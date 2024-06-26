package org.mediscan.core.api.controller.v1.response

import org.mediscan.core.api.domain.Pill

data class PillSearchResponseDto(
    val pillId: String?,
    val pillName: String?,
    val itemImage: String?,
    val className: String?,
) {
    companion object {
        fun toDto(pillEntities: List<Pill>): List<PillSearchResponseDto> {
            return pillEntities.map { pill ->
                PillSearchResponseDto(
                    pill.itemSeq,
                    pill.itemName,
                    pill.itemImage,
                    pill.className,
                )
            }
        }
    }
}
