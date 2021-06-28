package com.d20charactersheet.framework.boc.model

class StarterPackBoxPackOption(val equipmentPack: EquipmentPack) : StarterPackBoxOption {

    override fun getTitle(): String = equipmentPack.name

    override fun getItemGroups(): List<ItemGroup> = equipmentPack.itemGroups

}
