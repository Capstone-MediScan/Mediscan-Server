package org.mediscan.core.api.domain

import org.mediscan.core.api.controller.v1.request.PillDomainIdentificationRequestDto
import org.mediscan.core.api.controller.v1.response.PillDomainIdentificationResponseDto
import org.mediscan.core.api.controller.v1.response.PillSearchResponseDto
import org.mediscan.core.enums.Color
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PillService(
    private val pillManager: PillManager,
    private val pillReader: PillReader,
) {
    fun identifyPill(
        frontImage: MultipartFile,
        backImage: MultipartFile,
        fillShape: String,
        frontMarking: String,
        backMarking: String,
    ): List<PillDomainIdentificationResponseDto> {
        val pillDomainResponse = pillManager
            .identifyPill(
                PillDomainIdentificationRequestDto(
                    frontImage,
                    backImage,
                    fillShape,
                    frontMarking,
                    backMarking,
                ),
            )

        return pillDomainResponse
    }

    fun searchPill(pillShape: String, frontMarking: String, backMarking: String, color: Color): List<PillSearchResponseDto> {
        val pillDomainResponse = pillReader.readPill(pillShape, frontMarking, backMarking, color)
        return PillSearchResponseDto.toDto(pillDomainResponse)
    }
}
