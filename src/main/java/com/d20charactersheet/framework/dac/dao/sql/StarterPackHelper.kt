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
            createStarterPackOption(starterPackQueries)
            starterPackOptions.add(StarterPackBoxItemOption())
        }
        return starterPackOptions
    }

    fun createStarterPackOption(starterPackQueries: List<StarterPackQuery>): StarterPackBoxOption {
        val starterPackBoxOption = StarterPackBoxItemOption()
        for (starterPackQuery in starterPackQueries) {
            val item = itemService.getItemById(starterPackQuery.itemId, allArmor)
            starterPackBoxOption.add(ItemGroup().apply { this.item = item; number = starterPackQuery.quantity })
        }
        return starterPackBoxOption
    }


}
