package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistRangerTest {

    private lateinit var ruleService: RuleService

    // Ranger (4), Proficiency: +2, WIS: 12 (+1), Spellcasting - Ranger
    private lateinit var nascan: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        nascan = gameSystem.allCharacters[7]
    }

    @Test
    fun getNumberOfKnownSpells_nascanKnownCantrips_numberOfKnownCantripsIs0() {
        // arrange
        val rangerSpelllistAbility = nascan.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(nascan, rangerSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(0)
    }


    @Test
    fun getNumberOfKnownSpells_nascanKnown1stLevelSpell_numberOfKnown1stLevelIs3() {
        // arrange
        val rangerSpelllistAbility = nascan.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(nascan, rangerSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(3)
    }

    @Test
    fun getNumberOfKnownSpells_nascanKnown2ndLevelSpell_numberOfKnown1stLevelIs0() {
        // arrange
        val rangerSpelllistAbility = nascan.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(nascan, rangerSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_ranger_spellSlotsOfNascan() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(nascan)

        // assert
        assertThat(spellSlots).hasSize(3)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Ranger")).isEqualTo(3)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Ranger (4): | - | 2 | - | - | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun getSpellSaveDifficultyClass_nascan_difficultyClassIs13() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.WISDOM })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(nascan, spellSlot)

        // assert
        assertThat(dc).isEqualTo(12)
    }

}