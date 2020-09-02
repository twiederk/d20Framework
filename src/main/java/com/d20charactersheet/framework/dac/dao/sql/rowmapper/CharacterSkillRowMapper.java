package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps the character dependent data to a skill.
 */
public class CharacterSkillRowMapper extends BaseRowMapper {

    private final List<Skill> allSkills;

    /**
     * Creates a CharacterSkillRowMapper mapping data to character skills. The list of all skills is necessary to create
     * the CharacterSkill with the skill of the game system.
     *
     * @param allSkills
     *     All skills of the game system.
     */
    public CharacterSkillRowMapper(final List<Skill> allSkills) {
        super();
        this.allSkills = allSkills;
    }

    /**
     * Maps the character dependent data to a skill.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // skill_id, rank, misc_modifier, favorite
        final Skill skill = getSkill(dataRow.getInt(0));
        final CharacterSkill characterSkill = new CharacterSkill(skill);
        characterSkill.setRank(dataRow.getFloat(1));
        characterSkill.setModifier(dataRow.getInt(2));
        return characterSkill;
    }

    protected Skill getSkill(final int id) {
        for (final Skill skill : allSkills) {
            if (skill.getId() == id) {
                return skill;
            }
        }
        throw new IllegalArgumentException("Can't get skill with id: " + id);
    }

}
