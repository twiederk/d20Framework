package com.d20charactersheet.framework.boc.model;

/**
 * Weapon which does damage, can hit critcal and is of type simple, martial, exotic or ammo.
 */
public class Weapon extends Item {

  private static final long serialVersionUID = -5681403597135848471L;

  private Damage damage;
  private Critical critical;
  private WeaponType weaponType;
  private CombatType combatType;
  private WeaponEncumbrance weaponEncumbrance;
  private WeaponCategory weaponCategory;
  private int enhancementBonus;
  private WeaponFamily weaponFamily;
  private int rangeIncrement;

  /**
   * Returns the damage of the weapon.
   *
   * @return The damage of the weapon.
   */
  public Damage getDamage() {
    return damage;
  }

  /**
   * Sets the damage of the weapon.
   *
   * @param damage
   *     The damage of the weapon.
   */
  public void setDamage(final Damage damage) {
    this.damage = damage;
  }

  /**
   * Returns the critical hit of the weapon.
   *
   * @return The critical hit of the weapon.
   */
  public Critical getCritical() {
    return critical;
  }

  /**
   * Sets the critical hit.
   *
   * @param critical
   *     The critical hit.
   */
  public void setCritical(final Critical critical) {
    this.critical = critical;
  }

  /**
   * Sets the type of the weapon.
   *
   * @param weaponType
   *     The type of the weapon.
   */
  public void setWeaponType(final WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  /**
   * Returns the type of the weapon.
   *
   * @return The type of the weapon.
   */
  public WeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public String toString() {
    return getName();
  }

  /**
   * Returns the type of combat the weapon can be used in.
   *
   * @return The type of combat the weapon can be used in.
   */
  public CombatType getCombatType() {
    return combatType;
  }

  /**
   * Sets the combat type of the weapon.
   *
   * @param combatType
   *     The combat type to set.
   */
  public void setCombatType(final CombatType combatType) {
    this.combatType = combatType;
  }

  /**
   * Returns the encumbrance of the weapon.
   *
   * @return The encumbrance of the weapon.
   */
  public WeaponEncumbrance getWeaponEncumbrance() {
    return weaponEncumbrance;
  }

  /**
   * Set the encumbrance of the weapon.
   *
   * @param weaponEncumbrance
   *     The encumbrance to set.
   */
  public void setWeaponEncumbrance(final WeaponEncumbrance weaponEncumbrance) {
    this.weaponEncumbrance = weaponEncumbrance;
  }

  /**
   * Returns the category of the weapon.
   *
   * @return The category of the weapon.
   */
  public WeaponCategory getWeaponCategory() {
    return weaponCategory;
  }

  /**
   * Sets the category of the weapon.
   *
   * @param weaponCategory
   *     The category of the weapon.
   */
  public void setWeaponCategory(final WeaponCategory weaponCategory) {
    this.weaponCategory = weaponCategory;
  }

  /**
   * Returns the magical enhancement bonus of the weapon. The bonus is added to attack and damage roll.
   *
   * @return The magical enhancement bonus.
   */
  public int getEnhancementBonus() {
    return enhancementBonus;
  }

  /**
   * Sets the enhancement bonus of the weapon.
   *
   * @param enhancementBonus
   *     The enhancement bonus.
   */
  public void setEnhancementBonus(final int enhancementBonus) {
    this.enhancementBonus = enhancementBonus;
  }

  /**
   * Returns the weapon family the weapon belongs to.
   *
   * @return The weapon family.
   */
  public WeaponFamily getWeaponFamily() {
    return weaponFamily;
  }

  /**
   * Sets the weapon family of the weapon.
   *
   * @param weaponfamily
   *     The weapon family.
   */
  public void setWeaponFamily(final WeaponFamily weaponfamily) {
    this.weaponFamily = weaponfamily;
  }

  /**
   * Returns the range increment of the weapon in feet.
   *
   * @return The range increment of the weapon in feet.
   */
  public int getRangeIncrement() {
    return rangeIncrement;
  }

  /**
   * Sets the range increment of the weapon in feat.
   *
   * @param rangeIncrement
   *     The range increment.
   */
  public void setRangeIncrement(final int rangeIncrement) {
    this.rangeIncrement = rangeIncrement;
  }
}
