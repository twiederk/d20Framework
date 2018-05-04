package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores races.
 */
public class PathfinderRaceStorage {

  /**
   * Race stats
   */
  public static final Object[][] RACE = { //
      // id, name, size, base_land_speed, favored_class_id
      {1, "Dwarf", 4, 20, -1}, //
      {2, "Elf", 4, 30, -1}, //
      {3, "Gnome", 3, 20, -1}, //
      {4, "Half-Elf", 4, 30, -1}, //
      {5, "Half-Orc", 4, 30, -1}, //
      {6, "Halfling", 3, 20, -1}, //
      {7, "Human", 4, 30, -1}, //
      {8, "Eidolon - Quadruped", 4, 40, -1}, //
      {9, "Eidolon - Biped", 4, 30, -1}, //
      {10, "Eidolon - Serpentine", 4, 20, -1}, //
  };

  /**
   * Trais of races
   */
  public static final Object[][] RACE_ABILITY = { //
      // race_id, ability_id
      {1, 1}, //
      {1, 2}, //
      {1, 3}, //
      {1, 4}, //
      {1, 5}, //
      {1, 6}, //
      {1, 7}, //
      {1, 41}, //
      {2, 8}, //
      {2, 9}, //
      {2, 10}, //
      {2, 11}, //
      {2, 12}, //
      {3, 13}, //
      {3, 9}, //
      {3, 15}, //
      {3, 16}, //
      {3, 17}, //
      {3, 18}, //
      {3, 12}, //
      {3, 20}, //
      {4, 21}, //
      {4, 9}, //
      {4, 23}, //
      {4, 24}, //
      {4, 10}, //
      {4, 12}, //
      {4, 27}, //
      {5, 21}, //
      {5, 2}, //
      {5, 30}, //
      {5, 31}, //
      {5, 32}, //
      {6, 33}, //
      {6, 34}, //
      {6, 35}, //
      {6, 12}, //
      {6, 37}, //
      {7, 21}, //
      {7, 39}, //
      {7, 40}, //
  };
}
