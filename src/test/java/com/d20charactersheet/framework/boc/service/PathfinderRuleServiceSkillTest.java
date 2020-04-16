package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterSkill;

public class PathfinderRuleServiceSkillTest extends PathfinderRuleServiceTestCase {

  @Test
  public void testGetMaxClassSkillRank() {
    final int maxClassSkillRank = ruleService.getMaxClassSkillRank(valeros);
    assertEquals(1, maxClassSkillRank);
  }

  @Test
  public void testGetMaxCrossClassSkillRank() {
    final float maxCrossClassSkillRank = ruleService.getMaxCrossClassSkillRank(valeros);
    assertEquals(1.0f, maxCrossClassSkillRank, 0.0f);
  }

  @Test
  public void testGetSkillModifierWithClassSkill() {
    assertCharacterSkill(3, "Acrobatics");
  }

  @Test
  public void testGetSkillModifierWithClassSkillNoRank() {
    assertCharacterSkill(0, "Perform");
  }

  @Test
  public void testGetSkillModifierWithCrossClassSkill() {
    assertCharacterSkill(0, "Perception");
  }

  private void assertCharacterSkill(final int exceptedSkillModifier, final String skillName) {
    final CharacterSkill characterSkill = getSkill(skillName, valeros);
    final int skillModifier = ruleService.getSkillModifier(valeros, characterSkill);
    assertEquals(exceptedSkillModifier, skillModifier);
  }

  private CharacterSkill getSkill(final String name, final Character character) {
    for (final CharacterSkill characterSkill : character.getCharacterSkills()) {
      if (characterSkill.getSkill().getName().equals(name)) {
        return characterSkill;
      }
    }
    throw new IllegalArgumentException("Can't find character skill with name: " + name);
  }

  @Test
  public void testGetSkillPoints() {
    final int skillPoints = ruleService.getSkillPoints(valeros, null);
    assertEquals(4, skillPoints);
  }

}
