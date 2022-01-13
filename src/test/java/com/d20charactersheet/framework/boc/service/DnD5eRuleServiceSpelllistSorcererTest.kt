package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistSorcererTest {

    private lateinit var ruleService: RuleService

    // Sorcerer (4), Proficiency: +2, CHR: 18 (+4), Spellcasting - Sorcerer
    private lateinit var dorn: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        dorn = gameSystem.allCharacters[8]
    }

    @Test
    fun getNumberOfKnownSpells_dornKnownCantrips_numberOfKnownCantripsIs5() {
        // arrange
        val sorcererSpelllistAbility = dorn.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(dorn, sorcererSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(5)
    }


    @Test
    fun getNumberOfKnownSpells_dornKnown1stLevelSpell_numberOfKnown1stLevelIs5() {
        // arrange
        val sorcererSpelllistAbility = dorn.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, sorcererSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(5)
    }

    @Test
    fun getNumberOfKnownSpells_dornKnown2ndLevelSpell_numberOfKnown1stLevelIs5() {
        // arrange
        val sorcererSpelllistAbility = dorn.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, sorcererSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(5)
    }

    @Test
    fun getNumberOfKnownSpells_dornKnown3rdLevelSpell_numberOfKnown1stLevelIs0() {
        // arrange
        val sorcererSpelllistAbility = dorn.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, sorcererSpelllistAbility, 3)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_sorcerer_spellSlotsOfDorn() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(dorn)

        // assert
        assertThat(spellSlots).hasSize(12)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Sorcerer")).isEqualTo(12)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel:   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Sorcerer (4): | 5 | 4 | 3 | - | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(5)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun getSpellSaveDifficultyClass_dorn_difficultyClassIs13() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.CHARISMA })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(dorn, spellSlot)

        // assert
        assertThat(dc).isEqualTo(14)
    }

}