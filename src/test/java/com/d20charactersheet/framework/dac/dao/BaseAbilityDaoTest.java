package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());
    assertNotNull(allAbilities);
    assertEquals(302, allAbilities.size());
  }

  @Test
  public void testAbilityFastMovementBarbarian() {
    final Ability fastMovementBarbarianAbility = findAbilityById(ABILITY_ID_FAST_MOVEMENT_BARBARIAN);
    assertAbility(fastMovementBarbarianAbility, 0, AbilityType.EXTRAORDINARY, "Fast Movement - Barbarian",
                  "A barbarian's land speed is faster than the norm for his race by +10 feet. This benefit applies only when he is wearing no armor, light armor, or medium armor and not carrying a heavy load. Apply this bonus before modifying the barbarian's speed because of any load carried or armor worn.");
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

  private void assertAbility(final Ability ability, final int id, final AbilityType abilityType, final String name,
      final String description) {
    assertEquals(id, ability.getId());
    assertEquals(abilityType, ability.getAbilityType());
    assertEquals(name, ability.getName());
    assertEquals(description, ability.getDescription());
  }

  @Test
  public void testCreateAbility() {
    final int numberOfAllAbilities = abilityDao.getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()),
                                                                spelllistDao.getAllKnownSpellsTables(),
                                                                spelllistDao.getAllSpellsPerDayTables())
        .size();

    final Ability ability = new Ability();
    ability.setName("newAbilityName");
    ability.setAbilityType(AbilityType.SUPERNATURAL);
    ability.setDescription("newAbilityDescription");

    final Ability createdAbility = abilityDao.createAbility(ability);
    assertNotNull(createdAbility);
    assertTrue(createdAbility.getId() >= 0);
    assertEquals(abilityDao.getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()),
                                            spelllistDao.getAllKnownSpellsTables(), spelllistDao.getAllSpellsPerDayTables()).size(),
                 numberOfAllAbilities + 1);

    abilityDao.deleteAbility(createdAbility);
  }

  @Test
  public void testExtraFeatAbility() {
    final Ability ability = findAbilityById(ABILITY_ID_EXTRA_FEAT);
    assertTrue(ability instanceof ExtraFeatsAbility);
    final ExtraFeatsAbility extraFeatAbility = (ExtraFeatsAbility) ability;
    assertEquals(1, extraFeatAbility.getNumberOfFeats());
  }

  @Test
  public void testExtraSkillPointsAbility() {
    final Ability ability = findAbilityById(ABILITY_ID_EXTRA_SKILL_POINTS);
    assertTrue(ability instanceof ExtraSkillPointsAbility);
    final ExtraSkillPointsAbility extraSkillPointsAbility = (ExtraSkillPointsAbility) ability;
    assertEquals(1, extraSkillPointsAbility.getSkillPoints());
  }

  @Test
  public void testSpelllistAbility() {
    final Ability ability = findAbilityById(ABILITY_ID_SPELLLIST_CLERIC);
    assertTrue(ability instanceof SpelllistAbility);
    final SpelllistAbility spelllistAbility = (SpelllistAbility) ability;
    final Spelllist spelllist = spelllistAbility.getSpelllist();
    assertNotNull(spelllist);
    assertEquals(1, spelllist.getId());
    assertEquals("Cleric", spelllist.getName());
    assertEquals(10, spelllist.getNumberOfSpellLevels());
  }

  @Test
  public void testCreateSpelllistAbility() {
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

    abilityDao.createAbility(spelllistAbility);
    assertTrue(spelllistAbility.getId() > 0);

    final SpelllistAbility createdSpellistAbility = (SpelllistAbility) findAbilityById(spelllistAbility.getId());
    assertEquals(AbilityType.SPELL_LIKE, createdSpellistAbility.getAbilityType());
    assertTrue(createdSpellistAbility.isAttributeBonusSpellSlots());
    assertEquals(CastingType.PREPARED, createdSpellistAbility.getCastingType());
    assertEquals("testDescription", createdSpellistAbility.getDescription());
    assertEquals(knownSpellsTable, createdSpellistAbility.getKnownSpellsTable());
    assertEquals("testName", createdSpellistAbility.getName());
    assertEquals(EnumSet.of(School.CONJURATION), createdSpellistAbility.getSchools());
    assertEquals(Attribute.CHARISMA, createdSpellistAbility.getSpellAttribute());
    assertEquals(spelllist, createdSpellistAbility.getSpelllist());
    assertEquals(SpellSource.ARCANE, createdSpellistAbility.getSpellSource());
    assertEquals(spellsPerDayTable, createdSpellistAbility.getSpellsPerDayTable());

    // tear down
    abilityDao.deleteAbility(createdSpellistAbility);
  }

  @Test
  public void testUpdateSpelllistAbility() {
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

    abilityDao.updateAbility(spelllistAbility);

    final SpelllistAbility updatedSpellistAbility = (SpelllistAbility) findAbilityById(spelllistAbility.getId());
    assertEquals(AbilityType.SUPERNATURAL, updatedSpellistAbility.getAbilityType());
    assertTrue(updatedSpellistAbility.isAttributeBonusSpellSlots());
    assertEquals(CastingType.SPONTANEOUS, updatedSpellistAbility.getCastingType());
    assertEquals("testDescription", updatedSpellistAbility.getDescription());
    assertEquals(knownSpellsTable, updatedSpellistAbility.getKnownSpellsTable());
    assertEquals("testName", updatedSpellistAbility.getName());
    assertEquals(EnumSet.of(School.CONJURATION), updatedSpellistAbility.getSchools());
    assertEquals(Attribute.CHARISMA, updatedSpellistAbility.getSpellAttribute());
    assertEquals(spelllist, updatedSpellistAbility.getSpelllist());
    assertEquals(SpellSource.ARCANE, updatedSpellistAbility.getSpellSource());
    assertEquals(spellsPerDayTable, updatedSpellistAbility.getSpellsPerDayTable());

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
