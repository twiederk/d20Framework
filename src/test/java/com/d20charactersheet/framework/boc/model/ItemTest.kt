package com.d20charactersheet.framework.boc.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemTest {

    @Test
    fun equals_sameWeapon_isEqual() {
        // Arrange
        val weapon1 = Weapon().apply { id = 1 }
        val weapon2 = Weapon().apply { id = 1 }

        // Act
        val result = weapon1 == weapon2

        // Assert
        assertThat(result).isTrue
    }

    @Test
    fun equals_differentWeapon_isNotEqual() {
        // Arrange
        val weapon1 = Weapon().apply { id = 1 }
        val weapon2 = Weapon().apply { id = 2 }

        // Act
        val result = weapon1 == weapon2

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_weaponAndArmor_isNotEqual() {
        // Arrange
        val weapon = Weapon().apply { id = 1 }
        val armor = Armor().apply { id = 1 }

        // Act
        val result = weapon == armor

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_weaponAndGood_isNotEqual() {
        // Arrange
        val weapon = Weapon().apply { id = 1 }
        val good = Good().apply { id = 1 }

        // Act
        val result = weapon == good

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_sameArmor_isEqual() {
        // Arrange
        val armor1 = Armor().apply { id = 1 }
        val armor2 = Armor().apply { id = 1 }

        // Act
        val result = armor1 == armor2

        // Assert
        assertThat(result).isTrue
    }


    @Test
    fun equals_differentArmor_isNotEqual() {
        // Arrange
        val armor1 = Armor().apply { id = 1 }
        val armor2 = Armor().apply { id = 2 }

        // Act
        val result = armor1 == armor2

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_armorAndWeapon_isNotEqual() {
        // Arrange
        val armor = Armor().apply { id = 1 }
        val weapon = Weapon().apply { id = 1 }

        // Act
        val result = armor == weapon

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_armorAndGood_isNotEqual() {
        // Arrange
        val armor = Armor().apply { id = 1 }
        val good = Good().apply { id = 1 }

        // Act
        val result = armor == good

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_sameGood_isEqual() {
        // Arrange
        val good1 = Good().apply { id = 1 }
        val good2 = Good().apply { id = 1 }

        // Act
        val result = good1 == good2

        // Assert
        assertThat(result).isTrue
    }


    @Test
    fun equals_differentGood_isNotEqual() {
        // Arrange
        val good1 = Good().apply { id = 1 }
        val good2 = Good().apply { id = 2 }

        // Act
        val result = good1 == good2

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_goodAndWeapon_isNotEqual() {
        // Arrange
        val good = Good().apply { id = 1 }
        val weapon = Weapon().apply { id = 1 }

        // Act
        val result = good == weapon

        // Assert
        assertThat(result).isFalse
    }

    @Test
    fun equals_goodAndArmor_isNotEqual() {
        // Arrange
        val good = Good().apply { id = 1 }
        val armor = Armor().apply { id = 1 }

        // Act
        val result = good == armor

        // Assert
        assertThat(result).isFalse
    }

}