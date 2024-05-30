package org.mediscan.core.api.domain

import org.mediscan.client.example.AiServiceClient
import org.mediscan.client.example.model.PillIdentificationRequestDto
import org.mediscan.client.example.model.PillIdentificationResponseDto
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PillIdentificationService(
    private val aiServiceClient: AiServiceClient,
) {
    fun identifyPill(
        frontImage: MultipartFile,
        backImage: MultipartFile,
        pillShape: String,
        frontMarking: String = "None",
        backMarking: String = "None",
    ): List<PillIdentificationResponseDto> {
        val request = PillIdentificationRequestDto(
            frontImage = frontImage,
            backImage = backImage,
            pillShape = pillShape,
            frontMarking = frontMarking,
            backMarking = backMarking,
        )
        return aiServiceClient.identifyPill(request)
    }
}
