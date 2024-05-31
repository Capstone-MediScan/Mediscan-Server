package org.mediscan.core.api.domain

import org.mediscan.client.AiServiceClient
import org.mediscan.core.api.controller.v1.response.PillDetailResponseDto
import org.mediscan.core.api.controller.v1.response.PillIdentificationResponseDto
import org.mediscan.core.api.controller.v1.response.PillSearchResponseDto
import org.mediscan.core.api.support.utils.InMemoryMultipartFile
import org.mediscan.core.enums.Color
import org.springframework.stereotype.Service
import kotlin.math.round

@Service
class PillService(
    private val pillManager: PillManager,
    private val pillReader: PillReader,
    private val aiServiceClient: AiServiceClient,
) {
    fun identifyPill(
        pillIdentificationData: PillIdentificationData,
    ): List<PillIdentificationResponseDto> {
        val createCsvInMemory = pillManager.createCsvInMemory(
            pillIdentificationData.pillShape,
            pillIdentificationData.frontMarking,
            pillIdentificationData.backMarking,
        )

        val aiServiceClientResult = aiServiceClient.predict(
            InMemoryMultipartFile(
                "pill",
                "pill.csv",
                "text/csv",
                createCsvInMemory,
            ),
            pillIdentificationData.frontImage,
            pillIdentificationData.backImage,
        )

        val responseDtoList = mutableListOf<PillIdentificationResponseDto>()
        for (result in aiServiceClientResult) {
            val pill = pillReader.readPill(result.code)
            val responseDto = PillIdentificationResponseDto(
                pill.itemSeq,
                result.rank,
                pill.itemName,
                pill.itemImage,
                pill.className,
                round(result.accuracy).toLong(),
            )
            responseDtoList.add(responseDto)
        }

        return responseDtoList
    }

    fun searchPill(
        pillShape: String,
        frontMarking: String?,
        backMarking: String?,
        color: Color,
    ): List<PillSearchResponseDto> {
        val pillDomainResponse = pillReader.readPill(pillShape, frontMarking, backMarking, color)
        return PillSearchResponseDto.toDto(pillDomainResponse)
    }

    fun searchPill(pillId: String): PillDetailResponseDto {
        val pill = pillReader.readPill(pillId)
        return PillDetailResponseDto.toDto(pill)
    }
}
