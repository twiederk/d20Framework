package com.d20charactersheet.framework.boc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Party of characters.
 */
public class Party {

  private final List<Character> members;

  /**
   * Creates a empty party.
   */
  public Party() {
    members = new ArrayList<>();
  }

  /**
   * Returns all members of the party.
   *
   * @return All party members.
   */
  public List<Character> getMembers() {
    return members;
  }

  /**
   * Adds a character to the party. Each character can be added only once.
   *
   * @param character
   *     The characer to add.
   */
  public void add(final Character character) {
    if (!members.contains(character)) {
      members.add(character);
    }
  }

  /**
   * Removes the character from the party.
   *
   * @param character
   *     The character to remove.
   */
  public void remove(final Character character) {
    members.remove(character);
  }
}
