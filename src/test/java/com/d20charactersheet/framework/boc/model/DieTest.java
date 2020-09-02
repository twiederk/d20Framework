package com.d20charactersheet.framework.boc.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DieTest {

  @Test
  public void testRollDie() {
    for (final Die die : Die.values()) {
      assertDie(die);
    }
  }

  private void assertDie(final Die die) {
    for (int i = 0; i < 10; i++) {
      final int result = die.roll();
      assertTrue(die + " roll to low", result > 0);
      assertTrue(die + " roll to high", result <= die.max());
    }
  }

  @Test
  public void testRollDice() {
    for (final Die die : Die.values()) {
      assertDice(die);
    }
  }

  private void assertDice(final Die die) {
    for (int i = 0; i < 10; i++) {
      final int result = die.roll(3);
      assertTrue(result >= 3);
      assertTrue(result <= 3 * die.max());

    }
  }

}
