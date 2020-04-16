package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.XpTable;

/**
 * Access object to persistent layer for xp tables.
 */
public interface XpDao {

  /**
   * Returns all xp tables from the persistent layer.
   *
   * @return All xp tables from the persistent layer.
   */
  List<XpTable> getAllXpTables();

}
