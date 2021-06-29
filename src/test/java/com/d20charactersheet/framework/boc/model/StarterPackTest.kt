package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StarterPackTest {

    @Test
    fun constructor_instanciate_emptyList() {

        // Act
        val starterPack = StarterPack()

        // Assert
        assertThat(starterPack.selectionBoxes).isEmpty()
    }

    @Test
    fun add_singleSelectionBox_addsSelectionBox() {
        // arrange
        val starterPack = StarterPack()

        // act
        starterPack.add(SelectionBox())

        // assert
        assertThat(starterPack.selectionBoxes).hasSize(1)

    }
}