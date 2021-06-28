package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eEquipmentPackTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getEquipmentPackById_burglarsPack_returnBurglarsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(1, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Burglar's Pack")
        assertThat(pack.itemGroups).hasSize(13)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Ball bearings (bag of 1,000)")
        assertItemGroup(pack.itemGroups[2], "Bell")
        assertItemGroup(pack.itemGroups[3], "Candle", 5)
        assertItemGroup(pack.itemGroups[4], "Crowbar")
        assertItemGroup(pack.itemGroups[5], "Hammer")
        assertItemGroup(pack.itemGroups[6], "Piton", 10)
        assertItemGroup(pack.itemGroups[7], "Lantern, hooded")
        assertItemGroup(pack.itemGroups[8], "Oil (flask)", 2)
        assertItemGroup(pack.itemGroups[9], "Rations (1 day)", 5)
        assertItemGroup(pack.itemGroups[10], "Tinderbox")
        assertItemGroup(pack.itemGroups[11], "Waterskin")
        assertItemGroup(pack.itemGroups[12], "Rope, hempen (50 feet)")
    }

    @Test
    fun getEquipmentPackById_diplomatsPack_returnDiplomatsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(2, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Diplomat's Pack")
        assertThat(pack.itemGroups).hasSize(11)
        assertItemGroup(pack.itemGroups[0], "Chest")
        assertItemGroup(pack.itemGroups[1], "Case, map or scroll", 2)
        assertItemGroup(pack.itemGroups[2], "Clothes, fine")
        assertItemGroup(pack.itemGroups[3], "Ink (1 ounce bottle)")
        assertItemGroup(pack.itemGroups[4], "Ink pen")
        assertItemGroup(pack.itemGroups[5], "Lamp")
        assertItemGroup(pack.itemGroups[6], "Oil (flask)", 2)
        assertItemGroup(pack.itemGroups[7], "Paper (one sheet)", 5)
        assertItemGroup(pack.itemGroups[8], "Perfume (vial)")
        assertItemGroup(pack.itemGroups[9], "Sealing wax")
        assertItemGroup(pack.itemGroups[10], "Soap")
    }

    @Test
    fun getEquipmentPackById_dungeoneersPack_returnDungeoneersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(3, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Dungeoneer's Pack")
        assertThat(pack.itemGroups).hasSize(9)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Crowbar")
        assertItemGroup(pack.itemGroups[2], "Hammer")
        assertItemGroup(pack.itemGroups[3], "Piton", 10)
        assertItemGroup(pack.itemGroups[4], "Torch", 10)
        assertItemGroup(pack.itemGroups[5], "Tinderbox")
        assertItemGroup(pack.itemGroups[6], "Rations (1 day)", 10)
        assertItemGroup(pack.itemGroups[7], "Waterskin")
        assertItemGroup(pack.itemGroups[8], "Rope, hempen (50 feet)")
    }

    @Test
    fun getEquipmentPackById_entertainersPack_returnEntertainersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(4, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Entertainer's Pack")
        assertThat(pack.itemGroups).hasSize(6)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Bedroll")
        assertItemGroup(pack.itemGroups[2], "Candle", 5)
        assertItemGroup(pack.itemGroups[3], "Rations (1 day)", 5)
        assertItemGroup(pack.itemGroups[4], "Waterskin")
        assertItemGroup(pack.itemGroups[5], "Disguise kit")
    }

    @Test
    fun getEquipmentPackById_explorersPack_returnExplorersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(5, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Explorer's Pack")
        assertThat(pack.itemGroups).hasSize(8)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Bedroll")
        assertItemGroup(pack.itemGroups[2], "Mess kit")
        assertItemGroup(pack.itemGroups[3], "Tinderbox")
        assertItemGroup(pack.itemGroups[4], "Torch", 10)
        assertItemGroup(pack.itemGroups[5], "Rations (1 day)", 10)
        assertItemGroup(pack.itemGroups[6], "Waterskin")
        assertItemGroup(pack.itemGroups[7], "Rope, hempen (50 feet)")
    }

    @Test
    fun getEquipmentPackById_priestsPack_returnPriestsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(6, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Priest's Pack")
        assertThat(pack.itemGroups).hasSize(6)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Blanket")
        assertItemGroup(pack.itemGroups[2], "Candle", 10)
        assertItemGroup(pack.itemGroups[3], "Tinderbox")
        assertItemGroup(pack.itemGroups[4], "Rations (1 day)")
        assertItemGroup(pack.itemGroups[5], "Waterskin")
    }

    @Test
    fun getEquipmentPackById_scholarPack_returnScholarsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(7, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Scholar's Pack")
        assertThat(pack.itemGroups).hasSize(5)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Book")
        assertItemGroup(pack.itemGroups[2], "Ink (1 ounce bottle)")
        assertItemGroup(pack.itemGroups[3], "Ink pen")
        assertItemGroup(pack.itemGroups[4], "Parchment (one sheet)", 10)
    }

    private fun assertItemGroup(itemGroup: ItemGroup, name: String, quantity: Int = 1) {
        assertThat(itemGroup.item.name).isEqualTo(name)
        assertThat(itemGroup.number).isEqualTo(quantity)
    }

}