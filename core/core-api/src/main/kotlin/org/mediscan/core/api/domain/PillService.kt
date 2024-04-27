package org.mediscan.core.api.domain

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PillService (
    private val pillManager: PillManager
){
    fun identifyPill(frontImage: MultipartFile, backImage: MultipartFile,
                     fillShape: String, frontMarking: String, backMarking: String ):  {

        return
    }
}