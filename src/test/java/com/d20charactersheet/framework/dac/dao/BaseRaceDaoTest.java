package com.d20charactersheet.framework.dac.dao;

import static com.d20charactersheet.framework.boc.model.CharacterClass.AnyCharacterClass.ANY_CHARACTER_CLASS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

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

    // Act
    final List<Race> allRaces = getAllRaces();

    // Assert
    assertThat(allRaces).hasSize(19);
  }

  private List<Race> getAllRaces() {
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());

    final List<CharacterClass> allCharacterClasses = characterClassDao
        .getAllCharacterClasses(skillDao.getAllSkills(), allAbilities);
    return raceDao.getAllRaces(allCharacterClasses, allAbilities);
  }

  @Test
  public void testRaceHuman() {

    // Arrange
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());
    final List<CharacterClass> characterClasses = characterClassDao.getAllCharacterClasses(skillDao.getAllSkills(), allAbilities);
    final List<Race> races = raceDao.getAllRaces(characterClasses, allAbilities);

    // Act
    final Race human = races.get(0);

    // Assert
    assertThat(human).isNotNull();
    assertThat(human.getId()).isEqualTo(0);
    assertThat(human.getName()).isEqualTo("Human");
  }

  @Test
  public void testCreateRace() {
    // Arrange
    Race raceToCreate = createRace();

    // Act
    Race createdRace = raceDao.createRace(raceToCreate);

    // Assert
    assertThat(createdRace).isNotNull();
    assertThat(createdRace.getId()).isNotEqualTo(0);

    Race persistedRace = getRaceFromService(createdRace.getId());
    assertThat(persistedRace).isNotNull();
    assertRace(persistedRace);

    // tear down
    raceDao.deleteRace(persistedRace);
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
    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
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
    // Arrange
    final Race originalRace = getRaceById();
    final Race updateRace = createRace();

    // Act
    raceDao.updateRace(updateRace);

    // Assert
    final Race updatedRace = getRaceById();
    assertThat(updatedRace).isNotNull();
    assertRace(updatedRace);

    // tear down
    raceDao.updateRace(originalRace);
  }

  private void assertRace(final Race race) {
    assertThat(race.getName()).isEqualTo("testName");
    assertThat(race.getSize()).isEqualTo(Size.MEDIUM);
    assertThat(race.getBaseLandSpeed()).isEqualTo(30);
    assertThat(race.getFavoredCharacterClass()).isEqualTo(getBarbarian());

    final List<Ability> abilities = race.getAbilities();
    assertThat(abilities).isNotNull();
    assertThat(abilities.size()).isEqualTo(10);
  }

  private Race getRaceById() {
    for (final Race race : getAllRaces()) {
      if (race.getId() == 0) {
        fixSettingOfAnyCharacterClass(race);
        return race;
      }
    }
    fail("Can't get race by id " + 0);
    return null;
  }

  private void fixSettingOfAnyCharacterClass(final Race race) {
    if (race.getFavoredCharacterClass() == null) {
      race.setFavoredCharacterClass(ANY_CHARACTER_CLASS);
    }
  }
}
