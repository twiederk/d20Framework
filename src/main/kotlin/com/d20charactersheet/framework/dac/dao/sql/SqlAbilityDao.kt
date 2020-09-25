package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.abilitybuilder.*
import com.d20charactersheet.framework.dac.dao.AbilityDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ABILITY_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ABILITY_TYPE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_CLASSNAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_DESCRIPTION
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_PROPERTY_KEY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_PROPERTY_VALUE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ABILITY_PROPERTIES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_ABILITIES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_ABILITY
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_ABILITY_PROPERTY
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.AbilityConfigRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Provides access to the ability tables in the SQLite database.
 */
class SqlAbilityDao(private val db: Database) : AbilityDao {

    private val abilityConfigRowMapper: RowMapper = AbilityConfigRowMapper()

    override fun getAllAbilities(allSpelllists: List<Spelllist>, allKnownSpellsTables: List<KnownSpellsTable>,
                                 allSpellsPerDayTables: List<SpellsPerDayTable>): List<Ability> {
        val allAbilities: MutableList<Ability> = ArrayList()
        val abilityBuilderFactoy = createAbilityBuilderFactory(allSpelllists, allKnownSpellsTables,
                allSpellsPerDayTables)
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_ABILITIES, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val abilityConfig = abilityConfigRowMapper.mapRow(queryResult.getDataRow()) as AbilityConfig
                selectAbilityProperties(abilityConfig)
                val ability = createAbility(abilityConfig, abilityBuilderFactoy)
                allAbilities.add(ability)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
            //            Logger.error("Can't get all abilities", sqlException);
        } finally {
            queryResult?.close()
        }
        return allAbilities
    }

    private fun selectAbilityProperties(abilityConfig: AbilityConfig) {
        if (abilityConfig.classname != Ability::class.java.simpleName) {
            val abilityProperties: MutableMap<String, String> = HashMap()
            var queryResult: QueryResult? = null
            try {
                val params = arrayOf(abilityConfig.id.toString())
                queryResult = db.rawQuery(SQL_GET_ABILITY_PROPERTIES, params)
                queryResult.moveToFirst()
                while (!queryResult.isAfterLast()) {
                    val key = queryResult.getDataRow().getString(0)
                    val value = queryResult.getDataRow().getString(1)
                    abilityProperties[key] = value
                    queryResult.moveToNext()
                }
            } catch (sqlException: SQLException) {
                //                Logger.error("Can't get properties of ability: " + abilityConfig, IllegalStateException);
            } finally {
                queryResult?.close()
            }
            abilityConfig.properties = abilityProperties
        }
    }

    private fun createAbility(abilityConfig: AbilityConfig, abilityBuilderFactory: AbilityBuilderFactory): Ability {
        val abilityBuilder = abilityBuilderFactory.getAbilityBuilder(abilityConfig.classname)
        return abilityBuilder.createAbility(abilityConfig)
    }

    override fun createAbility(ability: Ability): Ability {
        insertAbilityTable(ability)
        insertAbilityPropertyTable(ability)
        return ability
    }

    private fun insertAbilityTable(ability: Ability) {
        val abilityValues = getAbilityValues(ability)
        abilityValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_ABILITY, abilityValues)
            check(rowId != -1L) { "Can't insert ability in ability table" }
            ability.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    private fun getAbilityValues(ability: Ability): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, ability.name)
        contentValues.put(COLUMN_DESCRIPTION, ability.description)
        contentValues.put(COLUMN_ABILITY_TYPE_ID, ability.abilityType.ordinal)
        contentValues.put(COLUMN_CLASSNAME, ability.javaClass.simpleName)
        return contentValues
    }

    private fun insertAbilityPropertyTable(ability: Ability) {
        (ability as? ExtraFeatsAbility)?.let { insertExtraFeatAbility(it) }
                ?: ((ability as? ExtraSkillPointsAbility)?.let { insertExtraSkillPointsAbility(it) }
                        ?: (ability as? SpelllistAbility)?.let { insertSpelllistAbility(it) })
    }

    private fun insertExtraFeatAbility(ability: Ability) {
        val extraFeatsAbility = ability as ExtraFeatsAbility
        insertAbilityProperty(ability.getId(), ExtraFeatsAbilityBuilder.KEY_NUMBER_OF_EXTRA_FEATS, extraFeatsAbility.numberOfFeats)
    }

    private fun insertExtraSkillPointsAbility(ability: Ability) {
        val extraSkillPointsAbility = ability as ExtraSkillPointsAbility
        insertAbilityProperty(ability.getId(), ExtraSkillPointsAbilityBuilder.KEY_NUMBER_OF_SKILL_POINTS, extraSkillPointsAbility.skillPoints)
    }

    private fun insertSpelllistAbility(ability: Ability) {
        val spelllistAbility = ability as SpelllistAbility
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELLLIST_ID, spelllistAbility.spelllist.id)
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELL_ATTRIBUTE_ID, spelllistAbility.spellAttribute.ordinal)
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_CASTING_TYPE_ID, spelllistAbility.castingType.ordinal)
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELL_SOURCE_ID, spelllistAbility.spellSource.ordinal)
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_KNOWN_SPELLS_TABLE_ID, spelllistAbility.knownSpellsTable.id)
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELLS_PER_DAY_TABLE_ID, spelllistAbility.spellsPerDayTable.id)
        insertAbilityProperty(ability.getId(), spelllistAbility.isAttributeBonusSpellSlots)
        insertAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SCHOOL_ID, getSchoolId(spelllistAbility.schools))
    }

    private fun getSchoolId(schools: EnumSet<School?>): Int {
        if (schools.size == 1) {
            val school = arrayOfNulls<School>(1)
            schools.toArray(school)
            return school[0]!!.ordinal
        }
        return SpelllistAbilityBuilder.ANY_SCHOOL_ID
    }

    private fun insertAbilityProperty(abilityId: Int, property_value: Boolean) {
        insertAbilityProperty(abilityId, SpelllistAbilityBuilder.KEY_ATTRIBUTE_BONUS_SPELL_SLOTS, java.lang.Boolean.toString(property_value))
    }

    private fun insertAbilityProperty(abilityId: Int, property_key: String, property_value: Int) {
        insertAbilityProperty(abilityId, property_key, property_value.toString())
    }

    private fun insertAbilityProperty(abilityId: Int, property_key: String, property_value: String) {
        val contentValues = getAbilityPropertyContentValues(abilityId, property_key, property_value)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_ABILITY_PROPERTY, contentValues)
            check(rowId != -1L) { "Can't insert ability property in ability_property table" }
        }
    }

    override fun updateAbility(ability: Ability) {
        updateAbilityTable(ability)
        updateAbilityPropertyTable(ability)
    }

    private fun updateAbilityTable(ability: Ability) {
        val abilityValues = getAbilityValues(ability)
        val bindVariables = arrayOf(ability.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_ABILITY, abilityValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "More or Less than 1 row affected: $numberOfAffectedRows" }
        }
    }

    private fun updateAbilityPropertyTable(ability: Ability) {
        (ability as? ExtraFeatsAbility)?.let { updateExtraFeatAbility(it) }
                ?: ((ability as? ExtraSkillPointsAbility)?.let { updateExtraSkillPointsAbility(it) }
                        ?: (ability as? SpelllistAbility)?.let { updateSpelllistAbility(it) })
    }

    private fun updateExtraFeatAbility(ability: Ability) {
        val extraFeatsAbility = ability as ExtraFeatsAbility
        updateAbilityProperty(ability.getId(), ExtraFeatsAbilityBuilder.KEY_NUMBER_OF_EXTRA_FEATS, extraFeatsAbility.numberOfFeats)
    }

    private fun updateExtraSkillPointsAbility(ability: Ability) {
        val extraSkillPointsAbility = ability as ExtraSkillPointsAbility
        updateAbilityProperty(ability.getId(), ExtraSkillPointsAbilityBuilder.KEY_NUMBER_OF_SKILL_POINTS, extraSkillPointsAbility.skillPoints)
    }

    private fun updateSpelllistAbility(ability: Ability) {
        val spelllistAbility = ability as SpelllistAbility
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELLLIST_ID, spelllistAbility.spelllist.id)
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELL_ATTRIBUTE_ID, spelllistAbility.spellAttribute.ordinal)
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_CASTING_TYPE_ID, spelllistAbility.castingType.ordinal)
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELL_SOURCE_ID, spelllistAbility.spellSource.ordinal)
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_KNOWN_SPELLS_TABLE_ID, spelllistAbility.knownSpellsTable.id)
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SPELLS_PER_DAY_TABLE_ID, spelllistAbility.spellsPerDayTable.id)
        updateAbilityProperty(ability.getId(), spelllistAbility.isAttributeBonusSpellSlots)
        updateAbilityProperty(ability.getId(), SpelllistAbilityBuilder.KEY_SCHOOL_ID, getSchoolId(spelllistAbility.schools))
    }

    private fun updateAbilityProperty(abilityId: Int, property_value: Boolean) {
        updateAbilityProperty(abilityId, SpelllistAbilityBuilder.KEY_ATTRIBUTE_BONUS_SPELL_SLOTS, java.lang.Boolean.toString(property_value))
    }

    private fun updateAbilityProperty(abilityId: Int, property_key: String, property_value: Int) {
        updateAbilityProperty(abilityId, property_key, property_value.toString())
    }

    private fun updateAbilityProperty(abilityId: Int, property_key: String, property_value: String) {
        val contentValues = getAbilityPropertyContentValues(abilityId, property_key, property_value)
        val bindVariables = arrayOf(abilityId.toString(), property_key)
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db
                    .update(TABLE_ABILITY_PROPERTY, contentValues, SQL_WHERE_ABILITY_ID_AND_PROPERTY_KEY, bindVariables)
            if (numberOfAffectedRows == 0) {
                db.insertOrThrow(TABLE_ABILITY_PROPERTY, contentValues)
            }
            check(numberOfAffectedRows <= 1) { "More than 1 row affected: $numberOfAffectedRows" }
        }
    }

    private fun getAbilityPropertyContentValues(abilityId: Int, property_key: String,
                                                property_value: String): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_ABILITY_ID, abilityId)
        contentValues.put(COLUMN_PROPERTY_KEY, property_key)
        contentValues.put(COLUMN_PROPERTY_VALUE, property_value)
        return contentValues
    }

    override fun deleteAbility(ability: Ability) {
        val abilityId = arrayOf(ability.id.toString())
        synchronized(Database.DB_LOCK) {
            db.delete(TABLE_ABILITY, "$COLUMN_ID = ?", abilityId)
            db.delete(TABLE_ABILITY_PROPERTY, "$COLUMN_ABILITY_ID = ?", abilityId)
        }
    }

    override fun createAbilityBuilderFactory(allSpelllists: List<Spelllist>,
                                             allKnownSpellsTables: List<KnownSpellsTable>, allSpellsPerDayTables: List<SpellsPerDayTable>): AbilityBuilderFactory {
        val abilityBuilderFactory = AbilityBuilderFactory()
        abilityBuilderFactory.registerAbilityBuilder(Ability::class.java.simpleName, DefaultAbilityBuilder())
        abilityBuilderFactory.registerAbilityBuilder(ExtraFeatsAbility::class.java.simpleName, ExtraFeatsAbilityBuilder())
        abilityBuilderFactory
                .registerAbilityBuilder(ExtraSkillPointsAbility::class.java.simpleName, ExtraSkillPointsAbilityBuilder())
        abilityBuilderFactory.registerAbilityBuilder(SpelllistAbility::class.java.simpleName,
                SpelllistAbilityBuilder(allSpelllists, allKnownSpellsTables,
                        allSpellsPerDayTables))
        return abilityBuilderFactory
    }

    companion object {
        private const val SQL_GET_ID: String = SELECT + "id FROM " + TABLE_ABILITY + " WHERE rowid = ?"
        private const val SQL_WHERE_ABILITY_ID_AND_PROPERTY_KEY: String = "$COLUMN_ABILITY_ID = ? AND $COLUMN_PROPERTY_KEY = ?"
    }

}