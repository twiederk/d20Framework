package com.d20charactersheet.framework.dac.dao.dummy;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.BaseAttackBonus;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.dac.dao.ClassDao;

/**
 * In memory DAO of the character classes.
 */
public class DummyClassDao implements ClassDao {

  private final DataTable characterClassTable;
  private final DataTable characterClassSkillTable;
  private final DataTable characterClassAbilityTable;

  /**
   * Creates the in memory character class database. The tables are already filled the the data of the D&D 3.5 base
   * and prestige classes.
   *
   * @param clazz
   *     Class raw data.
   * @param classSkill
   *     Skill raw data.
   * @param classAbility
   *     Ability raw data.
   */
  public DummyClassDao(final Object[][] clazz, final Object[][] classSkill, final Object[][] classAbility) {
    characterClassTable = new DataTable(clazz);
    characterClassSkillTable = new DataTable(classSkill);
    characterClassAbilityTable = new DataTable(classAbility);
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.ClassDao#getAllCharacterClasses(List, List)
   */
  @Override
  public List<CharacterClass> getAllCharacterClasses(final List<Skill> allSkills, final List<Ability> allAbilities) {
    return selectAllCharacterClasses(allSkills, allAbilities);
  }

  private List<CharacterClass> selectAllCharacterClasses(final List<Skill> allSkills, final List<Ability> allAbilities) {
    final List<CharacterClass> allCharacterClasses = new ArrayList<CharacterClass>();
    for (final DataRow characterClassRow : characterClassTable) {
      final CharacterClass characterClass = selectCharacterClass(characterClassRow, allSkills, allAbilities);
      allCharacterClasses.add(characterClass);
    }
    return allCharacterClasses;
  }

  private CharacterClass selectCharacterClass(final DataRow characterClassRow, final List<Skill> allSkills,
      final List<Ability> allAbilities) {
    // Id, Name, Saves, Alignments, base attack bonus, skill points per level, hit die id
    final CharacterClass characterClass = new CharacterClass();
    characterClass.setId(characterClassRow.getId());
    characterClass.setName((String) characterClassRow.get(1));
    final EnumSet<Save> saves = getEnums(characterClassRow.getInt(2), Save.class);
    characterClass.setSaves(saves);
    final EnumSet<Alignment> alignments = getEnums(characterClassRow.getInt(3), Alignment.class);
    characterClass.setAlignments(alignments);
    characterClass.setBaseAttackBonus(getBaseAttackBonus(characterClassRow.getInt(4)));
    characterClass.setSkillPointsPerLevel(characterClassRow.getInt(5));
    characterClass.setSkills(getSkills(characterClassRow.getId(), allSkills));
    characterClass.setHitDie(getHitDie(characterClassRow.getInt(6)));
    characterClass.setClassAbilities(getAbilities(characterClassRow.getId(), allAbilities));
    return characterClass;
  }

  private BaseAttackBonus getBaseAttackBonus(final int baseAttackBonusId) {
    for (final BaseAttackBonus baseAttackBonus : BaseAttackBonus.values()) {
      if (baseAttackBonus.ordinal() == baseAttackBonusId) {
        return baseAttackBonus;
      }
    }
    throw new IllegalArgumentException("Can't get base attack bonus of id: " + baseAttackBonusId);
  }

  <U extends Enum<U>> EnumSet<U> getEnums(final int ids, final Class<U> enumClass) {
    final EnumSet<U> enumSet = EnumSet.noneOf(enumClass);
    for (final U currentEnum : enumClass.getEnumConstants()) {
      final int mask = 1 << currentEnum.ordinal();
      if ((ids & mask) > 0) {
        enumSet.add(currentEnum);
      }
    }
    return enumSet;
  }

  private List<Skill> getSkills(final int characterClassId, final List<Skill> allSkills) {
    final List<Skill> skills = new ArrayList<Skill>();
    for (final DataRow characterClassSkillRow : characterClassSkillTable) {
      if (characterClassId == characterClassSkillRow.getId()) {
        final int skillId = (Integer) characterClassSkillRow.get(1);
        final Skill skill = getSkill(skillId, allSkills);
        skills.add(skill);
      }
    }
    return skills;
  }

  private Skill getSkill(final int skillId, final List<Skill> allSkills) {
    for (final Skill skill : allSkills) {
      if (skill.getId() == skillId) {
        return skill;
      }
    }
    throw new IllegalArgumentException("Can't get skill with id: " + skillId);
  }

  private Die getHitDie(final int hitDieId) {
    for (final Die hitDie : Die.values()) {
      if (hitDie.ordinal() == hitDieId) {
        return hitDie;
      }
    }
    throw new IllegalArgumentException("Can't get hit die of id: " + hitDieId);
  }

  private List<ClassAbility> getAbilities(final int characterClassId, final List<Ability> allAbilities) {
    final List<ClassAbility> classAbilities = new ArrayList<ClassAbility>();
    for (final DataRow dataRow : characterClassAbilityTable) {
      if (dataRow.getId() == characterClassId) {
        final ClassAbility classAbility = selectClassAbility(dataRow, allAbilities);
        classAbilities.add(classAbility);
      }
    }
    return classAbilities;
  }

  private ClassAbility selectClassAbility(final DataRow dataRow, final List<Ability> allClassAbilities) {
    final int abilityId = (Integer) dataRow.get(1);
    final Ability ability = getAbility(abilityId, allClassAbilities);
    final ClassAbility classAbility = new ClassAbility(ability);
    final int level = (Integer) dataRow.get(2);
    classAbility.setLevel(level);
    return classAbility;
  }

  private Ability getAbility(final int abilityId, final List<Ability> allAbilities) {
    for (final Ability ability : allAbilities) {
      if (ability.getId() == abilityId) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't determine ability of id: " + abilityId);
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.ClassDao#deleteSkill(com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public void deleteSkill(final Skill skill) {
    characterClassSkillTable.delete(1, skill.getId());
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.ClassDao#updateCharacterClass(com.d20charactersheet.framework.boc.model.CharacterClass)
   */
  @Override
  public void updateCharacterClass(final CharacterClass characterClass) {
    deleteCharacterClass(characterClass);
    insertCharacterClass(characterClass);
  }

  private void deleteCharacterClass(final CharacterClass characterClass) {
    characterClassSkillTable.delete(characterClass.getId());
    characterClassAbilityTable.delete(characterClass.getId());
    characterClassTable.delete(characterClass.getId());
  }

  private void insertCharacterClass(final CharacterClass characterClass) {
    final int saves = setEnum(characterClass.getSaves());
    final int alignments = setEnum(characterClass.getAlignments());

    // Id, Name, Saves, Alignments, base attack bonus, skill points per level, hit die id
    characterClassTable.insert(new Object[] {characterClass.getId(), characterClass.getName(), saves, alignments,
        characterClass.getBaseAttackBonus().ordinal(), characterClass.getSkillPointsPerLevel(), characterClass.getHitDie().ordinal()
    });

    for (final Skill skill : characterClass.getSkills()) {
      characterClassSkillTable.insert(new Object[] {characterClass.getId(), skill.getId()});
    }

    for (final ClassAbility classAbility : characterClass.getClassAbilities()) {
      characterClassAbilityTable
          .insert(new Object[] {characterClass.getId(), classAbility.getAbility().getId(), classAbility.getLevel()});
    }

  }

  private int setEnum(final EnumSet<?> enumset) {
    int result = 0;
    for (final Enum<?> currentEnum : enumset) {
      result += 1 << currentEnum.ordinal();
    }
    return result;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.ClassDao#createCharacterClass(com.d20charactersheet.framework.boc.model.CharacterClass)
   */
  @Override
  public CharacterClass createCharacterClass(final CharacterClass characterClass) {
    characterClass.setId(characterClassTable.getNewId());
    insertCharacterClass(characterClass);
    return characterClass;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.ClassDao#addSkill(com.d20charactersheet.framework.boc.model.Skill, * java.util.List)
   */
  @Override
  public void addSkill(final Skill skill, final List<CharacterClass> characterClasses) {
    for (final CharacterClass characterClass : characterClasses) {
      characterClassSkillTable.insert(new Object[] {characterClass.getId(), skill.getId()});
    }
  }
}
