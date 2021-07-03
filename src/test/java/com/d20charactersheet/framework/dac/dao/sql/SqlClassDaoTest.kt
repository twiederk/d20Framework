package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseClassDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Before

class SqlClassDaoTest : BaseClassDaoTest() {
    @Before
    fun setUp() {

        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/sql/create_database.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        skillDao = SqlSkillDao(jdbcDatabase)
        abilityDao = SqlAbilityDao(jdbcDatabase)
        classDao = SqlClassDao(jdbcDatabase)
        spelllistDao = SqlSpelllistDao(jdbcDatabase)

        val allSpelllists = spelllistDao.getAllSpelllists(spelllistDao.getAllSpells())
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()
        allCharacterClasses = classDao.getAllCharacterClasses(
            skillDao.getAllSkills(),
            abilityDao.getAllAbilities(allSpelllists, allKnownSpellsTables, allSpellsPerDayTables)
        )
    }

}