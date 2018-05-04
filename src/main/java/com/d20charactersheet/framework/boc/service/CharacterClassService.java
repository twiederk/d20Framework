package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Skill;

/**
 * Provides services about character classes.
 */
public interface CharacterClassService {

  /**
   * Returns all character classes. The skills are necessary to build up the class skills.
   *
   * @param allSkills
   *     All skills of the game system.
   * @param allAbilities
   *     All available class abilities
   *
   * @return All character classes of the game system.
   */
  public List<CharacterClass> getAllCharacterClasses(List<Skill> allSkills, List<Ability> allAbilities);

  /**
   * Deletes the skill from all character classes.
   *
   * @param skill
   *     The skill to delete.
   */
  public void deleteSkill(Skill skill);

  /**
   * Updates the character class in the persistent layer.
   *
   * @param characterClass
   *     The character class to update.
   */
  public void updateCharacterClass(CharacterClass characterClass);

  /**
   * Creates a character class with valid id.
   *
   * @param characterClass
   *     The character class to create.
   *
   * @return The created character class with valid id.
   */
  public CharacterClass createCharacterClass(CharacterClass characterClass);

  /**
   * Adds the skill as class skill to the character class.
   *
   * @param skill
   *     The skill to add as class skill.
   * @param characterClasses
   *     The character classes to add the skill to.
   */
  public void addSkill(Skill skill, List<CharacterClass> characterClasses);

  /**
   * Find class by name.
   *
   * @param name
   *     The name of the class.
   * @param allClasses
   *     The classes to search through.
   *
   * @return The class with the given name
   */
  public CharacterClass findClassByName(String name, List<CharacterClass> allClasses);

}
