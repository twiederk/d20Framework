package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * An ability which is assigned to a class and gained by a specific level.
 */
public class ClassAbility implements Serializable {

  private static final long serialVersionUID = -8203011281464947116L;

  private final Ability ability;
  private int level;

  /**
   * Creates ClassAbility with given ability.
   *
   * @param ability
   *     The ability of the class.
   */
  public ClassAbility(final Ability ability) {
    this.ability = ability;
  }

  /**
   * Returns the ability.
   *
   * @return The ability.
   */
  public Ability getAbility() {
    return ability;
  }

  /**
   * Returns the level the ability is gained.
   *
   * @return The level the ability is gained.
   */
  public int getLevel() {
    return level;
  }

  /**
   * Sets the level the ability is gained.
   *
   * @param level
   *     The level the ability is gained.
   */
  public void setLevel(final int level) {
    this.level = level;
  }

  @Override
  public String toString() {
    return ability.getName() + " (" + level + ")";

  }

}
