package com.d20charactersheet.framework.dac.dao.dummy;

import static com.d20charactersheet.framework.dac.abilitybuilder.ExtraFeatsAbilityBuilder.KEY_NUMBER_OF_EXTRA_FEATS;
import static com.d20charactersheet.framework.dac.abilitybuilder.ExtraSkillPointsAbilityBuilder.KEY_NUMBER_OF_SKILL_POINTS;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.ANY_SCHOOL_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_ATTRIBUTE_BONUS_SPELL_SLOTS;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_CASTING_TYPE_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_KNOWN_SPELLS_TABLE_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_SCHOOL_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_SPELLLIST_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_SPELLS_PER_DAY_TABLE_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_SPELL_ATTRIBUTE_ID;
import static com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder.KEY_SPELL_SOURCE_ID;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.AbilityType;
import com.d20charactersheet.framework.boc.model.ExtraFeatsAbility;
import com.d20charactersheet.framework.boc.model.ExtraSkillPointsAbility;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityBuilder;
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityBuilderFactory;
import com.d20charactersheet.framework.dac.abilitybuilder.AbilityConfig;
import com.d20charactersheet.framework.dac.abilitybuilder.DefaultAbilityBuilder;
import com.d20charactersheet.framework.dac.abilitybuilder.ExtraFeatsAbilityBuilder;
import com.d20charactersheet.framework.dac.abilitybuilder.ExtraSkillPointsAbilityBuilder;
import com.d20charactersheet.framework.dac.abilitybuilder.SpelllistAbilityBuilder;
import com.d20charactersheet.framework.dac.dao.AbilityDao;

/**
 * In memory storage of abilities. Simulates persistent layer.
 */
public class DummyAbilityDao implements AbilityDao {

  private final DataTable abilityTable;
  private final DataTable abilityPropertyTable;

  /**
   * Creates abilities form AbilityStorage.
   *
   * @param ability
   *     Ability raw data.
   * @param abilityProperty
   *     Ability property raw data.
   */
  public DummyAbilityDao(final Object[][] ability, final Object[][] abilityProperty) {
    abilityTable = new DataTable(ability);
    abilityPropertyTable = new DataTable(abilityProperty);
  }

  @Override
  public List<Ability> getAllAbilities(final List<Spelllist> allSpelllists, final List<KnownSpellsTable> allKnownSpellsTables,
      final List<SpellsPerDayTable> allSpellsPerDayTables) {
    final List<Ability> allAbilities = new ArrayList<>();
    final AbilityBuilderFactory abilityBuilderFactory = createAbilityBuilderFactory(allSpelllists, allKnownSpellsTables,
                                                                                    allSpellsPerDayTables);
    for (final DataRow dataRow : abilityTable) {
      final Ability ability = selectAbility(dataRow, abilityBuilderFactory);
      allAbilities.add(ability);
    }
    return allAbilities;
  }

  private Ability selectAbility(final DataRow dataRow, final AbilityBuilderFactory abilityBuilderFactory) {
    final AbilityConfig abilityConfig = selectAbilityConfig(dataRow);
    final Map<String, String> abilityProperties = selectAbilityProperties(dataRow.getId());
    abilityConfig.setProperties(abilityProperties);
    final AbilityBuilder abilityBuilder = abilityBuilderFactory.getAbilityBuilder(abilityConfig.getClassname());
    final Ability ability = createAbility(abilityConfig, abilityBuilder);
    return ability;
  }

  private Ability createAbility(final AbilityConfig abilityConfig, final AbilityBuilder abilityBuilder) {
    final Ability ability = abilityBuilder.createAbility(abilityConfig);
    return ability;
  }

  private AbilityConfig selectAbilityConfig(final DataRow dataRow) {
    final AbilityConfig abilityConfig = new AbilityConfig();
    abilityConfig.setId(dataRow.getId());
    abilityConfig.setName(dataRow.getString(1));
    abilityConfig.setDescription((dataRow.getString(2)));
    abilityConfig.setAbilityType(getAbilityType(dataRow.getInt(3)));
    abilityConfig.setClassname(dataRow.getString(4));
    return abilityConfig;
  }

  private Map<String, String> selectAbilityProperties(final int id) {
    final Map<String, String> abilityProperties = new HashMap<>();
    final List<DataRow> dataRows = abilityPropertyTable.select(0, id);
    for (final DataRow dataRow : dataRows) {
      final String key = dataRow.getString(1);
      final String value = dataRow.getString(2);
      abilityProperties.put(key, value);
    }
    return abilityProperties;
  }

  private AbilityType getAbilityType(final int abilityTypeId) {
    for (final AbilityType abilityType : AbilityType.values()) {
      if (abilityType.ordinal() == abilityTypeId) {
        return abilityType;
      }
    }
    throw new IllegalArgumentException("Can't find ability type of id: " + abilityTypeId);
  }

  @Override
  public Ability createAbility(final Ability ability) {
    ability.setId(abilityTable.getNewId());
    insertAbility(ability);
    insertAbilityProperty(ability);
    return ability;
  }

  private void insertAbility(final Ability ability) {
    abilityTable.insert(
        new Object[] {ability.getId(), ability.getName(), ability.getDescription(), ability.getAbilityType().ordinal(),
            ability.getClass().getSimpleName()
        });
  }

  private void insertAbilityProperty(final Ability ability) {
    if (ability instanceof ExtraFeatsAbility) {
      final ExtraFeatsAbility extraFeatsAbility = (ExtraFeatsAbility) ability;
      abilityPropertyTable.insert(
          new Object[] {ability.getId(), KEY_NUMBER_OF_EXTRA_FEATS, Integer.toString(extraFeatsAbility.getNumberOfFeats())});
    } else if (ability instanceof ExtraSkillPointsAbility) {
      final ExtraSkillPointsAbility extraSkillPointsAbility = (ExtraSkillPointsAbility) ability;
      abilityPropertyTable.insert(
          new Object[] {ability.getId(), KEY_NUMBER_OF_SKILL_POINTS, Integer.toString(extraSkillPointsAbility.getSkillPoints())});
    } else if (ability instanceof SpelllistAbility) {
      final SpelllistAbility spelllistAbility = (SpelllistAbility) ability;
      abilityPropertyTable
          .insert(new Object[] {ability.getId(), KEY_SPELLLIST_ID, Integer.toString(spelllistAbility.getSpelllist().getId())});
      abilityPropertyTable.insert(
          new Object[] {ability.getId(), KEY_SPELL_ATTRIBUTE_ID, Integer.toString(spelllistAbility.getSpellAttribute().ordinal())});
      abilityPropertyTable.insert(
          new Object[] {ability.getId(), KEY_CASTING_TYPE_ID, Integer.toString(spelllistAbility.getCastingType().ordinal())});
      abilityPropertyTable.insert(
          new Object[] {ability.getId(), KEY_SPELL_SOURCE_ID, Integer.toString(spelllistAbility.getSpellSource().ordinal())});
      abilityPropertyTable.insert(new Object[] {ability.getId(), KEY_KNOWN_SPELLS_TABLE_ID,
          Integer.toString(spelllistAbility.getKnownSpellsTable().getId())
      });
      abilityPropertyTable.insert(new Object[] {ability.getId(), KEY_SPELLS_PER_DAY_TABLE_ID,
          Integer.toString(spelllistAbility.getSpellsPerDayTable().getId())
      });
      abilityPropertyTable
          .insert(new Object[] {ability.getId(), KEY_SCHOOL_ID, Integer.toString(getSchoolId(spelllistAbility.getSchools()))});
      abilityPropertyTable.insert(new Object[] {ability.getId(), KEY_ATTRIBUTE_BONUS_SPELL_SLOTS,
          Boolean.toString(spelllistAbility.isAttributeBonusSpellSlots())
      });
    }
  }

  private int getSchoolId(final EnumSet<School> schools) {
    if (schools.size() == 1) {
      final School[] school = new School[1];
      schools.toArray(school);
      return school[0].ordinal();
    }
    return ANY_SCHOOL_ID;
  }

  @Override
  public void updateAbility(final Ability ability) {
    deleteAbility(ability);
    insertAbility(ability);
    insertAbilityProperty(ability);
  }

  @Override
  public void deleteAbility(final Ability ability) {
    abilityTable.delete(ability.getId());
    abilityPropertyTable.delete(ability.getId());
  }

  @Override
  public AbilityBuilderFactory createAbilityBuilderFactory(final List<Spelllist> allSpelllists,
      final List<KnownSpellsTable> allKnownSpellsTables, final List<SpellsPerDayTable> allSpellsPerDayTables) {
    final AbilityBuilderFactory abilityBuilderFactory = new AbilityBuilderFactory();
    abilityBuilderFactory.registerAbilityBuilder(Ability.class.getSimpleName(), new DefaultAbilityBuilder());
    abilityBuilderFactory.registerAbilityBuilder(SpelllistAbility.class.getSimpleName(),
                                                 new SpelllistAbilityBuilder(allSpelllists, allKnownSpellsTables,
                                                                             allSpellsPerDayTables));
    abilityBuilderFactory.registerAbilityBuilder(ExtraFeatsAbility.class.getSimpleName(), new ExtraFeatsAbilityBuilder());
    abilityBuilderFactory
        .registerAbilityBuilder(ExtraSkillPointsAbility.class.getSimpleName(), new ExtraSkillPointsAbilityBuilder());
    return abilityBuilderFactory;
  }

}
