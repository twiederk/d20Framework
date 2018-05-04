package com.d20charactersheet.framework.boc.model;

/**
 * The ExtraSkillPointsAbility adds additional skill points to the character.
 */
public class ExtraSkillPointsAbility extends Ability {

  private static final long serialVersionUID = 1L;

  private int skillPoints;

  /**
   * Returns the number of additional skill points.
   *
   * @return The number of additional skill points.
   */
  public int getSkillPoints() {
    return skillPoints;
  }

  /**
   * Sets the number of additional skill points.
   *
   * @param skillPoints
   *     The number of additional skill points.
   */
  public void setSkillPoints(final int skillPoints) {
    this.skillPoints = skillPoints;
  }

  @Override
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

}
