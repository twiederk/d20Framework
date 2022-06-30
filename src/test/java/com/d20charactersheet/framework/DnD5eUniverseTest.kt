package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eUniverseTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getGameSystem_initDnD5eUniverse_gameSystemIsInitialized() {

        // assert
        assertThat(gameSystem.name).isEqualTo("Dungeons & Dragons 5e")
        assertThat(gameSystem.id).isEqualTo(3)
        assertThat(gameSystem.characterCreatorService).isNotNull
    }

    @Test
    fun getAllRaces_allRaces_returnsAllRaces() {

        // act
        val allRaces = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)

        // assert
        assertThat(allRaces).hasSize(9)
    }

    @Test
    fun getAllRaces_allClasses_returnsAllClasses() {

        // act
        val allClasses = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)

        // assert
        assertThat(allClasses).hasSize(12)
    }

    @Test
    fun getAllSpelllists_allSpelllists_returnsAllSpelllists() {

        // act
        val allSpelllists = gameSystem.allSpelllists

        // assert
        assertThat(allSpelllists).hasSize(8)

    }

    @Test
    fun getAllSpells_allSpells_returnsAllSpells() {

        // act
        val allSpells = gameSystem.allSpells

        // assert
        assertThat(allSpells).hasSize(361)
    }

    @Test
    fun getAllSkills_allSkills_returnsAllSkills() {

        // act
        val allSkills = gameSystem.allSkills

        // assert
        assertThat(allSkills).hasSize(18)


    }
}