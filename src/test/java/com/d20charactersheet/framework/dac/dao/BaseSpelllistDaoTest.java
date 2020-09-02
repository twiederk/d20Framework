package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

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

    // Act
    final List<Spell> allSpells = spelllistDao.getAllSpells();

    // Assert
    assertThat(allSpells).hasSize(606);
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
    assertThat(spell.getName()).isEqualTo("Acid Arrow");
    assertThat(spell.getSchool()).isEqualTo(School.CONJURATION);
    assertThat(spell.getSubSchool()).isEqualTo(SubSchool.CREATION);
    assertThat(spell.getDescriptors()).hasSize(1);
    assertThat(spell.getDescriptors()[0]).isEqualTo(Descriptor.ACID);
    assertThat(spell.isVerbal()).isTrue();
    assertThat(spell.isSomatic()).isTrue();
    assertThat(spell.isMaterial()).isTrue();
    assertThat(spell.isFocus()).isTrue();
    assertThat(spell.isDivineFocus()).isFalse();
    assertThat(spell.isXpCost()).isFalse();
    assertThat(spell.getCastingTime()).isEqualTo(CastingTime.ONE_STANDARD_ACTION);
    assertThat(spell.getRange()).isEqualTo(Range.LONG);
    assertThat(spell.getEffect()).isEqualTo("One arrow of acid");
    assertThat(spell.getDuration()).isEqualTo("1 round + 1 round per three levels");
    assertThat(spell.getSpellResistance()).isEqualTo(SpellResistance.NO);
    assertThat(spell.getShortDescription()).isEqualTo("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.");
    assertThat(spell.getDescription()).isEqualTo(
        "A magical arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels (to a maximum of 18th), the acid, unless somehow neutralized, lasts for another round, dealing another 2d4 points of damage in that round.");
    assertThat(spell.getMaterialComponent()).isEqualTo("Powdered rhubarb leaf and an adder's stomach.");
    assertThat(spell.getFocus()).isEqualTo("A dart.");
  }

  @Test
  public void testGetAllSpelllists() {
    // Arrange
    final List<Spell> allSpells = spelllistDao.getAllSpells();

    // Act
    final List<Spelllist> allSpelllists = spelllistDao.getAllSpelllists(allSpells);

    // Assert
    assertThat(allSpelllists).hasSize(31);

    final Spelllist clericSpelllist = getSpelllistById(allSpelllists);
    assertSpelllist(clericSpelllist);
  }

  private Spelllist getSpelllistById(final List<Spelllist> allSpelllists) {
    for (final Spelllist spelllist : allSpelllists) {
      if (spelllist.getId() == BaseSpelllistDaoTest.SPELLLIST_ID_CLERIC) {
        return spelllist;
      }
    }
    throw new IllegalArgumentException("Can't find spelllist with id: " + BaseSpelllistDaoTest.SPELLLIST_ID_CLERIC);
  }

  private void assertSpelllist(final Spelllist spelllist) {
    assertThat(spelllist.getName()).isEqualTo("Cleric");
    assertThat(spelllist.getShortname()).isEqualTo("Clr");
    assertThat(spelllist.isDomain()).isFalse();
    assertThat(spelllist.getMinLevel()).isEqualTo(0);
    assertThat(spelllist.getMaxLevel()).isEqualTo(9);
    assertThat(spelllist.getNumberOfSpellLevels()).isEqualTo(10);
    assertThat(spelllist.getSpellsOfLevel(0)).hasSize(12);
    assertThat(spelllist.getSpellsOfLevel(1)).hasSize(31);
    assertThat(spelllist.getSpellsOfLevel(2)).hasSize(32);
    assertThat(spelllist.getSpellsOfLevel(3)).hasSize(34);
    assertThat(spelllist.getSpellsOfLevel(4)).hasSize(23);
    assertThat(spelllist.getSpellsOfLevel(5)).hasSize(27);
    assertThat(spelllist.getSpellsOfLevel(6)).hasSize(26);
    assertThat(spelllist.getSpellsOfLevel(7)).hasSize(18);
    assertThat(spelllist.getSpellsOfLevel(8)).hasSize(17);
    assertThat(spelllist.getSpellsOfLevel(9)).hasSize(11);
    assertThat(spelllist.getAllSpells()).hasSize(231);
  }

  @Test
  public void testCreateAndDeleteSpell() {
    // Arrange
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

    // Act
    spell = spelllistDao.createSpell(spell);

    // Assert
    assertThat(spell).isNotNull();
    assertThat(spell.getId()).isGreaterThan(0);

    final List<Spell> allSpells = spelllistDao.getAllSpells();
    assertThat(allSpells).hasSize(607);

    final Spell newSpell = getSpellById(spell.getId(), allSpells);

    final String description = spelllistDao.getSpellDescription(newSpell.getId());
    newSpell.setDescription(description);

    assertThat(newSpell.getName()).isEqualTo("testName");
    assertThat(newSpell.getSchool()).isEqualTo(School.CONJURATION);
    assertThat(newSpell.getSubSchool()).isEqualTo(SubSchool.CALLING);
    final Descriptor[] descriptors = new Descriptor[] {Descriptor.ACID};
    assertThat(descriptors).hasSize(1);
    assertThat(descriptors[0]).isEqualTo(Descriptor.ACID);
    assertThat(newSpell.isVerbal()).isTrue();
    assertThat(newSpell.isSomatic()).isTrue();
    assertThat(newSpell.isMaterial()).isTrue();
    assertThat(newSpell.isFocus()).isTrue();
    assertThat(newSpell.getCastingTime()).isEqualTo(CastingTime.ONE_STANDARD_ACTION);
    assertThat(newSpell.getRange()).isEqualTo(Range.LONG);
    assertThat(newSpell.getEffect()).isEqualTo("one arrow of acid");
    assertThat(newSpell.getDuration()).isEqualTo("1 round + 1 round per three levels");
    assertThat(newSpell.getSavingThrow()).isEqualTo("none");
    assertThat(newSpell.getSpellResistance()).isEqualTo(SpellResistance.NO);
    assertThat(newSpell.getDescription()).startsWith("An arrow of acid springs from your hand and speeds to its target.");
    assertThat(newSpell.getMaterialComponent()).isEqualTo("Powdered rhubarb leaf and an adder's stomach.");
    assertThat(newSpell.getFocus()).isEqualTo("A dart.");
    assertThat(newSpell.getShortDescription()).isEqualTo("Ranged touch attack, 2d4 damage for 1 round +1 round/three levels.");

    // tear down
    spelllistDao.deleteSpell(newSpell);
  }

  @Test
  public void testGetAllKnownSpellsTables() {
    // Act
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();

    // Assert
    assertThat(allKnownSpellsTables).hasSize(4);
  }

  @Test
  public void testGetAllKnownSpellsTables_checkBardKnownSpells() {
    // Arrange
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();

    // Act
    KnownSpellsTable knownSpellsTable = allKnownSpellsTables.get(0);

    // Assert
    // Check Bard known spells
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 16th 6 5 4 4 4 4 2 - - -
    assertKnownSpellsTable(knownSpellsTable, "Bard", 16,
                           new int[] {6, 5, 4, 4, 4, 4, 2, KnownSpellsTable.NO_ACCESS, KnownSpellsTable.NO_ACCESS,
                               KnownSpellsTable.NO_ACCESS
                           });
  }

  @Test
  public void testGetAllKnownSpellsTables_checkSorcererKnownSpells() {
    // Arrange
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();

    // Act
    KnownSpellsTable knownSpellsTable = allKnownSpellsTables.get(1);

    // Assert
    // Check Sorcerer known spells
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 18th 9 5 5 4 4 4 3 3 2 1
    assertKnownSpellsTable(knownSpellsTable, "Sorcerer", 18, new int[] {9, 5, 5, 4, 4, 4, 3, 3, 2, 1});
  }

  @Test
  public void testGetAllKnownSpellsTables_checkUnlimitedKnownSpells() {
    // Arrange
    final List<KnownSpellsTable> allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables();

    // Act
    KnownSpellsTable knownSpellsTable = allKnownSpellsTables.get(2);

    // Assert
    // Check Unlimited known spells
    // 1st 10 10 10 10 10 10 10 10 10 10
    assertKnownSpellsTable(knownSpellsTable, "Unlimited", 18,
                           new int[] {KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                               KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                               KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED, KnownSpellsTable.UNLIMITED,
                               KnownSpellsTable.UNLIMITED,
                           });
  }

  private void assertKnownSpellsTable(final KnownSpellsTable knownSpellsTable, final String name, final int spellcasterLevel,
      final int[] knownSpells) {
    assertThat(knownSpellsTable.getName()).isEqualTo(name);
    for (int i = 0; i < knownSpells.length; i++) {
      assertThat(knownSpellsTable.getKnownSpells(spellcasterLevel, i)).isEqualTo(knownSpells[i]);
    }
  }

  @Test
  public void testGetAllSpellsPerDayTables() {

    // Act
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    // Assert
    assertThat(allSpellsPerDayTables).hasSize(8);
  }

  @Test
  public void testGetAllSpellsPerDayTables_checkBardSpellsPerDay() {
    // Arrange
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    // Act
    SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(0);

    // Assert
    // Check Bard spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 16th 6 5 4 4 4 4 2 - - -
    assertSpellsPerDayTable(spellsPerDayTable, "Bard", 16,
                            new int[] {4, 4, 4, 3, 3, 2, 0, SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS,
                                SpellsPerDayTable.NO_ACCESS
                            });

  }

  @Test
  public void testGetAllSpellsPerDayTables_checkRangerSpellsPerDay() {
    // Arrange
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    // Act
    SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(1);

    // Assert
    // Check Ranger spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 14th - 2 1 1 0 - - - - -
    assertSpellsPerDayTable(spellsPerDayTable, "Ranger", 14,
                            new int[] {SpellsPerDayTable.NO_ACCESS, 2, 1, 1, 0, SpellsPerDayTable.NO_ACCESS,
                                SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS, SpellsPerDayTable.NO_ACCESS,
                                SpellsPerDayTable.NO_ACCESS
                            });
  }

  @Test
  public void testGetAllSpellsPerDayTables_checkSorcererSpellsPerDay() {
    // Arrange
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    // Act
    SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(2);

    // Assert
    // Check Sorcerer spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 18th 6 6 6 6 6 6 6 6 5 3
    assertSpellsPerDayTable(spellsPerDayTable, "Sorcerer", 18, new int[] {6, 6, 6, 6, 6, 6, 6, 6, 5, 3});
  }

  @Test
  public void testGetAllSpellsPerDayTables_checkWizardSpellsPerDay() {
    // Arrange
    final List<SpellsPerDayTable> allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables();

    // Act
    SpellsPerDayTable spellsPerDayTable = allSpellsPerDayTables.get(3);

    // Assert
    // Check Wizard spells per day
    // Lev. 0 1 2 3 4 5 6 7 8 9
    // 17th 4 4 4 4 4 4 4 3 2 1
    assertSpellsPerDayTable(spellsPerDayTable, "Wizard", 17, new int[] {4, 4, 4, 4, 4, 4, 4, 3, 2, 1});
  }

  private void assertSpellsPerDayTable(final SpellsPerDayTable spellsPerDayTable, final String name, final int spellcasterLevel,
      final int[] spellsPerDay) {
    assertThat(spellsPerDayTable.getName()).isEqualTo(name);
    for (int i = 0; i < spellsPerDay.length; i++) {
      assertThat(spellsPerDayTable.getSpellsPerDay(spellcasterLevel, i)).isEqualTo(spellsPerDay[i]);
    }
  }
}
