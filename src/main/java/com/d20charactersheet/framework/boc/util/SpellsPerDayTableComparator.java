package com.d20charactersheet.framework.boc.util;

import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;

/**
 * Compares spell per day tables by name.
 */
public class SpellsPerDayTableComparator implements Comparator<SpellsPerDayTable> {

  @Override
  public int compare(final SpellsPerDayTable spellsPerDayTable1, final SpellsPerDayTable spellsPerDayTable2) {
    return spellsPerDayTable1.getName().compareToIgnoreCase(spellsPerDayTable2.getName());
  }

}
