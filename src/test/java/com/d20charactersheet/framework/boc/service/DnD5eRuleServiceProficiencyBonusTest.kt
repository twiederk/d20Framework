package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eRuleServiceProficiencyBonusTest {

    @Test
    fun calculateProficiencyBonus_singleClass1stLevel_bonusIs2() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(ClassLevel(CharacterClass(), 1))
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(2)
    }

    @Test
    fun calculateProficiencyBonus_singleClass5thLevel_bonusIs2() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(ClassLevel(CharacterClass(), 5))
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(3)
    }

    @Test
    fun calculateProficiencyBonus_multiClass4thAnd5thLevel_bonusIs2() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(ClassLevel(CharacterClass(), 4), ClassLevel(CharacterClass(), 5))
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(4)
    }

}