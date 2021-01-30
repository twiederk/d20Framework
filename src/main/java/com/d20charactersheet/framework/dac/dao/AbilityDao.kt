package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.KnownSpellsTable
import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityBuilderFactory

/**
 * Interface to persistent layer about abilities.
 */
interface AbilityDao {

    /**
     * Returns all abilities.
     *
     * @param allSpelllists
     * All spell lists of game system.
     * @param allKnownSpellsTables
     * All known spells tables of game system.
     * @param allSpellsPerDayTables
     * All spells per day tables of game system.
     *
     * @return All abilities.
     */
    fun getAllAbilities(allSpelllists: List<Spelllist>, allKnownSpellsTables: List<KnownSpellsTable>,
                        allSpellsPerDayTables: List<SpellsPerDayTable>): List<Ability>

    /**
     * Creates a new ability in the persistent layer and sets its id.
     *
     * @param ability
     * The ability to create.
     *
     * @return The created ability with the id set.
     */
    fun createAbility(ability: Ability): Ability

    /**
     * Updates the ability in the persistent layer.
     *
     * @param ability
     * The ability to update.
     */
    fun updateAbility(ability: Ability)

    /**
     * Deletes class ability.
     *
     * @param ability
     * Ability to delete.
     */
    fun deleteAbility(ability: Ability)

    /**
     * Creates the AbilityBuilderFactory with the given spelllists.
     *
     * @param allSpelllists
     * All spell lists of the game system.
     * @param allKnownSpellsTables
     * All known spells tables of game system.
     * @param allSpellsPerDayTables
     * All spells per day tables of game system.
     *
     * @return The AbilityBuilderFactory.
     */
    fun createAbilityBuilderFactory(allSpelllists: List<Spelllist>, allKnownSpellsTables: List<KnownSpellsTable>,
                                    allSpellsPerDayTables: List<SpellsPerDayTable>): AbilityBuilderFactory
}