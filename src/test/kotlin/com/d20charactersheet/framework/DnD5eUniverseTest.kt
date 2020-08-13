package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import com.d20charactersheet.framework.boc.service.RaceService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eUniverseTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem
    private val raceService: RaceService = gameSystem.raceService

    @Test
    fun getName_initDnD5eUniverse_nameAndIdSet() {

        // Assert
        assertThat(gameSystem.name).isEqualTo("Dungeons & Dragons 5e")
        assertThat(gameSystem.id).isEqualTo(3)
    }

    @Test
    fun getAllRaces_allRaces_returnsAllRaces() {
        // Arrange

        // Act
        val allRaces = raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)

        // Assert
        assertThat(allRaces).hasSize(9)
    }

}