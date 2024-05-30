package org.mediscan.core.api.domain

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.apache.commons.io.output.ByteArrayOutputStream
import org.springframework.stereotype.Component
import java.io.OutputStreamWriter

@Component
class PillManager {
    fun createCsvInMemory(pillShape: String, pillFrontMarking: String?, pillBackMarking: String?): ByteArray {
        val outputStream = ByteArrayOutputStream()
        val writer = OutputStreamWriter(outputStream)
        val csvPrinter =
            CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader("shape", "f_text", "b_text", "drug_code").build())

        csvPrinter.printRecord(
            pillShape,
            pillFrontMarking.let { it ?: "none" },
            pillBackMarking.let { it ?: "none" },
            "none",
        )
        csvPrinter.flush()
        csvPrinter.close()

        return outputStream.toByteArray()
    }
}
