package com.d20charactersheet.framework.boc.service.exportimport

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.Universe
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilderFactory

class ImportCharacterV1XmlTest {

    private lateinit var importCharacter: ImportCharacterV1Xml
    private lateinit var document: Document

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val universe: Universe = DnDv35Universe()
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        document = builder.newDocument()
        val gameSystem = universe.gameSystem
        val importContext = ImportContext()
        importContext.gameSystemName = gameSystem.name
        importContext.allRaces = gameSystem.allRaces
        importContext.allClasses = gameSystem.allCharacterClasses
        importContext.allXpTables = gameSystem.allXpTables
        importContext.allSkills = gameSystem.allSkills
        importContext.allFeats = gameSystem.allFeats
        importContext.allWeapons = gameSystem.allWeapons
        importContext.allArmor = gameSystem.allArmor
        importContext.allGoods = gameSystem.allGoods
        importContext.allSpells = gameSystem.allSpells
        importContext.allSpelllists = gameSystem.allSpelllists
        importContext.allAbilities = gameSystem.allAbilities
        importCharacter = ImportCharacterV1Xml(importContext, document)
    }

    @Test
    fun testGetRace() {
        val raceElement = document.createElement(XmlConstants.TAG_RACE)
        raceElement.textContent = "High Elf"
        val race = importCharacter.ImportAppearance().getRace(raceElement)
        Assert.assertEquals(2, race.id.toLong())
        Assert.assertEquals("High Elf", race.name)
    }
}