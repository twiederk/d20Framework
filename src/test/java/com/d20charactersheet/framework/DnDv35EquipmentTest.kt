package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnDv35EquipmentTest {

    private val gameSystem: GameSystem = DnDv35Universe().gameSystem

    @Test
    fun getAllWeapon() {

        // Act
        val allWeapons = gameSystem.allWeapons

        // Assert
        assertThat(allWeapons).hasSize(110)
    }

    @Test
    fun getAllArmor() {

        // Act
        val allArmor = gameSystem.allArmor

        // Assert
        assertThat(allArmor).hasSize(38)
    }

    @Test
    fun getAllGoods() {

        // Act
        val allGoods = gameSystem.allGoods

        // Assert
        assertThat(allGoods).hasSize(131)
    }

    @Test
    fun getAllEquipmentPacks() {

        // Act
        val allPacks = gameSystem.allEquipmentPacks

        // Assert
        assertThat(allPacks).hasSize(7)
    }

}