package com.d20charactersheet.framework.dac.dao.jdbc

import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.SkillDao
import java.sql.Connection

class JdbcSkillDao(connection: Connection) : SkillDao {

    override fun deleteSkill(skill: Skill?) {
        TODO("Not yet implemented")
    }

    override fun getSkillDescription(skillId: Int): String {
        TODO("Not yet implemented")
    }

    override fun updateSkill(skill: Skill?): Skill {
        TODO("Not yet implemented")
    }

    override fun getAllSkills(): MutableList<Skill> {
        return mutableListOf()
    }

    override fun createSkill(skill: Skill?): Skill {
        TODO("Not yet implemented")
    }

}
