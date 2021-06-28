package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.EquipmentPack
import com.d20charactersheet.framework.boc.model.Item
import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.EquipmentPackRowMapper
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ItemGroupRowMapper
import java.sql.SQLException

class EquipmentPackHelper(private val db: Database) {

    fun getAllEquipmentPacks(allItems: List<Item>): List<EquipmentPack> {
        val allEquipmentPacks = selectAllEquipmentPacks()
        for (equipmentPack in allEquipmentPacks) {
            val itemGroups = selectItemGroups(equipmentPack.id, allItems)
            equipmentPack.addAll(itemGroups)
        }
        return allEquipmentPacks
    }

    private fun selectAllEquipmentPacks(): List<EquipmentPack> {
        val allEquipmentPacks: MutableList<EquipmentPack> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(TableAndColumnNames.SQL_GET_ALL_EQUIPMENT_PACKS, emptyArray())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val equipmentPack = EquipmentPackRowMapper().mapRow(queryResult.getDataRow())
                allEquipmentPacks.add(equipmentPack)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            println("Can't get all equipment packs $sqlException")
            sqlException.printStackTrace()
        } finally {
            queryResult?.close()
        }
        return allEquipmentPacks
    }


    private fun selectItemGroups(id: Int, allItems: List<Item>): List<ItemGroup> {
        val itemGroups: MutableList<ItemGroup> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(TableAndColumnNames.SQL_GET_EQUIPMENT_PACK_ITEM_GROUPS, arrayOf(id.toString()))
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val itemGroup = ItemGroupRowMapper(allItems).mapRow(queryResult.getDataRow())
                itemGroups.add(itemGroup)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            println("Can't get all equipment packs $sqlException")
            sqlException.printStackTrace()
        } finally {
            queryResult?.close()
        }
        return itemGroups
    }


}
