package com.d20charactersheet.framework.boc.service;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.XpDao;

import java.util.List;

/**
 * Handels xp points and leve.
 */
public class XpServiceImpl implements XpService {

  private final XpDao xpDao;

  /**
   * Instanciates XpService with given object to access persistent layer.
   *
   * @param xpDao
   *     The access to the persistent layer.
   */
  public XpServiceImpl(final XpDao xpDao) {
    this.xpDao = xpDao;
  }

  @Override
  public List<XpTable> getAllXpTables() {
    return xpDao.getAllXpTables();
  }

  public int getNextLevelAt(final XpTable xpTable, final int level) {
    if (level < 0) {
      throw new IllegalArgumentException("level must be positive");
    }

    final int[] levels = xpTable.getLevels();
    if (level >= levels.length) {
      return levels[levels.length - 1];
    }
    return levels[level];
  }

  @Override
  public boolean isValidExperiencePointsToCharacterLevel(final int experiencePoints, final Character character) {
    final int characterLevel = character.getCharacterLevel();
    final XpTable xpTable = character.getXpTable();
    final int minExperiencePoints = getNextLevelAt(xpTable, characterLevel - 1);
    final int maxExperiencePoints = getNextLevelAt(xpTable, characterLevel) - 1;
    return experiencePoints >= minExperiencePoints && experiencePoints <= maxExperiencePoints;
  }

}
