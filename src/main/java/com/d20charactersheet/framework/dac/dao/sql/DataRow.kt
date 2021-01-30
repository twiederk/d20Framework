package com.d20charactersheet.framework.dac.dao.sql

import java.sql.SQLException

interface DataRow {

    @Throws(SQLException::class)
    fun getInt(columnIndex: Int): Int

    @Throws(SQLException::class)
    fun getString(columnIndex: Int): String

    @Throws(SQLException::class)
    fun getFloat(columnIndex: Int): Float

    @Throws(SQLException::class)
    fun getBlob(columnIndex: Int): ByteArray

}
