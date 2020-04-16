package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;

/**
 * Provides contants for the locations of the DTD, xml tags and attributes.
 */
public interface XmlConstants {

  /**
   * Location of the DTD of characters in the www
   */
  String DTD_CHARACTERS_PUBLIC = "http://www.d20CharacterSheet.com/xml/v2/d20cs_characters.dtd";
  /**
   * Location of the DTD of equipment in the www
   */
  String DTD_EQUIPMENT_PUBLIC = "http://www.d20CharacterSheet.com/xml/v1/d20cs_equipment.dtd";

  /**
   * Location of the DTD of characters in the local file system
   */
  String DTD_CHARACTERS_SYSTEM = new File(
      "src/com/android/ash/dnd/framework/boc/service/exportimport/v2/d20cs_characters.dtd").toURI()
      .toString();
  /**
   * Location of the DTD of equipment in the local file system
   */
  String DTD_EQUIPMENT_SYSTEM = new File("src/com/android/ash/dnd/framework/boc/service/exportimport/d20cs_equipment.dtd").toURI()
      .toString();

  /**
   * Tag for characters
   */
  String TAG_CHARACTERS = "characters";
  /**
   * Tag for character
   */
  String TAG_CHARACTER = "character";
  /**
   * Tag for appearance
   */
  String TAG_APPEARANCE = "appearance";
  /**
   * Tag for attributes
   */
  String TAG_ATTRIBUTES = "attributes";
  /**
   * Tag for combat value
   */
  String TAG_COMBAT = "combat";
  /**
   * Tag for saves
   */
  String TAG_SAVES = "saves";
  /**
   * Tag for money
   */
  String TAG_MONEY = "money";
  /**
   * Tag for notes
   */
  String TAG_NOTES = "notes";
  /**
   * Tag for attacks
   */
  String TAG_ATTACKS = "attacks";
  /**
   * Tag for skills
   */
  String TAG_SKILLS = "skills";
  /**
   * Tag for feats
   */
  String TAG_FEATS = "feats";
  /**
   * Tag for spells
   */
  String TAG_SPELLS = "spells";
  /**
   * Tag for equipment
   */
  String TAG_EQUIPMENT = "equipment";
  /**
   * Tag for name
   */
  String TAG_NAME = "name";
  /**
   * Tag for player name
   */
  String TAG_PLAYER = "player";
  /**
   * Tag for race
   */
  String TAG_RACE = "race";
  /**
   * Tag for sex
   */
  String TAG_SEX = "sex";
  /**
   * Tag for alignment
   */
  String TAG_ALIGNMENT = "alignment";
  /**
   * Tag for xp points
   */
  String TAG_XPPOINTS = "xppoints";
  /**
   * Tag for xp table id
   */
  String TAG_XPTABLEID = "xptableid";
  /**
   * Tag for class levels
   */
  String TAG_CLASSLEVELS = "classlevels";
  /**
   * Tag for class level
   */
  String TAG_CLASSLEVEL = "classlevel";
  /**
   * Tag for class
   */
  String TAG_CLASS = "class";
  /**
   * Tag for level
   */
  String TAG_LEVEL = "level";
  /**
   * Tag for class abilities
   */
  String TAG_CLASSABILITIES = "classabilities";
  /**
   * Tag for class ability
   */
  String TAG_CLASSABILITY = "classability";
  /**
   * Tag for attribute
   */
  String TAG_ATTRIBUTE = "attribute";
  /**
   * Tag for hit points
   */
  String TAG_HITPOINTS = "hitpoints";
  /**
   * Tag for max hit points
   */
  String TAG_MAXHITPOINTS = "maxhitpoints";
  /**
   * Tag for armor modifier
   */
  String TAG_ARMORMOD = "armormod";
  /**
   * Tag for initative modifier
   */
  String TAG_INITATIVEMOD = "initiativemod";
  /**
   * Tag for CMB modifier
   */
  String TAG_CMBMOD = "cmbmod";
  /**
   * Tag for CMD modifier
   */
  String TAG_CMDMOD = "cmdmod";
  /**
   * Tag for fortify modifier
   */
  String TAG_FORTIFYMOD = "fortifymod";
  /**
   * Tag for reflex modifier
   */
  String TAG_REFLEXMOD = "reflexmod";
  /**
   * Tag for will modifier
   */
  String TAG_WILLMOD = "willmod";
  /**
   * Tag for platinum
   */
  String TAG_PLATINUM = "platinum";
  /**
   * Tag for gold
   */
  String TAG_GOLD = "gold";
  /**
   * Tag for silver
   */
  String TAG_SILVER = "silver";
  /**
   * Tag for copper
   */
  String TAG_COPPER = "copper";
  /**
   * Tag for note
   */
  String TAG_NOTE = "note";
  /**
   * Tag for date
   */
  String TAG_DATE = "date";
  /**
   * Tag for text
   */
  String TAG_TEXT = "text";
  /**
   * Tag for attack
   */
  String TAG_ATTACK = "attack";
  /**
   * Tag for description
   */
  String TAG_DESCRIPTION = "description";
  /**
   * Tag for attack wield
   */
  String TAG_ATTACKWIELD = "attackwield";
  /**
   * Tag for attack weapon
   */
  String TAG_ATTACKWEAPON = "attackweapon";
  /**
   * Tag for attack bonus modifier
   */
  String TAG_ATTACKBONUSMOD = "attackbonusmod";
  /**
   * Tag for damage bonus modifier
   */
  String TAG_DAMAGEBONUSMOD = "damagebonusmod";
  /**
   * Tag for skill
   */
  String TAG_SKILL = "skill";
  /**
   * Tag for rank
   */
  String TAG_RANK = "rank";
  /**
   * Tag for skill modifier
   */
  String TAG_SKILLMOD = "skillmod";
  /**
   * Tag for feat
   */
  String TAG_FEAT = "feat";
  /**
   * Tag for category
   */
  String TAG_CATEGORY = "category";
  /**
   * Tag for known spells
   */
  String TAG_KNOWNSPELLS = "knownspells";
  /**
   * Tag for known spell
   */
  String TAG_KNOWNSPELL = "knownspell";
  /**
   * Tag for spell slots
   */
  String TAG_SPELLSLOTS = "spellslots";
  /**
   * Tag for spell slot
   */
  String TAG_SPELLSLOT = "spellslot";
  /**
   * Tag for cast spell slot
   */
  String TAG_CAST = "cast";
  /**
   * Tag for spell list abilities of spell slot
   */
  String TAG_SPELLLISTABILITIES = "spelllistabilities";
  /**
   * Tag for spell list ability of spell slot
   */
  String TAG_SPELLLISTABILITY = "spellistability";
  /**
   * Tag for metamagic feats of spell slot
   */
  String TAG_METAMAGICFEATS = "metamagicfeats";
  /**
   * Tag for metamagic feat of spell slot
   */
  String TAG_METAMAGICFEAT = "metamagicfeat";

  /**
   * Tag for spell
   */
  String TAG_SPELL = "spell";
  /**
   * Tag for spell list
   */
  String TAG_SPELLLIST = "spelllist";

  /**
   * Tag for weapons
   */
  String TAG_WEAPONS = "weapons";
  /**
   * Tag for armors
   */
  String TAG_ARMORS = "armors";
  /**
   * Tag for goods
   */
  String TAG_GOODS = "goods";
  /**
   * Tag for weapon
   */
  String TAG_WEAPON = "weapon";
  /**
   * Tag for armor
   */
  String TAG_ARMOR = "armor";
  /**
   * Tag for good
   */
  String TAG_GOOD = "good";
  /**
   * Tag for number
   */
  String TAG_NUMBER = "number";
  /**
   * Tag for weight
   */
  String TAG_WEIGHT = "weight";
  /**
   * Tag for cost
   */
  String TAG_COST = "cost";
  /**
   * Tag for quality
   */
  String TAG_QUALITY = "quality";
  /**
   * Tag for type
   */
  String TAG_TYPE = "type";
  /**
   * Tag for bonus
   */
  String TAG_BONUS = "bonus";
  /**
   * Tag for penalty
   */
  String TAG_PENALTY = "penalty";
  /**
   * Tag for damage
   */
  String TAG_DAMAGE = "damage";
  /**
   * Tag for critical
   */
  String TAG_CRITICAL = "critical";
  /**
   * Tag for encumbrance
   */
  String TAG_ENCUMBRANCE = "encumbrance";
  /**
   * Tag for enhancement
   */
  String TAG_ENHANCEMENT = "enhancement";
  /**
   * Tag for family
   */
  String TAG_FAMILY = "family";
  /**
   * Tag for range increment
   */
  String TAG_RANGEINCREMENT = "rangeincrement";

  /**
   * Attribute for version
   */
  String ATTRIBUTE_VERSION = "version";
  /**
   * Attribute for game system
   */
  String ATTRIBUTE_GAMESYSTEM = "gamesystem";
  /**
   * Attribute for owned
   */
  String ATTRIBUTE_OWNED = "owned";
  /**
   * Attribute for name
   */
  String ATTRIBUTE_NAME = "name";
  /**
   * Attribute for value
   */
  String ATTRIBUTE_VALUE = "value";
  /**
   * Attribute for number of dice
   */
  String ATTRIBUTE_NUMBEROFDICE = "numberofdice";
  /**
   * Attribute for die
   */
  String ATTRIBUTE_DIE = "die";
  /**
   * Attribute for hit
   */
  String ATTRIBUTE_HIT = "hit";
  /**
   * Attribute for number of multiplier
   */
  String ATTRIBUTE_MULTIPIER = "multiplier";

  /**
   * Pattern of date time
   */
  String PATTERN_DATETIME = "yyyy-MM-dd HH:mm";

}
