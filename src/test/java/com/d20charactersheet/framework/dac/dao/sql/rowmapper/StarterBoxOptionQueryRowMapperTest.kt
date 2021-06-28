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
        whenever(dataRow.getInt(3)) doReturn 3
        whenever(dataRow.getInt(4)) doReturn 4
        whenever(dataRow.getInt(5)) doReturn 5
        whenever(dataRow.getInt(6)) doReturn 6

        // Act
        val starterPackBoxOptionQuery = StarterBoxOptionQueryRowMapper().mapRow(dataRow)

        // Assert
        assertThat(starterPackBoxOptionQuery.id).isEqualTo(1)
        assertThat(starterPackBoxOptionQuery.optionId).isEqualTo(2)
        assertThat(starterPackBoxOptionQuery.equipmentType).isEqualTo(EquipmentType.ARMOR)
        assertThat(starterPackBoxOptionQuery.typeId).isEqualTo(3)
        assertThat(starterPackBoxOptionQuery.combatId).isEqualTo(4)
        assertThat(starterPackBoxOptionQuery.itemId).isEqualTo(5)
        assertThat(starterPackBoxOptionQuery.quantity).isEqualTo(6)
    }

}