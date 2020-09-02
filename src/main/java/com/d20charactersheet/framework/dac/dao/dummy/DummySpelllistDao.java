package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.androidash.memorydb.DaoUtil;
import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.dao.SpelllistDao;
import com.d20charactersheet.framework.dac.dao.util.SpellSerializor;

/**
 * Implements SpelllistDao in Memory.
 */
public class DummySpelllistDao implements SpelllistDao {

  private final DataTable spellTable;
  private final DataTable spelllistTable;
  private DataTable spelllistSpellTable;
  private final DataTable knownSpellsTablesTable;
  private final DataTable knownSpellsLevelTable;
  private final SpellSerializor spellSerializor;
  private final DataTable spellsPerDayTablesTable;
  private final DataTable spellsPerDayLevelTable;

  private final DaoUtil daoUtil;

  /**
   * Instanciates DummySpelllistDao with data of SpellStorage.
   *
   * @param spell
   *     Spell raw data.
   * @param spelllist
   *     Spell list raw data.
   * @param spelllistSpell
   *     Spell list to spell raw data.
   * @param knownSpellsTable
   *     Known spells table raw data.
   * @param knownSpellsLevel
   *     Known spell levels raw data.
   * @param spellsPerDayTable
   *     Spells per day table raw data.
   * @param spellsPerDayLevel
   *     Spells per day levels raw data.
   */
  public DummySpelllistDao(final Object[][] spell, final Object[][] spelllist, final Object[][] spelllistSpell,
      final Object[][] knownSpellsTable, final Object[][] knownSpellsLevel, final Object[][] spellsPerDayTable,
      final Object[][] spellsPerDayLevel) {
    spellTable = new DataTable(spell);
    spelllistTable = new DataTable(spelllist);
    spelllistSpellTable = new DataTable(spelllistSpell);
    spellSerializor = new SpellSerializor();
    knownSpellsTablesTable = new DataTable(knownSpellsTable);
    knownSpellsLevelTable = new DataTable(knownSpellsLevel);
    spellsPerDayTablesTable = new DataTable(spellsPerDayTable);
    spellsPerDayLevelTable = new DataTable(spellsPerDayLevel);

    this.daoUtil = new DaoUtil();
  }

  @Override
  public List<Spell> getAllSpells() {
    final List<Spell> allSpells = new ArrayList<>();
    for (final DataRow dataRow : spellTable) {
      final Spell spell = selectSpell(dataRow);
      allSpells.add(spell);
    }
    return allSpells;
  }

  private Spell selectSpell(final DataRow dataRow) {
    final Spell spell = new Spell();
    spell.setId(dataRow.getId());
    spell.setName(dataRow.getString(1));
    setSchools(spell, dataRow.getString(2));
    setComponents(spell, dataRow.getInt(3));
    spell.setCastingTime(spellSerializor.deserializeCastingTime(dataRow.getString(4)));
    spell.setRange(spellSerializor.deserializeRange(dataRow.getString(5)));
    spell.setEffect(dataRow.getString(6));
    spell.setDuration(dataRow.getString(7));
    spell.setSavingThrow(dataRow.getString(8));
    spell.setSpellResistance(spellSerializor.deserializeSpellResistance(dataRow.getString(9)));
    spell.setShortDescription(dataRow.getString(10));
    spell.setDescription(dataRow.getString(11));
    spell.setMaterialComponent(dataRow.getString(12));
    try {
      spell.setFocus(dataRow.getString(13));
    } catch (final Exception e) {
      System.out.println("-->" + spell.getName());
    }
    return spell;

  }

  private void setSchools(final Spell spell, final String data) {
    spell.setSchool(spellSerializor.deserializeSchool(data));
    spell.setSubSchool(spellSerializor.deserializeSubSchool(data));
    spell.setDescriptors(spellSerializor.deserializeDescriptors(data));
  }

  private void setComponents(final Spell spell, final int components) {
    spell.setVerbal(isSet(components, 0));
    spell.setSomatic(isSet(components, 1));
    spell.setMaterial(isSet(components, 2));
    spell.setFocus(isSet(components, 3));
    spell.setDivineFocus(isSet(components, 4));
    spell.setXpCost(isSet(components, 5));

  }

  private boolean isSet(final int components, final int position) {
    final int mask = 1 << position;
    return (components & mask) > 0;
  }

  public List<Spelllist> getAllSpelllists(final List<Spell> allSpells) {
    final List<Spelllist> allSpelllists = new ArrayList<>();
    for (final DataRow dataRow : spelllistTable) {
      final Spelllist spelllist = selectSpelllist(dataRow);
      assignSpells(spelllist, allSpells);
      allSpelllists.add(spelllist);
    }
    return allSpelllists;
  }

  private Spelllist selectSpelllist(final DataRow dataRow) {
    final Spelllist spelllist = new Spelllist();
    spelllist.setId(dataRow.getId());
    spelllist.setName(dataRow.getString(1));
    spelllist.setShortname(dataRow.getString(2));
    spelllist.setDomain(daoUtil.getBoolean(dataRow.getInt(3)));
    spelllist.setMinLevel(dataRow.getInt(4));
    spelllist.setMaxLevel(dataRow.getInt(5));
    return spelllist;
  }

  private void assignSpells(final Spelllist spelllist, final List<Spell> allSpells) {
    final List<DataRow> dataRows = spelllistSpellTable.select(0, spelllist.getId());
    final Map<Integer, List<Spell>> spells = new HashMap<>();
    for (final DataRow dataRow : dataRows) {
      final Spell spell = getSpellById(dataRow.getInt(1), allSpells);
      final int level = dataRow.getInt(2);
      assignSpell(spells, spell, level);
    }
    spelllist.setSpellsByLevel(spells);
  }

  private Spell getSpellById(final int spellId, final List<Spell> allSpells) {
    for (final Spell spell : allSpells) {
      if (spell.getId() == spellId) {
        return spell;
      }
    }
    throw new IllegalArgumentException("Can't find spell with id: " + spellId);
  }

  private void assignSpell(final Map<Integer, List<Spell>> spells, final Spell spell, final int level) {
    List<Spell> spellsOfLevel = spells.get(level);
    if (spellsOfLevel == null) {
      spellsOfLevel = new ArrayList<>();
      spells.put(level, spellsOfLevel);
    }
    spellsOfLevel.add(spell);
  }

  @Override
  public String getSpellDescription(final int spellId) {
    final List<DataRow> dataRows = spellTable.select(0, spellId);
    if (dataRows.size() != 1) {
      throw new IllegalArgumentException("Can't get spell with id: " + spellId);
    }
    return dataRows.get(0).getString(11);
  }

  @Override
  public Spell createSpell(final Spell spell) {
    spell.setId(spellTable.getNewId());
    insertSpell(spell);
    return spell;
  }

  private void insertSpell(final Spell spell) {
    spellTable.insert(new Object[] { //
        spell.getId(), //
        spell.getName(), //
        spellSerializor.serializeSchool(spell), //
        spellSerializor.serializeComponents(spell), //
        spellSerializor.serializeCastingTime(spell.getCastingTime()), //
        spellSerializor.serializeRange(spell.getRange()), //
        spell.getEffect(), //
        spell.getDuration(), //
        spell.getSavingThrow(), //
        spellSerializor.serializeSpellResistance(spell.getSpellResistance()), //
        spell.getShortDescription(), //
        spell.getDescription(), //
        spell.getMaterialComponent(), //
        spell.getFocus() //
    });
  }

  @Override
  public void deleteSpell(final Spell spell) {
    spellTable.delete(spell.getId());
  }

  @Override
  public void updateSpell(final Spell spell) {
    spellTable.delete(spell.getId());
    insertSpell(spell);
  }

  @Override
  public void createSpelllevel(final Spelllist spelllist, final Spell spell, final int level) {
    for (DataRow dataRow : spelllistSpellTable) {
      if (dataRow.getInt(0) == spelllist.getId() && dataRow.getInt(1) == spell.getId()) {
        throw new IllegalArgumentException("Spell already added to this spelllist add this level");
      }
    }
    spelllistSpellTable.insert(new Object[] {spelllist.getId(), spell.getId(), level});
  }

  @Override
  public void updateSpelllevel(final Spelllist spelllist, final Spell spell, final int level) {
    final List<DataRow> dataRows = spelllistSpellTable.select(1, spell.getId());
    for (final DataRow dataRow : dataRows) {
      if (dataRow.getId() == spelllist.getId()) {
        dataRow.set(2, level);
        break;
      }
    }
  }

  @Override
  public Spelllist createSpelllist(final Spelllist spelllist) {
    final int id = spelllistTable.getNewId();
    spelllist.setId(id);
    spelllistTable.insert(
        new Object[] {spelllist.getId(), spelllist.getName(), spelllist.getShortname(), daoUtil.setBoolean(spelllist.isDomain()),
            spelllist.getMinLevel(), spelllist.getMaxLevel()
        });
    return spelllist;
  }

  @Override
  public void deleteSpelllist(final Spelllist spelllist) {
    spelllistTable.delete(spelllist.getId());
  }

  @Override
  public void updateSpelllist(final Spelllist spelllist) {
    final List<DataRow> dataRows = spelllistTable.select(0, spelllist.getId());
    if (dataRows.size() != 1) {
      throw new IllegalStateException("Can't find exact one spell list with id: " + spelllist.getId());
    }
    final DataRow dataRow = dataRows.get(0);
    dataRow.set(1, spelllist.getName());
    dataRow.set(2, spelllist.getShortname());
    dataRow.set(3, daoUtil.setBoolean(spelllist.isDomain()));
    dataRow.set(4, spelllist.getMinLevel());
    dataRow.set(5, spelllist.getMaxLevel());
  }

  @Override
  public void deleteSpelllevel(final Spelllist spelllist, final Spell spell) {
    final DataTable newSpelllistSpellTable = new DataTable();
    for (final DataRow dataRow : spelllistSpellTable) {
      if (dataRow.getId() != spelllist.getId()) {
        newSpelllistSpellTable.insert(dataRow);
        continue;
      }
      if (dataRow.getInt(1) != spell.getId()) {
        newSpelllistSpellTable.insert(dataRow);
      }
    }
    spelllistSpellTable = newSpelllistSpellTable;
  }

  @Override
  public List<KnownSpellsTable> getAllKnownSpellsTables() {
    final List<KnownSpellsTable> allKnownSpellsTables = new ArrayList<>(knownSpellsTablesTable.getNumberOfRows());
    for (final DataRow dataRow : knownSpellsTablesTable) {
      final KnownSpellsTable knownSpellsTabel = new KnownSpellsTable();
      knownSpellsTabel.setId(dataRow.getId());
      knownSpellsTabel.setName(dataRow.getString(1));
      knownSpellsTabel.setKnownSpells(selectKnownSpells(knownSpellsTabel));
      allKnownSpellsTables.add(knownSpellsTabel);

    }
    return allKnownSpellsTables;
  }

  private int[][] selectKnownSpells(final KnownSpellsTable knownSpellsTable) {
    final List<DataRow> dataRows = knownSpellsLevelTable.select(1, knownSpellsTable.getId());
    final int[][] levels = new int[20][10];
    for (final DataRow dataRow : dataRows) {
      levels[dataRow.getInt(2) - 1][0] = dataRow.getInt(3);
      levels[dataRow.getInt(2) - 1][1] = dataRow.getInt(4);
      levels[dataRow.getInt(2) - 1][2] = dataRow.getInt(5);
      levels[dataRow.getInt(2) - 1][3] = dataRow.getInt(6);
      levels[dataRow.getInt(2) - 1][4] = dataRow.getInt(7);
      levels[dataRow.getInt(2) - 1][5] = dataRow.getInt(8);
      levels[dataRow.getInt(2) - 1][6] = dataRow.getInt(9);
      levels[dataRow.getInt(2) - 1][7] = dataRow.getInt(10);
      levels[dataRow.getInt(2) - 1][8] = dataRow.getInt(11);
      levels[dataRow.getInt(2) - 1][9] = dataRow.getInt(12);
    }
    return levels;
  }

  @Override
  public List<SpellsPerDayTable> getAllSpellsPerDayTables() {
    final List<SpellsPerDayTable> allSpellsPerDayTables = new ArrayList<>(spellsPerDayTablesTable.getNumberOfRows());
    for (final DataRow dataRow : spellsPerDayTablesTable) {
      final SpellsPerDayTable spellsPerDayTable = new SpellsPerDayTable();
      spellsPerDayTable.setId(dataRow.getId());
      spellsPerDayTable.setName(dataRow.getString(1));
      spellsPerDayTable.setSpellsPerDay(selectSpellsPerDay(spellsPerDayTable));
      allSpellsPerDayTables.add(spellsPerDayTable);

    }
    return allSpellsPerDayTables;
  }

  private int[][] selectSpellsPerDay(final SpellsPerDayTable spellsPerDayTable) {
    final List<DataRow> dataRows = spellsPerDayLevelTable.select(1, spellsPerDayTable.getId());
    final int[][] levels = new int[20][10];
    for (final DataRow dataRow : dataRows) {
      levels[dataRow.getInt(2) - 1][0] = dataRow.getInt(3);
      levels[dataRow.getInt(2) - 1][1] = dataRow.getInt(4);
      levels[dataRow.getInt(2) - 1][2] = dataRow.getInt(5);
      levels[dataRow.getInt(2) - 1][3] = dataRow.getInt(6);
      levels[dataRow.getInt(2) - 1][4] = dataRow.getInt(7);
      levels[dataRow.getInt(2) - 1][5] = dataRow.getInt(8);
      levels[dataRow.getInt(2) - 1][6] = dataRow.getInt(9);
      levels[dataRow.getInt(2) - 1][7] = dataRow.getInt(10);
      levels[dataRow.getInt(2) - 1][8] = dataRow.getInt(11);
      levels[dataRow.getInt(2) - 1][9] = dataRow.getInt(12);
    }
    return levels;
  }
}
