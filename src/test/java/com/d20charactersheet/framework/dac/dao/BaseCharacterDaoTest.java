package com.d20charactersheet.framework.dac.dao;

import static org.assertj.core.api.Assertions.assertThat;

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

    // Act
    final List<Character> characters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables);

    // Assert
    assertThat(characters).hasSize(1);
  }

  @Test
  public void testGetCharacter() {

    // Act
    Character belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);

    // Assert
    assertThat(belvador).isNotNull();
  }

  @Test
  public void testUpdateAttribute() {
    // Arrange
    Character character = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);
    final int oldStrength = character.getStrength();
    character.setStrength(20);

    // Act
    final Character updatedCharacter = characterDao.updateCharacter(character);

    // Assert
    assertThat(updatedCharacter).isNotNull();
    character = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);
    assertThat(character.getStrength()).isEqualTo(20);

    // tear down
    character.setStrength(oldStrength);
    characterDao.updateCharacter(character);
  }

  @Test
  public void testUpdateClassLevel() {
    // Arrange
    final Character belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);
    final List<ClassLevel> oldClassLevels = belvador.getClassLevels();

    final List<ClassLevel> classLevels = new ArrayList<>();
    final ClassLevel classLevel = new ClassLevel(wizard, 10);
    classLevels.add(classLevel);
    belvador.setClassLevels(classLevels);

    // Act
    final Character character = characterDao.updateCharacter(belvador);

    // Assert
    assertThat(character.getClassLevels().get(0)).isEqualTo(classLevel);

    // tear down
    character.setClassLevels(oldClassLevels);
    characterDao.updateCharacter(character);
  }

  @Test
  public void testCreateCharacter() {
    // Arrange
    final String name = "name";
    final String player = "player";
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = xpDao.getAllXpTables().get(0);

    final Character newCharacter = createCharacter(name, race, sex, classLevel, alignment, xpTable);

    // Act
    final Character character = characterDao.createCharacter(newCharacter);

    // Assert
    assertThat(character).isNotNull();
    assertThat(character.getId()).isGreaterThanOrEqualTo(0);
    assertThat(character.getName()).isEqualTo(name);
    assertThat(character.getPlayer()).isEqualTo(player);
    assertThat(character.getRace()).isEqualTo(race);
    assertThat(character.getClassLevels()).hasSize(1);
    assertThat(character.getClassLevels().get(0).getCharacterClass()).isEqualTo(classLevel.getCharacterClass());
    assertThat(character.getClassLevels().get(0).getLevel()).isEqualTo(classLevel.getLevel());
    assertThat(character.getAlignment()).isEqualTo(alignment);

    // tear down
    characterDao.deleteCharacter(character);
  }

  @Test
  public void testDeleteCharacter() {
    // Arrange
    final String name = "testDeleteCharacter";
    final Race race = human;
    final Sex sex = Sex.MALE;
    final ClassLevel classLevel = new ClassLevel(fighter, 1);
    final Alignment alignment = Alignment.NEUTRAL;
    final XpTable xpTable = xpDao.getAllXpTables().get(0);
    final Character newCharacter = createCharacter(name, race, sex, classLevel, alignment, xpTable);
    newCharacter.setStrength(10);
    newCharacter.setDexterity(10);
    newCharacter.setConstitution(10);
    newCharacter.setIntelligence(10);
    newCharacter.setWisdom(10);
    newCharacter.setCharisma(10);
    final Character character = characterDao.createCharacter(newCharacter);
    final int id = character.getId();
    final int numberOfCharacters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables).size();

    // Act
    characterDao.deleteCharacter(character);

    // Assert
    final Character deletedCharacter = characterDao.getCharacter(id, allCharacterClasses, allRaces, allXpTables);
    assertThat(deletedCharacter).isNull();
    assertThat(characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables)).hasSize(numberOfCharacters - 1);

  }

  private Character createCharacter(final String name, final Race race, final Sex sex, final ClassLevel classLevel,
      final Alignment alignment, final XpTable xpTable) {
    final Character character = new Character();
    character.setName(name);
    character.setPlayer("player");
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
    // Arrange
    final Character belvador = new Character();
    belvador.setId(0);

    // Act
    final List<Note> notes = characterDao.getNotes(belvador);

    // Assert
    assertThat(notes).hasSize(0);
  }

  @Test
  public void testCreateNote() {
    // Arrange
    final Note note = new Note();
    final Date date = new Date();
    note.setDate(date);
    note.setText("newNote");

    final Character belvador = new Character();
    belvador.setId(0);

    // Act
    characterDao.createNote(note, belvador);

    // Assert
    assertThat(note.getId()).isGreaterThanOrEqualTo(0);

    List<Note> notes = characterDao.getNotes(belvador);
    assertThat(notes).hasSize(1);

    // tear down
    characterDao.deleteNote(note);

  }

  @Test
  public void testDeleteNote() {
    // Arrange
    final Note note = new Note();
    final Date date = new Date();
    note.setDate(date);
    note.setText("newNote");

    final Character belvador = new Character();
    belvador.setId(0);
    characterDao.createNote(note, belvador);

    // Act
    characterDao.deleteNote(note);

    // Assert
    List<Note> notes = characterDao.getNotes(belvador);
    assertThat(notes).hasSize(0);
  }

  @Test
  public void testGetKnownSpells() {
    // Arrange
    final Character belvador = new Character();
    belvador.setId(0);

    final List<Spell> allSpells = spelllistDao.getAllSpells();
    final List<Spelllist> allSpelllists = spelllistDao.getAllSpelllists(allSpells);

    // Act
    final List<KnownSpell> knownSpells = characterDao.getKnownSpells(belvador, allSpelllists, allSpells);

    // Assert
    assertThat(knownSpells).hasSize(31);
    assertThat(contains(knownSpells)).isTrue();
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
  public void testGetSpellSlots() {
    // Arrange
    final Character belvador = new Character();
    belvador.setId(0);
    final List<Spell> allSpells = spelllistDao.getAllSpells();

    // Act
    final List<SpellSlot> spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats);

    // Assert
    assertThat(spellSlots).hasSize(17);

    // spell slots per level
    assertThat(countLevel(spellSlots, 0)).isEqualTo(5);
    assertThat(countLevel(spellSlots, 1)).isEqualTo(5);
    assertThat(countLevel(spellSlots, 2)).isEqualTo(4);
    assertThat(countLevel(spellSlots, 3)).isEqualTo(3);

    // number of spells
    assertThat(countSpell(spellSlots, "Detect Magic")).isEqualTo(2);
    assertThat(countSpell(spellSlots, "Ray of Frost")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Light")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Mage Hand")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Mage Armor")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Mount")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Magic Missile")).isEqualTo(3);
    assertThat(countSpell(spellSlots, "Acid Arrow")).isEqualTo(2);
    assertThat(countSpell(spellSlots, "Summon Monster II")).isEqualTo(2);
    assertThat(countSpell(spellSlots, "Levitate")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Summon Monster III")).isEqualTo(1);
    assertThat(countSpell(spellSlots, "Lightning Bolt")).isEqualTo(1);

    // number of SpelllistAbilities
    assertThat(countSpelllistAbility(spellSlots, "Spells - Wizard")).isEqualTo(13);
    assertThat(countSpelllistAbility(spellSlots, "School Specialization - Conjuration")).isEqualTo(4);

    // number of meta magic feats
    assertThat(countMetaMagicFeats(spellSlots)).isEqualTo(1);
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
    // Arrange
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

    // Act
    characterDao.updateSpellSlot(spellSlot);

    // Assert
    spellSlots = characterDao.getSpellSlots(belvador, allSpells, allAbilities, allFeats);
    spellSlot = findSpellSlotById(1, spellSlots);

    assertThat(spellSlot.getId()).isEqualTo(copySpellSlot.getId());
    assertThat(spellSlot.getLevel()).isEqualTo(copySpellSlot.getLevel());
    assertThat(spellSlot.getSpelllistAbilities()).isEqualTo(copySpellSlot.getSpelllistAbilities());
    assertThat(spellSlot.getSpell().getName()).isEqualTo("Detect Poison");
    assertThat(spellSlot.getMetamagicFeats()).isEqualTo(metamagicFeats);
    assertThat(spellSlot.isCast()).isTrue();

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
    // Arrange
    final List<Spell> allSpells = spelllistDao.getAllSpells();

    final Character character = new Character();
    character.setId(0);

    SpellSlot spellSlot = new SpellSlot();
    spellSlot.setSpell(findSpellByName("Magic Missile", allSpells));
    spellSlot.setLevel(1);
    spellSlot.setCast(true);
    List<SpelllistAbility> spelllistAbilities = new ArrayList<>(1);
    spelllistAbilities.add((SpelllistAbility) findAbilityByName(allAbilities));
    spellSlot.setSpelllistAbilities(spelllistAbilities);

    List<Feat> metamagicFeats = new ArrayList<>(1);
    metamagicFeats.add(findFeatByName("Extend Spell", featDao.getAllFeats()));
    spellSlot.setMetamagicFeats(metamagicFeats);

    // Act
    spellSlot = characterDao.createSpellSlot(character, spellSlot);

    // Assert
    assertThat(spellSlot).isNotNull();
    final int spellSlotId = spellSlot.getId();
    assertThat(spellSlotId).isGreaterThan(0);

    final List<SpellSlot> spellSlots = characterDao.getSpellSlots(character, allSpells, allAbilities, allFeats);
    final SpellSlot createdSpellSlot = findSpellSlotById(spellSlotId, spellSlots);

    assertThat(createdSpellSlot.getSpell().getName()).isEqualTo("Magic Missile");
    assertThat(createdSpellSlot.getLevel()).isEqualTo(1);
    assertThat(createdSpellSlot.isCast()).isTrue();

    spelllistAbilities = createdSpellSlot.getSpelllistAbilities();
    assertThat(spelllistAbilities).hasSize(1);
    assertThat(createdSpellSlot.getSpelllistAbilities().get(0).getName()).isEqualTo("Spells - Wizard");

    metamagicFeats = createdSpellSlot.getMetamagicFeats();
    assertThat(metamagicFeats).hasSize(1);
    assertThat(metamagicFeats.get(0).getName()).isEqualTo("Extend Spell");

    // tear down
    characterDao.deleteSpellSlot(createdSpellSlot);
  }

  private Ability findAbilityByName(final List<Ability> allAbilities) {
    for (final Ability ability : allAbilities) {
      if (ability.getName().equals("Spells - Wizard")) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't find ability with name: " + "Spells - Wizard");
  }

  @Test
  public void testUpdateCharacterSkill() {
    // Arrange
    final Character belvador = new Character();
    belvador.setId(0);

    List<CharacterSkill> characterSkills = characterDao.getCharacterSkills(belvador, allSkills);
    CharacterSkill concentration = findSkillByName(characterSkills);
    final int modifierBackup = concentration.getModifier();
    concentration.setModifier(-1);

    // Act
    characterDao.updateCharacterSkill(belvador, concentration);

    // Assert
    characterSkills = characterDao.getCharacterSkills(belvador, allSkills);
    concentration = findSkillByName(characterSkills);

    assertThat(concentration.getModifier()).isEqualTo(-1);

    // tear down
    concentration.setModifier(modifierBackup);
    characterDao.updateCharacterSkill(belvador, concentration);

  }

  private CharacterSkill findSkillByName(final List<CharacterSkill> characterSkills) {
    for (final CharacterSkill characterSkill : characterSkills) {
      final Skill skill = characterSkill.getSkill();
      if (skill.getName().equals("Concentration")) {
        return characterSkill;
      }
    }
    throw new IllegalArgumentException("Can't find character skill with a skill named: " + "Concentration");
  }

}
