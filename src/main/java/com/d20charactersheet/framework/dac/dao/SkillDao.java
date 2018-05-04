package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Skill;

/**
 * Access to persisten skill data.
 */
public interface SkillDao {

  /**
   * Returns all available skills. Character dependent data is not set.
   *
   * @return All available skills.
   */
  public List<Skill> getAllSkills();

  /**
   * Create skill in persistent layer.
   *
   * @param skill
   *     The skill to create.
   *
   * @return The created skill (containing the id).
   */
  public Skill createSkill(Skill skill);

  /**
   * Updates the skill in the persistent layer.
   *
   * @param skill
   *     The skill to update.
   *
   * @return The updated skill.
   */
  public Skill updateSkill(Skill skill);

  /**
   * Delete the skill from the persisten layer.
   *
   * @param skill
   *     The skill to delete.
   */
  public void deleteSkill(Skill skill);

  /**
   * Returns the description of the skill with the given id.
   *
   * @param skillId
   *     The id of the skill.
   *
   * @return The description of the skill.
   */
  public String getSkillDescription(int skillId);

}
