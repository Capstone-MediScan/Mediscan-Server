package org.mediscan.core.api.controller.v1.response

data class PillDomainIdentificationResponseDto(
    val confidence: Long,
    val drugCode: String,
)
