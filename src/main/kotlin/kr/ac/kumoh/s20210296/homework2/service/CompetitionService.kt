package kr.ac.kumoh.s20210296.homework2.service

import kr.ac.kumoh.s20210296.homework2.model.Competition
import kr.ac.kumoh.s20210296.homework2.repository.CompetitionRepository
import org.springframework.stereotype.Service

@Service
class CompetitionService(private val repository: CompetitionRepository) {
    fun addCompetition(competition: Competition): Competition = repository.save(competition)

    fun getAllCompetitions() : List<Competition> = repository.findAll()

    fun getCompetitionById(id:String) : Competition? = repository.findById(id).orElse(null)

    fun getCompetitionByDate(date:String) : List<Competition> = repository.findByDate(date)

    fun updateCompetition(id:String, competition: Competition): Competition?{
        val competitionTarget = repository.findById(id)

        return if (competitionTarget.isPresent) {
            val oldCompetition = competitionTarget.get()
            val updatedCompetition = oldCompetition.copy(
                date = competition.date,
                name = competition.name,
                additionalContent = competition.additionalContent
            )
            repository.save(updatedCompetition)
        } else {
            null
        }
    }

    fun deleteCompetition(id: String):Boolean{
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}
