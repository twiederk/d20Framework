package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * The known spell of a character.
 */
public class KnownSpell implements Serializable {

  private static final long serialVersionUID = -1566443761948269324L;

  private int id;
  private Spell spell;
  private Spelllist spelllist;

  /**
   * Returns id of the known spell.
   *
   * @return Td of the known spell.
   */
  public int getId() {
    return id;
  }

  /**
   * Set id of known spell.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the Spell assigned to the character.
   *
   * @return The Spell assigned to the character.
   */
  public Spell getSpell() {
    return spell;
  }

  /**
   * Sets the assigned spell.
   *
   * @param spell
   *     The spell to assign.
   */
  public void setSpell(final Spell spell) {
    this.spell = spell;
  }

  /**
   * Returns the spell list of the known spell.
   *
   * @return The spell list of the known spell.
   */
  public Spelllist getSpelllist() {
    return spelllist;
  }

  /**
   * Set spell list of known spell.
   *
   * @param spelllist
   *     The spell list of the known spell.
   */
  public void setSpelllist(final Spelllist spelllist) {
    this.spelllist = spelllist;
  }

  @Override
  public String toString() {
    return spell.getName();
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
    final KnownSpell other = (KnownSpell) obj;
    return id == other.id;
  }

}
