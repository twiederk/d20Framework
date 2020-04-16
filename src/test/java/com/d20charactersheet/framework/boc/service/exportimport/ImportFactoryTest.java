package com.d20charactersheet.framework.boc.service.exportimport;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.boc.service.GameSystem;

public class ImportFactoryTest {

  public static final File IMPORT_DIR = new File("src/test/resources/exportimport");
  public static final File IMPORT_CHARACTER_V1_FILE = new File(IMPORT_DIR, "d20cs_characters_v1_unit_test.xml");
  public static final File IMPORT_EQUIPMENT_V1_FILE = new File(IMPORT_DIR, "d20cs_equipment_v1_unit_test.xml");

  private ImportFactoryImpl importFactory;
  private GameSystem gameSystem;

  @Before
  public void setUp() {
    final Universe universe = new DnDv35Universe();
    gameSystem = universe.getGameSystem();
    importFactory = new ImportFactoryImpl();
  }

  @Test
  @Ignore
  public void testGetImportCharacter() throws Exception {
    final ImportContext importContext = new ImportContext();
    importContext.setGameSystemName(gameSystem.getName());
    final ImportCharacter importCharacter = importFactory.getImportCharacter(importContext, IMPORT_CHARACTER_V1_FILE);
    assertNotNull(importCharacter);
    assertTrue(importCharacter instanceof ImportCharacterV1Xml);
  }

  @Test
  @Ignore
  public void testGetImportEquipment() throws Exception {
    final ImportContext importContext = new ImportContext();
    importContext.setGameSystemName(gameSystem.getName());
    importContext.setAllWeapons(new ArrayList<>());
    importContext.setAllArmor(new ArrayList<>());
    importContext.setAllGoods(new ArrayList<>());
    final ImportEquipment importEquipment = importFactory.getImportEquipment(importContext, IMPORT_CHARACTER_V1_FILE);
    assertNotNull(importEquipment);
    assertTrue(importEquipment instanceof ImportEquipmentV1Xml);
  }

  @Test
  public void testCheckGameSystem() throws Exception {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    final DocumentBuilder builder = factory.newDocumentBuilder();
    final Document document = builder.newDocument();

    final Element charactersElement = document.createElement(XmlConstants.TAG_CHARACTERS);
    charactersElement.setAttribute(XmlConstants.ATTRIBUTE_GAMESYSTEM, "Pathfinder");

    try {
      importFactory.checkGameSystem(gameSystem.getName(), charactersElement);
      fail("Missing exception: Expected IllegalStateException");
    } catch (final IllegalStateException illegalStateException) {
      // success expected exception is thrown
    } catch (final Exception exception) {
      fail("Wrong exception: Expected IllegalStateException");
    }
  }

}
