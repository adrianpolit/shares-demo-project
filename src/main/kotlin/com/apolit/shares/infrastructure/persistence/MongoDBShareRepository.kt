package com.apolit.shares.infrastructure.persistence

import com.apolit.shares.domain.ShareRepository
import com.apolit.shares.domain.model.CompanyInfo
import com.apolit.shares.domain.model.Share
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class MongoDBShareRepository(private val mongoTemplate: MongoTemplate) : ShareRepository {
    override fun listCompanies(): List<CompanyInfo> {
        return mongoTemplate.findDistinct("companyInfo", Share::class.java, CompanyInfo::class.java)
    }

    override fun lastShareInfo(companyId: String): Share? {
        val query = Query()
        query.addCriteria(
            Criteria
                .where("companyInfo.companyId")
                .`is`(companyId)
        ).with(Sort.by(Sort.Direction.DESC, "creationDate"))
        return mongoTemplate.findOne(query, Share::class.java)
    }

    override fun shareInfoByDate(companyId: String, dateTime: LocalDateTime): List<Share> {
        val query = Query()
        query.addCriteria(
            Criteria
                .where("companyInfo.companyId")
                .`is`(companyId)
        )
        query.addCriteria(
            Criteria
                .where("creationDate")
                .gt(dateTime)
        )

        return mongoTemplate.find(query, Share::class.java)
    }

    override fun save(share: Share) {
        mongoTemplate.save(share)
    }
}