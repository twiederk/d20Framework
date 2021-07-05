package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.StarterPackBox
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper

/**
 * Maps data to SelectionBox
 */
class StarterPackBoxRowMapper : RowMapper {

    override fun mapRow(dataRow: DataRow): StarterPackBox {
        return StarterPackBox(
            id = dataRow.getInt(0),
            name = dataRow.getString(1)
        )
    }

}
