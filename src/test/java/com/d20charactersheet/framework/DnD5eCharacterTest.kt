package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eCharacterTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    private val belvador: Character = gameSystem.getCharacter(1)
    private val serio: Character = gameSystem.getCharacter(2)

    @Test
    fun getAllCharacters_allCharacters_returnsAllCharacters() {

        // Act
        val allCharacters = gameSystem.allCharacters

        // Assert
        assertThat(allCharacters).hasSize(10)
    }

    @Test
    fun belvador_characterClassAbilties() {

        // assert
        assertThat(belvador.classAbilities).extracting("name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Spellcasting - Wizard",
            "Arcane Recovery",
            "Arcane Tradition",
            "School of Evocation",
            "Evocation - Evocation Savant",
            "Evocation - Sculpt Spells"
        )
    }

    @Test
    fun serio_characterClassAbilties() {

        // assert
        assertThat(serio.classAbilities).extracting("name").containsExactlyInAnyOrder(
            "Fighting Style - Defense",
            "Second Wind"
        )
    }

    @Test
    fun belvador_characterWeapons() {

        // assert
        assertThat(belvador.equipment.weapons).extracting("item.name").containsExactlyInAnyOrder(
            "Quarterstaff",
            "Crossbow, Light",
            "Crossbow bolts (20)"
        )
    }

    @Test
    fun belvador_weaponAttacks() {

        // assert
        assertThat(belvador.weaponAttacks).extracting("weapon.name").containsExactlyInAnyOrder(
            "Quarterstaff (Versatile)",
            "Crossbow, Light",
            "Dagger"
        )
    }

    @Test
    fun belvador_characterGoods() {

        // assert
        assertThat(belvador.equipment.goods).extracting("item.name").containsExactlyInAnyOrder(
            "Backpack",
            "Waterskin",
            "Rations (1 day)",
            "Bedroll",
            "Tinderbox",
            "Candle",
            "Case, map or scroll",
            "Parchment (one sheet)",
            "Ink (1 ounce bottle)",
            "Ink pen",
            "Spellbook",
            "Clothes, fine",
            "Lantern, bullseye",
            "Oil (flask)",
            "Torch",
            "Alchemist's fire (flask)",
            "Horse, riding",
            "Saddle, Riding",
            "Saddlebags"
        )
    }

    @Test
    fun serio_characterWeapons() {

        // assert
        assertThat(serio.equipment.weapons).extracting("item.name").containsExactlyInAnyOrder(
            "Longsword",
            "Longbow",
            "Crossbow bolts (20)"
        )
    }


    @Test
    fun serio_weaponAttacks() {

        // assert
        assertThat(serio.weaponAttacks).extracting("weapon.name").containsExactlyInAnyOrder(
            "Longsword",
            "Crossbow, Light"
        )
    }

    @Test
    fun serio_characterArmor() {

        // assert
        assertThat(serio.equipment.armor).extracting("item.name").containsExactlyInAnyOrder(
            "Chain mail",
            "Shield"
        )
    }

    @Test
    fun serio_characterGood() {

        // assert
        assertThat(serio.equipment.goods).extracting("item.name").containsExactlyInAnyOrder(
            "Pot, iron",
            "Clothes, common",
            "Backpack",
            "Bedroll",
            "Mess kit",
            "Tinderbox",
            "Torch",
            "Rations (1 day)",
            "Waterskin",
            "Rope, hempen (50 feet)"
        )
    }

}