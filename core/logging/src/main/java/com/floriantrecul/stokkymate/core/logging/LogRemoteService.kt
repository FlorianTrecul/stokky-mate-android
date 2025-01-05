package com.floriantrecul.stokkymate.core.logging

/**
 * Interface for remote logging services (e.g., Crashlytics, Sentry, custom backend).
 */
interface LogRemoteService {
    /**
     * Logs an error with an optional throwable.
     * @param message The error message to log.
     * @param throwable The exception (if any) associated with the error.
     */
    fun logError(message: String, throwable: Throwable?)

    /**
     * Logs a warning.
     * @param message The warning message to log.
     */
    fun logWarning(message: String)
}
