package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.CharacterClass;

/**
 * Compares character classes by their name.
 */
public class CharacterClassComparator implements Comparator<CharacterClass>, Serializable {

  private static final long serialVersionUID = 5732192385430615925L;

  /**
   * Compares character classes by their name.
   *
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(final CharacterClass characterClass1, final CharacterClass characterClass2) {
    return characterClass1.getName().compareToIgnoreCase(characterClass2.getName());
  }

}
