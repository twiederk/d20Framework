package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.PathfinderUniverse
import com.d20charactersheet.framework.Universe
import com.d20charactersheet.framework.boc.model.Character

abstract class PathfinderRuleServiceTestCase : RuleServiceTestCase() {

    lateinit var belvador: Character
    private lateinit var nascan: Character
    private lateinit var nyatar: Character
    private lateinit var jadzia: Character
    private lateinit var worf: Character
    private lateinit var rodrekr: Character
    private lateinit var thore: Character
    lateinit var kyra: Character
    private lateinit var merisiel: Character
    private lateinit var ezren: Character
    lateinit var valeros: Character
    lateinit var dorn: Character
    private lateinit var hakim: Character
    lateinit var toc: Character

    override fun createUniverse(): Universe {
        return PathfinderUniverse()
    }

    override fun createCharacterClasses() {
        allClasses = gameSystem.allCharacterClasses
        val classService = gameSystem.characterClassService
        barbarian = classService.findClassByName("Barbarian", allClasses)
        bard = classService.findClassByName("Bard", allClasses)
        druid = classService.findClassByName("Druid", allClasses)
        fighter = classService.findClassByName("Fighter", allClasses)
        monk = classService.findClassByName("Monk", allClasses)
        ranger = classService.findClassByName("Ranger", allClasses)
        rogue = classService.findClassByName("Rogue", allClasses)
        wizard = classService.findClassByName("Wizard", allClasses)
    }

    override fun createRaces() {
        val raceService = gameSystem.raceService
        val allRaces = gameSystem.allRaces
        human = raceService.findRaceByName("Human", allRaces)
        elf = raceService.findRaceByName("Elf", allRaces)
        gnome = raceService.findRaceByName("Gnome", allRaces)
        halfOrc = raceService.findRaceByName("Half-Orc", allRaces)
    }

    override fun createCharacters() {
        val characterService = gameSystem.characterService
        val allCharacters = gameSystem.allCharacters
        belvador = characterService.findCharacterByName("Belvador the Summoner", allCharacters)
        nyatar = characterService.findCharacterByName("Nyatar", allCharacters)
        jadzia = characterService.findCharacterByName("Jadzia", allCharacters)
        nascan = characterService.findCharacterByName("Nascan Schwarzhaut", allCharacters)
        worf = characterService.findCharacterByName("Worf", allCharacters)
        rodrekr = characterService.findCharacterByName("Rodrekr Vaeringjar", allCharacters)
        thore = characterService.findCharacterByName("Thore Stavanger", allCharacters)
        kyra = characterService.findCharacterByName("Kyra", allCharacters)
        merisiel = characterService.findCharacterByName("Merisiel", allCharacters)
        ezren = characterService.findCharacterByName("Ezren", allCharacters)
        valeros = characterService.findCharacterByName("Valeros", allCharacters)
        dorn = characterService.findCharacterByName("Dorn Evenwood", allCharacters)
        hakim = characterService.findCharacterByName("Hakim Al Dschech Ibn Sauri Harfed Ben Uluman", allCharacters)
        toc = characterService.findCharacterByName("Toc der Juengere", allCharacters)
    }
}