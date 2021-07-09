package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.boc.service.ItemService

class StarterPackHelper(
    private val itemService: ItemService,
    private val allWeapons: List<Weapon>,
    private val allArmor: List<Armor>,
    private val allGoods: List<Good>
) {


    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        val groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>> = groupStarterPackQueries(starterPackQueries)
        return createStarterBoxOptions(groupedStarterPackQuieries)
    }

    private fun groupStarterPackQueries(starterPackQueries: List<StarterPackQuery>): Map<Int, List<StarterPackQuery>> {
        return starterPackQueries.groupBy { it.optionId }
    }


    private fun createStarterBoxOptions(groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>>): List<StarterPackBoxOption> {
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        for (starterPackQueries in groupedStarterPackQuieries.values) {
            val starterPackBoxOption = createStarterPackOption(starterPackQueries)
            starterPackOptions.add(starterPackBoxOption)
        }
        return starterPackOptions
    }

    fun createStarterPackOption(starterPackQueries: List<StarterPackQuery>): StarterPackBoxOption {
        val starterPackBoxOption = StarterPackBoxItemOption()
        for (starterPackQuery in starterPackQueries) {
            val itemGroups = executeStarterPackQuery(starterPackQuery)
            starterPackBoxOption.addAll(itemGroups)
        }
        return starterPackBoxOption
    }

    fun executeStarterPackQuery(starterPackQuery: StarterPackQuery): List<ItemGroup> {
        val listOfItems = getListOfItems(starterPackQuery.equipmentType)
        val item = itemService.getItemById(starterPackQuery.itemId, listOfItems)
        return listOf(ItemGroup().apply { this.item = item; number = starterPackQuery.quantity })
    }

    private fun getListOfItems(equipmentType: EquipmentType): List<Item> {
        return when (equipmentType) {
            EquipmentType.WEAPON -> allWeapons
            EquipmentType.ARMOR -> allArmor
            EquipmentType.GOOD -> allGoods
            EquipmentType.PACK -> allGoods
        }
    }

}
