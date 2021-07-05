package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.EquipmentType
import com.d20charactersheet.framework.boc.model.StarterPackQuery
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper

class StarterBoxOptionQueryRowMapper : RowMapper {

    override fun mapRow(dataRow: DataRow): StarterPackQuery {
        return StarterPackQuery(
            dataRow.getInt(0),
            dataRow.getInt(1),
            EquipmentType.values()[dataRow.getInt(2)],
            dataRow.getInt(3),
            dataRow.getInt(4),

            )
    }

}
