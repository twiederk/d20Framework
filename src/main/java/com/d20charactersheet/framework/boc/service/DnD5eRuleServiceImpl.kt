package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class DnD5eRuleServiceImpl : AbstractRuleServiceImpl() {

    override fun getMaxClassSkillRank(character: Character?): Int {
        return 0
    }

    override fun getMaxCrossClassSkillRank(character: Character?): Float {
        return 0.0f
    }

    override fun getSkillPoints(character: Character?, startClass: CharacterClass?): Int {
        return 0
    }

    override fun getSkillModifier(character: Character?, characterSkill: CharacterSkill?): Int {
        return 0
    }

    override fun getSpentSkillPoints(character: Character?): Int {
        return 0
    }

    override fun getSpecialSizeModifier(size: Size?): Int {
        return 0
    }

    override fun getRankPerSkillPoint(character: Character?, skill: Skill?): Float {
        return 0.0f
    }

    override fun calculateProficiencyBonus(character: Character): Int {
        val levelTotal = character.classLevels.map { classLevel -> classLevel.level }.sum()
        return levelTotal / 4 + 2
    }

    override fun getNumberOfClassFeats(character: Character?): Int {
        return 0
    }

}
