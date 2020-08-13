package com.d20charactersheet.framework.dac.dao.jdbc

import com.d20charactersheet.framework.boc.model.KnownSpellsTable
import com.d20charactersheet.framework.boc.model.Spell
import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable
import com.d20charactersheet.framework.dac.dao.SpelllistDao
import java.sql.Connection

class JdbcSpelllistDao(connection: Connection) : SpelllistDao {

    override fun getAllSpelllists(allSpells: MutableList<Spell>?): MutableList<Spelllist> {
        return mutableListOf()
    }

    override fun createSpelllevel(spelllist: Spelllist?, spell: Spell?, level: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllSpellsPerDayTables(): MutableList<SpellsPerDayTable> {
        return mutableListOf()
    }

    override fun deleteSpelllist(spelllist: Spelllist?) {
        TODO("Not yet implemented")
    }

    override fun getAllSpells(): MutableList<Spell> {
        return mutableListOf()
    }

    override fun createSpelllist(spelllist: Spelllist?): Spelllist {
        TODO("Not yet implemented")
    }

    override fun updateSpelllist(spelllist: Spelllist?) {
        TODO("Not yet implemented")
    }

    override fun getSpellDescription(spellId: Int): String {
        TODO("Not yet implemented")
    }

    override fun deleteSpell(spell: Spell?) {
        TODO("Not yet implemented")
    }

    override fun updateSpell(spell: Spell?) {
        TODO("Not yet implemented")
    }

    override fun createSpell(spell: Spell?): Spell {
        TODO("Not yet implemented")
    }

    override fun updateSpelllevel(spelllist: Spelllist?, spell: Spell?, level: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllKnownSpellsTables(): MutableList<KnownSpellsTable> {
        return mutableListOf()
    }

    override fun deleteSpelllevel(spelllist: Spelllist?, spell: Spell?) {
        TODO("Not yet implemented")
    }

}
