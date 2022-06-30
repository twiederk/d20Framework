package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.model.Attribute
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eSkillTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getSkill_athletics_returnAthletics() {

        // act
        val skill = gameSystem.skillService.getSkillById(1, gameSystem.allSkills)

        // assert
        assertThat(skill.name).isEqualTo("Athletics")
        assertThat(skill.attribute).isEqualTo(Attribute.STRENGTH)
        assertThat(skill.isUntrained).isFalse
        assertThat(skill.description).isNull()

    }

    @Test
    fun getSkillDescription_athletics_returnDescription() {
        // arrange
        val skill = gameSystem.skillService.getSkillById(1, gameSystem.allSkills)

        // act
        gameSystem.skillService.getSkillDescription(skill)

        // assert
        assertThat(skill.description).isEqualTo("Your Strength (Athletics) check covers difficult situations you encounter while climbing, jumping, or swimming. Examples include the following activities:<br/>* You attempt to climb a sheer or slippery cliff, avoid hazards while scaling a wall, or cling to a surface while something is trying to knock you off.<br/>* You try to jump an unusually long distance or pull off a stunt midjump.<br/>* You struggle to swim or stay afloat in treacherous currents, storm-tossed waves, or areas of thick seaweed. Or another creature tries to push or pull you underwater or otherwise interfere with your swimming.")
    }

}