package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistBardTest {

    private lateinit var ruleService: RuleService

    // Bard (4), Proficiency: +2, CHA: 17 (+3), Spellcasting - Bard
    private lateinit var toc: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        toc = gameSystem.allCharacters[6]
    }

    @Test
    fun getNumberOfKnownSpells_tocKnownCantrips_numberOfKnownCantripsIs3() {
        // arrange
        val bardSpelllistAbility = toc.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(toc, bardSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(3)
    }

    @Test
    fun getNumberOfKnownSpells_tocKnown1stLevelSpell_numberOfKnown1stLevelIs7() {
        // arrange
        val bardSpelllistAbility = toc.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, bardSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(7)
    }

    @Test
    fun getNumberOfKnownSpells_tocKnown2ndLevelSpell_numberOfKnown1stLevelIs7() {
        // arrange
        val bardSpelllistAbility = toc.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, bardSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(7)
    }

    @Test
    fun calculateSpellSlots_bard_spellSlotsOfToc() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(toc)

        // assert
        assertThat(spellSlots).hasSize(10)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Bard")).isEqualTo(10)

        // number of spell slots of a special school
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Bard (4):   | 3 | 4 | 3 | - | - | - | - | - | - | - |
        // number of spell slots per spell level
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(3)
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
    fun getSpellSaveDifficultyClass_toc_difficultyClassIs13() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.CHARISMA })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(toc, spellSlot)

        // assert
        assertThat(dc).isEqualTo(13)
    }

    @Test
    fun getSpellSelection_bardCantrips_spellSelectionOfTocCantrips() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(toc)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Bard", 0)
        val spells = ruleService.getSpellSelection(toc, spellSlot)

        // 0.level cantrips
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder("Light", "Mage Hand", "Message")
    }

    @Test
    fun getSpellSelection_bardSpelllevel1_spellSelectionOfTocSpellsOfLevel1() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(toc)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Bard", 1)
        val spells = ruleService.getSpellSelection(toc, spellSlot)

        // 1.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder("Sleep", "Disguise Self", "Charm Person", "Cure Wounds")
    }

    @Test
    fun getSpellSelection_bardSpelllevel2_spellSelectionOfTocSpellsOfLevel2() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(toc)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Bard", 2)
        val spells = ruleService.getSpellSelection(toc, spellSlot)

        // 1.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Sleep",
            "Disguise Self",
            "Charm Person",
            "Cure Wounds",
            "Invisibility",
            "Knock",
            "Detect Thoughts"
        )
    }

    @Test
    fun rest_bard_allSpellSlotsAreEmpty() {

        // act
        val spellSlots = ruleService.rest(toc)

        // assert
        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Bard (4):   | 3 | 4 | 3 | - | - | - | - | - | - | - |
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Message")).isEqualTo(1)

        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name)).isEqualTo(3)

        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

}