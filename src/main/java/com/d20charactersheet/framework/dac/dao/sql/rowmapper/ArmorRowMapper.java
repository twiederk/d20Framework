package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.dac.dao.BaseRowMapper;
import com.d20charactersheet.framework.dac.dao.DataRow;

/**
 * Maps an armor from the persistent layer to an Armor object.
 */
public class ArmorRowMapper extends BaseRowMapper {

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws java.sql.SQLException {
        // armor.id, armor_text.name, cost, weight, armor_bonus, armor_penalty, armor_type_id
        final Armor armor = new Armor();
        armor.setId(dataRow.getInt(0));
        armor.setName(dataRow.getString(1));
        armor.setDescription(dataRow.getString(2));
        armor.setCost(dataRow.getFloat(3));
        armor.setWeight(dataRow.getFloat(4));
        armor.setArmorBonus(dataRow.getInt(5));
        armor.setArmorCheckPenalty(dataRow.getInt(6));
        armor.setArmorType((ArmorType) getEnum(dataRow.getInt(7), ArmorType.values()));
        armor.setQualityType(getQualityType(dataRow.getInt(8)));
        return armor;
    }

}
