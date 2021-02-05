package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eUniverseTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getGameSystem_initDnD5eUniverse_gameSystemIsInitialized() {

        // Assert
        assertThat(gameSystem.name).isEqualTo("Dungeons & Dragons 5e")
        assertThat(gameSystem.id).isEqualTo(3)
        assertThat(gameSystem.characterCreatorService).isNotNull
    }

    @Test
    fun getAllRaces_allRaces_returnsAllRaces() {

        // Act
        val allRaces = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)

        // Assert
        assertThat(allRaces).hasSize(9)
    }

    @Test
    fun getAllRaces_human_raceAbilities() {

        // Act
        val human = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[0]

        // Assert
        assertThat(human.abilities).extracting("name").containsExactlyInAnyOrder("Ability Score Increase (Human)")
    }

    @Test
    fun getAllRaces_dragonborn_raceAbilities() {

        // Act
        val dragonborn = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[1]

        // Assert
        assertThat(dragonborn.abilities).extracting("name").containsExactlyInAnyOrder(
            "Ability Score Increase (Dragonborn)",
            "Draconic Ancestry",
            "Breath Weapon",
            "Damage Resistance"
        )
    }

    @Test
    fun getAllRaces_dwarf_raceAbilities() {

        // Act
        val dwarf = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[2]

        // Assert
        assertThat(dwarf.abilities).extracting("name").containsExactlyInAnyOrder(
            "Ability Score Increase (Dwarf)",
            "Darkvision",
            "Dwarven Resilience",
            "Dwarven Combat Training",
            "Tool Proficiency",
            "Stonecunning"
        )
    }

    @Test
    fun getAllRaces_elf_raceAbilities() {

        // Act
        val elf = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[3]

        // Assert
        assertThat(elf.abilities).extracting("name")
            .containsExactlyInAnyOrder("Darkvision", "Ability Score Increase (Elf)", "Keen Senses", "Fey Ancestry", "Trance")
    }

    @Test
    fun getAllRaces_gnome_raceAbilities() {

        // Act
        val gnome = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[4]

        // Assert
        assertThat(gnome.abilities).extracting("name")
            .containsExactlyInAnyOrder("Darkvision", "Ability Score Increase (Gnome)", "Gnome Cunning")
    }

    @Test
    fun getAllRaces_halfElf_raceAbilities() {

        // Act
        val halfElf = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[5]

        // Assert
        assertThat(halfElf.abilities).extracting("name").containsExactlyInAnyOrder(
            "Darkvision",
            "Fey Ancestry",
            "Ability Score Increase (Half-Efl)",
            "Skill Versatility"
        )
    }

    @Test
    fun getAllRaces_halfOrc_raceAbilities() {

        // Act
        val halfOrc = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[6]

        // Assert
        assertThat(halfOrc.abilities).extracting("name").containsExactlyInAnyOrder(
            "Darkvision",
            "Ability Score Increase (Half-Orc)",
            "Menacing",
            "Relentless Endurance",
            "Savage Attacks"
        )
    }

    @Test
    fun getAllRaces_halfling_raceAbilities() {

        // Act
        val halfling = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[7]

        // Assert
        assertThat(halfling.abilities).extracting("name")
            .containsExactlyInAnyOrder("Ability Score Increase (Halfling)", "Lucky", "Brave", "Halfling Nimbleness")
    }

    @Test
    fun getAllRaces_tiefling_raceAbilities() {

        // Act
        val tiefling = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[8]

        // Assert
        assertThat(tiefling.abilities).extracting("name").containsExactlyInAnyOrder(
            "Darkvision",
            "Ability Score Increase (Tiefling)",
            "Hellish Resistance",
            "Infernal Legacy"
        )
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