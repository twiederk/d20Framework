package com.d20charactersheet.framework.boc.service.exportimport;

import java.util.LinkedList;
import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.FeatType;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.XpTable;

/**
 * Contains all data of the game system necessary for import.
 */
public class ImportContext {

  private String gameSystemName;

  private List<Race> allRaces;
  private List<CharacterClass> allClasses;
  private List<XpTable> allXpTables;
  private List<Skill> allSkills;
  private List<Feat> allFeats;
  private List<Weapon> allWeapons;
  private List<WeaponFamily> allWeaponFamilies;
  private List<Armor> allArmor;
  private List<Good> allGoods;
  private List<Spell> allSpells;
  private List<Spelllist> allSpelllists;
  private List<SpelllistAbility> allSpelllistAbilities;
  private List<Ability> allAbilities;
  private List<Feat> allMetamagicFeats;

  /**
   * Sets all races.
   *
   * @param allRaces
   *     Set all races of the game system.
   */
  public void setAllRaces(final List<Race> allRaces) {
    this.allRaces = allRaces;
  }

  /**
   * Sets all classes.
   *
   * @param allClasses
   *     Set all classes of the game system.
   */
  public void setAllClasses(final List<CharacterClass> allClasses) {
    this.allClasses = allClasses;
  }

  /**
   * Sets all xp tables.
   *
   * @param allXpTables
   *     The xp tables to set.
   */
  public void setAllXpTables(final List<XpTable> allXpTables) {
    this.allXpTables = allXpTables;
  }

  /**
   * Sets the weapon families.
   *
   * @param allWeaponFamilies
   *     The weapon families to set.
   */
  public void setAllWeaponFamilies(final List<WeaponFamily> allWeaponFamilies) {
    this.allWeaponFamilies = allWeaponFamilies;
  }

  /**
   * Sets all skills.
   *
   * @param allSkills
   *     Set all skills of the game system.
   */
  public void setAllSkills(final List<Skill> allSkills) {
    this.allSkills = allSkills;
  }

  /**
   * Sets all feats
   *
   * @param allFeats
   *     Set all feats of the game system.
   */
  public void setAllFeats(final List<Feat> allFeats) {
    this.allFeats = allFeats;
  }

  /**
   * Sets all weapons.
   *
   * @param allWeapons
   *     Set all weapons of the game system.
   */
  public void setAllWeapons(final List<Weapon> allWeapons) {
    this.allWeapons = allWeapons;
  }

  /**
   * Sets all armor
   *
   * @param allArmor
   *     Set all armor of the game system.
   */
  public void setAllArmor(final List<Armor> allArmor) {
    this.allArmor = allArmor;
  }

  /**
   * Sets all goods.
   *
   * @param allGoods
   *     Set all goods of the game system.
   */
  public void setAllGoods(final List<Good> allGoods) {
    this.allGoods = allGoods;
  }

  /**
   * Sets all spells.
   *
   * @param allSpells
   *     All spells of the game system.
   */
  public void setAllSpells(final List<Spell> allSpells) {
    this.allSpells = allSpells;
  }

  /**
   * Set all spell lists.
   *
   * @param allSpelllists
   *     All spell list of the game system.
   */
  public void setAllSpelllists(final List<Spelllist> allSpelllists) {
    this.allSpelllists = allSpelllists;
  }

  /**
   * Sets the name of the game system.
   *
   * @param gameSystemName
   *     The name of the game system.
   */
  public void setGameSystemName(final String gameSystemName) {
    this.gameSystemName = gameSystemName;
  }

  /**
   * Returns name of the game system.
   *
   * @return Name of the game system.
   */
  public String getGameSystemName() {
    return gameSystemName;
  }

  /**
   * Returns all races.
   *
   * @return All races.
   */
  public List<Race> getAllRaces() {
    return allRaces;
  }

  /**
   * Returns all classes.
   *
   * @return All classes.
   */
  public List<CharacterClass> getAllClasses() {
    return allClasses;
  }

  /**
   * Returns all xp tables.
   *
   * @return All xp tables.
   */
  public List<XpTable> getAllXpTables() {
    return allXpTables;
  }

  /**
   * Returns all skills.
   *
   * @return All skills.
   */
  public List<Skill> getAllSkills() {
    return allSkills;
  }

  /**
   * Returns all feats.
   *
   * @return all feats.
   */
  public List<Feat> getAllFeats() {
    return allFeats;
  }

  /**
   * Returns all weapons.
   *
   * @return All weapons.
   */
  public List<Weapon> getAllWeapons() {
    return allWeapons;
  }

  /**
   * Returns all armor.
   *
   * @return All armor.
   */
  public List<Armor> getAllArmor() {
    return allArmor;
  }

  /**
   * Returns all goods.
   *
   * @return All goods.
   */
  public List<Good> getAllGoods() {
    return allGoods;
  }

  /**
   * Returns all spells.
   *
   * @return All spells.
   */
  public List<Spell> getAllSpells() {
    return allSpells;
  }

  /**
   * Returns all spell lists of the game system.
   *
   * @return All spell lists of the game system.
   */
  public List<Spelllist> getAllSpelllists() {
    return allSpelllists;
  }

  /**
   * Returns all weapon families.
   *
   * @return All weapon families.
   */
  public List<WeaponFamily> getAllWeaponFamilies() {
    return allWeaponFamilies;
  }

  /**
   * Returns all spell list abilities of the game system.
   *
   * @return All spell list abilities of the game system.
   */
  public List<SpelllistAbility> getAllSpelllistAbilities() {
    if (allSpelllistAbilities == null) {
      allSpelllistAbilities = new LinkedList<>();
      for (final Ability ability : allAbilities) {
        if (ability instanceof SpelllistAbility) {
          final SpelllistAbility spelllistAbilitiy = (SpelllistAbility) ability;
          allSpelllistAbilities.add(spelllistAbilitiy);
        }
      }
    }
    return allSpelllistAbilities;
  }

  /**
   * Returns all abilities of the game system.
   *
   * @return All abilities of the game system.
   */
  public List<Ability> getAllAbilities() {
    return allAbilities;
  }

  /**
   * Set all abilities of the game system.
   *
   * @param allAbilities All abilities of the game system.
   */
  public void setAllAbilities(final List<Ability> allAbilities) {
    this.allAbilities = allAbilities;
  }

  /**
   * Returns all metamagic feats of the game system.
   *
   * @return All metamagic feats of the game system.
   */
  public List<Feat> getAllMetamagicFeats() {
    if (allMetamagicFeats == null) {
      allMetamagicFeats = new LinkedList<>();
      for (final Feat feat : allFeats) {
        if (FeatType.METAMAGIC.equals(feat.getFeatType())) {
          allMetamagicFeats.add(feat);
        }
      }
    }
    return allMetamagicFeats;
  }

}
