package org.mediscan.storage.db.core

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "pill")
class PillEntity(
    @Id
    val itemSeq: String,
    val itemName: String,
    val entpSeq: String,
    val entpName: String,
    val chart: String,
    val itemImage: String,
    val printFront: String,
    val printBack: String,
    val drugShape: String,
    val colorClass1: String,
    val colorClass2: String,
    val lineFront: String,
    val lineBack: String,
    val lengLong: String,
    val lengShort: String,
    val thick: String,
    val imgRegistTs: String,
    val classNo: String,
    val className: String,
    val etcOtcName: String,
    val itemPermitDate: String,
    val formCodeName: String,
    val markCodeFrontAnal: String,
    val markCodeBackAnal: String,
    val markCodeFrontImg: String,
    val markCodeBackImg: String,
    val itemEngName: String,
    val changeDate: String,
    val markCodeFront: String,
    val markCodeBack: String,
    val ediCode: String,
    val bizrno: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PillEntity) return false

        if (itemSeq != other.itemSeq) return false

        return true
    }

    override fun hashCode(): Int {
        return itemSeq.hashCode()
    }
}
