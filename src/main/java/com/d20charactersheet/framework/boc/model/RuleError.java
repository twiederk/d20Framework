package com.d20charactersheet.framework.boc.model;

/**
 * Violation of D&D 3.5 rules.
 */
public enum RuleError {

  /**
   * Attribute value must be between 1 and 99
   */
  ATTRIBUTE_VALUE_NOT_IN_RANGE,

  /**
   * Experience points must match character level
   */
  EXPERIENCE_NOT_IN_RANGE,

  /**
   * Experience points can't be negative
   */
  NEGATIVE_EXPERIENCE_POINTS,

  /**
   * Level of a class must be positive
   */
  ZERO_OR_NEGATIVE_CLASS_LEVEL,

  /**
   * Character requires one class at least
   */
  NONE_CLASS_LEVEL,

  /**
   * Skill ranks can't be negative
   */
  NEGATIVE_SKILL_RANK,

  /**
   * Max skill rank exceeded
   */
  MAX_SKILL_RANK_EXCEEDED,

  /**
   * The critical hit value must be between 0 and 20, if not it is invalid
   */
  INVALID_CRITICAL_HIT_VALUE,

  /**
   * Spell level must always be 0 or higher
   */
  NEGATIVE_SPELL_LEVEL

}
