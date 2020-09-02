package com.d20charactersheet.framework.dac.dao.sql

class ContentValues {

    private val contentValues: MutableMap<String, Any?> = mutableMapOf()

    fun put(columnName: String, value: String) {
        contentValues[columnName] = value
    }

    fun put(columnName: String, value: Int) {
        contentValues[columnName] = value
    }

    fun put(columnName: String, value: Boolean) {
        contentValues[columnName] = value
    }

    fun put(columnName: String, value: ByteArray) {
        contentValues[columnName] = value
    }

    fun put(columnName: String, value: Float) {
        contentValues[columnName] = value
    }

    fun putNull(columnName: String) {
        contentValues[columnName] = null
    }

    fun whereClause(): String = contentValues.map { mapEntry -> "${mapEntry.key}=?" }.joinToString()

    fun values(): MutableCollection<Any?> = contentValues.values

    fun size(): Int = contentValues.size

    fun columnNames(): String = contentValues.keys.joinToString()

    fun placeHolder(): String = contentValues.values.joinToString(separator = ",", transform = { "?" })

    fun keys(): MutableSet<String> = contentValues.keys

    fun get(key: String): Any? = contentValues[key]

}