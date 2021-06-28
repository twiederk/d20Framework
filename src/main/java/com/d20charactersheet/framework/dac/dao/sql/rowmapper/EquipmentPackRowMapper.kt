package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.EquipmentPack
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper

class EquipmentPackRowMapper : RowMapper {

    override fun mapRow(dataRow: DataRow): EquipmentPack {
        return EquipmentPack(
            id = dataRow.getInt(0),
            name = dataRow.getString(1)
        )
    }

}
