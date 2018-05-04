package com.d20charactersheet.framework.dac.abilitybuilder;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.ExtraFeatsAbility;

/**
 * Creates ExtraFeatsAbility out of AbilityConfig. Property with key "number_of_extra_feats" requires a positive integer
 * as value.
 */
public class ExtraFeatsAbilityBuilder extends DefaultAbilityBuilder {

  /**
   * The key to store the number of extra feats of the ability
   */
  public static final String KEY_NUMBER_OF_EXTRA_FEATS = "number_of_extra_feats";

  @Override
  public Ability createAbility(final AbilityConfig abilityConfig) {
    final ExtraFeatsAbility ability = new ExtraFeatsAbility();
    fillAbility(ability, abilityConfig);
    final int numberOfFeats = getInt(abilityConfig, KEY_NUMBER_OF_EXTRA_FEATS);
    ability.setNumberOfFeats(numberOfFeats);
    return ability;
  }

}
