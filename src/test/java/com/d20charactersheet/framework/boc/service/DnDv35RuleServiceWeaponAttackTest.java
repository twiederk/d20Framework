package com.d20charactersheet.framework.boc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.junit.Test;

import com.d20charactersheet.framework.boc.model.AttackWield;
import com.d20charactersheet.framework.boc.model.Character;
import com.d20charactersheet.framework.boc.model.CharacterFeat;
import com.d20charactersheet.framework.boc.model.Critical;
import com.d20charactersheet.framework.boc.model.Damage;
import com.d20charactersheet.framework.boc.model.Die;
import com.d20charactersheet.framework.boc.model.Feat;
import com.d20charactersheet.framework.boc.model.QualityType;
import com.d20charactersheet.framework.boc.model.Weapon;
import com.d20charactersheet.framework.boc.model.WeaponAttack;

public class DnDv35RuleServiceWeaponAttackTest extends DnDv35RuleServiceTestCase {

  @Test
  public void testBelvadorWithQuarterstaff() {
    WeaponAttack weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.TWO_HANDED);
    weaponAttack = ruleService.calculateWeaponAttack(belvador, weaponAttack);
    assertWeaponAttack(new int[] {2}, new Damage(1, Die.D6), 0, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testBelvadorWithCrossbowLight() {
    WeaponAttack weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(belvador, weaponAttack);
    assertWeaponAttack(new int[] {6}, new Damage(1, Die.D8), 0, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testBelvadorWithSilverDagger() {
    WeaponAttack weaponAttack = createWeaponAttack("Silver Dagger", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(belvador, weaponAttack);
    assertWeaponAttack(new int[] {3}, new Damage(1, Die.D4), 0, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testNascanWithWolfaxe() {
    WeaponAttack weaponAttack = createWeaponAttack("Battleaxe", AttackWield.ONE_HAND);
    weaponAttack.getWeapon()
        .setEnhancementBonus(2);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MAGIC);
    weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack);
    assertWeaponAttack(new int[] {9, 4}, new Damage(1, Die.D8), 3, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testNascanWithWolfaxeAndModifier() {
    WeaponAttack weaponAttack = createWeaponAttack("Battleaxe", AttackWield.ONE_HAND);
    weaponAttack.getWeapon()
        .setEnhancementBonus(2);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MAGIC);
    weaponAttack.setAttackBonusModifier(2);
    weaponAttack.setDamageBonusModifier(-2);
    weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack);
    assertWeaponAttack(new int[] {11, 6}, new Damage(1, Die.D8), 1, new Critical(20, 3), weaponAttack);

  }

  @Test
  public void testNascanWithHandaxePrimaryHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Handaxe", AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack);
    assertWeaponAttack(new int[] {7, 2}, new Damage(1, Die.D6), 1, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testNascanWithHandaxeOneHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Handaxe", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack);
    assertWeaponAttack(new int[] {9, 4}, new Damage(1, Die.D6), 1, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testNascanWithHandaxeOffHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Handaxe", AttackWield.OFF_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(nascan, weaponAttack);
    assertWeaponAttack(new int[] {7}, new Damage(1, Die.D6), 0, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testNyatarWithShortSword() {
    WeaponAttack weaponAttack = createWeaponAttack("Sword, short", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(nyatar, weaponAttack);
    assertWeaponAttack(new int[] {4}, new Damage(1, Die.D6), 1, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testNyatarWithCrossbowLight() {
    WeaponAttack weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(nyatar, weaponAttack);
    assertWeaponAttack(new int[] {7}, new Damage(1, Die.D8), 0, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testJadziaWithQuarterstaffPlusOneTwoHanded() {
    WeaponAttack weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.TWO_HANDED);
    weaponAttack.getWeapon()
        .setEnhancementBonus(1);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MAGIC);
    weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack);
    assertWeaponAttack(new int[] {4}, new Damage(1, Die.D6), 2, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testJadziaWithQuarterstaffPlusOnePrimaryHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND);
    weaponAttack.getWeapon()
        .setEnhancementBonus(1);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MAGIC);
    weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack);
    assertWeaponAttack(new int[] {2}, new Damage(1, Die.D6), 2, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testJadziaWithQuarterstaffPlusOneOffHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.OFF_HAND);
    weaponAttack.getWeapon()
        .setEnhancementBonus(1);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MAGIC);
    weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack);
    assertWeaponAttack(new int[] {2}, new Damage(1, Die.D6), 1, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testJadziaWithSling() {
    WeaponAttack weaponAttack = createWeaponAttack("Sling", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(jadzia, weaponAttack);
    assertWeaponAttack(new int[] {+4}, new Damage(1, Die.D4), 1, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testWorfWithGreataxe() {
    WeaponAttack weaponAttack = createWeaponAttack("Greataxe", AttackWield.TWO_HANDED);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MASTERWORK);
    weaponAttack = ruleService.calculateWeaponAttack(worf, weaponAttack);
    assertWeaponAttack(new int[] {+11}, new Damage(1, Die.D12), 7, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testRodrekrWithDwarvenWaraxe() {
    WeaponAttack weaponAttack = createWeaponAttack("Waraxe, dwarven", AttackWield.ONE_HAND);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MASTERWORK);
    weaponAttack = ruleService.calculateWeaponAttack(rodrekr, weaponAttack);
    assertWeaponAttack(new int[] {+11}, new Damage(1, Die.D10), 6, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testRodrekrWithCrossbowLight() {
    WeaponAttack weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(rodrekr, weaponAttack);
    assertWeaponAttack(new int[] {+7}, new Damage(1, Die.D8), 0, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testThoreWithDagger() {
    WeaponAttack weaponAttack = createWeaponAttack("Dagger", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack);
    assertWeaponAttack(new int[] {+8}, new Damage(1, Die.D4), 1, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testThoreWithShortSwordMasterworkPrimaryHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Sword, short", AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND);
    weaponAttack.getWeapon()
        .setQualityType(QualityType.MASTERWORK);
    weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack);
    assertWeaponAttack(new int[] {+8}, new Damage(1, Die.D6), 1, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testThoreWithShortSwordOffHand() {
    WeaponAttack weaponAttack = createWeaponAttack("Sword, short", AttackWield.OFF_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack);
    assertWeaponAttack(new int[] {+7}, new Damage(1, Die.D6), 0, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testThoreWithRapierOfPuncturing() {
    WeaponAttack weaponAttack = createWeaponAttack("Rapier of Puncturing", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack);
    assertWeaponAttack(new int[] {+10}, new Damage(1, Die.D6), 3, new Critical(18, 2), weaponAttack);
  }

  @Test
  public void testThoreWithCompositeLongbow() {
    WeaponAttack weaponAttack = createWeaponAttack("Longbow, composite", AttackWield.TWO_HANDED);
    weaponAttack = ruleService.calculateWeaponAttack(thore, weaponAttack);
    assertWeaponAttack(new int[] {+8}, new Damage(1, Die.D8), 1, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testKyraWithScimitar() {
    WeaponAttack weaponAttack = createWeaponAttack("Scimitar", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(kyra, weaponAttack);
    assertWeaponAttack(new int[] {+1}, new Damage(1, Die.D6), 1, new Critical(18, 2), weaponAttack);
  }

  @Test
  public void testKyraWithSling() {
    WeaponAttack weaponAttack = createWeaponAttack("Sling", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(kyra, weaponAttack);
    assertWeaponAttack(new int[] {-1}, new Damage(1, Die.D4), 1, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testMerisielWithRapier() {
    WeaponAttack weaponAttack = createWeaponAttack("Rapier", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(merisiel, weaponAttack);
    assertWeaponAttack(new int[] {+3}, new Damage(1, Die.D6), 1, new Critical(18, 2), weaponAttack);
  }

  @Test
  public void testEzrenWithQuaterstaff() {
    WeaponAttack weaponAttack = createWeaponAttack("Quarterstaff", AttackWield.TWO_HANDED);
    weaponAttack = ruleService.calculateWeaponAttack(ezren, weaponAttack);
    assertWeaponAttack(new int[] {+1}, new Damage(1, Die.D6), 1, new Critical(20, 2), weaponAttack);
  }

  @Test
  public void testEzrenWithCrossbowLight() {
    WeaponAttack weaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND);
    weaponAttack = ruleService.calculateWeaponAttack(ezren, weaponAttack);
    assertWeaponAttack(new int[] {+0}, new Damage(1, Die.D8), 0, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testValerosWithLongsword() {
    WeaponAttack weaponAttack = createWeaponAttack("Longsword", AttackWield.TWO_HANDED);
    weaponAttack = ruleService.calculateWeaponAttack(valeros, weaponAttack);
    assertWeaponAttack(new int[] {+5}, new Damage(1, Die.D8), 4, new Critical(19, 2), weaponAttack);
  }

  @Test
  public void testValerosWithShortBow() {
    WeaponAttack weaponAttack = createWeaponAttack("Shortbow", AttackWield.TWO_HANDED);
    weaponAttack = ruleService.calculateWeaponAttack(valeros, weaponAttack);
    assertWeaponAttack(new int[] {+3}, new Damage(1, Die.D6), 0, new Critical(20, 3), weaponAttack);
  }

  @Test
  public void testValerosWithLongswordAndModifier() {
    WeaponAttack weaponAttack = createWeaponAttack("Longsword", AttackWield.TWO_HANDED);
    weaponAttack.setAttackBonusModifier(1);
    weaponAttack.setDamageBonusModifier(1);
    weaponAttack = ruleService.calculateWeaponAttack(valeros, weaponAttack);
    assertWeaponAttack(new int[] {+6}, new Damage(1, Die.D8), 5, new Critical(19, 2), weaponAttack);

  }

  private WeaponAttack createWeaponAttack(final String weaponName, final AttackWield attackWield) {
    final Weapon quarterstaff = getWeaponByName(weaponName);

    final WeaponAttack weaponAttack = new WeaponAttack();
    weaponAttack.setWeapon(quarterstaff);
    weaponAttack.setAttackWield(attackWield);

    return weaponAttack;
  }

  private void assertWeaponAttack(final int[] attackBonuses, final Damage damage, final int damageBonus, final Critical critical,
      final WeaponAttack weaponAttack) {
    assertNotNull("AttackBonuses can't be null", weaponAttack.getAttackBonuses());
    assertEquals("Wrong number of attacks", attackBonuses.length, weaponAttack.getNumberOfAttacks());
    for (int i = 0; i < attackBonuses.length; i++) {
      assertEquals(i + ". attack bonus is wrong", attackBonuses[i], (int) weaponAttack.getAttackBonuses().get(i));
    }
    assertNotNull("Damage can't be null", weaponAttack.getDamage());
    assertEquals(damage, weaponAttack.getDamage());
    assertEquals("Wrong damage bonus", damageBonus, weaponAttack.getDamageBonus());
    assertNotNull("Critical can't be null", weaponAttack.getCritical());
    assertEquals(critical, weaponAttack.getCritical());
  }

  private Weapon getWeaponByName(final String name) {
    for (final Weapon weapon : gameSystem.getAllWeapons()) {
      if (weapon.getName().equals(name)) {
        return weapon;
      }
    }
    throw new IllegalArgumentException("Can't find weapon with name: " + name);
  }

  @Test
  public void testGetAttackBonusesMelee() {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;

    final WeaponAttack daggerWeaponAttack = createWeaponAttack("Dagger", AttackWield.ONE_HAND);

    Character character = createCharacter(fighter, 2);
    character.setStrength(12);
    assertAttackBonuses(new int[] {3}, dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack));

    character = createCharacter(fighter, 5);
    character.setStrength(12);
    assertAttackBonuses(new int[] {6}, dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack));

    character = createCharacter(fighter, 6);
    character.setStrength(12);
    assertAttackBonuses(new int[] {7, 2}, dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack));

    character = createCharacter(fighter, 10);
    character.setStrength(12);
    assertAttackBonuses(new int[] {11, 6}, dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack));

    character = createCharacter(fighter, 11);
    character.setStrength(12);
    assertAttackBonuses(new int[] {12, 7, 2}, dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack));

    // magical weapon with enhancement bonus
    final WeaponAttack daggerOfVenomWeaponAttack = createWeaponAttack("Dagger of Venom", AttackWield.ONE_HAND);

    character = createCharacter(fighter, 2);
    character.setStrength(12);
    assertAttackBonuses(new int[] {4}, dndv35RuleService.getAttackBonuses(character, daggerOfVenomWeaponAttack));

    character = createCharacter(fighter, 11);
    character.setStrength(12);
    assertAttackBonuses(new int[] {13, 8, 3}, dndv35RuleService.getAttackBonuses(character, daggerOfVenomWeaponAttack));

    // two-weapon fighting with primary hand
    final WeaponAttack longswordWeaponAttack = createWeaponAttack("Longsword", AttackWield.PRIMARY_HAND);

    character = createCharacter(fighter, 2);
    character.setStrength(12);
    assertAttackBonuses(new int[] {-3}, dndv35RuleService.getAttackBonuses(character, longswordWeaponAttack));

    // Feats
    // weapon finesse
    character = createCharacter(fighter, 2);
    character.setDexterity(12);
    character.setCharacterFeats(createCharacterFeat("Weapon Finesse"));
    assertAttackBonuses(new int[] {3}, dndv35RuleService.getAttackBonuses(character, daggerWeaponAttack));

    // weapon focus
    final WeaponAttack greatswordWeaponAttack = createWeaponAttack("Greatsword", AttackWield.TWO_HANDED);
    character = createCharacter(fighter, 2);
    character.setStrength(12);
    character.setCharacterFeats(createCharacterFeat("Weapon Focus", "Greatsword"));
    assertAttackBonuses(new int[] {4}, dndv35RuleService.getAttackBonuses(character, greatswordWeaponAttack));

    // greater weapon focus
    character = createCharacter(fighter, 2);
    character.setStrength(12);
    final List<CharacterFeat> characterFeats = createCharacterFeat("Weapon Focus", "Greatsword");
    characterFeats.addAll(createCharacterFeat("Greater Weapon Focus", "Greatsword"));
    character.setCharacterFeats(characterFeats);
    assertAttackBonuses(new int[] {5}, dndv35RuleService.getAttackBonuses(character, greatswordWeaponAttack));

    // masterwork
    character = createCharacter(fighter, 2);
    character.setStrength(12);
    final WeaponAttack coldIronLongsword = createWeaponAttack("Cold Iron Longsword", AttackWield.ONE_HAND);
    assertAttackBonuses(new int[] {4}, dndv35RuleService.getAttackBonuses(character, coldIronLongsword));

  }

  @Test
  public void testGetAttackBonusesOffHand() {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;

    final WeaponAttack shortSwordWeaponAttack = createWeaponAttack("Sword, short", AttackWield.OFF_HAND);
    final WeaponAttack battleaxeWeaponAttack = createWeaponAttack("Battleaxe", AttackWield.OFF_HAND);

    // light weapon in off hand
    Character character = createCharacter(fighter, 2);
    character.setStrength(12);
    assertAttackBonuses(new int[] {-5}, dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack));

    // light weapon in off hand
    character = createCharacter(fighter, 6);
    character.setStrength(12);
    assertAttackBonuses(new int[] {-1}, dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack));

    // one-handed weapon in off hand
    character = createCharacter(fighter, 2);
    character.setStrength(12);
    assertAttackBonuses(new int[] {-7}, dndv35RuleService.getAttackBonuses(character, battleaxeWeaponAttack));

    // light weapon in off hand and feat Improved Two-Weapon Fighting
    character = createCharacter(fighter, 2);
    character.setStrength(12);
    List<CharacterFeat> characterFeats = createCharacterFeat("Two-Weapon Fighting");
    characterFeats.addAll(createCharacterFeat("Improved Two-Weapon Fighting"));
    character.setCharacterFeats(characterFeats);
    assertAttackBonuses(new int[] {1, -4}, dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack));

    // light weapon in off hand and feat Greater Two-Weapon Fighting
    character = createCharacter(fighter, 2);
    character.setStrength(12);
    characterFeats = createCharacterFeat("Two-Weapon Fighting");
    characterFeats.addAll(createCharacterFeat("Improved Two-Weapon Fighting"));
    characterFeats.addAll(createCharacterFeat("Greater Two-Weapon Fighting"));
    character.setCharacterFeats(characterFeats);
    assertAttackBonuses(new int[] {1, -4, -9}, dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack));

    // light weapon in off hand and feat Greater Two-Weapon Fighting
    character = createCharacter(fighter, 11);
    character.setStrength(12);
    characterFeats = createCharacterFeat("Two-Weapon Fighting");
    characterFeats.addAll(createCharacterFeat("Improved Two-Weapon Fighting"));
    characterFeats.addAll(createCharacterFeat("Greater Two-Weapon Fighting"));
    character.setCharacterFeats(characterFeats);
    assertAttackBonuses(new int[] {10, 5, 0}, dndv35RuleService.getAttackBonuses(character, shortSwordWeaponAttack));

  }

  private List<CharacterFeat> createCharacterFeat(final String featname) {
    final Feat feat = new Feat();
    feat.setName(featname);
    final List<CharacterFeat> characterFeats = new ArrayList<>();
    characterFeats.add(new CharacterFeat(feat));
    return characterFeats;
  }

  private List<CharacterFeat> createCharacterFeat(final String featname, final String category) {
    final List<CharacterFeat> characterFeats = createCharacterFeat(featname);
    characterFeats.get(0).setCategory(category);
    return characterFeats;
  }

  @Test
  public void testGetAttackBonusesRanged() {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;

    final WeaponAttack oneHandWeaponAttack = createWeaponAttack("Crossbow, light", AttackWield.ONE_HAND);

    Character character = createCharacter(fighter, 2);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {3}, dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack));

    character = createCharacter(fighter, 5);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {6}, dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack));

    character = createCharacter(fighter, 6);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {7, 2}, dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack));

    character = createCharacter(fighter, 10);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {11, 6}, dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack));

    character = createCharacter(fighter, 11);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {12, 7, 2}, dndv35RuleService.getAttackBonuses(character, oneHandWeaponAttack));

    // two-weapon fighting primary hand
    final WeaponAttack primaryHandWeaponAttack = createWeaponAttack("Crossbow, light", AttackWield.PRIMARY_HAND);

    character = createCharacter(fighter, 2);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {-3}, dndv35RuleService.getAttackBonuses(character, primaryHandWeaponAttack));

    // two-weapon fighting primary hand
    final WeaponAttack offHandWeaponAttack = createWeaponAttack("Crossbow, light", AttackWield.OFF_HAND);

    character = createCharacter(fighter, 2);
    character.setDexterity(12);
    assertAttackBonuses(new int[] {-7}, dndv35RuleService.getAttackBonuses(character, offHandWeaponAttack));

  }

  private void assertAttackBonuses(final int[] expected, final List<Integer> attackBonuses) {
    assertEquals("Wrong number of attacks", expected.length, attackBonuses.size());
    for (int i = 0; i < expected.length; i++) {
      final int attackBonus = attackBonuses.get(i);
      assertEquals(i + ". Wrong attack bonus: ", expected[i], attackBonus);
    }
  }

  @Test
  public void testGetDamageBonus() {
    final List<CharacterFeat> emptyFeats = new ArrayList<>();
    assertDamageBonus(0, "Dagger", AttackWield.ONE_HAND, 0, emptyFeats);
    assertDamageBonus(1, "Dagger", AttackWield.ONE_HAND, 1, emptyFeats);
    assertDamageBonus(2, "Dagger of Venom", AttackWield.ONE_HAND, 1, emptyFeats);
    assertDamageBonus(3, "Assassin Dagger", AttackWield.ONE_HAND, 1, emptyFeats);
    assertDamageBonus(1, "Sling", AttackWield.ONE_HAND, 1, emptyFeats);
  }

  private void assertDamageBonus(final int expected, final String weaponName, final AttackWield attackWield,
      final int strenghModifier, final List<CharacterFeat> characterFeats) {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final WeaponAttack weaponAttack = createWeaponAttack(weaponName, attackWield);
    final int damageBonus = dndv35RuleService.getDamageBonus(weaponAttack, strenghModifier, characterFeats);
    assertEquals(expected, damageBonus);
  }

  @Test
  public void testGetMeleeWeaponStrengthBonus() {

    // Off-Hand Light Weapon with strength bonus
    assertMeleeWeaponStrengthBonus(1, "Sword, short", AttackWield.OFF_HAND, 2);

    // Off-Hand Light Weapon with strength malus
    assertMeleeWeaponStrengthBonus(-2, "Sword, short", AttackWield.OFF_HAND, -2);

    // Primary-Hand
    assertMeleeWeaponStrengthBonus(1, "Longsword", AttackWield.PRIMARY_HAND, 1);

    // One-Hand
    assertMeleeWeaponStrengthBonus(1, "Longsword", AttackWield.ONE_HAND, 1);

    // Two-Handed with strength bonus
    assertMeleeWeaponStrengthBonus(1, "Greataxe", AttackWield.TWO_HANDED, 1);
    assertMeleeWeaponStrengthBonus(3, "Greataxe", AttackWield.TWO_HANDED, 2);

    // Two-Handed with strength malus
    assertMeleeWeaponStrengthBonus(-2, "Greataxe", AttackWield.TWO_HANDED, -2);

    // Two-Handed Light Weapon
    assertMeleeWeaponStrengthBonus(2, "Sword, short", AttackWield.TWO_HANDED, 2);

  }

  private void assertMeleeWeaponStrengthBonus(final int expected, final String weaponName, final AttackWield attackWield,
      final int strenthBonus) {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final Weapon weapon = getWeaponByName(weaponName);
    final int bonus = dndv35RuleService.getMeleeWeaponStrengthBonus(weapon, attackWield, strenthBonus);
    assertEquals(expected, bonus);
  }

  @Test
  public void testGetRangedWeaponStrengthBonus() {
    // Projectile Weapon
    assertRangedWeaponStrengthBonus(0, "Crossbow, light", 1);

    // Sling recieves strength bonus
    assertRangedWeaponStrengthBonus(1, "Sling", 1);

    // Bow gets strengh malus only
    assertRangedWeaponStrengthBonus(-1, "Longbow", -1);
    assertRangedWeaponStrengthBonus(0, "Longbow", 0);
    assertRangedWeaponStrengthBonus(0, "Longbow", 1);

    // Composite Bow gets strength bonus
    assertRangedWeaponStrengthBonus(1, "Longbow, composite", 1);

    // Thrown Weapon
    assertRangedWeaponStrengthBonus(1, "Javelin", 1);

  }

  private void assertRangedWeaponStrengthBonus(final int expected, final String weaponName, final int strenthBonus) {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final Weapon weapon = getWeaponByName(weaponName);
    final int bonus = dndv35RuleService.getRangedWeaponStrengthBonus(weapon, strenthBonus);
    assertEquals(expected, bonus);
  }

  @Test
  public void testGetFeatDamageBonus() {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final Weapon dagger = getWeaponByName("Dagger");

    final List<CharacterFeat> emptyFeats = new ArrayList<>();
    int damageBonus = dndv35RuleService.getFeatDamageBonus(emptyFeats, dagger);
    assertEquals(0, damageBonus);

    final List<CharacterFeat> weaponSpecialization = createCharacterFeat("Weapon Specialization", "Dagger");
    damageBonus = dndv35RuleService.getFeatDamageBonus(weaponSpecialization, dagger);
    assertEquals(2, damageBonus);

    final Weapon daggerOfVenom = getWeaponByName("Dagger of Venom");
    damageBonus = dndv35RuleService.getFeatDamageBonus(weaponSpecialization, daggerOfVenom);
    assertEquals(2, damageBonus);

    final List<CharacterFeat> characterFeats = createCharacterFeat("Weapon Specialization", "Dagger");
    characterFeats.addAll(createCharacterFeat("Greater Weapon Specialization", "Dagger"));
    damageBonus = dndv35RuleService.getFeatDamageBonus(characterFeats, dagger);
    assertEquals(4, damageBonus);

  }

  @Test
  public void testGetTwoWeaponsFightingModifier() {
    final List<CharacterFeat> emptyList = new ArrayList<>();
    final List<CharacterFeat> twoWeaponFighting = createTwoWeaponFightingFeats();

    final Weapon lightWeapon = getWeaponByName("Dagger");
    final Weapon oneHandedWeapon = getWeaponByName("Longsword");
    final Weapon twoHandedWeapon = getWeaponByName("Greataxe");

    assertTwoWeaponsFightingModifier(0, AttackWield.ONE_HAND, oneHandedWeapon, emptyList);
    assertTwoWeaponsFightingModifier(0, AttackWield.TWO_HANDED, twoHandedWeapon, emptyList);

    // off-hand
    assertTwoWeaponsFightingModifier(-10, AttackWield.OFF_HAND, oneHandedWeapon, emptyList);
    assertTwoWeaponsFightingModifier(-8, AttackWield.OFF_HAND, lightWeapon, emptyList);
    assertTwoWeaponsFightingModifier(-4, AttackWield.OFF_HAND, oneHandedWeapon, twoWeaponFighting);
    assertTwoWeaponsFightingModifier(-2, AttackWield.OFF_HAND, lightWeapon, twoWeaponFighting);

    // primary-hand
    assertTwoWeaponsFightingModifier(-6, AttackWield.PRIMARY_HAND, oneHandedWeapon, emptyList);
    assertTwoWeaponsFightingModifier(-4, AttackWield.PRIMARY_HAND, oneHandedWeapon, twoWeaponFighting);
    assertTwoWeaponsFightingModifier(-4, AttackWield.PRIMARY_HAND, lightWeapon, emptyList);
    assertTwoWeaponsFightingModifier(-4, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, oneHandedWeapon, emptyList);
    assertTwoWeaponsFightingModifier(-2, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, oneHandedWeapon, twoWeaponFighting);

  }

  private List<CharacterFeat> createTwoWeaponFightingFeats() {
    final Feat twoWeaponFighting = new Feat();
    twoWeaponFighting.setName("Two-Weapon Fighting");

    final CharacterFeat characterFeat = new CharacterFeat(twoWeaponFighting);
    final List<CharacterFeat> characterFeats = new ArrayList<>(1);
    characterFeats.add(characterFeat);
    return characterFeats;
  }

  private void assertTwoWeaponsFightingModifier(final int expected, final AttackWield attackWield, final Weapon weapon,
      final List<CharacterFeat> characterFeats) {
    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final int bonus = dndv35RuleService.getTwoWeaponFighting(attackWield, weapon, characterFeats);
    assertEquals(expected, bonus);
  }

  @Test
  public void testGetAttackWields() {
    // Double Weapon
    assertAttackWields("Quarterstaff",
                       EnumSet.of(AttackWield.OFF_HAND, AttackWield.PRIMARY_HAND_LIGHT_OFF_HAND, AttackWield.TWO_HANDED));

    // Light Melee Weapon
    assertAttackWields("Dagger", EnumSet.allOf(AttackWield.class));
    assertAttackWields("Handaxe", EnumSet.allOf(AttackWield.class));
    assertAttackWields("Sword, short", EnumSet.allOf(AttackWield.class));

    // One-Handed Melee Weapon
    assertAttackWields("Battleaxe", EnumSet.allOf(AttackWield.class));
    assertAttackWields("Waraxe, dwarven", EnumSet.allOf(AttackWield.class));
    assertAttackWields("Rapier", EnumSet.allOf(AttackWield.class));
    assertAttackWields("Scimitar", EnumSet.allOf(AttackWield.class));
    assertAttackWields("Longsword", EnumSet.allOf(AttackWield.class));

    // Two-Handed Melee Weapon
    assertAttackWields("Greataxe", EnumSet.of(AttackWield.TWO_HANDED));

    // One-Handed Ranged Weapon
    assertAttackWields("Crossbow, light", EnumSet.of(AttackWield.ONE_HAND, AttackWield.TWO_HANDED));
    assertAttackWields("Sling", EnumSet.of(AttackWield.ONE_HAND, AttackWield.TWO_HANDED));

    // Two-Handed Range Weapon
    assertAttackWields("Shortbow", EnumSet.of(AttackWield.TWO_HANDED));
    assertAttackWields("Longbow, composite", EnumSet.of(AttackWield.TWO_HANDED));

  }

  private void assertAttackWields(final String name, final EnumSet<AttackWield> expected) {
    final Weapon quarterstaff = getWeaponByName(name);
    final EnumSet<AttackWield> attackWields = ruleService.getAttackWields(quarterstaff);

    assertNotNull(attackWields);
    assertEquals(expected.size(), attackWields.size());
    for (final AttackWield attackWield : expected) {
      assertTrue("Missing " + attackWield + " for " + name, attackWields.contains(attackWield));
    }
  }

  @Test
  public void testGetWeaponFocus() {
    final List<CharacterFeat> characterFeats = valeros.getCharacterFeats();
    final Weapon weapon = getWeaponByName("Cold Iron Longsword");

    final DnDv35RuleServiceImpl dndv35RuleService = (DnDv35RuleServiceImpl) ruleService;
    final int weaponFocus = dndv35RuleService.getWeaponFocus(characterFeats, weapon);

    assertEquals(1, weaponFocus);

  }
}
