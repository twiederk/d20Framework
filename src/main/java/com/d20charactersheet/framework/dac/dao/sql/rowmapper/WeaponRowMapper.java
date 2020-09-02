package com.d20charactersheet.framework.dac.dao.sql.rowmapper;

import java.sql.SQLException;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;
import com.d20charactersheet.framework.dac.dao.sql.DataRow;

/**
 * Maps a weapon from the database to an Weapon object.
 */
public class WeaponRowMapper extends BaseRowMapper {

    private final List<WeaponFamily> allWeaponFamilies;

    /**
     * Creates WeaponRowMapper with weapon families.
     *
     * @param allWeaponFamilies
     *     All weapon families.
     */
    public WeaponRowMapper(final List<WeaponFamily> allWeaponFamilies) {
        super();
        this.allWeaponFamilies = allWeaponFamilies;
    }

    @NotNull
    @Override
    public Object mapRow(@NotNull DataRow dataRow) throws SQLException {
        // id, weapon_text.name, cost, weight, number_of_dice, die_id, bonus, critical_hit, critical_mod,
        // weapon_type_id, description
        final Weapon weapon = new Weapon();
        weapon.setId(dataRow.getInt(0));
        weapon.setName(dataRow.getString(1));
        weapon.setDescription(dataRow.getString(2));
        weapon.setCost(dataRow.getFloat(3));
        weapon.setWeight(dataRow.getFloat(4));
        weapon.setDamage(createDamage(dataRow));
        weapon.setEnhancementBonus(dataRow.getInt(7));
        weapon.setCritical(createCritical(dataRow));
        weapon.setWeaponType((WeaponType) getEnum(dataRow.getInt(10), WeaponType.values()));
        weapon.setQualityType(getQualityType(dataRow.getInt(11)));
        weapon.setCombatType((CombatType) getEnum(dataRow.getInt(12), CombatType.values()));
        weapon.setWeaponEncumbrance((WeaponEncumbrance) getEnum(dataRow.getInt(13), WeaponEncumbrance.values()));
        weapon.setWeaponCategory((WeaponCategory) getEnum(dataRow.getInt(14), WeaponCategory.values()));
        weapon.setWeaponFamily(getWeaponFamily(dataRow.getInt(15)));
        weapon.setRangeIncrement(dataRow.getInt(16));
        return weapon;
    }

    private WeaponFamily getWeaponFamily(final int weaponFamilyId) {
        for (final WeaponFamily weaponFamily : allWeaponFamilies) {
            if (weaponFamily.getId() == weaponFamilyId) {
                return weaponFamily;
            }
        }
        throw new IllegalArgumentException("Can't get weapon family with id: " + weaponFamilyId);
    }

    private Damage createDamage(final DataRow dataRow) throws SQLException {
        final Damage damage = new Damage();
        damage.setNumberOfDice(dataRow.getInt(5));
        damage.setDie((Die) getEnum(dataRow.getInt(6), Die.values()));
        return damage;
    }

    private Critical createCritical(final DataRow dataRow) throws SQLException {
        final Critical critical = new Critical();
        critical.setHit(dataRow.getInt(8));
        critical.setMultiplier(dataRow.getInt(9));
        return critical;
    }
}
