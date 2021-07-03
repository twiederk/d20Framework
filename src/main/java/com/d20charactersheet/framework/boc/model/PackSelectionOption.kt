package com.d20charactersheet.framework.boc.model

class PackSelectionOption(val equipmentPack: EquipmentPack) : SelectionOption {

    override fun getTitle(): String = equipmentPack.name ?: ""

}
