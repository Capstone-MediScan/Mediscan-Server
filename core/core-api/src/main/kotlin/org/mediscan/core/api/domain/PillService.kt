package org.mediscan.core.api.domain

import org.mediscan.core.api.domain.v1.request.PillDomainIdentificationRequestDto
import org.mediscan.core.api.domain.v1.response.PillDomainIdentificationResponseDto
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PillService (
    private val pillManager: PillManager
){
    fun identifyPill(frontImage: MultipartFile, backImage: MultipartFile,
                     fillShape: String, frontMarking: String, backMarking: String ): PillDomainIdentificationResponseDto  {

        val pillDomainResponse = pillManager
            .identifyPill(PillDomainIdentificationRequestDto(frontImage, backImage, fillShape, frontMarking, backMarking))

        return pillDomainResponse
    }
}