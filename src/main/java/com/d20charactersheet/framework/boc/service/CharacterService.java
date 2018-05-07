package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Body;
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
 * Provides methods to administer characters.
 */
public interface CharacterService {

  /**
   * Returns list of all available characters.
   *
   * @param allCharacterClasses
   *     All character classes of the game system.
   * @param allRaces
   *     All races of the game system.
   * @param allAbilities
   *     All abilites of the game system.
   * @param allSkills
   *     All skills of the game system.
   * @param allFeats
   *     All feats of the game system.
   * @param allWeapons
   *     All weapons of the game system.
   * @param allArmor
   *     All armor of the game system.
   * @param allGoods
   *     All goods of the game system.
   * @param allSpells
   *     All spells of the game system.
   * @param allXpTables
   *     All XpTables of the game system.
   *
   * @return List of all available characters.
   */
  public List<Character> getAllCharacters(List<CharacterClass> allCharacterClasses, List<Race> allRaces, List<Ability> allAbilities,
      List<Skill> allSkills, List<Feat> allFeats, List<Weapon> allWeapons, List<Armor> allArmor, List<Good> allGoods,
      List<Spell> allSpells, List<XpTable> allXpTables);

  /**
   * Returns the character of the given id.
   *
   * @param id
   *     The id of the character.
   * @param allCharacterClasses
   *     All character classes of the game system.
   * @param allRaces
   *     All races of the game system.
   * @param allAbilities
   *     All abilities of the game system
   * @param allSkills
   *     All skills of the game sytem.
   * @param allFeats
   *     All feats of the game sytem.
   * @param allWeapons
   *     All weapons of the game sytem.
   * @param allArmor
   *     All armor of the game sytem.
   * @param allGoods
   *     All goods of the game sytem.
   * @param allSpells
   *     All spells of the game system.
   * @param allXpTables
   *     All XpTables of the game system.
   *
   * @return The character of the given id.
   */
  public Character getCharacter(int id, List<CharacterClass> allCharacterClasses, List<Race> allRaces, List<Ability> allAbilities,
      List<Skill> allSkills, List<Feat> allFeats, List<Weapon> allWeapons, List<Armor> allArmor, List<Good> allGoods,
      List<Spell> allSpells, List<XpTable> allXpTables);

  /**
   * Update the character to the persistent layer.
   *
   * @param character
   *     The character to update.
   *
   * @return The updated character.
   */
  public Character updateCharacter(Character character);

  /**
   * Creates a new character with the given arguments and stores it in the persistent layer.
   *
   * @param character
   *     The character to create.
   * @param allSkills
   *     All skills of the game system.
   *
   * @return The new created character with valid id.
   */
  public Character createCharacter(Character character, List<Skill> allSkills);

  /**
   * Delete the character. Images are <b>not</b> deleted!
   *
   * @param character
   *     The character to delete.
   */
  public void deleteCharacter(Character character);

  /**
   * Save feats of character to persistent layer.
   *
   * @param character
   *     The character with the feats to save.
   */
  public void updateFeats(Character character);

  /**
   * Returns the feats of the character.
   *
   * @param character
   *     The character to retrieve the feats of.
   * @param allFeats
   *     All feats of the game system.
   *
   * @return The feats of the character.
   */
  public List<CharacterFeat> getCharacterFeats(Character character, List<Feat> allFeats);

  /**
   * Delete the feats of the character.
   *
   * @param character
   *     The character to delete its feats.
   */
  public void deleteCharacterFeats(Character character);

  /**
   * Update the feats of the character.
   *
   * @param character
   *     The character to update its feats.
   */
  public void updateCharacterFeats(Character character);

  /**
   * Returns the skills of the character.
   *
   * @param character
   *     The Character to retrieve its skills.
   * @param allSkills
   *     All skills of the game system.
   *
   * @return The skills of the character.
   */
  public List<CharacterSkill> getCharacterSkills(Character character, List<Skill> allSkills);

  /**
   * Delete the skills of the character.
   *
   * @param character
   *     The character to delete its skills.
   */
  public void deleteCharacterSkills(Character character);

  /**
   * Updates the goods of the character.
   *
   * @param character
   *     The character to update.
   * @param goods
   *     The goods to update.
   */
  public void updateGoods(Character character, List<ItemGroup> goods);

  /**
   * Updates the weapons of the character.
   *
   * @param character
   *     The character to update.
   * @param weapons
   *     The weapons to update.
   */
  public void updateWeapons(Character character, List<ItemGroup> weapons);

  /**
   * Updates the armor of the character.
   *
   * @param character
   *     The character to update.
   * @param armor
   *     The armor to update.
   */
  public void updateArmor(Character character, List<ItemGroup> armor);

  /**
   * Returns the weapons of the character.
   *
   * @param character
   *     The character to get the weapons of.
   * @param allWeapons
   *     All weapons of the game system.
   *
   * @return The weapons of the character.
   */
  public List<ItemGroup> getWeapons(Character character, List<Weapon> allWeapons);

  /**
   * Returns the armor of the character.
   *
   * @param character
   *     The character to get the weapons of.
   * @param allArmor
   *     All armor of the game system.
   *
   * @return The armor of the character.
   */
  public List<ItemGroup> getArmor(Character character, List<Armor> allArmor);

  /**
   * Returns the goods of the character.
   *
   * @param character
   *     The charact to get the goods of.
   * @param allGoods
   *     All goods of the game system.
   *
   * @return The goods of the character.
   */
  public List<ItemGroup> getGoods(Character character, List<Good> allGoods);

  /**
   * Delete the skill from all characters.
   *
   * @param skill
   *     The skill to delete.
   */
  public void deleteSkill(Skill skill);

  /**
   * Delete the feat from all characters.
   *
   * @param feat
   *     The feat to delete.
   */
  public void deleteFeat(Feat feat);

  /**
   * Creates a note belonging to the character.
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
   * Updates a note belonging to the character.
   *
   * @param note
   *     The note to update.
   * @param character
   *     The character the note belongs to.
   */
  public void updateNote(Note note, Character character);

  /**
   * Deletes a note from a character.
   *
   * @param note
   *     The note to delete.
   * @param character
   *     The character to delete the note from.
   */
  public void deleteNote(Note note, Character character);

  /**
   * Updates a CharacterAbility
   *
   * @param characterAbility
   *     The CharacterAbility to update.
   */
  public void updateCharacterAbility(CharacterAbility characterAbility);

  /**
   * Creates a new class level for the character.
   *
   * @param character
   *     The character to create the class level for.
   * @param classLevel
   *     The class level to create.
   *
   * @return The created class level
   */
  public ClassLevel createClassLevel(Character character, ClassLevel classLevel);

  /**
   * Updates the given class level.
   *
   * @param classLevel
   *     The class level to update.
   */
  public void updateClassLevel(ClassLevel classLevel);

  /**
   * Deletes the given class level.
   *
   * @param classLevel
   *     The class level to delete.
   */
  public void deleteClassLevel(ClassLevel classLevel);

  /**
   * Deletes ClassAbilities from all characters.
   *
   * @param characterClass
   *     The class the abilities belong to.
   * @param classAbilities
   *     The class abilities to delete.
   */
  public void deleteCharacterAbilities(CharacterClass characterClass, List<ClassAbility> classAbilities);

  /**
   * Assigns WeaponAttack to character and creates it in the persistent layer.
   *
   * @param character
   *     The character to assign the WeaponAttack to.
   * @param weaponAttack
   *     The WeaponAttack to assign and create.
   *
   * @return The created WeaponAttack.
   */
  public WeaponAttack createWeaponAttack(Character character, WeaponAttack weaponAttack);

  /**
   * Updates the given WeaponAttack in the persistent layer.
   *
   * @param weaponAttack
   *     The WeaponAttack to update.
   */
  public void updateWeaponAttack(WeaponAttack weaponAttack);

  /**
   * Deletes a weapon attack from a character.
   *
   * @param character
   *     The Character to delete the weapon attack from.
   * @param weaponAttack
   *     The WeaponAttack to delete.
   */
  public void deleteWeaponAttack(Character character, WeaponAttack weaponAttack);

  /**
   * Create known spell for character.
   *
   * @param character
   *     The character to create known spell to.
   * @param knownSpell
   *     The known spell to create.
   *
   * @return The created known spell.
   */
  public KnownSpell createKnownSpell(Character character, KnownSpell knownSpell);

  /**
   * Delete known spell from character.
   *
   * @param character
   *     The character to delete the known spell of.
   * @param knownSpell
   *     The known spell to delete.
   */
  public void deleteKnownSpell(Character character, KnownSpell knownSpell);

  /**
   * Find character by id.
   *
   * @param characterId
   *     The id of the character.
   * @param allCharacters
   *     The characters to search.
   *
   * @return The character with the given id.
   */
  public Character findCharacterById(int characterId, List<Character> allCharacters);

  /**
   * Find character by name.
   *
   * @param name
   *     The name of the character.
   * @param allCharacters
   *     The characters to search.
   *
   * @return The character with the given name.
   */
  public Character findCharacterByName(String name, List<Character> allCharacters);

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
   *     The character to create spell slot for.
   * @param spellSlot
   *     The spell slot to create.
   *
   * @return The created spell slot.
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
   * Update the spell slots of the character.
   *
   * @param character
   *     The character to update the spell slots of.
   * @param spellSlots
   *     The spell slots to update.
   */
  public void updateSpellSlots(Character character, List<SpellSlot> spellSlots);

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

  /**
   * Create the body of a character.
   *
   * @param character
   *     The character to create the body of.
   * @param body
   *     The body to create.
   *
   * @return The created body.
   */
  public Body createBody(Character character, Body body);

  /**
   * Deletes the body of a character
   *
   * @param character
   *     The character to delete the body of.
   */
  public void deleteBody(Character character);

  /**
   * Updates the body of a character.
   *
   * @param character
   *     The character to update the body of.
   *
   * @return The updated body.
   */
  public Body updateBody(Character character);
}
