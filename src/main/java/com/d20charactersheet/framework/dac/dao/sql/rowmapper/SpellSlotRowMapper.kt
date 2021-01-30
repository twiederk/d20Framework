package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Spell
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.dac.dao.sql.DaoUtil
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.RowMapper
import java.sql.SQLException

/**
 * Instantiates Mapper for spell slots.
 *
 * @param allSpells
 * All spells of the game system.
 */
class SpellSlotRowMapper(private val allSpells: List<Spell>) : RowMapper {

    private val daoUtil: DaoUtil = DaoUtil()

    /**
     * Maps raw data to SpellSlot instance.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        val spellSlot = SpellSlot()
        spellSlot.id = dataRow.getInt(0)
        spellSlot.spell = getSpellOfSpellSlot(dataRow.getInt(1))
        spellSlot.level = dataRow.getInt(2)
        spellSlot.isCast = daoUtil.getBoolean(dataRow.getInt(3))
        return spellSlot
    }

    private fun getSpellOfSpellSlot(spellId: Int): Spell {
        return if (spellId == SpellSlot.EMPTY_SPELL.id) {
            SpellSlot.EMPTY_SPELL
        } else getSpell(spellId, allSpells)
    }

    private fun getSpell(spellId: Int, allSpells: List<Spell>): Spell {
        for (spell in allSpells) {
            if (spell.id == spellId) {
                return spell
            }
        }
        throw IllegalArgumentException("Can't find spell with id: $spellId")
    }

}