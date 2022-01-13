package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.SpellSlot
import com.d20charactersheet.framework.boc.model.SpelllistAbility
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSpelllistWizardTest {

    private lateinit var ruleService: RuleService

    // Wizard (5), Proficiency: +3, INT: 18 (+4), Spellcasting - Wizard
    private lateinit var belvador: Character

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        belvador = gameSystem.allCharacters[0]
    }


    @Test
    fun getMaxSpelllevel_belvador_maxSpelllevelIs9() {
        // arrange
        val spelllistAbility = belvador.spelllistAbilities[0]

        // act
        val maxSpelllevel = ruleService.getMaxSpelllevel(belvador, spelllistAbility)

        // assert
        assertThat(maxSpelllevel).isEqualTo(9)
    }

    @Test
    fun getNumberOfKnownSpells_belvadorKnownCantrips_numberOfKnownCantripsIs4() {
        // arrange
        val wizardSpelllistAbility = belvador.spelllistAbilities[0]

        // act
        val numberOfKnownCantrips = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 0)

        // assert
        assertThat(numberOfKnownCantrips).isEqualTo(4)
    }

    @Test
    fun getNumberOfKnownSpells_belvadorKnown1stLevelSpell_numberOfKnown1stLevelIs9() {
        // arrange
        val wizardSpelllistAbility = belvador.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 1)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(9)
    }

    @Test
    fun getNumberOfKnownSpells_belvadorKnown2ndLevelSpell_numberOfKnown2ndLevelIs9() {
        // arrange
        val wizardSpelllistAbility = belvador.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 2)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(9)
    }

    @Test
    fun getNumberOfKnownSpells_belvadorKnown3rdLevelSpell_numberOfKnown3rdLevelIs9() {
        // arrange
        val wizardSpelllistAbility = belvador.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 3)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(9)
    }

    @Test
    fun getNumberOfKnownSpells_belvadorKnown4thLevelSpell_numberOfKnown4thLevelIs0() {
        // arrange
        val wizardSpelllistAbility = belvador.spelllistAbilities[0]

        // act
        val numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 4)

        // assert
        assertThat(numberOfKnownSpells).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_wizard_spellSlotsOfBelvador() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        assertThat(spellSlots).hasSize(13)

        // number of SpelllistAbilities
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Wizard")).isEqualTo(13)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Wizard (5): | 4 | 4 | 3 | 2 | - | - | - | - | - | - |
        // 0.level Cantrips
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Dancing Lights")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Ray of Frost")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, SpellSlot.EMPTY_SPELL.name)).isEqualTo(0)


        // 1.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Detect Magic")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        // 2.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Melf's Acid Arrow")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        // 3.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(2)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun getSpellSaveDifficultyClass_belvador_difficultyClassIs15() {

        // arrange
        val spellSlot = SpellSlot().apply {
            spelllistAbilities = listOf(SpelllistAbility().apply { spellAttribute = Attribute.INTELLIGENCE })
        }

        // act
        val dc = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)

        // assert
        assertThat(dc).isEqualTo(15)
    }

    @Test
    fun getSpellSelection_wizardCantrips_spellSelectionOfBelvadorCantrips() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 0)
        val spells = ruleService.getSpellSelection(belvador, spellSlot)

        // 0.level cantrips
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder("Dancing Lights", "Light", "Mage Hand", "Ray of Frost")
    }

    @Test
    fun getSpellSelection_wizardSpelllevel1_spellSelectionOfBelvadorSpellsOfLevel1() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 1)
        val spells = ruleService.getSpellSelection(belvador, spellSlot)

        // 1.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Detect Magic",
            "Charm Person",
            "Mage Armor",
            "Magic Missile",
            "Protection from Evil and Good",
            "Shield",
            "Sleep",
            "Unseen Servant"
        )
    }

    @Test
    fun getSpellSelection_wizardSpelllevel2_spellSelectionOfBelvadorSpellsOfLevel2() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 2)
        val spells = ruleService.getSpellSelection(belvador, spellSlot)

        // 2.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Detect Magic",
            "Charm Person",
            "Mage Armor",
            "Magic Missile",
            "Protection from Evil and Good",
            "Shield",
            "Sleep",
            "Unseen Servant",
            "Melf's Acid Arrow",
            "Flaming Sphere",
            "Knock",
            "Spider Climb",
            "Levitate"
        )
    }

    @Test
    fun getSpellSelection_wizardSpelllevel3_spellSelectionOfBelvadorSpellsOfLevel3() {

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        val spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 3)
        val spells = ruleService.getSpellSelection(belvador, spellSlot)

        // 3.level spells
        assertThat(spells.map { it.name }).containsExactlyInAnyOrder(
            "Detect Magic",
            "Charm Person",
            "Mage Armor",
            "Magic Missile",
            "Protection from Evil and Good",
            "Shield",
            "Sleep",
            "Unseen Servant",
            "Melf's Acid Arrow",
            "Flaming Sphere",
            "Knock",
            "Spider Climb",
            "Levitate",
            "Fireball",
            "Lightning Bolt"
        )
    }

    @Test
    fun calculateSpellSlots_addLevel_spellSlotsOfAdditionalLevel() {
        // arrange
        belvador.classLevels[0].level = 6

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        assertThat(spellSlots).hasSize(14)

        // number of SpelllistAbilities
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Wizard")).isEqualTo(14)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Wizard (5): | 4 | 4 | 3 | 2 | - | - | - | - | - | - |
        // spells per day table - Wizard (6): | 4 | 4 | 3 | 3 | - | - | - | - | - | - |
        // 0.level Cantrips
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Dancing Lights")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Ray of Frost")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, SpellSlot.EMPTY_SPELL.name)).isEqualTo(0)


        // 1.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Detect Magic")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        // 2.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Melf's Acid Arrow")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        // 3.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, SpellSlot.EMPTY_SPELL.name)).isEqualTo(3)

        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun calculateSpellSlots_removeLevel_spellSlotsOfRemovedLevel() {
        // arrange
        belvador.classLevels[0].level = 4

        // act
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // assert
        assertThat(spellSlots).hasSize(11)

        // number of SpelllistAbilities
        assertThat(RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spellcasting - Wizard")).isEqualTo(11)

        // number of spell slots of SpelllistAbility
        assertThat(RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)).isEmpty()

        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Wizard (4): | 4 | 4 | 3 | - | - | - | - | - | - | - |
        // spells per day table - Wizard (5): | 4 | 4 | 3 | 2 | - | - | - | - | - | - |
        // 0.level Cantrips
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Dancing Lights")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Ray of Frost")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, SpellSlot.EMPTY_SPELL.name)).isEqualTo(0)


        // 1.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Detect Magic")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        // 2.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Melf's Acid Arrow")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        // 3.level Spells
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

    @Test
    fun rest_wizard_allSpellSlotsAreEmpty() {

        // act
        val spellSlots = ruleService.rest(belvador)

        // assert
        // spells per day table - Spelllevel: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
        // spells per day table - Wizard (5): | 4 | 4 | 3 | 2 | - | - | - | - | - | - |
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Dancing Lights")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand")).isEqualTo(1)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Ray of Frost")).isEqualTo(1)

        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name)).isEqualTo(4)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name)).isEqualTo(3)
        assertThat(RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, SpellSlot.EMPTY_SPELL.name)).isEqualTo(2)

        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 5)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 6)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 7)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 8)).isEqualTo(0)
        assertThat(RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 9)).isEqualTo(0)
    }

}