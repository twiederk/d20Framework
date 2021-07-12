package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

class StarterPackHelper(
    private val itemService: ItemService,
    private val allWeapons: List<Weapon>,
    private val allArmor: List<Armor>,
    private val allGoods: List<Good>,
    private val allPacks: List<EquipmentPack>
) {

    /**
     * Get all options of one starter box.
     *
     * @param starterPackQueries List of all queries for this starter box.
     *
     * @return List of all options for this box
     */
    fun getStarterBoxOptions(starterPackQueries: List<StarterPackQuery>): List<StarterPackBoxOption> {
        val groupedStarterPackQuieries: Map<Int, List<StarterPackQuery>> = starterPackQueries.groupBy { it.optionId }

        // queries are now mapped to options
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        for (queriesOfOneOption in groupedStarterPackQuieries.values) {
            // list of queries for one option
            starterPackOptions.addAll(
                StarterPackFactory().createStarterPackOptions(
                    queriesOfOneOption,
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
