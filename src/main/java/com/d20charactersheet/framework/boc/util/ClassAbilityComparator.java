package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.ClassAbility;

/**
 * Compares Abilities be their level first and second by name.
 */
public class ClassAbilityComparator implements Comparator<ClassAbility>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final ClassAbility classAbility1, final ClassAbility classAbilitiy2) {
    if (classAbility1.getLevel() > classAbilitiy2.getLevel()) {
      return 1;
    }
    if (classAbility1.getLevel() < classAbilitiy2.getLevel()) {
      return -1;
    }
    return classAbility1.getAbility().getName().compareTo(classAbilitiy2.getAbility().getName());
  }

}
