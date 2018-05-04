package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Spell;

/**
 * Compares spells by name.
 */
public class SpellComparator implements Comparator<Spell>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final Spell spell1, final Spell spell2) {
    return spell1.getName().compareToIgnoreCase(spell2.getName());
  }

}
