package kr.ac.kumoh.s20210296.homework2.repository

import kr.ac.kumoh.s20210296.homework2.model.Competition
import org.springframework.data.mongodb.repository.MongoRepository

interface CompetitionRepository : MongoRepository<Competition, String> {
    fun findByDate(date:String):List<Competition>
}