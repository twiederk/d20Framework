package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Ability;

/**
 * Compares abilities by name.
 */
public class AbilityComparator implements Comparator<Ability>, Serializable {

  private static final long serialVersionUID = -8874651019590593203L;

  @Override
  public int compare(final Ability ability1, final Ability ability2) {
    return ability1.getName().compareTo(ability2.getName());
  }

}
