package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Money
import org.junit.Assert
import org.junit.jupiter.api.Test

class DnDv35RuleServiceMoneyTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetMoney() {
        val money = Money()
        money.platinum = 1
        money.gold = 2
        money.silver = 3
        money.copper = 4
        val character = createCharacter(fighter, 1)
        character.money = money
        val gold = ruleService.getGold(character)
        Assert.assertEquals(12.34f, gold, 0.0f)
    }
}