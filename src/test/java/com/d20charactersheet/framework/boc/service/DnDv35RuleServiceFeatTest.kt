package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.ClassLevel
import org.junit.Assert
import org.junit.jupiter.api.Test

class DnDv35RuleServiceFeatTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetNumberOfFeats() {
        val character = createCharacter(ClassLevel(wizard, 5), elf)
        var numberOfFeats = ruleService.getNumberOfFeats(character)
        Assert.assertEquals(2, numberOfFeats.toLong())
        character.race = human
        numberOfFeats = ruleService.getNumberOfFeats(character)
        Assert.assertEquals(3, numberOfFeats.toLong())
    }

    @Test
    fun testGetNumberOfFeatsMultiClass() {
        val character = createCharacter(ClassLevel(wizard, 5), ClassLevel(fighter, 2), human, 10)
        val numberOfFeats = ruleService.getNumberOfFeats(character)
        Assert.assertEquals(4, numberOfFeats.toLong())
    }
}