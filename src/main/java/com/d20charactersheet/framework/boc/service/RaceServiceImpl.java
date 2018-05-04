package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.dac.dao.RaceDao;

/**
 * Implementation of RaceService.
 */
public class RaceServiceImpl implements RaceService {

  private final RaceDao raceDao;

  /**
   * Create race service with data access.
   *
   * @param raceDao
   *     The data access.
   */
  public RaceServiceImpl(final RaceDao raceDao) {
    this.raceDao = raceDao;
  }

  @Override
  public List<Race> getAllRaces(final List<CharacterClass> allCharacterClasses, final List<Ability> allAbilities) {
    final List<Race> allRaces = raceDao.getAllRaces(allCharacterClasses, allAbilities);
    for (final Race race : allRaces) {
      if (race.getFavoredCharacterClass() == null) {
        race.setFavoredCharacterClass(CharacterClass.ANY_CHARACTER_CLASS);
      }
    }
    return allRaces;
  }

  @Override
  public Race createRace(final Race race) {
    return raceDao.createRace(race);
  }

  @Override
  public void updateRace(final Race race) {
    raceDao.updateRace(race);
  }

  @Override
  public Race findRaceById(final int raceId, final List<Race> races) {
    for (final Race race : races) {
      if (race.getId() == raceId) {
        return race;
      }
    }
    throw new IllegalArgumentException("Can't find race with id: " + raceId);
  }

  @Override
  public Race findRaceByName(final String name, final List<Race> races) {
    for (final Race race : races) {
      if (race.getName().equals(name)) {
        return race;
      }
    }
    throw new IllegalArgumentException("Can't find race with name: " + name);
  }

}
