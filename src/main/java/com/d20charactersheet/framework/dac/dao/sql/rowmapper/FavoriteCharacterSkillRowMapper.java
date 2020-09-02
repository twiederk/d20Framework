package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.FavoriteCharacterSkill;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps the character dependent data to a skill.
 */
public class FavoriteCharacterSkillRowMapper extends CharacterSkillRowMapper {

    /**
     * Creates a CharacterSkillRowMapper mapping data to character skills. The list of all skills is necessary to create
     * the CharacterSkill with the skill of the game system.
     *
     * @param allSkills
     *     All skills of the game system.
     */
    public FavoriteCharacterSkillRowMapper(final List<Skill> allSkills) {
        super(allSkills);
    }

    /**
     * Maps the character dependent data to a skill.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // skill_id, rank, misc_modifier, favorite
        final Skill skill = getSkill(dataRow.getInt(0));
        final FavoriteCharacterSkill characterSkill = new FavoriteCharacterSkill(skill);
        characterSkill.setRank(dataRow.getFloat(1));
        characterSkill.setModifier(dataRow.getInt(2));
        characterSkill.setFavorite(getBoolean(dataRow.getInt(3)));
        return characterSkill;
    }

}
