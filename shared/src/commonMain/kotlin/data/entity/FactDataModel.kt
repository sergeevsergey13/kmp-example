package data.entity

import domain.FactModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactDataModel(
    @SerialName("fact")
    val fact: String?
)

fun FactDataModel.toDataModel() = FactModel(
    factText = this.fact
)