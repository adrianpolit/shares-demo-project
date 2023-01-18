package com.apolit.shares.infrastructure.controller.requests

import javax.validation.constraints.Size

data class FindSharesRequest(
    @field:Size(min = 4, max = 5) val companyId: String, val timeRange: TimeRange
)

enum class TimeRange {
    HOURLY, DAILY, WEEKLY
}