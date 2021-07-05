package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.EquipmentType
import com.d20charactersheet.framework.boc.model.StarterPackQuery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class StarterPackHelperTest {

    @Test
    fun getStarterBoxOptions_emptyListOfStarterBoxQueries_emptyListOfStarterPackOptions() {

        // act
        val starterBoxOptions = StarterPackHelper().getStarterBoxOptions(listOf())

        // assert
        assertThat(starterBoxOptions).isEmpty()
    }

    @Test
    fun getStarterBoxOptions_singleItem_singleOptionWithOneItem() {
        // arrange
        val starterPackQueries = listOf(
            StarterPackQuery(
                id = 1,
                optionId = 2,
                equipmentType = EquipmentType.ARMOR,
                itemId = 3,
                quantity = 4
            )
        )

        // act
        val starterBoxOptions = StarterPackHelper().getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterBoxOptions).hasSize(1)

    }
}