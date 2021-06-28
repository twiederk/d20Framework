package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.boc.service.ItemService

data class StarterPackData(
    val itemService: ItemService,
    val allWeapons: List<Weapon>,
    val allArmor: List<Armor>,
    val allGoods: List<Good>,
    val allPacks: List<EquipmentPack>
)
