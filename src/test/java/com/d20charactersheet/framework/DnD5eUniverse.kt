package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.*
import com.d20charactersheet.framework.dac.dao.sql.*
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper


class DnD5eUniverse : Universe {

    override val gameSystem: GameSystem

    init {
        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/sql/create_database.sql")
        jdbcHelper.executeSqlScript("/sql/dnd5e_phb_data.sql")
        jdbcHelper.executeSqlScript("/sql/dnd5e_phb_character.sql")
        jdbcHelper.executeSqlScript("/sql/dnd5e_phb_spell.sql")

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
        gameSystem.characterCreatorService = CharacterCreatorServiceImpl()
        gameSystem.featService = FeatServiceImpl(SqlFeatDao(jdbcDatabase))
        gameSystem.itemService = ItemServiceImpl(SqlItemDao(jdbcDatabase))
        gameSystem.xpService = XpServiceImpl(SqlXpDao(jdbcDatabase))
        gameSystem.characterService = CharacterServiceImpl(SqlCharacterDao(jdbcDatabase))
        gameSystem.ruleService = DnD5eRuleServiceImpl()
    }


}