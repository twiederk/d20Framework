package com.d20charactersheet.framework.dac.dao;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityBuilderFactory;

/**
 * Interface to persistent layer about abilities.
 */
public interface AbilityDao {

  /**
   * Returns all abilities.
   *
   * @param allSpelllists
   *     All spell lists of game system.
   * @param allKnownSpellsTables
   *     All known spells tables of game system.
   * @param allSpellsPerDayTables
   *     All spells per day tables of game system.
   *
   * @return All abilities.
   */
  List<Ability> getAllAbilities(List<Spelllist> allSpelllists, List<KnownSpellsTable> allKnownSpellsTables,
      List<SpellsPerDayTable> allSpellsPerDayTables);

  /**
   * Creates a new ability in the persistent layer and sets its id.
   *
   * @param ability
   *     The ability to create.
   *
   * @return The created ability with the id set.
   */
  Ability createAbility(Ability ability);

  /**
   * Updates the ability in the persistent layer.
   *
   * @param ability
   *     The ability to update.
   */
  void updateAbility(Ability ability);

  /**
   * Deletes class ability.
   *
   * @param ability
   *     Ability to delete.
   */
  void deleteAbility(Ability ability);

  /**
   * Creates the AbilityBuilderFactory with the given spelllists.
   *
   * @param allSpelllists
   *     All spell lists of the game system.
   * @param allKnownSpellsTables
   *     All known spells tables of game system.
   * @param allSpellsPerDayTables
   *     All spells per day tables of game system.
   *
   * @return The AbilityBuilderFactory.
   */
  AbilityBuilderFactory createAbilityBuilderFactory(List<Spelllist> allSpelllists, List<KnownSpellsTable> allKnownSpellsTables,
      List<SpellsPerDayTable> allSpellsPerDayTables);

}
