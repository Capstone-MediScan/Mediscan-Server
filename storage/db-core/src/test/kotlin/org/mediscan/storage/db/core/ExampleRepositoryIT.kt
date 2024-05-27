package org.mediscan.storage.db.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mediscan.storage.db.CoreDbContextTest

class ExampleRepositoryIT(
    val exampleRepository: ExampleRepository,
) : CoreDbContextTest() {
    @Test
    fun testShouldBeSavedAndFound() {
        val saved = exampleRepository.save(ExampleEntity("SPRING_BOOT"))
        assertThat(saved.exampleColumn).isEqualTo("SPRING_BOOT")

        val found = exampleRepository.findById(saved.id!!).get()
        assertThat(found.exampleColumn).isEqualTo("SPRING_BOOT")
    }
}
