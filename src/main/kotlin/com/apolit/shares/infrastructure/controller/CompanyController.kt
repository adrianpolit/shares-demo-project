package com.apolit.shares.infrastructure.controller

import com.apolit.shares.application.CompanyDescriptor
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CompanyController(private val companyDescriptor: CompanyDescriptor) {

    @GetMapping("/companies")
    @ApiResponse(description = "Returns a list of all companies")
    fun getAllCompanies() = ResponseEntity.ok(companyDescriptor.listCompanies())

}