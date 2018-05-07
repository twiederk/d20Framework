package com.d20charactersheet.framework.boc.service;

import static com.d20charactersheet.framework.boc.model.BodyPart.BODY;
import static com.d20charactersheet.framework.boc.model.BodyPart.BOTH_HANDS;
import static com.d20charactersheet.framework.boc.model.BodyPart.NONE;
import static com.d20charactersheet.framework.boc.model.BodyPart.OFF_HAND;
import static com.d20charactersheet.framework.boc.model.BodyPart.PRIMARY_HAND;

import java.util.EnumSet;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.BodyPart;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponType;

/**
 * The BodyService offers functions concerning the body of a character.
 */
public class BodyService {

  /**
   * Returns the body parts which can equip the item.
   *
   * @param item
   *     The item to equip.
   *
   * @return The body parts which can equip the item.
   */
  public EnumSet<BodyPart> calculateBodyParts(Item item) {
    EnumSet<BodyPart> bodyParts = EnumSet.of(NONE);
    if (item instanceof Weapon) {
      bodyParts = calculateWeaponBodyParts((Weapon) item);
    } else if (item instanceof Armor) {
      bodyParts = calculateArmorBodyParts((Armor) item);
    }
    return bodyParts;
  }

  private EnumSet<BodyPart> calculateArmorBodyParts(Armor armor) {
    if (ArmorType.SHIELD.equals(armor.getArmorType())) {
      return EnumSet.of(OFF_HAND);
    }
    return EnumSet.of(BODY);
  }

  private EnumSet<BodyPart> calculateWeaponBodyParts(Weapon weapon) {
    if (WeaponType.AMMO.equals(weapon.getWeaponType())) {
      return EnumSet.of(NONE);
    }
    if (WeaponEncumbrance.TWO_HANDED.equals(weapon.getWeaponEncumbrance())) {
      return EnumSet.of(BOTH_HANDS);
    }
    return EnumSet.of(OFF_HAND, PRIMARY_HAND, BOTH_HANDS);
  }

}
