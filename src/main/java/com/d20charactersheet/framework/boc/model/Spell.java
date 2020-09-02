package com.d20charactersheet.framework.boc.model;

import java.io.Serializable;
import java.util.BitSet;

/**
 * The representation of a spell.
 */
public class Spell implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private School school;
  private SubSchool subSchool;
  private Descriptor[] descriptors;
  private final BitSet components;
  private CastingTime castingTime;
  private Range range;
  private String effect;
  private String duration;
  private String savingThrow;
  private SpellResistance spellResistance;
  private String description;
  private String materialComponent;
  private String focus;
  private String shortDescription;

  /**
   * Instanciates a spell.
   */
  public Spell() {
    components = new BitSet(6);
  }

  /**
   * Returns the id of the spell.
   *
   * @return The id of the spell.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the spell.
   *
   * @param id
   *     The id of the spell.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Returns the name of the spell.
   *
   * @return The name of the spell.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the spell.
   *
   * @param name
   *     The name of the spell.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns the school of the spell. The school consists of school, subschool and descriptor.
   *
   * @return The school of the spell.
   */
  public School getSchool() {
    return school;
  }

  /**
   * Sets the school of the spell.
   *
   * @param school
   *     The school of the spell.
   */
  public void setSchool(final School school) {
    this.school = school;
  }

  /**
   * Returns the casting time.
   *
   * @return The casting time.
   */
  public CastingTime getCastingTime() {
    return castingTime;
  }

  /**
   * Sets the casting time.
   *
   * @param castingTime
   *     The casting time.
   */
  public void setCastingTime(final CastingTime castingTime) {
    this.castingTime = castingTime;
  }

  /**
   * Returns the range of the spell.
   *
   * @return The range of the spell.
   */
  public Range getRange() {
    return range;
  }

  /**
   * Sets the range of the spell.
   *
   * @param range
   *     The range of the spell.
   */
  public void setRange(final Range range) {
    this.range = range;
  }

  /**
   * Returns the effected area of the spell.
   *
   * @return The effected area of the spell.
   */
  public String getEffect() {
    return effect;
  }

  /**
   * Sets the effect area of the spell.
   *
   * @param effect
   *     The effect are of the spell.
   */
  public void setEffect(final String effect) {
    this.effect = effect;
  }

  /**
   * Returns the duration of the spell.
   *
   * @return The duration of the spell.
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Sets the duration of the spell.
   *
   * @param duration
   *     The duration of the spell.
   */
  public void setDuration(final String duration) {
    this.duration = duration;
  }

  /**
   * Returns if a save is allowed and the consequence of a successfull save.
   *
   * @return Is a save allowed and what is the consequence of a successfull save.
   */
  public String getSavingThrow() {
    return savingThrow;
  }

  /**
   * Sets if save is allowed and the consequence of a successfull save.
   *
   * @param savingThrow
   *     Is save allowed and consequence of successfull save.
   */
  public void setSavingThrow(final String savingThrow) {
    this.savingThrow = savingThrow;
  }

  /**
   * Returns if spell resistance applies
   *
   * @return Spell resistance
   */
  public SpellResistance getSpellResistance() {
    return spellResistance;
  }

  /**
   * Sets if spell resistance applies.
   *
   * @param spellResistance
   *     Spell resistance
   */
  public void setSpellResistance(final SpellResistance spellResistance) {
    this.spellResistance = spellResistance;
  }

  /**
   * Returns spell description.
   *
   * @return Spell description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets spell description.
   *
   * @param description
   *     Spell description.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Returns the material component of the spell.
   *
   * @return The material component of the spell.
   */
  public String getMaterialComponent() {
    return materialComponent;
  }

  /**
   * Sets the material component of the spell.
   *
   * @param materialComponent
   *     The material component.
   */
  public void setMaterialComponent(final String materialComponent) {
    this.materialComponent = materialComponent;
  }

  /**
   * Returns the focus of the spell.
   *
   * @return The focus of the spell.
   */
  public String getFocus() {
    return focus;
  }

  /**
   * Sets the focus of the spell.
   *
   * @param focus
   *     The focus of the spell.
   */
  public void setFocus(final String focus) {
    this.focus = focus;
  }

  /**
   * Set true if verbal component is required by the spell.
   *
   * @param verbal
   *     True, if verbal component is required.
   */
  public void setVerbal(final boolean verbal) {
    components.set(0, verbal);
  }

  /**
   * Set true if verbal component is required by the spell.
   *
   * @param somatic
   *     True, if verbal component is required.
   */
  public void setSomatic(final boolean somatic) {
    components.set(1, somatic);
  }

  /**
   * Set true if verbal component is required by the spell.
   *
   * @param material
   *     True, if verbal component is required.
   */
  public void setMaterial(final boolean material) {
    components.set(2, material);
  }

  /**
   * Set true if focus is required by the spell.
   *
   * @param focus
   *     True, if focus is required.
   */
  public void setFocus(final boolean focus) {
    components.set(3, focus);
  }

  /**
   * Set true if divine focus is required by the spell.
   *
   * @param divineFocus
   *     True, if divine focus is required.
   */
  public void setDivineFocus(final boolean divineFocus) {
    components.set(4, divineFocus);
  }

  /**
   * Set true if experience points are consumed by the spell.
   *
   * @param xpCost
   *     True, if experience points are consumed.
   */
  public void setXpCost(final boolean xpCost) {
    components.set(5, xpCost);
  }

  /**
   * Returns true, if verbal component is required.
   *
   * @return True, if verbal component is required.
   */
  public boolean isVerbal() {
    return components.get(0);
  }

  /**
   * Returns true, if somatic component is required.
   *
   * @return True, if somatic component is required.
   */
  public boolean isSomatic() {
    return components.get(1);
  }

  /**
   * Returns true, if material component is required.
   *
   * @return True, if material component is required.
   */
  public boolean isMaterial() {
    return components.get(2);
  }

  /**
   * Returns true, if focus is required.
   *
   * @return True, if focus is required.
   */
  public boolean isFocus() {
    return components.get(3);
  }

  /**
   * Returns true, if divine focus is required.
   *
   * @return True, if divine focus is required.
   */
  public boolean isDivineFocus() {
    return components.get(4);
  }

  /**
   * Returns true, if experience points are consumed.
   *
   * @return True, if experience points are consumed.
   */
  public boolean isXpCost() {
    return components.get(5);
  }

  /**
   * Returns the short description.
   *
   * @return The short description.
   */
  public String getShortDescription() {
    return shortDescription;
  }

  /**
   * Sets the short description.
   *
   * @param shortDescription
   *     The short description.
   */
  public void setShortDescription(final String shortDescription) {
    this.shortDescription = shortDescription;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

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
    final Spell other = (Spell) obj;
    return id == other.id;
  }

  /**
   * Returns the sub school.
   *
   * @return The sub school.
   */
  public SubSchool getSubSchool() {
    return subSchool;
  }

  /**
   * Sets the sub school.
   *
   * @param subSchool
   *     The sub school.
   */
  public void setSubSchool(final SubSchool subSchool) {
    this.subSchool = subSchool;
  }

  /**
   * Returns the descriptors.
   *
   * @return The descriptors.
   */
  public Descriptor[] getDescriptors() {
    return descriptors;
  }

  /**
   * Sets the descriptors.
   *
   * @param descriptor
   *     The descriptors.
   */
  public void setDescriptors(final Descriptor[] descriptor) {
    this.descriptors = descriptor;
  }
}
