package com.d20charactersheet.framework.dac.abilitybuilder

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.ExtraFeatsAbility

/**
 * Creates ExtraFeatsAbility out of AbilityConfig. Property with key "number_of_extra_feats" requires a positive integer
 * as value.
 */
class ExtraFeatsAbilityBuilder : DefaultAbilityBuilder() {
    override fun createAbility(abilityConfig: AbilityConfig): Ability {
        val ability = ExtraFeatsAbility()
        fillAbility(ability, abilityConfig)
        val numberOfFeats = getInt(abilityConfig, KEY_NUMBER_OF_EXTRA_FEATS)
        ability.numberOfFeats = numberOfFeats
        return ability
    }

    companion object {
        /**
         * The key to store the number of extra feats of the ability
         */
        const val KEY_NUMBER_OF_EXTRA_FEATS = "number_of_extra_feats"
    }
}