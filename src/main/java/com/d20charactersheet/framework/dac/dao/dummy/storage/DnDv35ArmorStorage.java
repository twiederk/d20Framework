package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Storage of all weapons, armor and goods. Stores weapons, armor and goods of Belvador and Nascan. Used to unburdon the
 * DummyItemDao from this data.
 */
public class DnDv35ArmorStorage {

  /**
   * All armor
   */
  public static final Object[][] ARMOR = {
      // id, description, name, cost, weight, armor bonus, armor check penalty, armor type, quality type
      {0, "Padded", "", 5.0f, 10.0f, 1, 0, 0, 0,}, //
      {1, "Leather", "", 10.0f, 15.0f, 2, 0, 0, 0,}, //
      {2, "Studded Leather", "", 25.0f, 20.0f, 3, -1, 0, 0,}, //
      {3, "Chain Shirt", "A chain shirt comes with a steel cap.", 100.0f, 25.0f, 4, -2, 0, 0,}, //
      {4, "Hide", "", 15.0f, 25.0f, 3, -3, 1, 0,}, //
      {5, "Scale Mail", "The suit includes gauntlets.", 50.0f, 30.0f, 4, -4, 1, 0,}, //
      {6, "Chain Mail", "The suit includes gauntlets.", 150.0f, 40.0f, 5, -5, 1, 0,}, //
      {7, "Breastplate", "It comes with a helmet and greaves.", 200.0f, 30.0f, 5, -4, 1, 0,}, //
      {8, "Splint Mail", "The suit includes gauntlets.", 200.0f, 45.0f, 6, -7, 2, 0,}, //
      {9, "Banded Mail", "The suit includes gauntlets.", 250.0f, 35.0f, 6, -6, 2, 0,}, //
      {10, "Half-Plate", "The suit includes gauntlets.", 600.0f, 50.0f, 7, -7, 2, 0,}, //
      {11, "Full Plate",
          "The suit includes gauntlets, heavy leather boots, a visored helmet, and a thick layer of padding that is worn underneath the armor. Each suit of full plate must be individually fitted to its owner by a master armorsmith, although a captured suit can be resized to fit a new owner at a cost of 200 to 800 (2d4x100) gold pieces.",
          1500.0f, 50.0f, 8, -6, 2, 0,
      }, //
      {12, "Buckler",
          "This small metal shield is worn strapped to your forearm. You can use a bow or crossbow without penalty while carrying it. You can also use your shield arm to wield a weapon (whether you are using an off-hand weapon or using your off hand to help wield a two-handed weapon), but you take a -1 penalty on attack rolls while doing so. This penalty stacks with those that may apply for fighting with your off hand and for fighting with two weapons. In any case, if you use a weapon in your off hand, you don''t get the buckler''s AC bonus for the rest of the round.\nYou can''t bash someone with a buckler.\n",
          15.0f, 5.0f, 1, -1, 3, 0,
      }, //
      {13, "Light Wooden Shield",
          "You strap a shield to your forearm and grip it with your hand. A light shield''s weight lets you carry other items in that hand, although you cannot use weapons with it.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to special attacks.\nShield Bash Attacks: You can bash an opponent with a light shield, using it as an off-hand weapon. See Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its AC bonus until your next action (usually until the next round). An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.\n",
          3.0f, 5.0f, 1, -1, 3, 0,
      }, //
      {14, "Light Steel Shield",
          "You strap a shield to your forearm and grip it with your hand. A light shield''s weight lets you carry other items in that hand, although you cannot use weapons with it.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to special attacks.\nShield Bash Attacks: You can bash an opponent with a light shield, using it as an off-hand weapon. See Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its AC bonus until your next action (usually until the next round). An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.\n",
          9.0f, 6.0f, 1, -1, 3, 0,
      }, //
      {15, "Heavy Wooden Shield",
          "You strap a shield to your forearm and grip it with your hand. A heavy shield is so heavy that you can''t use your shield hand for anything else.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to special attacks.\nShield Bash Attacks: You can bash an opponent with a heavy shield, using it as an off-hand weapon. See Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its AC bonus until your next action (usually until the next round). An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.\n",
          7.0f, 10.0f, 2, -2, 3, 0,
      }, //
      {16, "Heavy Steel Shield",
          "You strap a shield to your forearm and grip it with your hand. A heavy shield is so heavy that you can''t use your shield hand for anything else.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to special attacks.\nShield Bash Attacks: You can bash an opponent with a heavy shield, using it as an off-hand weapon. See Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its AC bonus until your next action (usually until the next round). An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.\n",
          20.0f, 15.0f, 2, -2, 3, 0,
      }, //
      {17, "Tower Shield",
          "This massive wooden shield is nearly as tall as you are. In most situations, it provides the indicated shield bonus to your AC. However, you can instead use it as total cover, though you must give up your attacks to do so. The shield does not, however, provide cover against targeted spells, a spellcaster can cast a spell on you by targeting the shield you are holding. You cannot bash with a tower shield, nor can you use your shield hand for anything else.\nWhen employing a tower shield in combat, you take a -2 penalty on attack rolls because of the shield''s encumbrance.\n",
          30.0f, 45.0f, 4, -10, 3, 0,
      }, //
      {18, "Adamantine Breastplate",
          "This nonmagical breastplate is made of adamantine, giving its wearer damage reduction of 2/-.", 10200.0f, 30.0f, 5, -4,
          1, 0,
      }, //
      {19, "Banded Mail of Luck",
          "Ten 100-gp gems adorn this +3 banded mail. Once per week, the armor allows its wearer to require that an attack roll made against him be rerolled. He must take whatever consequences come from the second roll. The wearer''s player must decide whether to have the attack roll rerolled before damage is rolled.",
          18900.0f, 35.0f, 9, -3, 2, 2,
      }, //
      {20, "Breastplate of Command",
          "This finely crafted +2 breastplate radiates a powerful aura of magic. When worn, the armor bestows a dignified and commanding aura upon its owner. The wearer gains a +2 competence bonus on all Charisma checks, including turning checks and Charisma-based skill checks. The wearer also gains a +2 competence bonus to his Leadership score. Friendly troops within 360 feet of the user become braver than normal. Since the effect arises in great part from the distinctiveness of the armor, the wearer cannot hide or conceal herself in any way and still have the effect function.",
          25400.0f, 30.0f, 7, -2, 1, 2,
      }, //
      {21, "Celestial Armor",
          "This bright silver or gold +3 chainmail is so fine and light that it can be worn under normal clothing without betraying its presence. It has a maximum Dexterity bonus of +8, an armor check penalty of -2, and an arcane spell failure chance of 15%. It is considered light armor, weighs 20 pounds, and it allows the wearer to use fly on command (as the spell) once per day.",
          22400.0f, 20.0f, 8, -2, 0, 2,
      }, //
      {22, "Demon Armor",
          "This plate armor is fashioned to make the wearer appear to be a demon. The helmet is shaped to look like a horned demon head, and its wearer looks out of the open, tooth-filled mouth. This +4 full plate allows the wearer to make claw attacks that deal 1d10 points of damage, strike as +1 weapons, and afflict the target as if she had been struck by a contagion spell (Fortitude DC 14 negates). Use of contagion requires a normal melee attack with the claws. The ''claws'' are built into the armor''s vambraces and gauntlets. \nThe armor bestows one negative level on any nonevil creature wearing it. This negative level persists as long as the armor is worn and disappears when the armor is removed. The negative level never results in actual level loss, but it cannot be overcome in any way (including restoration spells) while the armor is worn.\n",
          52260.0f, 50.0f, 12, -2, 2, 2,
      }, //
      {23, "Dragonhide Plate",
          "This suit of full plate is made of dragonhide, rather than metal, so druids can wear it. It is otherwise identical to masterwork full plate.",
          3300.0f, 50.0f, 8, -6, 2, 0,
      }, //
      {24, "Dwarven Plate", "This full plate is made of adamantine, giving its wearer damage reduction of 3/-.", 16500.0f, 50.0f, 8,
          -6, 2, 0,
      }, //
      {25, "Elven Chain",
          "This extremely light chainmail is made of very fine mithral links. Speed while wearing elven chain is 30 feet for Medium creatures, or 20 feet for Small. The armor has an arcane spell failure chance of 20%, a maximum Dexterity bonus of +4, and an armor check penalty of -2. It is considered light armor and weighs 20 pounds.",
          4150.0f, 20.0f, 5, -2, 0, 0,
      }, //
      {26, "Mithral Full Plate of Speed",
          "As a free action, the wearer of this fine set of +1 mithral full plate can activate it, enabling her to act as though affected by a haste spell for up to 10 rounds each day. The duration of the haste effect need not be consecutive rounds.\nSpeed while wearing a suit of mithral full plate is 20 feet for Medium creatures, or 15 feet for Small. The armor has an arcane spell failure chance of 25%, a maximum Dexterity bonus of +3, and an armor check penalty of -3. It is considered medium armor and weighs 25 pounds.\n",
          26500.0f, 25.0f, 9, -3, 1, 2,
      }, //
      {27, "Mithral Shirt",
          "This extremely light chain shirt is made of very fine mithral links. Speed while wearing a mithral shirt is 30 feet for Medium creatures, or 20 feet for Small. The armor has an arcane spell failure chance of 10%, a maximum Dexterity bonus of +6, and no armor check penalty. It is considered light armor and weighs 10 pounds.",
          1100.0f, 10.0f, 4, 0, 0, 0,
      }, //
      {28, "Plate Armor of the Deep",
          "This +1 full plate is decorated with a wave and fish motif. The wearer of plate armor of the deep is treated as unarmored for purposes of Swim checks. The wearer can breathe underwater and can converse with any creature with a language that breathes water.",
          24650.0f, 50.0f, 9, -5, 2, 2,
      }, //
      {29, "Rhino Hide",
          "This +2 hide armor is made from rhinoceros hide. In addition to granting a +2 enhancement bonus to AC, it has a -1 armor check penalty and deals an additional 2d6 points of damage on any successful charge attack made by the wearer, including a mounted charge.",
          5165.0f, 25.0f, 5, -1, 1, 2,
      }, //
      {30, "Absorbing Shield",
          "This +1 heavy steel shield is flat black and seems to absorb light. Once every two days, on command, it can disintegrate an object that it touches, as the spell but requiring a melee touch attack.",
          50170.0f, 15.0f, 3, -1, 3, 2,
      }, //
      {31, "Caster Shield",
          "This +1 light wooden shield has a small leather strip on the back on which a spellcaster can scribe a single spell as on a scroll. A spell so scribed has only half the base raw material cost. Experience point and component costs remain the same. The strip cannot accommodate spells of higher than 3rd level. The strip is reusable.\nA random caster ''s shield has a 50% chance of having a single medium scroll spell on it. The spell is divine (01-80 on d%) or arcane (81-100).\nA caster''s shield has a 5% arcane spell failure chance.\n",
          3153.0f, 5.0f, 2, 0, 3, 2,
      }, //
      {32, "Darkwood Buckler",
          "This nonmagical light wooden shield is made out of darkwood. It has no enhancement bonus, but its construction material makes it lighter than a normal wooden shield. It weighs 2-1/2 pounds and has no armor check penalty.",
          205.0f, 2.5f, 1, 0, 3, 0,
      }, //
      {33, "Darkwood Shield",
          "This nonmagical heavy wooden shield is made out of darkwood. It has no enhancement bonus, but its construction material makes it lighter than a normal wooden shield.\nIt weighs 5 pounds and has no armor check penalty.\n",
          257.0f, 5.0f, 2, 0, 3, 0,
      }, //
      {34, "Lion Shield",
          "This +2 heavy steel shield is fashioned to appear to be a roaring lion''s head. Three times per day as a free action, the lion''s head can be commanded to attack (independently of the shield wearer), biting with the wielder''s base attack bonus (including multiple attacks, if the wielder has them) and dealing 2d6 points of damage. This attack is in addition to any actions performed by the wielder.",
          9170.0f, 15.0f, 4, 0, 3, 2,
      }, //
      {35, "Mithral Heavy Shield",
          "This heavy shield is made of mithral and thus is much lighter than a standard steel shield. It has a 5% arcane spell failure chance and no armor check penalty. It weighs 5 pounds.",
          1020.0f, 5.0f, 2, 0, 3, 0,
      }, //
      {36, "Spined Shield",
          "This +1 heavy steel shield is covered in spines. It acts as a normal spiked shield. On command up to three times per day, the shield''s wearer can fire one of the shield''s spines. A fired spine has a +1 enhancement bonus, a range increment of 120 feet, and deals 1d10 points of damage (19-20/x2). Fired spines regenerate each day.",
          5580.0f, 15.0f, 3, -1, 3, 2,
      }, //
      {37, "Winged Shield",
          "This round heavy wooden shield has a +3 enhancement bonus. Small, feathered wings encircle the shield.\nOnce per day it can be commanded to fly (as the spell), carrying the wielder. The shield can carry up to 133 pounds and move at 60 feet per round, or up to 266 pounds and move at 40 feet per round.\n",
          17257.0f, 10.0f, 5, 0, 3, 2,
      }, //
  };

}
