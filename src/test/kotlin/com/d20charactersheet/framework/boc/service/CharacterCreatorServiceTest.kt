package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.Die
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class CharacterCreatorServiceTest {

    @Test
    fun rollAttributeWithStandardMethod_roll4d6_sumOf3highestRolls() {
        // Arrange
        Die.setRandom(Random(1))
        val underTest = CharacterCreatorServiceImpl()

        // Act
        val attributeScore = underTest.rollAttributeWithStandardMethod()

        // Assert
        assertThat(attributeScore).isEqualTo(13)
    }

}