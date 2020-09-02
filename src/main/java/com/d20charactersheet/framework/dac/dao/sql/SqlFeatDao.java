package com.d20charactersheet.framework.dac.dao.sql;

import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_BENEFIT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FEAT_TYPE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FIGHTER_BONUS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MULTIPLE;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_PREREQUISITE;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_SLOT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_STACK;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_FEATS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_FEAT;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.dac.dao.FeatDao;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.FeatRowMapper;

/**
 * Implementation of FeatDao to access data in a SQLite database on an Android device.
 */
public class SqlFeatDao implements FeatDao {

    private static final String SQL_GET_ID = SELECT + "id FROM " + TABLE_FEAT + " WHERE rowid = ?";

    private final Database db;
    private final RowMapper featRowMapper;

    /**
     * Creates DAO with application context.
     *
     * @param db
     *     The database to access.
     */
    public SqlFeatDao(final Database db) {
        this.db = db;
        featRowMapper = new FeatRowMapper();
    }

    /**
     * Returns all feats. Caches feats after first request.
     *
     * @see FeatDao#getAllFeats()
     */
    @Override
    public List<Feat> getAllFeats() {
        final List<Feat> feats = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_FEATS, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Feat staticFeat = (Feat) featRowMapper.mapRow(queryResult.getDataRow());
                feats.add(staticFeat);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all feats", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return feats;
    }

    /**
     * @see FeatDao#createFeat(Feat)
     */
    @Override
    public void createFeat(final Feat feat) {
        insertFeatTable(feat);
    }

    private void insertFeatTable(final Feat feat) {
        final ContentValues featValues = getFeatValues(feat);
        featValues.putNull(COLUMN_ID);
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_FEAT, null, featValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert feat in feat table");
            }
            feat.setId(db.queryId(SQL_GET_ID, rowId));
        }
    }

    private ContentValues getFeatValues(final Feat feat) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, feat.getName());
        contentValues.put(COLUMN_BENEFIT, feat.getBenefit());
        contentValues.put(COLUMN_PREREQUISITE, feat.getPrerequisit());
        contentValues.put(COLUMN_FEAT_TYPE_ID, feat.getFeatType().ordinal());
        contentValues.put(COLUMN_FIGHTER_BONUS, feat.isFighterBonus());
        contentValues.put(COLUMN_MULTIPLE, feat.isMultiple());
        contentValues.put(COLUMN_STACK, feat.isStack());
        contentValues.put(COLUMN_SPELL_SLOT, feat.getSpellSlot());
        return contentValues;
    }

    @Override
    public void updateFeat(final Feat feat) {
        updateFeatTable(feat);
    }

    private void updateFeatTable(final Feat feat) {
        final ContentValues featValues = getFeatValues(feat);
        final String[] bindVariables = new String[] {Integer.toString(feat.getId())};
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.update(TABLE_FEAT, featValues, SQL_WHERE_ID, bindVariables);
            if (numberOfAffectedRows != 1) {
                throw new IllegalStateException("More or Less than 1 row affected: " + numberOfAffectedRows);
            }
        }
    }

    /**
     * @see FeatDao#deleteFeat(Feat)
     */
    @Override
    public void deleteFeat(final Feat feat) {

        // delete from feat table
        final String[] featId = new String[] {Integer.toString(feat.getId())};
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.delete(TABLE_FEAT, COLUMN_ID + " = ?", featId);
            if (numberOfAffectedRows == 0) {
                throw new IllegalStateException("Can't delete feat: " + feat);
            }
        }
    }

}
