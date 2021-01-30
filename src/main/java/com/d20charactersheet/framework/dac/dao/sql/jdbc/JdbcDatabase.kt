package com.d20charactersheet.framework.dac.dao.sql.jdbc

import com.d20charactersheet.framework.dac.dao.sql.ContentValues
import com.d20charactersheet.framework.dac.dao.sql.Database
import com.d20charactersheet.framework.dac.dao.sql.QueryResult
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.DELETE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.INSERT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.INTO
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SET
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.UPDATE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.VALUES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE
import java.sql.Connection
import java.sql.ResultSet

class JdbcDatabase(private val connection: Connection) : Database {

    override fun queryId(sql: String, rowId: Long): Int {
        rawQuery(sql, arrayOf(Long.toString()))
        val statement = connection.createStatement()
        val generatedKeys = statement.executeQuery("$SELECT last_insert_rowid()")
        generatedKeys.next()
        return generatedKeys.getLong(1).toInt()
    }

    override fun rawQuery(sql: String, params: Array<String>): QueryResult {
        val prepareStatement = connection.prepareStatement(sql)
        params.forEachIndexed { index, arg -> prepareStatement.setString(index + 1, arg) }
        val resultSet: ResultSet = prepareStatement.executeQuery()
        return JdbcQueryResult(resultSet)
    }

    override fun update(tableName: String, contentValues: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        val sql = "$UPDATE $tableName $SET ${contentValues.whereClause()} $WHERE $whereClause"

        val prepareStatement = connection.prepareStatement(sql)
        contentValues.values().forEachIndexed { index, value ->
            when (value) {
                is String -> prepareStatement.setString(index + 1, value)
                is Int -> prepareStatement.setInt(index + 1, value)
                is ByteArray -> prepareStatement.setBytes(index + 1, value)
                is Float -> prepareStatement.setFloat(index + 1, value)
                is Boolean -> prepareStatement.setBoolean(index + 1, value)
            }
        }

        whereArgs.forEachIndexed { index, arg -> prepareStatement.setString(contentValues.size() + index + 1, arg) }

        return prepareStatement.executeUpdate()
    }

    override fun delete(tableName: String, whereClause: String, whereArgs: Array<String>): Int {
        val sql = "$DELETE $FROM $tableName $WHERE $whereClause"
        val prepareStatement = connection.prepareStatement(sql)
        whereArgs.forEachIndexed { index, arg -> prepareStatement.setString(index + 1, arg) }
        return prepareStatement.executeUpdate()
    }

    override fun insertOrThrow(tableName: String, contentValues: ContentValues): Long {
        val sql = "$INSERT $INTO $tableName (${contentValues.columnNames()}) $VALUES (${contentValues.placeHolder()})"
        val prepareStatement = connection.prepareStatement(sql)
        contentValues.values().forEachIndexed { index, value ->
            when (value) {
                is String -> prepareStatement.setString(index + 1, value)
                is Int -> prepareStatement.setInt(index + 1, value)
                is ByteArray -> prepareStatement.setBytes(index + 1, value)
                is Float -> prepareStatement.setFloat(index + 1, value)
                is Boolean -> prepareStatement.setBoolean(index + 1, value)
            }
        }
        return prepareStatement.executeUpdate().toLong()
    }

}
