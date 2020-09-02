package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.androidash.memorydb.DaoUtil;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;
import com.d20charactersheet.framework.dac.dao.sql.RowMapper;

/**
 * Maps raw data to SpellSlot instance.
 */
public class SpellSlotRowMapper implements RowMapper {

    private final List<Spell> allSpells;
    private final DaoUtil daoUtil;

    /**
     * Instantiates Mapper for spell slots.
     *
     * @param allSpells
     *     All spells of the game system.
     */
    public SpellSlotRowMapper(final List<Spell> allSpells) {
        this.allSpells = allSpells;
        daoUtil = new DaoUtil();
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final SpellSlot spellSlot = new SpellSlot();
        spellSlot.setId(dataRow.getInt(0));
        spellSlot.setSpell(getSpellOfSpellSlot(dataRow.getInt(1)));
        spellSlot.setLevel(dataRow.getInt(2));
        spellSlot.setCast(daoUtil.getBoolean(dataRow.getInt(3)));
        return spellSlot;
    }

    private Spell getSpellOfSpellSlot(final int spellId) {
        if (spellId == SpellSlot.EMPTY_SPELL.getId()) {
            return SpellSlot.EMPTY_SPELL;
        }
        return getSpell(spellId, allSpells);
    }

    private Spell getSpell(final int spellId, final List<Spell> allSpells) {
        for (final Spell spell : allSpells) {
            if (spell.getId() == spellId) {
                return spell;
            }
        }
        throw new IllegalArgumentException("Can't find spell with id: " + spellId);
    }

}
