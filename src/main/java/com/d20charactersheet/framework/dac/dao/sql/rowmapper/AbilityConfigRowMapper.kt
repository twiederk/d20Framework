package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.AbilityType
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityConfig
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps a data row to a ability instance.
 */
class AbilityConfigRowMapper : BaseRowMapper() {

    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val abilityConfig = AbilityConfig()
        abilityConfig.id = dataRow.getInt(0)
        abilityConfig.name = dataRow.getString(1)
        abilityConfig.description = dataRow.getString(2)
        abilityConfig.abilityType = AbilityType.values()[dataRow.getInt(3)]
        abilityConfig.classname = dataRow.getString(4)
        return abilityConfig
    }
}
