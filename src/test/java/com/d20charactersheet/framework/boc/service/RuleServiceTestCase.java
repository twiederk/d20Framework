package com.d20charactersheet.framework.boc.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Skill;

public abstract class RuleServiceTestCase {

  Universe universe;

  GameSystem gameSystem;
  RuleService ruleService;

  List<CharacterClass> allClasses;

  CharacterClass barbarian;
  CharacterClass bard;
  CharacterClass druid;
  CharacterClass fighter;
  CharacterClass monk;
  CharacterClass ranger;
  CharacterClass rogue;
  CharacterClass wizard;

  Race human;
  Race elf;
  Race gnome;
  Race halfOrc;

  @Before
  public void setUp() {
    universe = createUniverse();
    gameSystem = universe.getGameSystem();
    ruleService = gameSystem.getRuleService();
    createCharacterClasses();
    createRaces();
    createCharacters();
  }

  abstract Universe createUniverse();

  abstract void createCharacterClasses();

  abstract void createRaces();

  abstract void createCharacters();

  Character createCharacter(final CharacterClass characterClass, final int level) {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<>();
    classLevels.add(new ClassLevel(characterClass, level));
    character.setClassLevels(classLevels);
    return character;
  }

  Character createCharacter(final ClassLevel classLevel, final Race race) {
    final Character character = createCharacter(classLevel.getCharacterClass(), classLevel.getLevel());
    character.setRace(race);
    return character;
  }

  Character createCharacter(final ClassLevel classLevel, final Race race, final int intelligence) {
    final Character character = createCharacter(classLevel, race);
    character.setIntelligence(intelligence);
    return character;
  }

  Character createCharacter(final ClassLevel classLevel1, final ClassLevel classLevel2, final Race race, final int intelligence) {
    final Character character = new Character();
    final List<ClassLevel> classLevels = new ArrayList<>();
    classLevels.add(classLevel1);
    classLevels.add(classLevel2);
    character.setClassLevels(classLevels);
    character.setRace(race);
    character.setIntelligence(intelligence);
    return character;
  }

  Skill createSkill(final int id, final String name) {
    final Skill skill = new Skill();
    skill.setId(id);
    skill.setName(name);
    return skill;
  }

}
