package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.SkillDao;

/**
 * Implementation of the SkillService.
 */
public class SkillServiceImpl implements SkillService {

  private final SkillDao skillDao;

  /**
   * Create skill service with data access.
   *
   * @param skillDao
   *     The data access.
   */
  public SkillServiceImpl(final SkillDao skillDao) {
    this.skillDao = skillDao;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.SkillService#getAllSkills()
   */
  @Override
  public List<Skill> getAllSkills() {
    return skillDao.getAllSkills();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.SkillService#createSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public Skill createSkill(final Skill skill) {
    skillDao.createSkill(skill);
    return skill;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.SkillService#updateSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public void updateSkill(final Skill skill) {
    skillDao.updateSkill(skill);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.SkillService#deleteSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public void deleteSkill(final Skill skill) {
    skillDao.deleteSkill(skill);
  }

  @Override
  public Skill getSkillById(final int skillId, final List<Skill> allSkills) {
    for (final Skill skill : allSkills) {
      if (skill.getId() == skillId) {
        return skill;
      }
    }
    throw new IllegalArgumentException("Can't find skill with id: " + skillId);
  }

  @Override
  public Skill getSkillDescription(final Skill skill) {
    if (skill.getDescription() == null) {
      final String description = skillDao.getSkillDescription(skill.getId());
      skill.setDescription(description);
    }
    return skill;
  }

}
