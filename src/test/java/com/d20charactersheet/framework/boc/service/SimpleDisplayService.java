package com.d20charactersheet.framework.boc.service;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.BaseAttackBonus;
import com.d20charactersheet.framework.boc.model.CastingTime;
import com.d20charactersheet.framework.boc.model.CastingType;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Descriptor;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.FeatType;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.Range;
import com.d20charactersheet.framework.boc.model.RuleError;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.Size;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellResistance;
import com.d20charactersheet.framework.boc.model.SpellSource;
import com.d20charactersheet.framework.boc.model.SubSchool;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponType;

/**
 * Class is required to test implemented methods in AbstractDisplayService
 */
public class SimpleDisplayService extends AbstractDisplayService {

  @Override
  public String getDisplaySex(final Sex sex) {
    return null;
  }

  @Override
  public String getErrorMessage(final RuleError ruleError) {
    return null;
  }

  @Override
  public String getDisplayAttribute(final Attribute attribute) {
    return null;
  }

  @Override
  public String getDisplayFeatType(final FeatType featType) {
    return null;
  }

  @Override
  public String getDisplayBaseAttackBonus(final BaseAttackBonus baseAttackBonus) {
    return null;
  }

  @Override
  public String getDisplayWeight(final float weight) {
    return null;
  }

  @Override
  public String getDisplayCost(final float cost) {
    return null;
  }

  @Override
  public String getDisplayWeaponType(final WeaponType weaponFamily) {
    return null;
  }

  @Override
  public String getDisplayArmorType(final ArmorType armorType) {
    return null;
  }

  @Override
  public String getDisplayGoodType(final GoodType goodType) {
    return null;
  }

  @Override
  public String getDisplayCritical(final Critical critical) {
    return null;
  }

  @Override
  public String getDisplaySize(final Size size) {
    return null;
  }

  @Override
  public String getDisplayAbilityType(final AbilityType abilityType) {
    return null;
  }

  @Override
  public String getDisplayAlignment(final Alignment alignment) {
    return null;
  }

  @Override
  public String getDisplayItem(final Item item) {
    return null;
  }

  @Override
  public String getDisplayQualityType(final QualityType qualityType) {
    return null;
  }

  @Override
  public String getDisplaySpellLevel(final int level) {
    return null;
  }

  @Override
  public String getDisplaySpellComponents(final Spell spell) {
    return null;
  }

  @Override
  public String getDisplayDie(final Die die) {
    return die.toString();
  }

  @Override
  public String getDisplayUnitDistanceShort() {
    return "Feet";
  }

  @Override
  public String getDisplayAttackWield(final AttackWield attackWield) {
    return null;
  }

  @Override
  public String getDisplayCombatType(final CombatType combatType) {
    return null;
  }

  @Override
  public String getDisplayWeaponCategory(final WeaponCategory weaponCategory) {
    return null;
  }

  @Override
  public String getDisplayWeaponEncumbrance(final WeaponEncumbrance weaponEncumbrance) {
    return null;
  }

  @Override
  public String getDisplaySave(final Save save) {
    return null;
  }

  @Override
  public String getDisplayAttributeShort(final Attribute attribute) {
    return null;
  }

  @Override
  public String getDisplayCastingTime(final CastingTime castingTime) {
    return null;
  }

  @Override
  public String getDisplaySchool(final School school) {
    return null;
  }

  @Override
  public String getDisplaySubSchool(final SubSchool subSchool) {
    return null;
  }

  @Override
  public String getDisplayDescriptor(final Descriptor descriptor) {
    return null;
  }

  @Override
  public String getDisplayRange(final Range range) {
    return null;
  }

  @Override
  public String getDisplaySpellResistance(final SpellResistance spellResistance) {
    return null;
  }

  @Override
  public String getDisplayAbilityClass(final Ability ability) {
    return null;
  }

  @Override
  public String getDisplayNumberOfKnownSpells(final int numberOfKnownSpells, final int maxNumberOfKnownSpells,
      final int numberOfSpells) {
    return null;
  }

  @Override
  public String getDisplaySpellSlotLevel(final int level) {
    return null;
  }

  @Override
  public String getDisplaySchoolShort(final School school) {
    return null;
  }

  @Override
  public String getDisplayCastingType(final CastingType castingType) {
    return null;
  }

  @Override
  public String getDisplaySpellSource(final SpellSource spellSource) {
    return null;
  }

}
