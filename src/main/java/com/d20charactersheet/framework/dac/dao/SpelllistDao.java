package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;

/**
 * Access object to persistent layer for spells and spell lists.
 */
public interface SpelllistDao {

  /**
   * Returns all spells from the persistent layer.
   *
   * @return All spells from the persistent layer.
   */
  public List<Spell> getAllSpells();

  /**
   * Returns all spell lists from the persistent layer.
   *
   * @param allSpells
   *     List of all spells.
   *
   * @return All spell lists from the persistent layer.
   */
  public List<Spelllist> getAllSpelllists(List<Spell> allSpells);

  /**
   * Returns the description of the spell.
   *
   * @param spellId
   *     The id of the spell.
   *
   * @return The description of the spell.
   */
  public String getSpellDescription(int spellId);

  /**
   * Creates a new spell in the persistent layer.
   *
   * @param spell
   *     The spell to create.
   *
   * @return The spell with the new id in the persistance layer.
   */
  public Spell createSpell(Spell spell);

  /**
   * Delete a spell.
   *
   * @param spell
   *     The spell to delete.
   */
  public void deleteSpell(Spell spell);

  /**
   * Update a spell.
   *
   * @param spell
   *     The spell to update.
   */
  public void updateSpell(Spell spell);

  /**
   * Assign a spell to a spell list with the given level.
   *
   * @param spelllist
   *     The spell list to add the spell to.
   * @param spell
   *     The spell to add.
   * @param level
   *     The level to add the spell to the spell list.
   */
  public void createSpelllevel(Spelllist spelllist, Spell spell, int level);

  /**
   * Update the level of a spell assigned to a spell list.
   *
   * @param spelllist
   *     The spell list to update the assignment.
   * @param spell
   *     The spell to update the assignment.
   * @param level
   *     The level to update.
   */
  public void updateSpelllevel(Spelllist spelllist, Spell spell, int level);

  /**
   * Delete a spell assignment.
   *
   * @param spelllist
   *     The spell list to delete the spell from.
   * @param spell
   *     The spell to delete.
   */
  public void deleteSpelllevel(Spelllist spelllist, Spell spell);

  /**
   * Create a spell list with name and short name, but without spell assignments.
   *
   * @param spelllist
   *     The spell list to create.
   *
   * @return The spell list with the new it from the persistant layer.
   */
  public Spelllist createSpelllist(Spelllist spelllist);

  /**
   * Delete spellist. Deletes name and short name, but no spell assignments.
   *
   * @param spelllist
   *     The spell list to delete.
   */
  public void deleteSpelllist(Spelllist spelllist);

  /**
   * Update the name and short name of a spell list.
   *
   * @param spelllist
   *     The spell list to update.
   */
  public void updateSpelllist(Spelllist spelllist);

  /**
   * Returns all known spells tables.
   *
   * @return All known spells tables.
   */
  public List<KnownSpellsTable> getAllKnownSpellsTables();

  /**
   * Returns all spells per day tables.
   *
   * @return All spells per day tables.
   */
  public List<SpellsPerDayTable> getAllSpellsPerDayTables();

}
