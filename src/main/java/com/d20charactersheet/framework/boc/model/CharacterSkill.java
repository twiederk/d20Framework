package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Represents a skill used by a character. The class is a composite of the skill and the character specific data of the
 * skill.
 */
public class CharacterSkill implements Serializable {

  private static final long serialVersionUID = -6226190817903446498L;

  private final Skill skill;
  private float rank;
  private int modifier;

  /**
   * Creates a CharacterSkill of the given skill.
   *
   * @param skill
   *     The skill the character has specific data of.
   */
  public CharacterSkill(final Skill skill) {
    this.skill = skill;
  }

  /**
   * Returns the skill of the character skill.
   *
   * @return The skill of the character skill.
   */
  public Skill getSkill() {
    return skill;
  }

  /**
   * Returns the rank the character has in this skill.
   *
   * @return The rank the character has in this skill.
   */
  public float getRank() {
    return rank;
  }

  /**
   * Sets the rank of the skill.
   *
   * @param rank
   *     The rank of the skill.
   */
  public void setRank(final float rank) {
    this.rank = rank;
  }

  /**
   * Returns the modifier the character has in this skill.
   *
   * @return The modifier the character has in this skill.
   */
  public int getModifier() {
    return modifier;
  }

  /**
   * Sets the modifier.
   *
   * @param modifier
   *     The modifier.
   */
  public void setModifier(final int modifier) {
    this.modifier = modifier;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((skill == null) ? 0 : skill.hashCode());
    return result;
  }

  /**
   * CharacterSkills with the same skill are equal.
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
    final CharacterSkill other = (CharacterSkill) obj;
    if (skill == null) {
      return other.skill == null;
    } else
      return skill.equals(other.skill);
  }

  /**
   * Returns the name of the skill.
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return skill.getName();
  }

}
