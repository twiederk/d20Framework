package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.*
import com.d20charactersheet.framework.dac.dao.jdbc.*


class DnD5eUniverse : AbstractUniverse() {

    init {
        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dnd5e_phb_data.sql")

        val skillDao = JdbcSkillDao(jdbcHelper.connection)
        val spelllistDao = JdbcSpelllistDao(jdbcHelper.connection)
        val abilityDao = JdbcAbilityDao(jdbcHelper.connection)
        val classDao = JdbcClassDao(jdbcHelper.connection)
        val raceDao = JdbcRaceDao(jdbcHelper.connection)

        gameSystem = GameSystemCacheImpl(3, "Dungeons & Dragons 5e")
        gameSystem.skillService = SkillServiceImpl(skillDao)
        gameSystem.spelllistService = SpelllistServiceImpl(spelllistDao)
        gameSystem.abilityService = AbilityServiceImpl(abilityDao)
        gameSystem.characterClassService = CharacterClassServiceImpl(classDao)
        gameSystem.raceService = RaceServiceImpl(raceDao)
    }


}