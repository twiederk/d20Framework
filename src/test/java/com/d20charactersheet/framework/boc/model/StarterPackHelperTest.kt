package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService
import com.d20charactersheet.framework.boc.service.StarterPackHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class StarterPackHelperTest {

    val itemService: ItemService = mock()
    val allWeapons: List<Weapon> = mock()
    val allArmor: List<Armor> = mock()
    val allGoods: List<Good> = mock()

    @Test
    fun createStarterBoxOptions_oneWeapon_oneItemGroupWithWeapon() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                itemId = 4,
                quantity = 5
            )
        )
        whenever(itemService.getItemById(4, allWeapons)) doReturn Weapon().apply { id = 4; name = "myWeapon" }

        // act
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                mock(),
                mock(),
                mock()
            ).createStarterBoxOptions(mapOf(1 to starterPackQueries))

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myWeapon (5)")
    }

    @Test
    fun createStarterBoxOptions_oneArmor_oneItemGroupWithOneArmor() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.ARMOR,
                itemId = 4,
                quantity = 5
            )
        )
        whenever(itemService.getItemById(4, allArmor)) doReturn Armor().apply { id = 4; name = "myArmor" }

        // act
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                mock(),
                mock(),
                mock()
            ).createStarterBoxOptions(mapOf(1 to starterPackQueries))

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myArmor (5)")

    }

    @Test
    fun createStarterBoxOptions_oneGood_oneItemGroupWithOneGood() {
        // arrange
        val itemService: ItemService = mock()
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.GOOD,
                itemId = 4,
                quantity = 5
            )
        )
        whenever(itemService.getItemById(4, allGoods)) doReturn Good().apply { id = 4; name = "myGood" }

        // act
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                mock(),
                mock(),
                mock()
            ).createStarterBoxOptions(mapOf(1 to starterPackQueries))

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myGood (5)")
    }

    @Test
    fun createStarterBoxOptions_onePack_oneItemGroupWithOneGood() {
        // arrange
        val itemService: ItemService = mock()
        val allEquipmentPacks: List<EquipmentPack> = mock()
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.PACK,
                itemId = 4,
                quantity = 1
            )
        )
        whenever(itemService.getEquipmentPackById(4, allEquipmentPacks)) doReturn EquipmentPack(4, "myPack")

        // act
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                mock(),
                mock(),
                mock()
            ).createStarterBoxOptions(mapOf(1 to starterPackQueries))

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myPack")
    }

    @Test
    fun getStarterBoxOptions_emptyListOfStarterBoxQueries_emptyListOfStarterPackOptions() {

        // act
        val starterBoxOptions = StarterPackHelper(mock(), mock(), mock(), mock(), mock()).getStarterBoxOptions(listOf())

        // assert
        assertThat(starterBoxOptions).isEmpty()
    }

}