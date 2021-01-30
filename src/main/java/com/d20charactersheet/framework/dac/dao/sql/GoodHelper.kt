package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.Good
import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COST
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_GOOD_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_QUALITY_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEIGHT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_GOOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_GOOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.GoodRowMapper
import java.util.*

/**
 * Helper class of the ItemDao. Handles all database activities concerning goods. Its like an GoodDao.
 */
internal class GoodHelper(db: Database, helper: SqlItemDaoHelper) : ItemHelper(db, helper) {

    private val goodRowMapper: GoodRowMapper = GoodRowMapper()

    companion object {
        private const val SQL_GET_ALL_GOODS: String = SELECT + "id, name, description, cost, weight, good_type_id, quality_type_id FROM " + TABLE_GOOD
        private const val SQL_GET_CHARACTER_GOODS: String = (SELECT + "id, good_id, number " //
                + FROM + TABLE_CHARAKTER_GOOD + " " //
                + WHERE + "charakter_id = ?")
        private const val SQL_GET_GOOD_ID: String = SELECT + "id FROM " + TABLE_GOOD + " WHERE rowid = ?"
    }

    /**
     * Returns all available goods.
     *
     * @return All available goods.
     */
    val allGoods: List<Good>
        get() {
            val allItems = getAllItems(SQL_GET_ALL_GOODS, goodRowMapper)
            val allGoods: MutableList<Good> = ArrayList()
            for (item in allItems) {
                allGoods.add(item as Good)
            }
            return allGoods
        }

    /**
     * Returns the goods of the character.
     *
     * @param character
     * The character to get its goods.
     * @param allGoods
     * All available goods.
     *
     * @return The goods of the character.
     */
    fun getGoods(character: Character, allGoods: List<Good>): List<ItemGroup> {
        return getItemGroups(SQL_GET_CHARACTER_GOODS, character, allGoods)
    }

    /**
     * Updates the goods owned by the character.
     *
     * @param character
     * The characte owning the goods.
     * @param goods
     * The owned goods.
     *
     * @return The updated owned goods of the character.
     */
    fun updateGoods(character: Character, goods: List<ItemGroup>): List<ItemGroup> {
        return helper.updateItems(character.equipment.goods, goods, TABLE_CHARAKTER_GOOD, character.id)
    }

    /**
     * Insert the good in the good table and good_text table and set the id of the good.
     *
     * @param good
     * The good to insert.
     *
     * @return The good with its id.
     */
    fun createGood(good: Good): Good {
        insertGoodTable(good)
        return good
    }

    private fun insertGoodTable(good: Good) {
        val contentValues = getContentValues(good)
        contentValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_GOOD, contentValues)
            check(rowId != -1L) { "Can't insert good in good table" }
            good.id = db.queryId(SQL_GET_GOOD_ID, rowId)
        }
    }

    private fun getContentValues(good: Good): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, good.name)
        contentValues.put(COLUMN_DESCRIPTION, good.description)
        contentValues.put(COLUMN_COST, good.cost)
        contentValues.put(COLUMN_WEIGHT, good.weight)
        contentValues.put(COLUMN_GOOD_TYPE_ID, good.goodType.ordinal)
        contentValues.put(COLUMN_QUALITY_TYPE_ID, good.qualityType.ordinal)
        return contentValues
    }

    /**
     * Updates a good by deleting it first and inserting it again, while keeping its original id.
     *
     * @param good
     * The good to update.
     */
    fun updateGood(good: Good) {
        deleteGood(good)
        updateGoodTable(good)
    }

    private fun updateGoodTable(good: Good) {
        val contentValues = getContentValues(good)
        contentValues.put(COLUMN_ID, good.id)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_GOOD, contentValues)
            check(rowId != -1L) { "Can't insert good in good table" }
        }
    }

    /**
     * Delete the good from the good and good_text table.
     *
     * @param good
     * The good to delete.
     */
    fun deleteGood(good: Good) {
        val goodId = arrayOf(good.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_GOOD, "$COLUMN_ID = ?", goodId) }
    }

}