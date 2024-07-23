package data

import data.entity.toDataModel
import data.network.FactNetworkSource
import domain.FactModel
import domain.IFactRepository

object FactsRepository : IFactRepository {
    override suspend fun getNewFact(): FactModel {
        return FactNetworkSource.getNewFact().toDataModel()
    }
}