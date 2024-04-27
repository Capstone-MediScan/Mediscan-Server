package org.mediscan.core.api.controller.v1.request

import org.springframework.web.multipart.MultipartFile

data class PillIdentificationRequestDto(
    val image1: MultipartFile,
    val image2: MultipartFile,
    val pillShape: String,
    val frontMarking: String?,
    val backMarking: String?
)