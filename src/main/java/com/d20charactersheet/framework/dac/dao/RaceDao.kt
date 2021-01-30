package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Race

/**
 * Interface to persistent data of races.
 */
interface RaceDao {
    
    /**
     * Returns all races of the game system.
     *
     * @param allCharacterClasses
     * All character classes of the game system.
     * @param allAbilities
     * All abilities of the game system.
     *
     * @return All races of the game system.
     */
    fun getAllRaces(allCharacterClasses: List<CharacterClass>, allAbilities: List<Ability>): List<Race>

    /**
     * Creates a new race in the persistent layer. Fills the id of the race.
     *
     * @param race
     * The race to create.
     *
     * @return The created race with id.
     */
    fun createRace(race: Race): Race

    /**
     * Deletes the race from the persistent layer.
     *
     * @param race
     * The race to delete.
     */
    fun deleteRace(race: Race)

    /**
     * Update the race in the persistent layer.
     *
     * @param race
     * The race to update.
     */
    fun updateRace(race: Race)
}