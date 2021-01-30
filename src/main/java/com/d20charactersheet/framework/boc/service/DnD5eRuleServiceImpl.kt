package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class DnD5eRuleServiceImpl : AbstractRuleServiceImpl() {

    override fun getName(): String = "DnD 5e"

    override fun getMaxClassSkillRank(character: Character?): Int {
        TODO("Not yet implemented function body")
    }

    override fun getMaxCrossClassSkillRank(character: Character?): Float {
        TODO("Not yet implemented function body")
    }

    override fun getSkillPoints(character: Character?, startClass: CharacterClass?): Int {
        TODO("Not yet implemented function body")
    }

    override fun getSkillModifier(character: Character?, characterSkill: CharacterSkill?): Int {
        TODO("Not yet implemented function body")
    }

    override fun getSpentSkillPoints(character: Character?): Int {
        TODO("Not yet implemented function body")
    }

    override fun getSpecialSizeModifier(size: Size?): Int {
        TODO("Not yet implemented function body")
    }

    override fun getRankPerSkillPoint(character: Character?, skill: Skill?): Float {
        TODO("Not yet implemented function body")
    }

    override fun getNumberOfClassFeats(character: Character?): Int {
        TODO("Not yet implemented function body")
    }

}
