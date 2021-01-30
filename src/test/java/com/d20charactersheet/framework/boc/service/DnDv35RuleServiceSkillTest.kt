package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.util.*

class DnDv35RuleServiceSkillTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetMaxClassSkillRankSingleClassCharacter() {
        val character = createCharacter(wizard, 5)
        val maxClassSkillRank = ruleService.getMaxClassSkillRank(character)
        Assert.assertEquals(8, maxClassSkillRank.toLong())
    }

    @Test
    fun testGetMaxClassSkillRankMultiClassCharacter() {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(wizard, 5))
        classLevels.add(ClassLevel(bard, 5))
        classLevels.add(ClassLevel(barbarian, 5))
        character.classLevels = classLevels
        val maxClassSkillRank = ruleService.getMaxClassSkillRank(character)
        Assert.assertEquals(18, maxClassSkillRank.toLong())
    }

    @Test
    fun testGetMaxCrossClassSkillRankSingleClassCharacter() {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(wizard, 4))
        character.classLevels = classLevels
        val maxCrossClassSkillRank = ruleService.getMaxCrossClassSkillRank(character)
        Assert.assertEquals(3.5f, maxCrossClassSkillRank, 0.0f)
    }

    @Test
    fun testGetMaxCrossClassSkillRankMultiClassCharacter() {
        val character = Character()
        val classLevels: MutableList<ClassLevel> = ArrayList()
        classLevels.add(ClassLevel(wizard, 5))
        classLevels.add(ClassLevel(bard, 5))
        classLevels.add(ClassLevel(barbarian, 5))
        character.classLevels = classLevels
        val maxCrossClassSkillRank = ruleService.getMaxCrossClassSkillRank(character)
        Assert.assertEquals(9.0f, maxCrossClassSkillRank, 0.0f)
    }

    @Test
    fun testIsSkillTrained() {
        var characterSkill = createCharacterSkill(0.0f, false)
        Assert.assertFalse(ruleService.isTrained(characterSkill))
        characterSkill = createCharacterSkill(1.0f, false)
        Assert.assertTrue(ruleService.isTrained(characterSkill))
        characterSkill = createCharacterSkill(0.0f, true)
        Assert.assertTrue(ruleService.isTrained(characterSkill))
        characterSkill = createCharacterSkill(1.0f, true)
        Assert.assertTrue(ruleService.isTrained(characterSkill))
    }

    private fun createCharacterSkill(rank: Float, untrained: Boolean): CharacterSkill {
        val skill = Skill()
        skill.isUntrained = untrained
        val characterSkill = CharacterSkill(skill)
        characterSkill.rank = rank
        return characterSkill
    }

    @Test
    fun testGetSkillPointsWizard5ElfInt10() {
        // Wizard (5), Elf, INT 10
        val classLevel = ClassLevel(wizard, 5)
        val character = createCharacter(classLevel, elf, 10)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(16, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsWizard5ElfInt18() {
        // Wizard (5), Elf, INT 18
        val character = createCharacter(ClassLevel(wizard, 5), elf, 18)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(48, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsWizard5HumanInt18() {
        // Wizard (5), Human, INT 18
        val character = createCharacter(ClassLevel(wizard, 5), human, 18)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(56, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsBarbarian4HalfOrcInt9() {
        // Barbarian (4), Half-Orc, INT 9
        val character = createCharacter(ClassLevel(barbarian, 4), halfOrc, 9)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(21, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsBarbarian4HumanInt9() {
        // Barbarian (4), Half-Orc, INT 9
        val character = createCharacter(ClassLevel(barbarian, 4), human, 9)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(28, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsBard4HumanInt16() {
        // Bard (4), Human, INT 16
        val character = createCharacter(ClassLevel(bard, 4), human, 16)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(70, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsBard5HumanInt16() {
        // Bard (5), Human, INT 16
        val character = createCharacter(ClassLevel(bard, 5), human, 16)
        val skillPoints = ruleService.getSkillPoints(
            character, character.classLevels[0]
                .characterClass
        )
        Assert.assertEquals(80, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsRanger4Rogue3HumanInt10() {
        // Ranger (4), Rogue (3), Human, INT 10
        val character = createCharacter(ClassLevel(ranger, 4), ClassLevel(rogue, 3), human, 10)
        val skillPoints = ruleService.getSkillPoints(character, ranger)
        Assert.assertEquals(76, skillPoints.toLong())
    }

    @Test
    fun testGetSkillPointsRanger4Druid6HumanInt10() {
        // Ranger (4), Druid (6), Human, INT 10
        val character = createCharacter(ClassLevel(ranger, 4), ClassLevel(druid, 6), human, 10)
        val skillPoints = ruleService.getSkillPoints(character, ranger)
        Assert.assertEquals(79, skillPoints.toLong())
    }

    @Test
    fun testGetSkillModifier() {
        val character = Character()
        character.strength = 14
        val characterSkill = createCharacterSkill(3f)
        val skillModifier = ruleService.getSkillModifier(character, characterSkill)
        Assert.assertEquals(7, skillModifier.toLong())
    }

    @Test
    fun testGetSkillModifierWithHalfRank() {
        val character = Character()
        character.strength = 14
        val characterSkill = createCharacterSkill(3.5f)
        val skillModifier = ruleService.getSkillModifier(character, characterSkill)
        Assert.assertEquals(7, skillModifier.toLong())
    }

    @Test
    fun testSkillRoll() {
        val character = Character()
        character.strength = 14
        val characterSkill = createCharacterSkill(3.5f)
        val skillRoll = ruleService.rollSkill(character, characterSkill)
        Assert.assertTrue(skillRoll.result > 7)
        Assert.assertTrue(skillRoll.result < 28)
    }

    private fun createCharacterSkill(rank: Float): CharacterSkill {
        val skill = Skill()
        skill.attribute = Attribute.STRENGTH
        val characterSkill = CharacterSkill(skill)
        characterSkill.rank = rank
        characterSkill.modifier = 2
        return characterSkill
    }

    @Test
    fun testIsClassSkillSingleClassCharacter() {
        val wizardCharacter = createCharacter(ClassLevel(wizard, 5), elf, 10)
        val fighterCharacter = createCharacter(ClassLevel(fighter, 5), human, 10)
        val spellcraft = createSkill(39, "Spellcraft")
        var classSkill = ruleService.isClassSkill(wizardCharacter, spellcraft)
        Assert.assertTrue(classSkill)
        classSkill = ruleService.isClassSkill(fighterCharacter, spellcraft)
        Assert.assertFalse(classSkill)
    }

    @Test
    fun testIsClassSkillMultiClassCharacter() {
        val character = createCharacter(ClassLevel(fighter, 1), ClassLevel(wizard, 1), human, 10)
        val spellcraft = createSkill(39, "Spellcraft")
        val appraise = createSkill(1, "Appraise")
        var classSkill = ruleService.isClassSkill(character, spellcraft)
        Assert.assertTrue(classSkill)
        classSkill = ruleService.isClassSkill(character, appraise)
        Assert.assertFalse(classSkill)
    }

    @Test
    fun testGetSpentSkillPointsClassSkills() {
        val character = createCharacter(ClassLevel(fighter, 1), human, 10)
        val characterSkills: MutableList<CharacterSkill> = LinkedList()
        characterSkills.add(
            createCharacterSkill(
                fighter.skills[0], 4.0f
            )
        )
        characterSkills.add(
            createCharacterSkill(
                fighter.skills[1], 4.0f
            )
        )
        character.characterSkills = characterSkills
        val spentSkillPoints = ruleService.getSpentSkillPoints(character)
        Assert.assertEquals(8, spentSkillPoints.toLong())
    }

    @Test
    fun testGetSpentSkillPointsCrossClassSkills() {
        val character = createCharacter(ClassLevel(fighter, 1), human, 10)
        val characterSkills: MutableList<CharacterSkill> = LinkedList()
        characterSkills.add(createCharacterSkill(Skill(), 2.5f))
        characterSkills.add(createCharacterSkill(Skill(), 4.0f))
        character.characterSkills = characterSkills
        val spentSkillPoints = ruleService.getSpentSkillPoints(character)
        Assert.assertEquals(13, spentSkillPoints.toLong())
    }

    @Test
    fun testGetSpentSkillPointsMultiClassCharacter() {
        val character = createCharacter(ClassLevel(fighter, 1), ClassLevel(wizard, 1), human, 10)
        val characterSkills: MutableList<CharacterSkill> = LinkedList()
        characterSkills.add(
            createCharacterSkill(
                fighter.skills[0], 4.0f
            )
        )
        characterSkills.add(
            createCharacterSkill(
                fighter.skills[1], 4.0f
            )
        )
        characterSkills.add(
            createCharacterSkill(
                wizard.skills[0], 4.0f
            )
        )
        characterSkills.add(
            createCharacterSkill(
                wizard.skills[1], 4.0f
            )
        )
        characterSkills.add(createCharacterSkill(Skill(), 2.0f))
        characterSkills.add(createCharacterSkill(Skill(), 2.0f))
        character.characterSkills = characterSkills
        val spentSkillPoints = ruleService.getSpentSkillPoints(character)
        Assert.assertEquals(24, spentSkillPoints.toLong())
    }

    private fun createCharacterSkill(skill: Skill, rank: Float): CharacterSkill {
        val characterSkill = CharacterSkill(skill)
        characterSkill.rank = rank
        return characterSkill
    }
}