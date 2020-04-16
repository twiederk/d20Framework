package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;

public abstract class BaseItemDaoTest {

  protected CharacterDao characterDao;
  protected ItemDao itemDao;

  @Test
  public void testGetAllWeapons() {
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();
    final List<Weapon> weapons = itemDao.getAllWeapons(allWeaponTypes);
    assertNotNull(weapons);
    assertEquals(110, weapons.size());
  }

  @Test
  public void testWeapon() {
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();
    final List<Weapon> allWeapons = itemDao.getAllWeapons(allWeaponTypes);
    final Weapon silverDagger = getWeaponByName("Silver Dagger", allWeapons);
    assertEquals("Silver Dagger", silverDagger.getName());
    assertEquals(322.0f, silverDagger.getCost(), 0.0f);
    assertEquals(1.0f, silverDagger.getWeight(), 0.0f);
    assertEquals(19, silverDagger.getCritical()
        .getHit());
    assertEquals(2, silverDagger.getCritical()
        .getMultiplier());
    assertEquals(WeaponType.SIMPLE, silverDagger.getWeaponType());
    assertEquals(CombatType.MELEE_WEAPON, silverDagger.getCombatType());
    assertEquals(WeaponEncumbrance.LIGHT_HANDED, silverDagger.getWeaponEncumbrance());
    assertEquals(WeaponCategory.NORMAL_WEAPON, silverDagger.getWeaponCategory());

  }

  private Weapon getWeaponByName(final String name, final List<Weapon> allWeapons) {
    for (final Weapon weapon : allWeapons) {
      if (weapon.getName().equals(name)) {
        return weapon;
      }
    }
    throw new IllegalArgumentException("Can't find weapon with name: " + name);
  }

  @Test
  public void testGetAllArmor() {
    final List<Armor> armor = itemDao.getAllArmor();
    assertNotNull(armor);
    assertEquals(38, armor.size());
  }

  @Test
  public void testGetAllGoods() {
    final List<Good> goods = itemDao.getAllGoods();
    assertNotNull(goods);
    assertEquals(131, goods.size());
  }

  @Test
  public void testGetWeaponsOfBelvador() {
    final Character character = new Character();
    character.setId(0);
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();
    final List<ItemGroup> weapons = characterDao.getWeapons(character, itemDao.getAllWeapons(allWeaponTypes));
    assertNotNull(weapons);
    assertEquals(3, weapons.size());
    assertItem(weapons.get(0), "Quarterstaff", "A quarterstaff is a double weapon.", 1);
    assertItem(weapons.get(1), "Crossbow, light", "You draw a light crossbow back by pulling a lever.", 1);
    assertItem(weapons.get(2), "Bolts, crossbow (10)",
               "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a wooden case that holds 10 bolts (or 5, for a repeating crossbow). A bolt that hits its target is destroyed, one that misses has a 50% chance of being destroyed or lost.",
               2);
  }

  @Test
  public void testGetArmorOfBelvador() {
    final Character character = new Character();
    character.setId(0);
    final List<ItemGroup> armor = characterDao.getArmor(character, itemDao.getAllArmor());
    assertNotNull(armor);
    assertEquals(0, armor.size());
  }

  @Test
  public void testGetGoodsOfBelvador() {
    final Character character = new Character();
    character.setId(0);
    final List<ItemGroup> goods = characterDao.getGoods(character, itemDao.getAllGoods());
    assertNotNull(goods);
    assertEquals(19, goods.size());
    assertItem(goods.get(0), "Backpack", "A backpack is a leather pack carried on the back, typically with straps to secure it.",
               1);
    assertItem(goods.get(1), "Waterskin", "A waterskin is a leather pouch with a narrow neck that is used for holding water.", 1);
    assertItem(goods.get(2), "Trail Rations (per Day)",
               "Trail rations are compact, dry, high-energy foods suitable for travel, such as jerky, dried fruit, hardtack, and nuts.",
               10);
  }

  private void assertItem(final ItemGroup itemGroup, final String name, final String description, final int number) {
    assertEquals(name, itemGroup.getItem().getName());
    assertTrue(itemGroup.getItem().getDescription().startsWith(description));
    assertEquals(number, itemGroup.getNumber());
  }

  @Test
  public void testCreateWeapon() {
    Weapon weapon = createWeapon();
    weapon = itemDao.createWeapon(weapon);
    assertNotNull(weapon);
    assertTrue(weapon.getId() > 0);
    itemDao.deleteWeapon(weapon);
  }

  private Weapon createWeapon() {
    final Weapon weapon = new Weapon();
    weapon.setName("testName");
    weapon.setWeaponType(WeaponType.SIMPLE);
    weapon.setWeight(10.0f);
    weapon.setCost(100.0f);
    weapon.setQualityType(QualityType.NORMAL);
    weapon.setDamage(new Damage(1, Die.D8));
    weapon.setCritical(new Critical(20, 2));
    weapon.setDescription("testDescription");
    weapon.setCombatType(CombatType.MELEE_WEAPON);
    weapon.setWeaponEncumbrance(WeaponEncumbrance.ONE_HANDED);
    weapon.setWeaponCategory(WeaponCategory.NORMAL_WEAPON);
    final WeaponFamily weaponFamily = new WeaponFamily();
    weaponFamily.setId(1);
    weaponFamily.setName("testWeaponType");
    weapon.setWeaponFamily(weaponFamily);
    return weapon;
  }

  @Test
  public void testUpdateWeapon() {
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();
    Weapon weapon = itemDao.getAllWeapons(allWeaponTypes).get(0);
    final Weapon backup = backupWeapon(weapon);
    final int weaponId = weapon.getId();
    weapon.setName("testUpdate");
    weapon.setWeaponType(WeaponType.EXOTIC);
    weapon.setCost(10.0f);
    weapon.setWeight(100.0f);
    weapon.setQualityType(QualityType.NORMAL);
    weapon.setDamage(new Damage(1, Die.D10));
    weapon.setCritical(new Critical(20, 2));
    weapon.setDescription("testUpdateDescription");
    weapon.setCombatType(CombatType.MELEE_WEAPON);
    weapon.setWeaponEncumbrance(WeaponEncumbrance.ONE_HANDED);
    weapon.setWeaponCategory(WeaponCategory.NORMAL_WEAPON);
    final WeaponFamily weaponFamily = new WeaponFamily();
    weaponFamily.setId(1);
    weaponFamily.setName("testWeaponFamily");
    weapon.setWeaponFamily(weaponFamily);

    itemDao.updateWeapon(weapon);

    weapon = (Weapon) getItemById(weaponId, itemDao.getAllWeapons(allWeaponTypes));
    assertWeaponUpdate(weapon);

    // tear down
    itemDao.updateWeapon(backup);
  }

  private Weapon backupWeapon(final Weapon weapon) {
    final Weapon backup = new Weapon();
    backup.setId(weapon.getId());
    backup.setName(weapon.getName());
    backup.setWeaponType(weapon.getWeaponType());
    backup.setCost(weapon.getCost());
    backup.setWeight(weapon.getWeight());
    backup.setQualityType(weapon.getQualityType());
    backup.setDamage(weapon.getDamage());
    backup.setCritical(weapon.getCritical());
    backup.setDescription(weapon.getDescription());
    backup.setCombatType(weapon.getCombatType());
    backup.setWeaponEncumbrance(weapon.getWeaponEncumbrance());
    backup.setWeaponCategory(weapon.getWeaponCategory());
    backup.setWeaponFamily(weapon.getWeaponFamily());
    return backup;
  }

  private Item getItemById(final int itemId, final List<? extends Item> allItems) {
    for (final Item item : allItems) {
      if (itemId == item.getId()) {
        return item;
      }
    }
    return null;
  }

  private void assertWeaponUpdate(final Weapon weapon) {
    assertNotNull(weapon);
    assertEquals("testUpdate", weapon.getName());
    assertEquals(WeaponType.EXOTIC, weapon.getWeaponType());
    assertEquals(10.0f, weapon.getCost(), 0.0f);
    assertEquals(100.0f, weapon.getWeight(), 0.0f);
    assertFalse(weapon.isMagic());
    assertEquals(1, weapon.getDamage().getNumberOfDice());
    assertEquals(Die.D10, weapon.getDamage().getDie());
    assertEquals(0, weapon.getEnhancementBonus());
    assertEquals(20, weapon.getCritical().getHit());
    assertEquals(2, weapon.getCritical().getMultiplier());
    assertEquals("testUpdateDescription", weapon.getDescription());
  }

  @Test
  public void testCreateArmor() {
    Armor armor = createArmor();
    armor = itemDao.createArmor(armor);
    assertNotNull(armor);
    assertTrue(armor.getId() > 0);
    itemDao.deleteArmor(armor);
  }

  private Armor createArmor() {
    final Armor armor = new Armor();
    armor.setName("testName");
    armor.setArmorType(ArmorType.LIGHT);
    armor.setCost(10.0f);
    armor.setWeight(100.0f);
    armor.setQualityType(QualityType.NORMAL);
    armor.setArmorBonus(1);
    armor.setArmorCheckPenalty(-1);
    armor.setDescription("testDescription");
    return armor;
  }

  @Test
  public void testUpdateArmor() {
    Armor armor = itemDao.getAllArmor().get(0);
    final Armor backup = backupArmor(armor);
    final int armorId = armor.getId();
    armor.setName("testUpdate");
    armor.setArmorType(ArmorType.LIGHT);
    armor.setCost(10.0f);
    armor.setWeight(100.0f);
    armor.setQualityType(QualityType.NORMAL);
    armor.setArmorBonus(1);
    armor.setArmorCheckPenalty(-1);
    armor.setDescription("testUpdateDescription");

    itemDao.updateArmor(armor);

    armor = (Armor) getItemById(armorId, itemDao.getAllArmor());
    assertArmorUpdate(armor);

    // tear down
    itemDao.updateArmor(backup);
  }

  private Armor backupArmor(final Armor armor) {
    final Armor backup = new Armor();
    backup.setId(armor.getId());
    backup.setName(armor.getName());
    backup.setArmorType(armor.getArmorType());
    backup.setCost(armor.getCost());
    backup.setWeight(armor.getWeight());
    backup.setQualityType(armor.getQualityType());
    backup.setArmorBonus(armor.getArmorBonus());
    backup.setArmorCheckPenalty(armor.getArmorCheckPenalty());
    backup.setDescription(armor.getDescription());
    return backup;
  }

  private void assertArmorUpdate(final Armor armor) {
    assertNotNull(armor);
    assertEquals("testUpdate", armor.getName());
    assertEquals(ArmorType.LIGHT, armor.getArmorType());
    assertEquals(10.0f, armor.getCost(), 0.0f);
    assertEquals(100.0f, armor.getWeight(), 0.0f);
    assertFalse(armor.isMagic());
    assertEquals(1, armor.getArmorBonus());
    assertEquals(-1, armor.getArmorCheckPenalty());
    assertEquals("testUpdateDescription", armor.getDescription());
  }

  @Test
  public void testCreateGood() {
    Good good = createGood();
    good = itemDao.createGood(good);
    assertNotNull(good);
    assertTrue(good.getId() > 0);
    itemDao.deleteGood(good);
  }

  private Good createGood() {
    final Good good = new Good();
    good.setName("testName");
    good.setGoodType(GoodType.ADVENTURING_GEAR);
    good.setWeight(10.0f);
    good.setCost(100.0f);
    good.setQualityType(QualityType.NORMAL);
    good.setDescription("testDescription");
    return good;
  }

  @Test
  public void testUpdateGood() {
    Good good = itemDao.getAllGoods().get(0);
    final Good backup = backupGood(good);
    final int goodId = good.getId();
    good.setName("testUpdate");
    good.setGoodType(GoodType.CLOTHING);
    good.setCost(10.0f);
    good.setWeight(100.0f);
    good.setQualityType(QualityType.NORMAL);
    good.setDescription("testUpdateDescription");

    itemDao.updateGood(good);

    good = (Good) getItemById(goodId, itemDao.getAllGoods());
    assertGoodUpdate(good);

    // tear down
    itemDao.updateGood(backup);
  }

  private Good backupGood(final Good good) {
    final Good backup = new Good();
    backup.setId(good.getId());
    backup.setName(good.getName());
    backup.setGoodType(good.getGoodType());
    backup.setCost(good.getCost());
    backup.setWeight(good.getWeight());
    backup.setQualityType(good.getQualityType());
    backup.setDescription(good.getDescription());
    return backup;
  }

  private void assertGoodUpdate(final Good good) {
    assertNotNull(good);
    assertEquals("testUpdate", good.getName());
    assertEquals(GoodType.CLOTHING, good.getGoodType());
    assertEquals(10.0f, good.getCost(), 0.0f);
    assertEquals(100.0f, good.getWeight(), 0.0f);
    assertFalse(good.isMagic());
    assertEquals("testUpdateDescription", good.getDescription());
  }

}
