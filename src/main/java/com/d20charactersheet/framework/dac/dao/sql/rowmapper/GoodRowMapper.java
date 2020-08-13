package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps a good from database to Good object.
 */
public class GoodRowMapper extends BaseRowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        // good.id, good_text.name, cost, weight, good_type_id
        final Good good = new Good();
        good.setId(dataRow.getInt(0));
        good.setName(dataRow.getString(1));
        good.setDescription(dataRow.getString(2));
        good.setCost(dataRow.getFloat(3));
        good.setWeight(dataRow.getFloat(4));
        good.setGoodType((GoodType) getEnum(dataRow.getInt(5), GoodType.values()));
        good.setQualityType(getQualityType(dataRow.getInt(6)));
        return good;
    }

}
