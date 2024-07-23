package domain

import kotlin.random.Random

data class FactModel(
    val factText: String?,
    val id: Long = Random.nextLong(),
)
