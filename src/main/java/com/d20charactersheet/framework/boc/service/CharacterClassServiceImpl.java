package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.ClassDao;

/**
 * Handles character class specific tasks.
 */
public class CharacterClassServiceImpl implements CharacterClassService {

  private final ClassDao characterClassDao;

  /**
   * Creates CharacterClassService with given data access object.
   *
   * @param characterClassDao
   *     The data access object to the persistent layer.
   */
  public CharacterClassServiceImpl(final ClassDao characterClassDao) {
    this.characterClassDao = characterClassDao;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterClassService#getAllCharacterClasses(java.util.List, * java.util.List)
   */
  @Override
  public List<CharacterClass> getAllCharacterClasses(final List<Skill> allSkills, final List<Ability> allAbilities) {
    return characterClassDao.getAllCharacterClasses(allSkills, allAbilities);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterClassService#deleteSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public void deleteSkill(final Skill skill) {
    characterClassDao.deleteSkill(skill);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterClassService#updateCharacterClass(com.d20charactersheet.framework.boc.model.CharacterClass)
   */
  @Override
  public void updateCharacterClass(final CharacterClass characterClass) {
    characterClassDao.updateCharacterClass(characterClass);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterClassService#createCharacterClass(com.d20charactersheet.framework.boc.model.CharacterClass)
   */
  @Override
  public CharacterClass createCharacterClass(final CharacterClass characterClass) {
    characterClassDao.createCharacterClass(characterClass);
    return characterClass;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterClassService#addSkill(com.d20charactersheet.framework.boc.model.Skill, * java.util.List)
   */
  @Override
  public void addSkill(final Skill skill, final List<CharacterClass> characterClasses) {
    characterClassDao.addSkill(skill, characterClasses);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterClassService#findClassByName(java.lang.String, * java.util.List)
   */
  @Override
  public CharacterClass findClassByName(final String name, final List<CharacterClass> allClasses) {
    for (final CharacterClass clazz : allClasses) {
      if (clazz.getName().equals(name)) {
        return clazz;
      }
    }
    throw new IllegalArgumentException("Can't find class with name: " + name);
  }

}
