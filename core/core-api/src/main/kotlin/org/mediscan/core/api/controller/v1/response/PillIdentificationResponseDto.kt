package org.mediscan.core.api.controller.v1.response

data class PillIdentificationResponseDto(
    val pillId: String,
    val rank: Long,
    val pillName: String?,
    val itemImage: String?,
    val className: String?,
    val confidence: Long,
)
