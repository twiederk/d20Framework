package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.ArmorType
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Maps an armor from the persistent layer to an Armor object.
 */
class ArmorRowMapper : BaseRowMapper() {

    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // armor.id, armor_text.name, cost, weight, armor_bonus, armor_penalty, armor_type_id
        val armor = Armor()
        armor.id = dataRow.getInt(0)
        armor.name = dataRow.getString(1)
        armor.description = dataRow.getString(2)
        armor.cost = dataRow.getFloat(3)
        armor.weight = dataRow.getFloat(4)
        armor.armorBonus = dataRow.getInt(5)
        armor.armorCheckPenalty = dataRow.getInt(6)
        armor.armorType = ArmorType.values()[dataRow.getInt(7)]
        armor.qualityType = getQualityType(dataRow.getInt(8))
        return armor
    }
}