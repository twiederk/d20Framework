package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.KnownSpellsTable
import com.d20charactersheet.framework.boc.model.Spell
import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable

/**
 * Access object to persistent layer for spells and spell lists.
 */
interface SpelllistDao {
    
    /**
     * Returns all spells from the persistent layer.
     *
     * @return All spells from the persistent layer.
     */
    fun getAllSpells(): List<Spell>

    /**
     * Returns all spell lists from the persistent layer.
     *
     * @param allSpells
     * List of all spells.
     *
     * @return All spell lists from the persistent layer.
     */
    fun getAllSpelllists(allSpells: List<Spell>): List<Spelllist>

    /**
     * Returns the description of the spell.
     *
     * @param spellId
     * The id of the spell.
     *
     * @return The description of the spell.
     */
    fun getSpellDescription(spellId: Int): String

    /**
     * Creates a new spell in the persistent layer.
     *
     * @param spell
     * The spell to create.
     *
     * @return The spell with the new id in the persistance layer.
     */
    fun createSpell(spell: Spell): Spell

    /**
     * Delete a spell.
     *
     * @param spell
     * The spell to delete.
     */
    fun deleteSpell(spell: Spell)

    /**
     * Update a spell.
     *
     * @param spell
     * The spell to update.
     */
    fun updateSpell(spell: Spell)

    /**
     * Assign a spell to a spell list with the given level.
     *
     * @param spelllist
     * The spell list to add the spell to.
     * @param spell
     * The spell to add.
     * @param level
     * The level to add the spell to the spell list.
     */
    fun createSpelllevel(spelllist: Spelllist, spell: Spell, level: Int)

    /**
     * Update the level of a spell assigned to a spell list.
     *
     * @param spelllist
     * The spell list to update the assignment.
     * @param spell
     * The spell to update the assignment.
     * @param level
     * The level to update.
     */
    fun updateSpelllevel(spelllist: Spelllist, spell: Spell, level: Int)

    /**
     * Delete a spell assignment.
     *
     * @param spelllist
     * The spell list to delete the spell from.
     * @param spell
     * The spell to delete.
     */
    fun deleteSpelllevel(spelllist: Spelllist, spell: Spell)

    /**
     * Create a spell list with name and short name, but without spell assignments.
     *
     * @param spelllist
     * The spell list to create.
     *
     * @return The spell list with the new it from the persistant layer.
     */
    fun createSpelllist(spelllist: Spelllist): Spelllist

    /**
     * Delete spellist. Deletes name and short name, but no spell assignments.
     *
     * @param spelllist
     * The spell list to delete.
     */
    fun deleteSpelllist(spelllist: Spelllist)

    /**
     * Update the name and short name of a spell list.
     *
     * @param spelllist
     * The spell list to update.
     */
    fun updateSpelllist(spelllist: Spelllist)

    /**
     * Returns all known spells tables.
     *
     * @return All known spells tables.
     */
    fun getAllKnownSpellsTables(): List<KnownSpellsTable>

    /**
     * Returns all spells per day tables.
     *
     * @return All spells per day tables.
     */
    fun getAllSpellsPerDayTables(): List<SpellsPerDayTable>
}