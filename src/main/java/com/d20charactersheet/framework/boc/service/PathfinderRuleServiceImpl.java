package com.d20charactersheet.framework.boc.service;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Size;
import com.d20charactersheet.framework.boc.model.Skill;

/**
 * RuleService implementation of Pathfinder game system. Implemnts rules of Pathfinder.
 */
public class PathfinderRuleServiceImpl extends AbstractRuleServiceImpl {

  @Override
  protected int getNumberOfClassFeats(final @NotNull Character character) {
    return (character.getCharacterLevel() + 1) / 2;
  }

  @Override
  public int getMaxClassSkillRank(final @NotNull Character character) {
    return character.getCharacterLevel();
  }

  @Override
  public float getMaxCrossClassSkillRank(final @NotNull Character character) {
    return character.getCharacterLevel();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSkillModifier(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.CharacterSkill)
   */
  @Override
  public int getSkillModifier(final @NotNull Character character, final @NotNull CharacterSkill characterSkill) {
    final int attributeModifier = getAttributeModifier(character, characterSkill.getSkill().getAttribute());
    final int skillBoost = getSkillBoost(character, characterSkill);
    return attributeModifier + skillBoost + (int) characterSkill.getRank() + characterSkill.getModifier();
  }

  int getSkillBoost(final @NotNull Character character, final @NotNull CharacterSkill characterSkill) {
    if (isClassSkill(character, characterSkill.getSkill()) && characterSkill.getRank() > 0) {
      return 3;
    }
    return 0;
  }

  /**
   * The skill points are calculated in an optimal distribution. If a skill is a class skill of one of the classes of
   * the character each rank costs 1 skill point. Otherwise 2 skill points are spent per rank.
   *
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSpentSkillPoints(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getSpentSkillPoints(final @NotNull Character character) {
    int spentSkillPoints = 0;

    for (final @NotNull CharacterSkill characterSkill : character.getCharacterSkills()) {
      spentSkillPoints += characterSkill.getRank();
    }
    return spentSkillPoints;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSkillPoints(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.CharacterClass)
   */
  @Override
  public int getSkillPoints(final @NotNull Character character, final @NotNull CharacterClass startClass) {
    final int intelligenceBonus = getModifier(character.getIntelligence());
    final int abilityBonus = getAbilityBonus(character);
    int skillPoints = 0;
    for (final ClassLevel classLevel : character.getClassLevels()) {
      final @NotNull
      CharacterClass characterClass = classLevel.getCharacterClass();
      final int level = classLevel.getLevel();
      final int classSkillPoints = characterClass.getSkillPointsPerLevel();
      final int skillPointsPerLevel = Math.max(1, classSkillPoints + intelligenceBonus) + abilityBonus;
      skillPoints += skillPointsPerLevel * level;
    }
    return skillPoints;
  }

  @Override
  public float getRankPerSkillPoint(final @NotNull Character character, @NotNull final Skill skill) {
    return 1.0f;
  }

  @Override
  public int calculateProficiencyBonus(final @NotNull Character character) {
    return 0;
  }

  @Override
  public int getSpecialSizeModifier(final @NotNull Size size) {
    switch (size) {
      case FINE:
        return -8;
      case DIMINUTIVE:
        return -4;
      case TINY:
        return -2;
      case SMALL:
        return -1;
      case MEDIUM:
        return 0;
      case LARGE_LONG:
      case LARGE_TALL:
        return 1;
      case HUGE_LONG:
      case HUGE_TALL:
        return 2;
      case GARGANTUAN_LONG:
      case GARGANTUAN_TALL:
        return 4;
      case COLOSSAL_LONG:
      case COLOSSAL_TALL:
        return 8;
      default:
        throw new IllegalArgumentException("Can't determine special size modifier of size: " + size);
    }
  }

}
