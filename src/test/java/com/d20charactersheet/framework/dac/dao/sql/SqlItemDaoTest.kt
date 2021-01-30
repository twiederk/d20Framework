package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.dac.dao.BaseItemDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.junit.Before

class SqlItemDaoTest : BaseItemDaoTest() {

    @Before
    fun setUp() {
        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/sql/create_database.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/sql/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        itemDao = SqlItemDao(jdbcDatabase)
        characterDao = SqlCharacterDao(jdbcDatabase)
    }
}