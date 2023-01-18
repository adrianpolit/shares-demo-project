package com.apolit.shares.application.response

import com.apolit.shares.domain.model.CompanyInfo

data class CompanyInfoResponse(val companyId: String, val companyName: String) {
    companion object {
        fun fromCompanyInfoList(companyList: List<CompanyInfo>): MutableList<CompanyInfoResponse> {
            val responseList = mutableListOf<CompanyInfoResponse>()
            companyList.forEach {
                responseList.add(
                    CompanyInfoResponse(
                        companyId = it.companyId, companyName = it.companyName
                    )
                )
            }
            return responseList
        }
    }
}