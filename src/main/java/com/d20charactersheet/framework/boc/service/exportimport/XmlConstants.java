package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;

/**
 * Provides contants for the locations of the DTD, xml tags and attributes.
 */
public interface XmlConstants {

  /**
   * Location of the DTD of characters in the www
   */
  public static final String DTD_CHARACTERS_PUBLIC = "http://www.d20CharacterSheet.com/xml/v2/d20cs_characters.dtd";
  /**
   * Location of the DTD of equipment in the www
   */
  public static final String DTD_EQUIPMENT_PUBLIC = "http://www.d20CharacterSheet.com/xml/v1/d20cs_equipment.dtd";

  /**
   * Location of the DTD of characters in the local file system
   */
  public static final String DTD_CHARACTERS_SYSTEM = new File(
      "src/com/android/ash/dnd/framework/boc/service/exportimport/v2/d20cs_characters.dtd").toURI().toString();
  /**
   * Location of the DTD of equipment in the local file system
   */
  public static final String DTD_EQUIPMENT_SYSTEM = new File(
      "src/com/android/ash/dnd/framework/boc/service/exportimport/d20cs_equipment.dtd").toURI().toString();

  /**
   * Tag for characters
   */
  public static final String TAG_CHARACTERS = "characters";
  /**
   * Tag for character
   */
  public static final String TAG_CHARACTER = "character";
  /**
   * Tag for appearance
   */
  public static final String TAG_APPEARANCE = "appearance";
  /**
   * Tag for attributes
   */
  public static final String TAG_ATTRIBUTES = "attributes";
  /**
   * Tag for combat value
   */
  public static final String TAG_COMBAT = "combat";
  /**
   * Tag for saves
   */
  public static final String TAG_SAVES = "saves";
  /**
   * Tag for money
   */
  public static final String TAG_MONEY = "money";
  /**
   * Tag for notes
   */
  public static final String TAG_NOTES = "notes";
  /**
   * Tag for attacks
   */
  public static final String TAG_ATTACKS = "attacks";
  /**
   * Tag for skills
   */
  public static final String TAG_SKILLS = "skills";
  /**
   * Tag for feats
   */
  public static final String TAG_FEATS = "feats";
  /**
   * Tag for spells
   */
  public static final String TAG_SPELLS = "spells";
  /**
   * Tag for equipment
   */
  public static final String TAG_EQUIPMENT = "equipment";
  /**
   * Tag for name
   */
  public static final String TAG_NAME = "name";
  /**
   * Tag for player name
   */
  public static final String TAG_PLAYER = "player";
  /**
   * Tag for race
   */
  public static final String TAG_RACE = "race";
  /**
   * Tag for sex
   */
  public static final String TAG_SEX = "sex";
  /**
   * Tag for alignment
   */
  public static final String TAG_ALIGNMENT = "alignment";
  /**
   * Tag for xp points
   */
  public static final String TAG_XPPOINTS = "xppoints";
  /**
   * Tag for xp table id
   */
  public static final String TAG_XPTABLEID = "xptableid";
  /**
   * Tag for class levels
   */
  public static final String TAG_CLASSLEVELS = "classlevels";
  /**
   * Tag for class level
   */
  public static final String TAG_CLASSLEVEL = "classlevel";
  /**
   * Tag for class
   */
  public static final String TAG_CLASS = "class";
  /**
   * Tag for level
   */
  public static final String TAG_LEVEL = "level";
  /**
   * Tag for class abilities
   */
  public static final String TAG_CLASSABILITIES = "classabilities";
  /**
   * Tag for class ability
   */
  public static final String TAG_CLASSABILITY = "classability";
  /**
   * Tag for attribute
   */
  public static final String TAG_ATTRIBUTE = "attribute";
  /**
   * Tag for hit points
   */
  public static final String TAG_HITPOINTS = "hitpoints";
  /**
   * Tag for max hit points
   */
  public static final String TAG_MAXHITPOINTS = "maxhitpoints";
  /**
   * Tag for armor modifier
   */
  public static final String TAG_ARMORMOD = "armormod";
  /**
   * Tag for initative modifier
   */
  public static final String TAG_INITATIVEMOD = "initiativemod";
  /**
   * Tag for CMB modifier
   */
  public static final String TAG_CMBMOD = "cmbmod";
  /**
   * Tag for CMD modifier
   */
  public static final String TAG_CMDMOD = "cmdmod";
  /**
   * Tag for fortify modifier
   */
  public static final String TAG_FORTIFYMOD = "fortifymod";
  /**
   * Tag for reflex modifier
   */
  public static final String TAG_REFLEXMOD = "reflexmod";
  /**
   * Tag for will modifier
   */
  public static final String TAG_WILLMOD = "willmod";
  /**
   * Tag for platinum
   */
  public static final String TAG_PLATINUM = "platinum";
  /**
   * Tag for gold
   */
  public static final String TAG_GOLD = "gold";
  /**
   * Tag for silver
   */
  public static final String TAG_SILVER = "silver";
  /**
   * Tag for copper
   */
  public static final String TAG_COPPER = "copper";
  /**
   * Tag for note
   */
  public static final String TAG_NOTE = "note";
  /**
   * Tag for date
   */
  public static final String TAG_DATE = "date";
  /**
   * Tag for text
   */
  public static final String TAG_TEXT = "text";
  /**
   * Tag for attack
   */
  public static final String TAG_ATTACK = "attack";
  /**
   * Tag for description
   */
  public static final String TAG_DESCRIPTION = "description";
  /**
   * Tag for attack wield
   */
  public static final String TAG_ATTACKWIELD = "attackwield";
  /**
   * Tag for attack weapon
   */
  public static final String TAG_ATTACKWEAPON = "attackweapon";
  /**
   * Tag for attack bonus modifier
   */
  public static final String TAG_ATTACKBONUSMOD = "attackbonusmod";
  /**
   * Tag for damage bonus modifier
   */
  public static final String TAG_DAMAGEBONUSMOD = "damagebonusmod";
  /**
   * Tag for skill
   */
  public static final String TAG_SKILL = "skill";
  /**
   * Tag for rank
   */
  public static final String TAG_RANK = "rank";
  /**
   * Tag for skill modifier
   */
  public static final String TAG_SKILLMOD = "skillmod";
  /**
   * Tag for feat
   */
  public static final String TAG_FEAT = "feat";
  /**
   * Tag for category
   */
  public static final String TAG_CATEGORY = "category";
  /**
   * Tag for known spells
   */
  public static final String TAG_KNOWNSPELLS = "knownspells";
  /**
   * Tag for known spell
   */
  public static final String TAG_KNOWNSPELL = "knownspell";
  /**
   * Tag for spell slots
   */
  public static final String TAG_SPELLSLOTS = "spellslots";
  /**
   * Tag for spell slot
   */
  public static final String TAG_SPELLSLOT = "spellslot";
  /**
   * Tag for cast spell slot
   */
  public static final String TAG_CAST = "cast";
  /**
   * Tag for spell list abilities of spell slot
   */
  public static final String TAG_SPELLLISTABILITIES = "spelllistabilities";
  /**
   * Tag for spell list ability of spell slot
   */
  public static final String TAG_SPELLLISTABILITY = "spellistability";
  /**
   * Tag for metamagic feats of spell slot
   */
  public static final String TAG_METAMAGICFEATS = "metamagicfeats";
  /**
   * Tag for metamagic feat of spell slot
   */
  public static final String TAG_METAMAGICFEAT = "metamagicfeat";

  /**
   * Tag for spell
   */
  public static final String TAG_SPELL = "spell";
  /**
   * Tag for spell list
   */
  public static final String TAG_SPELLLIST = "spelllist";

  /**
   * Tag for weapons
   */
  public static final String TAG_WEAPONS = "weapons";
  /**
   * Tag for armors
   */
  public static final String TAG_ARMORS = "armors";
  /**
   * Tag for goods
   */
  public static final String TAG_GOODS = "goods";
  /**
   * Tag for weapon
   */
  public static final String TAG_WEAPON = "weapon";
  /**
   * Tag for armor
   */
  public static final String TAG_ARMOR = "armor";
  /**
   * Tag for good
   */
  public static final String TAG_GOOD = "good";
  /**
   * Tag for number
   */
  public static final String TAG_NUMBER = "number";
  /**
   * Tag for weight
   */
  public static final String TAG_WEIGHT = "weight";
  /**
   * Tag for cost
   */
  public static final String TAG_COST = "cost";
  /**
   * Tag for quality
   */
  public static final String TAG_QUALITY = "quality";
  /**
   * Tag for type
   */
  public static final String TAG_TYPE = "type";
  /**
   * Tag for bonus
   */
  public static final String TAG_BONUS = "bonus";
  /**
   * Tag for penalty
   */
  public static final String TAG_PENALTY = "penalty";
  /**
   * Tag for damage
   */
  public static final String TAG_DAMAGE = "damage";
  /**
   * Tag for critical
   */
  public static final String TAG_CRITICAL = "critical";
  /**
   * Tag for encumbrance
   */
  public static final String TAG_ENCUMBRANCE = "encumbrance";
  /**
   * Tag for enhancement
   */
  public static final String TAG_ENHANCEMENT = "enhancement";
  /**
   * Tag for family
   */
  public static final String TAG_FAMILY = "family";
  /**
   * Tag for range increment
   */
  public static final String TAG_RANGEINCREMENT = "rangeincrement";

  /**
   * Attribute for version
   */
  public static final String ATTRIBUTE_VERSION = "version";
  /**
   * Attribute for game system
   */
  public static final String ATTRIBUTE_GAMESYSTEM = "gamesystem";
  /**
   * Attribute for owned
   */
  public static final String ATTRIBUTE_OWNED = "owned";
  /**
   * Attribute for name
   */
  public static final String ATTRIBUTE_NAME = "name";
  /**
   * Attribute for value
   */
  public static final String ATTRIBUTE_VALUE = "value";
  /**
   * Attribute for number of dice
   */
  public static final String ATTRIBUTE_NUMBEROFDICE = "numberofdice";
  /**
   * Attribute for die
   */
  public static final String ATTRIBUTE_DIE = "die";
  /**
   * Attribute for hit
   */
  public static final String ATTRIBUTE_HIT = "hit";
  /**
   * Attribute for number of multiplier
   */
  public static final String ATTRIBUTE_MULTIPIER = "multiplier";

  /**
   * Pattern of date time
   */
  public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm";

}
