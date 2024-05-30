package org.mediscan.storage.db.core

interface PillQuerydslRepository {
    fun findPillEntities(
        shape: String,
        frontMarking: String?,
        backMarking: String?,
        color: String,
    ): List<PillEntity>
}
