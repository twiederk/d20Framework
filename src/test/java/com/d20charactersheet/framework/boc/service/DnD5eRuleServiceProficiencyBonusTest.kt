package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.dsl.createCharacter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eRuleServiceProficiencyBonusTest {

    @Test
    fun calculateProficiencyBonus_singleClass1stLevel_bonusIs2() {
        // Arrange
        val character = createCharacter { classLevels { classLevel { level = 1 } } }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(2)
    }

    @Test
    fun calculateProficiencyBonus_singleClass4thLevel_bonusIs2() {
        // Arrange
        val character = createCharacter { classLevels { classLevel { level = 4 } } }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(2)
    }

    @Test
    fun calculateProficiencyBonus_singleClass5thLevel_bonusIs3() {
        // Arrange
        val character = createCharacter { classLevels { classLevel { level = 5 } } }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(3)
    }

    @Test
    fun calculateProficiencyBonus_multiClass4thAnd4thLevel_bonusIs3() {
        // Arrange
        val character = createCharacter {
            classLevels {
                classLevel { level = 4 }
                classLevel { level = 4 }
            }
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(3)
    }

    @Test
    fun calculateProficiencyBonus_multiClass4thAnd5thLevel_bonusIs4() {
        // Arrange
        val character = createCharacter {
            classLevels {
                classLevel { level = 4 }
                classLevel { level = 5 }
            }
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().calculateProficiencyBonus(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(4)
    }

}