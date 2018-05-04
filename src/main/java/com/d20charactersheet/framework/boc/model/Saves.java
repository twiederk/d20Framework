package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Stores the modifier of each save (fortitude, reflex, will).
 */
public class Saves implements Serializable {

  private static final long serialVersionUID = 5516292153276782587L;

  private int fortitudeModifier;
  private int reflexModifier;
  private int willModifier;

  /**
   * Returns fortitude modifier.
   *
   * @return Fortitude modifier.
   */
  public int getFortitudeModifier() {
    return fortitudeModifier;
  }

  /**
   * Sets the fortitude modifier.
   *
   * @param fortitudeModifier
   *     The modifier to set.
   */
  public void setFortitudeModifier(final int fortitudeModifier) {
    this.fortitudeModifier = fortitudeModifier;
  }

  /**
   * Returns reflex modifier.
   *
   * @return reflex modifier.
   */
  public int getReflexModifier() {
    return reflexModifier;
  }

  /**
   * Sets the reflex modifier.
   *
   * @param reflexModifier
   *     The modifier to set.
   */
  public void setReflexModifier(final int reflexModifier) {
    this.reflexModifier = reflexModifier;
  }

  /**
   * Returns will modifier.
   *
   * @return will modifier.
   */
  public int getWillModifier() {
    return willModifier;
  }

  /**
   * Sets the will modifier.
   *
   * @param willModifier
   *     The modifier to set.
   */
  public void setWillModifier(final int willModifier) {
    this.willModifier = willModifier;
  }

}
