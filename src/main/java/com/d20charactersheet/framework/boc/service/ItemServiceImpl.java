package com.d20charactersheet.framework.boc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.EquipmentPack;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.RuleError;
import com.d20charactersheet.framework.boc.model.RuleException;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;
import com.d20charactersheet.framework.dac.dao.ItemDao;

/**
 * Implementation of item services. Caches items internally.
 */
public class ItemServiceImpl implements ItemService {

  private final ItemDao itemDao;

  /**
   * Creates ItemService with data access.
   *
   * @param itemDao
   *     The data access.
   */
  public ItemServiceImpl(final ItemDao itemDao) {
    this.itemDao = itemDao;
  }

  @NotNull
  @Override
  public List<Good> getAllGoods() {
    return itemDao.getAllGoods();
  }

  @NotNull
  @Override
  public List<Armor> getAllArmor() {
    return itemDao.getAllArmor();
  }

  @NotNull
  @Override
  public List<WeaponFamily> getAllWeaponFamilies() {
    return itemDao.getAllWeaponFamilies();
  }

  @NotNull
  @Override
  public List<Weapon> getAllWeapons(@NotNull final List<WeaponFamily> allWeaponTypes) {
    return itemDao.getAllWeapons(allWeaponTypes);
  }

  @NotNull
  @Override
  public Weapon createWeapon(final @NotNull Weapon weapon) {
    checkCritical(weapon.getCritical());
    itemDao.createWeapon(weapon);
    return weapon;
  }

  void checkCritical(final Critical critical) {
    if (critical.getHit() < 0 || critical.getHit() > 20) {
      throw new RuleException(RuleError.INVALID_CRITICAL_HIT_VALUE, critical.getHit());
    }
  }

  @Override
  public void updateWeapon(final @NotNull Weapon weapon) {
    checkCritical(weapon.getCritical());
    itemDao.updateWeapon(weapon);
  }

  @NotNull
  @Override
  public Armor createArmor(@NotNull final Armor armor) {
    itemDao.createArmor(armor);
    return armor;
  }

  @Override
  public void updateArmor(@NotNull final Armor armor) {
    itemDao.updateArmor(armor);
  }

  @NotNull
  @Override
  public Good createGood(@NotNull final Good good) {
    itemDao.createGood(good);
    return good;
  }

  @Override
  public void updateGood(@NotNull final Good good) {
    itemDao.updateGood(good);
  }

  @NotNull
  @Override
  public List<Weapon> getEquipableWeapons(final @NotNull List<Weapon> allWeapons) {
    final List<Weapon> equipWeapons = new ArrayList<>(allWeapons.size());
    for (final Weapon weapon : allWeapons) {
      if (weapon.getCost() == 0 && weapon.getWeight() == 0) {
        continue;
      }
      equipWeapons.add(weapon);
    }
    return equipWeapons;
  }

  @NotNull
  @Override
  public Item getItemById(final int itemId, final @NotNull List<? extends Item> items) {
    for (final Item item : items) {
      if (item.getId() == itemId) {
        return item;
      }
    }
    throw new IllegalArgumentException("Can't find item with id: " + itemId);
  }

  @NotNull
  @Override
  public List<Weapon> filterWeaponsByType(@NotNull WeaponType weaponType, @NotNull List<Weapon> allWeapons) {
    return allWeapons.stream().filter(weapon -> weapon.getWeaponType().equals(weaponType)) //
        .filter(weapon -> weapon.getQualityType().equals(QualityType.NORMAL)) //
        .filter(weapon -> weapon.getWeight() > 0) //
        .collect(Collectors.toList());
  }

  @NotNull
  @Override
  public List<Weapon> filterWeaponsByCombat(@NotNull CombatType combatType, @NotNull List<Weapon> allWeapons) {
    return allWeapons.stream().filter(weapon -> weapon.getCombatType().equals(combatType)) //
        .filter(weapon -> weapon.getQualityType().equals(QualityType.NORMAL)) //
        .filter(weapon -> weapon.getWeight() > 0) //
        .collect(Collectors.toList());
  }

  @NotNull
  @Override
  public List<Armor> filterArmorByType(@NotNull ArmorType armorType, @NotNull List<Armor> allArmor) {
    return allArmor.stream() //
        .filter(armor -> armor.getArmorType().equals(armorType)) //
        .filter(armor -> armor.getQualityType().equals(QualityType.NORMAL)) //
        .collect(Collectors.toList());
  }

  @NotNull
  @Override
  public List<Good> filterGoodsByType(@NotNull GoodType goodType, @NotNull List<Good> allGoods) {
    return allGoods.stream().filter(good -> good.getGoodType().equals(goodType)) //
        .filter(good -> good.getQualityType().equals(QualityType.NORMAL)) //
        .collect(Collectors.toList());
  }

  @NotNull
  @Override
  public EquipmentPack getEquipmentPackById(int equipmentPackId, @NotNull List<EquipmentPack> allEquipmentPacks) {
    for (final EquipmentPack pack : allEquipmentPacks) {
      if (pack.getId() == equipmentPackId) {
        return pack;
      }
    }
    throw new IllegalArgumentException("Can't find equipment pack with id: " + equipmentPackId);
  }

  @NotNull
  @Override
  public List<EquipmentPack> getAllEquipmentPacks(@NotNull List<? extends Item> allItems) {
    return itemDao.getAllEquipmentPacks(allItems);
  }

}
