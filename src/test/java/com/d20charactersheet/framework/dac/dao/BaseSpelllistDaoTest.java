package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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

public abstract class BaseSpelllistDaoTest {

  private static final int SPELL_ID_ACID_ARROW = 1;
  private static final int SPELLLIST_ID_CLERIC = 1;

  protected SpelllistDao spelllistDao;

  @Test
  public void testGetAllSpells() {
    final List<Spell> allSpells = spelllistDao.getAllSpells();
    assertNotNull(allSpells);
    assertEquals(606, allSpells.size());
    final Spell acidArrow = getSpellById(SPELL_ID_ACID_ARROW, allSpells);
    final String description = spelllistDao.getSpellDescription(acidArrow.getId());
    acidArrow.setDescription(description);
    assertSpell(acidArrow);
  }

  private Spell getSpellById(final int spellId, final List<Spell> allSpells) {
    for (final Spell spell : allSpells) {
      if (spell.getId() == spellId) {
        return spell;
      }
    }
    throw new IllegalArgumentException("Can't get spell with id: " + spellId);
  }

  private void assertSpell(final Spell spell) {
    // id, name, school, components, castingTime, range, effect, duration, savingThrow, spellresistance,
    // description, materialComponent, focus
    assertEquals("Acid Arrow", spell.getName());
    assertEquals(School.CONJURATION, spell.getSchool());
    assertEquals(SubSchool.CREATION, spell.getSubSchool());
    assertEquals(1, spell.getDescriptors().length);
    assertEquals(Descriptor.ACID, spell.getDescriptors()[0]);
    assertTrue("Verbal component is wrong", spell.isVerbal());
    assertTrue("Somatic component is wrong", spell.isSomatic());
    assertTrue("Material component is wrong", spell.isMaterial());
    assertTrue("Focus component is wrong", spell.isFocus());
    assertFalse("Divine focus component is wrong", spell.isDivineFocus());
    assertFalse("XP Cost component is wrong", spell.isXpCost());
    assertEquals(CastingTime.ONE_STANDARD_ACTION, spell.getCastingTime());
    assertEquals(Range.LONG, spell.getRange());
    assertEquals("One arrow of acid", spell.getEffect());
    assertEquals("1 round + 1 round per three levels", spell.getDuration());
    assertEquals(SpellResistance.NO, spell.getSpellResistance());
    assertEquals("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.", spell.getShortDescription());
    assertEquals(
        "A magical arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels (to a maximum of 18th), the acid, unless somehow neutralized, lasts for another round, dealing another 2d4 points of damage in that round.",
        spell.getDescription());
    assertEquals("Powdered rhubarb leaf and an adder's stomach.", spell.getMaterialComponent());
    assertEquals("A dart.", spell.getFocus());
  }

  @Test
  public void testGetAllSpelllists() {
    final List<Spell> allSpells = spelllistDao.getAllSpells();
    final List<Spelllist> allSpelllists = spelllistDao.getAllSpelllists(allSpells);
    assertNotNull(allSpelllists);
    assertEquals(31, allSpelllists.size());

    final Spelllist clericSpelllist = getSpelllistById(allSpelllists, SPELLLIST_ID_CLERIC);
    assertSpelllist(clericSpelllist);
  }

  private Spelllist getSpelllistById(final List<Spelllist> allSpelllists, final int spelllistId) {
    for (final Spelllist spelllist : allSpelllists) {
      if (spelllist.getId() == spelllistId) {
        return spelllist;
      }
    }
    throw new IllegalArgumentException("Can't find spelllist with id: " + spelllistId);
  }

  private void assertSpelllist(final Spelllist spelllist) {
    assertEquals("Cleric", spelllist.getName());
    assertEquals("Clr", spelllist.getShortname());
    assertFalse(spelllist.isDomain());
    assertEquals(0, spelllist.getMinLevel());
    assertEquals(9, spelllist.getMaxLevel());
    assertEquals(10, spelllist.getNumberOfSpellLevels());
    assertEquals(12, spelllist.getSpellsOfLevel(0).size());
    assertEquals(31, spelllist.getSpellsOfLevel(1).size());
    assertEquals(32, spelllist.getSpellsOfLevel(2).size());
    assertEquals(34, spelllist.getSpellsOfLevel(3).size());
    assertEquals(23, spelllist.getSpellsOfLevel(4).size());
    assertEquals(27, spelllist.getSpellsOfLevel(5).size());
    assertEquals(26, spelllist.getSpellsOfLevel(6).size());
    assertEquals(18, spelllist.getSpellsOfLevel(7).size());
    assertEquals(17, spelllist.getSpellsOfLevel(8).size());
    assertEquals(11, spelllist.getSpellsOfLevel(9).size());
    assertEquals(231, spelllist.getAllSpells().size());
  }

  @Test
  public void testCreateAndDeleteSpell() {
    Spell spell = new Spell();
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

    spell = spelllistDao.createSpell(spell);
    assertNotNull(spell);
    assertTrue(spell.getId() > 0);

    final List<Spell> allSpells = spelllistDao.getAllSpells();
    assertNotNull(allSpells);
    assertEquals(607, allSpells.size());

    final Spell newSpell = getSpellById(spell.getId(), allSpells);

    final String description = spelllistDao.getSpellDescription(newSpell.getId());
    newSpell.setDescription(description);

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

    spelllistDao.deleteSpell(newSpell);
  }

  @Test
  public void testGetAllKnownSpellsTables() {
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();
    assertNotNull(allKnownSpellsTables);
    assertEquals(4, allKnownSpellsTables.size());

    // Check Bard known spells
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 16th 6 5 4 4 4 4 2 - - -
    KnownSpellsTable knownSpellsTable = allKnownSpellsTables.get(0);
    assertKnownSpellsTable(knownSpellsTable, "Bard", 16,
                           new int[] {6, 5, 4, 4, 4, 4, 2, KnownSpellsTable.NO_ACCESS, KnownSpellsTable.NO_ACCESS,
                               KnownSpellsTable.NO_ACCESS
                           });

    // Check Sorcerer known spells
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 18th 9 5 5 4 4 4 3 3 2 1
    knownSpellsTable = allKnownSpellsTables.get(1);
    assertKnownSpellsTable(knownSpellsTable, "Sorcerer", 18, new int[] {9, 5, 5, 4, 4, 4, 3, 3, 2, 1});

    // Check Unlimited known spells
    // 1st 10 10 10 10 10 10 10 10 10 10
    knownSpellsTable = allKnownSpellsTables.get(2);
    assertKnownSpellsTable(knownSpellsTable, "Unlimited", 18,
                           new int[] {KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                               KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                               KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                               KnownSpellsTable.UNLIMITED,
                           });

  }

  private void assertKnownSpellsTable(final KnownSpellsTable knownSpellsTable, final String name, final int spellcasterLevel,
      final int[] knownSpells) {
    assertEquals(name, knownSpellsTable.getName());
    for (int i = 0; i < knownSpells.length; i++) {
      assertEquals(knownSpells[i], knownSpellsTable.getKnownSpells(spellcasterLevel, i));
    }
  }

  @Test
  public void testGetAllSpellsPerDayTables() {
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();
    assertNotNull(allSpellsPerDayTables);
    assertEquals(8, allSpellsPerDayTables.size());

    // Check Bard spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 16th 6 5 4 4 4 4 2 - - -
    SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(0);
    assertSpellsPerDayTable(spellsPerDayTable, "Bard", 16,
                            new int[] {4, 4, 4, 3, 3, 2, 0, SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS,
                                SpellsPerDayTable.NO_ACCESS
                            });

    // Check Ranger spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 14th - 2 1 1 0 - - - - -
    spellsPerDayTable = allSpellsPerDayTables.get(1);
    assertSpellsPerDayTable(spellsPerDayTable, "Ranger", 14,
                            new int[] {SpellsPerDayTable.NO_ACCESS, 2, 1, 1, 0, SpellsPerDayTable.NO_ACCESS,
                                SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS,
                                SpellsPerDayTable.NO_ACCESS
                            });

    // Check Sorcerer spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 18th 6 6 6 6 6 6 6 6 5 3
    spellsPerDayTable = allSpellsPerDayTables.get(2);
    assertSpellsPerDayTable(spellsPerDayTable, "Sorcerer", 18, new int[] {6, 6, 6, 6, 6, 6, 6, 6, 5, 3});

    // Check Wizard spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 17th 4 4 4 4 4 4 4 3 2 1
    spellsPerDayTable = allSpellsPerDayTables.get(3);
    assertSpellsPerDayTable(spellsPerDayTable, "Wizard", 17, new int[] {4, 4, 4, 4, 4, 4, 4, 3, 2, 1});

  }

  private void assertSpellsPerDayTable(final SpellsPerDayTable spellsPerDayTable, final String name, final int spellcasterLevel,
      final int[] spellsPerDay) {
    assertEquals(name, spellsPerDayTable.getName());
    for (int i = 0; i < spellsPerDay.length; i++) {
      assertEquals(spellsPerDay[i], spellsPerDayTable.getSpellsPerDay(spellcasterLevel, i));
    }
  }
}
