package domain

interface IFactRepository {
    suspend fun getNewFact() : FactModel
}