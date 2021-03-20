package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eRuleServiceFeatTest {

    @Test
    fun getNumberOfFeats_singleClass1stLevel_numberofFeatsIs0() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(ClassLevel(CharacterClass(), 1))
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(0)
    }

    @Test
    fun getNumberOfFeats_singleClass4thLevel_numberofFeatsIs1() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(ClassLevel(CharacterClass(), 4))
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(1)
    }

    @Test
    fun getNumberOfFeats_multiClass3rdAnd3rdAnd3rdLevel_numberofFeatsIs0() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(
                ClassLevel(CharacterClass(), 3), //
                ClassLevel(CharacterClass(), 3), //
                ClassLevel(CharacterClass(), 3)
            )
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(0)
    }

    @Test
    fun getNumberOfFeats_multiClass4thAnd4thAnd1stLevel_numberofFeatsIs2() {
        // Arrange
        val character = Character().apply {
            classLevels = listOf(
                ClassLevel(CharacterClass(), 4), //
                ClassLevel(CharacterClass(), 4), //
                ClassLevel(CharacterClass(), 1)
            )
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(2)
    }

}