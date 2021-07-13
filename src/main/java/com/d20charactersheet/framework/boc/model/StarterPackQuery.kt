package com.d20charactersheet.framework.boc.model

data class StarterPackQuery(
    val id: Int,
    val optionId: Int,
    val equipmentType: EquipmentType,
    val typeId: Int,
    val combatId: Int,
    val itemId: Int,
    val quantity: Int
)