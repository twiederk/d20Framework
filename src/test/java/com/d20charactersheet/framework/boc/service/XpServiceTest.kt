package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassLevel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class XpServiceTest {

    private lateinit var xpService: XpService

    @Before
    fun setUp() {
        val gameSystem = DnDv35Universe().gameSystem
        xpService = gameSystem.xpService
    }

    @Test
    fun testGetAllXpTables() {
        val allXpTables = xpService.allXpTables
        Assert.assertNotNull("allXpTables can't be null", allXpTables)
        Assert.assertEquals(1, allXpTables.size.toLong())
        val xpTable = allXpTables[0]
        Assert.assertEquals(1, xpTable.id.toLong())
        Assert.assertEquals("Normal", xpTable.name)
        Assert.assertNotNull(xpTable.levels)
    }

    @Test
    fun testGetNextLevelAt() {
        val allXpTables = xpService.allXpTables
        val xpTable = allXpTables[0]
        Assert.assertEquals(1000, xpService.getNextLevelAt(xpTable, 1).toLong())
        Assert.assertEquals(15000, xpService.getNextLevelAt(xpTable, 5).toLong())
        Assert.assertEquals(55000, xpService.getNextLevelAt(xpTable, 10).toLong())
        Assert.assertEquals(120000, xpService.getNextLevelAt(xpTable, 15).toLong())
        Assert.assertEquals(190000, xpService.getNextLevelAt(xpTable, 20).toLong())
    }

    @Test
    fun testGetNextLevelAtZeroLevel() {
        val allXpTables = xpService.allXpTables
        val xpTable = allXpTables[0]
        Assert.assertEquals(0, xpService.getNextLevelAt(xpTable, 0).toLong())
    }

    @Test
    fun testGetNextLevelAtNegativeLevel() {
        val allXpTables = xpService.allXpTables
        val xpTable = allXpTables[0]
        try {
            xpService.getNextLevelAt(xpTable, -1)
            Assert.fail("Missing Exception: expected IllegalArgumentException")
        } catch (illegalArgumentException: IllegalArgumentException) {
            // success: expected exception thrown
        } catch (exception: Exception) {
            Assert.fail("Wrong Exception: expected IllegalArgumentException")
        }
    }

    @Test
    fun testIsValidExperiencePointsToCharacterLevel() {
        val character: Character = Character().apply {
            classLevels = listOf(
                ClassLevel(CharacterClass().apply {
                    this.classAbilities = listOf()
                }, 1)
            )
        }
        val allXpTables = xpService.allXpTables
        val xpTable = allXpTables[0]
        character.xpTable = xpTable

        Assert.assertFalse(xpService.isValidExperiencePointsToCharacterLevel(-1, character))
        Assert.assertTrue(xpService.isValidExperiencePointsToCharacterLevel(0, character))
        Assert.assertTrue(xpService.isValidExperiencePointsToCharacterLevel(500, character))
        Assert.assertTrue(xpService.isValidExperiencePointsToCharacterLevel(999, character))
        Assert.assertFalse(xpService.isValidExperiencePointsToCharacterLevel(1000, character))
        Assert.assertFalse(xpService.isValidExperiencePointsToCharacterLevel(1500, character))
    }
}