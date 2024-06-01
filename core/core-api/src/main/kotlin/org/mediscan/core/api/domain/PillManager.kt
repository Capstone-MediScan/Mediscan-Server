package org.mediscan.core.api.domain

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileWriter

@Component
class PillManager {
    fun createCsvFile(pillShape: String, pillFrontMarking: String?, pillBackMarking: String?, filePath: String) {
        val file = File(filePath)
        val parentDir = file.parentFile
        if (!parentDir.exists()) {
            parentDir.mkdirs()
        }
        val writer = FileWriter(file)
        val csvPrinter =
            CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader("shape", "f_text", "b_text", "drug_code").setDelimiter('\t').build())

        csvPrinter.printRecord(
            pillShape,
            pillFrontMarking ?: "none",
            pillBackMarking ?: "none",
            "none",
        )
        csvPrinter.flush()
        csvPrinter.close()
    }
}
