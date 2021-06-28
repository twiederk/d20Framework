package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.StarterPackData
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnDv35StarterPackTest {

    private val gameSystem: GameSystem = DnDv35Universe().gameSystem
    private val starterPackData = StarterPackData(
        gameSystem.itemService,
        gameSystem.allWeapons,
        gameSystem.allArmor,
        gameSystem.allGoods,
        gameSystem.allEquipmentPacks
    )

    @Test
    fun getStarterPackOf_barbarian_returnStarterPacksOfBarbarian() {
        // arrange
        val barbarian = CharacterClass().apply { id = 0; name = "Barbarian" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(barbarian, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(4)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(21)

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(21)

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Javelin (4)")

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Explorer's Pack")
    }

    @Test
    fun getStarterPackOf_bard_returnStarterPacksOfBard() {
        // arrange
        val bard = CharacterClass().apply { id = 1; name = "Bard" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(bard, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(4)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(22)

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Diplomat's Pack")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Entertainer's Pack")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Music Instrument")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Musical Instrument, Common")

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Leather, Dagger")
    }

    @Test
    fun getStarterPackOf_cleric_returnStarterPacksOfCleric() {
        // arrange
        val cleric = CharacterClass().apply { id = 2; name = "Cleric" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(cleric, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(5)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("Mace, light")
        assertThat(starterPack.starterPackBoxes[0].options[1].getTitle()).isEqualTo("Warhammer")

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(3)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Scale Mail, Light Wooden Shield")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Leather, Light Wooden Shield")
        assertThat(starterPack.starterPackBoxes[1].options[2].getTitle()).isEqualTo("Chain Mail, Light Wooden Shield")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(21)

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Priest's Pack")
        assertThat(starterPack.starterPackBoxes[3].options[1].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Holy Symbol")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Holy Symbol, wooden")
        assertThat(starterPack.starterPackBoxes[4].options[1].getTitle()).isEqualTo("Holy Symbol, silver")
    }

    @Test
    fun getStarterPackOf_druid_returnStarterPacksOfDruid() {
        // arrange
        val druid = CharacterClass().apply { id = 3; name = "Druid" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(druid, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(5)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(21)

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(16)

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Leather")

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Druidic Focus")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Holly and Mistletoe")
    }

    @Test
    fun getStarterPackOf_fighter_returnStarterPacksOfFighter() {
        // arrange
        val fighter = CharacterClass().apply { id = 4; name = "Fighter" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(fighter, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(5)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("Chain Mail")
        assertThat(starterPack.starterPackBoxes[0].options[1].getTitle()).isEqualTo("Leather, Longbow, Arrows (20)")

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(37)

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(38)

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Crossbow, light, Bolts, crossbow (10)")
        assertThat(starterPack.starterPackBoxes[3].options[1].getTitle()).isEqualTo("Handaxe (2)")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[4].options[1].getTitle()).isEqualTo("Explorer's Pack")
    }

    @Test
    fun getStarterPackOf_monk_returnStarterPacksOfMonk() {
        // arrange
        val monk = CharacterClass().apply { id = 5; name = "Monk" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(monk, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(3)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(21)

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Dart (10)")
    }

    @Test
    fun getStarterPackOf_paladin_returnStarterPacksOfPaladin() {
        // arrange
        val paladin = CharacterClass().apply { id = 6; name = "Paladin" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(paladin, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(6)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(37)

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(38)

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(16)

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Priest's Pack")
        assertThat(starterPack.starterPackBoxes[3].options[1].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Chain Mail")

        assertThat(starterPack.starterPackBoxes[5].name).isEqualTo("Holy Symbol")
        assertThat(starterPack.starterPackBoxes[5].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[5].options[0].getTitle()).isEqualTo("Holy Symbol, wooden")
        assertThat(starterPack.starterPackBoxes[5].options[1].getTitle()).isEqualTo("Holy Symbol, silver")
    }

    @Test
    fun getStarterPackOf_ranger_returnStarterPacksOfRanger() {
        // arrange
        val ranger = CharacterClass().apply { id = 7; name = "Ranger" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(ranger, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(5)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("Scale Mail")
        assertThat(starterPack.starterPackBoxes[0].options[1].getTitle()).isEqualTo("Leather")

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(16)

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Secondary Hand")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(16)

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[3].options[1].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[4].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[4].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[4].options[0].getTitle()).isEqualTo("Longbow, Arrows (20)")
    }

    @Test
    fun getStarterPackOf_rogue_returnStarterPacksOfRogue() {
        // arrange
        val rogue = CharacterClass().apply { id = 8; name = "Rogue" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(rogue, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(4)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("Rapier")
        assertThat(starterPack.starterPackBoxes[0].options[1].getTitle()).isEqualTo("Sword, short")

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Shortbow, Arrows (20)")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Sword, short")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(3)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Burglar's Pack")
        assertThat(starterPack.starterPackBoxes[2].options[1].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[2].options[2].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[3].name).isEqualTo("Armor")
        assertThat(starterPack.starterPackBoxes[3].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[3].options[0].getTitle()).isEqualTo("Leather, Dagger (2), Thieves Tools")
    }

    @Test
    fun getStarterPackOf_sorcerer_returnStarterPacksOfSorcerer() {
        // arrange
        val sorcerer = CharacterClass().apply { id = 9; name = "Sorcerer" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(sorcerer, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(3)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(21)

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Dungeoneer's Pack")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Range Weapon")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Dagger (2)")
    }


    @Test
    fun getStarterPackOf_wizard_returnStarterPacksOfWizard() {
        // arrange
        val wizard = CharacterClass().apply { id = 10; name = "Wizard" }

        // act
        val starterPack = gameSystem.characterClassService.getStarterPack(wizard, starterPackData)

        // assert
        assertThat(starterPack.starterPackBoxes).hasSize(3)

        assertThat(starterPack.starterPackBoxes[0].name).isEqualTo("Primary Hand")
        assertThat(starterPack.starterPackBoxes[0].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[0].options[0].getTitle()).isEqualTo("Quarterstaff")
        assertThat(starterPack.starterPackBoxes[0].options[1].getTitle()).isEqualTo("Dagger")

        assertThat(starterPack.starterPackBoxes[1].name).isEqualTo("Equipment")
        assertThat(starterPack.starterPackBoxes[1].options).hasSize(2)
        assertThat(starterPack.starterPackBoxes[1].options[0].getTitle()).isEqualTo("Scholar's Pack")
        assertThat(starterPack.starterPackBoxes[1].options[1].getTitle()).isEqualTo("Explorer's Pack")

        assertThat(starterPack.starterPackBoxes[2].name).isEqualTo("Spellbook")
        assertThat(starterPack.starterPackBoxes[2].options).hasSize(1)
        assertThat(starterPack.starterPackBoxes[2].options[0].getTitle()).isEqualTo("Spellbook")
    }

}