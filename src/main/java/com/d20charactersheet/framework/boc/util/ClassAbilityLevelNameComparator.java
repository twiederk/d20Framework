package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.ClassAbility;

/**
 * Compares class abilities by there level first and then by their name.
 */
public class ClassAbilityLevelNameComparator implements Comparator<ClassAbility>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final ClassAbility ability1, final ClassAbility ability2) {
    if (ability1.getLevel() > ability2.getLevel()) {
      return 1;
    } else if (ability1.getLevel() < ability2.getLevel()) {
      return -1;
    } else {
      return ability1.getAbility().getName().compareToIgnoreCase(ability2.getAbility().getName());
    }
  }

}
