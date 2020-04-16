package com.d20charactersheet.framework.boc.model;

/**
 * Enumeration of different ways to wield a weapon.
 */
public enum AttackWield {

  /**
   * Wield weapon in off-hand while two-weapon fighting.
   */
  OFF_HAND, /**
   * Wield weapon in primary-hand while two-weapon fighting.
   */
  PRIMARY_HAND, /**
   * Wield weapon in primary-hand while two-weapon fighting, with a light weapon in the off-hand
   */
  PRIMARY_HAND_LIGHT_OFF_HAND, /**
   * Wield the weapon with one hand.
   */
  ONE_HAND, /**
   * Wield the weapon with tww hands.
   */
  TWO_HANDED
}
