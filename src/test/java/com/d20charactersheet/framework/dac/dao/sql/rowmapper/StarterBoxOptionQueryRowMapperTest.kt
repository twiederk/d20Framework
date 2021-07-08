package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.EquipmentType
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class StarterBoxOptionQueryRowMapperTest {

    @Test
    fun mapRow_singleArmor_typeArmorAndItemIdFilled() {
        // Arrange
        val dataRow: DataRow = mock()
        whenever(dataRow.getInt(0)) doReturn 1
        whenever(dataRow.getInt(1)) doReturn 2
        whenever(dataRow.getInt(2)) doReturn 1
        whenever(dataRow.getInt(5)) doReturn 3
        whenever(dataRow.getInt(6)) doReturn 4

        // Act
        val starterPackBoxOptionQuery = StarterBoxOptionQueryRowMapper().mapRow(dataRow)

        // Assert
//        id, starter_pack_box_option_id, equipment_tpye_id, type_id, combat_id, item_id, quantity
        assertThat(starterPackBoxOptionQuery.id).isEqualTo(1)
        assertThat(starterPackBoxOptionQuery.optionId).isEqualTo(2)
        assertThat(starterPackBoxOptionQuery.equipmentType).isEqualTo(EquipmentType.ARMOR)
        assertThat(starterPackBoxOptionQuery.itemId).isEqualTo(3)
        assertThat(starterPackBoxOptionQuery.quantity).isEqualTo(4)
    }

}