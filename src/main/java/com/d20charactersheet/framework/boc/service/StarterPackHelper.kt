package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class StarterPackHelper(
    private val itemService: ItemService,
    private val allWeapons: List<Weapon>,
    private val allArmor: List<Armor>,
    private val allGoods: List<Good>,
    val allPacks: List<EquipmentPack>
) {


    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        val groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>> = groupStarterPackQueries(starterPackQueries)
        return createStarterBoxOptions(groupedStarterPackQuieries)
    }

    private fun groupStarterPackQueries(starterPackQueries: List<StarterPackQuery>): Map<Int, List<StarterPackQuery>> {
        return starterPackQueries.groupBy { it.optionId }
    }


    internal fun createStarterBoxOptions(groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>>): List<StarterPackBoxOption> {
        // queries are now mapped to options
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        for (starterPackQueries in groupedStarterPackQuieries.values) {
            // list of queries for one option
            starterPackOptions.addAll(
                StarterPackFactory().createStarterPackOptions(
                    starterPackQueries,
                    itemService,
                    allWeapons,
                    allArmor,
                    allGoods,
                    allPacks
                )
            )
        }
        return starterPackOptions
    }


}
