package com.d20charactersheet.framework.boc.model

interface StarterPackBoxOption {

    fun getTitle(): String

    fun addAll(itemGroups: List<ItemGroup>)

}
