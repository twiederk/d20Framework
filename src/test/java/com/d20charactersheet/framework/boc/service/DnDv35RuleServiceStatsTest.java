package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Size;

public class DnDv35RuleServiceStatsTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetModifierNegativeValue() {
    try {
      ruleService.getModifier(-1);
      fail("No exception thrown (expected IllegalArgumentException)");
    } catch (final IllegalArgumentException illegalArgumentException) {
      // expected exception catched
    } catch (final Exception e) {
      fail("Wrong exception thrown (expected IllegalArgumentException)");
    }
  }

  @Test
  public void testGetModifier() throws Exception {
    // value: 1 => modifier -5
    int modifier = ruleService.getModifier(1);
    assertEquals(-5, modifier);

    // value: 5 => modifier -3
    modifier = ruleService.getModifier(5);
    assertEquals(-3, modifier);

    // value: 6 => modifier -2
    modifier = ruleService.getModifier(6);
    assertEquals(-2, modifier);

    // value: 10 => modifier 0
    modifier = ruleService.getModifier(10);
    assertEquals(0, modifier);

    // value: 11 => modifier 0
    modifier = ruleService.getModifier(11);
    assertEquals(0, modifier);

    // value: 12 => modifier +1
    modifier = ruleService.getModifier(12);
    assertEquals(1, modifier);

    // value: 15 => modifier +2
    modifier = ruleService.getModifier(15);
    assertEquals(2, modifier);

    // value: 16 => modifier +3
    modifier = ruleService.getModifier(16);
    assertEquals(3, modifier);

    // value: 20 => modifier +5
    modifier = ruleService.getModifier(20);
    assertEquals(5, modifier);

    // value: 45 => modifier +17
    modifier = ruleService.getModifier(45);
    assertEquals(17, modifier);

  }

  @Test
  public void testGetBaseAttackBonusOfSingleClass() throws Exception {

    // Fighter (good), level 1 => 1
    Character character = createCharacter(fighter, 1);
    int baseAttackBonus = ruleService.getBaseAttackBonus(character);
    assertEquals(1, baseAttackBonus);

    // Fighter (good), level 6 => 6
    character = createCharacter(fighter, 6);
    baseAttackBonus = ruleService.getBaseAttackBonus(character);
    assertEquals(6, baseAttackBonus);

    // Fighter (good), level 11 => 11
    character = createCharacter(fighter, 11);
    baseAttackBonus = ruleService.getBaseAttackBonus(character);
    assertEquals(11, baseAttackBonus);
  }

  @Test
  public void testGetBaseAttackBonusMultiClass() throws Exception {
    final List<ClassLevel> classLevels = new LinkedList<ClassLevel>();
    classLevels.add(new ClassLevel(ranger, 4));
    classLevels.add(new ClassLevel(druid, 6));

    final Character character = new Character();
    character.setClassLevels(classLevels);

    // Ranger (4), Druid (6) => 8
    int baseAttackBonus = ruleService.getBaseAttackBonus(character);
    assertEquals(8, baseAttackBonus);

    classLevels.clear();
    classLevels.add(new ClassLevel(ranger, 4));
    classLevels.add(new ClassLevel(rogue, 3));

    // Ranger (4), Rogue (3) => 6
    baseAttackBonus = ruleService.getBaseAttackBonus(character);
    assertEquals(6, baseAttackBonus);

  }

  @Test
  public void testGetGoodBaseAttackBonus() throws Exception {
    final AbstractRuleServiceImpl abstractRuleServiceImpl = (AbstractRuleServiceImpl) ruleService;

    assertEquals(1, abstractRuleServiceImpl.getGoodBaseAttackBonus(1));
    assertEquals(6, abstractRuleServiceImpl.getGoodBaseAttackBonus(6));
    assertEquals(11, abstractRuleServiceImpl.getGoodBaseAttackBonus(11));
  }

  @Test
  public void testGetAverageAttackBonus() throws Exception {
    final AbstractRuleServiceImpl abstractRuleServiceImpl = (AbstractRuleServiceImpl) ruleService;

    assertEquals(0, abstractRuleServiceImpl.getAverageBaseAttackBonus(1));
    assertEquals(1, abstractRuleServiceImpl.getAverageBaseAttackBonus(2));
    assertEquals(2, abstractRuleServiceImpl.getAverageBaseAttackBonus(3));
    assertEquals(3, abstractRuleServiceImpl.getAverageBaseAttackBonus(4));
    assertEquals(3, abstractRuleServiceImpl.getAverageBaseAttackBonus(5));
    assertEquals(4, abstractRuleServiceImpl.getAverageBaseAttackBonus(6));
    assertEquals(5, abstractRuleServiceImpl.getAverageBaseAttackBonus(7));
    assertEquals(6, abstractRuleServiceImpl.getAverageBaseAttackBonus(8));
    assertEquals(6, abstractRuleServiceImpl.getAverageBaseAttackBonus(9));
    assertEquals(7, abstractRuleServiceImpl.getAverageBaseAttackBonus(10));
    assertEquals(11, abstractRuleServiceImpl.getAverageBaseAttackBonus(15));
  }

  @Test
  public void testGetPoorAttackBonus() throws Exception {
    final AbstractRuleServiceImpl abstractRuleServiceImpl = (AbstractRuleServiceImpl) ruleService;

    assertEquals(0, abstractRuleServiceImpl.getPoorBaseAttackBonus(1));
    assertEquals(1, abstractRuleServiceImpl.getPoorBaseAttackBonus(2));
    assertEquals(1, abstractRuleServiceImpl.getPoorBaseAttackBonus(3));
    assertEquals(2, abstractRuleServiceImpl.getPoorBaseAttackBonus(4));
    assertEquals(2, abstractRuleServiceImpl.getPoorBaseAttackBonus(5));
    assertEquals(3, abstractRuleServiceImpl.getPoorBaseAttackBonus(6));
    assertEquals(3, abstractRuleServiceImpl.getPoorBaseAttackBonus(7));
    assertEquals(4, abstractRuleServiceImpl.getPoorBaseAttackBonus(8));
    assertEquals(4, abstractRuleServiceImpl.getPoorBaseAttackBonus(9));
    assertEquals(5, abstractRuleServiceImpl.getPoorBaseAttackBonus(10));
    assertEquals(7, abstractRuleServiceImpl.getPoorBaseAttackBonus(15));
  }

  @Test
  public void testGetInitative() throws Exception {
    final Character character = new Character();

    character.setDexterity(5);
    character.setInitiativeModifier(0);
    assertEquals(-3, ruleService.getInitative(character));

    character.setDexterity(10);
    character.setInitiativeModifier(1);
    assertEquals(1, ruleService.getInitative(character));

    character.setDexterity(15);
    character.setInitiativeModifier(2);
    assertEquals(4, ruleService.getInitative(character));

    character.setDexterity(18);
    character.setInitiativeModifier(3);
    assertEquals(7, ruleService.getInitative(character));

  }

  @Test
  public void testGetSpeed() throws Exception {

    // Human, Fighter (1) => 30 feet
    Character character = createCharacter(new ClassLevel(fighter, 1), human);
    assertEquals(30, ruleService.getSpeed(character));

    // Gnome, Fighter (1) => 20 feet
    character = createCharacter(new ClassLevel(fighter, 1), gnome);
    assertEquals(20, ruleService.getSpeed(character));

    // Human, Monk (1) => 30 feet
    character = createCharacter(new ClassLevel(monk, 1), human);
    assertEquals(30, ruleService.getSpeed(character));

  }

  @Test
  public void testGetClassesWithSingleClassLevel() throws Exception {
    final Character character = createCharacter(wizard, 5);

    final List<CharacterClass> oppositeClasses = ruleService.getOppositeOfCharacterClasses(character, allClasses);

    assertEquals(26, oppositeClasses.size());
  }

  @Test
  public void testGetClassesWithThreeClassLevels() throws Exception {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<ClassLevel>();
    classLevels.add(new ClassLevel(wizard, 5));
    classLevels.add(new ClassLevel(bard, 5));
    classLevels.add(new ClassLevel(barbarian, 5));
    character.setClassLevels(classLevels);

    final List<CharacterClass> oppositeClasses = ruleService.getOppositeOfCharacterClasses(character, allClasses);

    assertEquals(24, oppositeClasses.size());
  }

  @Test
  public void testACLevel11() throws Exception {
    final Character character = createCharacter(new ClassLevel(fighter, 11), human);
    character.setDexterity(12);
    final int armorClass = ruleService.getArmorClass(character);
    assertEquals(11, armorClass);
  }

  @Test
  public void testGetCombatManeuverBonus() throws Exception {
    // expectedCmb, class, level, race, strength, cmbModifier
    assertCmbScore(3, fighter, 1, human, 14, 0);
    assertCmbScore(6, fighter, 5, human, 10, 1);
    assertCmbScore(3, wizard, 6, elf, 11, 0);
  }

  @Test
  public void testGetCombatManeuverBonusMultiClass() throws Exception {
    final Character character = createCharacter(new ClassLevel(ranger, 4), new ClassLevel(rogue, 4), human, 1);
    character.setStrength(12);

    final int cmb = ruleService.getCombatManeuverBonus(character);
    assertEquals(8, cmb);
  }

  private void assertCmbScore(final int expectedCmb, final CharacterClass characterClass, final int level, final Race race,
      final int strength, final int cmbModifier) {
    final Character character = createCharacter(new ClassLevel(characterClass, level), race);
    character.setStrength(strength);
    character.setCmbModifier(cmbModifier);

    final int cmb = ruleService.getCombatManeuverBonus(character);
    assertEquals(expectedCmb, cmb);
  }

  @Test
  public void testGetSpecialSizeModifier() throws Exception {
    try {
      for (final Size size : Size.values()) {
        ruleService.getSpecialSizeModifier(size);
      }
    } catch (final Exception exception) {
      fail("Not all special size modifier could be determined");
    }
  }

  @Test
  public void testGetCombatDefenceModifier() throws Exception {
    // expectedCmd, class, level, race, strength, dexterity, cmdModifier
    assertCmdScore(13, fighter, 1, human, 14, 10, 0);
    assertCmdScore(18, fighter, 5, human, 10, 14, 1);
    assertCmdScore(13, wizard, 6, elf, 11, 11, 0);
  }

  private void assertCmdScore(final int expectedCmd, final CharacterClass characterClass, final int level, final Race race,
      final int strength, final int dexterity, final int cmdModifier) {
    final Character character = createCharacter(new ClassLevel(characterClass, level), race);
    character.setStrength(strength);
    character.setDexterity(dexterity);
    character.setCmdModifier(cmdModifier);

    final int cmd = ruleService.getCombatManeuverDefence(character);
    assertEquals(expectedCmd, cmd);
  }
}
