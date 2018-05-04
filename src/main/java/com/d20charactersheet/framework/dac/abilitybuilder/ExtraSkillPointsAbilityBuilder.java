package com.d20charactersheet.framework.dac.abilitybuilder;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.ExtraSkillPointsAbility;

/**
 * Creates ExtaSkillPointsAbility with the given AbilityConfig. Property with key "number_of_skill_points" and positive
 * int as value requiqred.
 */
public class ExtraSkillPointsAbilityBuilder extends DefaultAbilityBuilder {

  /**
   * The key to store the number of skill points of the ability
   */
  public static final String KEY_NUMBER_OF_SKILL_POINTS = "number_of_skill_points";

  @Override
  public Ability createAbility(final AbilityConfig abilityConfig) {
    final ExtraSkillPointsAbility ability = new ExtraSkillPointsAbility();
    fillAbility(ability, abilityConfig);
    final int numberOfSkillPoints = getInt(abilityConfig, KEY_NUMBER_OF_SKILL_POINTS);
    ability.setSkillPoints(numberOfSkillPoints);
    return ability;
  }

}
