package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseCharacterDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper

class SqlCharacterDaoTest : BaseCharacterDaoTest() {

    override fun setUp() {
        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        skillDao = SqlSkillDao(jdbcDatabase)
        characterDao = SqlCharacterDao(jdbcDatabase)
        characterClassDao = SqlClassDao(jdbcDatabase)
        raceDao = SqlRaceDao(jdbcDatabase)
        abilityDao = SqlAbilityDao(jdbcDatabase)
        spelllistDao = SqlSpelllistDao(jdbcDatabase)
        xpDao = SqlXpDao(jdbcDatabase)
        featDao = SqlFeatDao(jdbcDatabase)
        super.setUp()
    }
}