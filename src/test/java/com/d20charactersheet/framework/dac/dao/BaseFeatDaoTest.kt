package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Character
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

abstract class BaseFeatDaoTest {

    protected lateinit var characterDao: CharacterDao
    protected lateinit var featDao: FeatDao

    @Test
    fun testGetAllFeats() {

        // Act
        val allFeats = featDao.getAllFeats()

        // Assert
        assertThat(allFeats).hasSize(109)
    }

    @Test
    fun testGetFeatsOfCharacter() {
        // Arrange
        val belvador = Character()
        belvador.id = 0

        // Act
        val characterFeats = characterDao.getCharacterFeats(belvador, featDao.getAllFeats())

        // Assert
        assertThat(characterFeats).hasSize(3)
    }
}