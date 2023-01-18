package com.apolit.shares.infrastructure.controller.requests

import java.math.BigDecimal
import javax.validation.constraints.Size

data class CreateShareRequest(
    @field:Size(min = 4, max = 5) val companyId: String,
    @field:Size(min = 1, max = 20) val companyName: String,
    // TODO add validation for currency (XXXX.XX)
    val price: BigDecimal
)