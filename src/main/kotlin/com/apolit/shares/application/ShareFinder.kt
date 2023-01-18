package com.apolit.shares.application

import com.apolit.shares.application.response.ShareResponse
import com.apolit.shares.application.response.SummaryShareResponse
import com.apolit.shares.domain.ShareNotFoundException
import com.apolit.shares.domain.ShareRepository
import java.time.LocalDateTime

class ShareFinder(private val repository: ShareRepository) {


    fun findByCompanyId(companyId: String): ShareResponse {
        val result = repository.lastShareInfo(companyId) ?: throw ShareNotFoundException(companyId)
        return ShareResponse.fromShare(result)
    }


    fun findByCompanyIdInGivenTime(companyId: String, dateFrom: LocalDateTime): List<ShareResponse> {

        val result = repository.shareInfoByDate(companyId, dateFrom)
        if (result.isEmpty()) throw ShareNotFoundException(companyId)
        return ShareResponse.fromShareList(result)
    }

    fun findSummaryByCompanyAndTime(companyId: String, dateFrom: LocalDateTime): SummaryShareResponse {
        //TODO Improve this logic for better optimization
        val oldest = repository.shareInfoByDate(companyId, dateFrom).minByOrNull { it.creationDate }!!
        val newest = repository.lastShareInfo(companyId)!!

        val priceChange = newest.price.subtract(oldest.price)

        return SummaryShareResponse.fromInfo(newest, priceChange, oldest.creationDate, newest.creationDate)
    }

}