package org.mediscan.core.api.controller

import org.mediscan.core.api.controller.v1.response.PillDetailResponseDto
import org.mediscan.core.api.controller.v1.response.PillIdentificationResponseDto
import org.mediscan.core.api.controller.v1.response.PillSearchResponseDto
import org.mediscan.core.api.domain.PillIdentificationData
import org.mediscan.core.api.domain.PillService
import org.mediscan.core.api.support.response.ApiResponse
import org.mediscan.core.enums.Color
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class PillIController(
    private var pillService: PillService,
) {
    @PostMapping("/pill")
    fun identifyPill(
        @RequestPart frontImage: MultipartFile,
        @RequestPart backImage: MultipartFile,
        @RequestPart pillShape: String,
        @RequestPart(required = false) frontMarking: String?,
        @RequestPart(required = false) backMarking: String?,
    ): ApiResponse<List<PillIdentificationResponseDto>> {
        val results = pillService.identifyPill(
            PillIdentificationData(
                frontImage,
                backImage,
                pillShape,
                frontMarking,
                backMarking,
            ),
        )

        return ApiResponse.success(results)
    }

    @GetMapping("/pill/search")
    fun searchPill(
        @RequestParam pillShape: String,
        @RequestParam(required = false) frontMarking: String?,
        @RequestParam(required = false) backMarking: String?,
        @RequestParam color: Color,
    ): ApiResponse<List<PillSearchResponseDto>> {
        val results = pillService.searchPill(
            pillShape,
            frontMarking,
            backMarking,
            color,
        )

        return ApiResponse.success(results)
    }

    @GetMapping("/pill/{pillId}")
    fun searchPill(
        @PathVariable pillId: String,
    ): ApiResponse<PillDetailResponseDto> {
        val results = pillService.searchPill(
            pillId,
        )

        return ApiResponse.success(results)
    }
}
