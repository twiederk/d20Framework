package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

abstract class BaseAbilityDaoTest {

    protected lateinit var abilityDao: AbilityDao
    protected lateinit var spelllistDao: SpelllistDao

    @Test
    fun testGetAllAbilities() {

        // Act
        val allAbilities = abilityDao
                .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                        spelllistDao.getAllSpellsPerDayTables())

        // Assert
        assertThat(allAbilities).hasSize(302)
    }

    @Test
    fun testAbilityFastMovementBarbarian() {

        // Act
        val fastMovementBarbarianAbility = findAbilityById(ABILITY_ID_FAST_MOVEMENT_BARBARIAN)

        // Assert
        assertAbility(fastMovementBarbarianAbility)
    }

    private fun findAbilityById(abilityId: Int): Ability {
        val allAbilities = abilityDao
                .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                        spelllistDao.getAllSpellsPerDayTables())
        for (ability in allAbilities) {
            if (ability.id == abilityId) {
                return ability
            }
        }
        throw IllegalArgumentException("Can't get ability with id: $abilityId")
    }

    private fun assertAbility(ability: Ability) {
        assertThat(ability.id).isEqualTo(0)
        assertThat(ability.abilityType).isEqualTo(AbilityType.EXTRAORDINARY)
        assertThat(ability.name).isEqualTo("Fast Movement - Barbarian")
        assertThat(ability.description).isEqualTo(
                "A barbarian's land speed is faster than the norm for his race by +10 feet. This benefit applies only when he is wearing no armor, light armor, or medium armor and not carrying a heavy load. Apply this bonus before modifying the barbarian's speed because of any load carried or armor worn.")
    }

    @Test
    fun testCreateAbility() {

        // Arrange
        val numberOfAllAbilities = abilityDao
                .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                        spelllistDao.getAllSpellsPerDayTables()).size
        val ability = Ability()
        ability.name = "newAbilityName"
        ability.abilityType = AbilityType.SUPERNATURAL
        ability.description = "newAbilityDescription"

        // Act
        val createdAbility = abilityDao.createAbility(ability)

        // Assert
        assertThat(createdAbility).isNotNull
        assertThat(createdAbility.id).isGreaterThanOrEqualTo(0)
        assertThat(abilityDao.getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()),
                spelllistDao.getAllKnownSpellsTables(), spelllistDao.getAllSpellsPerDayTables()).size)
                .isEqualTo(numberOfAllAbilities + 1)

        // tear down
        abilityDao.deleteAbility(createdAbility)
    }

    @Test
    fun testExtraFeatAbility() {

        // Act
        val ability = findAbilityById(ABILITY_ID_EXTRA_FEAT)

        // Assert
        assertThat(ability).isInstanceOf(ExtraFeatsAbility::class.java)
        val extraFeatAbility = ability as ExtraFeatsAbility
        assertThat(extraFeatAbility.numberOfFeats).isEqualTo(1)
    }

    @Test
    fun testExtraSkillPointsAbility() {

        // Act
        val ability = findAbilityById(ABILITY_ID_EXTRA_SKILL_POINTS)

        // Assert
        assertThat(ability).isInstanceOf(ExtraSkillPointsAbility::class.java)
        val extraSkillPointsAbility = ability as ExtraSkillPointsAbility
        assertThat(extraSkillPointsAbility.skillPoints).isEqualTo(1)
    }

    @Test
    fun testSpelllistAbility() {

        // Act
        val ability = findAbilityById(ABILITY_ID_SPELLLIST_CLERIC)

        // Assert
        assertThat(ability).isInstanceOf(SpelllistAbility::class.java)
        val spelllistAbility = ability as SpelllistAbility
        val spelllist = spelllistAbility.spelllist
        assertThat(spelllist).isNotNull
        assertThat(spelllist.id).isEqualTo(1)
        assertThat(spelllist.name).isEqualTo("Cleric")
        assertThat(spelllist.numberOfSpellLevels).isEqualTo(10)
    }

    @Test
    fun testCreateSpelllistAbility() {
        // Arrange
        val allSpelllists = spelllistDao.getAllSpelllists(spelllistDao.getAllSpells())
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()
        val spelllist = allSpelllists[0]
        val knownSpellsTable = allKnownSpellsTables[0]
        val spellsPerDayTable = allSpellsPerDayTables[0]
        val spelllistAbility = SpelllistAbility()
        spelllistAbility.abilityType = AbilityType.SPELL_LIKE
        spelllistAbility.isAttributeBonusSpellSlots = true
        spelllistAbility.castingType = CastingType.PREPARED
        spelllistAbility.description = "testDescription"
        spelllistAbility.knownSpellsTable = knownSpellsTable
        spelllistAbility.name = "testName"
        spelllistAbility.schools = EnumSet.of(School.CONJURATION)
        spelllistAbility.spellAttribute = Attribute.CHARISMA
        spelllistAbility.spelllist = spelllist
        spelllistAbility.spellSource = SpellSource.ARCANE
        spelllistAbility.spellsPerDayTable = spellsPerDayTable

        // Act
        abilityDao.createAbility(spelllistAbility)

        // Assert
        assertThat(spelllistAbility.id).isGreaterThanOrEqualTo(0)
        val createdSpellistAbility = findAbilityById(spelllistAbility.id) as SpelllistAbility
        assertThat(createdSpellistAbility.abilityType).isEqualTo(AbilityType.SPELL_LIKE)
        assertThat(createdSpellistAbility.isAttributeBonusSpellSlots).isTrue
        assertThat(createdSpellistAbility.castingType).isEqualTo(CastingType.PREPARED)
        assertThat(createdSpellistAbility.description).isEqualTo("testDescription")
        assertThat(createdSpellistAbility.knownSpellsTable).isEqualTo(knownSpellsTable)
        assertThat(createdSpellistAbility.name).isEqualTo("testName")
        assertThat(createdSpellistAbility.schools).isEqualTo(EnumSet.of(School.CONJURATION))
        assertThat(createdSpellistAbility.spellAttribute).isEqualTo(Attribute.CHARISMA)
        assertThat(createdSpellistAbility.spelllist).isEqualTo(spelllist)
        assertThat(createdSpellistAbility.spellSource).isEqualTo(SpellSource.ARCANE)
        assertThat(createdSpellistAbility.spellsPerDayTable).isEqualTo(spellsPerDayTable)

        // tear down
        abilityDao.deleteAbility(createdSpellistAbility)
    }

    @Test
    fun testUpdateSpelllistAbility() {
        // Arrange
        val allSpelllists = spelllistDao.getAllSpelllists(spelllistDao.getAllSpells())
        val allKnownSpellsTables = spelllistDao.getAllKnownSpellsTables()
        val allSpellsPerDayTables = spelllistDao.getAllSpellsPerDayTables()
        val spelllist = allSpelllists[0]
        val knownSpellsTable = allKnownSpellsTables[0]
        val spellsPerDayTable = allSpellsPerDayTables[0]
        val spelllistAbility = findAbilityById(ABILITY_ID_SPELLLIST_CLERIC) as SpelllistAbility
        val backupSpelllistAbilty = copySpelllistAbility(spelllistAbility)
        spelllistAbility.abilityType = AbilityType.SUPERNATURAL
        spelllistAbility.isAttributeBonusSpellSlots = true
        spelllistAbility.castingType = CastingType.SPONTANEOUS
        spelllistAbility.description = "testDescription"
        spelllistAbility.knownSpellsTable = knownSpellsTable
        spelllistAbility.name = "testName"
        spelllistAbility.schools = EnumSet.of(School.CONJURATION)
        spelllistAbility.spellAttribute = Attribute.CHARISMA
        spelllistAbility.spelllist = spelllist
        spelllistAbility.spellSource = SpellSource.ARCANE
        spelllistAbility.spellsPerDayTable = spellsPerDayTable

        // Act
        abilityDao.updateAbility(spelllistAbility)

        // Assert
        val updatedSpellistAbility = findAbilityById(spelllistAbility.id) as SpelllistAbility
        assertThat(updatedSpellistAbility.abilityType).isEqualTo(AbilityType.SUPERNATURAL)
        assertThat(updatedSpellistAbility.isAttributeBonusSpellSlots).isTrue
        assertThat(updatedSpellistAbility.castingType).isEqualTo(CastingType.SPONTANEOUS)
        assertThat(updatedSpellistAbility.description).isEqualTo("testDescription")
        assertThat(updatedSpellistAbility.knownSpellsTable).isEqualTo(knownSpellsTable)
        assertThat(updatedSpellistAbility.name).isEqualTo("testName")
        assertThat(updatedSpellistAbility.schools).isEqualTo(EnumSet.of(School.CONJURATION))
        assertThat(updatedSpellistAbility.spellAttribute).isEqualTo(Attribute.CHARISMA)
        assertThat(updatedSpellistAbility.spelllist).isEqualTo(spelllist)
        assertThat(updatedSpellistAbility.spellSource).isEqualTo(SpellSource.ARCANE)
        assertThat(updatedSpellistAbility.spellsPerDayTable).isEqualTo(spellsPerDayTable)

        // tear down
        abilityDao.updateAbility(backupSpelllistAbilty)
    }

    private fun copySpelllistAbility(spelllistAbility: SpelllistAbility): SpelllistAbility {
        val copySpelllistAbility = SpelllistAbility()
        copySpelllistAbility.id = spelllistAbility.id
        copySpelllistAbility.abilityType = spelllistAbility.abilityType
        copySpelllistAbility.isAttributeBonusSpellSlots = spelllistAbility.isAttributeBonusSpellSlots
        copySpelllistAbility.castingType = spelllistAbility.castingType
        copySpelllistAbility.description = spelllistAbility.description
        copySpelllistAbility.knownSpellsTable = spelllistAbility.knownSpellsTable
        copySpelllistAbility.name = spelllistAbility.name
        copySpelllistAbility.schools = spelllistAbility.schools
        copySpelllistAbility.spellAttribute = spelllistAbility.spellAttribute
        copySpelllistAbility.spelllist = spelllistAbility.spelllist
        copySpelllistAbility.spellSource = spelllistAbility.spellSource
        copySpelllistAbility.spellsPerDayTable = spelllistAbility.spellsPerDayTable
        return copySpelllistAbility
    }

    companion object {
        private const val ABILITY_ID_FAST_MOVEMENT_BARBARIAN = 0
        private const val ABILITY_ID_SPELLLIST_CLERIC = 23
        private const val ABILITY_ID_EXTRA_FEAT = 224
        private const val ABILITY_ID_EXTRA_SKILL_POINTS = 225
    }
}