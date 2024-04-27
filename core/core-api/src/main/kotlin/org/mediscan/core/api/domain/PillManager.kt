package org.mediscan.core.api.domain;

import org.mediscan.client.example.PillIdentificationService
import org.mediscan.core.api.domain.v1.request.PillDomainIdentificationRequestDto
import org.mediscan.core.api.domain.v1.response.PillDomainIdentificationResponseDto
import org.springframework.stereotype.Component


@Component
class PillManager(
    private val pillIdentificationService: PillIdentificationService
) {
    fun identifyPill(request: PillDomainIdentificationRequestDto): List<PillDomainIdentificationResponseDto> {
        val results = pillIdentificationService.identifyPill(
            request.frontImage,
            request.backImage,
            request.pillShape,
            request.frontMarking,
            request.backMarking
        )

        return results.map { responseDto ->
            PillDomainIdentificationResponseDto(
                drugCode = responseDto.drugCode,
                confidence = responseDto.confidence
            )
        }
    }
}
