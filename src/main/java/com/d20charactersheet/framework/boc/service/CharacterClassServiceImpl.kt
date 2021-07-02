package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.ClassDao

/**
 * Handles character class specific tasks.
 */
class CharacterClassServiceImpl
/**
 * Creates CharacterClassService with given data access object.
 *
 * @param characterClassDao
 * The data access object to the persistent layer.
 */(private val characterClassDao: ClassDao) : CharacterClassService {
    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.getAllCharacterClasses
     */
    override fun getAllCharacterClasses(allSkills: List<Skill>, allAbilities: List<Ability>): List<CharacterClass> {
        return characterClassDao.getAllCharacterClasses(allSkills, allAbilities)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.deleteSkill
     */
    override fun deleteSkill(skill: Skill) {
        characterClassDao.deleteSkill(skill)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.updateCharacterClass
     */
    override fun updateCharacterClass(characterClass: CharacterClass) {
        characterClassDao.updateCharacterClass(characterClass)
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.createCharacterClass
     */
    override fun createCharacterClass(characterClass: CharacterClass): CharacterClass {
        characterClassDao.createCharacterClass(characterClass)
        return characterClass
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.CharacterClassService.addSkill
     */
    override fun addSkill(skill: Skill, characterClasses: List<CharacterClass>) {
        characterClassDao.addSkill(skill, characterClasses)
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
}