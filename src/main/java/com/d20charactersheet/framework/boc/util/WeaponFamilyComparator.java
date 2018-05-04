package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.WeaponFamily;

/**
 * Compare WeaopnFamily by name.
 */
public class WeaponFamilyComparator implements Comparator<WeaponFamily>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final WeaponFamily weaponFamily1, final WeaponFamily weaponFamily2) {
    return weaponFamily1.getName().compareTo(weaponFamily2.getName());
  }

}
