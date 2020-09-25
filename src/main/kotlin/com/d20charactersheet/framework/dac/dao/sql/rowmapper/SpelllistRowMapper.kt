package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.dac.dao.sql.DaoUtil
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps a data row to a new Spelllist instance.
 */
class SpelllistRowMapper : BaseRowMapper() {

    private val daoUtil = DaoUtil()

    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val spelllist = Spelllist()
        spelllist.id = dataRow.getInt(0)
        spelllist.name = dataRow.getString(1)
        spelllist.shortname = dataRow.getString(2)
        spelllist.isDomain = daoUtil.getBoolean(dataRow.getInt(3))
        spelllist.minLevel = dataRow.getInt(4)
        spelllist.maxLevel = dataRow.getInt(5)
        return spelllist
    }
}