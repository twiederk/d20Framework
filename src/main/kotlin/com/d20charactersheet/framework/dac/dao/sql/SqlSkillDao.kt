package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.SkillDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ATTRIBUTE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_UNTRAINED
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_SKILLS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_SKILL_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_SKILL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.WHERE
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.SkillRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Implementation of data interface SkillDao using SQLite3 database.
 * Creates SQLite3 dependent implementation of SkillDao.
 *
 * @param db
 * The database to access.
 */
class SqlSkillDao(private val db: Database) : SkillDao {

    private val skillRowMapper: RowMapper = SkillRowMapper()

    companion object {
        private const val SQL_GET_ID: String = SELECT + "id " + FROM + TABLE_SKILL + " " + WHERE + "rowid = ?"
    }

    /**
     * @see SkillDao.getAllSkills
     */
    override fun getAllSkills(): List<Skill> {
        val skills: MutableList<Skill> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_SKILLS, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val skill = skillRowMapper.mapRow(queryResult.getDataRow()) as Skill
                skills.add(skill)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all skills", sqlException);
        } finally {
            queryResult?.close()
        }
        return skills
    }

    /**
     * @see SkillDao.createSkill
     */
    override fun createSkill(skill: Skill): Skill {
        insertSkillTable(skill)
        skill.id = skill.id
        return skill
    }

    /**
     * @see SkillDao.updateSkill
     */
    override fun updateSkill(skill: Skill): Skill {
        updateSkillTable(skill)
        return skill
    }

    private fun updateSkillTable(skill: Skill) {
        val contentValues = getSkillTableContentValues(skill)
        val bindVariables = arrayOf(skill.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_SKILL, contentValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    private fun getSkillTableContentValues(skill: Skill): ContentValues {
        val values = ContentValues()
        values.put(COLUMN_NAME, skill.name)
        values.put(COLUMN_DESCRIPTION, skill.description)
        values.put(COLUMN_ATTRIBUTE_ID, skill.attribute.ordinal)
        values.put(COLUMN_UNTRAINED, skill.isUntrained)
        return values
    }

    /**
     * @see SkillDao.deleteSkill
     */
    override fun deleteSkill(skill: Skill) {

        // delete skill (table skill)
        val skillId = arrayOf(skill.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.delete(TABLE_SKILL, "$COLUMN_ID = ?", skillId)
            check(numberOfAffectedRows != 0) { "Can't delete skill: $skill" }
        }
    }

    private fun insertSkillTable(skill: Skill) {
        val skillValues = getSkillTableContentValues(skill)
        skillValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_SKILL, skillValues)
            check(rowId != -1L) { "Can't insert skill in skill table" }
            skill.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    override fun getSkillDescription(skillId: Int): String {
        var description = ""
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_SKILL_DESCRIPTION, arrayOf(skillId.toString()))
            queryResult.moveToFirst()
            description = queryResult.getDataRow().getString(0)
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get description of skill with id: " + skillId, sqlException);
        } finally {
            queryResult?.close()
        }
        return description
    }


}