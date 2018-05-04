package com.d20charactersheet.framework.boc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

  @Test
  public void testEqualsObject() {
    final Weapon weapon1 = new Weapon();
    weapon1.setId(1);
    final Weapon weapon2 = new Weapon();
    weapon2.setId(2);

    final Armor armor1 = new Armor();
    armor1.setId(1);
    final Armor armor2 = new Armor();
    armor2.setId(2);

    final Good good1 = new Good();
    good1.setId(1);
    final Good good2 = new Good();
    good2.setId(2);

    assertTrue(weapon1.equals(weapon1));
    assertFalse(weapon1.equals(weapon2));
    assertFalse(weapon1.equals(armor1));
    assertFalse(weapon1.equals(good1));

    assertTrue(armor1.equals(armor1));
    assertFalse(armor1.equals(armor2));
    assertFalse(armor1.equals(weapon1));
    assertFalse(armor1.equals(good1));

    assertTrue(good1.equals(good1));
    assertFalse(good1.equals(good2));
    assertFalse(good1.equals(weapon1));
    assertFalse(good1.equals(armor1));

  }

}
