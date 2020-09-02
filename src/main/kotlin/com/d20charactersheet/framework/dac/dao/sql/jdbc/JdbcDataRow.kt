package com.d20charactersheet.framework.dac.dao.sql.jdbc

import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.ResultSet

class JdbcDataRow(private val resultSet: ResultSet) : DataRow {

    override fun getInt(columnIndex: Int): Int = resultSet.getInt(columnIndex + 1)

    override fun getString(columnIndex: Int): String = resultSet.getString(columnIndex + 1)

    override fun getFloat(columnIndex: Int): Float = resultSet.getFloat(columnIndex + 1)

    override fun getBlob(columnIndex: Int): ByteArray = resultSet.getBinaryStream(columnIndex + 1).readBytes()

}
