package org.mediscan.core.api.domain

import org.mediscan.core.api.controller.v1.request.PillIdentificationRequestDto
import org.springframework.stereotype.Service

@Service
class PillService {
    fun identifyPill(request: PillIdentificationRequestDto): PillIdentificationResultDto {

        return PillIdentificationResultDto("Pill I")
    }
}