package com.d20charactersheet.framework.boc.service.exportimport

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.Universe
import com.d20charactersheet.framework.boc.service.GameSystem
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.io.File
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory

class ImportFactoryTest {

    private lateinit var importFactory: ImportFactoryImpl
    private lateinit var gameSystem: GameSystem

    @Before
    fun setUp() {
        val universe: Universe = DnDv35Universe()
        gameSystem = universe.gameSystem
        importFactory = ImportFactoryImpl()
    }

    @Test
    @Ignore
    @Throws(Exception::class)
    fun testGetImportCharacter() {
        val importContext = ImportContext()
        importContext.gameSystemName = gameSystem.name
        val importCharacter = importFactory.getImportCharacter(importContext, IMPORT_CHARACTER_V1_FILE)
        Assert.assertNotNull(importCharacter)
        Assert.assertTrue(importCharacter is ImportCharacterV1Xml)
    }

    @Test
    @Ignore
    @Throws(Exception::class)
    fun testGetImportEquipment() {
        val importContext = ImportContext()
        importContext.gameSystemName = gameSystem.name
        importContext.allWeapons = ArrayList()
        importContext.allArmor = ArrayList()
        importContext.allGoods = ArrayList()
        val importEquipment = importFactory.getImportEquipment(importContext, IMPORT_CHARACTER_V1_FILE)
        Assert.assertNotNull(importEquipment)
        Assert.assertTrue(importEquipment is ImportEquipmentV1Xml)
    }

    @Test
    @Throws(Exception::class)
    fun testCheckGameSystem() {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val document = builder.newDocument()
        val charactersElement = document.createElement(XmlConstants.TAG_CHARACTERS)
        charactersElement.setAttribute(XmlConstants.ATTRIBUTE_GAMESYSTEM, "Pathfinder")
        try {
            importFactory.checkGameSystem(gameSystem.name, charactersElement)
            Assert.fail("Missing exception: Expected IllegalStateException")
        } catch (illegalStateException: IllegalStateException) {
            // success expected exception is thrown
        } catch (exception: Exception) {
            Assert.fail("Wrong exception: Expected IllegalStateException")
        }
    }

    companion object {
        private val IMPORT_DIR = File("src/test/resources/exportimport")
        val IMPORT_CHARACTER_V1_FILE = File(IMPORT_DIR, "d20cs_characters_v1_unit_test.xml")
//        val IMPORT_EQUIPMENT_V1_FILE = File(IMPORT_DIR, "d20cs_equipment_v1_unit_test.xml")
    }
}