package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Race;

/**
 * Compares races by name.
 */
public class RaceComparator implements Comparator<Race>, Serializable {

  private static final long serialVersionUID = 1031566949914751883L;

  @Override
  public int compare(final Race race1, final Race race2) {
    return race1.getName().compareTo(race2.getName());
  }
}
