package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Note
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Creates a new NoteRowMapper with the given date pattern to convert the String into Date.
 *
 * @param datePattern
 * The pattern to convert the Sting into Date.
 */
class NoteRowMapper(datePattern: String) : BaseRowMapper() {
    private val dateFormat: DateFormat

    init {
        dateFormat = SimpleDateFormat(datePattern, Locale.getDefault())
    }

    /**
     * Maps a data row to a new note instance. The date of the note is stored as text in the database with the format given
     * in CharacterDao.DATE_FORMAT (yyyy-MM-dd HH:mm:ss.SSS).
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, date, text
        val note = Note()
        note.id = dataRow.getInt(0)
        note.date = parseDate(dataRow.getString(1), dateFormat)
        note.text = dataRow.getString(2)
        return note
    }

}