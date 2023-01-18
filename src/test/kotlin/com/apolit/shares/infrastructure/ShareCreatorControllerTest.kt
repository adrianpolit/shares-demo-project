package com.apolit.shares.infrastructure

import com.apolit.shares.application.ShareCreator
import com.apolit.shares.infrastructure.controller.ShareCreatorController
import com.apolit.shares.infrastructure.controller.requests.CreateShareRequest
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus.CREATED
import java.math.BigDecimal

class ShareCreatorControllerTest {
    private lateinit var shareCreatorController: ShareCreatorController
    private lateinit var shareCreator: ShareCreator

    @BeforeEach
    fun setup() {
        unmockkAll()
        shareCreator = mockk()
        shareCreatorController = ShareCreatorController(shareCreator)
    }

    @Test
    fun `should return 201 created`() {
        every { shareCreator.create(companyId, companyName, price) } returns Unit
        val result = shareCreatorController.createShare(validShareRequest)
        assert(result.statusCode == CREATED)
    }

    companion object {
        private const val companyId = "companyId"
        private const val companyName = "companyName"
        private val price = BigDecimal(99)
        val validShareRequest = CreateShareRequest(companyId, companyName, price)
    }
}