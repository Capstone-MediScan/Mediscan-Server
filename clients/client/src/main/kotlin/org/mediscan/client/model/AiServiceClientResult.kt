package org.mediscan.client.model

data class AiServiceClientResult(
    val rank: Long,
    val code: String,
    val accuracy: Double,
)
