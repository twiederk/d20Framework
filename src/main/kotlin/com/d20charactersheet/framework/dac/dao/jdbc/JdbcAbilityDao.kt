package com.d20charactersheet.framework.dac.dao.jdbc

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.KnownSpellsTable
import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityBuilderFactory
import com.d20charactersheet.framework.dac.dao.AbilityDao
import java.sql.Connection

class JdbcAbilityDao(connection: Connection) : AbilityDao {

    override fun createAbility(ability: Ability?): Ability {
        TODO("Not yet implemented")
    }

    override fun createAbilityBuilderFactory(allSpelllists: MutableList<Spelllist>?, allKnownSpellsTables: MutableList<KnownSpellsTable>?, allSpellsPerDayTables: MutableList<SpellsPerDayTable>?): AbilityBuilderFactory {
        TODO("Not yet implemented")
    }

    override fun getAllAbilities(allSpelllists: MutableList<Spelllist>?, allKnownSpellsTables: MutableList<KnownSpellsTable>?, allSpellsPerDayTables: MutableList<SpellsPerDayTable>?): MutableList<Ability> {
        return mutableListOf()
    }

    override fun deleteAbility(ability: Ability?) {
        TODO("Not yet implemented")
    }

    override fun updateAbility(ability: Ability?) {
        TODO("Not yet implemented")
    }

}
