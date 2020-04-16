package com.d20charactersheet.framework.dac.abilitybuilder;

import com.d20charactersheet.framework.boc.model.Ability;

/**
 * Creates an Ability instance out of an AbilityConfig.
 */
public interface AbilityBuilder {

  /**
   * Creates an Ability instance out of an AbilityConfig.
   *
   * @param abilityConfig
   *     The given AbilityConfig.
   *
   * @return The created Ability instance.
   */
  Ability createAbility(AbilityConfig abilityConfig);
}
