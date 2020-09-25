package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.sql.SqlSkillDao;
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase;
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper;

public class SkillServiceTest {

  private SkillService skillService;

  @Before
  public void setUp() {
    JdbcHelper jdbcHelper = new JdbcHelper();

    jdbcHelper.executeSqlScript("/create_database.sql");
    jdbcHelper.executeSqlScript("/dndv35_phb_data.sql");
    jdbcHelper.executeSqlScript("/dndv35_phb_spell.sql");
    jdbcHelper.executeSqlScript("/dndv35_phb_character.sql");

    JdbcDatabase jdbcDatabase = new JdbcDatabase(jdbcHelper.getConnection());

    skillService = new SkillServiceImpl(new SqlSkillDao(jdbcDatabase));
  }

  @Test
  public void testGetAllSkills() {
    final List<Skill> allSkills = skillService.getAllSkills();
    assertEquals(44, allSkills.size());
  }

  @Test
  public void testGetSkillDescription() {
    Skill skill = new Skill();
    skill.setId(1);
    skill.setName("Appraise");
    skill = skillService.getSkillDescription(skill);
    assertNotNull(skill.getDescription());
    assertTrue(skill.getDescription()
                   .startsWith("<b>Check:</b> You can appraise common"));
  }

}
