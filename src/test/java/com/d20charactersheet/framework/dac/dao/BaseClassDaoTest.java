package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
  public void testBaseClass() {

    // Assert
    assertThat(allCharacterClasses).hasSize(27);
  }

  @Test
  public void testBarbarianClass() {

    // Act
    final CharacterClass barbarian = allCharacterClasses.get(0);

    // Assert
    assertClass(barbarian, 0, "Barbarian", BaseAttackBonus.GOOD, Save.FORTITUDE, getAlignmentsOfBarbarian(), 4);

  }

  @Test
  public void testWizardClass() {

    // Act
    final CharacterClass wizard = allCharacterClasses.get(10);

    // Assert
    assertClass(wizard, 10, "Wizard", BaseAttackBonus.POOR, Save.WILL, EnumSet.allOf(Alignment.class), 2);
  }

  private void assertClass(final CharacterClass characterClass, final int id, final String name,
      final BaseAttackBonus baseAttackBonus, final Save save, final EnumSet<Alignment> alignments, final int skillPointsPerLevel) {
    assertThat(characterClass.getId()).isEqualTo(id);
    assertThat(characterClass.getName()).isEqualTo(name);
    assertThat(characterClass.getBaseAttackBonus()).isEqualTo(baseAttackBonus);
    assertSaves(characterClass, save);
    assertThat(characterClass.getAlignments()).isEqualTo(alignments);
    assertThat(characterClass.getSkillPointsPerLevel()).isEqualTo(skillPointsPerLevel);
    assertThat(characterClass.getSkills()).isNotNull();
  }

  private void assertSaves(final CharacterClass characterClass, final Save save) {
    final EnumSet<Save> saves = characterClass.getSaves();
    assertThat(saves).hasSize(1);
    assertThat(saves).containsExactly(save);
  }

  private EnumSet<Alignment> getAlignmentsOfBarbarian() {
    final EnumSet<Alignment> excludeAlignments = EnumSet.of(Alignment.LAWFUL_EVIL, Alignment.LAWFUL_NEUTRAL, Alignment.LAWFUL_GOOD);
    return EnumSet.complementOf(excludeAlignments);
  }

  @Test
  public void testSkillsOfFighterClass() {
    // Act
    final CharacterClass fighter = allCharacterClasses.get(4);

    // Assert
    assertSkills(fighter, new String[] {"Climb", "Craft", "Handle Animal", "Intimidate", "Jump", "Ride", "Swim"});
  }

  @Test
  public void testSkillsOSorcererClass() {
    // Act
    final CharacterClass sorcerer = allCharacterClasses.get(9);

    // Assert
    assertSkills(sorcerer, new String[] {"Bluff", "Concentration", "Craft", "Knowledge (arcana)", "Profession", "Spellcraft"});
  }

  private void assertSkills(final CharacterClass characterClass, final String[] skillNames) {
    final List<Skill> skills = characterClass.getSkills();
    assertThat(skills).hasSize(skillNames.length);
    for (int i = 0; i < skillNames.length; i++) {
      assertThat(skills.get(i).getName()).isEqualTo(skillNames[i]);
    }
  }

  @Test
  public void testAbilitiesOfCharacterClasses() {
    // Arrange
    final CharacterClass barbarian = allCharacterClasses.get(0);

    // Act
    final List<ClassAbility> classAbilities = barbarian.getClassAbilities();

    // Assert
    assertThat(classAbilities).hasSize(11);
    final ClassAbility fastMovementBarbarian = classAbilities.get(0);
    assertThat(fastMovementBarbarian.getAbility().getName()).isEqualTo("Fast Movement - Barbarian");
    assertThat(fastMovementBarbarian.getLevel()).isEqualTo(1);
  }
}
