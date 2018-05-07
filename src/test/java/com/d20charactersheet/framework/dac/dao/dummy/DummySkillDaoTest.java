package com.d20charactersheet.framework.dac.dao.dummy;

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
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SkillStorage.SKILL;

import org.junit.Before;

import com.d20charactersheet.framework.dac.dao.BaseSkillDaoTest;

public class DummySkillDaoTest extends BaseSkillDaoTest {

  @Before
  public void setUp() throws Exception {
    characterDao = new DummyCharacterDao(CHARACTER, CHARACTER_CLASS_LEVEL, CHARACTER_ABILITY, CHARACTER_SKILL, CHARACTER_FEAT,
                                         CHARACTER_WEAPON, CHARACTER_ARMOR, CHARACTER_GOOD, CHARACTER_NOTE, CHARACTER_ATTACK,
                                         CHARACTER_KNOWN_SPELL, CHARACTER_SPELL_SLOT, CHARACTER_SPELL_SLOT_ABILITY,
                                         CHARACTER_SPELL_SLOT_FEAT, CHARACTER_BODY_PART);
    skillDao = new DummySkillDao(SKILL);
  }

}
