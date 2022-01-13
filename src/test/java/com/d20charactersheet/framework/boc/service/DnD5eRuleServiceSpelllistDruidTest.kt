package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistDruidTest {

    private lateinit var ruleService: RuleService

    // Druid (3), Proficiency: +2, WIS: 15 (+2), Spellcasting - Druid
    private lateinit var miraculix: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        miraculix = gameSystem.allCharacters[3]
    }

    @Test
    fun getNumberOfKnownSpells_miraculixKnownCantrips_numberOfKnownCantripsIs3() {
        // arrange
        val druidSpelllistAbility = miraculix.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(miraculix, druidSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(2)
    }

    @Test
    fun getNumberOfKnownSpells_miraculixKnown1stLevelSpell_numberOfKnown1stLevelIs5() {
        // arrange
        val druidSpelllistAbility = miraculix.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(miraculix, druidSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(5)
    }

    @Test
    fun getNumberOfKnownSpells_miraculixKnown2ndLevelSpell_numberOfKnown1stLevelIs5() {
        // arrange
        val druidSpelllistAbility = miraculix.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(miraculix, druidSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(5)
    }

    @Test
    fun getNumberOfKnownSpells_miraculixKnown3rdndLevelSpell_numberOfKnown1stLevelIs0() {
        // arrange
        val druidSpelllistAbility = miraculix.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(miraculix, druidSpelllistAbility, 3)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_miraculix_spellSlotsOfMiraculix() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(miraculix)

        // assert
        assertThat(spellSlots).hasSize(8)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Druid")).isEqualTo(8)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Druid (3):  | 2 | 4 | 2 | - | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(2)
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
    fun getSpellSaveDifficultyClass_miraculix_difficultyClassIs12() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.WISDOM })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(miraculix, spellSlot)

        // assert
        assertThat(dc).isEqualTo(12)
    }

}