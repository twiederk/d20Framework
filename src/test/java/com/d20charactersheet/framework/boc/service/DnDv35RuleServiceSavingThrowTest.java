package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Save;

public class DnDv35RuleServiceSavingThrowTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetGoodSavingThrow() {
    final AbstractRuleServiceImpl abstractRuleServiceImpl = (AbstractRuleServiceImpl) ruleService;

    // level 1 => +2
    int savingThrow = abstractRuleServiceImpl.getGoodSave(1);
    assertEquals(2, savingThrow);

    // level 2 => +3
    savingThrow = abstractRuleServiceImpl.getGoodSave(2);
    assertEquals(3, savingThrow);

    // level 3 => +3
    savingThrow = abstractRuleServiceImpl.getGoodSave(3);
    assertEquals(3, savingThrow);

    // level 10 => +7
    savingThrow = abstractRuleServiceImpl.getGoodSave(10);
    assertEquals(7, savingThrow);

    // level 15 => +9
    savingThrow = abstractRuleServiceImpl.getGoodSave(15);
    assertEquals(9, savingThrow);

    // level 20 => +12
    savingThrow = abstractRuleServiceImpl.getGoodSave(20);
    assertEquals(12, savingThrow);
  }

  @Test
  public void testGetPoorSavingThrow() {
    final AbstractRuleServiceImpl abstractRuleServiceImpl = (AbstractRuleServiceImpl) ruleService;

    // level 1 => 0
    int savingThrow = abstractRuleServiceImpl.getPoorSave(1);
    assertEquals(0, savingThrow);

    // level 2 => 0
    savingThrow = abstractRuleServiceImpl.getPoorSave(2);
    assertEquals(0, savingThrow);

    // level 3 => +1
    savingThrow = abstractRuleServiceImpl.getPoorSave(3);
    assertEquals(1, savingThrow);

    // level 10 => +3
    savingThrow = abstractRuleServiceImpl.getPoorSave(10);
    assertEquals(3, savingThrow);

    // level 15 => +5
    savingThrow = abstractRuleServiceImpl.getPoorSave(15);
    assertEquals(5, savingThrow);

    // level 20 => +6
    savingThrow = abstractRuleServiceImpl.getPoorSave(20);
    assertEquals(6, savingThrow);
  }

  @Test
  public void testGetSavingThrowClass() {
    final AbstractRuleServiceImpl abstractRuleServiceImpl = (AbstractRuleServiceImpl) ruleService;

    // Fighter (1), Fortitude => 2
    int savingThrow = abstractRuleServiceImpl.getBaseSave(new ClassLevel(fighter, 1), Save.FORTITUDE);
    assertEquals(2, savingThrow);

    // Fighter (1), Reflex => 0
    savingThrow = abstractRuleServiceImpl.getBaseSave(new ClassLevel(fighter, 1), Save.REFLEX);
    assertEquals(0, savingThrow);

    // Fighter (1), Will => 0
    savingThrow = abstractRuleServiceImpl.getBaseSave(new ClassLevel(fighter, 1), Save.WILL);
    assertEquals(0, savingThrow);

    // Fighter (3), Fortitude => 3
    savingThrow = abstractRuleServiceImpl.getBaseSave(new ClassLevel(fighter, 3), Save.FORTITUDE);
    assertEquals(3, savingThrow);

    // Fighter (3), Reflex => 1
    savingThrow = abstractRuleServiceImpl.getBaseSave(new ClassLevel(fighter, 3), Save.REFLEX);
    assertEquals(1, savingThrow);

  }

  @Test
  public void testGetSavingThrowCharacter() {
    final Character character = createCharacter(wizard, 5);
    character.setConstitution(12);
    character.setDexterity(14);
    character.setWisdom(16);
    character.setFortitudeModifier(1);
    character.setReflexModifier(2);
    character.setWillModifier(3);

    int savingThrow = ruleService.getSave(character, Save.FORTITUDE);
    assertEquals(3, savingThrow);

    savingThrow = ruleService.getSave(character, Save.REFLEX);
    assertEquals(5, savingThrow);

    savingThrow = ruleService.getSave(character, Save.WILL);
    assertEquals(10, savingThrow);
  }

  @Test
  public void testGetSavingThrowMultiClassCharacter() {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<>();
    classLevels.add(new ClassLevel(ranger, 4));
    classLevels.add(new ClassLevel(rogue, 3));
    character.setClassLevels(classLevels);
    character.setConstitution(12);
    character.setDexterity(14);
    character.setWisdom(16);
    character.setFortitudeModifier(1);
    character.setReflexModifier(2);
    character.setWillModifier(3);

    // Ranger(4) + Rogue(3) + Constitution + modifier = +4 +1 +1 +1 = 7
    int savingThrow = ruleService.getSave(character, Save.FORTITUDE);
    assertEquals(7, savingThrow);

    // Ranger(4) + Rogue(3) + Constitution + modifier = +4 +3 +2 +2 = 11
    savingThrow = ruleService.getSave(character, Save.REFLEX);
    assertEquals(11, savingThrow);

    // Ranger(4) + Rogue(3) + Constitution = +1 +1 +3 +3 = 8
    savingThrow = ruleService.getSave(character, Save.WILL);
    assertEquals(8, savingThrow);

  }

  @Test
  public void testGetBaseSaveMultiCharacter() {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<>();
    classLevels.add(new ClassLevel(ranger, 4));
    classLevels.add(new ClassLevel(rogue, 3));
    character.setClassLevels(classLevels);

    // Ranger(4) + Rogue(3) = +4 +1 = 5
    int savingThrow = ruleService.getBaseSave(character, Save.FORTITUDE);
    assertEquals(5, savingThrow);

    // Ranger(4) + Rogue(3) = +4 +3 = 7
    savingThrow = ruleService.getBaseSave(character, Save.REFLEX);
    assertEquals(7, savingThrow);

    // Ranger(4) + Rogue(3) = +1 +1 = 2
    savingThrow = ruleService.getBaseSave(character, Save.WILL);
    assertEquals(2, savingThrow);

  }

}
