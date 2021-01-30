package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.ClassAbility
import com.d20charactersheet.framework.boc.model.Skill
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CharacterClassServiceTest {

    private lateinit var characterClassService: CharacterClassService
    private lateinit var allSkills: List<Skill>
    private lateinit var allAbilities: List<Ability>

    @BeforeEach
    fun setUp() {
        val gameSystem = DnDv35Universe().gameSystem
        characterClassService = gameSystem.characterClassService
        allSkills = gameSystem.allSkills
        allAbilities = gameSystem.allAbilities
    }

    @Test
    fun testGetAllCharacterClasses() {

        // Act
        val allCharacterClasses = characterClassService.getAllCharacterClasses(allSkills, allAbilities)

        // Assert
        assertThat(allCharacterClasses).hasSize(27)
    }

    @Test
    fun testAbilitiesOfBarbarian() {

        // Act
        val allCharacterClasses = characterClassService.getAllCharacterClasses(allSkills, allAbilities)

        // Assert
        val barbarian = allCharacterClasses[0]
        val barbarianAbilities = barbarian.classAbilities
        val levels = intArrayOf(1, 1, 1, 2, 3, 5, 7, 11, 14, 17, 20)
        assertThat(barbarianAbilities).hasSize(levels.size)
        assertLevels(levels, barbarianAbilities)
    }

    private fun assertLevels(levels: IntArray, classAbilities: List<ClassAbility>) {
        for (i in levels.indices) {
            val classAbility = classAbilities[i]
            assertThat(levels[i]).isEqualTo(classAbility.level)
        }
    }
}