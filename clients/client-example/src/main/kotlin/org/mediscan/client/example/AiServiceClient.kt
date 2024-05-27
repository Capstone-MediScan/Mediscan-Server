package org.mediscan.client.example

import org.mediscan.client.example.model.PillIdentificationRequestDto
import org.mediscan.client.example.model.PillIdentificationResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "ai-service", url = "")
interface AiServiceClient {
    @PostMapping("/identify-pill")
    fun identifyPill(@RequestBody requestDto: PillIdentificationRequestDto): List<PillIdentificationResponseDto>
}