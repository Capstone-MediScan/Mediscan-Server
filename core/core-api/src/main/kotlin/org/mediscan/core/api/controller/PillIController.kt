package org.mediscan.core.api.controller;

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PillIController {
    @GetMapping("/pill")
    fun identifyPill(): ResponseEntity<*> {
        return ResponseEntity.ok("Pill I")
    }
}
