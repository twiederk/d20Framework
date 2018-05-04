package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Skill;

/**
 * Provides methods to administer skills.
 */
public interface SkillService {

  /**
   * Returns all skills. Only character independent data is set.
   *
   * @return All skills.
   */
  public List<Skill> getAllSkills();

  /**
   * Creates a skill from the given parameters.
   *
   * @param skill
   *     The skill to create.
   *
   * @return The created skill with a valid id.
   */
  public Skill createSkill(Skill skill);

  /**
   * Updates the given skill.
   *
   * @param skill
   *     The skill to update.
   */
  public void updateSkill(Skill skill);

  /**
   * Delete the skill.
   *
   * @param skill
   *     The skill to delete.
   */
  public void deleteSkill(Skill skill);

  /**
   * Returns the skill with the given id out of the given list of skills.
   *
   * @param skillId
   *     The id of the skill to return.
   * @param allSkills
   *     The list of skills to search through.
   *
   * @return The skill with the given id out of the given list of skills.
   */
  public Skill getSkillById(int skillId, List<Skill> allSkills);

  /**
   * Adds the description to the skill if it is empty.
   *
   * @param skill
   *     The skill to add the description.
   *
   * @return The skill with description.
   */
  public Skill getSkillDescription(Skill skill);

}
