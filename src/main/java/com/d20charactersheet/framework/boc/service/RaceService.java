package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Race;

/**
 * Provides functionality about races.
 */
public interface RaceService {

  /**
   * Returns all races of the game sytem.
   *
   * @param allCharacterClasses
   *     All character classes of the game system.
   * @param allAbilities
   *     All abilities of the game system.
   *
   * @return All races of the game system.
   */
  List<Race> getAllRaces(List<CharacterClass> allCharacterClasses, List<Ability> allAbilities);

  /**
   * Creates a new race and sets its id.
   *
   * @param race
   *     The race to create.
   *
   * @return The created race with the id set.
   */
  Race createRace(Race race);

  /**
   * Updates the race.
   *
   * @param race
   *     The race to update.
   */
  void updateRace(Race race);

  /**
   * Returns the race by the given id.
   *
   * @param raceId
   *     The id of the race.
   * @param races
   *     The races to search.
   *
   * @return The race by the given id.
   */
  Race findRaceById(int raceId, List<Race> races);

  /**
   * Find race by name.
   *
   * @param name
   *     The name of the race.
   * @param races
   *     The races to search.
   *
   * @return The race with the given name.
   */
  Race findRaceByName(String name, List<Race> races);
}
