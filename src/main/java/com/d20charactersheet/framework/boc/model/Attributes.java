package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * The attributes of D&D 3.5.
 */
public class Attributes implements Serializable {

  private static final long serialVersionUID = -2372825935084695715L;

  // attributes
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  /**
   * Returns the strength.
   *
   * @return The strength.
   */
  public int getStrength() {
    return strength;
  }

  /**
   * Sets the strength.
   *
   * @param strength The strength to set.
   */
  public void setStrength(final int strength) {
    this.strength = strength;
  }

  /**
   * Returns the dexterity.
   *
   * @return The dexterity.
   */
  public int getDexterity() {
    return dexterity;
  }

  /**
   * Sets the dexterity.
   *
   * @param dexterity
   *     The dexterity to set.
   */
  public void setDexterity(final int dexterity) {
    this.dexterity = dexterity;
  }

  /**
   * Returns the constitution.
   *
   * @return The constitution.
   */
  public int getConstitution() {
    return constitution;
  }

  /**
   * Sets the constitution.
   *
   * @param constitution
   *     The consitution to set.
   */
  public void setConstitution(final int constitution) {
    this.constitution = constitution;
  }

  /**
   * Returns the intelligence.
   *
   * @return The intelligence.
   */
  public int getIntelligence() {
    return intelligence;
  }

  /**
   * Sets the intelligence.
   *
   * @param intelligence
   *     The intelligence to set.
   */
  public void setIntelligence(final int intelligence) {
    this.intelligence = intelligence;
  }

  /**
   * Returns the wisdom.
   *
   * @return The wisdom.
   */
  public int getWisdom() {
    return wisdom;
  }

  /**
   * Sets the wisdom.
   *
   * @param wisdom
   *     The wisdom to set.
   */
  public void setWisdom(final int wisdom) {
    this.wisdom = wisdom;
  }

  /**
   * Returns the charisma.
   *
   * @return The charisma.
   */
  public int getCharisma() {
    return charisma;
  }

  /**
   * Sets the charisma.
   *
   * @param charisma
   *     The charisma to set.
   */
  public void setCharisma(final int charisma) {
    this.charisma = charisma;
  }

  /**
   * Returns the value of the given attribute.
   *
   * @param attribute
   *     The attribute to get the value of.
   *
   * @return The value of the given attribute.
   */
  public int getAttribute(final Attribute attribute) {
    switch (attribute) {
      case STRENGTH:
        return strength;
      case DEXTERITY:
        return dexterity;
      case CONSTITUTION:
        return constitution;
      case INTELLIGENCE:
        return intelligence;
      case WISDOM:
        return wisdom;
      case CHARISMA:
        return charisma;
      default:
        throw new IllegalArgumentException("Can't find attribute: " + attribute);
    }

  }

}
