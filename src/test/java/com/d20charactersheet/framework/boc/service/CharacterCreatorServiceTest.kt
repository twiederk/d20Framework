package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class CharacterCreatorServiceTest {

    private val underTest = CharacterCreatorServiceImpl()

    @Test
    fun rollAttributeWithStandardMethod_roll4d6_sumOf3highestRolls() {
        // Arrange
        Die.setRandom(Random(1))


        // Act
        val attributeScore = underTest.rollAttributeWithStandardMethod()

        // Assert
        assertThat(attributeScore).isEqualTo(13)
    }

    @Test
    fun getEquipmentSelection_fighter_getCompleteSelectionForFighter() {
        // arrange
        val allArmor: List<Armor> = mock()
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(1, allArmor)).thenReturn(Armor().apply { id = 1; name = "Chain mail" })
        whenever(itemService.filterWeaponsByType(WeaponType.MARTIAL)).thenReturn(
            listOf(
                Weapon().apply { name = "Longsword" },
                Weapon().apply { name = "Battleaxe" },
                Weapon().apply { name = "Bastardsword" },
                Weapon().apply { name = "Two-Handed sword" },
                Weapon().apply { name = "Helberd" },
            )
        )

        // act
        val selectionBoxes: List<SelectionBox> = underTest.getEquipmentSelectionBoxes(CharacterClass(), itemService, allArmor)

        // assert
        assertThat(selectionBoxes).hasSize(2)

        assertThat(selectionBoxes[0].options).hasSize(2)
        assertThat(selectionBoxes[0].options[0].getTitle()).isEqualTo("Chain mail")
        assertThat(selectionBoxes[0].options[1].getTitle()).isEqualTo("Leather, Longbow, Arrow (20)")

        assertThat(selectionBoxes[1].options).hasSize(5)
    }

}