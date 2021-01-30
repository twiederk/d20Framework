package com.d20charactersheet.framework.dac.abilitybuilder

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.ExtraSkillPointsAbility

/**
 * Creates ExtraSkillPointsAbility with the given AbilityConfig. Property with key "number_of_skill_points" and positive
 * int as value required.
 */
class ExtraSkillPointsAbilityBuilder : DefaultAbilityBuilder() {
    override fun createAbility(abilityConfig: AbilityConfig): Ability {
        val ability = ExtraSkillPointsAbility()
        fillAbility(ability, abilityConfig)
        val numberOfSkillPoints = getInt(abilityConfig, KEY_NUMBER_OF_SKILL_POINTS)
        ability.skillPoints = numberOfSkillPoints
        return ability
    }

    companion object {
        /**
         * The key to store the number of skill points of the ability
         */
        const val KEY_NUMBER_OF_SKILL_POINTS = "number_of_skill_points"
    }
}