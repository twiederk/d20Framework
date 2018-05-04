package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Character;

/**
 * Compares characters by name.
 */
public class CharacterComparator implements Comparator<Character>, Serializable {

  private static final long serialVersionUID = -3631728385794998234L;

  /**
   * Compares characters by name.
   *
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(final Character character1, final Character character2) {
    return character1.getName().compareToIgnoreCase(character2.getName());
  }

}
