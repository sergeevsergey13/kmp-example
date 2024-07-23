package presentation

import data.FactsRepository
import domain.FactModel
import io.ktor.util.logging.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

object FactController {
    private val _factsFlow: MutableStateFlow<List<FactModel>> = MutableStateFlow(emptyList())
    val factFlow get() = _factsFlow.asStateFlow()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun getNewFact() {
        scope.launch {
            try {
                val newFact = FactsRepository.getNewFact()
                _factsFlow.update {
                    it + newFact
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}