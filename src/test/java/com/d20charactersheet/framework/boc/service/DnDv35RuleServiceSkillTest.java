package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.DieRoll;
import com.d20charactersheet.framework.boc.model.Skill;

public class DnDv35RuleServiceSkillTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetMaxClassSkillRankSingleClassCharacter() throws Exception {
    final Character character = createCharacter(wizard, 5);

    final int maxClassSkillRank = ruleService.getMaxClassSkillRank(character);
    assertEquals(8, maxClassSkillRank);
  }

  @Test
  public void testGetMaxClassSkillRankMultiClassCharacter() throws Exception {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<ClassLevel>();
    classLevels.add(new ClassLevel(wizard, 5));
    classLevels.add(new ClassLevel(bard, 5));
    classLevels.add(new ClassLevel(barbarian, 5));
    character.setClassLevels(classLevels);

    final int maxClassSkillRank = ruleService.getMaxClassSkillRank(character);
    assertEquals(18, maxClassSkillRank);
  }

  @Test
  public void testGetMaxCrossClassSkillRankSingleClassCharacter() throws Exception {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<ClassLevel>();
    classLevels.add(new ClassLevel(wizard, 4));
    character.setClassLevels(classLevels);

    final float maxCrossClassSkillRank = ruleService.getMaxCrossClassSkillRank(character);
    assertEquals(3.5f, maxCrossClassSkillRank, 0.0f);
  }

  @Test
  public void testGetMaxCrossClassSkillRankMultiClassCharacter() throws Exception {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<ClassLevel>();
    classLevels.add(new ClassLevel(wizard, 5));
    classLevels.add(new ClassLevel(bard, 5));
    classLevels.add(new ClassLevel(barbarian, 5));
    character.setClassLevels(classLevels);

    final float maxCrossClassSkillRank = ruleService.getMaxCrossClassSkillRank(character);
    assertEquals(9.0f, maxCrossClassSkillRank, 0.0f);
  }

  @Test
  public void testIsSkillTrained() throws Exception {

    CharacterSkill characterSkill = createCharacterSkill(0.0f, false);
    assertFalse(ruleService.isTrained(characterSkill));

    characterSkill = createCharacterSkill(1.0f, false);
    assertTrue(ruleService.isTrained(characterSkill));

    characterSkill = createCharacterSkill(0.0f, true);
    assertTrue(ruleService.isTrained(characterSkill));

    characterSkill = createCharacterSkill(1.0f, true);
    assertTrue(ruleService.isTrained(characterSkill));

  }

  private CharacterSkill createCharacterSkill(final float rank, final boolean untrained) {
    final Skill skill = new Skill();
    skill.setUntrained(untrained);

    final CharacterSkill characterSkill = new CharacterSkill(skill);
    characterSkill.setRank(rank);
    return characterSkill;
  }

  @Test
  public void testGetSkillPointsWizard5ElfInt10() throws Exception {
    // Wizard (5), Elf, INT 10
    final ClassLevel classLevel = new ClassLevel(wizard, 5);
    final Character character = createCharacter(classLevel, elf, 10);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(16, skillPoints);
  }

  @Test
  public void testGetSkillPointsWizard5ElfInt18() throws Exception {
    // Wizard (5), Elf, INT 18
    final Character character = createCharacter(new ClassLevel(wizard, 5), elf, 18);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(48, skillPoints);

  }

  @Test
  public void testGetSkillPointsWizard5HumanInt18() throws Exception {
    // Wizard (5), Human, INT 18
    final Character character = createCharacter(new ClassLevel(wizard, 5), human, 18);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(56, skillPoints);
  }

  @Test
  public void testGetSkillPointsBarbarian4HalfOrcInt9() throws Exception {
    // Barbarian (4), Half-Orc, INT 9
    final Character character = createCharacter(new ClassLevel(barbarian, 4), halfOrc, 9);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(21, skillPoints);
  }

  @Test
  public void testGetSkillPointsBarbarian4HumanInt9() throws Exception {
    // Barbarian (4), Half-Orc, INT 9
    final Character character = createCharacter(new ClassLevel(barbarian, 4), human, 9);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(28, skillPoints);
  }

  @Test
  public void testGetSkillPointsBard4HumanInt16() throws Exception {
    // Bard (4), Human, INT 16
    final Character character = createCharacter(new ClassLevel(bard, 4), human, 16);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(70, skillPoints);
  }

  @Test
  public void testGetSkillPointsBard5HumanInt16() throws Exception {
    // Bard (5), Human, INT 16
    final Character character = createCharacter(new ClassLevel(bard, 5), human, 16);
    final int skillPoints = ruleService.getSkillPoints(character, character.getClassLevels().get(0).getCharacterClass());
    assertEquals(80, skillPoints);
  }

  @Test
  public void testGetSkillPointsRanger4Rogue3HumanInt10() throws Exception {
    // Ranger (4), Rogue (3), Human, INT 10
    final Character character = createCharacter(new ClassLevel(ranger, 4), new ClassLevel(rogue, 3), human, 10);
    final int skillPoints = ruleService.getSkillPoints(character, ranger);
    assertEquals(76, skillPoints);
  }

  @Test
  public void testGetSkillPointsRanger4Druid6HumanInt10() throws Exception {
    // Ranger (4), Druid (6), Human, INT 10
    final Character character = createCharacter(new ClassLevel(ranger, 4), new ClassLevel(druid, 6), human, 10);
    final int skillPoints = ruleService.getSkillPoints(character, ranger);
    assertEquals(79, skillPoints);
  }

  @Test
  public void testGetSkillModifier() throws Exception {
    final Character character = new Character();
    character.setStrength(14);

    final CharacterSkill characterSkill = createCharacterSkill(Attribute.STRENGTH, 3, 2);
    final int skillModifier = ruleService.getSkillModifier(character, characterSkill);
    assertEquals(7, skillModifier);
  }

  @Test
  public void testGetSkillModifierWithHalfRank() throws Exception {
    final Character character = new Character();
    character.setStrength(14);

    final CharacterSkill characterSkill = createCharacterSkill(Attribute.STRENGTH, 3.5f, 2);
    final int skillModifier = ruleService.getSkillModifier(character, characterSkill);
    assertEquals(7, skillModifier);
  }

  @Test
  public void testSkillRoll() throws Exception {
    final Character character = new Character();
    character.setStrength(14);

    final CharacterSkill characterSkill = createCharacterSkill(Attribute.STRENGTH, 3.5f, 2);
    final DieRoll skillRoll = ruleService.rollSkill(character, characterSkill);
    assertTrue(skillRoll.getResult() > 7);
    assertTrue(skillRoll.getResult() < 28);
  }

  private CharacterSkill createCharacterSkill(final Attribute attribute, final float rank, final int modifier) {
    final Skill skill = new Skill();
    skill.setAttribute(attribute);

    final CharacterSkill characterSkill = new CharacterSkill(skill);
    characterSkill.setRank(rank);
    characterSkill.setModifier(modifier);
    return characterSkill;
  }

  @Test
  public void testIsClassSkillSingleClassCharacter() throws Exception {
    final Character wizardCharacter = createCharacter(new ClassLevel(wizard, 5), elf, 10);
    final Character fighterCharacter = createCharacter(new ClassLevel(fighter, 5), human, 10);
    final Skill spellcraft = createSkill(39, "Spellcraft");

    boolean classSkill = ruleService.isClassSkill(wizardCharacter, spellcraft);
    assertTrue(classSkill);

    classSkill = ruleService.isClassSkill(fighterCharacter, spellcraft);
    assertFalse(classSkill);
  }

  @Test
  public void testIsClassSkillMultiClassCharacter() throws Exception {
    final Character character = createCharacter(new ClassLevel(fighter, 1), new ClassLevel(wizard, 1), human, 10);
    final Skill spellcraft = createSkill(39, "Spellcraft");
    final Skill appraise = createSkill(1, "Appraise");

    boolean classSkill = ruleService.isClassSkill(character, spellcraft);
    assertTrue(classSkill);

    classSkill = ruleService.isClassSkill(character, appraise);
    assertFalse(classSkill);
  }

  @Test
  public void testGetSpentSkillPointsClassSkills() throws Exception {
    final Character character = createCharacter(new ClassLevel(fighter, 1), human, 10);
    final List<CharacterSkill> characterSkills = new LinkedList<CharacterSkill>();
    characterSkills.add(createCharacterSkill(fighter.getSkills().get(0), 4.0f));
    characterSkills.add(createCharacterSkill(fighter.getSkills().get(1), 4.0f));
    character.setCharacterSkills(characterSkills);

    final int spentSkillPoints = ruleService.getSpentSkillPoints(character);

    assertEquals(8, spentSkillPoints);
  }

  @Test
  public void testGetSpentSkillPointsCrossClassSkills() throws Exception {
    final Character character = createCharacter(new ClassLevel(fighter, 1), human, 10);
    final List<CharacterSkill> characterSkills = new LinkedList<CharacterSkill>();
    characterSkills.add(createCharacterSkill(new Skill(), 2.5f));
    characterSkills.add(createCharacterSkill(new Skill(), 4.0f));
    character.setCharacterSkills(characterSkills);

    final int spentSkillPoints = ruleService.getSpentSkillPoints(character);

    assertEquals(13, spentSkillPoints);
  }

  @Test
  public void testGetSpentSkillPointsMultiClassCharacter() throws Exception {
    final Character character = createCharacter(new ClassLevel(fighter, 1), new ClassLevel(wizard, 1), human, 10);
    final List<CharacterSkill> characterSkills = new LinkedList<CharacterSkill>();
    characterSkills.add(createCharacterSkill(fighter.getSkills().get(0), 4.0f));
    characterSkills.add(createCharacterSkill(fighter.getSkills().get(1), 4.0f));
    characterSkills.add(createCharacterSkill(wizard.getSkills().get(0), 4.0f));
    characterSkills.add(createCharacterSkill(wizard.getSkills().get(1), 4.0f));
    characterSkills.add(createCharacterSkill(new Skill(), 2.0f));
    characterSkills.add(createCharacterSkill(new Skill(), 2.0f));
    character.setCharacterSkills(characterSkills);

    final int spentSkillPoints = ruleService.getSpentSkillPoints(character);

    assertEquals(24, spentSkillPoints);
  }

  private CharacterSkill createCharacterSkill(final Skill skill, final float rank) {
    final CharacterSkill characterSkill = new CharacterSkill(skill);
    characterSkill.setRank(rank);
    return characterSkill;
  }
}
