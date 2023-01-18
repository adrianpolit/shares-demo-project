package com.apolit.shares.config


import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Shares Checker")
                    .description("Code challenge for NinetyNine by Adrián Polit")
                    .version("v0.0.1")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("Shares Checker Documentation (do not click here)")
                    .url("https://r.mtdv.me/I05IjbGdii")
            )
    }

}