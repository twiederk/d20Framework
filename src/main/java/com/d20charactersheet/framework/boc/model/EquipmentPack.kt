package com.d20charactersheet.framework.boc.model

data class EquipmentPack(
    val id: Int,
    val name: String,
    val itemGroups: MutableList<ItemGroup> = mutableListOf()
) {
    fun addAll(itemGroups: List<ItemGroup>) {
        this.itemGroups.addAll(itemGroups)
    }
}
