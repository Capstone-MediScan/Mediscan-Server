package org.mediscan.core.api.domain

import org.springframework.web.multipart.MultipartFile

data class PillIdentificationData(
    val frontImage: MultipartFile,
    val backImage: MultipartFile,
    val pillShape: String,
    val frontMarking: String? = "None",
    val backMarking: String? = "None",
)
