package repro

import com.fasterxml.jackson.annotation.JsonMerge

data class KtPerson(val username: String, @field:JsonMerge val address: KtAddress)
