package com.d20charactersheet.framework.dac.dao.dummy;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY_PROPERTY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS_SKILL;
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

import org.junit.Before;

import com.d20charactersheet.framework.dac.dao.BaseRaceDaoTest;

public class DummyRaceDaoTest extends BaseRaceDaoTest {

  @Before
  public void setUp() {
    characterClassDao = new DummyClassDao(CLASS, CLASS_SKILL, CLASS_ABILITY);
    skillDao = new DummySkillDao(SKILL);
    raceDao = new DummyRaceDao(RACE, RACE_ABILITY);
    abilityDao = new DummyAbilityDao(ABILITY, ABILITY_PROPERTY);
    spelllistDao = new DummySpelllistDao(SPELL, SPELLLIST, SPELLLIST_SPELL, KNOWN_SPELLS_TABLE, KNOWN_SPELLS_LEVEL,
                                         SPELLS_PER_DAY_TABLE, SPELLS_PER_DAY_LEVEL);
  }
}
