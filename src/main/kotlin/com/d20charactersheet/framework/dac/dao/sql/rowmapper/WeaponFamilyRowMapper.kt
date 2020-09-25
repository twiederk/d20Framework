package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.WeaponFamily
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

class WeaponFamilyRowMapper : BaseRowMapper() {

    /**
     * Maps a data row to a new WeaponFamily instance.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val weaponFamily = WeaponFamily()
        weaponFamily.id = dataRow.getInt(0)
        weaponFamily.name = dataRow.getString(1)
        return weaponFamily
    }
}