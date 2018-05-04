package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Skill;

/**
 * Compares skills by their name.
 */
public class SkillComparator implements Comparator<Skill>, Serializable {

  private static final long serialVersionUID = 9117660034666322217L;

  /**
   * Compares skills by their name.
   *
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(final Skill skill1, final Skill skill2) {
    return skill1.getName().compareToIgnoreCase(skill2.getName());
  }

}
