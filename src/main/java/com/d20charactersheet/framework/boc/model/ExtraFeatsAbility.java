package com.d20charactersheet.framework.boc.model;

/**
 * The ExtraFeatsAbility allows to get a number of additional feats.
 */
public class ExtraFeatsAbility extends Ability {

  private static final long serialVersionUID = 1L;

  private int numberOfFeats;

  /**
   * Returns the number of additional feats.
   *
   * @return The number of additional feats.
   */
  public int getNumberOfFeats() {
    return numberOfFeats;
  }

  /**
   * Sets the number of additional feats.
   *
   * @param numberOfFeats
   *     The number of additional feats.
   */
  public void setNumberOfFeats(final int numberOfFeats) {
    this.numberOfFeats = numberOfFeats;
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
