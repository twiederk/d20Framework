package com.d20charactersheet.framework.boc.model

class ItemStarterPackBoxOption : StarterPackBoxOption {


    val itemGroups: MutableList<ItemGroup> = mutableListOf()

    override fun getTitle(): String = itemGroups
        .map { extractItemName(it) }
        .joinToString { it }

    fun add(itemGroup: ItemGroup) {
        itemGroups.add(itemGroup)
    }

    private fun extractItemName(itemGroup: ItemGroup) = when (itemGroup.number) {
        1 -> itemGroup.item.name
        else -> "${itemGroup.item.name} (${itemGroup.number})"
    }
}
