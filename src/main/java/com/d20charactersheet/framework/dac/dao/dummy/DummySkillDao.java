package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.LinkedList;
import java.util.List;

import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.SkillDao;

/**
 * Dummy implementatioin of SkillDao. Creates a in memory data model to simulate the persistent data.
 */
public class DummySkillDao implements SkillDao {

  private final DataTable skillTable;

  /**
   * Creates list of all available skills. Creates skills of characters.
   *
   * @param skill
   *     Skill raw data.
   */
  public DummySkillDao(final Object[][] skill) {
    skillTable = new DataTable(skill);
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.SkillDao#getAllSkills()
   */
  @Override
  public List<Skill> getAllSkills() {
    final List<Skill> allSkills = new LinkedList<Skill>();
    for (final DataRow dataRow : skillTable) {
      final Skill skill = selectSkill(dataRow);
      allSkills.add(skill);
    }
    return allSkills;
  }

  private Skill selectSkill(final DataRow dataRow) {
    // id, name, attribute, description, untrained
    final Skill skill = new Skill();
    skill.setId(dataRow.getId());
    skill.setName((String) dataRow.get(1));
    skill.setAttribute(getAttribute((Integer) dataRow.get(2)));
    skill.setUntrained(getUntrained((Integer) dataRow.get(3)));
    skill.setDescription((String) dataRow.get(4));
    return skill;
  }

  private Attribute getAttribute(final int attributeId) {
    for (final Attribute attribute : Attribute.values()) {
      if (attribute.ordinal() == attributeId) {
        return attribute;
      }
    }
    throw new IllegalArgumentException("Can't determine attribute with id: " + attributeId);
  }

  private boolean getUntrained(final int untainedId) {
    if (untainedId == 0) {
      return false;
    } else if (untainedId == 1) {
      return true;
    }
    throw new IllegalArgumentException("Can't determine untrained of: " + untainedId);
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.SkillDao#createSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public Skill createSkill(final Skill skill) {
    skill.setId(skillTable.getNewId());
    insertSkill(skill);
    return skill;
  }

  private void insertSkill(final Skill skill) {
    // id, name, attribute, description, untrained
    skillTable.insert(
        new Object[] {skill.getId(), skill.getName(), skill.getAttribute().ordinal(), setUntrained(skill.isUntrained()),
            skill.getDescription(),
        });
  }

  private int setUntrained(final boolean untrained) {
    if (untrained) {
      return 1;
    }
    return 0;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.SkillDao#updateSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public Skill updateSkill(final Skill skill) {
    skillTable.delete(skill.getId());
    insertSkill(skill);
    return skill;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.SkillDao#deleteSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public void deleteSkill(final Skill skill) {
    skillTable.delete(skill.getId());
  }

  @Override
  public String getSkillDescription(final int skillId) {
    final List<DataRow> dataRows = skillTable.select(0, skillId);
    if (dataRows.size() != 1) {
      throw new IllegalArgumentException("Can't find skill with id: " + skillId);
    }
    final String description = dataRows.get(0).getString(4);
    return description;
  }

}
