package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Race
import com.d20charactersheet.framework.dac.dao.RaceDao
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ABILITY_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_BASE_LAND_SPEED
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_FAV_CLASS_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_NAME
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_RACE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.COLUMN_SIZE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SELECT
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ABILITY_IDS_OF_RACE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_GET_ALL_RACES
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.SQL_WHERE_ID
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_RACE
import com.d20charactersheet.framework.dac.dao.sql.TableAndColumnNames.TABLE_RACE_ABILITY
import com.d20charactersheet.framework.dac.dao.sql.rowmapper.RaceRowMapper
import java.sql.SQLException
import java.util.*

/**
 * Provides access to the tables storing the races in a SQLite database.
 *  Create SQLiteRaceDao accessing the given database.
 *
 * @param db
 * The database to access.
 */
class SqlRaceDao(private val db: Database) : RaceDao {

    override fun getAllRaces(allCharacterClasses: List<CharacterClass>, allAbilities: List<Ability>): List<Race> {
        val allRaces = selectAllRaces(allCharacterClasses)
        selectAbilitiesOfRaces(allRaces, allAbilities)
        return allRaces
    }

    companion object {
        private const val SQL_GET_ID: String = SELECT + "id FROM " + TABLE_RACE + " WHERE rowid = ?"
        private const val SQL_WHERE_RACE_ID: String = "$COLUMN_RACE_ID = ?"
    }

    private fun selectAllRaces(allCharacterClasses: List<CharacterClass>): List<Race> {
        val allRaces: MutableList<Race> = ArrayList()
        val raceRowMapper: RowMapper = RaceRowMapper(allCharacterClasses)
        var queryResult: QueryResult? = null
        try {
            queryResult = db.rawQuery(SQL_GET_ALL_RACES, arrayOf())
            queryResult.moveToFirst()
            while (!queryResult.isAfterLast()) {
                val race = raceRowMapper.mapRow(queryResult.getDataRow()) as Race
                allRaces.add(race)
                queryResult.moveToNext()
            }
        } catch (sqlException: SQLException) {
//            Logger.error("Can't get all races", sqlException);
        } finally {
            queryResult?.close()
        }
        return allRaces
    }

    private fun selectAbilitiesOfRaces(allRaces: List<Race>, allAbilities: List<Ability>) {
        var queryResult: QueryResult? = null
        for (race in allRaces) {
            try {
                val params = arrayOf(race.id.toString())
                queryResult = db.rawQuery(SQL_GET_ABILITY_IDS_OF_RACE, params)
                val abilities = getAbilities(queryResult, allAbilities)
                race.abilities = abilities
            } catch (sqlException: SQLException) {
                //                Logger.error("Can't get ability ids of race", sqlException);
            } finally {
                queryResult?.close()
            }
        }
    }

    @Throws(SQLException::class)
    private fun getAbilities(queryResult: QueryResult, allAbilities: List<Ability>): List<Ability> {
        val abilities: MutableList<Ability> = ArrayList()
        queryResult.moveToFirst()
        while (!queryResult.isAfterLast()) {
            val ability = getAbility(queryResult.getDataRow().getInt(0), allAbilities)
            abilities.add(ability)
            queryResult.moveToNext()
        }
        return abilities
    }

    private fun getAbility(abilityId: Int, allAbilities: List<Ability>): Ability {
        for (ability in allAbilities) {
            if (ability.id == abilityId) {
                return ability
            }
        }
        throw IllegalArgumentException("Can't determine ability of $abilityId")
    }

    override fun createRace(race: Race): Race {
        insertRaceTable(race)
        insertRaceAbilityTable(race)
        return race
    }

    private fun insertRaceTable(race: Race) {
        val contentValues = getRaceContentValues(race)
        contentValues.putNull(COLUMN_ID)
        synchronized(Database.DB_LOCK) {
            val rowId = db.insertOrThrow(TABLE_RACE, contentValues)
            check(rowId != -1L) { "Can't insert race in race table" }
            race.id = db.queryId(SQL_GET_ID, rowId)
        }
    }

    private fun getRaceContentValues(race: Race): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, race.name)
        contentValues.put(COLUMN_SIZE_ID, race.size.ordinal)
        contentValues.put(COLUMN_BASE_LAND_SPEED, race.baseLandSpeed)
        contentValues.put(COLUMN_FAV_CLASS_ID, race.favoredCharacterClass.id)
        return contentValues
    }

    private fun insertRaceAbilityTable(race: Race) {
        synchronized(Database.DB_LOCK) {
            for (ability in race.abilities) {
                val contentValues = ContentValues()
                contentValues.put(COLUMN_RACE_ID, race.id)
                contentValues.put(COLUMN_ABILITY_ID, ability.id)
                val rowId = db.insertOrThrow(TABLE_RACE_ABILITY, contentValues)
                check(rowId != -1L) { "Can't insert ability in race ability table" }
            }
        }
    }

    override fun deleteRace(race: Race) {
        val raceId = arrayOf(race.id.toString())
        synchronized(Database.DB_LOCK) {
            db.delete(TABLE_RACE_ABILITY, "$COLUMN_RACE_ID = ?", raceId)
            db.delete(TABLE_RACE, "$COLUMN_ID = ?", raceId)
        }
    }

    override fun updateRace(race: Race) {
        updateRaceTable(race)
        updateRaceAbilityTable(race)
    }

    private fun updateRaceTable(race: Race) {
        val raceValues = getRaceContentValues(race)
        val bindVariables = arrayOf(race.id.toString())
        synchronized(Database.DB_LOCK) {
            val numberOfAffectedRows = db.update(TABLE_RACE, raceValues, SQL_WHERE_ID, bindVariables)
            check(numberOfAffectedRows == 1) { "Can't update race: $race" }
        }
    }

    private fun updateRaceAbilityTable(race: Race) {
        val raceId = arrayOf(race.id.toString())
        synchronized(Database.DB_LOCK) { db.delete(TABLE_RACE_ABILITY, SQL_WHERE_RACE_ID, raceId) }
        insertRaceAbilityTable(race)
    }


}