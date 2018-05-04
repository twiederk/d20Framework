package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a character class and the level of this class.
 */
public class ClassLevel implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id = -1;

  private final CharacterClass characterClass;

  private int level;

  private List<CharacterAbility> characterAbilities;

  /**
   * Create ClassLevel with given class and level 1.
   *
   * @param characterClass
   *     The according class.
   */
  public ClassLevel(final CharacterClass characterClass) {
    this(characterClass, 1);
  }

  /**
   * Creates a ClassLevel with the given character class and level.
   *
   * @param characterClass
   *     The character class.
   * @param level
   *     The level.
   */
  public ClassLevel(final CharacterClass characterClass, final int level) {
    if (characterClass.getId() == CharacterClass.ANY_CHARACTER_CLASS.getId()) {
      throw new IllegalArgumentException("Can' create ClassLevel of ANY_CHARACTER_CLASS");
    }
    if (level < 1) {
      throw new RuleException(RuleError.ZERO_OR_NEGATIVE_CLASS_LEVEL, level);
    }

    this.characterClass = characterClass;
    this.level = level;

    characterAbilities = new ArrayList<CharacterAbility>();
    for (final ClassAbility classAbility : characterClass.getClassAbilities()) {
      final CharacterAbility characterAbility = new CharacterAbility();
      characterAbility.setClassAbility(classAbility);
      characterAbility.setOwned(true);
      characterAbilities.add(characterAbility);
    }

  }

  /**
   * Returns the id of the ClassLevel. Unsaved ClassLevels have an id of -1.
   *
   * @return The id of the ClassLevel.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the ClassLevel.
   *
   * @param id
   *     The id of the ClassLevel.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the character class of the class level.
   *
   * @return The character class.
   */
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  /**
   * Returns the class level.
   *
   * @return The class level.
   */
  public int getLevel() {
    return level;
  }

  /**
   * Sets the level
   *
   * @param level
   *     The level of the character class.
   */
  public void setLevel(final int level) {
    this.level = level;
  }

  /**
   * The name of the class and the level in brackets. Example: Wizard (4)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return characterClass.getName() + " (" + level + ")";
  }

  /**
   * Returns all class abilities of the Character.
   *
   * @return All class abilities of the Character.
   */
  public List<CharacterAbility> getCharacterAbilities() {
    return characterAbilities;
  }

  /**
   * Sets the class abilities of the Character.
   *
   * @param characterAbilities
   *     The character abilities to set.
   */
  public void setCharacterAbilities(final List<CharacterAbility> characterAbilities) {
    this.characterAbilities = characterAbilities;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ClassLevel other = (ClassLevel) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
