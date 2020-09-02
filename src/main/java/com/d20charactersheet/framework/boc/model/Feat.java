package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Feat with base information supplied in the player handbook.
 */
public class Feat implements Serializable {

  private static final long serialVersionUID = -1914680755705031710L;

  private int id;

  private String name;
  private String benefit;
  private String prerequisit;
  private FeatType featType;
  private boolean fighterBonus;
  private boolean multiple;
  private boolean stack;
  private int spellSlot;

  /**
   * Returns the benefit of the feat.
   *
   * @return The benefit of the feat.
   */
  public String getBenefit() {
    return benefit;
  }

  /**
   * Returns the type of the feat.
   *
   * @return The type of the feat.
   */
  public FeatType getFeatType() {
    return featType;
  }

  /**
   * Returns the id of the feat.
   *
   * @return The id of the feat.
   */
  public int getId() {
    return id;
  }

  /**
   * Returns the name of the feat.
   *
   * @return The name of the feat.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the prerequisit of the feat.
   *
   * @return The prerequisit of the feat.
   */
  public String getPrerequisit() {
    return prerequisit;
  }

  /**
   * Returns true, if feat is fighter bonus feat.
   *
   * @return True, if feat is fighter bonus feat.
   */
  public boolean isFighterBonus() {
    return fighterBonus;
  }

  /**
   * Sets the benefit of the feat.
   *
   * @param benefit
   *     The benefit to set.
   */
  public void setBenefit(final String benefit) {
    this.benefit = benefit;

  }

  /**
   * Sets the type of the feat.
   *
   * @param featType
   *     The type to set.
   */
  public void setFeatType(final FeatType featType) {
    this.featType = featType;
  }

  /**
   * Set true for fighter bonus feat.
   *
   * @param fighterBonus
   *     True, for fighter bonus feat.
   */
  public void setFighterBonus(final boolean fighterBonus) {
    this.fighterBonus = fighterBonus;
  }

  /**
   * Sets the id of the feat.
   *
   * @param id
   *     The id.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Sets the name.
   *
   * @param name
   *     The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the prerequisit of the feat.
   *
   * @param prerequisit
   *     The prerequisit to set.
   */
  public void setPrerequisit(final String prerequisit) {
    this.prerequisit = prerequisit;
  }

  /**
   * Returns true, if feat can be gained multiple times.
   *
   * @return True, if feat can be gained multiple times.
   */
  public boolean isMultiple() {
    return multiple;
  }

  /**
   * Returns true, if feat effect is cumulative.
   *
   * @return True, if feat effect is cumulative.
   */
  public boolean isStack() {
    return stack;
  }

  /**
   * Set true, for feat which can be gained multiple times.
   *
   * @param multiple
   *     True, for feat whicht can be gained multiple times.
   */
  public void setMultiple(final boolean multiple) {
    this.multiple = multiple;

  }

  /**
   * Set true, if feat effect is cumulative.
   *
   * @param stack
   *     True, if feat effect is cumulative.
   */
  public void setStack(final boolean stack) {
    this.stack = stack;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /**
   * Feats with the same id are equal.
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Feat other = (Feat) obj;
    return id == other.id;
  }

  /**
   * Returns number of spell slots required by the feat.
   *
   * @return Number of spell slots required by the feat.
   */
  public int getSpellSlot() {
    return spellSlot;
  }

  /**
   * Sets the number of spell slots required by the feat.
   *
   * @param spellSlot
   *     The number of spell slots required by the feat.
   */
  public void setSpellSlot(final int spellSlot) {
    this.spellSlot = spellSlot;
  }

}
