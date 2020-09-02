package com.d20charactersheet.framework.dac.dao.sql;

import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_XP_TABLES;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_XP_LEVELS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.XpDao;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.XpTableRowMapper;

/**
 * Create data access object to access xp tables in SQLite3 database.
 */
public class SqlXpDao implements XpDao {

    private final Database db;

    /**
     * Instantiates SQLiteXpDao.
     *
     * @param db
     *     The database to access.
     */
    public SqlXpDao(final Database db) {
        this.db = db;
    }

    @Override
    public List<XpTable> getAllXpTables() {
        final List<XpTable> allXpTables = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            final RowMapper xpTableRowMapper = new XpTableRowMapper();
            queryResult = db.rawQuery(SQL_GET_ALL_XP_TABLES, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final XpTable xpTable = (XpTable) xpTableRowMapper.mapRow(queryResult.getDataRow());
                final int[] levels = selectLevels(xpTable);
                xpTable.setLevelTable(levels);
                allXpTables.add(xpTable);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all xp tables", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return allXpTables;
    }

    private int[] selectLevels(final XpTable xpTable) {
        QueryResult queryResult = null;
        final List<Integer> levelList = new ArrayList<>(20);
        try {
            final String[] xpTableId = new String[] {Integer.toString(xpTable.getId())};
            queryResult = db.rawQuery(SQL_GET_XP_LEVELS, xpTableId);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                levelList.add(queryResult.getDataRow().getInt(0) - 1, queryResult.getDataRow().getInt(1));
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all xp tables", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }

        // convert from List<Integer> to int[]
        final int[] levels = new int[levelList.size()];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = levelList.get(i);
        }
        return levels;
    }
}
