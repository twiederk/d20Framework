package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.FavoriteCharacterSkill
import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Creates a CharacterSkillRowMapper mapping data to character skills. The list of all skills is necessary to create
 * the CharacterSkill with the skill of the game system.
 *
 * @param allSkills
 * All skills of the game system.
 */
class FavoriteCharacterSkillRowMapper(allSkills: List<Skill>) : CharacterSkillRowMapper(allSkills) {

    /**
     * Maps the character dependent data to a skill.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // skill_id, rank, misc_modifier, favorite
        val skill = getSkill(dataRow.getInt(0))
        val characterSkill = FavoriteCharacterSkill(skill)
        characterSkill.rank = dataRow.getFloat(1)
        characterSkill.modifier = dataRow.getInt(2)
        characterSkill.isFavorite = getBoolean(dataRow.getInt(3))
        return characterSkill
    }
}