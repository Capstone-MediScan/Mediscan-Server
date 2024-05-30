package org.mediscan.core.api.domain

import org.mediscan.core.api.controller.v1.response.PillDetailResponseDto
import org.mediscan.core.api.controller.v1.response.PillIdentificationResponseDto
import org.mediscan.core.api.controller.v1.response.PillSearchResponseDto
import org.mediscan.core.enums.Color
import org.springframework.stereotype.Service

@Service
class PillService(
    private val pillManager: PillManager,
    private val pillReader: PillReader,
) {
    fun identifyPill(
        pillIdentificationData: PillIdentificationData,
    ): List<PillIdentificationResponseDto> {
        val createCsvInMemory = pillManager.createCsvInMemory(
            pillIdentificationData.pillShape,
            pillIdentificationData.frontMarking,
            pillIdentificationData.backMarking,
        )
        var result: MutableList<PillIdentificationResponseDto> = mutableListOf()

        val rank1: Pill = pillReader.readPill("198600161")
        val rank2: Pill = pillReader.readPill("199301111")
        val rank3: Pill = pillReader.readPill("199302061")
        val rank4: Pill = pillReader.readPill("199501735")
        val rank5: Pill = pillReader.readPill("199302671")

        result.add(PillIdentificationResponseDto(rank1.itemSeq, rank1.itemName, rank1.itemImage, rank1.className, 60))
        result.add(PillIdentificationResponseDto(rank2.itemSeq, rank2.itemName, rank2.itemImage, rank2.className, 56))
        result.add(PillIdentificationResponseDto(rank3.itemSeq, rank3.itemName, rank3.itemImage, rank3.className, 55))
        result.add(PillIdentificationResponseDto(rank4.itemSeq, rank4.itemName, rank4.itemImage, rank4.className, 47))
        result.add(PillIdentificationResponseDto(rank5.itemSeq, rank5.itemName, rank5.itemImage, rank5.className, 47))
        return result
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
