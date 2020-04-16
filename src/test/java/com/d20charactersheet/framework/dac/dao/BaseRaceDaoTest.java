package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Size;

public abstract class BaseRaceDaoTest {

  protected SkillDao skillDao;
  protected ClassDao characterClassDao;
  protected RaceDao raceDao;
  protected AbilityDao abilityDao;
  protected SpelllistDao spelllistDao;

  @Test
  public void testGetAllRaces() {
    final List<Race> allRaces = getAllRaces();
    assertNotNull(allRaces);
    assertEquals(19, allRaces.size());
  }

  private List<Race> getAllRaces() {
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());

    final List<CharacterClass> allCharacterClasses = characterClassDao
        .getAllCharacterClasses(skillDao.getAllSkills(), allAbilities);
    final List<Race> allRaces = raceDao.getAllRaces(allCharacterClasses, allAbilities);
    return allRaces;
  }

  @Test
  public void testRaceHuman() {
    final List<Ability> allAbilities = abilityDao.getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()),
                                                                  spelllistDao.getAllKnownSpellsTables(),
                                                                  spelllistDao.getAllSpellsPerDayTables());
    final List<CharacterClass> characterClasses = characterClassDao.getAllCharacterClasses(skillDao.getAllSkills(), allAbilities);
    final List<Race> races = raceDao.getAllRaces(characterClasses, allAbilities);
    final Race human = races.get(0);
    assertHuman(human);
  }

  private void assertHuman(final Race human) {
    assertNotNull(human);
    assertEquals(0, human.getId());
    assertEquals("Human", human.getName());
  }

  @Test
  public void testCreateRace() {
    Race race = raceDao.createRace(createRace());
    assertNotNull(race);
    assertTrue(race.getId() > 0);

    race = getRaceFromService(race.getId());

    assertRace(race);

    raceDao.deleteRace(race);

  }

  private Race createRace() {
    final Race race = new Race();
    race.setName("testName");
    race.setSize(Size.MEDIUM);
    race.setBaseLandSpeed(30);
    race.setFavoredCharacterClass(getBarbarian());
    race.setAbilities(createAbilities());
    return race;
  }

  private List<Ability> createAbilities() {
    final List<Ability> allAbilities = abilityDao.getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()),
                                                                  spelllistDao.getAllKnownSpellsTables(),
                                                                  spelllistDao.getAllSpellsPerDayTables());
    final List<Ability> abilities = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      abilities.add(allAbilities.get(i));
    }
    return abilities;
  }

  private Race getRaceFromService(final int id) {
    for (final Race race : getAllRaces()) {
      if (race.getId() == id) {
        return race;
      }
    }
    fail("Can't retrieve race from RaceService");
    return null;
  }

  private void assertAbilities(final Race race) {
    final List<Ability> abilities = race.getAbilities();
    assertNotNull(abilities);
    assertEquals(10, abilities.size());
  }

  private CharacterClass getBarbarian() {
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());
    final List<CharacterClass> allCharacterClasses = characterClassDao
        .getAllCharacterClasses(skillDao.getAllSkills(), allAbilities);
    return allCharacterClasses.get(0);
  }

  @Test
  public void testUpdateRace() {
    final Race originalRace = getRaceById(0);
    final Race updateRace = createRace();

    raceDao.updateRace(updateRace);

    final Race updatedRace = getRaceById(0);
    assertRace(updatedRace);

    raceDao.updateRace(originalRace);
  }

  private void assertRace(final Race race) {
    assertEquals("testName", race.getName());
    assertEquals(Size.MEDIUM, race.getSize());
    assertEquals(30, race.getBaseLandSpeed());
    assertEquals(getBarbarian(), race.getFavoredCharacterClass());
    assertAbilities(race);
  }

  private Race getRaceById(final int raceId) {
    for (final Race race : getAllRaces()) {
      if (race.getId() == raceId) {
        fixSettingOfAnyCharacterClass(race);
        return race;
      }
    }
    fail("Can't get race by id " + raceId);
    return null;
  }

  private void fixSettingOfAnyCharacterClass(final Race race) {
    if (race.getFavoredCharacterClass() == null) {
      race.setFavoredCharacterClass(CharacterClass.ANY_CHARACTER_CLASS);
    }
  }
}
