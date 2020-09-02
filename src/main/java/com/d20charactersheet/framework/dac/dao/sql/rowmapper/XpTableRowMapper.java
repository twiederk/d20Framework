package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps a data row to a new XpTable instance.
 */
public class XpTableRowMapper extends BaseRowMapper {

  @NotNull
  @Override
  public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
    final XpTable xpTable = new XpTable();
    xpTable.setId(dataRow.getInt(0));
    xpTable.setName(dataRow.getString(1));
    return xpTable;
  }

}
