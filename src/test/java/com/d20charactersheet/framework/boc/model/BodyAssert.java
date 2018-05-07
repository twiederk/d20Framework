package com.d20charactersheet.framework.boc.model;

import org.assertj.core.api.AbstractAssert;

public class BodyAssert extends AbstractAssert<BodyAssert, Body> {

  protected BodyAssert(Body body) {
    super(body, BodyAssert.class);
  }

  public static BodyAssert assertThat(Body actual) {
    BodyAssert bodyAssert = new BodyAssert(actual);
    bodyAssert.isNotNull();
    return bodyAssert;
  }

  public BodyAssert equippedItem(BodyPart bodyPart, Item item) {
      if (!actual.getItemOfBodyPart(bodyPart).equals(item)) {
        failWithMessage("Expected <%s> to equip <%s>, but was <%s>", bodyPart.name(), item.getName(), actual.getItemOfBodyPart(bodyPart).getName());
      }
      return this;
  }

  public BodyAssert isEmpty(BodyPart bodyPart) {
    if (!actual.getItemOfBodyPart(bodyPart).equals(Item.EMPTY_ITEM)) {
      failWithMessage("Expected <%s> to equip <%s>, but was <%s>", bodyPart.name(), Item.EMPTY_ITEM.getName(), actual.getItemOfBodyPart(bodyPart).getName());
    }
    return this;
  }
}
