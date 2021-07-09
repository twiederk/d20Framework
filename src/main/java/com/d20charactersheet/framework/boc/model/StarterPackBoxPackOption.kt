package com.d20charactersheet.framework.boc.model

class StarterPackBoxPackOption(val equipmentPack: EquipmentPack) : StarterPackBoxOption {

    override fun getTitle(): String = equipmentPack.name ?: ""

    override fun addAll(itemGroups: List<ItemGroup>) {
        TODO("Not yet implemented function body")
    }

}
