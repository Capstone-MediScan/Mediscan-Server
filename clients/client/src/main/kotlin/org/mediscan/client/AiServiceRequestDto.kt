package org.mediscan.client

import org.springframework.web.multipart.MultipartFile

internal data class AiServiceRequestDto(
    val frontImage: MultipartFile,
    val backImage: MultipartFile,
    val pillCsv: MultipartFile,
)
