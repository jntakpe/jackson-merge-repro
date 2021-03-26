package repro

import com.fasterxml.jackson.annotation.JsonMerge
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class JsonMerger(private val objectMapper: ObjectMapper) {
    fun <T> merge(changes: JsonNode, toUpdate: T): T {
        return objectMapper.readerForUpdating(toUpdate).readValue(changes)
    }
}

data class KtAddress(val street: String?, val city: String?)

data class KtPerson(val username: String, @field:JsonMerge val address: KtAddress)
