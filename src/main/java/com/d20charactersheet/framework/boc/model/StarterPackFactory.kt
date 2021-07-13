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
        if (isEquipmentPackQuery(starterPackQueries)) {
            val equipmentPack = itemService.getEquipmentPackById(starterPackQueries[0].itemId, allPacks)
            return listOf(StarterPackBoxPackOption(equipmentPack))
        }

        if (isSingleItemQuery(starterPackQueries[0])) {
            val itemGroups = mutableListOf<ItemGroup>()
            for (starterPackQuery in starterPackQueries) {
                itemGroups.add(getSingleItem(starterPackQuery, itemService, allWeapons, allArmor, allGood))
            }
            return listOf(StarterPackBoxItemOption().also { it.addAll(itemGroups) })
        } else {
            for (starterPackQuery in starterPackQueries) {
                val starterPackOptions = mutableListOf<StarterPackBoxOption>()
                starterPackOptions.addAll(getMultipleItems(starterPackQuery, itemService, allWeapons, allArmor, allGood))
                return starterPackOptions
            }
        }
        return emptyList()
    }

    private fun isSingleItemQuery(starterPackQuery: StarterPackQuery): Boolean = starterPackQuery.itemId != -1

    private fun isEquipmentPackQuery(starterPackQueries: List<StarterPackQuery>) =
        starterPackQueries.size == 1 && starterPackQueries[0].equipmentType == PACK

    private fun getSingleItem(
        starterPackQuery: StarterPackQuery,
        itemService: ItemService,
        allWeapons: List<Weapon>,
        allArmor: List<Armor>,
        allGood: List<Good>
    ): ItemGroup = when (starterPackQuery.equipmentType) {
        WEAPON -> {
            val weapon = itemService.getItemById(starterPackQuery.itemId, allWeapons)
            ItemGroup().apply { this.item = weapon; number = starterPackQuery.quantity }
        }
        ARMOR -> {
            val armor = itemService.getItemById(starterPackQuery.itemId, allArmor)
            ItemGroup().apply { this.item = armor; number = starterPackQuery.quantity }
        }
        else -> {
            val good = itemService.getItemById(starterPackQuery.itemId, allGood)
            ItemGroup().apply { this.item = good; number = starterPackQuery.quantity }
        }
    }

    private fun getMultipleItems(
        starterPackQuery: StarterPackQuery,
        itemService: ItemService,
        allWeapons: List<Weapon>,
        allArmor: List<Armor>,
        allGood: List<Good>
    ): List<StarterPackBoxOption> {
        val weaponType = WeaponType.values()[starterPackQuery.typeId]
        val weapons = itemService.filterWeaponsByType(weaponType)
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        for (weapon in weapons) {
            val itemGroup = ItemGroup().apply { item = weapon; number = starterPackQuery.quantity }
            starterPackOptions.add(StarterPackBoxItemOption().also { it.add(itemGroup) })
        }
        return starterPackOptions

    }

}
