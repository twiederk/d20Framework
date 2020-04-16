package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;

/**
 * Administration of spells and spell lists.
 */
public interface SpelllistService {

  /**
   * Returns all spells of the game system.
   *
   * @return All spells.
   */
  List<Spell> getAllSpells();

  /**
   * Returns all spell lists.
   *
   * @param allSpells
   *     All spells of the game system.
   *
   * @return All spell lists.
   */
  List<Spelllist> getAllSpelllists(List<Spell> allSpells);

  /**
   * Adds the description of the spell, if it is empty.
   *
   * @param spell
   *     The spell to add the description to.
   *
   * @return The spell with description.
   */
  Spell getSpellDescription(Spell spell);

  /**
   * Returns the spell with the given id out of the list of spells.
   *
   * @param spellId
   *     The id of the spell to return.
   * @param allSpells
   *     The list of spells to search for the spell.
   *
   * @return The spell with the given id.
   */
  Spell findSpellById(int spellId, List<Spell> allSpells);

  /**
   * Create a new spell.
   *
   * @param spell
   *     The spell to create.
   *
   * @return The created spell.
   */
  Spell createSpell(Spell spell);

  /**
   * Delete a spell.
   *
   * @param spell
   *     The spell to delete.
   */
  void deleteSpell(Spell spell);

  /**
   * Update a spell
   *
   * @param spell
   *     The spell to update.
   */
  void updateSpell(Spell spell);

  /**
   * Returns the spell list with the given id.
   *
   * @param spelllistId
   *     The id of the spell list.
   * @param allSpelllists
   *     The spell lists to search.
   *
   * @return The spell list with the given. id.
   */
  Spelllist findSpelllistById(int spelllistId, List<Spelllist> allSpelllists);

  /**
   * Assign a spell to a spell list with the given level.
   *
   * @param spelllist
   *     The spell list to assign the spell to.
   * @param spell
   *     The spell to assign.
   * @param level
   *     The level to assign the spell to the spell list.
   */
  boolean createSpelllevel(Spelllist spelllist, Spell spell, int level);

  /**
   * Update a spell assignment.
   *
   * @param spelllist
   *     The spell list of the spell.
   * @param spell
   *     The spell.
   * @param level
   *     The level to update.
   */
  void updateSpelllevel(Spelllist spelllist, Spell spell, int level);

  /**
   * Create a new spell list without assignments.
   *
   * @param spelllist
   *     The spell list to create.
   *
   * @return The created spell list.
   */
  Spelllist createSpelllist(Spelllist spelllist);

  /**
   * Delete spell list, without assignments.
   *
   * @param spelllist
   *     The spell list to delete.
   */
  void deleteSpelllist(Spelllist spelllist);

  /**
   * Update spell list.
   *
   * @param spelllist
   *     The spell list to update.
   */
  void updateSpelllist(Spelllist spelllist);

  /**
   * Delete spell list.
   *
   * @param spelllist
   *     The spell list to delete.
   * @param spell
   *     The spell to delete
   */
  void deleteSpelllevel(Spelllist spelllist, Spell spell);

  /**
   * Returns all known spells tables.
   *
   * @return All known spells tables.
   */
  List<KnownSpellsTable> getAllKnownSpellsTables();

  /**
   * Returns all spells per day tables.
   *
   * @return All spells per day tables.
   */
  List<SpellsPerDayTable> getAllSpellsPerDayTables();

  /**
   * Find spell by given name.
   *
   * @param name
   *     The name of the spell to find.
   * @param allSpells
   *     The spells to search through.
   *
   * @return The spell with the given name.
   */
  Spell findSpellByName(String name, List<Spell> allSpells);

  /**
   * Find spell list by name.
   *
   * @param name
   *     The name of the spell list to find.
   * @param allSpelllists
   *     The spell list to search throug.
   *
   * @return The spell list with the given name.
   */
  Spelllist findSpelllistByName(String name, List<Spelllist> allSpelllists);
}
