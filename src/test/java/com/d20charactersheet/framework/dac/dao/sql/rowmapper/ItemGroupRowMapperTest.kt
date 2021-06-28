package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.Good
import com.d20charactersheet.framework.boc.model.Item
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class ItemGroupRowMapperTest {

    @Test
    fun mapRow() {
        // arrange
        val dataRow: DataRow = mock()
        whenever(dataRow.getInt(0)) doReturn 1
        whenever(dataRow.getInt(1)) doReturn 2
        whenever(dataRow.getInt(2)) doReturn 3

        val item = Good().apply { id = 2; name = "myItem" }
        val allItems: List<Item> = listOf(item)

        // act
        val itemGroup = ItemGroupRowMapper(allItems).mapRow(dataRow)

        // assert
        assertThat(itemGroup.id).isEqualTo(1)
        assertThat(itemGroup.item).isEqualTo(item)
        assertThat(itemGroup.number).isEqualTo(3)
    }

}