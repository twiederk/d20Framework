package com.d20charactersheet.framework.boc.service.exportimport;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.ArmorType;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;
import com.d20charactersheet.framework.boc.model.WeaponFamily;
import com.d20charactersheet.framework.boc.model.WeaponType;
import com.d20charactersheet.framework.boc.service.exportimport.ImportMessage.Type;

/**
 * Imports equipment from a xml file.
 */
public class ImportEquipmentV1Xml extends XmlImport implements ImportEquipment {

  /**
   * Creates importer for equipment from a xml file.
   *
   * @param importContext
   *     The import context containing all data necessary to import equipment.
   * @param document
   *     The xml document to import equipment from.
   */
  public ImportEquipmentV1Xml(final ImportContext importContext, final Document document) {
    super(importContext, document);
  }

  @Override
  public List<ImportReport<? extends Item>> importEquipment() {

    final List<ImportReport<? extends Item>> importReports = new ArrayList<>();

    final NodeList weaponList = document.getElementsByTagName(TAG_WEAPON);
    importReports.addAll(importItems(weaponList, new ImportWeapon()));

    final NodeList armorList = document.getElementsByTagName(TAG_ARMOR);
    importReports.addAll(importItems(armorList, new ImportArmor()));

    final NodeList goodList = document.getElementsByTagName(TAG_GOOD);
    importReports.addAll(importItems(goodList, new ImportGood()));

    return importReports;
  }

  private List<ImportReport<? extends Item>> importItems(final NodeList itemList, final ImportItem importItem) {
    final List<ImportReport<? extends Item>> importReports = new ArrayList<>(itemList.getLength());
    for (int i = 0; i < itemList.getLength(); i++) {
      final Node itemNode = itemList.item(i);
      final ImportReport<? extends Item> importReport = importItem.importItem(itemNode);
      importReports.add(importReport);
    }
    return importReports;
  }

  /**
   * Imports the general information of an item. Base class for specific item import classes.
   */
  public abstract class ImportItem {
    private static final int INDEX_NAME = 0;
    private static final int INDEX_COST = 1;
    private static final int INDEX_WEIGHT = 2;
    private static final int INDEX_QUALITY = 3;
    private static final int INDEX_DESCRIPTION = 4;
    static final int INDEX_TYPE = 5;

    void importItem(final Node itemNode, final Item item) {
      final NodeList childNodes = itemNode.getChildNodes();
      final String name = childNodes.item(INDEX_NAME).getTextContent();
      final float cost = getFloat(childNodes.item(INDEX_COST));
      final float weight = getFloat(childNodes.item(INDEX_WEIGHT));
      final QualityType qualityType = Enum.valueOf(QualityType.class, childNodes.item(INDEX_QUALITY).getTextContent());
      final String description = childNodes.item(INDEX_DESCRIPTION).getTextContent();

      item.setName(name);
      item.setWeight(weight);
      item.setCost(cost);
      item.setQualityType(qualityType);
      item.setDescription(description);
    }

    abstract ImportReport<? extends Item> importItem(final Node itemNode);

  }

  /**
   * Imports a weapon.
   */
  public class ImportWeapon extends ImportItem {

    private static final int INDEX_DAMAGE = 6;
    private static final int INDEX_CRITICAL = 7;
    private static final int INDEX_COMBAT = 8;
    private static final int INDEX_ENCUMBRANCE = 9;
    private static final int INDEX_CATEGORY = 10;
    private static final int INDEX_ENHANCEMENT = 11;
    private static final int INDEX_FAMILY = 12;
    private static final int INDEX_RANGEINCREMENT = 13;

    @Override
    public ImportReport<Weapon> importItem(final Node weaponNode) {
      final ImportReport<Weapon> importReport = new ImportReport<>(new Weapon());
      try {
        final Weapon weapon = importReport.getImportObject();
        importItem(weaponNode, weapon);

        final NodeList childNodes = weaponNode.getChildNodes();
        final WeaponType weaponType = Enum.valueOf(WeaponType.class, childNodes.item(INDEX_TYPE).getTextContent());
        final Damage damage = getDamage((Element) childNodes.item(INDEX_DAMAGE));
        final Critical critical = getCritical((Element) childNodes.item(INDEX_CRITICAL));
        final CombatType combat = Enum.valueOf(CombatType.class, childNodes.item(INDEX_COMBAT).getTextContent());
        final WeaponEncumbrance encumbrance = Enum
            .valueOf(WeaponEncumbrance.class, childNodes.item(INDEX_ENCUMBRANCE).getTextContent());
        final WeaponCategory category = Enum.valueOf(WeaponCategory.class, childNodes.item(INDEX_CATEGORY).getTextContent());
        final int enhancementBonus = getInt(childNodes.item(INDEX_ENHANCEMENT));
        final WeaponFamily family = getFamily(childNodes.item(INDEX_FAMILY), importReport);
        final int rangeIncrement = getInt(childNodes.item(INDEX_RANGEINCREMENT));

        weapon.setWeaponType(weaponType);
        weapon.setDamage(damage);
        weapon.setCritical(critical);
        weapon.setCombatType(combat);
        weapon.setWeaponEncumbrance(encumbrance);
        weapon.setWeaponCategory(category);
        weapon.setEnhancementBonus(enhancementBonus);
        weapon.setWeaponFamily(family);
        weapon.setRangeIncrement(rangeIncrement);
      } catch (final Exception exception) {
        exception.printStackTrace();
        final String message = exception.getMessage();
        final ImportMessage importMessage = new ImportMessage(message, ImportMessage.Type.ERROR);
        importReport.addMessage(importMessage);
      }
      return importReport;
    }

    private Damage getDamage(final Element damageElement) {
      final int numberOfDice = Integer.parseInt(damageElement.getAttribute(ATTRIBUTE_NUMBEROFDICE));
      final Die die = Enum.valueOf(Die.class, damageElement.getAttribute(ATTRIBUTE_DIE));
      final Damage damage = new Damage(numberOfDice, die);
      return damage;
    }

    private Critical getCritical(final Element criticalElement) {
      final int hit = Integer.parseInt(criticalElement.getAttribute(ATTRIBUTE_HIT));
      final int multiplier = Integer.parseInt(criticalElement.getAttribute(ATTRIBUTE_MULTIPIER));
      final Critical critical = new Critical(hit, multiplier);
      return critical;
    }

    private WeaponFamily getFamily(final Node familyNode, final ImportReport<Weapon> importReport) {
      final String name = familyNode.getTextContent();
      for (final WeaponFamily weaponFamily : importContext.getAllWeaponFamilies()) {
        if (weaponFamily.getName().equals(name)) {
          return weaponFamily;
        }
      }
      final WeaponFamily weaponFamily = importContext.getAllWeaponFamilies().get(0);
      final String message = "Can't find weapon family " + name + ". Using weapon family " + weaponFamily.getName() + " instead";
      final ImportMessage importMessage = new ImportMessage(message, Type.WARNING);
      importReport.addMessage(importMessage);
      return weaponFamily;
    }

  }

  /**
   * Imports an armor.
   */
  public class ImportArmor extends ImportItem {

    private static final int INDEX_BONUS = 6;
    private static final int INDEX_PENALTY = 7;

    @Override
    public ImportReport<Armor> importItem(final Node armorNode) {
      final ImportReport<Armor> importReport = new ImportReport<>(new Armor());
      final Armor armor = importReport.getImportObject();
      try {
        importItem(armorNode, armor);

        final NodeList childNodes = armorNode.getChildNodes();
        final ArmorType armorType = Enum.valueOf(ArmorType.class, childNodes.item(INDEX_TYPE).getTextContent());
        final int bonus = getInt(childNodes.item(INDEX_BONUS));
        final int penalty = getInt(childNodes.item(INDEX_PENALTY));

        armor.setArmorType(armorType);
        armor.setArmorBonus(bonus);
        armor.setArmorCheckPenalty(penalty);
      } catch (final Exception exception) {
        exception.printStackTrace();
        final String message = exception.getMessage();
        final ImportMessage importMessage = new ImportMessage(message, ImportMessage.Type.ERROR);
        importReport.addMessage(importMessage);
      }
      return importReport;
    }
  }

  /**
   * Imports a good.
   */
  public class ImportGood extends ImportItem {

    @Override
    public ImportReport<Good> importItem(final Node goodNode) {
      final ImportReport<Good> importReport = new ImportReport<>(new Good());
      final Good good = importReport.getImportObject();
      try {
        importItem(goodNode, good);
        final NodeList childNodes = goodNode.getChildNodes();
        final GoodType goodType = Enum.valueOf(GoodType.class, childNodes.item(INDEX_TYPE).getTextContent());
        good.setGoodType(goodType);
      } catch (final Exception exception) {
        exception.printStackTrace();
        final String message = exception.getMessage();
        final ImportMessage importMessage = new ImportMessage(message, ImportMessage.Type.ERROR);
        importReport.addMessage(importMessage);
      }
      return importReport;
    }
  }

}
