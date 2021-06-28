package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.model.EquipmentType.*

class StarterPackFactory {

    fun createStarterPackOptions(
        starterPackQueries: List<StarterPackQuery>,
        starterPackData: StarterPackData
    ): List<StarterPackBoxOption> {
        if (isEquipmentPackQuery(starterPackQueries)) {
            val equipmentPack =
                starterPackData.itemService.getEquipmentPackById(starterPackQueries[0].itemId, starterPackData.allPacks)
            return listOf(StarterPackBoxPackOption(equipmentPack))
        }

        if (isSingleItemQuery(starterPackQueries[0])) {
            val itemGroups = mutableListOf<ItemGroup>()
            for (starterPackQuery in starterPackQueries) {
                itemGroups.add(getSingleItem(starterPackQuery, starterPackData))
            }
            return listOf(StarterPackBoxItemOption().also { it.addAll(itemGroups) })
        } else {
            for (starterPackQuery in starterPackQueries) {
                val starterPackOptions = mutableListOf<StarterPackBoxOption>()
                starterPackOptions.addAll(getMultipleItems(starterPackQuery, starterPackData))
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
        starterPackData: StarterPackData
    ): ItemGroup = when (starterPackQuery.equipmentType) {
        WEAPON -> {
            val weapon = starterPackData.itemService.getItemById(starterPackQuery.itemId, starterPackData.allWeapons)
            ItemGroup().apply { this.item = weapon; number = starterPackQuery.quantity }
        }
        ARMOR -> {
            val armor = starterPackData.itemService.getItemById(starterPackQuery.itemId, starterPackData.allArmor)
            ItemGroup().apply { this.item = armor; number = starterPackQuery.quantity }
        }
        else -> {
            val good = starterPackData.itemService.getItemById(starterPackQuery.itemId, starterPackData.allGoods)
            ItemGroup().apply { this.item = good; number = starterPackQuery.quantity }
        }
    }

    private fun getMultipleItems(
        starterPackQuery: StarterPackQuery,
        starterPackData: StarterPackData
    ): List<StarterPackBoxOption> {
        val starterPackOptions = mutableListOf<StarterPackBoxOption>()
        when (starterPackQuery.equipmentType) {
            WEAPON -> {
                val weaponType = WeaponType.values()[starterPackQuery.typeId]
                var weapons = starterPackData.itemService.filterWeaponsByType(weaponType, starterPackData.allWeapons)
                if (starterPackQuery.combatId != -1) {
                    val combatType = CombatType.values()[starterPackQuery.combatId]
                    weapons = starterPackData.itemService.filterWeaponsByCombat(combatType, weapons)
                }
                for (weapon in weapons) {
                    val itemGroup = ItemGroup().apply { item = weapon; number = starterPackQuery.quantity }
                    starterPackOptions.add(StarterPackBoxItemOption().also { it.add(itemGroup) })
                }
            }
            ARMOR -> {
                val armorType = ArmorType.values()[starterPackQuery.typeId]
                val filteredArmor = starterPackData.itemService.filterArmorByType(armorType, starterPackData.allArmor)
                for (armor in filteredArmor) {
                    val itemGroup = ItemGroup().apply { item = armor; number = starterPackQuery.quantity }
                    starterPackOptions.add(StarterPackBoxItemOption().also { it.add(itemGroup) })
                }
            }
            else -> {
                val goodType = GoodType.values()[starterPackQuery.typeId]
                val goods = starterPackData.itemService.filterGoodsByType(goodType, starterPackData.allGoods)
                for (good in goods) {
                    val itemGroup = ItemGroup().apply { item = good; number = starterPackQuery.quantity }
                    starterPackOptions.add(StarterPackBoxItemOption().also { it.add(itemGroup) })
                }
            }
        }
        return starterPackOptions

    }

}
