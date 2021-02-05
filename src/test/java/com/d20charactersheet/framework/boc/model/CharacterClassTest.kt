package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CharacterClassTest {

    @Test
    fun initCharacterClass_classAbilitiesAreEmpty() {
        // Arrange

        // Act
        val clazz = CharacterClass()

        // Assert
        assertThat(clazz.classAbilities).isEmpty()
    }

}