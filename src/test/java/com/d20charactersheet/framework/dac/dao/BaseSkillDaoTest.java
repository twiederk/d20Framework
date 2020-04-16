package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    final List<Skill> allSkills = skillDao.getAllSkills();
    assertEquals(44, allSkills.size());
    final Skill skill = getSkill(allSkills, SKILL_ID_CLIMB);
    assertNotNull(skill);
    assertEquals(skill.getId(), SKILL_ID_CLIMB);
    assertEquals("Climb", skill.getName());
    assertTrue(skill.getDescription()
                   .startsWith("<b>Check: </b> With a successful Climb check"));
    assertEquals(Attribute.STRENGTH, skill.getAttribute());
    assertTrue(skill.isUntrained());
  }

  @Test
  public void testGetCharacterSkills() {
    final Character belvador = new Character();
    belvador.setId(0);

    final List<CharacterSkill> characterSkills = characterDao.getCharacterSkills(belvador, skillDao.getAllSkills());
    assertNotNull(characterSkills);
    assertEquals(10, characterSkills.size());
  }

  protected Skill getSkill(final List<Skill> allSkills, final int skillId) {
    for (final Skill skill : allSkills) {
      if (skill.getId() == skillId) {
        return skill;
      }
    }
    return null;
  }

  @Test
  public void testUpdateSkill() {
    final String nameTest = "testName";
    final String descriptionTest = "descriptionTest";
    final Attribute attributeTest = Attribute.STRENGTH;
    final boolean untrainedTest = false;

    final Skill skill = skillDao.getAllSkills()
        .get(0);
    final String nameOrginal = skill.getName();
    final String descriptionOrginal = skill.getDescription();
    final Attribute attributeOrginal = skill.getAttribute();
    final boolean untrainedOrginal = skill.isUntrained();

    skill.setName(nameTest);
    skill.setDescription(descriptionTest);
    skill.setAttribute(attributeTest);
    skill.setUntrained(untrainedTest);

    final Skill updatedSkill = skillDao.updateSkill(skill);

    assertNotNull(updatedSkill);
    assertEquals(nameTest, updatedSkill.getName());
    assertEquals(descriptionTest, updatedSkill.getDescription());
    assertEquals(attributeTest, updatedSkill.getAttribute());
    assertEquals(untrainedTest, updatedSkill.isUntrained());

    // clean up
    skill.setName(nameOrginal);
    skill.setDescription(descriptionOrginal);
    skill.setAttribute(attributeOrginal);
    skill.setUntrained(untrainedOrginal);

    skillDao.updateSkill(skill);
  }

  @Test
  public void testCreateSkill() {
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

    assertNotNull(skill);
    assertTrue(skill.getId() >= 0);
    assertEquals(nameTest, skill.getName());
    assertEquals(descriptionTest, skill.getDescription());
    assertEquals(attributeTest, skill.getAttribute());
    assertEquals(untrainedTest, skill.isUntrained());

    // clean up
    skillDao.deleteSkill(skill);
  }

  @Test
  public void testDeleteSkill() {
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

    // test
    skillDao.deleteSkill(skill);

    assertEquals(numberOfSkills - 1, skillDao.getAllSkills().size());
  }

}
