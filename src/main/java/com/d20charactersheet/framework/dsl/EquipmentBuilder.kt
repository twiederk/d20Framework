package com.d20charactersheet.framework.dsl

import com.d20charactersheet.framework.boc.model.Equipment
import com.d20charactersheet.framework.boc.model.Good
import com.d20charactersheet.framework.boc.model.ItemGroup

class EquipmentBuilder {
    var goods = mutableListOf<ItemGroup>()

    fun good(c: GoodBuilder.() -> Unit) {
        goods.add(GoodBuilder().apply(c).build())
    }

    fun build(): Equipment {
        val equipment = Equipment()
        equipment.goods = goods
        return equipment
    }

}

class GoodBuilder {
    var itemname: String? = null
    var quantity: Int = 1

    fun build(): ItemGroup {
        return ItemGroup().also { itemGroup ->
            itemGroup.item = Good().apply { name = itemname }
            itemGroup.number = quantity
        }
    }

}
