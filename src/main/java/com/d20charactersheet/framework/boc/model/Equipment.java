package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Equipment of a character. Equipment consistes of weapons, armor and goods. The items of the same type are grouped
 * together.
 */
public class Equipment implements Serializable {

  private static final long serialVersionUID = -6456350791921140731L;

  private List<ItemGroup> weapons = new ArrayList<>();
  private List<ItemGroup> armor = new ArrayList<>();
  private List<ItemGroup> goods = new ArrayList<>();

  /**
   * Returns the weapons of the equipment.
   *
   * @return The weapons of the equipment.
   */
  public List<ItemGroup> getWeapons() {
    return weapons;
  }

  /**
   * Sets the weapons of the equipment.
   *
   * @param weapons
   *     The weapons to set.
   */
  public void setWeapons(final List<ItemGroup> weapons) {
    this.weapons = weapons;
  }

  /**
   * Returns the goods of the equipment.
   *
   * @return The goods of the equipment.
   */
  public List<ItemGroup> getGoods() {
    return goods;
  }

  /**
   * Sets the goods of the equipment.
   *
   * @param goods
   *     The goods of the equipment.
   */
  public void setGoods(final List<ItemGroup> goods) {
    this.goods = goods;
  }

  /**
   * Returns the armor of the equipment.
   *
   * @return The armor of the equipment.
   */
  public List<ItemGroup> getArmor() {
    return armor;
  }

  /**
   * Sets the armor of the equipment.
   *
   * @param armor
   *     The armor to set.
   */
  public void setArmor(final List<ItemGroup> armor) {
    this.armor = armor;
  }

  /**
   * Returns all items of the equipment, including weapons, armor and goods.
   *
   * @return All items of the equipment.
   */
  public List<ItemGroup> getItems() {
    final List<ItemGroup> items = new LinkedList<>();
    items.addAll(weapons);
    items.addAll(armor);
    items.addAll(goods);
    return items;
  }

}
