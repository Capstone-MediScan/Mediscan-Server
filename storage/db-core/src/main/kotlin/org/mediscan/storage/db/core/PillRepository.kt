package org.mediscan.storage.db.core

import org.springframework.data.jpa.repository.JpaRepository

interface PillRepository : JpaRepository<PillEntity, Long>, PillQuerydslRepository {
    fun findPillEntitiesByDrugShapeAndColorClass1OrPrintFrontOrPrintBack(
        shape: String,
        frontMarking: String,
        backMarking: String,
        color: String,
    ): List<PillEntity>

    fun findPillEntityByItemSeq(itemSeq: String): PillEntity
}
