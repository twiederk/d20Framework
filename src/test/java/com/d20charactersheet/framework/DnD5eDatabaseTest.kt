package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.Save
import com.d20charactersheet.framework.boc.service.*
import com.d20charactersheet.framework.dac.dao.sql.*
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

class DnD5eDatabaseTest {

    @Test
    fun updateDatabase() {

        // arrange
        val src = Paths.get("./src/test/resources/db/dnd5e_db_4_8_0")
        val dest = Paths.get("./src/test/resources/db/dnd5e_db_4_8_0_to_update")
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING)

        val connection: Connection = DriverManager.getConnection("jdbc:sqlite:./src/test/resources/db/dnd5e_db_4_8_0_to_update")
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

        val gameSystem = GameSystemCacheImpl(1, "DnD 5e")
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
        gameSystem.ruleService = DnD5eRuleServiceImpl()

        val jdbcHelper = JdbcHelper("jdbc:sqlite:./src/test/resources/db/dnd5e_db_4_8_0_to_update")

        // act
        jdbcHelper.executeSqlScript("/db/dnd5e_upgrade_78_to_79.sql")

        // assert
        val testCharacter = gameSystem.allCharacters[0]
        assertThat(testCharacter.name).isEqualTo("Belvador the Summoner")
        assertThat(testCharacter.classLevels[0].characterClass.saves).isEqualTo(EnumSet.of(Save.INTELLIGENCE, Save.WISDOM))

        // tear down
        jdbcHelper.connection.close()
        connection.close()
        Files.delete(dest)
    }

}