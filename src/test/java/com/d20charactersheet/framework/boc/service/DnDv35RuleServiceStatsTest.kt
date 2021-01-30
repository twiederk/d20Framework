package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.util.*

class DnDv35RuleServiceStatsTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetModifierNegativeValue() {
        try {
            ruleService.getModifier(-1)
            Assert.fail("No exception thrown (expected IllegalArgumentException)")
        } catch (illegalArgumentException: IllegalArgumentException) {
            // expected exception catched
        } catch (e: Exception) {
            Assert.fail("Wrong exception thrown (expected IllegalArgumentException)")
        }
    }

    @Test
    fun testGetModifier() {
        // value: 1 => modifier -5
        var modifier = ruleService.getModifier(1)
        Assert.assertEquals(-5, modifier.toLong())

        // value: 5 => modifier -3
        modifier = ruleService.getModifier(5)
        Assert.assertEquals(-3, modifier.toLong())

        // value: 6 => modifier -2
        modifier = ruleService.getModifier(6)
        Assert.assertEquals(-2, modifier.toLong())

        // value: 10 => modifier 0
        modifier = ruleService.getModifier(10)
        Assert.assertEquals(0, modifier.toLong())

        // value: 11 => modifier 0
        modifier = ruleService.getModifier(11)
        Assert.assertEquals(0, modifier.toLong())

        // value: 12 => modifier +1
        modifier = ruleService.getModifier(12)
        Assert.assertEquals(1, modifier.toLong())

        // value: 15 => modifier +2
        modifier = ruleService.getModifier(15)
        Assert.assertEquals(2, modifier.toLong())

        // value: 16 => modifier +3
        modifier = ruleService.getModifier(16)
        Assert.assertEquals(3, modifier.toLong())

        // value: 20 => modifier +5
        modifier = ruleService.getModifier(20)
        Assert.assertEquals(5, modifier.toLong())

        // value: 45 => modifier +17
        modifier = ruleService.getModifier(45)
        Assert.assertEquals(17, modifier.toLong())
    }

    @Test
    fun testGetBaseAttackBonusOfSingleClass() {

        // Fighter (good), level 1 => 1
        var character = createCharacter(fighter, 1)
        var baseAttackBonus = ruleService.getBaseAttackBonus(character)
        Assert.assertEquals(1, baseAttackBonus.toLong())

        // Fighter (good), level 6 => 6
        character = createCharacter(fighter, 6)
        baseAttackBonus = ruleService.getBaseAttackBonus(character)
        Assert.assertEquals(6, baseAttackBonus.toLong())

        // Fighter (good), level 11 => 11
        character = createCharacter(fighter, 11)
        baseAttackBonus = ruleService.getBaseAttackBonus(character)
        Assert.assertEquals(11, baseAttackBonus.toLong())
    }

    @Test
    fun testGetBaseAttackBonusMultiClass() {
        val classLevels: MutableList<ClassLevel> = LinkedList()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(druid, 6))
        val character = Character()
        character.classLevels = classLevels

        // Ranger (4), Druid (6) => 8
        var baseAttackBonus = ruleService.getBaseAttackBonus(character)
        Assert.assertEquals(8, baseAttackBonus.toLong())
        classLevels.clear()
        classLevels.add(ClassLevel(ranger, 4))
        classLevels.add(ClassLevel(rogue, 3))

        // Ranger (4), Rogue (3) => 6
        baseAttackBonus = ruleService.getBaseAttackBonus(character)
        Assert.assertEquals(6, baseAttackBonus.toLong())
    }

    @Test
    fun testGetGoodBaseAttackBonus() {
        val abstractRuleServiceImpl = ruleService as AbstractRuleServiceImpl
        Assert.assertEquals(1, abstractRuleServiceImpl.getGoodBaseAttackBonus(1).toLong())
        Assert.assertEquals(6, abstractRuleServiceImpl.getGoodBaseAttackBonus(6).toLong())
        Assert.assertEquals(11, abstractRuleServiceImpl.getGoodBaseAttackBonus(11).toLong())
    }

    @Test
    fun testGetAverageAttackBonus() {
        val abstractRuleServiceImpl = ruleService as AbstractRuleServiceImpl
        Assert.assertEquals(0, abstractRuleServiceImpl.getAverageBaseAttackBonus(1).toLong())
        Assert.assertEquals(1, abstractRuleServiceImpl.getAverageBaseAttackBonus(2).toLong())
        Assert.assertEquals(2, abstractRuleServiceImpl.getAverageBaseAttackBonus(3).toLong())
        Assert.assertEquals(3, abstractRuleServiceImpl.getAverageBaseAttackBonus(4).toLong())
        Assert.assertEquals(3, abstractRuleServiceImpl.getAverageBaseAttackBonus(5).toLong())
        Assert.assertEquals(4, abstractRuleServiceImpl.getAverageBaseAttackBonus(6).toLong())
        Assert.assertEquals(5, abstractRuleServiceImpl.getAverageBaseAttackBonus(7).toLong())
        Assert.assertEquals(6, abstractRuleServiceImpl.getAverageBaseAttackBonus(8).toLong())
        Assert.assertEquals(6, abstractRuleServiceImpl.getAverageBaseAttackBonus(9).toLong())
        Assert.assertEquals(7, abstractRuleServiceImpl.getAverageBaseAttackBonus(10).toLong())
        Assert.assertEquals(11, abstractRuleServiceImpl.getAverageBaseAttackBonus(15).toLong())
    }

    @Test
    fun testGetPoorAttackBonus() {
        val abstractRuleServiceImpl = ruleService as AbstractRuleServiceImpl
        Assert.assertEquals(0, abstractRuleServiceImpl.getPoorBaseAttackBonus(1).toLong())
        Assert.assertEquals(1, abstractRuleServiceImpl.getPoorBaseAttackBonus(2).toLong())
        Assert.assertEquals(1, abstractRuleServiceImpl.getPoorBaseAttackBonus(3).toLong())
        Assert.assertEquals(2, abstractRuleServiceImpl.getPoorBaseAttackBonus(4).toLong())
        Assert.assertEquals(2, abstractRuleServiceImpl.getPoorBaseAttackBonus(5).toLong())
        Assert.assertEquals(3, abstractRuleServiceImpl.getPoorBaseAttackBonus(6).toLong())
        Assert.assertEquals(3, abstractRuleServiceImpl.getPoorBaseAttackBonus(7).toLong())
        Assert.assertEquals(4, abstractRuleServiceImpl.getPoorBaseAttackBonus(8).toLong())
        Assert.assertEquals(4, abstractRuleServiceImpl.getPoorBaseAttackBonus(9).toLong())
        Assert.assertEquals(5, abstractRuleServiceImpl.getPoorBaseAttackBonus(10).toLong())
        Assert.assertEquals(7, abstractRuleServiceImpl.getPoorBaseAttackBonus(15).toLong())
    }

    @Test
    fun testGetInitative() {
        val character = Character()
        character.dexterity = 5
        character.initiativeModifier = 0
        Assert.assertEquals(-3, ruleService.getInitative(character).toLong())
        character.dexterity = 10
        character.initiativeModifier = 1
        Assert.assertEquals(1, ruleService.getInitative(character).toLong())
        character.dexterity = 15
        character.initiativeModifier = 2
        Assert.assertEquals(4, ruleService.getInitative(character).toLong())
        character.dexterity = 18
        character.initiativeModifier = 3
        Assert.assertEquals(7, ruleService.getInitative(character).toLong())
    }

    @Test
    fun testGetSpeed() {

        // Human, Fighter (1) => 30 feet
        var character = createCharacter(ClassLevel(fighter, 1), human)
        Assert.assertEquals(30, ruleService.getSpeed(character).toLong())

        // Gnome, Fighter (1) => 20 feet
        character = createCharacter(ClassLevel(fighter, 1), gnome)
        Assert.assertEquals(20, ruleService.getSpeed(character).toLong())

        // Human, Monk (1) => 30 feet
        character = createCharacter(ClassLevel(monk, 1), human)
        Assert.assertEquals(30, ruleService.getSpeed(character).toLong())
    }

    @Test
    fun testGetClassesWithSingleClassLevel() {
        val character = createCharacter(wizard, 5)
        val oppositeClasses = ruleService.getOppositeOfCharacterClasses(character, allClasses)
        Assert.assertEquals(26, oppositeClasses.size.toLong())
    }

    @Test
    fun testGetClassesWithThreeClassLevels() {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(wizard, 5))
        classLevels.add(ClassLevel(bard, 5))
        classLevels.add(ClassLevel(barbarian, 5))
        character.classLevels = classLevels
        val oppositeClasses = ruleService.getOppositeOfCharacterClasses(character, allClasses)
        Assert.assertEquals(24, oppositeClasses.size.toLong())
    }

    @Test
    fun testACLevel11() {
        val character = createCharacter(ClassLevel(fighter, 11), human)
        character.dexterity = 12
        val armorClass = ruleService.getArmorClass(character)
        Assert.assertEquals(11, armorClass.toLong())
    }

    @Test
    fun testGetCombatManeuverBonus() {
        // expectedCmb, class, level, race, strength, cmbModifier
        assertCmbScore(3, fighter, 1, human, 14, 0)
        assertCmbScore(6, fighter, 5, human, 10, 1)
        assertCmbScore(3, wizard, 6, elf, 11, 0)
    }

    @Test
    fun testGetCombatManeuverBonusMultiClass() {
        val character = createCharacter(ClassLevel(ranger, 4), ClassLevel(rogue, 4), human, 1)
        character.strength = 12
        val cmb = ruleService.getCombatManeuverBonus(character)
        Assert.assertEquals(8, cmb.toLong())
    }

    private fun assertCmbScore(
        expectedCmb: Int, characterClass: CharacterClass, level: Int, race: Race,
        strength: Int, cmbModifier: Int
    ) {
        val character = createCharacter(ClassLevel(characterClass, level), race)
        character.strength = strength
        character.cmbModifier = cmbModifier
        val cmb = ruleService.getCombatManeuverBonus(character)
        Assert.assertEquals(expectedCmb.toLong(), cmb.toLong())
    }

    @Test
    fun testGetSpecialSizeModifier() {
        try {
            for (size in Size.values()) {
                ruleService.getSpecialSizeModifier(size)
            }
        } catch (exception: Exception) {
            Assert.fail("Not all special size modifier could be determined")
        }
    }

    @Test
    fun testGetCombatDefenceModifier() {
        // expectedCmd, class, level, race, strength, dexterity, cmdModifier
        assertCmdScore(13, fighter, 1, human, 14, 10, 0)
        assertCmdScore(18, fighter, 5, human, 10, 14, 1)
        assertCmdScore(13, wizard, 6, elf, 11, 11, 0)
    }

    private fun assertCmdScore(
        expectedCmd: Int, characterClass: CharacterClass, level: Int, race: Race,
        strength: Int, dexterity: Int, cmdModifier: Int
    ) {
        val character = createCharacter(ClassLevel(characterClass, level), race)
        character.strength = strength
        character.dexterity = dexterity
        character.cmdModifier = cmdModifier
        val cmd = ruleService.getCombatManeuverDefence(character)
        Assert.assertEquals(expectedCmd.toLong(), cmd.toLong())
    }
}