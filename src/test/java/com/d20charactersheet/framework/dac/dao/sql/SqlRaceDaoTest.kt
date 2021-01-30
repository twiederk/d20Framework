package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseRaceDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Before

class SqlRaceDaoTest : BaseRaceDaoTest() {

    @Before
    fun setUp() {

        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/sql/create_database.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        characterClassDao = SqlClassDao(jdbcDatabase)
        skillDao = SqlSkillDao(jdbcDatabase)
        raceDao = SqlRaceDao(jdbcDatabase)
        abilityDao = SqlAbilityDao(jdbcDatabase)
        spelllistDao = SqlSpelllistDao(jdbcDatabase)
    }


}