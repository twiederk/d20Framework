package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.*
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Creates WeaponRowMapper with weapon families.
 *
 * @param allWeaponFamilies
 * All weapon families.
 */
class WeaponRowMapper(private val allWeaponFamilies: List<WeaponFamily>) : BaseRowMapper() {

    /**
     * Maps a weapon from the database to an Weapon object.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, weapon_text.name, cost, weight, number_of_dice, die_id, bonus, critical_hit, critical_mod,
        // weapon_type_id, description
        val weapon = Weapon()
        weapon.id = dataRow.getInt(0)
        weapon.name = dataRow.getString(1)
        weapon.description = dataRow.getString(2)
        weapon.cost = dataRow.getFloat(3)
        weapon.weight = dataRow.getFloat(4)
        weapon.damage = createDamage(dataRow)
        weapon.enhancementBonus = dataRow.getInt(7)
        weapon.critical = createCritical(dataRow)
        weapon.weaponType = WeaponType.values()[dataRow.getInt(10)]
        weapon.qualityType = getQualityType(dataRow.getInt(11))
        weapon.combatType = CombatType.values()[dataRow.getInt(12)]
        weapon.weaponEncumbrance = WeaponEncumbrance.values()[dataRow.getInt(13)]
        weapon.weaponCategory = WeaponCategory.values()[dataRow.getInt(14)]
        weapon.weaponFamily = getWeaponFamily(dataRow.getInt(15))
        weapon.rangeIncrement = dataRow.getInt(16)
        return weapon
    }

    private fun getWeaponFamily(weaponFamilyId: Int): WeaponFamily {
        for (weaponFamily in allWeaponFamilies) {
            if (weaponFamily.id == weaponFamilyId) {
                return weaponFamily
            }
        }
        throw IllegalArgumentException("Can't get weapon family with id: $weaponFamilyId")
    }

    @Throws(SQLException::class)
    private fun createDamage(dataRow: DataRow): Damage {
        val damage = Damage()
        damage.numberOfDice = dataRow.getInt(5)
        damage.die = Die.values()[dataRow.getInt(6)]
        return damage
    }

    @Throws(SQLException::class)
    private fun createCritical(dataRow: DataRow): Critical {
        val critical = Critical()
        critical.hit = dataRow.getInt(8)
        critical.multiplier = dataRow.getInt(9)
        return critical
    }
}