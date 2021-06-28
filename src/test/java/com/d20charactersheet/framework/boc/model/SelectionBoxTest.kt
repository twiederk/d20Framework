package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SelectionBoxTest {

    @Test
    fun getName_notItem_emptyString() {
        // arrange

        // act
        val title = SelectionOption().getTitle()

        // assert
        assertThat(title).isEmpty()
    }

    @Test
    fun getName_singleItem_nameOfItem() {
        // arrange
        val selectionOption = SelectionOption()
        selectionOption.add(ItemGroup().apply {
            item = Weapon().apply { name = "Chain mail" }
        })

        // act
        val title = selectionOption.getTitle()

        // assert
        assertThat(title).isEqualTo("Chain mail")
    }

}