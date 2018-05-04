package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.WeaponAttack;

/**
 * Compare WeaponAttacks by name.
 */
public class WeaponAttackComparator implements Comparator<WeaponAttack>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final WeaponAttack weaponAttack1, final WeaponAttack weaponAttack2) {
    return weaponAttack1.getName().compareToIgnoreCase(weaponAttack2.getName());
  }

}
