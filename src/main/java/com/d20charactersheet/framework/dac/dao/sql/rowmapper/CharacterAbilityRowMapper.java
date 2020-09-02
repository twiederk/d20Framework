package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps data row to new CharacterAbility instance.
 */
public class CharacterAbilityRowMapper extends BaseRowMapper {

    private final List<ClassAbility> classAbilities;

    /**
     * Creates CharacterAbilityRowMapper with list of all available class abilities.
     *
     * @param classAbilities
     *     List of all available class abilities
     */
    public CharacterAbilityRowMapper(final List<ClassAbility> classAbilities) {
        super();
        this.classAbilities = classAbilities;
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // id, ability_id, owned
        final CharacterAbility characterAbility = new CharacterAbility();
        characterAbility.setId(dataRow.getInt(0));
        characterAbility.setClassAbility(getClassAbility(dataRow.getInt(1)));
        characterAbility.setOwned(getBoolean(dataRow.getInt(2)));
        return characterAbility;
    }

    private ClassAbility getClassAbility(final int abilityId) {
        for (final ClassAbility classAbility : classAbilities) {
            if (classAbility.getAbility().getId() == abilityId) {
                return classAbility;
            }
        }
        throw new IllegalArgumentException("Can't find ability of id: " + abilityId);
    }

}
