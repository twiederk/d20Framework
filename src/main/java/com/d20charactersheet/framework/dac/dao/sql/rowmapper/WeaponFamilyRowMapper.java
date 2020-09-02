package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps a data row to a new WeaponFamily instance.
 */
public class WeaponFamilyRowMapper extends BaseRowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        final WeaponFamily weaponFamily = new WeaponFamily();
        weaponFamily.setId(dataRow.getInt(0));
        weaponFamily.setName(dataRow.getString(1));
        return weaponFamily;
    }

}
