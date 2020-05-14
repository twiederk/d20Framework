package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellStorage.SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_TABLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.CastingTime;
import com.d20charactersheet.framework.boc.model.Descriptor;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Range;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellResistance;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.boc.model.SubSchool;
import com.d20charactersheet.framework.dac.dao.dummy.DummySpelllistDao;

public class SpelllistServiceTest {

  private SpelllistService spelllistService;

  @Before
  public void setUp() {
    spelllistService = new SpelllistServiceImpl(
        new DummySpelllistDao(SPELL, SPELLLIST, SPELLLIST_SPELL, KNOWN_SPELLS_TABLE, KNOWN_SPELLS_LEVEL, SPELLS_PER_DAY_TABLE,
                              SPELLS_PER_DAY_LEVEL));
  }

  @Test
  public void testGetAllSpells() {
    final List<Spell> allSpells = spelllistService.getAllSpells();
    assertNotNull(allSpells);
    assertEquals(606, allSpells.size());
  }

  @Test
  public void testGetAllSpellllists() {
    final List<Spell> allSpells = spelllistService.getAllSpells();
    final List<Spelllist> allSpelllists = spelllistService.getAllSpelllists(allSpells);
    assertNotNull(allSpelllists);
    assertEquals(31, allSpelllists.size());
  }

  @Test
  public void testGetSpellDescription() {
    Spell spell = new Spell();
    spell.setId(1);

    spell = spelllistService.getSpellDescription(spell);
    assertNotNull(spell);
    assertNotNull(spell.getDescription());
    assertTrue(spell.getDescription().startsWith("A magical arrow of acid springs from your hand"));
  }

  @Test
  public void testCreateAndDeleteSpell() {
    Spell spell = createSpell();

    spell = spelllistService.createSpell(spell);

    assertNotNull(spell);
    assertTrue(spell.getId() > 0);

    final Spell newSpell = spelllistService.findSpellById(spell.getId(), spelllistService.getAllSpells());

    assertEquals("testName", newSpell.getName());
    assertEquals(School.CONJURATION, newSpell.getSchool());
    assertEquals(SubSchool.CALLING, newSpell.getSubSchool());
    final Descriptor[] descriptors = new Descriptor[] {Descriptor.ACID};
    assertEquals(1, descriptors.length);
    assertEquals(Descriptor.ACID, descriptors[0]);
    assertTrue(newSpell.isVerbal());
    assertTrue(newSpell.isSomatic());
    assertTrue(newSpell.isMaterial());
    assertTrue(newSpell.isFocus());
    assertEquals(CastingTime.ONE_STANDARD_ACTION, newSpell.getCastingTime());
    assertEquals(Range.LONG, newSpell.getRange());
    assertEquals("one arrow of acid", newSpell.getEffect());
    assertEquals("1 round + 1 round per three levels", newSpell.getDuration());
    assertEquals("none", newSpell.getSavingThrow());
    assertEquals(SpellResistance.NO, newSpell.getSpellResistance());
    assertTrue(newSpell.getDescription().startsWith("An arrow of acid springs from your hand and speeds to its target."));
    assertEquals("Powdered rhubarb leaf and an adder's stomach.", newSpell.getMaterialComponent());
    assertEquals("A dart.", newSpell.getFocus());
    assertEquals("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.", newSpell.getShortDescription());

    spelllistService.deleteSpell(newSpell);
    assertEquals(606, spelllistService.getAllSpells().size());
  }

  private Spell createSpell() {
    final Spell spell = new Spell();
    spell.setName("testName");
    spell.setSchool(School.CONJURATION);
    spell.setSubSchool(SubSchool.CALLING);
    spell.setDescriptors(new Descriptor[] {Descriptor.ACID});
    spell.setVerbal(true);
    spell.setSomatic(true);
    spell.setMaterial(true);
    spell.setFocus(true);
    spell.setCastingTime(CastingTime.ONE_STANDARD_ACTION);
    spell.setRange(Range.LONG);
    spell.setEffect("one arrow of acid");
    spell.setDuration("1 round + 1 round per three levels");
    spell.setSavingThrow("none");
    spell.setSpellResistance(SpellResistance.NO);
    spell.setDescription(
        "An arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels you possess, the acid, unless neutralized, lasts for another round (to a maximum of 6 additional rounds at 18th level), dealing another 2d4 points of damage in each round.");
    spell.setMaterialComponent("Powdered rhubarb leaf and an adder's stomach.");
    spell.setFocus("A dart.");
    spell.setShortDescription("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.");
    return spell;
  }

  @Test
  public void testCreateAndDeleteSpelllist() {
    Spelllist spelllist = new Spelllist();
    spelllist.setName("testName");
    spelllist.setShortname("testShortname");

    spelllist = spelllistService.createSpelllist(spelllist);
    assertNotNull(spelllist);
    assertTrue(spelllist.getId() > 0);

    final Spelllist newSpelllist = spelllistService
        .findSpelllistById(spelllist.getId(), spelllistService.getAllSpelllists(spelllistService.getAllSpells()));

    assertEquals("testName", newSpelllist.getName());
    assertEquals("testShortname", newSpelllist.getShortname());

    spelllistService.deleteSpelllist(spelllist);
    final List<Spelllist> allSpelllists = spelllistService.getAllSpelllists(spelllistService.getAllSpells());
    assertEquals(31, allSpelllists.size());
  }

  @Test
  public void createSpelllevel_spellNewToEmptySpelllist_spellAdded() {
    // Arrange
    Spell spell = new Spell();
    spell.setId(1);

    // Act
    boolean result = spelllistService.createSpelllevel(new Spelllist(), spell, 1);

    // Assert
    assertTrue(result);
  }

  @Test
  public void createSpelllevel_spellNewToSpelllist_spellAdded() {
    // Arrange
    Spell existingSpell = new Spell();
    existingSpell.setId(1);

    List<Spell> spells = new ArrayList<>();
    spells.add(existingSpell);

    Map<Integer, List<Spell>> spellsByLevel = new HashMap<>();
    spellsByLevel.put(1, spells);

    Spelllist spelllist = new Spelllist();
    spelllist.setSpellsByLevel(spellsByLevel);
    spelllistService.createSpelllevel(spelllist, existingSpell, 1);

    Spell newSpell = new Spell();
    newSpell.setId(2);

    // Act
    boolean result = spelllistService.createSpelllevel(new Spelllist(), newSpell, 1);

    // Assert
    assertTrue(result);
  }

  @Test
  public void createSpelllevel_spellAlreadyPartOfSpelllist_spellNotAdded() {
    // Arrange
    Spell spell = new Spell();
    spell.setId(1);

    List<Spell> spells = new ArrayList<>();
    spells.add(spell);

    Map<Integer, List<Spell>> spellsByLevel = new HashMap<>();
    spellsByLevel.put(1, spells);

    Spelllist spelllist = new Spelllist();
    spelllist.setSpellsByLevel(spellsByLevel);
    spelllistService.createSpelllevel(spelllist, spell, 1);

    // Act
    boolean result = spelllistService.createSpelllevel(spelllist, spell, 1);

    // Assert
    assertFalse(result);
  }

  @Test
  public void testUpdateSpelllist() {
    final Spelllist spelllist = spelllistService.getAllSpelllists(spelllistService.getAllSpells()).get(0);

    final String originalName = spelllist.getName();
    final String originalShortname = spelllist.getShortname();

    spelllist.setName("testUpdateName");
    spelllist.setShortname("testUpdateShortname");

    spelllistService.updateSpelllist(spelllist);

    final Spelllist updatedSpelllist = spelllistService
        .findSpelllistById(spelllist.getId(), spelllistService.getAllSpelllists(spelllistService.getAllSpells()));

    assertEquals("testUpdateName", updatedSpelllist.getName());
    assertEquals("testUpdateShortname", updatedSpelllist.getShortname());

    // tear down
    updatedSpelllist.setName(originalName);
    updatedSpelllist.setShortname(originalShortname);

    spelllistService.updateSpelllist(updatedSpelllist);

  }

  @Test
  public void testGetAllKnownSpellsTables() {
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistService.getAllKnownSpellsTables();
    assertNotNull(allKnownSpellsTables);
    assertEquals(4, allKnownSpellsTables.size());
  }

  @Test
  public void testGetAllSpellsPerDayTables() {
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistService.getAllSpellsPerDayTables();
    assertNotNull(allSpellsPerDayTables);
    assertEquals(8, allSpellsPerDayTables.size());
  }
}
