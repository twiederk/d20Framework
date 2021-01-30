package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.Universe
import com.d20charactersheet.framework.boc.model.*
import org.junit.jupiter.api.BeforeEach
import java.util.*

abstract class RuleServiceTestCase {

    lateinit var universe: Universe

    lateinit var gameSystem: GameSystem

    lateinit var ruleService: RuleService

    lateinit var allClasses: List<CharacterClass>

    lateinit var barbarian: CharacterClass
    lateinit var bard: CharacterClass
    lateinit var druid: CharacterClass
    lateinit var fighter: CharacterClass
    lateinit var monk: CharacterClass
    lateinit var ranger: CharacterClass
    lateinit var rogue: CharacterClass
    lateinit var wizard: CharacterClass

    lateinit var human: Race
    lateinit var elf: Race
    lateinit var gnome: Race
    lateinit var halfOrc: Race

    @BeforeEach
    fun setUp() {
        universe = createUniverse()
        gameSystem = universe.gameSystem
        ruleService = gameSystem.ruleService
        createCharacterClasses()
        createRaces()
        createCharacters()
    }

    abstract fun createUniverse(): Universe
    abstract fun createCharacterClasses()
    abstract fun createRaces()
    abstract fun createCharacters()

    fun createCharacter(characterClass: CharacterClass?, level: Int): Character {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(characterClass, level))
        character.classLevels = classLevels
        return character
    }

    fun createCharacter(classLevel: ClassLevel, race: Race?): Character {
        val character = createCharacter(classLevel.characterClass, classLevel.level)
        character.race = race
        return character
    }

    fun createCharacter(classLevel: ClassLevel, race: Race?, intelligence: Int): Character {
        val character = createCharacter(classLevel, race)
        character.intelligence = intelligence
        return character
    }

    fun createCharacter(classLevel1: ClassLevel, classLevel2: ClassLevel, race: Race?, intelligence: Int): Character {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(classLevel1)
        classLevels.add(classLevel2)
        character.classLevels = classLevels
        character.race = race
        character.intelligence = intelligence
        return character
    }

    fun createSkill(id: Int, name: String?): Skill {
        val skill = Skill()
        skill.id = id
        skill.name = name
        return skill
    }
}