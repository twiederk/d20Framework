package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistMultiClassTest {

    private lateinit var ruleService: RuleService

    // Wizard (3), Proficiency: +2, INT: 15 (+2), Spellcasting - Wizard
    // Druid (3),  Proficiency: +2, WIS: 14 (+2), Spellcasting - Druid
    private lateinit var linda: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        linda = gameSystem.allCharacters[5]
    }

    @Test
    fun calculateSpellSlots_wizardAndDruid_spellSlotsOfLinda() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        assertThat(spellSlots).hasSize(17)

        // number of SpelllistAbilities
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Druid")).isEqualTo(8)
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Wizard")).isEqualTo(9)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Wizard (3): | 2 | 4 | 2 | - | - | - | - | - | - | - |
        // spells per day table - Druid  (3): | 3 | 4 | 2 | - | - | - | - | - | - | - |

        // 0.level Cantrips
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(5)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Message")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Druidcraft")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Guidance")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, SpellSlot.EMPTY_SPELL.name)).isEqualTo(0)

        // 1.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(8)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Detect Magic")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Disguise Self")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Speak with Animals")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name)).isEqualTo(4)

        // 2.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Levitate")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Flaming Sphere")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun getSpellSaveDifficultyClass_lindaWizard_difficultyClassIs15() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.INTELLIGENCE })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(linda, spellSlot)

        // assert
        assertThat(dc).isEqualTo(13)
    }

    @Test
    fun getSpellSaveDifficultyClass_lindaDruid_difficultyClassIs15() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.WISDOM })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(linda, spellSlot)

        // assert
        assertThat(dc).isEqualTo(13)
    }

    @Test
    fun getSpellSelection_wizardCantrips_spellSelectionOfLindaCantrips() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 0)
        val spells = ruleService.getSpellSelection(linda, spellSlot)

        // 0.level cantrips
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder("Light", "Mage Hand", "Message")
    }

    @Test
    fun getSpellSelection_druidCantrips_spellSelectionOfLindaCantrips() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Druid", 0)
        val spells = ruleService.getSpellSelection(linda, spellSlot)

        // 0.level cantrips
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder("Druidcraft", "Guidance")
    }

    @Test
    fun getSpellSelection_wizardSpelllevel1_spellSelectionOfLindaSpellsOfLevel1() {
        // arrange

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 1)
        val spells = ruleService.getSpellSelection(linda, spellSlot)

        // 1.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Charm Person",
            "Disguise Self",
            "Magic Missile",
            "Sleep"
        )
    }

    @Test
    fun getSpellSelection_druidSpelllevel1_spellSelectionOfLindaSpellsOfLevel1() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Druid", 1)
        val spells = ruleService.getSpellSelection(linda, spellSlot)

        // 1.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Cure Wounds",
            "Entangle",
            "Speak with Animals",
            "Detect Magic",
            "Goodberry"
        )
    }

    @Test
    fun getSpellSelection_wizardSpelllevel2_spellSelectionOfLindaSpellsOfLevel2() {
        // arrange

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 2)
        val spells = ruleService.getSpellSelection(linda, spellSlot)

        // 2.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Charm Person",
            "Disguise Self",
            "Magic Missile",
            "Sleep",
            "Melf's Acid Arrow",
            "Levitate"
        )
    }

    @Test
    fun getSpellSelection_druidSpelllevel2_spellSelectionOfLindaSpellsOfLevel2() {
        // arrange

        // act
        val spellSlots = ruleService.calculateSpellSlots(linda)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Druid", 2)
        val spells = ruleService.getSpellSelection(linda, spellSlot)

        // 2.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Cure Wounds",
            "Entangle",
            "Speak with Animals",
            "Detect Magic",
            "Goodberry",
            "Hold Person",
            "Flaming Sphere"
        )
    }

}