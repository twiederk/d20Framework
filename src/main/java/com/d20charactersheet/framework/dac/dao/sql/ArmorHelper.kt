package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ARMOR_BONUS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ARMOR_PENALTY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ARMOR_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COST
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_QUALITY_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEIGHT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_ARMOR
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_ARMOR
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ArmorRowMapper
import java.util.*

/**
 * Helper class of the ItemDao. Handles all database activities concerning armor. Its like an ArmorDao.
 */
internal class ArmorHelper(db: Database, helper: SqlItemDaoHelper) : ItemHelper(db, helper) {

    private val armorRowMapper: ArmorRowMapper = ArmorRowMapper()

    companion object {
        private const val SQL_GET_ALL_ARMOR: String = (SELECT + "id, name, description, cost, weight, armor_bonus, armor_penalty, armor_type_id, quality_type_id FROM "
                + TABLE_ARMOR)
        private const val SQL_GET_CHARACTER_ARMOR: String = (SELECT + "id, armor_id, number " //
                + FROM + TABLE_CHARAKTER_ARMOR + " " //
                + WHERE + "charakter_id = ?")
        private const val SQL_GET_ARMOR_ID: String = SELECT + "id FROM " + TABLE_ARMOR + " WHERE rowid = ?"
    }

    /**
     * Returns list of all armor.
     *
     * @return List of all armor.
     */
    val allArmor: List<Armor>
        get() {
            val allItems = getAllItems(SQL_GET_ALL_ARMOR, armorRowMapper)
            val allArmor: MutableList<Armor> = ArrayList()
            for (item in allItems) {
                allArmor.add(item as Armor)
            }
            return allArmor
        }

    /**
     * Returns all armor of the character.
     *
     * @param character
     * The character to retrieve the armor of.
     * @param allArmor
     * All available armor in the system.
     *
     * @return The armor of the character.
     */
    fun getArmor(character: Character, allArmor: List<Armor>): List<ItemGroup> {
        return getItemGroups(SQL_GET_CHARACTER_ARMOR, character, allArmor)
    }

    /**
     * Updates the list of armor of the character.
     *
     * @param character
     * The character to update its armor.
     * @param armor
     * The armor of the character.
     *
     * @return The updated list of the armor of the character.
     */
    fun updateArmor(character: Character, armor: List<ItemGroup>): List<ItemGroup> {
        return helper.updateItems(character.equipment.armor, armor, TABLE_CHARAKTER_ARMOR, character.id)
    }

    /**
     * Create a new armor.
     *
     * @param armor
     * The armor to create.
     *
     * @return The new created armor, including its id.
     */
    fun createArmor(armor: Armor): Armor {
        insertArmorTable(armor)
        return armor
    }

    private fun insertArmorTable(armor: Armor) {
        val contentValues = getContentValues(armor)
        contentValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_ARMOR, contentValues)
            check(rowId != -1L) { "Can't insert armor in armor table" }
            armor.id = db.queryId(SQL_GET_ARMOR_ID, rowId)
        }
    }

    private fun getContentValues(armor: Armor): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, armor.name)
        contentValues.put(COLUMN_DESCRIPTION, armor.description)
        contentValues.put(COLUMN_COST, armor.cost)
        contentValues.put(COLUMN_WEIGHT, armor.weight)
        contentValues.put(COLUMN_ARMOR_BONUS, armor.armorBonus)
        contentValues.put(COLUMN_ARMOR_PENALTY, armor.armorCheckPenalty)
        contentValues.put(COLUMN_ARMOR_TYPE_ID, armor.armorType.ordinal)
        contentValues.put(COLUMN_QUALITY_TYPE_ID, armor.qualityType.ordinal)
        return contentValues
    }

    /**
     * Delete the armor.
     *
     * @param armor
     * The armor to delete.
     */
    fun deleteArmor(armor: Armor) {
        val armorId = arrayOf(armor.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_ARMOR, "$COLUMN_ID = ?", armorId) }
    }

    /**
     * Update the armor.
     *
     * @param armor
     * The armor to update.
     */
    fun updateArmor(armor: Armor) {
        deleteArmor(armor)
        updateArmorTable(armor)
    }

    private fun updateArmorTable(armor: Armor) {
        val contentValues = getContentValues(armor)
        contentValues.put(COLUMN_ID, armor.id)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_ARMOR, contentValues)
            check(rowId != -1L) { "Can't insert armor in armor table" }
        }
    }

}