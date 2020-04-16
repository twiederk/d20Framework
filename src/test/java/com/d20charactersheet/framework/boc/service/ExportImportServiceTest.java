package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;
import com.d20charactersheet.framework.boc.service.exportimport.ImportReport;

public class ExportImportServiceTest {

  public static final File EXPORT_DIR = new File("target/xml");
  public static final File EXPORT_CHARACTERS_FILE = new File(EXPORT_DIR, "d20cs_characters_unit_test.xml");
  public static final File EXPORT_EQUIPMENT_FILE = new File(EXPORT_DIR, "d20cs_equipment_unit_test.xml");

  public static final File IMPORT_DIR = new File("src/test/resources/exportimport");
  public static final File IMPORT_CHARACTER_V1_FILE = new File(IMPORT_DIR, "d20cs_characters_v1_unit_test.xml");
  public static final File IMPORT_CHARACTER_V2_FILE = new File(IMPORT_DIR, "d20cs_characters_v2_unit_test.xml");
  public static final File IMPORT_EQUIPMENT_V1_FILE = new File(IMPORT_DIR, "d20cs_equipment_v1_unit_test.xml");

  private GameSystem gameSystem;
  private ExportImportService exportImportService;

  @Before
  public void setUp() {
    final Universe universe = new DnDv35Universe();
    gameSystem = universe.getGameSystem();
    exportImportService = new ExportImportServiceImpl();

    if (!EXPORT_DIR.exists()) {
      EXPORT_DIR.mkdir();
    }
  }

  @Test
  @Ignore
  public void testExportCharacters() throws Exception {
    final Character belvador = gameSystem.getCharacter(0);

    // test note
    final Date noteDate = new SimpleDateFormat("yyyyMMdd HH:mm").parse("20130413 15:30");
    final String noteText = "My test note!";
    final List<Note> notes = new ArrayList<>();
    final Note note = new Note();
    note.setDate(noteDate);
    note.setText(noteText);
    notes.add(note);
    belvador.setNotes(notes);

    // test armor
    final ItemGroup itemGroup = new ItemGroup();
    itemGroup.setItem(gameSystem.getAllArmor().get(0));
    itemGroup.setNumber(2);
    belvador.getEquipment().getArmor().add(itemGroup);

    final List<Character> characters = new LinkedList<>();
    characters.add(belvador);

    final File exportFile = exportImportService.exportCharacters(gameSystem, EXPORT_CHARACTERS_FILE, characters);
    assertNotNull("Missing export file of characters", exportFile);

    belvador.getNotes().clear();
    belvador.getEquipment().getArmor().clear();
  }

  @Test
  @Ignore
  public void testImportCharactersV1() throws Exception {
    final List<ImportReport<Character>> importReports = exportImportService.importCharacters(gameSystem, IMPORT_CHARACTER_V1_FILE);

    assertNotNull(importReports);
    assertEquals(1, importReports.size());

    final Character belvador = importReports.get(0).getImportObject();

    assertAppearance(belvador);
    assertAttributes(belvador);
    assertCombat(belvador);
    assertSaves(belvador);
    assertMoney(belvador);
    assertNotes(belvador);
    assertAttacks(belvador);
    assertSkills(belvador);
    assertFeats(belvador);
    assertKnownSpells(belvador);
    assertWeapons(belvador);
    assertArmor(belvador);
    assertGoods(belvador);
  }

  @Test
  @Ignore
  public void testImportCharactersV2() throws Exception {
    final List<ImportReport<Character>> importReports = exportImportService.importCharacters(gameSystem, IMPORT_CHARACTER_V2_FILE);

    assertNotNull(importReports);
    assertEquals(1, importReports.size());

    final ImportReport<Character> importReport = importReports.get(0);
    assertTrue(importReport.getImportMessages().toString(), importReport.isSuccess());
    assertEquals(importReport.getImportMessages().toString(), 0, importReport.getImportMessages().size());

    final Character belvador = importReport.getImportObject();

    assertAppearance(belvador);
    assertAttributes(belvador);
    assertCombat(belvador);
    assertSaves(belvador);
    assertMoney(belvador);
    assertNotes(belvador);
    assertAttacks(belvador);
    assertSkills(belvador);
    assertFeats(belvador);
    assertKnownSpells(belvador);
    assertSpellSlots(belvador);
    assertWeapons(belvador);
    assertArmor(belvador);
    assertGoods(belvador);

  }

  private void assertAppearance(final Character belvador) {
    assertEquals("Belvador the Summoner", belvador.getName());
    assertEquals("Torsten", belvador.getPlayer());
    assertEquals(2, belvador.getRace().getId());
    assertEquals(Sex.MALE, belvador.getSex());

    final List<ClassLevel> classLevels = belvador.getClassLevels();
    assertNotNull(classLevels);
    assertEquals(1, classLevels.size());
    final ClassLevel classLevel = classLevels.get(0);
    assertEquals(10, classLevel.getCharacterClass().getId());
    assertEquals(5, classLevel.getLevel());
    final List<CharacterAbility> characterAbilities = classLevel.getCharacterAbilities();
    assertNotNull(characterAbilities);
    assertEquals(16, characterAbilities.size());
    assertEquals(8, getNumberOfOwnedCharacterAbilities(characterAbilities));

    assertEquals(Alignment.CHAOTIC_GOOD, belvador.getAlignment());
    assertEquals(13129, belvador.getExperiencePoints());
    assertEquals(1, belvador.getXpTable().getId());
  }

  private Object getNumberOfOwnedCharacterAbilities(final List<CharacterAbility> characterAbilities) {
    int numberOfOwnedCharacterAbilities = 0;
    for (final CharacterAbility characterAbility : characterAbilities) {
      if (characterAbility.isOwned()) {
        numberOfOwnedCharacterAbilities++;
      }
    }
    return numberOfOwnedCharacterAbilities;
  }

  private void assertAttributes(final Character belvador) {
    assertEquals(11, belvador.getStrength());
    assertEquals(18, belvador.getDexterity());
    assertEquals(17, belvador.getConstitution());
    assertEquals(18, belvador.getIntelligence());
    assertEquals(11, belvador.getWisdom());
    assertEquals(15, belvador.getCharisma());
  }

  private void assertCombat(final Character belvador) {
    assertEquals(26, belvador.getHitPoints());
    assertEquals(26, belvador.getMaxHitPoints());
    assertEquals(0, belvador.getArmorClass());
    assertEquals(0, belvador.getInitiativeModifier());
    assertEquals(0, belvador.getCmbModifier());
    assertEquals(0, belvador.getCmdModifier());
  }

  private void assertSaves(final Character belvador) {
    assertEquals(0, belvador.getFortitudeModifier());
    assertEquals(0, belvador.getReflexModifier());
    assertEquals(0, belvador.getWillModifier());
  }

  private void assertMoney(final Character belvador) {
    assertEquals(1, belvador.getMoney().getPlatinum());
    assertEquals(2, belvador.getMoney().getGold());
    assertEquals(3, belvador.getMoney().getSilver());
    assertEquals(4, belvador.getMoney().getCopper());
  }

  private void assertNotes(final Character belvador) {
    final List<Note> notes = belvador.getNotes();
    assertNotNull(notes);
    assertEquals(1, notes.size());
    final Note note = notes.get(0);

    try {
      final Date noteDate = new SimpleDateFormat("yyyyMMdd HH:mm").parse("20130413 15:30");
      assertEquals(noteDate, note.getDate());
      assertEquals("My test note!", note.getText());
    } catch (final ParseException parseException) {
      parseException.printStackTrace();
      fail("Can't create noteDate");
    }

  }

  private void assertAttacks(final Character belvador) {
    final List<WeaponAttack> weaponAttacks = belvador.getWeaponAttacks();
    assertNotNull(weaponAttacks);
    assertEquals(3, weaponAttacks.size());

    final WeaponAttack weaponAttack = weaponAttacks.get(0);
    assertEquals("Quarterstaff", weaponAttack.getName());
    assertEquals("My good old quaterstaff", weaponAttack.getDescription());
    assertEquals(AttackWield.TWO_HANDED, weaponAttack.getAttackWield());
    assertEquals(11, weaponAttack.getWeapon().getId());
    assertEquals("Quarterstaff", weaponAttack.getWeapon().getName());
    assertEquals(0, weaponAttack.getAttackBonusModifier());
    assertEquals(0, weaponAttack.getDamageBonusModifier());

  }

  private void assertSkills(final Character belvador) {
    final List<CharacterSkill> characterSkills = belvador.getCharacterSkills();
    assertNotNull(characterSkills);
    assertEquals(10, characterSkills.size());

    final CharacterSkill concentration = characterSkills.get(0);
    assertEquals("Concentration", concentration.getSkill().getName());
    assertEquals(8.0f, concentration.getRank(), 0.0f);
    assertEquals(0, concentration.getModifier());
  }

  private void assertFeats(final Character belvador) {
    final List<CharacterFeat> characterFeats = belvador.getCharacterFeats();
    assertNotNull(characterFeats);
    assertEquals(3, characterFeats.size());

    final CharacterFeat characterFeat = characterFeats.get(2);
    assertEquals("Spell Focus", characterFeat.getFeat().getName());
    assertEquals("Summoning", characterFeat.getCategory());
  }

  private void assertKnownSpells(final Character belvador) {
    final SpelllistAbility spelllistAbility = belvador.getSpelllistAbilities().get(0);
    final List<KnownSpell> knownSpells = belvador.getKnownSpells(spelllistAbility.getSpelllist());
    assertNotNull(knownSpells);
    assertEquals(31, knownSpells.size());

    final KnownSpell knownSpell = knownSpells.get(0);
    assertNotNull("Spell can't be null", knownSpell.getSpell());
    assertEquals("Arcane Mark", knownSpell.getSpell().getName());
    assertNotNull("Spelllist can't be null", knownSpell.getSpelllist());
    assertEquals("Wizard", knownSpell.getSpelllist().getName());
  }

  private void assertSpellSlots(final Character belvador) {
    final List<SpellSlot> spellSlots = belvador.getSpellSlots();
    assertNotNull(spellSlots);
    assertEquals(17, spellSlots.size());

    // <spellslot><spell>Detect
    // Magic</spell><level>0</level><cast>false</cast><spelllistabilities><spellistability>Spells -
    // Wizard</spellistability></spelllistabilities><metamagicfeats/></spellslot>
    SpellSlot spellSlot = spellSlots.get(0);
    assertNotNull(spellSlot.getSpell());
    assertEquals("Detect Magic", spellSlot.getSpell().getName());
    assertEquals(0, spellSlot.getLevel());
    assertFalse(spellSlot.isCast());
    List<SpelllistAbility> spelllistAbilities = spellSlot.getSpelllistAbilities();
    assertNotNull(spelllistAbilities);
    assertEquals(1, spelllistAbilities.size());
    assertEquals("Spells - Wizard", spelllistAbilities.get(0).getName());
    assertNotNull(spellSlot.getMetamagicFeats());
    assertEquals(0, spellSlot.getMetamagicFeats().size());

    // <spellslot><spell>Summon Monster
    // II</spell><level>3</level><cast>false</cast><spelllistabilities><spellistability>Spells -
    // Wizard</spellistability></spelllistabilities><metamagicfeats><metamagicfeat>Extend
    // Spell</metamagicfeat></metamagicfeats></spellslot>
    spellSlot = spellSlots.get(12);
    assertNotNull(spellSlot.getSpell());
    assertEquals("Summon Monster II", spellSlot.getSpell().getName());
    assertEquals(3, spellSlot.getLevel());
    assertFalse(spellSlot.isCast());
    spelllistAbilities = spellSlot.getSpelllistAbilities();
    assertNotNull(spelllistAbilities);
    assertEquals(1, spelllistAbilities.size());
    assertEquals("Spells - Wizard", spelllistAbilities.get(0).getName());
    final List<Feat> metamagicFeats = spellSlot.getMetamagicFeats();
    assertNotNull(metamagicFeats);
    assertEquals(1, metamagicFeats.size());
    assertEquals("Extend Spell", metamagicFeats.get(0).getName());
  }

  private void assertWeapons(final Character belvador) {
    final List<ItemGroup> weapons = belvador.getEquipment().getWeapons();
    assertNotNull(weapons);
    assertEquals(3, weapons.size());

    final ItemGroup quaterstaff = weapons.get(0);
    assertEquals("Quarterstaff", quaterstaff.getItem().getName());
    assertEquals(1, quaterstaff.getNumber());
  }

  private void assertArmor(final Character belvador) {
    final List<ItemGroup> armor = belvador.getEquipment().getArmor();
    assertNotNull(armor);
    assertEquals(1, armor.size());

    final ItemGroup padded = armor.get(0);
    assertEquals("Padded", padded.getItem().getName());
    assertEquals(2, padded.getNumber());
  }

  private void assertGoods(final Character belvador) {
    final List<ItemGroup> goods = belvador.getEquipment().getGoods();
    assertNotNull(goods);
    assertEquals(19, goods.size());

    final ItemGroup padded = goods.get(0);
    assertEquals("Backpack", padded.getItem().getName());
    assertEquals(1, padded.getNumber());
  }

  @Test
  @Ignore
  public void testExportEquipment() throws Exception {
    final List<Weapon> weapons = gameSystem.getAllWeapons();
    final List<Armor> armor = gameSystem.getAllArmor();
    final List<Good> goods = gameSystem.getAllGoods();
    final File exportFile = exportImportService.exportEquipment(gameSystem, EXPORT_EQUIPMENT_FILE, weapons, armor, goods);
    assertNotNull("Missing export file of weapons", exportFile);
  }

  @Test
  @Ignore
  public void testImportEquipment() throws Exception {
    final List<ImportReport<? extends Item>> importReports = exportImportService
        .importEquipment(gameSystem, IMPORT_EQUIPMENT_V1_FILE);

    assertNotNull("Import reports can't be null", importReports);
    assertEquals(279, importReports.size());

    final Weapon dagger = (Weapon) getItemByName("Dagger", importReports);
    final WeaponFamily weaponFamily = getWeaponFamilyByName("Dagger");
    assertWeapon("Dagger", 2.0f, 1.0f, QualityType.NORMAL,
                 "You get a +2 bonus on Sleight of Hand checks made to conceal a dagger on your body (see the Sleight of Hand skill)",
                 WeaponType.SIMPLE, new Damage(1, Die.D4), new Critical(19, 2), CombatType.MELEE_WEAPON,
                 WeaponEncumbrance.LIGHT_HANDED, WeaponCategory.NORMAL_WEAPON, 0, weaponFamily, 10, dagger);

    final Armor scaleMail = (Armor) getItemByName("Scale Mail", importReports);
    assertArmor("Scale Mail", 50.0f, 30.0f, QualityType.NORMAL, "The suit includes gauntlets.", ArmorType.MEDIUM, 4, -4, scaleMail);

    final Good winterBlanket = (Good) getItemByName("Winter Blanket", importReports);
    assertGood("Winter Blanket", 0.5f, 3f, QualityType.NORMAL,
               "A thick, quilted, wool blanket made to keep you warm in cold weather.", GoodType.ADVENTURING_GEAR, winterBlanket);

  }

  private WeaponFamily getWeaponFamilyByName(final String name) {
    for (final WeaponFamily weaponFamily : gameSystem.getAllWeaponFamilies()) {
      if (weaponFamily.getName().equals(name)) {
        return weaponFamily;
      }
    }
    throw new IllegalArgumentException("Can't find weapon family with name: " + name);
  }

  private void assertWeapon(final String name, final float cost, final float weight, final QualityType qualityType,
      final String description, final WeaponType weaponType, final Damage damage, final Critical critical,
      final CombatType combatType, final WeaponEncumbrance weaponEncumbrance, final WeaponCategory weaponCategory,
      final int enhancementBonus, final WeaponFamily weaponFamily, final int rangeIncrement, final Weapon weapon) {
    assertItem(name, cost, weight, qualityType, description, weapon);
    assertEquals(weaponType, weapon.getWeaponType());
    assertEquals(damage, weapon.getDamage());
    assertEquals(critical, weapon.getCritical());
    assertEquals(combatType, weapon.getCombatType());
    assertEquals(weaponEncumbrance, weapon.getWeaponEncumbrance());
    assertEquals(weaponCategory, weapon.getWeaponCategory());
    assertEquals(enhancementBonus, weapon.getEnhancementBonus());
    assertEquals(weaponFamily, weapon.getWeaponFamily());
    assertEquals(rangeIncrement, weapon.getRangeIncrement());
  }

  private void assertArmor(final String name, final float cost, final float weight, final QualityType qualityType,
      final String description, final ArmorType armorType, final int bonus, final int penalty, final Armor armor) {
    assertItem(name, cost, weight, qualityType, description, armor);
    assertEquals(armorType, armor.getArmorType());
    assertEquals(bonus, armor.getArmorBonus());
    assertEquals(penalty, armor.getArmorCheckPenalty());
  }

  private void assertGood(final String name, final float cost, final float weight, final QualityType qualityType,
      final String description, final GoodType goodType, final Good good) {
    assertItem(name, cost, weight, qualityType, description, good);
    assertEquals(goodType, good.getGoodType());
  }

  private void assertItem(final String name, final float cost, final float weight, final QualityType qualityType,
      final String description, final Item item) {
    assertEquals(name, item.getName());
    assertEquals(cost, item.getCost(), 0.0f);
    assertEquals(weight, item.getWeight(), 0.0f);
    assertEquals(qualityType, item.getQualityType());
    assertEquals(description, item.getDescription());
  }

  private Item getItemByName(final String name, final List<ImportReport<? extends Item>> importReports) {
    for (final ImportReport<? extends Item> importReport : importReports) {
      final Item item = importReport.getImportObject();
      if (item.getName().equals(name)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Can't find item with name: " + name);
  }

}
