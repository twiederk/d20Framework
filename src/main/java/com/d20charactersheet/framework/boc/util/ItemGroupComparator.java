package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.ItemGroup;

/**
 * Compares ItemGroups by the name of the item.
 */
public class ItemGroupComparator implements Comparator<ItemGroup>, Serializable {

  private static final long serialVersionUID = 7846756005561799452L;

  @Override
  public int compare(final ItemGroup itemGroup1, final ItemGroup itemGroup2) {
    return itemGroup1.getItem().getName().compareToIgnoreCase(itemGroup2.getItem().getName());
  }

}
