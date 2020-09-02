package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Represents an attack with a weapon wield in a specific way.
 */
public class WeaponAttack implements Serializable {

  private static final long serialVersionUID = 1477573533252992562L;

  private int id;
  private String name;
  private String description;
  private AttackWield attackWield;
  private Weapon weapon;
  private int ammunition;
  private List<Integer> attackBonuses;
  private int damageBonus;
  private int attackBonusModifier;
  private int damageBonusModifier;

  /**
   * Returns the id of the weapon attack.
   *
   * @return The id of the weapon attack.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the weapon attack.
   *
   * @param id
   *     The id of the weapon attack.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the weapon attack.
   *
   * @return The name of the weapon attack.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the weapon attack.
   *
   * @param name
   *     The name of the weapon attack.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the description of the weapon attack.
   *
   * @return The description of the weapon attack.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description
   *
   * @param description
   *     The description.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Returns how the weapon is wielded.
   *
   * @return The wield style of the weapon.
   */
  public AttackWield getAttackWield() {
    return attackWield;
  }

  /**
   * Sets how the weapon is wield.
   *
   * @param attackWield
   *     How the weapon is wielded.
   */
  public void setAttackWield(final AttackWield attackWield) {
    this.attackWield = attackWield;
  }

  /**
   * Returns the weapon which is used for attack.
   *
   * @return The weapon used for the attack.
   */
  public Weapon getWeapon() {
    return weapon;
  }

  /**
   * Sets the weapon to attack with.
   *
   * @param weapon
   *     The weapon to attack with.
   */
  public void setWeapon(final Weapon weapon) {
    this.weapon = weapon;
  }

  /**
   * The number of attacks in one round of combat.
   *
   * @return The number of attacks in one round of combat.
   */
  public int getNumberOfAttacks() {
    return attackBonuses.size();
  }

  /**
   * Returns the attack bonuses of each attack in one round of combat.
   *
   * @return The attack bonuses of each attack in one round of combat.
   */
  public List<Integer> getAttackBonuses() {
    return attackBonuses;
  }

  /**
   * Sets the attack bonuses for each attack in one round of combat.
   *
   * @param attackBonuses
   *     The attack bonuses for each attack in one round of combat.
   */
  public void setAttackBonuses(final List<Integer> attackBonuses) {
    this.attackBonuses = attackBonuses;
  }

  /**
   * Returns the damage of the weapon.
   *
   * @return The damage of the weapon.
   */
  public Damage getDamage() {
    return weapon.getDamage();
  }

  /**
   * Returns the critical hit of the weapon.
   *
   * @return The critical hit of the weapon.
   */
  public Critical getCritical() {
    return weapon.getCritical();
  }

  /**
   * Returns the damage bonus.
   *
   * @return The damage bonus.
   */
  public int getDamageBonus() {
    return damageBonus;
  }

  /**
   * Sets the damage bonus.
   *
   * @param damageBonus
   *     The damage bonus.
   */
  public void setDamageBonus(final int damageBonus) {
    this.damageBonus = damageBonus;
  }

  /**
   * Returns the ammunition.
   *
   * @return The ammunition.
   */
  public int getAmmunition() {
    return ammunition;
  }

  /**
   * Sets the ammunition.
   *
   * @param ammunition
   *     The ammunition.
   */
  public void setAmmunition(final int ammunition) {
    this.ammunition = ammunition;
  }

  /**
   * @param attackBonusModifier
   *     the attackBonusModifier to set
   */
  public void setAttackBonusModifier(final int attackBonusModifier) {
    this.attackBonusModifier = attackBonusModifier;
  }

  /**
   * @return the attackBonusModifier
   */
  public int getAttackBonusModifier() {
    return attackBonusModifier;
  }

  /**
   * @param damageBonusModifer
   *     the damageBonusModifer to set
   */
  public void setDamageBonusModifier(final int damageBonusModifer) {
    this.damageBonusModifier = damageBonusModifer;
  }

  /**
   * @return the damageBonusModifer
   */
  public int getDamageBonusModifier() {
    return damageBonusModifier;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final WeaponAttack other = (WeaponAttack) obj;
    return id == other.id;
  }
}
