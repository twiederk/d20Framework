package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.*
import com.d20charactersheet.framework.dac.dao.sql.*
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.sql.Connection
import java.sql.DriverManager

class DnDv35DatabaseTest {

    @Test
    fun getAllCharacters_loadDataFromRealDatabase_dataLoaded() {

        // Arrange
        val connection: Connection = DriverManager.getConnection("jdbc:sqlite:./src/test/resources/db/dndv35_db_4_9_0")
        val jdbcDatabase = JdbcDatabase(connection)

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

        val gameSystem = GameSystemCacheImpl(1, "Dungeons & Dragons v.3.5")
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
        gameSystem.ruleService = DnDv35RuleServiceImpl()

        // Act
        val allCharacters = gameSystem.allCharacters

        // Assert
        assertThat(allCharacters).hasSize(14)
    }

}