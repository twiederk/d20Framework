package com.d20charactersheet.framework.boc.model;

/**
 * Known spell table of a class.
 */
public class KnownSpellsTable {

  /**
   * No access to the spell level by the class
   */
  public static final int NO_ACCESS = -1;

  /**
   * Unlimited access to the spell level by the class
   */
  public static final int UNLIMITED = 10;

  private int id;
  private String name;
  private int[][] knownSpells;

  /**
   * Returns id of the known spell table.
   *
   * @return Id of the known spell table.
   */
  public int getId() {
    return id;
  }

  /**
   * Set the if of the known spell table.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the known spell table.
   *
   * @return The name of the known spell table.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the known spell table.
   *
   * @param name
   *     The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the known spells table with caster and spell level.
   *
   * @return The known spells table with caster and spell level.
   */
  public int[][] getKnownSpells() {
    return knownSpells;
  }

  /**
   * Set known spell table with caster and spell level.
   *
   * @param knownSpells
   *     The spell table to set-
   */
  public void setKnownSpells(final int[][] knownSpells) {
    this.knownSpells = knownSpells;
  }

  /**
   * Returns number of known spells of given caster and spell level.
   *
   * @param spellcasterLevel
   *     The level of the spell caster.
   * @param spellLevel
   *     The spell level.
   *
   * @return Number of known spells of given caster and spell level.
   */
  public int getKnownSpells(final int spellcasterLevel, final int spellLevel) {
    try {
      int boundedSpellCasterLevel = boundSpellCasterLevel(spellcasterLevel);
      int boundedSpellLevel = boundSpellLevel(spellLevel, boundedSpellCasterLevel);
      return knownSpells[boundedSpellCasterLevel - 1][boundedSpellLevel];
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      return 0;
    }
  }

  private int boundSpellLevel(int spellLevel, int boundedSpellCasterLevel) {
    int boundedSpellLevel = spellLevel;
    if (spellLevel >= knownSpells[boundedSpellCasterLevel - 1].length) {
      boundedSpellLevel = knownSpells[boundedSpellCasterLevel - 1].length - 1;
    }
    return boundedSpellLevel;
  }

  private int boundSpellCasterLevel(int spellcasterLevel) {
    int boundedSpellCasterLevel = spellcasterLevel;
    if (spellcasterLevel >= knownSpells.length) {
      boundedSpellCasterLevel = knownSpells.length;
    }
    return boundedSpellCasterLevel;
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
    final KnownSpellsTable other = (KnownSpellsTable) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
