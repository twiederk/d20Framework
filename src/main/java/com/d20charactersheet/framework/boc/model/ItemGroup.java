package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;

/**
 * Represents a number of the same kind of item. The id of new created items is -1.
 */
public class ItemGroup implements Serializable {

  private static final long serialVersionUID = -2643677647610555824L;

  private int id = -1;
  private Item item;
  private int number;

  /**
   * Returns the id of the item group, not the item!
   *
   * @return The id of the item group.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the item group.
   *
   * @param id
   *     The id of the item group.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the item.
   *
   * @return The item.
   */
  public Item getItem() {
    return item;
  }

  /**
   * Sets the item.
   *
   * @param item
   *     The item.
   */
  public void setItem(final Item item) {
    this.item = item;
  }

  /**
   * Sets the number of items in this group.
   *
   * @param number
   *     Number of items in this group.
   */
  public void setNumber(final int number) {
    this.number = number;
  }

  /**
   * Returns the number of items in this group.
   *
   * @return The number of items in this group.
   */
  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return item.getName() + " (" + number + ")";
  }
}
