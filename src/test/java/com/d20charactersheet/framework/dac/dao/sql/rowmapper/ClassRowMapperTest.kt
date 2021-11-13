package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

internal class ClassRowMapperTest {

    @Test
    fun mapRow() {
        // Arrange
        val dataRow: DataRow = mock()
        whenever(dataRow.getInt(0)) doReturn 1 // id
        whenever(dataRow.getString(1)) doReturn "myCharacterName" // name
        whenever(dataRow.getInt(2)) doReturn 2 // save
        whenever(dataRow.getInt(3)) doReturn 3 // alignment
        whenever(dataRow.getInt(4)) doReturn 0 // base attack bonus
        whenever(dataRow.getInt(5)) doReturn 5 // skill points per level
        whenever(dataRow.getInt(6)) doReturn 6 // hit die
        whenever(dataRow.getInt(7)) doReturn 7 // image id

        // Act
        val characterClass = ClassRowMapper().mapRow(dataRow) as CharacterClass

        // Assert
        assertThat(characterClass.id).isEqualTo(1)
        assertThat(characterClass.name).isEqualTo("myCharacterName")
        assertThat(characterClass.saves).isEqualTo(EnumSet.of(Save.REFLEX))
        assertThat(characterClass.alignments).isEqualTo(EnumSet.of(Alignment.LAWFUL_GOOD, Alignment.NEUTRAL_GOOD))
        assertThat(characterClass.baseAttackBonus).isEqualTo(BaseAttackBonus.POOR)
        assertThat(characterClass.skillPointsPerLevel).isEqualTo(5)
        assertThat(characterClass.hitDie).isEqualTo(Die.D12)
        assertThat(characterClass.imageId).isEqualTo(7)
    }

}