package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PackStarterPackBoxOptionTest {

    @Test
    fun getTitle_noPack_nameOfPack() {
        // Arrange
        val underTest = PackStarterPackBoxOption(EquipmentPack().apply { name = "myEquipmentPack" })

        // Act
        val title = underTest.getTitle()

        // Assert
        assertThat(title).isEqualTo("myEquipmentPack")
    }

}