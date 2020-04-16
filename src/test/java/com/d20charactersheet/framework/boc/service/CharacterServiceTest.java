package com.d20charactersheet.framework.boc.service;

import org.junit.Before;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage;

public class CharacterServiceTest extends BaseCharacterServiceTest {

  @Before
  public void setUp() {
    final Universe universe = new DnDv35Universe();
    gameSystem = universe.getGameSystem();
    final CharacterClassService characterClassService = gameSystem.getCharacterClassService();
    fighter = characterClassService.findClassByName("Fighter", gameSystem.getAllCharacterClasses());
    wizard = characterClassService.findClassByName("Wizard", gameSystem.getAllCharacterClasses());

    final RaceService raceService = gameSystem.getRaceService();
    human = raceService.findRaceByName("Human", gameSystem.getAllRaces());
  }

  @Override
  public void testDeleteCharacter() {
    // can only be implemented with an ImageService
  }

  @Override
  protected int getNumberOfCharacters() {
    return DnDv35CharacterStorage.CHARACTER.length;
  }
}
