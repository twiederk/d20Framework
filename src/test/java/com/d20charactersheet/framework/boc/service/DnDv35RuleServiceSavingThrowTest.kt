package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.ClassLevel
import com.d20charactersheet.framework.boc.model.Save
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.util.*

class DnDv35RuleServiceSavingThrowTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetGoodSavingThrow() {
        val abstractRuleServiceImpl = ruleService as AbstractRuleServiceImpl

        // level 1 => +2
        var savingThrow = abstractRuleServiceImpl.getGoodSave(1)
        Assert.assertEquals(2, savingThrow.toLong())

        // level 2 => +3
        savingThrow = abstractRuleServiceImpl.getGoodSave(2)
        Assert.assertEquals(3, savingThrow.toLong())

        // level 3 => +3
        savingThrow = abstractRuleServiceImpl.getGoodSave(3)
        Assert.assertEquals(3, savingThrow.toLong())

        // level 10 => +7
        savingThrow = abstractRuleServiceImpl.getGoodSave(10)
        Assert.assertEquals(7, savingThrow.toLong())

        // level 15 => +9
        savingThrow = abstractRuleServiceImpl.getGoodSave(15)
        Assert.assertEquals(9, savingThrow.toLong())

        // level 20 => +12
        savingThrow = abstractRuleServiceImpl.getGoodSave(20)
        Assert.assertEquals(12, savingThrow.toLong())
    }

    @Test
    fun testGetPoorSavingThrow() {
        val abstractRuleServiceImpl = ruleService as AbstractRuleServiceImpl

        // level 1 => 0
        var savingThrow = abstractRuleServiceImpl.getPoorSave(1)
        Assert.assertEquals(0, savingThrow.toLong())

        // level 2 => 0
        savingThrow = abstractRuleServiceImpl.getPoorSave(2)
        Assert.assertEquals(0, savingThrow.toLong())

        // level 3 => +1
        savingThrow = abstractRuleServiceImpl.getPoorSave(3)
        Assert.assertEquals(1, savingThrow.toLong())

        // level 10 => +3
        savingThrow = abstractRuleServiceImpl.getPoorSave(10)
        Assert.assertEquals(3, savingThrow.toLong())

        // level 15 => +5
        savingThrow = abstractRuleServiceImpl.getPoorSave(15)
        Assert.assertEquals(5, savingThrow.toLong())

        // level 20 => +6
        savingThrow = abstractRuleServiceImpl.getPoorSave(20)
        Assert.assertEquals(6, savingThrow.toLong())
    }

    @Test
    fun testGetSavingThrowClass() {
        val abstractRuleServiceImpl = ruleService as AbstractRuleServiceImpl

        // Fighter (1), Fortitude => 2
        var savingThrow = abstractRuleServiceImpl.getBaseSave(ClassLevel(fighter, 1), Save.FORTITUDE)
        Assert.assertEquals(2, savingThrow.toLong())

        // Fighter (1), Reflex => 0
        savingThrow = abstractRuleServiceImpl.getBaseSave(ClassLevel(fighter, 1), Save.REFLEX)
        Assert.assertEquals(0, savingThrow.toLong())

        // Fighter (1), Will => 0
        savingThrow = abstractRuleServiceImpl.getBaseSave(ClassLevel(fighter, 1), Save.WILL)
        Assert.assertEquals(0, savingThrow.toLong())

        // Fighter (3), Fortitude => 3
        savingThrow = abstractRuleServiceImpl.getBaseSave(ClassLevel(fighter, 3), Save.FORTITUDE)
        Assert.assertEquals(3, savingThrow.toLong())

        // Fighter (3), Reflex => 1
        savingThrow = abstractRuleServiceImpl.getBaseSave(ClassLevel(fighter, 3), Save.REFLEX)
        Assert.assertEquals(1, savingThrow.toLong())
    }

    @Test
    fun testGetSavingThrowCharacter() {
        val character = createCharacter(wizard, 5)
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.fortitudeModifier = 1
        character.reflexModifier = 2
        character.willModifier = 3
        var savingThrow = ruleService.getSave(character, Save.FORTITUDE)
        Assert.assertEquals(3, savingThrow.toLong())
        savingThrow = ruleService.getSave(character, Save.REFLEX)
        Assert.assertEquals(5, savingThrow.toLong())
        savingThrow = ruleService.getSave(character, Save.WILL)
        Assert.assertEquals(10, savingThrow.toLong())
    }

    @Test
    fun testGetSavingThrowMultiClassCharacter() {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels
        character.constitution = 12
        character.dexterity = 14
        character.wisdom = 16
        character.fortitudeModifier = 1
        character.reflexModifier = 2
        character.willModifier = 3

        // Ranger(4) + Rogue(3) + Constitution + modifier = +4 +1 +1 +1 = 7
        var savingThrow = ruleService.getSave(character, Save.FORTITUDE)
        Assert.assertEquals(7, savingThrow.toLong())

        // Ranger(4) + Rogue(3) + Constitution + modifier = +4 +3 +2 +2 = 11
        savingThrow = ruleService.getSave(character, Save.REFLEX)
        Assert.assertEquals(11, savingThrow.toLong())

        // Ranger(4) + Rogue(3) + Constitution = +1 +1 +3 +3 = 8
        savingThrow = ruleService.getSave(character, Save.WILL)
        Assert.assertEquals(8, savingThrow.toLong())
    }

    @Test
    fun testGetBaseSaveMultiCharacter() {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))
        character.classLevels = classLevels

        // Ranger(4) + Rogue(3) = +4 +1 = 5
        var savingThrow = ruleService.getBaseSave(character, Save.FORTITUDE)
        Assert.assertEquals(5, savingThrow.toLong())

        // Ranger(4) + Rogue(3) = +4 +3 = 7
        savingThrow = ruleService.getBaseSave(character, Save.REFLEX)
        Assert.assertEquals(7, savingThrow.toLong())

        // Ranger(4) + Rogue(3) = +1 +1 = 2
        savingThrow = ruleService.getBaseSave(character, Save.WILL)
        Assert.assertEquals(2, savingThrow.toLong())
    }
}