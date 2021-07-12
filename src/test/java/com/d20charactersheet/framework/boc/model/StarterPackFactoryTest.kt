package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class StarterPackFactoryTest {

    private val itemService: ItemService = mock()

    private val allArmor: List<Armor> = mock()
    private val allWeapons: List<Weapon> = mock()
    private val allGoods: List<Good> = mock()
    private val allPacks: List<EquipmentPack> = mock()

    @Test
    fun createStarterPackOptions_oneQueryForWeapon_oneOptionWithOneWeapon() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                itemId = 3,
                quantity = 4
            )
        )
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { id = 3; name = "myWeapon" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allArmor, allGoods, allPacks)

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
                itemId = 3,
                quantity = 4
            )
        )
        whenever(itemService.getItemById(3, allArmor)) doReturn Weapon().apply { id = 3; name = "myArmor" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allArmor, allGoods, allPacks)

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
                itemId = 3,
                quantity = 4
            )
        )
        whenever(itemService.getItemById(3, allGoods)) doReturn Weapon().apply { id = 3; name = "myGood" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allArmor, allGoods, allPacks)

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
                itemId = 3,
                quantity = 1
            )
        )
        whenever(itemService.getEquipmentPackById(3, allPacks)) doReturn EquipmentPack(3, "myPack")

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allArmor, allGoods, allPacks)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myPack")
    }

    @Test
    fun createStarterPackOptions_twoQuerieForOneOption_oneOptionWithTwoItemGroups() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                itemId = 3,
                quantity = 1
            ),
            StarterPackQuery(
                id = 2,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                itemId = 4,
                quantity = 1
            )
        )
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { id = 3; name = "myFirstWeapon" }
        whenever(itemService.getItemById(4, allWeapons)) doReturn Weapon().apply { id = 4; name = "mySecondWeapon" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allArmor, allGoods, allPacks)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myFirstWeapon, mySecondWeapon")
    }

}