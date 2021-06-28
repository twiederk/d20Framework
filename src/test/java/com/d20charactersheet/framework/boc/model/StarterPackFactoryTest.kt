package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

class StarterPackFactoryTest {

    private val itemService: ItemService = mock()

    private val allWeapons: List<Weapon> = mock()
    private val allArmor: List<Armor> = mock()
    private val allGoods: List<Good> = mock()
    private val allPacks: List<EquipmentPack> = mock()

    private val starterPackData = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks)

    @Test
    fun createStarterPackOptions_oneQueryForWeapon_oneOptionWithOneWeapon() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                typeId = -1,
                combatId = -1,
                itemId = 3,
                quantity = 4
            )
        )
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { id = 3; name = "myWeapon" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myWeapon (4)")
    }

    @Test
    fun createStarterPackOptions_oneQueryForArmor_oneOptionWithOneArmor() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.ARMOR,
                typeId = -1,
                combatId = -1,
                itemId = 3,
                quantity = 4
            )
        )
        whenever(itemService.getItemById(3, allArmor)) doReturn Weapon().apply { id = 3; name = "myArmor" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myArmor (4)")
    }

    @Test
    fun createStarterPackOptions_oneQueryForGood_oneOptionWithOneGood() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.GOOD,
                typeId = -1,
                combatId = -1,
                itemId = 3,
                quantity = 4
            )
        )
        whenever(itemService.getItemById(3, allGoods)) doReturn Weapon().apply { id = 3; name = "myGood" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myGood (4)")
    }

    @Test
    fun createStarterPackOptions_oneQueryForEquipmentPack_oneOptionWithEquipementPack() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.PACK,
                typeId = -1,
                combatId = -1,
                itemId = 3,
                quantity = 1
            )
        )
        whenever(itemService.getEquipmentPackById(3, allPacks)) doReturn EquipmentPack(3, "myPack")

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myPack")
    }

    @Test
    fun createStarterPackOptions_twoQueriesForOneOption_oneOptionWithTwoItemGroups() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                typeId = -1,
                combatId = -1,
                itemId = 3,
                quantity = 1
            ),
            StarterPackQuery(
                id = 2,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                typeId = -1,
                combatId = -1,
                itemId = 4,
                quantity = 1
            )
        )
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { id = 3; name = "myFirstWeapon" }
        whenever(itemService.getItemById(4, allWeapons)) doReturn Weapon().apply { id = 4; name = "mySecondWeapon" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myFirstWeapon, mySecondWeapon")
    }

    @Test
    fun createStarterPackOptions_oneQueriesForManyWeapons_oneQptionForEachWeapon() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                typeId = 1,
                combatId = -1,
                itemId = -1,
                quantity = 1
            )
        )
        whenever(itemService.filterWeaponsByType(WeaponType.MARTIAL, allWeapons)) doReturn listOf(
            Weapon().apply { name = "firstWeapon" },
            Weapon().apply { name = "secondWeapon" },
            Weapon().apply { name = "thirdWeapon" }
        )

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(3)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("firstWeapon")
        assertThat((starterPackOptions[1]).getTitle()).isEqualTo("secondWeapon")
        assertThat((starterPackOptions[2]).getTitle()).isEqualTo("thirdWeapon")
        verify(itemService, never()).filterWeaponsByCombat(any(), any())
    }

    @Test
    fun createStarterPackOptions_oneQueriesForManyMeleeWeapons_oneQptionForEachWeapon() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                typeId = 1,
                combatId = 0,
                itemId = -1,
                quantity = 1
            )
        )
        whenever(itemService.filterWeaponsByType(WeaponType.MARTIAL, allWeapons)) doReturn listOf(
            Weapon().apply { name = "firstWeapon" },
            Weapon().apply { name = "secondWeapon" },
            Weapon().apply { name = "thirdWeapon" }
        )
        whenever(itemService.filterWeaponsByCombat(eq(CombatType.MELEE_WEAPON), any())) doReturn listOf(
            Weapon().apply { name = "firstWeapon" },
            Weapon().apply { name = "secondWeapon" },
        )

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(2)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("firstWeapon")
        assertThat((starterPackOptions[1]).getTitle()).isEqualTo("secondWeapon")
    }

    @Test
    fun createStarterPackOptions_oneQueriesForManyArmor_oneQptionForEachArmor() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.ARMOR,
                typeId = 3,
                combatId = -1,
                itemId = -1,
                quantity = 1
            )

        )
        whenever(itemService.filterArmorByType(ArmorType.SHIELD, allArmor)) doReturn listOf(
            Armor().apply { name = "Light Wooden Shield" },
            Armor().apply { name = "Light Steel Shield" },
            Armor().apply { name = "Tower Shield" }
        )

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(3)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("Light Wooden Shield")
        assertThat(starterPackOptions[1].getTitle()).isEqualTo("Light Steel Shield")
        assertThat(starterPackOptions[2].getTitle()).isEqualTo("Tower Shield")
    }

    @Test
    fun createStarterPackOptions_oneQueriesForManyGoods_oneQptionForEachGood() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.GOOD,
                typeId = 0,
                combatId = -1,
                itemId = -1,
                quantity = 1
            )

        )
        whenever(itemService.filterGoodsByType(GoodType.ADVENTURING_GEAR, allGoods)) doReturn listOf(
            Good().apply { name = "Backpack" },
            Good().apply { name = "Bedroll" },
            Good().apply { name = "Candle" }
        )

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, starterPackData)

        // assert
        assertThat(starterPackOptions).hasSize(3)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("Backpack")
        assertThat(starterPackOptions[1].getTitle()).isEqualTo("Bedroll")
        assertThat(starterPackOptions[2].getTitle()).isEqualTo("Candle")
    }

}