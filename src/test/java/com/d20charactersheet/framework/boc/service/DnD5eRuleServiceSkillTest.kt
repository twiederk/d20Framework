package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.Character
import com.d20charactersheet.framework.boc.model.CharacterSkill
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceSkillTest {

    private lateinit var belvador: Character

    private lateinit var ruleService: RuleService

    @BeforeEach
    fun before() {
        val gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        belvador = gameSystem.allCharacters[0]
    }

    @Test
    fun should_always_return_zero_for_max_class_skill_rank() {

        // act
        val maxClassSkillRank = ruleService.getMaxClassSkillRank(belvador)

        // assert
        assertThat(maxClassSkillRank).isZero
    }

    @Test
    fun should_always_return_zero_for_max_cross_class_skill_rank() {

        // act
        val maxClassSkillRank = ruleService.getMaxCrossClassSkillRank(belvador)

        // assert
        assertThat(maxClassSkillRank).isZero
    }

    @Test
    fun should_always_return_zero_for_skill_points() {

        // act
        val maxClassSkillRank = ruleService.getSkillPoints(belvador, belvador.classLevels[0].characterClass)

        // assert
        assertThat(maxClassSkillRank).isZero
    }

    @Test
    fun should_always_return_zero_for_spend_skill_points() {

        // act
        val maxClassSkillRank = ruleService.getSpentSkillPoints(belvador)

        // assert
        assertThat(maxClassSkillRank).isZero
    }

    @Test
    fun should_return_skill_bonus_for_skill_without_misc_modifier_and_proficiency() {

        // arrange
        val religion = getCharacterSkillByName("Religion", belvador.characterSkills)

        // act
        val skillModifier = ruleService.getSkillModifier(belvador, religion)

        // assert
        // Int: 18 => +4
        // Misc Modifier: 0
        // Proficiency: -
        assertThat(skillModifier).isEqualTo(4)
    }

    @Test
    fun should_return_skill_bonus_for_skill_with_misc_modifier_but_withoud_proficiency() {

        // arrange
        val medicine = getCharacterSkillByName("Medicine", belvador.characterSkills)

        // act
        val skillModifier = ruleService.getSkillModifier(belvador, medicine)

        // assert
        // Wis: 11 => +0
        // Misc Modifier: +2
        // Proficiency: -
        assertThat(skillModifier).isEqualTo(2)
    }

    @Test
    fun should_return_skill_bonus_for_skill_without_misc_modifier_but_with_proficiency() {

        // arrange
        val arcana = getCharacterSkillByName("Arcana", belvador.characterSkills)

        // act
        val skillModifier = ruleService.getSkillModifier(belvador, arcana)

        // assert
        // Int: 18 => +4
        // Misc Modifier: 0
        // Proficiency: +3
        assertThat(skillModifier).isEqualTo(7)
    }

    @Test
    fun should_return_false_when_rank_is_zero() {
        // arrange
        val religion = getCharacterSkillByName("Religion", belvador.characterSkills)

        // act
        val trained = ruleService.isTrained(religion)

        // assert
        assertThat(trained).isFalse
    }

    @Test
    fun should_return_true_when_rank_is_one() {
        // arrange
        val arcana = getCharacterSkillByName("Arcana", belvador.characterSkills)

        // act
        val trained = ruleService.isTrained(arcana)

        // assert
        assertThat(trained).isTrue
    }

    private fun getCharacterSkillByName(name: String, characterSkills: List<CharacterSkill>): CharacterSkill {
        for (characterSkill in characterSkills) {
            if (characterSkill.skill.name == name) {
                return characterSkill
            }
        }
        throw java.lang.IllegalArgumentException("Can't find character skill with name [$name]")
    }

}