package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.XpTable;

/**
 * Handles level and experience points information.
 */
public interface XpService {

  /**
   * Returns all xp tables.
   *
   * @return All xp tables.
   */
  List<XpTable> getAllXpTables();

  /**
   * Returns the number of experience points the next level starts at.
   *
   * @param xpTable
   *     The xp table to get the levels of.
   * @param level
   *     The level to compare.
   *
   * @return The number of experience points the next level starts at.
   */
  int getNextLevelAt(XpTable xpTable, int level);

  /**
   * Validates if the given experience points match the character level of the character.
   *
   * @param experiencePoints
   *     The experience points to check.
   * @param character
   *     The character to check its character class against the experience points.
   *
   * @return True, if the experience points match the character level.
   */
  boolean isValidExperiencePointsToCharacterLevel(int experiencePoints, Character character);

}
