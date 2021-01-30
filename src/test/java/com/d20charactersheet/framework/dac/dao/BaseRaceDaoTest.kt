package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.CharacterClass.AnyCharacterClass
import com.d20charactersheet.framework.boc.model.Race
import com.d20charactersheet.framework.boc.model.Size
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

abstract class BaseRaceDaoTest {

    protected lateinit var skillDao: SkillDao
    protected lateinit var characterClassDao: ClassDao
    protected lateinit var raceDao: RaceDao
    protected lateinit var abilityDao: AbilityDao
    protected lateinit var spelllistDao: SpelllistDao

    @Test
    fun testGetAllRaces() {

        // Act
        val allRaces = getAllRaces()

        // Assert
        assertThat(allRaces).hasSize(19)
    }

    private fun getAllRaces(): List<Race> {
        val allAbilities = abilityDao
            .getAllAbilities(
                spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                spelllistDao.getAllSpellsPerDayTables()
            )
        val allCharacterClasses = characterClassDao
            .getAllCharacterClasses(skillDao.getAllSkills(), allAbilities)
        return raceDao.getAllRaces(allCharacterClasses, allAbilities)
    }

    @Test
    fun testRaceHuman() {

        // Arrange
        val allAbilities = abilityDao
                .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                        spelllistDao.getAllSpellsPerDayTables())
        val characterClasses = characterClassDao.getAllCharacterClasses(skillDao.getAllSkills(), allAbilities)
        val races = raceDao.getAllRaces(characterClasses, allAbilities)

        // Act
        val human = races[0]

        // Assert
        assertThat(human).isNotNull
        assertThat(human.id).isEqualTo(0)
        assertThat(human.name).isEqualTo("Human")
    }

    @Test
    fun testCreateRace() {
        // Arrange
        val raceToCreate = createRace()

        // Act
        val createdRace = raceDao.createRace(raceToCreate)

        // Assert
        assertThat(createdRace).isNotNull
        assertThat(createdRace.id).isNotEqualTo(0)
        val persistedRace = getRaceFromService(createdRace.id)
        assertThat(persistedRace).isNotNull
        assertRace(persistedRace)

        // tear down
        raceDao.deleteRace(persistedRace)
    }

    private fun createRace(): Race {
        val race = Race()
        race.name = "testName"
        race.size = Size.MEDIUM
        race.baseLandSpeed = 30
        race.favoredCharacterClass = getBarbarian()
        race.abilities = createAbilities()
        return race
    }

    private fun createAbilities(): List<Ability> {
        val allAbilities = abilityDao
                .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                        spelllistDao.getAllSpellsPerDayTables())
        val abilities: MutableList<Ability> = ArrayList()
        for (i in 0..9) {
            abilities.add(allAbilities[i])
        }
        return abilities
    }

    private fun getRaceFromService(id: Int): Race {
        for (race in getAllRaces()) {
            if (race.id == id) {
                return race
            }
        }
        throw IllegalStateException("Can't retrieve race from RaceService")
    }

    private fun getBarbarian(): CharacterClass {
        val allAbilities = abilityDao
                .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                        spelllistDao.getAllSpellsPerDayTables())
        val allCharacterClasses = characterClassDao
                .getAllCharacterClasses(skillDao.getAllSkills(), allAbilities)
        return allCharacterClasses[0]
    }

    @Test
    fun testUpdateRace() {
        // Arrange
        val originalRace = getRaceById()
        val updateRace = createRace()

        // Act
        raceDao.updateRace(updateRace)

        // Assert
        val updatedRace = getRaceById()
        assertThat(updatedRace).isNotNull
        assertRace(updatedRace)

        // tear down
        raceDao.updateRace(originalRace)
    }

    private fun assertRace(race: Race) {
        assertThat(race.name).isEqualTo("testName")
        assertThat(race.size).isEqualTo(Size.MEDIUM)
        assertThat(race.baseLandSpeed).isEqualTo(30)
        assertThat(race.favoredCharacterClass).isEqualTo(getBarbarian())
        val abilities = race.abilities
        assertThat(abilities).isNotNull
        assertThat(abilities.size).isEqualTo(10)
    }

    private fun getRaceById(): Race {
        for (race in getAllRaces()) {
            if (race.id == 0) {
                fixSettingOfAnyCharacterClass(race)
                return race
            }
        }
        throw IllegalStateException("Can't get race by id " + 0)
    }

    private fun fixSettingOfAnyCharacterClass(race: Race) {
        if (race.favoredCharacterClass == null) {
            race.favoredCharacterClass = AnyCharacterClass.ANY_CHARACTER_CLASS
        }
    }
}