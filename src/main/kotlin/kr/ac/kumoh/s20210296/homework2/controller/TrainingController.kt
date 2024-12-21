package kr.ac.kumoh.s20210296.homework2.controller

import kr.ac.kumoh.s20210296.homework2.model.Training
import kr.ac.kumoh.s20210296.homework2.service.TrainingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/Training")
@CrossOrigin(origins = ["https://superb-shortbread-7ed911.netlify.app"])
class TrainingController(private val service: TrainingService) {
    @PostMapping
    fun addTraining(@RequestBody training: Training): Training = service.addTraining(training)

    @GetMapping
    fun getAllTrainings(): List<Training> = service.getAllTrainings()

    @GetMapping("/{id}")
    fun getTrainingById(@PathVariable id: String): Training? = service.getTrainingById(id)

    @GetMapping("date/{date}")
    fun getTrainingByDate(@PathVariable date: String): List<Training> = service.getTrainingByDate(date)

    @PutMapping("/{id}")
    fun updateTraining(@PathVariable id: String, @RequestBody training: Training): Training? = service.updateTraining(id, training)

    @DeleteMapping("/{id}")
    fun deleteTraining(@PathVariable id: String): Map<String, String> {
        return if (service.deleteTraining(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}