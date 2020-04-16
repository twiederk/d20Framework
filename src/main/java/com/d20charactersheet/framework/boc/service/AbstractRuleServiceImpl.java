package com.d20charactersheet.framework.boc.service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.d20charactersheet.framework.boc.model.Ability;
import com.d20charactersheet.framework.boc.model.Armor;
import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Attribute;
import com.d20charactersheet.framework.boc.model.Body;
import com.d20charactersheet.framework.boc.model.BodyPart;
import com.d20charactersheet.framework.boc.model.CastingType;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterAbility;
import com.d20charactersheet.framework.boc.model.CharacterClass;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.CharacterSkill;
import com.d20charactersheet.framework.boc.model.ClassLevel;
import com.d20charactersheet.framework.boc.model.CombatType;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.DieRoll;
import com.d20charactersheet.framework.boc.model.ExtraFeatsAbility;
import com.d20charactersheet.framework.boc.model.ExtraSkillPointsAbility;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.Good;
import com.d20charactersheet.framework.boc.model.GoodType;
import com.d20charactersheet.framework.boc.model.Item;
import com.d20charactersheet.framework.boc.model.ItemGroup;
import com.d20charactersheet.framework.boc.model.KnownSpell;
import com.d20charactersheet.framework.boc.model.KnownSpellsTable;
import com.d20charactersheet.framework.boc.model.Money;
import com.d20charactersheet.framework.boc.model.RuleError;
import com.d20charactersheet.framework.boc.model.RuleException;
import com.d20charactersheet.framework.boc.model.Save;
import com.d20charactersheet.framework.boc.model.School;
import com.d20charactersheet.framework.boc.model.Size;
import com.d20charactersheet.framework.boc.model.Skill;
import com.d20charactersheet.framework.boc.model.Spell;
import com.d20charactersheet.framework.boc.model.SpellSlot;
import com.d20charactersheet.framework.boc.model.SpellSource;
import com.d20charactersheet.framework.boc.model.Spelllist;
import com.d20charactersheet.framework.boc.model.SpelllistAbility;
import com.d20charactersheet.framework.boc.model.SpellsPerDayTable;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;
import com.d20charactersheet.framework.boc.model.WeaponCategory;
import com.d20charactersheet.framework.boc.model.WeaponEncumbrance;

/**
 * Implementation of the RuleService.
 */
public abstract class AbstractRuleServiceImpl implements RuleService {

  private static final String FEAT_WEAPON_FINESSE = "Weapon Finesse";
  private static final String FEAT_TWO_WEAPON_FIGHTING = "Two-Weapon Fighting";
  private static final String FEAT_WEAPON_FOCUS = "Weapon Focus";
  private static final String FEAT_GREATER_WEAPON_FOCUS = "Greater Weapon Focus";
  private static final String FEAT_WEAPON_SPECIALIZATION = "Weapon Specialization";
  private static final String FEAT_GREATER_WEAPON_SPECIALIZATION = "Greater Weapon Specialization";
  private static final String FEAT_IMPROVED_TWO_WEAPON_FIGHTING = "Improved Two-Weapon Fighting";
  private static final String FEAT_GREATER_TWO_WEAPON_FIGHTING = "Greater Two-Weapon Fighting";

  private static final String WEAPON_FAMILIY_SLING = "Sling";
  private static final String WEAPON_FAMILIY_LONGBOW = "Longbow";
  private static final String WEAPON_FAMILIY_SHORTBOW = "Shortbow";
  private static final String WEAPON_FAMILIY_COMPOSITE_LONGBOW = "Longbow, composite";
  private static final String WEAPON_FAMILIY_COMPOSITE_SHORTBOW = "Shortbow, composite";
  private static final String WEAPON_FAMILIY_RAPIER = "Rapier";
  private static final String WEAPON_FAMILIY_WHIP = "Whip";
  private static final String WEAPON_FAMILIY_CHAIN_SPIKED = "Chain, spiked";

  /**
   * Returns the modifier of the given attribute value. Negative attribute values are not allowed.
   *
   * @see com.d20charactersheet.framework.boc.service.RuleService#getModifier(int)
   */
  @Override
  public int getModifier(final int value) {
    if (value < 0) {
      throw new IllegalArgumentException("No negative attribute value allowed");
    }
    return value / 2 - 5;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getBaseAttackBonus(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getBaseAttackBonus(final Character character) {
    int baseAttackBonus = 0;
    for (final ClassLevel classLevel : character.getClassLevels()) {
      switch (classLevel.getCharacterClass().getBaseAttackBonus()) {

        case GOOD:
          baseAttackBonus += getGoodBaseAttackBonus(classLevel.getLevel());
          break;

        case AVERAGE:
          baseAttackBonus += getAverageBaseAttackBonus(classLevel.getLevel());
          break;

        case POOR:
          baseAttackBonus += getPoorBaseAttackBonus(classLevel.getLevel());
          break;

        default:
          throw new IllegalArgumentException("Can't determine base attack bonus of class: " + classLevel.getCharacterClass());
      }
    }
    return baseAttackBonus;
  }

  int getGoodBaseAttackBonus(final int level) {
    return level;
  }

  int getAverageBaseAttackBonus(final int level) {
    return (level - 1) - ((level - 1) / 4);
  }

  int getPoorBaseAttackBonus(final int level) {
    return level / 2;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getInitative(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getInitative(final Character character) {
    return getModifier(character.getDexterity()) + character.getInitiativeModifier();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSpeed(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getSpeed(final Character character) {
    final int speed = character.getRace().getBaseLandSpeed();
    return speed;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getArmorClass(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getArmorClass(final Character character) {
    int armorBonus = calculateArmorBonus(character.getEquippedItems());
    return 10 + getModifier(character.getDexterity()) + armorBonus + character.getArmorClass();
  }

  private int calculateArmorBonus(List<Item> equippedItems) {
    return equippedItems.stream().
        filter(item -> item instanceof Armor).
        mapToInt(item -> ((Armor) item).getArmorBonus()).
        sum();
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getOppositeOfCharacterClasses(com.d20charactersheet.framework.boc.model.Character, java.util.List)
   */
  @Override
  public List<CharacterClass> getOppositeOfCharacterClasses(final Character character, final List<CharacterClass> allClasses) {
    final List<CharacterClass> characterClasses = getCharacterClasses(character);
    final List<CharacterClass> oppositeClasses = new ArrayList<>();
    for (final CharacterClass characterClass : allClasses) {
      if (!characterClasses.contains(characterClass)) {
        oppositeClasses.add(characterClass);
      }

    }
    return oppositeClasses;
  }

  private List<CharacterClass> getCharacterClasses(final Character character) {
    final List<CharacterClass> characterClasses = new LinkedList<>();
    for (final ClassLevel classLevel : character.getClassLevels()) {
      characterClasses.add(classLevel.getCharacterClass());
    }
    return characterClasses;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#isTrained(com.d20charactersheet.framework.boc.model.CharacterSkill)
   */
  public boolean isTrained(final CharacterSkill characterSkill) {
    if (characterSkill.getSkill().isUntrained() || characterSkill.getRank() > 0) {
      return true;
    }
    return false;
  }

  int getAbilityBonus(final Character character) {
    int abilityBonus = 0;
    for (final Ability ability : character.getActiveAbilities()) {
      if (ability instanceof ExtraSkillPointsAbility) {
        final ExtraSkillPointsAbility extraSkillPointsAbility = (ExtraSkillPointsAbility) ability;
        abilityBonus += extraSkillPointsAbility.getSkillPoints();
      }
    }
    return abilityBonus;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getAttributeModifier(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.Attribute)
   */
  @Override
  public int getAttributeModifier(final Character character, final Attribute attribute) {
    switch (attribute) {
      case STRENGTH:
        return getModifier(character.getStrength());
      case DEXTERITY:
        return getModifier(character.getDexterity());
      case CONSTITUTION:
        return getModifier(character.getConstitution());
      case INTELLIGENCE:
        return getModifier(character.getIntelligence());
      case WISDOM:
        return getModifier(character.getWisdom());
      case CHARISMA:
        return getModifier(character.getCharisma());
      default:
        throw new IllegalStateException("Can't determine modifier of attribute: " + attribute);
    }
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#rollSkill(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.CharacterSkill)
   */
  @Override
  public DieRoll rollSkill(final Character character, final CharacterSkill characterSkill) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getSkillModifier(character, characterSkill));
    return dieRoll;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSave(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.Save)
   */
  @Override
  public int getSave(final Character character, final Save save) {
    final int baseSave = getBaseSave(character, save);
    final int attributeModifier = getSaveAttributeModifier(character, save);
    final int modifier = getSaveModifier(character, save);
    final int saveModifier = baseSave + attributeModifier + modifier;
    return saveModifier;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getBaseSave(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.Save)
   */
  @Override
  public int getBaseSave(final Character character, final Save save) {
    int baseSave = 0;
    for (final ClassLevel classLevel : character.getClassLevels()) {
      baseSave += getBaseSave(classLevel, save);
    }
    return baseSave;
  }

  int getBaseSave(final ClassLevel classLevel, final Save save) {
    final EnumSet<Save> saves = classLevel.getCharacterClass().getSaves();
    if (saves.contains(save)) {
      return getGoodSave(classLevel.getLevel());
    }
    return getPoorSave(classLevel.getLevel());
  }

  int getGoodSave(final int level) {
    return 2 + (level / 2);
  }

  int getPoorSave(final int level) {
    return level / 3;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSaveAttributeModifier(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.Save)
   */
  @Override
  public int getSaveAttributeModifier(final Character character, final Save save) {
    switch (save) {
      case FORTITUDE:
        return getModifier(character.getConstitution());

      case REFLEX:
        return getModifier(character.getDexterity());

      case WILL:
        return getModifier(character.getWisdom());

      default:
        throw new IllegalStateException("Can't determine attribute of save: " + save);
    }
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getSaveModifier(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.Save)
   */
  @Override
  public int getSaveModifier(final Character character, final Save save) {
    switch (save) {
      case FORTITUDE:
        return character.getFortitudeModifier();

      case REFLEX:
        return character.getReflexModifier();

      case WILL:
        return character.getWillModifier();

      default:
        throw new IllegalStateException("Can't determine modifier of save: " + save);
    }
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#isClassSkill(com.d20charactersheet.framework.boc.model.Character, com.d20charactersheet.framework.boc.model.Skill)
   */
  @Override
  public boolean isClassSkill(final Character character, final Skill skill) {
    for (final ClassLevel classLevel : character.getClassLevels()) {
      final List<Skill> classSkills = classLevel.getCharacterClass().getSkills();
      if (classSkills.contains(skill)) {
        return true;
      }
    }
    return false;
  }

  /**
   * @see com.d20charactersheet.framework.boc.service.RuleService#getNumberOfFeats(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public int getNumberOfFeats(final Character character) {
    return getNumberOfClassFeats(character) + getNumberOfAbilityFeats(character);
  }

  protected abstract int getNumberOfClassFeats(final Character character);

  private int getNumberOfAbilityFeats(final Character character) {
    int numberOfAbilityFeats = 0;
    for (final Ability ability : character.getActiveAbilities()) {
      if (ability instanceof ExtraFeatsAbility) {
        final ExtraFeatsAbility extaFeatAbility = (ExtraFeatsAbility) ability;
        numberOfAbilityFeats += extaFeatAbility.getNumberOfFeats();
      }
    }
    return numberOfAbilityFeats;
  }

  /**
   * The gold is the sum of all platinum, gold, silver and copper coins of the character. 1 platiumn = 10 gold = 100
   * silver = 1000 copper.
   *
   * @see com.d20charactersheet.framework.boc.service.RuleService#getGold(com.d20charactersheet.framework.boc.model.Character)
   */
  @Override
  public float getGold(final Character character) {
    final Money money = character.getMoney();
    final float gold = money.getPlatinum() * 10 + money.getGold() //
        + money.getSilver() / 10.0f + money.getCopper() / 100.0f;
    return gold;
  }

  @Override
  public float getLoad(final Character character) {
    float load = 0.0f;
    for (final ItemGroup itemGroup : character.getEquipment().getItems()) {
      if (isCarriable(itemGroup.getItem())) {
        load += itemGroup.getItem().getWeight() * itemGroup.getNumber();
      }
    }
    return load;
  }

  private boolean isCarriable(final Item item) {
    if (item instanceof Good) {
      final Good good = (Good) item;
      if (good.getGoodType().equals(GoodType.MOUNT) || good.getGoodType().equals(GoodType.MOUNT_GEAR)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int getCombatManeuverBonus(final Character character) {
    // CMB = Base attack bonus + Strength modifier + special size modifier
    final int baseAttackBonus = getBaseAttackBonus(character);
    final int strengthModifier = getModifier(character.getStrength());
    final int specialSizeModifier = getSpecialSizeModifier(character.getRace().getSize());
    final int cmbModifer = character.getCmbModifier();
    final int combatManeuverBonus = baseAttackBonus + strengthModifier + specialSizeModifier + cmbModifer;
    return combatManeuverBonus;
  }

  public int getCombatManeuverDefence(final Character character) {
    // CMD = Base attack bonus + Strength modifier + Dexterity modifier + special size modifier
    final int baseAttackBonus = getBaseAttackBonus(character);
    final int strengthModifier = getModifier(character.getStrength());
    final int dexterityModifier = getModifier(character.getDexterity());
    final int specialSizeModifier = getSpecialSizeModifier(character.getRace().getSize());
    final int cmdModifer = character.getCmdModifier();
    final int combatManeuverDefence =
        10 + baseAttackBonus + strengthModifier + dexterityModifier + specialSizeModifier + cmdModifer;
    return combatManeuverDefence;
  }

  public abstract int getSpecialSizeModifier(final Size size);

  public WeaponAttack calculateWeaponAttack(final Character character, final WeaponAttack weaponAttack) {
    weaponAttack.setAttackBonuses(getAttackBonuses(character, weaponAttack));
    weaponAttack.setDamageBonus(
        getDamageBonus(weaponAttack, getAttributeModifier(character, Attribute.STRENGTH), character.getCharacterFeats()));
    return weaponAttack;
  }

  List<Integer> getAttackBonuses(final Character character, final WeaponAttack weaponAttack) {
    final Weapon weapon = weaponAttack.getWeapon();
    final int baseAttackBonus = getBaseAttackBonus(character);
    final int attributeBonus = calculateAttributeModifier(character, weapon);
    final int enhancementBonus = getAttackEnhancementBonus(weapon);
    final int featBonus = getFeatAttackBonus(character, weaponAttack);
    final int attackBonusModifier = weaponAttack.getAttackBonusModifier();

    final List<Integer> baseAttackBonuses;
    if (AttackWield.OFF_HAND.equals(weaponAttack.getAttackWield())) {
      baseAttackBonuses = getAttackBonusesOffHand(character.getCharacterFeats(), baseAttackBonus, enhancementBonus, attributeBonus,
                                                  featBonus, attackBonusModifier);
    } else {
      baseAttackBonuses = new LinkedList<>();
      int bab = baseAttackBonus;
      do {
        final int attackBonus = bab + enhancementBonus + attributeBonus + featBonus + attackBonusModifier;
        baseAttackBonuses.add(attackBonus);
        bab = bab - 5;
      } while (bab > 0);
    }
    return baseAttackBonuses;
  }

  private List<Integer> getAttackBonusesOffHand(final List<CharacterFeat> characterFeats, final int baseAttackBonus,
      final int enhancementBonus, final int attributeBonus, final int featBonus, final int attackBonusModifier) {
    final List<Integer> baseAttackBonuses = new LinkedList<>();

    // 1st attack
    final int attackBonus = baseAttackBonus + enhancementBonus + attributeBonus + featBonus + attackBonusModifier;
    baseAttackBonuses.add(attackBonus);

    // 2nd attack
    if (isCharacterFeat(FEAT_IMPROVED_TWO_WEAPON_FIGHTING, characterFeats)) {
      baseAttackBonuses.add(attackBonus - 5);
    }

    // 3rd attack
    if (isCharacterFeat(FEAT_GREATER_TWO_WEAPON_FIGHTING, characterFeats)) {
      baseAttackBonuses.add(attackBonus - 10);
    }

    return baseAttackBonuses;
  }

  private int getAttackEnhancementBonus(final Weapon weapon) {
    int enhancementBonus;
    switch (weapon.getQualityType()) {
      case NORMAL:
        enhancementBonus = 0;
        break;

      case MASTERWORK:
        enhancementBonus = 1;
        break;

      case MAGIC:
        enhancementBonus = weapon.getEnhancementBonus();
        break;

      default:
        enhancementBonus = 0;
        break;
    }
    return enhancementBonus;
  }

  private int getFeatAttackBonus(final Character character, final WeaponAttack weaponAttack) {
    final List<CharacterFeat> characterFeats = character.getCharacterFeats();
    final Weapon weapon = weaponAttack.getWeapon();

    final int twoWeaponFighting = getTwoWeaponFighting(weaponAttack.getAttackWield(), weapon, characterFeats);
    final int weaponFocus = getWeaponFocus(characterFeats, weapon);

    final int featBonus = twoWeaponFighting + weaponFocus;
    return featBonus;
  }

  int getTwoWeaponFighting(final AttackWield attackWield, final Weapon weapon, final List<CharacterFeat> characterFeats) {
    int bonus;
    switch (attackWield) {
      case OFF_HAND:
        bonus = -10;
        if (isLightOrDoubleWeapon(weapon)) {
          bonus = bonus + 2;
        }
        if (isCharacterFeat(FEAT_TWO_WEAPON_FIGHTING, characterFeats)) {
          bonus = bonus + 6;
        }
        break;

      case PRIMARY_HAND:
        bonus = -6;
        if (isLightOrDoubleWeapon(weapon)) {
          bonus = bonus + 2;
        }
        if (isCharacterFeat(FEAT_TWO_WEAPON_FIGHTING, characterFeats)) {
          bonus = bonus + 2;
        }
        break;

      case PRIMARY_HAND_LIGHT_OFF_HAND:
        bonus = -4;
        if (isCharacterFeat(FEAT_TWO_WEAPON_FIGHTING, characterFeats)) {
          bonus = bonus + 2;
        }
        break;

      default:
        bonus = 0;
    }
    return bonus;
  }

  private boolean isLightOrDoubleWeapon(final Weapon weapon) {
    if (WeaponEncumbrance.LIGHT_HANDED.equals(weapon.getWeaponEncumbrance()) //
        || WeaponCategory.DOUBLE_WEAPON.equals(weapon.getWeaponCategory())) {
      return true;
    }
    return false;
  }

  int calculateAttributeModifier(final Character character, final Weapon weapon) {
    int bonus;
    switch (weapon.getCombatType()) {
      case MELEE_WEAPON:
        if (isFinesseWeapon(weapon) //
            && character.getDexterity() > character.getStrength() //
            && isCharacterFeat(FEAT_WEAPON_FINESSE, character.getCharacterFeats())) {
          bonus = getAttributeModifier(character, Attribute.DEXTERITY);
        } else {
          bonus = getAttributeModifier(character, Attribute.STRENGTH);
        }
        break;

      case RANGED_WEAPON:
        bonus = getAttributeModifier(character, Attribute.DEXTERITY);
        break;

      default:
        bonus = 0;
        break;
    }
    return bonus;
  }

  private boolean isFinesseWeapon(final Weapon weapon) {
    // With a light weapon, rapier, whip, or spiked chain made for a creature of your size category,
    // you may use your Dexterity modifier instead of your Strength modifier on attack rolls.
    if (WeaponEncumbrance.LIGHT_HANDED.equals(weapon.getWeaponEncumbrance()) //
        || isWeaponFamily(weapon, WEAPON_FAMILIY_RAPIER) //
        || isWeaponFamily(weapon, WEAPON_FAMILIY_WHIP) //
        || isWeaponFamily(weapon, WEAPON_FAMILIY_CHAIN_SPIKED)) {
      return true;
    }
    return false;
  }

  private boolean isCharacterFeat(final String featname, final List<CharacterFeat> characterFeats) {
    for (final CharacterFeat characterFeat : characterFeats) {
      if (characterFeat.getFeat().getName().equalsIgnoreCase(featname)) {
        return true;
      }
    }
    return false;
  }

  int getWeaponFocus(final List<CharacterFeat> characterFeats, final Weapon weapon) {
    int bonus = 0;
    for (final CharacterFeat characterFeat : characterFeats) {
      final String featname = characterFeat.getFeat().getName();
      if ((featname.equalsIgnoreCase(FEAT_WEAPON_FOCUS) || featname.equalsIgnoreCase(FEAT_GREATER_WEAPON_FOCUS)) //
          && characterFeat.getCategory().equalsIgnoreCase(weapon.getWeaponFamily().getName())) {
        bonus = bonus + 1;
      }
    }
    return bonus;
  }

  Damage getDamage(final Damage weaponDamage) {
    final Damage attackDamage = new Damage(weaponDamage.getNumberOfDice(), weaponDamage.getDie());
    return attackDamage;
  }

  int getDamageBonus(final WeaponAttack weaponAttack, final int strengthModifier, final List<CharacterFeat> characterFeats) {
    final Weapon weapon = weaponAttack.getWeapon();
    final int strengthBonus = getWeaponStrengthBonus(weapon, weaponAttack.getAttackWield(), strengthModifier);
    final int enhancementBonus = weaponAttack.getWeapon().getEnhancementBonus();
    final int featBonus = getFeatDamageBonus(characterFeats, weapon);
    final int damageBonusModifier = weaponAttack.getDamageBonusModifier();

    final int damageBonus = enhancementBonus + strengthBonus + featBonus + damageBonusModifier;
    return damageBonus;
  }

  int getWeaponStrengthBonus(final Weapon weapon, final AttackWield attackWield, final int strengthModifier) {
    int bonus;
    if (CombatType.MELEE_WEAPON.equals(weapon.getCombatType())) {
      bonus = getMeleeWeaponStrengthBonus(weapon, attackWield, strengthModifier);
    } else {
      bonus = getRangedWeaponStrengthBonus(weapon, strengthModifier);
    }
    return bonus;

  }

  int getMeleeWeaponStrengthBonus(final Weapon weapon, final AttackWield attackWield, final int strengthModifier) {
    switch (attackWield) {

      case OFF_HAND:
        // AttackWield.OFF_HAND: +(Str-Mod / 2), if you have a Strength penalty, the entire penalty applies.
        if (strengthModifier > 0) {
          return strengthModifier / 2;
        }
        return strengthModifier;

      case PRIMARY_HAND:
        // AttackWield.PRIMARY_HAND: +Str-Mod
      case PRIMARY_HAND_LIGHT_OFF_HAND:
        // AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND: +Str-Mod
      case ONE_HAND:
        // AttackWield.ONE_HAND: +Str-Mod
        return strengthModifier;

      case TWO_HANDED:
        // AttackWield.TWO_HAND: +(Str-Mod * 1,5), Strength penalty is not multipied,
        // Extra strenth bonus not for WeaponEncumbrance.LIGHT
        if (WeaponEncumbrance.LIGHT_HANDED.equals(weapon.getWeaponEncumbrance())) {
          return strengthModifier;
        }
        if (strengthModifier > 0) {
          return strengthModifier * 3 / 2;
        }
        return strengthModifier;

      default:
        return 0;
    }
  }

  int getRangedWeaponStrengthBonus(final Weapon weapon, final int strengthModifier) {
    int bonus;

    switch (weapon.getWeaponCategory()) {
      case THROWN_WEAPON:
        bonus = strengthModifier;
        break;

      case PROJECTILE_WEAPON:
        if (isWeaponFamily(weapon, WEAPON_FAMILIY_SLING)) {
          // Sling gets Str-Mod
          bonus = strengthModifier;
        } else if (isBow(weapon) && strengthModifier < 0) {
          // Bow gets Str-Penalty only
          bonus = strengthModifier;
        } else if (isCompositeBow(weapon)) {
          // Composite Bow gets Str-Mod
          bonus = strengthModifier;
        } else {
          bonus = 0;
        }
        break;

      default:
        bonus = 0;
        break;
    }
    return bonus;
  }

  private boolean isBow(final Weapon weapon) {
    final String weaponFamily = weapon.getWeaponFamily().getName();
    if (weaponFamily.equalsIgnoreCase(WEAPON_FAMILIY_LONGBOW) //
        || weaponFamily.equalsIgnoreCase(WEAPON_FAMILIY_SHORTBOW)) {
      return true;
    }
    return false;
  }

  private boolean isWeaponFamily(final Weapon weapon, final String weaponFamilyName) {
    if (weapon.getWeaponFamily().getName().equalsIgnoreCase(weaponFamilyName)) {
      return true;
    }
    return false;
  }

  private boolean isCompositeBow(final Weapon weapon) {
    final String weaponFamily = weapon.getWeaponFamily().getName();
    if (weaponFamily.equalsIgnoreCase(WEAPON_FAMILIY_COMPOSITE_LONGBOW) //
        || weaponFamily.equalsIgnoreCase(WEAPON_FAMILIY_COMPOSITE_SHORTBOW)) {
      return true;
    }
    return false;
  }

  int getFeatDamageBonus(final List<CharacterFeat> characterFeats, final Weapon weapon) {
    int bonus = 0;
    for (final CharacterFeat characterFeat : characterFeats) {
      final String featname = characterFeat.getFeat().getName();
      if ((featname.equalsIgnoreCase(FEAT_WEAPON_SPECIALIZATION) || featname.equalsIgnoreCase(FEAT_GREATER_WEAPON_SPECIALIZATION))
          && characterFeat.getCategory().equalsIgnoreCase(weapon.getWeaponFamily().getName())) {
        bonus = bonus + 2;
      }
    }
    return bonus;
  }

  Critical getCritical(final Critical weaponCritical) {
    final Critical attackCritical = new Critical(weaponCritical.getHit(), weaponCritical.getMultiplier());
    return attackCritical;
  }

  @Override
  public DieRoll rollAttack(final int attackBonus) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(attackBonus);
    return dieRoll;
  }

  @Override
  public DieRoll rollDamage(final Damage damage, final int bonus) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(damage.getDie());
    final int[] rolls = new int[damage.getNumberOfDice()];
    for (int i = 0; i < damage.getNumberOfDice(); i++) {
      rolls[i] = damage.getDie().roll();
    }
    dieRoll.setRolls(rolls);
    dieRoll.setBonus(bonus);
    return dieRoll;
  }

  @Override
  public DieRoll rollCritical(final Damage damage, final int bonus, final Critical critical) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(damage.getDie());
    final int numberOfDice = damage.getNumberOfDice() * critical.getMultiplier();
    final int[] rolls = new int[numberOfDice];
    for (int i = 0; i < numberOfDice; i++) {
      rolls[i] = damage.getDie().roll();
    }
    dieRoll.setRolls(rolls);
    dieRoll.setBonus(bonus * critical.getMultiplier());
    return dieRoll;
  }

  @Override
  public boolean isCritical(final DieRoll dieRoll, final Critical critical) {
    if (dieRoll.getRolls()[0] >= critical.getHit()) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isFumble(final DieRoll dieRoll) {
    if (dieRoll.getRolls()[0] == 1) {
      return true;
    }
    return false;
  }

  public EnumSet<AttackWield> getAttackWields(final Weapon weapon) {
    EnumSet<AttackWield> attackWields = EnumSet.noneOf(AttackWield.class);
    if (WeaponCategory.DOUBLE_WEAPON.equals(weapon.getWeaponCategory())) {
      attackWields = EnumSet.of(AttackWield.OFF_HAND, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, AttackWield.TWO_HANDED);
    } else {
      if (CombatType.MELEE_WEAPON.equals(weapon.getCombatType())) {
        switch (weapon.getWeaponEncumbrance()) {
          case LIGHT_HANDED:
            attackWields = EnumSet.allOf(AttackWield.class);
            break;

          case ONE_HANDED:
            attackWields = EnumSet.allOf(AttackWield.class);
            break;

          case TWO_HANDED:
            attackWields = EnumSet.of(AttackWield.TWO_HANDED);
            break;

          default:
            attackWields = EnumSet.noneOf(AttackWield.class);
            break;
        }
      } else {
        switch (weapon.getWeaponEncumbrance()) {

          case LIGHT_HANDED:
            attackWields = EnumSet.of(AttackWield.ONE_HAND, AttackWield.TWO_HANDED);
            break;

          case ONE_HANDED:
            attackWields = EnumSet.of(AttackWield.ONE_HAND, AttackWield.TWO_HANDED);
            break;

          case TWO_HANDED:
            attackWields = EnumSet.of(AttackWield.TWO_HANDED);
            break;

          default:
            attackWields = EnumSet.noneOf(AttackWield.class);
            break;
        }
      }

    }
    return attackWields;
  }

  @Override
  public DieRoll rollAttribute(final Character character, final Attribute attribute) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getAttributeModifier(character, attribute));
    return dieRoll;
  }

  @Override
  public DieRoll rollSave(final Character character, final Save save) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getSave(character, save));
    return dieRoll;
  }

  @Override
  public DieRoll rollInitative(final Character character) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getInitative(character));
    return dieRoll;
  }

  @Override
  public DieRoll rollBaseAttackBonus(final Character character) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getBaseAttackBonus(character));
    return dieRoll;
  }

  @Override
  public DieRoll rollCombatManeuverBonus(final Character character) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getCombatManeuverBonus(character));
    return dieRoll;
  }

  @Override
  public DieRoll rollCombatManeuverDefence(final Character character) {
    final DieRoll dieRoll = new DieRoll();
    dieRoll.setDie(Die.D20);
    dieRoll.setRolls(new int[] {Die.D20.roll()});
    dieRoll.setBonus(getCombatManeuverDefence(character));
    return dieRoll;
  }

  @Override
  public int getMaxSpelllevel(final Character character, final SpelllistAbility spelllistAbility) {
    final Attribute attribute = spelllistAbility.getSpellAttribute();
    final int attributeValue = character.getAttribute(attribute);
    return Math.max(attributeValue - 10, 0);
  }

  @Override
  public int getNumberOfKnownSpells(final Character character, final SpelllistAbility spelllistAbility, final int spellLevel) {

    // check max spell level
    if (spellLevel > getMaxSpelllevel(character, spelllistAbility)) {
      return 0;
    }

    // check current max spell level
    if (spellLevel > getCurrentMaxSpelllevel(character, spelllistAbility)) {
      return 0;
    }

    final SpellSource spellSource = spelllistAbility.getSpellSource();
    final CastingType castingType = spelllistAbility.getCastingType();
    if (SpellSource.DIVINE.equals(spellSource) //
        || (SpellSource.ARCANE.equals(spellSource) && CastingType.PREPARED.equals(castingType))) {
      // all spells of spell level are known
      final Spelllist spelllist = spelllistAbility.getSpelllist();
      return spelllist.getSpellsOfLevel(spellLevel).size();
    }
    // read from spells known table
    final KnownSpellsTable knownSpellsTable = spelllistAbility.getKnownSpellsTable();
    final int spellcasterLevel = getSpellcasterLevel(character, spelllistAbility);
    return knownSpellsTable.getKnownSpells(spellcasterLevel, spellLevel);
  }

  private int getCurrentMaxSpelllevel(final Character character, final SpelllistAbility spelllistAbility) {
    final int spellcasterLevel = getSpellcasterLevel(character, spelllistAbility);
    int currentMaxSpelllevel = 0;
    final SpellsPerDayTable spellsPerDayTable = spelllistAbility.getSpellsPerDayTable();
    final Spelllist spelllist = spelllistAbility.getSpelllist();
    for (int i = spelllist.getMinLevel(); i <= spelllist.getMaxLevel(); i++) {
      if (spellsPerDayTable.getSpellsPerDay(spellcasterLevel, i) != SpellsPerDayTable.NO_ACCESS) {
        currentMaxSpelllevel = i;
      }
    }
    return currentMaxSpelllevel;
  }

  @Override
  public int getSpellcasterLevel(final Character character, final SpelllistAbility spelllistAbility) {
    final CharacterClass clazz = getClassOfAbility(character, spelllistAbility);
    final int level = getLevelOfClass(character, clazz);
    return level;
  }

  private CharacterClass getClassOfAbility(final Character character, final Ability ability) {
    for (final ClassLevel classLevel : character.getClassLevels()) {
      for (final CharacterAbility characterAbility : classLevel.getCharacterAbilities()) {
        if (characterAbility.getClassAbility().getAbility().equals(ability)) {
          return classLevel.getCharacterClass();
        }
      }
    }
    throw new IllegalArgumentException("Can't find class of abilitiy: " + ability);
  }

  private int getLevelOfClass(final Character character, final CharacterClass clazz) {
    for (final ClassLevel classLevel : character.getClassLevels()) {
      if (classLevel.getCharacterClass().equals(clazz)) {
        return classLevel.getLevel();
      }
    }
    throw new IllegalArgumentException("Can't find level of class: " + clazz);
  }

  @Override
  public List<SpellSlot> calculateSpellSlots(final Character character) {
    final List<SpellSlot> spellSlots = new ArrayList<>();
    for (final SpelllistAbility spelllistAbility : character.getSpelllistAbilities()) {
      calculateSpellSlots(character, spelllistAbility, spellSlots);
    }

    fillSpellSlots(character, spellSlots);

    return spellSlots;
  }

  private List<SpellSlot> calculateSpellSlots(final Character character, final SpelllistAbility spelllistAbility,
      final List<SpellSlot> spellSlots) {
    final int spellCasterLevel = getSpellcasterLevel(character, spelllistAbility);

    // get slots of spells per day table
    createSpellsPerDaySlots(spelllistAbility, spellCasterLevel, spellSlots);

    // get slots of attribute bonus
    createAttributeBonusSlots(character, spelllistAbility, spellSlots);

    return spellSlots;
  }

  void createSpellsPerDaySlots(final SpelllistAbility spelllistAbility, final int spellCasterLevel,
      final List<SpellSlot> spellSlots) {
    final Spelllist spelllist = spelllistAbility.getSpelllist();
    for (int spellLevel = spelllist.getMinLevel(); spellLevel <= spelllist.getMaxLevel(); spellLevel++) {
      createEmptySpellSlots(spelllistAbility, spellCasterLevel, spellLevel, spellSlots);
    }
  }

  private void createEmptySpellSlots(final SpelllistAbility spelllistAbility, final int spellCasterLevel, final int spellLevel,
      final List<SpellSlot> spellSlots) {
    final SpellsPerDayTable spellsPerDayTable = spelllistAbility.getSpellsPerDayTable();
    final int spellsPerDay = spellsPerDayTable.getSpellsPerDay(spellCasterLevel, spellLevel);

    for (int i = 0; i < spellsPerDay; i++) {
      if (spelllistAbility.getSpelllist().isDomain()) {
        createEmptyDomainSpellSlot(spelllistAbility, spellLevel, spellSlots);
      } else {
        createEmptySpellSlot(spelllistAbility, spellLevel, spellSlots);
      }
    }
  }

  private void createEmptyDomainSpellSlot(final SpelllistAbility spelllistAbility, final int spellLevel,
      final List<SpellSlot> spellSlots) {
    final SpellSlot domainSpellSlot = getDomainSpellSlot(spellSlots, spellLevel);
    if (domainSpellSlot == null) {
      final SpellSlot spellSlot = new SpellSlot();
      spellSlot.addSpelllistAbility(spelllistAbility);
      spellSlot.setLevel(spellLevel);
      spellSlots.add(spellSlot);
    } else {
      domainSpellSlot.addSpelllistAbility(spelllistAbility);
    }
  }

  private SpellSlot getDomainSpellSlot(final List<SpellSlot> spellSlots, final int spellLevel) {
    for (final SpellSlot spellSlot : spellSlots) {
      if (spellSlot.getLevel() == spellLevel && spellSlot.isDomain()) {
        return spellSlot;
      }
    }
    return null;
  }

  private void createEmptySpellSlot(final SpelllistAbility spelllistAbility, final int spellLevel,
      final List<SpellSlot> spellSlots) {
    final SpellSlot spellSlot = new SpellSlot();
    spellSlot.addSpelllistAbility(spelllistAbility);
    spellSlot.setLevel(spellLevel);
    spellSlots.add(spellSlot);
  }

  void createAttributeBonusSlots(final Character character, final SpelllistAbility spelllistAbility,
      final List<SpellSlot> spellSlots) {
    if (spelllistAbility.isAttributeBonusSpellSlots()) {
      final int attributeValue = character.getAttribute(spelllistAbility.getSpellAttribute());
      final int modifier = getModifier(attributeValue);
      final int currentMaxSpelllevel = getCurrentMaxSpelllevel(character, spelllistAbility);
      final Spelllist spelllist = spelllistAbility.getSpelllist();
      for (int spellLevel = spelllist.getMinLevel(); spellLevel <= currentMaxSpelllevel; spellLevel++) {
        final int attributeBonusSlots = getAttributeBonusSlots(modifier, spellLevel);
        for (int i = 0; i < attributeBonusSlots; i++) {
          createEmptySpellSlot(spelllistAbility, spellLevel, spellSlots);
        }
      }
    }
  }

  int getAttributeBonusSlots(final int modifier, final int spellLevel) {
    if (modifier <= 0) {
      return 0;
    }

    if (spellLevel == 0) {
      return 0;
    }

    int attributeBonusSlots = modifier - ((3 * modifier + spellLevel - 1) / 4);

    if (attributeBonusSlots < 0) {
      attributeBonusSlots = 0;
    }

    return attributeBonusSlots;
  }

  private void fillSpellSlots(final Character character, final List<SpellSlot> spellSlots) {
    final List<SpellSlot> characterSpellSlots = new ArrayList<>(character.getSpellSlots());
    for (final SpellSlot spellSlot : spellSlots) {
      fillSpellSlot(spellSlot, characterSpellSlots);
    }
  }

  private void fillSpellSlot(final SpellSlot spellSlot, final List<SpellSlot> characterSpellSlots) {
    for (final SpellSlot characterSpellSlot : characterSpellSlots) {
      if (equals(spellSlot, characterSpellSlot)) {
        spellSlot.setId(characterSpellSlot.getId());
        spellSlot.setCast(characterSpellSlot.isCast());
        spellSlot.setSpell(characterSpellSlot.getSpell());
        spellSlot.setSpelllistAbilities(characterSpellSlot.getSpelllistAbilities());
        spellSlot.setMetamagicFeats(characterSpellSlot.getMetamagicFeats());
        characterSpellSlots.remove(characterSpellSlot);
        return;
      }
    }
  }

  private boolean equals(final SpellSlot spellSlot, final SpellSlot characterSpellSlot) {
    if (spellSlot.getLevel() == characterSpellSlot.getLevel() && equals(spellSlot.getSpelllistAbilities(),
                                                                        characterSpellSlot.getSpelllistAbilities())) {
      return true;
    }
    return false;
  }

  private boolean equals(final List<SpelllistAbility> spelllistAbilities,
      final List<SpelllistAbility> characterSpelllistAbilities) {
    if (spelllistAbilities.size() != characterSpelllistAbilities.size()) {
      return false;
    }
    for (final SpelllistAbility spelllistAbility : spelllistAbilities) {
      if (!characterSpelllistAbilities.contains(spelllistAbility)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<Spell> getSpellSelection(final Character character, final SpellSlot spellSlot) {
    final List<Spell> spellSelectionOfLevel = getSpellSelectionOfLevel(character, spellSlot);
    final List<Spell> spellSelection = getSpellSelectionOfSchool(spellSelectionOfLevel, spellSlot);
    return spellSelection;
  }

  private List<Spell> getSpellSelectionOfLevel(final Character character, final SpellSlot spellSlot) throws RuleException {
    final List<Spell> spellSelection = new ArrayList<>();
    final List<Spelllist> spelllists = spellSlot.getSpelllists();
    for (final Spelllist spelllist : spelllists) {
      final List<KnownSpell> knownSpells = character.getKnownSpells(spelllist);
      final int spellLevel = getSpellLevel(spellSlot);
      final List<Spell> spellsOfLevel = getSpellsOfLevel(spelllist.getSpellsOfLevel(spellLevel), knownSpells);
      spellSelection.addAll(spellsOfLevel);
    }
    return spellSelection;
  }

  private int getSpellLevel(final SpellSlot spellSlot) throws RuleException {
    int spellLevel = spellSlot.getLevel();
    for (final Feat feat : spellSlot.getMetamagicFeats()) {
      spellLevel = spellLevel - feat.getSpellSlot();
    }
    if (spellLevel < 0) {
      throw new RuleException(RuleError.NEGATIVE_SPELL_LEVEL, spellLevel);
    }
    return spellLevel;
  }

  private List<Spell> getSpellSelectionOfSchool(final List<Spell> spellSelectionOfLevel, final SpellSlot spellSlot) {
    if (EnumSet.allOf(School.class).equals(spellSlot.getSchools())) {
      return spellSelectionOfLevel;
    }

    final List<Spell> spellSelection = new LinkedList<>();
    for (final Spell spell : spellSelectionOfLevel) {
      if (spellSlot.getSchools().contains(spell.getSchool())) {
        spellSelection.add(spell);
      }
    }
    return spellSelection;
  }

  private List<Spell> getSpellsOfLevel(final List<Spell> spelllistSpells, final List<KnownSpell> knownSpells) {
    final List<Spell> spellsOfLevel = new LinkedList<>();
    for (final KnownSpell knownSpell : knownSpells) {
      final Spell spell = knownSpell.getSpell();
      if (spelllistSpells.contains(spell)) {
        spellsOfLevel.add(spell);
      }
    }
    return spellsOfLevel;
  }

  @Override
  public int getSpellSaveDifficultyClass(final Character character, final SpellSlot spellSlot) {
    final SpelllistAbility spelllistAbility = findSpelllistAbilityOfSpell(spellSlot);
    final Spelllist spelllist = spelllistAbility.getSpelllist();
    final Attribute spellAttribute = spelllistAbility.getSpellAttribute();
    return getSpellSaveDifficultyClass(character, spellAttribute, spelllist, spellSlot.getSpell());
  }

  private SpelllistAbility findSpelllistAbilityOfSpell(final SpellSlot spellSlot) {
    final List<SpelllistAbility> spelllistAbilities = spellSlot.getSpelllistAbilities();
    if (spelllistAbilities.size() == 1) {
      return spelllistAbilities.get(0);
    }
    for (final SpelllistAbility spelllistAbility : spelllistAbilities) {
      final Spelllist spelllist = spelllistAbility.getSpelllist();
      if (spelllist.getAllSpells().contains(spellSlot.getSpell())) {
        return spelllistAbility;
      }
    }
    throw new IllegalStateException(
        "Can't find spell: " + spellSlot.getSpell() + " in spell lists of spell abilities: " + spelllistAbilities);
  }

  int getSpellSaveDifficultyClass(final Character character, final Attribute spellAttribute, final Spelllist spelllist,
      final Spell spell) {
    final int spellLevel = getSpelllevelOfSpell(spelllist, spell);
    final int attributeBonus = getAttributeModifier(character, spellAttribute);
    final int spellSaveDifficultyClass = 10 + spellLevel + attributeBonus;
    return spellSaveDifficultyClass;
  }

  private int getSpelllevelOfSpell(final Spelllist spelllist, final Spell spell) {
    final Map<Integer, List<Spell>> spellsByLevel = spelllist.getSpellsByLevel();
    for (final int level : spellsByLevel.keySet()) {
      final List<Spell> spells = spellsByLevel.get(level);
      if (spells.contains(spell)) {
        return level;
      }
    }
    throw new IllegalArgumentException("Can't find spell: " + spell + " in spell list " + spelllist);
  }

  @Override
  public List<SpellSlot> rest(final Character character) {
    final List<SpellSlot> spellSlots = new LinkedList<>();
    for (final SpellSlot spellSlot : character.getSpellSlots()) {
      if (spellSlot.isCast()) {
        spellSlot.setCast(false);
        if (CastingType.SPONTANEOUS.equals(spellSlot.getSpelllistAbilities().get(0).getCastingType())) {
          spellSlot.setSpell(SpellSlot.EMPTY_SPELL);
        }
        spellSlots.add(spellSlot);
      }
    }
    return spellSlots;
  }

  @Override
  public Body equipItem(Body body, BodyPart bodyPart, Item item) {
    switch (bodyPart) {
      case BOTH_HANDS:
        body.clear(BodyPart.OFF_HAND);
        body.clear(BodyPart.PRIMARY_HAND);
        break;
      case OFF_HAND:
      case PRIMARY_HAND:
        body.clear(BodyPart.BOTH_HANDS);
        break;
    }
    body.equip(bodyPart, item);
    return body;
  }
}
