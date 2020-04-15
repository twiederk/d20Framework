package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DisplayServiceTest {

    private lateinit var displayService: DisplayService

    @BeforeEach
    fun setUp() {
        displayService = object : AbstractDisplayService() {
            override fun getDisplayDie(die: Die) = die.toString()
            override fun getDisplayUnitDistanceShort() = "Feet"

            override fun getDisplayAlignment(alignment: Alignment): String? = null
            override fun getDisplaySex(sex: Sex): String? = null
            override fun getErrorMessage(ruleError: RuleError): String? = null
            override fun getDisplayAttribute(attribute: Attribute): String? = null
            override fun getDisplayFeatType(featType: FeatType): String? = null
            override fun getDisplayBaseAttackBonus(baseAttackBonus: BaseAttackBonus): String? = null
            override fun getDisplayWeight(weight: Float): String? = null
            override fun getDisplayCost(cost: Float): String? = null
            override fun getDisplayWeaponType(weaponFamily: WeaponType): String? = null
            override fun getDisplayArmorType(armorType: ArmorType): String? = null
            override fun getDisplayGoodType(goodType: GoodType): String? = null
            override fun getDisplayCritical(critical: Critical): String? = null
            override fun getDisplaySize(size: Size): String? = null
            override fun getDisplayAbilityType(abilityType: AbilityType): String? = null
            override fun getDisplayItem(item: Item): String? = null
            override fun getDisplayQualityType(qualityType: QualityType): String? = null
            override fun getDisplaySpellLevel(level: Int): String? = null
            override fun getDisplaySpellComponents(spell: Spell): String? = null
            override fun getDisplayAttackWield(attackWield: AttackWield): String? = null
            override fun getDisplayCombatType(combatType: CombatType): String? = null
            override fun getDisplayWeaponCategory(weaponCategory: WeaponCategory): String? = null
            override fun getDisplayWeaponEncumbrance(weaponEncumbrance: WeaponEncumbrance): String? = null
            override fun getDisplaySave(save: Save): String? = null
            override fun getDisplayAttributeShort(attribute: Attribute): String? = null
            override fun getDisplaySchool(school: School): String? = null
            override fun getDisplaySubSchool(subSchool: SubSchool): String? = null
            override fun getDisplayCastingTime(castingTime: CastingTime): String? = null
            override fun getDisplayDescriptor(descriptor: Descriptor): String? = null
            override fun getDisplayRange(range: Range): String? = null
            override fun getDisplaySpellResistance(spellResistance: SpellResistance): String? = null
            override fun getDisplayAbilityClass(ability: Ability): String? = null
            override fun getDisplayNumberOfKnownSpells(numberOfKnownSpells: Int, maxNumberOfKnownSpells: Int, numberOfSpells: Int): String? = null
            override fun getDisplaySpellSlotLevel(level: Int): String? = null
            override fun getDisplaySchoolShort(school: School): String? = null
            override fun getDisplayCastingType(castingType: CastingType): String? = null
            override fun getDisplaySpellSource(spellSource: SpellSource): String? = null
        }
    }

    @Test
    fun getDisplayNoteFirstLine_withEmptyString_displayEmptyString() {
        // Arrange
        val note = Note().apply { text = "" }

        // Act
        val result = displayService.getDisplayNoteFirstLine(note)

        // Assert
        assertThat(result).isEqualTo("")
    }

    @Test
    fun getDisplayNoteFirstLine_withOneLine_displayFirstLine() {
        // Arrange
        val note = Note().apply { text = "Eine Zeile" }

        // Act
        val result = displayService.getDisplayNoteFirstLine(note)

        // Assert
        assertThat(result).isEqualTo("Eine Zeile")
    }

    @Test
    fun getDisplayNoteFirstLine_withTwoLines_displayFirstLine() {
        // Arrange
        val note = Note().apply { text = "Erste Zeile\nZweite Zeile" }

        // Act
        val result = displayService.getDisplayNoteFirstLine(note)

        // Assert
        assertThat(result).isEqualTo("Erste Zeile")
    }

    @Test
    fun getDisplayDamage_dieWithPositiveBonus_displayDieWithBonus() {
        // Arrange
        val weapon = createWeapon(Damage(1, Die.D8), 2)

        // Act
        val displayDamage = displayService.getDisplayDamage(weapon)

        // Assert
        assertThat(displayDamage).isEqualTo("1D8+2")
    }

    @Test
    fun getDisplayDamage_dieWithNegativeBonus_displayDieWithBonus() {
        // Arrange
        val weapon = createWeapon(Damage(1, Die.D4), -1)

        // Act
        val displayDamage = displayService.getDisplayDamage(weapon)

        // Assert
        assertThat(displayDamage).isEqualTo("1D4-1")
    }

    @Test
    fun getDisplayDamage_dieWithoutBonus_displayDie() {
        // Arrange
        val weapon = createWeapon(Damage(1, Die.D10), 0)

        // Act
        val displayDamage = displayService.getDisplayDamage(weapon)

        // Assert
        assertThat(displayDamage).isEqualTo("1D10")
    }

    @Test
    fun getDisplayDamage_zeroDieWithBonus_displayBonusOnly() {
        // Arrange
        val weapon = createWeapon(Damage(0, Die.D2), 1)

        // Act
        val displayDamage = displayService.getDisplayDamage(weapon)

        // Assert
        assertThat(displayDamage).isEqualTo("+1")
    }

    @Test
    fun getDisplayDamage_zeroDieWithoutBonus_displayEmptyString() {
        // Arrange
        val weapon = createWeapon(Damage(0, Die.D2), 0)

        // Act
        val displayDamage = displayService.getDisplayDamage(weapon)

        // Assert
        assertThat(displayDamage).isEqualTo("")
    }

    private fun createWeapon(damage: Damage, enhancementBonus: Int) = Weapon().apply {
        this.damage = damage
        this.enhancementBonus = enhancementBonus
    }

    @Test
    fun getDisplayRangeIncrement_rangeOfZero_displayDash() {
        // Act
        val displayRangeIncrement = displayService.getDisplayRangeIncrement(0)

        // Assert
        assertThat(displayRangeIncrement).isEqualTo("-")
    }

    @Test
    fun getDisplayRangeIncrement_rangeOfTen_displayTen() {
        // Act
        val displayRangeIncrement = displayService.getDisplayRangeIncrement(10)

        // Assert
        assertThat(displayRangeIncrement).isEqualTo("10 Feet")
    }

    @Test
    fun getDisplayAmmunition_projectileWeaponZeroAmmunition_displayZero() {
        // Arrange
        val weapon = Weapon().apply { weaponCategory = WeaponCategory.PROJECTILE_WEAPON }
        val weaponAttack = WeaponAttack().apply {
            this.weapon = weapon
            ammunition = 0
        }

        // Act
        val displayAmmunition = displayService.getDisplayAmmunition(weaponAttack)

        // Assert
        assertThat(displayAmmunition).isEqualTo("0")
    }

    @Test
    fun getDisplayAmmunition_projectileWeaponTenAmmunition_displayTen() {
        // Arrange
        val weapon = Weapon().apply { weaponCategory = WeaponCategory.PROJECTILE_WEAPON }
        val weaponAttack = WeaponAttack().apply {
            this.weapon = weapon
            ammunition = 10
        }

        // Act
        val displayAmmunition = displayService.getDisplayAmmunition(weaponAttack)

        // Assert
        assertThat(displayAmmunition).isEqualTo("10")
    }

    @Test
    fun getDisplayAmmunition_normalWeaponZeroAmmunition_displayDash() {
        // Arrange
        val weapon = Weapon().apply { weaponCategory = WeaponCategory.NORMAL_WEAPON }
        val weaponAttack = WeaponAttack().apply {
            this.weapon = weapon
            ammunition = 0
        }

        // Act
        val displayAmmunition = displayService.getDisplayAmmunition(weaponAttack)

        // Assert
        assertThat(displayAmmunition).isEqualTo("-")
    }

    @Test
    fun getDisplayAmmunition_normalWeaponTenAmmunition_displayDash() {
        // Arrange
        val weapon = Weapon().apply { weaponCategory = WeaponCategory.NORMAL_WEAPON }
        val weaponAttack = WeaponAttack().apply {
            this.weapon = weapon
            ammunition = 10
        }

        // Act
        val displayAmmunition = displayService.getDisplayAmmunition(weaponAttack)

        // Assert
        assertThat(displayAmmunition).isEqualTo("-")
    }

}