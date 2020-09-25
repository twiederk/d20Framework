package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.KnownSpell
import com.d20charactersheet.framework.boc.model.Spell
import com.d20charactersheet.framework.boc.model.Spelllist
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper
import java.sql.SQLException

/**
 * Instantiates KnownSpellRowMapper with all spell lists and spells of the game system.
 *
 * @param allSpelllists
 * All spell lists of the game system.
 * @param allSpells
 * All spells of the game system.
 */
class KnownSpellRowMapper(private val allSpelllists: List<Spelllist>, private val allSpells: List<Spell>) : RowMapper {

    /**
     * Maps raw data to KnownSpell class.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val knownSpell = KnownSpell()
        knownSpell.id = dataRow.getInt(0)
        knownSpell.spelllist = getSpelllist(dataRow.getInt(1))
        knownSpell.spell = getSpell(dataRow.getInt(2))
        return knownSpell
    }

    private fun getSpelllist(spelllistId: Int): Spelllist? {
        for (spelllist in allSpelllists) {
            if (spelllist.id == spelllistId) {
                return spelllist
            }
        }
        return null
    }

    private fun getSpell(spellId: Int): Spell {
        for (spell in allSpells) {
            if (spell.id == spellId) {
                return spell
            }
        }
        throw IllegalArgumentException("Can't find spell with id: $spellId")
    }
}