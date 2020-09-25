package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.ClassAbility
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Creates ClassAbilityRowMapper with all class abilities.
 *
 * @param allAbilities
 * All class abilities.
 */
class ClassAbilityRowMapper(private val allAbilities: List<Ability>) : BaseRowMapper() {

    /**
     * Creates ClassAbility instances read from data rows.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val ability = getAbility(dataRow.getInt(0))
        val classAbility = ClassAbility(ability)
        classAbility.level = dataRow.getInt(1)
        return classAbility
    }

    private fun getAbility(abilityId: Int): Ability {
        for (ability in allAbilities) {
            if (ability.id == abilityId) {
                return ability
            }
        }
        throw RuntimeException("Can't determine ability with id: $abilityId")
    }
}