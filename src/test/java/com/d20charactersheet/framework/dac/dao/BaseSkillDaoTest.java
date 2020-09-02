package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.Skill;

public abstract class BaseSkillDaoTest {

  protected static final int SKILL_ID_CLIMB = 4;
  protected SkillDao skillDao;
  protected CharacterDao characterDao;

  @Test
  public void testGetAllSkills() {

    // Act
    final List<Skill> allSkills = skillDao.getAllSkills();

    // Assert
    assertThat(allSkills).hasSize(44);
    final Skill skill = getSkill(allSkills);
    assertThat(skill).isNotNull();
    assertThat(skill.getId()).isEqualTo(SKILL_ID_CLIMB);
    assertThat(skill.getName()).isEqualTo("Climb");
    assertThat(skill.getDescription()).isNull();
    assertThat(skill.getAttribute()).isEqualTo(Attribute.STRENGTH);
    assertThat(skill.isUntrained()).isTrue();
  }

  @Test
  public void testGetCharacterSkills() {
    // Arrange
    final Character belvador = new Character();
    belvador.setId(0);

    // Act
    final List<CharacterSkill> characterSkills = characterDao.getCharacterSkills(belvador, skillDao.getAllSkills());

    // Assert
    assertThat(characterSkills).isNotNull();
    assertThat(characterSkills.size()).isEqualTo(10);
  }

  protected Skill getSkill(final List<Skill> allSkills) {
    for (final Skill skill : allSkills) {
      if (skill.getId() == BaseSkillDaoTest.SKILL_ID_CLIMB) {
        return skill;
      }
    }
    return null;
  }

  @Test
  public void testUpdateSkill() {
    // Arrange
    final String nameTest = "testName";
    final String descriptionTest = "descriptionTest";
    final Attribute attributeTest = Attribute.STRENGTH;
    final boolean untrainedTest = false;

    final Skill skill = skillDao.getAllSkills().get(0);
    final String nameOrginal = skill.getName();
    final String descriptionOrginal = skillDao.getSkillDescription(skill.getId());
    final Attribute attributeOrginal = skill.getAttribute();
    final boolean untrainedOrginal = skill.isUntrained();

    skill.setName(nameTest);
    skill.setDescription(descriptionTest);
    skill.setAttribute(attributeTest);
    skill.setUntrained(untrainedTest);

    // Act
    final Skill updatedSkill = skillDao.updateSkill(skill);

    // Assert
    assertThat(updatedSkill).isNotNull();
    assertThat(updatedSkill.getName()).isEqualTo(nameTest);
    assertThat(updatedSkill.getDescription()).isEqualTo(descriptionTest);
    assertThat(updatedSkill.getAttribute()).isEqualTo(attributeTest);
    assertThat(updatedSkill.isUntrained()).isEqualTo(untrainedTest);

    // clean up
    skill.setName(nameOrginal);
    skill.setDescription(descriptionOrginal);
    skill.setAttribute(attributeOrginal);
    skill.setUntrained(untrainedOrginal);

    skillDao.updateSkill(skill);
  }

  @Test
  public void testCreateSkill() {
    // Arrange
    final String nameTest = "testName";
    final String descriptionTest = "descriptionTest";
    final Attribute attributeTest = Attribute.STRENGTH;
    final boolean untrainedTest = false;

    final Skill newSkill = new Skill();
    newSkill.setName(nameTest);
    newSkill.setDescription(descriptionTest);
    newSkill.setAttribute(attributeTest);
    newSkill.setUntrained(untrainedTest);

    // Act
    final Skill skill = skillDao.createSkill(newSkill);

    // Assert
    assertThat(skill).isNotNull();
    assertThat(skill.getId()).isGreaterThanOrEqualTo(0);
    assertThat(skill.getName()).isEqualTo(nameTest);
    assertThat(skill.getDescription()).isEqualTo(descriptionTest);
    assertThat(skill.getAttribute()).isEqualTo(attributeTest);
    assertThat(skill.isUntrained()).isEqualTo(untrainedTest);

    // clean up
    skillDao.deleteSkill(skill);
  }

  @Test
  public void testDeleteSkill() {
    // Arrange
    final String nameTest = "testName";
    final String descriptionTest = "descriptionTest";
    final Attribute attributeTest = Attribute.STRENGTH;
    final boolean untrainedTest = false;

    final Skill newSkill = new Skill();
    newSkill.setName(nameTest);
    newSkill.setDescription(descriptionTest);
    newSkill.setAttribute(attributeTest);
    newSkill.setUntrained(untrainedTest);

    final Skill skill = skillDao.createSkill(newSkill);
    final int numberOfSkills = skillDao.getAllSkills().size();

    // Act
    skillDao.deleteSkill(skill);

    // Assert
    assertThat(skillDao.getAllSkills()).hasSize(numberOfSkills - 1);
  }

  @Test
  public void testGetSkillDescription() {

    // Act
    String description = skillDao.getSkillDescription(BaseSkillDaoTest.SKILL_ID_CLIMB);

    // Assert
    assertThat(description).startsWith("<b>Check: </b> With a successful Climb check,");
  }

}
