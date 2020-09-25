package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.Skill
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

abstract class BaseSkillDaoTest {

    protected lateinit var skillDao: SkillDao
    protected lateinit var characterDao: CharacterDao

    @Test
    fun testGetAllSkills() {

        // Act
        val allSkills = skillDao.getAllSkills()

        // Assert
        assertThat(allSkills).hasSize(44)
        val skill = getSkill(allSkills)
        assertThat(skill).isNotNull
        assertThat(skill.id).isEqualTo(SKILL_ID_CLIMB)
        assertThat(skill.name).isEqualTo("Climb")
        assertThat(skill.description).isNull()
        assertThat(skill.attribute).isEqualTo(Attribute.STRENGTH)
        assertThat(skill.isUntrained).isTrue
    }

    @Test
    fun testGetCharacterSkills() {
        // Arrange
        val belvador = Character()
        belvador.id = 0

        // Act
        val characterSkills = characterDao.getCharacterSkills(belvador, skillDao.getAllSkills())

        // Assert
        assertThat(characterSkills).isNotNull
        assertThat(characterSkills.size).isEqualTo(10)
    }

    private fun getSkill(allSkills: List<Skill>): Skill {
        for (skill in allSkills) {
            if (skill.id == SKILL_ID_CLIMB) {
                return skill
            }
        }
        throw IllegalStateException("Can't find climb skill")
    }

    @Test
    fun testUpdateSkill() {
        // Arrange
        val nameTest = "testName"
        val descriptionTest = "descriptionTest"
        val attributeTest = Attribute.STRENGTH
        val untrainedTest = false
        val skill = skillDao.getAllSkills()[0]
        val nameOrginal = skill.name
        val descriptionOrginal = skillDao.getSkillDescription(skill.id)
        val attributeOrginal = skill.attribute
        val untrainedOrginal = skill.isUntrained
        skill.name = nameTest
        skill.description = descriptionTest
        skill.attribute = attributeTest
        skill.isUntrained = untrainedTest

        // Act
        val updatedSkill = skillDao.updateSkill(skill)

        // Assert
        assertThat(updatedSkill).isNotNull
        assertThat(updatedSkill.name).isEqualTo(nameTest)
        assertThat(updatedSkill.description).isEqualTo(descriptionTest)
        assertThat(updatedSkill.attribute).isEqualTo(attributeTest)
        assertThat(updatedSkill.isUntrained).isEqualTo(untrainedTest)

        // clean up
        skill.name = nameOrginal
        skill.description = descriptionOrginal
        skill.attribute = attributeOrginal
        skill.isUntrained = untrainedOrginal
        skillDao.updateSkill(skill)
    }

    @Test
    fun testCreateSkill() {
        // Arrange
        val nameTest = "testName"
        val descriptionTest = "descriptionTest"
        val attributeTest = Attribute.STRENGTH
        val untrainedTest = false
        val newSkill = Skill()
        newSkill.name = nameTest
        newSkill.description = descriptionTest
        newSkill.attribute = attributeTest
        newSkill.isUntrained = untrainedTest

        // Act
        val skill = skillDao.createSkill(newSkill)

        // Assert
        assertThat(skill).isNotNull
        assertThat(skill.id).isGreaterThanOrEqualTo(0)
        assertThat(skill.name).isEqualTo(nameTest)
        assertThat(skill.description).isEqualTo(descriptionTest)
        assertThat(skill.attribute).isEqualTo(attributeTest)
        assertThat(skill.isUntrained).isEqualTo(untrainedTest)

        // clean up
        skillDao.deleteSkill(skill)
    }

    @Test
    fun testDeleteSkill() {
        // Arrange
        val nameTest = "testName"
        val descriptionTest = "descriptionTest"
        val attributeTest = Attribute.STRENGTH
        val untrainedTest = false
        val newSkill = Skill()
        newSkill.name = nameTest
        newSkill.description = descriptionTest
        newSkill.attribute = attributeTest
        newSkill.isUntrained = untrainedTest
        val skill = skillDao.createSkill(newSkill)
        val numberOfSkills = skillDao.getAllSkills().size

        // Act
        skillDao.deleteSkill(skill)

        // Assert
        assertThat(skillDao.getAllSkills()).hasSize(numberOfSkills - 1)
    }

    @Test
    fun testGetSkillDescription() {

        // Act
        val description = skillDao.getSkillDescription(SKILL_ID_CLIMB)

        // Assert
        assertThat(description).startsWith("<b>Check: </b> With a successful Climb check,")
    }

    companion object {
        protected const val SKILL_ID_CLIMB = 4
    }
}