package com.d20charactersheet.framework.dac.dao

interface DataRow {

    fun getInt(columnIndex: Int): Int

    fun getString(columnIndex: Int): String

    fun getFloat(columnIndex: Int): Float

}
