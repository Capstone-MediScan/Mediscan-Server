package org.mediscan.core.api.domain.v1.request;

import org.springframework.web.multipart.MultipartFile

data class PillDomainIdentificationRequestDto (
    val frontImage: MultipartFile,
    val backImage: MultipartFile,
    val pillShape: String,
    val frontMarking: String?,
    val backMarking: String?
)