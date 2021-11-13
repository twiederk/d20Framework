package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a character class.
 */
public class CharacterClass implements Serializable {

  private static final long serialVersionUID = -4273293681688637609L;

  private int id;

  private String name;

  private Die hitDie;

  private BaseAttackBonus baseAttackBonus;

  private EnumSet<Save> saves;

  private EnumSet<Alignment> alignments;

  private int skillPointsPerLevel;

  private List<Skill> skills;

  private List<ClassAbility> classAbilities = new LinkedList<>();

  private StarterPack starterPack;

  private int imageId;

  /**
   * Returns the id of the class.
   *
   * @return The id of the class.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the class. The id must be unique.
   *
   * @param id
   *     The id of the class.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the class.
   *
   * @return The name of the class.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the class.
   *
   * @param name
   *     The name of the class.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the base attack bonus.
   *
   * @return The base attack bonus.
   */
  public BaseAttackBonus getBaseAttackBonus() {
    return baseAttackBonus;
  }

  /**
   * Sets the base attack bonus.
   *
   * @param baseAttackBonus
   *     The base attack bonus.
   */
  public void setBaseAttackBonus(final BaseAttackBonus baseAttackBonus) {
    this.baseAttackBonus = baseAttackBonus;
  }

  /**
   * Returns all the saves of the class which have a good base bonus.
   *
   * @return All the saves with a good base bonus.
   */
  public EnumSet<Save> getSaves() {
    return saves;
  }

  /**
   * Sets the saves with good base bonus.
   *
   * @param baseSaveBonus
   *     The saves with good base bonus.
   */
  public void setSaves(final EnumSet<Save> baseSaveBonus) {
    this.saves = baseSaveBonus;
  }

  /**
   * Returns all allowed alignments of the class.
   *
   * @return All allowed alignments of the class.
   */
  public EnumSet<Alignment> getAlignments() {
    return alignments;
  }

  /**
   * Sets all allowed alignments of the class.
   *
   * @param alignments
   *     Allowed alignments of the class.
   */
  public void setAlignments(final EnumSet<Alignment> alignments) {
    this.alignments = alignments;
  }

  /**
   * Returns the number of skill points the class gaines for each level.
   *
   * @return The number of skill points the class gaines for each level.
   */
  public int getSkillPointsPerLevel() {
    return skillPointsPerLevel;
  }

  /**
   * Set the number of skill points the class gaines for each level.
   *
   * @param skillPointsPerLevel
   *     The number of skill points the class gaines for each level.
   */
  public void setSkillPointsPerLevel(final int skillPointsPerLevel) {
    this.skillPointsPerLevel = skillPointsPerLevel;
  }

  /**
   * Returns the skills of the class.
   *
   * @return The skills of the class.
   */
  public List<Skill> getSkills() {
    return skills;
  }

  /**
   * Sets the skills of the class.
   *
   * @param classSkills
   *     The skills of the class.
   */
  public void setSkills(final List<Skill> classSkills) {
    this.skills = classSkills;
  }

  /**
   * Sets the hit die of the class.
   *
   * @param hitDie
   *     The hit die to set.
   */
  public void setHitDie(final Die hitDie) {
    this.hitDie = hitDie;
  }

  /**
   * Returns the hit die of the class.
   *
   * @return The hit die of the class.
   */
  public Die getHitDie() {
    return hitDie;
  }

  /**
   * Returns all abilities of the class.
   *
   * @return All abilities of the class.
   */
  public List<ClassAbility> getClassAbilities() {
    return classAbilities;
  }

  /**
   * Sets the abilities of the class.
   *
   * @param classAbilities
   *     The abilities of the class.
   */
  public void setClassAbilities(final List<ClassAbility> classAbilities) {
    this.classAbilities = classAbilities;
  }

  /**
   * Gets start pack of the class.
   *
   * @return The starter pack of the class.
   */
  public StarterPack getStarterPack() {
    return starterPack;
  }

  /**
   * Sets the starter pack of the class.
   *
   * @param starterPack
   *     The starter pack to set
   */
  public void setStarterPack(StarterPack starterPack) {
    this.starterPack = starterPack;
  }

  /**
   * Gets image id of the class.
   *
   * @return The image id of the class.
   */
  public int getImageId() {
    return imageId;
  }

  /**
   * Sets the image id of the class.
   *
   * @param imageId
   *     The image id to set
   */
  public void setImageId(int imageId) {
    this.imageId = imageId;
  }

  /**
   * Returns the name of the character class.
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /**
   * Character classes with the same id are equal.
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CharacterClass other = (CharacterClass) obj;
    return id == other.id;
  }

  /**
   * Special Object Pattern to represent any character class by an entity.
   */
  public static class AnyCharacterClass extends CharacterClass {

    /**
     * Special object representing any character class
     */
    public static final CharacterClass ANY_CHARACTER_CLASS = new AnyCharacterClass();

    private static final long serialVersionUID = -4894505396895224186L;

    private AnyCharacterClass() {
      super();
      setId(-1);
      setName("Any");
      setHitDie(Die.D2);
      setBaseAttackBonus(BaseAttackBonus.POOR);
      setSaves(EnumSet.noneOf(Save.class));
      setAlignments(EnumSet.noneOf(Alignment.class));
      setSkillPointsPerLevel(0);
      setSkills(new LinkedList<>());
    }
  }

}
