package com.d20charactersheet.framework.dac.dao.sql;

import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_IMAGE;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_IMAGE;

import java.sql.SQLException;

import com.d20charactersheet.framework.dac.dao.ImageDao;

/**
 * SQLite specific implementation of the ImageDao interface.
 */
public class SqlImageDao implements ImageDao {

    private static final String SQL_GET_IMAGE = SELECT + COLUMN_IMAGE + " FROM " + TABLE_IMAGE + " WHERE " + COLUMN_ID + " = ?";
    private static final String SQL_GET_ID = SELECT + COLUMN_ID + " FROM " + TABLE_IMAGE + " WHERE rowid = ?";

    private final Database db;

    /**
     * Instantiates ImageDaoSQLite with the given context containing the database.
     *
     * @param db
     *     The database to access.
     */
    public SqlImageDao(final Database db) {
        this.db = db;
    }

    /**
     * @see ImageDao#getImage(int)
     */
    @Override
    public byte[] getImage(final int imageId) {
        byte[] data = null;
        final String[] bindVariables = new String[1];
        bindVariables[0] = Integer.toString(imageId);
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_IMAGE, bindVariables);
            queryResult.moveToFirst();
            if (!queryResult.isAfterLast()) {
                data = queryResult.getDataRow().getBlob(0);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get image width imageId: " + imageId);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return data;
    }

    /**
     * @see ImageDao#createImage(byte[])
     */
    @Override
    public int createImage(final byte[] imageData) {
        final ContentValues values = new ContentValues();
        values.putNull(COLUMN_ID);
        values.put(COLUMN_IMAGE, imageData);
        final long rowId;
        synchronized (Database.DB_LOCK) {
            rowId = db.insertOrThrow(TABLE_IMAGE, null, values);
        }
        return db.queryId(SQL_GET_ID, rowId);
    }

    /**
     * @see ImageDao#deleteImage(int)
     */
    @Override
    public void deleteImage(final int imageId) {
        final String[] bindVariables = new String[1];
        bindVariables[0] = Integer.toString(imageId);
        synchronized (Database.DB_LOCK) {
            final int deletedRows = db.delete(TABLE_IMAGE, SQL_WHERE_ID, bindVariables);
            if (deletedRows != 1) {
                throw new IllegalStateException("Too many or to less deleted rows: " + deletedRows + ". Expected one deleted row!");
            }
        }
    }

}
