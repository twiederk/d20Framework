package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass.AnyCharacterClass
import com.d20charactersheet.framework.boc.model.Race
import com.d20charactersheet.framework.boc.model.Size
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RaceServiceTest {

    private lateinit var gameSystem: GameSystem
    private lateinit var raceService: RaceService

    @Before
    fun setUp() {
        gameSystem = DnDv35Universe().gameSystem
        raceService = gameSystem.raceService
    }

    @Test
    fun testGetAllRaces() {
        val races = raceService.getAllRaces(gameSystem.allCharacterClasses, gameSystem.allAbilities)
        Assert.assertNotNull(races)
        Assert.assertEquals(19, races.size.toLong())
    }

    @Test
    fun testCreateRace() {
        val race = raceService.createRace(createRace())
        Assert.assertNotNull(race)
        Assert.assertTrue(race.id > 0)
    }

    private fun createRace(): Race {
        val race = Race()
        race.name = "testName"
        race.size = Size.MEDIUM
        race.baseLandSpeed = 30
        race.favoredCharacterClass = AnyCharacterClass.ANY_CHARACTER_CLASS
        race.abilities = createAbilities()
        return race
    }

    private fun createAbilities(): List<Ability> {
        val allAbilities = gameSystem.allAbilities
        val abilities: MutableList<Ability> = ArrayList()
        for (i in 0..9) {
            abilities.add(allAbilities[i])
        }
        return abilities
    }

    @Test
    fun testUpdateRace() {
        val originalRace = gameSystem.allRaces[0]
        val updateRace = createRace()
        updateRace.id = originalRace.id
        raceService.updateRace(updateRace)
        gameSystem.clear()
        val updatedRace = gameSystem.allRaces[0]
        Assert.assertEquals("testName", updatedRace.name)
        Assert.assertEquals(Size.MEDIUM, updatedRace.size)
        Assert.assertEquals(30, updatedRace.baseLandSpeed)
        Assert.assertEquals(AnyCharacterClass.ANY_CHARACTER_CLASS, updatedRace.favoredCharacterClass)
        Assert.assertEquals(10, updatedRace.abilities?.size)
        raceService.updateRace(originalRace)
    }

}