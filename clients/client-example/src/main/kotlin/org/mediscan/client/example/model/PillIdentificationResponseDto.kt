package org.mediscan.client.example.model;

data class PillIdentificationResponseDto(
        var drugCode: String,
        var confidence: Long
)
