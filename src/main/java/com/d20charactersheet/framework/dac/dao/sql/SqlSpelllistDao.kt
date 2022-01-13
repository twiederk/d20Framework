package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.KnownSpellsTable
import com.d20charactersheet.framework.boc.model.Spell
import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable
import com.d20charactersheet.framework.dac.dao.SpelllistDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CASTING_TIME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COMPONENTS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DOMAIN
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DURATION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_EFFECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FOCUS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MATERIAL_COMPONENT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MAX_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MIN_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_RANGE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SAVING_THROW
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SCHOOL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SHORTNAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SHORT_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELLLIST_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_RESISTANCE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_KNOWN_SPELLS_TABLES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SPELLLISTS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SPELLS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SPELLS_PER_DAY_TABLES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_KNOWN_SPELLS_LEVELS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SPELLS_OF_SPELLLIST
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SPELLS_PER_DAY_LEVELS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SPELL_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SPELL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SPELLLIST
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SPELLLIST_SPELL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.KnownSpellsTableRowMapper
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SpellRowMapper
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SpelllistRowMapper
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SpellsPerDayTableRowMapper
import com.d20charactersheet.framework.dac.dao.sql.util.SpellSerializor
import java.sql.SQLException

/**
 * Data access object for SpelllistService. Retrieve spells and spell lists from SQLite3 database.
 * Instantiates SQLiteSpelllistDao
 *
 * @param db
 * The database to access. */
class SqlSpelllistDao(private val db: Database) : SpelllistDao {

    private val spellRowMapper: RowMapper = SpellRowMapper()
    private val spelllistRowMapper: RowMapper = SpelllistRowMapper()
    private val spellSerializor: SpellSerializor = SpellSerializor()

    companion object {
        private const val SQL_GET_ID: String = SELECT + "id" + FROM + TABLE_SPELL + WHERE + "rowid = ?"
        private const val WHERE_SPELLLEVEL: String = "$COLUMN_SPELLLIST_ID = ? AND $COLUMN_SPELL_ID = ?"
    }

    override fun getAllSpells(): List<Spell> {
        val allSpells: MutableList<Spell> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_SPELLS, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val spell = spellRowMapper.mapRow(queryResult.getDataRow()) as Spell
                allSpells.add(spell)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //                Logger.error("Can't get all spells", sqlException);
        } finally {
            queryResult?.close()
        }
        return allSpells
    }

    override fun getAllSpelllists(allSpells: List<Spell>): List<Spelllist> {
        val allSpelllists: MutableList<Spelllist> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_SPELLLISTS, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val spelllist = spelllistRowMapper.mapRow(queryResult.getDataRow()) as Spelllist
                assignSpells(spelllist, allSpells)
                allSpelllists.add(spelllist)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //                Logger.error("Can't get all spelllists", sqlException);
        } finally {
            queryResult?.close()
        }
        return allSpelllists
    }

    private fun assignSpells(spelllist: Spelllist, allSpells: List<Spell>) {
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(spelllist.id.toString())
            val spells: MutableMap<Int, MutableList<Spell>> = HashMap()
            queryResult = db.rawQuery(SQL_GET_SPELLS_OF_SPELLLIST, params)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val spell = getSpellById(queryResult.getDataRow().getInt(0), allSpells)
                val level = queryResult.getDataRow().getInt(1)
                assignSpell(spells, spell, level)
                queryResult.moveToNext()
            }
            spelllist.spellsByLevel = spells
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't assign spells to spelllist: " + spelllist, sqlException);
        } finally {
            queryResult?.close()
        }
    }

    private fun getSpellById(spellId: Int, allSpells: List<Spell>): Spell {
        for (spell in allSpells) {
            if (spell.id == spellId) {
                return spell
            }
        }
        throw IllegalArgumentException("Can't find spell with id: $spellId")
    }

    private fun assignSpell(spells: MutableMap<Int, MutableList<Spell>>, spell: Spell, level: Int) {
        var spellsOfLevel = spells[level]
        if (spellsOfLevel == null) {
            spellsOfLevel = ArrayList()
            spells[level] = spellsOfLevel
        }
        spellsOfLevel.add(spell)
    }

    override fun getSpellDescription(spellId: Int): String {
        var description = ""
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_SPELL_DESCRIPTION, arrayOf(spellId.toString()))
            queryResult.moveToFirst()
            description = queryResult.getDataRow().getString(0)
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get description of spell with id: " + spellId, sqlException);
        } finally {
            queryResult?.close()
        }
        return description
    }

    override fun createSpell(spell: Spell): Spell {
        insertSpellTable(spell)
        return spell
    }

    private fun insertSpellTable(spell: Spell) {
        val spellValues = getSpellValues(spell)
        spellValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_SPELL, spellValues)
            check(rowId != -1L) { "Can't insert spell in spell table" }
            spell.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    private fun getSpellValues(spell: Spell): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, spell.name)
        contentValues.put(COLUMN_SCHOOL, spellSerializor.serializeSchool(spell))
        contentValues.put(COLUMN_COMPONENTS, spellSerializor.serializeComponents(spell))
        contentValues.put(COLUMN_CASTING_TIME, spellSerializor.serializeCastingTime(spell.castingTime))
        contentValues.put(COLUMN_RANGE, spell.range)
        contentValues.put(COLUMN_EFFECT, spell.effect)
        contentValues.put(COLUMN_DURATION, spell.duration)
        contentValues.put(COLUMN_SAVING_THROW, spell.savingThrow)
        contentValues.put(COLUMN_SPELL_RESISTANCE, spellSerializor.serializeSpellResistance(spell.spellResistance))
        contentValues.put(COLUMN_SHORT_DESCRIPTION, spell.shortDescription)
        contentValues.put(COLUMN_DESCRIPTION, spell.description)
        contentValues.put(COLUMN_MATERIAL_COMPONENT, spell.materialComponent)
        contentValues.put(COLUMN_FOCUS, spell.focus)
        return contentValues
    }

    override fun deleteSpell(spell: Spell) {
        val spellId = arrayOf(spell.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_SPELL, "$COLUMN_ID = ?", spellId) }
    }

    override fun updateSpell(spell: Spell) {
        val spellValues = getSpellValues(spell)
        val bindVariables = arrayOf(spell.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_SPELL, spellValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    override fun createSpelllevel(spelllist: Spelllist, spell: Spell, level: Int) {
        val spelllevelValues = getSpelllevelValues(spelllist.id, spell.id, level)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_SPELLLIST_SPELL, spelllevelValues)
            check(rowId != -1L) { "Can't insert spelllevel in spelllist_spell table" }
        }
    }

    private fun getSpelllevelValues(spelllistId: Int, spellId: Int, level: Int): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_SPELLLIST_ID, spelllistId)
        contentValues.put(COLUMN_SPELL_ID, spellId)
        contentValues.put(COLUMN_LEVEL, level)
        return contentValues
    }

    override fun updateSpelllevel(spelllist: Spelllist, spell: Spell, level: Int) {
        val spelllevelValues = ContentValues()
        spelllevelValues.put(COLUMN_LEVEL, level)
        val bindVariables = arrayOf(spelllist.id.toString(), spell.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_SPELLLIST_SPELL, spelllevelValues, WHERE_SPELLLEVEL, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    override fun createSpelllist(spelllist: Spelllist): Spelllist {
        insertSpelllistTable(spelllist)
        return spelllist
    }

    private fun insertSpelllistTable(spelllist: Spelllist) {
        val spelllistValues = getSpelllistValues(spelllist)
        spelllistValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_SPELLLIST, spelllistValues)
            check(rowId != -1L) { "Can't insert spelllist in spelllist table" }
            spelllist.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    private fun getSpelllistValues(spelllist: Spelllist): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, spelllist.name)
        contentValues.put(COLUMN_SHORTNAME, spelllist.shortname)
        contentValues.put(COLUMN_DOMAIN, spelllist.isDomain)
        contentValues.put(COLUMN_MIN_LEVEL, spelllist.minLevel)
        contentValues.put(COLUMN_MAX_LEVEL, spelllist.maxLevel)
        return contentValues
    }

    override fun deleteSpelllist(spelllist: Spelllist) {
        val spelllistId = arrayOf(spelllist.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_SPELLLIST, "$COLUMN_ID = ?", spelllistId) }
    }

    override fun updateSpelllist(spelllist: Spelllist) {
        val spelllistValues = getSpelllistValues(spelllist)
        val bindVariables = arrayOf(spelllist.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_SPELLLIST, spelllistValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    override fun deleteSpelllevel(spelllist: Spelllist, spell: Spell) {
        val bindVariables = arrayOf(spelllist.id.toString(), spell.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_SPELLLIST_SPELL, WHERE_SPELLLEVEL, bindVariables) }
    }

    override fun getAllKnownSpellsTables(): List<KnownSpellsTable> {
        val allKnownSpellsTables: MutableList<KnownSpellsTable> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val rowMapper: RowMapper = KnownSpellsTableRowMapper()
            queryResult = db.rawQuery(SQL_GET_ALL_KNOWN_SPELLS_TABLES, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val knownSpellsTable = rowMapper.mapRow(queryResult.getDataRow()) as KnownSpellsTable
                val knownSpellsLevels = selectKnownSpellsLevels(knownSpellsTable)
                knownSpellsTable.knownSpells = knownSpellsLevels
                allKnownSpellsTables.add(knownSpellsTable)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //                Logger.error("Can't get all xp tables", sqlException);
        } finally {
            queryResult?.close()
        }
        return allKnownSpellsTables
    }

    private fun selectKnownSpellsLevels(knownSpellsTable: KnownSpellsTable): Array<IntArray> {
        val knownSpellsLevels = Array(20) { IntArray(10) }
        var queryResult: QueryResult? = null
        val knownSpellsTableId = knownSpellsTable.id.toString()
        for (spellcasterLevel in knownSpellsLevels.indices) {
            val params = arrayOf(knownSpellsTableId, (spellcasterLevel + 1).toString())
            try {
                queryResult = db.rawQuery(SQL_GET_KNOWN_SPELLS_LEVELS, params)
                queryResult.moveToFirst()
                while (!queryResult.isAfterLast()) {
                    val dataRow = queryResult.getDataRow()
                    knownSpellsLevels[spellcasterLevel][0] = dataRow.getInt(0)
                    knownSpellsLevels[spellcasterLevel][1] = dataRow.getInt(1)
                    knownSpellsLevels[spellcasterLevel][2] = dataRow.getInt(2)
                    knownSpellsLevels[spellcasterLevel][3] = dataRow.getInt(3)
                    knownSpellsLevels[spellcasterLevel][4] = dataRow.getInt(4)
                    knownSpellsLevels[spellcasterLevel][5] = dataRow.getInt(5)
                    knownSpellsLevels[spellcasterLevel][6] = dataRow.getInt(6)
                    knownSpellsLevels[spellcasterLevel][7] = dataRow.getInt(7)
                    knownSpellsLevels[spellcasterLevel][8] = dataRow.getInt(8)
                    knownSpellsLevels[spellcasterLevel][9] = dataRow.getInt(9)
                    queryResult.moveToNext()
                }
            } catch (sqlException: SQLException) {
                //                Logger.error("Can't get all known spells levels", sqlException);
            } finally {
                queryResult?.close()
            }
        }
        return knownSpellsLevels
    }

    override fun getAllSpellsPerDayTables(): List<SpellsPerDayTable> {
        val allSpellsPerDayTables: MutableList<SpellsPerDayTable> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val rowMapper: RowMapper = SpellsPerDayTableRowMapper()
            queryResult = db.rawQuery(SQL_GET_ALL_SPELLS_PER_DAY_TABLES, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val spellsPerDayTable = rowMapper.mapRow(queryResult.getDataRow()) as SpellsPerDayTable
                val spellsPerDayLevels = selectSpellsPerDayLevels(spellsPerDayTable)
                spellsPerDayTable.spellsPerDay = spellsPerDayLevels
                allSpellsPerDayTables.add(spellsPerDayTable)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all spells per day tables", sqlException);
        } finally {
            queryResult?.close()
        }
        return allSpellsPerDayTables
    }

    private fun selectSpellsPerDayLevels(spellsPerDayTable: SpellsPerDayTable): Array<IntArray> {
        val spellsPerDayLevels = Array(20) { IntArray(10) }
        var queryResult: QueryResult? = null
        val spellsPerDayTableId = spellsPerDayTable.id.toString()
        for (spellcasterLevel in spellsPerDayLevels.indices) {
            val params = arrayOf(spellsPerDayTableId, (spellcasterLevel + 1).toString())
            try {
                queryResult = db.rawQuery(SQL_GET_SPELLS_PER_DAY_LEVELS, params)
                queryResult.moveToFirst()
                while (!queryResult.isAfterLast()) {
                    val dataRow = queryResult.getDataRow()
                    spellsPerDayLevels[spellcasterLevel][0] = dataRow.getInt(0)
                    spellsPerDayLevels[spellcasterLevel][1] = dataRow.getInt(1)
                    spellsPerDayLevels[spellcasterLevel][2] = dataRow.getInt(2)
                    spellsPerDayLevels[spellcasterLevel][3] = dataRow.getInt(3)
                    spellsPerDayLevels[spellcasterLevel][4] = dataRow.getInt(4)
                    spellsPerDayLevels[spellcasterLevel][5] = dataRow.getInt(5)
                    spellsPerDayLevels[spellcasterLevel][6] = dataRow.getInt(6)
                    spellsPerDayLevels[spellcasterLevel][7] = dataRow.getInt(7)
                    spellsPerDayLevels[spellcasterLevel][8] = dataRow.getInt(8)
                    spellsPerDayLevels[spellcasterLevel][9] = dataRow.getInt(9)
                    queryResult.moveToNext()
                }
            } catch (sqlException: SQLException) {
                //                Logger.error("Can't get spells per day levels", sqlException);
            } finally {
                queryResult?.close()
            }
        }
        return spellsPerDayLevels
    }


}