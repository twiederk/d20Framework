package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;
import com.d20charactersheet.framework.dac.dao.util.SpellSerializor;

/**
 * Maps a data row to a spell.
 */
public class SpellRowMapper extends BaseRowMapper {

    private final SpellSerializor spellSerializor = new SpellSerializor();

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        // id, name, components, casting_time, range, effect, duraction, saving_throw, spell_resistance,
        // short_description, description, mat_component, focus
        final Spell spell = new Spell();
        spell.setId(dataRow.getInt(0));
        spell.setName(dataRow.getString(1));
        setSchools(spell, dataRow.getString(2));
        setComponents(spell, dataRow.getInt(3));
        spell.setCastingTime(spellSerializor.deserializeCastingTime(dataRow.getString(4)));
        spell.setRange(spellSerializor.deserializeRange(dataRow.getString(5)));
        spell.setEffect(dataRow.getString(6));
        spell.setDuration(dataRow.getString(7));
        spell.setSavingThrow(dataRow.getString(8));
        spell.setSpellResistance(spellSerializor.deserializeSpellResistance(dataRow.getString(9)));
        spell.setShortDescription(dataRow.getString(10));
        spell.setMaterialComponent(dataRow.getString(11));
        spell.setFocus(dataRow.getString(12));
        return spell;
    }

    private void setSchools(final Spell spell, final String data) {
        spell.setSchool(spellSerializor.deserializeSchool(data));
        spell.setSubSchool(spellSerializor.deserializeSubSchool(data));
        spell.setDescriptors(spellSerializor.deserializeDescriptors(data));
    }

    private void setComponents(final Spell spell, final int components) {
        spell.setVerbal(isSet(components, 0));
        spell.setSomatic(isSet(components, 1));
        spell.setMaterial(isSet(components, 2));
        spell.setFocus(isSet(components, 3));
        spell.setDivineFocus(isSet(components, 4));
        spell.setXpCost(isSet(components, 5));

    }

    private boolean isSet(final int components, final int position) {
        final int mask = 1 << position;
        return (components & mask) > 0;
    }

}
