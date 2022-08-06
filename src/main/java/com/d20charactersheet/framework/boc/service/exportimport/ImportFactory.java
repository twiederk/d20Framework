package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;
import java.io.InputStream;

/**
 * Provides proper import implementation based on the version of the import file.
 */
public interface ImportFactory {

  /**
   * Provides proper import implementation based on the version of the import file.
   *
   * @param importContext
   *     Contains all data of the game system required for import.
   * @param importFile
   *     The file to import.
   *
   * @return The implemention to import the file.
   *
   * @throws Exception
   *     Thrown if the game system and file doesn't match or no import implementation is available.
   */
  ImportCharacter getImportCharacter(ImportContext importContext, File importFile) throws Exception;

  /**
   * Provides proper import implementation based on the version of the import file.
   *
   * @param importContext
   *     Contains all data of the game system required for import.
   * @param inputStream
   *     The stream to import.
   *
   * @return The implemention to import the file.
   *
   * @throws Exception
   *     Thrown if the game system and file doesn't match or no import implementation is available.
   */
  ImportCharacter getImportCharacter(ImportContext importContext, InputStream inputStream) throws Exception;

  /**
   * Returns proper import implementation for equipment based on the version of the import file.
   *
   * @param importContext
   *     Contains all data necessary to import equipment.
   * @param importFile
   *     The file to import.
   *
   * @return The equipment importer.
   *
   * @throws Exception
   *     Thrown if the game system and file doesn't match or no import implementation is available.
   */
  ImportEquipment getImportEquipment(ImportContext importContext, File importFile) throws Exception;

  /**
   * Returns proper import implementation for equipment based on the version of the import file.
   *
   * @param importContext
   *     Contains all data necessary to import equipment.
   * @param importStream
   *     The stream to import.
   *
   * @return The equipment importer.
   *
   * @throws Exception
   *     Thrown if the game system and file doesn't match or no import implementation is available.
   */
  ImportEquipment getImportEquipment(ImportContext importContext, InputStream importStream) throws Exception;

}
