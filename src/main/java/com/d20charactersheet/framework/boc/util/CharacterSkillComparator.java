package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.CharacterSkill;

/**
 * Sorts list of skills by name.
 */
public class CharacterSkillComparator implements Comparator<CharacterSkill>, Serializable {

  private static final long serialVersionUID = -8442547692007817265L;

  /**
   * Sorts skills by name.
   */
  @Override
  public int compare(final CharacterSkill characterSkill1, final CharacterSkill characterSkill2) {
    return characterSkill1.getSkill().getName().compareToIgnoreCase(characterSkill2.getSkill().getName());
  }

}
