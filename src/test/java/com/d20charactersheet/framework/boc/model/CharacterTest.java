package com.d20charactersheet.framework.boc.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.DnDv35Universe;
import com.d20charactersheet.framework.Universe;
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

  private boolean containsSpell(final String name, final List<KnownSpell> knownSpells) {
    for (final KnownSpell knownSpell : knownSpells) {
      final Spell spell = knownSpell.getSpell();
      if (spell.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }
}
