package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Presentation of damage. Damage consists of several damage parts. Each damage part consists of a die and number of
 * many time to roll that die. In addition the bonus is added once.
 */
public class Damage implements Serializable {

  private static final long serialVersionUID = 1L;

  private int numberOfDice;
  private Die die;

  /**
   * Creates a DamagePart instance with number of dice, and bonus set to 0 and die to null.
   */
  public Damage() {
    super();
  }

  /**
   * Creates a DamagePart with the given parameters.
   *
   * @param numberOfDice
   *     The number of dice to roll.
   * @param die
   *     The kind of die to roll.
   */
  public Damage(final int numberOfDice, final Die die) {
    this.numberOfDice = numberOfDice;
    this.die = die;
  }

  /**
   * Returns the number of dice to roll.
   *
   * @return The number of dice to roll.
   */
  public int getNumberOfDice() {
    return numberOfDice;
  }

  /**
   * Sets the number of dice to roll.
   *
   * @param numberOfDice
   *     The number of dice to roll.
   */
  public void setNumberOfDice(final int numberOfDice) {
    this.numberOfDice = numberOfDice;
  }

  /**
   * Returns the kind of die to roll.
   *
   * @return The kind of die to roll.
   */
  public Die getDie() {
    return die;
  }

  /**
   * Sets the die to roll.
   *
   * @param die
   *     The kind of die to roll.
   */
  public void setDie(final Die die) {
    this.die = die;
  }

  /**
   * Rolls the number of dice and sums them up.
   *
   * @return The sum of the rolled dice.
   */
  public int roll() {
    return die.roll(numberOfDice);
  }

  @Override
  public String toString() {
    return numberOfDice + die.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((die == null) ? 0 : die.hashCode());
    result = prime * result + numberOfDice;
    return result;
  }

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
    final Damage other = (Damage) obj;
    if (die != other.die) {
      return false;
    }
    return numberOfDice == other.numberOfDice;
  }

}
