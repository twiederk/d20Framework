package com.d20charactersheet.framework.dac.dao.sql.jdbc

import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.QueryResult
import java.sql.ResultSet

class JdbcQueryResult(private val resultSet: ResultSet) : QueryResult {

    override fun moveToFirst() {
        resultSet.next()
    }

    override fun isAfterLast(): Boolean {
        return resultSet.isAfterLast
    }

    override fun moveToNext() {
        resultSet.next()
    }

    override fun getDataRow(): DataRow {
        return JdbcDataRow(resultSet)
    }

    override fun close() {
        resultSet.close()
    }

}
