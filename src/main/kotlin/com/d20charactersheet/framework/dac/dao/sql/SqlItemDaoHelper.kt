package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ARMOR_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CHARAKTER_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_GOOD_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NUMBER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEAPON_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_ARMOR
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_GOOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_WEAPON
import java.sql.SQLException

/**
 * Expands ItemDaoHelper to use optimized update of item groups.
 * Creates SQLiteItemDaoHelper with access to given database.
 *
 * @param db
 * Database to access.
 */
class SqlItemDaoHelper(private val db: Database) : ItemDaoHelper() {

    override fun deleteItemGroups(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>, tableName: String) {
        val itemsToDelete = getItemsToDelete(currentItems, editedItems)
        synchronized(Database.DB_LOCK) {
            for (itemToDelete in itemsToDelete) {
                val itemGroupId = arrayOf(itemToDelete.id.toString())
                db.delete(tableName, "$COLUMN_ID = ?", itemGroupId)
            }
        }
    }

    override fun updateItemGroups(currentItems: List<ItemGroup>, editedItems: List<ItemGroup>,
                                  tableName: String, characterId: Int): List<ItemGroup> {
        val itemsToUpdate = getItemsToUpdate(currentItems, editedItems)
        synchronized(Database.DB_LOCK) {
            for (itemGroup in itemsToUpdate) {
                val itemValues = ContentValues()
                itemValues.put(COLUMN_NUMBER, itemGroup.number)
                itemValues.put(COLUMN_CHARAKTER_ID, characterId)
                val bindVariables = arrayOf(itemGroup.id.toString())
                db.update(tableName, itemValues, SQL_WHERE_ID, bindVariables)
            }
        }
        return itemsToUpdate
    }

    private fun getItemValues(itemGroup: ItemGroup, tableName: String, characterId: Int): ContentValues {
        // id, character id, item id, number
        val itemValues = ContentValues()
        itemValues.put(COLUMN_CHARAKTER_ID, characterId)
        itemValues.put(getColumnName(tableName), itemGroup.item.id)
        itemValues.put(COLUMN_NUMBER, itemGroup.number)
        return itemValues
    }

    private fun getColumnName(tableName: String): String = when (tableName) {
        TABLE_CHARAKTER_WEAPON  -> COLUMN_WEAPON_ID
        TABLE_CHARAKTER_ARMOR -> COLUMN_ARMOR_ID
        TABLE_CHARAKTER_GOOD -> COLUMN_GOOD_ID
        else -> throw IllegalArgumentException("Can't determine column name of $tableName")
    }

    override fun insertItemGroups(editedItems: List<ItemGroup>, tableName: String, characterId: Int): List<ItemGroup> {
        val itemsToInsert = getItemsToInsert(editedItems)
        synchronized(Database.DB_LOCK) {
            for (itemToInsert in itemsToInsert) {
                val itemValues = getItemValues(itemToInsert, tableName, characterId)
                itemValues.putNull(COLUMN_ID)
                val rowId = db.insertOrThrow(tableName, itemValues)
                check(rowId != -1L) { "Can't insert $itemsToInsert in $tableName" }
                itemToInsert.id = getId(tableName, rowId)
            }
        }
        return itemsToInsert
    }

    private fun getId(tableName: String, rowId: Long): Int {
        val sql: String = SELECT + "id FROM " + tableName + " WHERE rowid = ?"
        val bindVariables = arrayOf(rowId.toString())
        var queryResult: QueryResult? = null
        return try {
            queryResult = db.rawQuery(sql, bindVariables)
            queryResult.moveToFirst()
            queryResult.getDataRow().getInt(0)
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get id of rowId: " + rowId);
            throw IllegalStateException(sqlException)
        } finally {
            queryResult?.close()
        }
    }
}