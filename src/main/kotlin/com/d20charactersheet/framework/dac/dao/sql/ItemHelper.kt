package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.Item
import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ItemGroupRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Helper to retrieve all items of a specific implementation (weapon, armor, good) from the database. Retrieves all items
 * of a character of a specific item type.
 * Creates ItemHelper with given database and helper.
 *
 * @param db
 * The database to connect to.
 * @param helper
 * The helper to handle basic item tasks.
 */
internal open class ItemHelper(val db: Database, val helper: SqlItemDaoHelper) {

    /**
     * Returns all items of a sub type of item.
     *
     * @param sql
     * The sql to select all items of the sub type.
     * @param rowMapper
     * Rowmapper to map row data to sub type of item.
     *
     * @return All items of a sub type of item.
     */
    fun getAllItems(sql: String, rowMapper: RowMapper): List<Item> {
        val allItems: MutableList<Item> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(sql, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val item = rowMapper.mapRow(queryResult.getDataRow()) as Item
                allItems.add(item)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all items", sqlException);
        } finally {
            queryResult?.close()
        }
        return allItems
    }

    /**
     * Returns all items of a character grouped together.
     *
     * @param sql
     * The sql to select the a subtype of an item.
     * @param character
     * The character to get its items grouped.
     * @param allItems
     * All items available in the game system.
     *
     * @return All items of a character grouped together.
     */
    fun getItemGroups(sql: String, character: Character, allItems: List<Item>): List<ItemGroup> {
        val itemGroups: MutableList<ItemGroup> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(character.id.toString())
            queryResult = db.rawQuery(sql, params)
            val itemGroupRowMapper = ItemGroupRowMapper(allItems)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                mapAndAddItemGroup(queryResult, itemGroups, itemGroupRowMapper)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get items of character", sqlException);
        } finally {
            queryResult?.close()
        }
        return itemGroups
    }

    private fun mapAndAddItemGroup(queryResult: QueryResult, characterItem: MutableList<ItemGroup>,
                                   itemGroupRowMapper: ItemGroupRowMapper) {
        try {
            val itemGroup = itemGroupRowMapper.mapRow(queryResult.getDataRow()) as ItemGroup
            characterItem.add(itemGroup)
        } catch (exception: Exception) {
            //            Logger.error("Can't map item group, skipping it", exception);
        }
    }
}