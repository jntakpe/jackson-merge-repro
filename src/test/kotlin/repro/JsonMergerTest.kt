package repro

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonMergerTest {

    @Test
    fun `works simple`() {
        val changes = JsonNodeFactory.instance.objectNode().put("username", "updated")
        val original = KtPerson("original", KtAddress("Rivoli", "Paris"))
        val merged = JsonMerger(jacksonObjectMapper()).merge(changes, original)
        assertThat(merged).isEqualToComparingFieldByField(original.copy("updated"))
    }

    @Test
    fun `fails when nested`() {
        val original = KtPerson("original", KtAddress("Rivoli", "Paris"))
        val merged = JsonMerger(jacksonObjectMapper()).merge(nestedChanges(), original)
        assertThat(merged).isEqualToComparingFieldByFieldRecursively(
            KtPerson(
                "updated",
                KtAddress("Magenta", "Paris")
            )
        ) //actually city is null
    }

    @Test
    fun `works with java objects`() {
        val original = JavaPerson().apply {
            username = "original"
            address = JavaAddress().apply {
                street = "Rivoli"
                city = "Paris"
            }
        }
        val merged = JsonMerger(ObjectMapper()).merge(nestedChanges(), original)
        assertThat(merged).isEqualToComparingFieldByFieldRecursively(
            KtPerson(
                "updated",
                KtAddress("Magenta", "Paris")
            )
        ) //actually city is null
    }

    private fun nestedChanges(): ObjectNode {
        return JsonNodeFactory.instance.objectNode().put("username", "updated").apply {
            putObject("address").put("street", "Magenta")
        }
    }
}
