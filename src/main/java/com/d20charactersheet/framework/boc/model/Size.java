package com.d20charactersheet.framework.boc.model;

/**
 * The size of a creature.
 */
public enum Size {

  /**
   * Fine
   */
  FINE(0.5f, 0),

  /**
   * Diminutive
   */
  DIMINUTIVE(1.0f, 0),

  /**
   * Tiny
   */
  TINY(2.5f, 0),

  /**
   * Small
   */
  SMALL(5.0f, 5),

  /**
   * Medium
   */
  MEDIUM(5.0f, 5),

  /**
   * Large (tall)
   */
  LARGE_TALL(10.0f, 10),

  /**
   * Large (long)
   */
  LARGE_LONG(10.0f, 5),

  /**
   * Huge (tall)
   */
  HUGE_TALL(15.0f, 15),

  /**
   * Huge (long)
   */
  HUGE_LONG(15.0f, 10),

  /**
   * Gargantuan (tall)
   */
  GARGANTUAN_TALL(20.0f, 20),

  /**
   * Gargantuan (long)
   */
  GARGANTUAN_LONG(20.0f, 15),

  /**
   * Colossal (tall)
   */
  COLOSSAL_TALL(30.0f, 30),

  /**
   * Colossal (long)
   */
  COLOSSAL_LONG(30.0f, 20);

  private final float space;
  private final int reach;

  Size(final float space, final int reach) {
    this.space = space;
    this.reach = reach;
  }

  /**
   * Returns the space occupied by creature in feet.
   *
   * @return The space occupied by creature in feet.
   */
  public float getSpace() {
    return space;
  }

  /**
   * Returns the reach distance of the creature in feet.
   *
   * @return The reach distance of the creature in feet.
   */
  public int getReach() {
    return reach;
  }

}
