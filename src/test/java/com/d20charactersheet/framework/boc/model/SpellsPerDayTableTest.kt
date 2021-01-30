package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellsPerDayTableTest {

    @Test
    fun getSpellsPerDay_spellcasterLevelAndSpellLevelInBounds_numberOfSpellsPerDay() {
        // Arrange
        val underTest = SpellsPerDayTable()
        underTest.spellsPerDay = arrayOf(intArrayOf(1), intArrayOf(1))

        // Act
        val spellsPerDay = underTest.getSpellsPerDay(1, 0)

        // Assert
        assertThat(spellsPerDay).isEqualTo(1)
    }

    @Test
    fun getSpellsPerDay_spellcasterLevelOutOfBounds_noAccess() {
        // Arrange
        val underTest = SpellsPerDayTable()
        underTest.spellsPerDay = arrayOf(IntArray(10), IntArray(10))

        // Act
        val spellsPerDay = underTest.getSpellsPerDay(11, 0)

        // Assert
        assertThat(spellsPerDay).isEqualTo(SpellsPerDayTable.NO_ACCESS)
    }

    @Test
    fun getSpellsPerDay_spellLevelOutOfBounds_noAccess() {
        // Arrange
        val underTest = SpellsPerDayTable()
        underTest.spellsPerDay = arrayOf(IntArray(10), IntArray(10))

        // Act
        val spellsPerDay = underTest.getSpellsPerDay(1, 10)

        // Assert
        assertThat(spellsPerDay).isEqualTo(SpellsPerDayTable.NO_ACCESS)
    }

}