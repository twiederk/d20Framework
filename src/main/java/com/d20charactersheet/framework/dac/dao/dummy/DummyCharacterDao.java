package com.d20charactersheet.framework.dac.dao.dummy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.androidash.memorydb.DaoUtil;
import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Body;
import com.d20charactersheet.framework.boc.model.BodyPart;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.FeatType;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.HumanoidBody;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Money;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.dac.dao.CharacterDao;

/**
 * Dummy implementation of CharacterDao. Creates a in memory data model to simulate the persistent data.
 */
public class DummyCharacterDao implements CharacterDao {

  private final DataTable characterTable;
  private final DataTable characterClassLevelTable;
  private final DataTable characterAbilityTable;
  private final DataTable characterSkillTable;
  private final DataTable characterFeatTable;
  private final DataTable characterWeaponTable;
  private final DataTable characterArmorTable;
  private final DataTable characterGoodTable;
  private final DataTable characterNoteTable;
  private final DataTable characterWeaponAttackTable;
  private DataTable characterKnownSpellTable;
  private final DataTable characterSpellSlotTable;
  private final DataTable characterSpellSlotAbilityTable;
  private final DataTable characterSpellSlotFeatTable;
  private final DataTable characterBodyPartTable;

  private final DummyItemDaoHelper helper;

  private final DaoUtil daoUtil;

  /**
   * Creates in memory table of characters. The tables are filled with two characters Belvador the Summoner and Nascan
   * Blackskin.
   *
   * @param character
   *     Character raw data.
   * @param classLevel
   *     Class level raw data.
   * @param characterAbility
   *     Character ability raw data.
   * @param characterSkill
   *     Character skill raw data.
   * @param characterFeat
   *     Character feat raw data.
   * @param characterWeapon
   *     Character weapon raw data.
   * @param characterArmor
   *     Character armor raw data.
   * @param characterGood
   *     Character good raw data.
   * @param characterNote
   *     Character note raw data.
   * @param characterAttack
   *     Character attack raw data.
   * @param characterKnownSpell
   *     Character spell raw data.
   * @param characterSpellSlot
   *     Character spell slot raw data.
   * @param characterSpellSlotAbility
   *     Character spell slot ability raw data.
   * @param characterSpellSlotFeat
   *     Character spell slot feat raw data.
   * @param characterBodyPart
   *     Character body part raw data.
   */
  public DummyCharacterDao(final Object[][] character, final Object[][] classLevel, final Object[][] characterAbility,
      final Object[][] characterSkill, final Object[][] characterFeat, final Object[][] characterWeapon,
      final Object[][] characterArmor, final Object[][] characterGood, final Object[][] characterNote,
      final Object[][] characterAttack, final Object[][] characterKnownSpell, final Object[][] characterSpellSlot,
      final Object[][] characterSpellSlotAbility, final Object[][] characterSpellSlotFeat, final Object[][] characterBodyPart) {
    characterTable = new DataTable(character);
    characterClassLevelTable = new DataTable(classLevel);
    characterAbilityTable = new DataTable(characterAbility);
    characterSkillTable = new DataTable(characterSkill);
    characterFeatTable = new DataTable(characterFeat);
    characterWeaponTable = new DataTable(characterWeapon);
    characterArmorTable = new DataTable(characterArmor);
    characterGoodTable = new DataTable(characterGood);
    characterNoteTable = new DataTable(characterNote);
    characterWeaponAttackTable = new DataTable(characterAttack);
    characterKnownSpellTable = new DataTable(characterKnownSpell);
    characterSpellSlotTable = new DataTable(characterSpellSlot);
    characterSpellSlotAbilityTable = new DataTable(characterSpellSlotAbility);
    characterSpellSlotFeatTable = new DataTable(characterSpellSlotFeat);
    characterBodyPartTable = new DataTable(characterBodyPart);

    helper = new DummyItemDaoHelper(characterWeaponTable, characterArmorTable, characterGoodTable);

    daoUtil = new DaoUtil();
  }

  @Override
  public List<Character> getAllCharacters(final List<CharacterClass> allCharacterClasses, final List<Race> allRaces,
      final List<XpTable> allXpTables) {
    return selectAllCharacters(allCharacterClasses, allRaces, allXpTables);
  }

  private List<Character> selectAllCharacters(final List<CharacterClass> allCharacterClasses, final List<Race> allRaces,
      final List<XpTable> allXpTables) {
    final List<Character> allCharacters = new ArrayList<>(characterTable.getNumberOfRows());
    for (final DataRow characterTableRow : characterTable) {
      final Character character = selectCharacter(characterTableRow, allCharacterClasses, allRaces, allXpTables);
      allCharacters.add(character);
    }
    return allCharacters;
  }

  private Character selectCharacter(final DataRow characterTableRow, final List<CharacterClass> allCharacterClasses,
      final List<Race> allRaces, final List<XpTable> allXpTables) {

    final Character character = new Character();
    character.setId(characterTableRow.getId());
    setAppearance(character, characterTableRow, allXpTables);
    setClassLevels(character, allCharacterClasses);
    setRace(character, characterTableRow, allRaces);
    setAttributes(character, characterTableRow);
    setCombat(character, characterTableRow);
    setSaves(character, characterTableRow);
    setImages(character, characterTableRow);
    setMoney(character, characterTableRow);
    return character;
  }

  private void setAppearance(final Character character, final DataRow characterTableRow, final List<XpTable> allXpTables) {
    character.setPlayer(characterTableRow.getString(1));
    character.setName(characterTableRow.getString(2));
    character.setSex((Sex) daoUtil.getEnum(characterTableRow.getInt(4), Sex.values()));
    character.setAlignment((Alignment) daoUtil.getEnum(characterTableRow.getInt(5), Alignment.values()));
    character.setXpTable(getXpTableById(characterTableRow.getInt(6), allXpTables));
    character.setExperiencePoints(characterTableRow.getInt(7));
  }

  private XpTable getXpTableById(final int xpTableId, final List<XpTable> allXpTables) {
    for (final XpTable xpTable : allXpTables) {
      if (xpTable.getId() == xpTableId) {
        return xpTable;
      }
    }
    throw new IllegalArgumentException("Can't find XpTable with id: " + xpTableId);
  }

  private void setClassLevels(final Character character, final List<CharacterClass> allClasses) {
    final List<ClassLevel> characterClasses = new ArrayList<>();
    final List<DataRow> dataRows = characterClassLevelTable.select(1, character.getId());
    for (final DataRow classLevelRow : dataRows) {
      final ClassLevel classLevel = selectClassLevel(classLevelRow, allClasses);
      characterClasses.add(classLevel);
    }
    character.setClassLevels(characterClasses);
  }

  private ClassLevel selectClassLevel(final DataRow characterClassLevelRow, final List<CharacterClass> allCharacterClasses) {
    final CharacterClass characterClass = getCharacterClass((Integer) characterClassLevelRow.get(2), allCharacterClasses);
    final ClassLevel classLevel = new ClassLevel(characterClass);
    classLevel.setId(characterClassLevelRow.getId());
    classLevel.setLevel(characterClassLevelRow.getInt(3));
    return classLevel;
  }

  private CharacterClass getCharacterClass(final int characterClassId, final List<CharacterClass> allCharacterClasses) {
    for (final CharacterClass characterClass : allCharacterClasses) {
      if (characterClassId == characterClass.getId()) {
        return characterClass;
      }
    }
    throw new IllegalArgumentException("Can't get character class of id: " + characterClassId);
  }

  private void setRace(final Character character, final DataRow characterTableRow, final List<Race> allRaces) {
    final int raceId = (Integer) characterTableRow.get(3);
    for (final Race race : allRaces) {
      if (race.getId() == raceId) {
        character.setRace(race);
        return;
      }
    }
    throw new IllegalArgumentException("Can't get race of id: " + raceId);
  }

  private void setAttributes(final Character character, final DataRow characterTableRow) {
    character.setStrength((Integer) characterTableRow.get(8));
    character.setDexterity((Integer) characterTableRow.get(9));
    character.setConstitution((Integer) characterTableRow.get(10));
    character.setIntelligence((Integer) characterTableRow.get(11));
    character.setWisdom((Integer) characterTableRow.get(12));
    character.setCharisma((Integer) characterTableRow.get(13));
  }

  private void setCombat(final Character character, final DataRow characterTableRow) {
    character.setHitPoints((Integer) characterTableRow.get(14));
    character.setMaxHitPoints((Integer) characterTableRow.get(15));
    character.setArmorClass((Integer) characterTableRow.get(16));
    character.setInitiativeModifier((Integer) characterTableRow.get(17));
    character.setCmbModifier((Integer) characterTableRow.get(18));
    character.setCmdModifier((Integer) characterTableRow.get(19));
  }

  private void setSaves(final Character character, final DataRow characterTableRow) {
    character.setFortitudeModifier((Integer) characterTableRow.get(20));
    character.setReflexModifier((Integer) characterTableRow.get(21));
    character.setWillModifier((Integer) characterTableRow.get(22));
  }

  private void setImages(final Character character, final DataRow characterTableRow) {
    character.setImageId((Integer) characterTableRow.get(23));
    character.setThumbImageId((Integer) characterTableRow.get(24));
  }

  private void setMoney(final Character character, final DataRow characterTableRow) {
    final Money characterMoney = new Money();
    characterMoney.setPlatinum((Integer) characterTableRow.get(25));
    characterMoney.setGold((Integer) characterTableRow.get(26));
    characterMoney.setSilver((Integer) characterTableRow.get(27));
    characterMoney.setCopper((Integer) characterTableRow.get(28));
    character.setMoney(characterMoney);
  }

  @Override
  public Character getCharacter(final int characterId, final List<CharacterClass> allCharacterClasses, final List<Race> allRaces,
      final List<XpTable> allXpTables) {
    for (final DataRow characterRow : characterTable) {
      if (characterId == characterRow.getId()) {
        return selectCharacter(characterRow, allCharacterClasses, allRaces, allXpTables);
      }
    }
    return null;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.CharacterDao#updateCharacter(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public Character updateCharacter(final Character character) {
    characterTable.delete(character.getId());
    insertCharacterTable(character);
    return character;
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.CharacterDao#createCharacter(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public Character createCharacter(final Character character) {
    character.setId(characterTable.getNewId());
    insertCharacter(character);
    return character;
  }

  private void insertCharacter(final Character character) {
    insertCharacterTable(character);
    insertCharacterClassLevelTable(character);
  }

  private void insertCharacterTable(final Character character) {
    // id, name, player, race, sex, alignment, xp_table_id, experience
    // str, dex, con, int, wis, cha
    // hp, max hp, ac, ini, cmb, cmd
    // fortify, reflex, will
    // imageid, thumbnailid
    // platinum, gold, silver, copper
    characterTable.insert(new Object[] { //
        character.getId(), character.getPlayer(), character.getName(), character.getRace().getId(), character.getSex().ordinal(),
        character.getAlignment().ordinal(), character.getXpTable().getId(), character.getExperiencePoints(),
        character.getStrength(), character.getDexterity(), character.getConstitution(), character.getIntelligence(),
        character.getWisdom(), character.getCharisma(), character.getHitPoints(), character.getMaxHitPoints(),
        character.getArmorClass(), character.getInitiativeModifier(), character.getCmbModifier(), character.getCmdModifier(),
        character.getFortitudeModifier(), character.getReflexModifier(), character.getWillModifier(), character.getImageId(),
        character.getThumbImageId(), character.getMoney().getPlatinum(), character.getMoney().getGold(),
        character.getMoney().getSilver(), character.getMoney().getCopper()
    });
  }

  private void insertCharacterClassLevelTable(final Character character) {
    for (final ClassLevel classLevel : character.getClassLevels()) {
      classLevel.setId(characterClassLevelTable.getNewId());
      insertCharacterClassLevelTable(character, classLevel);
    }
  }

  private void insertCharacterClassLevelTable(final Character character, final ClassLevel classLevel) {
    // id, character_id, class_id, level
    characterClassLevelTable.insert(
        new Object[] {classLevel.getId(), character.getId(), classLevel.getCharacterClass().getId(), classLevel.getLevel()});
    insertCharacterAbilityTable(character, classLevel);
  }

  private void insertCharacterAbilityTable(final Character character, final ClassLevel classLevel) {
    for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
      characterAbility.setId(characterAbilityTable.getNewId());
      // id, character_id, class_id, ability_id, owned
      characterAbilityTable.insert(
          new Object[] {characterAbility.getId(), character.getId(), classLevel.getCharacterClass().getId(),
              characterAbility.getClassAbility().getAbility().getId(), daoUtil.setBoolean(characterAbility.isOwned())
          });
    }
  }

  /**
   * @see com.d20charactersheet.framework.dac.dao.CharacterDao#deleteCharacter(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public void deleteCharacter(final Character character) {
    characterClassLevelTable.delete(1, character.getId());
    characterTable.delete(character.getId());
  }

  @Override
  public List<CharacterSkill> getCharacterSkills(final Character character, final List<Skill> allSkills) {
    final List<CharacterSkill> characterSkills = new ArrayList<>();
    final int characterId = character.getId();

    for (final DataRow dataRow : characterSkillTable.select(1, characterId)) {
      final CharacterSkill characterSkill = selectCharacterSkill(dataRow, allSkills);
      characterSkills.add(characterSkill);
    }
    return characterSkills;
  }

  private CharacterSkill selectCharacterSkill(final DataRow dataRow, final List<Skill> allSkills) {
    final int skillId = (Integer) dataRow.get(0);
    final Skill skill = getSkill(skillId, allSkills);
    final CharacterSkill characterSkill = new CharacterSkill(skill);
    characterSkill.setRank((Float) dataRow.get(2));
    characterSkill.setModifier((Integer) dataRow.get(3));
    return characterSkill;
  }

  private Skill getSkill(final int skillId, final List<Skill> allSkills) {
    for (final Skill skill : allSkills) {
      if (skill.getId() == skillId) {
        return skill;
      }
    }
    throw new IllegalArgumentException("Can't get skill of id: " + skillId);
  }

  @Override
  public void deleteCharacterSkills(final Character character) {
    characterSkillTable.delete(character.getId());
  }

  @Override
  public List<CharacterFeat> getCharacterFeats(final Character character, final List<Feat> allFeats) {
    final List<CharacterFeat> characterFeats = new ArrayList<>();
    for (final DataRow characterFeatRow : characterFeatTable.select(2, character.getId())) {
      final CharacterFeat characterFeat = createCharacterFeat(characterFeatRow, allFeats);
      characterFeats.add(characterFeat);
    }
    return characterFeats;
  }

  private CharacterFeat createCharacterFeat(final DataRow characterFeatRow, final List<Feat> allFeats) {
    // name, category
    final int featId = characterFeatRow.getInt(1);
    final Feat feat = getFeat(allFeats, featId);
    final CharacterFeat characterFeat = new CharacterFeat(feat);
    characterFeat.setId(characterFeatRow.getId());
    if (characterFeat.getFeat().isMultiple()) {
      characterFeat.setCategory((String) characterFeatRow.get(3));
    }
    return characterFeat;
  }

  private Feat getFeat(final List<Feat> allFeats, final int staticFeatId) {
    for (final Feat feat : allFeats) {
      if (feat.getId() == staticFeatId) {
        return feat;
      }
    }
    throw new IllegalArgumentException("Can't get feat of id: " + staticFeatId);

  }

  @Override
  public void updateCharacterFeats(final Character character) {
    deleteCharacterFeats(character);
    insertCharacterFeats(character);
  }

  private void insertCharacterFeats(final Character character) {
    for (final CharacterFeat characterFeat : character.getCharacterFeats()) {
      characterFeatTable.insert(
          new Object[] {characterFeat.getId(), characterFeat.getFeat().getId(), character.getId(), characterFeat.getCategory()});
    }
  }

  @Override
  public void deleteCharacterFeats(final Character character) {
    characterFeatTable.delete(2, character.getId());
  }

  @Override
  public List<ItemGroup> getWeapons(final Character character, final List<Weapon> allWeapons) {
    final List<ItemGroup> weaponGroups = new ArrayList<>();
    for (final DataRow dataRow : characterWeaponTable) {
      final int characterId = (Integer) dataRow.get(1);
      if (characterId == character.getId()) {
        final ItemGroup weaponGroup = createItemGroup(dataRow, allWeapons);
        weaponGroups.add(weaponGroup);
      }
    }
    return weaponGroups;
  }

  @Override
  public List<ItemGroup> getArmor(final Character character, final List<Armor> allArmor) {
    final List<ItemGroup> armorGroups = new ArrayList<>();
    for (final DataRow dataRow : characterArmorTable) {
      final int characterId = (Integer) dataRow.get(1);
      if (characterId == character.getId()) {
        final ItemGroup armorGroup = createItemGroup(dataRow, allArmor);
        armorGroups.add(armorGroup);
      }
    }
    return armorGroups;
  }

  @Override
  public List<ItemGroup> getGoods(final Character character, final List<Good> allGoods) {
    final List<ItemGroup> itemGroups = new ArrayList<>();
    for (final DataRow dataRow : characterGoodTable) {
      final int characterId = (Integer) dataRow.get(1);
      if (characterId == character.getId()) {
        final ItemGroup itemGroup = createItemGroup(dataRow, allGoods);
        itemGroups.add(itemGroup);
      }
    }
    return itemGroups;
  }

  private ItemGroup createItemGroup(final DataRow dataRow, final List<? extends Item> allItems) {
    for (final Item item : allItems) {
      final int goodId = (Integer) dataRow.get(2);
      if (goodId == item.getId()) {
        final ItemGroup goodGroup = new ItemGroup();
        goodGroup.setId(dataRow.getId());
        goodGroup.setItem(item);
        goodGroup.setNumber((Integer) dataRow.get(3));
        return goodGroup;
      }
    }
    throw new IllegalArgumentException("Can't create good group of id: " + dataRow);
  }

  @Override
  public List<ItemGroup> updateWeapons(final Character character, final List<ItemGroup> weapons) {
    return helper.updateItems(character.getEquipment().getWeapons(), weapons, Weapon.class.getSimpleName(), character.getId());
  }

  @Override
  public List<ItemGroup> updateArmor(final Character character, final List<ItemGroup> armor) {
    return helper.updateItems(character.getEquipment().getArmor(), armor, Armor.class.getSimpleName(), character.getId());
  }

  @Override
  public List<ItemGroup> updateGoods(final Character character, final List<ItemGroup> goods) {
    return helper.updateItems(character.getEquipment().getGoods(), goods, Good.class.getSimpleName(), character.getId());
  }

  @Override
  public void deleteSkill(final Skill skill) {
    characterSkillTable.delete(1, skill.getId());
  }

  @Override
  public void deleteFeat(final Feat feat) {
    characterFeatTable.delete(1, feat.getId());
    characterSpellSlotFeatTable.delete(2, feat.getId());
  }

  @Override
  public List<Note> getNotes(final Character character) {
    final List<Note> notes = new ArrayList<>();
    for (final DataRow dataRow : characterNoteTable) {
      if (dataRow.get(1).equals(character.getId())) {
        final Note note = selectNote(dataRow);
        notes.add(note);
      }
    }
    return notes;
  }

  private Note selectNote(final DataRow dataRow) {
    final Note note = new Note();
    note.setId(dataRow.getId());
    note.setDate(parseDate((String) dataRow.get(2)));
    note.setText((String) dataRow.get(3));
    return note;
  }

  private Date parseDate(final String dateParameter) {
    final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    Date date;
    try {
      date = dateFormat.parse(dateParameter);
    } catch (final ParseException parseException) {
      parseException.printStackTrace();
      throw new RuntimeException(parseException);
    }
    return date;
  }

  private String formatDate(final Date date) {
    final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    return dateFormat.format(date);
  }

  @Override
  public Note createNote(final Note note, final Character character) {
    note.setId(characterNoteTable.getNewId());
    characterNoteTable.insert(new Object[] {note.getId(), character.getId(), formatDate(note.getDate()), note.getText()});
    return note;
  }

  @Override
  public void updateNote(final Note note, final Character character) {
    characterNoteTable.delete(note.getId());
    characterNoteTable.insert(new Object[] {note.getId(), character.getId(), formatDate(note.getDate()), note.getText()});
  }

  @Override
  public void deleteNote(final Note note) {
    characterNoteTable.delete(note.getId());
  }

  @Override
  public CharacterSkill newCharacterSkill(final Skill skill) {
    return new CharacterSkill(skill);
  }

  @Override
  public void deleteNotes(final Character character) {
    characterNoteTable.delete(1, character.getId());
  }

  @Override
  public void deleteWeapons(final Character character) {
    characterWeaponTable.delete(1, character.getId());
  }

  @Override
  public void deleteArmor(final Character character) {
    characterArmorTable.delete(1, character.getId());
  }

  @Override
  public void deleteGoods(final Character character) {
    characterGoodTable.delete(1, character.getId());
  }

  @Override
  public List<CharacterAbility> getCharacterAbilities(final Character character, final CharacterClass characterClass) {
    final List<CharacterAbility> characterAbilities = new ArrayList<>();
    final List<DataRow> dataRows = selectCharacterAbilities(character.getId(), characterClass.getId());
    for (final DataRow dataRow : dataRows) {
      final CharacterAbility characterAbility = new CharacterAbility();
      characterAbility.setId(dataRow.getId());
      characterAbility.setClassAbility(getClassAbilityById(characterClass, dataRow.getInt(3)));
      characterAbility.setOwned(daoUtil.getBoolean(dataRow.getInt(4)));
      characterAbilities.add(characterAbility);
    }
    return characterAbilities;
  }

  private List<DataRow> selectCharacterAbilities(final int characterId, final int classId) {
    final List<DataRow> dataRows = new LinkedList<>();
    for (final DataRow dataRow : characterAbilityTable) {
      // id, character_id, class_id, ability_id, owned
      if (dataRow.getInt(1) == characterId && dataRow.getInt(2) == classId) {
        dataRows.add(dataRow);
      }
    }
    return dataRows;
  }

  private ClassAbility getClassAbilityById(final CharacterClass characterClass, final int abilityId) {
    for (final ClassAbility classAbility : characterClass.getClassAbilities()) {
      if (classAbility.getAbility().getId() == abilityId) {
        return classAbility;
      }
    }
    throw new IllegalArgumentException("Can't find ability with id: " + abilityId);
  }

  @Override
  public void updateCharacterAbility(final CharacterAbility characterAbility) {
    final List<DataRow> dataRows = characterAbilityTable.select(0, characterAbility.getId());
    if (dataRows.size() != 1) {
      throw new IllegalArgumentException("Can't find data row of character ability with id: " + characterAbility.getId());
    }
    final DataRow dataRow = dataRows.get(0);
    dataRow.set(4, daoUtil.setBoolean(characterAbility.isOwned()));
  }

  @Override
  public void createCharacterAbility(final Character character, final CharacterClass characterClass,
      final CharacterAbility characterAbility) {
    characterAbility.setId(characterAbilityTable.getNewId());
    characterAbilityTable.insert(new Object[] {characterAbility.getId(), character.getId(), characterClass.getId(),
        characterAbility.getClassAbility().getAbility().getId(), daoUtil.setBoolean(characterAbility.isOwned())
    });
  }

  @Override
  public void deleteCharacterAbility(final CharacterAbility characterAbility) {
    characterAbilityTable.delete(characterAbility.getId());
  }

  @Override
  public void deleteCharacterAbilities(final Character character) {
    characterAbilityTable.delete(1, character.getId());
  }

  @Override
  public ClassLevel createClassLevel(final Character character, final ClassLevel classLevel) {
    classLevel.setId(characterClassLevelTable.getNewId());
    insertCharacterClassLevelTable(character, classLevel);
    return classLevel;
  }

  @Override
  public void updateClassLevel(final ClassLevel classLevel) {
    for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
      updateCharacterAbility(characterAbility);
    }

    final List<DataRow> dataRows = characterClassLevelTable.select(0, classLevel.getId());
    if (dataRows.size() != 1) {
      throw new IllegalArgumentException("Can't find class level with id: " + classLevel.getId());
    }
    final DataRow dataRow = dataRows.get(0);
    dataRow.set(3, classLevel.getLevel());
  }

  @Override
  public void deleteClassLevel(final ClassLevel classLevel) {
    for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
      characterAbilityTable.delete(characterAbility.getId());
    }
    characterClassLevelTable.delete(classLevel.getId());
  }

  @Override
  public void deleteCharacterAbilities(final CharacterClass characterClass, final List<ClassAbility> classAbilities) {
    final int classId = characterClass.getId();
    final List<DataRow> dataRows = new LinkedList<>();
    for (final DataRow dataRow : characterAbilityTable) {
      // id, character_id, class_id, ability_id, owned
      if (dataRow.getInt(2) == classId && isAbility(dataRow.getInt(3), classAbilities)) {
        dataRows.add(dataRow);
      }
    }

    for (final DataRow dataRow : dataRows) {
      characterAbilityTable.delete(dataRow.getId());
    }
  }

  private boolean isAbility(final int abilityId, final List<ClassAbility> classAbilities) {
    for (final ClassAbility classAbility : classAbilities) {
      if (classAbility.getAbility().getId() == abilityId) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<WeaponAttack> getWeaponAttacks(final Character character, final List<Weapon> allWeapons) {
    final List<WeaponAttack> weaponAttacks = new ArrayList<>();
    final List<DataRow> dataRows = characterWeaponAttackTable.select(1, character.getId());
    for (final DataRow dataRow : dataRows) {
      final WeaponAttack weaponAttack = new WeaponAttack();
      weaponAttack.setId(dataRow.getId());
      weaponAttack.setName(dataRow.getString(2));
      weaponAttack.setDescription(dataRow.getString(3));
      weaponAttack.setAttackWield((AttackWield) daoUtil.getEnum(dataRow.getInt(4), AttackWield.values()));
      weaponAttack.setWeapon(getWeapon(dataRow.getInt(5), allWeapons));
      weaponAttack.setAmmunition(dataRow.getInt(6));
      weaponAttack.setAttackBonusModifier(dataRow.getInt(7));
      weaponAttack.setDamageBonusModifier(dataRow.getInt(8));
      weaponAttacks.add(weaponAttack);
    }
    return weaponAttacks;
  }

  private Weapon getWeapon(final int weaponId, final List<Weapon> allWeapons) {
    for (final Weapon weapon : allWeapons) {
      if (weapon.getId() == weaponId) {
        return weapon;
      }
    }
    throw new IllegalArgumentException("Can't find weapon with id: " + weaponId);
  }

  @Override
  public void updateWeaponAttack(final WeaponAttack weaponAttack) {
    final List<DataRow> dataRows = characterWeaponAttackTable.select(0, weaponAttack.getId());
    if (dataRows.size() != 1) {
      throw new IllegalArgumentException("Can't find weapon attack with id: " + weaponAttack.getId());
    }
    final DataRow dataRow = dataRows.get(0);
    dataRow.set(6, weaponAttack.getAmmunition());
  }

  @Override
  public WeaponAttack createWeaponAttack(final Character character, final WeaponAttack weaponAttack) {
    // id, character_id, name, description, attack_wield_id, weapon_id, ammunition
    weaponAttack.setId(characterWeaponAttackTable.getNewId());
    characterWeaponAttackTable.insert(
        new Object[] {weaponAttack.getId(), character.getId(), weaponAttack.getName(), weaponAttack.getDescription(),
            weaponAttack.getAttackWield().ordinal(), weaponAttack.getWeapon().getId(), weaponAttack.getAmmunition(),
            weaponAttack.getAttackBonusModifier(), weaponAttack.getDamageBonusModifier()
        });
    return weaponAttack;
  }

  @Override
  public void deleteWeaponAttack(final WeaponAttack weaponAttack) {
    characterWeaponAttackTable.delete(weaponAttack.getId());
  }

  @Override
  public void deleteWeaponAttacks(final Character character) {
    characterWeaponAttackTable.delete(1, character.getId());
  }

  @Override
  public List<KnownSpell> getKnownSpells(final Character character, final List<Spelllist> allSpelllist,
      final List<Spell> allSpells) {
    final List<DataRow> result = characterKnownSpellTable.select(1, character.getId());

    final List<KnownSpell> knownSpells = new LinkedList<>();
    for (final DataRow dataRow : result) {
      final KnownSpell knownSpell = new KnownSpell();
      knownSpell.setId(dataRow.getId());
      knownSpell.setSpelllist(getSpelllist(dataRow.getInt(2), allSpelllist));
      knownSpell.setSpell(getSpell(dataRow.getInt(3), allSpells));
      knownSpells.add(knownSpell);
    }
    return knownSpells;
  }

  private Spelllist getSpelllist(final int spelllistId, final List<Spelllist> allSpelllists) {
    for (final Spelllist spelllist : allSpelllists) {
      if (spelllist.getId() == spelllistId) {
        return spelllist;
      }
    }
    return null;
  }

  private Spell getSpell(final int spellId, final List<Spell> allSpells) {
    for (final Spell spell : allSpells) {
      if (spell.getId() == spellId) {
        return spell;
      }
    }
    throw new IllegalArgumentException("Can't find spell with id: " + spellId);
  }

  @Override
  public KnownSpell createKnownSpell(final Character character, final KnownSpell knownSpell) {
    knownSpell.setId(characterKnownSpellTable.getNewId());
    characterKnownSpellTable.insert(
        new Object[] {knownSpell.getId(), character.getId(), knownSpell.getSpelllist().getId(), knownSpell.getSpell().getId()});
    return knownSpell;
  }

  @Override
  public void deleteKnownSpell(final KnownSpell knownSpell) {
    characterKnownSpellTable.delete(knownSpell.getId());
  }

  @Override
  public void deleteKnownSpells(final Character character) {
    characterKnownSpellTable.delete(1, character.getId());
  }

  @Override
  public List<SpellSlot> getSpellSlots(final Character character, final List<Spell> allSpells, final List<Ability> allAbilities,
      final List<Feat> allFeats) {
    final List<SpelllistAbility> spelllistAbilities = getSpelllistAbilities(allAbilities);
    final List<Feat> metaMagicFeats = getMetaMagicFeats(allFeats);

    final List<DataRow> result = characterSpellSlotTable.select(1, character.getId());

    final List<SpellSlot> spellSlots = new ArrayList<>();
    for (final DataRow dataRow : result) {
      final SpellSlot spellSlot = new SpellSlot();
      spellSlot.setId(dataRow.getId());
      spellSlot.setSpell(getSpellOfSpellSlot(dataRow.getInt(2), allSpells));
      spellSlot.setLevel(dataRow.getInt(3));
      spellSlot.setCast(daoUtil.getBoolean(dataRow.getInt(4)));
      spellSlot.setSpelllistAbilities(getSpelllistAbilities(dataRow.getId(), spelllistAbilities));
      spellSlot.setMetamagicFeats(getMetaMagicFeats(dataRow.getId(), metaMagicFeats));
      spellSlots.add(spellSlot);
    }
    return spellSlots;
  }

  private Spell getSpellOfSpellSlot(final int spellId, final List<Spell> allSpells) {
    if (spellId == SpellSlot.EMPTY_SPELL.getId()) {
      return SpellSlot.EMPTY_SPELL;
    }
    return getSpell(spellId, allSpells);
  }

  private List<SpelllistAbility> getSpelllistAbilities(final List<Ability> allAbilities) {
    final List<SpelllistAbility> spelllistAbilities = new LinkedList<>();
    for (final Ability ability : allAbilities) {
      if (ability instanceof SpelllistAbility) {
        final SpelllistAbility spelllistAbility = (SpelllistAbility) ability;
        spelllistAbilities.add(spelllistAbility);
      }
    }
    return spelllistAbilities;
  }

  private List<SpelllistAbility> getSpelllistAbilities(final int spellSlotId, final List<SpelllistAbility> allAbilities) {
    final List<SpelllistAbility> spelllistAbilities = new LinkedList<>();
    final List<DataRow> result = characterSpellSlotAbilityTable.select(1, spellSlotId);
    for (final DataRow dataRow : result) {
      final SpelllistAbility spelllistAbility = getAbilityById(dataRow.getInt(2), allAbilities);
      spelllistAbilities.add(spelllistAbility);
    }
    return spelllistAbilities;
  }

  private SpelllistAbility getAbilityById(final int abilityId, final List<SpelllistAbility> allSpelllistAbilities) {
    for (final SpelllistAbility spelllistAbility : allSpelllistAbilities) {
      if (spelllistAbility.getId() == abilityId) {
        return spelllistAbility;
      }
    }
    throw new IllegalArgumentException("Can't find spelllist ability with id: " + abilityId);
  }

  private List<Feat> getMetaMagicFeats(final List<Feat> allFeats) {
    final List<Feat> metaMagicFeats = new LinkedList<>();
    for (final Feat feat : allFeats) {
      if (FeatType.METAMAGIC.equals(feat.getFeatType())) {
        metaMagicFeats.add(feat);
      }
    }
    return metaMagicFeats;
  }

  private List<Feat> getMetaMagicFeats(final int spellSlotId, final List<Feat> allFeats) {
    final List<Feat> metaMagicFeats = new LinkedList<>();
    final List<DataRow> result = characterSpellSlotFeatTable.select(1, spellSlotId);
    for (final DataRow dataRow : result) {
      final Feat feat = getFeatById(dataRow.getInt(2), allFeats);
      metaMagicFeats.add(feat);

    }
    return metaMagicFeats;
  }

  private Feat getFeatById(final int featId, final List<Feat> allFeats) {
    for (final Feat feat : allFeats) {
      if (feat.getId() == featId) {
        return feat;
      }
    }
    throw new IllegalArgumentException("Can't find feat with id: " + featId);
  }

  @Override
  public void updateSpellSlot(final SpellSlot spellSlot) {
    final List<DataRow> dataRows = characterSpellSlotTable.select(0, spellSlot.getId());
    if (dataRows.size() != 1) {
      throw new IllegalArgumentException("Can't find spell slot with id: " + spellSlot.getId());
    }
    // id, character_id, spell_id, level, cast
    final DataRow dataRow = dataRows.get(0);
    dataRow.set(2, spellSlot.getSpell().getId());
    dataRow.set(4, daoUtil.setBoolean(spellSlot.isCast()));

    // id, spell_slot_id, feat_id
    characterSpellSlotFeatTable.delete(1, spellSlot.getId());
    for (final Feat feat : spellSlot.getMetamagicFeats()) {
      final int id = characterSpellSlotFeatTable.getNewId();
      characterSpellSlotFeatTable.insert(new Object[] {id, spellSlot.getId(), feat.getId()});
    }
  }

  @Override
  public SpellSlot createSpellSlot(final Character character, final SpellSlot spellSlot) {
    final int spellSlotId = characterSpellSlotTable.getNewId();
    spellSlot.setId(spellSlotId);
    insertCharacterSpellSlot(character, spellSlot);
    insertCharacterSpellSlotAbility(spellSlot);
    insertCharacterSpellSlotFeat(spellSlot);
    return spellSlot;
  }

  private void insertCharacterSpellSlot(final Character character, final SpellSlot spellSlot) {
    characterSpellSlotTable.insert(
        new Object[] {spellSlot.getId(), character.getId(), spellSlot.getSpell().getId(), spellSlot.getLevel(),
            daoUtil.setBoolean(spellSlot.isCast())
        });
  }

  private void insertCharacterSpellSlotAbility(final SpellSlot spellSlot) {
    for (final SpelllistAbility spelllistAbility : spellSlot.getSpelllistAbilities()) {
      characterSpellSlotAbilityTable
          .insert(new Object[] {characterSpellSlotAbilityTable.getNewId(), spellSlot.getId(), spelllistAbility.getId()});
    }
  }

  private void insertCharacterSpellSlotFeat(final SpellSlot spellSlot) {
    for (final Feat metamagicFeat : spellSlot.getMetamagicFeats()) {
      characterSpellSlotFeatTable
          .insert(new Object[] {characterSpellSlotFeatTable.getNewId(), spellSlot.getId(), metamagicFeat.getId()});
    }
  }

  @Override
  public void deleteSpellSlot(final SpellSlot spellSlot) {
    characterSpellSlotFeatTable.delete(1, spellSlot.getId());
    characterSpellSlotAbilityTable.delete(1, spellSlot.getId());
    characterSpellSlotTable.delete(spellSlot.getId());
  }

  @Override
  public void deleteSpellSlots(final Character character) {
    for (final SpellSlot spellSlot : character.getSpellSlots()) {
      deleteSpellSlot(spellSlot);
    }
  }

  @Override
  public void deleteKnownSpells(final Spelllist spelllist, final Spell spell) {
    final DataTable newCharacterKnownSpellTable = new DataTable();
    for (final DataRow dataRow : characterKnownSpellTable) {
      if (dataRow.getInt(2) == spelllist.getId() && dataRow.getInt(3) == spell.getId()) {
        continue;
      }
      newCharacterKnownSpellTable.insert(dataRow);
    }
    characterKnownSpellTable = newCharacterKnownSpellTable;
  }

  @Override
  public void deleteSpellSlots(final Spelllist spelllist, final Spell spell) {
    final List<DataRow> result = characterSpellSlotTable.select(2, spell.getId());
    for (final DataRow dataRow : result) {
      characterSpellSlotFeatTable.delete(1, dataRow.getId());
      characterSpellSlotAbilityTable.delete(1, dataRow.getId());
      characterSpellSlotTable.delete(0, dataRow.getId());
    }
  }

  @Override
  public void updateCharacterSkill(final Character character, final CharacterSkill characterSkill) {
    final List<DataRow> result = characterSkillTable.select(0, characterSkill.getSkill().getId());

    for (final DataRow dataRow : result) {
      if (dataRow.getInt(1) == character.getId()) {
        dataRow.set(2, characterSkill.getRank());
        dataRow.set(3, characterSkill.getModifier());
        return;
      }
    }
    characterSkillTable.insert(
        new Object[] {characterSkill.getSkill().getId(), character.getId(), characterSkill.getRank(), characterSkill.getModifier(),
            0
        });
  }

  @Override
  public Body getBody(Character character, List<Weapon> allWeapons, List<Armor> allArmor, List<Good> allGoods) {
    Body body = new HumanoidBody();
    final List<DataRow> result = characterBodyPartTable.select(1, character.getId());
    for (final DataRow dataRow : result) {
      BodyPart bodyPart = (BodyPart) daoUtil.getEnum(dataRow.getInt(2), BodyPart.values());
      Item item = getItem(dataRow.getInt(3), dataRow.getString(4), allWeapons, allArmor, allGoods);
      body.equip(bodyPart, item);
    }

    return body;
  }

  private Item getItem(int itemId, String itemclass, List<Weapon> allWeapons, List<Armor> allArmor, List<Good> allGoods) {
    Item item;
    if (Weapon.class.getSimpleName().equals(itemclass)) {
      item = findItem(itemId, allWeapons);
    } else if (Armor.class.getSimpleName().equals(itemclass)) {
      item = findItem(itemId, allArmor);
    } else if (Good.class.getSimpleName().equals(itemclass)) {
      item = findItem(itemId, allGoods);
    } else {
      throw new IllegalArgumentException("Can't find item with id: " + itemId + " and itemclass: " + itemclass);
    }
    return item;
  }

  private Item findItem(final int itemId, final List<? extends Item> allItems) {
    for (Item item : allItems) {
      if (item.getId() == itemId) {
        return item;
      }
    }
    throw new IllegalArgumentException("Can't find item with id: " + itemId);
  }

  @Override
  public Body createBody(Character character, Body body) {
    // id, character_id, body_part_id, item_id, itemclass
    for (BodyPart bodyPart : body.getBodyParts()) {
      Item item = body.getItemOfBodyPart(bodyPart);
      insertcharacterBodyPartTable(character, bodyPart, item);
    }
    return body;
  }

  @Override
  public void deleteBody(Character character) {
    characterBodyPartTable.delete(1, character.getId());
  }

  @Override
  public void updateBody(Character character) {
    deleteBody(character);
    createBody(character, character.getBody());
  }

  private void insertcharacterBodyPartTable(Character character, BodyPart bodyPart, Item item) {
    if (!item.equals(Item.EMPTY_ITEM)) {
      characterWeaponAttackTable.insert(
          new Object[] {characterBodyPartTable.getNewId(), character.getId(), bodyPart.ordinal(), item.getId(),
              item.getClass().getSimpleName()
          });
    }
  }

}
