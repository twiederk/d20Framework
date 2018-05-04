package com.d20charactersheet.framework.boc.service.exportimport;

import static org.junit.Assert.assertEquals;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.service.GameSystem;

public class ImportCharacterV1XmlTest {

  private ImportCharacterV1Xml importCharacter;
  private Document document;

  @Before
  public void setUp() throws Exception {
    final Universe universe = new DnDv35Universe();
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    final DocumentBuilder builder = factory.newDocumentBuilder();
    document = builder.newDocument();
    final GameSystem gameSystem = universe.getGameSystem();
    final ImportContext importContext = new ImportContext();
    importContext.setGameSystemName(gameSystem.getName());
    importContext.setAllRaces(gameSystem.getAllRaces());
    importContext.setAllClasses(gameSystem.getAllCharacterClasses());
    importContext.setAllXpTables(gameSystem.getAllXpTables());
    importContext.setAllSkills(gameSystem.getAllSkills());
    importContext.setAllFeats(gameSystem.getAllFeats());
    importContext.setAllWeapons(gameSystem.getAllWeapons());
    importContext.setAllArmor(gameSystem.getAllArmor());
    importContext.setAllGoods(gameSystem.getAllGoods());
    importContext.setAllSpells(gameSystem.getAllSpells());
    importContext.setAllSpelllists(gameSystem.getAllSpelllists());
    importContext.setAllAbilities(gameSystem.getAllAbilities());
    importCharacter = new ImportCharacterV1Xml(importContext, document);
  }

  @Test
  public void testGetRace() throws Exception {
    final Element raceElement = document.createElement(XmlConstants.TAG_RACE);
    raceElement.setTextContent("High Elf");

    final Race race = importCharacter.new ImportAppearance().getRace(raceElement);

    assertEquals(2, race.getId());
    assertEquals("High Elf", race.getName());
  }

}
