package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService
import com.d20charactersheet.framework.boc.service.ItemServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class StarterPackDataTest {

    @Test
    fun getItemService_returnsItemService() {
        // arrange
        val itemService: ItemService = ItemServiceImpl(mock())
        val allWeapons: List<Weapon> = listOf()
        val allArmor: List<Armor> = listOf()
        val allGoods: List<Good> = listOf()
        val allPacks: List<EquipmentPack> = listOf()

        // act
        val result = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks).itemService

        // assert
        assertThat(result).isEqualTo(itemService)
    }

    @Test
    fun getItemService_allWeapons() {
        // arrange
        val itemService: ItemService = ItemServiceImpl(mock())
        val allWeapons: List<Weapon> = listOf()
        val allArmor: List<Armor> = listOf()
        val allGoods: List<Good> = listOf()
        val allPacks: List<EquipmentPack> = listOf()

        // act
        val result = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks).allWeapons

        // assert
        assertThat(result).isEqualTo(allWeapons)
    }

    @Test
    fun getItemService_allArmor() {
        // arrange
        val itemService: ItemService = ItemServiceImpl(mock())
        val allWeapons: List<Weapon> = listOf()
        val allArmor: List<Armor> = listOf()
        val allGoods: List<Good> = listOf()
        val allPacks: List<EquipmentPack> = listOf()

        // act
        val result = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks).allArmor

        // assert
        assertThat(result).isEqualTo(allArmor)
    }

    @Test
    fun getItemService_allGoods() {
        // arrange
        val itemService: ItemService = ItemServiceImpl(mock())
        val allWeapons: List<Weapon> = listOf()
        val allArmor: List<Armor> = listOf()
        val allGoods: List<Good> = listOf()
        val allPacks: List<EquipmentPack> = listOf()

        // act
        val result = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks).allGoods

        // assert
        assertThat(result).isEqualTo(allGoods)
    }

    @Test
    fun getItemService_allPacks() {
        // arrange
        val itemService: ItemService = ItemServiceImpl(mock())
        val allWeapons: List<Weapon> = listOf()
        val allArmor: List<Armor> = listOf()
        val allGoods: List<Good> = listOf()
        val allPacks: List<EquipmentPack> = listOf()

        // act
        val result = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks).allPacks

        // assert
        assertThat(result).isEqualTo(allPacks)
    }

}