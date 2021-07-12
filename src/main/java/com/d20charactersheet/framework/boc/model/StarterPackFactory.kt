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
                PACK -> {
                    val equipmentPack = itemService.getEquipmentPackById(starterPackQuery.itemId, allPacks)
                    return listOf(StarterPackBoxPackOption(equipmentPack))
                }
                WEAPON -> {
                    val weapon = itemService.getItemById(starterPackQuery.itemId, allWeapons)
                    val starterPackOption = StarterPackBoxItemOption().also {
                        it.add(ItemGroup().apply { item = weapon; number = starterPackQuery.quantity })
                    }
                    return listOf(starterPackOption)
                }
                ARMOR -> {
                    val weapon = itemService.getItemById(starterPackQuery.itemId, allArmor)
                    val starterPackOption = StarterPackBoxItemOption().also {
                        it.add(ItemGroup().apply { item = weapon; number = starterPackQuery.quantity })
                    }
                    return listOf(starterPackOption)
                }
                GOOD -> {
                    val weapon = itemService.getItemById(starterPackQuery.itemId, allGood)
                    val starterPackOption = StarterPackBoxItemOption().also {
                        it.add(ItemGroup().apply { item = weapon; number = starterPackQuery.quantity })
                    }
                    return listOf(starterPackOption)
                }
            }
        }
        return emptyList()
    }

}
