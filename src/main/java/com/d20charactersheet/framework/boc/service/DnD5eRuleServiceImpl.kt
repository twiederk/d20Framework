package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import kotlin.math.max

class DnD5eRuleServiceImpl : AbstractRuleServiceImpl() {

    private companion object {
        private val fitnesseWeaponNames = listOf("Dagger", "Dart", "Rapier", "Scimitar", "Shortsword", "Whip")
    }

    override fun calculateWeaponAttack(character: Character, weaponAttack: WeaponAttack): WeaponAttack {
        val proficiencyBonus = calculateProficiencyBonus(character)
        val attributeBonus = calculateAttributeModifier(character, weaponAttack.weapon)
        val enhancementBonus = weaponAttack.weapon.enhancementBonus
        weaponAttack.attackBonuses = listOf(proficiencyBonus + attributeBonus + enhancementBonus + weaponAttack.attackBonusModifier)
        weaponAttack.damageBonus = calculateDamageBonus(attributeBonus, enhancementBonus, weaponAttack)
        return weaponAttack
    }

    private fun calculateDamageBonus(
        attributeBonus: Int,
        enhancementBonus: Int,
        weaponAttack: WeaponAttack
    ): Int {
        if (weaponAttack.attackWield == AttackWield.OFF_HAND) {
            return enhancementBonus + weaponAttack.damageBonusModifier
        }
        return attributeBonus + enhancementBonus + weaponAttack.damageBonusModifier
    }

    override fun calculateProficiencyBonus(character: Character): Int {
        val levelTotal = character.classLevels.sumOf { classLevel -> classLevel.level }
        return (levelTotal - 1) / 4 + 2
    }

    override fun calculateAttributeModifier(character: Character, weapon: Weapon): Int {
        if (isFinesse(weapon)) {
            return maxOf(getAttributeModifier(character, Attribute.STRENGTH), getAttributeModifier(character, Attribute.DEXTERITY))
        }
        return when (weapon.combatType) {
            CombatType.MELEE_WEAPON -> getAttributeModifier(character, Attribute.STRENGTH)
            CombatType.RANGED_WEAPON -> getAttributeModifier(character, Attribute.DEXTERITY)
            else -> 0
        }
    }

    private fun isFinesse(weapon: Weapon): Boolean {
        return fitnesseWeaponNames.contains(weapon.name)
    }

    override fun getNumberOfFeats(character: Character): Int = character.classLevels.sumOf { it.level / 4 }

    override fun rollCritical(damage: Damage, bonus: Int, critical: Critical): DieRoll {
        val dieRoll = DieRoll()
        dieRoll.die = damage.die
        dieRoll.bonus = bonus
        val numberOfDice = damage.numberOfDice * critical.multiplier
        dieRoll.rolls = IntArray(numberOfDice)
        for (i in 0 until numberOfDice) {
            dieRoll.rolls[i] = damage.die.roll()
        }
        return dieRoll
    }

    /**
     * @see com.d20charactersheet.framework.boc.service.RuleService.getSaveAttributeModifier
     */
    override fun getSaveAttributeModifier(character: Character, save: Save): Int {
        return when (save) {
            Save.STRENGTH -> getModifier(character.strength)
            Save.DEXTERITY -> getModifier(character.dexterity)
            Save.CONSTITUTION -> getModifier(character.constitution)
            Save.INTELLIGENCE -> getModifier(character.intelligence)
            Save.WISDOM -> getModifier(character.wisdom)
            Save.CHARISMA -> getModifier(character.charisma)
        }
    }

    override fun getSave(character: Character, save: Save): Int {
        val proficiencyBonus = getProficiencySave(character, save)
        val attributeModifier = getSaveAttributeModifier(character, save)
        val modifier = getSaveModifier(character, save)
        return proficiencyBonus + attributeModifier + modifier
    }

    override fun getProficiencySave(character: Character, save: Save): Int {
        val classWithHighestLevel = character.classLevels.maxByOrNull { it.level } ?: character.classLevels[0]
        if (classWithHighestLevel.characterClass.saves.contains(save)) {
            return calculateProficiencyBonus(character)
        }
        return 0
    }

    override fun getMaxClassSkillRank(character: Character): Int {
        return 0
    }

    override fun getMaxCrossClassSkillRank(character: Character): Float {
        return 0.0f
    }

    override fun getSkillPoints(character: Character, startClass: CharacterClass): Int {
        return 0
    }

    override fun getSkillModifier(character: Character, characterSkill: CharacterSkill): Int {
        val attributeModifier = getAttributeModifier(character, characterSkill.skill.attribute)
        val miscModifier = characterSkill.modifier
        val proficiencyBonus = if (characterSkill.rank > 0) calculateProficiencyBonus(character) else 0
        return attributeModifier + miscModifier + proficiencyBonus
    }

    override fun getSpentSkillPoints(character: Character): Int {
        return 0
    }

    override fun getSpecialSizeModifier(size: Size): Int {
        return 0
    }

    override fun getRankPerSkillPoint(character: Character, skill: Skill): Float {
        return 0.0f
    }

    override fun getNumberOfClassFeats(character: Character): Int {
        return 0
    }

    override fun getMaxSpelllevel(character: Character, spelllistAbility: SpelllistAbility): Int {
        return spelllistAbility.spelllist.maxLevel
    }

    override fun getNumberOfKnownSpells(character: Character, spelllistAbility: SpelllistAbility, spellLevel: Int): Int {
        val knownSpellsTable = spelllistAbility.knownSpellsTable
        val spellcasterLevel = getSpellcasterLevel(character, spelllistAbility)
        val numberOfKnownSpells = knownSpellsTable.getKnownSpells(spellcasterLevel, spellLevel)
        if (isNoAccess(numberOfKnownSpells)) {
            return 0
        }
        if (isCantrip(spellLevel)) {
            return numberOfKnownSpells
        }
        if (spelllistAbility.castingType == CastingType.SPONTANEOUS) {
            return numberOfKnownSpells
        }
        return numberOfKnownSpells + max(getAttributeModifier(character, spelllistAbility.spellAttribute), 1)
    }

    private fun isCantrip(spellLevel: Int) = spellLevel == 0

    private fun isNoAccess(numberOfKnownSpells: Int) = numberOfKnownSpells == KnownSpellsTable.NO_ACCESS

    override fun calculateSpellSlots(character: Character): List<SpellSlot> {
        val spellSlots: List<SpellSlot> = ArrayList()
        for (spelllistAbility in character.spelllistAbilities) {
            calculateSpellSlots(character, spelllistAbility, spellSlots)
        }

        fillSpellSlots(character, spellSlots)

        return spellSlots
    }

    private fun calculateSpellSlots(character: Character, spelllistAbility: SpelllistAbility, spellSlots: List<SpellSlot>) {
        val spellCasterLevel = getSpellcasterLevel(character, spelllistAbility)

        // get slots of spells per day table
        createSpellsPerDaySlots(spelllistAbility, spellCasterLevel, spellSlots)
    }

    override fun getSpellSaveDifficultyClass(character: Character, spellSlot: SpellSlot): Int {
        val proficiencyBonus = calculateProficiencyBonus(character)
        val attributeBonus = calculateSpellSaveDiffucultyClassAttributeBonus(character, spellSlot.spelllistAbilities)
        return 8 + proficiencyBonus + attributeBonus
    }

    private fun calculateSpellSaveDiffucultyClassAttributeBonus(
        character: Character,
        spelllistAbilities: List<SpelllistAbility>?
    ): Int {
        if (spelllistAbilities != null && spelllistAbilities.isNotEmpty()) {
            return getAttributeModifier(character, spelllistAbilities[0].spellAttribute)
        }
        return 0
    }

    override fun getSpellSelection(character: Character, spellSlot: SpellSlot): List<Spell> {
        val spellSelection = mutableListOf<Spell>()
        val spelllists = spellSlot.spelllists
        for (spelllist in spelllists) {
            val knownSpells = character.getKnownSpells(spelllist)
            val spellSlotLevel = spellSlot.level
            if (spellSlotLevel == 0) {
                val spellsOfLevel = getSpellsOfLevel(spelllist.getSpellsOfLevel(spellSlotLevel), knownSpells)
                spellSelection.addAll(spellsOfLevel)
            }
            if (spellSlotLevel > 0) {
                for (spellLevel in (1..spellSlotLevel)) {
                    val spellsOfLevel = getSpellsOfLevel(spelllist.getSpellsOfLevel(spellLevel), knownSpells)
                    spellSelection.addAll(spellsOfLevel)
                }
            }
        }
        return spellSelection
    }

    override fun rest(character: Character): MutableList<SpellSlot> {
        val spellSlots = mutableListOf<SpellSlot>()
        for (spellSlot in character.spellSlots) {
            if (spellSlot.level == 0) {
                spellSlot.isCast = false
            } else {
                spellSlot.spell = SpellSlot.EMPTY_SPELL
            }
            spellSlots.add(spellSlot)
        }
        return spellSlots
    }

    override fun isTrained(characterSkill: CharacterSkill): Boolean {
        return characterSkill.rank == 1.0F
    }


}
