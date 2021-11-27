package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.SqlItemDao
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ItemServiceTest {

    private lateinit var itemService: ItemService

    @BeforeEach
    fun setUp() {
        val jdbcHelper = JdbcHelper()
        jdbcHelper.executeSqlScript("/sql/create_database.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_character.sql")
        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)
        itemService = ItemServiceImpl(SqlItemDao(jdbcDatabase))
    }

    @Test
    fun testGetAllWeapons() {
        // arrange
        val allWeaponTypes = itemService.allWeaponFamilies

        // act
        val allWeapons = itemService.getAllWeapons(allWeaponTypes)

        // assert
        assertThat(allWeapons).hasSize(110)
        val gauntlet = allWeapons[0]
        assertThat(gauntlet.id).isEqualTo(0)
        assertThat(gauntlet.name).isEqualTo("Gauntlet")
        assertThat(gauntlet.cost).isEqualTo(2.0f)
        assertThat(gauntlet.weight).isEqualTo(1.0f)

        val damage = gauntlet.damage
        assertThat(damage.numberOfDice).isEqualTo(1)
        assertThat(damage.die).isEqualTo(Die.D3)
        assertThat(gauntlet.enhancementBonus).isEqualTo(0)

        val critical = gauntlet.critical
        assertThat(critical.hit).isEqualTo(20)
        assertThat(critical.multiplier).isEqualTo(2)
        assertThat(gauntlet.weaponType).isEqualTo(WeaponType.SIMPLE)
    }

    @Test
    fun testGetAllArmors() {
        // act
        val allArmors = itemService.allArmor

        // assert
        assertThat(allArmors).hasSize(38)
        val padded = allArmors[0]
        assertThat(padded.id).isEqualTo(0)
        assertThat(padded.name).isEqualTo("Padded")
        assertThat(padded.weight).isEqualTo(10.0f)
        assertThat(padded.cost).isEqualTo(5.0f)
        assertThat(padded.armorBonus).isEqualTo(1)
        assertThat(padded.armorCheckPenalty).isEqualTo(0)
        assertThat(padded.armorType).isEqualTo(ArmorType.LIGHT)
    }

    @Test
    fun testGetAllGoods() {
        // act
        val allGoods = itemService.allGoods

        // assert
        assertThat(allGoods).hasSize(131)
        val barrel = allGoods[1]
        assertThat(barrel.id).isEqualTo(1)
        assertThat(barrel.name).isEqualTo("Barrel")
        assertThat(barrel.cost).isEqualTo(2.0f)
        assertThat(barrel.weight).isEqualTo(30.0f)
        assertThat(barrel.goodType).isEqualTo(GoodType.ADVENTURING_GEAR)
    }

    @Test
    fun testCreateWeapon() {
        // arrange
        val allWeaponFamilies = itemService.allWeaponFamilies
        val numberOfWeapons = itemService.getAllWeapons(allWeaponFamilies).size
        var weapon = Weapon()
        weapon.name = "testName"
        weapon.weaponType = WeaponType.SIMPLE
        weapon.cost = 10.0f
        weapon.weight = 100.0f
        weapon.qualityType = QualityType.NORMAL
        weapon.damage = Damage(1, Die.D8)
        weapon.critical = Critical(20, 2)
        weapon.description = "testDescription"
        weapon.combatType = CombatType.MELEE_WEAPON
        weapon.weaponEncumbrance = WeaponEncumbrance.ONE_HANDED
        weapon.weaponCategory = WeaponCategory.NORMAL_WEAPON
        weapon.weaponFamily = allWeaponFamilies[0]
        weapon.rangeIncrement = 10

        // act
        weapon = itemService.createWeapon(weapon)

        // assert
        assertThat(weapon.id).isGreaterThan(0)
        val allWeapons = itemService.getAllWeapons(allWeaponFamilies)
        assertThat(allWeapons).hasSize(numberOfWeapons + 1)
        weapon = getItem(allWeapons) as Weapon
        assertThat(weapon).isNotNull
        assertWeapon(weapon)
    }

    private fun assertWeapon(weapon: Weapon) {
        val damage = weapon.damage
        val critical = weapon.critical
        assertThat(weapon.name).isEqualTo("testName")
        assertThat(weapon.weaponType).isEqualTo(WeaponType.SIMPLE)
        assertThat(weapon.cost).isEqualTo(10.0f)
        assertThat(weapon.weight).isEqualTo(100.0f)
        assertThat(weapon.isMagic).isFalse
        assertThat(damage.numberOfDice).isEqualTo(1)
        assertThat(damage.die).isEqualTo(Die.D8)
        assertThat(weapon.enhancementBonus).isEqualTo(0)
        assertThat(critical.hit).isEqualTo(20)
        assertThat(critical.multiplier).isEqualTo(2)
        assertThat(weapon.description).isEqualTo("testDescription")
        assertThat(weapon.rangeIncrement).isEqualTo(10)
    }

    private fun getItem(allItems: List<Item>): Item? {
        for (item in allItems) {
            if ("testName" == item.name) {
                return item
            }
        }
        return null
    }

    @Test
    fun testUpdateWeapon() {
        // arrange
        val allWeaponTypes = itemService.allWeaponFamilies
        var weapon = itemService.getAllWeapons(allWeaponTypes)[0]
        val weaponId = weapon!!.id
        weapon.name = "testUpdate"
        weapon.weaponType = WeaponType.EXOTIC
        weapon.cost = 10.0f
        weapon.weight = 100.0f
        weapon.qualityType = QualityType.NORMAL
        weapon.damage = Damage(1, Die.D10)
        weapon.critical = Critical(20, 2)
        weapon.description = "testUpdateDescription"

        // act
        itemService.updateWeapon(weapon)

        // assert
        weapon = getItemById(weaponId, itemService.getAllWeapons(allWeaponTypes)) as Weapon?
        assertItemUpdate(weapon)
    }

    private fun getItemById(itemId: Int, allItems: List<Item>): Item? {
        for (item in allItems) {
            if (itemId == item.id) {
                return item
            }
        }
        return null
    }

    private fun assertItemUpdate(item: Item) {
        assertThat(item).isNotNull
        assertThat(item.name).isEqualTo("testUpdate")
        assertThat(item.description).isEqualTo("testUpdateDescription")
    }

    @Test
    fun testCheckCritical() {
        // arrange
        val zeroHitCritical = Critical(0, 0)
        val oneHitCritical = Critical(1, 0)
        val tweentyHitCritical = Critical(20, 0)
        val itemServiceImpl = itemService as ItemServiceImpl

        // act
        itemServiceImpl.checkCritical(oneHitCritical)
        itemServiceImpl.checkCritical(tweentyHitCritical)
        itemServiceImpl.checkCritical(zeroHitCritical)
    }

    @Test
    fun testCheckCritical_negativeHitCritical() {
        // arrange
        val itemServiceImpl = itemService as ItemServiceImpl
        val negativeHitCritical = Critical(-1, 0)

        // act
        val exception = catchThrowable { itemServiceImpl.checkCritical(negativeHitCritical) }

        // assert
        assertThat(exception).isInstanceOf(RuleException::class.java)
    }

    @Test
    fun testCheckCritical_above20HitCritical() {
        // arrange
        val itemServiceImpl = itemService as ItemServiceImpl
        val above20HitCritical = Critical(21, 0)

        // act
        val exception = catchThrowable { itemServiceImpl.checkCritical(above20HitCritical) }

        // assert
        assertThat(exception).isInstanceOf(RuleException::class.java)
    }

    @Test
    fun testCreateArmor() {
        // arrange
        val numberOfArmor = itemService.allArmor.size
        var armor = Armor()
        armor.name = "testName"
        armor.armorType = ArmorType.LIGHT
        armor.cost = 10.0f
        armor.weight = 100.0f
        armor.qualityType = QualityType.NORMAL
        armor.armorBonus = 1
        armor.armorCheckPenalty = -1
        armor.description = "testDescription"

        // act
        armor = itemService.createArmor(armor)

        // assert
        assertThat(armor).isNotNull
        assertThat(armor.id).isGreaterThan(0)
        val allArmors = itemService.allArmor
        assertThat(allArmors).hasSize(numberOfArmor + 1)
        armor = getItem(allArmors) as Armor
        assertThat(armor).isNotNull
        assertArmor(armor)
    }

    private fun assertArmor(armor: Armor) {
        assertThat(armor.name).isEqualTo("testName")
        assertThat(armor.armorType).isEqualTo(ArmorType.LIGHT)
        assertThat(armor.cost).isEqualTo(10.0f)
        assertThat(armor.weight).isEqualTo(100.0f)
        assertThat(armor.isMagic).isFalse
        assertThat(armor.armorBonus).isEqualTo(1)
        assertThat(armor.armorCheckPenalty).isEqualTo(-1)
        assertThat(armor.description).isEqualTo("testDescription")
    }

    @Test
    fun testUpdateArmor() {
        // arrange
        var armor = itemService.allArmor[0]
        val armorId = armor!!.id
        armor.name = "testUpdate"
        armor.armorType = ArmorType.LIGHT
        armor.cost = 10.0f
        armor.weight = 100.0f
        armor.qualityType = QualityType.NORMAL
        armor.armorBonus = 1
        armor.armorCheckPenalty = -1
        armor.description = "testUpdateDescription"

        // act
        itemService.updateArmor(armor)

        // assert
        armor = getItemById(armorId, itemService.allArmor) as Armor?
        assertItemUpdate(armor)
    }

    @Test
    fun testCreateGood() {
        // arrange
        val numberOfGoods = itemService.allGoods.size
        var good = Good()
        good.name = "testName"
        good.goodType = GoodType.ADVENTURING_GEAR
        good.cost = 10.0f
        good.weight = 100.0f
        good.qualityType = QualityType.NORMAL
        good.description = "testDescription"

        // act
        good = itemService.createGood(good)

        // assert
        assertThat(good.id).isGreaterThan(0)
        val allGoods = itemService.allGoods
        assertThat(allGoods).hasSize(numberOfGoods + 1)
        good = getItem(allGoods) as Good
        assertThat(good).isNotNull
        assertGood(good)
    }

    private fun assertGood(good: Good) {
        assertThat(good.name).isEqualTo("testName")
        assertThat(good.goodType).isEqualTo(GoodType.ADVENTURING_GEAR)
        assertThat(good.cost).isEqualTo(10.0f)
        assertThat(good.weight).isEqualTo(100.0f)
        assertThat(good.isMagic).isFalse
        assertThat(good.description).isEqualTo("testDescription")
    }

    @Test
    fun testUpdateGood() {
        // arrange
        var good = itemService.allGoods[0]
        val goodId = good!!.id
        good.name = "testUpdate"
        good.goodType = GoodType.SPECIAL_ITEM
        good.cost = 10.0f
        good.weight = 100.0f
        good.qualityType = QualityType.NORMAL
        good.description = "testUpdateDescription"

        // act
        itemService.updateGood(good)

        // assert
        good = getItemById(goodId, itemService.allGoods) as Good?
        assertItemUpdate(good)
    }

    @Test
    fun testGetEquipableWeapons() {
        // arrange
        val allWeaponTypes = itemService.allWeaponFamilies
        val allWeapons = itemService.getAllWeapons(allWeaponTypes)

        // act
        val equipableWeapons = itemService.getEquipableWeapons(allWeapons)

        // assert
        assertThat(equipableWeapons).hasSize(104)
    }

    @Test
    fun testGetAllEquipmentPacks() {
        // arrange
        val allGoods = itemService.allGoods

        // act
        val allPacks = itemService.getAllEquipmentPacks(allGoods)

        // assert
        assertThat(allPacks).hasSize(7)
    }

    @Test
    fun filterWeaponsByType_simple_returnAllSimpleAndNormalWeapons() {
        // arrange
        val allWeapons: List<Weapon> = listOf(
            Weapon().apply { weaponType = WeaponType.SIMPLE; qualityType = QualityType.NORMAL; weight = 1F },
            Weapon().apply { weaponType = WeaponType.SIMPLE; qualityType = QualityType.MASTERWORK; weight = 1F },
            Weapon().apply { weaponType = WeaponType.SIMPLE; qualityType = QualityType.MAGIC; weight = 1F },
            Weapon().apply { weaponType = WeaponType.SIMPLE; qualityType = QualityType.NORMAL; weight = 0F },
            Weapon().apply { weaponType = WeaponType.MARTIAL; weight = 1F },
            Weapon().apply { weaponType = WeaponType.EXOTIC; weight = 1F },
            Weapon().apply { weaponType = WeaponType.AMMO; weight = 1F }
        )

        // act
        val weapons = itemService.filterWeaponsByType(WeaponType.SIMPLE, allWeapons)

        // assert
        assertThat(weapons.map { it.weaponType }).containsOnly(WeaponType.SIMPLE)
        assertThat(weapons.map { it.qualityType }).containsOnly(QualityType.NORMAL)
        assertThat(weapons).allMatch { weapon -> weapon.weight > 0 }
    }

    @Test
    fun filterWeaponsByCombat_melee_returnMeleeWeapons() {
        val allWeapons: List<Weapon> = listOf(
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.NORMAL; weight = 1F },
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.NORMAL; weight = 0F },
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.MASTERWORK; weight = 1F },
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.MAGIC; weight = 1F },
            Weapon().apply { combatType = CombatType.RANGED_WEAPON; qualityType = QualityType.NORMAL; weight = 1F },
            Weapon().apply { combatType = CombatType.RANGED_WEAPON; qualityType = QualityType.MASTERWORK; weight = 1F },
            Weapon().apply { combatType = CombatType.RANGED_WEAPON; qualityType = QualityType.MAGIC; weight = 1F }
        )

        // act
        val weapons = itemService.filterWeaponsByCombat(CombatType.MELEE_WEAPON, allWeapons)

        // assert
        assertThat(weapons.map { it.combatType }).containsOnly(CombatType.MELEE_WEAPON)
        assertThat(weapons.map { it.qualityType }).containsOnly(QualityType.NORMAL)
        assertThat(weapons).allMatch { weapon -> weapon.weight > 0 }
    }

    @Test
    fun filterWeaponsByCombat_ranged_returnRangedWeapons() {
        val allWeapons: List<Weapon> = listOf(
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.NORMAL; weight = 1F },
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.NORMAL; weight = 0F },
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.MASTERWORK; weight = 1F },
            Weapon().apply { combatType = CombatType.MELEE_WEAPON; qualityType = QualityType.MAGIC; weight = 1F },
            Weapon().apply { combatType = CombatType.RANGED_WEAPON; qualityType = QualityType.NORMAL; weight = 1F },
            Weapon().apply { combatType = CombatType.RANGED_WEAPON; qualityType = QualityType.MASTERWORK; weight = 1F },
            Weapon().apply { combatType = CombatType.RANGED_WEAPON; qualityType = QualityType.MAGIC; weight = 1F }
        )

        // act
        val weapons = itemService.filterWeaponsByCombat(CombatType.RANGED_WEAPON, allWeapons)

        // assert
        assertThat(weapons.map { it.combatType }).containsOnly(CombatType.RANGED_WEAPON)
        assertThat(weapons.map { it.qualityType }).containsOnly(QualityType.NORMAL)
        assertThat(weapons).allMatch { weapon -> weapon.weight > 0 }
    }

    @Test
    fun filterArmorByType_simple_returnAllLightArmor() {
        // arrange
        val allArmor: List<Armor> = listOf(
            Armor().apply { armorType = ArmorType.LIGHT; qualityType = QualityType.NORMAL },
            Armor().apply { armorType = ArmorType.LIGHT; qualityType = QualityType.MASTERWORK },
            Armor().apply { armorType = ArmorType.LIGHT; qualityType = QualityType.MAGIC },
            Armor().apply { armorType = ArmorType.MEDIUM },
            Armor().apply { armorType = ArmorType.HEAVY },
            Armor().apply { armorType = ArmorType.SHIELD }
        )

        // act
        val armor = itemService.filterArmorByType(ArmorType.LIGHT, allArmor)

        // assert
        assertThat(armor.map { it.armorType }).containsOnly(ArmorType.LIGHT)
        assertThat(armor.map { it.qualityType }).containsOnly(QualityType.NORMAL)
    }

    @Test
    fun filterGoodsByType_adventuringGear_returnAllAdventuringGearGoods() {
        // arrange
        val allGoods: List<Good> = listOf(
            Good().apply { goodType = GoodType.ADVENTURING_GEAR; qualityType = QualityType.NORMAL },
            Good().apply { goodType = GoodType.ADVENTURING_GEAR; qualityType = QualityType.MASTERWORK },
            Good().apply { goodType = GoodType.ADVENTURING_GEAR; qualityType = QualityType.MAGIC },
            Good().apply { goodType = GoodType.CLOTHING },
            Good().apply { goodType = GoodType.ENTERTAINMENT },
            Good().apply { goodType = GoodType.MOUNT },
            Good().apply { goodType = GoodType.MOUNT_GEAR },
            Good().apply { goodType = GoodType.SKILL_KIT },
            Good().apply { goodType = GoodType.SPECIAL_ITEM },
            Good().apply { goodType = GoodType.SPECIAL_SUBSTANCE },
            Good().apply { goodType = GoodType.TOOL_KIT },
        )

        // act
        val goods = itemService.filterGoodsByType(GoodType.ADVENTURING_GEAR, allGoods)

        // assert
        assertThat(goods.map { it.goodType }).containsOnly(GoodType.ADVENTURING_GEAR)
        assertThat(goods.map { it.qualityType }).containsOnly(QualityType.NORMAL)
    }

    @Test
    fun getEquipmentPackById_returnFilteredEquipmentPack() {

        // act
        val equipmentPack = itemService.getEquipmentPackById(1, itemService.getAllEquipmentPacks(itemService.allGoods))

        // assert
        assertThat(equipmentPack).isNotNull
        assertThat(equipmentPack.id).isEqualTo(1)
        assertThat(equipmentPack.name).isEqualTo("Burglar's Pack")
    }

}