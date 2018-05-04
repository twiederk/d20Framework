package com.d20charactersheet.framework.boc.service;

import java.io.File;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.service.exportimport.ImportReport;

/**
 * Exports characters to a xml file and imports characters from an xml file.
 */
public interface ExportImportService {

  /**
   * The file name prefix of a character xml file
   */
  public static final String EXPORT_CHARACTER_FILE_PREFIX = "d20cs_characters";

  /**
   * The file name prefix of a equipment xml file
   */
  public static final String EXPORT_EQUIPMENT_FILE_PREFIX = "d20cs_equipment";

  /**
   * The file name suffix of a xml file
   */
  public static final String EXPORT_FILE_SUFFIX = ".xml";

  /**
   * Exports the characters to a xml file.
   *
   * @param gameSystem
   *     The game system the characters belong to.
   * @param exportFile
   *     The file to export to.
   * @param characters
   *     The characters to exoprt.
   *
   * @return The file containing the exported data.
   *
   * @throws Exception
   *     Thrown if the export failed.
   */
  public File exportCharacters(GameSystem gameSystem, File exportFile, List<Character> characters) throws Exception;

  /**
   * Imports characters from a xml file into the given game system and returning an import report for each character.
   *
   * @param gameSystem
   *     The game system to import the characters to.
   * @param importFile
   *     The file to import the characters from.
   *
   * @return The import reports of each character.
   *
   * @throws Exception
   *     Thrown if the import failed.
   */
  public List<ImportReport<Character>> importCharacters(GameSystem gameSystem, File importFile) throws Exception;

  /**
   * Exports equipment to a xml file.
   *
   * @param gameSystem
   *     The game system the equipment belongs to.
   * @param exportFile
   *     The file to export to.
   * @param weapons
   *     The weapons to export.
   * @param armor
   *     The armor to export.
   * @param goods
   *     The goods to export.
   *
   * @return The file containing the exported equipment.
   *
   * @throws Exception
   *     Thrown if the export failed.
   */
  public File exportEquipment(GameSystem gameSystem, File exportFile, List<Weapon> weapons, List<Armor> armor, List<Good> goods)
      throws Exception;

  /**
   * Imports equipment from a xml file int the given game system. Returns a list of import reports.
   *
   * @param gameSystem
   *     The game system to import the equipment to.
   * @param importFile
   *     The file to import from.
   *
   * @return The list of import reports.
   *
   * @throws Exception
   *     Thrown if the import failed.
   */
  public List<ImportReport<? extends Item>> importEquipment(GameSystem gameSystem, File importFile) throws Exception;
}
