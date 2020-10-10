package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.dac.dao.sql.SqlAbilityDao;
import com.d20charactersheet.framework.dac.dao.sql.SqlSpelllistDao;
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcDatabase;
import com.d20charactersheet.framework.dac.dao.sql.jdbc.JdbcHelper;

public class AbilityServiceTest {

  private AbilityService abilityService;
  private SpelllistService spelllistService;

  @Before
  public void setUp() {

    JdbcHelper jdbcHelper = new JdbcHelper();

    jdbcHelper.executeSqlScript("/sql/create_database.sql");
    jdbcHelper.executeSqlScript("/sql/dndv35_phb_data.sql");
    jdbcHelper.executeSqlScript("/sql/dndv35_phb_spell.sql");
    jdbcHelper.executeSqlScript("/sql/dndv35_phb_character.sql");

    JdbcDatabase jdbcDatabase = new JdbcDatabase(jdbcHelper.getConnection());

    abilityService = new AbilityServiceImpl(new SqlAbilityDao(jdbcDatabase));
    spelllistService = new SpelllistServiceImpl(new SqlSpelllistDao(jdbcDatabase));
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

    final Ability sourceAbility = getAbilityById();

    final Ability updateAbility = new Ability();
    updateAbility.setId(sourceAbility.getId());
    updateAbility.setAbilityType(AbilityType.SUPERNATURAL);
    updateAbility.setName("updateName");
    updateAbility.setDescription("updateDescription");

    abilityService.updateAbility(updateAbility);

    final Ability destAbility = getAbilityById();
    assertEquals("updateName", destAbility.getName());
    assertEquals("updateDescription", destAbility.getDescription());
    assertEquals(AbilityType.SUPERNATURAL, destAbility.getAbilityType());

    // tear down
    abilityService.updateAbility(sourceAbility);

  }

  private Ability getAbilityById() {
    final int ABILITY_ID = 0;

    final List<Ability> allAbilities = abilityService
        .getAllAbilities(spelllistService.getAllSpelllists(spelllistService.getAllSpells()),
                         spelllistService.getAllKnownSpellsTables(), spelllistService.getAllSpellsPerDayTables());
    for (final Ability ability : allAbilities) {
      if (ability.getId() == ABILITY_ID) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't find ability with id: " + 0);
  }

}
