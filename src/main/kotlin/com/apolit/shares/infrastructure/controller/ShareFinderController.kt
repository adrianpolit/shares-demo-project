package com.apolit.shares.infrastructure.controller

import com.apolit.shares.application.ShareFinder
import com.apolit.shares.application.response.ShareResponse
import com.apolit.shares.application.response.SummaryShareResponse
import com.apolit.shares.infrastructure.controller.requests.TimeRange
import com.apolit.shares.infrastructure.controller.requests.TimeRange.*
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class ShareFinderController(private val shareFinder: ShareFinder) {

    @GetMapping("/shares/{companyId}")
    @ApiResponse(description = "Finds the latest share value for a given company ID")
    fun getById(@PathVariable companyId: String): ResponseEntity<ShareResponse> {
        return ResponseEntity.ok().body(shareFinder.findByCompanyId(companyId))
    }

    @GetMapping("/shares/{companyId}/{timeRange}")
    @ApiResponse(description = "Finds the share data for a given company ID and time")
    fun getByIdAndTime(
        @PathVariable companyId: String, @PathVariable timeRange: TimeRange
    ): ResponseEntity<List<ShareResponse>> {

        return ResponseEntity.ok(shareFinder.findByCompanyIdInGivenTime(companyId, getTargetDate(timeRange)))
    }

    @GetMapping("/shares/{companyId}/{timeRange}/summary")
    @ApiResponse(description = "Finds gives you the change in the price for the selected time")
    fun getSumByIdAndTime(
        @PathVariable companyId: String, @PathVariable timeRange: TimeRange
    ): ResponseEntity<SummaryShareResponse> {

        return ResponseEntity.ok(shareFinder.findSummaryByCompanyAndTime(companyId, getTargetDate(timeRange)))
    }

    companion object {
        //TODO I'd like to fix this, I don't want to pass the Enum itself... this needs a little work
        // this logic should be in the application but without needing to access the enum
        fun getTargetDate(timeRange: TimeRange): LocalDateTime {
            val dateTarget = LocalDateTime.now()

            return when (timeRange) {
                HOURLY -> dateTarget.minusHours(1)
                DAILY -> dateTarget.minusDays(1)
                WEEKLY -> dateTarget.minusWeeks(1)
            }
        }
    }
}
