package com.d20charactersheet.framework.boc.model;

/**
 * Typ of memorizing spells for casting.
 */
public enum CastingType {
  /**
   * Spells can be cast immediately
   */
  SPONTANEOUS, /**
   * Spells must be memorized before casting
   */
  PREPARED;
}
