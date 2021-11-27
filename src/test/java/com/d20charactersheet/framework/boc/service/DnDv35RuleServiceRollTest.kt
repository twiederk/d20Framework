package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.junit.Assert
import org.junit.jupiter.api.Test

class DnDv35RuleServiceRollTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testRollAttack() {
        val dieRoll = ruleService.rollAttack(5)
        assertDieRoll(dieRoll, 1, Die.D20, 5)
    }

    @Test
    fun testRollDamage() {
        val dieRoll = ruleService.rollDamage(Damage(2, Die.D6), 3)
        assertDieRoll(dieRoll, 2, Die.D6, 3)
    }

    @Test
    fun testRollCritical() {
        val critical = Critical(20, 2)
        var dieRoll = ruleService.rollCritical(Damage(1, Die.D4), 2, critical)
        assertDieRoll(dieRoll, 2, Die.D4, 4)
        critical.multiplier = 3
        dieRoll = ruleService.rollCritical(Damage(1, Die.D4), 2, critical)
        assertDieRoll(dieRoll, 3, Die.D4, 6)
    }

    @Test
    fun testRollSkill() {
        val skill = Skill()
        skill.attribute = Attribute.STRENGTH
        val characterSkill = CharacterSkill(skill)
        characterSkill.modifier = 2
        characterSkill.rank = 1f
        val dieRoll = ruleService.rollSkill(belvador, characterSkill)
        assertDieRoll(dieRoll, 1, Die.D20, 3)
    }

    private fun assertDieRoll(dieRoll: DieRoll, numberOfRolls: Int, die: Die, bonus: Int) {
        Assert.assertNotNull(dieRoll)
        Assert.assertNotNull(dieRoll.rolls)
        Assert.assertNotNull(dieRoll.die)
        Assert.assertEquals(numberOfRolls.toLong(), dieRoll.rolls.size.toLong())
        Assert.assertEquals(die, dieRoll.die)
        Assert.assertEquals(bonus.toLong(), dieRoll.bonus.toLong())
        Assert.assertTrue(dieRoll.result >= numberOfRolls + bonus)
        Assert.assertTrue(dieRoll.result <= die.max() * numberOfRolls + bonus)
    }

    @Test
    fun testIsCritical() {
        val critical = Critical(20, 2)
        val dieRoll = DieRoll()
        dieRoll.rolls = intArrayOf(20)
        Assert.assertTrue(ruleService.isCritical(dieRoll, critical))
        dieRoll.rolls = intArrayOf(19)
        Assert.assertFalse(ruleService.isCritical(dieRoll, critical))
    }

    @Test
    fun testIsFumble() {
        val dieRoll = DieRoll()
        dieRoll.rolls = intArrayOf(1)
        Assert.assertTrue(ruleService.isFumble(dieRoll))
        dieRoll.rolls = intArrayOf(19)
        Assert.assertFalse(ruleService.isFumble(dieRoll))
    }

    @Test
    fun testRollAttribute() {
        val dieRoll = ruleService.rollAttribute(belvador, Attribute.INTELLIGENCE)
        assertDieRoll(dieRoll, 1, Die.D20, 4)
    }

    @Test
    fun testRollSave() {
        val dieRoll = ruleService.rollSave(belvador, Save.STRENGTH)
        assertDieRoll(dieRoll, 1, Die.D20, 4)
    }

    @Test
    fun testRollInitative() {
        val dieRoll = ruleService.rollInitative(belvador)
        assertDieRoll(dieRoll, 1, Die.D20, 4)
    }

    @Test
    fun testRollBaseAttackBonus() {
        val dieRoll = ruleService.rollBaseAttackBonus(belvador)
        assertDieRoll(dieRoll, 1, Die.D20, 2)
    }

    @Test
    fun testRollCombatManeuverBonus() {
        val dieRoll = ruleService.rollCombatManeuverBonus(belvador)
        assertDieRoll(dieRoll, 1, Die.D20, 2)
    }

    @Test
    fun testRollCombatManeuverDefence() {
        val dieRoll = ruleService.rollCombatManeuverDefence(belvador)
        assertDieRoll(dieRoll, 1, Die.D20, 16)
    }
}