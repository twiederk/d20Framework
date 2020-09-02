package com.d20charactersheet.framework.dac.dao.sql;

import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ATTRIBUTE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_UNTRAINED;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SKILLS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SKILL_DESCRIPTION;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SKILL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.SkillDao;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SkillRowMapper;

/**
 * Implementation of data interface SkillDao using SQLite3 database.
 */
public class SqlSkillDao implements SkillDao {

    private static final String SQL_GET_ID = SELECT + "id " + FROM + TABLE_SKILL + " " + WHERE + "rowid = ?";

    private final Database db;
    private final RowMapper skillRowMapper;

    /**
     * Creates SQLite3 dependent implementation of SkillDao.
     *
     * @param db
     *     The database to access.
     */
    public SqlSkillDao(final Database db) {
        this.db = db;
        skillRowMapper = new SkillRowMapper();
    }

    /**
     * @see SkillDao#getAllSkills()
     */
    @Override
    public List<Skill> getAllSkills() {
        final List<Skill> skills = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_SKILLS, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Skill skill = (Skill) skillRowMapper.mapRow(queryResult.getDataRow());
                skills.add(skill);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all skills", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return skills;
    }

    /**
     * @see SkillDao#createSkill(Skill)
     */
    @Override
    public Skill createSkill(final Skill skill) {
        insertSkillTable(skill);
        skill.setId(skill.getId());
        return skill;
    }

    /**
     * @see SkillDao#updateSkill(Skill)
     */
    @Override
    public Skill updateSkill(final Skill skill) {
        updateSkillTable(skill);
        return skill;
    }

    private void updateSkillTable(final Skill skill) {
        final ContentValues contentValues = getSkillTableContentValues(skill);
        final String[] bindVariables = new String[1];
        bindVariables[0] = Integer.toString(skill.getId());
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.update(TABLE_SKILL, contentValues, SQL_WHERE_ID, bindVariables);
            if (numberOfAffectedRows != 1) {
                throw new IllegalStateException("More or Less than 1 row affected: " + numberOfAffectedRows);
            }
        }
    }

    private ContentValues getSkillTableContentValues(final Skill skill) {
        final ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, skill.getName());
        values.put(COLUMN_DESCRIPTION, skill.getDescription());
        values.put(COLUMN_ATTRIBUTE_ID, skill.getAttribute().ordinal());
        values.put(COLUMN_UNTRAINED, skill.isUntrained());
        return values;
    }

    /**
     * @see SkillDao#deleteSkill(Skill)
     */
    @Override
    public void deleteSkill(final Skill skill) {

        // delete skill (table skill)
        final String[] skillId = new String[] { Integer.toString(skill.getId()) };
        synchronized (Database.DB_LOCK) {
            final int numberOfAffectedRows = db.delete(TABLE_SKILL, COLUMN_ID + " = ?", skillId);
            if (numberOfAffectedRows == 0) {
                throw new IllegalStateException("Can't delete skill: " + skill);
            }
        }

    }

    private void insertSkillTable(final Skill skill) {
        final ContentValues skillValues = getSkillTableContentValues(skill);
        skillValues.putNull(COLUMN_ID);
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_SKILL, null, skillValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert skill in skill table");
            }
            skill.setId(db.queryId(SQL_GET_ID, rowId));
        }
    }

    @Override
    public String getSkillDescription(final int skillId) {
        String description = "";
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_SKILL_DESCRIPTION, new String[] {Integer.toString(skillId)});
            queryResult.moveToFirst();
            description = queryResult.getDataRow().getString(0);
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get description of skill with id: " + skillId, sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return description;
    }
}
