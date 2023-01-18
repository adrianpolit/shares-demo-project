package com.apolit.shares.domain

// TODO Add ExceptionHandler
sealed class ShareException(override val message: String, override val cause: Throwable? = null) :
    RuntimeException(message, cause)

data class ShareNotFoundException(val id: String) : ShareException("No share found for id: <$id>")
