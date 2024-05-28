package org.mediscan.core.api.domain

import org.mediscan.core.enums.Color
import org.mediscan.storage.db.core.PillJpaRepository
import org.springframework.stereotype.Component

@Component
class PillReader(
    private val pillRepository: PillJpaRepository,
) {
    fun readPill(pillShape: String, frontMarking: String, backMarking: String, color: Color): List<Pill> {
        val pillEntities =
            pillRepository.findPillEntitiesByDrugShapeAndColorClass1OrPrintFrontOrPrintBack(
                pillShape,
                frontMarking,
                backMarking,
                color.s,
            )
        println(color.s)
        return Pill.toDto(pillEntities)
    }
}
