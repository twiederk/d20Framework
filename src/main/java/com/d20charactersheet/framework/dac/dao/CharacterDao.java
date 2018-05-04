package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.XpTable;

/**
 * Data access object to persistent character data.
 */
public interface CharacterDao {

  /**
   * The format of the date how it is stored in the persistent layer as string
   */
  public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

  /**
   * Returns list of all available characters. All character classes are necessary to instanciate the characters.
   *
   * @param allCharacterClasses
   *     All available character classes of the game system.
   * @param allRaces
   *     All races of the game system.
   * @param allXpTables
   *     All Xp tables of the game system.
   *
   * @return List of all available characters.
   */
  public List<Character> getAllCharacters(List<CharacterClass> allCharacterClasses, List<Race> allRaces, List<XpTable> allXpTables);

  /**
   * Returns the character of the given id. All character classes of the game system are necessary to instanciate the
   * character.
   *
   * @param id
   *     The id of the character.
   * @param allCharacterClasses
   *     All character classes of the game system.
   * @param allRaces
   *     All races of the game system.
   * @param allXpTables
   *     All Xp tables of the game system.
   *
   * @return The character of the given id.
   */
  public Character getCharacter(int id, List<CharacterClass> allCharacterClasses, List<Race> allRaces, List<XpTable> allXpTables);

  /**
   * Updates the character to the persistence layer.
   *
   * @param character
   *     The character to update.
   *
   * @return The given character.
   */
  public Character updateCharacter(Character character);

  /**
   * Inserts the character into the persistence layer. Returning it with a valid id.
   *
   * @param character
   *     The character to insert.
   *
   * @return The inserted character with a valid id.
   */
  public Character createCharacter(Character character);

  /**
   * Delets the character from the persistent layer, including its class levels and notes, excluding its images.
   *
   * @param character
   *     The character to delete.
   */
  public void deleteCharacter(Character character);

  /**
   * Returns skills of the character. Character dependent data ist set.
   *
   * @param character
   *     The character to return the skills of.
   * @param allSkills
   *     All skills of the game system.
   *
   * @return Skills of the character.
   */
  public List<CharacterSkill> getCharacterSkills(Character character, List<Skill> allSkills);

  /**
   * Delete all skills of the character.
   *
   * @param character
   *     The character to delete the skills of.
   */
  public void deleteCharacterSkills(Character character);

  /**
   * Returns the feats of the character.
   *
   * @param character
   *     The character to get the feats of.
   * @param allFeats
   *     All feats of the game system.
   *
   * @return The feats of the character.
   */
  public List<CharacterFeat> getCharacterFeats(Character character, List<Feat> allFeats);

  /**
   * Updates the feats of the character.
   *
   * @param character
   *     The character with the feats to update.
   */
  public void updateCharacterFeats(Character character);

  /**
   * Delete all feats of the character.
   *
   * @param character
   *     The character to delete the feats of.
   */
  public void deleteCharacterFeats(Character character);

  /**
   * Returns all weapons of the character.
   *
   * @param character
   *     The character to get its weapons from.
   * @param allWeapons
   *     All existing weapons.
   *
   * @return The weapons of the character.
   */
  public List<ItemGroup> getWeapons(Character character, List<Weapon> allWeapons);

  /**
   * Returns all armor of the character.
   *
   * @param character
   *     The character to get the armor from.
   * @param allArmor
   *     All existing armor.
   *
   * @return The armor of the character.
   */
  public List<ItemGroup> getArmor(Character character, List<Armor> allArmor);

  /**
   * Returns all good of the character
   *
   * @param character
   *     The character to get its goods.
   * @param allGoods
   *     All existing goods.
   *
   * @return The goods of the character.
   */
  public List<ItemGroup> getGoods(Character character, List<Good> allGoods);

  /**
   * Updates the weapons of the character.
   *
   * @param character
   *     The character to update.
   * @param weapons
   *     The weapons to update.
   *
   * @return The updated list of weapons.
   */
  public List<ItemGroup> updateWeapons(Character character, List<ItemGroup> weapons);

  /**
   * Updates the armor of the character.
   *
   * @param character
   *     The character to update.
   * @param armor
   *     The armor to update.
   *
   * @return The updated list of armor.
   */
  public List<ItemGroup> updateArmor(Character character, List<ItemGroup> armor);

  /**
   * Updates the goods of the character.
   *
   * @param character
   *     The character top update.
   * @param goods
   *     The goods to update.
   *
   * @return The updated goods.
   */
  public List<ItemGroup> updateGoods(Character character, List<ItemGroup> goods);

  /**
   * Delete the given Skill from all Characters
   *
   * @param skill
   *     The skill to deleted from the game system.
   */
  public void deleteSkill(Skill skill);

  /**
   * Delete the feat from all characters.
   *
   * @param feat
   *     The feat to deleted from the game system.
   */
  public void deleteFeat(Feat feat);

  /**
   * Returns the notes of the character.
   *
   * @param character
   *     The character get the notes of.
   *
   * @return The notes of the character.
   */
  public List<Note> getNotes(Character character);

  /**
   * Creates the note belonging to the character.
   *
   * @param note
   *     The note to create.
   * @param character
   *     The character the note belongs to.
   *
   * @return The created note with a valid id.
   */
  public Note createNote(Note note, Character character);

  /**
   * Updates a note of a character.
   *
   * @param note
   *     The note to update.
   * @param character
   *     The character the note belongs to.
   */
  public void updateNote(Note note, Character character);

  /**
   * Deletes a note from the persistent layer.
   *
   * @param note
   *     The note to delete.
   */
  public void deleteNote(Note note);

  /**
   * Create new CharacterSkill with given skill. Overwrite this methode to usw own subclasses of CharacterSkill.
   *
   * @param skill
   *     The skill of the CharacterSkill.
   *
   * @return The created CharacterSkill
   */
  public CharacterSkill newCharacterSkill(Skill skill);

  /**
   * Deletes all notes of the given character.
   *
   * @param character
   *     The character to delete the notes of.
   */
  public void deleteNotes(Character character);

  /**
   * Deletes all weapons of the given character.
   *
   * @param character
   *     The character to delete the weapons of.
   */
  public void deleteWeapons(Character character);

  /**
   * Delete all armor of the character.
   *
   * @param character
   *     The character to delete armor of.
   */
  public void deleteArmor(Character character);

  /**
   * Delete all goods of the character.
   *
   * @param character
   *     The character to delete goods of.
   */
  public void deleteGoods(Character character);

  /**
   * Returns list of character abilities.
   *
   * @param character
   *     The character to get class abilities of.
   * @param characterClass
   *     The class to get character abilities.
   *
   * @return List of character abilities.
   */
  public List<CharacterAbility> getCharacterAbilities(Character character, CharacterClass characterClass);

  /**
   * Updates the character ability.
   *
   * @param characterAbility
   *     The character ability to update.
   */
  public void updateCharacterAbility(CharacterAbility characterAbility);

  /**
   * Create CharacterAbility for character and class.
   *
   * @param character
   *     The character to create the CharacterAbility for.
   * @param characterClass
   *     The class the ability belongs to.
   * @param characterAbility
   *     The CharacterAbility to create.
   *
   * @return The created CharacterAbility.
   */
  public CharacterAbility createCharacterAbility(Character character, CharacterClass characterClass,
      CharacterAbility characterAbility);

  /**
   * Delete CharacterAbility.
   *
   * @param characterAbility
   *     The CharacterAbility to delete.
   */
  public void deleteCharacterAbility(CharacterAbility characterAbility);

  /**
   * Delete all character abilities of a character.
   *
   * @param character
   *     The character to delete the abilities of.
   */
  public void deleteCharacterAbilities(Character character);

  /**
   * Create a new class level for a character.
   *
   * @param character
   *     The character to create the ClassLevel for.
   * @param classLevel
   *     The class level to create.
   *
   * @return The created class level.
   */
  public ClassLevel createClassLevel(Character character, ClassLevel classLevel);

  /**
   * Update the class level.
   *
   * @param classLevel
   *     The class level to update.
   */
  public void updateClassLevel(ClassLevel classLevel);

  /**
   * Delete the class level.
   *
   * @param classLevel
   *     The class level to delete.
   */
  public void deleteClassLevel(ClassLevel classLevel);

  /**
   * Delete the given list of character abilities.
   *
   * @param characterClass
   *     The class to delete the abilities of.
   * @param classAbilities
   *     the class abilities to delete.
   */
  public void deleteCharacterAbilities(CharacterClass characterClass, List<ClassAbility> classAbilities);

  /**
   * Returns the weapon attacks of a character.
   *
   * @param character
   *     The character to get the weapon attacks of.
   * @param allWeapons
   *     All weapons.
   *
   * @return The weapon attacks of a character.
   */
  public List<WeaponAttack> getWeaponAttacks(Character character, List<Weapon> allWeapons);

  /**
   * Create a WeaponAttack for a character.
   *
   * @param character
   *     The character to create a WeaponAttack for.
   * @param weaponAttack
   *     The WeaponAttack to create.
   *
   * @return The created weapon attack.
   */
  public WeaponAttack createWeaponAttack(Character character, WeaponAttack weaponAttack);

  /**
   * Update the weapon attack.
   *
   * @param weaponAttack
   *     The weapon attack to update.
   */
  public void updateWeaponAttack(WeaponAttack weaponAttack);

  /**
   * Delete the weapon attack.
   *
   * @param weaponAttack
   *     The weapon attack to delete.
   */
  public void deleteWeaponAttack(WeaponAttack weaponAttack);

  /**
   * Delete all weapon attacks of a character.
   *
   * @param character
   *     The character to delete all weaon attacks of.
   */
  public void deleteWeaponAttacks(Character character);

  /**
   * Returns all marked spells of a character.
   *
   * @param character
   *     The character to get marked spells of.
   * @param allSpelllist
   *     All spell lists of the game sytem.
   * @param allSpells
   *     All spells of the game system.
   *
   * @return All marked spells of a character.
   */
  public List<KnownSpell> getKnownSpells(Character character, List<Spelllist> allSpelllist, List<Spell> allSpells);

  /**
   * Create a new known spell for the character.
   *
   * @param character
   *     The character to create the know spell for.
   * @param knownSpell
   *     The known spell to create.
   *
   * @return The new created known spell.
   */
  public KnownSpell createKnownSpell(Character character, KnownSpell knownSpell);

  /**
   * Delete the known spell from all characters. Use if a spell is deleted from the game system.
   *
   * @param knownSpell
   *     The known spell to delete.
   */
  public void deleteKnownSpell(KnownSpell knownSpell);

  /**
   * Delete all KnownSpells of a character.
   *
   * @param character
   */
  public void deleteKnownSpells(Character character);

  /**
   * Returns the spell slots of the character.
   *
   * @param character
   *     The character t get the spell slots of.
   * @param allSpells
   *     All spells of the game system.
   * @param allAbilities
   *     All abilities of the game system.
   * @param allFeats
   *     All feats of the game system.
   *
   * @return The spell slots of the character.
   */
  public List<SpellSlot> getSpellSlots(Character character, List<Spell> allSpells, final List<Ability> allAbilities,
      List<Feat> allFeats);

  /**
   * Update the given spell slot.
   *
   * @param spellSlot
   *     The spell slot to update.
   */
  public void updateSpellSlot(SpellSlot spellSlot);

  /**
   * Create spell slot for character.
   *
   * @param character
   *     The character to create the spell slot for.
   * @param spellSlot
   *     The spell slot to create.
   *
   * @return The new created spell slot.
   */
  public SpellSlot createSpellSlot(Character character, SpellSlot spellSlot);

  /**
   * Delete the given spell slot.
   *
   * @param spellSlot
   *     The spell slot to delete.
   */
  public void deleteSpellSlot(SpellSlot spellSlot);

  /**
   * Delete all spell slots of the character.
   *
   * @param character
   *     The character to delete the spell slots of.
   */
  public void deleteSpellSlots(Character character);

  /**
   * Delete known spells of a spell list. Use if a spell is deleted from a spell list.
   *
   * @param spelllist
   *     The spell list to delete the known spells of.
   * @param spell
   *     The spell to delete from the known spells of.
   */
  public void deleteKnownSpells(Spelllist spelllist, Spell spell);

  /**
   * Delete the spell slots of a spell list and spell. Use if a spell is deleted from aa spell list.
   *
   * @param spelllist
   *     The spell list to delete the spell slots of.
   * @param spell
   *     The spll to delete the spell slots of.
   */
  public void deleteSpellSlots(Spelllist spelllist, Spell spell);

  /**
   * Update the skill of a character.
   *
   * @param character
   *     The character to update the skill of.
   * @param characterSkill
   *     The skill to update.
   */
  public void updateCharacterSkill(Character character, CharacterSkill characterSkill);

}
