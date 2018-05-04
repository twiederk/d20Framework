package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Spelllist;

/**
 * Compare spell lists by name.
 */
public class SpelllistComparator implements Comparator<Spelllist>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final Spelllist spelllist1, final Spelllist spelllist2) {
    return spelllist1.getName().compareTo(spelllist2.getName());
  }

}
