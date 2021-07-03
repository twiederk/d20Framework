package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class CharacterClassServiceStarterPackTest {

    private val underTest = CharacterClassServiceImpl(mock())

    @Test
    fun getStarterPack_singleItem_getOneSelectionBoxWithOneSelectionOptionWithOneItemGroup() {
        // arrange

        // act
        val starterPack = underTest.getStarterPack(CharacterClass(), mock(), mock(), mock())

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(1)
    }

    @Test
    fun getStarterPack_fighter_getCompleteSelectionForFighter() {
        // arrange
        val allWeaopns: List<Weapon> = mock()
        val allArmor: List<Armor> = mock()
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(1, allWeaopns)).thenReturn(Weapon().apply { name = "Longbow" })
        whenever(itemService.getItemById(2, allWeaopns)).thenReturn(Weapon().apply { name = "Arrow" })
        whenever(itemService.getItemById(3, allWeaopns)).thenReturn(Weapon().apply { name = "Crossbow, light" })
        whenever(itemService.getItemById(4, allWeaopns)).thenReturn(Weapon().apply { name = "Bolt" })
        whenever(itemService.getItemById(5, allWeaopns)).thenReturn(Weapon().apply { name = "Handaxe" })

        whenever(itemService.getItemById(1, allArmor)).thenReturn(Armor().apply { name = "Chain mail" })
        whenever(itemService.getItemById(2, allArmor)).thenReturn(Armor().apply { name = "Leather" })
        whenever(itemService.getItemById(3, allArmor)).thenReturn(Armor().apply { name = "Shield" })

        whenever(itemService.filterWeaponsByType(WeaponType.MARTIAL)).thenReturn(
            listOf(
                Weapon().apply { name = "Longsword" },
                Weapon().apply { name = "Battleaxe" },
                Weapon().apply { name = "Bastardsword" },
                Weapon().apply { name = "Two-Handed sword" },
                Weapon().apply { name = "Helberd" },
            )
        )
        val clazz = CharacterClass()

        // act
        val starterPack: StarterPack = underTest.getStarterPack(clazz, itemService, allWeaopns, allArmor)

        // assert
        assertThat(clazz.starterPack).isEqualTo(starterPack)

        assertThat(starterPack.starterPackBoxes).hasSize(5)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("Chain mail")
        assertThat(starterPack.starterPackBoxes[0].options[1].getTitle()).isEqualTo("Leather, Longbow, Arrow (20)")

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(5)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Longsword")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Battleaxe")
        assertThat(starterPack.starterPackBoxes[1].options[2].getTitle()).isEqualTo("Bastardsword")
        assertThat(starterPack.starterPackBoxes[1].options[3].getTitle()).isEqualTo("Two-Handed sword")
        assertThat(starterPack.starterPackBoxes[1].options[4].getTitle()).isEqualTo("Helberd")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(6)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Longsword")
        assertThat(starterPack.starterPackBoxes[2].options[1].getTitle()).isEqualTo("Battleaxe")
        assertThat(starterPack.starterPackBoxes[2].options[2].getTitle()).isEqualTo("Bastardsword")
        assertThat(starterPack.starterPackBoxes[2].options[3].getTitle()).isEqualTo("Two-Handed sword")
        assertThat(starterPack.starterPackBoxes[2].options[4].getTitle()).isEqualTo("Helberd")
        assertThat(starterPack.starterPackBoxes[2].options[5].getTitle()).isEqualTo("Shield")

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Crossbow, light, Bolt (20)")
        assertThat(starterPack.starterPackBoxes[3].options[1].getTitle()).isEqualTo("Handaxe (2)")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Equipment Pack")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[4].options[1].getTitle()).isEqualTo("Explorer's Pack")

    }

}