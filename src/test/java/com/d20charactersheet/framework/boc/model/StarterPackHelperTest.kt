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

    private val starterPackData = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks)


    @Test
    fun getStarterBoxOptions_emptyListOfStarterBoxQueries_emptyListOfStarterPackOptions() {

        // act
        val starterBoxOptions = StarterPackHelper(starterPackData).getStarterBoxOptions(listOf())

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
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

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
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

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
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

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
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

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
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

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
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(2)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("myFirstWeapon")
        assertThat(starterPackOptions[1].getTitle()).isEqualTo("mySecondWeapon")
    }

    @Test
    fun getStarterBoxOptions_manyWeaponsForOneQuery_oneOptionForEachWeapon() {
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
            Weapon().apply { name = "Longsword" },
            Weapon().apply { name = "Battleaxe" },
            Weapon().apply { name = "Bastardsword" },
            Weapon().apply { name = "Two-Handed sword" },
            Weapon().apply { name = "Helberd" }
        )

        // act
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(5)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("Longsword")
        assertThat(starterPackOptions[1].getTitle()).isEqualTo("Battleaxe")
        assertThat(starterPackOptions[2].getTitle()).isEqualTo("Bastardsword")
        assertThat(starterPackOptions[3].getTitle()).isEqualTo("Two-Handed sword")
        assertThat(starterPackOptions[4].getTitle()).isEqualTo("Helberd")
    }

    @Test
    fun getStarterBoxOptions_manyArmorForOneQuery_oneOptionForEachArmor() {
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
        val starterPackOptions: List<StarterPackBoxOption> =
            StarterPackHelper(starterPackData).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterPackOptions).hasSize(3)
        assertThat(starterPackOptions[0].getTitle()).isEqualTo("Light Wooden Shield")
        assertThat(starterPackOptions[1].getTitle()).isEqualTo("Light Steel Shield")
        assertThat(starterPackOptions[2].getTitle()).isEqualTo("Tower Shield")
    }

}