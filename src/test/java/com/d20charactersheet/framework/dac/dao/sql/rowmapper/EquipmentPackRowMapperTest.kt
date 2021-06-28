package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.dac.dao.sql.DataRow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class EquipmentPackRowMapperTest {

    @Test
    fun mapRow() {
        // arrange
        val dataRow: DataRow = mock()
        whenever(dataRow.getInt(0)) doReturn 1
        whenever(dataRow.getString(1)) doReturn "myEquipmentPack"

        // act
        val equipmentPack = EquipmentPackRowMapper().mapRow(dataRow)

        // assert
        assertThat(equipmentPack.id).isEqualTo(1)
        assertThat(equipmentPack.name).isEqualTo("myEquipmentPack")
        assertThat(equipmentPack.itemGroups).isNotNull
    }

}