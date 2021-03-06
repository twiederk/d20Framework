package com.d20charactersheet.framework.dac.abilitybuilder

import com.d20charactersheet.framework.boc.model.Ability

/**
 * Creates an Ability instance out of an AbilityConfig.
 */
interface AbilityBuilder {

    /**
     * Creates an Ability instance out of an AbilityConfig.
     *
     * @param abilityConfig
     * The given AbilityConfig.
     *
     * @return The created Ability instance.
     */
    fun createAbility(abilityConfig: AbilityConfig): Ability
}