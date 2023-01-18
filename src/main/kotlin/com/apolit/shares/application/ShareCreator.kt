package com.apolit.shares.application

import com.apolit.shares.domain.ShareRepository
import com.apolit.shares.domain.model.CompanyInfo
import com.apolit.shares.domain.model.Share
import java.math.BigDecimal
import java.math.RoundingMode.FLOOR
import java.time.LocalDateTime.now
import kotlin.random.Random

class ShareCreator(private val repository: ShareRepository) {

    fun create(companyId: String, companyName: String, price: BigDecimal) {
        val companyInfo = CompanyInfo(companyId, companyName)
        Share(companyInfo, price, now()).let {
            repository.save(it)
        }
    }

    // For this exercise only, obviously
    fun createRandom() {
        companyData.forEach { companyData ->
            Share(
                CompanyInfo(
                    companyData.first,
                    companyData.second,
                ), price = getRandomPrice(), creationDate = now()
            ).let {
                repository.save(it)
            }
        }
    }

    private fun getRandomPrice(): BigDecimal = BigDecimal(Random.nextDouble(500.0)).setScale(2, FLOOR)

    companion object {
        private val companyData = listOf(
            "CS.PA" to "AXA Insurance S.A",
            "4F0N" to "4Finance S.A",
            "WABI" to "Wabi Project",
            "DAC" to "Electric Automation"
        )
    }
}