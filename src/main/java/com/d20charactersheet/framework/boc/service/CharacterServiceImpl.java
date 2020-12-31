package com.d20charactersheet.framework.boc.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Body;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Equipment;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.HumanoidBody;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.RuleError;
import com.d20charactersheet.framework.boc.model.RuleException;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.CharacterDao;

/**
 * Implementation of the CharacterService interface.
 */
public class CharacterServiceImpl implements CharacterService {

  private final CharacterDao characterDao;

  /**
   * Creates CharacterService with the given data access object.
   *
   * @param characterDao
   *     Access data of persistent layer.
   */
  public CharacterServiceImpl(final CharacterDao characterDao) {
    this.characterDao = characterDao;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterService#getAllCharacters(java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List)
   */
  @Override
  public List<Character> getAllCharacters(final List<CharacterClass> allCharacterClasses, final List<Race> allRaces,
      final List<Ability> allAbilities, final List<Skill> allSkills, final List<Feat> allFeats, final List<Weapon> allWeapons,
      final List<Armor> allArmor, final List<Good> allGoods, final List<Spell> allSpells, final List<XpTable> allXpTables) {
    final List<Character> allCharacters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables);
    for (final Character character : allCharacters) {
      fillCharacter(character, allAbilities, allSkills, allFeats, allWeapons, allArmor, allGoods, allSpells);
    }
    return allCharacters;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterService#getCharacter(int, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List)
   */
  @Override
  public Character getCharacter(final int id, final List<CharacterClass> allCharacterClasses, final List<Race> allRaces,
      final List<Ability> allAbilities, final List<Skill> allSkills, final List<Feat> allFeats, final List<Weapon> allWeapons,
      final List<Armor> allArmor, final List<Good> allGoods, final List<Spell> allSpells, final List<XpTable> allXpTables) {
    final Character character = characterDao.getCharacter(id, allCharacterClasses, allRaces, allXpTables);
    fillCharacter(character, allAbilities, allSkills, allFeats, allWeapons, allArmor, allGoods, allSpells);
    return character;
  }

  private void fillCharacter(final Character character, final List<Ability> allAbilities, final List<Skill> allSkills,
      final List<Feat> allFeats, final List<Weapon> allWeapons, final List<Armor> allArmor, final List<Good> allGoods,
      final List<Spell> allSpells) {
    fillClassLevel(character);
    fillSkills(character, allSkills);
    fillFeats(character, allFeats);
    fillEquipment(character, allWeapons, allArmor, allGoods);
    fillNotes(character);
    fillWeaponAttacks(character, allWeapons);
    fillKnownSpells(character, allSpells);
    fillSpellSlots(character, allSpells, allAbilities, allFeats);
    fillBodyParts(character, allWeapons, allArmor, allGoods);
  }

  private void fillClassLevel(final Character character) {

    // load character abilities from persistent layer
    List<CharacterAbility> characterAbilities;
    for (final ClassLevel classLevel : character.getClassLevels()) {
      final CharacterClass characterClass = classLevel.getCharacterClass();
      characterAbilities = characterDao.getCharacterAbilities(character, characterClass);
      characterAbilities = removeCharacterAbilities(characterAbilities, characterClass);
      addCharacterAbilities(characterAbilities, characterClass, character);
      classLevel.setCharacterAbilities(characterAbilities);
    }
  }

  List<CharacterAbility> removeCharacterAbilities(final List<CharacterAbility> characterAbilities,
      final CharacterClass characterClass) {
    final List<CharacterAbility> remainingCharacterAbilities = new ArrayList<>(characterAbilities.size());
    for (final CharacterAbility characterAbility : characterAbilities) {
      if (contains(characterAbility, characterClass.getClassAbilities())) {
        remainingCharacterAbilities.add(characterAbility);
      } else {
        characterDao.deleteCharacterAbility(characterAbility);
      }
    }
    return remainingCharacterAbilities;

  }

  private boolean contains(final CharacterAbility characterAbility, final List<ClassAbility> classAbilities) {
    for (final ClassAbility classAbility : classAbilities) {
      if (classAbility.getAbility().getId() == characterAbility.getClassAbility().getAbility().getId()) {
        return true;
      }
    }
    return false;
  }

  void addCharacterAbilities(final List<CharacterAbility> characterAbilities, final CharacterClass characterClass,
      final Character character) {
    for (final ClassAbility classAbility : characterClass.getClassAbilities()) {
      if (!contains(classAbility, characterAbilities)) {
        final CharacterAbility characterAbility = new CharacterAbility();
        characterAbility.setClassAbility(classAbility);
        characterAbility.setOwned(true);
        characterDao.createCharacterAbility(character, characterClass, characterAbility);
        characterAbilities.add(characterAbility);
      }
    }
  }

  private boolean contains(final ClassAbility classAbility, final List<CharacterAbility> characterAbilities) {
    for (final CharacterAbility characterAbility : characterAbilities) {
      if (characterAbility.getClassAbility().getAbility().getId() == classAbility.getAbility().getId()) {
        return true;
      }
    }
    return false;
  }

  private void fillSkills(final Character character, final List<Skill> allSkills) {
    final List<CharacterSkill> characterSkills = characterDao.getCharacterSkills(character, allSkills);
    for (final Skill skill : allSkills) {
      if (!contains(characterSkills, skill)) {
        characterSkills.add(characterDao.newCharacterSkill(skill));
      }
    }
    character.setCharacterSkills(characterSkills);
  }

  private boolean contains(final List<CharacterSkill> characterSkills, final Skill skill) {
    for (final CharacterSkill characterSkill : characterSkills) {
      if (characterSkill.getSkill().equals(skill)) {
        return true;
      }
    }
    return false;
  }

  private void fillFeats(final Character character, final List<Feat> allFeats) {
    character.setCharacterFeats(characterDao.getCharacterFeats(character, allFeats));
  }

  private void fillEquipment(final Character character, final List<Weapon> allWeapons, final List<Armor> allArmor,
      final List<Good> allGoods) {
    final Equipment equipment = new Equipment();
    equipment.setWeapons(characterDao.getWeapons(character, allWeapons));
    equipment.setArmor(characterDao.getArmor(character, allArmor));
    equipment.setGoods(characterDao.getGoods(character, allGoods));
    character.setEquipment(equipment);
  }

  private void fillKnownSpells(final Character character, final List<Spell> allSpells) {
    final List<Spelllist> spelllists = character.getSpelllists();
    final List<KnownSpell> daoKnownSpells = characterDao.getKnownSpells(character, spelllists, allSpells);
    final List<KnownSpell> knownSpells = new ArrayList<>(daoKnownSpells.size());
    for (final KnownSpell knownSpell : daoKnownSpells) {
      if (knownSpell.getSpelllist() == null) {
        deleteKnownSpell(character, knownSpell);
      } else {
        knownSpells.add(knownSpell);
      }
    }
    character.setKnownSpells(knownSpells);
  }

  private void fillSpellSlots(final Character character, final List<Spell> allSpells, final List<Ability> allAbilities,
      final List<Feat> allFeats) {
    character.setSpellSlots(characterDao.getSpellSlots(character, allSpells, allAbilities, allFeats));
  }

  private void fillBodyParts(Character character, final List<Weapon> allWeapons, final List<Armor> allArmor,
      final List<Good> allGoods) {
    character.setBody(characterDao.getBody(character, allWeapons, allArmor, allGoods));
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterService#updateCharacter(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public Character updateCharacter(final Character character) {
    return characterDao.updateCharacter(character);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterService#createCharacter(com.d20charactersheet.framework.boc.model.Character, java.util.List)
   */
  @Override
  public Character createCharacter(final Character character, final List<Skill> allSkills) {
    checkArguments(character.getName(), character.getPlayer(), character.getRace(), character.getSex(), character.getClassLevels(),
                   character.getAlignment());

    character.setImageId(ImageService.DEFAULT_CHARACTER_IMAGE_ID);
    character.setThumbImageId(ImageService.DEFAULT_THUMB_IMAGE_ID);
    fillSkills(character, allSkills);
    characterDao.createCharacter(character);
    return character;
  }

  private void checkArguments(final String name, final String player, final Race race, final Sex sex,
      final List<ClassLevel> classLevels, final Alignment alignment) {
    if (name == null) {
      throw new IllegalArgumentException("name is null");
    }
    if ("".equals(name.trim())) {
      throw new IllegalArgumentException("name is empty");
    }
    if (player == null) {
      throw new IllegalArgumentException("player is null");
    }
    if ("".equals(player.trim())) {
      throw new IllegalArgumentException("player is empty");
    }
    if (race == null) {
      throw new IllegalArgumentException("race is null");
    }
    if (sex == null) {
      throw new IllegalArgumentException("sex is null");
    }
    if (classLevels == null) {
      throw new IllegalArgumentException("classLevel is null");
    }
    if (classLevels.isEmpty()) {
      throw new IllegalArgumentException("classLevel is empty");
    }
    if (alignment == null) {
      throw new IllegalArgumentException("alignment is null");
    }
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterService#deleteCharacter(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public void deleteCharacter(final Character character) {
    characterDao.deleteWeaponAttacks(character);
    characterDao.deleteNotes(character);
    characterDao.deleteWeapons(character);
    characterDao.deleteArmor(character);
    characterDao.deleteGoods(character);
    characterDao.deleteCharacterSkills(character);
    characterDao.deleteCharacterFeats(character);
    characterDao.deleteCharacterAbilities(character);
    characterDao.deleteKnownSpells(character);
    characterDao.deleteSpellSlots(character);
    characterDao.deleteBody(character);
    characterDao.deleteCharacter(character);
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.CharacterService#updateFeats(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public void updateFeats(final Character character) {
    characterDao.updateCharacterFeats(character);
  }

  @Override
  public List<CharacterFeat> getCharacterFeats(final Character character, final List<Feat> allFeats) {
    return characterDao.getCharacterFeats(character, allFeats);
  }

  @Override
  public void deleteCharacterFeats(final Character character) {
    characterDao.deleteCharacterFeats(character);
  }

  @Override
  public void updateCharacterFeats(final Character character) {
    characterDao.updateCharacterFeats(character);
  }

  @Override
  public List<CharacterSkill> getCharacterSkills(final Character character, final List<Skill> allSkills) {
    return characterDao.getCharacterSkills(character, allSkills);
  }

  @Override
  public void deleteCharacterSkills(final Character character) {
    characterDao.deleteCharacterSkills(character);
  }

  @Override
  public void updateWeapons(final Character character, final List<ItemGroup> weapons) {
    final List<ItemGroup> updatedWeapons = characterDao.updateWeapons(character, weapons);
    character.getEquipment().setWeapons(updatedWeapons);
  }

  @Override
  public void updateArmor(final Character character, final List<ItemGroup> armor) {
    final List<ItemGroup> updatedArmor = characterDao.updateArmor(character, armor);
    character.getEquipment().setArmor(updatedArmor);
  }

  @Override
  public void updateGoods(final Character character, final List<ItemGroup> goods) {
    final List<ItemGroup> updatedGoods = characterDao.updateGoods(character, goods);
    character.getEquipment().setGoods(updatedGoods);
  }

  @Override
  public List<ItemGroup> getWeapons(final Character character, final List<Weapon> allWeapons) {
    return characterDao.getWeapons(character, allWeapons);
  }

  @Override
  public List<ItemGroup> getArmor(final Character character, final List<Armor> allArmor) {
    return characterDao.getArmor(character, allArmor);
  }

  @Override
  public List<ItemGroup> getGoods(final Character character, final List<Good> allGoods) {
    return characterDao.getGoods(character, allGoods);
  }

  @Override
  public void deleteSkill(final Skill skill) {
    characterDao.deleteSkill(skill);
  }

  @Override
  public void deleteFeat(final Feat feat) {
    characterDao.deleteFeat(feat);
  }

  private void fillNotes(final Character character) {
    character.setNotes(characterDao.getNotes(character));
  }

  private void fillWeaponAttacks(final Character character, final List<Weapon> allWeapons) {
    final List<WeaponAttack> weaponAttacks = characterDao.getWeaponAttacks(character, allWeapons);
    character.setWeaponAttacks(weaponAttacks);
  }

  @Override
  public Note createNote(final Note note, final Character character) {
    final Note newNote = characterDao.createNote(note, character);
    character.getNotes().add(newNote);
    return newNote;
  }

  @Override
  public void updateNote(final Note note, final Character character) {
    characterDao.updateNote(note, character);
    for (final Note characterNote : character.getNotes()) {
      if (note.equals(characterNote)) {
        characterNote.setDate(note.getDate());
        characterNote.setText(note.getText());
        break;
      }
    }
  }

  @Override
  public void deleteNote(final Note note, final Character character) {
    characterDao.deleteNote(note);
    final List<Note> notes = new ArrayList<>();
    for (final Note currentNote : character.getNotes()) {
      if (currentNote.getId() != note.getId()) {
        notes.add(currentNote);
      }
    }
    character.setNotes(notes);
  }

  @Override
  public void updateCharacterAbility(final CharacterAbility characterAbility) {
    characterDao.updateCharacterAbility(characterAbility);
  }

  @Override
  public ClassLevel createClassLevel(final Character character, final ClassLevel classLevel) {
    return characterDao.createClassLevel(character, classLevel);
  }

  @Override
  public void updateClassLevel(final ClassLevel classLevel) {
    characterDao.updateClassLevel(classLevel);
  }

  @Override
  public void deleteClassLevel(final ClassLevel classLevel) {
    characterDao.deleteClassLevel(classLevel);
  }

  @Override
  public void deleteCharacterAbilities(final CharacterClass characterClass, final List<ClassAbility> classAbilities) {
    characterDao.deleteCharacterAbilities(characterClass, classAbilities);
  }

  @Override
  public void updateWeaponAttack(final WeaponAttack weaponAttack) {
    characterDao.updateWeaponAttack(weaponAttack);

  }

  @Override
  public WeaponAttack createWeaponAttack(final Character character, final WeaponAttack weaponAttack) {
    final WeaponAttack newWeaponAttack = characterDao.createWeaponAttack(character, weaponAttack);
    character.getWeaponAttacks().add(newWeaponAttack);
    return newWeaponAttack;
  }

  @Override
  public void deleteWeaponAttack(final Character character, final WeaponAttack weaponAttack) {
    final List<WeaponAttack> weaponAttacks = new ArrayList<>(character.getWeaponAttacks()
                                                                 .size() - 1);
    for (final WeaponAttack currentWeaponAttack : character.getWeaponAttacks()) {
      if (currentWeaponAttack.equals(weaponAttack)) {
        continue;
      }
      weaponAttacks.add(currentWeaponAttack);
    }
    character.setWeaponAttacks(weaponAttacks);
    characterDao.deleteWeaponAttack(weaponAttack);
  }

  @Override
  public void createKnownSpell(final Character character, final KnownSpell knownSpell) {
    final KnownSpell newKnownSpell = characterDao.createKnownSpell(character, knownSpell);
    character.getKnownSpells().add(newKnownSpell);
  }

  @Override
  public void deleteKnownSpell(final Character character, final KnownSpell knownSpell) {
    characterDao.deleteKnownSpell(knownSpell);
    character.getKnownSpells().remove(knownSpell);
  }

  @Override
  public Character findCharacterById(final int characterId, final List<Character> allCharacters) {
    for (final Character character : allCharacters) {
      if (character.getId() == characterId) {
        return character;
      }
    }
    throw new IllegalArgumentException("Can't find character with id: " + characterId);
  }

  @Override
  public Character findCharacterByName(final String name, final List<Character> allCharacters) {
    for (final Character character : allCharacters) {
      if (character.getName().equals(name)) {
        return character;
      }
    }
    throw new IllegalArgumentException("Can't find character with name: " + name);
  }

  @Override
  public void updateSpellSlot(final SpellSlot spellSlot) {
    characterDao.updateSpellSlot(spellSlot);
  }

  @Override
  public SpellSlot createSpellSlot(final Character character, final SpellSlot spellSlot) {
    final SpellSlot newSpellSlot = characterDao.createSpellSlot(character, spellSlot);
    character.getSpellSlots().add(newSpellSlot);
    return newSpellSlot;
  }

  @Override
  public void deleteSpellSlot(final SpellSlot spellSlot) {
    characterDao.deleteSpellSlot(spellSlot);
  }

  @Override
  public void updateSpellSlots(final Character character, final List<SpellSlot> newSpellSlots) {
    final List<SpellSlot> oldSpellSlots = new LinkedList<>(character.getSpellSlots());

    // create new spell slots
    for (final SpellSlot spellSlot : newSpellSlots) {
      if (spellSlot.getId() == SpellSlot.NEW_ID) {
        createSpellSlot(character, spellSlot);
      }
    }

    // delete obsolete spell slots
    oldSpellSlots.removeAll(newSpellSlots);
    for (final SpellSlot spellSlot : oldSpellSlots) {
      deleteSpellSlot(spellSlot);
    }
    character.setSpellSlots(newSpellSlots);
  }

  @Override
  public void deleteKnownSpells(final Spelllist spelllist, final Spell spell) {
    characterDao.deleteKnownSpells(spelllist, spell);
  }

  @Override
  public void deleteSpellSlots(final Spelllist spelllist, final Spell spell) {
    characterDao.deleteSpellSlots(spelllist, spell);
  }

  @Override
  public void updateCharacterSkill(final Character character, final CharacterSkill characterSkill) {
    if (characterSkill.getRank() < 0) {
      throw new RuleException(RuleError.NEGATIVE_SKILL_RANK);
    }
    characterDao.updateCharacterSkill(character, characterSkill);
  }

  @Override
  public Body createBody(Character character, Body body) {
    Body newBody = characterDao.createBody(character, body);
    character.setBody(newBody);
    return newBody;
  }

  @Override
  public void deleteBody(Character character) {
    characterDao.deleteBody(character);
    character.setBody(new HumanoidBody());
  }

  @Override
  public Body updateBody(Character character) {
    characterDao.updateBody(character);
    return character.getBody();
  }

}
