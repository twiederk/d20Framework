package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemStarterPackBoxTest {

    @Test
    fun getName_noItem_emptyString() {
        // arrange

        // act
        val title = StarterPackBoxItemOption().getTitle()

        // assert
        assertThat(title).isEmpty()
    }

    @Test
    fun getName_singleItem_nameOfItem() {
        // arrange
        val selectionOption = StarterPackBoxItemOption()
        selectionOption.add(ItemGroup().apply {
            item = Armor().apply { name = "Chain mail"; number = 1 }
        })

        // act
        val title = selectionOption.getTitle()

        // assert
        assertThat(title).isEqualTo("Chain mail")
    }

    @Test
    fun getName_twoItems_namesSeparatedByComa() {
        // arrange
        val selectionOption = StarterPackBoxItemOption()
        selectionOption.add(ItemGroup().apply { item = Armor().apply { name = "Chain mail"; number = 1 } })
        selectionOption.add(ItemGroup().apply { item = Weapon().apply { name = "Longbow"; number = 1 } })

        // act
        val title = selectionOption.getTitle()

        // assert
        assertThat(title).isEqualTo("Chain mail, Longbow")
    }

    @Test
    fun getName_twoItemsWithCount_namesSeparatedByComaAndCountInBraces() {
        // arrange
        val selectionOption = StarterPackBoxItemOption()
        selectionOption.add(ItemGroup().apply { item = Weapon().apply { name = "Longbow"; number = 1 } })
        selectionOption.add(ItemGroup().apply { item = Weapon().apply { name = "Arrow"; number = 20 } })

        // act
        val title = selectionOption.getTitle()

        // assert
        assertThat(title).isEqualTo("Longbow, Arrow (20)")
    }

}