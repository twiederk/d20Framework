package com.d20charactersheet.framework.dac.dao.sql


import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.ClassAbility
import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.ClassDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ABILITY_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ALIGNMENTS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_BASE_ATTACK_BONUS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CLASS_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_HIT_DIE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SAVES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SKILL_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SKILL_POINTS_PER_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_CLASSES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CLASS_ABILITIES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CLASS_SKILLS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CLASS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CLASS_ABILITY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CLASS_SKILL
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ClassAbilityRowMapper
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ClassRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Provides access to character class data stored in an SQLite database.
 */
class SqlClassDao(private val db: Database) : ClassDao {

    private val classRowMapper: RowMapper = ClassRowMapper()

    companion object {
        private const val SQL_GET_ID: String = SELECT + "id FROM " + TABLE_CLASS + " WHERE rowid = ?"
    }

    /**
     * @see ClassDao.deleteSkill
     */
    override fun deleteSkill(skill: Skill) {
        val skillId = arrayOf(skill.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CLASS_SKILL, "$COLUMN_SKILL_ID = ?", skillId) }
    }

    override fun getAllCharacterClasses(allSkills: List<Skill>, allAbilities: List<Ability>): List<CharacterClass> {
        val characterClasses = selectCharacterClassTable()
        for (characterClass in characterClasses) {
            val characterClassId = characterClass.id
            val skills = selectCharacterClassSkillTable(characterClassId, allSkills)
            characterClass.skills = skills
            val classAbilities = selectClassAbilityTable(characterClassId, allAbilities)
            characterClass.classAbilities = classAbilities
        }
        return characterClasses
    }

    private fun selectCharacterClassTable(): List<CharacterClass> {
        val characterClasses: MutableList<CharacterClass> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_CLASSES, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val characterClass = classRowMapper.mapRow(queryResult.getDataRow()) as CharacterClass
                characterClasses.add(characterClass)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all classes", sqlException);
        } finally {
            queryResult?.close()
        }
        return characterClasses
    }

    private fun selectCharacterClassSkillTable(id: Int, allSkills: List<Skill>): List<Skill> {
        val skills: MutableList<Skill> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(id.toString())
            queryResult = db.rawQuery(SQL_GET_CLASS_SKILLS, params)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val skill = getSkill(allSkills, queryResult.getDataRow().getInt(0))
                skills.add(skill)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all classes skills", sqlException);
        } finally {
            queryResult?.close()
        }
        return skills
    }

    private fun getSkill(allSkills: List<Skill>, skillId: Int): Skill {
        for (skill in allSkills) {
            if (skill.id == skillId) {
                return skill
            }
        }
        throw IllegalArgumentException("Can't determine skill of id: $skillId")
    }

    private fun selectClassAbilityTable(characterClassId: Int, allAbilities: List<Ability>): List<ClassAbility> {
        val classAbilities: MutableList<ClassAbility> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(characterClassId.toString())
            queryResult = db.rawQuery(SQL_GET_CLASS_ABILITIES, params)
            val classAbilityRowMapper: RowMapper = ClassAbilityRowMapper(allAbilities)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val classAbility = classAbilityRowMapper.mapRow(queryResult.getDataRow()) as ClassAbility
                classAbilities.add(classAbility)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all class abilities", sqlException);
        } finally {
            queryResult?.close()
        }
        return classAbilities
    }

    /**
     * @see ClassDao.updateCharacterClass
     */
    override fun updateCharacterClass(characterClass: CharacterClass) {
        deleteCharacterClass(characterClass)
        updateCharacterClassTable(characterClass)
        insertClassAbilityTable(characterClass)
        insertCharacterClassSkillTable(characterClass)
    }

    private fun deleteCharacterClass(characterClass: CharacterClass) {
        val characterClassId = arrayOf(characterClass.id.toString())
        synchronized(Database.DB_LOCK) {
            db.delete(TABLE_CLASS, "$COLUMN_ID = ?", characterClassId)
            db.delete(TABLE_CLASS_ABILITY, "$COLUMN_CLASS_ID = ?", characterClassId)
            db.delete(TABLE_CLASS_SKILL, "$COLUMN_CLASS_ID = ?", characterClassId)
        }
    }

    private fun updateCharacterClassTable(characterClass: CharacterClass) {
        val contentValues = getContentValues(characterClass)
        contentValues.put(COLUMN_ID, characterClass.id)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CLASS, contentValues)
            check(rowId != -1L) { "Can't insert class in class table" }
        }
    }

    private fun getContentValues(characterClass: CharacterClass): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, characterClass.name)
        contentValues.put(COLUMN_SAVES, setEnum(characterClass.saves))
        contentValues.put(COLUMN_ALIGNMENTS, setEnum(characterClass.alignments))
        contentValues.put(COLUMN_BASE_ATTACK_BONUS, characterClass.baseAttackBonus.ordinal)
        contentValues.put(COLUMN_SKILL_POINTS_PER_LEVEL, characterClass.skillPointsPerLevel)
        contentValues.put(COLUMN_HIT_DIE_ID, characterClass.hitDie.ordinal)
        return contentValues
    }

    private fun insertClassAbilityTable(characterClass: CharacterClass) {
        synchronized(Database.DB_LOCK) {
            for (classAbility in characterClass.classAbilities) {
                val contentValues = ContentValues()
                contentValues.put(COLUMN_CLASS_ID, characterClass.id)
                contentValues.put(COLUMN_ABILITY_ID, classAbility.ability.id)
                contentValues.put(COLUMN_LEVEL, classAbility.level)
                val rowId = db.insertOrThrow(TABLE_CLASS_ABILITY, contentValues)
                check(rowId != -1L) { "Can't insert ability in class ability table" }
            }
        }
    }

    private fun insertCharacterClassSkillTable(characterClass: CharacterClass) {
        synchronized(Database.DB_LOCK) {
            for (skill in characterClass.skills) {
                val contentValues = ContentValues()
                contentValues.put(COLUMN_CLASS_ID, characterClass.id)
                contentValues.put(COLUMN_SKILL_ID, skill.id)
                val rowId = db.insertOrThrow(TABLE_CLASS_SKILL, contentValues)
                check(rowId != -1L) { "Can't insert skill in class skill table" }
            }
        }
    }

    /**
     * @see ClassDao.createCharacterClass
     */
    override fun createCharacterClass(characterClass: CharacterClass) {
        insertCharacterClassTable(characterClass)
        insertClassAbilityTable(characterClass)
        insertCharacterClassSkillTable(characterClass)
    }

    private fun insertCharacterClassTable(characterClass: CharacterClass) {
        val contentValues = getContentValues(characterClass)
        contentValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CLASS, contentValues)
            check(rowId != -1L) { "Can't insert class in class table" }
            characterClass.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    /**
     * @see ClassDao.addSkill
     */
    override fun addSkill(skill: Skill, characterClasses: List<CharacterClass>) {
        synchronized(Database.DB_LOCK) {
            for (characterClass in characterClasses) {
                val contentValues = ContentValues()
                contentValues.put(COLUMN_CLASS_ID, characterClass.id)
                contentValues.put(COLUMN_SKILL_ID, skill.id)
                val rowId = db.insertOrThrow(TABLE_CLASS_SKILL, contentValues)
                check(rowId != -1L) { "Can't insert skill ($skill) to class ($characterClass)" }
            }
        }
    }

    private fun setEnum(enumset: EnumSet<*>): Int {
        var result = 0
        for (currentEnum in enumset) {
            result += 1 shl currentEnum.ordinal
        }
        return result
    }

}