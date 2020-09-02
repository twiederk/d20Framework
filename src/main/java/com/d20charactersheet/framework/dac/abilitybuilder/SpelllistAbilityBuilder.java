package com.d20charactersheet.framework.dac.abilitybuilder;

import java.util.EnumSet;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.CastingType;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.SpellSource;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;

/**
 * Creates a SpelllistAbility which contains a spell list. The id of the spell list is a ability property called
 * spelllist_id.
 */
public class SpelllistAbilityBuilder extends DefaultAbilityBuilder {

  /**
   * The key to store the spell list id of the ability
   */
  public static final String KEY_SPELLLIST_ID = "spelllist_id";
  /**
   * The key to store the id of the spell attribute
   */
  public static final String KEY_SPELL_ATTRIBUTE_ID = "spell_attribute_id";
  /**
   * The key to store the id of the casting type
   */
  public static final String KEY_CASTING_TYPE_ID = "casting_type_id";
  /**
   * The key to store the id of the spell source
   */
  public static final String KEY_SPELL_SOURCE_ID = "spell_source_id";
  /**
   * The key to store the id of the known spells table
   */
  public static final String KEY_KNOWN_SPELLS_TABLE_ID = "spells_known_table_id";
  /**
   * The key to store the id of the spells per day table
   */
  public static final String KEY_SPELLS_PER_DAY_TABLE_ID = "spells_per_day_table_id";
  /**
   * The key to store if the attribute provides bonus spell slots
   */
  public static final String KEY_ATTRIBUTE_BONUS_SPELL_SLOTS = "attribute_bonus_spell_slots";
  /**
   * The key to store the id of the school suported by the spell list ability
   */
  public static final String KEY_SCHOOL_ID = "school_id";

  /**
   * Set of all school
   */
  public static final EnumSet<School> ANY_SCHOOL = EnumSet.allOf(School.class);
  /**
   * The id to support any school
   */
  public static final int ANY_SCHOOL_ID = -1;

  private final List<Spelllist> allSpelllists;

  private final List<KnownSpellsTable> allKnownSpellsTables;

  private final List<SpellsPerDayTable> allSpellsPerDayTables;

  /**
   * Instanciates SpelllistAbilityBuilder with a list of all available spell lists.
   *
   * @param allSpelllists
   *     All spell lists of the game sytem.
   * @param allKnownSpellsTables
   *     All known spell tables of the game system.
   * @param allSpellsPerDayTables
   *     All spells per day tables of the game system.
   */
  public SpelllistAbilityBuilder(final List<Spelllist> allSpelllists, final List<KnownSpellsTable> allKnownSpellsTables,
      final List<SpellsPerDayTable> allSpellsPerDayTables) {
    super();
    this.allSpelllists = allSpelllists;
    this.allKnownSpellsTables = allKnownSpellsTables;
    this.allSpellsPerDayTables = allSpellsPerDayTables;
  }

  @Override
  public Ability createAbility(final AbilityConfig abilityConfig) {
    final SpelllistAbility ability = new SpelllistAbility();
    fillAbility(ability, abilityConfig);
    ability.setSpelllist(getSpelllist(abilityConfig));
    ability.setSpellAttribute(getAttribute(abilityConfig));
    ability.setCastingType(getCastingType(abilityConfig));
    ability.setSpellSource(getSpellSource(abilityConfig));
    ability.setKnownSpellsTable(getKnownSpellsTable(abilityConfig));
    ability.setSpellsPerDayTable(getSpellsPerDayTable(abilityConfig));
    ability.setSchools(getSchools(abilityConfig));
    ability.setAttributeBonusSpellSlots(getAttributeBonusSpellSlots(abilityConfig));
    return ability;
  }

  private Spelllist getSpelllist(final AbilityConfig abilityConfig) {
    Spelllist spelllist = allSpelllists.get(0);
    try {
      final int spelllistId = getInt(abilityConfig, KEY_SPELLLIST_ID);
      for (final Spelllist currentSpelllist : allSpelllists) {
        if (currentSpelllist.getId() == spelllistId) {
          spelllist = currentSpelllist;
          break;
        }
      }
    } catch (final Exception e) {
      // failed to get spell list from ability config
    }
    return spelllist;
  }

  private KnownSpellsTable getKnownSpellsTable(final AbilityConfig abilityConfig) {
    int knownSpellsTableId = allKnownSpellsTables.get(0).getId();
    try {
      knownSpellsTableId = getInt(abilityConfig, KEY_KNOWN_SPELLS_TABLE_ID);
    } catch (final Exception e) {
      // failed to get id of spells known table from ability config
    }

    for (final KnownSpellsTable knownSpellsTable : allKnownSpellsTables) {
      if (knownSpellsTable.getId() == knownSpellsTableId) {
        return knownSpellsTable;
      }
    }
    throw new IllegalArgumentException("Can't find spells known table with id: " + knownSpellsTableId);
  }

  private SpellsPerDayTable getSpellsPerDayTable(final AbilityConfig abilityConfig) {
    int spellsPerDayTableId = allSpellsPerDayTables.get(0).getId();
    try {
      spellsPerDayTableId = getInt(abilityConfig, KEY_SPELLS_PER_DAY_TABLE_ID);
    } catch (final Exception e) {
      // failed to get id of spells per day table from ability config
    }

    for (final SpellsPerDayTable spellsPerDayTable : allSpellsPerDayTables) {
      if (spellsPerDayTable.getId() == spellsPerDayTableId) {
        return spellsPerDayTable;
      }
    }
    throw new IllegalArgumentException("Can't find spells per day table with id: " + spellsPerDayTableId);
  }

  private Attribute getAttribute(final AbilityConfig abilityConfig) {
    Attribute attribute = Attribute.INTELLIGENCE;
    try {
      attribute = (Attribute) getEnum(abilityConfig, KEY_SPELL_ATTRIBUTE_ID, Attribute.values());
    } catch (final NumberFormatException numberFormatException) {
      // failed to read attribute id from ability config
    }
    return attribute;
  }

  private CastingType getCastingType(final AbilityConfig abilityConfig) {
    CastingType castingType = CastingType.PREPARED;
    try {
      castingType = (CastingType) getEnum(abilityConfig, KEY_CASTING_TYPE_ID, CastingType.values());
    } catch (final Exception e) {
      // failed to get casting type from ability config
    }
    return castingType;
  }

  private SpellSource getSpellSource(final AbilityConfig abilityConfig) {
    SpellSource spellSource = SpellSource.ARCANE;
    try {
      spellSource = (SpellSource) getEnum(abilityConfig, KEY_SPELL_SOURCE_ID, SpellSource.values());
    } catch (final Exception e) {
      // failed to get spell source from ability config
    }
    return spellSource;
  }

  private EnumSet<School> getSchools(final AbilityConfig abilityConfig) {
    EnumSet<School> schools = ANY_SCHOOL;
    try {
      final int schoolId = getInt(abilityConfig, KEY_SCHOOL_ID);
      if (schoolId != ANY_SCHOOL_ID) {
        for (final School school : School.values()) {
          if (school.ordinal() == schoolId) {
            schools = EnumSet.of(school);
          }
        }
      }
    } catch (final Exception e) {
      // failed to get school from ability config
    }
    return schools;
  }

  private boolean getAttributeBonusSpellSlots(final AbilityConfig abilityConfig) {
    boolean attributeBonusSpellSlots = false;
    try {
      attributeBonusSpellSlots = getBoolean(abilityConfig);
    } catch (final Exception e) {
      // failed to get attribute bonus spell slots from ability config
    }
    return attributeBonusSpellSlots;
  }

}
