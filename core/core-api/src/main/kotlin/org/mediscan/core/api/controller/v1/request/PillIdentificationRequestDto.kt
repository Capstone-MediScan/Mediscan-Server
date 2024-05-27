package org.mediscan.core.api.controller.v1.request

import org.springframework.web.multipart.MultipartFile

data class PillIdentificationRequestDto(
    val frontImage: MultipartFile,
    val backImage: MultipartFile,
    val pillShape: String,
    val frontMarking: String = "None",
    val backMarking: String = "None",
)
