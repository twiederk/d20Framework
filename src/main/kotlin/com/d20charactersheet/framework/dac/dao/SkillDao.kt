package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Skill

/**
 * Access to persisten skill data.
 */
interface SkillDao {
    /**
     * Returns all available skills. Character dependent data is not set.
     *
     * @return All available skills.
     */
    fun getAllSkills(): List<Skill>

    /**
     * Create skill in persistent layer.
     *
     * @param skill
     * The skill to create.
     *
     * @return The created skill (containing the id).
     */
    fun createSkill(skill: Skill): Skill

    /**
     * Updates the skill in the persistent layer.
     *
     * @param skill
     * The skill to update.
     *
     * @return The updated skill.
     */
    fun updateSkill(skill: Skill): Skill

    /**
     * Delete the skill from the persisten layer.
     *
     * @param skill
     * The skill to delete.
     */
    fun deleteSkill(skill: Skill)

    /**
     * Returns the description of the skill with the given id.
     *
     * @param skillId
     * The id of the skill.
     *
     * @return The description of the skill.
     */
    fun getSkillDescription(skillId: Int): String
}