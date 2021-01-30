package com.d20charactersheet.framework.boc.service

import com.d20charactersheet.framework.boc.model.*
import org.junit.Assert
import org.junit.jupiter.api.Test

class DnDv35RuleServiceItemTest : DnDv35RuleServiceTestCase() {

    @Test
    fun testGetLoadOfBelvador() {
        // Act
        val load = ruleService.getLoad(belvador)

        // Assert
        Assert.assertEquals(52.5f, load, 0.0f)
    }

    @Test
    fun equipItemInPrimaryHandWithEmptyPrimaryHand() {
        // Arrange
        val oneHandedWeapon = Weapon()
        oneHandedWeapon.id = 1
        oneHandedWeapon.weaponEncumbrance = WeaponEncumbrance.ONE_HANDED

        // Act
        val body = ruleService.equipItem(HumanoidBody(), BodyPart.PRIMARY_HAND, oneHandedWeapon)

        // Assert
        BodyAssert.assertThat(body).equippedItem(BodyPart.PRIMARY_HAND, oneHandedWeapon)
    }

    @Test
    fun equipItemInPrimaryHandWithFilledPrimaryHand() {
        // Arrange
        val oneHandedWeapon = Weapon()
        oneHandedWeapon.id = 1
        oneHandedWeapon.weaponEncumbrance = WeaponEncumbrance.ONE_HANDED
        var body: Body = HumanoidBody()
        body.equip(BodyPart.PRIMARY_HAND, Weapon())

        // Act
        body = ruleService.equipItem(body, BodyPart.PRIMARY_HAND, oneHandedWeapon)

        // Assert
        BodyAssert.assertThat(body).equippedItem(BodyPart.PRIMARY_HAND, oneHandedWeapon)
    }

    @Test
    fun equipItemInPrimaryHandWithFilledBothHands() {
        // Arrange
        val longsword = gameSystem.itemService.getItemById(24, gameSystem.allWeapons)
        val greatsword = gameSystem.itemService.getItemById(38, gameSystem.allWeapons)
        var body: Body = HumanoidBody()
        body.equip(BodyPart.BOTH_HANDS, greatsword)

        // Act
        body = ruleService.equipItem(body, BodyPart.PRIMARY_HAND, longsword)

        // Assert
        BodyAssert.assertThat(body).equippedItem(BodyPart.PRIMARY_HAND, longsword).isEmpty(BodyPart.BOTH_HANDS)
    }

    @Test
    fun equipItemInOffHandWithFilledBothHands() {
        // Arrange
        val dagger = gameSystem.itemService.getItemById(1, gameSystem.allWeapons)
        val greatsword = gameSystem.itemService.getItemById(38, gameSystem.allWeapons)
        var body: Body = HumanoidBody()
        body.equip(BodyPart.BOTH_HANDS, greatsword)

        // Act
        body = ruleService.equipItem(body, BodyPart.OFF_HAND, dagger)

        // Assert
        BodyAssert.assertThat(body).equippedItem(BodyPart.OFF_HAND, dagger).isEmpty(BodyPart.BOTH_HANDS)
    }

    @Test
    fun equipItemInBothHandsWithFilledPrimaryAndOffHand() {
        // Arrange
        val dagger = gameSystem.itemService.getItemById(1, gameSystem.allWeapons)
        val longsword = gameSystem.itemService.getItemById(24, gameSystem.allWeapons)
        val greatsword = gameSystem.itemService.getItemById(38, gameSystem.allWeapons)
        var body: Body = HumanoidBody()
        body.equip(BodyPart.OFF_HAND, dagger)
        body.equip(BodyPart.PRIMARY_HAND, longsword)

        // Act
        body = ruleService.equipItem(body, BodyPart.BOTH_HANDS, greatsword)

        // Assert
        BodyAssert.assertThat(body).equippedItem(BodyPart.BOTH_HANDS, greatsword).isEmpty(BodyPart.OFF_HAND)
            .isEmpty(BodyPart.PRIMARY_HAND)
    }
}