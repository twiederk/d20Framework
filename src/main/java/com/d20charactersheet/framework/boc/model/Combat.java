package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Stores the combat values of a character.
 */
public class Combat implements Serializable {

  private static final long serialVersionUID = 3574392152471971346L;

  private int hitPoints;
  private int maxHitPoints;
  private int armor;
  private int initiativeModifier;
  private int cmbModifier;
  private int cmdModifier;

  /**
   * Returns the current hit points.
   *
   * @return The current hit points.
   */
  public int getHitPoints() {
    return hitPoints;
  }

  /**
   * Sets the hit points.
   *
   * @param hitPoints
   *     The hit points to set.
   */
  public void setHitPoints(final int hitPoints) {
    this.hitPoints = hitPoints;
  }

  /**
   * Returns the maximum of hit points.
   *
   * @return The maximum of hit points.
   */
  public int getMaxHitPoints() {
    return maxHitPoints;
  }

  /**
   * Sets the maximum hit points.
   *
   * @param maxHitPoints
   *     The maximum hit points.
   */
  public void setMaxHitPoints(final int maxHitPoints) {
    this.maxHitPoints = maxHitPoints;
  }

  /**
   * Returns the armor class.
   *
   * @return The armor class.
   */
  public int getArmorClass() {
    return armor;
  }

  /**
   * Sets the armor class.
   *
   * @param armor
   *     The armor class.
   */
  public void setArmorClass(final int armor) {
    this.armor = armor;
  }

  /**
   * Returns the modifier of the initiative.
   *
   * @return The modifier of the initiative.
   */
  public int getInitiativeModifier() {
    return initiativeModifier;
  }

  /**
   * Sets the modifier of the initiative.
   *
   * @param initiativeModifier
   *     The modifier of the initiative.
   */
  public void setInitiativeModifier(final int initiativeModifier) {
    this.initiativeModifier = initiativeModifier;
  }

  /**
   * Sets the Combat Maneuver Bonus modifier.
   *
   * @param cmbModifier
   *     The CMB to set
   */
  public void setCmbModifier(final int cmbModifier) {
    this.cmbModifier = cmbModifier;
  }

  /**
   * Returns the Combat Maneuver Bonus modifier
   *
   * @return The CMB
   */
  public int getCmbModifier() {
    return cmbModifier;
  }

  /**
   * Returns the Combat Maneuver Defence modifier.
   *
   * @return The Combat Maneuver Defence modifier.
   */
  public int getCmdModifier() {
    return cmdModifier;
  }

  /**
   * Sets the Combat Maneuver Defence modifier.
   *
   * @param cmdModifier
   *     The CMD
   */
  public void setCmdModifier(final int cmdModifier) {
    this.cmdModifier = cmdModifier;
  }

}
