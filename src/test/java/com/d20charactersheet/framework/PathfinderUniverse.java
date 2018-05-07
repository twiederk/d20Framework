package com.d20charactersheet.framework;

import static com.d20charactersheet.framework.dac.dao.dummy.storage.DnDv35CharacterStorage.CHARACTER_BODY_PART;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderAbilityStorage.ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderAbilityStorage.ABILITY_PROPERTY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderArmorStorage.ARMOR;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_ARMOR;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_ATTACK;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_CLASS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_FEAT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_GOOD;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_KNOWN_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_NOTE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_SPELL_SLOT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_SPELL_SLOT_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_SPELL_SLOT_FEAT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderCharacterStorage.CHARACTER_WEAPON;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderClassStorage.CLASS;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderClassStorage.CLASS_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderClassStorage.CLASS_SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderFeatStorage.FEAT;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderGoodStorage.GOOD;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderKnownSpellsStorage.KNOWN_SPELLS_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderKnownSpellsStorage.KNOWN_SPELLS_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderRaceStorage.RACE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderRaceStorage.RACE_ABILITY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderSkillStorage.SKILL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderSpellStorage.SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderSpelllistStorage.SPELLLIST;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderSpelllistStorage.SPELLLIST_SPELL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderSpellsPerDayStorage.SPELLS_PER_DAY_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderSpellsPerDayStorage.SPELLS_PER_DAY_TABLE;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderWeaponStorage.WEAPON;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderWeaponStorage.WEAPON_FAMILY;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderXpStorage.XP_LEVEL;
import static com.d20charactersheet.framework.dac.dao.dummy.storage.PathfinderXpStorage.XP_TABLE;

import com.d20charactersheet.framework.boc.service.AbilityService;
import com.d20charactersheet.framework.boc.service.AbilityServiceImpl;
import com.d20charactersheet.framework.boc.service.BodyService;
import com.d20charactersheet.framework.boc.service.CharacterClassService;
import com.d20charactersheet.framework.boc.service.CharacterClassServiceImpl;
import com.d20charactersheet.framework.boc.service.CharacterService;
import com.d20charactersheet.framework.boc.service.CharacterServiceImpl;
import com.d20charactersheet.framework.boc.service.ExportImportService;
import com.d20charactersheet.framework.boc.service.ExportImportServiceImpl;
import com.d20charactersheet.framework.boc.service.FeatService;
import com.d20charactersheet.framework.boc.service.FeatServiceImpl;
import com.d20charactersheet.framework.boc.service.GameSystemCacheImpl;
import com.d20charactersheet.framework.boc.service.ItemService;
import com.d20charactersheet.framework.boc.service.ItemServiceImpl;
import com.d20charactersheet.framework.boc.service.PathfinderRuleServiceImpl;
import com.d20charactersheet.framework.boc.service.RaceService;
import com.d20charactersheet.framework.boc.service.RaceServiceImpl;
import com.d20charactersheet.framework.boc.service.SkillService;
import com.d20charactersheet.framework.boc.service.SkillServiceImpl;
import com.d20charactersheet.framework.boc.service.SpelllistService;
import com.d20charactersheet.framework.boc.service.SpelllistServiceImpl;
import com.d20charactersheet.framework.boc.service.XpService;
import com.d20charactersheet.framework.boc.service.XpServiceImpl;
import com.d20charactersheet.framework.dac.dao.dummy.DummyAbilityDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummyCharacterDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummyClassDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummyFeatDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummyItemDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummyRaceDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummySkillDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummySpelllistDao;
import com.d20charactersheet.framework.dac.dao.dummy.DummyXpDao;

public class PathfinderUniverse extends AbstractUniverse {

  public PathfinderUniverse() {
    super();
    final SkillService skillService = new SkillServiceImpl(new DummySkillDao(SKILL));
    final FeatService featService = new FeatServiceImpl(new DummyFeatDao(FEAT));
    final CharacterClassService characterClassService = new CharacterClassServiceImpl(
        new DummyClassDao(CLASS, CLASS_SKILL, CLASS_ABILITY));
    final RaceService raceService = new RaceServiceImpl(new DummyRaceDao(RACE, RACE_ABILITY));
    final AbilityService abilityService = new AbilityServiceImpl(new DummyAbilityDao(ABILITY, ABILITY_PROPERTY));
    final ItemService itemService = new ItemServiceImpl(new DummyItemDao(WEAPON_FAMILY, WEAPON, ARMOR, GOOD));
    final CharacterService characterService = new CharacterServiceImpl(
        new DummyCharacterDao(CHARACTER, CHARACTER_CLASS_LEVEL, CHARACTER_ABILITY, CHARACTER_SKILL, CHARACTER_FEAT,
                              CHARACTER_WEAPON, CHARACTER_ARMOR, CHARACTER_GOOD, CHARACTER_NOTE, CHARACTER_ATTACK,
                              CHARACTER_KNOWN_SPELL, CHARACTER_SPELL_SLOT, CHARACTER_SPELL_SLOT_ABILITY,
                              CHARACTER_SPELL_SLOT_FEAT, CHARACTER_BODY_PART));
    final SpelllistService spelllistService = new SpelllistServiceImpl(
        new DummySpelllistDao(SPELL, SPELLLIST, SPELLLIST_SPELL, KNOWN_SPELLS_TABLE, KNOWN_SPELLS_LEVEL, SPELLS_PER_DAY_TABLE,
                              SPELLS_PER_DAY_LEVEL));
    final XpService xpService = new XpServiceImpl(new DummyXpDao(XP_TABLE, XP_LEVEL));
    final ExportImportService exportImportService = new ExportImportServiceImpl();

    gameSystem = new GameSystemCacheImpl(2, "Pathfinder");
    gameSystem.setSkillService(skillService);
    gameSystem.setFeatService(featService);
    gameSystem.setCharacterClassService(characterClassService);
    gameSystem.setItemService(itemService);
    gameSystem.setRaceService(raceService);
    gameSystem.setAbilityService(abilityService);
    gameSystem.setCharacterService(characterService);
    gameSystem.setSpelllistService(spelllistService);
    gameSystem.setXpService(xpService);
    gameSystem.setExportImportService(exportImportService);
    gameSystem.setBodyService(new BodyService());
    gameSystem.setRuleService(new PathfinderRuleServiceImpl());
  }
}
