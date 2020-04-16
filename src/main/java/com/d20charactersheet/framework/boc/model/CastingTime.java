package com.d20charactersheet.framework.boc.model;

/**
 * Casting time options for a spell
 */
public enum CastingTime {
  /**
   * None casting time set
   */
  NONE, /**
   * 1 standard action
   */
  ONE_STANDARD_ACTION, /**
   * 1 free action
   */
  ONE_FREE_ACTION, /**
   * 1 round
   */
  ONE_ROUND, /**
   * 1 minute
   */
  ONE_MINUTE, /**
   * 10 minutes
   */
  TEN_MINUTES, /**
   * 1 hour
   */
  ONE_HOUR, /**
   * 1 immediate action
   */
  ONE_IMMEDIATE_ACTION, /**
   * 1 swift action
   */
  ONE_SWIFT_ACTION, /**
   * Specific casting time
   */
  SPECIFIC

}
