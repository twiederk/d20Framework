package com.d20charactersheet.framework.dac.dao.sql

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.Good
import com.d20charactersheet.framework.boc.model.Weapon
import com.d20charactersheet.framework.boc.model.WeaponFamily
import com.d20charactersheet.framework.dac.dao.ItemDao

/**
 * Provides access to SQLite database on Android device storing items.
 * Creates DAO to access SQLite database on Android device with given helper.
 *
 * @param db
 * The database to access.
 */
class SqlItemDao(db: Database) : ItemDao {

    private val helper = SqlItemDaoHelper(db)
    private val weaponHelper = WeaponHelper(db, helper)
    private val armorHelper = ArmorHelper(db, helper)
    private val goodHelper = GoodHelper(db, helper)

    override fun getAllWeapons(allWeaponFamilies: List<WeaponFamily>): List<Weapon> {
        return weaponHelper.getAllWeapons(allWeaponFamilies)
    }

    override fun getAllArmor(): List<Armor> {
        return armorHelper.allArmor
    }

    override fun getAllGoods(): List<Good> {
        return goodHelper.allGoods
    }

    override fun createWeapon(weapon: Weapon): Weapon {
        return weaponHelper.createWeapon(weapon)
    }

    override fun updateWeapon(weapon: Weapon) {
        weaponHelper.updateWeapon(weapon)
    }

    override fun deleteWeapon(weapon: Weapon) {
        weaponHelper.deleteWeapon(weapon)
    }

    override fun createArmor(armor: Armor): Armor {
        return armorHelper.createArmor(armor)
    }

    override fun updateArmor(armor: Armor) {
        armorHelper.updateArmor(armor)
    }

    override fun deleteArmor(armor: Armor) {
        armorHelper.deleteArmor(armor)
    }

    override fun createGood(good: Good): Good {
        return goodHelper.createGood(good)
    }

    override fun updateGood(good: Good) {
        goodHelper.updateGood(good)
    }

    override fun deleteGood(good: Good) {
        goodHelper.deleteGood(good)
    }

    override fun getAllWeaponFamilies(): List<WeaponFamily> {
        return weaponHelper.allWeaponFamilies
    }


}