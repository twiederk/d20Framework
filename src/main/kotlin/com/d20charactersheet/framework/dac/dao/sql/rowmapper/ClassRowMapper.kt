package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

class ClassRowMapper : BaseRowMapper() {

    /**
     * Maps a data row to a character class.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, name, base_attack_bonus, saves, alignments, skill_points_per_level, hit_die_id
        val characterClass = CharacterClass()
        characterClass.id = dataRow.getInt(0)
        characterClass.name = dataRow.getString(1)
        val saves = getEnums(dataRow.getInt(2), Save::class.java)
        characterClass.saves = saves
        val alignments = getEnums(dataRow.getInt(3), Alignment::class.java)
        characterClass.alignments = alignments
        characterClass.baseAttackBonus = BaseAttackBonus.values()[dataRow.getInt(4)]
        characterClass.skillPointsPerLevel = dataRow.getInt(5)
        characterClass.hitDie = Die.values()[dataRow.getInt(6)]
        return characterClass
    }
}