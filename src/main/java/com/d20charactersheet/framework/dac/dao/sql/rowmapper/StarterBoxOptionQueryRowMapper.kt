package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.EquipmentType
import com.d20charactersheet.framework.boc.model.StarterPackQuery
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper

class StarterBoxOptionQueryRowMapper : RowMapper {

    override fun mapRow(dataRow: DataRow): StarterPackQuery {
        return StarterPackQuery(
            id = dataRow.getInt(0),
            optionId = dataRow.getInt(1),
            equipmentType = EquipmentType.values()[dataRow.getInt(2)],
            typeId = dataRow.getInt(3),
            combatId = dataRow.getInt(4),
            itemId = dataRow.getInt(5),
            quantity = dataRow.getInt(6),
        )
    }

}
