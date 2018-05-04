package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.ArrayList;
import java.util.List;

import com.androidash.memorydb.DaoUtil;
import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;
import com.d20charactersheet.framework.dac.dao.ItemDao;
import com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35WeaponStorage;

/**
 * Stores weapons, armor and goods of character in memory. Retrieves weapons, armor and goods from ItemStorage.
 */
public class DummyItemDao implements ItemDao {

  private final DataTable weaponFamilyDataTable;
  private final DataTable weaponDataTable;
  private final DataTable armorDataTable;
  private final DataTable goodDataTable;
  private final DaoUtil daoUtil;

  /**
   * Instanciates DummyItemDao. Creating tables in memory of weapons, armor and goods. Also creating table of weapons,
   * armor and goods carried by the characters.
   *
   * @param weaponFamilies
   *     Weapon families raw data.
   * @param weapons
   *     Weapons raw data.
   * @param armor
   *     Armor raw data.
   * @param goods
   *     Goods raw data.
   */
  public DummyItemDao(final Object[][] weaponFamilies, final Object[][] weapons, final Object[][] armor, final Object[][] goods) {
    weaponFamilyDataTable = new DataTable(weaponFamilies);
    weaponDataTable = new DataTable(weapons);
    armorDataTable = new DataTable(armor);
    goodDataTable = new DataTable(goods);
    daoUtil = new DaoUtil();
  }

  @Override
  public List<WeaponFamily> getAllWeaponFamilies() {
    final List<WeaponFamily> allWeaponFamilies = new ArrayList<WeaponFamily>(DnDv35WeaponStorage.WEAPON_FAMILY.length);
    for (final DataRow dataRow : weaponFamilyDataTable) {
      final WeaponFamily weaponFamily = selectWeaponType(dataRow);
      allWeaponFamilies.add(weaponFamily);
    }
    return allWeaponFamilies;
  }

  private WeaponFamily selectWeaponType(final DataRow dataRow) {
    final WeaponFamily weaponType = new WeaponFamily();
    weaponType.setId(dataRow.getId());
    weaponType.setName(dataRow.getString(1));
    return weaponType;
  }

  @Override
  public List<Weapon> getAllWeapons(final List<WeaponFamily> allWeaponFamilies) {
    final List<Weapon> allWeapons = new ArrayList<Weapon>();
    for (final DataRow weaponDataRow : weaponDataTable) {
      final Weapon weapon = selectWeapon(weaponDataRow, allWeaponFamilies);
      allWeapons.add(weapon);
    }
    return allWeapons;
  }

  private Weapon selectWeapon(final DataRow dataRow, final List<WeaponFamily> allWeaponFamilies) {
    // id, name, cost, number of dice, die, bonus, critical hit, critical modifier, weight
    final Weapon weapon = new Weapon();
    weapon.setId(dataRow.getId());
    weapon.setName(dataRow.getString(1));
    weapon.setDescription(dataRow.getString(2));
    weapon.setCost((Float) dataRow.get(3));
    weapon.setWeight((Float) dataRow.get(4));
    weapon.setDamage(getDamage(dataRow));
    weapon.setEnhancementBonus(dataRow.getInt(7));
    weapon.setCritical(getCritical(dataRow));
    weapon.setWeaponType((WeaponType) daoUtil.getEnum(dataRow.getInt(10), WeaponType.values()));
    weapon.setQualityType((QualityType) daoUtil.getEnum(dataRow.getInt(11), QualityType.values()));
    weapon.setCombatType((CombatType) daoUtil.getEnum(dataRow.getInt(12), CombatType.values()));
    weapon.setWeaponEncumbrance((WeaponEncumbrance) daoUtil.getEnum(dataRow.getInt(13), WeaponEncumbrance.values()));
    weapon.setWeaponCategory((WeaponCategory) daoUtil.getEnum(dataRow.getInt(14), WeaponCategory.values()));
    weapon.setWeaponFamily(getWeaponFamilyById(dataRow.getInt(15), allWeaponFamilies));
    weapon.setRangeIncrement(dataRow.getInt(16));
    return weapon;
  }

  private Damage getDamage(final DataRow weaponDataRow) {
    final Damage damage = new Damage();
    damage.setNumberOfDice(weaponDataRow.getInt(5));
    damage.setDie((Die) daoUtil.getEnum(weaponDataRow.getInt(6), Die.values()));

    return damage;
  }

  private Critical getCritical(final DataRow weaponDataRow) {
    final Critical critical = new Critical();
    critical.setHit(weaponDataRow.getInt(8));
    critical.setMultiplier(weaponDataRow.getInt(9));
    return critical;
  }

  private WeaponFamily getWeaponFamilyById(final int weaponFamilyId, final List<WeaponFamily> allWeaponFamilies) {
    for (final WeaponFamily weaponFamily : allWeaponFamilies) {
      if (weaponFamily.getId() == weaponFamilyId) {
        return weaponFamily;
      }
    }
    throw new IllegalArgumentException("Can't find weapon family with id: " + weaponFamilyId);
  }

  @Override
  public List<Armor> getAllArmor() {
    final List<Armor> allArmors = new ArrayList<Armor>();
    for (final DataRow armorDataRow : armorDataTable) {
      final Armor armor = selectArmor(armorDataRow);
      allArmors.add(armor);
    }
    return allArmors;
  }

  private Armor selectArmor(final DataRow armorDataRow) {
    final Armor armor = new Armor();
    armor.setId(armorDataRow.getId());
    armor.setName(armorDataRow.getString(1));
    armor.setDescription(armorDataRow.getString(2));
    armor.setCost((Float) armorDataRow.get(3));
    armor.setWeight((Float) armorDataRow.get(4));
    armor.setArmorBonus(armorDataRow.getInt(5));
    armor.setArmorCheckPenalty(armorDataRow.getInt(6));
    armor.setArmorType((ArmorType) daoUtil.getEnum(armorDataRow.getInt(7), ArmorType.values()));
    armor.setQualityType((QualityType) daoUtil.getEnum(armorDataRow.getInt(8), QualityType.values()));
    return armor;
  }

  @Override
  public List<Good> getAllGoods() {
    final List<Good> allGoods = new ArrayList<Good>();
    for (final DataRow goodDataRow : goodDataTable) {
      final Good adventuringGear = selectGood(goodDataRow);
      allGoods.add(adventuringGear);
    }
    return allGoods;
  }

  private Good selectGood(final DataRow goodDataRow) {
    final Good good = new Good();
    good.setId(goodDataRow.getId());
    good.setName(goodDataRow.getString(1));
    good.setDescription(goodDataRow.getString(2));
    good.setCost((Float) goodDataRow.get(3));
    good.setWeight((Float) goodDataRow.get(4));
    good.setGoodType((GoodType) daoUtil.getEnum(goodDataRow.getInt(5), GoodType.values()));
    good.setQualityType((QualityType) daoUtil.getEnum(goodDataRow.getInt(6), QualityType.values()));
    return good;
  }

  @Override
  public Weapon createWeapon(final Weapon weapon) {
    weapon.setId(weaponDataTable.getNewId());
    insertWeapon(weapon);
    return weapon;
  }

  private void insertWeapon(final Weapon weapon) {
    final Damage damage = weapon.getDamage();
    final Critical critical = weapon.getCritical();
    weaponDataTable.insert( //
                            new Object[] {weapon.getId(), weapon.getName(), weapon.getDescription(), weapon.getCost(),
                                weapon.getWeight(), damage.getNumberOfDice(), damage.getDie().ordinal(),
                                weapon.getEnhancementBonus(), critical.getHit(), critical.getMultiplier(),
                                weapon.getWeaponType().ordinal(), weapon.getQualityType().ordinal(),
                                weapon.getCombatType().ordinal(), weapon.getWeaponEncumbrance().ordinal(),
                                weapon.getWeaponCategory().ordinal(), weapon.getWeaponFamily().getId(), weapon.getRangeIncrement()
                            });
  }

  @Override
  public void updateWeapon(final Weapon weapon) {
    deleteWeapon(weapon);
    insertWeapon(weapon);
  }

  public void deleteWeapon(final Weapon weapon) {
    weaponDataTable.delete(weapon.getId());
  }

  @Override
  public Armor createArmor(final Armor armor) {
    armor.setId(armorDataTable.getNewId());
    insertArmor(armor);
    return armor;
  }

  private void insertArmor(final Armor armor) {
    armorDataTable.insert( //
                           new Object[] {armor.getId(), armor.getName(), armor.getDescription(), armor.getCost(), armor.getWeight(),
                               armor.getArmorBonus(), armor.getArmorCheckPenalty(), armor.getArmorType().ordinal(),
                               armor.getQualityType().ordinal()
                           });
  }

  @Override
  public void updateArmor(final Armor armor) {
    deleteArmor(armor);
    insertArmor(armor);
  }

  public void deleteArmor(final Armor armor) {
    armorDataTable.delete(armor.getId());
  }

  @Override
  public Good createGood(final Good good) {
    good.setId(goodDataTable.getNewId());
    insertGood(good);
    return good;
  }

  private void insertGood(final Good good) {
    goodDataTable.insert( //
                          new Object[] {good.getId(), good.getName(), good.getDescription(), good.getCost(), good.getWeight(),
                              good.getGoodType().ordinal(), good.getQualityType().ordinal()
                          });
  }

  @Override
  public void deleteGood(final Good good) {
    goodDataTable.delete(good.getId());
  }

  @Override
  public void updateGood(final Good good) {
    deleteGood(good);
    insertGood(good);
  }
}
