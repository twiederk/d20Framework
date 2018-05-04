package com.d20charactersheet.framework.boc.service.exportimport;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Character;

/**
 * Imports characters.
 */
public interface ImportCharacter {

  /**
   * Imports characters and returns an import report for each character.
   *
   * @return The import reports for each character.
   *
   * @throws Exception
   *     Thrown if the import failed.
   */
  List<ImportReport<Character>> importCharacters() throws Exception;

}
