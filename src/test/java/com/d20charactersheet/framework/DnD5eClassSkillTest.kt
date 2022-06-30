package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eClassSkillTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getSkills_barbarian_skillsOfBarbarian() {

        // act
        val skills = gameSystem.allCharacterClasses[0].skills

        // assert
        assertThat(skills).hasSize(6)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Animal Handling",
            "Athletics",
            "Intimidation",
            "Nature",
            "Perception",
            "Survival"
        )
    }

    @Test
    fun getSkills_bard_skillsOfBard() {

        // act
        val skills = gameSystem.allCharacterClasses[1].skills

        // assert
        assertThat(skills).hasSize(18)
    }

    @Test
    fun getSkills_cleric_skillsOfCleric() {

        // act
        val skills = gameSystem.allCharacterClasses[2].skills

        // assert
        assertThat(skills).hasSize(5)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "History",
            "Insight",
            "Medicine",
            "Persuasion",
            "Religion"
        )
    }

    @Test
    fun getSkills_druid_skillsOfDruid() {

        // act
        val skills = gameSystem.allCharacterClasses[3].skills

        // assert
        assertThat(skills).hasSize(8)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Arcana",
            "Animal Handling",
            "Insight",
            "Medicine",
            "Nature",
            "Perception",
            "Religion",
            "Survival"
        )
    }

    @Test
    fun getSkills_fighter_skillsOfFighter() {

        // act
        val skills = gameSystem.allCharacterClasses[4].skills

        // assert
        assertThat(skills).hasSize(8)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Acrobatics",
            "Animal Handling",
            "Athletics",
            "History",
            "Insight",
            "Intimidation",
            "Perception",
            "Survival"
        )
    }

    @Test
    fun getSkills_monk_skillsOfMonk() {

        // act
        val skills = gameSystem.allCharacterClasses[5].skills

        // assert
        assertThat(skills).hasSize(6)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Acrobatics",
            "Athletics",
            "History",
            "Insight",
            "Religion",
            "Stealth"
        )
    }

    @Test
    fun getSkills_paladin_skillsOPaladin() {

        // act
        val skills = gameSystem.allCharacterClasses[6].skills

        // assert
        assertThat(skills).hasSize(6)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Athletics",
            "Insight",
            "Intimidation",
            "Medicine",
            "Persuasion",
            "Religion"
        )
    }

    @Test
    fun getSkills_ranger_skillsOfRanger() {

        // act
        val skills = gameSystem.allCharacterClasses[7].skills

        // assert
        assertThat(skills).hasSize(8)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Animal Handling",
            "Athletics",
            "Insight",
            "Investigation",
            "Nature",
            "Perception",
            "Stealth",
            "Survival"
        )
    }

    @Test
    fun getSkills_rogue_skillsOfRogue() {

        // act
        val skills = gameSystem.allCharacterClasses[8].skills

        // assert
        assertThat(skills).hasSize(11)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Acrobatics",
            "Athletics",
            "Deception",
            "Insight",
            "Intimidation",
            "Investigation",
            "Perception",
            "Performance",
            "Persuasion",
            "Sleight of Hand",
            "Stealth"
        )
    }

    @Test
    fun getSkills_sorcerer_skillsOfSorcerer() {

        // act
        val skills = gameSystem.allCharacterClasses[9].skills

        // assert
        assertThat(skills).hasSize(6)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Arcana",
            "Deception",
            "Insight",
            "Intimidation",
            "Persuasion",
            "Religion"
        )
    }

    @Test
    fun getSkills_warlock_skillsOfWarlock() {

        // act
        val skills = gameSystem.allCharacterClasses[10].skills

        // assert
        assertThat(skills).hasSize(7)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Arcana",
            "Deception",
            "History",
            "Intimidation",
            "Investigation",
            "Nature",
            "Religion"
        )
    }

    @Test
    fun getSkills_wizard_skillsOfWizard() {

        // act
        val skills = gameSystem.allCharacterClasses[11].skills

        // assert
        assertThat(skills).hasSize(6)
        assertThat(skills.map { it.name }).containsExactlyInAnyOrder(
            "Arcana",
            "History",
            "Insight",
            "Investigation",
            "Medicine",
            "Religion"
        )
    }


}