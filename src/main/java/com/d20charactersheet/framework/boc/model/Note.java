package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Note consists of the text, create date and belongs to a character.
 */
public class Note implements Serializable {

  private static final long serialVersionUID = 5253971379097169400L;

  private int id = -1;

  private String text;

  private Date date;

  /**
   * Returns the id of the note.
   *
   * @return The id of the note.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the note.
   *
   * @param id
   *     The id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the text of the note.
   *
   * @return The text of the note.
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the text of the note.
   *
   * @param text
   *     The text of the note.
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Returns the create date of the note.
   *
   * @return The create date of the note.
   */
  public Date getDate() {
    return date;
  }

  /**
   * Sets the create date of the note.
   *
   * @param date
   *     The create date of the note.
   */
  public void setDate(final Date date) {
    this.date = date;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /**
   * Notes are equal if their id is equal.
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Note other = (Note) obj;
    return id == other.id;
  }

  @Override
  public String toString() {
    return text;
  }
}
