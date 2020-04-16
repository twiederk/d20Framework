package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.XpTable;

public class XpServiceTest {

  private XpService xpService;

  @Before
  public void setUp() {
    final GameSystem gameSystem = new DnDv35Universe().getGameSystem();
    xpService = gameSystem.getXpService();
  }

  @Test
  public void testGetAllXpTables() {
    final List<XpTable> allXpTables = xpService.getAllXpTables();

    assertNotNull("allXpTables can't be null", allXpTables);
    assertEquals(1, allXpTables.size());

    final XpTable xpTable = allXpTables.get(0);
    assertEquals(1, xpTable.getId());
    assertEquals("Normal", xpTable.getName());

    assertNotNull(xpTable.getLevels());
  }

  @Test
  public void testGetNextLevelAt() {
    final List<XpTable> allXpTables = xpService.getAllXpTables();
    final XpTable xpTable = allXpTables.get(0);

    assertEquals(1000, xpService.getNextLevelAt(xpTable, 1));
    assertEquals(15000, xpService.getNextLevelAt(xpTable, 5));
    assertEquals(55000, xpService.getNextLevelAt(xpTable, 10));
    assertEquals(120000, xpService.getNextLevelAt(xpTable, 15));
    assertEquals(190000, xpService.getNextLevelAt(xpTable, 20));
  }

  @Test
  public void testGetNextLevelAtZeroLevel() {
    final List<XpTable> allXpTables = xpService.getAllXpTables();
    final XpTable xpTable = allXpTables.get(0);

    assertEquals(0, xpService.getNextLevelAt(xpTable, 0));
  }

  @Test
  public void testGetNextLevelAtNegativeLevel() {
    final List<XpTable> allXpTables = xpService.getAllXpTables();
    final XpTable xpTable = allXpTables.get(0);

    try {
      xpService.getNextLevelAt(xpTable, -1);
      fail("Missing Exception: exptected IllegalArgumentException");
    } catch (final IllegalArgumentException illegalArgumentException) {
      // success: expected exception thrown
    } catch (final Exception exception) {
      fail("Wrong Exception: expected IllegalArgumentException");
    }
  }

  @Test
  public void testIsValidExperiencePointsToCharacterLevel() {

    final Character character = new Character() {

      private static final long serialVersionUID = 1L;

      @Override
      public int getCharacterLevel() {
        return 1;
      }
    };
    final List<XpTable> allXpTables = xpService.getAllXpTables();
    final XpTable xpTable = allXpTables.get(0);
    character.setXpTable(xpTable);

    int experience = -1;

    boolean valid = xpService.isValidExperiencePointsToCharacterLevel(experience, character);
    assertFalse(valid);

    experience = 0;
    valid = xpService.isValidExperiencePointsToCharacterLevel(experience, character);
    assertTrue(valid);

    experience = 500;
    valid = xpService.isValidExperiencePointsToCharacterLevel(experience, character);
    assertTrue(valid);

    experience = 999;
    valid = xpService.isValidExperiencePointsToCharacterLevel(experience, character);
    assertTrue(valid);

    experience = 1000;
    valid = xpService.isValidExperiencePointsToCharacterLevel(experience, character);
    assertFalse(valid);

    experience = 1500;
    valid = xpService.isValidExperiencePointsToCharacterLevel(experience, character);
    assertFalse(valid);

  }

}
