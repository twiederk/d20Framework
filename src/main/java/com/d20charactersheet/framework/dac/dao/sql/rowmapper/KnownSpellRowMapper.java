package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;
import com.d20charactersheet.framework.dac.dao.sql.RowMapper;

/**
 * Maps raw data to KnownSpell class.
 */
public class KnownSpellRowMapper implements RowMapper {

    private final List<Spell> allSpells;
    private final List<Spelllist> allSpelllists;

    /**
     * Instantiates KnownSpellRowMapper with all spell lists and spells of the game system.
     *
     * @param allSpelllists
     *     All spell lists of the game system.
     * @param allSpells
     *     All spells of the game system.
     */
    public KnownSpellRowMapper(final List<Spelllist> allSpelllists, final List<Spell> allSpells) {
        this.allSpelllists = allSpelllists;
        this.allSpells = allSpells;
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final KnownSpell knownSpell = new KnownSpell();
        knownSpell.setId(dataRow.getInt(0));
        knownSpell.setSpelllist(getSpelllist(dataRow.getInt(1)));
        knownSpell.setSpell(getSpell(dataRow.getInt(2)));
        return knownSpell;
    }

    private Spelllist getSpelllist(final int spelllistId) {
        for (final Spelllist spelllist : allSpelllists) {
            if (spelllist.getId() == spelllistId) {
                return spelllist;
            }
        }
        return null;
    }

    private Spell getSpell(final int spellId) {
        for (final Spell spell : allSpells) {
            if (spell.getId() == spellId) {
                return spell;
            }
        }
        throw new IllegalArgumentException("Can't find spell with id: " + spellId);
    }

}
