package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Race;

/**
 * Interface to persistent data of races.
 */
public interface RaceDao {

  /**
   * Returns all races of the game system.
   *
   * @param allCharacterClasses
   *     All character classes of the game system.
   * @param allAbilities
   *     All abilities of the game system.
   *
   * @return All races of the game system.
   */
  public List<Race> getAllRaces(List<CharacterClass> allCharacterClasses, List<Ability> allAbilities);

  /**
   * Creates a new race in the persistent layer. Fills the id of the race.
   *
   * @param race
   *     The race to create.
   *
   * @return The created race with id.
   */
  public Race createRace(Race race);

  /**
   * Deletes the race from the persistent layer.
   *
   * @param race
   *     The race to delete.
   */
  public void deleteRace(Race race);

  /**
   * Update the race in the persistent layer.
   *
   * @param race
   *     The race to update.
   */
  public void updateRace(Race race);

}
