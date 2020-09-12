package com.d20charactersheet.framework.boc.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The body of a humanoid character.
 */
public class HumanoidBody implements Body {

  private final Map<BodyPart, Item> bodySlots;

  /**
   * Creates a HumanoidBody with all body parts
   */
  public HumanoidBody() {
    bodySlots = new HashMap<>();
    EnumSet<BodyPart> humanoidBodyParts = EnumSet.allOf(BodyPart.class);
    humanoidBodyParts.remove(BodyPart.NONE);
    try {
      humanoidBodyParts.forEach(bodyPart -> bodySlots.put(bodyPart, Item.EMPTY_ITEM));
    } catch (NoClassDefFoundError noClassDefFoundError) {
      // problem occured with static access to this::clear on Lenovo devices with Android 6
    }
  }

  @Override
  public Set<BodyPart> getBodyParts() {
    return bodySlots.keySet();
  }

  @Override
  public void equip(BodyPart bodyPart, Item item) {
    bodySlots.put(bodyPart, item);
  }

  @Override
  public Item getItemOfBodyPart(BodyPart bodyPart) {
    return bodySlots.get(bodyPart);
  }

  @Override
  public void clear(BodyPart bodyPart) {
    bodySlots.put(bodyPart, Item.EMPTY_ITEM);
  }

  @Override
  public List<Item> getEquippedItems() {
    return bodySlots.values().stream().filter(item -> !item.equals(Item.EMPTY_ITEM)).collect(Collectors.toList());
  }
}
