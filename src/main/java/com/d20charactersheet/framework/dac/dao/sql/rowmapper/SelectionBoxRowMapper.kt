package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.SelectionBox
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper

/**
 * Maps data to SelectionBox
 */
class SelectionBoxRowMapper : RowMapper {

    override fun mapRow(dataRow: DataRow): SelectionBox {
        return SelectionBox(
            id = dataRow.getInt(0),
            name = dataRow.getString(1)
        )
    }

}
