package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseFeatDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Before

class SqlFeatDaoTest : BaseFeatDaoTest() {

    @Before
    fun setUp() {

        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        featDao = SqlFeatDao(jdbcDatabase)
        characterDao = SqlCharacterDao(jdbcDatabase)
    }
}