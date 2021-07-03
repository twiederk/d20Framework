package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PackSelectionOptionTest {

    @Test
    fun getTitle_noPack_nameOfPack() {
        // Arrange
        val underTest = PackSelectionOption(EquipmentPack().apply { name = "myEquipmentPack" })

        // Act
        val title = underTest.getTitle()

        // Assert
        assertThat(title).isEqualTo("myEquipmentPack")
    }

}