package com.d20charactersheet.framework.dac.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.XpTable;
import com.d20charactersheet.framework.boc.service.ImageService;

public abstract class BaseCharacterDaoTest {

  protected CharacterDao characterDao;
  protected ImageDao imageDao;
  protected ClassDao characterClassDao;
  protected SkillDao skillDao;
  protected FeatDao featDao;
  protected RaceDao raceDao;
  protected AbilityDao abilityDao;
  protected SpelllistDao spelllistDao;
  protected XpDao xpDao;

  protected List<CharacterClass> allCharacterClasses;
  protected List<Race> allRaces;
  protected List<XpTable> allXpTables;
  protected List<Ability> allAbilities;
  protected List<Skill> allSkills;
  protected List<Feat> allFeats;

  protected CharacterClass fighter;
  protected CharacterClass wizard;
  protected Race human;

  @Before
  public void setUp() throws Exception {
    allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());
    allSkills = skillDao.getAllSkills();
    allFeats = featDao.getAllFeats();

    allCharacterClasses = characterClassDao.getAllCharacterClasses(allSkills, allAbilities);
    fighter = allCharacterClasses.get(4);
    wizard = allCharacterClasses.get(10);

    allRaces = raceDao.getAllRaces(allCharacterClasses, allAbilities);
    human = allRaces.get(0);

    allXpTables = xpDao.getAllXpTables();
  }

  @After
  public void tearDown() {
    characterDao = null;
    imageDao = null;
    characterClassDao = null;
    skillDao = null;
    raceDao = null;
    abilityDao = null;
    spelllistDao = null;

    allCharacterClasses = null;
    allRaces = null;
    allXpTables = null;

    fighter = null;
    wizard = null;
    human = null;
  }

  @Test
  public void testGetAllCharacters() {
    final List<Character> characters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables);
    assertNotNull(characters);
  }

  @Test
  public void testGetCharacter() {
    final List<Character> characters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables);
    assertNotNull(characters);

    for (final Character character : characters) {
      assertNotNull(characterDao.getCharacter(character.getId(), allCharacterClasses, allRaces, allXpTables));
    }
  }

  @Test
  public void testUpdateAttribute() {
    Character character = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);
    final int oldStrength = character.getStrength();

    character.setStrength(20);
    final Character updatedCharacter = characterDao.updateCharacter(character);
    assertNotNull(updatedCharacter);

    character = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);
    assertEquals(20, character.getStrength());

    character.setStrength(oldStrength);
    character = characterDao.updateCharacter(character);
    assertEquals(oldStrength, character.getStrength());
  }

  @Test
  public void testUpdateClassLevel() {
    final Character belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);
    final List<ClassLevel> oldClassLevels = belvador.getClassLevels();
    assertNotNull(oldClassLevels);

    final List<ClassLevel> classLevels = new ArrayList<>();
    final ClassLevel classLevel = new ClassLevel(wizard, 10);
    classLevels.add(classLevel);
    belvador.setClassLevels(classLevels);

    final Character character = characterDao.updateCharacter(belvador);
    assertEquals(classLevel, character.getClassLevels().get(0));

    character.setClassLevels(oldClassLevels);
    characterDao.updateCharacter(character);
  }

  @Test
  public void testCreateCharacter() {
    final String name = "name";
    final String player = "player";
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = xpDao.getAllXpTables()
        .get(0);

    final Character newCharacter = createCharacter(name, player, race, sex, classLevel, alignment, xpTable);

    // test
    final Character character = characterDao.createCharacter(newCharacter);

    assertNotNull(character);
    assertTrue(character.getId() >= 0);
    assertEquals(name, character.getName());
    assertEquals(player, character.getPlayer());
    assertEquals(race, character.getRace());
    assertEquals(1, character.getClassLevels().size());
    assertEquals(classLevel.getCharacterClass(), character.getClassLevels().get(0).getCharacterClass());
    assertEquals(classLevel.getLevel(), character.getClassLevels().get(0).getLevel());
    assertEquals(alignment, character.getAlignment());

    // clean up
    characterDao.deleteCharacter(character);
  }

  @Test
  public void testDeleteCharacter() {
    final String name = "testDeleteCharacter";
    final String player = "player";
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = xpDao.getAllXpTables()
        .get(0);
    final Character newCharacter = createCharacter(name, player, race, sex, classLevel, alignment, xpTable);
    newCharacter.setStrength(10);
    newCharacter.setDexterity(10);
    newCharacter.setConstitution(10);
    newCharacter.setIntelligence(10);
    newCharacter.setWisdom(10);
    newCharacter.setCharisma(10);
    final Character character = characterDao.createCharacter(newCharacter);
    final int id = character.getId();
    final int numberOfCharacters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables)
        .size();

    // test
    characterDao.deleteCharacter(character);
    final Character deletedCharacter = characterDao.getCharacter(id, allCharacterClasses, allRaces, allXpTables);

    assertNull(deletedCharacter);
    assertEquals(numberOfCharacters - 1, characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables).size());

  }

  private Character createCharacter(final String name, final String player, final Race race, final Sex sex,
      final ClassLevel classLevel, final Alignment alignment, final XpTable xpTable) {
    final Character character = new Character();
    character.setName(name);
    character.setPlayer(player);
    character.setRace(race);
    character.setSex(sex);
    final List<ClassLevel> classLevels = new LinkedList<>();
    classLevels.add(classLevel);
    character.setClassLevels(classLevels);
    character.setAlignment(alignment);
    character.setXpTable(xpTable);
    character.setStrength(1);
    character.setDexterity(1);
    character.setConstitution(1);
    character.setIntelligence(1);
    character.setWisdom(1);
    character.setCharisma(1);
    character.setImageId(ImageService.DEFAULT_CHARACTER_IMAGE_ID);
    character.setThumbImageId(ImageService.DEFAULT_THUMB_IMAGE_ID);
    return character;
  }

  @Test
  public void testGetAllNotes() {
    final Character belvador = new Character();
    belvador.setId(0);
    final List<Note> notes = characterDao.getNotes(belvador);
    assertNotNull(notes);
    assertEquals(0, notes.size());
  }

  @Test
  public void testCreateAndDeleteNote() {
    final Note note = new Note();
    final Date date = new Date();
    note.setDate(date);
    note.setText("newNote");

    final Character belvador = new Character();
    belvador.setId(0);
    characterDao.createNote(note, belvador);
    assertTrue(note.getId() >= 0);

    List<Note> notes = characterDao.getNotes(belvador);
    assertEquals(1, notes.size());

    characterDao.deleteNote(note);
    notes = characterDao.getNotes(belvador);
    assertEquals(0, notes.size());

  }

  @Test
  public void testGetKnownSpells() {
    final Character belvador = new Character();
    belvador.setId(0);

    final List<Spell> allSpells = spelllistDao.getAllSpells();
    final List<Spelllist> allSpelllists = spelllistDao.getAllSpelllists(allSpells);

    final List<KnownSpell> knownSpells = characterDao.getKnownSpells(belvador, allSpelllists, allSpells);
    assertNotNull(knownSpells);
    assertEquals("Wrong number of character spells", 31, knownSpells.size());
    assertTrue(contains("Arcane Mark", knownSpells));
  }

  private boolean contains(final String name, final List<KnownSpell> knownSpells) {
    for (final KnownSpell knownSpell : knownSpells) {
      if (knownSpell.getSpell().getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void testGetSpellSlots() {
    final Character belvador = new Character();
    belvador.setId(0);

    final List<Spell> allSpells = spelllistDao.getAllSpells();

    final List<SpellSlot> spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats);
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
    assertEquals(1, countMetaMagicFeats(spellSlots, "Extend Spell"));
  }

  private int countSpell(final List<SpellSlot> spellSlots, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getSpell().getName().equals(name)) {
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
        if (spelllistAbility.getName().equals(name)) {
          count++;
        }
      }
    }
    return count;
  }

  private int countMetaMagicFeats(final List<SpellSlot> spellSlots, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      for (final Feat feat : spellSlot.getMetamagicFeats()) {
        if (feat.getName().equals(name)) {
          count++;
        }
      }
    }
    return count;
  }

  @Test
  public void testUpdateSpellSlot() {
    final Character belvador = new Character();
    belvador.setId(0);

    final List<Spell> allSpells = spelllistDao.getAllSpells();
    List<SpellSlot> spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats);
    SpellSlot spellSlot = findSpellSlotById(1, spellSlots);
    final SpellSlot copySpellSlot = copySpellSlot(spellSlot);

    final Spell detectPoison = findSpellByName("Detect Poison", allSpells);
    spellSlot.setSpell(detectPoison);
    spellSlot.setCast(true);
    final List<Feat> metamagicFeats = new LinkedList<>();
    metamagicFeats.add(findFeatByName("Empower Spell", allFeats));
    spellSlot.setMetamagicFeats(metamagicFeats);

    characterDao.updateSpellSlot(spellSlot);

    spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats);
    spellSlot = findSpellSlotById(1, spellSlots);

    assertEquals(copySpellSlot.getId(), spellSlot.getId());
    assertEquals(copySpellSlot.getLevel(), spellSlot.getLevel());
    assertEquals(copySpellSlot.getSpelllistAbilities(), spellSlot.getSpelllistAbilities());
    assertEquals("Detect Poison", spellSlot.getSpell().getName());
    assertEquals(metamagicFeats, spellSlot.getMetamagicFeats());
    assertTrue(spellSlot.isCast());

    // tear down
    characterDao.updateSpellSlot(copySpellSlot);

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

  private SpellSlot findSpellSlotById(final int spellSlotId, final List<SpellSlot> spellSlots) {
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getId() == spellSlotId) {
        return spellSlot;
      }
    }
    throw new IllegalArgumentException("Can't find spell slot with id: " + spellSlotId);
  }

  private Spell findSpellByName(final String name, final List<Spell> allSpells) {
    for (final Spell spell : allSpells) {
      if (spell.getName().equals(name)) {
        return spell;
      }
    }
    throw new IllegalArgumentException("Can't find spell with name: " + name);
  }

  private Feat findFeatByName(final String name, final List<Feat> allFeats) {
    for (final Feat feat : allFeats) {
      if (feat.getName().equals(name)) {
        return feat;
      }
    }
    throw new IllegalArgumentException("Can't find feat with name: " + name);
  }

  @Test
  public void testCreateSpellSlot() {
    final List<Spell> allSpells = spelllistDao.getAllSpells();

    final Character character = new Character();
    character.setId(0);

    SpellSlot spellSlot = new SpellSlot();
    spellSlot.setSpell(findSpellByName("Magic Missile", allSpells));
    spellSlot.setLevel(1);
    spellSlot.setCast(true);
    List<SpelllistAbility> spelllistAbilities = new ArrayList<>(1);
    spelllistAbilities.add((SpelllistAbility) findAbilityByName("Spells - Wizard", allAbilities));
    spellSlot.setSpelllistAbilities(spelllistAbilities);

    List<Feat> metamagicFeats = new ArrayList<>(1);
    metamagicFeats.add(findFeatByName("Extend Spell", featDao.getAllFeats()));
    spellSlot.setMetamagicFeats(metamagicFeats);

    spellSlot = characterDao.createSpellSlot(character, spellSlot);
    assertNotNull(spellSlot);
    final int spellSlotId = spellSlot.getId();
    assertTrue(spellSlotId > 0);

    final List<SpellSlot> spellSlots = characterDao.getSpellSlots(character, allSpells, allAbilities, allFeats);
    final SpellSlot createdSpellSlot = findSpellSlotById(spellSlotId, spellSlots);

    assertEquals("Magic Missile", createdSpellSlot.getSpell().getName());
    assertEquals(1, createdSpellSlot.getLevel());
    assertTrue(createdSpellSlot.isCast());

    spelllistAbilities = createdSpellSlot.getSpelllistAbilities();
    assertNotNull(spelllistAbilities);
    assertEquals(1, spelllistAbilities.size());
    assertEquals("Spells - Wizard", createdSpellSlot.getSpelllistAbilities().get(0).getName());

    metamagicFeats = createdSpellSlot.getMetamagicFeats();
    assertNotNull(metamagicFeats);
    assertEquals(1, metamagicFeats.size());
    assertEquals("Extend Spell", metamagicFeats.get(0).getName());

    // tear down
    characterDao.deleteSpellSlot(createdSpellSlot);
  }

  private Ability findAbilityByName(final String name, final List<Ability> allAbilities) {
    for (final Ability ability : allAbilities) {
      if (ability.getName().equals(name)) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't find ability with name: " + name);
  }

  @Test
  public void testUpdateCharacterSkill() {
    final Character belvador = new Character();
    belvador.setId(0);

    List<CharacterSkill> characterSkills = characterDao.getCharacterSkills(belvador, allSkills);
    CharacterSkill concentration = findSkillByName(characterSkills, "Concentration");
    final int modifierBackup = concentration.getModifier();
    concentration.setModifier(-1);

    characterDao.updateCharacterSkill(belvador, concentration);

    characterSkills = characterDao.getCharacterSkills(belvador, allSkills);
    concentration = findSkillByName(characterSkills, "Concentration");

    assertEquals(-1, concentration.getModifier());

    // tear down
    concentration.setModifier(modifierBackup);
    characterDao.updateCharacterSkill(belvador, concentration);

  }

  private CharacterSkill findSkillByName(final List<CharacterSkill> characterSkills, final String name) {
    for (final CharacterSkill characterSkill : characterSkills) {
      final Skill skill = characterSkill.getSkill();
      if (skill.getName().equals(name)) {
        return characterSkill;
      }
    }
    throw new IllegalArgumentException("Can't find character skill with a skill named: " + name);
  }

}
