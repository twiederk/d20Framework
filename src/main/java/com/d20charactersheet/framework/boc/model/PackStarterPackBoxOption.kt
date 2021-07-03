package com.d20charactersheet.framework.boc.model

class PackStarterPackBoxOption(val equipmentPack: EquipmentPack) : StarterPackBoxOption {

    override fun getTitle(): String = equipmentPack.name ?: ""

}
