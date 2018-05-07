package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.boc.model.BodyPart.BODY;
import static com.d20charactersheet.framework.boc.model.BodyPart.BOTH_HANDS;
import static com.d20charactersheet.framework.boc.model.BodyPart.NONE;
import static com.d20charactersheet.framework.boc.model.BodyPart.OFF_HAND;
import static com.d20charactersheet.framework.boc.model.BodyPart.PRIMARY_HAND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumSet;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.BodyPart;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponType;

public class BodyServiceTest {

  private final BodyService bodyService = new BodyService();

  @Test
  public void testLightWeapon() {
    // Arrange
    Weapon lightWeapon = new Weapon();
    lightWeapon.setWeaponEncumbrance(WeaponEncumbrance.LIGHT_HANDED);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(lightWeapon);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(OFF_HAND, PRIMARY_HAND, BOTH_HANDS);
  }

  @Test
  public void testOneHandedWeapon() {
    // Arrange
    Weapon oneHandedWeapon = new Weapon();
    oneHandedWeapon.setWeaponEncumbrance(WeaponEncumbrance.ONE_HANDED);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(oneHandedWeapon);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(OFF_HAND, PRIMARY_HAND, BOTH_HANDS);
  }

  @Test
  public void testTwoHandedWeapon() {
    // Arrange
    Weapon twoHandedWeapon = new Weapon();
    twoHandedWeapon.setWeaponEncumbrance(WeaponEncumbrance.TWO_HANDED);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(twoHandedWeapon);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(BOTH_HANDS);
  }

  @Test
  public void testAmmo() {
    // Arrange
    Weapon twoHandedWeapon = new Weapon();
    twoHandedWeapon.setWeaponEncumbrance(WeaponEncumbrance.TWO_HANDED);
    twoHandedWeapon.setWeaponType(WeaponType.AMMO);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(twoHandedWeapon);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(NONE);
  }

  @Test
  public void testLightArmor() {
    // Arrange
    Armor lightArmor = new Armor();
    lightArmor.setArmorType(ArmorType.LIGHT);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(lightArmor);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(BODY);
  }

  @Test
  public void testMediumArmor() {
    // Arrange
    Armor mediumArmor = new Armor();
    mediumArmor.setArmorType(ArmorType.MEDIUM);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(mediumArmor);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(BODY);
  }

  @Test
  public void testHeavyArmor() {
    // Arrange
    Armor heavyArmor = new Armor();
    heavyArmor.setArmorType(ArmorType.HEAVY);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(heavyArmor);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(BODY);
  }

  @Test
  public void testShield() {
    // Arrange
    Armor shield = new Armor();
    shield.setArmorType(ArmorType.SHIELD);

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(shield);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(OFF_HAND);
  }

  @Test
  public void testGood() {
    // Arrange
    Good good = new Good();

    // Act
    EnumSet<BodyPart> bodyParts = bodyService.calculateBodyParts(good);

    // Assert
    assertThat(bodyParts).containsExactlyInAnyOrder(NONE);
  }


}
