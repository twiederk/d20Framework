package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Creates ClassAbility instances read from data rows.
 */
public class ClassAbilityRowMapper extends BaseRowMapper {

    private final List<Ability> allAbilities;

    /**
     * Creates ClassAbilityRowMapper with all class abilities.
     *
     * @param allAbilities
     *     All class abilities.
     */
    public ClassAbilityRowMapper(final List<Ability> allAbilities) {
        super();
        this.allAbilities = allAbilities;
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final Ability ability = getAbility(dataRow.getInt(0));
        final ClassAbility classAbility = new ClassAbility(ability);
        classAbility.setLevel(dataRow.getInt(1));
        return classAbility;
    }

    private Ability getAbility(final int abilityId) {
        for (final Ability ability : allAbilities) {
            if (ability.getId() == abilityId) {
                return ability;
            }
        }
        throw new RuntimeException("Can't determine ability with id: " + abilityId);
    }

}
