package com.d20charactersheet.framework.boc.model;

import java.util.List;
import java.util.Set;

/**
 * The body of a character consists of different body parts. Items are equipped to these body parts.
 */
public interface Body {

  /**
   * Get all body parts of the body.
   *
   * @return All body parts.
   */
  Set<BodyPart> getBodyParts();

  /**
   * Equip the item to the body part.
   *
   * @param bodyPart
   *     The body part to equip the item to.
   * @param item
   *     The item to equip.
   */
  void equip(BodyPart bodyPart, Item item);

  /**
   * Returns the item of the body part.
   *
   * @param bodyPart
   *     The body part to return the item from.
   *
   * @return The item equipped by the body part. Return Item.EMPTY_ITEM, if the body parts doesn't equip an item.
   */
  Item getItemOfBodyPart(BodyPart bodyPart);

  /**
   * Remove the item from the body part.
   *
   * @param bodyPart
   *     The body part to remove the item from
   */
  void clear(BodyPart bodyPart);

  /**
   * Returns a list of all equipped items.
   *
   * @return List of all equipped items.
   */
  List<Item> getEquippedItems();
}
