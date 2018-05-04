package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.KnownSpellsTable;

/**
 * Compares known spell tables by name.
 */
public class KnownSpellsTableComparator implements Comparator<KnownSpellsTable>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final KnownSpellsTable knownSpellsTable1, final KnownSpellsTable knownSpellsTable2) {
    return knownSpellsTable1.getName().compareToIgnoreCase(knownSpellsTable2.getName());
  }

}
