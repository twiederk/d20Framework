package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * The moneybag of the character.
 */
public class Money implements Serializable {

  private static final long serialVersionUID = 6597644994818767460L;

  private int platinum;
  private int gold;
  private int silver;
  private int copper;

  /**
   * Returns the number of platinum coins.
   *
   * @return The number of platinum coins.
   */
  public int getPlatinum() {
    return platinum;
  }

  /**
   * Sets the number of the platinum coins.
   *
   * @param platinum
   *     Number of platinum coins to set.
   */
  public void setPlatinum(final int platinum) {
    this.platinum = platinum;
  }

  /**
   * Returns the number of gold coins.
   *
   * @return The number of gold coins.
   */
  public int getGold() {
    return gold;
  }

  /**
   * Sets the number of the gold coins.
   *
   * @param gold
   *     Number of gold coins to set.
   */
  public void setGold(final int gold) {
    this.gold = gold;
  }

  /**
   * Returns the number of silver coins.
   *
   * @return The number of silver coins.
   */
  public int getSilver() {
    return silver;
  }

  /**
   * Sets the number of the silver coins.
   *
   * @param silver
   *     Number of silver coins to set.
   */
  public void setSilver(final int silver) {
    this.silver = silver;
  }

  /**
   * Returns the number of copper coins.
   *
   * @return The number of copper coins.
   */
  public int getCopper() {
    return copper;
  }

  /**
   * Sets the number of the copper coins.
   *
   * @param copper
   *     Number of copper coins to set.
   */
  public void setCopper(final int copper) {
    this.copper = copper;
  }

}
