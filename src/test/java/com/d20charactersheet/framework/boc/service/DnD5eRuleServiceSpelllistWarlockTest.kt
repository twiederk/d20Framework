package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistWarlockTest {

    private lateinit var ruleService: RuleService

    // Warlock (6), Proficiency: +3, CHR: 18 (+4), Pact Magic
    private lateinit var balthus: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        balthus = gameSystem.allCharacters[9]
    }

    @Test
    fun getNumberOfKnownSpells_balthusKnownCantrips_numberOfKnownCantripsIs3() {
        // arrange
        val warlockSpelllistAbility = balthus.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(balthus, warlockSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(3)
    }


    @Test
    fun getNumberOfKnownSpells_balthusKnown1stLevelSpell_numberOfKnown1stLevelIs7() {
        // arrange
        val warlockSpelllistAbility = balthus.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(balthus, warlockSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(7)
    }

    @Test
    fun getNumberOfKnownSpells_balthusKnown2ndLevelSpell_numberOfKnown1stLevelIs7() {
        // arrange
        val warlockSpelllistAbility = balthus.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(balthus, warlockSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(7)
    }

    @Test
    fun getNumberOfKnownSpells_balthusKnown3rdLevelSpell_numberOfKnown1stLevelIs7() {
        // arrange
        val warlockSpelllistAbility = balthus.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(balthus, warlockSpelllistAbility, 3)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(7)
    }

    @Test
    fun getNumberOfKnownSpells_balthusKnown4thLevelSpell_numberOfKnown1stLevelIs0() {
        // arrange
        val warlockSpelllistAbility = balthus.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(balthus, warlockSpelllistAbility, 4)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_warlock_spellSlotsOfBalthus() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(balthus)

        // assert
        assertThat(spellSlots).hasSize(5)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Pact Magic")).isEqualTo(5)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel:  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Warlock (4): | 3 | 0 | 0 | 2 | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(2)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun getSpellSaveDifficultyClass_balthus_difficultyClassIs13() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.CHARISMA })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(balthus, spellSlot)

        // assert
        assertThat(dc).isEqualTo(15)
    }

    @Test
    fun getSpellSelection_warlockCantrips_spellSelectionOfBalthusCantrips() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(balthus)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Warlock", 0)
        val spells = ruleService.getSpellSelection(balthus, spellSlot)

        // 0.level cantrips
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder("Mage Hand", "Chill Touch", "Eldritch Blast")
    }

    @Test
    fun getSpellSelection_warlockSpelllevel3_spellSelectionOfBalthusSpelllevel3() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(balthus)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Warlock", 3)
        val spells = ruleService.getSpellSelection(balthus, spellSlot)

        // 0.level cantrips
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Faerie Fire",
            "Hellish Rebuke",
            "Shatter",
            "Vampiric Touch"
        )
    }

}