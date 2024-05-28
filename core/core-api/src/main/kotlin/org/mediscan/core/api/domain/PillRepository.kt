package org.mediscan.core.api.domain

interface PillRepository {
    fun readPill(pillShape: String, frontMarking: String, backMarking: String, color: String): Pill
}
