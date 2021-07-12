package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class StarterPackFactoryTest {

    private val itemService: ItemService = mock()

    private val allWeapons: List<Weapon> = mock()
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
                quantity = 1
            )
        )
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { id = 3; name = "myWeapon" }

        // act
        val starterPackOptions =
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allPacks)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myWeapon")
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
            StarterPackFactory().createStarterPackOptions(starterPackQueries, itemService, allWeapons, allPacks)

        // assert
        assertThat(starterPackOptions).hasSize(1)
        assertThat((starterPackOptions[0]).getTitle()).isEqualTo("myPack")
    }

}