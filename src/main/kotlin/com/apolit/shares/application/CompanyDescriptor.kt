package com.apolit.shares.application

import com.apolit.shares.application.response.CompanyInfoResponse
import com.apolit.shares.domain.ShareRepository

class CompanyDescriptor(private val repository: ShareRepository) {
    fun listCompanies(): List<CompanyInfoResponse> {
        return CompanyInfoResponse.fromCompanyInfoList(repository.listCompanies())
    }
}