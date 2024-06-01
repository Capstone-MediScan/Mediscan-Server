package org.mediscan.core.api.controller.v1.response

import org.mediscan.core.api.domain.Pill

data class PillDetailResponseDto(
    val pillId: String?,
    val pillName: String?,
    val pillNameEng: String?,
    val detail: String?,
    val frontMarking: String?,
    val backMarking: String?,
    val shape: String?,
    val width: String?,
    val length: String?,
    val thick: String?,
    val entpName: String?,
    val itemImage: String?,
) {
    companion object {
        fun toDto(pill: Pill): PillDetailResponseDto {
            return PillDetailResponseDto(
                pill.itemSeq,
                pill.itemName,
                pill.itemEngName,
                pill.className,
                pill.printFront,
                pill.printBack,
                pill.chart,
                pill.lengLong,
                pill.lengShort,
                pill.thick,
                pill.entpName,
                pill.itemImage,
            )
        }
    }
}
