package com.d20charactersheet.framework.boc.service;

import java.util.List;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Race;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.XpTable;

/**
 * Represents consistent game system. Provides services and data of game system. Executes task including more than one
 * service. Provides convenience methods.
 */
public interface GameSystem {

  /**
   * Returns the name of the game system.
   *
   * @return The name of the game system.
   */
  public String getName();

  /**
   * Returns the id of the game system.
   *
   * @return The id of the game system.
   */
  public int getId();

  /**
   * Set the character service.
   *
   * @param characterService
   *     The character service.
   */
  public void setCharacterService(CharacterService characterService);

  /**
   * Set the skill service.
   *
   * @param skillService
   *     The skill service.
   */
  public void setSkillService(SkillService skillService);

  /**
   * Set the feat service.
   *
   * @param featService
   *     The feat service.
   */
  public void setFeatService(FeatService featService);

  /**
   * Set the character class service.
   *
   * @param characterClassService
   *     The character class service.
   */
  public void setCharacterClassService(CharacterClassService characterClassService);

  /**
   * Set the item service.
   *
   * @param itemService
   *     The item service.
   */
  public void setItemService(ItemService itemService);

  /**
   * Set the race service.
   *
   * @param raceService
   *     The race service.
   */
  public void setRaceService(RaceService raceService);

  /**
   * Set the ability service.
   *
   * @param abilityService
   *     The ability service.
   */
  public void setAbilityService(AbilityService abilityService);

  /**
   * Set the image service.
   *
   * @param imageService
   *     The image service.
   */
  public void setImageService(ImageService imageService);

  /**
   * Set the rule service.
   *
   * @param ruleService
   *     The rule service.
   */
  public void setRuleService(RuleService ruleService);

  /**
   * Set the display service.
   *
   * @param displayService
   *     The display service.
   */
  public void setDisplayService(DisplayService displayService);

  /**
   * Set the spelllist service.
   *
   * @param spelllistService
   *     The SpelllistService
   */
  public void setSpelllistService(SpelllistService spelllistService);

  /**
   * Sets the XpService.
   *
   * @param xpService
   *     The XpService
   */
  public void setXpService(XpService xpService);

  /**
   * Sets the ExportImportService.
   *
   * @param exportImportService
   *     The ExportImportService.
   */
  public void setExportImportService(ExportImportService exportImportService);

  /**
   * Returns the skill service.
   *
   * @return The skill service.
   */
  public SkillService getSkillService();

  /**
   * Returns the feat service.
   *
   * @return The feat service.
   */
  public FeatService getFeatService();

  /**
   * Returns the character class service.
   *
   * @return The character class service.
   */
  public CharacterClassService getCharacterClassService();

  /**
   * Returns the item service.
   *
   * @return The item service.
   */
  public ItemService getItemService();

  /**
   * Returns the ability service.
   *
   * @return The ability service.
   */
  public AbilityService getAbilityService();

  /**
   * Returns the race service.
   *
   * @return The race service.
   */
  public RaceService getRaceService();

  /**
   * Returns the character service.
   *
   * @return The character service.
   */
  public CharacterService getCharacterService();

  /**
   * Returns the image service.
   *
   * @return The image service.
   */
  public ImageService getImageService();

  /**
   * Returns the rule service.
   *
   * @return The rule service.
   */
  public RuleService getRuleService();

  /**
   * Returns the display service.
   *
   * @return The display service.
   */
  public DisplayService getDisplayService();

  /**
   * Returns the SpelllistService.
   *
   * @return The SpelllistService.
   */
  public SpelllistService getSpelllistService();

  /**
   * Returns the ExportImportService.
   *
   * @return The ExportImportService.
   */
  public ExportImportService getExportImportService();

  /**
   * Returns the XpService.
   *
   * @return The XpService.
   */
  public XpService getXpService();

  /**
   * Returns all skills of the game system.
   *
   * @return All skills of the game system.
   */
  public List<Skill> getAllSkills();

  /**
   * Returns all character classes of the game system.
   *
   * @return All character classes of the game system.
   */
  public List<CharacterClass> getAllCharacterClasses();

  /**
   * Returns all feats of the game system.
   *
   * @return All feats of the game system.
   */
  public List<Feat> getAllFeats();

  /**
   * Returns all weapons of the game system.
   *
   * @return All weapons of the game system.
   */
  public List<Weapon> getAllWeapons();

  /**
   * Returns all weapon families.
   *
   * @return All weapon families.
   */
  public List<WeaponFamily> getAllWeaponFamilies();

  /**
   * Returns all armor of the game system.
   *
   * @return All armor of the game system.
   */
  public List<Armor> getAllArmor();

  /**
   * Returns all goods of the game system.
   *
   * @return All goods of the game system.
   */
  public List<Good> getAllGoods();

  /**
   * Returns all races of the game system.
   *
   * @return All races of the game system.
   */
  public List<Race> getAllRaces();

  /**
   * Returns all abilities of the game system.
   *
   * @return All abilities of the game system.
   */
  public List<Ability> getAllAbilities();

  /**
   * Returns all spells.
   *
   * @return All spells.
   */
  public List<Spell> getAllSpells();

  /**
   * Returns all spell lists.
   *
   * @return All spell lists.
   */
  public List<Spelllist> getAllSpelllists();

  /**
   * Returns all xp tables.
   *
   * @return All xp tables.
   */
  public List<XpTable> getAllXpTables();

  /**
   * Returns all known spells tables.
   *
   * @return All known spells tables.
   */
  public List<KnownSpellsTable> getAllKnownSpellsTables();

  /**
   * Returns all spells per day tables.
   *
   * @return All spells per day tables.
   */
  public List<SpellsPerDayTable> getAllSpellsPerDayTables();

  /**
   * Clears the game system.
   */
  public void clear();

  /**
   * Loads the game system.
   */
  public void load();

  /**
   * Returns true, if the game system is loaded.
   *
   * @return True, if the game system is loaded.
   */
  public boolean isLoaded();

  /**
   * Returns all characters.
   *
   * @return All characters.
   */
  public List<Character> getAllCharacters();

  /**
   * Returns the character of the given id.
   *
   * @param id
   *     The id of the character.
   *
   * @return The character of the given id.
   */
  public Character getCharacter(int id);

  /**
   * Delete the character, including its images.
   *
   * @param character
   *     The character to delete.
   */
  public void deleteCharacter(Character character);

  /**
   * Delete the skill from the game system.
   *
   * @param skill
   *     The skill to delete.
   */
  public void deleteSkill(Skill skill);

  /**
   * Delete the feat from the game system.
   *
   * @param feat
   *     The feat to delete.
   */
  public void deleteFeat(Feat feat);

  /**
   * Delete spell from spell list.
   *
   * @param spelllist
   *     The spell list to delete the spell of.
   * @param spell
   *     The spell to delete from the spell list.
   */
  public void deleteSpellFromSpelllist(Spelllist spelllist, Spell spell);

}
