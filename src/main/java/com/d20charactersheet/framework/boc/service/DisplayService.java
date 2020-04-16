package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.BaseAttackBonus;
import com.d20charactersheet.framework.boc.model.CastingTime;
import com.d20charactersheet.framework.boc.model.CastingType;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Descriptor;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.FeatType;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Note;
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
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponType;

/**
 * Service to turn internal data into displayable strings.
 */
public interface DisplayService {

  /**
   * Returns the displayable and language dependent alignment.
   *
   * @param alignment
   *     The alignment to display.
   *
   * @return The displayable alignment value.
   */
  String getDisplayAlignment(Alignment alignment);

  /**
   * Returns the displayable language dependent class level. Each class level is separated by a comma. Example: Wizard
   * (4), Figher (2)
   *
   * @param classLevels
   *     The class levels to display.
   *
   * @return The displayable class levels.
   */
  String getDisplayClassLevels(List<ClassLevel> classLevels);

  /**
   * Returns a modifier containg a prefix sign. Plus(+) positive valus, minus(-) negative values. Zero has no prefix.
   *
   * @param modifier
   *     The current modifer.
   *
   * @return The modifier with the prefix sign.
   */
  String getDisplayModifier(int modifier);

  /**
   * Returns the base attack bonus devided in multiple attacks. Example: base attack bonus +7 => +7/+2
   *
   * @param baseAttackBonus
   *     The base attack bonus.
   *
   * @return The base attack bonus devided by multiple attacks.
   */
  String getDisplayBaseAttackBonus(int baseAttackBonus);

  /**
   * Returns the formular to calculate the armor class. Example: 10 + (+2) +
   *
   * @param dexterityModifier
   *     The modifier to display in the formular.
   *
   * @return The formular to calculate the armor class.
   */
  String getDisplayArmourClassFormular(int dexterityModifier);

  /**
   * Returns the displayable and language dependent sex.
   *
   * @param sex
   *     The sex to display.
   *
   * @return The displayable and language dependent sex.
   */
  String getDisplaySex(Sex sex);

  /**
   * Returns the language dependent error message of the given error.
   *
   * @param ruleError
   *     The error to get the error message of.
   *
   * @return The language dependent error message of the given error.
   */
  String getErrorMessage(RuleError ruleError);

  /**
   * Returns the displayable and language dependent class level. Example: Bard (6)
   *
   * @param classLevel
   *     The class level to display.
   *
   * @return The displayable and language dependent class level. Example: Bard (6)
   */
  String getDisplayClassLevel(ClassLevel classLevel);

  /**
   * Returns the formula to calculate the initiative and cmb. Example: +2 +
   *
   * @param modifier
   *     The modifier to display.
   *
   * @return The formula to calculate the initiative and cmb.
   */
  String getDisplaySimpleFormular(int modifier);

  /**
   * Returns the displayable and language dependent attribute. Example: Dexterity.
   *
   * @param attribute
   *     The attribute to display.
   *
   * @return The displayable and language dependent attribute.
   */
  String getDisplayAttribute(Attribute attribute);

  /**
   * Returns the displayable and language dependent feat type. Example: Item Creation.
   *
   * @param featType
   *     The feat type to display.
   *
   * @return The displayable and language dependent feat type.
   */
  String getDisplayFeatType(FeatType featType);

  /**
   * Returns the displayable and language dependent die name.
   *
   * @param die
   *     The die to get the name of.
   *
   * @return The displayable and language dependent die name.
   */
  String getDisplayDie(Die die);

  /**
   * Returns the displayable and language dependent name of the base attack bonus.
   *
   * @param baseAttackBonus
   *     The base attack bonus to get the name of.
   *
   * @return The displayable and language dependent name of the base attack bonus.
   */
  String getDisplayBaseAttackBonus(BaseAttackBonus baseAttackBonus);

  /**
   * Returns weight with language specific unit (lb.). Decimal part is only displayed if decimal part exists.
   *
   * @param weight
   *     The weight to display.
   *
   * @return The weight with unit to display.
   */
  String getDisplayWeight(float weight);

  /**
   * Returns the cost as cold pieces. Decimal part is only display if necessary.
   *
   * @param cost
   *     The cost to display.
   *
   * @return The cost as cold pieces.
   */
  String getDisplayCost(float cost);

  /**
   * Returns displayable, language dependent weapon type.
   *
   * @param weaponFamily
   *     The weapon family to display.
   *
   * @return Displayable, language dependent weapon type.
   */
  String getDisplayWeaponType(WeaponType weaponFamily);

  /**
   * Returns humanreadable, language dependent armor type.
   *
   * @param armorType
   *     The armor type to display.
   *
   * @return Humanreadable, language dependent armor type.
   */
  String getDisplayArmorType(ArmorType armorType);

  /**
   * Returns humanreadable, language dependent good type.
   *
   * @param goodType
   *     The good type to display.
   *
   * @return Humanreadable, language dependent armor type.
   */
  String getDisplayGoodType(GoodType goodType);

  /**
   * Returns humanreadable critical.
   *
   * @param critical
   *     The critical to display.
   *
   * @return Humanreadable critical.
   */
  String getDisplayCritical(Critical critical);

  /**
   * Returns the damage humanreadable and language dependent.
   *
   * @param weapon
   *     The weapon to display the damage of.
   *
   * @return The damage humanreadable and language dependent.
   */
  String getDisplayDamage(Weapon weapon);

  /**
   * Returns the damage for display.
   *
   * @param damage
   *     The damage to display.
   * @param bonus
   *     The damage bonus to display.
   *
   * @return The damage humanreadable and language dependent.
   */
  String getDisplayDamage(Damage damage, int bonus);

  /**
   * Returns the damage for display.
   *
   * @param weaponAttack
   *     The weapon attack to display the damage of.
   *
   * @return The damage humanreadable and language dependent.
   */
  String getDisplayDamage(WeaponAttack weaponAttack);

  /**
   * Returns the size humanreadable and language dependent.
   *
   * @param size
   *     The size to display.
   *
   * @return The size humanreadable and language dependent.
   */
  String getDisplaySize(Size size);

  /**
   * Return ability type as humanreadable and language dependent.
   *
   * @param abilityType
   *     The ability type to display.
   *
   * @return Ability type as humanreadable and language dependent.
   */
  String getDisplayAbilityType(AbilityType abilityType);

  /**
   * Displays the first line of a note.
   *
   * @param note
   *     The note to display the first line of.
   *
   * @return The first line of the note.
   */
  String getDisplayNoteFirstLine(Note note);

  /**
   * Displays the name of an item. If the item is a masterwork, this displayed as part of the name. Example Silver
   * Dagger, masterwork
   *
   * @param item
   *     The item to display its name.
   *
   * @return The display name of the item.
   */
  String getDisplayItem(Item item);

  /**
   * Displays the quality type.
   *
   * @param qualityType
   *     The quality type to display.
   *
   * @return The displayable quality type.
   */
  String getDisplayQualityType(QualityType qualityType);

  /**
   * Returns the spell level for display. Example: 2nd-LEVEL SPELLS
   *
   * @param level
   *     The level to display.
   *
   * @return The displayable level.
   */
  String getDisplaySpellLevel(int level);

  /**
   * Returns the spell components in a comma separated list.
   *
   * @param spell
   *     The spell to display its components.
   *
   * @return The spell components in a comma separated list.
   */
  String getDisplaySpellComponents(Spell spell);

  /**
   * Returns the range increment with distance unit. Range increment of zero displays a dash(-). Example: 10 Feet
   *
   * @param rangeIncrement
   *     The range increment to display.
   *
   * @return The range increment with unit for display.
   */
  String getDisplayRangeIncrement(int rangeIncrement);

  /**
   * Returns the distance unit (Feet).
   *
   * @return The distance unit (Feet).
   */
  String getDisplayUnitDistanceShort();

  /**
   * Returns the ammunition of the weapon attack.
   *
   * @param weaponAttack
   *     The weapon attack to display the ammunition of.
   *
   * @return The ammunition of the weapon attack.
   */
  String getDisplayAmmunition(WeaponAttack weaponAttack);

  /**
   * Returns the attack wield for display.
   *
   * @param attackWield
   *     The attack wield to display.
   *
   * @return The attack wield for display.
   */
  String getDisplayAttackWield(final AttackWield attackWield);

  /**
   * Returns the combat type for display.
   *
   * @param combatType
   *     The combat type to display.
   *
   * @return The combat type for display.
   */
  String getDisplayCombatType(CombatType combatType);

  /**
   * Returns the weapon category for display.
   *
   * @param weaponCategory
   *     The weapon category to display.
   *
   * @return The weapon category for display.
   */
  String getDisplayWeaponCategory(WeaponCategory weaponCategory);

  /**
   * Returns the weapon encumbrance for display.
   *
   * @param weaponEncumbrance
   *     The weapon encumbrance to display.
   *
   * @return The weapon encumbrance for display.
   */
  String getDisplayWeaponEncumbrance(WeaponEncumbrance weaponEncumbrance);

  /**
   * Returns the name of the save for display.
   *
   * @param save
   *     The save to display.
   *
   * @return The name of the save.
   */
  String getDisplaySave(Save save);

  /**
   * Returns the abbreviation of an attribute name.
   *
   * @param attribute
   *     The attribute to get the abbreviation of.
   *
   * @return The abbreviation of an attribute name.
   */
  String getDisplayAttributeShort(Attribute attribute);

  /**
   * Returns the complete school of spell, containing school, sub school and descriptors. Exampel Conjuration
   * (Calling) [Acid]
   *
   * @param spell
   *     The spell to display the school of.
   *
   * @return The complete schoof of the spell.
   */
  String getDisplaySpellSchool(final Spell spell);

  /**
   * Returns the school of the spell.
   *
   * @param school
   *     The school to display.
   *
   * @return The school of the spell.
   */
  String getDisplaySchool(final School school);

  /**
   * Returns the sub school for display
   *
   * @param subSchool
   *     The sub school to display.
   *
   * @return The sub school for display
   */
  String getDisplaySubSchool(final SubSchool subSchool);

  /**
   * Returns the casting time for display.
   *
   * @param castingTime
   *     The casting time to display.
   *
   * @return The casting time for display.
   */
  String getDisplayCastingTime(CastingTime castingTime);

  /**
   * Returns descriptor for display.
   *
   * @param descriptor
   *     The discriptor to display.
   *
   * @return Descriptor for display.
   */
  String getDisplayDescriptor(Descriptor descriptor);

  /**
   * Returns the range for display.
   *
   * @param range
   *     The range to display.
   *
   * @return The range for display.
   */
  String getDisplayRange(Range range);

  /**
   * Returns spell resistance for display.
   *
   * @param spellResistance
   *     The spell resistance to display.
   *
   * @return Spell resistance for display.
   */
  String getDisplaySpellResistance(SpellResistance spellResistance);

  /**
   * Returns the class of the ability to display.
   *
   * @param ability
   *     The ability to display the class of.
   *
   * @return The class of the ability to display.
   */
  String getDisplayAbilityClass(Ability ability);

  /**
   * Returns the number of known spells in relation to allowed known spells [3 / 5]. If no known spells are allowed
   * none is displayed [0 / None]. If the number of known spells isn't restricted all is displayed [7 / All].
   *
   * @param numberOfKnownSpells
   *     The number of known spells of the character.
   * @param maxNumberOfKnownSpells
   *     The maximum number of known spells for the character.
   * @param numberOfSpells
   *     The number of spells in this spell list and level.
   *
   * @return The number of known spells in relation to allowed known spells.
   */
  String getDisplayNumberOfKnownSpells(int numberOfKnownSpells, int maxNumberOfKnownSpells, int numberOfSpells);

  /**
   * Returns heading of spell slot level.
   *
   * @param level
   *     The level to get the heading of.
   *
   * @return Heading of spell slot level.
   */
  String getDisplaySpellSlotLevel(int level);

  /**
   * Returns the abbreviation of a spell school.
   *
   * @param school
   *     The school to get the abbreviation of.
   *
   * @return The abbreviation of a spell school.
   */
  String getDisplaySchoolShort(final School school);

  /**
   * Returns displayable the casting typ.
   *
   * @param castingType
   *     The casting type to display.
   *
   * @return Displayable the casting typ.
   */
  String getDisplayCastingType(CastingType castingType);

  /**
   * Returns displayable spell source.
   *
   * @param spellSource
   *     The spell source to displays.
   *
   * @return Displayable spell source.
   */
  String getDisplaySpellSource(SpellSource spellSource);

  /**
   * Returns feat name with number of required spell slots in brakets.
   *
   * @param feat
   *     The feat to display.
   *
   * @return Feat name with number of required spell slots in brakets.
   */
  String getDisplayMetamagicFeat(Feat feat);
}
