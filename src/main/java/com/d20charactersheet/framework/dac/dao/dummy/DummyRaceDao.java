package com.d20charactersheet.framework.dac.dao.dummy;

import static com.d20charactersheet.framework.boc.model.CharacterClass.AnyCharacterClass.ANY_CHARACTER_CLASS;

import java.util.ArrayList;
import java.util.List;

import com.androidash.memorydb.DataRow;
import com.androidash.memorydb.DataTable;
import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Size;
import com.d20charactersheet.framework.dac.dao.RaceDao;

/**
 * In memory storage of races to simulate peristent layer.
 */
public class DummyRaceDao implements RaceDao {

  private final DataTable raceTable;
  private final DataTable raceAbilityTable;

  /**
   * Creates races from the RaceStorage.
   *
   * @param race
   *     Race raw data.
   * @param raceAbility
   *     Ability raw data.
   */
  public DummyRaceDao(final Object[][] race, final Object[][] raceAbility) {
    raceTable = new DataTable(race);
    raceAbilityTable = new DataTable(raceAbility);
  }

  @Override
  public List<Race> getAllRaces(final List<CharacterClass> allCharacterClasses, final List<Ability> allAbilities) {
    return selectAllRaces(allCharacterClasses, allAbilities);
  }

  private List<Race> selectAllRaces(final List<CharacterClass> allCharacterClasses, final List<Ability> allAbilities) {
    final List<Race> allRaces = new ArrayList<>(raceTable.getNumberOfRows());
    for (final DataRow dataRow : raceTable) {
      final Race race = selectRace(dataRow, allCharacterClasses, allAbilities);
      allRaces.add(race);
    }
    return allRaces;
  }

  private Race selectRace(final DataRow dataRow, final List<CharacterClass> allCharacterClasses, final List<Ability> allAbilities) {
    // id, name, size, base_land_speed, favored_class_id
    // 0, "Human", 4, 30, -1
    final Race race = new Race();
    race.setId(dataRow.getId());
    race.setName((String) dataRow.get(1));
    race.setSize(getSize((Integer) dataRow.get(2)));
    race.setBaseLandSpeed((Integer) dataRow.get(3));
    race.setFavoredCharacterClass(getCharacterClass((Integer) dataRow.get(4), allCharacterClasses));
    race.setAbilities(getAbilities(dataRow.getId(), allAbilities));
    return race;
  }

  private Size getSize(final int sizeId) {
    for (final Size size : Size.values()) {
      if (size.ordinal() == sizeId) {
        return size;
      }
    }
    throw new IllegalArgumentException("Can't determine size with id: " + sizeId);
  }

  private CharacterClass getCharacterClass(final int characterClassId, final List<CharacterClass> allCharacterClasses) {
    if (characterClassId == ANY_CHARACTER_CLASS.getId()) {
      return null;
    }

    for (final CharacterClass characterClass : allCharacterClasses) {
      if (characterClass.getId() == characterClassId) {
        return characterClass;
      }
    }
    throw new IllegalArgumentException("Can't determine character class with id: " + characterClassId);
  }

  private List<Ability> getAbilities(final int raceId, final List<Ability> allAbilities) {
    final List<Ability> abilities = new ArrayList<>();
    for (final DataRow dataRow : raceAbilityTable) {
      if (dataRow.getId() == raceId) {
        final Ability ability = getAbility((Integer) dataRow.get(1), allAbilities);
        abilities.add(ability);
      }
    }
    return abilities;
  }

  private Ability getAbility(final int abilityId, final List<Ability> allAbilities) {
    for (final Ability ability : allAbilities) {
      if (ability.getId() == abilityId) {
        return ability;
      }
    }
    throw new IllegalArgumentException("Can't determine ability of id: " + abilityId);
  }

  @Override
  public Race createRace(final Race race) {
    race.setId(raceTable.getNewId());
    insertRaceTable(race);
    insertRaceAbilityTable(race);
    return race;
  }

  private void insertRaceTable(final Race race) {
    // id, name, size, base_land_speed, favored_class_id
    raceTable.insert(new Object[] {race.getId(), race.getName(), race.getSize().ordinal(), race.getBaseLandSpeed(),
        race.getFavoredCharacterClass().getId()
    });
  }

  private void insertRaceAbilityTable(final Race race) {
    for (final Ability ability : race.getAbilities()) {
      // race_id, ability_id
      raceAbilityTable.insert(new Object[] {race.getId(), ability.getId()});
    }
  }

  @Override
  public void deleteRace(final Race race) {
    raceAbilityTable.delete(race.getId());
    raceTable.delete(race.getId());
  }

  @Override
  public void updateRace(final Race race) {
    deleteRace(race);
    insertRaceTable(race);
    insertRaceAbilityTable(race);
  }

}
