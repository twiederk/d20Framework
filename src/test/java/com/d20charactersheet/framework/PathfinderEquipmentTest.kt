package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PathfinderEquipmentTest {

    private val gameSystem: GameSystem = PathfinderUniverse().gameSystem

    @Test
    fun getAllWeapon() {

        // Act
        val allWeapons = gameSystem.allWeapons

        // Assert
        assertThat(allWeapons).hasSize(163)
    }

    @Test
    fun getAllArmor() {

        // Act
        val allArmor = gameSystem.allArmor

        // Assert
        assertThat(allArmor).hasSize(64)
    }

    @Test
    fun getAllGoods() {

        // Act
        val allGoods = gameSystem.allGoods

        // Assert
        assertThat(allGoods).hasSize(219)
    }

    @Test
    fun getAllEquipmentPacks() {

        // Act
        val allPacks = gameSystem.allEquipmentPacks

        // Assert
        assertThat(allPacks).hasSize(7)
    }

}