package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eFeatTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getAllClasses_barbarian_classAbilities() {

        // Act
        val allFeats = gameSystem.allFeats

        // Assert
        assertThat(allFeats).hasSize(42)
    }

}