package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.ClassAbility;

/**
 * Compares class abilities by their name.
 */
public class ClassAbilityNameComparator implements Comparator<ClassAbility>, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public int compare(final ClassAbility classAbility1, final ClassAbility classAbility2) {
    return classAbility1.getAbility().getName().compareTo(classAbility2.getAbility().getName());
  }

}
