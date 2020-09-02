package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Represents a ability.
 */
public class Ability implements Serializable {

  private static final long serialVersionUID = -7032987904537024348L;

  private int id;
  private String name;
  private String description;
  private AbilityType abilityType;

  /**
   * Returns id of the ability.
   *
   * @return Id of the ability.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets id of the ability.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the ability.
   *
   * @return The name of the ability.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the ability.
   *
   * @param name
   *     The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns description of the ability.
   *
   * @return Description of the ability.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description of the ability.
   *
   * @param description
   *     The description to set.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Returns the type of the ability.
   *
   * @return The type of the ability.
   */
  public AbilityType getAbilityType() {
    return abilityType;
  }

  /**
   * Sets the type of the ability.
   *
   * @param abilityType
   *     The ability type to set.
   */
  public void setAbilityType(final AbilityType abilityType) {
    this.abilityType = abilityType;
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
    final Ability other = (Ability) obj;
    return id == other.id;
  }

}
