package com.d20charactersheet.framework.boc.model;

/**
 * Table with spells per day of caster and spell level.
 */
public class SpellsPerDayTable {

  /**
   * The spell caster has no access to the spell level
   */
  public static final int NO_ACCESS = -1;

  private int id;
  private String name;
  private int[][] spellsPerDay;

  /**
   * Returns id of the spells per day table.
   *
   * @return Id of the spells per day table.
   */
  public int getId() {
    return id;
  }

  /**
   * Set id of spells per day table.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns name of spells per day table.
   *
   * @return Name of spells per day table.
   */
  public String getName() {
    return name;
  }

  /**
   * Set name of spell per day table.
   *
   * @param name
   *     The name to set.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns table of spells per day by caster and spell level.
   *
   * @return Table of spells per day by caster and spell level.
   */
  public int[][] getSpellsPerDay() {
    return spellsPerDay;
  }

  /**
   * Set table of spells per day.
   *
   * @param spellsPerDay
   *     The spells per day table to set.
   */
  public void setSpellsPerDay(final int[][] spellsPerDay) {
    this.spellsPerDay = spellsPerDay;
  }

  /**
   * Returns the number of spells per day according to caster and spell level.
   *
   * @param spellcasterLevel
   * @param spellLevel
   *
   * @return The number of spells per day according to caster and spell level.
   */
  public int getSpellsPerDay(final int spellcasterLevel, final int spellLevel) {
    return spellsPerDay[spellcasterLevel - 1][spellLevel];
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
    final SpellsPerDayTable other = (SpellsPerDayTable) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
