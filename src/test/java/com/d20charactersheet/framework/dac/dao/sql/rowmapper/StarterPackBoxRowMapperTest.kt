package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.dac.dao.sql.DataRow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class StarterPackBoxRowMapperTest {

    @Test
    fun mapRow() {
        // Arrange
        val dataRow: DataRow = mock()
        whenever(dataRow.getInt(0)) doReturn 1
        whenever(dataRow.getString(1)) doReturn "mySelectionBox"

        // Act
        val selectionBox = StarterPackBoxRowMapper().mapRow(dataRow)

        // Assert
        assertThat(selectionBox.id).isEqualTo(1)
        assertThat(selectionBox.name).isEqualTo("mySelectionBox")
    }

}