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
        val starterPackBoxes: List<StarterPackBox> = classDao.getSelectionBoxes(4)

        // assert
        assertThat(starterPackBoxes).isNotNull
        assertThat(starterPackBoxes).hasSize(5)
        assertThat(starterPackBoxes[0].name).isEqualTo("Armor")
        assertThat(starterPackBoxes[1].name).isEqualTo("Primary Hand")
        assertThat(starterPackBoxes[2].name).isEqualTo("Secondary Hand")
        assertThat(starterPackBoxes[3].name).isEqualTo("Ranged Weapon")
        assertThat(starterPackBoxes[4].name).isEqualTo("Equipment Pack")

        assertThat(starterPackBoxes[0].options[0].getTitle()).isEqualTo("Chain mail")
        assertThat(starterPackBoxes[0].options[1].getTitle()).isEqualTo("Leather, Longbow, Arrow (20)")

    }

}