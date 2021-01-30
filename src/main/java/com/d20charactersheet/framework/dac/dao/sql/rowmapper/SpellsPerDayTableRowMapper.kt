package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.SpellsPerDayTable
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper
import java.sql.SQLException

class SpellsPerDayTableRowMapper : RowMapper {

    /**
     * Maps spell per day tables.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val spellsPerDayTable = SpellsPerDayTable()
        spellsPerDayTable.id = dataRow.getInt(0)
        spellsPerDayTable.name = dataRow.getString(1)
        return spellsPerDayTable
    }
}