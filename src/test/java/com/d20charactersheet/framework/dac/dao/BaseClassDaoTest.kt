package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

abstract class BaseClassDaoTest {

    protected lateinit var classDao: ClassDao
    protected lateinit var skillDao: SkillDao
    protected lateinit var abilityDao: AbilityDao
    protected lateinit var spelllistDao: SpelllistDao
    protected lateinit var allCharacterClasses: List<CharacterClass>

    @Test
    fun testAllCharacterClasses() {

        // Assert
        assertThat(allCharacterClasses).hasSize(27)
    }

    @Test
    fun testBarbarianClass() {

        // Act
        val barbarian = allCharacterClasses[0]

        // Assert
        assertClass(barbarian, 0, "Barbarian", BaseAttackBonus.GOOD, Save.FORTITUDE, getAlignmentsOfBarbarian(), 4)
    }

    @Test
    fun testWizardClass() {

        // Act
        val wizard = allCharacterClasses[10]

        // Assert
        assertClass(wizard, 10, "Wizard", BaseAttackBonus.POOR, Save.WILL, EnumSet.allOf(Alignment::class.java), 2)
    }

    private fun assertClass(characterClass: CharacterClass, id: Int, name: String,
                            baseAttackBonus: BaseAttackBonus, save: Save, alignments: EnumSet<Alignment>, skillPointsPerLevel: Int) {
        assertThat(characterClass.id).isEqualTo(id)
        assertThat(characterClass.name).isEqualTo(name)
        assertThat(characterClass.baseAttackBonus).isEqualTo(baseAttackBonus)
        assertSaves(characterClass, save)
        assertThat(characterClass.alignments).isEqualTo(alignments)
        assertThat(characterClass.skillPointsPerLevel).isEqualTo(skillPointsPerLevel)
        assertThat(characterClass.skills).isNotNull
    }

    private fun assertSaves(characterClass: CharacterClass, save: Save) {
        val saves = characterClass.saves
        assertThat(saves).hasSize(1)
        assertThat(saves).containsExactly(save)
    }

    private fun getAlignmentsOfBarbarian(): EnumSet<Alignment> {
        val excludeAlignments = EnumSet.of(Alignment.LAWFUL_EVIL, Alignment.LAWFUL_NEUTRAL, Alignment.LAWFUL_GOOD)
        return EnumSet.complementOf(excludeAlignments)
    }

    @Test
    fun testSkillsOfFighterClass() {
        // Act
        val fighter = allCharacterClasses[4]

        // Assert
        assertSkills(fighter, arrayOf("Climb", "Craft", "Handle Animal", "Intimidate", "Jump", "Ride", "Swim"))
    }

    @Test
    fun testSkillsOSorcererClass() {
        // Act
        val sorcerer = allCharacterClasses[9]

        // Assert
        assertSkills(sorcerer, arrayOf("Bluff", "Concentration", "Craft", "Knowledge (arcana)", "Profession", "Spellcraft"))
    }

    private fun assertSkills(characterClass: CharacterClass, skillNames: Array<String>) {
        val skills = characterClass.skills
        assertThat(skills).hasSize(skillNames.size)
        for (i in skillNames.indices) {
            assertThat(skills[i].name).isEqualTo(skillNames[i])
        }
    }

    @Test
    fun testAbilitiesOfCharacterClasses() {
        // Arrange
        val barbarian = allCharacterClasses[0]

        // Act
        val classAbilities = barbarian.classAbilities

        // Assert
        assertThat(classAbilities).hasSize(11)
        val fastMovementBarbarian = classAbilities[0]
        assertThat(fastMovementBarbarian.ability.name).isEqualTo("Fast Movement - Barbarian")
        assertThat(fastMovementBarbarian.level).isEqualTo(1)
    }

    @Test
    fun testSelectionBoxesOfFighter() {

        // act
        val starterPackBoxsWithQueries: Map<StarterPackBox, List<StarterPackQuery>> = classDao.getStarterPackBoxesWithQueries(4)

        // assert
        assertThat(starterPackBoxsWithQueries).isNotNull
        assertThat(starterPackBoxsWithQueries).hasSize(5)
        assertThat(starterPackBoxsWithQueries.keys).containsExactly(
            StarterPackBox(1, "Armor"),
            StarterPackBox(2, "Primary Hand"),
            StarterPackBox(3, "Secondary Hand"),
            StarterPackBox(4, "Ranged Weapon"),
            StarterPackBox(5, "Equipment Pack")
        )
        assertThat(starterPackBoxsWithQueries[StarterPackBox(1, "Armor")]).hasSize(4)
        val chainMailQuery = starterPackBoxsWithQueries[StarterPackBox(1, "Armor")]!![0]
        assertThat(chainMailQuery.id).isEqualTo(1)
        assertThat(chainMailQuery.optionId).isEqualTo(1)
        assertThat(chainMailQuery.equipmentType).isEqualTo(EquipmentType.ARMOR)
        assertThat(chainMailQuery.typeId).isEqualTo(-1)
        assertThat(chainMailQuery.combatId).isEqualTo(-1)
        assertThat(chainMailQuery.itemId).isEqualTo(6)
        assertThat(chainMailQuery.quantity).isEqualTo(1)

        assertThat(starterPackBoxsWithQueries[StarterPackBox(2, "Primary Hand")]).hasSize(1)
        val martialWeaponQuery = starterPackBoxsWithQueries[StarterPackBox(2, "Primary Hand")]!![0]
        assertThat(martialWeaponQuery.id).isEqualTo(5)
        assertThat(martialWeaponQuery.optionId).isEqualTo(1)
        assertThat(martialWeaponQuery.equipmentType).isEqualTo(EquipmentType.WEAPON)
        assertThat(martialWeaponQuery.typeId).isEqualTo(1)
        assertThat(martialWeaponQuery.combatId).isEqualTo(-1)
        assertThat(martialWeaponQuery.itemId).isEqualTo(-1)
        assertThat(martialWeaponQuery.quantity).isEqualTo(1)

    }

}