package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*

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
        return levelTotal / 4 + 2
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
        return 0
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

}
