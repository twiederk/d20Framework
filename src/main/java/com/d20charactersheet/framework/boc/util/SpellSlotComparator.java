package com.d20charactersheet.framework.boc.util;

import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.SpellSlot;

/**
 * Compares spell slots by name. Empty spell slots are sorted to the end of the list.
 */
public class SpellSlotComparator implements Comparator<SpellSlot> {

  @Override
  public int compare(final SpellSlot o1, final SpellSlot o2) {

    if (isEmptySpell(o1) && !isEmptySpell(o2)) {
      return 1;
    }
    if (!isEmptySpell(o1) && isEmptySpell(o2)) {
      return -1;
    }
    return o1.getSpell().getName().compareTo(o2.getSpell().getName());
  }

  private boolean isEmptySpell(final SpellSlot spellSlot) {
    return SpellSlot.EMPTY_SPELL.equals(spellSlot.getSpell());
  }

}
