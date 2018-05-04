package com.d20charactersheet.framework.boc.util;

import java.io.Serializable;
import java.util.Comparator;

import com.d20charactersheet.framework.boc.model.Note;

/**
 * Sorting notes by creation date.
 */
public class NoteComparator implements Comparator<Note>, Serializable {

  private static final long serialVersionUID = -9048487739328623863L;

  @Override
  public int compare(final Note note0, final Note note1) {
    if (note0.getDate().before(note1.getDate())) {
      return +1;
    } else if (note0.getDate().after(note1.getDate())) {
      return -1;
    }
    return 0;
  }

}
