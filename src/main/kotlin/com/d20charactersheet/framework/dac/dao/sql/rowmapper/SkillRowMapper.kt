package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps character independent skill data to a skill.
 */
class SkillRowMapper : BaseRowMapper() {

    /**
     * Maps character independent skill data to a skill.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val skill = Skill()
        skill.id = dataRow.getInt(0)
        skill.attribute = Attribute.values()[dataRow.getInt(1)]
        skill.isUntrained = getBoolean(dataRow.getInt(2))
        skill.name = dataRow.getString(3)
        return skill
    }
}