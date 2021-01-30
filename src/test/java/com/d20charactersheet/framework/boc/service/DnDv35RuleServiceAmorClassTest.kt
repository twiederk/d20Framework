package com.d20charactersheet.framework.boc.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnDv35RuleServiceAmorClassTest : DnDv35RuleServiceTestCase() {

    @Test
    fun getArmorClass_belvador_armorClass() {
        // Act
        val armorClass = ruleService.getArmorClass(belvador)

        // Assert
        assertThat(armorClass).isEqualTo(14)
    }

    @Test
    fun calculateFlatFooted_belvador_armorClassWithoutDexterity() {
        // Act
        val armorClass = ruleService.calculateFlatFootedArmorClass(belvador)

        // Assert
        assertThat(armorClass).isEqualTo(10)
    }

    @Test
    fun calculateTouchArmorClass_belvador_armorClassWithDexterityOnly() {
        // Act
        val armorClass = ruleService.calculateTouchArmorClass(belvador)

        // Assert
        assertThat(armorClass).isEqualTo(14)
    }

    @Test
    fun getArmorClass_nascan_armorClass() {
        // Act
        val armorClass = ruleService.getArmorClass(nascan)

        // Assert
        assertThat(armorClass).isEqualTo(18)
    }

    @Test
    fun calculateFlatFooted_nascan_armorClassWithoutDexterity() {
        // Act
        val armorClass = ruleService.calculateFlatFootedArmorClass(nascan)

        // Assert
        assertThat(armorClass).isEqualTo(15)
    }

    @Test
    fun calculateTouchArmorClass_nascan_armorClassWithDexterityOnly() {
        // Act
        val armorClass = ruleService.calculateTouchArmorClass(nascan)

        // Assert
        assertThat(armorClass).isEqualTo(13)
    }


    @Test
    fun getArmorClass_tocDerJuengere_armorClass() {
        // Act
        val armorClass = ruleService.getArmorClass(toc)

        // Assert
        assertThat(armorClass).isEqualTo(16)
    }

    @Test
    fun calculateFlatFooted_tocDerJuengere_armorClassWithoutDexterity() {
        // Act
        val armorClass = ruleService.calculateFlatFootedArmorClass(toc)

        // Assert
        assertThat(armorClass).isEqualTo(13)
    }

    @Test
    fun calculateTouchArmorClass_tocDerJuengere_armorClassWithDexterityOnly() {
        // Act
        val armorClass = ruleService.calculateTouchArmorClass(toc)

        // Assert
        assertThat(armorClass).isEqualTo(13)
    }

}