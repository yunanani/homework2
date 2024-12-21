package kr.ac.kumoh.s20210296.homework2.controller

import kr.ac.kumoh.s20210296.homework2.model.Competition
import kr.ac.kumoh.s20210296.homework2.service.CompetitionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/Competition")
@CrossOrigin(origins = ["http://localhost:3000"])
class CompetitionController(private val service: CompetitionService) {
    @PostMapping
    fun addCompetition(@RequestBody competition: Competition): Competition = service.addCompetition(competition)

    @GetMapping
    fun getAllCompetitions(): List<Competition> = service.getAllCompetitions()

    @GetMapping("/{id}")
    fun getSongById(@PathVariable id:String):Competition? = service.getCompetitionById(id)

    @GetMapping("date/{date}")
    fun getCompetitionByDate(@PathVariable date: String):List<Competition> = service.getCompetitionByDate(date)

    @PutMapping("/{id}")
    fun updateCompetition(@PathVariable id:String, @RequestBody Competition:Competition): Competition? = service.updateCompetition(id,Competition)

    @DeleteMapping("/{id}")
    fun deleteCompetition(@PathVariable id:String) : Map<String,String>{
        return if (service.deleteCompetition(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}
