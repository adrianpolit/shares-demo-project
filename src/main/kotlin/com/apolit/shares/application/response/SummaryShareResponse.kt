package com.apolit.shares.application.response

import com.apolit.shares.domain.model.Share
import java.math.BigDecimal
import java.time.LocalDateTime

data class SummaryShareResponse(
    val companyId: String,
    val companyName: String,
    val changeInPeriod: BigDecimal,
    val currentPrice: BigDecimal,
    val fromDate: LocalDateTime,
    val toDate: LocalDateTime
) {
    companion object {
        fun fromInfo(share: Share, priceChange: BigDecimal, oldestDate: LocalDateTime, newestDate: LocalDateTime) =
            SummaryShareResponse(
                companyId = share.companyInfo.companyId,
                companyName = share.companyInfo.companyName,
                changeInPeriod = priceChange,
                currentPrice = share.price,
                fromDate = oldestDate,
                toDate = newestDate

            )
    }
}