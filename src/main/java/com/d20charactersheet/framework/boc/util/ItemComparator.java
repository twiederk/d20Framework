package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Item;

/**
 * Compares items by their name.
 */
public class ItemComparator implements Comparator<Item>, Serializable {

  private static final long serialVersionUID = -3653133766552636542L;

  @Override
  public int compare(final Item item1, final Item item2) {
    return item1.getName().compareToIgnoreCase(item2.getName());
  }

}
