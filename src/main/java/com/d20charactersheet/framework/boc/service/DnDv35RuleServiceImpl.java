package com.d20charactersheet.framework.boc.service;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Size;
import com.d20charactersheet.framework.boc.model.Skill;

/**
 * The RuleService implementation of Dungeons & Dragons v.3.5. It contains the rules for DnDv35.
 */
public class DnDv35RuleServiceImpl extends AbstractRuleServiceImpl {

  @Override
  protected int getNumberOfClassFeats(final @NotNull Character character) {
    return 1 + character.getCharacterLevel() / 3;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getMaxClassSkillRank(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getMaxClassSkillRank(final @NotNull Character character) {
    return character.getCharacterLevel() + 3;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getMaxCrossClassSkillRank(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public float getMaxCrossClassSkillRank(final @NotNull Character character) {
    return getMaxClassSkillRank(character) / 2.0f;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSkillModifier(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.CharacterSkill)
   */
  @Override
  public int getSkillModifier(final @NotNull Character character, final @NotNull CharacterSkill characterSkill) {
    final int attributeModifier = getAttributeModifier(character, characterSkill.getSkill().getAttribute());
    return attributeModifier + (int) Math.floor(characterSkill.getRank()) + characterSkill.getModifier();
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
      if (isClassSkill(character, characterSkill.getSkill())) {
        spentSkillPoints += characterSkill.getRank();
      } else {
        spentSkillPoints += characterSkill.getRank() * 2;
      }
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
      if (characterClass.equals(startClass)) {
        skillPoints += (skillPointsPerLevel * 4) + (skillPointsPerLevel * (level - 1));
      } else {
        skillPoints += skillPointsPerLevel * level;
      }
    }
    return skillPoints;
  }

  @Override
  public float getRankPerSkillPoint(final @NotNull Character character, final @NotNull Skill skill) {
    if (isClassSkill(character, skill)) {
      return 1.0f;
    }
    return 0.5f;
  }

  @Override
  public int calculateProficiencyBonus(final @NotNull Character character) {
    return 0;
  }

  @Override
  public int getSpecialSizeModifier(final @NotNull Size size) {
    switch (size) {
      case FINE:
        return -16;
      case DIMINUTIVE:
        return -12;
      case TINY:
        return -8;
      case SMALL:
        return -4;
      case MEDIUM:
        return 0;
      case LARGE_LONG:
      case LARGE_TALL:
        return 4;
      case HUGE_LONG:
      case HUGE_TALL:
        return 8;
      case GARGANTUAN_LONG:
      case GARGANTUAN_TALL:
        return 12;
      case COLOSSAL_LONG:
      case COLOSSAL_TALL:
        return 16;
      default:
        throw new IllegalArgumentException("Can't determine special size modifier of size: " + size);
    }
  }

}
