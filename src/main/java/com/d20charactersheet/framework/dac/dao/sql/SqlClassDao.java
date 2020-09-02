package com.d20charactersheet.framework.dac.dao.sql;

import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ABILITY_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ALIGNMENTS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_BASE_ATTACK_BONUS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CLASS_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_HIT_DIE_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_LEVEL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SAVES;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SKILL_ID;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SKILL_POINTS_PER_LEVEL;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_CLASSES;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CLASS_ABILITIES;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CLASS_SKILLS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CLASS;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CLASS_ABILITY;
import static com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CLASS_SKILL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.ClassDao;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ClassAbilityRowMapper;
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.ClassRowMapper;

/**
 * Provides access to character class data stored in an SQLite database.
 */
public class SqlClassDao implements ClassDao {

    private static final String SQL_GET_ID = SELECT + "id FROM " + TABLE_CLASS + " WHERE rowid = ?";

    private final Database db;
    private final RowMapper classRowMapper;

    /**
     * Creates DAO to persistent character class data, stored in an SQLite database.
     *
     * @param db
     *     The database to access.
     */
    public SqlClassDao(final Database db) {
        this.db = db;
        classRowMapper = new ClassRowMapper();
    }

    /**
     * @see ClassDao#deleteSkill(Skill)
     */
    @Override
    public void deleteSkill(final Skill skill) {
        final String[] skillId = {Integer.toString(skill.getId())};
        synchronized (Database.DB_LOCK) {
            db.delete(TABLE_CLASS_SKILL, COLUMN_SKILL_ID + " = ?", skillId);
        }
    }

    @Override
    public List<CharacterClass> getAllCharacterClasses(final List<Skill> allSkills, final List<Ability> allAbilities) {
        final List<CharacterClass> characterClasses = selectCharacterClassTable();
        for (final CharacterClass characterClass : characterClasses) {
            final int characterClassId = characterClass.getId();
            final List<Skill> skills = selectCharacterClassSkillTable(characterClassId, allSkills);
            characterClass.setSkills(skills);
            final List<ClassAbility> classAbilities = selectClassAbilityTable(characterClassId, allAbilities);
            characterClass.setClassAbilities(classAbilities);
        }
        return characterClasses;
    }

    private List<CharacterClass> selectCharacterClassTable() {
        final List<CharacterClass> characterClasses = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_CLASSES, new String[0]);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final CharacterClass characterClass = (CharacterClass) classRowMapper.mapRow(queryResult.getDataRow());
                characterClasses.add(characterClass);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all classes", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return characterClasses;
    }

    private List<Skill> selectCharacterClassSkillTable(final int id, final List<Skill> allSkills) {
        final List<Skill> skills = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            final String[] params = new String[] {Integer.toString(id)};
            queryResult = db.rawQuery(SQL_GET_CLASS_SKILLS, params);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final Skill skill = getSkill(allSkills, queryResult.getDataRow().getInt(0));
                skills.add(skill);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all classes skills", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return skills;
    }

    private Skill getSkill(final List<Skill> allSkills, final int skillId) {
        for (final Skill skill : allSkills) {
            if (skill.getId() == skillId) {
                return skill;
            }
        }
        throw new IllegalArgumentException("Can't determine skill of id: " + skillId);
    }

    private List<ClassAbility> selectClassAbilityTable(final int characterClassId, final List<Ability> allAbilities) {
        final List<ClassAbility> classAbilities = new ArrayList<>();
        QueryResult queryResult = null;
        try {
            final String[] params = new String[] {Integer.toString(characterClassId)};
            queryResult = db.rawQuery(SQL_GET_CLASS_ABILITIES, params);
            final RowMapper classAbilityRowMapper = new ClassAbilityRowMapper(allAbilities);
            for (queryResult.moveToFirst(); !queryResult.isAfterLast(); queryResult.moveToNext()) {
                final ClassAbility classAbility = (ClassAbility) classAbilityRowMapper.mapRow(queryResult.getDataRow());
                classAbilities.add(classAbility);
            }
        } catch (final SQLException sqlException) {
            //            Logger.error("Can't get all class abilities", sqlException);
        } finally {
            if (queryResult != null) {
                queryResult.close();
            }
        }
        return classAbilities;
    }

    /**
     * @see ClassDao#updateCharacterClass(CharacterClass)
     */
    @Override
    public void updateCharacterClass(final CharacterClass characterClass) {
        deleteCharacterClass(characterClass);
        updateCharacterClassTable(characterClass);
        insertClassAbilityTable(characterClass);
        insertCharacterClassSkillTable(characterClass);
    }

    private void deleteCharacterClass(final CharacterClass characterClass) {
        final String[] characterClassId = new String[] {Integer.toString(characterClass.getId())};
        synchronized (Database.DB_LOCK) {
            db.delete(TABLE_CLASS, COLUMN_ID + " = ?", characterClassId);
            db.delete(TABLE_CLASS_ABILITY, COLUMN_CLASS_ID + " = ?", characterClassId);
            db.delete(TABLE_CLASS_SKILL, COLUMN_CLASS_ID + " = ?", characterClassId);
        }

    }

    private void updateCharacterClassTable(final CharacterClass characterClass) {
        final ContentValues contentValues = getContentValues(characterClass);
        contentValues.put(COLUMN_ID, characterClass.getId());
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_CLASS, null, contentValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert class in class table");
            }
        }
    }

    private ContentValues getContentValues(final CharacterClass characterClass) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, characterClass.getName());
        contentValues.put(COLUMN_SAVES, setEnum(characterClass.getSaves()));
        contentValues.put(COLUMN_ALIGNMENTS, setEnum(characterClass.getAlignments()));
        contentValues.put(COLUMN_BASE_ATTACK_BONUS, characterClass.getBaseAttackBonus().ordinal());
        contentValues.put(COLUMN_SKILL_POINTS_PER_LEVEL, characterClass.getSkillPointsPerLevel());
        contentValues.put(COLUMN_HIT_DIE_ID, characterClass.getHitDie().ordinal());
        return contentValues;
    }

    private void insertClassAbilityTable(final CharacterClass characterClass) {
        synchronized (Database.DB_LOCK) {
            for (final ClassAbility classAbility : characterClass.getClassAbilities()) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_CLASS_ID, characterClass.getId());
                contentValues.put(COLUMN_ABILITY_ID, classAbility.getAbility().getId());
                contentValues.put(COLUMN_LEVEL, classAbility.getLevel());
                final long rowId = db.insertOrThrow(TABLE_CLASS_ABILITY, null, contentValues);
                if (rowId == -1) {
                    throw new IllegalStateException("Can't insert ability in class ability table");
                }
            }
        }
    }

    private void insertCharacterClassSkillTable(final CharacterClass characterClass) {
        synchronized (Database.DB_LOCK) {
            for (final Skill skill : characterClass.getSkills()) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_CLASS_ID, characterClass.getId());
                contentValues.put(COLUMN_SKILL_ID, skill.getId());
                final long rowId = db.insertOrThrow(TABLE_CLASS_SKILL, null, contentValues);
                if (rowId == -1) {
                    throw new IllegalStateException("Can't insert skill in class skill table");
                }
            }
        }
    }

    /**
     * @see ClassDao#createCharacterClass(CharacterClass)
     */
    @Override
    public void createCharacterClass(final CharacterClass characterClass) {
        insertCharacterClassTable(characterClass);
        insertClassAbilityTable(characterClass);
        insertCharacterClassSkillTable(characterClass);
    }

    private void insertCharacterClassTable(final CharacterClass characterClass) {
        final ContentValues contentValues = getContentValues(characterClass);
        contentValues.putNull(COLUMN_ID);
        synchronized (Database.DB_LOCK) {
            final long rowId = db.insertOrThrow(TABLE_CLASS, null, contentValues);
            if (rowId == -1) {
                throw new IllegalStateException("Can't insert class in class table");
            }
            characterClass.setId(db.queryId(SQL_GET_ID, rowId));
        }
    }

    /**
     * @see ClassDao#addSkill(Skill,
     * List)
     */
    @Override
    public void addSkill(final Skill skill, final List<CharacterClass> characterClasses) {
        synchronized (Database.DB_LOCK) {
            for (final CharacterClass characterClass : characterClasses) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_CLASS_ID, characterClass.getId());
                contentValues.put(COLUMN_SKILL_ID, skill.getId());
                final long rowId = db.insertOrThrow(TABLE_CLASS_SKILL, null, contentValues);
                if (rowId == -1) {
                    throw new IllegalStateException("Can't insert skill (" + skill + ") to class (" + characterClass + ")");
                }
            }
        }
    }

    private int setEnum(final EnumSet<?> enumset) {
        int result = 0;
        for (final Enum<?> currentEnum : enumset) {
            result += 1 << currentEnum.ordinal();
        }
        return result;
    }

}
