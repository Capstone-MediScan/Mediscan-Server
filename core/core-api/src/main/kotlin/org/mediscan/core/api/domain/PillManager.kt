package org.mediscan.core.api.domain;

import org.mediscan.core.api.domain.v1.request.PillDomainIdentificationRequestDto
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile


@Component
class PillManager {
    fun identifyPill(request: PillDomainIdentificationRequestDto): String {
        return
    }

}
