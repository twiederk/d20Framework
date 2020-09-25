package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.CharacterAbility
import com.d20charactersheet.framework.boc.model.ClassAbility
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Creates CharacterAbilityRowMapper with list of all available class abilities.
 *
 * @param classAbilities
 * List of all available class abilities
 */
class CharacterAbilityRowMapper(private val classAbilities: List<ClassAbility>) : BaseRowMapper() {

    /**
     * Maps data row to new CharacterAbility instance.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, ability_id, owned
        val characterAbility = CharacterAbility()
        characterAbility.id = dataRow.getInt(0)
        characterAbility.classAbility = getClassAbility(dataRow.getInt(1))
        characterAbility.isOwned = getBoolean(dataRow.getInt(2))
        return characterAbility
    }

    private fun getClassAbility(abilityId: Int): ClassAbility {
        for (classAbility in classAbilities) {
            if (classAbility.ability.id == abilityId) {
                return classAbility
            }
        }
        throw IllegalArgumentException("Can't find ability of id: $abilityId")
    }
}