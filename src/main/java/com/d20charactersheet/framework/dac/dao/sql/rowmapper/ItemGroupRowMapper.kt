package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Item
import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * All available items to map.
 *
 * @param allItems
 * All available items to map.
 */
class ItemGroupRowMapper(private val allItems: List<Item>) : BaseRowMapper() {

    /**
     * Maps raw data to an item group.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, weapon_id, number
        val itemGroup = ItemGroup()
        itemGroup.id = dataRow.getInt(0)
        itemGroup.item = getItem(dataRow.getInt(1), allItems)
        itemGroup.number = dataRow.getInt(2)
        return itemGroup
    }
}