package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Body;
import com.d20charactersheet.framework.boc.model.BodyAssert;
import com.d20charactersheet.framework.boc.model.BodyPart;
import com.d20charactersheet.framework.boc.model.HumanoidBody;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;

public class DnDv35RuleServiceItemTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testGetLoadOfBelvador() {
    // Act
    float load = ruleService.getLoad(belvador);

    // Assert
    assertEquals(52.5f, load, 0.0f);
  }

  @Test
  public void equipItemInPrimaryHandWithEmptyPrimaryHand() {
    // Arrange
    Weapon oneHandedWeapon = new Weapon();
    oneHandedWeapon.setId(1);
    oneHandedWeapon.setWeaponEncumbrance(WeaponEncumbrance.ONE_HANDED);

    // Act
    Body body = ruleService.equipItem(new HumanoidBody(), BodyPart.PRIMARY_HAND, oneHandedWeapon);

    // Assert
    BodyAssert.assertThat(body).equippedItem(BodyPart.PRIMARY_HAND, oneHandedWeapon);
  }

  @Test
  public void equipItemInPrimaryHandWithFilledPrimaryHand() {
    // Arrange
    Weapon oneHandedWeapon = new Weapon();
    oneHandedWeapon.setId(1);
    oneHandedWeapon.setWeaponEncumbrance(WeaponEncumbrance.ONE_HANDED);
    Body body = new HumanoidBody();
    body.equip(BodyPart.PRIMARY_HAND, new Weapon());

    // Act
    body = ruleService.equipItem(body, BodyPart.PRIMARY_HAND, oneHandedWeapon);

    // Assert
    BodyAssert.assertThat(body).equippedItem(BodyPart.PRIMARY_HAND, oneHandedWeapon);
  }

  @Test
  public void equipItemInPrimaryHandWithFilledBothHands() {
    // Arrange
    Item longsword = gameSystem.getItemService().getItemById(24, gameSystem.getAllWeapons());
    Item greatsword = gameSystem.getItemService().getItemById(38, gameSystem.getAllWeapons());

    Body body = new HumanoidBody();
    body.equip(BodyPart.BOTH_HANDS, greatsword);

    // Act
    body = ruleService.equipItem(body, BodyPart.PRIMARY_HAND, longsword);

    // Assert
    BodyAssert.assertThat(body).equippedItem(BodyPart.PRIMARY_HAND, longsword).isEmpty(BodyPart.BOTH_HANDS);
  }

  @Test
  public void equipItemInOffHandWithFilledBothHands() {
    // Arrange
    Item dagger = gameSystem.getItemService().getItemById(1, gameSystem.getAllWeapons());
    Item greatsword = gameSystem.getItemService().getItemById(38, gameSystem.getAllWeapons());

    Body body = new HumanoidBody();
    body.equip(BodyPart.BOTH_HANDS, greatsword);

    // Act
    body = ruleService.equipItem(body, BodyPart.OFF_HAND, dagger);

    // Assert
    BodyAssert.assertThat(body).equippedItem(BodyPart.OFF_HAND, dagger).isEmpty(BodyPart.BOTH_HANDS);
  }

  @Test
  public void equipItemInBothHandsWithFilledPrimaryAndOffHand() {
    // Arrange
    Item dagger = gameSystem.getItemService().getItemById(1, gameSystem.getAllWeapons());
    Item longsword = gameSystem.getItemService().getItemById(24, gameSystem.getAllWeapons());
    Item greatsword = gameSystem.getItemService().getItemById(38, gameSystem.getAllWeapons());

    Body body = new HumanoidBody();
    body.equip(BodyPart.OFF_HAND, dagger);
    body.equip(BodyPart.PRIMARY_HAND, longsword);

    // Act
    body = ruleService.equipItem(body, BodyPart.BOTH_HANDS, greatsword);

    // Assert
    BodyAssert.assertThat(body).equippedItem(BodyPart.BOTH_HANDS, greatsword).isEmpty(BodyPart.OFF_HAND)
        .isEmpty(BodyPart.PRIMARY_HAND);
  }

}
