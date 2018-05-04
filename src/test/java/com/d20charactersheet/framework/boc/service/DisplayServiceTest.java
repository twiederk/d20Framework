package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.WeaponCategory;

public class DisplayServiceTest {

  private DisplayService displayService;

  @Before
  public void setUp() throws Exception {
    displayService = new SimpleDisplayService();
  }

  @Test
  public void testGetDisplayNoteShortText() {
    assertNote("", "");
    assertNote("Eine Zeile", "Eine Zeile");
    assertNote("Erste Zeile", "Erste Zeile\nZweite Zeile");
  }

  private void assertNote(final String expected, final String text) {
    final Note note = new Note();
    note.setText(text);
    final String noteShortText = displayService.getDisplayNoteFirstLine(note);
    assertEquals(expected, noteShortText);
  }

  @Test
  public void testGetDisplayDamage() throws Exception {
    String displayDamage = displayService.getDisplayDamage(createWeapon(new Damage(1, Die.D8), 2));
    assertEquals("1D8+2", displayDamage);

    displayDamage = displayService.getDisplayDamage(createWeapon(new Damage(1, Die.D4), -1));
    assertEquals("1D4-1", displayDamage);

    displayDamage = displayService.getDisplayDamage(createWeapon(new Damage(1, Die.D10), 0));
    assertEquals("1D10", displayDamage);

    displayDamage = displayService.getDisplayDamage(createWeapon(new Damage(0, Die.D2), 1));
    assertEquals("+1", displayDamage);

    displayDamage = displayService.getDisplayDamage(createWeapon(new Damage(0, Die.D2), 0));
    assertEquals("", displayDamage);
  }

  private Weapon createWeapon(final Damage damage, final int enhancementBonus) {
    final Weapon weapon = new Weapon();
    weapon.setDamage(damage);
    weapon.setEnhancementBonus(enhancementBonus);
    return weapon;
  }

  @Test
  public void testGetDisplayRangeIncrement() throws Exception {
    assertEquals("-", displayService.getDisplayRangeIncrement(0));
    assertEquals("10 Feet", displayService.getDisplayRangeIncrement(10));
    assertEquals("50 Feet", displayService.getDisplayRangeIncrement(50));
    assertEquals("120 Feet", displayService.getDisplayRangeIncrement(120));
  }

  @Test
  public void testGetDisplayAmmunitionProjectileWeapon() throws Exception {
    final Weapon weapon = new Weapon();
    weapon.setWeaponCategory(WeaponCategory.PROJECTILE_WEAPON);

    final WeaponAttack weaponAttack = new WeaponAttack();
    weaponAttack.setWeapon(weapon);
    weaponAttack.setAmmunition(0);
    assertEquals("0", displayService.getDisplayAmmunition(weaponAttack));

    weaponAttack.setAmmunition(10);
    assertEquals("10", displayService.getDisplayAmmunition(weaponAttack));
  }

  @Test
  public void testGetDisplayAmmunitionNormalWeapon() throws Exception {
    final Weapon weapon = new Weapon();
    weapon.setWeaponCategory(WeaponCategory.NORMAL_WEAPON);

    final WeaponAttack weaponAttack = new WeaponAttack();
    weaponAttack.setWeapon(weapon);
    weaponAttack.setAmmunition(0);
    assertEquals("-", displayService.getDisplayAmmunition(weaponAttack));

    weaponAttack.setAmmunition(10);
    assertEquals("-", displayService.getDisplayAmmunition(weaponAttack));
  }

}
