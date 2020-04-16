package com.d20charactersheet.framework.boc.service;

import java.util.ArrayList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.RuleError;
import com.d20charactersheet.framework.boc.model.RuleException;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
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

  @Override
  public List<Good> getAllGoods() {
    return itemDao.getAllGoods();
  }

  @Override
  public List<Armor> getAllArmor() {
    return itemDao.getAllArmor();
  }

  @Override
  public List<WeaponFamily> getAllWeaponFamilies() {
    return itemDao.getAllWeaponFamilies();
  }

  @Override
  public List<Weapon> getAllWeapons(final List<WeaponFamily> allWeaponTypes) {
    return itemDao.getAllWeapons(allWeaponTypes);
  }

  @Override
  public Weapon createWeapon(final Weapon weapon) {
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
  public void updateWeapon(final Weapon weapon) {
    checkCritical(weapon.getCritical());
    itemDao.updateWeapon(weapon);
  }

  @Override
  public Armor createArmor(final Armor armor) {
    itemDao.createArmor(armor);
    return armor;
  }

  @Override
  public void updateArmor(final Armor armor) {
    itemDao.updateArmor(armor);
  }

  @Override
  public Good createGood(final Good good) {
    itemDao.createGood(good);
    return good;
  }

  @Override
  public void updateGood(final Good good) {
    itemDao.updateGood(good);
  }

  @Override
  public List<Weapon> getEquipableWeapons(final List<Weapon> allWeapons) {
    final List<Weapon> equipWeapons = new ArrayList<>(allWeapons.size());
    for (final Weapon weapon : allWeapons) {
      if (weapon.getCost() == 0 && weapon.getWeight() == 0) {
        continue;
      }
      equipWeapons.add(weapon);
    }
    return equipWeapons;
  }

  @Override
  public Item getItemById(final int itemId, final List<? extends Item> items) {
    for (final Item item : items) {
      if (item.getId() == itemId) {
        return item;
      }
    }
    throw new IllegalArgumentException("Can't find item with id: " + itemId);
  }

}
