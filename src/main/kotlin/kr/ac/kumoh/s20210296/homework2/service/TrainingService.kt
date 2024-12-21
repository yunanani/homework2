package kr.ac.kumoh.s20210296.homework2.service

import kr.ac.kumoh.s20210296.homework2.model.Training
import kr.ac.kumoh.s20210296.homework2.repository.TrainingRepository
import org.springframework.stereotype.Service

@Service
class TrainingService(private val repository: TrainingRepository) {
    fun addTraining(training: Training): Training = repository.save(training)

    fun getAllTrainings(): List<Training> = repository.findAll()

    fun getTrainingById(id: String): Training? = repository.findById(id).orElse(null)

    fun getTrainingByDate(date:String) : List<Training> = repository.findByDate(date)

    fun updateTraining(id: String, training: Training): Training? {
        val trainingTarget = repository.findById(id)

        return if (trainingTarget.isPresent) {
            val oldTraining = trainingTarget.get()
            val updatedTraining = oldTraining.copy(
                date = training.date,
                name = training.name,
                additionalContent = training.additionalContent
            )
            repository.save(updatedTraining)
        } else {
            null
        }
    }

    fun deleteTraining(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}
