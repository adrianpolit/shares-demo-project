package com.apolit.shares.infrastructure

import com.apolit.shares.application.ShareFinder
import com.apolit.shares.application.response.ShareResponse
import com.apolit.shares.domain.ShareNotFoundException
import com.apolit.shares.infrastructure.controller.ShareFinderController
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus
import java.math.BigDecimal
import java.time.LocalDateTime.now

class ShareFinderControllerTest {
    private lateinit var shareFinderController: ShareFinderController
    private lateinit var shareFinder: ShareFinder

    @BeforeEach
    fun setup() {
        unmockkAll()
        shareFinder = mockk()
        shareFinderController = ShareFinderController(shareFinder)
    }

    @Test
    fun `getById should return OK if share exists`() {
        every { shareFinder.findByCompanyId(companyId) } returns shareResponse
        val result = shareFinderController.getById(companyId)
        assert(result.statusCode == HttpStatus.OK)
    }

    @Test
    fun `getById raise exception if share does not exist`() {
        every { shareFinder.findByCompanyId(companyId) } throws ShareNotFoundException(companyId)
        assertThrows<ShareNotFoundException> { shareFinderController.getById(companyId) }
    }

    companion object {
        const val companyId = "companyId"
        val shareResponse =
            ShareResponse(companyId = companyId, companyName = "name", price = BigDecimal(10), created = now())
    }
}