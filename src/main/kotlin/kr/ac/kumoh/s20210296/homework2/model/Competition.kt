package kr.ac.kumoh.s20210296.homework2.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "competition")
data class Competition(
    @Id val id: String? = null,
    val aurl: String,
    val date: String,
    val name: String,
    val additionalContent: AdditionalContent? = null
)