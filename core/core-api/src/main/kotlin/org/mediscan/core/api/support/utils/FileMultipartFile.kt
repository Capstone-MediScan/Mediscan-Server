package org.mediscan.core.api.support.utils

import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

class FileMultipartFile(
    private val file: File,
    private val contentType: String,
) : MultipartFile {

    override fun getName(): String {
        return file.name
    }

    override fun getOriginalFilename(): String {
        return file.name
    }

    override fun getContentType(): String {
        return contentType
    }

    override fun isEmpty(): Boolean {
        return file.length() == 0L
    }

    override fun getSize(): Long {
        return file.length()
    }

    override fun getBytes(): ByteArray {
        return file.readBytes()
    }

    override fun getInputStream(): InputStream {
        return FileInputStream(file)
    }

    override fun transferTo(dest: File) {
        file.copyTo(dest, overwrite = true)
    }
}
