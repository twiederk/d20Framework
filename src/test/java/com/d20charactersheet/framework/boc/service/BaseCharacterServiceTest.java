package com.d20charactersheet.framework.boc.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Body;
import com.d20charactersheet.framework.boc.model.BodyPart;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassAbility;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.HumanoidBody;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
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

public abstract class BaseCharacterServiceTest {

  private static final String PLAYER_NAME = "player";

  protected GameSystem gameSystem;

  protected CharacterClass fighter;
  protected CharacterClass wizard;

  protected Race human;

  @After
  public void tearDown() {
    fighter = null;
    wizard = null;
    human = null;
  }

  @Test
  public void testGetAllCharacters() {
    final List<Character> characters = gameSystem.getAllCharacters();
    assertNotNull(characters);
    assertEquals(getNumberOfCharacters(), characters.size());
  }

  protected abstract int getNumberOfCharacters();

  @Test
  public void testGetBelvador() {
    final Character belvador = gameSystem.getCharacter(0);
    assertNotNull(belvador);
    assertEquals(0, belvador.getId());
    assertEquals("Belvador the Summoner", belvador.getName());
    assertEquals(1, belvador.getXpTable()
        .getId());
  }

  @Test
  public void testUpdateAttribute() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final Character belvador = gameSystem.getCharacter(0);
    final int oldValue = belvador.getStrength();
    belvador.setStrength(20);
    characterService.updateCharacter(belvador);

    final Character character = gameSystem.getCharacter(0);
    assertNotNull(character);
    assertEquals(20, character.getStrength());

    // tear down
    character.setStrength(oldValue);
    characterService.updateCharacter(character);
  }

  @Test
  public void testUpdateClassLevel() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final Character belvador = gameSystem.getCharacter(0);
    final ClassLevel wizardClassLevel = belvador.getClassLevels()
        .get(0);
    wizardClassLevel.setLevel(10);

    final Character character = characterService.updateCharacter(belvador);
    assertEquals(wizardClassLevel, character.getClassLevels()
        .get(0));

    // tear down
    wizardClassLevel.setLevel(5);
    characterService.updateCharacter(character);
  }

  @Test
  public void testCreateCharacter() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final ImageService imageService = gameSystem.getImageService();

    final String name = "testCreateCharacter";
    final String player = PLAYER_NAME;
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = gameSystem.getAllXpTables().get(0);
    Character character = createCharacter(name, player, race, sex, classLevel, alignment, xpTable);

    // test
    character = characterService.createCharacter(character, gameSystem.getAllSkills());

    assertNotNull(character);
    assertEquals(name, character.getName());
    assertEquals(player, character.getPlayer());
    assertEquals(race, character.getRace());
    assertEquals(1, character.getClassLevels().size());
    final ClassLevel newClassLevel = character.getClassLevels().get(0);
    assertTrue(newClassLevel.getId() != -1);
    assertEquals(classLevel.getCharacterClass(), newClassLevel.getCharacterClass());
    assertEquals(classLevel.getLevel(), newClassLevel.getLevel());
    for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
      assertTrue(characterAbility.getId() != -1);
    }

    assertEquals(alignment, character.getAlignment());

    // tear down
    if (imageService != null) {
      characterService.deleteCharacter(character);
    }
  }

  @Test
  public void testCreateCharacterWithIllegalValues() {
    final String name = "testCreateCharacterWithIllegalValues";
    final String player = PLAYER_NAME;
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = gameSystem.getAllXpTables()
        .get(0);

    assertException(null, player, race, sex, classLevel, alignment, xpTable);
    assertException(name, null, race, sex, classLevel, alignment, xpTable);
    assertException(name, player, null, sex, classLevel, alignment, xpTable);
    assertException(name, player, race, null, classLevel, alignment, xpTable);
    assertException(name, player, race, sex, null, alignment, xpTable);
    assertException(name, player, race, sex, classLevel, null, xpTable);
    assertException("", player, race, sex, classLevel, alignment, xpTable);
    assertException(name, "", race, sex, classLevel, alignment, xpTable);
    assertException(" ", player, race, sex, classLevel, alignment, xpTable);
    assertException(name, " ", race, sex, classLevel, alignment, xpTable);
  }

  private void assertException(final String name, final String player, final Race race, final Sex sex, final ClassLevel classLevel,
      final Alignment alignment, final XpTable xpTable) {
    final CharacterService characterService = gameSystem.getCharacterService();
    try {
      final Character character = createCharacter(name, player, race, sex, classLevel, alignment, xpTable);
      characterService.createCharacter(character, gameSystem.getAllSkills());
      fail("Missing exception. Expected IllegalArgumentException. Arguments: (" + name + ", " + player + ", " + race + ", "
               + classLevel + ", " + alignment);
    } catch (final IllegalArgumentException illegalArgumentException) {
      // ok, expected exception thrown
    } catch (final Exception exception) {
      fail("Wrong exception thrown. Expected IllegalArguments Exception. Arguments: (" + name + ", " + player + ", " + race + ", "
               + classLevel + ", " + alignment);
    }

  }

  private Character createCharacter(final String name, final String player, final Race race, final Sex sex,
      final ClassLevel classLevel, final Alignment alignment, final XpTable xpTable) {
    final Character character = new Character();
    character.setName(name);
    character.setPlayer(player);
    character.setRace(race);
    character.setSex(sex);
    final List<ClassLevel> classLevels = new LinkedList<>();
    if (classLevel != null) {
      classLevels.add(classLevel);
    }
    character.setClassLevels(classLevels);
    character.setAlignment(alignment);
    character.setXpTable(xpTable);
    return character;
  }

  @Test
  public void testDeleteCharacter() {
    final CharacterService characterService = gameSystem.getCharacterService();

    final String name = "testDeleteCharacter";
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = gameSystem.getAllXpTables().get(0);
    Character character = createCharacter(name, PLAYER_NAME, race, sex, classLevel, alignment, xpTable);
    character.setStrength(10);
    character.setDexterity(10);
    character.setConstitution(10);
    character.setIntelligence(10);
    character.setWisdom(10);
    character.setCharisma(10);

    character = characterService.createCharacter(character, gameSystem.getAllSkills());
    final int id = character.getId();
    final int numberOfCharacters = gameSystem.getAllCharacters().size();

    // test
    characterService.deleteCharacter(character);

    assertEquals(numberOfCharacters - 1, gameSystem.getAllCharacters().size());

  }

  @Test
  public void testGetCharacterWithListenSkill() {
    final Character belvador = gameSystem.getCharacter(0);
    final CharacterSkill listen = getCharacterSkill(belvador);
    assertNotNull(listen);
    assertEquals(29, listen.getSkill()
        .getId());
    assertEquals(0.0f, listen.getRank(), 0.0f);
    assertEquals(2, listen.getModifier());
    assertTrue(listen.getSkill()
                   .isUntrained());
  }

  private CharacterSkill getCharacterSkill(final Character character) {
    for (final CharacterSkill characterSkill : character.getCharacterSkills()) {
      if ("Listen".equals(characterSkill.getSkill().getName())) {
        return characterSkill;
      }
    }
    throw new IllegalStateException("Can't get skill: " + "Listen");
  }

  @Test
  public void testGetCharacterWithAllSkills() {
    final Character belvador = gameSystem.getCharacter(0);
    assertEquals(44, belvador.getCharacterSkills()
        .size());
  }

  @Test
  public void testInitiativeModifier() {
    final Character belvador = gameSystem.getCharacter(0);
    assertEquals(0, belvador.getInitiativeModifier());
  }

  @Test
  public void testWeapons() {
    final Character belvador = gameSystem.getCharacter(0);
    final List<ItemGroup> weapons = belvador.getEquipment()
        .getWeapons();
    assertNotNull(weapons);
    assertEquals(3, weapons.size());
    assertItem("Quarterstaff", 1, weapons.get(0));
    assertItem("Crossbow, light", 1, weapons.get(1));
    assertItem("Bolts, crossbow (10)", 2, weapons.get(2));
  }

  @Test
  public void testArmor() {
    final Character belvador = gameSystem.getCharacter(0);
    final List<ItemGroup> armor = belvador.getEquipment()
        .getArmor();
    assertNotNull(armor);
    assertEquals(0, armor.size());
  }

  @Test
  public void testGoods() {
    final Character belvador = gameSystem.getCharacter(0);
    final List<ItemGroup> goods = belvador.getEquipment()
        .getGoods();
    assertNotNull(goods);
    assertEquals(19, goods.size());
    assertItem("Backpack", 1, goods.get(0));
    assertItem("Waterskin", 1, goods.get(1));
    assertItem("Trail Rations (per Day)", 10, goods.get(2));
  }

  private void assertItem(final String name, final int number, final ItemGroup itemGroup) {
    assertEquals(name, itemGroup.getItem()
        .getName());
    assertEquals(number, itemGroup.getNumber());
  }

  @Test
  public void testGetNotes() {
    final Character belvador = gameSystem.getCharacter(0);
    final List<Note> notes = belvador.getNotes();
    assertEquals(0, notes.size());
  }

  @Test
  public void testCreateNote() {
    final CharacterService characterService = gameSystem.getCharacterService();

    final Note note = new Note();
    note.setDate(new Date());
    note.setText("TestNote");

    final Character belvador = gameSystem.getCharacter(0);
    final int numberOfNotes = belvador.getNotes()
        .size();

    final Note createdNote = characterService.createNote(note, belvador);
    assertTrue(createdNote.getId() >= 0);
    assertEquals(numberOfNotes + 1, belvador.getNotes()
        .size());

    characterService.deleteNote(note, belvador);
  }

  @Test
  public void testUpdateCharacterAbilities() {
    Character belvador = gameSystem.getCharacter(0);
    CharacterAbility familiar = getCharacterAbilityByName("Familiar", belvador);
    familiar.setOwned(false);
    CharacterAbility abjuration = getCharacterAbilityByName("School Specialization - Abjuration", belvador);
    abjuration.setOwned(true);

    final CharacterService characterService = gameSystem.getCharacterService();
    characterService.updateCharacterAbility(familiar);
    characterService.updateCharacterAbility(abjuration);

    gameSystem.clear();
    gameSystem.load();
    belvador = gameSystem.getCharacter(0);

    familiar = getCharacterAbilityByName("Familiar", belvador);
    abjuration = getCharacterAbilityByName("School Specialization - Abjuration", belvador);
    assertFalse(familiar.isOwned());
    assertTrue(abjuration.isOwned());

    // tear down
    familiar.setOwned(true);
    abjuration.setOwned(false);
    characterService.updateCharacterAbility(familiar);
    characterService.updateCharacterAbility(abjuration);

  }

  private CharacterAbility getCharacterAbilityByName(final String name, final Character character) {
    for (final ClassLevel classLevel : character.getClassLevels()) {
      for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
        if (characterAbility.getClassAbility()
            .getAbility()
            .getName()
            .equals(name)) {
          return characterAbility;
        }
      }
    }
    throw new IllegalArgumentException("Can't get character ability with name: " + name);
  }

  @Test
  public void testRemoveCharacterAbilities() {
    final CharacterClass characterClass = createCharacterClass();
    List<CharacterAbility> characterAbilities = new ArrayList<>();
    characterAbilities.add(createCharacterAbility(1));
    characterAbilities.add(createCharacterAbility(2));
    characterAbilities.add(createCharacterAbility(3));

    final CharacterServiceImpl characterService = (CharacterServiceImpl) gameSystem.getCharacterService();
    characterAbilities = characterService.removeCharacterAbilities(characterAbilities, characterClass);
    assertEquals(2, characterAbilities.size());
  }

  @Test
  public void testAddCharacterAbilities() {
    final CharacterClass characterClass = createCharacterClass();
    final List<CharacterAbility> characterAbilities = new ArrayList<>();
    characterAbilities.add(createCharacterAbility(1));
    final CharacterServiceImpl characterService = (CharacterServiceImpl) gameSystem.getCharacterService();
    final Character character = new Character();
    character.setId(1);

    characterService.addCharacterAbilities(characterAbilities, characterClass, character);
    assertEquals(2, characterAbilities.size());

  }

  private CharacterClass createCharacterClass() {
    final List<ClassAbility> classAbilities = new ArrayList<>(2);
    classAbilities.add(createClassAbility(1));
    classAbilities.add(createClassAbility(2));

    final CharacterClass characterClass = new CharacterClass();
    characterClass.setClassAbilities(classAbilities);

    return characterClass;
  }

  private ClassAbility createClassAbility(final int abilityId) {
    final Ability ability = new Ability();
    ability.setId(abilityId);
    return new ClassAbility(ability);
  }

  private CharacterAbility createCharacterAbility(final int abilityId) {
    final Ability ability = new Ability();
    ability.setId(abilityId);
    final ClassAbility classAbility = new ClassAbility(ability);
    final CharacterAbility characterAbility = new CharacterAbility();
    characterAbility.setClassAbility(classAbility);
    return characterAbility;
  }

  @Test
  public void testWeaponAttacks() {
    final Character belvador = gameSystem.getCharacter(0);

    final List<WeaponAttack> weaponAttacks = belvador.getWeaponAttacks();
    assertNotNull("Weapon attacks can't be null", weaponAttacks);
    assertEquals("Wrong number of weapon attacks", 3, weaponAttacks.size());

    assertWeaponAttack(weaponAttacks.get(0), 1, "Quarterstaff", "My good old quaterstaff", AttackWield.TWO_HANDED, 0);
    assertWeaponAttack(weaponAttacks.get(1), 2, "Crossbow, light", "", AttackWield.ONE_HAND, 20);
    assertWeaponAttack(weaponAttacks.get(2), 3, "Silver Dagger", "Use against lycanthropes", AttackWield.ONE_HAND, 0);

  }

  private void assertWeaponAttack(final WeaponAttack weaponAttack, final int id, final String name, final String description,
      final AttackWield attackWield, final int ammunition) {
    assertEquals(id, weaponAttack.getId());
    assertEquals(name, weaponAttack.getName());
    assertEquals(description, weaponAttack.getDescription());
    assertEquals(attackWield, weaponAttack.getAttackWield());
    final Weapon weapon = weaponAttack.getWeapon();
    assertNotNull("Weapon can't be null", weapon);
    assertEquals(name, weapon.getName());
    assertEquals(ammunition, weaponAttack.getAmmunition());
  }

  @Test
  public void testGetKnownSpells() {
    final Character belvador = gameSystem.getCharacter(0);

    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities()
        .get(0);
    final List<KnownSpell> knownSpells = belvador.getKnownSpells(spelllistAbility.getSpelllist());
    assertNotNull("Character spells can't be null", knownSpells);
    assertEquals("Wrong number of character spells", 31, knownSpells.size());

    assertTrue(contains(knownSpells));
  }

  private boolean contains(final List<KnownSpell> knownSpells) {
    for (final KnownSpell knownSpell : knownSpells) {
      if (knownSpell.getSpell().getName().equals("Arcane Mark")) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void testCreateKnownSpells() {

    final SpelllistService spelllistService = gameSystem.getSpelllistService();
    final Spell acidArrow = spelllistService.findSpellByName("Acid Arrow", gameSystem.getAllSpells());
    final Spelllist spelllist = spelllistService.findSpelllistByName("Wizard", gameSystem.getAllSpelllists());

    final KnownSpell knownSpell = new KnownSpell();
    knownSpell.setSpell(acidArrow);
    knownSpell.setSpelllist(spelllist);

    final Character belvador = gameSystem.getCharacter(0);
    final CharacterService characterService = gameSystem.getCharacterService();
    characterService.createKnownSpell(belvador, knownSpell);

    assertTrue(knownSpell.getId() > 0);
    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities()
        .get(0);
    final List<KnownSpell> knownSpells = belvador.getKnownSpells(spelllistAbility.getSpelllist());
    assertEquals(32, knownSpells.size());

    // tear down
    characterService.deleteKnownSpell(belvador, knownSpell);
  }

  @Test
  public void testDeleteKnownSpells() {
    final Character belvador = gameSystem.getCharacter(0);
    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities()
        .get(0);
    final KnownSpell knownSpell = belvador.getKnownSpells(spelllistAbility.getSpelllist())
        .get(0);

    final CharacterService characterService = gameSystem.getCharacterService();
    characterService.deleteKnownSpell(belvador, knownSpell);

    final List<KnownSpell> knownSpells = belvador.getKnownSpells(spelllistAbility.getSpelllist());
    assertEquals(30, knownSpells.size());

    // tear down
    characterService.createKnownSpell(belvador, knownSpell);
  }

  @Test
  public void testGetCharacterWithSpellSlots() {
    final Character belvador = gameSystem.getCharacter(0);

    final List<SpellSlot> spellSlots = belvador.getSpellSlots();
    assertNotNull("SpellSlots can't be null", spellSlots);
    assertEquals(17, spellSlots.size());

    // spell slots per level
    assertEquals(5, countLevel(spellSlots, 0));
    assertEquals(5, countLevel(spellSlots, 1));
    assertEquals(4, countLevel(spellSlots, 2));
    assertEquals(3, countLevel(spellSlots, 3));

    // number of spells
    assertEquals(2, countSpell(spellSlots, "Detect Magic"));
    assertEquals(1, countSpell(spellSlots, "Ray of Frost"));
    assertEquals(1, countSpell(spellSlots, "Light"));
    assertEquals(1, countSpell(spellSlots, "Mage Hand"));
    assertEquals(1, countSpell(spellSlots, "Mage Armor"));
    assertEquals(1, countSpell(spellSlots, "Mount"));
    assertEquals(3, countSpell(spellSlots, "Magic Missile"));
    assertEquals(2, countSpell(spellSlots, "Acid Arrow"));
    assertEquals(2, countSpell(spellSlots, "Summon Monster II"));
    assertEquals(1, countSpell(spellSlots, "Levitate"));
    assertEquals(1, countSpell(spellSlots, "Summon Monster III"));
    assertEquals(1, countSpell(spellSlots, "Lightning Bolt"));

    // number of SpelllistAbilities
    assertEquals(13, countSpelllistAbility(spellSlots, "Spells - Wizard"));
    assertEquals(4, countSpelllistAbility(spellSlots, "School Specialization - Conjuration"));

    // number of meta magic feats
    assertEquals(1, countMetaMagicFeats(spellSlots));
  }

  private int countSpell(final List<SpellSlot> spellSlots, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getSpell()
          .getName()
          .equals(name)) {
        count++;
      }
    }
    return count;
  }

  private int countLevel(final List<SpellSlot> spellSlots, final int level) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getLevel() == level) {
        count++;
      }
    }
    return count;
  }

  private int countSpelllistAbility(final List<SpellSlot> spellSlots, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      for (final SpelllistAbility spelllistAbility : spellSlot.getSpelllistAbilities()) {
        if (spelllistAbility.getName()
            .equals(name)) {
          count++;
        }
      }
    }
    return count;
  }

  private int countMetaMagicFeats(final List<SpellSlot> spellSlots) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      for (final Feat feat : spellSlot.getMetamagicFeats()) {
        if (feat.getName().equals("Extend Spell")) {
          count++;
        }
      }
    }
    return count;
  }

  @Test
  public void testUpdateSpellSlot() {
    final CharacterService characterService = gameSystem.getCharacterService();
    Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());
    SpellSlot spellSlot = findSpellSlotById(belvador);
    final SpellSlot copySpellSlot = copySpellSlot(spellSlot);

    final Spell detectPoison = gameSystem.getSpelllistService()
        .findSpellByName("Detect Poison", gameSystem.getAllSpells());
    spellSlot.setSpell(detectPoison);
    spellSlot.setCast(true);
    final List<Feat> metamagicFeats = new LinkedList<>();
    metamagicFeats.add(gameSystem.getFeatService()
                           .findFeatByName("Empower Spell", gameSystem.getAllFeats()));
    spellSlot.setMetamagicFeats(metamagicFeats);

    characterService.updateSpellSlot(spellSlot);

    belvador = gameSystem.getCharacter(0);
    spellSlot = findSpellSlotById(belvador);

    assertEquals(copySpellSlot.getId(), spellSlot.getId());
    assertEquals(copySpellSlot.getLevel(), spellSlot.getLevel());
    assertEquals(copySpellSlot.getSpelllistAbilities(), spellSlot.getSpelllistAbilities());
    assertEquals("Detect Poison", spellSlot.getSpell()
        .getName());
    assertEquals(metamagicFeats, spellSlot.getMetamagicFeats());
    assertTrue(spellSlot.isCast());

    // tear down
    characterService.updateSpellSlot(copySpellSlot);
  }

  private SpellSlot findSpellSlotById(final Character character) {
    for (final SpellSlot spellSlot : character.getSpellSlots()) {
      if (spellSlot.getId() == 1) {
        return spellSlot;
      }
    }
    throw new IllegalArgumentException("Can't find spell slot with id: " + 1);
  }

  private SpellSlot copySpellSlot(final SpellSlot spellSlot) {
    final SpellSlot copySpellSlot = new SpellSlot();
    copySpellSlot.setId(spellSlot.getId());
    copySpellSlot.setSpell(spellSlot.getSpell());
    copySpellSlot.setLevel(spellSlot.getLevel());
    copySpellSlot.setCast(spellSlot.isCast());
    copySpellSlot.setSpelllistAbilities(new LinkedList<>(spellSlot.getSpelllistAbilities()));
    copySpellSlot.setMetamagicFeats(new LinkedList<>(spellSlot.getMetamagicFeats()));
    return copySpellSlot;
  }

  @Test
  public void testCreateSpellSlot() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());
    final SpellSlot originalSpellSlot = belvador.getSpellSlots()
        .get(0);
    final SpellSlot newSpellSlot = copySpellSlot(originalSpellSlot);
    newSpellSlot.setId(0);

    final SpellSlot createdSpellSlot = characterService.createSpellSlot(belvador, newSpellSlot);
    assertNotNull(createdSpellSlot);
    assertTrue("Created spell slot must have id > 0", newSpellSlot.getId() > 0);
    assertEquals(18, belvador.getSpellSlots()
        .size());

    // tear down
    characterService.deleteSpellSlot(createdSpellSlot);

  }

  @Test
  public void testCalculateSpellSlot_increaseLevel() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());

    final List<SpellSlot> backupSpellSlots = new LinkedList<>(belvador.getSpellSlots());

    // increase level
    // Wizard (6), INT: 18, Spells - Wizard, School Specialisation - Conjuration
    // Spells-Wizard_: 4, 3, 3, 2
    // Specialisation: 1, 1, 1, 1
    // Intelli. Bonus: 0, 1, 1, 1
    // Total_________: 5, 5, 5, 4 => 19
    belvador.getClassLevels()
        .get(0)
        .setLevel(6);

    final List<SpellSlot> spellSlots = gameSystem.getRuleService()
        .calculateSpellSlots(belvador);
    characterService.updateSpellSlots(belvador, spellSlots);

    assertEquals(19, belvador.getSpellSlots()
        .size());

    // tear down
    for (final SpellSlot spellSlot : belvador.getSpellSlots()) {
      characterService.deleteSpellSlot(spellSlot);
    }
    for (final SpellSlot spellSlot : backupSpellSlots) {
      characterService.createSpellSlot(belvador, spellSlot);
    }
  }

  @Test
  public void testCalculateSpellSlot_decreaseLevel() {
    final CharacterService characterService = gameSystem.getCharacterService();
    final Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());

    final List<SpellSlot> backupSpellSlots = new LinkedList<>(belvador.getSpellSlots());

    // decrease level
    // Wizard (4), INT: 18, Spells - Wizard, School Specialisation - Conjuration
    // Spells-Wizard_: 4, 3, 2, 0
    // Specialisation: 1, 1, 1, 1
    // Intelli. Bonus: 0, 1, 1, 1
    // Total_________: 5, 5, 4, 0 => 14
    belvador.getClassLevels()
        .get(0)
        .setLevel(4);

    final List<SpellSlot> spellSlots = gameSystem.getRuleService()
        .calculateSpellSlots(belvador);
    characterService.updateSpellSlots(belvador, spellSlots);

    assertEquals(14, belvador.getSpellSlots()
        .size());

    // tear down
    for (final SpellSlot spellSlot : belvador.getSpellSlots()) {
      characterService.deleteSpellSlot(spellSlot);
    }
    for (final SpellSlot spellSlot : backupSpellSlots) {
      characterService.createSpellSlot(belvador, spellSlot);
    }
  }

  @Test
  public void testUpdateCharacterSkill() {
    final CharacterService characterService = gameSystem.getCharacterService();
    Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());

    CharacterSkill concentration = findSkillByName(belvador);
    final int modifierBackup = concentration.getModifier();
    concentration.setModifier(-1);

    characterService.updateCharacterSkill(belvador, concentration);
    belvador = gameSystem.getCharacter(0);
    concentration = findSkillByName(belvador);

    assertEquals(-1, concentration.getModifier());

    // tear down
    concentration.setModifier(modifierBackup);
    characterService.updateCharacterSkill(belvador, concentration);
  }

  @Test
  public void testCreateBody() {
    // Arrange
    final CharacterService characterService = gameSystem.getCharacterService();
    Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());

    // Act
    Body body = characterService.createBody(belvador, new HumanoidBody());

    // Assert
    assertNotNull(body);

  }

  @Test
  public void testDeleteBody() {
    // Arrange
    final CharacterService characterService = gameSystem.getCharacterService();
    Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());

    // Act
    characterService.deleteBody(belvador);

    // Assert
    Body body = belvador.getBody();
    for (BodyPart bodyPart : body.getBodyParts()) {
      assertThat(body.getItemOfBodyPart(bodyPart)).isEqualTo(Item.EMPTY_ITEM);
    }
  }

  @Test
  public void testUpdateBody() {
    // Arrange
    final CharacterService characterService = gameSystem.getCharacterService();
    Character belvador = characterService.findCharacterByName("Belvador the Summoner", gameSystem.getAllCharacters());
    belvador.getBody().equip(BodyPart.BOTH_HANDS, Item.EMPTY_ITEM);

    // Act
    Body body = characterService.updateBody(belvador);

    // Assert
    assertThat(body).isNotNull();
    for (BodyPart bodyPart : body.getBodyParts()) {
      assertThat(body.getItemOfBodyPart(bodyPart)).isEqualTo(Item.EMPTY_ITEM);
    }
  }

  private CharacterSkill findSkillByName(final Character character) {
    for (final CharacterSkill characterSkill : character.getCharacterSkills()) {
      final Skill skill = characterSkill.getSkill();
      if (skill.getName().equals("Concentration")) {
        return characterSkill;
      }
    }
    throw new IllegalArgumentException("Can't find character skill with a skill named: " + "Concentration");
  }
}
