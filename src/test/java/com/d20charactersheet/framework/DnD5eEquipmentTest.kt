package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eEquipmentTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getAllWeapon() {

        // Act
        val allWeapons = gameSystem.allWeapons

        // Assert
        assertThat(allWeapons).hasSize(47)
    }

    @Test
    fun getAllArmor() {

        // Act
        val allArmor = gameSystem.allArmor

        // Assert
        assertThat(allArmor).hasSize(13)
    }

    @Test
    fun getAllGoods() {

        // Act
        val allGoods = gameSystem.allGoods

        // Assert
        assertThat(allGoods).hasSize(158)
    }

}