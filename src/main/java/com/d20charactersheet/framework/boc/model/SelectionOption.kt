package com.d20charactersheet.framework.boc.model

class SelectionOption {


    val itemGroups: MutableList<ItemGroup> = mutableListOf()


    fun getTitle(): String {
        if (itemGroups.isEmpty()) return ""
        return itemGroups[0].item.name
    }

    fun add(itemGroup: ItemGroup) {
        itemGroups.add(itemGroup)
    }
}
