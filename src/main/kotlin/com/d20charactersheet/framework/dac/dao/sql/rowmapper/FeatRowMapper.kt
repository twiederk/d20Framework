package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Feat
import com.d20charactersheet.framework.boc.model.FeatType
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

class FeatRowMapper : BaseRowMapper() {

    /**
     * Maps a row of feat data to a StaticFeat object.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // feat.id, feat.feat_type_id, feat_text.name, feat_text.prerequisit, feat_text.benefit, feat.fighter,
        // feat.multiple, feat.stack
        val feat = Feat()
        feat.id = dataRow.getInt(0)
        feat.name = dataRow.getString(1)
        feat.prerequisit = dataRow.getString(2)
        feat.benefit = dataRow.getString(3)
        feat.featType = FeatType.values()[dataRow.getInt(4)]
        feat.isFighterBonus = getBoolean(dataRow.getInt(5))
        feat.isMultiple = getBoolean(dataRow.getInt(6))
        feat.isStack = getBoolean(dataRow.getInt(7))
        feat.spellSlot = dataRow.getInt(8)
        return feat
    }
}