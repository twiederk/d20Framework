package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Storage of all weapons, armor and goods. Stores weapons, armor and goods of Belvador and Nascan. Used to unburdon the
 * DummyItemDao from this data.
 */
public class PathfinderArmorStorage {

  /**
   * All armor
   */
  public static final Object[][] ARMOR = {
      // id, description, name, cost, weight, armor bonus, armor check penalty, armor type, quality type
      {1, "Padded", "Little more than heavy, quilted cloth, this armor provides only the most basic protection.", 5.0f, 10.0f, 1, 0,
          0, 0,
      }, //
      {2, "Leather", "Leather armor is made up of pieces of hard boiled leather carefully sewn together.", 10.0f, 15.0f, 2, 0, 0,
          0,
      }, //
      {3, "Studded leather", "Similar to leather armor, this suit is reinforced with small metal studs.", 25.0f, 20.0f, 3, -1, 0,
          0,
      }, //
      {4, "Chain shirt", "Covering the torso, this shirt is made up of thousands of interlocking metal rings.", 100.0f, 25.0f, 4,
          -2, 0, 0,
      }, //
      {5, "Hide", "Hide armor is made up of the tanned and preserved skin of any thick-hided beast.", 15.0f, 25.0f, 4, -3, 1, 0,},
      //
      {6, "Scale mail", "Scale mail is made up of dozens of small overlapping metal plates. The suit includes gauntlets.", 50.0f,
          30.0f, 5, -4, 1, 0,
      }, //
      {7, "Chainmail", "Unlike a chain shirt, chainmail covers the legs and arms of the wearer. The suit includes gauntlets.",
          150.0f, 40.0f, 6, -5, 1, 0,
      }, //
      {8, "Breastplate", "Covering only the torso, a breastplate is made up of a single piece of sculpted metal.", 200.0f, 30.0f, 6,
          -4, 1, 0,
      }, //
      {9, "Splint mail", "Splint mail is made up of metal strips, like banded mail. The suit includes gauntlets.", 200.0f, 45.0f, 7,
          -7, 2, 0,
      }, //
      {10, "Banded mail",
          "Banded mail is made up of overlapping strips of metal, fastened to a leather backing. The suit includes gauntlets.",
          250.0f, 35.0f, 7, -6, 2, 0,
      }, //
      {11, "Half-plate", "Combining elements of full plate and chainmail, half-plate includes gauntlets and a helm.", 600.0f, 50.0f,
          8, -7, 2, 0,
      }, //
      {12, "Full plate",
          "This metal suit includes gauntlets, heavy leather boots, a visored helmet, and a thick layer of padding that is worn underneath the armor. Each suit of full plate must be individually fitted to its owner by a master armorsmith, although a captured suit can be resized to fit a new owner at a cost of 200 to 800 (2d4 x 100) gold pieces.",
          1500.0f, 50.0f, 9, -6, 2, 0,
      }, //
      {13, "Buckler",
          "This small metal shield is worn strapped to your forearm. You can use a bow or crossbow without penalty while carrying it. You can also use your shield arm to wield a weapon (whether you are using an off-hand weapon or using your off hand to help wield a two-handed weapon), but you take a -1 penalty on attack rolls while doing so. This penalty stacks with those that may apply for fighting with your off hand and for fighting with two weapons. In any case, if you use a weapon in your off hand, you lose the buckler's AC bonus until your next turn. You can cast a spell with somatic components using your shield arm, but you lose the buckler's AC bonus until your next turn. You can't make a shield bash with a buckler.",
          5.0f, 5.0f, 1, -1, 3, 0,
      }, //
      {14, "Shield, light wooden",
          "You strap a shield to your forearm and grip it with your hand. A light shield's weight lets you carry other items in that hand, although you cannot use weapons with it.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to some spells and effects.\nShield Bash Attacks: You can bash an opponent with a light shield. See 'shield, light' on Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its AC bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.",
          3.0f, 5.0f, 1, -1, 3, 0,
      }, //
      {15, "Shield, light steel",
          "You strap a shield to your forearm and grip it with your hand. A light shield's weight lets you carry other items in that hand, although you cannot use weapons with it.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to some spells and effects.\nShield Bash Attacks: You can bash an opponent with a light shield. See 'shield, light' on Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its AC bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.",
          9.0f, 6.0f, 1, -1, 3, 0,
      }, //
      {16, "Shield, heavy wooden",
          "You strap a shield to your forearm and grip it with your hand. A heavy shield is so heavy that you can't use your shield hand for anything else.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to spells and effects.\nShield Bash Attacks: You can bash an opponent with a heavy shield. See 'shield, heavy' on Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its AC bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.",
          7.0f, 10.0f, 2, -2, 3, 0,
      }, //
      {17, "Shield, heavy steel",
          "You strap a shield to your forearm and grip it with your hand. A heavy shield is so heavy that you can't use your shield hand for anything else.\nWooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to spells and effects.\nShield Bash Attacks: You can bash an opponent with a heavy shield. See 'shield, heavy' on Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its AC bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right.",
          20.0f, 15.0f, 2, -2, 3, 0,
      }, //
      {18, "Shield, tower",
          "This massive wooden shield is nearly as tall as you are. In most situations, it provides the indicated shield bonus to your AC. As a standard action, however, you can use a tower shield to grant you total cover until the beginning of your next turn. When using a tower shield in this way, you must choose one edge of your space. That edge is treated as a solid wall for attacks targeting you only. You gain total cover for attacks that pass through this edge and no cover for attacks that do not pass through this edge (see Combat). The shield does not, however, provide cover against targeted spells, a spellcaster can cast a spell on you by targeting the shield you are holding. You cannot bash with a tower shield, nor can you use your shield hand for anything else.\nWhen employing a tower shield in combat, you take a -2 penalty on attack rolls because of the shield's encumbrance.",
          30.0f, 45.0f, 4, -10, 3, 0,
      }, //
      {19, "Adamantine Breastplate", "This nonmagical breastplate is made of adamantine, giving its wearer damage reductionof 2/-.",
          10200.0f, 30.0f, 6, -4, 1, 0,
      }, //
      {20, "Banded Mail of Luck",
          "Ten 100-gp gems adorn this +3 banded mail. Once per week, the armor allows its wearer to require that an attack roll made against him be rerolled. He must take whatever consequences come from the second roll. The wearer's player must decide whether to have the attack roll rerolled before damage is rolled.",
          18900.0f, 35.0f, 10, -3, 2, 2,
      }, //
      {21, "Breastplate of Command",
          "This +2 breastplate bestows a commanding aura upon its wearer. The wearer gains a +2 competence bonus on all Charismachecks, including Charisma-based skill checks. The wearer also gains a +2 competence bonus to his Leadershipscore. Friendly troops within 360 feet of the user become braver than normal, gaining a +2 resistance bonus on saving throws against fear. Since the effect arises in great part from the distinctiveness of the armor, it does not function if the wearer hides or conceals herself in any way.",
          25400.0f, 30.0f, 8, -2, 1, 2,
      }, //
      {22, "Celestial Armor",
          "This bright silver or gold +3 chainmail is so fine and light that it can be worn under normal clothing without betraying its presence. It has a maximum Dexteritybonus of +8, an armor check penalty of -2, and an arcane spell failure chance of 15%. It is considered light armor and allows the wearer to use fly on command (as the spell) once per day.",
          22400.0f, 20.0f, 9, -2, 1, 2,
      }, //
      {23, "Demon Armor",
          "This plate armor is fashioned to make the wearer appear to be a demon. The helmet is shaped to look like a horned demon head, and its wearer looks out of the open, tooth-filled mouth. This +4 full plate allows the wearer to make claw attacks that deal 1d10 points of damage, strike as +1 weapons, and afflict the target as if she had been struck by a contagion spell (FortitudeDC 14 negates). Use of contagion requires a normal melee attack with the claws. The 'claws' are built into the armor's vambraces and gauntlets, and cannot be disarmed.\nA suit of demon armor is infused with evil, and as a result it bestows one negative level on any nonevil creature wearing it. This negative level persists as long as the armor is worn and disappears when the armor is removed. The negative level cannot be overcome in any way (including restoration spells) while the armor is worn.",
          52260.0f, 50.0f, 13, -2, 2, 2,
      }, //
      {24, "Dwarven Plate", "This full plate is made of adamantine, giving its wearer damage reductionof 3/-.", 16500.0f, 50.0f, 9,
          -6, 2, 0,
      }, //
      {25, "Dragonhide Plate",
          "This suit of full plate is made of dragonhide, rather than metal, so druids can wear it. It is otherwise identical to masterwork full plate.",
          3300.0f, 50.0f, 9, -6, 2, 2,
      }, //
      {26, "Elven Chain",
          "This extremely light chainmail is made of very fine mithrallinks. This armor is treated, in all ways, like light armor, including when determining proficiency. The armor has an arcane spell failure chance of 20%, a maximum Dexteritybonus of +4, and an armor check penalty of -2.",
          5150.0f, 20.0f, 6, -5, 1, 0,
      }, //
      {27, "Mithral Full Plate of Speed",
          "As a free action, the wearer of this fine set of +1 mithralfull plate can activate it, enabling him to act as though affected by a haste spell for up to 10 rounds each day. The duration of the haste effect need not be consecutive rounds.\nThe armor has an arcane spell failure chance of 25%, a maximum Dexteritybonus of +3, and an armor check penalty of -3. It is considered medium armor, except that you must be proficient in heavy armor to avoid taking nonproficiency penalties.",
          26500.0f, 25.0f, 10, -5, 2, 2,
      }, //
      {28, "Mithral Shirt",
          "This extremely light chain shirt is made of very fine mithrallinks. The armor has an arcane spell failure chance of 10%, a maximum Dexteritybonus of +6, and no armor check penalty. It is considered light armor. ",
          1100.0f, 10.0f, 4, -2, 0, 0,
      }, //
      {29, "Plate Armor of the Deep",
          "This +1 full plate is decorated with a wave and fish motif. Although the armor remains as heavy and bulky as normal full plate, the wearer of plate armor of the deep is treated as unarmored for purposes of Swim checks. The wearer can breathe underwater and can converse with any water-breathing creature with a language.",
          24650.0f, 50.0f, 10, -5, 2, 2,
      }, //
      {30, "Rhino Hide",
          "This +2 hide armor is made from rhinoceros hide. In addition to granting a +2 enhancement bonus to AC, it has a -1 armor check penalty and deals an additional 2d6 points of damage on any successful charge attack made by the wearer, including a mounted charge.",
          5165.0f, 25.0f, 6, -1, 1, 2,
      }, //
      {31, "Absorbing Shield",
          "This +1 heavy steel shield is made of metal, but its color is flat black that seems to absorb light. Once every 2 days, on command, it can disintegrate an object that it touches, as the spell but requiring a melee touch attack. This effect only functions as an attack-it can't be activated to target a creature or weapon as it strikes the shield.",
          50170.0f, 15.0f, 3, -1, 3, 2,
      }, //
      {32, "Caster's Shield",
          "This +1 light wooden shield has a leather strip on the back on which a spellcaster can scribe a single spell as on a scroll. A spell so scribed requires half the normal cost in raw materials. The strip cannot accommodate spells of higher than 3rd level. The strip is reusable.\nA random caster's shield has a 50% chance of having a single medium scroll spell on it. The spell is divine (01-80 on d%) or arcane (81-100). A caster's shield has a 5% arcane spell failure chance.",
          3153.0f, 5.0f, 2, 0, 3, 2,
      }, //
      {33, "Darkwood Buckler",
          "This nonmagical light wooden shield is made out of darkwood. It has no enhancement bonus, but its construction material makes it lighter than a normal wooden shield. It has no armor check penalty.",
          203.0f, 2.5f, 1, -1, 3, 0,
      }, //
      {34, "Darkwood Shield",
          "This nonmagical heavy wooden shield is made out of darkwood. It has no enhancement bonus, but its construction material makes it lighter than a normal wooden shield. It has no armor check penalty.",
          257.0f, 5.0f, 2, -2, 3, 0,
      }, //
      {35, "Lion's Shield",
          "This +2 heavy steel shield is fashioned to appear to be a roaring lion's head. Three times per day as a free action, the lion's head can be commanded to attack (independently of the shield wearer), biting with the wielder's base attack bonus (including multiple attacks, if the wielder has them) and dealing 2d6 points of damage. This attack is in addition to any actions performed by the wielder.",
          9170.0f, 15.0f, 4, 0, 3, 2,
      }, //
      {36, "Mithral Heavy Shield",
          "This heavy shield is made of mithraland thus is much lighter than a standard steel shield. It has a 5% arcane spell failure chance and no armor check penalty.",
          1020.0f, 5.0f, 2, -2, 3, 0,
      }, //
      {37, "Spined Shield",
          "This +1 heavy steel shield is covered in spines. It acts as a normal spiked shield. On command up to three times per day, the shield's wearer can fire one of the shield's spines. A fired spine has a +1 enhancement bonus, a range increment of 120 feet, and deals 1d10 points of damage (19-20/x2). Fired spines regenerateeach day.",
          5580.0f, 15.0f, 3, -1, 3, 2,
      }, //
      {38, "Winged Shield",
          "This heavy wooden shield has a +3 enhancement bonus. Arching bird wings are carved into the face of the shield. Once per day, it can be commanded to fly (as the spell), carrying the wielder. The shield can carry up to 133 pounds and move at 60 feet per round, or up to 266 pounds and move at 40 feet per round.",
          17257.0f, 10.0f, 5, 0, 3, 2,
      }, //
      {39, "Quilted cloth",
          "This enhanced form of padded armor has internal layers specifically designed to trap arrows, bolts, darts, shuriken, thrown daggers, and other small ranged piercing weapons. When these kinds of weapons strike you, they tend to become snagged in these layers and fail to harm you. You gain DR 3/- against attacks of this kind. The special layers of the armor have no effect on other kinds of weapons.",
          100.0f, 15.0f, 1, 0, 0, 0,
      }, //
      {40, "Wooden",
          "This suit of leather armor has plates of fire-treated wood sewn over vital areas. Though not as effective as metal armor, it offers better protection than leather alone. Unlike metal armor, the wood is slightly buoyant, and the armor check penalty for swimming in this armor is 0.",
          20.0f, 25.0f, 3, -1, 0, 0,
      }, //
      {41, "Armored coat",
          "This sturdy leather coat is reinforced with metal plates sewn into the lining. More cumbersome than light armor but less effective than most medium armors, the advantage of an armored coat is that a person can don it or remove it as a move action (there is no 'don hastily' option for an armored coat). If worn over other armor, use the better AC bonus and worse value in all other categories, an armored coat has no effect if worn with heavy armor. The only magic effects that apply are those worn on top.",
          50.0f, 20.0f, 4, -2, 1, 0,
      }, //
      {42, "Agile breastplate",
          "This breastplate is specially crafted in a manner that allows extra maneuverability for some physical activities. The armor check penalty for Climb checks and jump checks is only -1 (masterwork and mithral versions of this armor reduce this penalty as well as the normal penalty).",
          400.0f, 25.0f, 6, -4, 1, 0,
      }, //
      {43, "Agile half-plate",
          "This style of half-plate is specially crafted in a manner that allows extra maneuverability for some physical activities. The armor check penalty for Climb checks and jump checks is only -4 (masterwork and mithral versions of this armor reduce this penalty as well as the normal penalty). In addition, unlike most heavy armors, the wearer can still run at quadruple speed instead of triple speed.",
          850.0f, 55.0f, 8, -7, 2, 0,
      }, //
      {44, "Quickdraw shield, light wooden",
          "This light shield is specially crafted with a series of straps to allow a character proficient in shields to ready or stow it on his or her back quickly and easily. If you have a base attack bonus of +1 or higher, you may don or put away a quickdraw shield as a swift action combined with a regular move. If you have the Two-Weapon Fighting feat, you can draw a light or one-handed weapon with one hand and a quickdraw shield with the other in the time it would normally take you to draw one weapon. If you have the Quick Draw feat, you may don or put away a quickdraw shield as a free action.",
          53.0f, 6.0f, 1, -2, 3, 0,
      }, //
      {45, "Quickdraw shield, light steel",
          "This light shield is specially crafted with a series of straps to allow a character proficient in shields to ready or stow it on his or her back quickly and easily. If you have a base attack bonus of +1 or higher, you may don or put away a quickdraw shield as a swift action combined with a regular move. If you have the Two-Weapon Fighting feat, you can draw a light or one-handed weapon with one hand and a quickdraw shield with the other in the time it would normally take you to draw one weapon. If you have the Quick Draw feat, you may don or put away a quickdraw shield as a free action.",
          59.0f, 7.0f, 1, -2, 3, 0,
      }, //
      {46, "Mistmail",
          "The fine links of this +1 chain shirt form a pattern of roiling clouds. On command once per day, the wearer can transform it into thick fog that fills his space and provides concealment (20% miss chance). This mist moves with the character. Effects that disperse the mist or destroy it cause the armor to reform into its solid shape on the character's body, as does speaking the command word or entering a place where the fog-magic doesn't function (such as underwater). If the character tries to don another suit of armor while the mistmail is in fog form, it reforms at the character's feet.",
          2250.0f, 25.0f, 5, -1, 0, 2,
      }, //
      {47, "Soothsayer's raiment",
          "This +1 chainmail is attuned to a particular oracular mystery and contains a revelation associated with that mystery (see the oracle class description). While wearing the armor, an oracle has access to that revelation and may use it as if she had it as a normal class feature. The oracle must have the appropriate mystery to use the armor, for example, a soothsayer's raiment (battlecry) is only usable by an oracle of battle. If the wearer already has that revelation and the revelation gives an ability with a limited number of uses per day, the oracle can use that ability one additional time per day. This ability has no effect if worn by a non-oracle.<br>For divination spells with a percentage-based chance of success (such as augury and divination), the wearer's chance increases by +5.",
          10300.0f, 40.0f, 7, -4, 1, 2,
      }, //
      {48, "Boneless leather",
          "This suit of +1 leather gives its wearer the ability to twist and contort his body in virtually any direction. He gains a +5 bonus on Escape Artist checks, a +5 bonus on Acrobatics checks to reduce damage from falls, a +5 bonus to CMD, and DR 5/piercing or slashing.",
          12160.0f, 15.0f, 3, 0, 0, 2,
      }, //
      {49, "Murderer's blackcloth",
          "This silk +1 shadow padded armor is as dark as night and stitched with thread the color of dried blood. When worn by a rogue with the bleed talent, it increases the bleed damage of the rogue's sneak attacks by +1.",
          12405.0f, 10.0f, 2, 0, 0, 2,
      }, //
      {50, "Folding plate",
          "This item normally looks like a heavy steel brooch or cloak clasp, often depicting a heavy helm or sturdy shield. On command, the brooch transforms in a clatter of metallic plates and panels to instantly cover the wearer in a complete suit of +1 full plate, with the design of the brooch displayed on the armor's breastplate. The same command word causes the armor to transform into the brooch. The brooch only transforms if the wearer's armor slot is unoccupied, thus it won't work if the wearer is already armored.",
          12650.0f, 50.0f, 10, -5, 2, 2,
      }, //
      {51, "Armor of insults",
          "Each metal bit of this suit of +1 studded leather looks more like a tiny sneering face than a simple stud. Once per day the wearer of the armor may command the mouths to unleash a torrent of verbal abuse directed against every hostile creature within 60 feet who can see and hear the wearer. Each such creature must make a DC 16 Will saving throw to avoid suffering an overwhelming compulsion to attack the wearer for the next 7 rounds. If the creature is unable to attack the wearer on its next turn, or attacking the wearer would put the creature at risk (moving through a threatened square, charging into a pit, and so on) it can act normally that turn. This is a mind-affecting sonic effect, and has no effect on creatures that do not use a spoken language. ",
          16175.0f, 20.0f, 4, 0, 0, 2,
      }, //
      {52, "Buccaneer's breastplate",
          "This +1 breastplate is made of bluish metal and decorated with wave motifs. It allows the wearer to continually utilize the effects of the spell water walk. If a creature puts on the armor while underwater, the wearer is borne toward the surface at a rate of 60 feet per round.",
          23850.0f, 30.0f, 7, -3, 1, 2,
      }, //
      {53, "Forsaken banded mail",
          "Every inch of this suit of +1 banded mail bears a defaced holy symbol or a design equally offensive to one or more gods and their servants. The wearer of the armor cannot cast divine spells or use any spell-like supernatural ability gained from a connection to a deity. The wearer gains SR 19 against any divine-origin spell, spell-like ability, or supernatural ability (such as a domain granted power or ability from an outsider serving a deity), and treats the armor's enhancement bonus as +2 higher against creatures with these abilities.",
          25400.0f, 35.0f, 8, -5, 2, 2,
      }, //
      {54, "Giant-hide armor (ogre)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          39165.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {55, "Giant-hide armor (hill giant)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          46665.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {56, "Giant-hide armor (stone giant)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          54165.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {57, "Giant-hide armor (fire giant)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          54165.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {58, "Giant-hide armor (frost giant)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          54165.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {59, "Giant-hide armor (troll)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          59165.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {60, "Giant-hide armor (cloud giant)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          69165.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {61, "Giant-hide armor (storm giant)",
          "This drooping, many-folded suit of +3 hide armor is made from the tanned skin of an actual giant. Once per day on command, the wearer can grow to match the size of the appropriate giant, as if using giant form I (ogre, troll, hill giant, stone giant, fire giant, or frost giant) or giant form II (cloud giant or storm giant). This transformation lasts up to 15 minutes, and ends when the wearer commands. Most good folk consider wearing the skins of intelligent creatures to be abhorrent. Giants gain a +2 morale bonus on attack and damage rolls against the wearer, or +4 if the wearer's armor is made from the same kind of giant as the attacker.",
          76665.0f, 25.0f, 7, 0, 1, 2,
      }, //
      {62, "Daystar half-plate",
          "The silvery sheen of this +1 half-plate causes it to sparkle in even the faintest light. At will, the wearer can command it to shine with a daylight spell for 10 minutes. Once per day, the wearer can command it to shine as per the sunburst spell.",
          81250.0f, 50.0f, 9, -6, 2, 2,
      }, //
      {63, "Battlement shield",
          "Once per day on command, this +2 tower shield can transform into a solid, 10-foot by 10-foot by 1-foot wall of masonry with a battlement on top and an arrow slit in each 5-foot length. The wall acts as cover just like any physical wall. The wielder can touch the wall with one hand and command it to revert to a tower shield either resting on the ground and balanced against his hand or strapped to his arm in the normal fashion. The wall has all the characteristics of any other foot-thick wall of masonry (hardness 8, 90 hit points, break DC of 35). Attacks sufficient to destroy the wall cause it to immediately transform back into a shield, which loses half its hit points and gains the broken condition. The shield remains in wall form until destroyed or commanded to return to shield form. The wall cannot appear in a space too small to accommodate it. ",
          16180.0f, 45.0f, 6, -8, 3, 2,
      }, //
      {64, "Fortress shield",
          "The wearer of this +1 tower shield may, as a full-round action, transform the shield into a 1-inch thick cube of iron that springs into being around him, completely enclosing his space. The cube has hardness 10 and 30 hit points per side. This cube grants the wearer total cover against everything outside the cube, including (as it is perfectly sealed) swarms and gas attacks. The inside of the cube is dark, and air cannot get in or out so the wearer must hold his breath starting on the third round after activating the cube. Attacks sufficient to destroy one side of the cube cause it to immediately transform back into a shield, which loses half its hit points and gains the broken condition. Otherwise, the cube reverts to shield form upon command, if the wearer moves from his current space, or the wearer falls unconscious or dies.",
          19180.0f, 45.0f, 5, -9, 3, 2,
      }, //
  };

}
