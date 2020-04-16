package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.ArrayList;
import java.util.List;

import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.XpDao;

/**
 * Implements XpDao in memory.
 */
public class DummyXpDao implements XpDao {

  private final DataTable xpTablesTable;
  private final DataTable xpLevelsTable;

  /**
   * Instanciates DummyXpDao with data of XpStorage.
   *
   * @param xpTable
   *     Xp table raw data.
   * @param xpLevel
   *     Xp level raw data.
   */
  public DummyXpDao(final Object[][] xpTable, final Object[][] xpLevel) {
    xpTablesTable = new DataTable(xpTable);
    xpLevelsTable = new DataTable(xpLevel);
  }

  @Override
  public List<XpTable> getAllXpTables() {
    final List<XpTable> allXpTables = new ArrayList<>(xpTablesTable.getNumberOfRows());
    for (final DataRow dataRow : xpTablesTable) {
      final XpTable xpTable = new XpTable();
      xpTable.setId(dataRow.getId());
      xpTable.setName(dataRow.getString(1));
      xpTable.setLevelTable(selectLevelTable(xpTable));
      allXpTables.add(xpTable);

    }
    return allXpTables;
  }

  private int[] selectLevelTable(final XpTable xpTable) {
    final List<DataRow> dataRows = xpLevelsTable.select(1, xpTable.getId());
    final int[] levels = new int[dataRows.size()];
    for (final DataRow dataRow : dataRows) {
      levels[dataRow.getInt(2) - 1] = dataRow.getInt(3);
    }
    return levels;
  }
}
