package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class DnD5eRaceAbilityTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getAllRaces_human_raceAbilities() {

        // Act
        val human = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[0]

        // Assert
        Assertions.assertThat(human.abilities).extracting("name").containsExactlyInAnyOrder("Ability Score Increase (Human)")
    }

    @Test
    fun getAllRaces_dragonborn_raceAbilities() {

        // Act
        val dragonborn = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[1]

        // Assert
        Assertions.assertThat(dragonborn.abilities).extracting("name").containsExactlyInAnyOrder(
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
        Assertions.assertThat(dwarf.abilities).extracting("name").containsExactlyInAnyOrder(
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
        Assertions.assertThat(elf.abilities).extracting("name")
            .containsExactlyInAnyOrder("Darkvision", "Ability Score Increase (Elf)", "Keen Senses", "Fey Ancestry", "Trance")
    }

    @Test
    fun getAllRaces_gnome_raceAbilities() {

        // Act
        val gnome = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[4]

        // Assert
        Assertions.assertThat(gnome.abilities).extracting("name")
            .containsExactlyInAnyOrder("Darkvision", "Ability Score Increase (Gnome)", "Gnome Cunning")
    }

    @Test
    fun getAllRaces_halfElf_raceAbilities() {

        // Act
        val halfElf = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[5]

        // Assert
        Assertions.assertThat(halfElf.abilities).extracting("name").containsExactlyInAnyOrder(
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
        Assertions.assertThat(halfOrc.abilities).extracting("name").containsExactlyInAnyOrder(
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
        Assertions.assertThat(halfling.abilities).extracting("name")
            .containsExactlyInAnyOrder("Ability Score Increase (Halfling)", "Lucky", "Brave", "Halfling Nimbleness")
    }

    @Test
    fun getAllRaces_tiefling_raceAbilities() {

        // Act
        val tiefling = gameSystem.raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)[8]

        // Assert
        Assertions.assertThat(tiefling.abilities).extracting("name").containsExactlyInAnyOrder(
            "Darkvision",
            "Ability Score Increase (Tiefling)",
            "Hellish Resistance",
            "Infernal Legacy"
        )
    }

}