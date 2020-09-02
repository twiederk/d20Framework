package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Represents a skill. The skill consists of character independent data like name, description, attribute, untrained and
 * classes. The character dependent data is rank, modifier and favorite.
 */
public class Skill implements Serializable {

  private static final long serialVersionUID = 1475900541253039072L;

  private int id;
  private String name;
  private String description;
  private Attribute attribute;
  private boolean untrained;

  /**
   * Returns the unique id of the skill.
   *
   * @return The unique id of the skill.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the unique id of the skill.
   *
   * @param id
   *     The unique id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the skill.
   *
   * @return The name of the skill.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the skill.
   *
   * @param name
   *     The name of the skill.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the description of the skill.
   *
   * @return The description of the skill.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the skill.
   *
   * @param description
   *     The description of the skill.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Returns the attribute of the skill.
   *
   * @return The attribute of the skill.
   */
  public Attribute getAttribute() {
    return attribute;
  }

  /**
   * Sets the attribute of the skill.
   *
   * @param attribute
   *     The attribute of the skill.
   */
  public void setAttribute(final Attribute attribute) {
    this.attribute = attribute;
  }

  /**
   * Returns true, if skill can be used even untrainend.
   *
   * @return True, if skill can be used even untrainend.
   */
  public boolean isUntrained() {
    return untrained;
  }

  /**
   * Sets if skill can be used untrained.
   *
   * @param untrained
   *     True, if skill can be used untrained.
   */
  public void setUntrained(final boolean untrained) {
    this.untrained = untrained;
  }

  /**
   * Returns the name of the skill.
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /**
   * Skills are equal, if their is is equal.
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
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
    final Skill other = (Skill) obj;
    return id == other.id;
  }

}
