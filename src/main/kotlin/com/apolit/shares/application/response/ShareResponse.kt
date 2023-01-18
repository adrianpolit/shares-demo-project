package com.apolit.shares.application.response

import com.apolit.shares.domain.model.Share
import java.math.BigDecimal
import java.time.LocalDateTime

data class ShareResponse(
    val companyId: String, val companyName: String, val price: BigDecimal, val created: LocalDateTime
) {
    companion object {
        fun fromShare(share: Share) = ShareResponse(
            companyId = share.companyInfo.companyId,
            companyName = share.companyInfo.companyName,
            price = share.price,
            created = share.creationDate
        )

        fun fromShareList(shares: List<Share>): MutableList<ShareResponse> {
            val responseList = mutableListOf<ShareResponse>()
            shares.forEach {
                responseList.add(fromShare(it))
            }
            return responseList
        }
    }
}