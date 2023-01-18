package com.apolit.shares.infrastructure.scheduler

import com.apolit.shares.application.ShareCreator
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@EnableScheduling
// TODO investigate different approach (quartz?)
class MockShareRetriever(private val shareCreator: ShareCreator) {

    // TODO Get value from config file/env var
    @Scheduled(fixedDelay = 10000)
    fun retrieve() {
        shareCreator.createRandom()
    }
}