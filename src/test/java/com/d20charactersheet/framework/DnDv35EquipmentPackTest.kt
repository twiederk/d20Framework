package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnDv35EquipmentPackTest {

    private val gameSystem: GameSystem = DnDv35Universe().gameSystem

    @Test
    fun getEquipmentPackById_burglarsPack_returnBurglarsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(1, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Burglar's Pack")
        assertThat(pack.itemGroups).hasSize(14)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Caltrops")
        assertItemGroup(pack.itemGroups[2], "Bell")
        assertItemGroup(pack.itemGroups[3], "Candle", 5)
        assertItemGroup(pack.itemGroups[4], "Crowbar")
        assertItemGroup(pack.itemGroups[5], "Hammer")
        assertItemGroup(pack.itemGroups[6], "Piton", 10)
        assertItemGroup(pack.itemGroups[7], "Hooded Lantern")
        assertItemGroup(pack.itemGroups[8], "Flask of Oil", 2)
        assertItemGroup(pack.itemGroups[9], "Trail Rations (per Day)", 5)
        assertItemGroup(pack.itemGroups[10], "Flint and Steel")
        assertItemGroup(pack.itemGroups[11], "Waterskin")
        assertItemGroup(pack.itemGroups[12], "Rope, Hempen")
        assertItemGroup(pack.itemGroups[13], "Outfit Artisan")
    }

    @Test
    fun getEquipmentPackById_diplomatsPack_returnDiplomatsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(2, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Diplomat's Pack")
        assertThat(pack.itemGroups).hasSize(10)
        assertItemGroup(pack.itemGroups[0], "Chest")
        assertItemGroup(pack.itemGroups[1], "Scroll Case", 2)
        assertItemGroup(pack.itemGroups[2], "Outfit Courtier")
        assertItemGroup(pack.itemGroups[3], "Vial of Ink")
        assertItemGroup(pack.itemGroups[4], "Inkpen")
        assertItemGroup(pack.itemGroups[5], "Hooded Lantern")
        assertItemGroup(pack.itemGroups[6], "Flask of Oil", 2)
        assertItemGroup(pack.itemGroups[7], "Paper (Sheet)", 5)
        assertItemGroup(pack.itemGroups[8], "Sealing Wax")
        assertItemGroup(pack.itemGroups[9], "Soap")
    }

    @Test
    fun getEquipmentPackById_dungeoneersPack_returnDungeoneersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(3, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Dungeoneer's Pack")
        assertThat(pack.itemGroups).hasSize(10)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Crowbar")
        assertItemGroup(pack.itemGroups[2], "Hammer")
        assertItemGroup(pack.itemGroups[3], "Piton", 10)
        assertItemGroup(pack.itemGroups[4], "Torch", 10)
        assertItemGroup(pack.itemGroups[5], "Flint and Steel")
        assertItemGroup(pack.itemGroups[6], "Trail Rations (per Day)", 10)
        assertItemGroup(pack.itemGroups[7], "Waterskin")
        assertItemGroup(pack.itemGroups[8], "Rope, Hempen")
        assertItemGroup(pack.itemGroups[9], "Outfit Traveler")
    }

    @Test
    fun getEquipmentPackById_entertainersPack_returnEntertainersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(4, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Entertainer's Pack")
        assertThat(pack.itemGroups).hasSize(7)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Bedroll")
        assertItemGroup(pack.itemGroups[2], "Candle", 5)
        assertItemGroup(pack.itemGroups[3], "Trail Rations (per Day)", 5)
        assertItemGroup(pack.itemGroups[4], "Waterskin")
        assertItemGroup(pack.itemGroups[5], "Disguise Kit")
        assertItemGroup(pack.itemGroups[6], "Outfit Entertainer")
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
        assertItemGroup(pack.itemGroups[2], "Flint and Steel")
        assertItemGroup(pack.itemGroups[3], "Torch", 10)
        assertItemGroup(pack.itemGroups[4], "Trail Rations (per Day)", 10)
        assertItemGroup(pack.itemGroups[5], "Waterskin")
        assertItemGroup(pack.itemGroups[6], "Rope, Hempen")
        assertItemGroup(pack.itemGroups[7], "Outfit Explorer")
    }

    @Test
    fun getEquipmentPackById_priestsPack_returnPriestsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(6, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Priest's Pack")
        assertThat(pack.itemGroups).hasSize(7)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Winter Blanket")
        assertItemGroup(pack.itemGroups[2], "Candle", 10)
        assertItemGroup(pack.itemGroups[3], "Flint and Steel")
        assertItemGroup(pack.itemGroups[4], "Trail Rations (per Day)")
        assertItemGroup(pack.itemGroups[5], "Waterskin")
        assertItemGroup(pack.itemGroups[6], "Cleric Vestments")
    }

    @Test
    fun getEquipmentPackById_scholarPack_returnScholarsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(7, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Scholar's Pack")
        assertThat(pack.itemGroups).hasSize(5)
        assertItemGroup(pack.itemGroups[0], "Backpack")
        assertItemGroup(pack.itemGroups[1], "Vial of Ink")
        assertItemGroup(pack.itemGroups[2], "Inkpen")
        assertItemGroup(pack.itemGroups[3], "Parchment (Sheet)", 10)
        assertItemGroup(pack.itemGroups[4], "Outfit Scholar")
    }

    private fun assertItemGroup(itemGroup: ItemGroup, name: String, quantity: Int = 1) {
        assertThat(itemGroup.item.name).isEqualTo(name)
        assertThat(itemGroup.number).isEqualTo(quantity)
    }

}