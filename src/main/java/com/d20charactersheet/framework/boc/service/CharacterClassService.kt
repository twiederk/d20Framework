package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

/**
 * Provides services about character classes.
 */
interface CharacterClassService {
    /**
     * Returns all character classes. The skills are necessary to build up the class skills.
     *
     * @param allSkills
     * All skills of the game system.
     * @param allAbilities
     * All available class abilities
     *
     * @return All character classes of the game system.
     */
    fun getAllCharacterClasses(allSkills: List<Skill>, allAbilities: List<Ability>): List<CharacterClass>

    /**
     * Deletes the skill from all character classes.
     *
     * @param skill
     * The skill to delete.
     */
    fun deleteSkill(skill: Skill)

    /**
     * Updates the character class in the persistent layer.
     *
     * @param characterClass
     * The character class to update.
     */
    fun updateCharacterClass(characterClass: CharacterClass)

    /**
     * Creates a character class with valid id.
     *
     * @param characterClass
     * The character class to create.
     *
     * @return The created character class with valid id.
     */
    fun createCharacterClass(characterClass: CharacterClass): CharacterClass

    /**
     * Adds the skill as class skill to the character class.
     *
     * @param skill
     * The skill to add as class skill.
     * @param characterClasses
     * The character classes to add the skill to.
     */
    fun addSkill(skill: Skill, characterClasses: List<CharacterClass>)

    /**
     * Find class by name.
     *
     * @param name
     * The name of the class.
     * @param allClasses
     * The classes to search through.
     *
     * @return The class with the given name
     */
    fun findClassByName(name: String, allClasses: List<CharacterClass>): CharacterClass

    /**
     * Get start pack of class.
     *
     * @param characterClass
     * The class to get the starter pack of.
     * @param starterPackData
     * The data required to create the starter pack of the class
     *
     * @return
     * The start pack of the class.
     */
    fun getStarterPack(
        characterClass: CharacterClass,
        starterPackData: StarterPackData
    ): StarterPack

}