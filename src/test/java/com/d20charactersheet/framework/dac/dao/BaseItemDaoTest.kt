package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

abstract class BaseItemDaoTest {

    protected lateinit var characterDao: CharacterDao
    protected lateinit var itemDao: ItemDao

    @Test
    fun testGetAllWeapons() {
        // arrange
        val allWeaponTypes = itemDao.getAllWeaponFamilies()

        // act
        val weapons = itemDao.getAllWeapons(allWeaponTypes)

        // assert
        assertThat(weapons).hasSize(110)
    }

    @Test
    fun testWeapon() {
        // arrange
        val allWeaponTypes = itemDao.getAllWeaponFamilies()
        val allWeapons = itemDao.getAllWeapons(allWeaponTypes)

        // act
        val silverDagger = getWeaponByName(allWeapons)

        // assert
        assertThat(silverDagger.name).isEqualTo("Silver Dagger")
        assertThat(silverDagger.cost).isEqualTo(322.0f)
        assertThat(silverDagger.weight).isEqualTo(1.0f)
        assertThat(silverDagger.critical.hit).isEqualTo(19)
        assertThat(silverDagger.critical.multiplier).isEqualTo(2)
        assertThat(silverDagger.weaponType).isEqualTo(WeaponType.SIMPLE)
        assertThat(silverDagger.combatType).isEqualTo(CombatType.MELEE_WEAPON)
        assertThat(silverDagger.weaponEncumbrance).isEqualTo(WeaponEncumbrance.LIGHT_HANDED)
        assertThat(silverDagger.weaponCategory).isEqualTo(WeaponCategory.NORMAL_WEAPON)
    }

    private fun getWeaponByName(allWeapons: List<Weapon>): Weapon {
        for (weapon in allWeapons) {
            if (weapon.name == "Silver Dagger") {
                return weapon
            }
        }
        throw IllegalArgumentException("Can't find weapon with name: " + "Silver Dagger")
    }

    @Test
    fun testGetAllArmor() {

        // act
        val armor = itemDao.getAllArmor()

        // assert
        assertThat(armor).hasSize(38)
    }

    @Test
    fun testGetAllGoods() {

        // act
        val goods = itemDao.getAllGoods()

        // assert
        assertThat(goods).hasSize(131)
    }

    @Test
    fun testGetAllEquipmentPacks() {
        // arrange
        val allGoods = itemDao.getAllGoods()

        // act
        val equipmentPacks = itemDao.getAllEquipmentPacks(allGoods)

        // assert
        assertThat(equipmentPacks).hasSize(7)
        assertThat(equipmentPacks[0].itemGroups).hasSize(14)
    }

    @Test
    fun testGetWeaponsOfBelvador() {
        // arrange
        val character = Character()
        character.id = 0
        val allWeaponTypes = itemDao.getAllWeaponFamilies()

        // act
        val weapons = characterDao.getWeapons(character, itemDao.getAllWeapons(allWeaponTypes))

        // assert
        assertThat(weapons).hasSize(3)
        assertItem(weapons[0], "Quarterstaff", "A quarterstaff is a double weapon.", 1)
        assertItem(weapons[1], "Crossbow, light", "You draw a light crossbow back by pulling a lever.", 1)
        assertItem(weapons[2], "Bolts, crossbow (10)",
                "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a wooden case that holds 10 bolts (or 5, for a repeating crossbow). A bolt that hits its target is destroyed, one that misses has a 50% chance of being destroyed or lost.",
                2)
    }

    @Test
    fun testGetArmorOfBelvador() {
        // arrange
        val character = Character()
        character.id = 0

        // act
        val armor = characterDao.getArmor(character, itemDao.getAllArmor())

        // assert
        assertThat(armor).isEmpty()
    }

    @Test
    fun testGetGoodsOfBelvador() {
        // arrange
        val character = Character()
        character.id = 0

        // act
        val goods = characterDao.getGoods(character, itemDao.getAllGoods())

        // assert
        assertThat(goods).hasSize(19)
        assertItem(goods[0], "Backpack", "A backpack is a leather pack carried on the back, typically with straps to secure it.",
                1)
        assertItem(goods[1], "Waterskin", "A waterskin is a leather pouch with a narrow neck that is used for holding water.", 1)
        assertItem(goods[2], "Trail Rations (per Day)",
                "Trail rations are compact, dry, high-energy foods suitable for travel, such as jerky, dried fruit, hardtack, and nuts.",
                10)
    }

    private fun assertItem(itemGroup: ItemGroup, name: String, description: String, number: Int) {
        assertThat(itemGroup.item.name).isEqualTo(name)
        assertThat(itemGroup.item.description).startsWith(description)
        assertThat(itemGroup.number).isEqualTo(number)
    }

    @Test
    fun testCreateWeapon() {
        // arrange
        var weapon = createWeapon()

        // act
        weapon = itemDao.createWeapon(weapon)

        // assert
        assertThat(weapon).isNotNull
        assertThat(weapon.id).isGreaterThan(0)

        // tear down
        itemDao.deleteWeapon(weapon)
    }

    private fun createWeapon(): Weapon {
        val weapon = Weapon()
        weapon.name = "testName"
        weapon.weaponType = WeaponType.SIMPLE
        weapon.weight = 10.0f
        weapon.cost = 100.0f
        weapon.qualityType = QualityType.NORMAL
        weapon.damage = Damage(1, Die.D8)
        weapon.critical = Critical(20, 2)
        weapon.description = "testDescription"
        weapon.combatType = CombatType.MELEE_WEAPON
        weapon.weaponEncumbrance = WeaponEncumbrance.ONE_HANDED
        weapon.weaponCategory = WeaponCategory.NORMAL_WEAPON
        val weaponFamily = WeaponFamily()
        weaponFamily.id = 1
        weaponFamily.name = "testWeaponType"
        weapon.weaponFamily = weaponFamily
        return weapon
    }

    @Test
    fun testUpdateWeapon() {
        // arrange
        val allWeaponTypes = itemDao.getAllWeaponFamilies()
        var weapon = itemDao.getAllWeapons(allWeaponTypes)[0]
        val backup = backupWeapon(weapon)
        val weaponId = weapon.id
        weapon.name = "testUpdate"
        weapon.weaponType = WeaponType.EXOTIC
        weapon.cost = 10.0f
        weapon.weight = 100.0f
        weapon.qualityType = QualityType.NORMAL
        weapon.damage = Damage(1, Die.D10)
        weapon.critical = Critical(20, 2)
        weapon.description = "testUpdateDescription"
        weapon.combatType = CombatType.MELEE_WEAPON
        weapon.weaponEncumbrance = WeaponEncumbrance.ONE_HANDED
        weapon.weaponCategory = WeaponCategory.NORMAL_WEAPON
        val weaponFamily = WeaponFamily()
        weaponFamily.id = 1
        weaponFamily.name = "testWeaponFamily"
        weapon.weaponFamily = weaponFamily

        // act
        itemDao.updateWeapon(weapon)

        // assert
        weapon = getItemById(weaponId, itemDao.getAllWeapons(allWeaponTypes)) as Weapon
        assertWeaponUpdate(weapon)

        // tear down
        itemDao.updateWeapon(backup)
    }

    private fun backupWeapon(weapon: Weapon): Weapon {
        val backup = Weapon()
        backup.id = weapon.id
        backup.name = weapon.name
        backup.weaponType = weapon.weaponType
        backup.cost = weapon.cost
        backup.weight = weapon.weight
        backup.qualityType = weapon.qualityType
        backup.damage = weapon.damage
        backup.critical = weapon.critical
        backup.description = weapon.description
        backup.combatType = weapon.combatType
        backup.weaponEncumbrance = weapon.weaponEncumbrance
        backup.weaponCategory = weapon.weaponCategory
        backup.weaponFamily = weapon.weaponFamily
        return backup
    }

    private fun getItemById(itemId: Int, allItems: List<Item>): Item? {
        for (item in allItems) {
            if (itemId == item.id) {
                return item
            }
        }
        return null
    }

    private fun assertWeaponUpdate(weapon: Weapon) {
        assertThat(weapon).isNotNull
        assertThat(weapon.name).isEqualTo("testUpdate")
        assertThat(weapon.weaponType).isEqualTo(WeaponType.EXOTIC)
        assertThat(weapon.cost).isEqualTo(10.0f)
        assertThat(weapon.weight).isEqualTo(100.0f)
        assertThat(weapon.isMagic).isFalse
        assertThat(weapon.damage.numberOfDice).isEqualTo(1)
        assertThat(weapon.damage.die).isEqualTo(Die.D10)
        assertThat(weapon.enhancementBonus).isEqualTo(0)
        assertThat(weapon.critical.hit).isEqualTo(20)
        assertThat(weapon.critical.multiplier).isEqualTo(2)
        assertThat(weapon.description).isEqualTo("testUpdateDescription")
    }

    @Test
    fun testCreateArmor() {
        // arrange
        var armor = createArmor()

        // act
        armor = itemDao.createArmor(armor)

        // assert
        assertThat(armor).isNotNull
        assertThat(armor.id).isGreaterThan(0)

        // tear down
        itemDao.deleteArmor(armor)
    }

    private fun createArmor(): Armor {
        val armor = Armor()
        armor.name = "testName"
        armor.armorType = ArmorType.LIGHT
        armor.cost = 10.0f
        armor.weight = 100.0f
        armor.qualityType = QualityType.NORMAL
        armor.armorBonus = 1
        armor.armorCheckPenalty = -1
        armor.description = "testDescription"
        return armor
    }

    @Test
    fun testUpdateArmor() {
        // arrange
        var armor = itemDao.getAllArmor()[0]
        val backup = backupArmor(armor)
        val armorId = armor.id
        armor.name = "testUpdate"
        armor.armorType = ArmorType.LIGHT
        armor.cost = 10.0f
        armor.weight = 100.0f
        armor.qualityType = QualityType.NORMAL
        armor.armorBonus = 1
        armor.armorCheckPenalty = -1
        armor.description = "testUpdateDescription"

        // act
        itemDao.updateArmor(armor)

        // assert
        armor = getItemById(armorId, itemDao.getAllArmor()) as Armor
        assertArmorUpdate(armor)

        // tear down
        itemDao.updateArmor(backup)
    }

    private fun backupArmor(armor: Armor): Armor {
        val backup = Armor()
        backup.id = armor.id
        backup.name = armor.name
        backup.armorType = armor.armorType
        backup.cost = armor.cost
        backup.weight = armor.weight
        backup.qualityType = armor.qualityType
        backup.armorBonus = armor.armorBonus
        backup.armorCheckPenalty = armor.armorCheckPenalty
        backup.description = armor.description
        return backup
    }

    private fun assertArmorUpdate(armor: Armor) {
        assertThat(armor).isNotNull
        assertThat(armor.name).isEqualTo("testUpdate")
        assertThat(armor.armorType).isEqualTo(ArmorType.LIGHT)
        assertThat(armor.cost).isEqualTo(10.0f)
        assertThat(armor.weight).isEqualTo(100.0f)
        assertThat(armor.isMagic).isFalse
        assertThat(armor.armorBonus).isEqualTo(1)
        assertThat(armor.armorCheckPenalty).isEqualTo(-1)
        assertThat(armor.description).isEqualTo("testUpdateDescription")
    }

    @Test
    fun testCreateGood() {
        // arrange
        var good = createGood()

        // act
        good = itemDao.createGood(good)

        // assert
        assertThat(good).isNotNull
        assertThat(good.id).isGreaterThan(0)

        // tear down
        itemDao.deleteGood(good)
    }

    private fun createGood(): Good {
        val good = Good()
        good.name = "testName"
        good.goodType = GoodType.ADVENTURING_GEAR
        good.weight = 10.0f
        good.cost = 100.0f
        good.qualityType = QualityType.NORMAL
        good.description = "testDescription"
        return good
    }

    @Test
    fun testUpdateGood() {
        // arrange
        var good = itemDao.getAllGoods()[0]
        val backup = backupGood(good)
        val goodId = good.id
        good.name = "testUpdate"
        good.goodType = GoodType.CLOTHING
        good.cost = 10.0f
        good.weight = 100.0f
        good.qualityType = QualityType.NORMAL
        good.description = "testUpdateDescription"

        // act
        itemDao.updateGood(good)

        // assert
        good = getItemById(goodId, itemDao.getAllGoods()) as Good
        assertGoodUpdate(good)

        // tear down
        itemDao.updateGood(backup)
    }

    private fun backupGood(good: Good): Good {
        val backup = Good()
        backup.id = good.id
        backup.name = good.name
        backup.goodType = good.goodType
        backup.cost = good.cost
        backup.weight = good.weight
        backup.qualityType = good.qualityType
        backup.description = good.description
        return backup
    }

    private fun assertGoodUpdate(good: Good) {
        assertThat(good).isNotNull
        assertThat(good.name).isEqualTo("testUpdate")
        assertThat(good.goodType).isEqualTo(GoodType.CLOTHING)
        assertThat(good.cost).isEqualTo(10.0f)
        assertThat(good.weight).isEqualTo(100.0f)
        assertThat(good.isMagic).isFalse
        assertThat(good.description).isEqualTo("testUpdateDescription")
    }
}