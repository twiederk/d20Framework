package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eUniverseTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getName_initDnD5eUniverse_nameAndIdSet() {

        // Assert
        assertThat(gameSystem.name).isEqualTo("Dungeons & Dragons 5e")
        assertThat(gameSystem.id).isEqualTo(3)
    }

    @Test
    fun getAllRaces_allRaces_returnsAllRaces() {

        // Act
        val allRaces = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)

        // Assert
        assertThat(allRaces).hasSize(9)
    }

    @Test
    fun getAllRaces_allClasses_returnsAllClasses() {

        // Act
        val allClasses = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)

        // Assert
        assertThat(allClasses).hasSize(12)
    }

    @Test
    fun getAllCharacters_allCharacters_returnsAllCharacters() {

        // Act
        val allCharacters = gameSystem.allCharacters

        // Assert
        assertThat(allCharacters).hasSize(1)
    }


}