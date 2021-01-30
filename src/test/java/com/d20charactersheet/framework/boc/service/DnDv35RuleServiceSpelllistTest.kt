package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.School
import com.d20charactersheet.framework.boc.model.SpellSlot
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.util.*

class DnDv35RuleServiceSpelllistTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetMaxSpelllevel() {
        val spelllistAbility = belvador.spelllistAbilities[0]
        val maxSpelllevel = ruleService.getMaxSpelllevel(belvador, spelllistAbility)
        Assert.assertEquals(8, maxSpelllevel.toLong())
    }

    @Test
    fun testGetNumberOfKnownSpellsBard() {
        // Toc Bard (4)
        val spelllistAbility = toc.spelllistAbilities[0]

        // 0.level
        var numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 0)
        Assert.assertEquals(6, numberOfKnownSpells.toLong())

        // 1.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 1)
        Assert.assertEquals(3, numberOfKnownSpells.toLong())

        // 2.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 2)
        Assert.assertEquals(2, numberOfKnownSpells.toLong())

        // 3.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 3)
        Assert.assertEquals(0, numberOfKnownSpells.toLong())
    }

    @Test
    fun testGetNumberOfKnownSpellsCleric() {
        // Kyra Cleric (1)
        val spelllistAbility = kyra.spelllistAbilities[0]

        // 0.level
        var numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, spelllistAbility, 0)
        Assert.assertEquals(12, numberOfKnownSpells.toLong())

        // 1.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, spelllistAbility, 1)
        Assert.assertEquals(31, numberOfKnownSpells.toLong())

        // 2.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, spelllistAbility, 2)
        Assert.assertEquals(0, numberOfKnownSpells.toLong())
    }

    @Test
    fun testGetNumberOfKnownSpellsSorcerer() {
        // Dorn Evenwood Sorcerer (4)
        val spelllistAbility = dorn.spelllistAbilities[0]

        // 0.level
        var numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 0)
        Assert.assertEquals(6, numberOfKnownSpells.toLong())

        // 1.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 1)
        Assert.assertEquals(3, numberOfKnownSpells.toLong())

        // 2.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 2)
        Assert.assertEquals(1, numberOfKnownSpells.toLong())

        // 3.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 3)
        Assert.assertEquals(0, numberOfKnownSpells.toLong())
    }

    @Test
    fun testGetNumberOfKnownSpellsWizard() {
        // Belvador Wizard (5)
        val wizardSpelllistAbility = belvador.spelllistAbilities[0]

        // 0.level
        var numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 0)
        Assert.assertEquals(19, numberOfKnownSpells.toLong())

        // 1.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 1)
        Assert.assertEquals(42, numberOfKnownSpells.toLong())

        // 2.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 2)
        Assert.assertEquals(50, numberOfKnownSpells.toLong())

        // 3.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 3)
        Assert.assertEquals(45, numberOfKnownSpells.toLong())

        // 4.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 4)
        Assert.assertEquals(0, numberOfKnownSpells.toLong())
        val conjurationSpelllistAbility = belvador.spelllistAbilities[1]

        // 0.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 0)
        Assert.assertEquals(19, numberOfKnownSpells.toLong())

        // 1.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 1)
        Assert.assertEquals(42, numberOfKnownSpells.toLong())

        // 2.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 2)
        Assert.assertEquals(50, numberOfKnownSpells.toLong())

        // 3.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 3)
        Assert.assertEquals(45, numberOfKnownSpells.toLong())

        // 4.level
        numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 4)
        Assert.assertEquals(0, numberOfKnownSpells.toLong())
    }

    @Test
    fun testCalculateSpellSlotsOfWizard() {
        // Wizard (5), INT: 18, Spells - Wizard, School Specialisation - Conjuration
        val spellSlots = ruleService.calculateSpellSlots(belvador)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(17, spellSlots.size.toLong())

        // Spells-Wizard_: 4, 3, 2, 1
        // Specialisation: 1, 1, 1, 1
        // Intelli. Bonus: 0, 1, 1, 1
        // Total_________: 5, 5, 4, 3
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(4, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))
        val schoolSpellSlots = RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)
        Assert.assertNotNull(schoolSpellSlots)
        Assert.assertEquals(4, schoolSpellSlots.size.toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 0))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 1))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 2))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 3))

        // number of spells
        // 0. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Detect Magic").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Ray of Frost").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand").toLong())

        // 1. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Mage Armor").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Mount").toLong())
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile").toLong())

        // 2. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Acid Arrow").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Summon Monster II").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Levitate").toLong())

        // 3. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, "Summon Monster II").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, "Summon Monster III").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, "Lightning Bolt").toLong())

        // number of SpelllistAbilities
        Assert.assertEquals(13, RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spells - Wizard").toLong())
        Assert.assertEquals(
            4,
            RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "School Specialization - Conjuration").toLong()
        )

        // number of meta magic feats
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countMetaMagicFeats(spellSlots, "Extend Spell").toLong())
    }

    @Test
    fun testCalculateSpellSlotsOfBard() {
        // Bard (4), CHA: 17, Spells - Bard
        val spellSlots = ruleService.calculateSpellSlots(toc)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(7, spellSlots.size.toLong())

        // Spells-Bard___: 3, 2, 0, -
        // Charisma Bonus: 0, 1, 1, 1
        // Total_________: 3, 3, 1, -
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))

        // number of spells
        // 0. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, SpellSlot.EMPTY_SPELL.name).toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Message").toLong())

        // 1. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name).toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Sleep").toLong())

        // 2. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Invisibility").toLong())
    }

    @Test
    fun testCalculateSpellSlotsOfCleric() {
        // Cleric (1), WIS: 17, Spells - Cleric
        val spellSlots = ruleService.calculateSpellSlots(kyra)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(6, spellSlots.size.toLong())

        // Spells-Cleric_: 3, 1, -, -
        // Healing-Domain: 0, 1, -, -
        // Good-Domain___: 0, 1, -, -
        // Wisdom Bonus__: 0, 1, 1, 1
        // Total_________: 3, 3, -, -
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))
        val domainSpellSlots = RuleServiceSpelllistTestHelper.getDomainSpellSlots(spellSlots)
        Assert.assertNotNull(domainSpellSlots)
        Assert.assertEquals(1, domainSpellSlots.size.toLong())
        val domainSpellSlot = domainSpellSlots[0]
        Assert.assertEquals(2, domainSpellSlot.spelllistAbilities.size.toLong())

        // number of spells
        // 0. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Resistance").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Detect Poison").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Guidance").toLong())

        // 1. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Bless").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Protection from Evil").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Sanctuary").toLong())
    }

    @Test
    fun testCalculateSpellSlotsOfSorcerer() {
        // Sorcerer (4), CHA: 18, Spells - Sorcerer
        val spellSlots = ruleService.calculateSpellSlots(dorn)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(17, spellSlots.size.toLong())

        // Spells-Sorcerer: 6, 6, 3, -, -
        // Wisdom Bonus___: 0, 1, 1, 1, 1
        // Total__________: 6, 7, 4, -, -
        Assert.assertEquals(6, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(7, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(4, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))

        // number of spells
        // 0. level
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Detect Magic").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Acid Splash").toLong())
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, SpellSlot.EMPTY_SPELL.name).toLong())

        // 1. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Shield").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Burning Hands").toLong())
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, SpellSlot.EMPTY_SPELL.name).toLong())

        // 2. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Web").toLong())
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name).toLong())
    }

    @Test
    fun testCalculateSpellSlotsOfWizardAddLevel() {
        // Wizard (6), INT: 18, Spells - Wizard, School Specialisation - Conjuration
        // Spells-Wizard_: 4, 3, 3, 2
        // Specialisation: 1, 1, 1, 1
        // Intelli. Bonus: 0, 1, 1, 1
        // Total_________: 5, 5, 5, 4
        belvador.classLevels[0].level = 6
        val spellSlots = ruleService.calculateSpellSlots(belvador)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(19, spellSlots.size.toLong())
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(4, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))
        val schoolSpellSlots = RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)
        Assert.assertNotNull(schoolSpellSlots)
        Assert.assertEquals(4, schoolSpellSlots.size.toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 0))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 1))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 2))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 3))

        // number of spells
        // 0. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Detect Magic").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Ray of Frost").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Light").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 0, "Mage Hand").toLong())

        // 1. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Mage Armor").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Mount").toLong())
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 1, "Magic Missile").toLong())

        // 2. level
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Acid Arrow").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Summon Monster II").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, "Levitate").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.name).toLong())

        // 3. level
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, "Summon Monster II").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, "Summon Monster III").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, "Lightning Bolt").toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpell(spellSlots, 3, SpellSlot.EMPTY_SPELL.name).toLong())

        // number of SpelllistAbilities
        Assert.assertEquals(15, RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "Spells - Wizard").toLong())
        Assert.assertEquals(
            4,
            RuleServiceSpelllistTestHelper.countSpelllistAbility(spellSlots, "School Specialization - Conjuration").toLong()
        )

        // number of meta magic feats
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countMetaMagicFeats(spellSlots, "Extend Spell").toLong())

        // number of new spell slots
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countNewSpellSlots(spellSlots).toLong())

        // tear down
        belvador.classLevels[0].level = 5
    }

    @Test
    fun testCalculateSpellSlotsOfWizardRemoveLevel() {
        // Wizard (4), INT: 18, Spells - Wizard, School Specialisation - Conjuration
        // Spells-Wizard_: 4, 3, 2, 0
        // Specialisation: 1, 1, 1, 1
        // Intelli. Bonus: 0, 1, 1, 1
        // Total_________: 5, 5, 4, 0
        belvador.classLevels[0].level = 4
        val spellSlots = ruleService.calculateSpellSlots(belvador)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(14, spellSlots.size.toLong())
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(5, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(4, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))
        val schoolSpellSlots = RuleServiceSpelllistTestHelper.getSchoolSpellSlots(spellSlots)
        Assert.assertNotNull(schoolSpellSlots)
        Assert.assertEquals(3, schoolSpellSlots.size.toLong())
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 0))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 1))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 2))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(schoolSpellSlots, 3))

        // number of new spell slots
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countNewSpellSlots(spellSlots).toLong())

        // tear down
        belvador.classLevels[0].level = 5
    }

    @Test
    fun testCreateSpellsPerDaySlots() {
        val spelllistAbility = belvador.spelllistAbilities[0]
        val spellCasterLevel = ruleService.getSpellcasterLevel(belvador, spelllistAbility)
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val spellSlots: List<SpellSlot> = ArrayList()
        dndv35RuleService.createSpellsPerDaySlots(spelllistAbility, spellCasterLevel, spellSlots)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(10, spellSlots.size.toLong())
        Assert.assertEquals(4, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(3, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(2, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4))
    }

    @Test
    fun testCreateAttributeBonusSlots() {
        val spelllistAbility = belvador.spelllistAbilities[0]
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val spellSlots: List<SpellSlot> = ArrayList()
        dndv35RuleService.createAttributeBonusSlots(belvador, spelllistAbility, spellSlots)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(3, spellSlots.size.toLong())
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 0))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 1))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 2))
        Assert.assertEquals(1, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 3))
        Assert.assertEquals(0, RuleServiceSpelllistTestHelper.countSpellSlots(spellSlots, 4))
    }

    @Test
    fun testGetAttributeBonusSlots() {
        assertAttributeBonusSlots(1, intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0))
        assertAttributeBonusSlots(2, intArrayOf(0, 1, 1, 0, 0, 0, 0, 0, 0, 0))
        assertAttributeBonusSlots(5, intArrayOf(0, 2, 1, 1, 1, 1, 0, 0, 0, 0))
        assertAttributeBonusSlots(9, intArrayOf(0, 3, 2, 2, 2, 2, 1, 1, 1, 1))
        assertAttributeBonusSlots(17, intArrayOf(0, 5, 4, 4, 4, 4, 3, 3, 3, 3))
    }

    private fun assertAttributeBonusSlots(modifier: Int, attributeBonusSlots: IntArray) {
        val abstractRuleService = ruleService as AbstractRuleServiceImpl
        for (spellLevel in attributeBonusSlots.indices) {
            Assert.assertEquals(
                "spelllevel: $spellLevel", attributeBonusSlots[spellLevel],
                abstractRuleService.getAttributeBonusSlots(modifier, spellLevel)
            )
        }
    }

    @Test
    fun testGetSpellSelectionOfWizard() {
        // Wizard (5), INT: 18, Spells - Wizard, School Specialisation - Conjuration
        val spellSlots = ruleService.calculateSpellSlots(belvador)

        // Spells - Wizard
        // 0. level
        var spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 0)
        var spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(14, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Arcane Mark", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Magic", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Read Magic", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Prestidigitation", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Resistance", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Ray of Frost", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Poison", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Flare", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Light", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Dancing Lights", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mending", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mage Hand", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Open/Close", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Daze", spells))

        // 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 1)
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(9, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Shield", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Protection from Evil", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mage Armor", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster I", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mount", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Unseen Servant", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Magic Missile", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Charm Person", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Sleep", spells))

        // 2nd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 2)
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(6, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Acid Arrow", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster II", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Knock", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Spider Climb", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Levitate", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Flaming Sphere", spells))

        // 3rd level
        spellSlot =
            RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 3, EnumSet.allOf(School::class.java), arrayOfNulls(0))
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(2, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster III", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Lightning Bolt", spells))

        // 3rd level Metamagic Feat
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(
            spellSlots,
            "Wizard",
            3,
            EnumSet.allOf(School::class.java),
            arrayOf("Extend Spell")
        )
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(6, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Acid Arrow", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster II", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Knock", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Spider Climb", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Levitate", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Flaming Sphere", spells))

        // School Specialisation - Conjuration
        // 0. level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 0, EnumSet.of(School.CONJURATION))
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(0, spells.size.toLong())

        // 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 1, EnumSet.of(School.CONJURATION))
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(4, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mage Armor", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster I", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mount", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Unseen Servant", spells))

        // 2nd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 2, EnumSet.of(School.CONJURATION))
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(2, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Acid Arrow", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster II", spells))

        // 3rd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 3, EnumSet.of(School.CONJURATION))
        spells = ruleService.getSpellSelection(belvador, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(1, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster III", spells))
    }

    @Test
    fun testGetSpellSelectionOfBard() {
        // Bard (4), CHA: 17, Spells - Bard
        val spellSlots = ruleService.calculateSpellSlots(toc)

        // Spells - Bard
        // 0. level
        var spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Bard", 0)
        var spells = ruleService.getSpellSelection(toc, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(6, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Light", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Magic", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Message", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mage Hand", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Open/Close", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Daze", spells))

        // 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Bard", 1)
        spells = ruleService.getSpellSelection(toc, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(3, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Sleep", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Disguise Self", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Charm Person", spells))

        // 2nd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Bard", 2)
        spells = ruleService.getSpellSelection(toc, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(2, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Cure Moderate Wounds", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Invisibility", spells))
    }

    @Test
    fun testGetSpellSelectionOfSorcerer() {
        // Sorcerer (4), CHA: 18, Spells - Sorcerer
        val spellSlots = ruleService.calculateSpellSlots(dorn)

        // Spells - Sorcerer
        // 0. level
        var spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Sorcerer", 0)
        var spells = ruleService.getSpellSelection(dorn, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(6, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Acid Splash", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Dancing Lights", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Magic", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Flare", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mage Hand", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Read Magic", spells))

        // 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Sorcerer", 1)
        spells = ruleService.getSpellSelection(dorn, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(3, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Magic Missile", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Shield", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Burning Hands", spells))

        // 2nd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Sorcerer", 2)
        spells = ruleService.getSpellSelection(dorn, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(1, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Web", spells))
    }

    @Test
    fun testGetSpellSelectionOfCleric() {
        // Cleric (1), WIS: 17, Spells - Cleric, Spells - Good Domain, Spells - Healing Domain
        val spellSlots = ruleService.calculateSpellSlots(kyra)

        // Spells - Cleric
        // 0. level
        var spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Cleric", 0)
        var spells = ruleService.getSpellSelection(kyra, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(12, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Create Water", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Cure Minor Wounds", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Magic", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Poison", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Guidance", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Inflict Minor Wounds", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Light", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Mending", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Purify Food and Drink", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Read Magic", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Resistance", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Virtue", spells))

        // 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Cleric", 1)
        spells = ruleService.getSpellSelection(kyra, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(29, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Bane", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Bless", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Cause Fear", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Bless Water", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Command", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Comprehend Languages", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Cure Light Wounds", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Deathwatch", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Chaos", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Evil", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Good", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Law", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Detect Undead", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Divine Favor", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Doom", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Endure Elements", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Entropic Shield", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Hide from Undead", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Inflict Light Wounds", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Magic Stone", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Magic Weapon", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Obscuring Mist", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Protection from Chaos", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Protection from Evil", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Protection from Law", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Remove Fear", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Sanctuary", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Shield of Faith", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Summon Monster I", spells))

        // Spells - Good Domain, Spells - Healing Domain
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Healing", 1)
        spells = ruleService.getSpellSelection(kyra, spellSlot)
        Assert.assertNotNull(spells)
        Assert.assertEquals(2, spells.size.toLong())
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Protection from Evil", spells))
        Assert.assertTrue(RuleServiceSpelllistTestHelper.containsSpell("Cure Light Wounds", spells))
    }

    @Test
    fun testGetSpellSaveDifficultyClassWizard() {
        val spellSlots = belvador.spellSlots

        // Spells - Wizard, 0th level
        var spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 0, EnumSet.allOf(School::class.java))
        var spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(14, spellSaveDifficultyClass.toLong())

        // Spells - Wizard, 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 1, EnumSet.allOf(School::class.java))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(15, spellSaveDifficultyClass.toLong())

        // Spells - Wizard, 2nd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 2, EnumSet.allOf(School::class.java))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(16, spellSaveDifficultyClass.toLong())

        // Spells - Wizard, 3rd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 3, EnumSet.allOf(School::class.java))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(17, spellSaveDifficultyClass.toLong())

        // School Specialization - Conjuration, 0th level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 0, EnumSet.of(School.CONJURATION))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(14, spellSaveDifficultyClass.toLong())

        // School Specialization - Conjuration, 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 1, EnumSet.of(School.CONJURATION))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(15, spellSaveDifficultyClass.toLong())

        // School Specialization - Conjuration, 2nd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 2, EnumSet.of(School.CONJURATION))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(16, spellSaveDifficultyClass.toLong())

        // School Specialization - Conjuration, 3rd level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Wizard", 3, EnumSet.of(School.CONJURATION))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot)
        Assert.assertEquals(17, spellSaveDifficultyClass.toLong())
    }

    @Test
    fun testGetSpellSaveDifficultyClassCleric() {
        val spellSlots = kyra.spellSlots

        // Spells - Cleric, 0th level
        var spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Cleric", 0, EnumSet.allOf(School::class.java))
        var spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot)
        Assert.assertEquals(13, spellSaveDifficultyClass.toLong())

        // Spells - Cleric, 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Cleric", 1, EnumSet.allOf(School::class.java))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot)
        Assert.assertEquals(14, spellSaveDifficultyClass.toLong())

        // Spells - Good Domain, Spells - Healing Domain, 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Healing", 1, EnumSet.allOf(School::class.java))
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot)
        Assert.assertEquals(14, spellSaveDifficultyClass.toLong())

        // Spells - Good Domain, Spells - Healing Domain, 1st level
        spellSlot = RuleServiceSpelllistTestHelper.getSpellSlot(spellSlots, "Healing", 1, EnumSet.allOf(School::class.java))
        val cureLightWounds = gameSystem.spelllistService.findSpellByName("Cure Light Wounds", gameSystem.allSpells)
        spellSlot.spell = cureLightWounds
        spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot)
        Assert.assertEquals(14, spellSaveDifficultyClass.toLong())
    }

    @Test
    fun testRestOfWizard() {
        val spellSlots = ruleService.rest(belvador)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(0, spellSlots.size.toLong())
    }

    @Test
    fun testRestOfBard() {
        val spellSlots = ruleService.rest(toc)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(3, spellSlots.size.toLong())
        Assert.assertEquals(7, RuleServiceSpelllistTestHelper.countEmptySpellSlots(toc.spellSlots).toLong())
    }

    @Test
    fun testRestOfCleric() {
        val spellSlots = ruleService.rest(kyra)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(0, spellSlots.size.toLong())
    }

    @Test
    fun testRestOfSorcerer() {
        val spellSlots = ruleService.rest(dorn)
        Assert.assertNotNull(spellSlots)
        Assert.assertEquals(10, spellSlots.size.toLong())
        Assert.assertEquals(17, RuleServiceSpelllistTestHelper.countEmptySpellSlots(dorn.spellSlots).toLong())
    }
}