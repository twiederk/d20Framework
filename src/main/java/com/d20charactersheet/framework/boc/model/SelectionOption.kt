package com.d20charactersheet.framework.boc.model

class SelectionOption {


    val itemGroups: MutableList<ItemGroup> = mutableListOf()

    fun add(itemGroup: ItemGroup) {
        itemGroups.add(itemGroup)
    }

    fun getTitle(): String = itemGroups
        .map { extractItemName(it) }
        .joinToString { it }

    private fun extractItemName(itemGroup: ItemGroup) = when (itemGroup.number) {
        1 -> itemGroup.item.name
        else -> "${itemGroup.item.name} (${itemGroup.number})"
    }
}
