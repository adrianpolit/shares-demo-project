package com.apolit.shares.domain

import com.apolit.shares.domain.model.CompanyInfo
import com.apolit.shares.domain.model.Share
import java.time.LocalDateTime

interface ShareRepository {
    fun listCompanies(): List<CompanyInfo>
    fun lastShareInfo(companyId: String): Share?
    fun shareInfoByDate(companyId: String, dateTime: LocalDateTime): List<Share>
    fun save(share: Share)
}