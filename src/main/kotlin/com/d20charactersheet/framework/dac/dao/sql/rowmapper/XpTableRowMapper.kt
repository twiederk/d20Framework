package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.XpTable
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

class XpTableRowMapper : BaseRowMapper() {

    /**
     * Maps a data row to a new XpTable instance.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val xpTable = XpTable()
        xpTable.id = dataRow.getInt(0)
        xpTable.name = dataRow.getString(1)
        return xpTable
    }
}