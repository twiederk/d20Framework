package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistClericTest {

    private lateinit var ruleService: RuleService

    // Cleric (1), Proficiency: +2, WIS: 17 (+3), Spellcasting - Cleric
    private lateinit var kyra: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        kyra = gameSystem.allCharacters[2]
    }

    @Test
    fun getNumberOfKnownSpells_kyraKnownCantrips_numberOfKnownCantripsIs3() {
        // arrange
        val clericSpelllistAbility = kyra.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(kyra, clericSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(3)
    }

    @Test
    fun getNumberOfKnownSpells_kyraKnown1stLevelSpell_numberOfKnown1stLevelIs4() {
        // arrange
        val clericSpelllistAbility = kyra.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, clericSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(4)
    }

    @Test
    fun calculateSpellSlots_cleric_spellSlotsOfKyra() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(kyra)

        // assert
        assertThat(spellSlots).hasSize(5)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Cleric")).isEqualTo(5)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Cleric (1): | 3 | 2 | - | - | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(2)
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
    fun getSpellSaveDifficultyClass_kyra_difficultyClassIs13() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.WISDOM })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot)

        // assert
        assertThat(dc).isEqualTo(13)
    }

}