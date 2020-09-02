package com.d20charactersheet.framework.boc.model;

import java.util.EnumSet;

/**
 * The SpelllistAbility provides access to a spell list.
 */
public class SpelllistAbility extends Ability {

  private static final long serialVersionUID = 1L;

  private Spelllist spelllist;

  private Attribute spellAttribute;

  private CastingType castingType;

  private SpellSource spellSource;

  private KnownSpellsTable knownSpellsTable;

  private SpellsPerDayTable spellsPerDayTable;

  private EnumSet<School> schools;

  private boolean attributeBonusSpellSlots;

  /**
   * Returns the spell list available by this ability.
   *
   * @return The spell list.
   */
  public Spelllist getSpelllist() {
    return spelllist;
  }

  /**
   * Sets the spell list available by this ability.
   *
   * @param spelllist
   *     The spell list.
   */
  public void setSpelllist(final Spelllist spelllist) {
    this.spelllist = spelllist;
  }

  /**
   * Returns attribute to get extra spell slots for the spell list.
   *
   * @return Attribute to get extra spell slots for the spell list.
   */
  public Attribute getSpellAttribute() {
    return spellAttribute;
  }

  /**
   * Set attribute to get extra spell slots.
   *
   * @param spellAttribute
   *     Attribute to get extra spell slots.
   */
  public void setSpellAttribute(final Attribute spellAttribute) {
    this.spellAttribute = spellAttribute;
  }

  /**
   * Returns casting type of spell list.
   *
   * @return Casting type of spell list.
   */
  public CastingType getCastingType() {
    return castingType;
  }

  /**
   * Set casting type of spell list.
   *
   * @param castingType
   *     Casting type to set.
   */
  public void setCastingType(final CastingType castingType) {
    this.castingType = castingType;
  }

  /**
   * Returns spell source of spell list.
   *
   * @return Spell source of spell list.
   */
  public SpellSource getSpellSource() {
    return spellSource;
  }

  /**
   * Set spell source of spell list.
   *
   * @param spellSource
   *     The spell source to set.
   */
  public void setSpellSource(final SpellSource spellSource) {
    this.spellSource = spellSource;
  }

  /**
   * Returns the known spells table.
   *
   * @return The known spells table.
   */
  public KnownSpellsTable getKnownSpellsTable() {
    return knownSpellsTable;
  }

  /**
   * Set known spells table.
   *
   * @param knownSpellsTable
   *     The known spells table.
   */
  public void setKnownSpellsTable(final KnownSpellsTable knownSpellsTable) {
    this.knownSpellsTable = knownSpellsTable;
  }

  /**
   * Returns spells per day table.
   *
   * @return Spells per day table.
   */
  public SpellsPerDayTable getSpellsPerDayTable() {
    return spellsPerDayTable;
  }

  /**
   * Set spells per day table.
   *
   * @param spellsPerDayTable
   *     The spells per day table to set.
   */
  public void setSpellsPerDayTable(final SpellsPerDayTable spellsPerDayTable) {
    this.spellsPerDayTable = spellsPerDayTable;
  }

  /**
   * Returns the schools supported by the spell list ability.
   *
   * @return The schools supported by the spell list ability.
   */
  public EnumSet<School> getSchools() {
    return schools;
  }

  /**
   * Set schools supported by spell list ability.
   *
   * @param schools
   *     The supported schools.
   */
  public void setSchools(final EnumSet<School> schools) {
    this.schools = schools;
  }

  /**
   * Returns true, if attribute provides additional spell slots.
   *
   * @return True, if attribute provides additional spell slots.
   */
  public boolean isAttributeBonusSpellSlots() {
    return attributeBonusSpellSlots;
  }

  /**
   * Set if attribute provides additional spell slots.
   *
   * @param attributeBonusSpellSlots
   *     Set to true to get additional spell slots by the attribute.
   */
  public void setAttributeBonusSpellSlots(final boolean attributeBonusSpellSlots) {
    this.attributeBonusSpellSlots = attributeBonusSpellSlots;
  }

}
