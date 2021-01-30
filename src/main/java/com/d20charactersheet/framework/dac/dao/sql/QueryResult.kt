package com.d20charactersheet.framework.dac.dao.sql

interface QueryResult {

    fun moveToFirst()
    fun isAfterLast(): Boolean
    fun moveToNext()
    fun getDataRow(): DataRow
    fun close()

}