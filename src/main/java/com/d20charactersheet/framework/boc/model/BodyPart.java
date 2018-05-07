package com.d20charactersheet.framework.boc.model;

/**
 * The body parts of a body, which can equip items.
 */
public enum BodyPart {
  /**
   * One headband, hat, helmet, or phylactery on the head
   */
  HEAD,

  /**
   * One pair of eye lenses or goggles on or over the eyes
   */
  EYES,

  /**
   * One amulet, brooch, medallion, necklace, periapt, or scarab around the neck
   */
  NECK,

  /**
   * One vest, vestment, or shirt on the torso
   */
  TORSO,

  /**
   * One robe or suit of armor on the body (over a vest, vestment, or shirt)
   */
  BODY,

  /**
   * One belt around the waist (over a robe or suit of armor)
   */
  WAIST,

  /**
   * One cloak, cape, or mantle around the shoulders (over a robe or suit of armor)
   */
  SHOULDERS,

  /**
   * One pair of bracers or bracelets on the arms or wrists
   */
  ARMS,

  /**
   * One glove, pair of gloves, or pair of gauntlets on the hands
   */
  HANDS,

  /**
   * One ring on each hand (or two rings on one hand)
   */
  FINGERS_LEFT,

  /**
   * One ring on each hand (or two rings on one hand)
   */
  FINGERS_RIGHT,

  /**
   * One pair of boots or shoes on the feet
   */
  FEET,

  /**
   * One light-handed or one-handed weapon
   */
  PRIMARY_HAND,

  /**
   * One light-handed or one-handed weapon
   */
  OFF_HAND,

  /**
   * One light-handed, one-handed or two-handed  weapon
   */
  BOTH_HANDS,

  /**
   * No item to equip
   */
  NONE
}
