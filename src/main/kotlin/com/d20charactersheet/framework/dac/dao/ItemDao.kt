package com.d20charactersheet.framework.dac.dao

import com.d20charactersheet.framework.boc.model.Armor
import com.d20charactersheet.framework.boc.model.Good
import com.d20charactersheet.framework.boc.model.Weapon
import com.d20charactersheet.framework.boc.model.WeaponFamily

/**
 * Interface to persistent layer of items.
 */
interface ItemDao {

    /**
     * Returns all weapons from the persistent layer.
     *
     * @param allWeaponFamilies
     * All weapon families.
     *
     * @return All weapons.
     */
    fun getAllWeapons(allWeaponFamilies: List<WeaponFamily>): List<Weapon>

    /**
     * Returns all armor from the persistent layer.
     *
     * @return All armor.
     */
    fun getAllArmor(): List<Armor>

    /**
     * Returns all goods from the persistent layer.
     *
     * @return All goods.
     */
    fun getAllGoods(): List<Good>

    /**
     * Persists the weapon. Creates a weapon id while persisting it.
     *
     * @param weapon
     * The weapon to persist.
     *
     * @return The persisted weapon with the persisted id.
     */
    fun createWeapon(weapon: Weapon): Weapon

    /**
     * Updates the weapon.
     *
     * @param weapon
     * The weapon to update.
     */
    fun updateWeapon(weapon: Weapon)

    /**
     * Persists the armor and creates its id.
     *
     * @param armor
     * The armor to persist.
     *
     * @return The persited armor with the created id:
     */
    fun createArmor(armor: Armor): Armor

    /**
     * Updates the armor.
     *
     * @param armor
     * The armor to update.
     */
    fun updateArmor(armor: Armor)

    /**
     * Deletes the weapon from the persistent layer.
     *
     * @param weapon
     * The weapon to delete.
     */
    fun deleteWeapon(weapon: Weapon)

    /**
     * Deletes the armor.
     *
     * @param armor
     * The armor to delete.
     */
    fun deleteArmor(armor: Armor)

    /**
     * Creates the good in the persistent layer.
     *
     * @param good
     * The good to create.
     *
     * @return The created good.
     */
    fun createGood(good: Good): Good

    /**
     * Deletes the good from the persistent layer.
     *
     * @param good
     * The good to delete.
     */
    fun deleteGood(good: Good)

    /**
     * Updates the good in the persistent layer.
     *
     * @param good
     * The good to update.
     */
    fun updateGood(good: Good)

    /**
     * Returns list of all weapon families.
     *
     * @return List of all weapon families.
     */
    fun getAllWeaponFamilies(): List<WeaponFamily>
}