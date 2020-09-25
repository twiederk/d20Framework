package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Good
import com.d20charactersheet.framework.boc.model.GoodType
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps a good from database to Good object.
 */
class GoodRowMapper : BaseRowMapper() {

    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // good.id, good_text.name, cost, weight, good_type_id
        val good = Good()
        good.id = dataRow.getInt(0)
        good.name = dataRow.getString(1)
        good.description = dataRow.getString(2)
        good.cost = dataRow.getFloat(3)
        good.weight = dataRow.getFloat(4)
        good.goodType = GoodType.values()[dataRow.getInt(5)]
        good.qualityType = getQualityType(dataRow.getInt(6))
        return good
    }
}