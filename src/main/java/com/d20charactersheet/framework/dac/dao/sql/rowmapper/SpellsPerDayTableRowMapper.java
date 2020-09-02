package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;
import com.d20charactersheet.framework.dac.dao.sql.RowMapper;

/**
 * Maps spell per day tables.
 */
public class SpellsPerDayTableRowMapper implements RowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final SpellsPerDayTable spellsPerDayTable = new SpellsPerDayTable();
        spellsPerDayTable.setId(dataRow.getInt(0));
        spellsPerDayTable.setName(dataRow.getString(1));
        return spellsPerDayTable;
    }

}
