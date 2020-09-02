package com.d20charactersheet.framework.dac.dao.sql;

import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CASTING_TIME;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COMPONENTS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DOMAIN;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DURATION;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_EFFECT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FOCUS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_LEVEL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MATERIAL_COMPONENT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MAX_LEVEL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MIN_LEVEL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_RANGE;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SAVING_THROW;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SCHOOL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SHORTNAME;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SHORT_DESCRIPTION;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELLLIST_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_RESISTANCE;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_KNOWN_SPELLS_TABLES;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SPELLLISTS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SPELLS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SPELLS_PER_DAY_TABLES;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_KNOWN_SPELLS_LEVELS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SPELLS_OF_SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SPELLS_PER_DAY_LEVELS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SPELL_DESCRIPTION;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SPELL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SPELLLIST_SPELL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.dao.SpelllistDao;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.KnownSpellsTableRowMapper;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SpellRowMapper;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SpelllistRowMapper;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SpellsPerDayTableRowMapper;
import com.d20charactersheet.framework.dac.dao.util.SpellSerializor;

/**
 * Data access object for SpelllistService. Retrieves spells and spell lists from SQLite3 database.
 */
public class SqlSpelllistDao implements SpelllistDao {

    private static final String SQL_GET_ID = SELECT + "id" + FROM + TABLE_SPELL + WHERE + "rowid = ?";

    private static final String WHERE_SPELLLEVEL = COLUMN_SPELLLIST_ID + " = ? AND " + COLUMN_SPELL_ID + " = ?";

    private final Database db;

    private final RowMapper spellRowMapper;
    private final RowMapper spelllistRowMapper;
    private final SpellSerializor spellSerializor;

    /**
     * Instantiates SQLiteSpelllistDao
     *
     * @param db
     *     The database to access.
     */
    public SqlSpelllistDao(final Database db) {
        this.db = db;
        spellRowMapper = new SpellRowMapper();
        spelllistRowMapper = new SpelllistRowMapper();
        spellSerializor = new SpellSerializor();
    }

    @Override
    public List<Spell> getAllSpells() {
        final List<Spell> allSpells = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_SPELLS, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Spell spell = (Spell) spellRowMapper.mapRow(queryResult.getDataRow());
                allSpells.add(spell);
            }
        } catch (final SQLException sqlException) {
            //                Logger.error("Can't get all spells", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return allSpells;
    }

    @Override
    public List<Spelllist> getAllSpelllists(final List<Spell> allSpells) {
        final List<Spelllist> allSpelllists = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_SPELLLISTS, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Spelllist spelllist = (Spelllist) spelllistRowMapper.mapRow(queryResult.getDataRow());
                assignSpells(spelllist, allSpells);
                allSpelllists.add(spelllist);
            }
        } catch (final SQLException sqlException) {
            //                Logger.error("Can't get all spelllists", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return allSpelllists;
    }

    private void assignSpells(final Spelllist spelllist, final List<Spell> allSpells) {
        QueryResult queryResult = null;
        try {
            final String[] params = new String[] {Integer.toString(spelllist.getId())};
            final Map<Integer, List<Spell>> spells = new HashMap<>();
            queryResult = db.rawQuery(SQL_GET_SPELLS_OF_SPELLLIST, params);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Spell spell = getSpellById(queryResult.getDataRow().getInt(0), allSpells);
                final int level = queryResult.getDataRow().getInt(1);
                assignSpell(spells, spell, level);
            }
            spelllist.setSpellsByLevel(spells);
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't assign spells to spelllist: " + spelllist, sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
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
        String description = "";
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_SPELL_DESCRIPTION, new String[] {Integer.toString(spellId)});
            queryResult.moveToFirst();
            description = queryResult.getDataRow().getString(0);
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get description of spell with id: " + spellId, sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return description;
    }

    @Override
    public Spell createSpell(final Spell spell) {
        insertSpellTable(spell);
        return spell;
    }

    private void insertSpellTable(final Spell spell) {
        final ContentValues spellValues = getSpellValues(spell);
        spellValues.putNull(COLUMN_ID);
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_SPELL, null, spellValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert spell in spell table");
            }
            spell.setId(db.queryId(SQL_GET_ID, rowId));
        }
    }

    private ContentValues getSpellValues(final Spell spell) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, spell.getName());
        contentValues.put(COLUMN_SCHOOL, spellSerializor.serializeSchool(spell));
        contentValues.put(COLUMN_COMPONENTS, spellSerializor.serializeComponents(spell));
        contentValues.put(COLUMN_CASTING_TIME, spellSerializor.serializeCastingTime(spell.getCastingTime()));
        contentValues.put(COLUMN_RANGE, spellSerializor.serializeRange(spell.getRange()));
        contentValues.put(COLUMN_EFFECT, spell.getEffect());
        contentValues.put(COLUMN_DURATION, spell.getDuration());
        contentValues.put(COLUMN_SAVING_THROW, spell.getSavingThrow());
        contentValues.put(COLUMN_SPELL_RESISTANCE, spellSerializor.serializeSpellResistance(spell.getSpellResistance()));
        contentValues.put(COLUMN_SHORT_DESCRIPTION, spell.getShortDescription());
        contentValues.put(COLUMN_DESCRIPTION, spell.getDescription());
        contentValues.put(COLUMN_MATERIAL_COMPONENT, spell.getMaterialComponent());
        contentValues.put(COLUMN_FOCUS, spell.getFocus());
        return contentValues;
    }

    @Override
    public void deleteSpell(final Spell spell) {
        final String[] spellId = new String[] {Integer.toString(spell.getId())};
        synchronized (Database.DB_LOCK) {
            db.delete(TABLE_SPELL, COLUMN_ID + " = ?", spellId);
        }
    }

    @Override
    public void updateSpell(final Spell spell) {
        final ContentValues spellValues = getSpellValues(spell);
        final String[] bindVariables = new String[] {Integer.toString(spell.getId())};
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.update(TABLE_SPELL, spellValues, SQL_WHERE_ID, bindVariables);
            if (numberOfAffectedRows != 1) {
                throw new IllegalStateException("More or Less than 1 row affected: " + numberOfAffectedRows);
            }
        }
    }

    @Override
    public void createSpelllevel(final Spelllist spelllist, final Spell spell, final int level) {
        final ContentValues spelllevelValues = getSpelllevelValues(spelllist.getId(), spell.getId(), level);
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_SPELLLIST_SPELL, null, spelllevelValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert spelllevel in spelllist_spell table");
            }
        }
    }

    private ContentValues getSpelllevelValues(final int spelllistId, final int spellId, final int level) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SPELLLIST_ID, spelllistId);
        contentValues.put(COLUMN_SPELL_ID, spellId);
        contentValues.put(COLUMN_LEVEL, level);
        return contentValues;
    }

    @Override
    public void updateSpelllevel(final Spelllist spelllist, final Spell spell, final int level) {
        final ContentValues spelllevelValues = new ContentValues();
        spelllevelValues.put(COLUMN_LEVEL, level);
        final String[] bindVariables = new String[] {Integer.toString(spelllist.getId()), Integer.toString(spell.getId())};
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.update(TABLE_SPELLLIST_SPELL, spelllevelValues, WHERE_SPELLLEVEL, bindVariables);
            if (numberOfAffectedRows != 1) {
                throw new IllegalStateException("More or Less than 1 row affected: " + numberOfAffectedRows);
            }
        }
    }

    @Override
    public Spelllist createSpelllist(final Spelllist spelllist) {
        insertSpelllistTable(spelllist);
        return spelllist;
    }

    private void insertSpelllistTable(final Spelllist spelllist) {
        final ContentValues spelllistValues = getSpelllistValues(spelllist);
        spelllistValues.putNull(COLUMN_ID);
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_SPELLLIST, null, spelllistValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert spelllist in spelllist table");
            }
            spelllist.setId(db.queryId(SQL_GET_ID, rowId));
        }
    }

    private ContentValues getSpelllistValues(final Spelllist spelllist) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, spelllist.getName());
        contentValues.put(COLUMN_SHORTNAME, spelllist.getShortname());
        contentValues.put(COLUMN_DOMAIN, spelllist.isDomain());
        contentValues.put(COLUMN_MIN_LEVEL, spelllist.getMinLevel());
        contentValues.put(COLUMN_MAX_LEVEL, spelllist.getMaxLevel());
        return contentValues;
    }

    @Override
    public void deleteSpelllist(final Spelllist spelllist) {
        final String[] spelllistId = new String[] {Integer.toString(spelllist.getId())};
        synchronized (Database.DB_LOCK) {
            db.delete(TABLE_SPELLLIST, COLUMN_ID + " = ?", spelllistId);
        }
    }

    @Override
    public void updateSpelllist(final Spelllist spelllist) {
        final ContentValues spelllistValues = getSpelllistValues(spelllist);
        final String[] bindVariables = new String[] {Integer.toString(spelllist.getId())};
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.update(TABLE_SPELLLIST, spelllistValues, SQL_WHERE_ID, bindVariables);
            if (numberOfAffectedRows != 1) {
                throw new IllegalStateException("More or Less than 1 row affected: " + numberOfAffectedRows);
            }
        }
    }

    @Override
    public void deleteSpelllevel(final Spelllist spelllist, final Spell spell) {
        final String[] bindVariables = new String[] {Integer.toString(spelllist.getId()), Integer.toString(spell.getId())};
        synchronized (Database.DB_LOCK) {
            db.delete(TABLE_SPELLLIST_SPELL, WHERE_SPELLLEVEL, bindVariables);
        }
    }

    @Override
    public List<KnownSpellsTable> getAllKnownSpellsTables() {
        final List<KnownSpellsTable> allKnownSpellsTables = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            final RowMapper rowMapper = new KnownSpellsTableRowMapper();
            queryResult = db.rawQuery(SQL_GET_ALL_KNOWN_SPELLS_TABLES, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final KnownSpellsTable knownSpellsTable = (KnownSpellsTable) rowMapper.mapRow(queryResult.getDataRow());
                final int[][] knownSpellsLevels = selectKnownSpellsLevels(knownSpellsTable);
                knownSpellsTable.setKnownSpells(knownSpellsLevels);
                allKnownSpellsTables.add(knownSpellsTable);
            }
        } catch (final SQLException sqlException) {
            //                Logger.error("Can't get all xp tables", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return allKnownSpellsTables;
    }

    private int[][] selectKnownSpellsLevels(final KnownSpellsTable knownSpellsTable) {
        final int[][] knownSpellsLevels = new int[20][10];
        QueryResult queryResult = null;
        final String knownSpellsTableId = Integer.toString(knownSpellsTable.getId());
        for (int spellcasterLevel = 0; spellcasterLevel < knownSpellsLevels.length; spellcasterLevel++) {
            final String[] params = new String[] {knownSpellsTableId, Integer.toString(spellcasterLevel + 1)};
            try {
                queryResult = db.rawQuery(SQL_GET_KNOWN_SPELLS_LEVELS, params);
                for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                    DataRow dataRow = queryResult.getDataRow();
                    knownSpellsLevels[spellcasterLevel][0] = dataRow.getInt(0);
                    knownSpellsLevels[spellcasterLevel][1] = dataRow.getInt(1);
                    knownSpellsLevels[spellcasterLevel][2] = dataRow.getInt(2);
                    knownSpellsLevels[spellcasterLevel][3] = dataRow.getInt(3);
                    knownSpellsLevels[spellcasterLevel][4] = dataRow.getInt(4);
                    knownSpellsLevels[spellcasterLevel][5] = dataRow.getInt(5);
                    knownSpellsLevels[spellcasterLevel][6] = dataRow.getInt(6);
                    knownSpellsLevels[spellcasterLevel][7] = dataRow.getInt(7);
                    knownSpellsLevels[spellcasterLevel][8] = dataRow.getInt(8);
                    knownSpellsLevels[spellcasterLevel][9] = dataRow.getInt(9);
                }
            } catch (final SQLException sqlException) {
                //                Logger.error("Can't get all known spells levels", sqlException);
            } finally {
                if (queryResult != null) {
                    queryResult.close();
                }
            }
        }
        return knownSpellsLevels;
    }

    @Override
    public List<SpellsPerDayTable> getAllSpellsPerDayTables() {
        final List<SpellsPerDayTable> allSpellsPerDayTables = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            final RowMapper rowMapper = new SpellsPerDayTableRowMapper();
            queryResult = db.rawQuery(SQL_GET_ALL_SPELLS_PER_DAY_TABLES, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final SpellsPerDayTable spellsPerDayTable = (SpellsPerDayTable) rowMapper.mapRow(queryResult.getDataRow());
                final int[][] spellsPerDayLevels = selectSpellsPerDayLevels(spellsPerDayTable);
                spellsPerDayTable.setSpellsPerDay(spellsPerDayLevels);
                allSpellsPerDayTables.add(spellsPerDayTable);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all spells per day tables", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return allSpellsPerDayTables;
    }

    private int[][] selectSpellsPerDayLevels(final SpellsPerDayTable spellsPerDayTable) {
        final int[][] spellsPerDayLevels = new int[20][10];
        QueryResult queryResult = null;
        final String spellsPerDayTableId = Integer.toString(spellsPerDayTable.getId());
        for (int spellcasterLevel = 0; spellcasterLevel < spellsPerDayLevels.length; spellcasterLevel++) {
            final String[] params = new String[] {spellsPerDayTableId, Integer.toString(spellcasterLevel + 1)};
            try {
                queryResult = db.rawQuery(SQL_GET_SPELLS_PER_DAY_LEVELS, params);
                for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                    DataRow dataRow = queryResult.getDataRow();
                    spellsPerDayLevels[spellcasterLevel][0] = dataRow.getInt(0);
                    spellsPerDayLevels[spellcasterLevel][1] = dataRow.getInt(1);
                    spellsPerDayLevels[spellcasterLevel][2] = dataRow.getInt(2);
                    spellsPerDayLevels[spellcasterLevel][3] = dataRow.getInt(3);
                    spellsPerDayLevels[spellcasterLevel][4] = dataRow.getInt(4);
                    spellsPerDayLevels[spellcasterLevel][5] = dataRow.getInt(5);
                    spellsPerDayLevels[spellcasterLevel][6] = dataRow.getInt(6);
                    spellsPerDayLevels[spellcasterLevel][7] = dataRow.getInt(7);
                    spellsPerDayLevels[spellcasterLevel][8] = dataRow.getInt(8);
                    spellsPerDayLevels[spellcasterLevel][9] = dataRow.getInt(9);
                }
            } catch (final SQLException sqlException) {
                //                Logger.error("Can't get spells per day levels", sqlException);
            } finally {
                if (queryResult != null) {
                    queryResult.close();
                }
            }
        }
        return spellsPerDayLevels;
    }

}
