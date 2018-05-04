package com.d20charactersheet.framework.boc.model;

/**
 * Good is part of character equipment, like a rope or latern.
 */
public class Good extends Item {

  private static final long serialVersionUID = 7457159733365474660L;

  private GoodType goodType;

  /**
   * Sets the type of the good.
   *
   * @param goodType
   *     The type of the good.
   */
  public void setGoodType(final GoodType goodType) {
    this.goodType = goodType;
  }

  /**
   * Returns the good type.
   *
   * @return The good type.
   */
  public GoodType getGoodType() {
    return goodType;
  }

}
