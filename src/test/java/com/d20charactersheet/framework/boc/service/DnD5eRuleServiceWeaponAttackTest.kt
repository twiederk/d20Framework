package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.DnD5eUniverse
import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DnD5eRuleServiceWeaponAttackTest {

    private lateinit var gameSystem: GameSystem
    private lateinit var ruleService: RuleService
    private lateinit var belvador: Character
    private lateinit var serio: Character

    @BeforeEach
    fun before() {
        gameSystem = DnD5eUniverse().gameSystem
        ruleService = gameSystem.ruleService

        val characterService = gameSystem.characterService
        val allCharacters = gameSystem.allCharacters
        belvador = characterService.findCharacterByName("Belvador the Summoner", allCharacters)
        serio = characterService.findCharacterByName("Serio Custode", allCharacters)
    }

    @Test
    fun calculateWeaponAttack_belvadorQuarterstaff_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Quarterstaff")

        // act
        ruleService.calculateWeaponAttack(belvador, weaponAttack)

        // assert
        assertWeaponAttack(listOf(3), Damage(1, Die.D6), 0, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_belvadorCrossbowLight_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Crossbow, Light")

        // act
        ruleService.calculateWeaponAttack(belvador, weaponAttack)

        // assert
        assertWeaponAttack(listOf(7), Damage(1, Die.D8), 4, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_belvadorMagicDagger_returnWeaponAttack() {
        // arrange
        val weapon = Weapon().apply {
            combatType = CombatType.MELEE_WEAPON
            enhancementBonus = 1
            damage = Damage(1, Die.D8)
            critical = Critical(20, 2)
        }

        val weaponAttack = WeaponAttack().apply {
            this.weapon = weapon
        }

        // act
        ruleService.calculateWeaponAttack(belvador, weaponAttack)

        // assert
        assertWeaponAttack(listOf(4), Damage(1, Die.D8), 1, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_belvadorWithFinesseWeapon_returnWeaponAttack() {
        // arrange
        val rapier = Weapon().apply {
            name = "Rapier"
            combatType = CombatType.MELEE_WEAPON
            damage = Damage(1, Die.D8)
            critical = Critical(20, 2)
        }

        val weaponAttack = WeaponAttack().apply {
            this.weapon = rapier
        }

        // act
        ruleService.calculateWeaponAttack(belvador, weaponAttack)

        // assert
        assertWeaponAttack(listOf(7), Damage(1, Die.D8), 4, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_belvadorQuarterstaffWithAttackBonusModifier_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Longsword")
        weaponAttack.attackBonusModifier = 1

        // act
        ruleService.calculateWeaponAttack(belvador, weaponAttack)

        // assert
        assertWeaponAttack(listOf(4), Damage(1, Die.D8), 0, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_belvadorQuarterstaffWithDamageBonusModifier_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Longsword")
        weaponAttack.damageBonusModifier = 1

        // act
        ruleService.calculateWeaponAttack(belvador, weaponAttack)

        // assert
        assertWeaponAttack(listOf(3), Damage(1, Die.D8), 1, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_serioLongsword_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Longsword")

        // act
        ruleService.calculateWeaponAttack(serio, weaponAttack)

        // assert
        assertWeaponAttack(listOf(5), Damage(1, Die.D8), 3, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_serioLongbow_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Longbow")

        // act
        ruleService.calculateWeaponAttack(serio, weaponAttack)

        // assert
        assertWeaponAttack(listOf(4), Damage(1, Die.D8), 2, Critical(20, 2), weaponAttack)
    }

    @Test
    fun calculateWeaponAttack_serioTwoWeaponFighting_returnWeaponAttack() {
        // arrange
        val weaponAttack = createWeaponAttack("Dagger", AttackWield.OFF_HAND)

        // act
        ruleService.calculateWeaponAttack(serio, weaponAttack)

        // assert
        assertWeaponAttack(listOf(5), Damage(1, Die.D4), 0, Critical(20, 2), weaponAttack)
    }

    private fun createWeaponAttack(weaponName: String, attackWield: AttackWield = AttackWield.ONE_HAND): WeaponAttack {
        val weapon = getWeaponByName(weaponName)
        return WeaponAttack().apply {
            this.weapon = weapon
            this.attackWield = attackWield
        }
    }

    private fun getWeaponByName(name: String): Weapon {
        for (weapon in gameSystem.allWeapons) {
            if (weapon.name == name) {
                return weapon
            }
        }
        throw IllegalArgumentException("Can't find weapon with name: $name")
    }

    private fun assertWeaponAttack(
        attackBonuses: List<Int>, damage: Damage, damageBonus: Int, critical: Critical,
        weaponAttack: WeaponAttack
    ) {
        assertThat(weaponAttack.attackBonuses).`as`("Wrong attack bonus").isEqualTo(attackBonuses.toList())
        assertThat(weaponAttack.damage).`as`("Wrong damage").isEqualTo(damage)
        assertThat(weaponAttack.damageBonus).`as`("Wrong damage bonus").isEqualTo(damageBonus)
        assertThat(weaponAttack.critical).`as`("Wrong critical").isEqualTo(critical)
    }

}