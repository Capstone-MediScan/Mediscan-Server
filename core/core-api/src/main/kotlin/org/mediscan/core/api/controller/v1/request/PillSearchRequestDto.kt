package org.mediscan.core.api.controller.v1.request

class PillSearchRequestDto(
    val pillShape: String,
    val frontMarking: String,
    val backMarking: String,
    val color: String
) {
}