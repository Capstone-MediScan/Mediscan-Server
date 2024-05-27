package org.mediscan.storage.db.core

import org.springframework.data.jpa.repository.JpaRepository

interface PillJpaRepository : JpaRepository<PillEntity, Long>
