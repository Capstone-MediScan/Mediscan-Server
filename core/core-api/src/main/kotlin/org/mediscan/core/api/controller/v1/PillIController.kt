package org.mediscan.core.api.controller.v1;

import org.mediscan.core.api.controller.v1.request.PillIdentificationRequestDto
import org.mediscan.core.api.controller.v1.response.PillIdentificationResponseDto
import org.mediscan.core.api.domain.PillService
import org.mediscan.core.api.support.response.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController;

@RestController
class PillIController(
    private var pillService: PillService
) {
    @PostMapping("/pill")
    fun identifyPill(@RequestBody request: PillIdentificationRequestDto): ApiResponse<PillIdentificationResponseDto> {
        val result =pillService.identifyPill(request.frontImage, request.backImage, request.pillShape, request.frontMarking, request.backMarking)
        return ApiResponse.success(PillIdentificationResponseDto(result.confidence,result.drugCode))
    }
}
