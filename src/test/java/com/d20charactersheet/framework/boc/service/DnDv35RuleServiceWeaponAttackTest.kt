package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.util.*

class DnDv35RuleServiceWeaponAttackTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testBelvadorWithQuarterstaff() {
        var weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.TWO_HANDED)
        weaponAttack = ruleService.calculateWeaponAttack(belvador, weaponAttack)
        assertWeaponAttack(intArrayOf(2), Damage(1, Die.D6), 0, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testBelvadorWithCrossbowLight() {
        var weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(belvador, weaponAttack)
        assertWeaponAttack(intArrayOf(6), Damage(1, Die.D8), 0, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testBelvadorWithSilverDagger() {
        var weaponAttack = createWeaponAttack("Silver Dagger", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(belvador, weaponAttack)
        assertWeaponAttack(intArrayOf(3), Damage(1, Die.D4), 0, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testNascanWithWolfaxe() {
        var weaponAttack = createWeaponAttack("Battleaxe", AttackWield.ONE_HAND)
        weaponAttack.weapon.enhancementBonus = 2
        weaponAttack.weapon.qualityType = QualityType.MAGIC
        weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack)
        assertWeaponAttack(intArrayOf(9, 4), Damage(1, Die.D8), 3, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testNascanWithWolfaxeAndModifier() {
        var weaponAttack = createWeaponAttack("Battleaxe", AttackWield.ONE_HAND)
        weaponAttack.weapon.enhancementBonus = 2
        weaponAttack.weapon.qualityType = QualityType.MAGIC
        weaponAttack.attackBonusModifier = 2
        weaponAttack.damageBonusModifier = -2
        weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack)
        assertWeaponAttack(intArrayOf(11, 6), Damage(1, Die.D8), 1, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testNascanWithHandaxePrimaryHand() {
        var weaponAttack = createWeaponAttack("Handaxe", AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack)
        assertWeaponAttack(intArrayOf(7, 2), Damage(1, Die.D6), 1, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testNascanWithHandaxeOneHand() {
        var weaponAttack = createWeaponAttack("Handaxe", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack)
        assertWeaponAttack(intArrayOf(9, 4), Damage(1, Die.D6), 1, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testNascanWithHandaxeOffHand() {
        var weaponAttack = createWeaponAttack("Handaxe", AttackWield.OFF_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack)
        assertWeaponAttack(intArrayOf(7), Damage(1, Die.D6), 0, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testNyatarWithShortSword() {
        var weaponAttack = createWeaponAttack("Sword, short", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(nyatar, weaponAttack)
        assertWeaponAttack(intArrayOf(4), Damage(1, Die.D6), 1, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testNyatarWithCrossbowLight() {
        var weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(nyatar, weaponAttack)
        assertWeaponAttack(intArrayOf(7), Damage(1, Die.D8), 0, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testJadziaWithQuarterstaffPlusOneTwoHanded() {
        var weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.TWO_HANDED)
        weaponAttack.weapon.enhancementBonus = 1
        weaponAttack.weapon.qualityType = QualityType.MAGIC
        weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack)
        assertWeaponAttack(intArrayOf(4), Damage(1, Die.D6), 2, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testJadziaWithQuarterstaffPlusOnePrimaryHand() {
        var weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND)
        weaponAttack.weapon.enhancementBonus = 1
        weaponAttack.weapon.qualityType = QualityType.MAGIC
        weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack)
        assertWeaponAttack(intArrayOf(2), Damage(1, Die.D6), 2, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testJadziaWithQuarterstaffPlusOneOffHand() {
        var weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.OFF_HAND)
        weaponAttack.weapon.enhancementBonus = 1
        weaponAttack.weapon.qualityType = QualityType.MAGIC
        weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack)
        assertWeaponAttack(intArrayOf(2), Damage(1, Die.D6), 1, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testJadziaWithSling() {
        var weaponAttack = createWeaponAttack("Sling", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack)
        assertWeaponAttack(intArrayOf(+4), Damage(1, Die.D4), 1, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testWorfWithGreataxe() {
        var weaponAttack = createWeaponAttack("Greataxe", AttackWield.TWO_HANDED)
        weaponAttack.weapon.qualityType = QualityType.MASTERWORK
        weaponAttack = ruleService.calculateWeaponAttack(worf, weaponAttack)
        assertWeaponAttack(intArrayOf(+11), Damage(1, Die.D12), 7, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testRodrekrWithDwarvenWaraxe() {
        var weaponAttack = createWeaponAttack("Waraxe, dwarven", AttackWield.ONE_HAND)
        weaponAttack.weapon.qualityType = QualityType.MASTERWORK
        weaponAttack = ruleService.calculateWeaponAttack(rodrekr, weaponAttack)
        assertWeaponAttack(intArrayOf(+11), Damage(1, Die.D10), 6, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testRodrekrWithCrossbowLight() {
        var weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(rodrekr, weaponAttack)
        assertWeaponAttack(intArrayOf(+7), Damage(1, Die.D8), 0, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testThoreWithDagger() {
        var weaponAttack = createWeaponAttack("Dagger", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack)
        assertWeaponAttack(intArrayOf(+8), Damage(1, Die.D4), 1, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testThoreWithShortSwordMasterworkPrimaryHand() {
        var weaponAttack = createWeaponAttack("Sword, short", AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND)
        weaponAttack.weapon.qualityType = QualityType.MASTERWORK
        weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack)
        assertWeaponAttack(intArrayOf(+8), Damage(1, Die.D6), 1, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testThoreWithShortSwordOffHand() {
        var weaponAttack = createWeaponAttack("Sword, short", AttackWield.OFF_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack)
        assertWeaponAttack(intArrayOf(+7), Damage(1, Die.D6), 0, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testThoreWithRapierOfPuncturing() {
        var weaponAttack = createWeaponAttack("Rapier of Puncturing", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack)
        assertWeaponAttack(intArrayOf(+10), Damage(1, Die.D6), 3, Critical(18, 2), weaponAttack)
    }

    @Test
    fun testThoreWithCompositeLongbow() {
        var weaponAttack = createWeaponAttack("Longbow, composite", AttackWield.TWO_HANDED)
        weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack)
        assertWeaponAttack(intArrayOf(+8), Damage(1, Die.D8), 1, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testKyraWithScimitar() {
        var weaponAttack = createWeaponAttack("Scimitar", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(kyra, weaponAttack)
        assertWeaponAttack(intArrayOf(+1), Damage(1, Die.D6), 1, Critical(18, 2), weaponAttack)
    }

    @Test
    fun testKyraWithSling() {
        var weaponAttack = createWeaponAttack("Sling", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(kyra, weaponAttack)
        assertWeaponAttack(intArrayOf(-1), Damage(1, Die.D4), 1, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testMerisielWithRapier() {
        var weaponAttack = createWeaponAttack("Rapier", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(merisiel, weaponAttack)
        assertWeaponAttack(intArrayOf(+3), Damage(1, Die.D6), 1, Critical(18, 2), weaponAttack)
    }

    @Test
    fun testEzrenWithQuaterstaff() {
        var weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.TWO_HANDED)
        weaponAttack = ruleService.calculateWeaponAttack(ezren, weaponAttack)
        assertWeaponAttack(intArrayOf(+1), Damage(1, Die.D6), 1, Critical(20, 2), weaponAttack)
    }

    @Test
    fun testEzrenWithCrossbowLight() {
        var weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND)
        weaponAttack = ruleService.calculateWeaponAttack(ezren, weaponAttack)
        assertWeaponAttack(intArrayOf(+0), Damage(1, Die.D8), 0, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testValerosWithLongsword() {
        var weaponAttack = createWeaponAttack("Longsword", AttackWield.TWO_HANDED)
        weaponAttack = ruleService.calculateWeaponAttack(valeros, weaponAttack)
        assertWeaponAttack(intArrayOf(+5), Damage(1, Die.D8), 4, Critical(19, 2), weaponAttack)
    }

    @Test
    fun testValerosWithShortBow() {
        var weaponAttack = createWeaponAttack("Shortbow", AttackWield.TWO_HANDED)
        weaponAttack = ruleService.calculateWeaponAttack(valeros, weaponAttack)
        assertWeaponAttack(intArrayOf(+3), Damage(1, Die.D6), 0, Critical(20, 3), weaponAttack)
    }

    @Test
    fun testValerosWithLongswordAndModifier() {
        var weaponAttack = createWeaponAttack("Longsword", AttackWield.TWO_HANDED)
        weaponAttack.attackBonusModifier = 1
        weaponAttack.damageBonusModifier = 1
        weaponAttack = ruleService.calculateWeaponAttack(valeros, weaponAttack)
        assertWeaponAttack(intArrayOf(+6), Damage(1, Die.D8), 5, Critical(19, 2), weaponAttack)
    }

    private fun createWeaponAttack(weaponName: String, attackWield: AttackWield): WeaponAttack {
        val quarterstaff = getWeaponByName(weaponName)
        val weaponAttack = WeaponAttack()
        weaponAttack.weapon = quarterstaff
        weaponAttack.attackWield = attackWield
        return weaponAttack
    }

    private fun assertWeaponAttack(
        attackBonuses: IntArray, damage: Damage, damageBonus: Int, critical: Critical,
        weaponAttack: WeaponAttack
    ) {
        Assert.assertNotNull("AttackBonuses can't be null", weaponAttack.attackBonuses)
        Assert.assertEquals("Wrong number of attacks", attackBonuses.size.toLong(), weaponAttack.numberOfAttacks.toLong())
        for (i in attackBonuses.indices) {
            Assert.assertEquals("$i. attack bonus is wrong", attackBonuses[i], weaponAttack.attackBonuses[i])
        }
        Assert.assertNotNull("Damage can't be null", weaponAttack.damage)
        Assert.assertEquals(damage, weaponAttack.damage)
        Assert.assertEquals("Wrong damage bonus", damageBonus.toLong(), weaponAttack.damageBonus.toLong())
        Assert.assertNotNull("Critical can't be null", weaponAttack.critical)
        Assert.assertEquals(critical, weaponAttack.critical)
    }

    private fun getWeaponByName(name: String): Weapon {
        for (weapon in gameSystem.allWeapons) {
            if (weapon.name == name) {
                return weapon
            }
        }
        throw IllegalArgumentException("Can't find weapon with name: $name")
    }

    @Test
    fun testGetAttackBonusesMelee() {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val daggerWeaponAttack = createWeaponAttack("Dagger", AttackWield.ONE_HAND)
        var character = createCharacter(fighter, 2)
        character.strength = 12
        assertAttackBonuses(intArrayOf(3), dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack))
        character = createCharacter(fighter, 5)
        character.strength = 12
        assertAttackBonuses(intArrayOf(6), dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack))
        character = createCharacter(fighter, 6)
        character.strength = 12
        assertAttackBonuses(intArrayOf(7, 2), dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack))
        character = createCharacter(fighter, 10)
        character.strength = 12
        assertAttackBonuses(intArrayOf(11, 6), dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack))
        character = createCharacter(fighter, 11)
        character.strength = 12
        assertAttackBonuses(intArrayOf(12, 7, 2), dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack))

        // magical weapon with enhancement bonus
        val daggerOfVenomWeaponAttack = createWeaponAttack("Dagger of Venom", AttackWield.ONE_HAND)
        character = createCharacter(fighter, 2)
        character.strength = 12
        assertAttackBonuses(intArrayOf(4), dndv35RuleService.getAttackBonuses(character, daggerOfVenomWeaponAttack))
        character = createCharacter(fighter, 11)
        character.strength = 12
        assertAttackBonuses(intArrayOf(13, 8, 3), dndv35RuleService.getAttackBonuses(character, daggerOfVenomWeaponAttack))

        // two-weapon fighting with primary hand
        val longswordWeaponAttack = createWeaponAttack("Longsword", AttackWield.PRIMARY_HAND)
        character = createCharacter(fighter, 2)
        character.strength = 12
        assertAttackBonuses(intArrayOf(-3), dndv35RuleService.getAttackBonuses(character, longswordWeaponAttack))

        // Feats
        // weapon finesse
        character = createCharacter(fighter, 2)
        character.dexterity = 12
        character.characterFeats = createCharacterFeat("Weapon Finesse")
        assertAttackBonuses(intArrayOf(3), dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack))

        // weapon focus
        val greatswordWeaponAttack = createWeaponAttack("Greatsword", AttackWield.TWO_HANDED)
        character = createCharacter(fighter, 2)
        character.strength = 12
        character.characterFeats = createCharacterFeat("Weapon Focus", "Greatsword")
        assertAttackBonuses(intArrayOf(4), dndv35RuleService.getAttackBonuses(character, greatswordWeaponAttack))

        // greater weapon focus
        character = createCharacter(fighter, 2)
        character.strength = 12
        val characterFeats = createCharacterFeat("Weapon Focus", "Greatsword")
        characterFeats.addAll(createCharacterFeat("Greater Weapon Focus", "Greatsword"))
        character.characterFeats = characterFeats
        assertAttackBonuses(intArrayOf(5), dndv35RuleService.getAttackBonuses(character, greatswordWeaponAttack))

        // masterwork
        character = createCharacter(fighter, 2)
        character.strength = 12
        val coldIronLongsword = createWeaponAttack("Cold Iron Longsword", AttackWield.ONE_HAND)
        assertAttackBonuses(intArrayOf(4), dndv35RuleService.getAttackBonuses(character, coldIronLongsword))
    }

    @Test
    fun testGetAttackBonusesOffHand() {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val shortSwordWeaponAttack = createWeaponAttack("Sword, short", AttackWield.OFF_HAND)
        val battleaxeWeaponAttack = createWeaponAttack("Battleaxe", AttackWield.OFF_HAND)

        // light weapon in off hand
        var character = createCharacter(fighter, 2)
        character.strength = 12
        assertAttackBonuses(intArrayOf(-5), dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack))

        // light weapon in off hand
        character = createCharacter(fighter, 6)
        character.strength = 12
        assertAttackBonuses(intArrayOf(-1), dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack))

        // one-handed weapon in off hand
        character = createCharacter(fighter, 2)
        character.strength = 12
        assertAttackBonuses(intArrayOf(-7), dndv35RuleService.getAttackBonuses(character, battleaxeWeaponAttack))

        // light weapon in off hand and feat Improved Two-Weapon Fighting
        character = createCharacter(fighter, 2)
        character.strength = 12
        var characterFeats = createCharacterFeat("Two-Weapon Fighting")
        characterFeats.addAll(createCharacterFeat("Improved Two-Weapon Fighting"))
        character.characterFeats = characterFeats
        assertAttackBonuses(intArrayOf(1, -4), dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack))

        // light weapon in off hand and feat Greater Two-Weapon Fighting
        character = createCharacter(fighter, 2)
        character.strength = 12
        characterFeats = createCharacterFeat("Two-Weapon Fighting")
        characterFeats.addAll(createCharacterFeat("Improved Two-Weapon Fighting"))
        characterFeats.addAll(createCharacterFeat("Greater Two-Weapon Fighting"))
        character.characterFeats = characterFeats
        assertAttackBonuses(intArrayOf(1, -4, -9), dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack))

        // light weapon in off hand and feat Greater Two-Weapon Fighting
        character = createCharacter(fighter, 11)
        character.strength = 12
        characterFeats = createCharacterFeat("Two-Weapon Fighting")
        characterFeats.addAll(createCharacterFeat("Improved Two-Weapon Fighting"))
        characterFeats.addAll(createCharacterFeat("Greater Two-Weapon Fighting"))
        character.characterFeats = characterFeats
        assertAttackBonuses(intArrayOf(10, 5, 0), dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack))
    }

    private fun createCharacterFeat(featname: String): MutableList<CharacterFeat> {
        val feat = Feat()
        feat.name = featname
        val characterFeats: MutableList<CharacterFeat> = ArrayList()
        characterFeats.add(CharacterFeat(feat))
        return characterFeats
    }

    private fun createCharacterFeat(featname: String, category: String): MutableList<CharacterFeat> {
        val characterFeats = createCharacterFeat(featname)
        characterFeats[0].category = category
        return characterFeats
    }

    @Test
    fun testGetAttackBonusesRanged() {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val oneHandWeaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND)
        var character = createCharacter(fighter, 2)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(3), dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack))
        character = createCharacter(fighter, 5)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(6), dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack))
        character = createCharacter(fighter, 6)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(7, 2), dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack))
        character = createCharacter(fighter, 10)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(11, 6), dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack))
        character = createCharacter(fighter, 11)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(12, 7, 2), dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack))

        // two-weapon fighting primary hand
        val primaryHandWeaponAttack = createWeaponAttack("Crossbow, light", AttackWield.PRIMARY_HAND)
        character = createCharacter(fighter, 2)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(-3), dndv35RuleService.getAttackBonuses(character, primaryHandWeaponAttack))

        // two-weapon fighting primary hand
        val offHandWeaponAttack = createWeaponAttack("Crossbow, light", AttackWield.OFF_HAND)
        character = createCharacter(fighter, 2)
        character.dexterity = 12
        assertAttackBonuses(intArrayOf(-7), dndv35RuleService.getAttackBonuses(character, offHandWeaponAttack))
    }

    private fun assertAttackBonuses(expected: IntArray, attackBonuses: List<Int>) {
        assertThat(attackBonuses).hasSize(expected.size)
        for (i in expected.indices) {
            val attackBonus = attackBonuses[i]
            assertThat(attackBonus).isEqualTo(expected[i])
        }
    }

    @Test
    fun testGetDamageBonus() {
        val emptyFeats: List<CharacterFeat> = ArrayList()
        assertDamageBonus(0, "Dagger", 0, emptyFeats)
        assertDamageBonus(1, "Dagger", 1, emptyFeats)
        assertDamageBonus(2, "Dagger of Venom", 1, emptyFeats)
        assertDamageBonus(3, "Assassin Dagger", 1, emptyFeats)
        assertDamageBonus(1, "Sling", 1, emptyFeats)
    }

    private fun assertDamageBonus(
        expected: Int, weaponName: String, strenghModifier: Int,
        characterFeats: List<CharacterFeat>
    ) {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val weaponAttack = createWeaponAttack(weaponName, AttackWield.ONE_HAND)
        val damageBonus = dndv35RuleService.getDamageBonus(weaponAttack, strenghModifier, characterFeats)
        Assert.assertEquals(expected.toLong(), damageBonus.toLong())
    }

    @Test
    fun testGetMeleeWeaponStrengthBonus() {

        // Off-Hand Light Weapon with strength bonus
        assertMeleeWeaponStrengthBonus(1, "Sword, short", AttackWield.OFF_HAND, 2)

        // Off-Hand Light Weapon with strength malus
        assertMeleeWeaponStrengthBonus(-2, "Sword, short", AttackWield.OFF_HAND, -2)

        // Primary-Hand
        assertMeleeWeaponStrengthBonus(1, "Longsword", AttackWield.PRIMARY_HAND, 1)

        // One-Hand
        assertMeleeWeaponStrengthBonus(1, "Longsword", AttackWield.ONE_HAND, 1)

        // Two-Handed with strength bonus
        assertMeleeWeaponStrengthBonus(1, "Greataxe", AttackWield.TWO_HANDED, 1)
        assertMeleeWeaponStrengthBonus(3, "Greataxe", AttackWield.TWO_HANDED, 2)

        // Two-Handed with strength malus
        assertMeleeWeaponStrengthBonus(-2, "Greataxe", AttackWield.TWO_HANDED, -2)

        // Two-Handed Light Weapon
        assertMeleeWeaponStrengthBonus(2, "Sword, short", AttackWield.TWO_HANDED, 2)
    }

    private fun assertMeleeWeaponStrengthBonus(
        expected: Int, weaponName: String, attackWield: AttackWield,
        strenthBonus: Int
    ) {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val weapon = getWeaponByName(weaponName)
        val bonus = dndv35RuleService.getMeleeWeaponStrengthBonus(weapon, attackWield, strenthBonus)
        Assert.assertEquals(expected.toLong(), bonus.toLong())
    }

    @Test
    fun testGetRangedWeaponStrengthBonus() {
        // Projectile Weapon
        assertRangedWeaponStrengthBonus(0, "Crossbow, light", 1)

        // Sling recieves strength bonus
        assertRangedWeaponStrengthBonus(1, "Sling", 1)

        // Bow gets strengh malus only
        assertRangedWeaponStrengthBonus(-1, "Longbow", -1)
        assertRangedWeaponStrengthBonus(0, "Longbow", 0)
        assertRangedWeaponStrengthBonus(0, "Longbow", 1)

        // Composite Bow gets strength bonus
        assertRangedWeaponStrengthBonus(1, "Longbow, composite", 1)

        // Thrown Weapon
        assertRangedWeaponStrengthBonus(1, "Javelin", 1)
    }

    private fun assertRangedWeaponStrengthBonus(expected: Int, weaponName: String, strenthBonus: Int) {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val weapon = getWeaponByName(weaponName)
        val bonus = dndv35RuleService.getRangedWeaponStrengthBonus(weapon, strenthBonus)
        Assert.assertEquals(expected.toLong(), bonus.toLong())
    }

    @Test
    fun testGetFeatDamageBonus() {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val dagger = getWeaponByName("Dagger")
        val emptyFeats: List<CharacterFeat> = ArrayList()
        var damageBonus = dndv35RuleService.getFeatDamageBonus(emptyFeats, dagger)
        Assert.assertEquals(0, damageBonus.toLong())
        val weaponSpecialization: List<CharacterFeat> = createCharacterFeat("Weapon Specialization", "Dagger")
        damageBonus = dndv35RuleService.getFeatDamageBonus(weaponSpecialization, dagger)
        Assert.assertEquals(2, damageBonus.toLong())
        val daggerOfVenom = getWeaponByName("Dagger of Venom")
        damageBonus = dndv35RuleService.getFeatDamageBonus(weaponSpecialization, daggerOfVenom)
        Assert.assertEquals(2, damageBonus.toLong())
        val characterFeats = createCharacterFeat("Weapon Specialization", "Dagger")
        characterFeats.addAll(createCharacterFeat("Greater Weapon Specialization", "Dagger"))
        damageBonus = dndv35RuleService.getFeatDamageBonus(characterFeats, dagger)
        Assert.assertEquals(4, damageBonus.toLong())
    }

    @Test
    fun testGetTwoWeaponsFightingModifier() {
        val emptyList: List<CharacterFeat> = ArrayList()
        val twoWeaponFighting = createTwoWeaponFightingFeats()
        val lightWeapon = getWeaponByName("Dagger")
        val oneHandedWeapon = getWeaponByName("Longsword")
        val twoHandedWeapon = getWeaponByName("Greataxe")
        assertTwoWeaponsFightingModifier(0, AttackWield.ONE_HAND, oneHandedWeapon, emptyList)
        assertTwoWeaponsFightingModifier(0, AttackWield.TWO_HANDED, twoHandedWeapon, emptyList)

        // off-hand
        assertTwoWeaponsFightingModifier(-10, AttackWield.OFF_HAND, oneHandedWeapon, emptyList)
        assertTwoWeaponsFightingModifier(-8, AttackWield.OFF_HAND, lightWeapon, emptyList)
        assertTwoWeaponsFightingModifier(-4, AttackWield.OFF_HAND, oneHandedWeapon, twoWeaponFighting)
        assertTwoWeaponsFightingModifier(-2, AttackWield.OFF_HAND, lightWeapon, twoWeaponFighting)

        // primary-hand
        assertTwoWeaponsFightingModifier(-6, AttackWield.PRIMARY_HAND, oneHandedWeapon, emptyList)
        assertTwoWeaponsFightingModifier(-4, AttackWield.PRIMARY_HAND, oneHandedWeapon, twoWeaponFighting)
        assertTwoWeaponsFightingModifier(-4, AttackWield.PRIMARY_HAND, lightWeapon, emptyList)
        assertTwoWeaponsFightingModifier(-4, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, oneHandedWeapon, emptyList)
        assertTwoWeaponsFightingModifier(-2, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, oneHandedWeapon, twoWeaponFighting)
    }

    private fun createTwoWeaponFightingFeats(): List<CharacterFeat> {
        val twoWeaponFighting = Feat()
        twoWeaponFighting.name = "Two-Weapon Fighting"
        val characterFeat = CharacterFeat(twoWeaponFighting)
        val characterFeats: MutableList<CharacterFeat> = ArrayList(1)
        characterFeats.add(characterFeat)
        return characterFeats
    }

    private fun assertTwoWeaponsFightingModifier(
        expected: Int, attackWield: AttackWield, weapon: Weapon,
        characterFeats: List<CharacterFeat>
    ) {
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val bonus = dndv35RuleService.getTwoWeaponFighting(attackWield, weapon, characterFeats)
        Assert.assertEquals(expected.toLong(), bonus.toLong())
    }

    @Test
    fun testGetAttackWields() {
        // Double Weapon
        assertAttackWields(
            "Quarterstaff",
            EnumSet.of(AttackWield.OFF_HAND, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, AttackWield.TWO_HANDED)
        )

        // Light Melee Weapon
        assertAttackWields("Dagger", EnumSet.allOf(AttackWield::class.java))
        assertAttackWields("Handaxe", EnumSet.allOf(AttackWield::class.java))
        assertAttackWields("Sword, short", EnumSet.allOf(AttackWield::class.java))

        // One-Handed Melee Weapon
        assertAttackWields("Battleaxe", EnumSet.allOf(AttackWield::class.java))
        assertAttackWields("Waraxe, dwarven", EnumSet.allOf(AttackWield::class.java))
        assertAttackWields("Rapier", EnumSet.allOf(AttackWield::class.java))
        assertAttackWields("Scimitar", EnumSet.allOf(AttackWield::class.java))
        assertAttackWields("Longsword", EnumSet.allOf(AttackWield::class.java))

        // Two-Handed Melee Weapon
        assertAttackWields("Greataxe", EnumSet.of(AttackWield.TWO_HANDED))

        // One-Handed Ranged Weapon
        assertAttackWields("Crossbow, light", EnumSet.of(AttackWield.ONE_HAND, AttackWield.TWO_HANDED))
        assertAttackWields("Sling", EnumSet.of(AttackWield.ONE_HAND, AttackWield.TWO_HANDED))

        // Two-Handed Range Weapon
        assertAttackWields("Shortbow", EnumSet.of(AttackWield.TWO_HANDED))
        assertAttackWields("Longbow, composite", EnumSet.of(AttackWield.TWO_HANDED))
    }

    private fun assertAttackWields(name: String, expected: EnumSet<AttackWield>) {
        val quarterstaff = getWeaponByName(name)
        val attackWields = ruleService.getAttackWields(quarterstaff)
        Assert.assertNotNull(attackWields)
        Assert.assertEquals(expected.size.toLong(), attackWields.size.toLong())
        for (attackWield in expected) {
            Assert.assertTrue("Missing $attackWield for $name", attackWields.contains(attackWield))
        }
    }

    @Test
    fun testGetWeaponFocus() {
        val characterFeats = valeros.characterFeats
        val weapon = getWeaponByName("Cold Iron Longsword")
        val dndv35RuleService = ruleService as DnDv35RuleServiceImpl
        val weaponFocus = dndv35RuleService.getWeaponFocus(characterFeats, weapon)
        Assert.assertEquals(1, weaponFocus.toLong())
    }
}