package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;

/**
 * Interface to persistent layer of items.
 */
public interface ItemDao {

  /**
   * Returns all weapons from the persistent layer.
   *
   * @param allWeaponFamilies
   *     All weapon families.
   *
   * @return All weapons.
   */
  public List<Weapon> getAllWeapons(List<WeaponFamily> allWeaponFamilies);

  /**
   * Returns all armor from the persistent layer.
   *
   * @return All armor.
   */
  public List<Armor> getAllArmor();

  /**
   * Returns all goods from the persistent layer.
   *
   * @return All goods.
   */
  public List<Good> getAllGoods();

  /**
   * Persists the weapon. Creates a weapon id while persisting it.
   *
   * @param weapon
   *     The weapon to persist.
   *
   * @return The persisted weapon with the persisted id.
   */
  public Weapon createWeapon(Weapon weapon);

  /**
   * Updates the weapon.
   *
   * @param weapon
   *     The weapon to update.
   */
  public void updateWeapon(Weapon weapon);

  /**
   * Persists the armor and creates its id.
   *
   * @param armor
   *     The armor to persist.
   *
   * @return The persited armor with the created id:
   */
  public Armor createArmor(Armor armor);

  /**
   * Updates the armor.
   *
   * @param armor
   *     The armor to update.
   */
  public void updateArmor(Armor armor);

  /**
   * Deletes the weapon from the persistent layer.
   *
   * @param weapon
   */
  public void deleteWeapon(Weapon weapon);

  /**
   * Deletes the armor.
   *
   * @param armor
   *     The armor to delete.
   */
  public void deleteArmor(Armor armor);

  /**
   * Creates the good in the persistent layer.
   *
   * @param good
   *     The good to create.
   *
   * @return The created good.
   */
  public Good createGood(Good good);

  /**
   * Deletes the good from the persistent layer.
   *
   * @param good
   *     The good to delete.
   */
  public void deleteGood(Good good);

  /**
   * Updates the good in the persistent layer.
   *
   * @param good
   *     The good to update.
   */
  public void updateGood(Good good);

  /**
   * Returns list of all weapon families.
   *
   * @return List of all weapon families.
   */
  public List<WeaponFamily> getAllWeaponFamilies();

}
