package com.d20charactersheet.framework.boc.service;

import java.util.EnumSet;
import java.util.List;

import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.DieRoll;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.boc.model.Size;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;

/**
 * Provides data of different tables of the D&D handbooks.
 */
public interface RuleService {

  /**
   * Returns the modifier of an attribute value.
   *
   * @param value
   *     The attribute value.
   *
   * @return The modifier according to the attribute value.
   */
  public int getModifier(int value);

  /**
   * All class levels of the character are added up to the base attack bonus of the character.
   *
   * @param character
   *     The character to calculate the base attack bonus of.
   *
   * @return The base attack bonus of the character.
   */
  public int getBaseAttackBonus(Character character);

  /**
   * Returns the initiative of the character. The initiative is the dexterity bonus of the character.
   *
   * @param character
   *     The character to calulcate the initative of.
   *
   * @return The initiative of the character.
   */
  public int getInitative(Character character);

  /**
   * Returns the speed of the character. The speed depends on the race of the character.
   *
   * @param character
   *     The character to return the speed of.
   *
   * @return The speed of the character.
   */
  public int getSpeed(Character character);

  /**
   * Returns the armor class of the character. The armor class is calculated by the formular 10 + Dexteritymod. +
   * armor
   *
   * @param character
   *     The character to calculate the armor of.
   *
   * @return The armor class of the character.
   */
  public int getArmorClass(Character character);

  /**
   * Returns all classes the character has no level in.
   *
   * @param character
   *     The character to get the opposite classes of.
   * @param allClasses
   *     All character classes of the game system.
   *
   * @return All classes the character has no level in.
   */
  public List<CharacterClass> getOppositeOfCharacterClasses(Character character, List<CharacterClass> allClasses);

  /**
   * Returns the max class skill rank of the character.
   *
   * @param character
   *     The character to determine the max class skill of.
   *
   * @return The max class skill rank of the character.
   */
  public int getMaxClassSkillRank(Character character);

  /**
   * Returns the max cross class skill rank of the character.
   *
   * @param character
   *     The character to determine the max cross class skill of.
   *
   * @return The max cross class skill rank of the character.
   */
  public float getMaxCrossClassSkillRank(Character character);

  /**
   * Returns, true if the character is trained in the skill.
   *
   * @param characterSkill
   *     The skill to check.
   *
   * @return True, if the character is trained in the skill.
   */
  public boolean isTrained(CharacterSkill characterSkill);

  /**
   * Returns the number of skill points of the character, with the given start class.
   *
   * @param character
   *     The character to calculate the number of skill points of.
   * @param startClass
   *     The class of the characters 1st character
   *
   * @return The number of skill points of the character.
   */
  public int getSkillPoints(Character character, CharacterClass startClass);

  /**
   * The skill modifier of this skill for this character. Calculating together the attribute modifier, rank and
   * modifier of the skill.
   *
   * @param character
   *     The character using the skill.
   * @param characterSkill
   *     The skill, with its rank and modifier.
   *
   * @return The skill modifier.
   */
  public int getSkillModifier(Character character, CharacterSkill characterSkill);

  /**
   * Returns the attribute modifier of the character of the given attribute.
   *
   * @param character
   *     The character to get the modifier of.
   * @param attribute
   *     The attribute to get the modifier of.
   *
   * @return The attribute modifier.
   */
  public int getAttributeModifier(Character character, Attribute attribute);

  /**
   * Performs a skill check. Returning the result of the die roll.
   *
   * @param character
   *     The character to perform the skill check.
   * @param characterSkill
   *     The skill to perform the skill check.
   *
   * @return The result of the skill check.
   */
  public DieRoll rollSkill(Character character, CharacterSkill characterSkill);

  /**
   * Returns the save of character. Save is calculated of base save, plus attribute modifier, plus modifier.
   *
   * @param character
   *     The character to get the save of.
   * @param save
   *     The save to get.
   *
   * @return The save of the character.
   */
  public int getSave(Character character, Save save);

  /**
   * Returns the base save of the character. The base save is calculated of all base saves of the classes with levels
   * of the character.
   *
   * @param character
   *     The character to get the base save of.
   * @param save
   *     The save to get the base save of.
   *
   * @return The base save of the character.
   */
  public int getBaseSave(Character character, Save save);

  /**
   * Returns the modifier of the character for the save.
   *
   * @param character
   *     The character to get the modifier of.
   * @param save
   *     The save to get the modifier of.
   *
   * @return The modifier of the character for the save.
   */
  public int getSaveModifier(Character character, Save save);

  /**
   * Returns the attribute modifier of the character for the save.
   *
   * @param character
   *     The character to get the abiltiy modifier of.
   * @param save
   *     The save to get the attribute modifier of.
   *
   * @return The attribute modifier of the character for the save.
   */
  public int getSaveAttributeModifier(Character character, Save save);

  /**
   * Returns true if the skill is a class skill of the character.
   *
   * @param character
   *     The character to check against.
   * @param skill
   *     The skill to check.
   *
   * @return True if the skill is a class skill of the character.
   */
  public boolean isClassSkill(Character character, Skill skill);

  /**
   * Calcultes the number of feats of the character.
   *
   * @param character
   *     The character to calculate the number of feats of.
   *
   * @return The number of feats of the character.
   */
  public int getNumberOfFeats(Character character);

  /**
   * Calculates the number of skill points spent by the character.
   *
   * @param character
   *     The character to calculate its spent skill points.
   *
   * @return The number of skill points spent by the character.
   */
  public int getSpentSkillPoints(Character character);

  /**
   * Sums up the gold of the character.
   *
   * @param character
   *     The character to sum up its gold.
   *
   * @return The gold of the character.
   */
  public float getGold(Character character);

  /**
   * Calculates the load of the character. Goods of type MOUNT and MOUNT_GEAR are not added.
   *
   * @param character
   *     The character to calculate its load.
   *
   * @return The load of the character.
   */
  public float getLoad(Character character);

  /**
   * Calculates the Combat Maneuver Bonus (CMB) of the character.
   *
   * @param character
   *     The character to calculate the cmb of.
   *
   * @return The calculated cmb.
   */
  public int getCombatManeuverBonus(Character character);

  /**
   * Calculates the Combat Maneuver Defence Bonus (CMD) of the character.
   *
   * @param character
   *     The character to calculate the cmd of.
   *
   * @return The calculated cmd.
   */
  public int getCombatManeuverDefence(Character character);

  /**
   * Returns the special size modificator for cmb/grapple.
   *
   * @param size
   *     The sice of the creature.
   *
   * @return The special size modificator for cmb/grapple.
   */
  public int getSpecialSizeModifier(Size size);

  /**
   * Returns the name of the game system.
   *
   * @return The name of the game system.
   */
  public String getName();

  /**
   * Returns how many ranks are gained by investing one skill point.
   *
   * @param character
   *     The character to check.
   * @param skill
   *     The skill to check.
   *
   * @return The number of ranks the character get for investing one skill point in the given skill.
   */
  public float getRankPerSkillPoint(Character character, Skill skill);

  /**
   * Calculates the attack bonuses and damage of the given WeaponAttack.
   *
   * @param character
   *     The character who attacks.
   * @param weaponAttack
   *     The WeaponAttack to calculate.
   *
   * @return The calculated WeaponAttack.
   */
  public WeaponAttack calculateWeaponAttack(Character character, WeaponAttack weaponAttack);

  /**
   * Rolls an attack with the given attack bonus.
   *
   * @param attackBonus
   *     The bonus to add to the attack.
   *
   * @return The result of the attack roll.
   */
  public DieRoll rollAttack(int attackBonus);

  /**
   * Rolls a damage with the given damage and bonus.
   *
   * @param damage
   *     The number and type of dice to roll.
   * @param damageBonus
   *     The bonus to add.
   *
   * @return The result of the damage roll.
   */
  public DieRoll rollDamage(Damage damage, int damageBonus);

  /**
   * Rolls a critical with the given damage, bonus and critical.
   *
   * @param damage
   *     The number and type of dice to roll.
   * @param damageBonus
   *     The bonus to add.
   * @param critical
   *     The critical to roll multi times.
   *
   * @return The reslt of the critical roll.
   */
  public DieRoll rollCritical(Damage damage, int damageBonus, Critical critical);

  /**
   * Returns true, if the attack roll is critical.
   *
   * @param attackRoll
   *     The attack roll to check.
   * @param critical
   *     The critical hit to achieve.
   *
   * @return True, if the attack roll is critical.
   */
  public boolean isCritical(DieRoll attackRoll, Critical critical);

  /**
   * Returns true, if the attack roll fumbled.
   *
   * @param dieRoll
   *     The attack roll to check.
   *
   * @return True, if the attack roll fumbled.
   */
  public boolean isFumble(DieRoll dieRoll);

  /**
   * Returns the allows attack wields for the weapon.
   *
   * @param weapon
   *     The weapon to get the attack wields of.
   *
   * @return The allows attack wields for the weapon.
   */
  public EnumSet<AttackWield> getAttackWields(Weapon weapon);

  /**
   * Returns the result of an attribute roll.
   *
   * @param character
   *     The character to check the attribute of.
   * @param attribute
   *     The attribute to check.
   *
   * @return the result of an attribute roll.
   */
  public DieRoll rollAttribute(Character character, Attribute attribute);

  /**
   * Returns the result of a save roll.
   *
   * @param character
   *     The character to check the save of.
   * @param save
   *     The save to check.
   *
   * @return The result of a save roll.
   */
  public DieRoll rollSave(Character character, Save save);

  /**
   * Returns the result of the initative roll.
   *
   * @param character
   *     The charcter to roll initative for.
   *
   * @return The result of the initative roll.
   */
  public DieRoll rollInitative(Character character);

  /**
   * Returns the result of a base attack bonus roll.
   *
   * @param character
   *     The character to roll bab for.
   *
   * @return The result of a base attack bonus roll.
   */
  public DieRoll rollBaseAttackBonus(Character character);

  /**
   * Returns the result of a combat maneuver bonus roll.
   *
   * @param character
   *     The character to roll for.
   *
   * @return The result of a combat maneuver bonus roll.
   */
  public DieRoll rollCombatManeuverBonus(Character character);

  /**
   * Returns the result of the combat maneuver defence roll.
   *
   * @param character
   *     The character to roll for.
   *
   * @return The result of the combat maneuver defence roll.
   */
  public DieRoll rollCombatManeuverDefence(Character character);

  /**
   * Returns the number of known spells of the character for the given spell list ability and spell level.
   *
   * @param character
   *     The character to calculate the number of known spells of.
   * @param spelllistAbility
   *     The spell abilitiy to calculate the number of known spells for.
   * @param spellLevel
   *     The spell level.
   *
   * @return The number of known spells of the character for the given spell list ability and spell level.
   */
  public int getNumberOfKnownSpells(Character character, SpelllistAbility spelllistAbility, int spellLevel);

  /**
   * Returns the maximum spell level of the character for the given spell list ability.
   *
   * @param character
   *     The character to calculate the max spell level of.
   * @param spelllistAbility
   *     The spell list ability
   *
   * @return The maximum spell level of the character for the given spell list ability.
   */
  public int getMaxSpelllevel(Character character, SpelllistAbility spelllistAbility);

  /**
   * Returns the spell slots of the character and fills them with spells.
   *
   * @param character
   *     The character to calculate the spell slots of.
   *
   * @return The spell slots of the character and fills them with spells.
   */
  public List<SpellSlot> calculateSpellSlots(Character character);

  /**
   * Returns the current spell caster level of the character for the given spell list ability.
   *
   * @param character
   *     The character to calculate the current spell caster level of.
   * @param spelllistAbility
   *     The spell list ability to calculate the spell caster level of.
   *
   * @return The current spell caster level of the character for the given spell list ability.
   */
  public int getSpellcasterLevel(Character character, SpelllistAbility spelllistAbility);

  /**
   * Returns the spells available for spell slot of the character.
   *
   * @param character
   *     The character the spell slot belongs to.
   * @param spellSlot
   *     The spell slot to get the available spells for
   *
   * @return Returns the spells available for spell slot of the character.
   */
  public List<Spell> getSpellSelection(Character character, SpellSlot spellSlot);

  /**
   * Returns spell save difficulty class for spell of spell slot.
   *
   * @param character
   *     The character the spell splot belongs to.
   * @param spellSlot
   *     The spell slot with the assigned spell.
   *
   * @return Spell save difficulty class for spell of spell slot.
   */
  public int getSpellSaveDifficultyClass(Character character, SpellSlot spellSlot);

  /**
   * Refreshes all spell slots of the character. Spell slots of prepared spells are set to uncast. Spell slots of
   * spontanous spells are set to uncast and the empty spell is assigned.
   *
   * @param character
   *     The character to refresh its spell slots.
   *
   * @return The refreshed spell slots.
   */
  public List<SpellSlot> rest(Character character);
}
