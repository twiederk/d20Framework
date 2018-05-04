package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;

/**
 * Provides services to handle items.
 */
public interface ItemService {

  /**
   * Returns all weapon families.
   *
   * @return All weapon families.
   */
  public List<WeaponFamily> getAllWeaponFamilies();

  /**
   * Returns list of all available weapons.
   *
   * @param allWeaponFamilies
   *     List of all weapon families
   *
   * @return List of all available weapons.
   */
  public List<Weapon> getAllWeapons(List<WeaponFamily> allWeaponFamilies);

  /**
   * Returns list of all available armor.
   *
   * @return List of all available armor.
   */
  public List<Armor> getAllArmor();

  /**
   * Returns list of all available goods.
   *
   * @return List of all available goods.
   */
  public List<Good> getAllGoods();

  /**
   * Creates new weapon with valid id.
   *
   * @param weapon
   *     The weapon to create.
   *
   * @return New created weapon with valid id
   */
  public Weapon createWeapon(Weapon weapon);

  /**
   * Updates the given weapon in the persistent layer.
   *
   * @param weapon
   *     The weapon to update.
   */
  public void updateWeapon(Weapon weapon);

  /**
   * Creates a new armor with valid id.
   *
   * @param armor
   *     The armor to create.
   *
   * @return The new armor with a valid id.
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
   * Create a new good with valid id.
   *
   * @param good
   *     The good to create.
   *
   * @return The created good with valid id.
   */
  public Good createGood(Good good);

  /**
   * Update the given good.
   *
   * @param good
   *     The good to update.
   */
  public void updateGood(Good good);

  /**
   * Returns list of equipable weapons (weight and cost > 0).
   *
   * @param allWeapons
   *     List of all weapons.
   *
   * @return List of equipable weapons (weight and cost > 0).
   */
  public List<Weapon> getEquipableWeapons(List<Weapon> allWeapons);

  /**
   * Returns item with the given id.
   *
   * @param itemId
   *     The id of the item.
   * @param items
   *     The items to search.
   *
   * @return Item with the given id.
   */
  public Item getItemById(int itemId, List<? extends Item> items);

}
