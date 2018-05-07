package com.d20charactersheet.framework.dac.dao.dummy;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY_PROPERTY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_ARMOR;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_ATTACK;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_BODY_PART;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_CLASS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_FEAT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_GOOD;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_KNOWN_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_NOTE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_SPELL_SLOT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_SPELL_SLOT_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_SPELL_SLOT_FEAT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_WEAPON;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS_SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35FeatStorage.FEAT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35RaceStorage.RACE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35RaceStorage.RACE_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SkillStorage.SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellStorage.SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35XpStorage.XP_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35XpStorage.XP_TABLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Alignment;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Sex;
import com.d20charactersheet.framework.dac.dao.BaseCharacterDaoTest;

public class DummyCharacterDaoTest extends BaseCharacterDaoTest {

  @Override
  @Before
  public void setUp() throws Exception {
    characterDao = new DummyCharacterDao(CHARACTER, CHARACTER_CLASS_LEVEL, CHARACTER_ABILITY, CHARACTER_SKILL, CHARACTER_FEAT,
                                         CHARACTER_WEAPON, CHARACTER_ARMOR, CHARACTER_GOOD, CHARACTER_NOTE, CHARACTER_ATTACK,
                                         CHARACTER_KNOWN_SPELL, CHARACTER_SPELL_SLOT, CHARACTER_SPELL_SLOT_ABILITY,
                                         CHARACTER_SPELL_SLOT_FEAT, CHARACTER_BODY_PART);
    characterClassDao = new DummyClassDao(CLASS, CLASS_SKILL, CLASS_ABILITY);
    skillDao = new DummySkillDao(SKILL);
    featDao = new DummyFeatDao(FEAT);
    raceDao = new DummyRaceDao(RACE, RACE_ABILITY);
    abilityDao = new DummyAbilityDao(ABILITY, ABILITY_PROPERTY);
    spelllistDao = new DummySpelllistDao(SPELL, SPELLLIST, SPELLLIST_SPELL, KNOWN_SPELLS_TABLE, KNOWN_SPELLS_LEVEL,
                                         SPELLS_PER_DAY_TABLE, SPELLS_PER_DAY_LEVEL);
    xpDao = new DummyXpDao(XP_TABLE, XP_LEVEL);
    super.setUp();
  }

  @Test
  public void testDummyCharacters() throws Exception {
    final List<Character> allCharacters = characterDao.getAllCharacters(allCharacterClasses, allRaces, allXpTables);
    final Character belvador = allCharacters.get(0);
    assertStats(belvador, 0, "Belvador the Summoner", "Torsten", 2, Sex.MALE, Alignment.CHAOTIC_GOOD, 13129);
    assertCharacterClassLevels(belvador, new Object[][] {{"Wizard", 5}});

    final Character nascan = allCharacters.get(1);
    assertStats(nascan, 1, "Nascan Schwarzhaut", "Torsten", 0, Sex.MALE, Alignment.NEUTRAL, 24500);
    assertCharacterClassLevels(nascan, new Object[][] {{"Ranger", 4}, {"Rogue", 3}});
  }

  private void assertStats(final Character character, final int id, final String name, final String player, final int raceId,
      final Sex sex, final Alignment alignment, final int experiencePoints) {
    assertNotNull(character);
    assertEquals(id, character.getId());
    assertEquals(name, character.getName());
    assertEquals(player, character.getPlayer());
    assertEquals(raceId, character.getRace().getId());
    assertEquals(sex, character.getSex());
    assertEquals(alignment, character.getAlignment());
    assertEquals(experiencePoints, character.getExperiencePoints());
  }

  private void assertCharacterClassLevels(final Character character, final Object[][] characterClassLevels) {
    final List<ClassLevel> classLevels = character.getClassLevels();
    assertNotNull(classLevels);
    assertEquals(characterClassLevels.length, classLevels.size());
    for (int i = 0; i < characterClassLevels.length; i++) {
      final String name = (String) characterClassLevels[i][0];
      final int level = (Integer) characterClassLevels[i][1];
      final ClassLevel classLevel = classLevels.get(i);
      assertEquals(name, classLevel.getCharacterClass().getName());
      assertEquals(level, classLevel.getLevel());

    }
  }

  @Test
  public void testClassLevels() throws Exception {
    final Character belvador = characterDao.getCharacter(0, allCharacterClasses, allRaces, allXpTables);

    assertEquals(1, belvador.getClassLevels().size());
  }

}
