package com.d20charactersheet.framework.boc.model;

/**
 * Representation of an armor.
 */
public class Armor extends Item {

  private static final long serialVersionUID = 3920261330456781178L;

  private int armorBonus;
  private int armorCheckPenalty;
  private ArmorType armorType;

  /**
   * Returns the armor class bonus.
   *
   * @return The armor class bonus.
   */
  public int getArmorBonus() {
    return armorBonus;
  }

  /**
   * Sets the armor class bonus.
   *
   * @param armorBonus
   *     The armor class bonus.
   */
  public void setArmorBonus(final int armorBonus) {
    this.armorBonus = armorBonus;
  }

  /**
   * Returns the skill check penalty.
   *
   * @return The skill check penalty.
   */
  public int getArmorCheckPenalty() {
    return armorCheckPenalty;
  }

  /**
   * Sets the skill check penalty.
   *
   * @param armorCheckPenalty
   *     The skill check penalty.
   */
  public void setArmorCheckPenalty(final int armorCheckPenalty) {
    this.armorCheckPenalty = armorCheckPenalty;
  }

  /**
   * Sets the type of the armor.
   *
   * @param armorType
   *     Type of the armor.
   */
  public void setArmorType(final ArmorType armorType) {
    this.armorType = armorType;
  }

  /**
   * Returns the type of the armor.
   *
   * @return The type of the armor.
   */
  public ArmorType getArmorType() {
    return armorType;
  }

}
