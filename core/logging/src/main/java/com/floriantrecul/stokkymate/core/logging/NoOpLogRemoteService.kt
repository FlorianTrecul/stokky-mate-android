package com.floriantrecul.stokkymate.core.logging

/**
 * Default (No-Op) implementation for remote logging services.
 * This implementation does nothing and serves as a placeholder.
 */
class NoOpLogRemoteService : LogRemoteService {
    /**
     * Does nothing when an error is logged.
     * @param message The error message.
     * @param throwable The exception associated with the error.
     */
    override fun logError(message: String, throwable: Throwable?) {
        // No operation performed
    }

    /**
     * Does nothing when a warning is logged.
     * @param message The warning message.
     */
    override fun logWarning(message: String) {
        // No operation performed
    }
}
