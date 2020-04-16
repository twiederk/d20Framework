package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.EnumSet;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.BaseAttackBonus;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.boc.model.Skill;

public abstract class BaseClassDaoTest {

  protected ClassDao characterClassDao;
  protected SkillDao skillDao;
  protected AbilityDao abilityDao;
  protected SpelllistDao spelllistDao;
  protected List<CharacterClass> allCharacterClasses;

  @Test
  public void testBaseClasses() {
    assertNotNull(allCharacterClasses);
    assertEquals(27, allCharacterClasses.size());

    // check barbarian
    final CharacterClass barbarian = allCharacterClasses.get(0);
    assertClass(barbarian, 0, "Barbarian", BaseAttackBonus.GOOD, Save.FORTITUDE, getAlignmentsOfBarbarian(), 4);

    // check wizard
    final CharacterClass wizard = allCharacterClasses.get(10);
    assertClass(wizard, 10, "Wizard", BaseAttackBonus.POOR, Save.WILL, EnumSet.allOf(Alignment.class), 2);
  }

  private void assertClass(final CharacterClass characterClass, final int id, final String name,
      final BaseAttackBonus baseAttackBonus, final Save save, final EnumSet<Alignment> alignments, final int skillPointsPerLevel) {
    assertEquals(id, characterClass.getId());
    assertEquals(name, characterClass.getName());
    assertEquals(baseAttackBonus, characterClass.getBaseAttackBonus());
    assertSaves(characterClass, save);
    assertEquals(alignments, characterClass.getAlignments());
    assertEquals(skillPointsPerLevel, characterClass.getSkillPointsPerLevel());
    assertNotNull(characterClass.getSkills());
  }

  private void assertSaves(final CharacterClass characterClass, final Save save) {
    final EnumSet<Save> saves = characterClass.getSaves();
    assertNotNull(saves);
    assertEquals(1, saves.size());
    assertTrue(saves.contains(save));
  }

  private EnumSet<Alignment> getAlignmentsOfBarbarian() {
    final EnumSet<Alignment> excludeAlignments = EnumSet.of(Alignment.LAWFUL_EVIL, Alignment.LAWFUL_NEUTRAL, Alignment.LAWFUL_GOOD);
    final EnumSet<Alignment> alignmentsOfBarbarian = EnumSet.complementOf(excludeAlignments);
    return alignmentsOfBarbarian;
  }

  @Test
  public void testSkillsOfCharacterClasses() {
    final CharacterClass fighter = allCharacterClasses.get(4);
    assertSkills(fighter, new String[] {"Climb", "Craft", "Handle Animal", "Intimidate", "Jump", "Ride", "Swim"});

    final CharacterClass sorcerer = allCharacterClasses.get(9);
    assertSkills(sorcerer, new String[] {"Bluff", "Concentration", "Craft", "Knowledge (arcana)", "Profession", "Spellcraft"});
  }

  private void assertSkills(final CharacterClass characterClass, final String[] skillNames) {
    final List<Skill> skills = characterClass.getSkills();
    assertNotNull(skills);
    assertEquals(skillNames.length, skills.size());
    for (int i = 0; i < skillNames.length; i++) {
      assertEquals(skillNames[i], skills.get(i).getName());
    }
  }

  @Test
  public void testAbilitiesOfCharacterClasses() {
    final CharacterClass barbarian = allCharacterClasses.get(0);
    final List<ClassAbility> classAbilities = barbarian.getClassAbilities();
    assertNotNull(classAbilities);
    assertEquals(11, classAbilities.size());
    final ClassAbility fastMovementBarbarian = classAbilities.get(0);
    assertEquals("Fast Movement - Barbarian", fastMovementBarbarian.getAbility()
        .getName());
    assertEquals(1, fastMovementBarbarian.getLevel());
  }
}
