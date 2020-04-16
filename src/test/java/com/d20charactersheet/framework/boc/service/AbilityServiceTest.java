package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35AbilityStorage.ABILITY_PROPERTY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35KnownSpellsStorage.KNOWN_SPELLS_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellStorage.SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpelllistStorage.SPELLLIST_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35SpellsPerDayStorage.SPELLS_PER_DAY_TABLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.dac.dao.dummy.DummyAbilityDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummySpelllistDao;

public class AbilityServiceTest {

  private AbilityService abilityService;
  private SpelllistService spelllistService;

  @Before
  public void setUp() {
    abilityService = new AbilityServiceImpl(new DummyAbilityDao(ABILITY, ABILITY_PROPERTY));
    spelllistService = new SpelllistServiceImpl(
        new DummySpelllistDao(SPELL, SPELLLIST, SPELLLIST_SPELL, KNOWN_SPELLS_TABLE, KNOWN_SPELLS_LEVEL, SPELLS_PER_DAY_TABLE,
                              SPELLS_PER_DAY_LEVEL));
  }

  @Test
  public void testGetAllAbilities() {
    final List<Ability> allAbilities = abilityService
        .getAllAbilities(spelllistService.getAllSpelllists(spelllistService.getAllSpells()),
                         spelllistService.getAllKnownSpellsTables(), spelllistService.getAllSpellsPerDayTables());
    assertNotNull(allAbilities);
    assertEquals(302, allAbilities.size());
  }

  @Test
  public void testUpdateAbility() {
    final int ABILITY_ID = 0;

    final Ability sourceAbility = getAbilityById(ABILITY_ID);

    final Ability updateAbility = new Ability();
    updateAbility.setId(sourceAbility.getId());
    updateAbility.setAbilityType(AbilityType.SUPERNATURAL);
    updateAbility.setName("updateName");
    updateAbility.setDescription("updateDescription");

    abilityService.updateAbility(updateAbility);

    final Ability destAbility = getAbilityById(ABILITY_ID);
    assertEquals("updateName", destAbility.getName());
    assertEquals("updateDescription", destAbility.getDescription());
    assertEquals(AbilityType.SUPERNATURAL, destAbility.getAbilityType());

    // tear down
    abilityService.updateAbility(sourceAbility);

  }

  private Ability getAbilityById(final int abilityId) {
    final List<Ability> allAbilities = abilityService
        .getAllAbilities(spelllistService.getAllSpelllists(spelllistService.getAllSpells()),
                         spelllistService.getAllKnownSpellsTables(), spelllistService.getAllSpellsPerDayTables());
    for (final Ability ability : allAbilities) {
      if (ability.getId() == abilityId) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't find ability with id: " + abilityId);
  }

}
