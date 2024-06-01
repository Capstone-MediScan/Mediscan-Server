package org.mediscan.storage.db.core

import com.querydsl.jpa.impl.JPAQueryFactory
import org.mediscan.storage.db.core.QPillEntity.pillEntity

class PillQuerydslRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
) : PillQuerydslRepository {
    override fun findPillEntities(
        shape: String,
        frontMarking: String?,
        backMarking: String?,
        color: String,
    ): List<PillEntity> {
        val pillEntities: List<PillEntity>

        val result1 = queryFactory.selectFrom(pillEntity)
            .where(
                pillEntity.drugShape.eq(shape)
                    .and(frontMarking?.let { pillEntity.printFront.eq(it) } ?: pillEntity.printFront.isNull)
                    .and(backMarking?.let { pillEntity.printBack.eq(it) } ?: pillEntity.printBack.isNull)
                    .and(pillEntity.colorClass1.eq(color)),
            )
            .fetch()

        val result2 = queryFactory.selectFrom(pillEntity)
            .where(
                pillEntity.drugShape.eq(shape)
                    .and(backMarking?.let { pillEntity.printFront.eq(it) } ?: pillEntity.printFront.isNull)
                    .and(frontMarking?.let { pillEntity.printBack.eq(it) } ?: pillEntity.printBack.isNull)
                    .and(pillEntity.colorClass1.eq(color)),
            )
            .fetch()

        pillEntities = (result1 + result2).distinct()
        return pillEntities
    }
}
