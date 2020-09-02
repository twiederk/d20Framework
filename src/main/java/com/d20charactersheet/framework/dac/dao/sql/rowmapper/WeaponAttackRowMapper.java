package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps data row to new WeaponAttack instance.
 */
public class WeaponAttackRowMapper extends BaseRowMapper {

    private final List<Weapon> allWeapons;

    /**
     * Creates WeaponAttackRowMapper with all weapon.
     *
     * @param allWeapons
     *     All weapons.
     */
    public WeaponAttackRowMapper(final List<Weapon> allWeapons) {
        super();
        this.allWeapons = allWeapons;
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // id, name, description, attack_wield_id, weapon_id, ammunition
        final WeaponAttack weaponAttack = new WeaponAttack();
        weaponAttack.setId(dataRow.getInt(0));
        weaponAttack.setName(dataRow.getString(1));
        weaponAttack.setDescription(dataRow.getString(2));
        weaponAttack.setAttackWield((AttackWield) getEnum(dataRow.getInt(3), AttackWield.values()));
        weaponAttack.setWeapon((Weapon) getItem(dataRow.getInt(4), allWeapons));
        weaponAttack.setAmmunition(dataRow.getInt(5));
        weaponAttack.setAttackBonusModifier(dataRow.getInt(6));
        weaponAttack.setDamageBonusModifier(dataRow.getInt(7));
        return weaponAttack;
    }

}
