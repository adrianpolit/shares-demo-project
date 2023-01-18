package com.apolit.shares.infrastructure.controller

import com.apolit.shares.domain.ShareNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ShareFinderExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [ShareNotFoundException::class])
    protected fun handleMissingData(
        ex: RuntimeException,
        request: WebRequest
    ): ResponseEntity<String> = ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ex.message)
}