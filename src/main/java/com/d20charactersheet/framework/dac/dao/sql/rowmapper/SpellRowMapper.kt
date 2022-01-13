package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Spell
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import com.d20charactersheet.framework.dac.dao.sql.util.SpellSerializor
import java.sql.SQLException

class SpellRowMapper : BaseRowMapper() {
    private val spellSerializor = SpellSerializor()

    /**
     * Maps a data row to a spell.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, name, components, casting_time, range, effect, duraction, saving_throw, spell_resistance,
        // short_description, description, mat_component, focus
        val spell = Spell()
        spell.id = dataRow.getInt(0)
        spell.name = dataRow.getString(1)
        setSchools(spell, dataRow.getString(2))
        setComponents(spell, dataRow.getInt(3))
        spell.castingTime = spellSerializor.deserializeCastingTime(dataRow.getString(4))
        spell.range = dataRow.getString(5)
        spell.effect = dataRow.getString(6)
        spell.duration = dataRow.getString(7)
        spell.savingThrow = dataRow.getString(8)
        spell.spellResistance = spellSerializor.deserializeSpellResistance(dataRow.getString(9))
        spell.shortDescription = dataRow.getString(10)
        spell.materialComponent = dataRow.getString(11)
        spell.focus = dataRow.getString(12)
        return spell
    }

    private fun setSchools(spell: Spell, data: String) {
        spell.school = spellSerializor.deserializeSchool(data)
        spell.subSchool = spellSerializor.deserializeSubSchool(data)
        spell.descriptors = spellSerializor.deserializeDescriptors(data)
    }

    private fun setComponents(spell: Spell, components: Int) {
        spell.isVerbal = isSet(components, 0)
        spell.isSomatic = isSet(components, 1)
        spell.isMaterial = isSet(components, 2)
        spell.isFocus = isSet(components, 3)
        spell.isDivineFocus = isSet(components, 4)
        spell.isXpCost = isSet(components, 5)
    }

    private fun isSet(components: Int, position: Int): Boolean {
        val mask = 1 shl position
        return components and mask > 0
    }
}