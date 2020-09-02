package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Race like Human, Elf, Dwarf, etc.
 */
public class Race implements Serializable {

  private static final long serialVersionUID = -54018234373833177L;

  private int id;
  private String name;
  private Size size;
  private int baseLandSpeed;
  private CharacterClass favoredCharacterClass;
  private List<Ability> abilities;

  /**
   * Returns the id of the race.
   *
   * @return The id of the race.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the race.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the race.
   *
   * @return The name of the race.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the race.
   *
   * @param name
   *     The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the base speed on land in feet.
   *
   * @return The base speed on land in feet.
   */
  public int getBaseLandSpeed() {
    return baseLandSpeed;
  }

  /**
   * Sets the base speed on land in feet.
   *
   * @param baseLandSpeed
   *     The base speed to set.
   */
  public void setBaseLandSpeed(final int baseLandSpeed) {
    this.baseLandSpeed = baseLandSpeed;
  }

  /**
   * Returns the favored character class.
   *
   * @return The favored character class.
   */
  public CharacterClass getFavoredCharacterClass() {
    return favoredCharacterClass;
  }

  /**
   * Set the favored character class.
   *
   * @param favoredCharacterClass
   *     The favored character class.
   */
  public void setFavoredCharacterClass(final CharacterClass favoredCharacterClass) {
    this.favoredCharacterClass = favoredCharacterClass;
  }

  /**
   * Returns the abilities of the race.
   *
   * @return The abilities of the race.
   */
  public List<Ability> getAbilities() {
    return abilities;
  }

  /**
   * Sets the abilities of the race.
   *
   * @param abilities
   *     The abilities of the race.
   */
  public void setAbilities(final List<Ability> abilities) {
    this.abilities = abilities;
  }

  /**
   * Returns the size of the race.
   *
   * @return The size of the race.
   */
  public Size getSize() {
    return size;
  }

  /**
   * Set the size of the race.
   *
   * @param size
   *     The size of the race.
   */
  public void setSize(final Size size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return name;
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
    final Race other = (Race) obj;
    return id == other.id;
  }

}
