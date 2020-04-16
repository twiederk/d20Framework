package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.DieRoll;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.boc.model.Skill;

public class DnDv35RuleServiceRollTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testRollAttack() {
    final DieRoll dieRoll = ruleService.rollAttack(5);
    assertDieRoll(dieRoll, 1, Die.D20, 5);
  }

  @Test
  public void testRollDamage() {
    final DieRoll dieRoll = ruleService.rollDamage(new Damage(2, Die.D6), 3);
    assertDieRoll(dieRoll, 2, Die.D6, 3);
  }

  @Test
  public void testRollCritical() {
    final Critical critical = new Critical(20, 2);
    DieRoll dieRoll = ruleService.rollCritical(new Damage(1, Die.D4), 2, critical);
    assertDieRoll(dieRoll, 2, Die.D4, 4);

    critical.setMultiplier(3);
    dieRoll = ruleService.rollCritical(new Damage(1, Die.D4), 2, critical);
    assertDieRoll(dieRoll, 3, Die.D4, 6);
  }

  @Test
  public void testRollSkill() {
    final Skill skill = new Skill();
    skill.setAttribute(Attribute.STRENGTH);
    final CharacterSkill characterSkill = new CharacterSkill(skill);
    characterSkill.setModifier(2);
    characterSkill.setRank(1);

    final DieRoll dieRoll = ruleService.rollSkill(belvador, characterSkill);

    assertDieRoll(dieRoll, 1, Die.D20, 3);
  }

  private void assertDieRoll(final DieRoll dieRoll, final int numberOfRolls, final Die die, final int bonus) {
    assertNotNull(dieRoll);
    assertNotNull(dieRoll.getRolls());
    assertNotNull(dieRoll.getDie());

    assertEquals(numberOfRolls, dieRoll.getRolls().length);
    assertEquals(die, dieRoll.getDie());
    assertEquals(bonus, dieRoll.getBonus());
    assertTrue(dieRoll.getResult() >= (numberOfRolls + bonus));
    assertTrue(dieRoll.getResult() <= (die.max() * numberOfRolls + bonus));
  }

  @Test
  public void testIsCritical() {
    final Critical critical = new Critical(20, 2);

    final DieRoll dieRoll = new DieRoll();
    dieRoll.setRolls(new int[] {20});
    assertTrue(ruleService.isCritical(dieRoll, critical));

    dieRoll.setRolls(new int[] {19});
    assertFalse(ruleService.isCritical(dieRoll, critical));
  }

  @Test
  public void testIsFumble() {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setRolls(new int[] {1});
    assertTrue(ruleService.isFumble(dieRoll));

    dieRoll.setRolls(new int[] {19});
    assertFalse(ruleService.isFumble(dieRoll));
  }

  @Test
  public void testRollAttribute() {
    final DieRoll dieRoll = ruleService.rollAttribute(belvador, Attribute.INTELLIGENCE);
    assertDieRoll(dieRoll, 1, Die.D20, 4);
  }

  @Test
  public void testRollSave() {
    final DieRoll dieRoll = ruleService.rollSave(belvador, Save.FORTITUDE);
    assertDieRoll(dieRoll, 1, Die.D20, 4);
  }

  @Test
  public void testRollInitative() {
    final DieRoll dieRoll = ruleService.rollInitative(belvador);
    assertDieRoll(dieRoll, 1, Die.D20, 4);
  }

  @Test
  public void testRollBaseAttackBonus() {
    final DieRoll dieRoll = ruleService.rollBaseAttackBonus(belvador);
    assertDieRoll(dieRoll, 1, Die.D20, 2);
  }

  @Test
  public void testRollCombatManeuverBonus() {
    final DieRoll dieRoll = ruleService.rollCombatManeuverBonus(belvador);
    assertDieRoll(dieRoll, 1, Die.D20, 2);
  }

  @Test
  public void testRollCombatManeuverDefence() {
    final DieRoll dieRoll = ruleService.rollCombatManeuverDefence(belvador);
    assertDieRoll(dieRoll, 1, Die.D20, 16);
  }
}
