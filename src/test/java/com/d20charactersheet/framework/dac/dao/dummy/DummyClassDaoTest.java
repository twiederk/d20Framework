package com.d20charactersheet.framework.dac.dao.dummy;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY_PROPERTY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35ClassStorage.CLASS_SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SkillStorage.SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellStorage.SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_TABLE;

import java.util.List;

import org.junit.Before;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.dac.dao.BaseClassDaoTest;

public class DummyClassDaoTest extends BaseClassDaoTest {

  @Before
  public void setUp() throws Exception {
    characterClassDao = new DummyClassDao(CLASS, CLASS_SKILL, CLASS_ABILITY);
    skillDao = new DummySkillDao(SKILL);
    abilityDao = new DummyAbilityDao(ABILITY, ABILITY_PROPERTY);
    spelllistDao = new DummySpelllistDao(SPELL, SPELLLIST, SPELLLIST_SPELL, KNOWN_SPELLS_TABLE, KNOWN_SPELLS_LEVEL,
                                         SPELLS_PER_DAY_TABLE, SPELLS_PER_DAY_LEVEL);

    final List<Ability> allAbilities = abilityDao
        .getAllAbilities(spelllistDao.getAllSpelllists(spelllistDao.getAllSpells()), spelllistDao.getAllKnownSpellsTables(),
                         spelllistDao.getAllSpellsPerDayTables());
    allCharacterClasses = characterClassDao.getAllCharacterClasses(skillDao.getAllSkills(), allAbilities);
  }

}
