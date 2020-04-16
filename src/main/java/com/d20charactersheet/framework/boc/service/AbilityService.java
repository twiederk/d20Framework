package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;

/**
 * Provides functionallity about abilities.
 */
public interface AbilityService {

  /**
   * Returns all abilities of the game system.
   *
   * @param allSpelllists
   *     All spell lists of the game sytem.
   * @param allKnownSpellsTables
   *     All known spell tables of the game system.
   * @param allSpellsPerDayTables
   *     All spells per day tables of the game system.
   *
   * @return All abilities of the game system.
   */
  List<Ability> getAllAbilities(List<Spelllist> allSpelllists, List<KnownSpellsTable> allKnownSpellsTables,
      List<SpellsPerDayTable> allSpellsPerDayTables);

  /**
   * Creates a new ability.
   *
   * @param ability
   *     The ability to create.
   *
   * @return The create ability.
   */
  Ability createAbility(Ability ability);

  /**
   * Updates the given ability.
   *
   * @param ability
   *     The ability to update.
   */
  void updateAbility(Ability ability);

  /**
   * Returns the ability with the given id out of the given list.
   *
   * @param abilityId
   *     The id of the ability to return.
   * @param allAbilities
   *     The abilities to check for id.
   *
   * @return The ability with the given id out of the given list.
   */
  Ability getAbilityById(int abilityId, List<Ability> allAbilities);

}
