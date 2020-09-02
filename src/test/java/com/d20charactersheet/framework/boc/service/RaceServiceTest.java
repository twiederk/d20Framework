package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.boc.model.CharacterClass.AnyCharacterClass.ANY_CHARACTER_CLASS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Size;

public class RaceServiceTest {

  private GameSystem gameSystem;
  private RaceService raceService;

  @Before
  public void setUp() {
    gameSystem = new DnDv35Universe().getGameSystem();
    raceService = gameSystem.getRaceService();
  }

  @Test
  public void testGetAllRaces() {
    final List<Race> races = raceService.getAllRaces(gameSystem.getAllCharacterClasses(), gameSystem.getAllAbilities());
    assertNotNull(races);
    assertEquals(19, races.size());
  }

  @Test
  public void testCreateRace() {
    final Race race = raceService.createRace(createRace());
    assertNotNull(race);
    assertTrue(race.getId() > 0);
  }

  private Race createRace() {
    final Race race = new Race();
    race.setName("testName");
    race.setSize(Size.MEDIUM);
    race.setBaseLandSpeed(30);
    race.setFavoredCharacterClass(ANY_CHARACTER_CLASS);
    race.setAbilities(createAbilities());
    return race;
  }

  private List<Ability> createAbilities() {
    final List<Ability> allAbilities = gameSystem.getAllAbilities();
    final List<Ability> abilities = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      abilities.add(allAbilities.get(i));
    }
    return abilities;
  }

  @Test
  public void testUpdateRace() {
    final Race originalRace = getRaceById();
    final Race updateRace = createRace();
    updateRace.setId(Objects.requireNonNull(originalRace).getId());
    raceService.updateRace(updateRace);
    gameSystem.clear();

    final Race updatedRace = getRaceById();
    assertEquals("testName", Objects.requireNonNull(updatedRace).getName());
    assertEquals(Size.MEDIUM, updatedRace.getSize());
    assertEquals(30, updatedRace.getBaseLandSpeed());
    assertEquals(ANY_CHARACTER_CLASS, updatedRace.getFavoredCharacterClass());
    assertEquals(10, updatedRace.getAbilities().size());

    raceService.updateRace(originalRace);
  }

  private Race getRaceById() {
    for (final Race race : gameSystem.getAllRaces()) {
      if (race.getId() == 0) {
        return race;
      }
    }
    fail("Can't get race by id " + 0);
    return null;
  }
}
