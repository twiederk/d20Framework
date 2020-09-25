package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.boc.model.Weapon
import com.d20charactersheet.framework.boc.model.WeaponFamily
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COMBAT_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COST
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CRITICAL_HIT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CRITICAL_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DIE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ENHANCEMENT_BONUS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NUMBER_OF_DICE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_QUALITY_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_RANGE_INCREMENT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEAPON_CATEGORY_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEAPON_ENCUMBRANCE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEAPON_FAMILY_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEAPON_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEIGHT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_WEAPON
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_WEAPON
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_WEAPON_FAMILY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.WeaponFamilyRowMapper
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.WeaponRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Helper class of the ItemDao. Handles all database activities concerning weapons. Its like a WeaponDao.
 */
internal class WeaponHelper(db: Database, helper: SqlItemDaoHelper) : ItemHelper(db, helper) {

    private val weaponFamilyRowMapper: WeaponFamilyRowMapper = WeaponFamilyRowMapper()

    companion object {
        private const val SQL_GET_ALL_WEAPONS: String = (SELECT + "id, name, description, cost, weight, number_of_dice, die_id, "
                + "enhancement_bonus, critical_hit, critical_mod, weapon_type_id, quality_type_id, "
                + "combat_type_id, weapon_encumbrance_id, weapon_category_id, weapon_family_id, range_increment FROM " + TABLE_WEAPON)
        private const val SQL_GET_CHARACTER_WEAPONS: String = (SELECT + "id, weapon_id, number " //
                + FROM + TABLE_CHARAKTER_WEAPON + " " //
                + WHERE + "charakter_id = ?")
        private const val SQL_GET_WEAPON_ID: String = SELECT + "id FROM " + TABLE_WEAPON + " WHERE rowid = ?"
        private const val SQL_GET_ALL_WEAPON_FAMILIES: String = SELECT + "id, name FROM " + TABLE_WEAPON_FAMILY
    }


    /**
     * Returns all weapons.
     *
     * @param allWeaponFamilies
     * List of all weapon families.
     *
     * @return All weaopns.
     */
    fun getAllWeapons(allWeaponFamilies: List<WeaponFamily>): List<Weapon> {
        val allItems = getAllItems(SQL_GET_ALL_WEAPONS, WeaponRowMapper(allWeaponFamilies))
        val allWeapons: MutableList<Weapon> = ArrayList()
        for (item in allItems) {
            allWeapons.add(item as Weapon)
        }
        return allWeapons
    }

    /**
     * Returns all weapons of the character.
     *
     * @param character
     * The character.
     * @param allWeapons
     * All available weapons.
     *
     * @return All weapons of the character.
     */
    fun getWeapons(character: Character, allWeapons: List<Weapon>): List<ItemGroup> {
        return getItemGroups(SQL_GET_CHARACTER_WEAPONS, character, allWeapons)
    }

    /**
     * Updates the list of weapons owned by the character.
     *
     * @param character
     * The character to update its list.
     * @param weapons
     * The new list of weapons of the character.
     *
     * @return The updated list of weapons of the character.
     */
    fun updateWeapons(character: Character, weapons: List<ItemGroup>): List<ItemGroup> {
        return helper.updateItems(character.equipment.weapons, weapons, TABLE_CHARAKTER_WEAPON, character.id)
    }

    /**
     * Creates a new weapon.
     *
     * @param weapon
     * The weapon to create.
     *
     * @return The new weapon with its created id.
     */
    fun createWeapon(weapon: Weapon): Weapon {
        insertWeaponTable(weapon)
        return weapon
    }

    private fun insertWeaponTable(weapon: Weapon) {
        val contentValues = getContentValues(weapon)
        contentValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_WEAPON, contentValues)
            check(rowId != -1L) { "Can't insert weapon in weapon table" }
            weapon.id = db.queryId(SQL_GET_WEAPON_ID, rowId)
        }
    }

    private fun getContentValues(weapon: Weapon): ContentValues {
        val damage = weapon.damage
        val critical = weapon.critical
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, weapon.name)
        contentValues.put(COLUMN_DESCRIPTION, weapon.description)
        contentValues.put(COLUMN_COST, weapon.cost)
        contentValues.put(COLUMN_WEIGHT, weapon.weight)
        contentValues.put(COLUMN_NUMBER_OF_DICE, damage.numberOfDice)
        contentValues.put(COLUMN_DIE_ID, damage.die.ordinal)
        contentValues.put(COLUMN_ENHANCEMENT_BONUS, weapon.enhancementBonus)
        contentValues.put(COLUMN_CRITICAL_HIT, critical.hit)
        contentValues.put(COLUMN_CRITICAL_MOD, critical.multiplier)
        contentValues.put(COLUMN_WEAPON_TYPE_ID, weapon.weaponType.ordinal)
        contentValues.put(COLUMN_QUALITY_TYPE_ID, weapon.qualityType.ordinal)
        contentValues.put(COLUMN_COMBAT_TYPE_ID, weapon.combatType.ordinal)
        contentValues.put(COLUMN_WEAPON_ENCUMBRANCE_ID, weapon.weaponEncumbrance.ordinal)
        contentValues.put(COLUMN_WEAPON_CATEGORY_ID, weapon.weaponCategory.ordinal)
        contentValues.put(COLUMN_WEAPON_FAMILY_ID, weapon.weaponFamily.id)
        contentValues.put(COLUMN_RANGE_INCREMENT, weapon.rangeIncrement)
        return contentValues
    }

    /**
     * Updates the weapon.
     *
     * @param weapon
     * The weapon to update.
     */
    fun updateWeapon(weapon: Weapon) {
        deleteWeapon(weapon)
        updateWeaponTable(weapon)
    }

    private fun updateWeaponTable(weapon: Weapon) {
        val contentValues = getContentValues(weapon)
        contentValues.put(COLUMN_ID, weapon.id)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_WEAPON, contentValues)
            check(rowId != -1L) { "Can't insert weapon in weapon table" }
        }
    }

    /**
     * Deletes the weapon.
     *
     * @param weapon
     * The weapon to update.
     */
    fun deleteWeapon(weapon: Weapon) {
        val weaponId = arrayOf(weapon.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_WEAPON, "$COLUMN_ID = ?", weaponId) }
    }//            Logger.error("Can't get all weapon families", sqlException);

    /**
     * Returns all weapon families from the database.
     *
     * @return All weapon families.
     */
    val allWeaponFamilies: List<WeaponFamily>
        get() {
            val allWeaponFamilies: MutableList<WeaponFamily> = ArrayList()
            var queryResult: QueryResult? = null
            try {
                queryResult = db.rawQuery(SQL_GET_ALL_WEAPON_FAMILIES, arrayOf())
                queryResult.moveToFirst()
                while (!queryResult.isAfterLast()) {
                    val weaponFamily = weaponFamilyRowMapper.mapRow(queryResult.getDataRow()) as WeaponFamily
                    allWeaponFamilies.add(weaponFamily)
                    queryResult.moveToNext()
                }
            } catch (sqlException: SQLException) {
                //            Logger.error("Can't get all weapon families", sqlException);
            } finally {
                queryResult?.close()
            }
            return allWeaponFamilies
        }


}