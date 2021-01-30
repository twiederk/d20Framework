package com.d20charactersheet.framework.dac.dao.sql

import java.sql.SQLException

interface Database {

    fun queryId(sql: String, rowId: Long): Int

    @Throws(SQLException::class)
    fun rawQuery(sql: String, params: Array<String>): QueryResult

    fun update(tableName: String, contentValues: ContentValues, whereClause: String, whereArgs: Array<String>): Int

    fun delete(tableName: String, whereClause: String, whereArgs: Array<String>): Int

    fun insertOrThrow(tableName: String, contentValues: ContentValues): Long

    companion object {
        const val DB_LOCK = "DB_LOCK"
    }

}