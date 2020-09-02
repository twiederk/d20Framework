package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.*
import com.d20charactersheet.framework.dac.dao.sql.*
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper


class DnD5eUniverse : AbstractUniverse() {

    init {
        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dnd5e_phb_data.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        val skillDao = SqlSkillDao(jdbcDatabase)
        val spelllistDao = SqlSpelllistDao(jdbcDatabase)
        val abilityDao = SqlAbilityDao(jdbcDatabase)
        val classDao = SqlClassDao(jdbcDatabase)
        val raceDao = SqlRaceDao(jdbcDatabase)

        gameSystem = GameSystemCacheImpl(3, "Dungeons & Dragons 5e")
        gameSystem.skillService = SkillServiceImpl(skillDao)
        gameSystem.spelllistService = SpelllistServiceImpl(spelllistDao)
        gameSystem.abilityService = AbilityServiceImpl(abilityDao)
        gameSystem.characterClassService = CharacterClassServiceImpl(classDao)
        gameSystem.raceService = RaceServiceImpl(raceDao)
    }


}