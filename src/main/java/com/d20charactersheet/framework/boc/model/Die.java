package com.d20charactersheet.framework.boc.model;

import java.util.EnumSet;
import java.util.Random;

/**
 * Enumeration of all available dice.
 */
public enum Die {

  /**
   * 2-sided die
   */
  D2,

  /**
   * 3-sided die
   */
  D3,

  /**
   * 4-sided die
   */
  D4,

  /**
   * 6-sided die
   */
  D6,

  /**
   * 8-sided die
   */
  D8,

  /**
   * 10-sided die
   */
  D10,

  /**
   * 12-sided die
   */
  D12,

  /**
   * 20-sided die
   */
  D20,

  /**
   * 100-sided die
   */
  D100;

  private static Random random = new Random(System.currentTimeMillis());

  /**
   * Dice available for hit die of character classes.
   */
  public static final EnumSet<Die> HIT_DICE = EnumSet.of(D4, D6, D8, D10, D12);

  public static void setRandom(Random random) {
    Die.random = random;
  }

  /**
   * Rolls the die once.
   *
   * @return The result of the die roll.
   */
  public int roll() {
    return random.nextInt(this.max()) + 1;
  }

  /**
   * Rolls the die as many times as the given number.
   *
   * @param numberOfDice
   *     The number of times to roll the die.
   *
   * @return The sum of the rolled dice.
   */
  public int roll(final int numberOfDice) {
    int result = 0;
    for (int i = 0; i < numberOfDice; i++) {
      result = result + roll();
    }
    return result;
  }

  /**
   * Returns the max value of the die.
   *
   * @return The max value of the die.
   */
  public int max() {
    switch (this) {
      case D2:
        return 2;
      case D3:
        return 3;
      case D4:
        return 4;
      case D6:
        return 6;
      case D8:
        return 8;
      case D10:
        return 10;
      case D12:
        return 12;
      case D20:
        return 20;
      case D100:
        return 100;
      default:
        throw new IllegalArgumentException("Can't get max of: " + this);
    }

  }
}
