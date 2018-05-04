package com.d20charactersheet.framework.boc.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Note;

public class NoteComparatorTest {

  private static final String DATE_FORMAT_STRING = "dd.MM.yyyy";

  @Test
  public void testCompare() {
    final DateFormat dateFormat = getDateFormat();
    final Note note30 = createNote("30.20.2010", dateFormat);
    final Note note10 = createNote("10.12.2010", dateFormat);
    final Note note20 = createNote("20.12.2010", dateFormat);

    final List<Note> notes = new LinkedList<Note>();
    notes.add(note30);
    notes.add(note10);
    notes.add(note20);

    Collections.sort(notes, new NoteComparator());
    assertEquals(note30.getDate(), notes.get(0).getDate());
    assertEquals(note20.getDate(), notes.get(1).getDate());
    assertEquals(note10.getDate(), notes.get(2).getDate());
  }

  private DateFormat getDateFormat() {
    return new SimpleDateFormat(DATE_FORMAT_STRING);
  }

  private Note createNote(final String dateParameter, final DateFormat dateFormat) {
    final Note note = new Note();
    Date date;
    try {
      date = dateFormat.parse(dateParameter);
      note.setDate(date);
    } catch (final ParseException parseException) {
      parseException.printStackTrace();
      fail("Can't parse dateParameter: " + dateParameter);
    }
    return note;
  }

}
