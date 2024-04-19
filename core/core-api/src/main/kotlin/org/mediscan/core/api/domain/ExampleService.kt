package org.mediscan.core.api.domain

import org.springframework.stereotype.Service

@Service
class ExampleService() {
    fun processExample(exampleData: ExampleData): ExampleResult {
        return ExampleResult(exampleData.value)
    }
}
