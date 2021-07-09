package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.boc.service.ItemService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*


class StarterPackHelperTest {

    @Test
    fun getStarterBoxOptions_emptyListOfStarterBoxQueries_emptyListOfStarterPackOptions() {

        // act
        val starterBoxOptions = StarterPackHelper(mock(), mock(), mock(), mock()).getStarterBoxOptions(listOf())

        // assert
        assertThat(starterBoxOptions).isEmpty()
    }

    @Test
    fun getStarterBoxOptions_singleItem_singleOptionWithOneItem() {
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
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(eq(3), any())) doReturn Armor().apply { name = "myArmor" }

        // act
        val starterBoxOptions = StarterPackHelper(itemService, mock(), mock(), mock()).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterBoxOptions).hasSize(1)
        assertThat(starterBoxOptions[0].getTitle()).isEqualTo("myArmor (4)")
    }

    @Test
    fun createStarterBoxOption_singleArmor_oneItemGroup() {
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
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(eq(3), any())) doReturn Armor().apply { name = "myArmor" }

        // act
        val starterPackOption = StarterPackHelper(itemService, mock(), mock(), mock()).createStarterPackOption(starterPackQueries)

        // assert
        assertThat(starterPackOption.getTitle()).isEqualTo("myArmor (4)")
    }

    @Test
    fun executeStarterPackQuery_oneWeapon_oneItemGroupWithWeapon() {
        // arrange
        val itemService: ItemService = mock()
        val allWeapons: List<Weapon> = mock()
        val starterPackQuery = StarterPackQuery(
            id = 1,
            optionId = 2,
            equipmentType = EquipmentType.WEAPON,
            itemId = 4,
            quantity = 5
        )
        whenever(itemService.getItemById(4, allWeapons)) doReturn Weapon().apply { id = 4 }

        // act
        val itemGroups: List<ItemGroup> =
            StarterPackHelper(itemService, allWeapons, mock(), mock()).executeStarterPackQuery(starterPackQuery)

        // assert
        assertThat(itemGroups).hasSize(1)
        assertThat(itemGroups[0].item).isEqualTo(Weapon().apply { id = 4 })
        assertThat(itemGroups[0].number).isEqualTo(5)
    }

    @Test
    fun executeStarterPackQuery_oneArmor_oneItemGroupWithOneArmor() {
        // arrange
        val itemService: ItemService = mock()
        val allArmor: List<Armor> = mock()
        val starterPackQuery = StarterPackQuery(
            id = 1,
            optionId = 2,
            equipmentType = EquipmentType.ARMOR,
            itemId = 4,
            quantity = 5
        )
        whenever(itemService.getItemById(4, allArmor)) doReturn Armor().apply { id = 4 }

        // act
        val itemGroups: List<ItemGroup> =
            StarterPackHelper(itemService, mock(), allArmor, mock()).executeStarterPackQuery(starterPackQuery)

        // assert
        assertThat(itemGroups).hasSize(1)
        assertThat(itemGroups[0].item).isEqualTo(Armor().apply { id = 4 })
        assertThat(itemGroups[0].number).isEqualTo(5)
    }

    @Test
    fun executeStarterPackQuery_oneGood_oneItemGroupWithOneGood() {
        // arrange
        val itemService: ItemService = mock()
        val allGoods: List<Good> = mock()
        val starterPackQuery = StarterPackQuery(
            id = 1,
            optionId = 2,
            equipmentType = EquipmentType.GOOD,
            itemId = 4,
            quantity = 5
        )
        whenever(itemService.getItemById(4, allGoods)) doReturn Good().apply { id = 4 }

        // act
        val itemGroups: List<ItemGroup> =
            StarterPackHelper(itemService, mock(), mock(), allGoods).executeStarterPackQuery(starterPackQuery)

        // assert
        assertThat(itemGroups).hasSize(1)
        assertThat(itemGroups[0].item).isEqualTo(Good().apply { id = 4 })
        assertThat(itemGroups[0].number).isEqualTo(5)
    }

}