package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * A CharacterAbility is a ClassAbility of a character and can be owned by the character. ClassAbilities which are owned
 * by a character and the character has the proper class level are active. Active Ablities can be used by the character.
 */
public class CharacterAbility implements Serializable {

  private static final long serialVersionUID = -964915644796604051L;

  private int id = -1;
  private ClassAbility classAbility;
  private boolean owned;

  /**
   * Returns the id of the CharacterAbility. An id of -1 shows, that the CharacterAbility is new and has not been
   * saved yet.
   *
   * @return Id of the CharacterAbility.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the CharacterAbility.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns true, if the class ability is owned by the character.
   *
   * @return True, if the class ability is owned by the character.
   */
  public boolean isOwned() {
    return owned;
  }

  /**
   * Set to true, to mark the class ability as owned by the character.
   *
   * @param owned
   *     True, class ability is owned by the character.
   */
  public void setOwned(final boolean owned) {
    this.owned = owned;
  }

  /**
   * Returns the class ability.
   *
   * @return The class ability.
   */
  public ClassAbility getClassAbility() {
    return classAbility;
  }

  /**
   * Sets the class ability.
   *
   * @param classAbility
   *     The class ability.
   */
  public void setClassAbility(final ClassAbility classAbility) {
    this.classAbility = classAbility;
  }

  @Override
  public String toString() {
    return classAbility.getAbility().getName();
  }

}
