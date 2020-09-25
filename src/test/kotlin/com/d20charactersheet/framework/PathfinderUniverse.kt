package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.*
import com.d20charactersheet.framework.dac.dao.sql.*
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper

class PathfinderUniverse : Universe {

    override val gameSystem: GameSystem

    init {

        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/pathfinder_crb_data.sql")
        jdbcHelper.executeSqlScript("/pathfinder_crb_spell.sql")
        jdbcHelper.executeSqlScript("/pathfinder_crb_character.sql")
        jdbcHelper.executeSqlScript("/pathfinder_apg_data.sql")
        jdbcHelper.executeSqlScript("/pathfinder_apg_spell.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        val skillService: SkillService = SkillServiceImpl(SqlSkillDao(jdbcDatabase))
        val featService: FeatService = FeatServiceImpl(SqlFeatDao(jdbcDatabase))
        val characterClassService: CharacterClassService = CharacterClassServiceImpl(SqlClassDao(jdbcDatabase))
        val raceService: RaceService = RaceServiceImpl(SqlRaceDao(jdbcDatabase))
        val abilityService: AbilityService = AbilityServiceImpl(SqlAbilityDao(jdbcDatabase))
        val itemService: ItemService = ItemServiceImpl(SqlItemDao(jdbcDatabase))
        val characterService: CharacterService = CharacterServiceImpl(SqlCharacterDao(jdbcDatabase))
        val spelllistService: SpelllistService = SpelllistServiceImpl(SqlSpelllistDao(jdbcDatabase))
        val xpService: XpService = XpServiceImpl(SqlXpDao(jdbcDatabase))
        val exportImportService: ExportImportService = ExportImportServiceImpl()

        gameSystem = GameSystemCacheImpl(2, "Pathfinder")
        gameSystem.skillService = skillService
        gameSystem.featService = featService
        gameSystem.characterClassService = characterClassService
        gameSystem.itemService = itemService
        gameSystem.raceService = raceService
        gameSystem.abilityService = abilityService
        gameSystem.characterService = characterService
        gameSystem.spelllistService = spelllistService
        gameSystem.xpService = xpService
        gameSystem.exportImportService = exportImportService
        gameSystem.bodyService = BodyService()
        gameSystem.ruleService = PathfinderRuleServiceImpl()
    }

}