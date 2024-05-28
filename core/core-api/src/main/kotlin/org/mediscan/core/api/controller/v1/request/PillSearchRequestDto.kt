package org.mediscan.core.api.controller.v1.request

import org.mediscan.core.enums.Color

class PillSearchRequestDto(
    val pillShape: String,
    val frontMarking: String,
    val backMarking: String,
    val color: Color,
)
