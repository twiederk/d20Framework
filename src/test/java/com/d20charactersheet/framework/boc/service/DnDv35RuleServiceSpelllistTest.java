package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.boc.model.SpellSlot.EMPTY_SPELL;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.containsSpell;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.countEmptySpellSlots;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.countMetaMagicFeats;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.countNewSpellSlots;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.countSpell;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.countSpellSlots;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.countSpelllistAbility;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.getDomainSpellSlots;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.getSchoolSpellSlots;
import static com.d20charactersheet.framework.boc.service.RuleServiceSpelllistTestHelper.getSpellSlot;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;

public class DnDv35RuleServiceSpelllistTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetMaxSpelllevel() {
    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities()
        .get(0);
    final int maxSpelllevel = ruleService.getMaxSpelllevel(belvador, spelllistAbility);
    assertEquals(8, maxSpelllevel);
  }

  @Test
  public void testGetNumberOfKnownSpellsBard() {
    // Toc Bard (4)
    final SpelllistAbility spelllistAbility = toc.getSpelllistAbilities()
        .get(0);

    // 0.level
    int numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 0);
    assertEquals(6, numberOfKnownSpells);

    // 1.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 1);
    assertEquals(3, numberOfKnownSpells);

    // 2.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 2);
    assertEquals(2, numberOfKnownSpells);

    // 3.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(toc, spelllistAbility, 3);
    assertEquals(0, numberOfKnownSpells);
  }

  @Test
  public void testGetNumberOfKnownSpellsCleric() {
    // Kyra Cleric (1)
    final SpelllistAbility spelllistAbility = kyra.getSpelllistAbilities()
        .get(0);

    // 0.level
    int numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, spelllistAbility, 0);
    assertEquals(12, numberOfKnownSpells);

    // 1.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, spelllistAbility, 1);
    assertEquals(31, numberOfKnownSpells);

    // 2.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(kyra, spelllistAbility, 2);
    assertEquals(0, numberOfKnownSpells);
  }

  @Test
  public void testGetNumberOfKnownSpellsSorcerer() {
    // Dorn Evenwood Sorcerer (4)
    final SpelllistAbility spelllistAbility = dorn.getSpelllistAbilities()
        .get(0);

    // 0.level
    int numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 0);
    assertEquals(6, numberOfKnownSpells);

    // 1.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 1);
    assertEquals(3, numberOfKnownSpells);

    // 2.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 2);
    assertEquals(1, numberOfKnownSpells);

    // 3.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(dorn, spelllistAbility, 3);
    assertEquals(0, numberOfKnownSpells);
  }

  @Test
  public void testGetNumberOfKnownSpellsWizard() {
    // Belvador Wizard (5)
    final SpelllistAbility wizardSpelllistAbility = belvador.getSpelllistAbilities()
        .get(0);

    // 0.level
    int numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 0);
    assertEquals(19, numberOfKnownSpells);

    // 1.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 1);
    assertEquals(42, numberOfKnownSpells);

    // 2.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 2);
    assertEquals(50, numberOfKnownSpells);

    // 3.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 3);
    assertEquals(45, numberOfKnownSpells);

    // 4.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, wizardSpelllistAbility, 4);
    assertEquals(0, numberOfKnownSpells);

    final SpelllistAbility conjurationSpelllistAbility = belvador.getSpelllistAbilities().get(1);

    // 0.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 0);
    assertEquals(19, numberOfKnownSpells);

    // 1.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 1);
    assertEquals(42, numberOfKnownSpells);

    // 2.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 2);
    assertEquals(50, numberOfKnownSpells);

    // 3.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 3);
    assertEquals(45, numberOfKnownSpells);

    // 4.level
    numberOfKnownSpells = ruleService.getNumberOfKnownSpells(belvador, conjurationSpelllistAbility, 4);
    assertEquals(0, numberOfKnownSpells);
  }

  @Test
  public void testCalculateSpellSlotsOfWizard() {
    // Wizard (5), INT: 18, Spells - Wizard, School Specialisation - Conjuration
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(belvador);
    assertNotNull(spellSlots);
    assertEquals(17, spellSlots.size());

    // Spells-Wizard_: 4, 3, 2, 1
    // Specialisation: 1, 1, 1, 1
    // Intelli. Bonus: 0, 1, 1, 1
    // Total_________: 5, 5, 4, 3
    assertEquals(5, countSpellSlots(spellSlots, 0));
    assertEquals(5, countSpellSlots(spellSlots, 1));
    assertEquals(4, countSpellSlots(spellSlots, 2));
    assertEquals(3, countSpellSlots(spellSlots, 3));

    final List<SpellSlot> schoolSpellSlots = getSchoolSpellSlots(spellSlots);
    assertNotNull(schoolSpellSlots);
    assertEquals(4, schoolSpellSlots.size());
    assertEquals(1, countSpellSlots(schoolSpellSlots, 0));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 1));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 2));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 3));

    // number of spells
    // 0. level
    assertEquals(2, countSpell(spellSlots, 0, "Detect Magic"));
    assertEquals(1, countSpell(spellSlots, 0, "Ray of Frost"));
    assertEquals(1, countSpell(spellSlots, 0, "Light"));
    assertEquals(1, countSpell(spellSlots, 0, "Mage Hand"));

    // 1. level
    assertEquals(1, countSpell(spellSlots, 1, "Mage Armor"));
    assertEquals(1, countSpell(spellSlots, 1, "Mount"));
    assertEquals(3, countSpell(spellSlots, 1, "Magic Missile"));

    // 2. level
    assertEquals(2, countSpell(spellSlots, 2, "Acid Arrow"));
    assertEquals(1, countSpell(spellSlots, 2, "Summon Monster II"));
    assertEquals(1, countSpell(spellSlots, 2, "Levitate"));

    // 3. level
    assertEquals(1, countSpell(spellSlots, 3, "Summon Monster II"));
    assertEquals(1, countSpell(spellSlots, 3, "Summon Monster III"));
    assertEquals(1, countSpell(spellSlots, 3, "Lightning Bolt"));

    // number of SpelllistAbilities
    assertEquals(13, countSpelllistAbility(spellSlots, "Spells - Wizard"));
    assertEquals(4, countSpelllistAbility(spellSlots, "School Specialization - Conjuration"));

    // number of meta magic feats
    assertEquals(1, countMetaMagicFeats(spellSlots, "Extend Spell"));

  }

  @Test
  public void testCalculateSpellSlotsOfBard() {
    // Bard (4), CHA: 17, Spells - Bard
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(toc);
    assertNotNull(spellSlots);
    assertEquals(7, spellSlots.size());

    // Spells-Bard___: 3, 2, 0, -
    // Charisma Bonus: 0, 1, 1, 1
    // Total_________: 3, 3, 1, -
    assertEquals(3, countSpellSlots(spellSlots, 0));
    assertEquals(3, countSpellSlots(spellSlots, 1));
    assertEquals(1, countSpellSlots(spellSlots, 2));
    assertEquals(0, countSpellSlots(spellSlots, 3));

    // number of spells
    // 0. level
    assertEquals(2, countSpell(spellSlots, 0, EMPTY_SPELL.getName()));
    assertEquals(1, countSpell(spellSlots, 0, "Message"));

    // 1. level
    assertEquals(2, countSpell(spellSlots, 1, EMPTY_SPELL.getName()));
    assertEquals(1, countSpell(spellSlots, 1, "Sleep"));

    // 2. level
    assertEquals(1, countSpell(spellSlots, 2, "Invisibility"));

  }

  @Test
  public void testCalculateSpellSlotsOfCleric() {
    // Cleric (1), WIS: 17, Spells - Cleric
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(kyra);
    assertNotNull(spellSlots);
    assertEquals(6, spellSlots.size());

    // Spells-Cleric_: 3, 1, -, -
    // Healing-Domain: 0, 1, -, -
    // Good-Domain___: 0, 1, -, -
    // Wisdom Bonus__: 0, 1, 1, 1
    // Total_________: 3, 3, -, -
    assertEquals(3, countSpellSlots(spellSlots, 0));
    assertEquals(3, countSpellSlots(spellSlots, 1));
    assertEquals(0, countSpellSlots(spellSlots, 2));
    assertEquals(0, countSpellSlots(spellSlots, 3));

    final List<SpellSlot> domainSpellSlots = getDomainSpellSlots(spellSlots);
    assertNotNull(domainSpellSlots);
    assertEquals(1, domainSpellSlots.size());

    final SpellSlot domainSpellSlot = domainSpellSlots.get(0);
    assertEquals(2, domainSpellSlot.getSpelllistAbilities().size());

    // number of spells
    // 0. level
    assertEquals(1, countSpell(spellSlots, 0, "Resistance"));
    assertEquals(1, countSpell(spellSlots, 0, "Detect Poison"));
    assertEquals(1, countSpell(spellSlots, 0, "Guidance"));

    // 1. level
    assertEquals(1, countSpell(spellSlots, 1, "Bless"));
    assertEquals(1, countSpell(spellSlots, 1, "Protection from Evil"));
    assertEquals(1, countSpell(spellSlots, 1, "Sanctuary"));

  }

  @Test
  public void testCalculateSpellSlotsOfSorcerer() {
    // Sorcerer (4), CHA: 18, Spells - Sorcerer
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(dorn);
    assertNotNull(spellSlots);
    assertEquals(17, spellSlots.size());

    // Spells-Sorcerer: 6, 6, 3, -, -
    // Wisdom Bonus___: 0, 1, 1, 1, 1
    // Total__________: 6, 7, 4, -, -
    assertEquals(6, countSpellSlots(spellSlots, 0));
    assertEquals(7, countSpellSlots(spellSlots, 1));
    assertEquals(4, countSpellSlots(spellSlots, 2));
    assertEquals(0, countSpellSlots(spellSlots, 3));

    // number of spells
    // 0. level
    assertEquals(3, countSpell(spellSlots, 0, "Detect Magic"));
    assertEquals(1, countSpell(spellSlots, 0, "Acid Splash"));
    assertEquals(2, countSpell(spellSlots, 0, EMPTY_SPELL.getName()));

    // 1. level
    assertEquals(2, countSpell(spellSlots, 1, "Magic Missile"));
    assertEquals(1, countSpell(spellSlots, 1, "Shield"));
    assertEquals(1, countSpell(spellSlots, 1, "Burning Hands"));
    assertEquals(3, countSpell(spellSlots, 1, EMPTY_SPELL.getName()));

    // 2. level
    assertEquals(2, countSpell(spellSlots, 2, "Web"));
    assertEquals(2, countSpell(spellSlots, 2, EMPTY_SPELL.getName()));
  }

  @Test
  public void testCalculateSpellSlotsOfWizardAddLevel() {
    // Wizard (6), INT: 18, Spells - Wizard, School Specialisation - Conjuration
    // Spells-Wizard_: 4, 3, 3, 2
    // Specialisation: 1, 1, 1, 1
    // Intelli. Bonus: 0, 1, 1, 1
    // Total_________: 5, 5, 5, 4
    belvador.getClassLevels()
        .get(0)
        .setLevel(6);
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(belvador);
    assertNotNull(spellSlots);
    assertEquals(19, spellSlots.size());

    assertEquals(5, countSpellSlots(spellSlots, 0));
    assertEquals(5, countSpellSlots(spellSlots, 1));
    assertEquals(5, countSpellSlots(spellSlots, 2));
    assertEquals(4, countSpellSlots(spellSlots, 3));

    final List<SpellSlot> schoolSpellSlots = getSchoolSpellSlots(spellSlots);
    assertNotNull(schoolSpellSlots);
    assertEquals(4, schoolSpellSlots.size());
    assertEquals(1, countSpellSlots(schoolSpellSlots, 0));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 1));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 2));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 3));

    // number of spells
    // 0. level
    assertEquals(2, countSpell(spellSlots, 0, "Detect Magic"));
    assertEquals(1, countSpell(spellSlots, 0, "Ray of Frost"));
    assertEquals(1, countSpell(spellSlots, 0, "Light"));
    assertEquals(1, countSpell(spellSlots, 0, "Mage Hand"));

    // 1. level
    assertEquals(1, countSpell(spellSlots, 1, "Mage Armor"));
    assertEquals(1, countSpell(spellSlots, 1, "Mount"));
    assertEquals(3, countSpell(spellSlots, 1, "Magic Missile"));

    // 2. level
    assertEquals(2, countSpell(spellSlots, 2, "Acid Arrow"));
    assertEquals(1, countSpell(spellSlots, 2, "Summon Monster II"));
    assertEquals(1, countSpell(spellSlots, 2, "Levitate"));
    assertEquals(1, countSpell(spellSlots, 2, SpellSlot.EMPTY_SPELL.getName()));

    // 3. level
    assertEquals(1, countSpell(spellSlots, 3, "Summon Monster II"));
    assertEquals(1, countSpell(spellSlots, 3, "Summon Monster III"));
    assertEquals(1, countSpell(spellSlots, 3, "Lightning Bolt"));
    assertEquals(1, countSpell(spellSlots, 3, SpellSlot.EMPTY_SPELL.getName()));

    // number of SpelllistAbilities
    assertEquals(15, countSpelllistAbility(spellSlots, "Spells - Wizard"));
    assertEquals(4, countSpelllistAbility(spellSlots, "School Specialization - Conjuration"));

    // number of meta magic feats
    assertEquals(1, countMetaMagicFeats(spellSlots, "Extend Spell"));

    // number of new spell slots
    assertEquals(2, countNewSpellSlots(spellSlots));

    // tear down
    belvador.getClassLevels().get(0).setLevel(5);
  }

  @Test
  public void testCalculateSpellSlotsOfWizardRemoveLevel() {
    // Wizard (4), INT: 18, Spells - Wizard, School Specialisation - Conjuration
    // Spells-Wizard_: 4, 3, 2, 0
    // Specialisation: 1, 1, 1, 1
    // Intelli. Bonus: 0, 1, 1, 1
    // Total_________: 5, 5, 4, 0
    belvador.getClassLevels()
        .get(0)
        .setLevel(4);
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(belvador);
    assertNotNull(spellSlots);
    assertEquals(14, spellSlots.size());

    assertEquals(5, countSpellSlots(spellSlots, 0));
    assertEquals(5, countSpellSlots(spellSlots, 1));
    assertEquals(4, countSpellSlots(spellSlots, 2));
    assertEquals(0, countSpellSlots(spellSlots, 3));

    final List<SpellSlot> schoolSpellSlots = getSchoolSpellSlots(spellSlots);
    assertNotNull(schoolSpellSlots);
    assertEquals(3, schoolSpellSlots.size());
    assertEquals(1, countSpellSlots(schoolSpellSlots, 0));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 1));
    assertEquals(1, countSpellSlots(schoolSpellSlots, 2));
    assertEquals(0, countSpellSlots(schoolSpellSlots, 3));

    // number of new spell slots
    assertEquals(0, countNewSpellSlots(spellSlots));

    // tear down
    belvador.getClassLevels().get(0).setLevel(5);
  }

  @Test
  public void testCreateSpellsPerDaySlots() {
    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities()
        .get(0);
    final int spellCasterLevel = ruleService.getSpellcasterLevel(belvador, spelllistAbility);
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final List<SpellSlot> spellSlots = new ArrayList<>();
    dndv35RuleService.createSpellsPerDaySlots(spelllistAbility, spellCasterLevel, spellSlots);
    assertNotNull(spellSlots);
    assertEquals(10, spellSlots.size());
    assertEquals(4, countSpellSlots(spellSlots, 0));
    assertEquals(3, countSpellSlots(spellSlots, 1));
    assertEquals(2, countSpellSlots(spellSlots, 2));
    assertEquals(1, countSpellSlots(spellSlots, 3));
    assertEquals(0, countSpellSlots(spellSlots, 4));
  }

  @Test
  public void testCreateAttributeBonusSlots() {
    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities()
        .get(0);
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final List<SpellSlot> spellSlots = new ArrayList<>();
    dndv35RuleService.createAttributeBonusSlots(belvador, spelllistAbility, spellSlots);
    assertNotNull(spellSlots);
    assertEquals(3, spellSlots.size());
    assertEquals(0, countSpellSlots(spellSlots, 0));
    assertEquals(1, countSpellSlots(spellSlots, 1));
    assertEquals(1, countSpellSlots(spellSlots, 2));
    assertEquals(1, countSpellSlots(spellSlots, 3));
    assertEquals(0, countSpellSlots(spellSlots, 4));
  }

  @Test
  public void testGetAttributeBonusSlots() {
    assertAttributeBonusSlots(1, new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
    assertAttributeBonusSlots(2, new int[] {0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    assertAttributeBonusSlots(5, new int[] {0, 2, 1, 1, 1, 1, 0, 0, 0, 0});
    assertAttributeBonusSlots(9, new int[] {0, 3, 2, 2, 2, 2, 1, 1, 1, 1});
    assertAttributeBonusSlots(17, new int[] {0, 5, 4, 4, 4, 4, 3, 3, 3, 3});
  }

  private void assertAttributeBonusSlots(final int modifier, final int[] attributeBonusSlots) {
    final AbstractRuleServiceImpl abstractRuleService = (AbstractRuleServiceImpl) ruleService;
    for (int spellLevel = 0; spellLevel < attributeBonusSlots.length; spellLevel++) {
      assertEquals("spelllevel: " + spellLevel, attributeBonusSlots[spellLevel],
                   abstractRuleService.getAttributeBonusSlots(modifier, spellLevel));
    }
  }

  @Test
  public void testGetSpellSelectionOfWizard() {
    // Wizard (5), INT: 18, Spells - Wizard, School Specialisation - Conjuration
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(belvador);

    // Spells - Wizard
    // 0. level
    SpellSlot spellSlot = getSpellSlot(spellSlots, "Wizard", 0);
    List<Spell> spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(14, spells.size());
    assertTrue(containsSpell("Arcane Mark", spells));
    assertTrue(containsSpell("Detect Magic", spells));
    assertTrue(containsSpell("Read Magic", spells));
    assertTrue(containsSpell("Prestidigitation", spells));
    assertTrue(containsSpell("Resistance", spells));
    assertTrue(containsSpell("Ray of Frost", spells));
    assertTrue(containsSpell("Detect Poison", spells));
    assertTrue(containsSpell("Flare", spells));
    assertTrue(containsSpell("Light", spells));
    assertTrue(containsSpell("Dancing Lights", spells));
    assertTrue(containsSpell("Mending", spells));
    assertTrue(containsSpell("Mage Hand", spells));
    assertTrue(containsSpell("Open/Close", spells));
    assertTrue(containsSpell("Daze", spells));

    // 1st level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 1);
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(9, spells.size());
    assertTrue(containsSpell("Shield", spells));
    assertTrue(containsSpell("Protection from Evil", spells));
    assertTrue(containsSpell("Mage Armor", spells));
    assertTrue(containsSpell("Summon Monster I", spells));
    assertTrue(containsSpell("Mount", spells));
    assertTrue(containsSpell("Unseen Servant", spells));
    assertTrue(containsSpell("Magic Missile", spells));
    assertTrue(containsSpell("Charm Person", spells));
    assertTrue(containsSpell("Sleep", spells));

    // 2nd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 2);
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(6, spells.size());
    assertTrue(containsSpell("Acid Arrow", spells));
    assertTrue(containsSpell("Summon Monster II", spells));
    assertTrue(containsSpell("Knock", spells));
    assertTrue(containsSpell("Spider Climb", spells));
    assertTrue(containsSpell("Levitate", spells));
    assertTrue(containsSpell("Flaming Sphere", spells));

    // 3rd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 3, EnumSet.allOf(School.class), new String[0]);
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(2, spells.size());
    assertTrue(containsSpell("Summon Monster III", spells));
    assertTrue(containsSpell("Lightning Bolt", spells));

    // 3rd level Metamagic Feat
    spellSlot = getSpellSlot(spellSlots, "Wizard", 3, EnumSet.allOf(School.class), new String[] {"Extend Spell"});
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(6, spells.size());
    assertTrue(containsSpell("Acid Arrow", spells));
    assertTrue(containsSpell("Summon Monster II", spells));
    assertTrue(containsSpell("Knock", spells));
    assertTrue(containsSpell("Spider Climb", spells));
    assertTrue(containsSpell("Levitate", spells));
    assertTrue(containsSpell("Flaming Sphere", spells));

    // School Specialisation - Conjuration
    // 0. level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 0, EnumSet.of(School.CONJURATION));
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(0, spells.size());

    // 1st level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 1, EnumSet.of(School.CONJURATION));
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(4, spells.size());
    assertTrue(containsSpell("Mage Armor", spells));
    assertTrue(containsSpell("Summon Monster I", spells));
    assertTrue(containsSpell("Mount", spells));
    assertTrue(containsSpell("Unseen Servant", spells));

    // 2nd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 2, EnumSet.of(School.CONJURATION));
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(2, spells.size());
    assertTrue(containsSpell("Acid Arrow", spells));
    assertTrue(containsSpell("Summon Monster II", spells));

    // 3rd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 3, EnumSet.of(School.CONJURATION));
    spells = ruleService.getSpellSelection(belvador, spellSlot);
    assertNotNull(spells);
    assertEquals(1, spells.size());
    assertTrue(containsSpell("Summon Monster III", spells));
  }

  @Test
  public void testGetSpellSelectionOfBard() {
    // Bard (4), CHA: 17, Spells - Bard
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(toc);

    // Spells - Bard
    // 0. level
    SpellSlot spellSlot = getSpellSlot(spellSlots, "Bard", 0);
    List<Spell> spells = ruleService.getSpellSelection(toc, spellSlot);
    assertNotNull(spells);
    assertEquals(6, spells.size());
    assertTrue(containsSpell("Light", spells));
    assertTrue(containsSpell("Detect Magic", spells));
    assertTrue(containsSpell("Message", spells));
    assertTrue(containsSpell("Mage Hand", spells));
    assertTrue(containsSpell("Open/Close", spells));
    assertTrue(containsSpell("Daze", spells));

    // 1st level
    spellSlot = getSpellSlot(spellSlots, "Bard", 1);
    spells = ruleService.getSpellSelection(toc, spellSlot);
    assertNotNull(spells);
    assertEquals(3, spells.size());
    assertTrue(containsSpell("Sleep", spells));
    assertTrue(containsSpell("Disguise Self", spells));
    assertTrue(containsSpell("Charm Person", spells));

    // 2nd level
    spellSlot = getSpellSlot(spellSlots, "Bard", 2);
    spells = ruleService.getSpellSelection(toc, spellSlot);
    assertNotNull(spells);
    assertEquals(2, spells.size());
    assertTrue(containsSpell("Cure Moderate Wounds", spells));
    assertTrue(containsSpell("Invisibility", spells));

  }

  @Test
  public void testGetSpellSelectionOfSorcerer() {
    // Sorcerer (4), CHA: 18, Spells - Sorcerer
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(dorn);

    // Spells - Sorcerer
    // 0. level
    SpellSlot spellSlot = getSpellSlot(spellSlots, "Sorcerer", 0);
    List<Spell> spells = ruleService.getSpellSelection(dorn, spellSlot);
    assertNotNull(spells);
    assertEquals(6, spells.size());
    assertTrue(containsSpell("Acid Splash", spells));
    assertTrue(containsSpell("Dancing Lights", spells));
    assertTrue(containsSpell("Detect Magic", spells));
    assertTrue(containsSpell("Flare", spells));
    assertTrue(containsSpell("Mage Hand", spells));
    assertTrue(containsSpell("Read Magic", spells));

    // 1st level
    spellSlot = getSpellSlot(spellSlots, "Sorcerer", 1);
    spells = ruleService.getSpellSelection(dorn, spellSlot);
    assertNotNull(spells);
    assertEquals(3, spells.size());
    assertTrue(containsSpell("Magic Missile", spells));
    assertTrue(containsSpell("Shield", spells));
    assertTrue(containsSpell("Burning Hands", spells));

    // 2nd level
    spellSlot = getSpellSlot(spellSlots, "Sorcerer", 2);
    spells = ruleService.getSpellSelection(dorn, spellSlot);
    assertNotNull(spells);
    assertEquals(1, spells.size());
    assertTrue(containsSpell("Web", spells));
  }

  @Test
  public void testGetSpellSelectionOfCleric() {
    // Cleric (1), WIS: 17, Spells - Cleric, Spells - Good Domain, Spells - Healing Domain
    final List<SpellSlot> spellSlots = ruleService.calculateSpellSlots(kyra);

    // Spells - Cleric
    // 0. level
    SpellSlot spellSlot = getSpellSlot(spellSlots, "Cleric", 0);
    List<Spell> spells = ruleService.getSpellSelection(kyra, spellSlot);
    assertNotNull(spells);
    assertEquals(12, spells.size());
    assertTrue(containsSpell("Create Water", spells));
    assertTrue(containsSpell("Cure Minor Wounds", spells));
    assertTrue(containsSpell("Detect Magic", spells));
    assertTrue(containsSpell("Detect Poison", spells));
    assertTrue(containsSpell("Guidance", spells));
    assertTrue(containsSpell("Inflict Minor Wounds", spells));
    assertTrue(containsSpell("Light", spells));
    assertTrue(containsSpell("Mending", spells));
    assertTrue(containsSpell("Purify Food and Drink", spells));
    assertTrue(containsSpell("Read Magic", spells));
    assertTrue(containsSpell("Resistance", spells));
    assertTrue(containsSpell("Virtue", spells));

    // 1st level
    spellSlot = getSpellSlot(spellSlots, "Cleric", 1);
    spells = ruleService.getSpellSelection(kyra, spellSlot);
    assertNotNull(spells);
    assertEquals(29, spells.size());
    assertTrue(containsSpell("Bane", spells));
    assertTrue(containsSpell("Bless", spells));
    assertTrue(containsSpell("Cause Fear", spells));
    assertTrue(containsSpell("Bless Water", spells));
    assertTrue(containsSpell("Command", spells));
    assertTrue(containsSpell("Comprehend Languages", spells));
    assertTrue(containsSpell("Cure Light Wounds", spells));
    assertTrue(containsSpell("Deathwatch", spells));
    assertTrue(containsSpell("Detect Chaos", spells));
    assertTrue(containsSpell("Detect Evil", spells));
    assertTrue(containsSpell("Detect Good", spells));
    assertTrue(containsSpell("Detect Law", spells));
    assertTrue(containsSpell("Detect Undead", spells));
    assertTrue(containsSpell("Divine Favor", spells));
    assertTrue(containsSpell("Doom", spells));
    assertTrue(containsSpell("Endure Elements", spells));
    assertTrue(containsSpell("Entropic Shield", spells));
    assertTrue(containsSpell("Hide from Undead", spells));
    assertTrue(containsSpell("Inflict Light Wounds", spells));
    assertTrue(containsSpell("Magic Stone", spells));
    assertTrue(containsSpell("Magic Weapon", spells));
    assertTrue(containsSpell("Obscuring Mist", spells));
    assertTrue(containsSpell("Protection from Chaos", spells));
    assertTrue(containsSpell("Protection from Evil", spells));
    assertTrue(containsSpell("Protection from Law", spells));
    assertTrue(containsSpell("Remove Fear", spells));
    assertTrue(containsSpell("Sanctuary", spells));
    assertTrue(containsSpell("Shield of Faith", spells));
    assertTrue(containsSpell("Summon Monster I", spells));

    // Spells - Good Domain, Spells - Healing Domain
    spellSlot = getSpellSlot(spellSlots, "Healing", 1);
    spells = ruleService.getSpellSelection(kyra, spellSlot);
    assertNotNull(spells);
    assertEquals(2, spells.size());
    assertTrue(containsSpell("Protection from Evil", spells));
    assertTrue(containsSpell("Cure Light Wounds", spells));
  }

  @Test
  public void testGetSpellSaveDifficultyClassWizard() {
    final List<SpellSlot> spellSlots = belvador.getSpellSlots();

    // Spells - Wizard, 0th level
    SpellSlot spellSlot = getSpellSlot(spellSlots, "Wizard", 0, EnumSet.allOf(School.class));
    int spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(14, spellSaveDifficultyClass);

    // Spells - Wizard, 1st level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 1, EnumSet.allOf(School.class));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(15, spellSaveDifficultyClass);

    // Spells - Wizard, 2nd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 2, EnumSet.allOf(School.class));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(16, spellSaveDifficultyClass);

    // Spells - Wizard, 3rd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 3, EnumSet.allOf(School.class));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(17, spellSaveDifficultyClass);

    // School Specialization - Conjuration, 0th level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 0, EnumSet.of(School.CONJURATION));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(14, spellSaveDifficultyClass);

    // School Specialization - Conjuration, 1st level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 1, EnumSet.of(School.CONJURATION));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(15, spellSaveDifficultyClass);

    // School Specialization - Conjuration, 2nd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 2, EnumSet.of(School.CONJURATION));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(16, spellSaveDifficultyClass);

    // School Specialization - Conjuration, 3rd level
    spellSlot = getSpellSlot(spellSlots, "Wizard", 3, EnumSet.of(School.CONJURATION));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(belvador, spellSlot);
    assertEquals(17, spellSaveDifficultyClass);

  }

  @Test
  public void testGetSpellSaveDifficultyClassCleric() {
    final List<SpellSlot> spellSlots = kyra.getSpellSlots();

    // Spells - Cleric, 0th level
    SpellSlot spellSlot = getSpellSlot(spellSlots, "Cleric", 0, EnumSet.allOf(School.class));
    int spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot);
    assertEquals(13, spellSaveDifficultyClass);

    // Spells - Cleric, 1st level
    spellSlot = getSpellSlot(spellSlots, "Cleric", 1, EnumSet.allOf(School.class));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot);
    assertEquals(14, spellSaveDifficultyClass);

    // Spells - Good Domain, Spells - Healing Domain, 1st level
    spellSlot = getSpellSlot(spellSlots, "Healing", 1, EnumSet.allOf(School.class));
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot);
    assertEquals(14, spellSaveDifficultyClass);

    // Spells - Good Domain, Spells - Healing Domain, 1st level
    spellSlot = getSpellSlot(spellSlots, "Healing", 1, EnumSet.allOf(School.class));
    final Spell cureLightWounds = gameSystem.getSpelllistService().findSpellByName("Cure Light Wounds", gameSystem.getAllSpells());
    spellSlot.setSpell(cureLightWounds);
    spellSaveDifficultyClass = ruleService.getSpellSaveDifficultyClass(kyra, spellSlot);
    assertEquals(14, spellSaveDifficultyClass);
  }

  @Test
  public void testRestOfWizard() {
    final List<SpellSlot> spellSlots = ruleService.rest(belvador);
    assertNotNull(spellSlots);
    assertEquals(0, spellSlots.size());
  }

  @Test
  public void testRestOfBard() {
    final List<SpellSlot> spellSlots = ruleService.rest(toc);
    assertNotNull(spellSlots);
    assertEquals(3, spellSlots.size());
    assertEquals(7, countEmptySpellSlots(toc.getSpellSlots()));
  }

  @Test
  public void testRestOfCleric() {
    final List<SpellSlot> spellSlots = ruleService.rest(kyra);
    assertNotNull(spellSlots);
    assertEquals(0, spellSlots.size());
  }

  @Test
  public void testRestOfSorcerer() {
    final List<SpellSlot> spellSlots = ruleService.rest(dorn);
    assertNotNull(spellSlots);
    assertEquals(10, spellSlots.size());
    assertEquals(17, countEmptySpellSlots(dorn.getSpellSlots()));
  }

}
