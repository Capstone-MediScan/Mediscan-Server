package org.mediscan.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@FeignClient(name = "ai-service", url = "127.0.0.1:8000")
internal interface AiServiceApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/predict"],
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
    )
    fun predictPill(
        @RequestPart frontImage: MultipartFile,
        @RequestPart backImage: MultipartFile,
        @RequestPart pillCsv: MultipartFile,
    ): AiServiceResponseDto
}
