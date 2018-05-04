package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Weapon;

/**
 * Exports the equipment of a game system to a file.
 */
public interface ExportEquipment {

  /**
   * Exports the given list of weapons, armor and goods of a game system to the given file.
   *
   * @param gameSystemName
   *     The name of the game system.
   * @param exportFile
   *     The file to export to.
   * @param weapons
   *     The weapons to export.
   * @param armor
   *     The armor to export.
   * @param goods
   *     The goods to export.
   *
   * @throws Exception
   *     Thrown if the export fails.
   */
  public void exportEquipment(String gameSystemName, File exportFile, List<Weapon> weapons, List<Armor> armor, List<Good> goods)
      throws Exception;

}
