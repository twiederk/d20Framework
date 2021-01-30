package com.d20charactersheet.framework.boc.service;

import com.d20charactersheet.framework.boc.model.*;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class RuleServiceSpelllistTestHelper {

  public static List<SpellSlot> getSchoolSpellSlots(final List<SpellSlot> spellSlots) {
    final List<SpellSlot> schoolSpellSlots = new LinkedList<>();
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getSchools().size() == 1) {
        schoolSpellSlots.add(spellSlot);
      }
    }
    return schoolSpellSlots;
  }

  public static boolean containsSpell(final String name, final List<Spell> spells) {
    for (final Spell spell : spells) {
      if (spell.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public static SpellSlot getSpellSlot(final List<SpellSlot> spellSlots, final String spelllistName, final int spellLevel) {
    return getSpellSlot(spellSlots, spelllistName, spellLevel, EnumSet.allOf(School.class), new String[0]);
  }

  public static SpellSlot getSpellSlot(final List<SpellSlot> spellSlots, final String spelllistName, final int spellLevel,
      final EnumSet<School> schools) {
    return getSpellSlot(spellSlots, spelllistName, spellLevel, schools, new String[0]);
  }

  public static SpellSlot getSpellSlot(final List<SpellSlot> spellSlots, final String spelllistName, final int spellLevel,
      final EnumSet<School> schools, final String[] featNames) {
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getLevel() == spellLevel && contains(spellSlot.getSpelllists(), spelllistName) && spellSlot.getSchools()
          .equals(schools) && contains(spellSlot.getMetamagicFeats(), featNames)) {
        return spellSlot;
      }
    }
    throw new IllegalArgumentException("Can't find spell slot with spell level: " + spellLevel);
  }

  private static boolean contains(final List<Spelllist> spelllists, final String spelllistName) {
    for (final Spelllist spelllist : spelllists) {
      if (spelllist.getName().equals(spelllistName)) {
        return true;
      }
    }
    return false;
  }

  private static boolean contains(final List<Feat> feats, final String[] featNames) {
    if (featNames.length == 0 && feats.size() == 0) {
      return true;
    }
    for (final Feat feat : feats) {
      if (contains(feat, featNames)) {
        return true;
      }
    }
    return false;
  }

  private static boolean contains(final Feat feat, final String[] featNames) {
    for (final String name : featNames) {
      if (feat.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public static Object countSpellSlots(final List<SpellSlot> spellSlots, final int spellLevel) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getLevel() == spellLevel) {
        count++;
      }
    }
    return count;
  }

  public static int countSpell(final List<SpellSlot> spellSlots, final int spellLevel, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getLevel() == spellLevel && spellSlot.getSpell().getName().equals(name)) {
        count++;
      }
    }
    return count;
  }

  public static int countSpelllistAbility(final List<SpellSlot> spellSlots, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      for (final SpelllistAbility spelllistAbility : spellSlot.getSpelllistAbilities()) {
        if (spelllistAbility.getName().equals(name)) {
          count++;
        }
      }
    }
    return count;
  }

  public static int countMetaMagicFeats(final List<SpellSlot> spellSlots, final String name) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      for (final Feat feat : spellSlot.getMetamagicFeats()) {
        if (feat.getName().equals(name)) {
          count++;
        }
      }
    }
    return count;
  }

  public static int countNewSpellSlots(final List<SpellSlot> spellSlots) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getId() == 0) {
        count++;
      }
    }
    return count;
  }

  public static List<SpellSlot> getDomainSpellSlots(final List<SpellSlot> spellSlots) {
    final List<SpellSlot> domainSpellSlots = new LinkedList<>();
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.isDomain()) {
        domainSpellSlots.add(spellSlot);
      }
    }
    return domainSpellSlots;
  }

  public static int countEmptySpellSlots(final List<SpellSlot> spellSlots) {
    int count = 0;
    for (final SpellSlot spellSlot : spellSlots) {
      if (SpellSlot.EMPTY_SPELL.equals(spellSlot.getSpell())) {
        count++;
      }
    }
    return count;
  }

}
