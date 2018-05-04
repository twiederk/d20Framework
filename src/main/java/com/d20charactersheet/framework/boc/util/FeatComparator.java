package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Feat;

/**
 * Compares feats by name.
 */
public class FeatComparator implements Comparator<Feat>, Serializable {

  private static final long serialVersionUID = -4859253566885238563L;

  /**
   * Compares feat by name.
   *
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(final Feat feat1, final Feat feat2) {
    return feat1.getName().compareToIgnoreCase(feat2.getName());
  }

}
