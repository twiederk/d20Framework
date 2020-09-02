package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumSet;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.CastingType;
import com.d20charactersheet.framework.boc.model.ExtraFeatsAbility;
import com.d20charactersheet.framework.boc.model.ExtraSkillPointsAbility;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.SpellSource;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;

public abstract class BaseAbilityDaoTest {

  private static final int ABILITY_ID_FAST_MOVEMENT_BARBARIAN = 0;
  private static final int ABILITY_ID_SPELLLIST_CLERIC = 23;
  private static final int ABILITY_ID_EXTRA_FEAT = 224;
  private static final int ABILITY_ID_EXTRA_SKILL_POINTS = 225;

  protected AbilityDao abilityDao;
  protected SpelllistDao spelllistDao;

  @Test
  public void testGetAllAbilities() {

    // Act
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());

    // Assert
    assertThat(allAbilities).hasSize(302);
  }

  @Test
  public void testAbilityFastMovementBarbarian() {

    // Act
    final Ability fastMovementBarbarianAbility = findAbilityById(ABILITY_ID_FAST_MOVEMENT_BARBARIAN);

    // Assert
    assertAbility(fastMovementBarbarianAbility);
  }

  private Ability findAbilityById(final int abilityId) {
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());
    for (final Ability ability : allAbilities) {
      if (ability.getId() == abilityId) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't get ability with id: " + abilityId);
  }

  private void assertAbility(final Ability ability) {
    assertThat(ability.getId()).isEqualTo(0);
    assertThat(ability.getAbilityType()).isEqualTo(AbilityType.EXTRAORDINARY);
    assertThat(ability.getName()).isEqualTo("Fast Movement - Barbarian");
    assertThat(ability.getDescription()).isEqualTo(
        "A barbarian's land speed is faster than the norm for his race by +10 feet. This benefit applies only when he is wearing no armor, light armor, or medium armor and not carrying a heavy load. Apply this bonus before modifying the barbarian's speed because of any load carried or armor worn.");
  }

  @Test
  public void testCreateAbility() {

    // Arrange
    final int numberOfAllAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables()).size();

    final Ability ability = new Ability();
    ability.setName("newAbilityName");
    ability.setAbilityType(AbilityType.SUPERNATURAL);
    ability.setDescription("newAbilityDescription");

    // Act
    final Ability createdAbility = abilityDao.createAbility(ability);

    // Assert
    assertThat(createdAbility).isNotNull();
    assertThat(createdAbility.getId()).isGreaterThanOrEqualTo(0);
    assertThat(abilityDao.getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()),
                                          spelllistDao.getAllKnownSpellsTables(), spelllistDao.getAllSpellsPerDayTables()).size())
        .isEqualTo(numberOfAllAbilities + 1);

    // tear down
    abilityDao.deleteAbility(createdAbility);
  }

  @Test
  public void testExtraFeatAbility() {

    // Act
    final Ability ability = findAbilityById(ABILITY_ID_EXTRA_FEAT);

    // Assert
    assertThat(ability).isInstanceOf(ExtraFeatsAbility.class);
    final ExtraFeatsAbility extraFeatAbility = (ExtraFeatsAbility) ability;
    assertThat(extraFeatAbility.getNumberOfFeats()).isEqualTo(1);
  }

  @Test
  public void testExtraSkillPointsAbility() {

    // Act
    final Ability ability = findAbilityById(ABILITY_ID_EXTRA_SKILL_POINTS);

    // Assert
    assertThat(ability).isInstanceOf(ExtraSkillPointsAbility.class);
    final ExtraSkillPointsAbility extraSkillPointsAbility = (ExtraSkillPointsAbility) ability;
    assertThat(extraSkillPointsAbility.getSkillPoints()).isEqualTo(1);
  }

  @Test
  public void testSpelllistAbility() {

    // Act
    final Ability ability = findAbilityById(ABILITY_ID_SPELLLIST_CLERIC);

    // Assert
    assertThat(ability).isInstanceOf(SpelllistAbility.class);
    final SpelllistAbility spelllistAbility = (SpelllistAbility) ability;
    final Spelllist spelllist = spelllistAbility.getSpelllist();
    assertThat(spelllist).isNotNull();
    assertThat(spelllist.getId()).isEqualTo(1);
    assertThat(spelllist.getName()).isEqualTo("Cleric");
    assertThat(spelllist.getNumberOfSpellLevels()).isEqualTo(10);
  }

  @Test
  public void testCreateSpelllistAbility() {
    // Arrange
    final List<Spelllist> allSpelllists = spelllistDao.getAllSpelllists(spelllistDao.getAllSpells());
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    final Spelllist spelllist = allSpelllists.get(0);
    final KnownSpellsTable knownSpellsTable = allKnownSpellsTables.get(0);
    final SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(0);

    final SpelllistAbility spelllistAbility = new SpelllistAbility();
    spelllistAbility.setAbilityType(AbilityType.SPELL_LIKE);
    spelllistAbility.setAttributeBonusSpellSlots(true);
    spelllistAbility.setCastingType(CastingType.PREPARED);
    spelllistAbility.setDescription("testDescription");
    spelllistAbility.setKnownSpellsTable(knownSpellsTable);
    spelllistAbility.setName("testName");
    spelllistAbility.setSchools(EnumSet.of(School.CONJURATION));
    spelllistAbility.setSpellAttribute(Attribute.CHARISMA);
    spelllistAbility.setSpelllist(spelllist);
    spelllistAbility.setSpellSource(SpellSource.ARCANE);
    spelllistAbility.setSpellsPerDayTable(spellsPerDayTable);

    // Act
    abilityDao.createAbility(spelllistAbility);

    // Assert
    assertThat(spelllistAbility.getId()).isGreaterThanOrEqualTo(0);

    final SpelllistAbility createdSpellistAbility = (SpelllistAbility) findAbilityById(spelllistAbility.getId());
    assertThat(createdSpellistAbility.getAbilityType()).isEqualTo(AbilityType.SPELL_LIKE);
    assertThat(createdSpellistAbility.isAttributeBonusSpellSlots()).isTrue();
    assertThat(createdSpellistAbility.getCastingType()).isEqualTo(CastingType.PREPARED);
    assertThat(createdSpellistAbility.getDescription()).isEqualTo("testDescription");
    assertThat(createdSpellistAbility.getKnownSpellsTable()).isEqualTo(knownSpellsTable);
    assertThat(createdSpellistAbility.getName()).isEqualTo("testName");
    assertThat(createdSpellistAbility.getSchools()).isEqualTo(EnumSet.of(School.CONJURATION));
    assertThat(createdSpellistAbility.getSpellAttribute()).isEqualTo(Attribute.CHARISMA);
    assertThat(createdSpellistAbility.getSpelllist()).isEqualTo(spelllist);
    assertThat(createdSpellistAbility.getSpellSource()).isEqualTo(SpellSource.ARCANE);
    assertThat(createdSpellistAbility.getSpellsPerDayTable()).isEqualTo(spellsPerDayTable);

    // tear down
    abilityDao.deleteAbility(createdSpellistAbility);
  }

  @Test
  public void testUpdateSpelllistAbility() {
    // Arrange
    final List<Spelllist> allSpelllists = spelllistDao.getAllSpelllists(spelllistDao.getAllSpells());
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    final Spelllist spelllist = allSpelllists.get(0);
    final KnownSpellsTable knownSpellsTable = allKnownSpellsTables.get(0);
    final SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(0);

    final SpelllistAbility spelllistAbility = (SpelllistAbility) findAbilityById(ABILITY_ID_SPELLLIST_CLERIC);
    final SpelllistAbility backupSpelllistAbilty = copySpelllistAbility(spelllistAbility);

    spelllistAbility.setAbilityType(AbilityType.SUPERNATURAL);
    spelllistAbility.setAttributeBonusSpellSlots(true);
    spelllistAbility.setCastingType(CastingType.SPONTANEOUS);
    spelllistAbility.setDescription("testDescription");
    spelllistAbility.setKnownSpellsTable(knownSpellsTable);
    spelllistAbility.setName("testName");
    spelllistAbility.setSchools(EnumSet.of(School.CONJURATION));
    spelllistAbility.setSpellAttribute(Attribute.CHARISMA);
    spelllistAbility.setSpelllist(spelllist);
    spelllistAbility.setSpellSource(SpellSource.ARCANE);
    spelllistAbility.setSpellsPerDayTable(spellsPerDayTable);

    // Act
    abilityDao.updateAbility(spelllistAbility);

    // Assert
    final SpelllistAbility updatedSpellistAbility = (SpelllistAbility) findAbilityById(spelllistAbility.getId());
    assertThat(updatedSpellistAbility.getAbilityType()).isEqualTo(AbilityType.SUPERNATURAL);
    assertThat(updatedSpellistAbility.isAttributeBonusSpellSlots()).isTrue();
    assertThat(updatedSpellistAbility.getCastingType()).isEqualTo(CastingType.SPONTANEOUS);
    assertThat(updatedSpellistAbility.getDescription()).isEqualTo("testDescription");
    assertThat(updatedSpellistAbility.getKnownSpellsTable()).isEqualTo(knownSpellsTable);
    assertThat(updatedSpellistAbility.getName()).isEqualTo("testName");
    assertThat(updatedSpellistAbility.getSchools()).isEqualTo(EnumSet.of(School.CONJURATION));
    assertThat(updatedSpellistAbility.getSpellAttribute()).isEqualTo(Attribute.CHARISMA);
    assertThat(updatedSpellistAbility.getSpelllist()).isEqualTo(spelllist);
    assertThat(updatedSpellistAbility.getSpellSource()).isEqualTo(SpellSource.ARCANE);
    assertThat(updatedSpellistAbility.getSpellsPerDayTable()).isEqualTo(spellsPerDayTable);

    // tear down
    abilityDao.updateAbility(backupSpelllistAbilty);
  }

  private SpelllistAbility copySpelllistAbility(final SpelllistAbility spelllistAbility) {
    final SpelllistAbility copySpelllistAbility = new SpelllistAbility();
    copySpelllistAbility.setId(spelllistAbility.getId());
    copySpelllistAbility.setAbilityType(spelllistAbility.getAbilityType());
    copySpelllistAbility.setAttributeBonusSpellSlots(spelllistAbility.isAttributeBonusSpellSlots());
    copySpelllistAbility.setCastingType(spelllistAbility.getCastingType());
    copySpelllistAbility.setDescription(spelllistAbility.getDescription());
    copySpelllistAbility.setKnownSpellsTable(spelllistAbility.getKnownSpellsTable());
    copySpelllistAbility.setName(spelllistAbility.getName());
    copySpelllistAbility.setSchools(spelllistAbility.getSchools());
    copySpelllistAbility.setSpellAttribute(spelllistAbility.getSpellAttribute());
    copySpelllistAbility.setSpelllist(spelllistAbility.getSpelllist());
    copySpelllistAbility.setSpellSource(spelllistAbility.getSpellSource());
    copySpelllistAbility.setSpellsPerDayTable(spelllistAbility.getSpellsPerDayTable());
    return copySpelllistAbility;
  }
}
