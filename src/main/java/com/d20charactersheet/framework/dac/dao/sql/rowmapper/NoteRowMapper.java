package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps a data row to a new note instance. The date of the note is stored as text in the database with the format given
 * in CharacterDao.DATE_FORMAT (yyyy-MM-dd HH:mm:ss.SSS).
 */
public class NoteRowMapper extends BaseRowMapper {

    private final DateFormat dateFormat;

    /**
     * Creates a new NoteRowMapper with the given date pattern to convert the String into Date.
     *
     * @param datePattern
     *     The pattern to convert the Sting into Date.
     */
    public NoteRowMapper(final String datePattern) {
        super();
        dateFormat = new SimpleDateFormat(datePattern, Locale.getDefault());
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // id, date, text
        final Note note = new Note();
        note.setId(dataRow.getInt(0));
        note.setDate(parseDate(dataRow.getString(1), dateFormat));
        note.setText(dataRow.getString(2));
        return note;
    }

}
