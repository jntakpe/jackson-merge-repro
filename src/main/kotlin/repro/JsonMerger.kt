package repro

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class JsonMerger(private val objectMapper: ObjectMapper) {

    fun <T> merge(changes: JsonNode, toUpdate: T): T {
        return objectMapper.readerForUpdating(toUpdate).readValue(changes)
    }
}
