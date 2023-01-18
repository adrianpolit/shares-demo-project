package com.apolit.shares.config

import com.apolit.shares.application.CompanyDescriptor
import com.apolit.shares.application.ShareCreator
import com.apolit.shares.application.ShareFinder
import com.apolit.shares.domain.ShareRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DependencyInjectionConfig {

    @Bean
    fun shareCreator(shareRepository: ShareRepository) = ShareCreator(shareRepository)

    @Bean
    fun shareFinder(shareRepository: ShareRepository) = ShareFinder(shareRepository)

    @Bean
    fun companyDescriptor(shareRepository: ShareRepository) = CompanyDescriptor(shareRepository)
}