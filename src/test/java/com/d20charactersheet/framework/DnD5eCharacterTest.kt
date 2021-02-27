package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eCharacterTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getAllCharacters_allCharacters_returnsAllCharacters() {

        // Act
        val allCharacters = gameSystem.allCharacters

        // Assert
        assertThat(allCharacters).hasSize(2)
    }

    @Test
    fun belvador_characterClassAbilties() {

        // act
        val belvador = gameSystem.getCharacter(1)

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

        // act
        val serio = gameSystem.getCharacter(2)

        // assert
        assertThat(serio.classAbilities).extracting("name").containsExactlyInAnyOrder(
            "Fighting Style - Defense",
            "Second Wind"
        )
    }

}