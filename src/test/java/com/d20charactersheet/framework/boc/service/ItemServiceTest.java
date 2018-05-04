package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ArmorStorage.ARMOR;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35GoodStorage.GOOD;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35WeaponStorage.WEAPON;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35WeaponStorage.WEAPON_FAMILY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.RuleException;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;
import com.d20charactersheet.framework.dac.dao.dummy.DummyItemDao;

public class ItemServiceTest {

  private ItemService itemService;

  @Before
  public void setUp() throws Exception {
    itemService = new ItemServiceImpl(new DummyItemDao(WEAPON_FAMILY, WEAPON, ARMOR, GOOD));
  }

  @Test
  public void testGetAllWeapons() {
    final List<WeaponFamily> allWeaponTypes = itemService.getAllWeaponFamilies();
    final List<Weapon> allWeapons = itemService.getAllWeapons(allWeaponTypes);
    assertNotNull(allWeapons);
    assertEquals(110, allWeapons.size());

    final Weapon gauntlet = allWeapons.get(0);
    assertEquals(0, gauntlet.getId());
    assertEquals("Gauntlet", gauntlet.getName());
    assertEquals(2.0f, gauntlet.getCost(), 0.0f);
    assertEquals(1.0f, gauntlet.getWeight(), 0.0f);
    final Damage damage = gauntlet.getDamage();
    assertEquals(1, damage.getNumberOfDice());
    assertEquals(Die.D3, damage.getDie());
    assertEquals(0, gauntlet.getEnhancementBonus());
    final Critical critical = gauntlet.getCritical();
    assertEquals(20, critical.getHit());
    assertEquals(2, critical.getMultiplier());
    assertEquals(WeaponType.SIMPLE, gauntlet.getWeaponType());
  }

  @Test
  public void testGetAllArmors() {
    final List<Armor> allArmors = itemService.getAllArmor();
    assertNotNull(allArmors);
    assertEquals(38, allArmors.size());

    final Armor padded = allArmors.get(0);
    assertEquals(0, padded.getId());
    assertEquals("Padded", padded.getName());
    assertEquals(10.0f, padded.getWeight(), 0.0f);
    assertEquals(5.0f, padded.getCost(), 0.0f);
    assertEquals(1, padded.getArmorBonus());
    assertEquals(0, padded.getArmorCheckPenalty());
    assertEquals(ArmorType.LIGHT, padded.getArmorType());
  }

  @Test
  public void testGetAllGoods() {
    final List<Good> allGoods = itemService.getAllGoods();
    assertNotNull(allGoods);
    assertEquals(131, allGoods.size());

    final Good barrel = allGoods.get(1);
    assertEquals(1, barrel.getId());
    assertEquals("Barrel", barrel.getName());
    assertEquals(2.0f, barrel.getCost(), 0.0f);
    assertEquals(30.0f, barrel.getWeight(), 0.0f);
    assertEquals(GoodType.ADVENTURING_GEAR, barrel.getGoodType());
  }

  @Test
  public void testCreateWeapon() {
    final List<WeaponFamily> allWeaponFamilies = itemService.getAllWeaponFamilies();
    final int numberOfWeapons = itemService.getAllWeapons(allWeaponFamilies).size();

    Weapon weapon = new Weapon();
    weapon.setName("testName");
    weapon.setWeaponType(WeaponType.SIMPLE);
    weapon.setCost(10.0f);
    weapon.setWeight(100.0f);
    weapon.setQualityType(QualityType.NORMAL);
    weapon.setDamage(new Damage(1, Die.D8));
    weapon.setCritical(new Critical(20, 2));
    weapon.setDescription("testDescription");
    weapon.setCombatType(CombatType.MELEE_WEAPON);
    weapon.setWeaponEncumbrance(WeaponEncumbrance.ONE_HANDED);
    weapon.setWeaponCategory(WeaponCategory.NORMAL_WEAPON);
    weapon.setWeaponFamily(allWeaponFamilies.get(0));
    weapon.setRangeIncrement(10);

    weapon = itemService.createWeapon(weapon);
    assertTrue(weapon.getId() > 0);

    final List<Weapon> allWeapons = itemService.getAllWeapons(allWeaponFamilies);
    assertEquals(numberOfWeapons + 1, allWeapons.size());

    weapon = (Weapon) getItem(allWeapons);
    assertNotNull(weapon);
    assertWeapon(weapon);
  }

  private void assertWeapon(final Weapon weapon) {
    final Damage damage = weapon.getDamage();
    final Critical critical = weapon.getCritical();
    assertEquals("testName", weapon.getName());
    assertEquals(WeaponType.SIMPLE, weapon.getWeaponType());
    assertEquals(10.0f, weapon.getCost(), 0.0f);
    assertEquals(100.0f, weapon.getWeight(), 0.0f);
    assertFalse(weapon.isMagic());
    assertEquals(1, damage.getNumberOfDice());
    assertEquals(Die.D8, damage.getDie());
    assertEquals(0, weapon.getEnhancementBonus());
    assertEquals(20, critical.getHit());
    assertEquals(2, critical.getMultiplier());
    assertEquals("testDescription", weapon.getDescription());
    assertEquals(10, weapon.getRangeIncrement());
  }

  private Item getItem(final List<? extends Item> allItems) {
    for (final Item item : allItems) {
      if ("testName".equals(item.getName())) {
        return item;
      }
    }
    return null;
  }

  @Test
  public void testUpdateWeapon() throws Exception {
    final List<WeaponFamily> allWeaponTypes = itemService.getAllWeaponFamilies();
    Weapon weapon = itemService.getAllWeapons(allWeaponTypes).get(0);
    final int weaponId = weapon.getId();
    weapon.setName("testUpdate");
    weapon.setWeaponType(WeaponType.EXOTIC);
    weapon.setCost(10.0f);
    weapon.setWeight(100.0f);
    weapon.setQualityType(QualityType.NORMAL);
    weapon.setDamage(new Damage(1, Die.D10));
    weapon.setCritical(new Critical(20, 2));
    weapon.setDescription("testUpdateDescription");

    itemService.updateWeapon(weapon);

    weapon = (Weapon) getItemById(weaponId, itemService.getAllWeapons(allWeaponTypes));
    assertItemUpdate(weapon);

  }

  private Item getItemById(final int itemId, final List<? extends Item> allItems) {
    for (final Item item : allItems) {
      if (itemId == item.getId()) {
        return item;
      }
    }
    return null;
  }

  private void assertItemUpdate(final Item item) {
    assertNotNull(item);
    assertEquals("testUpdate", item.getName());
    assertEquals("testUpdateDescription", item.getDescription());
  }

  @Test
  public void testCheckCritical() throws Exception {
    final Critical zeroHitCritical = new Critical(0, 0);
    final Critical oneHitCritical = new Critical(1, 0);
    final Critical tweentyHitCritical = new Critical(20, 0);
    final Critical negativeHitCritical = new Critical(-1, 0);
    final Critical above20HitCritical = new Critical(21, 0);

    final ItemServiceImpl itemServiceImpl = (ItemServiceImpl) itemService;
    itemServiceImpl.checkCritical(oneHitCritical);
    itemServiceImpl.checkCritical(tweentyHitCritical);
    itemServiceImpl.checkCritical(zeroHitCritical);
    assertCheckCriticalException(negativeHitCritical, itemServiceImpl);
    assertCheckCriticalException(above20HitCritical, itemServiceImpl);

  }

  private void assertCheckCriticalException(final Critical critical, final ItemServiceImpl itemServiceImpl) {
    try {
      itemServiceImpl.checkCritical(critical);
      fail("Expected RuleException");
    } catch (final RuleException ruleException) {
      // success expected exception was thrown
    } catch (final Exception exception) {
      fail("Expected RuleException");
    }
  }

  @Test
  public void testCreateArmor() {
    final int numberOfArmor = itemService.getAllArmor().size();

    Armor armor = new Armor();
    armor.setName("testName");
    armor.setArmorType(ArmorType.LIGHT);
    armor.setCost(10.0f);
    armor.setWeight(100.0f);
    armor.setQualityType(QualityType.NORMAL);
    armor.setArmorBonus(1);
    armor.setArmorCheckPenalty(-1);
    armor.setDescription("testDescription");

    armor = itemService.createArmor(armor);
    assertNotNull(armor);
    assertTrue(armor.getId() > 0);

    final List<Armor> allArmors = itemService.getAllArmor();
    assertEquals(numberOfArmor + 1, allArmors.size());

    armor = (Armor) getItem(allArmors);
    assertNotNull(armor);
    assertArmor(armor);
  }

  private void assertArmor(final Armor armor) {
    assertEquals("testName", armor.getName());
    assertEquals(ArmorType.LIGHT, armor.getArmorType());
    assertEquals(10.0f, armor.getCost(), 0.0f);
    assertEquals(100.0f, armor.getWeight(), 0.0f);
    assertFalse(armor.isMagic());
    assertEquals(1, armor.getArmorBonus());
    assertEquals(-1, armor.getArmorCheckPenalty());
    assertEquals("testDescription", armor.getDescription());
  }

  @Test
  public void testUpdateArmor() throws Exception {
    Armor armor = itemService.getAllArmor().get(0);
    final int armorId = armor.getId();
    armor.setName("testUpdate");
    armor.setArmorType(ArmorType.LIGHT);
    armor.setCost(10.0f);
    armor.setWeight(100.0f);
    armor.setQualityType(QualityType.NORMAL);
    armor.setArmorBonus(1);
    armor.setArmorCheckPenalty(-1);
    armor.setDescription("testUpdateDescription");

    itemService.updateArmor(armor);

    armor = (Armor) getItemById(armorId, itemService.getAllArmor());
    assertItemUpdate(armor);

  }

  @Test
  public void testCreateGood() {
    final int numberOfGoods = itemService.getAllGoods().size();
    Good good = new Good();
    good.setName("testName");
    good.setGoodType(GoodType.ADVENTURING_GEAR);
    good.setCost(10.0f);
    good.setWeight(100.0f);
    good.setQualityType(QualityType.NORMAL);
    good.setDescription("testDescription");

    good = itemService.createGood(good);
    assertTrue(good.getId() > 0);

    final List<Good> allGoods = itemService.getAllGoods();
    assertEquals(numberOfGoods + 1, allGoods.size());

    good = (Good) getItem(allGoods);
    assertNotNull(good);
    assertGood(good);
  }

  private void assertGood(final Good good) {
    assertEquals("testName", good.getName());
    assertEquals(GoodType.ADVENTURING_GEAR, good.getGoodType());
    assertEquals(10.0f, good.getCost(), 0.0f);
    assertEquals(100.0f, good.getWeight(), 0.0f);
    assertFalse(good.isMagic());
    assertEquals("testDescription", good.getDescription());
  }

  @Test
  public void testUpdateGood() throws Exception {
    Good good = itemService.getAllGoods().get(0);
    final int goodId = good.getId();
    good.setName("testUpdate");
    good.setGoodType(GoodType.SPECIAL_ITEM);
    good.setCost(10.0f);
    good.setWeight(100.0f);
    good.setQualityType(QualityType.NORMAL);
    good.setDescription("testUpdateDescription");

    itemService.updateGood(good);

    good = (Good) getItemById(goodId, itemService.getAllGoods());
    assertItemUpdate(good);
  }

  @Test
  public void testGetEquipableWeapons() throws Exception {
    final List<WeaponFamily> allWeaponTypes = itemService.getAllWeaponFamilies();
    final List<Weapon> allWeapons = itemService.getAllWeapons(allWeaponTypes);

    final List<Weapon> equipableWeapons = itemService.getEquipableWeapons(allWeapons);

    assertNotNull(equipableWeapons);
    assertEquals(104, equipableWeapons.size());
  }
}
