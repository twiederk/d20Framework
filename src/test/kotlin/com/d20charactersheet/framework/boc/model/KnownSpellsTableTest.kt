package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KnownSpellsTableTest {

    @Test
    fun getKnownSpells_spellcasterLevelAndSpellLevelInBounds_numberOfKnownSpells() {
        // Arrange
        val underTest = KnownSpellsTable()
        underTest.knownSpells = arrayOf(intArrayOf(1), intArrayOf(1))

        // Act
        val knownSpells = underTest.getKnownSpells(1, 0)

        // Assert
        assertThat(knownSpells).isEqualTo(1)
    }

    @Test
    fun getKnownSpells_spellcasterLevelOutOfBounds_maxNumberOfKnownSpells() {
        // Arrange
        val underTest = KnownSpellsTable()
        underTest.knownSpells = arrayOf(IntArray(10), intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))

        // Act
        val spellsPerDay = underTest.getKnownSpells(11, 9)

        // Assert
        assertThat(spellsPerDay).isEqualTo(1)
    }

    @Test
    fun getKnownSpells_spellLevelOutOfBounds_maxNumberOfKnownSpells() {
        // Arrange
        val underTest = KnownSpellsTable()
        underTest.knownSpells = arrayOf(IntArray(10), IntArray(10))
        underTest.knownSpells[0] = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

        // Act
        val spellsPerDay = underTest.getKnownSpells(1, 10)

        // Assert
        assertThat(spellsPerDay).isEqualTo(1)
    }

}