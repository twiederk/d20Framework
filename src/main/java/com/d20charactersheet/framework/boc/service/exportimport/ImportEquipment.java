package com.d20charactersheet.framework.boc.service.exportimport;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Item;

/**
 * Imports equipment.
 */
public interface ImportEquipment {

  /**
   * Imports equipment.
   *
   * @return List of import reports of the imported equipment.
   */
  List<ImportReport<? extends Item>> importEquipment();

}
