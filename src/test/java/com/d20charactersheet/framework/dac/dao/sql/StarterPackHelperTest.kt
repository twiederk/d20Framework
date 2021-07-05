package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.EquipmentType
import com.d20charactersheet.framework.boc.model.StarterPackQuery
import com.d20charactersheet.framework.boc.service.ItemService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*


class StarterPackHelperTest {

    @Test
    fun getStarterBoxOptions_emptyListOfStarterBoxQueries_emptyListOfStarterPackOptions() {

        // act
        val starterBoxOptions = StarterPackHelper(mock(), mock(), mock(), mock()).getStarterBoxOptions(listOf())

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
        val starterBoxOptions = StarterPackHelper(mock(), mock(), mock(), mock()).getStarterBoxOptions(starterPackQueries)

        // assert
        assertThat(starterBoxOptions).hasSize(1)
        assertThat(starterBoxOptions[0].getTitle()).isEqualTo("myArmor")
    }

    @Test
    fun createStarterBoxOption_singleArmor_oneItemGroup() {
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
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(eq(3), any())) doReturn Armor().apply { name = "myArmor" }

        // act
        val starterPackOption = StarterPackHelper(itemService, mock(), mock(), mock()).createStarterPackOption(starterPackQueries)

        // assert
        assertThat(starterPackOption.getTitle()).isEqualTo("myArmor (4)")
    }

}