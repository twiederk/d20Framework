package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseClassDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Before

class SqlClassDaoTest : BaseClassDaoTest() {
    @Before
    fun setUp() {

        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        skillDao = SqlSkillDao(jdbcDatabase)
        abilityDao = SqlAbilityDao(jdbcDatabase)
        characterClassDao = SqlClassDao(jdbcDatabase)
        spelllistDao = SqlSpelllistDao(jdbcDatabase)

        val allSpelllists = spelllistDao.getAllSpelllists(spelllistDao.allSpells)
        val allKnownSpellsTables = spelllistDao.allKnownSpellsTables
        val allSpellsPerDayTables = spelllistDao.allSpellsPerDayTables
        allCharacterClasses = characterClassDao.getAllCharacterClasses(skillDao.allSkills,
                abilityDao.getAllAbilities(allSpelllists, allKnownSpellsTables, allSpellsPerDayTables))
    }

}