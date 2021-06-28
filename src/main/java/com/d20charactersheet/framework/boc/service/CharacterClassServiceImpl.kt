package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.ClassDao

/**
 * Creates CharacterClassService with given data access object.
 * Handles character class specific tasks.
 *
 * @param classDao
 * The data access object to the persistent layer.
 */
class CharacterClassServiceImpl(private val classDao: ClassDao) : CharacterClassService {

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.getAllCharacterClasses
     */
    override fun getAllCharacterClasses(allSkills: List<Skill>, allAbilities: List<Ability>): List<CharacterClass> {
        return classDao.getAllCharacterClasses(allSkills, allAbilities)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.deleteSkill
     */
    override fun deleteSkill(skill: Skill) {
        classDao.deleteSkill(skill)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.updateCharacterClass
     */
    override fun updateCharacterClass(characterClass: CharacterClass) {
        classDao.updateCharacterClass(characterClass)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.createCharacterClass
     */
    override fun createCharacterClass(characterClass: CharacterClass): CharacterClass {
        classDao.createCharacterClass(characterClass)
        return characterClass
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.addSkill
     */
    override fun addSkill(skill: Skill, characterClasses: List<CharacterClass>) {
        classDao.addSkill(skill, characterClasses)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.findClassByName
     */
    override fun findClassByName(name: String, allClasses: List<CharacterClass>): CharacterClass {
        for (clazz in allClasses) {
            if (clazz.name == name) {
                return clazz
            }
        }
        throw IllegalArgumentException("Can't find class with name: $name")
    }

    override fun getStarterPack(
        characterClass: CharacterClass,
        starterPackData: StarterPackData
    ): StarterPack {

        val starterPackBoxesWithQueries = classDao.getStarterPackBoxesWithQueries(characterClass.id)

        val starterPack = StarterPack()
        for (starterPackBox in starterPackBoxesWithQueries.keys) {
            val starterBoxOptions = StarterPackHelper(starterPackData)
                .getStarterBoxOptions(starterPackBoxesWithQueries.getOrDefault(starterPackBox, listOf()))
            starterPackBox.addAll(starterBoxOptions)
            starterPack.add(starterPackBox)
        }

        characterClass.starterPack = starterPack

        return starterPack
    }

}