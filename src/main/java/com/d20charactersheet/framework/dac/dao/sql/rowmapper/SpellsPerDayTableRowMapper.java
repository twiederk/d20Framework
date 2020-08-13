package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.dao.DataRow;
import com.d20charactersheet.framework.dac.dao.RowMapper;

/**
 * Maps spell per day tables.
 */
public class SpellsPerDayTableRowMapper implements RowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        final SpellsPerDayTable spellsPerDayTable = new SpellsPerDayTable();
        spellsPerDayTable.setId(dataRow.getInt(0));
        spellsPerDayTable.setName(dataRow.getString(1));
        return spellsPerDayTable;
    }

}
