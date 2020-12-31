package com.d20charactersheet.framework.dac.dao.sql.jdbc

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement


class JdbcHelper {

    private val dbLock = Any()

    val connection: Connection = DriverManager.getConnection("jdbc:sqlite::memory:")

    fun executeSqlScript(sqlScriptName: String) {
        val sqlScripts = getSqlScriptsFromRawResource(sqlScriptName)
        synchronized(dbLock) {
            for (sqlScript in sqlScripts.filterNotNull()) {
//                print(sqlScript)
                if (sqlScript.trim { it <= ' ' }.isEmpty()) {
                    continue
                }
                try {
                    val statement: Statement = connection.createStatement()
                    statement.executeUpdate(sqlScript)
                } catch (sqlException: SQLException) {
                    println("Can't execute statement: $sqlScript")
                    sqlException.printStackTrace()
                }
            }
        }
    }

    private fun getSqlScriptsFromRawResource(sqlScriptName: String): Array<String?> {
        val sql = this::class.java.getResource(sqlScriptName).readText()
        return sql.split(";".toRegex()).toTypedArray()
    }

}