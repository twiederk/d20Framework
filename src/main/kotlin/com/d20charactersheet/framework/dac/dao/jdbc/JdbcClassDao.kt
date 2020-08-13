package com.d20charactersheet.framework.dac.dao.jdbc

import com.d20charactersheet.framework.boc.model.Ability
import com.d20charactersheet.framework.boc.model.CharacterClass
import com.d20charactersheet.framework.boc.model.Skill
import com.d20charactersheet.framework.dac.dao.ClassDao
import java.sql.Connection

class JdbcClassDao(connection: Connection) : ClassDao {
    override fun updateCharacterClass(characterClass: CharacterClass?) {
        TODO("Not yet implemented")
    }

    override fun createCharacterClass(characterClass: CharacterClass?): CharacterClass {
        TODO("Not yet implemented")
    }

    override fun deleteSkill(skill: Skill?) {
        TODO("Not yet implemented")
    }

    override fun addSkill(skill: Skill?, characterClasses: MutableList<CharacterClass>?) {
        TODO("Not yet implemented")
    }

    override fun getAllCharacterClasses(allSkills: MutableList<Skill>?, allAbilities: MutableList<Ability>?): MutableList<CharacterClass> {
        return mutableListOf()
    }

}
