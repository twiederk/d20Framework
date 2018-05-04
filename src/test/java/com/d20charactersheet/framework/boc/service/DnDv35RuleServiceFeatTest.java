package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.ClassLevel;

public class DnDv35RuleServiceFeatTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetNumberOfFeats() throws Exception {
    final Character character = createCharacter(new ClassLevel(wizard, 5), elf);
    int numberOfFeats = ruleService.getNumberOfFeats(character);
    assertEquals(2, numberOfFeats);

    character.setRace(human);
    numberOfFeats = ruleService.getNumberOfFeats(character);
    assertEquals(3, numberOfFeats);
  }

  @Test
  public void testGetNumberOfFeatsMultiClass() throws Exception {
    final Character character = createCharacter(new ClassLevel(wizard, 5), new ClassLevel(fighter, 2), human, 10);
    final int numberOfFeats = ruleService.getNumberOfFeats(character);
    assertEquals(4, numberOfFeats);
  }

}
