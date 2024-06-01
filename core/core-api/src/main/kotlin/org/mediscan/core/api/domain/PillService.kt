package org.mediscan.core.api.domain

import org.mediscan.client.AiServiceClient
import org.mediscan.core.api.controller.v1.response.PillDetailResponseDto
import org.mediscan.core.api.controller.v1.response.PillIdentificationResponseDto
import org.mediscan.core.api.controller.v1.response.PillSearchResponseDto
import org.mediscan.core.api.support.utils.FileMultipartFile
import org.mediscan.core.enums.Color
import org.springframework.stereotype.Service
import java.io.File

@Service
class PillService(
    private val pillManager: PillManager,
    private val pillReader: PillReader,
    private val aiServiceClient: AiServiceClient,
) {
    fun identifyPill(
        pillIdentificationData: PillIdentificationData,
    ): List<PillIdentificationResponseDto> {
        val csvFileName = "./data/pill.csv"

        pillManager.createCsvFile(
            pillIdentificationData.pillShape,
            pillIdentificationData.frontMarking,
            pillIdentificationData.backMarking,
            csvFileName,
        )
        try {
            val aiServiceClientResult = aiServiceClient.predict(
                FileMultipartFile(File(csvFileName), "text/csv"),
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
                    (result.accuracy * 100).toLong(),
                )
                responseDtoList.add(responseDto)
            }

            return responseDtoList
        } finally {
            File(csvFileName).delete()
        }
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
