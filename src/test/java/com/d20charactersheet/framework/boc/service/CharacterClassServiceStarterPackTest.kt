package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.ClassDao
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class CharacterClassServiceStarterPackTest {

    private val classDao: ClassDao = mock()

    private val underTest = CharacterClassServiceImpl(classDao)

    @Test
    fun getStarterPack_oneItem_getOneStaterPackBoxWithOneStarterPackOptionWithOneItemGroup() {
        // arrange
        whenever(classDao.getStarterPackBoxesWithQueries(1)) doReturn mapOf(
            StarterPackBox(1, "Weapon") to listOf(StarterPackQuery(1, 2, EquipmentType.WEAPON, -1, -1, 3, 4))
        )
        val clazz = CharacterClass().apply { id = 1 }

        val allWeapons: List<Weapon> = mock()
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { name = "myWeapon" }
        val starterPackData = StarterPackData(itemService, allWeapons, mock(), mock(), mock())

        // act
        val starterPack = underTest.getStarterPack(clazz, starterPackData)

        // assert
        assertThat(clazz.starterPack).isEqualTo(starterPack)
        assertThat(starterPack.starterPackBoxes).containsExactly(StarterPackBox(1, "Weapon"))
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("myWeapon (4)")
    }

    @Test
    fun getStarterPack_twoItemsForOneOption_getOneStarterPackBoxWithOneOptionWithTwoItemGroups() {
        // arrange
        whenever(classDao.getStarterPackBoxesWithQueries(1)) doReturn mapOf(
            StarterPackBox(1, "Weapon with Armor") to listOf(
                StarterPackQuery(1, 2, EquipmentType.WEAPON, -1, -1, 3, 4),
                StarterPackQuery(1, 2, EquipmentType.ARMOR, -1, -1, 5, 6)
            )
        )
        val clazz = CharacterClass().apply { id = 1 }

        val allWeapons: List<Weapon> = mock()
        val allArmor: List<Armor> = mock()
        val itemService: ItemService = mock()
        whenever(itemService.getItemById(3, allWeapons)) doReturn Weapon().apply { name = "myWeapon" }
        whenever(itemService.getItemById(5, allArmor)) doReturn Weapon().apply { name = "myArmor" }
        val starterPackData = StarterPackData(itemService, allWeapons, allArmor, mock(), mock())

        // act
        val starterPack = underTest.getStarterPack(clazz, starterPackData)

        // assert
        assertThat(clazz.starterPack).isEqualTo(starterPack)
        assertThat(starterPack.starterPackBoxes).containsExactly(StarterPackBox(1, "Weapon with Armor"))
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("myWeapon (4), myArmor (6)")
    }

    @Test
    fun getStarterPack_fighter_getCompleteSelectionForFighter() {
        // arrange
        val allWeapons: List<Weapon> = mock()
        val allArmor: List<Armor> = mock()
        val allGoods: List<Good> = mock()
        val allPacks: List<EquipmentPack> = mock()

        whenever(classDao.getStarterPackBoxesWithQueries(1)) doReturn mapOf(
            StarterPackBox(1, "Armor") to listOf(
                StarterPackQuery(1, 1, EquipmentType.ARMOR, -1, -1, 1, 1), // Chain Mail
                StarterPackQuery(2, 2, EquipmentType.ARMOR, -1, -1, 2, 1), // Leather
                StarterPackQuery(3, 2, EquipmentType.WEAPON, -1, -1, 1, 1), // Longbow
                StarterPackQuery(4, 2, EquipmentType.WEAPON, -1, -1, 2, 1), // Arrows (20)
            ),
            StarterPackBox(2, "Primary Hand") to listOf(
                StarterPackQuery(5, 1, EquipmentType.WEAPON, 1, -1, -1, 1), // Martial weapons
            ),
            StarterPackBox(3, "Secondary Hand") to listOf(
                StarterPackQuery(6, 1, EquipmentType.WEAPON, 1, -1, -1, 1), // Martial weapons
                StarterPackQuery(7, 2, EquipmentType.ARMOR, 3, -1, -1, 1), // Martial weapons
            ),
            StarterPackBox(4, "Range Weapon") to listOf(
                StarterPackQuery(8, 1, EquipmentType.WEAPON, -1, -1, 3, 1), // Crossbow, light
                StarterPackQuery(9, 1, EquipmentType.WEAPON, -1, -1, 4, 1), // Bolts, crossbow (10)
                StarterPackQuery(10, 2, EquipmentType.WEAPON, -1, -1, 5, 2), // Handaxe
            ),
            StarterPackBox(5, "Equipment Pack") to listOf(
                StarterPackQuery(11, 1, EquipmentType.PACK, -1, -1, 1, 1), // Dungeoneer's Pack
                StarterPackQuery(12, 2, EquipmentType.PACK, -1, -1, 2, 1), // Explorer's Pack
            )
        )

        val itemService: ItemService = mock()
        whenever(itemService.getItemById(1, allArmor)) doReturn (Armor().apply { name = "Chain mail" })
        whenever(itemService.getItemById(2, allArmor)) doReturn (Armor().apply { name = "Leather" })
        whenever(itemService.getItemById(1, allWeapons)) doReturn (Weapon().apply { name = "Longbow" })
        whenever(itemService.getItemById(2, allWeapons)) doReturn (Weapon().apply { name = "Arrow (20)" })
        whenever(itemService.getItemById(3, allWeapons)) doReturn (Weapon().apply { name = "Crossbow, light" })
        whenever(itemService.getItemById(4, allWeapons)) doReturn (Weapon().apply { name = "Bolts, crossbow (10)" })
        whenever(itemService.getItemById(5, allWeapons)) doReturn (Weapon().apply { name = "Handaxe" })

        whenever(itemService.filterWeaponsByType(WeaponType.MARTIAL, allWeapons)) doReturn listOf(
            Weapon().apply { name = "Longsword" },
            Weapon().apply { name = "Battleaxe" },
            Weapon().apply { name = "Bastardsword" },
            Weapon().apply { name = "Two-Handed sword" },
            Weapon().apply { name = "Helberd" }
        )

        whenever(itemService.filterArmorByType(ArmorType.SHIELD, allArmor)) doReturn listOf(
            Armor().apply { name = "Light Wooden Shield" },
            Armor().apply { name = "Light Steel Shield" },
            Armor().apply { name = "Tower Shield" }
        )

        whenever(itemService.getEquipmentPackById(1, allPacks)) doReturn EquipmentPack(1, "Dungeoneer's Pack")
        whenever(itemService.getEquipmentPackById(2, allPacks)) doReturn EquipmentPack(2, "Explorer's Pack")

        val starterPackData = StarterPackData(itemService, allWeapons, allArmor, allGoods, allPacks)
        val clazz = CharacterClass().apply { id = 1 }

        // act
        val starterPack: StarterPack = underTest.getStarterPack(clazz, starterPackData)

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
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(8)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Longsword")
        assertThat(starterPack.starterPackBoxes[2].options[1].getTitle()).isEqualTo("Battleaxe")
        assertThat(starterPack.starterPackBoxes[2].options[2].getTitle()).isEqualTo("Bastardsword")
        assertThat(starterPack.starterPackBoxes[2].options[3].getTitle()).isEqualTo("Two-Handed sword")
        assertThat(starterPack.starterPackBoxes[2].options[4].getTitle()).isEqualTo("Helberd")
        assertThat(starterPack.starterPackBoxes[2].options[5].getTitle()).isEqualTo("Light Wooden Shield")
        assertThat(starterPack.starterPackBoxes[2].options[6].getTitle()).isEqualTo("Light Steel Shield")
        assertThat(starterPack.starterPackBoxes[2].options[7].getTitle()).isEqualTo("Tower Shield")

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Crossbow, light, Bolts, crossbow (10)")
        assertThat(starterPack.starterPackBoxes[3].options[1].getTitle()).isEqualTo("Handaxe (2)")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Equipment Pack")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[4].options[1].getTitle()).isEqualTo("Explorer's Pack")

    }

}