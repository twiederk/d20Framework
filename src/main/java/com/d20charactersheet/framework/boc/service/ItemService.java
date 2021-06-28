package com.d20charactersheet.framework.boc.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.EquipmentPack;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;

/**
 * Provides services to handle items.
 */
public interface ItemService {

  /**
   * Returns all weapon families.
   *
   * @return All weapon families.
   */
  @NotNull
  List<WeaponFamily> getAllWeaponFamilies();

  /**
   * Returns list of all available weapons.
   *
   * @param allWeaponFamilies
   *     List of all weapon families
   *
   * @return List of all available weapons.
   */
  @NotNull
  List<Weapon> getAllWeapons(@NotNull List<WeaponFamily> allWeaponFamilies);

  /**
   * Returns list of all available armor.
   *
   * @return List of all available armor.
   */
  @NotNull
  List<Armor> getAllArmor();

  /**
   * Returns list of all available goods.
   *
   * @return List of all available goods.
   */
  @NotNull
  List<Good> getAllGoods();

  /**
   * Creates new weapon with valid id.
   *
   * @param weapon
   *     The weapon to create.
   *
   * @return New created weapon with valid id
   */
  @NotNull
  Weapon createWeapon(@NotNull Weapon weapon);

  /**
   * Updates the given weapon in the persistent layer.
   *
   * @param weapon
   *     The weapon to update.
   */
  void updateWeapon(@NotNull Weapon weapon);

  /**
   * Creates a new armor with valid id.
   *
   * @param armor
   *     The armor to create.
   *
   * @return The new armor with a valid id.
   */
  @NotNull
  Armor createArmor(@NotNull Armor armor);

  /**
   * Updates the armor.
   *
   * @param armor
   *     The armor to update.
   */
  void updateArmor(@NotNull Armor armor);

  /**
   * Create a new good with valid id.
   *
   * @param good
   *     The good to create.
   *
   * @return The created good with valid id.
   */
  @NotNull
  Good createGood(@NotNull Good good);

  /**
   * Update the given good.
   *
   * @param good
   *     The good to update.
   */
  void updateGood(@NotNull Good good);

  /**
   * Returns list of equipable weapons (weight and cost > 0).
   *
   * @param allWeapons
   *     List of all weapons.
   *
   * @return List of equipable weapons (weight and cost > 0).
   */
  @NotNull
  List<Weapon> getEquipableWeapons(@NotNull List<Weapon> allWeapons);

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
  @NotNull
  Item getItemById(int itemId, @NotNull List<? extends Item> items);

  /**
   * Returns weapons of the given weapon type.
   *
   * @param weaponType
   *     The weapon type to filter the list with.
   * @param allWeapons
   *     The weapons to filter
   *
   * @return Weapons of given weapon type.
   */
  @NotNull
  List<Weapon> filterWeaponsByType(@NotNull WeaponType weaponType, @NotNull List<Weapon> allWeapons);

  /**
   * Returns weapons of given combat type.
   *
   * @param combatType
   *     The combat type to filter the list with
   * @param allWeapons
   *     The weapons to filter
   *
   * @return Weapons of given combat type.
   */
  @NotNull
  List<Weapon> filterWeaponsByCombat(@NotNull CombatType combatType, @NotNull List<Weapon> allWeapons);

  /**
   * Returns armor of given armor type.
   *
   * @param armorType
   *     The armor type to filter the list with.
   * @param allArmor
   *     The armor to filter
   *
   * @return Armor of given armor type.
   */
  @NotNull
  List<Armor> filterArmorByType(@NotNull ArmorType armorType, @NotNull List<Armor> allArmor);

  /**
   * Returns goods of given good type.
   *
   * @param goodType
   *     The good type to filter the list with.
   * @param allGoods
   *     The goods to filter.
   *
   * @return Goods of given good type.
   */
  @NotNull
  List<Good> filterGoodsByType(@NotNull GoodType goodType, @NotNull List<Good> allGoods);

  /**
   * Returns requested equipment pack.
   *
   * @param id
   *     The id of the requested equipment pack.
   * @param allEquipmentPacks
   *     List of all equipment packs.
   *
   * @return The requested equipment pack.
   */
  @NotNull
  EquipmentPack getEquipmentPackById(int id, @NotNull List<EquipmentPack> allEquipmentPacks);

  /**
   * Returns all equipment packs.
   *
   * @param allItems
   *     List of all items needed to fill equipment packs.
   *
   * @return All equipment packs.
   */
  @NotNull
  List<EquipmentPack> getAllEquipmentPacks(@NotNull List<? extends Item> allItems);

}
