package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.dac.dao.DataRow;
import com.d20charactersheet.framework.dac.dao.RowMapper;

/**
 * Maps raw data to known spells table.
 */
public class KnownSpellsTableRowMapper implements RowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        final KnownSpellsTable knownSpellsTable = new KnownSpellsTable();
        knownSpellsTable.setId(dataRow.getInt(0));
        knownSpellsTable.setName(dataRow.getString(1));
        return knownSpellsTable;
    }

}
