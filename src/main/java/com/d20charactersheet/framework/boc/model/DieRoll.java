package com.d20charactersheet.framework.boc.model;

/**
 * Represents the result of a die roll. The same die is rolled a specific number of times and a bonus is added once.
 */
public class DieRoll {

  private Die die;
  private int[] rolls;
  private int bonus;

  /**
   * Returns the rolled die.
   *
   * @return The rolled die.
   */
  public Die getDie() {
    return die;
  }

  /**
   * Sets the rolled die.
   *
   * @param die
   *     The rolled die.
   */
  public void setDie(final Die die) {
    this.die = die;
  }

  /**
   * Returns the single results of the separate die rolls.
   *
   * @return The single results of the separate die rolls.
   */
  public int[] getRolls() {
    return rolls;
  }

  /**
   * Sets the die roll results
   *
   * @param rolls
   *     The die roll results.
   */
  public void setRolls(final int[] rolls) {
    this.rolls = rolls;
  }

  /**
   * Returns the bonus to add.
   *
   * @return The bonus to add.
   */
  public int getBonus() {
    return bonus;
  }

  /**
   * Sets the bonus to add.
   *
   * @param bonus
   *     The bonus to add.
   */
  public void setBonus(final int bonus) {
    this.bonus = bonus;
  }

  /**
   * Returns the result of the complete die roll.
   *
   * @return The result of the complete die roll.
   */
  public int getResult() {
    int result = 0;
    for (int roll : rolls) {
      result = result + roll;
    }
    result = result + bonus;
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder output = new StringBuilder();
    output.append(die);
    output.append(", [ ");
    for (int i = 0; i < rolls.length; i++) {
      output.append(rolls[i]);
      if (i + 1 < rolls.length) {
        output.append(", ");
      }
    }
    output.append(" ], ");
    output.append(bonus);
    output.append(" = ");
    output.append(getResult());
    return output.toString();
  }
}
