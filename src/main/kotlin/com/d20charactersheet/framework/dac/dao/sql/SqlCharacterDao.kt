package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.CharacterDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ABILITY_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ALIGNMENT_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_AMMUNITION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ARMOR
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ATTACK_BONUS_MODIFIER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ATTACK_WIELD_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_BODY_PART_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CAST
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CATEGORY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CHARAKTER_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CHARISMA
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CLASS_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CMB_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CMD_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CONSTITUTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_COPPER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DAMAGE_BONUS_MODIFIER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DATE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DEXTERITY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_EXPERIENCE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FAVORITE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FEAT_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FORTITUDE_MISC_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_GOLD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_HITPOINTS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_IMAGE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_INI_MISC_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_INTELLIGENCE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ITEMCLASS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ITEM_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MAX_HITPOINTS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_MISC_MODIFIER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_OWNED
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_PLATINUM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_PLAYER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_RACE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_RANK
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_REFLEX_MISC_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SEX_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SILVER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SKILL_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELLLIST_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SPELL_SLOT_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_STRENGTH
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_TEXT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_THUMB_IMAGE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WEAPON_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WILL_MISC_MOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_WISDOM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_XP_TABLE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.FROM
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_CHARACTERS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_ABILITIES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_BODY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_CLASS_LEVELS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_FEATS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_KNOWN_SPELLS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_NOTES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_SKILLS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_SPELL_SLOTS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_SPELL_SLOT_ABILITIES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_SPELL_SLOT_FEATS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_CHARACTER_WEAPON_ATTACKS
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_ABILITY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_ARMOR
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_BODY_PART
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_CLASS_LEVEL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_FEAT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_GOOD
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_KNOWN_SPELL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_NOTE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_SKILL
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_SPELL_SLOT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_SPELL_SLOT_ABILITY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_SPELL_SLOT_FEAT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_WEAPON
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_CHARAKTER_WEAPON_ATTACK
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.*
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Data access object to access data of a SQLite 3 database.
 */
class SqlCharacterDao(private val db: Database) : CharacterDao {
    
    private val weaponHelper: WeaponHelper
    private val armorHelper: ArmorHelper
    private val goodHelper: GoodHelper
    private val daoUtil: DaoUtil

    init {
        val helper = SqlItemDaoHelper(db)
        weaponHelper = WeaponHelper(db, helper)
        armorHelper = ArmorHelper(db, helper)
        goodHelper = GoodHelper(db, helper)
        daoUtil = DaoUtil()
    }


    override fun getAllCharacters(allCharacterClasses: List<CharacterClass>, allRaces: List<Race>,
                                  allXpTables: List<XpTable>): List<Character> {
        val characters: MutableList<Character> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_CHARACTERS, arrayOf())
            val characterRowMapper: RowMapper = CharacterRowMapper(allRaces, allXpTables)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val character = characterRowMapper.mapRow(queryResult.getDataRow()) as Character
                character.classLevels = getClassLevels(character, allCharacterClasses)
                characters.add(character)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all characters", sqlException);
        } finally {
            queryResult?.close()
        }
        return characters
    }

    private fun getClassLevels(character: Character, allCharacterClasses: List<CharacterClass>): List<ClassLevel> {
        val classLevels: MutableList<ClassLevel> = LinkedList()
        var queryResult: QueryResult? = null
        val characterId = arrayOf(character.id.toString())
        try {
            queryResult = db.rawQuery(SQL_GET_CHARACTER_CLASS_LEVELS, characterId)
            val classLevelRowMapper: RowMapper = ClassLevelRowMapper(allCharacterClasses)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val classLevel = classLevelRowMapper.mapRow(queryResult.getDataRow()) as ClassLevel
                classLevel.characterAbilities = getCharacterAbilities(character, classLevel.characterClass)
                classLevels.add(classLevel)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get class levels of character: " + character, sqlException);
        } finally {
            queryResult?.close()
        }
        return classLevels
    }

    override fun getCharacter(id: Int, allCharacterClasses: List<CharacterClass>, allRaces: List<Race>,
                              allXpTables: List<XpTable>): Character {
        var queryResult: QueryResult? = null
        try {
            val bindVariables = arrayOf(id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER, bindVariables)
            val character = getCharacter(queryResult, allRaces, allXpTables)
            if (character != null) {
                character.classLevels = getClassLevels(character, allCharacterClasses)
                return character
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get character with id: " + id, sqlException);
        } finally {
            queryResult?.close()
        }
        throw IllegalStateException("Can't get character with id: $id")
    }

    @Throws(SQLException::class)
    private fun getCharacter(queryResult: QueryResult, allRaces: List<Race>, allXpTables: List<XpTable>): Character? {
        queryResult.moveToFirst()
        return if (queryResult.isAfterLast()) {
            null
        } else CharacterRowMapper(allRaces, allXpTables).mapRow(queryResult.getDataRow()) as Character
    }

    /**
     * @see CharacterDao.updateCharacter
     */
    override fun updateCharacter(character: Character): Character {
        updateCharakterTable(character)
        return character
    }

    private fun updateCharakterTable(character: Character) {
        val values = getCharacterValues(character)
        val bindVariables = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_CHARAKTER, values, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    private fun getCharacterValues(character: Character): ContentValues {
        val values = ContentValues()

        // stats
        values.put(COLUMN_PLAYER, character.player)
        values.put(COLUMN_NAME, character.name)
        values.put(COLUMN_RACE_ID, character.race.id)
        values.put(COLUMN_SEX_ID, character.sex.ordinal)
        values.put(COLUMN_ALIGNMENT_ID, character.alignment.ordinal)
        values.put(COLUMN_XP_TABLE_ID, character.xpTable.id)
        values.put(COLUMN_EXPERIENCE, character.experiencePoints)

        // abilities
        values.put(COLUMN_STRENGTH, character.strength)
        values.put(COLUMN_DEXTERITY, character.dexterity)
        values.put(COLUMN_CONSTITUTION, character.constitution)
        values.put(COLUMN_INTELLIGENCE, character.intelligence)
        values.put(COLUMN_WISDOM, character.wisdom)
        values.put(COLUMN_CHARISMA, character.charisma)

        // combat
        values.put(COLUMN_HITPOINTS, character.hitPoints)
        values.put(COLUMN_MAX_HITPOINTS, character.maxHitPoints)
        values.put(COLUMN_ARMOR, character.armorClass)
        values.put(COLUMN_INI_MISC_MOD, character.initiativeModifier)
        values.put(COLUMN_CMB_MOD, character.cmbModifier)
        values.put(COLUMN_CMD_MOD, character.cmdModifier)

        // saving throws
        values.put(COLUMN_FORTITUDE_MISC_MOD, character.fortitudeModifier)
        values.put(COLUMN_REFLEX_MISC_MOD, character.reflexModifier)
        values.put(COLUMN_WILL_MISC_MOD, character.willModifier)

        // images
        values.put(COLUMN_IMAGE_ID, character.imageId)
        values.put(COLUMN_THUMB_IMAGE_ID, character.thumbImageId)

        // money
        val money = character.money
        values.put(COLUMN_PLATINUM, money.platinum)
        values.put(COLUMN_GOLD, money.gold)
        values.put(COLUMN_SILVER, money.silver)
        values.put(COLUMN_COPPER, money.copper)
        return values
    }

    /**
     * @see CharacterDao.createCharacter
     */
    override fun createCharacter(character: Character): Character {
        val characterValues = getCharacterValues(character)
        characterValues.putNull(COLUMN_ID)
        var rowId: Long
        synchronized(Database.DB_LOCK) {
            rowId = db.insertOrThrow(TABLE_CHARAKTER, characterValues)
            check(rowId != -1L) { "Can't insert character in charakter table" }
        }
        character.id = db.queryId(SQL_GET_CHARACTER_ID, rowId)
        val classLevel = character.classLevels[0]
        val classValues = getClassLevelValues(character, classLevel)
        classValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            rowId = db.insertOrThrow(TABLE_CHARAKTER_CLASS_LEVEL, classValues)
            check(rowId != -1L) { "Can't insert class level in charakter_class_level table" }
        }
        classLevel.id = db.queryId(SQL_GET_CLASS_LEVEL_ID, rowId)
        for (characterAbility in classLevel.characterAbilities) {
            createCharacterAbility(character, classLevel.characterClass, characterAbility)
        }
        return character
    }

    private fun getClassLevelValues(character: Character, classLevel: ClassLevel): ContentValues {
        // id, charakter_id, charakter_class_id, level
        val values = ContentValues()
        values.put(COLUMN_CHARAKTER_ID, character.id)
        values.put(COLUMN_CLASS_ID, classLevel.characterClass.id)
        values.put(COLUMN_LEVEL, classLevel.level)
        return values
    }

    /**
     * @see CharacterDao.deleteCharacter
     */
    override fun deleteCharacter(character: Character) {

        // delete notes
        val characterId = arrayOf(character.id.toString())

        // delete class levels (table charakter_class)
        synchronized(Database.DB_LOCK) {
            var numberOfAffectedRows = db.delete(TABLE_CHARAKTER_CLASS_LEVEL, "$COLUMN_CHARAKTER_ID = ?", characterId)
            check(numberOfAffectedRows != 0) { "Can't delete class levels of character: $character" }

            // delete character (table charakter)
            numberOfAffectedRows = db.delete(TABLE_CHARAKTER, "$COLUMN_ID = ?", characterId)
            check(numberOfAffectedRows != 0) { "Can't delete character: $character" }
        }
    }

    override fun getCharacterFeats(character: Character, allFeats: List<Feat>): List<CharacterFeat> {
        val characterFeats: MutableList<CharacterFeat> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_FEATS, params)
            val characterFeatRowMapper: RowMapper = CharacterFeatRowMapper(allFeats)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val characterFeat = characterFeatRowMapper.mapRow(queryResult.getDataRow()) as CharacterFeat
                characterFeats.add(characterFeat)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get character feats", sqlException);
        } finally {
            queryResult?.close()
        }
        return characterFeats
    }

    override fun updateCharacterFeats(character: Character) {
        deleteCharacterFeats(character)
        insertFeats(character)
    }

    override fun deleteCharacterFeats(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_FEAT, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    private fun insertFeats(character: Character) {
        synchronized(Database.DB_LOCK) {
            for (characterFeat in character.characterFeats) {
                val values = ContentValues()
                values.putNull(COLUMN_ID)
                values.put(COLUMN_CHARAKTER_ID, character.id)
                values.put(COLUMN_FEAT_ID, characterFeat.feat.id)
                values.put(COLUMN_CATEGORY, characterFeat.category)
                db.insertOrThrow(TABLE_CHARAKTER_FEAT, values)
            }
        }
    }

    override fun getCharacterSkills(character: Character, allSkills: List<Skill>): List<CharacterSkill> {
        val characterSkills: MutableList<CharacterSkill> = ArrayList()
        var queryResult: QueryResult? = null
        val characterSkillRowMapper: RowMapper = FavoriteCharacterSkillRowMapper(allSkills)
        try {
            val params = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_SKILLS, params)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val characterSkill = characterSkillRowMapper.mapRow(queryResult.getDataRow()) as CharacterSkill
                characterSkills.add(characterSkill)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get character skills", sqlException);
        } finally {
            queryResult?.close()
        }
        return characterSkills
    }

    override fun deleteCharacterSkills(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_SKILL, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun getWeapons(character: Character, allWeapons: List<Weapon>): List<ItemGroup> {
        return weaponHelper.getWeapons(character, allWeapons)
    }

    override fun getArmor(character: Character, allArmor: List<Armor>): List<ItemGroup> {
        return armorHelper.getArmor(character, allArmor)
    }

    override fun getGoods(character: Character, allGoods: List<Good>): List<ItemGroup> {
        return goodHelper.getGoods(character, allGoods)
    }

    override fun updateWeapons(character: Character, weapons: List<ItemGroup>): List<ItemGroup> {
        return weaponHelper.updateWeapons(character, weapons)
    }

    override fun updateArmor(character: Character, armor: List<ItemGroup>): List<ItemGroup> {
        return armorHelper.updateArmor(character, armor)
    }

    override fun updateGoods(character: Character, goods: List<ItemGroup>): List<ItemGroup> {
        return goodHelper.updateGoods(character, goods)
    }

    override fun deleteSkill(skill: Skill) {
        val skillId = arrayOf(skill.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_SKILL, "$COLUMN_SKILL_ID = ?", skillId) }
    }

    override fun deleteFeat(feat: Feat) {
        val featId = arrayOf(feat.id.toString())
        synchronized(Database.DB_LOCK) {
            db.delete(TABLE_CHARAKTER_FEAT, "$COLUMN_FEAT_ID = ?", featId)
            db.delete(TABLE_CHARAKTER_SPELL_SLOT_FEAT, "$COLUMN_FEAT_ID = ?", featId)
        }
    }

    override fun getNotes(character: Character): List<Note> {
        val notes: MutableList<Note> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_NOTES, params)
            val noteRowMapper = NoteRowMapper(CharacterDao.DATE_FORMAT)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val note = noteRowMapper.mapRow(queryResult.getDataRow()) as Note
                notes.add(note)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get items of character", sqlException);
        } finally {
            queryResult?.close()
        }
        return notes
    }

    override fun createNote(note: Note, character: Character): Note {
        val noteValues = getNoteValues(note, character)
        noteValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CHARAKTER_NOTE, noteValues)
            check(rowId != -1L) { "Can't insert note in note table" }
            note.id = db.queryId(SQL_GET_NOTE_ID, rowId)
        }
        return note
    }

    override fun updateNote(note: Note, character: Character) {
        val noteValues = getNoteValues(note, character)
        val bindVariables = arrayOf(note.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_CHARAKTER_NOTE, noteValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    private fun getNoteValues(note: Note, character: Character): ContentValues {
        val noteValues = ContentValues()
        noteValues.put(COLUMN_CHARAKTER_ID, character.id)
        noteValues.put(COLUMN_DATE, SimpleDateFormat(CharacterDao.DATE_FORMAT, Locale.getDefault()).format(note.date))
        noteValues.put(COLUMN_TEXT, note.text)
        return noteValues
    }

    override fun deleteNote(note: Note) {
        val noteId = arrayOf(note.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.delete(TABLE_CHARAKTER_NOTE, "$COLUMN_ID = ?", noteId)
            check(numberOfAffectedRows != 0) { "Can't delete note" }
        }
    }

    override fun newCharacterSkill(skill: Skill): CharacterSkill {
        return FavoriteCharacterSkill(skill)
    }

    override fun deleteNotes(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_NOTE, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun deleteWeapons(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_WEAPON, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun deleteArmor(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_ARMOR, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun deleteGoods(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_GOOD, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun getCharacterAbilities(character: Character, characterClass: CharacterClass): List<CharacterAbility> {
        val characterAbilities: MutableList<CharacterAbility> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val params = arrayOf(character.id.toString(), characterClass.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_ABILITIES, params)
            val rowMapper = CharacterAbilityRowMapper(characterClass.classAbilities)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                try {
                    val characterAbility = rowMapper.mapRow(queryResult.getDataRow()) as CharacterAbility
                    characterAbilities.add(characterAbility)
                } catch (illegalArgumentException: IllegalArgumentException) {
                    //                    Logger.warn(illegalArgumentException.getMessage(), illegalArgumentException);
                }
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get character abilities of character", sqlException);
        } finally {
            queryResult?.close()
        }
        return characterAbilities
    }

    override fun createCharacterAbility(character: Character, characterClass: CharacterClass,
                                        characterAbility: CharacterAbility) {
        val characterAbilityValues = getCharacterAbilityValues(character, characterClass, characterAbility)
        characterAbilityValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CHARAKTER_ABILITY, characterAbilityValues)
            check(rowId != -1L) { "Can't insert character ability in character_ability table" }
            characterAbility.id = db.queryId(SQL_GET_CHARACTER_ABILITY_ID, rowId)
        }
    }

    override fun updateCharacterAbility(characterAbility: CharacterAbility) {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_OWNED, daoUtil.setBoolean(characterAbility.isOwned))
        val id = arrayOf(characterAbility.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_CHARAKTER_ABILITY, contentValues, SQL_WHERE_ID, id)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    private fun getCharacterAbilityValues(character: Character, characterClass: CharacterClass,
                                          characterAbility: CharacterAbility): ContentValues {
        val values = ContentValues()
        values.put(COLUMN_CHARAKTER_ID, character.id)
        values.put(COLUMN_CLASS_ID, characterClass.id)
        values.put(COLUMN_ABILITY_ID, characterAbility.classAbility.ability.id)
        values.put(COLUMN_OWNED, daoUtil.setBoolean(characterAbility.isOwned))
        return values
    }

    override fun deleteCharacterAbility(characterAbility: CharacterAbility) {
        val id = arrayOf(characterAbility.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_ABILITY, SQL_WHERE_ID, id) }
    }

    override fun deleteCharacterAbilities(character: Character) {
        val id = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_ABILITY, "$COLUMN_CHARAKTER_ID = ?", id) }
    }

    override fun createClassLevel(character: Character, classLevel: ClassLevel): ClassLevel {
        val classLevelValues = getClassLevelValues(classLevel, character)
        classLevelValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CHARAKTER_CLASS_LEVEL, classLevelValues)
            check(rowId != -1L) { "Can't insert class level in class level table" }
            classLevel.id = db.queryId(SQL_GET_CLASS_LEVEL_ID, rowId)
        }
        for (characterAbility in classLevel.characterAbilities) {
            createCharacterAbility(character, classLevel.characterClass, characterAbility)
        }
        return classLevel
    }

    private fun getClassLevelValues(classLevel: ClassLevel, character: Character): ContentValues {
        // id, character_id, class_id, level
        val values = ContentValues()
        values.put(COLUMN_CHARAKTER_ID, character.id)
        values.put(COLUMN_CLASS_ID, classLevel.characterClass.id)
        values.put(COLUMN_LEVEL, classLevel.level)
        return values
    }

    override fun updateClassLevel(classLevel: ClassLevel) {
        val values = ContentValues()
        values.put(COLUMN_LEVEL, classLevel.level)
        val bindVariables = arrayOf(classLevel.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_CHARAKTER_CLASS_LEVEL, values, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
        for (characterAbility in classLevel.characterAbilities) {
            updateCharacterAbility(characterAbility)
        }
    }

    override fun deleteClassLevel(classLevel: ClassLevel) {
        for (characterAbility in classLevel.characterAbilities) {
            deleteCharacterAbility(characterAbility)
        }
        val classLevelId = arrayOf(classLevel.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.delete(TABLE_CHARAKTER_CLASS_LEVEL, "$COLUMN_ID = ?", classLevelId)
            check(numberOfAffectedRows != 0) { "Can't delete class level" }
        }
    }

    override fun deleteCharacterAbilities(characterClass: CharacterClass, classAbilities: List<ClassAbility>) {
        val classId = characterClass.id.toString()
        synchronized(Database.DB_LOCK) {
            for (classAbility in classAbilities) {
                val params = arrayOf(classId, classAbility.ability.id.toString())
                val numberOfAffectedRows = db.delete(TABLE_CHARAKTER_ABILITY, WHERE_CHARACTER_ABILITY, params)
                check(numberOfAffectedRows != 0) { "Can't delete character ability" }
            }
        }
    }

    override fun getWeaponAttacks(character: Character, allWeapons: List<Weapon>): List<WeaponAttack> {
        val weaponAttacks: MutableList<WeaponAttack> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val characterId = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_WEAPON_ATTACKS, characterId)
            val weaponAttackRowMapper = WeaponAttackRowMapper(allWeapons)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val weaponAttack = weaponAttackRowMapper.mapRow(queryResult.getDataRow()) as WeaponAttack
                weaponAttacks.add(weaponAttack)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get weapon attacks of " + character, sqlException);
        } finally {
            queryResult?.close()
        }
        return weaponAttacks
    }

    override fun createWeaponAttack(character: Character, weaponAttack: WeaponAttack): WeaponAttack {
        val weaponAttackValues = getWeaponAttackValues(weaponAttack)
        weaponAttackValues.putNull(COLUMN_ID)
        weaponAttackValues.put(COLUMN_CHARAKTER_ID, character.id)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CHARAKTER_WEAPON_ATTACK, weaponAttackValues)
            check(rowId != -1L) { "Can't insert weapon attack in weapon_attack table" }
            weaponAttack.id = db.queryId(SQL_GET_WEAPON_ATTACK_ID, rowId)
        }
        return weaponAttack
    }

    private fun getWeaponAttackValues(weaponAttack: WeaponAttack): ContentValues {
        val weaponAttackValues = ContentValues()
        weaponAttackValues.put(COLUMN_NAME, weaponAttack.name)
        weaponAttackValues.put(COLUMN_DESCRIPTION, weaponAttack.description)
        weaponAttackValues.put(COLUMN_ATTACK_WIELD_ID, weaponAttack.attackWield.ordinal)
        weaponAttackValues.put(COLUMN_WEAPON_ID, weaponAttack.weapon.id)
        weaponAttackValues.put(COLUMN_AMMUNITION, weaponAttack.ammunition)
        weaponAttackValues.put(COLUMN_ATTACK_BONUS_MODIFIER, weaponAttack.attackBonusModifier)
        weaponAttackValues.put(COLUMN_DAMAGE_BONUS_MODIFIER, weaponAttack.damageBonusModifier)
        return weaponAttackValues
    }

    override fun updateWeaponAttack(weaponAttack: WeaponAttack) {
        val weaponAttackValues = getWeaponAttackValues(weaponAttack)
        val bindVariables = arrayOf(weaponAttack.id.toString())
        val numberOfAffectedRows = db.update(TABLE_CHARAKTER_WEAPON_ATTACK, weaponAttackValues, SQL_WHERE_ID, bindVariables)
        check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
    }

    override fun deleteWeaponAttack(weaponAttack: WeaponAttack) {
        val weaponAttackId = arrayOf(weaponAttack.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.delete(TABLE_CHARAKTER_WEAPON_ATTACK, "$COLUMN_ID = ?", weaponAttackId)
            check(numberOfAffectedRows != 0) { "Can't delete note" }
        }
    }

    override fun deleteWeaponAttacks(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_WEAPON_ATTACK, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun createKnownSpell(character: Character, knownSpell: KnownSpell): KnownSpell {
        synchronized(Database.DB_LOCK) {
            val knownSpellValues = getKnownSpellValues(knownSpell, character)
            knownSpellValues.putNull(COLUMN_ID)
            val rowId = db.insertOrThrow(TABLE_CHARAKTER_KNOWN_SPELL, knownSpellValues)
            check(rowId != -1L) { "Can't insert character spell in character spell table" }
            knownSpell.id = db.queryId(SQL_GET_CHARACTER_KNOWN_SPELL_ID, rowId)
        }
        return knownSpell
    }

    private fun getKnownSpellValues(knownSpell: KnownSpell, character: Character): ContentValues {
        val knownSpellValues = ContentValues()
        knownSpellValues.put(COLUMN_CHARAKTER_ID, character.id)
        knownSpellValues.put(COLUMN_SPELLLIST_ID, knownSpell.spelllist.id)
        knownSpellValues.put(COLUMN_SPELL_ID, knownSpell.spell.id)
        return knownSpellValues
    }

    override fun deleteKnownSpell(knownSpell: KnownSpell) {
        synchronized(Database.DB_LOCK) {
            val knownSpellId = arrayOf(knownSpell.id.toString())
            val numberOfAffectedRows = db.delete(TABLE_CHARAKTER_KNOWN_SPELL, WHERE_ID, knownSpellId)
            check(numberOfAffectedRows != 0) { "Can't delete known spell $knownSpell" }
        }
    }

    override fun deleteKnownSpells(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_KNOWN_SPELL, WHERE_CHARACTER_ID, characterId) }
    }

    override fun getKnownSpells(character: Character, allSpelllist: List<Spelllist>, allSpells: List<Spell>): List<KnownSpell> {
        val knownSpells: MutableList<KnownSpell> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val knownSpellRowMapper: RowMapper = KnownSpellRowMapper(allSpelllist, allSpells)
            val characterId = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_KNOWN_SPELLS, characterId)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                try {
                    val knownSpell = knownSpellRowMapper.mapRow(queryResult.getDataRow()) as KnownSpell
                    knownSpells.add(knownSpell)
                } catch (illegalArgumentException: IllegalArgumentException) {
                    //                    Logger.warn(illegalArgumentException.getLocalizedMessage(), illegalArgumentException);
                }
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all known spells", sqlException);
        } finally {
            queryResult?.close()
        }
        return knownSpells
    }

    override fun getSpellSlots(character: Character, allSpells: List<Spell>, allAbilities: List<Ability>,
                               allFeats: List<Feat>): List<SpellSlot> {
        val spelllistAbilities = getSpelllistAbilities(allAbilities)
        val metaMagicFeats = getMetamagicFeats(allFeats)
        val spellSlots: MutableList<SpellSlot> = ArrayList()
        var queryResult: QueryResult? = null
        try {
            val spellSlotRowMapper: RowMapper = SpellSlotRowMapper(allSpells)
            val characterId = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_SPELL_SLOTS, characterId)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val spellSlot = spellSlotRowMapper.mapRow(queryResult.getDataRow()) as SpellSlot
                spellSlot.spelllistAbilities = getSpelllistAbilities(spellSlot, spelllistAbilities)
                spellSlot.metamagicFeats = getMetaMagicFeats(spellSlot, metaMagicFeats)
                spellSlots.add(spellSlot)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all spell slots", sqlException);
        } finally {
            queryResult?.close()
        }
        return spellSlots
    }

    private fun getSpelllistAbilities(allAbilities: List<Ability>): List<SpelllistAbility> {
        val spelllistAbilities: MutableList<SpelllistAbility> = LinkedList()
        for (ability in allAbilities) {
            if (ability is SpelllistAbility) {
                spelllistAbilities.add(ability)
            }
        }
        return spelllistAbilities
    }

    private fun getMetamagicFeats(allFeats: List<Feat>): List<Feat> {
        val metamagicFeats: MutableList<Feat> = LinkedList()
        for (feat in allFeats) {
            if (FeatType.METAMAGIC == feat.featType) {
                metamagicFeats.add(feat)
            }
        }
        return metamagicFeats
    }

    private fun getSpelllistAbilities(spellSlot: SpellSlot,
                                      allSpelllistAbilities: List<SpelllistAbility>): List<SpelllistAbility> {
        val spelllistAbilities: MutableList<SpelllistAbility> = LinkedList()
        var queryResult: QueryResult? = null
        try {
            val spellSlotId = arrayOf(spellSlot.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_SPELL_SLOT_ABILITIES, spellSlotId)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val spelllistAbility = getSpelllistAbility(queryResult.getDataRow().getInt(0),
                        allSpelllistAbilities)
                spelllistAbilities.add(spelllistAbility)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get spell slot abilities", sqlException);
        } finally {
            queryResult?.close()
        }
        return spelllistAbilities
    }

    private fun getSpelllistAbility(spelllistAbilityId: Int, allSpelllistAbilities: List<SpelllistAbility>): SpelllistAbility {
        for (spelllistAbility in allSpelllistAbilities) {
            if (spelllistAbility.id == spelllistAbilityId) {
                return spelllistAbility
            }
        }
        throw IllegalArgumentException("Can't find spell list ability with id: $spelllistAbilityId")
    }

    private fun getMetaMagicFeats(spellSlot: SpellSlot, allMetamagicFeats: List<Feat>): List<Feat> {
        val metamagicFeats: MutableList<Feat> = LinkedList()
        var queryResult: QueryResult? = null
        try {
            val spellSlotId = arrayOf(spellSlot.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_SPELL_SLOT_FEATS, spellSlotId)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val metamagicFeat = getMetamagicFeat(queryResult.getDataRow().getInt(0), allMetamagicFeats)
                metamagicFeats.add(metamagicFeat)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get spell slot feats", sqlException);
        } finally {
            queryResult?.close()
        }
        return metamagicFeats
    }

    private fun getMetamagicFeat(metamagicFeatId: Int, allMetamagicFeats: List<Feat>): Feat {
        for (metamagicFeat in allMetamagicFeats) {
            if (metamagicFeat.id == metamagicFeatId) {
                return metamagicFeat
            }
        }
        throw IllegalArgumentException("Can't find spell list feat with id: $metamagicFeatId")
    }

    override fun updateSpellSlot(spellSlot: SpellSlot) {
        val contentValues = getSpellSlotValues(spellSlot)
        val spellSlotId = arrayOf(spellSlot.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_CHARAKTER_SPELL_SLOT, contentValues, SQL_WHERE_ID, spellSlotId)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
            db.delete(TABLE_CHARAKTER_SPELL_SLOT_FEAT, "$COLUMN_SPELL_SLOT_ID = ?", spellSlotId)
            for (metamagicFeat in spellSlot.metamagicFeats) {
                val metamagicFeatContentValues = getMetamagicFeatValues(spellSlot.id, metamagicFeat)
                db.insertOrThrow(TABLE_CHARAKTER_SPELL_SLOT_FEAT, metamagicFeatContentValues)
            }
        }
    }

    private fun getMetamagicFeatValues(spellSlotId: Int, metamagicFeat: Feat): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_SPELL_SLOT_ID, spellSlotId)
        contentValues.put(COLUMN_FEAT_ID, metamagicFeat.id)
        return contentValues
    }

    private fun getSpellSlotValues(spellSlot: SpellSlot): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_SPELL_ID, spellSlot.spell.id)
        contentValues.put(COLUMN_LEVEL, spellSlot.level)
        contentValues.put(COLUMN_CAST, spellSlot.isCast)
        return contentValues
    }

    override fun createSpellSlot(character: Character, spellSlot: SpellSlot): SpellSlot {
        insertSpellSlot(character, spellSlot)
        insertSpellSlotAbility(spellSlot)
        insertSpellSlotFeat(spellSlot)
        return spellSlot
    }

    private fun insertSpellSlot(character: Character, spellSlot: SpellSlot) {
        val contentValues = getSpellSlotValues(spellSlot)
        contentValues.putNull(COLUMN_ID)
        contentValues.put(COLUMN_CHARAKTER_ID, character.id)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_CHARAKTER_SPELL_SLOT, contentValues)
            check(rowId != -1L) { "Can't insert spell slot in charakter_spell_slot table" }
            spellSlot.id = db.queryId(SQL_GET_SPELL_SLOT_ID, rowId)
        }
    }

    private fun insertSpellSlotAbility(spellSlot: SpellSlot) {
        for (spelllistAbility in spellSlot.spelllistAbilities) {
            val contentValues = getSpelllistAbilityValues(spellSlot, spelllistAbility)
            synchronized(Database.DB_LOCK) {
                val rowId = db.insertOrThrow(TABLE_CHARAKTER_SPELL_SLOT_ABILITY, contentValues)
                check(rowId != -1L) { "Can't insert spelllist ability in charakter_spell_slot_ability table" }
            }
        }
    }

    private fun getSpelllistAbilityValues(spellSlot: SpellSlot, spelllistAbility: SpelllistAbility): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_SPELL_SLOT_ID, spellSlot.id)
        contentValues.put(COLUMN_ABILITY_ID, spelllistAbility.id)
        return contentValues
    }

    private fun insertSpellSlotFeat(spellSlot: SpellSlot) {
        for (metamagicFeat in spellSlot.metamagicFeats) {
            val contentValues = getMetamagicFeatsValues(spellSlot, metamagicFeat)
            synchronized(Database.DB_LOCK) {
                val rowId = db.insertOrThrow(TABLE_CHARAKTER_SPELL_SLOT_FEAT, contentValues)
                check(rowId != -1L) { "Can't insert feat in charakter_spell_slot_feat table" }
            }
        }
    }

    private fun getMetamagicFeatsValues(spellSlot: SpellSlot, metamagicFeat: Feat): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_SPELL_SLOT_ID, spellSlot.id)
        contentValues.put(COLUMN_FEAT_ID, metamagicFeat.id)
        return contentValues
    }

    override fun deleteSpellSlot(spellSlot: SpellSlot) {
        val spellSlotId = arrayOf(spellSlot.id.toString())
        synchronized(Database.DB_LOCK) {
            db.delete(TABLE_CHARAKTER_SPELL_SLOT_FEAT, "$COLUMN_SPELL_SLOT_ID = ?", spellSlotId)
            db.delete(TABLE_CHARAKTER_SPELL_SLOT_ABILITY, "$COLUMN_SPELL_SLOT_ID = ?", spellSlotId)
            db.delete(TABLE_CHARAKTER_SPELL_SLOT, "$COLUMN_ID = ?", spellSlotId)
        }
    }

    override fun deleteSpellSlots(character: Character) {
        for (spellSlot in character.spellSlots) {
            deleteSpellSlot(spellSlot)
        }
    }

    override fun deleteKnownSpells(spelllist: Spelllist, spell: Spell) {
        val bindVariables = arrayOf(spelllist.id.toString(), spell.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_KNOWN_SPELL, WHERE_SPELLLIST_ID_AND_SPELL_ID, bindVariables) }
    }

    override fun deleteSpellSlots(spelllist: Spelllist, spell: Spell) {
        val spellId = arrayOf(spell.id.toString())
        synchronized(Database.DB_LOCK) {
            db.delete(TABLE_CHARAKTER_SPELL_SLOT, "$COLUMN_SPELL_ID = ?", spellId)
            db.delete(TABLE_CHARAKTER_SPELL_SLOT_ABILITY, WHERE_SPELL_SLOT_ID_NOT_IN_TABLE_CHARAKTER_SPELL_SLOT, arrayOf())
            db.delete(TABLE_CHARAKTER_SPELL_SLOT_FEAT, WHERE_SPELL_SLOT_ID_NOT_IN_TABLE_CHARAKTER_SPELL_SLOT, arrayOf())
        }
    }

    override fun updateCharacterSkill(character: Character, characterSkill: CharacterSkill) {
        val contentValues = getCharacterSkillContentValues(characterSkill)
        val bindVariables = arrayOf(character.id.toString(),
                characterSkill.skill.id.toString()
        )
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db
                    .update(TABLE_CHARAKTER_SKILL, contentValues, WHERE_CHARAKTER_ID_AND_SKILL_ID, bindVariables)
            if (numberOfAffectedRows == 0) {
                contentValues.put(COLUMN_SKILL_ID, characterSkill.skill.id)
                contentValues.put(COLUMN_CHARAKTER_ID, character.id)
                db.insertOrThrow(TABLE_CHARAKTER_SKILL, contentValues)
            }
            check(numberOfAffectedRows <= 1) { "More than 1 row affected: $numberOfAffectedRows" }
        }
    }

    override fun getBody(character: Character, allWeapons: List<Weapon>, allArmor: List<Armor>, allGoods: List<Good>): Body {
        val body: Body = HumanoidBody()
        var queryResult: QueryResult? = null
        try {
            val characterId = arrayOf(character.id.toString())
            queryResult = db.rawQuery(SQL_GET_CHARACTER_BODY, characterId)
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val dataRow = queryResult.getDataRow()
                val bodyPart = BodyPart.values()[dataRow.getInt(2)]
                val item = getItem(dataRow.getInt(3), dataRow.getString(4), allWeapons, allArmor, allGoods)
                body.equip(bodyPart, item)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get body parts", sqlException);
        } finally {
            queryResult?.close()
        }
        return body
    }

    private fun getItem(itemId: Int, itemclass: String, allWeapons: List<Weapon>, allArmor: List<Armor>, allGoods: List<Good>): Item {
        return when(itemclass) {
            Weapon::class.java.simpleName -> findItem(itemId, allWeapons)
            Armor::class.java.simpleName -> findItem(itemId, allArmor)
            Good::class.java.simpleName -> findItem(itemId, allGoods)
            else -> throw IllegalArgumentException("Can't find item with id: $itemId and itemclass: $itemclass")
        }
    }

    private fun findItem(itemId: Int, allItems: List<Item>): Item {
        for (item in allItems) {
            if (item.id == itemId) {
                return item
            }
        }
        throw IllegalArgumentException("Can't find item with id: $itemId")
    }

    override fun createBody(character: Character, body: Body): Body {
        for (bodyPart in body.bodyParts) {
            val item = body.getItemOfBodyPart(bodyPart)
            insertBodyPart(character, bodyPart, item)
        }
        return body
    }

    private fun insertBodyPart(character: Character, bodyPart: BodyPart, item: Item) {
        if (item != Item.EMPTY_ITEM) {
            val bodyValues = getBodyPartValues(bodyPart, item, character)
            bodyValues.putNull(COLUMN_ID)
            synchronized(Database.DB_LOCK) {
                val rowId = db.insertOrThrow(TABLE_CHARAKTER_BODY_PART, bodyValues)
                check(rowId != -1L) { "Can't insert body part in body part table" }
            }
        }
    }

    private fun getBodyPartValues(bodyPart: BodyPart, item: Item, character: Character): ContentValues {
        val bodyPartValues = ContentValues()
        bodyPartValues.put(COLUMN_CHARAKTER_ID, character.id)
        bodyPartValues.put(COLUMN_BODY_PART_ID, bodyPart.ordinal)
        bodyPartValues.put(COLUMN_ITEM_ID, item.id)
        bodyPartValues.put(COLUMN_ITEMCLASS, item.javaClass.simpleName)
        return bodyPartValues
    }

    override fun deleteBody(character: Character) {
        val characterId = arrayOf(character.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_CHARAKTER_BODY_PART, "$COLUMN_CHARAKTER_ID = ?", characterId) }
    }

    override fun updateBody(character: Character) {
        deleteBody(character)
        createBody(character, character.body)
    }

    private fun getCharacterSkillContentValues(characterSkill: CharacterSkill): ContentValues {
        val favCharacterSkill = characterSkill as FavoriteCharacterSkill
        val contentValues = ContentValues()
        contentValues.put(COLUMN_RANK, favCharacterSkill.rank)
        contentValues.put(COLUMN_MISC_MODIFIER, favCharacterSkill.modifier)
        contentValues.put(COLUMN_FAVORITE, favCharacterSkill.isFavorite)
        return contentValues
    }

    companion object {
        private const val WHERE_ROW_ID = " WHERE rowid = ?"
        private const val SELECT_ID_FROM: String = SELECT + "id FROM "
        private const val SQL_GET_CHARACTER_ID = SELECT_ID_FROM + TABLE_CHARAKTER + WHERE_ROW_ID
        private const val SQL_GET_CLASS_LEVEL_ID = SELECT_ID_FROM + TABLE_CHARAKTER_CLASS_LEVEL + WHERE_ROW_ID
        private const val SQL_GET_NOTE_ID = SELECT_ID_FROM + TABLE_CHARAKTER_NOTE + WHERE_ROW_ID
        private const val SQL_GET_SPELL_SLOT_ID = SELECT_ID_FROM + TABLE_CHARAKTER_SPELL_SLOT + WHERE_ROW_ID
        private const val SQL_GET_CHARACTER_ABILITY_ID = SELECT_ID_FROM + TABLE_CHARAKTER_ABILITY + WHERE_ROW_ID
        private const val SQL_GET_WEAPON_ATTACK_ID = SELECT_ID_FROM + TABLE_CHARAKTER_WEAPON_ATTACK + WHERE_ROW_ID
        private const val SQL_GET_CHARACTER_KNOWN_SPELL_ID = SELECT_ID_FROM + TABLE_CHARAKTER_KNOWN_SPELL + WHERE_ROW_ID
        private const val WHERE_CHARACTER_ABILITY: String = "$COLUMN_CLASS_ID = ? AND $COLUMN_ABILITY_ID = ?"
        private const val WHERE_CHARACTER_ID: String = "$COLUMN_CHARAKTER_ID = ?"
        private const val WHERE_ID: String = "$COLUMN_ID = ?"
        private const val WHERE_SPELLLIST_ID_AND_SPELL_ID: String = "$COLUMN_SPELLLIST_ID = ? AND $COLUMN_SPELL_ID = ?"
        private const val WHERE_SPELL_SLOT_ID_NOT_IN_TABLE_CHARAKTER_SPELL_SLOT = "$COLUMN_SPELL_SLOT_ID NOT IN ($SELECT $COLUMN_ID $FROM $TABLE_CHARAKTER_SPELL_SLOT)"
        private const val WHERE_CHARAKTER_ID_AND_SKILL_ID: String = "$COLUMN_CHARAKTER_ID = ? AND $COLUMN_SKILL_ID = ?"
    }

}