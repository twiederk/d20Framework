package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Race;

public abstract class DnDv35RuleServiceTestCase extends RuleServiceTestCase {

  Character belvador;
  Character nascan;
  Character nyatar;
  Character jadzia;
  Character worf;
  Character rodrekr;
  Character thore;
  Character kyra;
  Character merisiel;
  Character ezren;
  Character valeros;
  Character dorn;
  Character hakim;
  Character toc;

  @Override
  Universe createUniverse() {
    return new DnDv35Universe();
  }

  @Override
  void createCharacterClasses() {
    allClasses = gameSystem.getAllCharacterClasses();
    final CharacterClassService classService = gameSystem.getCharacterClassService();
    barbarian = classService.findClassByName("Barbarian", allClasses);
    bard = classService.findClassByName("Bard", allClasses);
    druid = classService.findClassByName("Druid", allClasses);
    fighter = classService.findClassByName("Fighter", allClasses);
    monk = classService.findClassByName("Monk", allClasses);
    ranger = classService.findClassByName("Ranger", allClasses);
    rogue = classService.findClassByName("Rogue", allClasses);
    wizard = classService.findClassByName("Wizard", allClasses);
  }

  @Override
  void createRaces() {
    final RaceService raceService = gameSystem.getRaceService();
    final List<Race> allRaces = gameSystem.getAllRaces();
    human = raceService.findRaceByName("Human", allRaces);
    elf = raceService.findRaceByName("High Elf", allRaces);
    gnome = raceService.findRaceByName("Rock Gnome", allRaces);
    halfOrc = raceService.findRaceByName("Half-Orc", allRaces);
  }

  @Override
  void createCharacters() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final List<Character> allCharacters = gameSystem.getAllCharacters();
    belvador = characterService.findCharacterByName("Belvador the Summoner", allCharacters);
    nyatar = characterService.findCharacterByName("Nyatar", allCharacters);
    jadzia = characterService.findCharacterByName("Jadzia", allCharacters);
    nascan = characterService.findCharacterByName("Nascan Schwarzhaut", allCharacters);
    worf = characterService.findCharacterByName("Worf", allCharacters);
    rodrekr = characterService.findCharacterByName("Rodrekr Vaeringjar", allCharacters);
    thore = characterService.findCharacterByName("Thore Stavanger", allCharacters);
    kyra = characterService.findCharacterByName("Kyra", allCharacters);
    merisiel = characterService.findCharacterByName("Merisiel", allCharacters);
    ezren = characterService.findCharacterByName("Ezren", allCharacters);
    valeros = characterService.findCharacterByName("Valeros", allCharacters);
    dorn = characterService.findCharacterByName("Dorn Evenwood", allCharacters);
    hakim = characterService.findCharacterByName("Hakim Al Dschech Ibn Sauri Harfed Ben Uluman", allCharacters);
    toc = characterService.findCharacterByName("Toc der Juengere", allCharacters);
  }

}
