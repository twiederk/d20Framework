package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.CharacterSkill
import org.junit.Assert
import org.junit.jupiter.api.Test

class PathfinderRuleServiceSkillTest : PathfinderRuleServiceTestCase() {

    @Test
    fun testGetMaxClassSkillRank() {
        val maxClassSkillRank = ruleService.getMaxClassSkillRank(valeros)
        Assert.assertEquals(1, maxClassSkillRank.toLong())
    }

    @Test
    fun testGetMaxCrossClassSkillRank() {
        val maxCrossClassSkillRank = ruleService.getMaxCrossClassSkillRank(valeros)
        Assert.assertEquals(1.0f, maxCrossClassSkillRank, 0.0f)
    }

    @Test
    fun testGetSkillModifierWithClassSkill() {
        assertCharacterSkill(3, "Acrobatics")
    }

    @Test
    fun testGetSkillModifierWithClassSkillNoRank() {
        assertCharacterSkill(0, "Perform")
    }

    @Test
    fun testGetSkillModifierWithCrossClassSkill() {
        assertCharacterSkill(0, "Perception")
    }

    private fun assertCharacterSkill(exceptedSkillModifier: Int, skillName: String) {
        val characterSkill = getSkill(skillName, valeros)
        val skillModifier = ruleService.getSkillModifier(valeros, characterSkill)
        Assert.assertEquals(exceptedSkillModifier.toLong(), skillModifier.toLong())
    }

    private fun getSkill(name: String, character: Character): CharacterSkill {
        for (characterSkill in character.characterSkills) {
            if (characterSkill.skill.name == name) {
                return characterSkill
            }
        }
        throw IllegalArgumentException("Can't find character skill with name: $name")
    }

    @Test
    fun testGetSkillPoints() {
        val skillPoints = ruleService.getSkillPoints(valeros, CharacterClass())
        Assert.assertEquals(4, skillPoints.toLong())
    }
}