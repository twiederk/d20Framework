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
        val allWeaopns: List<Weapon> = mock()
        val allArmor: List<Armor> = mock()
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(1, allWeaopns)).thenReturn(Weapon().apply { name = "Longbow" })
        whenever(itemService.getItemById(2, allWeaopns)).thenReturn(Weapon().apply { name = "Arrow" })

        whenever(itemService.getItemById(1, allArmor)).thenReturn(Armor().apply { name = "Chain mail" })
        whenever(itemService.getItemById(2, allArmor)).thenReturn(Armor().apply { name = "Leather" })

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
        val starterPack: StarterPack = underTest.getStarterPack(CharacterClass(), itemService, allWeaopns, allArmor)

        // assert
        assertThat(starterPack.selectionBoxes).hasSize(2)

        assertThat(starterPack.selectionBoxes[0].name).isEqualTo("Armor")
        assertThat(starterPack.selectionBoxes[0].options).hasSize(2)
        assertThat(starterPack.selectionBoxes[0].options[0].getTitle()).isEqualTo("Chain mail")
        assertThat(starterPack.selectionBoxes[0].options[1].getTitle()).isEqualTo("Leather, Longbow, Arrow (20)")

        assertThat(starterPack.selectionBoxes[1].name).isEqualTo("Primary Hand")
        assertThat(starterPack.selectionBoxes[1].options).hasSize(5)
        assertThat(starterPack.selectionBoxes[1].options[0].getTitle()).isEqualTo("Longsword")
        assertThat(starterPack.selectionBoxes[1].options[1].getTitle()).isEqualTo("Battleaxe")
        assertThat(starterPack.selectionBoxes[1].options[2].getTitle()).isEqualTo("Bastardsword")
        assertThat(starterPack.selectionBoxes[1].options[3].getTitle()).isEqualTo("Two-Handed sword")
        assertThat(starterPack.selectionBoxes[1].options[4].getTitle()).isEqualTo("Helberd")
    }

}