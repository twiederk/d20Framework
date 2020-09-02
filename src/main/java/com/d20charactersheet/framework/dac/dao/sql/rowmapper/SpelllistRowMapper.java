package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import com.androidash.memorydb.DaoUtil;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps a data row to a new Spelllist instance.
 */
public class SpelllistRowMapper extends BaseRowMapper {

    private final DaoUtil daoUtil = new DaoUtil();

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final Spelllist spelllist = new Spelllist();
        spelllist.setId(dataRow.getInt(0));
        spelllist.setName(dataRow.getString(1));
        spelllist.setShortname(dataRow.getString(2));
        spelllist.setDomain(daoUtil.getBoolean(dataRow.getInt(3)));
        spelllist.setMinLevel(dataRow.getInt(4));
        spelllist.setMaxLevel(dataRow.getInt(5));
        return spelllist;
    }

}
