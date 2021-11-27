package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel
import com.d20charactersheet.framework.boc.model.Save
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class DnDv35RuleServiceSavingThrowTest {

    val ruleService = DnDv35RuleServiceImpl()

    val wizard = CharacterClass().apply { saves = EnumSet.of(Save.CONSTITUTION) }
    val fighter = CharacterClass().apply { saves = EnumSet.of(Save.STRENGTH) }
    val ranger = CharacterClass().apply { saves = EnumSet.of(Save.STRENGTH, Save.DEXTERITY) }
    val rogue = CharacterClass().apply { saves = EnumSet.of(Save.DEXTERITY) }

    @Test
    fun getGoodSave_level1_return2() {
        // act
        val savingThrow = ruleService.getGoodSave(1)

        // assert
        assertThat(savingThrow).isEqualTo(2)
    }

    @Test
    fun getGoodSave_level2_return3() {
        // act
        val savingThrow = ruleService.getGoodSave(2)

        // assert
        assertThat(savingThrow).isEqualTo(3)
    }

    @Test
    fun getGoodSave_level3_return3() {
        // act
        val savingThrow = ruleService.getGoodSave(3)

        // assert
        assertThat(savingThrow).isEqualTo(3)
    }

    @Test
    fun getGoodSave_level10_return7() {
        // act
        val savingThrow = ruleService.getGoodSave(10)

        // assert
        assertThat(savingThrow).isEqualTo(7)
    }

    @Test
    fun getGoodSave_level15_return9() {
        // act
        val savingThrow = ruleService.getGoodSave(15)

        // assert
        assertThat(savingThrow).isEqualTo(9)
    }

    @Test
    fun getGoodSave_level20_return12() {
        // act
        val savingThrow = ruleService.getGoodSave(20)

        // assert
        assertThat(savingThrow).isEqualTo(12)
    }

    @Test
    fun getPoorSave_level1_return0() {
        // act
        val savingThrow = ruleService.getPoorSave(1)

        // assert
        assertThat(savingThrow).isEqualTo(0)
    }

    @Test
    fun getPoorSave_level2_return0() {
        // act
        val savingThrow = ruleService.getPoorSave(2)

        // assert
        assertThat(savingThrow).isEqualTo(0)
    }

    @Test
    fun getPoorSave_level3_return1() {
        // act
        val savingThrow = ruleService.getPoorSave(3)

        // assert
        assertThat(savingThrow).isEqualTo(1)
    }

    @Test
    fun getPoorSave_level10_return3() {
        // act
        val savingThrow = ruleService.getPoorSave(10)

        // assert
        assertThat(savingThrow).isEqualTo(3)
    }

    @Test
    fun getPoorSave_level15_return5() {
        // act
        val savingThrow = ruleService.getPoorSave(15)

        // assert
        assertThat(savingThrow).isEqualTo(5)
    }

    @Test
    fun getPoorSave_level20_return6() {
        // act
        val savingThrow = ruleService.getPoorSave(20)

        // assert
        assertThat(savingThrow).isEqualTo(6)
    }

    @Test
    fun getBaseSave_fighterLevel1_fortitudeIs2() {
        // act
        val savingThrow = ruleService.getBaseSave(ClassLevel(fighter, 1), Save.STRENGTH)

        // assert
        assertThat(savingThrow).isEqualTo(2)
    }

    @Test
    fun getBaseSave_fighterLevel1_reflexIs0() {
        // act
        val savingThrow = ruleService.getBaseSave(ClassLevel(fighter, 1), Save.DEXTERITY)

        // assert
        assertThat(savingThrow).isEqualTo(0)
    }

    @Test
    fun getBaseSave_fighterLevel1_willIs0() {
        // act
        val savingThrow = ruleService.getBaseSave(ClassLevel(fighter, 1), Save.CONSTITUTION)

        // assert
        assertThat(savingThrow).isEqualTo(0)
    }

    @Test
    fun getBaseSave_fighterLevel3_fortitudeIs3() {
        // act
        val savingThrow = ruleService.getBaseSave(ClassLevel(fighter, 3), Save.STRENGTH)

        // assert
        assertThat(savingThrow).isEqualTo(3)
    }

    @Test
    fun getBaseSave_fighterLevel3_reflexIs1() {
        // act
        val savingThrow = ruleService.getBaseSave(ClassLevel(fighter, 3), Save.DEXTERITY)

        // assert
        assertThat(savingThrow).isEqualTo(1)
    }

    @Test
    fun getSave_singleClassWizardLevel5_fortitudeIs3() {
        // arrange
        val character = Character().apply {
            classLevels = listOf(
                ClassLevel(wizard, 5)
            )
        }
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.setSaveModifier(Save.STRENGTH, 1)
        character.setSaveModifier(Save.DEXTERITY, 2)
        character.setSaveModifier(Save.CONSTITUTION, 3)

        // act
        val savingThrow = ruleService.getSave(character, Save.STRENGTH)

        // assert
        assertThat(savingThrow).isEqualTo(3)
    }

    @Test
    fun getSave_singleClassWizardLevel5_reflexIs5() {
        // arrange
        val character = Character().apply {
            classLevels = listOf(
                ClassLevel(wizard, 5)
            )
        }
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.setSaveModifier(Save.STRENGTH, 1)
        character.setSaveModifier(Save.DEXTERITY, 2)
        character.setSaveModifier(Save.CONSTITUTION, 3)

        // act
        val savingThrow = ruleService.getSave(character, Save.DEXTERITY)

        // assert
        assertThat(savingThrow).isEqualTo(5)
    }

    @Test
    fun getSave_singleClassWizardLevel5_willIs10() {
        // arrange
        val character = Character().apply {
            classLevels = listOf(
                ClassLevel(wizard, 5)
            )
        }
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.setSaveModifier(Save.STRENGTH, 1)
        character.setSaveModifier(Save.DEXTERITY, 2)
        character.setSaveModifier(Save.CONSTITUTION, 3)

        // act
        val savingThrow = ruleService.getSave(character, Save.CONSTITUTION)

        // assert
        assertThat(savingThrow).isEqualTo(10)
    }

    @Test
    fun getSave_ranger4Rogu3_fortitude7() {

        // arrange
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.setSaveModifier(Save.STRENGTH, 1)
        character.setSaveModifier(Save.DEXTERITY, 2)
        character.setSaveModifier(Save.CONSTITUTION, 3)

        // act
        val savingThrow = ruleService.getSave(character, Save.STRENGTH)

        // assert
        // Ranger(4) + Rogue(3) + Constitution + modifier = +4 +1 +1 +1 = 7
        assertThat(savingThrow).isEqualTo(7)
    }

    @Test
    fun getSave_ranger4Rogu3_reflex111() {

        // arrange
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.setSaveModifier(Save.STRENGTH, 1)
        character.setSaveModifier(Save.DEXTERITY, 2)
        character.setSaveModifier(Save.CONSTITUTION, 3)

        // act
        val savingThrow = ruleService.getSave(character, Save.DEXTERITY)

        // assert
        // Ranger(4) + Rogue(3) + Constitution + modifier = +4 +3 +2 +2 = 11
        assertThat(savingThrow).isEqualTo(11)
    }

    @Test
    fun getSave_ranger4Rogu3_will8() {

        // arrange
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.setSaveModifier(Save.STRENGTH, 1)
        character.setSaveModifier(Save.DEXTERITY, 2)
        character.setSaveModifier(Save.CONSTITUTION, 3)

        // act
        val savingThrow = ruleService.getSave(character, Save.CONSTITUTION)

        // Ranger(4) + Rogue(3) + Constitution = +1 +1 +3 +3 = 8
        assertThat(savingThrow).isEqualTo(8)
    }


    @Test
    fun getBase_ranger4rogue3_fortitude() {

        // arrange
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels

        // act
        val savingThrow = ruleService.getProficiencySave(character, Save.STRENGTH)

        // assert
        // Ranger(4) + Rogue(3) = +4 +1 = 5
        assertThat(savingThrow).isEqualTo(5)
    }

    @Test
    fun getBase_ranger4rogue3_reflex7() {

        // arrange
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels

        // act
        val savingThrow = ruleService.getProficiencySave(character, Save.DEXTERITY)

        // assert
        // Ranger(4) + Rogue(3) = +4 +3 = 7
        assertThat(savingThrow).isEqualTo(7)
    }

    @Test
    fun getBase_ranger4rogue3_will2() {

        // arrange
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels

        // act
        val savingThrow = ruleService.getProficiencySave(character, Save.CONSTITUTION)

        // assert
        // Ranger(4) + Rogue(3) = +1 +1 = 2
        assertThat(savingThrow).isEqualTo(2)
    }
}