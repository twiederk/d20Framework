package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel
import com.d20charactersheet.framework.boc.model.Save
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class DnD5eRuleServieSavingThrowTest {

    @Test
    fun getSave_singleClassWithProficiencyLevel1() {

        // arrange
        val clazz = CharacterClass().apply {
            saves = EnumSet.of(Save.STRENGTH)
        }

        val character = Character().apply {
            strength = 10
            classLevels = listOf(
                ClassLevel(clazz, 1)
            )
        }

        // act
        val save = DnD5eRuleServiceImpl().getSave(character, Save.STRENGTH)

        // assert
        assertThat(save).isEqualTo(2)
    }

    @Test
    fun getSave_singleClassWithProficiencyLevel5() {

        // arrange
        val clazz = CharacterClass().apply {
            saves = EnumSet.of(Save.STRENGTH)
        }

        val character = Character().apply {
            strength = 10
            classLevels = listOf(
                ClassLevel(clazz, 5)
            )
        }

        // act
        val save = DnD5eRuleServiceImpl().getSave(character, Save.STRENGTH)

        // assert
        assertThat(save).isEqualTo(3)
    }

    @Test
    fun getSave_singleClassWithoutProficiencyLevel1() {

        // arrange
        val clazz = CharacterClass().apply {
            saves = EnumSet.of(Save.CHARISMA)
        }

        val character = Character().apply {
            strength = 10
            classLevels = listOf(
                ClassLevel(clazz, 1)
            )
        }

        // act
        val save = DnD5eRuleServiceImpl().getSave(character, Save.STRENGTH)

        // assert
        assertThat(save).isEqualTo(0)
    }

    @Test
    fun getSave_multiClassWithProficiencyInOneClass() {

        // arrange
        val clazz1 = CharacterClass().apply {
            saves = EnumSet.of(Save.CHARISMA)
        }
        val clazz2 = CharacterClass().apply {
            saves = EnumSet.of(Save.STRENGTH)
        }

        val character = Character().apply {
            strength = 10
            classLevels = listOf(
                ClassLevel(clazz1, 5),
                ClassLevel(clazz2, 6)
            )
        }

        // act
        val save = DnD5eRuleServiceImpl().getSave(character, Save.STRENGTH)

        // assert
        assertThat(save).isEqualTo(4)
    }

    @Test
    fun getSave_multiClassWithProficiencyInTwoClasses() {

        // arrange
        val clazz1 = CharacterClass().apply {
            saves = EnumSet.of(Save.STRENGTH)
        }
        val clazz2 = CharacterClass().apply {
            saves = EnumSet.of(Save.STRENGTH)
        }

        val character = Character().apply {
            strength = 10
            classLevels = listOf(
                ClassLevel(clazz1, 5),
                ClassLevel(clazz2, 5)
            )
        }

        // act
        val save = DnD5eRuleServiceImpl().getSave(character, Save.STRENGTH)

        // assert
        assertThat(save).isEqualTo(4)
    }

}