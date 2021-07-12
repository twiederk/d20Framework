package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.model.EquipmentType.*
import com.d20charactersheet.framework.boc.service.ItemService

class StarterPackFactory {

    fun createStarterPackOptions(
        starterPackQueries: List<StarterPackQuery>,
        itemService: ItemService,
        allWeapons: List<Weapon>,
        allArmor: List<Armor>,
        allGood: List<Good>,
        allPacks: List<EquipmentPack>
    ): List<StarterPackBoxOption> {
        if (starterPackQueries.size == 1) {
            val starterPackQuery = starterPackQueries[0]
            when (starterPackQuery.equipmentType) {
                WEAPON -> {
                    val weapon = itemService.getItemById(starterPackQuery.itemId, allWeapons)
                    return createStarterPackItemOption(weapon, starterPackQuery)
                }
                ARMOR -> {
                    val armor = itemService.getItemById(starterPackQuery.itemId, allArmor)
                    return createStarterPackItemOption(armor, starterPackQuery)
                }
                GOOD -> {
                    val good = itemService.getItemById(starterPackQuery.itemId, allGood)
                    return createStarterPackItemOption(good, starterPackQuery)
                }
                PACK -> {
                    val equipmentPack = itemService.getEquipmentPackById(starterPackQuery.itemId, allPacks)
                    return listOf(StarterPackBoxPackOption(equipmentPack))
                }
            }
        }
        return emptyList()
    }

    private fun createStarterPackItemOption(
        item: Item,
        starterPackQuery: StarterPackQuery
    ): List<StarterPackBoxItemOption> {
        val starterPackOption = StarterPackBoxItemOption().also {
            it.add(ItemGroup().apply { this.item = item; number = starterPackQuery.quantity })
        }
        return listOf(starterPackOption)
    }

}
