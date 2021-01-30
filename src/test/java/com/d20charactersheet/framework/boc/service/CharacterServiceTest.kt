package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.Universe
import org.junit.Before

class CharacterServiceTest : BaseCharacterServiceTest() {

    @Before
    fun setUp() {
        val universe: Universe = DnDv35Universe()
        gameSystem = universe.gameSystem
        val characterClassService = gameSystem.characterClassService
        fighter = characterClassService.findClassByName("Fighter", gameSystem.allCharacterClasses)
        wizard = characterClassService.findClassByName("Wizard", gameSystem.allCharacterClasses)
        val raceService = gameSystem.raceService
        human = raceService.findRaceByName("Human", gameSystem.allRaces)
    }

    override fun testDeleteCharacter() {
        // can only be implemented with an ImageService
    }

    override fun getNumberOfCharacters(): Int {
        // number of characters in dndv35_phb_character.sql
        return 14
    }
}