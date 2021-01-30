package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Skill

/**
 * The data access object to the persistent layer for character class objects.
 */
interface ClassDao {

    /**
     * Returns all character classes from the persistent layer. Skills are required to build the list of class skills.
     *
     * @param allSkills
     * All available skills in the game system.
     * @param allAbilities
     * All available abilities
     *
     * @return All character classes of the game system.
     */
    fun getAllCharacterClasses(allSkills: List<Skill>, allAbilities: List<Ability>): List<CharacterClass>

    /**
     * Deletes the given skill from all character classes.
     *
     * @param skill
     * The skill to delete from all character classes.
     */
    fun deleteSkill(skill: Skill)

    /**
     * Updates a character class to the persistent layer.
     *
     * @param characterClass
     * The character class to update.
     */
    fun updateCharacterClass(characterClass: CharacterClass)

    /**
     * Creates a character class in the persistent layer.
     *
     * @param characterClass
     * The character class to create.
     */
    fun createCharacterClass(characterClass: CharacterClass)

    /**
     * Adds the given skill as class skill to the given list of character classes.
     *
     * @param skill
     * The class skill to add.
     * @param characterClasses
     * The character classes to add the skill to.
     */
    fun addSkill(skill: Skill, characterClasses: List<CharacterClass>)
}