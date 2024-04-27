package org.mediscan.core.api.controller;

import org.mediscan.core.api.controller.v1.request.PillIdentificationRequestDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController;

@RestController
class PillIController {
    @PostMapping("/pill")
    fun identifyPill(@RequestBody request: PillIdentificationRequestDto): ResponseEntity<*> {

        return ResponseEntity.ok("Pill I")
    }
}
