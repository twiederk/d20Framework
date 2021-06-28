package com.d20charactersheet.framework.boc.model

class StarterPackBoxItemOption : StarterPackBoxOption {

    private val items: MutableList<ItemGroup> = mutableListOf()

    override fun getTitle(): String = items
        .map { extractItemName(it) }
        .joinToString { it }

    override fun getItemGroups(): List<ItemGroup> = items

    fun addAll(itemGroups: List<ItemGroup>) {
        this.items.addAll(itemGroups)
    }

    fun add(itemGroup: ItemGroup) {
        items.add(itemGroup)
    }

    private fun extractItemName(itemGroup: ItemGroup) = when (itemGroup.number) {
        1 -> itemGroup.item.name
        else -> "${itemGroup.item.name} (${itemGroup.number})"
    }
}
