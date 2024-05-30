package org.mediscan.core.api.controller.v1.response

data class PillIdentificationResponseDto(
    val pillId: String,
    val pillName: String?,
    val itemImage: String?,
    val className: String?,
    val confidence: Long,
)
