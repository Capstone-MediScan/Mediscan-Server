package org.mediscan.core.api.controller.v1

import org.mediscan.core.api.controller.v1.request.PillIdentificationRequestDto
import org.mediscan.core.api.controller.v1.response.PillIdentificationResponseDto
import org.mediscan.core.api.domain.PillService
import org.mediscan.core.api.support.response.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PillIController(
    private var pillService: PillService,
) {
    @PostMapping("/pill")
    fun identifyPill(@RequestBody request: PillIdentificationRequestDto): ApiResponse<List<PillIdentificationResponseDto>> {
        val results = pillService.identifyPill(
            request.frontImage,
            request.backImage,
            request.pillShape,
            request.frontMarking,
            request.backMarking,
        )

        val responseDtos = results.map { result ->
            PillIdentificationResponseDto(
                drugCode = result.drugCode,
                confidence = result.confidence,
            )
        }

        return ApiResponse.success(responseDtos)
    }

//    @PostMapping("/pill/search")
//    fun searchPill(
//        @RequestBody request: PillSearchRequestDto
//    ): ApiResponse<List<PillSearchResponseDto>> {
//        val results = pillService.searchPill(
//            request.pillShape,
//            request.frontMarking,
//            request.backMarking,
//            request.color
//        )
//
//        val responseDtos = results.map { result ->
//            PillSearchResponseDto(
//
//            )
//        }
//
//        return ApiResponse.success(responseDtos)
//    }
}
