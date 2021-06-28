package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

/**
 * Represents consistent game system. Provides services and data of game system. Executes task including more than one
 * service. Provides convenience methods.
 */
interface GameSystem {

    /**
     * Returns the name of the game system.
     *
     * @return The name of the game system.
     */
    val name: String

    /**
     * Returns the id of the game system.
     *
     * @return The id of the game system.
     */
    val id: Int

    /**
     * Returns the skill service.
     *
     * @return The skill service.
     */
    var skillService: SkillService

    /**
     * Returns the feat service.
     *
     * @return The feat service.
     */
    var featService: FeatService

    /**
     * Returns the character class service.
     *
     * @return The character class service.
     */
    var characterClassService: CharacterClassService

    /**
     * Returns the item service.
     *
     * @return The item service.
     */
    var itemService: ItemService

    /**
     * Returns the ability service.
     *
     * @return The ability service.
     */
    var abilityService: AbilityService

    /**
     * Returns the race service.
     *
     * @return The race service.
     */
    var raceService: RaceService

    /**
     * Returns the character service.
     *
     * @return The character service.
     */
    var characterService: CharacterService

    /**
     * Returns the image service.
     *
     * @return The image service.
     */
    var imageService: ImageService

    /**
     * Returns the rule service.
     *
     * @return The rule service.
     */
    var ruleService: RuleService

    /**
     * Returns the display service.
     *
     * @return The display service.
     */
    var displayService: DisplayService

    /**
     * Returns the SpelllistService.
     *
     * @return The SpelllistService.
     */
    var spelllistService: SpelllistService

    /**
     * Returns the ExportImportService.
     *
     * @return The ExportImportService.
     */
    var exportImportService: ExportImportService

    /**
     * Returns the XpService.
     *
     * @return The XpService.
     */
    var xpService: XpService

    /**
     * Returns the BodyService.
     *
     * @return The BodyService.
     */
    var bodyService: BodyService

    /**
     * Returns the CharacterCreatorService.
     *
     * @return The CharacterCreatorService.
     */
    var characterCreatorService: CharacterCreatorService

    /**
     * Returns all skills of the game system.
     *
     * @return All skills of the game system.
     */
    val allSkills: List<Skill>

    /**
     * Returns all character classes of the game system.
     *
     * @return All character classes of the game system.
     */
    val allCharacterClasses: List<CharacterClass>

    /**
     * Returns all feats of the game system.
     *
     * @return All feats of the game system.
     */
    val allFeats: List<Feat>

    /**
     * Returns all weapons of the game system.
     *
     * @return All weapons of the game system.
     */
    val allWeapons: List<Weapon>

    /**
     * Returns all weapon families.
     *
     * @return All weapon families.
     */
    val allWeaponFamilies: List<WeaponFamily>

    /**
     * Returns all armor of the game system.
     *
     * @return All armor of the game system.
     */
    val allArmor: List<Armor>

    /**
     * Returns all goods of the game system.
     *
     * @return All goods of the game system.
     */
    val allGoods: List<Good>

    /**
     * Returns all equipment packs of the game system.
     *
     * @return All equipment packs of the game system.
     */
    val allEquipmentPacks: List<EquipmentPack>

    /**
     * Returns all races of the game system.
     *
     * @return All races of the game system.
     */
    val allRaces: List<Race>

    /**
     * Returns all abilities of the game system.
     *
     * @return All abilities of the game system.
     */
    val allAbilities: List<Ability>

    /**
     * Returns all spells.
     *
     * @return All spells.
     */
    val allSpells: List<Spell>

    /**
     * Returns all spell lists.
     *
     * @return All spell lists.
     */
    val allSpelllists: List<Spelllist>

    /**
     * Returns all xp tables.
     *
     * @return All xp tables.
     */
    val allXpTables: List<XpTable>

    /**
     * Returns all known spells tables.
     *
     * @return All known spells tables.
     */
    val allKnownSpellsTables: List<KnownSpellsTable>

    /**
     * Returns all spells per day tables.
     *
     * @return All spells per day tables.
     */
    val allSpellsPerDayTables: List<SpellsPerDayTable>

    /**
     * Clears the game system.
     */
    fun clear()

    /**
     * Loads the game system.
     */
    fun load()

    /**
     * Returns true, if the game system is loaded.
     *
     * @return True, if the game system is loaded.
     */
    val isLoaded: Boolean

    /**
     * Returns all characters.
     *
     * @return All characters.
     */
    val allCharacters: List<Character>

    /**
     * Returns the character of the given id.
     *
     * @param id
     * The id of the character.
     *
     * @return The character of the given id.
     */
    fun getCharacter(id: Int): Character

    /**
     * Delete the character, including its images.
     *
     * @param character
     * The character to delete.
     */
    fun deleteCharacter(character: Character)

    /**
     * Delete the skill from the game system.
     *
     * @param skill
     * The skill to delete.
     */
    fun deleteSkill(skill: Skill)

    /**
     * Delete the feat from the game system.
     *
     * @param feat
     * The feat to delete.
     */
    fun deleteFeat(feat: Feat)

    /**
     * Delete spell from spell list.
     *
     * @param spelllist
     * The spell list to delete the spell of.
     * @param spell
     * The spell to delete from the spell list.
     */
    fun deleteSpellFromSpelllist(spelllist: Spelllist, spell: Spell)
}