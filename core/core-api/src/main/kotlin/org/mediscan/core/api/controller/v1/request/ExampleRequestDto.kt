package org.mediscan.core.api.controller.v1.request

import org.mediscan.core.api.domain.ExampleData

data class ExampleRequestDto(
    val data: String,
) {
    fun toExampleData(): ExampleData {
        return ExampleData(data, data)
    }
}
