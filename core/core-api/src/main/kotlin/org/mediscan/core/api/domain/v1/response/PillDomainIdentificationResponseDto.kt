package org.mediscan.core.api.domain.v1.response

data class PillDomainIdentificationResponseDto(
    val confidence: Long,
    val drugCode: String
)
