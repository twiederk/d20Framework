package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps character independent skill data to a skill.
 */
public class SkillRowMapper extends BaseRowMapper {

    /**
     * Maps character independent skill data to a skill.
     */
    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        final Skill skill = new Skill();
        skill.setId(dataRow.getInt(0));
        skill.setAttribute((Attribute) getEnum(dataRow.getInt(1), Attribute.values()));
        skill.setUntrained(getBoolean(dataRow.getInt(2)));
        skill.setName(dataRow.getString(3));
        return skill;
    }
}
