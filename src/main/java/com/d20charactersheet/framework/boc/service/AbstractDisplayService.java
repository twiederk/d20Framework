package com.d20charactersheet.framework.boc.service;

import java.util.Iterator;
import java.util.List;

import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Descriptor;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Note;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SubSchool;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.WeaponCategory;

/**
 * Implements methods of DisplayService interface which are independed from the OS. OS dependent display services derive
 * from this abstract implementation.
 */
public abstract class AbstractDisplayService implements DisplayService {

  /**
   * @see com.d20charactersheet.framework.boc.service.DisplayService#getDisplayClassLevels(java.util.List)
   */
  public String getDisplayClassLevels(final List<ClassLevel> classLevels) {
    final StringBuilder displayClassLevels = new StringBuilder();
    for (final Iterator<ClassLevel> iterator = classLevels.iterator(); iterator.hasNext(); ) {
      final ClassLevel classLevel = iterator.next();
      displayClassLevels.append(getDisplayClassLevel(classLevel));
      if (iterator.hasNext()) {
        displayClassLevels.append(", ");
      }
    }
    return displayClassLevels.toString();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.DisplayService#getDisplayClassLevel(com.d20charactersheet.framework.boc.model.ClassLevel)
   */
  public String getDisplayClassLevel(final ClassLevel classLevel) {
    final StringBuilder displayClassLevel = new StringBuilder();
    final CharacterClass characterClass = classLevel.getCharacterClass();
    final int level = classLevel.getLevel();
    displayClassLevel.append(characterClass.getName());
    displayClassLevel.append(" (").append(level).append(")");
    return displayClassLevel.toString();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.DisplayService#getDisplayModifier(int)
   */
  public String getDisplayModifier(final int modifier) {
    String sign = "";
    if (modifier > 0) {
      sign = "+";
    }
    return sign + modifier;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.DisplayService#getDisplayBaseAttackBonus(int)
   */
  public String getDisplayBaseAttackBonus(final int baseAttackBonus) {
    final StringBuilder displayBaseAttackBonus = new StringBuilder();
    int bab = baseAttackBonus;
    do {
      displayBaseAttackBonus.append("+").append(bab);
      bab -= 5;
      if (bab > 0) {
        displayBaseAttackBonus.append("/");
      }
    } while (bab > 0);
    return displayBaseAttackBonus.toString();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.DisplayService#getDisplayArmourClassFormular(int)
   */
  @Override
  public String getDisplayArmourClassFormular(final int dexterityModifier) {
    final String displayModifier = getDisplayModifier(dexterityModifier);
    return "10 + (" + displayModifier + ") + ";
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.DisplayService#getDisplaySimpleFormular(int)
   */
  public String getDisplaySimpleFormular(final int dexterityModifier) {
    final String displayModifier = getDisplayModifier(dexterityModifier);
    return displayModifier + " + ";
  }

  public String getDisplayNoteFirstLine(final Note note) {
    final String text = note.getText();
    final int indexOfNewLine = text.indexOf('\n');
    if (indexOfNewLine >= 0) {
      return text.substring(0, indexOfNewLine);
    }
    return text;
  }

  @Override
  public String getDisplayDamage(final Damage damage, final int bonus) {
    final int numberOfDice = damage.getNumberOfDice();

    final StringBuilder output = new StringBuilder();
    if (numberOfDice > 0) {
      output.append(numberOfDice);
      output.append(getDisplayDie(damage.getDie()));
    }
    if (bonus != 0) {
      output.append(getDisplayModifier(bonus));
    }
    return output.toString();
  }

  @Override
  public String getDisplayDamage(final Weapon weapon) {
    return getDisplayDamage(weapon.getDamage(), weapon.getEnhancementBonus());
  }

  @Override
  public String getDisplayDamage(final WeaponAttack weaponAttack) {
    return getDisplayDamage(weaponAttack.getDamage(), weaponAttack.getDamageBonus());
  }

  public String getDisplayRangeIncrement(final int rangeIncrement) {
    if (rangeIncrement == 0) {
      return "-";
    }
    final StringBuilder output = new StringBuilder();
    output.append(rangeIncrement).append(" ").append(getDisplayUnitDistanceShort());
    return output.toString();
  }

  @Override
  public String getDisplayAmmunition(final WeaponAttack weaponAttack) {
    if (WeaponCategory.PROJECTILE_WEAPON.equals(weaponAttack.getWeapon().getWeaponCategory())) {
      return Integer.toString(weaponAttack.getAmmunition());
    }
    return "-";
  }

  @Override
  public String getDisplaySpellSchool(final Spell spell) {
    final StringBuilder output = new StringBuilder();
    output.append(getSchool(spell));
    output.append(getSubSchool(spell));
    output.append(getDescriptors(spell));
    return output.toString();
  }

  private String getSchool(final Spell spell) {
    final School school = spell.getSchool();
    if (school == null) {
      return "";
    }
    return getDisplaySchool(school);
  }

  private String getSubSchool(final Spell spell) {
    final SubSchool subSchool = spell.getSubSchool();

    final StringBuilder output = new StringBuilder();
    if (subSchool != null && !SubSchool.NONE.equals(subSchool)) {
      output.append(" (").append(getDisplaySubSchool(subSchool)).append(")");
    }
    return output.toString();
  }

  private String getDescriptors(final Spell spell) {
    final Descriptor[] descriptors = spell.getDescriptors();

    final StringBuilder output = new StringBuilder();
    if (descriptors != null && descriptors.length > 0 && !(descriptors.length == 1 && Descriptor.NONE.equals(descriptors[0]))) {
      output.append(" [");
      for (int i = 0; i < descriptors.length; i++) {
        output.append(getDisplayDescriptor(descriptors[i]));
        if (i + 1 < descriptors.length) {
          output.append(", ");
        }
      }
      output.append("]");
    }
    return output.toString();
  }

  public String getDisplayMetamagicFeat(final Feat feat) {
    final StringBuilder output = new StringBuilder();
    output.append(feat.getName());
    output.append(" (").append(feat.getSpellSlot()).append(")");
    return output.toString();
  }

}
