package kr.ac.kumoh.s20210296.homework2.repository

import kr.ac.kumoh.s20210296.homework2.model.Training
import org.springframework.data.mongodb.repository.MongoRepository

interface TrainingRepository : MongoRepository<Training, String> {
    fun findByDate(date:String):List<Training>
}