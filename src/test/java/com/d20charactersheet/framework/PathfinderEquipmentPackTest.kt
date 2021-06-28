package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.ItemGroup
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PathfinderEquipmentPackTest {

    private val gameSystem: GameSystem = PathfinderUniverse().gameSystem

    @Test
    fun getEquipmentPackById_burglarsPack_returnBurglarsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(1, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Burglar's Pack")
        assertThat(pack.itemGroups).hasSize(14)
        assertItemGroup(pack.itemGroups[0], "Backpack (empty)")
        assertItemGroup(pack.itemGroups[1], "Caltrops")
        assertItemGroup(pack.itemGroups[2], "Bell")
        assertItemGroup(pack.itemGroups[3], "Candle", 5)
        assertItemGroup(pack.itemGroups[4], "Crowbar")
        assertItemGroup(pack.itemGroups[5], "Hammer")
        assertItemGroup(pack.itemGroups[6], "Piton", 10)
        assertItemGroup(pack.itemGroups[7], "Lantern, hooded")
        assertItemGroup(pack.itemGroups[8], "Oil (1-pint flask)", 2)
        assertItemGroup(pack.itemGroups[9], "Rations, trail (per day)", 5)
        assertItemGroup(pack.itemGroups[10], "Flint and steel")
        assertItemGroup(pack.itemGroups[11], "Waterskin")
        assertItemGroup(pack.itemGroups[12], "Rope, hemp (50 ft.)")
        assertItemGroup(pack.itemGroups[13], "Artisan's outfit")
    }

    @Test
    fun getEquipmentPackById_diplomatsPack_returnDiplomatsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(2, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Diplomat's Pack")
        assertThat(pack.itemGroups).hasSize(10)
        assertItemGroup(pack.itemGroups[0], "Chest (empty)")
        assertItemGroup(pack.itemGroups[1], "Case, map or scroll", 2)
        assertItemGroup(pack.itemGroups[2], "Courtier's outfit")
        assertItemGroup(pack.itemGroups[3], "Ink (1 oz. vial)")
        assertItemGroup(pack.itemGroups[4], "Inkpen")
        assertItemGroup(pack.itemGroups[5], "Lamp, common")
        assertItemGroup(pack.itemGroups[6], "Oil (1-pint flask)", 2)
        assertItemGroup(pack.itemGroups[7], "Paper (sheet)", 5)
        assertItemGroup(pack.itemGroups[8], "Sealing wax")
        assertItemGroup(pack.itemGroups[9], "Soap (per lb.)")
    }

    @Test
    fun getEquipmentPackById_dungeoneersPack_returnDungeoneersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(3, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Dungeoneer's Pack")
        assertThat(pack.itemGroups).hasSize(10)
        assertItemGroup(pack.itemGroups[0], "Backpack (empty)")
        assertItemGroup(pack.itemGroups[1], "Crowbar")
        assertItemGroup(pack.itemGroups[2], "Hammer")
        assertItemGroup(pack.itemGroups[3], "Piton", 10)
        assertItemGroup(pack.itemGroups[4], "Torch", 10)
        assertItemGroup(pack.itemGroups[5], "Flint and steel")
        assertItemGroup(pack.itemGroups[6], "Rations, trail (per day)", 10)
        assertItemGroup(pack.itemGroups[7], "Waterskin")
        assertItemGroup(pack.itemGroups[8], "Rope, hemp (50 ft.)")
        assertItemGroup(pack.itemGroups[9], "Traveler's outfit")
    }

    @Test
    fun getEquipmentPackById_entertainersPack_returnEntertainersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(4, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Entertainer's Pack")
        assertThat(pack.itemGroups).hasSize(7)
        assertItemGroup(pack.itemGroups[0], "Backpack (empty)")
        assertItemGroup(pack.itemGroups[1], "Bedroll")
        assertItemGroup(pack.itemGroups[2], "Candle", 5)
        assertItemGroup(pack.itemGroups[3], "Rations, trail (per day)", 5)
        assertItemGroup(pack.itemGroups[4], "Waterskin")
        assertItemGroup(pack.itemGroups[5], "Disguise kit")
        assertItemGroup(pack.itemGroups[6], "Entertainer's outfit")
    }

    @Test
    fun getEquipmentPackById_explorersPack_returnExplorersPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(5, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Explorer's Pack")
        assertThat(pack.itemGroups).hasSize(8)
        assertItemGroup(pack.itemGroups[0], "Backpack (empty)")
        assertItemGroup(pack.itemGroups[1], "Bedroll")
        assertItemGroup(pack.itemGroups[2], "Flint and steel")
        assertItemGroup(pack.itemGroups[3], "Torch", 10)
        assertItemGroup(pack.itemGroups[4], "Rations, trail (per day)", 10)
        assertItemGroup(pack.itemGroups[5], "Waterskin")
        assertItemGroup(pack.itemGroups[6], "Rope, hemp (50 ft.)")
        assertItemGroup(pack.itemGroups[7], "Explorer's outfit")
    }

    @Test
    fun getEquipmentPackById_priestsPack_returnPriestsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(6, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Priest's Pack")
        assertThat(pack.itemGroups).hasSize(7)
        assertItemGroup(pack.itemGroups[0], "Backpack (empty)")
        assertItemGroup(pack.itemGroups[1], "Blanket, winter")
        assertItemGroup(pack.itemGroups[2], "Candle", 10)
        assertItemGroup(pack.itemGroups[3], "Flint and steel")
        assertItemGroup(pack.itemGroups[4], "Rations, trail (per day)")
        assertItemGroup(pack.itemGroups[5], "Waterskin")
        assertItemGroup(pack.itemGroups[6], "Cleric's vestments")
    }

    @Test
    fun getEquipmentPackById_scholarPack_returnScholarsPack() {

        // act
        val pack = gameSystem.itemService.getEquipmentPackById(7, gameSystem.allEquipmentPacks)

        // assert
        assertThat(pack.name).isEqualTo("Scholar's Pack")
        assertThat(pack.itemGroups).hasSize(5)
        assertItemGroup(pack.itemGroups[0], "Backpack (empty)")
        assertItemGroup(pack.itemGroups[1], "Ink (1 oz. vial)")
        assertItemGroup(pack.itemGroups[2], "Inkpen")
        assertItemGroup(pack.itemGroups[3], "Parchment (sheet)", 10)
        assertItemGroup(pack.itemGroups[4], "Scholar's outfit")
    }

    private fun assertItemGroup(itemGroup: ItemGroup, name: String, quantity: Int = 1) {
        assertThat(itemGroup.item.name).isEqualTo(name)
        assertThat(itemGroup.number).isEqualTo(quantity)
    }

}