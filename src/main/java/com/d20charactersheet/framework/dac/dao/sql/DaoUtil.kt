package com.d20charactersheet.framework.dac.dao.sql

class DaoUtil {

    fun getBoolean(booleanId: Int): Boolean = booleanId != 0

    fun setBoolean(value: Boolean): Int = if (value) 1 else 0

}