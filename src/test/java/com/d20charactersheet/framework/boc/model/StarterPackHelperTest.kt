package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService
import com.d20charactersheet.framework.boc.service.StarterPackHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class StarterPackHelperTest {

    private val itemService: ItemService = mock()
    private val allWeapons: List<Weapon> = mock()
    private val allArmor: List<Armor> = mock()
    private val allGoods: List<Good> = mock()
    private val allPacks: List<EquipmentPack> = mock()


    @Test
    fun getStarterBoxOptions_emptyListOfStarterBoxQueries_emptyListOfStarterPackOptions() {

        // act
        val starterBoxOptions = StarterPackHelper(mock(), mock(), mock(), mock(), mock()).getStarterBoxOptions(listOf())

        // assert
        assertThat(starterBoxOptions).isEmpty()
    }

    @Test
    fun getStarterBoxOptions_oneWeapon_oneItemGroupWithWeapon() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.WEAPON,
                typeId = -1,
                combatId = -1,
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
                allArmor,
                allGoods,
                allPacks
            ).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myWeapon (5)")
    }

    @Test
    fun getStarterBoxOptions_oneArmor_oneItemGroupWithOneArmor() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.ARMOR,
                typeId = -1,
                combatId = -1,
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
                allArmor,
                allGoods,
                allPacks
            ).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myArmor (5)")

    }

    @Test
    fun getStarterBoxOptions_oneGood_oneItemGroupWithOneGood() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.GOOD,
                typeId = -1,
                combatId = -1,
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
                allArmor,
                allGoods,
                allPacks
            ).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myGood (5)")
    }

    @Test
    fun getStarterBoxOptions_onePack_oneItemGroupWithOneGood() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.PACK,
                typeId = -1,
                combatId = -1,
                itemId = 4,
                quantity = 1
            )
        )
        whenever(itemService.getEquipmentPackById(4, allPacks)) doReturn EquipmentPack(4, "myPack")

        // act
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                allArmor,
                allGoods,
                allPacks
            ).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myPack")
    }

    @Test
    fun getStarterBoxOptions_twoItemsForOneOptions_oneOptionWithOneItemEach() {
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
                id = 1,
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
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                allArmor,
                allGoods,
                allPacks
            ).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myFirstWeapon, mySecondWeapon")
    }

    @Test
    fun getStarterBoxOptions_twoItemsForTwoOptions_twoOptionsWithOneItemEach() {
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
                id = 1,
                optionId = 3,
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
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(
                itemService,
                allWeapons,
                allArmor,
                allGoods,
                allPacks
            ).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(2)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myFirstWeapon")
        assertThat(starterPackOptions[1].getTitle()).isEqualTo("mySecondWeapon")
    }

}