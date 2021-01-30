package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.*

/**
 * Data access object to persistent character data.
 */
interface CharacterDao {
    
    /**
     * Returns list of all available characters. All character classes are necessary to instanciate the characters.
     *
     * @param allCharacterClasses
     * All available character classes of the game system.
     * @param allRaces
     * All races of the game system.
     * @param allXpTables
     * All Xp tables of the game system.
     *
     * @return List of all available characters.
     */
    fun getAllCharacters(allCharacterClasses: List<CharacterClass>, allRaces: List<Race>, allXpTables: List<XpTable>): List<Character>

    /**
     * Returns the character of the given id. All character classes of the game system are necessary to instantiate the
     * character.
     *
     * @param id
     * The id of the character.
     * @param allCharacterClasses
     * All character classes of the game system.
     * @param allRaces
     * All races of the game system.
     * @param allXpTables
     * All Xp tables of the game system.
     *
     * @return The character of the given id.
     */
    fun getCharacter(id: Int, allCharacterClasses: List<CharacterClass>, allRaces: List<Race>, allXpTables: List<XpTable>): Character

    /**
     * Updates the character to the persistence layer.
     *
     * @param character
     * The character to update.
     *
     * @return The given character.
     */
    fun updateCharacter(character: Character): Character

    /**
     * Inserts the character into the persistence layer. Returning it with a valid id.
     *
     * @param character
     * The character to insert.
     *
     * @return The inserted character with a valid id.
     */
    fun createCharacter(character: Character): Character

    /**
     * Delets the character from the persistent layer, including its class levels and notes, excluding its images.
     *
     * @param character
     * The character to delete.
     */
    fun deleteCharacter(character: Character)

    /**
     * Returns skills of the character. Character dependent data ist set.
     *
     * @param character
     * The character to return the skills of.
     * @param allSkills
     * All skills of the game system.
     *
     * @return Skills of the character.
     */
    fun getCharacterSkills(character: Character, allSkills: List<Skill>): List<CharacterSkill>

    /**
     * Delete all skills of the character.
     *
     * @param character
     * The character to delete the skills of.
     */
    fun deleteCharacterSkills(character: Character)

    /**
     * Returns the feats of the character.
     *
     * @param character
     * The character to get the feats of.
     * @param allFeats
     * All feats of the game system.
     *
     * @return The feats of the character.
     */
    fun getCharacterFeats(character: Character, allFeats: List<Feat>): List<CharacterFeat>

    /**
     * Updates the feats of the character.
     *
     * @param character
     * The character with the feats to update.
     */
    fun updateCharacterFeats(character: Character)

    /**
     * Delete all feats of the character.
     *
     * @param character
     * The character to delete the feats of.
     */
    fun deleteCharacterFeats(character: Character)

    /**
     * Returns all weapons of the character.
     *
     * @param character
     * The character to get its weapons from.
     * @param allWeapons
     * All existing weapons.
     *
     * @return The weapons of the character.
     */
    fun getWeapons(character: Character, allWeapons: List<Weapon>): List<ItemGroup>

    /**
     * Returns all armor of the character.
     *
     * @param character
     * The character to get the armor from.
     * @param allArmor
     * All existing armor.
     *
     * @return The armor of the character.
     */
    fun getArmor(character: Character, allArmor: List<Armor>): List<ItemGroup>

    /**
     * Returns all good of the character
     *
     * @param character
     * The character to get its goods.
     * @param allGoods
     * All existing goods.
     *
     * @return The goods of the character.
     */
    fun getGoods(character: Character, allGoods: List<Good>): List<ItemGroup>

    /**
     * Updates the weapons of the character.
     *
     * @param character
     * The character to update.
     * @param weapons
     * The weapons to update.
     *
     * @return The updated list of weapons.
     */
    fun updateWeapons(character: Character, weapons: List<ItemGroup>): List<ItemGroup>

    /**
     * Updates the armor of the character.
     *
     * @param character
     * The character to update.
     * @param armor
     * The armor to update.
     *
     * @return The updated list of armor.
     */
    fun updateArmor(character: Character, armor: List<ItemGroup>): List<ItemGroup>

    /**
     * Updates the goods of the character.
     *
     * @param character
     * The character top update.
     * @param goods
     * The goods to update.
     *
     * @return The updated goods.
     */
    fun updateGoods(character: Character, goods: List<ItemGroup>): List<ItemGroup>

    /**
     * Delete the given Skill from all Characters
     *
     * @param skill
     * The skill to deleted from the game system.
     */
    fun deleteSkill(skill: Skill)

    /**
     * Delete the feat from all characters.
     *
     * @param feat
     * The feat to deleted from the game system.
     */
    fun deleteFeat(feat: Feat)

    /**
     * Returns the notes of the character.
     *
     * @param character
     * The character get the notes of.
     *
     * @return The notes of the character.
     */
    fun getNotes(character: Character): List<Note>

    /**
     * Creates the note belonging to the character.
     *
     * @param note
     * The note to create.
     * @param character
     * The character the note belongs to.
     *
     * @return The created note with a valid id.
     */
    fun createNote(note: Note, character: Character): Note

    /**
     * Updates a note of a character.
     *
     * @param note
     * The note to update.
     * @param character
     * The character the note belongs to.
     */
    fun updateNote(note: Note, character: Character)

    /**
     * Deletes a note from the persistent layer.
     *
     * @param note
     * The note to delete.
     */
    fun deleteNote(note: Note)

    /**
     * Create new CharacterSkill with given skill. Overwrite this methode to usw own subclasses of CharacterSkill.
     *
     * @param skill
     * The skill of the CharacterSkill.
     *
     * @return The created CharacterSkill
     */
    fun newCharacterSkill(skill: Skill): CharacterSkill

    /**
     * Deletes all notes of the given character.
     *
     * @param character
     * The character to delete the notes of.
     */
    fun deleteNotes(character: Character)

    /**
     * Deletes all weapons of the given character.
     *
     * @param character
     * The character to delete the weapons of.
     */
    fun deleteWeapons(character: Character)

    /**
     * Delete all armor of the character.
     *
     * @param character
     * The character to delete armor of.
     */
    fun deleteArmor(character: Character)

    /**
     * Delete all goods of the character.
     *
     * @param character
     * The character to delete goods of.
     */
    fun deleteGoods(character: Character)

    /**
     * Returns list of character abilities.
     *
     * @param character
     * The character to get class abilities of.
     * @param characterClass
     * The class to get character abilities.
     *
     * @return List of character abilities.
     */
    fun getCharacterAbilities(character: Character, characterClass: CharacterClass): List<CharacterAbility>

    /**
     * Updates the character ability.
     *
     * @param characterAbility
     * The character ability to update.
     */
    fun updateCharacterAbility(characterAbility: CharacterAbility)

    /**
     * Create CharacterAbility for character and class.
     *
     * @param character
     * The character to create the CharacterAbility for.
     * @param characterClass
     * The class the ability belongs to.
     * @param characterAbility
     * The CharacterAbility to create.
     */
    fun createCharacterAbility(character: Character, characterClass: CharacterClass, characterAbility: CharacterAbility)

    /**
     * Delete CharacterAbility.
     *
     * @param characterAbility
     * The CharacterAbility to delete.
     */
    fun deleteCharacterAbility(characterAbility: CharacterAbility)

    /**
     * Delete all character abilities of a character.
     *
     * @param character
     * The character to delete the abilities of.
     */
    fun deleteCharacterAbilities(character: Character)

    /**
     * Create a new class level for a character.
     *
     * @param character
     * The character to create the ClassLevel for.
     * @param classLevel
     * The class level to create.
     *
     * @return The created class level.
     */
    fun createClassLevel(character: Character, classLevel: ClassLevel): ClassLevel

    /**
     * Update the class level.
     *
     * @param classLevel
     * The class level to update.
     */
    fun updateClassLevel(classLevel: ClassLevel)

    /**
     * Delete the class level.
     *
     * @param classLevel
     * The class level to delete.
     */
    fun deleteClassLevel(classLevel: ClassLevel)

    /**
     * Delete the given list of character abilities.
     *
     * @param characterClass
     * The class to delete the abilities of.
     * @param classAbilities
     * the class abilities to delete.
     */
    fun deleteCharacterAbilities(characterClass: CharacterClass, classAbilities: List<ClassAbility>)

    /**
     * Returns the weapon attacks of a character.
     *
     * @param character
     * The character to get the weapon attacks of.
     * @param allWeapons
     * All weapons.
     *
     * @return The weapon attacks of a character.
     */
    fun getWeaponAttacks(character: Character, allWeapons: List<Weapon>): List<WeaponAttack>

    /**
     * Create a WeaponAttack for a character.
     *
     * @param character
     * The character to create a WeaponAttack for.
     * @param weaponAttack
     * The WeaponAttack to create.
     *
     * @return The created weapon attack.
     */
    fun createWeaponAttack(character: Character, weaponAttack: WeaponAttack): WeaponAttack

    /**
     * Update the weapon attack.
     *
     * @param weaponAttack
     * The weapon attack to update.
     */
    fun updateWeaponAttack(weaponAttack: WeaponAttack)

    /**
     * Delete the weapon attack.
     *
     * @param weaponAttack
     * The weapon attack to delete.
     */
    fun deleteWeaponAttack(weaponAttack: WeaponAttack)

    /**
     * Delete all weapon attacks of a character.
     *
     * @param character
     * The character to delete all weaon attacks of.
     */
    fun deleteWeaponAttacks(character: Character)

    /**
     * Returns all marked spells of a character.
     *
     * @param character
     * The character to get marked spells of.
     * @param allSpelllist
     * All spell lists of the game sytem.
     * @param allSpells
     * All spells of the game system.
     *
     * @return All marked spells of a character.
     */
    fun getKnownSpells(character: Character, allSpelllist: List<Spelllist>, allSpells: List<Spell>): List<KnownSpell>

    /**
     * Create a new known spell for the character.
     *
     * @param character
     * The character to create the know spell for.
     * @param knownSpell
     * The known spell to create.
     *
     * @return The new created known spell.
     */
    fun createKnownSpell(character: Character, knownSpell: KnownSpell): KnownSpell

    /**
     * Delete the known spell from all characters. Use if a spell is deleted from the game system.
     *
     * @param knownSpell
     * The known spell to delete.
     */
    fun deleteKnownSpell(knownSpell: KnownSpell)

    /**
     * Delete all KnownSpells of a character.
     *
     * @param character
     * The character to delete the known spells of.
     */
    fun deleteKnownSpells(character: Character)

    /**
     * Returns the spell slots of the character.
     *
     * @param character
     * The character t get the spell slots of.
     * @param allSpells
     * All spells of the game system.
     * @param allAbilities
     * All abilities of the game system.
     * @param allFeats
     * All feats of the game system.
     *
     * @return The spell slots of the character.
     */
    fun getSpellSlots(character: Character, allSpells: List<Spell>, allAbilities: List<Ability>, allFeats: List<Feat>): List<SpellSlot>

    /**
     * Update the given spell slot.
     *
     * @param spellSlot
     * The spell slot to update.
     */
    fun updateSpellSlot(spellSlot: SpellSlot)

    /**
     * Create spell slot for character.
     *
     * @param character
     * The character to create the spell slot for.
     * @param spellSlot
     * The spell slot to create.
     *
     * @return The new created spell slot.
     */
    fun createSpellSlot(character: Character, spellSlot: SpellSlot): SpellSlot

    /**
     * Delete the given spell slot.
     *
     * @param spellSlot
     * The spell slot to delete.
     */
    fun deleteSpellSlot(spellSlot: SpellSlot)

    /**
     * Delete all spell slots of the character.
     *
     * @param character
     * The character to delete the spell slots of.
     */
    fun deleteSpellSlots(character: Character)

    /**
     * Delete known spells of a spell list. Use if a spell is deleted from a spell list.
     *
     * @param spelllist
     * The spell list to delete the known spells of.
     * @param spell
     * The spell to delete from the known spells of.
     */
    fun deleteKnownSpells(spelllist: Spelllist, spell: Spell)

    /**
     * Delete the spell slots of a spell list and spell. Use if a spell is deleted from aa spell list.
     *
     * @param spelllist
     * The spell list to delete the spell slots of.
     * @param spell
     * The spll to delete the spell slots of.
     */
    fun deleteSpellSlots(spelllist: Spelllist, spell: Spell)

    /**
     * Update the skill of a character.
     *
     * @param character
     * The character to update the skill of.
     * @param characterSkill
     * The skill to update.
     */
    fun updateCharacterSkill(character: Character, characterSkill: CharacterSkill)

    /**
     * Returns the body of a character with equipped items.
     *
     * @param character
     * The character to get the body of.
     * @param allWeapons
     * All weapons.
     * @param allArmor
     * All armor.
     * @param allGoods
     * All goods.
     *
     * @return The body of the character with equipped items.
     */
    fun getBody(character: Character, allWeapons: List<Weapon>, allArmor: List<Armor>, allGoods: List<Good>): Body

    /**
     * Stores the body of a charater to the persistent layer.
     *
     * @param character
     * The character to persist the body of.
     * @param body
     * The body to persist.
     *
     * @return The persisted body.
     */
    fun createBody(character: Character, body: Body): Body

    /**
     * Delete the body of a character from the persistent layer.
     *
     * @param character
     * The character to delete the body of.
     */
    fun deleteBody(character: Character)

    /**
     * Update the body of a character.
     *
     * @param character
     * The character to update the body of.
     */
    fun updateBody(character: Character)

    companion object {
        /**
         * The format of the date how it is stored in the persistent layer as string
         */
        const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"
    }
}