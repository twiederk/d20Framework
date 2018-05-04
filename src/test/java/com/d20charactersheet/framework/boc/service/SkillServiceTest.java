package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SkillStorage.SKILL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.dummy.DummySkillDao;

public class SkillServiceTest {

  private SkillService skillService;

  @Before
  public void setUp() throws Exception {
    skillService = new SkillServiceImpl(new DummySkillDao(SKILL));
  }

  @Test
  public void testGetAllSkills() {
    final List<Skill> allSkills = skillService.getAllSkills();
    assertEquals(44, allSkills.size());
  }

  @Test
  public void testGetSkillDescription() throws Exception {
    Skill skill = new Skill();
    skill.setId(1);
    skill.setName("Appraise");
    skill = skillService.getSkillDescription(skill);
    assertNotNull(skill.getDescription());
    assertTrue(skill.getDescription().startsWith("<b>Check:</b> You can appraise common"));
  }

}
