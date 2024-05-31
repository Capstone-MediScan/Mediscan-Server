package org.mediscan.client

import org.mediscan.client.model.AiServiceClientResult
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class AiServiceClient internal constructor(
    private val aiServiceApi: AiServiceApi,
) {
    fun predict(
        frontImage: MultipartFile,
        backImage: MultipartFile,
        pillCsv: MultipartFile,
    ): List<AiServiceClientResult> {
        val request = AiServiceRequestDto(frontImage, backImage, pillCsv)
        return aiServiceApi.predictPill(request)
    }
}
