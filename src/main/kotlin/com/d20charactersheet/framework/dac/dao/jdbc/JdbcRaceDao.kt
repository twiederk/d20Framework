package com.d20charactersheet.framework.dac.dao.jdbc

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Race
import com.d20charactersheet.framework.dac.dao.RaceDao
import com.d20charactersheet.framework.dac.dao.RowMapper
import com.d20charactersheet.framework.dac.dao.TableAndColumnNames
import com.d20charactersheet.framework.dac.dao.jdbc.rowmapper.RaceRowMapper
import java.sql.Connection
import java.sql.ResultSet


class JdbcRaceDao(private val connection: Connection) : RaceDao {

    override fun deleteRace(race: Race?) {
        TODO("Not yet implemented")
    }

    override fun getAllRaces(allCharacterClasses: MutableList<CharacterClass>, allAbilities: MutableList<Ability>): MutableList<Race> {
        val allRaces: MutableList<Race> = selectAllRaces(allCharacterClasses)
        selectAbilitiesOfRaces(allRaces, allAbilities)
        return allRaces
    }

    private fun selectAllRaces(allCharacterClasses: List<CharacterClass>): MutableList<Race> {
        val allRaces: MutableList<Race> = ArrayList()
        val raceRowMapper: RowMapper = RaceRowMapper(allCharacterClasses)
        connection.prepareStatement(TableAndColumnNames.SQL_GET_ALL_RACES).use {
            val resultSet: ResultSet = it.executeQuery()
            while (resultSet.next()) {
                val race = raceRowMapper.mapRow(JdbcDataRow(resultSet)) as Race
                allRaces.add(race)
            }
        }
        return allRaces
    }

    private fun selectAbilitiesOfRaces(allRaces: List<Race>, allAbilities: List<Ability>) {
        for (race in allRaces) {
            connection.prepareStatement(TableAndColumnNames.SQL_GET_ABILITY_IDS_OF_RACE).use {
                it.setInt(1, race.id)
                val resultSet = it.executeQuery()
                val abilities = getAbilities(resultSet, allAbilities)
                race.abilities = abilities
            }
        }
    }

    private fun getAbilities(resultSet: ResultSet, allAbilities: List<Ability>): List<Ability> {
        val abilities: MutableList<Ability> = ArrayList()
        while (resultSet.next()) {
            val ability = getAbility(resultSet.getInt(1), allAbilities)
            abilities.add(ability)
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


    override fun createRace(race: Race?): Race {
        TODO("Not yet implemented")
    }

    override fun updateRace(race: Race?) {
        TODO("Not yet implemented")
    }

}
