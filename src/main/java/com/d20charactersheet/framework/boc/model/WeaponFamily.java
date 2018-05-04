package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Represents a family of similar weapons.
 */
public class WeaponFamily implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String name;

  /**
   * Returns the id of the weapon family.
   *
   * @return The id of the weapon family.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the weapon family.
   *
   * @param id
   *     The id of the weapon family.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the weapon family.
   *
   * @return The name of the weapon family.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the weapon family.
   *
   * @param name
   *     The name of the weapon family.
   */
  public void setName(final String name) {
    this.name = name;
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
    final WeaponFamily other = (WeaponFamily) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }
}
