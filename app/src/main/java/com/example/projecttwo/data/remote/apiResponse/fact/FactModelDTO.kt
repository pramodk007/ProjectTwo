package com.example.projecttwo.data.remote.apiResponse.fact

import com.example.projecttwo.domain.model.FactModel

data class FactModelDTO(
    val fact: String?,
    val length: Int?,
) {
    fun toPresentation(): FactModel {
        return FactModel(
            fact = fact,
            length = length
        )
    }
}