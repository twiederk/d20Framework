package com.d20charactersheet.framework.boc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DieRollTest {

  @Test
  public void testGetResult() {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setRolls(new int[] {1, 2, 3});
    dieRoll.setBonus(10);
    assertEquals(16, dieRoll.getResult());
  }

}
