package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService

class StarterPackFactory {

    fun createStarterPackOptions(
        starterPackQueries: List<StarterPackQuery>,
        itemService: ItemService,
        allPacks: List<EquipmentPack>
    ): List<StarterPackBoxOption> {
        if (starterPackQueries.size == 1 && starterPackQueries[0].equipmentType == EquipmentType.PACK) {
            val equipmentPack = itemService.getEquipmentPackById(starterPackQueries[0].itemId, allPacks)
            return listOf(StarterPackBoxPackOption(equipmentPack))
        }
        return emptyList()
    }

}
