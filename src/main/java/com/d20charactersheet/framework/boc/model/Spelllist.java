package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Stores a spell list with its name and assigned spells.
 */
public class Spelllist implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private String shortname;
  private Map<Integer, List<Spell>> spellsByLevel = new HashMap<>();
  private boolean domain;
  private int minLevel;
  private int maxLevel;

  /**
   * Returns the id of the spell list.
   *
   * @return The id of the spell list.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the spell list.
   *
   * @param id
   *     The id of the spell list.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the spell list.
   *
   * @return The name of the spell list.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the spell list.
   *
   * @param name
   *     The name of the spell list.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns short name of spell list.
   *
   * @return Short name of spell list.
   */
  public String getShortname() {
    return shortname;
  }

  /**
   * Sets the short name of the spell list.
   *
   * @param shortname
   *     The short name of the spell list.
   */
  public void setShortname(final String shortname) {
    this.shortname = shortname;
  }

  /**
   * Returns spells of spell list clusterd by their spell level. The spell level is the key of the map. The value is
   * the list of spell.
   *
   * @return The spell level is the key of the map. The value is the list of spell.
   */
  public Map<Integer, List<Spell>> getSpellsByLevel() {
    return spellsByLevel;
  }

  /**
   * Sets the spells of the spell list clustered by their spell level.
   *
   * @param spellsByLevel
   *     Spells of spell list clustered by their spell level.
   */
  public void setSpellsByLevel(final Map<Integer, List<Spell>> spellsByLevel) {
    this.spellsByLevel = spellsByLevel;
  }

  /**
   * Returns the spells of the given spell level.
   *
   * @param level
   *     The level of the spells.
   *
   * @return The spells of the given level.
   */
  public List<Spell> getSpellsOfLevel(final int level) {
    List<Spell> spellsOfLevel = spellsByLevel.get(level);
    if (spellsOfLevel == null) {
      spellsOfLevel = new LinkedList<>();
    }
    return spellsOfLevel;
  }

  /**
   * Returns the number of spell levels of this spell list.
   *
   * @return The number of spell levels of this spell list.
   */
  public int getNumberOfSpellLevels() {
    return spellsByLevel.size();
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Returns all spells of the spell list.
   *
   * @return All spells of the spell list.
   */
  public List<Spell> getAllSpells() {
    final List<Spell> allSpells = new ArrayList<>();
    for (final List<Spell> spells : spellsByLevel.values()) {
      allSpells.addAll(spells);
    }
    return allSpells;
  }

  /**
   * Returns true if spell list is a domain.
   *
   * @return True if spell list is a domain.
   */
  public boolean isDomain() {
    return domain;
  }

  /**
   * Set if spell list is a domain.
   *
   * @param domain
   *     Set true for spell lists which are a domain.
   */
  public void setDomain(final boolean domain) {
    this.domain = domain;
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
    final Spelllist other = (Spelllist) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

  /**
   * Returns minimum spell level of the spell list.
   *
   * @return Minimum spell level of the spell list.
   */
  public int getMinLevel() {
    return minLevel;
  }

  /**
   * Set minimum spell level of spell list.
   *
   * @param minLevel
   *     The minimum spell level.
   */
  public void setMinLevel(final int minLevel) {
    this.minLevel = minLevel;
  }

  /**
   * Returns maximum spell level of spell list.
   *
   * @return Maximum spell level of spell list.
   */
  public int getMaxLevel() {
    return maxLevel;
  }

  /**
   * Set maximum spell level of spell list.
   *
   * @param maxLevel
   *     The maximum spell level.
   */
  public void setMaxLevel(final int maxLevel) {
    this.maxLevel = maxLevel;
  }

}
