package com.d20charactersheet.framework.boc.service;

import java.util.ArrayList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.dao.SpelllistDao;

/**
 * Implements SpelllistService interface to administer everything about spells and spell lists.
 */
public class SpelllistServiceImpl implements SpelllistService {

  private final SpelllistDao spelllistDao;

  /**
   * Instanciates an implementation of SpellService.
   *
   * @param spelllistDao
   *     The access object to the persistent layer.
   */
  public SpelllistServiceImpl(final SpelllistDao spelllistDao) {
    this.spelllistDao = spelllistDao;
  }

  @Override
  public List<Spell> getAllSpells() {
    return spelllistDao.getAllSpells();
  }

  @Override
  public List<Spelllist> getAllSpelllists(final List<Spell> allSpells) {
    return spelllistDao.getAllSpelllists(allSpells);
  }

  @Override
  public Spell getSpellDescription(final Spell spell) {
    if (spell.getDescription() == null) {
      final String description = spelllistDao.getSpellDescription(spell.getId());
      spell.setDescription(description);
    }
    return spell;
  }

  @Override
  public Spell findSpellById(final int spellId, final List<Spell> allSpells) {
    for (final Spell spell : allSpells) {
      if (spell.getId() == spellId) {
        return spell;
      }
    }
    throw new IllegalArgumentException("Can't find spell with id: " + spellId);
  }

  @Override
  public Spell createSpell(final Spell spell) {
    return spelllistDao.createSpell(spell);
  }

  @Override
  public void deleteSpell(final Spell spell) {
    spelllistDao.deleteSpell(spell);
  }

  @Override
  public void updateSpell(final Spell spell) {
    spelllistDao.updateSpell(spell);
  }

  @Override
  public Spelllist findSpelllistById(final int spelllistId, final List<Spelllist> allSpelllists) {
    for (final Spelllist spelllist : allSpelllists) {
      if (spelllist.getId() == spelllistId) {
        return spelllist;
      }
    }
    throw new IllegalArgumentException("Can't find spell list with id: " + spelllistId);
  }

  @Override
  public boolean createSpelllevel(final Spelllist spelllist, final Spell spell, final int level) {
    if (spelllist.getAllSpells().contains(spell)) {
      return false;
    }
    spelllistDao.createSpelllevel(spelllist, spell, level);
    List<Spell> spells = spelllist.getSpellsOfLevel(level);
    if (spells == null) {
      spells = new ArrayList<>();
    }
    spells.add(spell);
    spelllist.getSpellsByLevel().put(level, spells);
    return true;
  }

  @Override
  public void updateSpelllevel(final Spelllist spelllist, final Spell spell, final int level) {
    spelllistDao.updateSpelllevel(spelllist, spell, level);
  }

  @Override
  public Spelllist createSpelllist(final Spelllist spelllist) {
    return spelllistDao.createSpelllist(spelllist);
  }

  @Override
  public void deleteSpelllist(final Spelllist spelllist) {
    spelllistDao.deleteSpelllist(spelllist);
  }

  @Override
  public void updateSpelllist(final Spelllist spelllist) {
    spelllistDao.updateSpelllist(spelllist);
  }

  @Override
  public void deleteSpelllevel(final Spelllist spelllist, final Spell spell) {
    spelllistDao.deleteSpelllevel(spelllist, spell);
  }

  @Override
  public List<KnownSpellsTable> getAllKnownSpellsTables() {
    return spelllistDao.getAllKnownSpellsTables();
  }

  @Override
  public List<SpellsPerDayTable> getAllSpellsPerDayTables() {
    return spelllistDao.getAllSpellsPerDayTables();
  }

  @Override
  public Spell findSpellByName(String name, List<Spell> allSpells) {
    for (final Spell spell : allSpells) {
      if (spell.getName().equals(name)) {
        return spell;
      }
    }
    throw new IllegalArgumentException("Can't find spell with name: " + name);
  }

  @Override
  public Spelllist findSpelllistByName(String name, List<Spelllist> allSpelllists) {
    for (Spelllist spelllist : allSpelllists) {
      if (spelllist.getName().equals(name)) {
        return spelllist;
      }
    }
    throw new IllegalArgumentException("Can't find spell list with name: " + name);
  }

}
