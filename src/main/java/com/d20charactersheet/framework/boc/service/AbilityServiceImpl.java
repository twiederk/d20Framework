package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.dao.AbilityDao;

/**
 * Implementation of AbilityService.
 */
public class AbilityServiceImpl implements AbilityService {

  private final AbilityDao abilityDao;

  /**
   * Creates AbilityService with data access.
   *
   * @param abilityDao
   *     The data access.
   */
  public AbilityServiceImpl(final AbilityDao abilityDao) {
    this.abilityDao = abilityDao;
  }

  @Override
  public List<Ability> getAllAbilities(final List<Spelllist> allSpelllists, List<KnownSpellsTable> allKnownSpellsTables,
      List<SpellsPerDayTable> allSpellsPerDayTables) {
    return abilityDao.getAllAbilities(allSpelllists, allKnownSpellsTables, allSpellsPerDayTables);
  }

  @Override
  public Ability createAbility(final Ability ability) {
    return abilityDao.createAbility(ability);
  }

  @Override
  public void updateAbility(final Ability ability) {
    abilityDao.updateAbility(ability);
  }

  @Override
  public Ability getAbilityById(final int abilityId, final List<Ability> allAbilities) {
    for (final Ability ability : allAbilities) {
      if (ability.getId() == abilityId) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't find ability with id: " + abilityId);
  }

}
