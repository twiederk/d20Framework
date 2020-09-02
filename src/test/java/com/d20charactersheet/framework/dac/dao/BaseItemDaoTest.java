package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
    // Arrange
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();

    // Act
    final List<Weapon> weapons = itemDao.getAllWeapons(allWeaponTypes);

    // Assert
    assertThat(weapons).hasSize(110);
  }

  @Test
  public void testWeapon() {
    // Arrange
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();
    final List<Weapon> allWeapons = itemDao.getAllWeapons(allWeaponTypes);

    // Act
    final Weapon silverDagger = getWeaponByName(allWeapons);

    // Assert
    assertThat(silverDagger.getName()).isEqualTo("Silver Dagger");
    assertThat(silverDagger.getCost()).isEqualTo(322.0f);
    assertThat(silverDagger.getWeight()).isEqualTo(1.0f);
    assertThat(silverDagger.getCritical().getHit()).isEqualTo(19);
    assertThat(silverDagger.getCritical().getMultiplier()).isEqualTo(2);
    assertThat(silverDagger.getWeaponType()).isEqualTo(WeaponType.SIMPLE);
    assertThat(silverDagger.getCombatType()).isEqualTo(CombatType.MELEE_WEAPON);
    assertThat(silverDagger.getWeaponEncumbrance()).isEqualTo(WeaponEncumbrance.LIGHT_HANDED);
    assertThat(silverDagger.getWeaponCategory()).isEqualTo(WeaponCategory.NORMAL_WEAPON);

  }

  private Weapon getWeaponByName(final List<Weapon> allWeapons) {
    for (final Weapon weapon : allWeapons) {
      if (weapon.getName().equals("Silver Dagger")) {
        return weapon;
      }
    }
    throw new IllegalArgumentException("Can't find weapon with name: " + "Silver Dagger");
  }

  @Test
  public void testGetAllArmor() {

    // Act
    final List<Armor> armor = itemDao.getAllArmor();

    // Assert
    assertThat(armor).hasSize(38);
  }

  @Test
  public void testGetAllGoods() {
    // Arrange

    // Act
    final List<Good> goods = itemDao.getAllGoods();

    // Assert
    assertThat(goods).hasSize(131);
  }

  @Test
  public void testGetWeaponsOfBelvador() {
    // Arrange
    final Character character = new Character();
    character.setId(0);
    final List<WeaponFamily> allWeaponTypes = itemDao.getAllWeaponFamilies();

    // Act
    final List<ItemGroup> weapons = characterDao.getWeapons(character, itemDao.getAllWeapons(allWeaponTypes));

    // Assert
    assertThat(weapons).hasSize(3);
    assertItem(weapons.get(0), "Quarterstaff", "A quarterstaff is a double weapon.", 1);
    assertItem(weapons.get(1), "Crossbow, light", "You draw a light crossbow back by pulling a lever.", 1);
    assertItem(weapons.get(2), "Bolts, crossbow (10)",
               "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a wooden case that holds 10 bolts (or 5, for a repeating crossbow). A bolt that hits its target is destroyed, one that misses has a 50% chance of being destroyed or lost.",
               2);
  }

  @Test
  public void testGetArmorOfBelvador() {
    // Arrange
    final Character character = new Character();
    character.setId(0);

    // Act
    final List<ItemGroup> armor = characterDao.getArmor(character, itemDao.getAllArmor());

    // Assert
    assertThat(armor).isEmpty();
  }

  @Test
  public void testGetGoodsOfBelvador() {
    // Arrange
    final Character character = new Character();
    character.setId(0);

    // Act
    final List<ItemGroup> goods = characterDao.getGoods(character, itemDao.getAllGoods());

    // Assert
    assertThat(goods).hasSize(19);
    assertItem(goods.get(0), "Backpack", "A backpack is a leather pack carried on the back, typically with straps to secure it.",
               1);
    assertItem(goods.get(1), "Waterskin", "A waterskin is a leather pouch with a narrow neck that is used for holding water.", 1);
    assertItem(goods.get(2), "Trail Rations (per Day)",
               "Trail rations are compact, dry, high-energy foods suitable for travel, such as jerky, dried fruit, hardtack, and nuts.",
               10);
  }

  private void assertItem(final ItemGroup itemGroup, final String name, final String description, final int number) {
    assertThat(itemGroup.getItem().getName()).isEqualTo(name);
    assertThat(itemGroup.getItem().getDescription()).startsWith(description);
    assertThat(itemGroup.getNumber()).isEqualTo(number);
  }

  @Test
  public void testCreateWeapon() {
    // Arrange
    Weapon weapon = createWeapon();

    // Act
    weapon = itemDao.createWeapon(weapon);

    // Assert
    assertThat(weapon).isNotNull();
    assertThat(weapon.getId()).isGreaterThan(0);

    // tear down
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
    // Arrange
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

    // Act
    itemDao.updateWeapon(weapon);

    // Assert
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
    assertThat(weapon).isNotNull();
    assertThat(weapon.getName()).isEqualTo("testUpdate");
    assertThat(weapon.getWeaponType()).isEqualTo(WeaponType.EXOTIC);
    assertThat(weapon.getCost()).isEqualTo(10.0f);
    assertThat(weapon.getWeight()).isEqualTo(100.0f);
    assertThat(weapon.isMagic()).isFalse();
    assertThat(weapon.getDamage().getNumberOfDice()).isEqualTo(1);
    assertThat(weapon.getDamage().getDie()).isEqualTo(Die.D10);
    assertThat(weapon.getEnhancementBonus()).isEqualTo(0);
    assertThat(weapon.getCritical().getHit()).isEqualTo(20);
    assertThat(weapon.getCritical().getMultiplier()).isEqualTo(2);
    assertThat(weapon.getDescription()).isEqualTo("testUpdateDescription");
  }

  @Test
  public void testCreateArmor() {
    // Arrange
    Armor armor = createArmor();

    // Act
    armor = itemDao.createArmor(armor);

    // Assert
    assertThat(armor).isNotNull();
    assertThat(armor.getId()).isGreaterThan(0);

    // tear down
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
    // Arrange
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

    // Act
    itemDao.updateArmor(armor);

    // Assert
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
    assertThat(armor).isNotNull();
    assertThat(armor.getName()).isEqualTo("testUpdate");
    assertThat(armor.getArmorType()).isEqualTo(ArmorType.LIGHT);
    assertThat(armor.getCost()).isEqualTo(10.0f);
    assertThat(armor.getWeight()).isEqualTo(100.0f);
    assertThat(armor.isMagic()).isFalse();
    assertThat(armor.getArmorBonus()).isEqualTo(1);
    assertThat(armor.getArmorCheckPenalty()).isEqualTo(-1);
    assertThat(armor.getDescription()).isEqualTo("testUpdateDescription");
  }

  @Test
  public void testCreateGood() {
    // Arrange
    Good good = createGood();

    // Act
    good = itemDao.createGood(good);

    // Assert
    assertThat(good).isNotNull();
    assertThat(good.getId()).isGreaterThan(0);

    // tear down
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
    // Arrange
    Good good = itemDao.getAllGoods().get(0);
    final Good backup = backupGood(good);
    final int goodId = good.getId();
    good.setName("testUpdate");
    good.setGoodType(GoodType.CLOTHING);
    good.setCost(10.0f);
    good.setWeight(100.0f);
    good.setQualityType(QualityType.NORMAL);
    good.setDescription("testUpdateDescription");

    // Act
    itemDao.updateGood(good);

    // Assert
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
    assertThat(good).isNotNull();
    assertThat(good.getName()).isEqualTo("testUpdate");
    assertThat(good.getGoodType()).isEqualTo(GoodType.CLOTHING);
    assertThat(good.getCost()).isEqualTo(10.0f);
    assertThat(good.getWeight()).isEqualTo(100.0f);
    assertThat(good.isMagic()).isFalse();
    assertThat(good.getDescription()).isEqualTo("testUpdateDescription");
  }

}
