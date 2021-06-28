package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Die
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class CharacterCreatorServiceTest {

    private val underTest = CharacterCreatorServiceImpl()

    @Test
    fun rollAttributeWithStandardMethod_roll4d6_sumOf3highestRolls() {
        // Arrange
        Die.setRandom(Random(1))

        // Act
        val attributeScore = underTest.rollAttributeWithStandardMethod()

        // Assert
        assertThat(attributeScore).isEqualTo(13)
    }

}