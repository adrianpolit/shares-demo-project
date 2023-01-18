package com.apolit.shares.infrastructure.controller

import com.apolit.shares.application.ShareCreator
import com.apolit.shares.infrastructure.controller.requests.CreateShareRequest
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
class ShareCreatorController(private val shareCreator: ShareCreator) {

    @PostMapping("/share")
    @ApiResponse(description = "Creates a new share record")
    fun createShare(@Valid @RequestBody request: CreateShareRequest): ResponseEntity<String> {
        shareCreator.create(request.companyId, request.companyName, request.price)
        return ResponseEntity.created(URI.create("")).build()
    }
}