package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Critical
import com.d20charactersheet.framework.boc.model.Damage
import com.d20charactersheet.framework.boc.model.Die
import com.d20charactersheet.framework.boc.model.DieRoll
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceRollTest {

    private lateinit var ruleService: RuleService

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService
    }

    @Test
    fun rollCritical_oneDamageDie_twiceDieRollOnceDamageBonus() {
        // arrange
        val critical = Critical(20, 2)

        // act
        val dieRoll = ruleService.rollCritical(Damage(1, Die.D4), 2, critical)

        // assert
        assertDieRoll(dieRoll, 2, Die.D4, 2)
    }

    @Test
    fun rollCritical_twoDamageDice_twiceDieRollOnceDamageBonus() {
        // arrange
        val critical = Critical(20, 2)

        // act
        val dieRoll = ruleService.rollCritical(Damage(2, Die.D8), 3, critical)

        // assert
        assertDieRoll(dieRoll, 4, Die.D8, 3)
    }

    private fun assertDieRoll(dieRoll: DieRoll, numberOfRolls: Int, die: Die, bonus: Int) {
        assertThat(dieRoll.die).`as`("Wrong die").isEqualTo(die)
        assertThat(dieRoll.rolls).`as`("Wrong number of rolls").hasSize(numberOfRolls)
        assertThat(dieRoll.bonus).`as`("Wrong bonus").isEqualTo(bonus)
        assertThat(dieRoll.result).`as`("Wrong result").isBetween(numberOfRolls + bonus, die.max() * numberOfRolls + bonus)
    }

}