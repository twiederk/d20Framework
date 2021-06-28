package com.d20charactersheet.framework.boc.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.EquipmentPack;
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
 * Implementation of game system. Caches data of games system.
 */
public class GameSystemCacheImpl implements GameSystem {

  private SkillService skillService;
  private FeatService featService;
  private CharacterClassService characterClassService;
  private ItemService itemService;
  private AbilityService abilityService;
  private RaceService raceService;
  private CharacterService characterService;
  private ImageService imageService;
  private RuleService ruleService;
  private DisplayService displayService;
  private SpelllistService spelllistService;
  private XpService xpService;
  private ExportImportService exportImportService;
  private BodyService bodyService;
  private CharacterCreatorService characterCreatorService;

  private List<Skill> allSkills;
  private List<CharacterClass> allCharacterClasses;
  private List<Feat> allFeats;
  private List<WeaponFamily> allWeaponFamilies;
  private List<Weapon> allWeapons;
  private List<Armor> allArmor;
  private List<Good> allGoods;
  private List<EquipmentPack> allEquipmentPacks;
  private List<Race> allRaces;
  private List<Ability> allAbilities;
  private List<Spell> allSpells;
  private List<Spelllist> allSpelllists;
  private List<XpTable> allXpTables;
  private List<KnownSpellsTable> allKnownSpellsTables;
  private List<SpellsPerDayTable> allSpellsPerDayTables;

  private boolean loaded;
  private final int id;
  private final String name;

  /**
   * Creates a new game system with the given id and name.
   *
   * @param id
   *     The id of the game system.
   * @param name
   *     The name of the game system.
   */
  public GameSystemCacheImpl(final int id, final String name) {
    this.id = id;
    this.name = name;
  }

  public void setCharacterService(@NotNull final CharacterService characterService) {
    this.characterService = characterService;
  }

  public void setSkillService(@NotNull final SkillService skillService) {
    this.skillService = skillService;
  }

  public void setFeatService(@NotNull final FeatService featService) {
    this.featService = featService;
  }

  public void setCharacterClassService(@NotNull final CharacterClassService characterClassService) {
    this.characterClassService = characterClassService;
  }

  public void setItemService(@NotNull final ItemService itemService) {
    this.itemService = itemService;
  }

  public void setRaceService(@NotNull final RaceService raceService) {
    this.raceService = raceService;
  }

  public void setAbilityService(@NotNull final AbilityService abilityService) {
    this.abilityService = abilityService;
  }

  public void setImageService(@NotNull final ImageService imageService) {
    this.imageService = imageService;
  }

  @Override
  public void setRuleService(@NotNull final RuleService ruleService) {
    this.ruleService = ruleService;
  }

  @Override
  public void setDisplayService(@NotNull final DisplayService displayService) {
    this.displayService = displayService;
  }

  @Override
  public void setXpService(@NotNull final XpService xpService) {
    this.xpService = xpService;
  }

  @Override
  public void setExportImportService(@NotNull final ExportImportService exportImportService) {
    this.exportImportService = exportImportService;
  }

  @Override
  public void setBodyService(@NotNull BodyService bodyService) {
    this.bodyService = bodyService;
  }

  @Override
  public void setCharacterCreatorService(@NotNull CharacterCreatorService characterCreatorService) {
    this.characterCreatorService = characterCreatorService;
  }

  @NotNull
  public List<Skill> getAllSkills() {
    if (allSkills == null) {
      allSkills = skillService.getAllSkills();
    }
    return allSkills;
  }

  @NotNull
  public List<CharacterClass> getAllCharacterClasses() {
    if (allCharacterClasses == null) {
      allCharacterClasses = characterClassService.getAllCharacterClasses(getAllSkills(), getAllAbilities());
    }
    return allCharacterClasses;
  }

  @NotNull
  public List<Feat> getAllFeats() {
    if (allFeats == null) {
      allFeats = featService.getAllFeats();
    }
    return allFeats;
  }

  @NotNull
  public List<WeaponFamily> getAllWeaponFamilies() {
    if (allWeaponFamilies == null) {
      allWeaponFamilies = itemService.getAllWeaponFamilies();
    }
    return allWeaponFamilies;
  }

  @NotNull
  public List<Weapon> getAllWeapons() {
    if (allWeapons == null) {
      allWeapons = itemService.getAllWeapons(getAllWeaponFamilies());
    }
    return allWeapons;
  }

  @NotNull
  public List<Armor> getAllArmor() {
    if (allArmor == null) {
      allArmor = itemService.getAllArmor();
    }
    return allArmor;
  }

  @NotNull
  public List<Good> getAllGoods() {
    if (allGoods == null) {
      allGoods = itemService.getAllGoods();
    }
    return allGoods;
  }

  @NotNull
  public List<EquipmentPack> getAllEquipmentPacks() {
    if (allEquipmentPacks == null) {
      allEquipmentPacks = itemService.getAllEquipmentPacks(getAllGoods());
    }
    return allEquipmentPacks;
  }

  @NotNull
  public List<Race> getAllRaces() {
    if (allRaces == null) {
      allRaces = raceService.getAllRaces(getAllCharacterClasses(), getAllAbilities());
    }
    return allRaces;
  }

  @NotNull
  public List<Ability> getAllAbilities() {
    if (allAbilities == null) {
      allAbilities = abilityService.getAllAbilities(getAllSpelllists(), getAllKnownSpellsTables(), getAllSpellsPerDayTables());
    }
    return allAbilities;
  }

  @Override
  @NotNull
  public List<XpTable> getAllXpTables() {
    if (allXpTables == null) {
      allXpTables = xpService.getAllXpTables();
    }
    return allXpTables;
  }

  @Override
  @NotNull
  public List<KnownSpellsTable> getAllKnownSpellsTables() {
    if (allKnownSpellsTables == null) {
      allKnownSpellsTables = spelllistService.getAllKnownSpellsTables();
    }
    return allKnownSpellsTables;
  }

  @Override
  @NotNull
  public List<SpellsPerDayTable> getAllSpellsPerDayTables() {
    if (allSpellsPerDayTables == null) {
      allSpellsPerDayTables = spelllistService.getAllSpellsPerDayTables();
    }
    return allSpellsPerDayTables;
  }

  public void clear() {
    loaded = false;
    allSkills = null;
    allCharacterClasses = null;
    allFeats = null;
    allWeaponFamilies = null;
    allWeapons = null;
    allArmor = null;
    allGoods = null;
    allRaces = null;
    allAbilities = null;
    allSpells = null;
    allSpelllists = null;
    allXpTables = null;
    allKnownSpellsTables = null;
    allSpellsPerDayTables = null;
  }

  @Override
  @NotNull
  public List<Character> getAllCharacters() {
    return characterService.getAllCharacters(getAllCharacterClasses(), getAllRaces(), getAllAbilities(), getAllSkills(),
                                             getAllFeats(), getAllWeapons(), getAllArmor(), getAllGoods(), getAllSpells(),
                                             getAllXpTables());
  }

  @Override
  @NotNull
  public Character getCharacter(final int id) {
    return characterService.getCharacter(id, getAllCharacterClasses(), getAllRaces(), getAllAbilities(), getAllSkills(),
                                         getAllFeats(), getAllWeapons(), getAllArmor(), getAllGoods(), getAllSpells(),
                                         getAllXpTables());
  }

  @NotNull
  public SkillService getSkillService() {
    return skillService;
  }

  @NotNull
  public FeatService getFeatService() {
    return featService;
  }

  @NotNull
  public CharacterClassService getCharacterClassService() {
    return characterClassService;
  }

  @NotNull
  public ItemService getItemService() {
    return itemService;
  }

  @NotNull
  public AbilityService getAbilityService() {
    return abilityService;
  }

  @NotNull
  public RaceService getRaceService() {
    return raceService;
  }

  @NotNull
  public CharacterService getCharacterService() {
    return characterService;
  }

  @Override
  @NotNull
  public ImageService getImageService() {
    return imageService;
  }

  @Override
  @NotNull
  public RuleService getRuleService() {
    return ruleService;
  }

  @Override
  @NotNull
  public DisplayService getDisplayService() {
    return displayService;
  }

  @Override
  @NotNull
  public XpService getXpService() {
    return xpService;
  }

  @Override
  @NotNull
  public BodyService getBodyService() {
    return bodyService;
  }

  @Override
  @NotNull
  public CharacterCreatorService getCharacterCreatorService() {
    return characterCreatorService;
  }

  @Override
  @NotNull
  public ExportImportService getExportImportService() {
    return exportImportService;
  }

  @Override
  public void setSpelllistService(@NotNull final SpelllistService spelllistService) {
    this.spelllistService = spelllistService;
  }

  @Override
  @NotNull
  public SpelllistService getSpelllistService() {
    return spelllistService;
  }

  @Override
  @NotNull
  public List<Spell> getAllSpells() {
    if (allSpells == null) {
      allSpells = spelllistService.getAllSpells();
    }
    return allSpells;
  }

  @Override
  @NotNull
  public List<Spelllist> getAllSpelllists() {
    if (allSpelllists == null) {
      allSpelllists = spelllistService.getAllSpelllists(getAllSpells());
    }
    return allSpelllists;
  }

  public void deleteCharacter(@NotNull final Character character) {
    imageService.deleteImage(character.getImageId());
    imageService.deleteImage(character.getThumbImageId());
    characterService.deleteCharacter(character);
  }

  @Override
  public void deleteSkill(@NotNull final Skill skill) {
    characterService.deleteSkill(skill);
    characterClassService.deleteSkill(skill);
    skillService.deleteSkill(skill);
    clear();
  }

  @Override
  public void deleteFeat(@NotNull final Feat feat) {
    characterService.deleteFeat(feat);
    featService.deleteFeat(feat);
    clear();
  }

  @Override
  public boolean isLoaded() {
    return loaded;
  }

  @Override
  public void load() {
    allSpells = spelllistService.getAllSpells();
    allSpelllists = spelllistService.getAllSpelllists(allSpells);
    allKnownSpellsTables = spelllistService.getAllKnownSpellsTables();
    allSpellsPerDayTables = spelllistService.getAllSpellsPerDayTables();
    allSkills = skillService.getAllSkills();
    allAbilities = abilityService.getAllAbilities(allSpelllists, allKnownSpellsTables, allSpellsPerDayTables);
    allCharacterClasses = characterClassService.getAllCharacterClasses(allSkills, allAbilities);
    allFeats = featService.getAllFeats();
    allWeaponFamilies = itemService.getAllWeaponFamilies();
    allWeapons = itemService.getAllWeapons(allWeaponFamilies);
    allArmor = itemService.getAllArmor();
    allGoods = itemService.getAllGoods();
    allRaces = raceService.getAllRaces(allCharacterClasses, allAbilities);
    allXpTables = xpService.getAllXpTables();
    loaded = true;
  }

  @Override
  @NotNull
  public String getName() {
    return name;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void deleteSpellFromSpelllist(@NotNull final Spelllist spelllist, @NotNull final Spell spell) {
    spelllistService.deleteSpelllevel(spelllist, spell);
    characterService.deleteKnownSpells(spelllist, spell);
    characterService.deleteSpellSlots(spelllist, spell);
  }

}
