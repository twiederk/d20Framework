package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistPaladinTest {

    private lateinit var ruleService: RuleService

    // Paladin (6), Proficiency: +3, CHA: 14 (+2), Spellcasting - Paladin
    private lateinit var pala: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        pala = gameSystem.allCharacters[4]
    }

    @Test
    fun getNumberOfKnownSpells_palaKnownCantrips_numberOfKnownCantripsIs0() {
        // arrange
        val paladinSpelllistAbility = pala.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(pala, paladinSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(0)
    }

    @Test
    fun getNumberOfKnownSpells_palaKnown1stLevelSpell_numberOfKnown1stLevelIs5() {
        // arrange
        val paladinSpelllistAbility = pala.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(pala, paladinSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(5)
    }

    @Test
    fun getNumberOfKnownSpells_palaKnown2ndLevelSpell_numberOfKnown1stLevelIs5() {
        // arrange
        val paladinSpelllistAbility = pala.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(pala, paladinSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(5)
    }

    @Test
    fun getNumberOfKnownSpells_palaKnown3rdndLevelSpell_numberOfKnown1stLevelIs0() {
        // arrange
        val paladinSpelllistAbility = pala.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(pala, paladinSpelllistAbility, 3)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_pala_spellSlotsOfPala() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(pala)

        // assert
        assertThat(spellSlots).hasSize(6)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Paladin")).isEqualTo(6)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Paladin (6): | 4 | 2 | - | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(2)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun getSpellSaveDifficultyClass_pala_difficultyClassIs13() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.CHARISMA })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(pala, spellSlot)

        // assert
        assertThat(dc).isEqualTo(13)
    }

}