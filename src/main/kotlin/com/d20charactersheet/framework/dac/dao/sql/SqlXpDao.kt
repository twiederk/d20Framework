package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.XpTable
import com.d20charactersheet.framework.dac.dao.XpDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_XP_TABLES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_XP_LEVELS
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.XpTableRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Create data access object to access xp tables in SQLite3 database.
 *  Instantiates SQLiteXpDao.
 *
 * @param db
 * The database to access.
 */
class SqlXpDao(private val db: Database) : XpDao {

    override fun getAllXpTables(): List<XpTable> {
        val allXpTables: MutableList<XpTable> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val xpTableRowMapper: RowMapper = XpTableRowMapper()
            queryResult = db.rawQuery(SQL_GET_ALL_XP_TABLES, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val xpTable = xpTableRowMapper.mapRow(queryResult.getDataRow()) as XpTable
                val levels = selectLevels(xpTable)
                xpTable.setLevelTable(levels)
                allXpTables.add(xpTable)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all xp tables", sqlException);
        } finally {
            queryResult?.close()
        }
        return allXpTables
    }

    private fun selectLevels(xpTable: XpTable): IntArray {
        var queryResult: QueryResult? = null
        val levelList: MutableList<Int> = mutableListOf()
        try {
            val xpTableId = arrayOf(xpTable.id.toString())
            queryResult = db.rawQuery(SQL_GET_XP_LEVELS, xpTableId)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                levelList.add(queryResult.getDataRow().getInt(0) - 1, queryResult.getDataRow().getInt(1))
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all xp tables", sqlException);
        } finally {
            queryResult?.close()
        }

        // convert from List<Integer> to int[]
        val levels = IntArray(levelList.size)
        for (i in levels.indices) {
            levels[i] = levelList[i]
        }
        return levels
    }

}