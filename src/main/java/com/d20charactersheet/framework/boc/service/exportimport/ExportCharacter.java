package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Character;

/**
 * Exports characters to a file.
 */
public interface ExportCharacter {

  /**
   * Exports the given list of characters of the given game system to the given file location.
   *
   * @param gameSystemName
   *     The name of the game system the characters belong to.
   * @param exportFile
   *     The file to export the characters to
   * @param characters
   *     The characters to export.
   *
   * @throws Exception
   *     Thrown if the export fails.
   */
  public void exportCharacters(String gameSystemName, final File exportFile, List<Character> characters) throws Exception;

}
