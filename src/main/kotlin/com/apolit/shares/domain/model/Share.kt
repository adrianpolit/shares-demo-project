package com.apolit.shares.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Share(
    val companyInfo: CompanyInfo,
    val price: BigDecimal,
    val creationDate: LocalDateTime,
)

data class CompanyInfo(
    val companyId: String,
    val companyName: String,
)
