package org.mediscan.core.api.controller.v1.response;

data class PillIdentificationResponseDto (
//    val pillName: String,
//    val usage: String,
//    val confidence: Long,
//    val imagePath: String
        val confidence: Long,
        val drugCode: String
)