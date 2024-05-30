package org.mediscan.core.api.domain

import org.mediscan.core.enums.Color
import org.mediscan.storage.db.core.PillRepository
import org.springframework.stereotype.Component

@Component
class PillReader(
    private val pillRepository: PillRepository,
) {
    fun readPill(pillShape: String, frontMarking: String?, backMarking: String?, color: Color): List<Pill> {
        val pillEntities =
            pillRepository.findPillEntities(
                pillShape,
                frontMarking,
                backMarking,
                color.s,
            )
        return Pill.toDto(pillEntities)
    }

    fun readPill(pillId: String): Pill {
        val pillEntity = pillRepository.findPillEntityByItemSeq(pillId)
        return Pill.toDto(pillEntity)
    }
}
