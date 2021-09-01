package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.dsl.createCharacter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eRuleServiceFeatTest {

    @Test
    fun getNumberOfFeats_singleClass1stLevel_numberofFeatsIs0() {
        // Arrange
        val character = createCharacter { classLevels { classLevel { level = 1 } } }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(0)
    }

    @Test
    fun getNumberOfFeats_singleClass4thLevel_numberofFeatsIs1() {
        // Arrange
        val character = createCharacter { classLevels { classLevel { level = 4 } } }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(1)
    }

    @Test
    fun getNumberOfFeats_multiClass3rdAnd3rdAnd3rdLevel_numberofFeatsIs0() {
        // Arrange
        val character = createCharacter {
            classLevels {
                classLevel { level = 3 }
                classLevel { level = 3 }
                classLevel { level = 3 }
            }
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(0)
    }

    @Test
    fun getNumberOfFeats_multiClass4thAnd4thAnd1stLevel_numberofFeatsIs2() {
        // Arrange
        val character = createCharacter {
            classLevels {
                classLevel { level = 4 }
                classLevel { level = 4 }
                classLevel { level = 1 }
            }
        }

        // Act
        val proficiencyBonus = DnD5eRuleServiceImpl().getNumberOfFeats(character)

        // Assert
        assertThat(proficiencyBonus).isEqualTo(2)
    }

}