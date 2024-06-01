package org.mediscan.client

import org.mediscan.client.model.AiServiceClientResult

internal data class AiServiceResponseDto(
    val result: List<AiServiceClientResult>,
)
