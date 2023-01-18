package com.apolit.shares.infrastructure

import com.apolit.shares.application.CompanyDescriptor
import com.apolit.shares.application.response.CompanyInfoResponse
import com.apolit.shares.infrastructure.controller.CompanyController
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus.OK

class CompanyControllerTest {

    private lateinit var companyController: CompanyController
    private lateinit var companyDescriptor: CompanyDescriptor

    @BeforeEach
    fun setup() {
        companyDescriptor = mockk()
        companyController = CompanyController(companyDescriptor)
    }

    @Test
    fun `should return company info`() {
        every { companyDescriptor.listCompanies() } returns listOf(CompanyInfoResponse("id", "name"))
        val result = companyController.getAllCompanies()
        assert(result.statusCode == OK)
    }
}