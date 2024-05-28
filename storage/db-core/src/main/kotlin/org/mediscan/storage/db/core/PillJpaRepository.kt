package org.mediscan.storage.db.core

import org.springframework.data.jpa.repository.JpaRepository

interface PillJpaRepository : JpaRepository<PillEntity, Long> {
    fun findPillEntitiesByDrugShapeAndColorClass1OrPrintFrontOrPrintBack(
        shape: String,
        frontMarking: String,
        backMarking: String,
        color: String,
    ): List<PillEntity>
}
