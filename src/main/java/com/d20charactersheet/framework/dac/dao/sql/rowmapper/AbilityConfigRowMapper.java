package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityConfig;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps a data row to a ability instance.
 */
public class AbilityConfigRowMapper extends BaseRowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final AbilityConfig abilityConfig = new AbilityConfig();
        abilityConfig.setId(dataRow.getInt(0));
        abilityConfig.setName(dataRow.getString(1));
        abilityConfig.setDescription(dataRow.getString(2));
        abilityConfig.setAbilityType((AbilityType) getEnum(dataRow.getInt(3), AbilityType.values()));
        abilityConfig.setClassname(dataRow.getString(4));
        return abilityConfig;
    }

}
