package com.d20charactersheet.framework.dac.dao.sql.rowmapper

import com.d20charactersheet.framework.boc.model.AttackWield
import com.d20charactersheet.framework.boc.model.Weapon
import com.d20charactersheet.framework.boc.model.WeaponAttack
import com.d20charactersheet.framework.dac.dao.sql.DataRow
import java.sql.SQLException

/**
 * Creates WeaponAttackRowMapper with all weapon.
 *
 * @param allWeapons
 * All weapons.
 */
class WeaponAttackRowMapper(private val allWeapons: List<Weapon>) : BaseRowMapper() {

    /**
     * Maps data row to new WeaponAttack instance.
     */
    @Throws(SQLException::class)
    override fun mapRow(dataRow: DataRow): Any {
        // id, name, description, attack_wield_id, weapon_id, ammunition
        val weaponAttack = WeaponAttack()
        weaponAttack.id = dataRow.getInt(0)
        weaponAttack.name = dataRow.getString(1)
        weaponAttack.description = dataRow.getString(2)
        weaponAttack.attackWield = AttackWield.values()[dataRow.getInt(3)]
        weaponAttack.weapon = getItem(dataRow.getInt(4), allWeapons) as Weapon
        weaponAttack.ammunition = dataRow.getInt(5)
        weaponAttack.attackBonusModifier = dataRow.getInt(6)
        weaponAttack.damageBonusModifier = dataRow.getInt(7)
        return weaponAttack
    }
}