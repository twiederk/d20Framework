package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.KnownSpellsTable
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper
import java.sql.SQLException

/**
 * Maps raw data to known spells table.
 */
class KnownSpellsTableRowMapper : RowMapper {

    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val knownSpellsTable = KnownSpellsTable()
        knownSpellsTable.id = dataRow.getInt(0)
        knownSpellsTable.name = dataRow.getString(1)
        return knownSpellsTable
    }
}