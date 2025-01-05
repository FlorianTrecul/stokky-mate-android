package com.floriantrecul.stokkymate.core.logging

import android.util.Log
import timber.log.Timber

object Logger {

    // Remote service placeholder (can be replaced with Crashlytics, Sentry, etc.)
    private var remoteService: LogRemoteService = NoOpLogRemoteService()

    /**
     * Initializes the Logger with the appropriate environment.
     * @param isDebug Indicates if the application is in debug mode.
     * @param customTag An optional tag to prepend to all logs.
     * @param remoteService Remote service for error tracking (e.g., Crashlytics).
     */
    fun init(isDebug: Boolean, customTag: String? = null, remoteService: LogRemoteService = NoOpLogRemoteService()) {
        this.remoteService = remoteService

        if (isDebug) {
            Timber.plant(DebugTreeWithTag(customTag))
        } else {
            Timber.plant(ProductionTree())
        }
    }

    /**
     * Logging methods
     */
    fun debug(message: String, vararg args: Any?) {
        val formattedMessage = formatMessage(message, *args)
        Timber.d(formattedMessage)
    }

    fun error(throwable: Throwable, message: String? = null, vararg args: Any?) {
        val formattedMessage = formatMessage(message, *args)
        Timber.e(throwable, formattedMessage)
        remoteService.logError(formattedMessage, throwable)
    }

    fun info(message: String, vararg args: Any?) {
        val formattedMessage = formatMessage(message, *args)
        Timber.i(formattedMessage)
    }

    fun warning(message: String, vararg args: Any?) {
        val formattedMessage = formatMessage(message, *args)
        Timber.w(formattedMessage)
        remoteService.logWarning(formattedMessage)
    }

    /**
     * Formats the message with arguments (if provided).
     * @param message The log message.
     * @param args Arguments to format the message.
     * @return The formatted message string.
     */
    private fun formatMessage(message: String?, vararg args: Any?): String {
        return if (message != null) String.format(message, *args) else "No message provided"
    }

    /**
     * DebugTree that optionally prepends a custom tag and includes method, line, and file information.
     */
    private class DebugTreeWithTag(private val customTag: String?) : Timber.DebugTree() {
        override fun createStackElementTag(element: StackTraceElement): String {
            val tag = super.createStackElementTag(element)
            val methodName = element.methodName
            val lineNumber = element.lineNumber
            val fileName = element.fileName

            return if (customTag != null) {
                "$customTag-$tag ($fileName:$lineNumber#$methodName)"
            } else {
                "$tag ($fileName:$lineNumber#$methodName)"
            }
        }
    }

    /**
     * ProductionTree: limits logs to critical levels and integrates with remote services.
     */
    private class ProductionTree : Timber.Tree() {
        override fun isLoggable(tag: String?, priority: Int): Boolean {
            // Filter only WARN and above
            return priority >= Log.WARN
        }

        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.ERROR) {
                remoteService.logError(message, t)
            } else if (priority == Log.WARN) {
                remoteService.logWarning(message)
            }
        }
    }
}
