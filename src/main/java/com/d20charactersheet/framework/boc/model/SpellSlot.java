package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The spell slot of a character.
 */
public class SpellSlot implements Serializable {

  private static final long serialVersionUID = 3716473999349530118L;

  /**
   * Empty spell if no real spell is assigned to the slot
   */
  public static final Spell EMPTY_SPELL = new EmptySpell();

  /**
   * The id of new slots, which aren't persistent already
   */
  public static final int NEW_ID = 0;

  private int id;

  private Spell spell;

  private int level;

  private boolean cast;

  private List<SpelllistAbility> spelllistAbilities;

  private List<Feat> metamagicFeats;

  private static class EmptySpell extends Spell {

    private static final long serialVersionUID = 1L;

    private EmptySpell() {
      super();
      setId(-1);
      setName("EMPTY SPELL");
      setSchool(School.UNIVERSAL);
      setShortDescription("");
    }
  }

  /**
   * Instanciate spell slot with empty spell.
   */
  public SpellSlot() {
    this.id = NEW_ID;
    this.spell = EMPTY_SPELL;
    this.spelllistAbilities = new LinkedList<>();
    this.metamagicFeats = new LinkedList<>();
  }

  /**
   * Returns id of the spell slot.
   *
   * @return Id of the spell slot.
   */
  public int getId() {
    return id;
  }

  /**
   * Set id of spell slot.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the spell of the spell slot.
   *
   * @return The spell of the spell slot.
   */
  public Spell getSpell() {
    return spell;
  }

  /**
   * Set the spell of the spell slot.
   *
   * @param spell
   *     The spell to set.
   */
  public void setSpell(final Spell spell) {
    this.spell = spell;
  }

  /**
   * Returns level of the spell slot.
   *
   * @return Level of the spell slot.
   */
  public int getLevel() {
    return level;
  }

  /**
   * Set level of spell slot.
   *
   * @param level
   *     The level to set.
   */
  public void setLevel(final int level) {
    this.level = level;
  }

  /**
   * Returns if spell is already cast.
   *
   * @return True, if spell is already cast.
   */
  public boolean isCast() {
    return cast;
  }

  /**
   * Set if spell is cast.
   *
   * @param cast
   *     True, for cast spells.
   */
  public void setCast(final boolean cast) {
    this.cast = cast;
  }

  /**
   * Returns spell list abilities assigned to this spell slot.
   *
   * @return Spell list abilities assigned to this spell slot.
   */
  public List<SpelllistAbility> getSpelllistAbilities() {
    return spelllistAbilities;
  }

  /**
   * Sets spell list abilities assigned to this spell slot.
   *
   * @param spelllistAbilities
   *     The spell list abilities to set.
   */
  public void setSpelllistAbilities(final List<SpelllistAbility> spelllistAbilities) {
    this.spelllistAbilities = spelllistAbilities;
  }

  /**
   * Returns true, if spell slot is domain spell slot.
   *
   * @return True, if spell slot is domain spell slot.
   */
  public boolean isDomain() {
    for (final SpelllistAbility spelllistAbility : spelllistAbilities) {
      if (spelllistAbility.getSpelllist().isDomain()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    final StringBuilder output = new StringBuilder();
    for (final Iterator<SpelllistAbility> iterator = spelllistAbilities.iterator(); iterator.hasNext(); ) {
      final SpelllistAbility spelllistAbility = iterator.next();
      output.append(spelllistAbility.getName());
      if (iterator.hasNext()) {
        output.append(", ");
      }
    }
    output.append(" (").append(level).append("): ");
    output.append(spell.getName());
    return output.toString();
  }

  /**
   * Add spell list ability to spell slot.
   *
   * @param spelllistAbility
   *     The spell list ability to add.
   */
  public void addSpelllistAbility(final SpelllistAbility spelllistAbility) {
    spelllistAbilities.add(spelllistAbility);
  }

  /**
   * Returns school the spell must belong to.
   *
   * @return School the spell must belong to.
   */
  public EnumSet<School> getSchools() {
    final EnumSet<School> schools = EnumSet.noneOf(School.class);
    for (final SpelllistAbility spelllistAbility : spelllistAbilities) {
      schools.addAll(spelllistAbility.getSchools());
    }
    return schools;
  }

  /**
   * Returns spell lists the spell must belong to.
   *
   * @return Spell lists the spell must belong to.
   */
  public List<Spelllist> getSpelllists() {
    final List<Spelllist> spelllists = new LinkedList<>();
    for (final SpelllistAbility spelllistAbility : spelllistAbilities) {
      final Spelllist spelllist = spelllistAbility.getSpelllist();
      if (!spelllists.contains(spelllist)) {
        spelllists.add(spelllist);
      }
    }
    return spelllists;
  }

  /**
   * Returns the metamagic feats checked for the spell slot.
   *
   * @return The metamagic feats checked for the spell slot.
   */
  public List<Feat> getMetamagicFeats() {
    return metamagicFeats;
  }

  /**
   * Sets the metamagic feats for the spell slot.
   *
   * @param metamagicFeats
   *     The metamagic feats to set.
   */
  public void setMetamagicFeats(final List<Feat> metamagicFeats) {
    this.metamagicFeats = metamagicFeats;
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
    final SpellSlot other = (SpellSlot) obj;
    return id == other.id;
  }

}
