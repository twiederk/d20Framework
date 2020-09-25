package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Alignment
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.Sex
import com.d20charactersheet.framework.dac.dao.BaseCharacterDaoTest
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SqlCharacterDaoTest : BaseCharacterDaoTest() {

    override fun setUp() {
        val jdbcHelper = JdbcHelper()

        jdbcHelper.executeSqlScript("/create_database.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_data.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_spell.sql")
        jdbcHelper.executeSqlScript("/dndv35_phb_character.sql")

        val jdbcDatabase = JdbcDatabase(jdbcHelper.connection)

        skillDao = SqlSkillDao(jdbcDatabase)
        characterDao = SqlCharacterDao(jdbcDatabase)
        characterClassDao = SqlClassDao(jdbcDatabase)
        raceDao = SqlRaceDao(jdbcDatabase)
        abilityDao = SqlAbilityDao(jdbcDatabase)
        spelllistDao = SqlSpelllistDao(jdbcDatabase)
        xpDao = SqlXpDao(jdbcDatabase)
        featDao = SqlFeatDao(jdbcDatabase)
        super.setUp()
    }

    @Test
    override fun testGetAllCharacters() {

        // Act
        val characters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables)

        // Assert
        assertThat(characters).hasSize(14)
    }

    @Test
    fun getCharacter_Belvador() {

        // Act
        val belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables)

        // Assert
        assertStats(belvador, 0, "Belvador the Summoner", 2, Alignment.CHAOTIC_GOOD, 13129)
        assertCharacterClassLevels(belvador, arrayOf(arrayOf("Wizard", 5)))
    }

    @Test
    fun getCharacter_Nascan() {

        // Act
        val nascan = characterDao.getCharacter(1, allCharacterClasses, allRaces, allXpTables)

        // Assert
        assertStats(nascan, 1, "Nascan Schwarzhaut", 0, Alignment.NEUTRAL, 24500)
        assertCharacterClassLevels(nascan, arrayOf(arrayOf("Ranger", 4), arrayOf("Rogue", 3)))
    }

    private fun assertStats(character: Character, id: Int, name: String, raceId: Int, alignment: Alignment, experiencePoints: Int) {
        assertThat(character).isNotNull
        assertThat(character.id).isEqualTo(id)
        assertThat(character.name).isEqualTo(name)
        assertThat(character.player).isEqualTo("Torsten")
        assertThat(character.race.id).isEqualTo(raceId)
        assertThat(character.sex).isEqualTo(Sex.MALE)
        assertThat(character.alignment).isEqualTo(alignment)
        assertThat(character.experiencePoints).isEqualTo(experiencePoints)
    }

    private fun assertCharacterClassLevels(character: Character, characterClassLevels: Array<Array<Any>>) {
        val classLevels = character.classLevels
        assertThat(classLevels).hasSize(characterClassLevels.size)
        for (i in characterClassLevels.indices) {
            val name = characterClassLevels[i][0] as String
            val level = characterClassLevels[i][1] as Int
            val classLevel = classLevels[i]
            assertThat(classLevel.characterClass.name).isEqualTo(name)
            assertThat(classLevel.level).isEqualTo(level)
        }
    }

}