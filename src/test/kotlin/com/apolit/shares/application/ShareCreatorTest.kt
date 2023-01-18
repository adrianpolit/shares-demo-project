package com.apolit.shares.application

import com.apolit.shares.domain.ShareRepository
import com.apolit.shares.domain.model.CompanyInfo
import com.apolit.shares.domain.model.Share
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.time.LocalDateTime

class ShareCreatorTest {
    private lateinit var shareRepository: ShareRepository
    private lateinit var shareCreator: ShareCreator

    @BeforeEach
    fun setup() {
        unmockkAll()
        shareRepository = mockk(relaxUnitFun = true)
        shareCreator = ShareCreator(shareRepository)
        mockkStatic(LocalDateTime::class)
    }

    @Test
    fun `should create share`() {
        val date = LocalDateTime.now()
        every { LocalDateTime.now() } returns date

        shareCreator.create(companyId, companyName, price)

        verify {
            shareRepository.save(
                Share(
                    CompanyInfo(companyId, companyName), price, date
                )
            )
        }
    }

    @Test
    fun `should create random share`() {
        val date = LocalDateTime.now()
        every { LocalDateTime.now() } returns date

        shareCreator.createRandom()

        verify {
            shareRepository.save(any())
        }
    }

    companion object {
        const val companyId = "NINE"
        val price: BigDecimal = ZERO
        const val companyName = "Cool and witty company name"

    }
}