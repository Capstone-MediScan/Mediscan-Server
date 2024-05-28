package org.mediscan.core.api.domain

import org.mediscan.storage.db.core.PillEntity

data class Pill(
    val itemSeq: String,
    val itemName: String?,
    val entpSeq: String?,
    val entpName: String?,
    val chart: String?,
    val itemImage: String?,
    val printFront: String?,
    val printBack: String?,
    val drugShape: String?,
    val colorClass1: String?,
    val colorClass2: String?,
    val lineFront: String?,
    val lineBack: String?,
    val lengLong: String?,
    val lengShort: String?,
    val thick: String?,
    val imgRegistTs: String?,
    val classNo: String?,
    val className: String?,
    val etcOtcName: String?,
    val itemPermitDate: String?,
    val formCodeName: String?,
    val markCodeFrontAnal: String?,
    val markCodeBackAnal: String?,
    val markCodeFrontImg: String?,
    val markCodeBackImg: String?,
    val itemEngName: String?,
    val changeDate: String?,
    val markCodeFront: String?,
    val markCodeBack: String?,
    val ediCode: String?,
    val bizrno: String?,
) {
    companion object {
        fun toDto(pillEntities: List<PillEntity>): List<Pill> {
            return pillEntities.map { pillEntity ->
                Pill(
                    pillEntity.itemSeq,
                    pillEntity.itemName,
                    pillEntity.entpSeq,
                    pillEntity.entpName,
                    pillEntity.chart,
                    pillEntity.itemImage,
                    pillEntity.printFront,
                    pillEntity.printBack,
                    pillEntity.drugShape,
                    pillEntity.colorClass1,
                    pillEntity.colorClass2,
                    pillEntity.lineFront,
                    pillEntity.lineBack,
                    pillEntity.lengLong,
                    pillEntity.lengShort,
                    pillEntity.thick,
                    pillEntity.imgRegistTs,
                    pillEntity.classNo,
                    pillEntity.className,
                    pillEntity.etcOtcName,
                    pillEntity.itemPermitDate,
                    pillEntity.formCodeName,
                    pillEntity.markCodeFrontAnal,
                    pillEntity.markCodeBackAnal,
                    pillEntity.markCodeFrontImg,
                    pillEntity.markCodeBackImg,
                    pillEntity.itemEngName,
                    pillEntity.changeDate,
                    pillEntity.markCodeFront,
                    pillEntity.markCodeBack,
                    pillEntity.ediCode,
                    pillEntity.bizrno,
                )
            }
        }
    }
}
