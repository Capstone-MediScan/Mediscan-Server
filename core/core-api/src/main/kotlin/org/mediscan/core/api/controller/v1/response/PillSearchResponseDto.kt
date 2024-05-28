package org.mediscan.core.api.controller.v1.response

import org.mediscan.core.api.domain.Pill

class PillSearchResponseDto(
    val pillName: String?,
    val itemImage: String?,
    val classNo: String?,
) {
    companion object {
        fun toDto(pillEntities: List<Pill>): List<PillSearchResponseDto> {
            return pillEntities.map { pill ->
                PillSearchResponseDto(
                    pill.itemName,
                    pill.itemImage,
                    pill.classNo,
                )
            }
        }
    }
}
