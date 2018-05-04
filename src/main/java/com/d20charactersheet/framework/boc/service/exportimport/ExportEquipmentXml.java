package com.d20charactersheet.framework.boc.service.exportimport;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.Weapon;

/**
 * Exports equipment to a xml file.
 */
public class ExportEquipmentXml extends XmlExport implements ExportEquipment {

  private static final String VERSION = "1";

  @Override
  public void exportEquipment(final String gameSystemName, final File exportFile, final List<Weapon> weapons,
      final List<Armor> armor, final List<Good> goods) throws Exception {
    createDocument();

    // create equipment element
    final Element equipmentElement = document.createElement(TAG_EQUIPMENT);
    equipmentElement.setAttribute(ATTRIBUTE_VERSION, VERSION);
    equipmentElement.setAttribute(ATTRIBUTE_GAMESYSTEM, gameSystemName);
    document.appendChild(equipmentElement);

    final Node weaponsNode = createWeapons(weapons);
    equipmentElement.appendChild(weaponsNode);

    final Node armorsNode = createArmors(armor);
    equipmentElement.appendChild(armorsNode);

    final Node goodsNode = createGoods(goods);
    equipmentElement.appendChild(goodsNode);

    // write XML file
    final PrintStream printStream = new PrintStream(exportFile);
    write(printStream, DTD_EQUIPMENT_SYSTEM, DTD_EQUIPMENT_PUBLIC);
  }

  private Node createWeapons(final List<Weapon> weapons) {
    final Node weaponsNode = document.createElement(TAG_WEAPONS);
    for (final Weapon weapon : weapons) {
      final Node weaponNode = createWeapon(weapon);
      weaponsNode.appendChild(weaponNode);
    }
    return weaponsNode;
  }

  private Node createWeapon(final Weapon weapon) {
    final Node weaponNode = createItem(TAG_WEAPON, weapon);
    weaponNode.appendChild(createElementWithText(TAG_TYPE, weapon.getWeaponType().name()));
    weaponNode.appendChild(createDamage(weapon.getDamage()));
    weaponNode.appendChild(createCritical(weapon.getCritical()));
    weaponNode.appendChild(createElementWithText(TAG_COMBAT, weapon.getCombatType().name()));
    weaponNode.appendChild(createElementWithText(TAG_ENCUMBRANCE, weapon.getWeaponEncumbrance().name()));
    weaponNode.appendChild(createElementWithText(TAG_CATEGORY, weapon.getWeaponCategory().name()));
    weaponNode.appendChild(createElementWithText(TAG_ENHANCEMENT, Integer.toString(weapon.getEnhancementBonus())));
    weaponNode.appendChild(createElementWithText(TAG_FAMILY, weapon.getWeaponFamily().getName()));
    weaponNode.appendChild(createElementWithText(TAG_RANGEINCREMENT, Integer.toString(weapon.getRangeIncrement())));

    return weaponNode;
  }

  private Node createItem(final String tag, final Item item) {
    final Node node = document.createElement(tag);
    node.appendChild(createElementWithText(TAG_NAME, item.getName()));
    node.appendChild(createElementWithText(TAG_COST, item.getCost()));
    node.appendChild(createElementWithText(TAG_WEIGHT, item.getWeight()));
    node.appendChild(createElementWithText(TAG_QUALITY, item.getQualityType().name()));
    node.appendChild(createElementWithText(TAG_DESCRIPTION, item.getDescription()));
    return node;
  }

  private Node createDamage(final Damage damage) {
    final Element damageElement = document.createElement(TAG_DAMAGE);
    damageElement.setAttribute(ATTRIBUTE_NUMBEROFDICE, Integer.toString(damage.getNumberOfDice()));
    damageElement.setAttribute(ATTRIBUTE_DIE, damage.getDie().name());
    return damageElement;
  }

  private Node createCritical(final Critical critical) {
    final Element criticalElement = document.createElement(TAG_CRITICAL);
    criticalElement.setAttribute(ATTRIBUTE_HIT, Integer.toString(critical.getHit()));
    criticalElement.setAttribute(ATTRIBUTE_MULTIPIER, Integer.toString(critical.getMultiplier()));
    return criticalElement;
  }

  private Node createArmors(final List<Armor> armors) {
    final Node armorsNode = document.createElement(TAG_ARMORS);
    for (final Armor armor : armors) {
      final Node armorNode = createArmor(armor);
      armorsNode.appendChild(armorNode);
    }
    return armorsNode;
  }

  private Node createArmor(final Armor armor) {
    final Node armorNode = createItem(TAG_ARMOR, armor);
    armorNode.appendChild(createElementWithText(TAG_TYPE, armor.getArmorType().name()));
    armorNode.appendChild(createElementWithText(TAG_BONUS, armor.getArmorBonus()));
    armorNode.appendChild(createElementWithText(TAG_PENALTY, armor.getArmorCheckPenalty()));
    return armorNode;
  }

  private Node createGoods(final List<Good> goods) {
    final Node goodsNode = document.createElement(TAG_GOODS);
    for (final Good good : goods) {
      final Node goodNode = createGood(good);
      goodsNode.appendChild(goodNode);
    }
    return goodsNode;
  }

  private Node createGood(final Good good) {
    final Node goodNode = createItem(TAG_GOOD, good);
    goodNode.appendChild(createElementWithText(TAG_TYPE, good.getGoodType().name()));
    return goodNode;
  }

}
