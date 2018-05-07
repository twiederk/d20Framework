package com.d20charactersheet.framework.boc.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
import com.d20charactersheet.framework.boc.service.BodyService;
import com.d20charactersheet.framework.boc.service.CharacterClassService;
import com.d20charactersheet.framework.boc.service.GameSystem;

public class CharacterTest {

  private Character character;
  private GameSystem gameSystem;
  private CharacterClassService characterClassService;

  @Before
  public void setUp() throws Exception {
    final Universe universe = new DnDv35Universe();
    gameSystem = universe.getGameSystem();
    characterClassService = gameSystem.getCharacterClassService();
    character = new Character();
  }

  @Test
  public void testGetCharacterLevel() throws Exception {
    final List<ClassLevel> classLevels = new LinkedList<ClassLevel>();

    final CharacterClass wizard = characterClassService.findClassByName("Wizard", gameSystem.getAllCharacterClasses());
    final CharacterClass bard = characterClassService.findClassByName("Bard", gameSystem.getAllCharacterClasses());

    classLevels.add(new ClassLevel(wizard, 4));
    character.setClassLevels(classLevels);

    assertEquals(4, character.getCharacterLevel());

    classLevels.add(new ClassLevel(bard, 3));
    assertEquals(7, character.getCharacterLevel());
  }

  @Test
  public void testCheckAttributeNegativeValue() throws Exception {
    try {
      character.setStrength(-1);
      fail("Missing exception. Expected RuleException");
    } catch (final RuleException ruleException) {
      // expected exception => OK
    } catch (final Exception exception) {
      fail("Wrong exception. Expected RuleException");
    }
  }

  @Test
  public void testCheckAttributeZeroValue() throws Exception {
    try {
      character.setStrength(0);
      fail("Missing exception. Expected RuleException");
    } catch (final RuleException ruleException) {
      // expected exception => OK
    } catch (final Exception exception) {
      fail("Wrong exception. Expected RuleException");
    }
  }

  @Test
  public void testCheckAttributeAllowedValue() throws Exception {
    character.setStrength(1);
    character.setStrength(5);
    character.setStrength(10);
    character.setStrength(15);
    character.setStrength(20);
    character.setStrength(50);
    character.setStrength(99);
  }

  @Test
  public void testCheckAttributeToHighValue() throws Exception {
    try {
      character.setStrength(100);
      fail("Missing exception. Expected RuleException");
    } catch (final RuleException ruleException) {
      // expected exception => OK
    } catch (final Exception exception) {
      fail("Wrong exception. Expected RuleException");
    }
  }

  @Test
  public void testSetExperiencePointsNegative() throws Exception {
    try {
      character.setExperiencePoints(-1);
      fail("Missing exception. Expected RuleException");
    } catch (final RuleException ruleException) {
      // expected exception => OK
    } catch (final Exception exception) {
      fail("Wrong exception. Expected RuleException");
    }
  }

  @Test
  public void testSetClassLevels() throws Exception {
    final CharacterClass barbarian = characterClassService.findClassByName("Barbarian", gameSystem.getAllCharacterClasses());
    final ClassLevel classLevel = new ClassLevel(barbarian);
    classLevel.setLevel(0);
    final List<ClassLevel> classLevels = new LinkedList<ClassLevel>();
    classLevels.add(classLevel);

    try {
      character.setClassLevels(classLevels);
      fail("Missing exception. Expected RuleException");
    } catch (final RuleException ruleException) {
      // expected exception => OK
    } catch (final Exception exception) {
      fail("Wrong exception. Expected RuleException");
    }
  }

  @Test
  public void testGetCharacterClasses() throws Exception {
    final List<ClassLevel> classLevels = new LinkedList<ClassLevel>();

    final CharacterClass wizard = characterClassService.findClassByName("Wizard", gameSystem.getAllCharacterClasses());
    final CharacterClass barbarian = characterClassService.findClassByName("Barbarian", gameSystem.getAllCharacterClasses());

    classLevels.add(new ClassLevel(wizard, 4));
    classLevels.add(new ClassLevel(barbarian, 1));
    character.setClassLevels(classLevels);

    final List<CharacterClass> characterClasses = character.getCharacterClasses();

    assertNotNull(characterClasses);
    assertEquals(2, characterClasses.size());
  }

  @Test
  public void testGetAllAbilitiesOfBelvador() throws Exception {
    final Character belvador = gameSystem.getAllCharacters().get(0);
    final int numberOfAllAbilities = belvador.getAllAbilities().size();
    assertEquals(21, numberOfAllAbilities);
  }

  @Test
  public void testGetRaceAbilitiesOfBelvador() throws Exception {
    final Character belvador = gameSystem.getAllCharacters().get(0);
    final int numberOfRaceAbilities = belvador.getRaceAbilities().size();
    assertEquals(5, numberOfRaceAbilities);
  }

  @Test
  public void testGetClassAbilitiesOfBelvador() throws Exception {
    final Character belvador = gameSystem.getAllCharacters().get(0);
    final int numberOfClassAbilities = belvador.getClassAbilities().size();
    assertEquals(8, numberOfClassAbilities);
  }

  @Test
  public void testGetSpelllistAbilities() throws Exception {
    final Character belvador = gameSystem.getCharacter(0);

    final List<SpelllistAbility> spelllistAbilities = belvador.getSpelllistAbilities();
    assertNotNull(spelllistAbilities);
    assertEquals(2, spelllistAbilities.size());
  }

  @Test
  public void testGetKnownSpellsOfBelvador() throws Exception {
    final Character belvador = gameSystem.getCharacter(0);
    final List<SpelllistAbility> spelllistAbilities = belvador.getSpelllistAbilities();
    assertNotNull(spelllistAbilities);
    assertEquals(2, spelllistAbilities.size());

    final List<KnownSpell> knownSpells = belvador.getKnownSpells(spelllistAbilities.get(0).getSpelllist());
    assertNotNull(knownSpells);
    assertEquals(31, knownSpells.size());

    // 0 level
    assertTrue(containsSpell("Arcane Mark", knownSpells));
    assertTrue(containsSpell("Detect Magic", knownSpells));
    assertTrue(containsSpell("Read Magic", knownSpells));
    assertTrue(containsSpell("Prestidigitation", knownSpells));
    assertTrue(containsSpell("Resistance", knownSpells));
    assertTrue(containsSpell("Ray of Frost", knownSpells));
    assertTrue(containsSpell("Detect Poison", knownSpells));
    assertTrue(containsSpell("Flare", knownSpells));
    assertTrue(containsSpell("Light", knownSpells));
    assertTrue(containsSpell("Dancing Lights", knownSpells));
    assertTrue(containsSpell("Mending", knownSpells));
    assertTrue(containsSpell("Mage Hand", knownSpells));
    assertTrue(containsSpell("Open/Close", knownSpells));
    assertTrue(containsSpell("Daze", knownSpells));

    // 1st level
    assertTrue(containsSpell("Shield", knownSpells));
    assertTrue(containsSpell("Protection from Evil", knownSpells));
    assertTrue(containsSpell("Mage Armor", knownSpells));
    assertTrue(containsSpell("Summon Monster I", knownSpells));
    assertTrue(containsSpell("Mount", knownSpells));
    assertTrue(containsSpell("Unseen Servant", knownSpells));
    assertTrue(containsSpell("Magic Missile", knownSpells));
    assertTrue(containsSpell("Charm Person", knownSpells));
    assertTrue(containsSpell("Sleep", knownSpells));

    // 2nd level
    assertTrue(containsSpell("Acid Arrow", knownSpells));
    assertTrue(containsSpell("Summon Monster II", knownSpells));
    assertTrue(containsSpell("Knock", knownSpells));
    assertTrue(containsSpell("Spider Climb", knownSpells));
    assertTrue(containsSpell("Levitate", knownSpells));
    assertTrue(containsSpell("Flaming Sphere", knownSpells));

    // 3rd level
    assertTrue(containsSpell("Summon Monster III", knownSpells));
    assertTrue(containsSpell("Lightning Bolt", knownSpells));
  }

  @Test
  public void testBodyPartsBelvador() {
    // Arrange
    final Character belvador = gameSystem.getCharacter(0);

    // Act
    Body body = belvador.getBody();

    // Assert
    assertThat(body.getBodyParts()).hasSize(15);
    assertThat(body.getItemOfBodyPart(BodyPart.BOTH_HANDS).getName()).isEqualTo("Quarterstaff");
  }

  @Test
  public void testBodyPartsNascan() {
    // Arrange
    final Character nascan = gameSystem.getCharacter(1);
    Armor studdedLeather = gameSystem.getAllArmor().get(2);
    Weapon battleaxe = gameSystem.getAllWeapons().get(25);
    Weapon shortSword = gameSystem.getAllWeapons().get(24);

    // Act
    Body body = nascan.getBody();

    // Assert
    assertThat(body.getBodyParts()).hasSize(15);
    BodyAssert.assertThat(body).equippedItem(BodyPart.BODY, studdedLeather).equippedItem(BodyPart.OFF_HAND, shortSword)
        .equippedItem(BodyPart.PRIMARY_HAND, battleaxe);
  }

  @Test
  public void testBodyPartsTocDerJuengere() {
    // Arrange
    final Character tocDerJuengere = gameSystem.getCharacter(13);
    Armor studdedLeather = gameSystem.getAllArmor().get(2);
    Weapon rapier = gameSystem.getAllWeapons().get(29);

    // Act
    Body body = tocDerJuengere.getBody();

    // Assert
    assertThat(body.getBodyParts()).hasSize(15);
    BodyAssert.assertThat(body).equippedItem(BodyPart.BODY, studdedLeather).equippedItem(BodyPart.PRIMARY_HAND, rapier);
  }

  @Test
  public void testWholeEquipmentOfBelvador() {
    // Arrange
    final Character belvador = gameSystem.getCharacter(0);
    final Equipment equipment = belvador.getEquipment();
    Map<BodyPart, List<Item>> bodyParts = new HashMap<>();
    Arrays.stream(BodyPart.values()).forEach(bodyPart -> bodyParts.put(bodyPart, new LinkedList<>()));
    BodyService bodyService = gameSystem.getBodyService();

    for (ItemGroup itemGroup : equipment.getItems()) {
      // Act
      Item item = itemGroup.getItem();
      EnumSet<BodyPart> itemBodyParts = bodyService.calculateBodyParts(item);
      itemBodyParts.stream().forEach(bodyPart -> bodyParts.get(bodyPart).add(item));
    }

    // Assert
    assertThat(bodyParts.get(BodyPart.HEAD)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.EYES)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.NECK)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.TORSO)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.BODY)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.WAIST)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.SHOULDERS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.ARMS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.HANDS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FINGERS_LEFT)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FINGERS_RIGHT)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FEET)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.OFF_HAND)).extracting("name").containsOnly("Crossbow, light");
    assertThat(bodyParts.get(BodyPart.PRIMARY_HAND)).extracting("name").containsOnly("Crossbow, light");
    assertThat(bodyParts.get(BodyPart.HEAD)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.BOTH_HANDS)).extracting("name").containsOnly("Quarterstaff", "Crossbow, light");
    assertThat(bodyParts.get(BodyPart.NONE)).hasSize(20);
  }

  @Test
  public void testWholeEquipmentOfNascan() {
    // Arrange
    final Character nascan = gameSystem.getCharacter(1);
    final Equipment equipment = nascan.getEquipment();
    Map<BodyPart, List<Item>> bodyParts = new HashMap<>();
    Arrays.stream(BodyPart.values()).forEach(bodyPart -> bodyParts.put(bodyPart, new LinkedList<>()));
    BodyService bodyService = gameSystem.getBodyService();

    for (ItemGroup itemGroup : equipment.getItems()) {
      // Act
      Item item = itemGroup.getItem();
      EnumSet<BodyPart> itemBodyParts = bodyService.calculateBodyParts(item);
      itemBodyParts.stream().forEach(bodyPart -> bodyParts.get(bodyPart).add(item));
    }

    // Assert
    assertThat(bodyParts.get(BodyPart.HEAD)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.EYES)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.NECK)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.TORSO)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.BODY)).extracting("name").containsOnly("Studded Leather");
    assertThat(bodyParts.get(BodyPart.WAIST)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.SHOULDERS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.ARMS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.HANDS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FINGERS_LEFT)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FINGERS_RIGHT)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FEET)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.OFF_HAND)).extracting("name").containsOnly("Sword, short", "Battleaxe");
    assertThat(bodyParts.get(BodyPart.PRIMARY_HAND)).extracting("name").containsOnly("Sword, short", "Battleaxe");
    assertThat(bodyParts.get(BodyPart.HEAD)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.BOTH_HANDS)).extracting("name").containsOnly("Sword, short", "Battleaxe");
    assertThat(bodyParts.get(BodyPart.NONE)).hasSize(6);
  }

  @Test
  public void testWholeEquipmentOfTocDerJuengere() {
    // Arrange
    final Character tocDerJuengere = gameSystem.getCharacter(13);
    final Equipment equipment = tocDerJuengere.getEquipment();
    Map<BodyPart, List<Item>> bodyParts = new HashMap<>();
    Arrays.stream(BodyPart.values()).forEach(bodyPart -> bodyParts.put(bodyPart, new LinkedList<>()));
    BodyService bodyService = gameSystem.getBodyService();

    for (ItemGroup itemGroup : equipment.getItems()) {
      // Act
      Item item = itemGroup.getItem();
      EnumSet<BodyPart> itemBodyParts = bodyService.calculateBodyParts(item);
      itemBodyParts.stream().forEach(bodyPart -> bodyParts.get(bodyPart).add(item));
    }

    // Assert
    assertThat(bodyParts.get(BodyPart.HEAD)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.EYES)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.NECK)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.TORSO)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.BODY)).extracting("name").containsOnly("Studded Leather");
    assertThat(bodyParts.get(BodyPart.WAIST)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.SHOULDERS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.ARMS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.HANDS)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FINGERS_LEFT)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FINGERS_RIGHT)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.FEET)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.OFF_HAND)).extracting("name").containsOnly("Rapier", "Crossbow, light");
    assertThat(bodyParts.get(BodyPart.PRIMARY_HAND)).extracting("name").containsOnly("Rapier", "Crossbow, light");
    assertThat(bodyParts.get(BodyPart.HEAD)).hasSize(0);
    assertThat(bodyParts.get(BodyPart.BOTH_HANDS)).extracting("name").containsOnly("Rapier", "Crossbow, light");
    assertThat(bodyParts.get(BodyPart.NONE)).hasSize(14);
  }

  @Test
  public void testEquippedItemsOfBelvador() {
    // Arrange
    final Character belvador = gameSystem.getCharacter(0);

    // Act
    List<Item> equippedItems = belvador.getEquippedItems();

    // Assert
    assertThat(equippedItems).extracting("Name").containsOnly("Quarterstaff");
  }

  @Test
  public void testEquippedItemsOfNascan() {
    // Arrange
    final Character nascan = gameSystem.getCharacter(1);

    // Act
    List<Item> equippedItems = nascan.getEquippedItems();

    // Assert
    assertThat(equippedItems).extracting("Name").containsExactlyInAnyOrder("Studded Leather", "Sword, short", "Battleaxe");
  }

  @Test
  public void testEquippedItemsOfTocDerJuengere() {
    // Arrange
    final Character tocDerJuengere = gameSystem.getCharacter(13);

    // Act
    List<Item> equippedItems = tocDerJuengere.getEquippedItems();

    // Assert
    assertThat(equippedItems).extracting("Name").containsExactlyInAnyOrder("Studded Leather", "Rapier");
  }

  private boolean containsSpell(final String name, final List<KnownSpell> knownSpells) {
    return knownSpells.stream().anyMatch(knownSpell -> knownSpell.getSpell().getName().equals(name));
  }
}
