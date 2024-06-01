package org.mediscan.client

import org.mediscan.client.model.AiServiceClientResult
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class AiServiceClient internal constructor(
    private val aiServiceApi: AiServiceApi,
) {
    fun predict(
        pillCsv: MultipartFile,
        frontImage: MultipartFile,
        backImage: MultipartFile,
    ): List<AiServiceClientResult> {
        return aiServiceApi.predictPill(frontImage, backImage, pillCsv).result
    }
}
