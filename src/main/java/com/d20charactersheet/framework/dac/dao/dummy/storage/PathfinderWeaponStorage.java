package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores all weapons of DnDv35.
 */
public class PathfinderWeaponStorage {

  /**
   * All weapons
   */
  public static final Object[][] WEAPON = { //
      // id, name, description, cost, weight, number of dice, die, bonus, critical hit, critical modifier, weapon
      // type, quality type, weapon combat, weapon encumbrance, weapon category, weapon type
      {1, "Gauntlet",
          "This metal glove lets you deal lethal damage rather than nonlethal damage with unarmed strikes. A strike with a gauntlet is otherwise considered an unarmed attack. The cost and weight given are for a single gauntlet. Medium and heavy armors (except breastplate) come with gauntlets. Your opponent cannot use a disarm action to disarm you of gauntlets.",
          2f, 1f, 1, 1, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {2, "Unarmed strike",
          "A Medium character deals 1d3 points of nonlethal damage with an unarmed strike. A Small character deals 1d2 points of nonlethal damage. A monk or any character with the Improved Unarmed Strike feat can deal lethal or nonlethal damage with unarmed strikes, at his discretion. The damage from an unarmed strike is considered weapon damage for the purposes of effects that give you a bonus on weapon damage rolls. An unarmed strike is always considered a light weapon. Therefore, you can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with an unarmed strike. Unarmed strikes do not count as natural weapons (see Combat).",
          0f, 0f, 1, 1, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {3, "Dagger",
          "A dagger has a blade that is about 1 foot in length. You get a +2 bonus on Sleight of Hand skill checks made to conceal a dagger on your body (see Using Skills).",
          2f, 1f, 1, 2, 0, 19, 2, 0, 0, 0, 0, 0, 2, 10
      }, //
      {4, "Dagger, punching",
          "A punching dagger''s blade is attached to a horizontal handle that projects out from the fist when held.", 2f, 1f, 1, 2,
          0, 20, 3, 0, 0, 0, 0, 0, 2, 0
      }, //
      {5, "Gauntlet, spiked",
          "The cost and weight given are for a single gauntlet. An attack with a spiked gauntlet is considered an armed attack. Your opponent cannot use a disarm action to disarm you of spiked gauntlets.",
          5f, 1f, 1, 2, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {6, "Mace, light", "A mace is made up of an ornate metal head attached to a simple wooden or metal shaft.", 5f, 4f, 1, 3, 0,
          20, 2, 0, 0, 0, 0, 0, 3, 0
      }, //
      {7, "Sickle", "", 6f, 2f, 1, 3, 0, 20, 2, 0, 0, 0, 0, 0, 4, 0}, //
      {8, "Club", "", 0f, 3f, 1, 3, 0, 20, 2, 0, 0, 0, 1, 0, 5, 10}, //
      {9, "Mace, heavy", "A heavy mace has a larger head and a longer handle than a normal mace.", 12f, 8f, 1, 4, 0, 20, 2, 0, 0, 0,
          1, 0, 6, 0
      }, //
      {10, "Morningstar", "A morningstar is a spiked metal ball, affixed to the top of a long handle.", 8f, 6f, 1, 4, 0, 20, 2, 0,
          0, 0, 1, 0, 7, 0
      }, //
      {11, "Shortspear", "A shortspear is about 3 feet in length, making it a suitable thrown weapon.", 1f, 3f, 1, 3, 0, 20, 2, 0,
          0, 0, 1, 0, 8, 20
      }, //
      {12, "Longspear", "A longspear is about 8 feet in length.", 5f, 9f, 1, 4, 0, 20, 3, 0, 0, 0, 2, 1, 9, 0}, //
      {13, "Quarterstaff", "A quarterstaff is a simple piece of wood, about 5 feet in length.", 0f, 4f, 1, 3, 0, 20, 2, 0, 0, 0, 2,
          2, 10, 0
      }, //
      {14, "Spear", "A spear is 5 feet in length and can be thrown.", 2f, 6f, 1, 4, 0, 20, 3, 0, 0, 0, 2, 0, 11, 20}, //
      {15, "Blowgun",
          "Blowguns are generally used to deliver debilitating (but rarely fatal) poisons from a distance. They are nearly silent when fired. For a list of appropriate poisons, see Poison.",
          2f, 1f, 1, 0, 0, 20, 2, 0, 0, 1, 0, 4, 12, 20
      }, //
      {16, "Darts, Blowgun (10)", "", 0.5f, 0f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0}, //
      {17, "Crossbow, heavy",
          "You draw a heavy crossbow back by turning a small winch. Loading a heavy crossbow is a full-round action that provokes attacks of opportunity. Normally, operating a heavy crossbow requires two hands. However, you can shoot, but not load, a heavy crossbow with one hand at a -4 penalty on attack rolls. You can shoot a heavy crossbow with each hand, but you take a penalty on attack rolls as if attacking with two one-handed weapons. This penalty is cumulative with the penalty for one-handed firing.",
          50f, 8f, 1, 5, 0, 19, 2, 0, 0, 1, 0, 4, 13, 120
      }, //
      {18, "Bolts, Crossbow, heavy (10)",
          "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a case or quiver that holds 10 bolts (or 5, for a repeating crossbow). ",
          1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {19, "Crossbow, light",
          "You draw a light crossbow back by pulling a lever. Loading a light crossbow is a move action that provokes attacks of opportunity. Normally, operating a light crossbow requires two hands. However, you can shoot, but not load, a light crossbow with one hand at a -2 penalty on attack rolls. You can shoot a light crossbow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons. This penalty is cumulative with the penalty for one-handed firing.",
          35f, 4f, 1, 4, 0, 19, 2, 0, 0, 1, 0, 4, 14, 80
      }, //
      {20, "Bolts, Crossbow, light (10)",
          "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a case or quiver that holds 10 bolts (or 5, for a repeating crossbow). ",
          1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {21, "Dart", "", 0.5f, 0.5f, 1, 2, 0, 20, 2, 0, 0, 1, 1, 3, 15, 20}, //
      {22, "Javelin",
          "A javelin is a thin throwing spear . Since it is not designed for melee, you are treated as nonproficient with it and take a -4 penalty on attack rolls if you use a javelin as a melee weapon.",
          1f, 2f, 1, 3, 0, 20, 2, 0, 0, 1, 1, 3, 16, 30
      }, //
      {23, "Sling",
          "A sling is little more than a leather cup attached to a pair of strings. Your Strength modifier applies to damage rolls when you use a sling, just as it does for thrown weapons. You can fire, but not load, a sling with one hand. Loading a sling is a move action that requires two hands and provokes attacks of opportunity. You can hurl ordinary stones with a sling, but stones are not as dense or as round as bullets. Thus, such an attack deals damage as if the weapon were designed for a creature one size category smaller than you and you take a -1 penalty on attack rolls.",
          0f, 0.1f, 1, 2, 0, 20, 2, 0, 0, 1, 1, 4, 17, 50
      }, //
      {24, "Bullets, sling (10)",
          "Bullets are shaped metal balls, designed to be used by a sling or halfling sling staff. Bullets come in a leather pouch that holds 10 bullets.",
          0.1f, 5f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {25, "Axe, throwing", "", 8f, 2f, 1, 3, 0, 20, 2, 1, 0, 0, 0, 3, 18, 10}, //
      {26, "Hammer, light", "", 1f, 2f, 1, 2, 0, 20, 2, 1, 0, 0, 0, 0, 19, 20}, //
      {27, "Handaxe", "", 6f, 3f, 1, 3, 0, 20, 3, 1, 0, 0, 0, 0, 20, 0}, //
      {28, "Kukri", "A kukri is a curved blade, about 1 foot in length.", 8f, 2f, 1, 2, 0, 18, 2, 1, 0, 0, 0, 0, 21, 0}, //
      {29, "Pick, light", "", 4f, 3f, 1, 2, 0, 20, 4, 1, 0, 0, 0, 0, 22, 0}, //
      {30, "Sap", "", 1f, 2f, 1, 3, 0, 20, 2, 1, 0, 0, 0, 0, 23, 0}, //
      {31, "Starknife",
          "From a central metal ring, four tapering metal blades extend like points on a compass rose. A wielder can stab with the starknife or throw it. ",
          24f, 3f, 1, 2, 0, 20, 3, 1, 0, 0, 0, 0, 24, 20
      }, //
      {32, "Sword, short", "This sword is about 2 feet in length.", 10f, 2f, 1, 3, 0, 19, 2, 1, 0, 0, 0, 0, 25, 0}, //
      {33, "Battleaxe", "", 10f, 6f, 1, 4, 0, 20, 3, 1, 0, 0, 1, 0, 26, 0}, //
      {34, "Flail", "A flail consists of a spiked metal ball, connected to a handle by a sturdy chain.", 8f, 5f, 1, 4, 0, 20, 2, 1,
          0, 0, 1, 0, 27, 0
      }, //
      {35, "Longsword", "This sword is about 3-1/2 feet in length.", 15f, 4f, 1, 4, 0, 19, 2, 1, 0, 0, 1, 0, 28, 0}, //
      {36, "Pick, heavy", "", 8f, 6f, 1, 3, 0, 20, 4, 1, 0, 0, 1, 0, 29, 0}, //
      {37, "Rapier",
          "You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a rapier sized for you, even though it isn''t a light weapon. You can''t wield a rapier in two hands in order to apply 1-1/2 times your Strength bonus to damage.",
          20f, 2f, 1, 3, 0, 18, 2, 1, 0, 0, 1, 0, 30, 0
      }, //
      {38, "Scimitar", "", 15f, 4f, 1, 3, 0, 18, 2, 1, 0, 0, 1, 0, 31, 0}, //
      {39, "Trident", "A trident has three metal prongs at end of a 4-foot-long shaft. This weapon can be thrown.", 15f, 4f, 1, 4,
          0, 20, 2, 1, 0, 0, 1, 0, 32, 10
      }, //
      {40, "Warhammer", "", 12f, 5f, 1, 4, 0, 20, 3, 1, 0, 0, 1, 0, 33, 0}, //
      {41, "Falchion", "", 75f, 8f, 2, 2, 0, 18, 2, 1, 0, 0, 2, 0, 34, 0}, //
      {42, "Glaive", "A glaive is a simple blade, mounted to the end of a pole about 7 feet in length.", 8f, 10f, 1, 5, 0, 20, 3, 1,
          0, 0, 2, 1, 35, 0
      }, //
      {43, "Greataxe", "", 20f, 12f, 1, 6, 0, 20, 3, 1, 0, 0, 2, 0, 36, 0}, //
      {44, "Greatclub", "", 5f, 8f, 1, 5, 0, 20, 2, 1, 0, 0, 2, 0, 37, 0}, //
      {45, "Flail, heavy", "Similar to a flail, a heavy flail has a larger metal ball and a longer handle. ", 15f, 10f, 1, 5, 0, 19,
          2, 1, 0, 0, 2, 0, 38, 0
      }, //
      {46, "Greatsword", "This immense two-handed sword is about 5 feet in length.", 50f, 8f, 2, 3, 0, 19, 2, 1, 0, 0, 2, 0, 39, 0},
      //
      {47, "Guisarme", "A guisarme is an 8-foot-long shaft with a blade and a hook mounted at the tip.", 9f, 12f, 2, 2, 0, 20, 3, 1,
          0, 0, 2, 1, 40, 0
      }, //
      {48, "Halberd", "A halberd is similar to a 5-foot-long spear, but it also has a small, axe-like head mounted near the tip.",
          10f, 12f, 1, 5, 0, 20, 3, 1, 0, 0, 2, 0, 41, 0
      }, //
      {49, "Lance",
          "A lance deals double damage when used from the back of a charging mount. While mounted, you can wield a lance with one hand.",
          10f, 10f, 1, 4, 0, 20, 3, 1, 0, 0, 2, 1, 42, 0
      }, //
      {50, "Ranseur",
          "Similar in appearance to a trident, a ranseur has a single spear at its tip, flanked by a pair of short, curving blades.",
          10f, 12f, 2, 2, 0, 20, 3, 1, 0, 0, 2, 1, 43, 0
      }, //
      {51, "Scythe", "", 18f, 10f, 2, 2, 0, 20, 4, 1, 0, 0, 2, 0, 44, 0}, //
      {52, "Longbow",
          "At almost 5 feet in height, a longbow is made up of one solid piece of carefully curved wood. You need two hands to use a bow, regardless of its size. A longbow is too unwieldy to use while you are mounted. If you have a penalty for low Strength, apply it to damage rolls when you use a longbow. If you have a Strength bonus, you can apply it to damage rolls when you use a composite longbow (see below), but not when you use a regular longbow.",
          75f, 3f, 1, 4, 0, 20, 3, 1, 0, 1, 2, 4, 45, 100
      }, //
      {53, "Arrows, Longbow (20)",
          "An arrow used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (critical multiplier x2). Arrows come in a leather quiver that holds 20 arrows.",
          1f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {54, "Longbow, composite",
          "You need at least two hands to use a bow, regardless of its size. You can use a composite longbow while mounted. All composite bows are made with a particular strength rating (that is, each requires a minimum Strength modifier to use with proficiency). If your Strength bonus is less than the strength rating of the composite bow, you can''t effectively use it, so you take a -2 penalty on attacks with it. The default composite longbow requires a Strength modifier of +0 or higher to use with proficiency. A composite longbow can be made with a high strength rating to take advantage of an above-average Strength score, this feature allows you to add your Strength bonus to damage, up to the maximum bonus indicated for the bow. Each point of Strength bonus granted by the bow adds 100 gp to its cost. If you have a penalty for low Strength, apply it to damage rolls when you use a composite longbow. For purposes of Weapon Proficiency and similar feats, a composite longbow is treated as if it were a longbow.",
          100f, 3f, 1, 4, 0, 20, 3, 1, 0, 1, 2, 4, 46, 110
      }, //
      {55, "Arrows, Longbow, composite (20)",
          "An arrow used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (critical multiplier x2). Arrows come in a leather quiver that holds 20 arrows.",
          1f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {56, "Shortbow",
          "A shortbow is made up of one piece of wood, about 3 feet in length. You need two hands to use a bow, regardless of its size. You can use a shortbow while mounted. If you have a penalty for low Strength, apply it to damage rolls when you use a shortbow. If you have a bonus for high Strength, you can apply it to damage rolls when you use a composite shortbow (see below), but not a regular shortbow.",
          30f, 2f, 1, 3, 0, 20, 3, 1, 0, 1, 2, 4, 47, 60
      }, //
      {57, "Arrows, Shortbow (20)",
          "An arrow used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (critical multiplier x2). Arrows come in a leather quiver that holds 20 arrows.",
          1f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {58, "Shortbow, composite",
          "You need at least two hands to use a bow, regardless of its size. You can use a composite shortbow while mounted. All composite bows are made with a particular strength rating (that is, each requires a minimum Strength modifier to use with proficiency). If your Strength bonus is lower than the strength rating of the composite bow, you can''t effectively use it, so you take a -2 penalty on attacks with it. The default composite shortbow requires a Strength modifier of +0 or higher to use with proficiency. A composite shortbow can be made with a high strength rating to take advantage of an above-average Strength score, this feature allows you to add your Strength bonus to damage, up to the maximum bonus indicated for the bow. Each point of Strength bonus granted by the bow adds 75 gp to its cost. If you have a penalty for low Strength, apply it to damage rolls when you use a composite shortbow. For purposes of Weapon Proficiency, Weapon Focus, and similar feats, a composite shortbow is treated as if it were a shortbow.",
          75f, 2f, 1, 3, 0, 20, 3, 1, 0, 1, 2, 4, 48, 70
      }, //
      {59, "Arrows, Shortbow, composite (20)",
          "An arrow used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (critical multiplier x2). Arrows come in a leather quiver that holds 20 arrows.",
          1f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 70, 0
      }, //
      {60, "Kama", "Similar to a sickle, a kama is a short, curved blade attached to a simple handle.", 2f, 2f, 1, 3, 0, 20, 2, 2,
          0, 0, 0, 0, 49, 0
      }, //
      {61, "Nunchaku", "A nunchaku is made up of two wooden or metal bars connected by a small length of rope or chain.", 2f, 2f, 1,
          3, 0, 20, 2, 2, 0, 0, 0, 0, 50, 0
      }, //
      {62, "Sai",
          "A sai is a metal spike flanked by a pair of prongs used to trap an enemy''s weapon. With a sai, you get a +2 bonus on Combat Maneuver Checks to sunder an enemy''s weapon. Though pointed, a sai is used primarily to bludgeon foes and to disarm weapons.",
          1f, 1f, 1, 2, 0, 20, 2, 2, 0, 0, 0, 0, 51, 0
      }, //
      {63, "Siangham", "This weapon is a handheld shaft fitted with a pointed tip for stabbing foes.", 3f, 1f, 1, 3, 0, 20, 2, 2, 0,
          0, 0, 0, 52, 0
      }, //
      {64, "Sword, bastard",
          "A bastard sword is about 4 feet in length, making it too large to use in one hand without special training, thus, it is an exotic weapon. A character can use a bastard sword two-handed as a martial weapon.",
          35f, 6f, 1, 5, 0, 19, 2, 2, 0, 0, 1, 0, 53, 0
      }, //
      {65, "Waraxe, dwarven",
          "A dwarven waraxe has a large, ornate head mounted to a thick handle, making it too large to use in one hand without special training, thus, it is an exotic weapon. A Medium character can use a dwarven waraxe two-handed as a martial weapon, or a Large creature can use it one-handed in the same way. A dwarf treats a dwarven waraxe as a martial weapon even when using it in one hand.",
          30f, 8f, 1, 5, 0, 20, 3, 2, 0, 0, 1, 0, 54, 0
      }, //
      {66, "Whip",
          "A whip deals no damage to any creature with an armor bonus of +1 or higher or a natural armor bonus of +3 or higher. The whip is treated as a melee weapon with 15-foot reach, though you don''t threaten the area into which you can make an attack. In addition, unlike most other weapons with reach, you can use it against foes anywhere within your reach (including adjacent foes).",
          1f, 2f, 1, 1, 0, 20, 2, 2, 0, 0, 1, 1, 55, 0
      }, //
      {67, "Axe, orc double",
          "A cruel weapon with blades placed at opposite ends of a long haft, an orc double axe is a double weapon.", 60f, 15f, 1,
          4, 0, 20, 3, 2, 0, 0, 2, 2, 56, 0
      }, //
      {68, "Chain, spiked",
          "A spiked chain is about 4 feet in length, covered in wicked barbs. You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a spiked chain sized for you, even though it isn''t a light weapon.",
          25f, 10f, 2, 2, 0, 20, 2, 2, 0, 0, 2, 0, 57, 0
      }, //
      {69, "Curve blade, elven",
          "Essentially a longer version of a scimitar, but with a thinner blade, the elven curve blade is exceptionally rare. You receive a +2 circumstance bonus to your Combat Maneuver Defense whenever a foe attempts to sunder your elven curve blade due to its flexible metal. You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with an elven curve blade sized for you, even though it isn''t a light weapon.",
          80f, 7f, 1, 5, 0, 18, 2, 2, 0, 0, 2, 0, 58, 0
      }, //
      {70, "Flail, dire",
          "A dire flail consists of two spheres of spiked iron dangling from chains at opposite ends of a long haft.", 90f, 10f, 1,
          4, 0, 20, 2, 2, 0, 0, 2, 2, 59, 0
      }, //
      {71, "Hammer, gnome hooked",
          "A gnome hooked hammer is a double weapon-an ingenious tool with a hammer head at one end of its haft and a long, curved pick at the other. The hammer''s blunt head is a bludgeoning weapon that deals 1d6 points of damage (crit x3). Its hook is a piercing weapon that deals 1d4 points of damage (crit x4). You can use either head as the primary weapon. Gnomes treat hooked hammers as martial weapons.",
          20f, 6f, 1, 4, 0, 20, 3, 2, 0, 0, 2, 2, 60, 0
      }, //
      {72, "Sword, two-bladed",
          "A two-bladed sword is a double weapon-twin blades extend from either side of a central, short haft, allowing the wielder to attack with graceful but deadly flourishes.",
          100f, 10f, 1, 4, 0, 19, 2, 2, 0, 0, 2, 2, 61, 0
      }, //
      {73, "Urgrosh, dwarven",
          "A dwarven urgrosh is a double weapon-an axe head and a spear point on opposite ends of a long haft. The urgrosh''s axe head is a slashing weapon that deals 1d8 points of damage. Its spear head is a piercing weapon that deals 1d6 points of damage. You can use either head as the primary weapon. The other becomes the off-hand weapon. If you use an urgrosh against a charging character, the spear head is the part of the weapon that deals damage. Dwarves treat dwarven urgroshes as martial weapons.",
          50f, 12f, 1, 4, 0, 20, 3, 2, 0, 0, 2, 2, 62, 0
      }, //
      {74, "Bolas",
          "A bolas is a pair of weights, connected by a thin rope or cord. You can use this weapon to make a ranged trip attack against an opponent. You can''t be tripped during your own trip attempt when using a bolas.",
          5f, 2f, 1, 2, 0, 20, 2, 2, 0, 1, 0, 3, 63, 10
      }, //
      {75, "Crossbow, hand",
          "You can draw a hand crossbow back by hand. Loading a hand crossbow is a move action that provokes attacks of opportunity. You can shoot, but not load, a hand crossbow with one hand at no penalty. You can shoot a hand crossbow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons.",
          100f, 2f, 1, 2, 0, 19, 2, 2, 0, 1, 1, 4, 64, 30
      }, //
      {76, "Bolts, Crossbow, hand (10)",
          "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a case or quiver that holds 10 bolts (or 5, for a repeating crossbow). ",
          1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {77, "Crossbow, repeating heavy",
          "The repeating crossbow (whether heavy or light) holds 5 crossbow bolts. As long as it holds bolts, you can reload it by pulling the reloading lever (a free action). Loading a new case of 5 bolts is a full-round action that provokes attacks of opportunity. You can fire a repeating crossbow with one hand or fire a repeating crossbow in each hand in the same manner as you would a normal crossbow of the same size. However, you must fire the weapon with two hands in order to use the reloading lever, and you must use two hands to load a new case of bolts.",
          400f, 12f, 1, 0, 0, 19, 2, 2, 0, 1, 1, 4, 65, 120
      }, //
      {78, "Bolts, Crossbow, repeating heavy (5)",
          "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a case or quiver that holds 10 bolts (or 5, for a repeating crossbow). ",
          1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {79, "Crossbow, repeating light",
          "The repeating crossbow (whether heavy or light) holds 5 crossbow bolts. As long as it holds bolts, you can reload it by pulling the reloading lever (a free action). Loading a new case of 5 bolts is a full-round action that provokes attacks of opportunity. You can fire a repeating crossbow with one hand or fire a repeating crossbow in each hand in the same manner as you would a normal crossbow of the same size. However, you must fire the weapon with two hands in order to use the reloading lever, and you must use two hands to load a new case of bolts.",
          250f, 6f, 1, 4, 0, 19, 2, 2, 0, 1, 1, 4, 66, 80
      }, //
      {80, "Bolts, Crossbow, repeating light (5)",
          "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a case or quiver that holds 10 bolts (or 5, for a repeating crossbow). ",
          1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 70, 0
      }, //
      {81, "Net",
          "A net is used to entangle enemies. When you throw a net, you make a ranged touch attack against your target. A net''s maximum range is 10 feet. If you hit, the target is entangled. An entangled creature takes a -2 penalty on attack rolls and a -4 penalty on Dexterity, can move at only half speed, and cannot charge or run. If you control the trailing rope by succeeding on an opposed Strength check while holding it, the entangled creature can move only within the limits that the rope allows. If the entangled creature attempts to cast a spell, it must make a concentration check with a DC of 15 + the spell''s level or be unable to cast the spell. An entangled creature can escape with a DC 20 Escape Artist check (a full-round action). The net has 5 hit points and can be burst with a DC 25 Strength check (also a full-round action). A net is useful only against creatures within one size category of you. A net must be folded to be thrown effectively. The first time you throw your net in a fight, you make a normal ranged touch attack roll. After the net is unfolded, you take a -4 penalty on attack rolls with it. It takes 2 rounds for a proficient user to fold a net and twice that long for a nonproficient one to do so.",
          20f, 6f, 0, 0, 0, 0, 0, 2, 0, 1, 1, 3, 67, 10
      }, //
      {82, "Shuriken (5)",
          "A shuriken is a small piece of metal with sharpened edges, designed for throwing. A shuriken can''t be used as a melee weapon. Although they are thrown weapons, shuriken are treated as ammunition for the purposes of drawing them, crafting masterwork or otherwise special versions of them, and what happens to them after they are thrown.",
          1f, 0.5f, 1, 0, 0, 20, 2, 2, 0, 1, 0, 3, 68, 10
      }, //
      {83, "Sling staff, halfling",
          "Made from a specially designed sling attached to a short club, a halfling sling staff can be used by a proficient wielder to devastating effect. Your Strength modifier applies to damage rolls when you use a halfling sling staff, just as it does for thrown weapons. You can fire, but not load, a halfling sling staff with one hand. Loading a halfling sling staff is a move action that requires two hands and provokes attacks of opportunity. You can hurl ordinary stones with a halfling sling staff, but stones are not as dense or as round as bullets. Thus, such an attack deals damage as if the weapon were designed for a creature one size category smaller than you and you take a -1 penalty on attack rolls. A halfling sling staff can be used as a simple weapon that deals bludgeoning damage equal to that of a club of its size. Halflings treat halfling sling staves as martial weapons.",
          20f, 3f, 1, 4, 0, 20, 3, 2, 0, 1, 2, 4, 69, 80
      }, //
      {84, "Adamantine Battleaxe",
          "This nonmagical axe is made out of adamantine. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          3010f, 6f, 1, 4, 0, 20, 3, 1, 0, 0, 1, 0, 26, 0
      }, //
      {85, "Adamantine Dagger",
          "This nonmagical dagger is made out of adamantine. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          3002f, 1f, 1, 2, 0, 19, 2, 0, 0, 0, 0, 0, 2, 0
      }, //
      {86, "Assassin''s Dagger",
          "This wicked-looking, curved +2 dagger provides a +1 bonus to the DC of a Fortitude save forced by the death attack of an assassin.",
          10302f, 1f, 1, 2, 2, 19, 2, 0, 2, 0, 0, 0, 2, 0
      }, //
      {87, "Dagger of Venom",
          "This black +1 dagger has a serrated edge. It allows the wielder to use a poison effect (as the spell, save DC 14) upon a creature struck by the blade once per day. The wielder can decide to use the power after he has struck. Doing so is a free action, but the poison effect must be invoked in the same round that the dagger strikes. ",
          8302f, 1f, 1, 2, 1, 19, 2, 0, 2, 0, 0, 0, 2, 0
      }, //
      {88, "Dwarven Thrower",
          "This weapon functions as a +2 warhammer in the hands of most users. Yet in the hands of a dwarf, the warhammer gains an additional +1 enhancement bonus (for a total enhancement bonus of +3) and gains the returning special ability. It can be hurled with a 30-foot range increment. When hurled, a dwarven thrower deals an extra 2d8 points of damage against creatures of the giant subtype or an extra 1d8 points of damage against any other target. ",
          60312f, 5f, 1, 4, 2, 20, 3, 1, 2, 0, 1, 0, 33, 0
      }, //
      {89, "Flame Tongue",
          "This is a +1 flaming burst longsword. Once per day, the sword can blast forth a fiery ray at any target within 30 feet as a ranged touch attack. The ray deals 4d6 points of fire damage on a successful hit. ",
          20715f, 4f, 1, 4, 1, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {90, "Frost Brand",
          "This +3 frost greatsword sheds light as a torch when the temperature drops below 0� F. At such times it cannot be concealed when drawn, nor can its light be shut off. Its wielder is protected from fire, the sword absorbs the first 10 points of fire damage each round that the wielder would otherwise take.\nA frost brand extinguishes all nonmagical fires in a 20-foot radius. As a standard action, it can also dispel lasting fire spells, but not instantaneous effects. You must succeed on a dispel check (1d20 +14) against each spell to dispel it. The DC to dispel such spells is 11 + the caster level of the fire spell.",
          54475f, 8f, 2, 3, 3, 19, 2, 1, 2, 0, 2, 0, 39, 0
      }, //
      {91, "Holy Avenger",
          "This +2 cold iron longsword becomes a +5 holy cold iron longsword in the hands of a paladin.\nThis sacred weapon provides spell resistance of 5 + the paladin''s level to the wielder and anyone adjacent to her. It also enables the paladin to use greater dispel magic (once per round as a standard action) at the class level of the paladin. Only the area dispel is possible, not the targeted dispel or counterspell versions of greater dispel magic.",
          120630f, 4f, 1, 4, 2, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {92, "Javelin of Lightning",
          "This javelin becomes a 5d6 lightning bolt when thrown (Reflex DC 14 half). It is consumed in the attack.", 1500f, 2f, 1,
          3, 0, 20, 2, 0, 2, 1, 1, 3, 16, 30
      }, //
      {93, "Life-Drinker",
          "This +1 greataxe is favored by undead and constructs, who do not suffer its drawback. A life-drinker bestows two negative levels on its target whenever it deals damage, just as if its target had been struck by an undead creature. One day after being struck, subjects must make a DC 16 Fortitude save for each negative level or the negative levels become permanent.\nEach time a life-drinker deals damage to a foe, it also bestows one negative level on the wielder. Any negative levels gained by the wielder in this fashion lasts for 1 hour. ",
          40320f, 12f, 1, 6, 1, 20, 3, 1, 2, 0, 2, 0, 36, 0
      }, //
      {94, "Longsword, Cold Iron",
          "This nonmagical longsword is crafted out of cold iron. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          330f, 4f, 1, 4, 0, 19, 2, 1, 1, 0, 1, 0, 28, 0
      }, //
      {95, "Luck Blade (0 wishes)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made, before the results are revealed. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power. ",
          22060f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {96, "Luck Blade (1 wish)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made, before the results are revealed. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power. ",
          62360f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {97, "Luck Blade (2 wishes)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made, before the results are revealed. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power. ",
          102660f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {98, "Luck Blade (3 wishes)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made, before the results are revealed. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power. ",
          142960f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {99, "Mace of Smiting",
          "This +3 adamantine heavy mace has a +5 enhancement bonus against constructs, and a successful critical hit dealt to a construct completely destroys the construct (no saving throw). A critical hit dealt to an outsider deals x4 damage rather than x2. ",
          75312f, 8f, 1, 4, 3, 20, 2, 0, 2, 0, 1, 0, 6, 0
      }, //
      {100, "Mace of Terror",
          "This weapon usually appears to be a particularly frightening-looking iron or steel mace. On command, this +2 heavy mace causes the wielder''s clothes and appearance to transform into an illusion of darkest horror such that living creatures in a 30-foot cone become panicked as if by a fear spell (Will DC 16 partial). Those who fail take a -2 morale penalty on saving throws, and they flee from the wielder. The wielder may use this ability up to three times per day.",
          38552f, 8f, 1, 4, 2, 20, 2, 0, 2, 0, 1, 0, 6, 0
      }, //
      {101, "Nine Lives Stealer",
          "This longsword always performs as a +2 longsword, but it also has the power to draw the life force from an opponent. It can do this nine times before the ability is lost. At that point, the sword becomes a simple +2 longsword (with a faint evil aura). A critical hit must be dealt for the sword''s death-dealing ability to function, and this weapon has no effect on creatures not subject to critical hits. The victim is entitled to a DC 20 Fortitude save to avoid death. If the save is successful, the sword''s death-dealing ability does not function, no use of the ability is expended, and normal critical damage is determined. This sword is evil, and any good character attempting to wield it gains two negative levels. These negative levels remain as long as the sword is in hand and disappear when the sword is no longer wielded. These negative levels never result in actual level loss, but they cannot be overcome in any way (including restoration spells) while the sword is wielded.",
          23057f, 4f, 1, 4, 2, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {102, "Oathbow",
          "Of elven make, this white +2 composite longbow (+2 Str bonus) whispers, ''Swift defeat to my enemies'' in Elven when nocked and pulled. Once per day, if the archer swears aloud to slay her target (a free action), the bow''s whisper becomes the shout ''Death to those who have wronged me!'' Against such a sworn enemy, the bow has a +5 enhancement bonus, and arrows launched from it deal an additional 2d6 points of damage (and x4 on a critical hit instead of the normal x3). After an enemy has been sworn, the bow is treated as only a masterwork weapon against all foes other than the sworn enemy, and the archer takes a -1 penalty on attack rolls with any weapon other than the oathbow. These bonuses and penalties last for 7 days or until the sworn enemy is slain or destroyed by the wielder of the oathbow, whichever comes first.\nThe oathbow may only have one sworn enemy at a time. Once the wielder swears to slay a target, he cannot make a new oath until he has slain that target or 7 days have passed. Even if the wielder slays the sworn enemy on the same day that he makes the oath, he cannot activate the oathbow''s special power again until 24 hours have passed from the time he made the oath. ",
          25600f, 3f, 1, 4, 2, 20, 3, 1, 2, 1, 2, 4, 46, 110
      }, //
      {103, "Rapier of Puncturing",
          "Three times per day, this +2 wounding rapier allows the wielder to make a touch attack with the weapon that deals 1d6 points of Constitution damage by draining blood. Creatures immune to critical hits are immune to the Constitution damage dealt by this weapon.",
          50320f, 2f, 1, 3, 2, 18, 2, 1, 2, 0, 1, 0, 30, 0
      }, //
      {104, "Screaming Bolt",
          "These +2 bolts scream when fired, forcing all enemies of the wielder within 20 feet of the path of the bolt to succeed on a DC 14 Will save or become shaken. This is a mind-affecting fear effect.",
          267f, 0.1f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {105, "Shatterspike",
          "This intimidating weapon appears to be a longsword with multiple hooks, barbs, and serrations along the blade, excellent for catching and sundering a foe''s weapon. Wielders without the Improved Sunder feat use a shatterspike as a +1 longsword only. Wielders with the Improved Sunder feat instead use shatterspike as a +4 longsword when attempting to sunder an opponent''s weapon. Shatterspike can damage weapons with an enhancement bonus of +4 or lower.",
          4315f, 4f, 1, 4, 0, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {106, "Shifter''s Sorrow",
          "This +1/+1 two-bladed sword has blades of alchemical silver. The weapon deals an extra 2d6 points of damage against any creature with the shapechanger subtype. When a shapechanger or a creature in an alternate form (such as a druid using wild shape) is struck by the weapon, it must make a DC 15 Will save or return to its natural form.",
          12780f, 10f, 1, 4, 0, 19, 2, 2, 2, 0, 2, 2, 61, 0
      }, //
      {107, "Silver Dagger",
          "As a masterwork weapon, this alchemical silver dagger has a +1 enhancement bonus on attack rolls (but not to damage rolls).",
          322f, 1f, 1, 2, 0, 19, 2, 0, 1, 0, 0, 0, 2, 0
      }, //
      {108, "Slaying Arrow",
          "This +1 arrow is keyed to a particular type or subtype of creature. If it strikes such a creature, the target must make a DC 20 Fortitude save or take 50 points of damage. Note that even creatures normally exempt from Fortitude saves (undead and constructs) are subject to this attack. When keyed to a living creature, this is a death effect (and thus death ward protects a target). To determine the type or subtype of creature the arrow is keyed to, roll on the table below.\nA greater slaying arrow functions just like a normal slaying arrow, but the DC to avoid the death effect is 23 and the arrow deals 100 points of damage if the saving throw is failed.",
          2282f, 0.1f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {109, "Slaying Arrow, greater",
          "This +1 arrow is keyed to a particular type or subtype of creature. If it strikes such a creature, the target must make a DC 20 Fortitude save or take 50 points of damage. Note that even creatures normally exempt from Fortitude saves (undead and constructs) are subject to this attack. When keyed to a living creature, this is a death effect (and thus death ward protects a target). To determine the type or subtype of creature the arrow is keyed to, roll on the table below.\nA greater slaying arrow functions just like a normal slaying arrow, but the DC to avoid the death effect is 23 and the arrow deals 100 points of damage if the saving throw is failed.",
          4057f, 0.1f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {110, "Sleep Arrow",
          "This +1 arrow is painted white and has white fletching. If it strikes a foe so that it would normally deal damage, it instead bursts into magical energy that deals nonlethal damage (in the same amount as would lethal damage) and forces the target to make a DC 11 Will save or fall asleep.",
          132f, 0.1f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {111, "Sun Blade",
          "This sword is the size of a bastard sword. However, a sun blade is wielded as if it were a short sword with respect to weight and ease of use. In other words, the weapon appears to all viewers to be a bastard sword, and deals bastard sword damage, but the wielder feels and reacts as if the weapon were a short sword. Any individual able to use either a bastard sword or a short sword with proficiency is proficient in the use of a sun blade. Likewise, Weapon Focus and Weapon Specialization in short sword and bastard sword apply equally, but the benefits of those feats do not stack.\nIn normal combat, the glowing golden blade of the weapon is equal to a +2 bastard sword. Against evil creatures, its enhancement bonus is +4. Against Negative Energy Plane creatures or undead creatures, the sword deals double damage (and x3 on a critical hit instead of the usual x2).\nThe blade also has a special sunlight power. Once per day, the wielder can swing the blade vigorously above his head while speaking a command word. The sun blade then sheds a bright yellow radiance that acts like bright light and affects creatures susceptible to light as if it were natural sunlight. The radiance begins shining in a 10-foot radius around the sword wielder and extends outward at 5 feet per round for 10 rounds thereafter, to create a globe of light with a 60-foot radius. When the wielder stops swinging, the radiance fades to a dim glow that persists for another minute before disappearing entirely. All sun blades are of good alignment, and any evil creature attempting to wield one gains one negative level. The negative level remains as long as the sword is in hand and disappears when the sword is no longer wielded. This negative level cannot be overcome in any way (including by restoration spells) while the sword is wielded.",
          50335f, 2f, 1, 5, 0, 19, 2, 2, 2, 0, 1, 0, 53, 0
      }, //
      {112, "Sword of Life Stealing",
          "This black iron +2 longsword bestows a negative level when it deals a critical hit. The sword wielder gains 1d6 temporary hit points each time a negative level is bestowed on another. These temporary hit points last for 24 hours. One day after being struck, subjects must make a DC 16 Fortitude save for each negative level gained or they become permanent.",
          25715f, 4f, 1, 4, 2, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {113, "Sword of the Planes",
          "This longsword has an enhancement bonus of +1 on the Material Plane, but on any Elemental Plane its enhancement bonus increases to +2. The +2 enhancement bonus also applies whenever the weapon is used against creatures native to the Elemental Plane. It operates as a +3 longsword on the Astral Plane and the Ethereal Plane, or when used against opponents native to either of those planes. On any other plane, or against any outsider, it functions as a +4 longsword.",
          22315f, 4f, 1, 4, 1, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {114, "Sword of Subtlety",
          "A +1 short sword with a thin, dull gray blade, this weapon provides a +4 bonus on its wielder''s attack and damage rolls when he is making a sneak attack with it.",
          22310f, 2f, 1, 3, 1, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {115, "Sylvan Scimitar",
          "This +3 scimitar, when used outdoors in a temperate climate, grants its wielder the use of the Cleave feat and deals an extra 1d6 points of damage.",
          47315f, 4f, 1, 3, 3, 18, 2, 1, 2, 0, 1, 0, 31, 0
      }, //
      {116, "Trident of Fish Command",
          "The magical properties of this +1 trident with a 6-foot-long haft enable its wielder to charm up to 14 HD of aquatic animals as per the spell charm animals (Will DC 16 negates, animals get a +5 bonus if currently under attack by the wielder or his allies), no two of which can be more than 30 feet apart. The wielder can use this effect up to three times per day. The wielder can communicate with the animals as if using a speak with animals spell. Animals making their saving throws are free of control, but they will not approach within 10 feet of the trident.",
          18650f, 4f, 1, 4, 1, 20, 2, 1, 2, 0, 1, 0, 32, 0
      }, //
      {117, "Trident of Warning",
          "A weapon of this type enables its wielder to determine the location, depth, kind, and number of aquatic predators within 680 feet. A trident of warning must be grasped and pointed in order for the character using it to gain such information, and it requires 1 round to scan a hemisphere with a radius of 680 feet. The weapon is otherwise a +2 trident.",
          10115f, 4f, 1, 4, 2, 20, 2, 1, 2, 0, 1, 0, 32, 0
      }, //
      {118, "Shield, light", "You can bash with a shield instead of using it for defense.", 0f, 0f, 1, 1, 0, 20, 2, 1, 0, 0, 0, 0,
          73, 0
      }, //
      {119, "Spiked armor",
          "You can outfit your armor with spikes, which can deal damage in a grapple or as a separate attack. See Armor, below, for details.",
          0f, 0f, 1, 3, 0, 20, 2, 1, 0, 0, 0, 0, 75, 0
      }, //
      {120, "Spiked shield, light", "You can bash with a spiked shield instead of using it for defense.", 0f, 0f, 1, 2, 0, 20, 2, 1,
          0, 0, 0, 0, 73, 0
      }, //
      {121, "Shield, heavy", "You can bash with a shield instead of using it for defense.", 0f, 0f, 1, 2, 0, 20, 2, 1, 0, 0, 1, 0,
          74, 0
      }, //
      {122, "Spiked shield, heavy", "You can bash with a spiked shield instead of using it for defense.", 0f, 0f, 1, 3, 0, 20, 2, 1,
          0, 0, 1, 0, 74, 0
      }, //
      {123, "Brass knuckles",
          "These close combat weapons are designed to fit comfortably around the knuckles, narrowing the contact area and therefore magnifying the amount of force delivered by a punch. They allow you to deal lethal damage with unarmed attacks. You may hold, but not wield, a weapon or other object in a hand wearing brass knuckles. You may cast a spell with a somatic component while wearing brass knuckles if you make a concentration check (DC 10 + the level of the spell you''re casting). Monks are proficient with brass knuckles and can use their monk unarmed damage when fighting with them.",
          1f, 1f, 1, 1, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {124, "Battle aspergillum",
          "Named for the common aspergillum, a mace-like tool used by priests to sprinkle holy water, this light mace has a hollow head and a metal plug to fit the hollow''s neck. When the mace strikes a creature, holy water sprinkles out through tiny holes throughout the weapon''s head, creatures subject to damage from holy water take 1 point of damage in addition to the normal effect of being struck by the mace (a nonmagical aspergillum can deal holy water damage to an incorporeal creature in this manner, even if the mace itself deals no damage). After 5 hits, the battle aspergillum is empty and needs to be refilled. Filling it with holy water is a standard action that provokes an attack of opportunity (like drinking a potion). A filled aspergillum is normally carried upright, otherwise the holy water leaks out as the weapon moves.",
          5f, 4f, 1, 3, 0, 20, 2, 0, 0, 0, 0, 0, 3, 0
      }, //
      {125, "Cestus",
          "The cestus is a glove of leather or thick cloth that covers the wielder from mid-finger to mid-forearm. The close combat weapon is reinforced with metal plates over the fingers and often lined with wicked spikes along the backs of the hands and wrists. While wearing a cestus, you are considered armed and your unarmed attacks deal normal damage. If you are proficient with a cestus, your unarmed strikes may deal bludgeoning or piercing damage. Monks are proficient with the cestus. When using a cestus, your fingers are mostly exposed, allowing you to wield or carry items in that hand, but the constriction of the weapon at your knuckles gives you a -2 penalty on all precision-based tasks involving that hand (such as opening locks).",
          5f, 1f, 1, 2, 0, 19, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {126, "Wooden stake",
          "This close combat weapon is just a sharpened piece of wood. Iron spikes used as weapons deal damage as wooden stakes.",
          0f, 1f, 1, 2, 0, 20, 2, 0, 0, 0, 0, 0, 5, 10
      }, //
      {127, "Bayonet",
          "Bayonets are close combat weapons designed to fit into the grooves or muzzles of crossbows and firearms. They allow you to make melee attacks with these weapons but render them temporarily useless as ranged weapons. Attaching or removing a bayonet is a move action.",
          5f, 1f, 1, 3, 0, 20, 2, 0, 0, 0, 2, 0, 76, 0
      }, //
      {128, "Boar spear",
          "This spear with a spiraling blade has a metal crossbar approximately halfway down its length. If you ready a boar spear against a charge and your attack hits, you get a +2 shield bonus to your AC against that creature until your next turn.",
          5f, 8f, 1, 4, 0, 20, 2, 0, 0, 0, 2, 0, 11, 0
      }, //
      {129, "Sword cane",
          "This slender light blade lies within a wooden container that serves as both its scabbard and hiding place. You can draw the blade from the cane as a swift action (or a free action if you have the Quick Draw feat). An observer must make a DC 20 Perception check to realize an undrawn sword cane is a weapon rather than a walking stick, the DC decreases to 10 if the observer is able to handle the weapon.",
          45f, 4f, 1, 3, 0, 20, 2, 1, 0, 0, 1, 0, 25, 0
      }, //
      {130, "Bardiche",
          "The crescent axe-blade of this polearm is attached to the haft at two points: the center of the blade attaches to a socket at the top of the haft, and the lower point of the blade attaches to a secondary mount point. The blade is often very long, sometimes almost as long as the haft. You gain a +2 bonus to your CMD to resist sunder attempts against a bardiche.",
          13f, 14f, 1, 5, 0, 19, 2, 1, 0, 0, 2, 1, 77, 0
      }, //
      {131, "Bec de corbin",
          "The bec de corbin is a polearm very similar to the lucerne hammer, but the hammer head is blunt rather than spiked and the spike is stouter and more hooked. You primarily attack with the spike. You gain a +2 bonus to your CMB to sunder medium or heavy armor with a bec de corbin.",
          15f, 12f, 1, 5, 0, 20, 3, 1, 0, 0, 2, 0, 78, 0
      }, //
      {132, "Bill",
          "The blade of this polearm is a curved or hooked chopping blade with a spiked projection on the back of the blade. The spike is commonly used to block and parry. When fighting defensively or with full defense, this weapon gives you a +1 shield bonus to AC. A mounted opponent hit by a bill takes a -1 penalty on his Ride check to stay mounted.",
          11f, 11f, 1, 4, 0, 20, 3, 1, 0, 0, 2, 1, 79, 0
      }, //
      {133, "Glaive-guisarme",
          "This polearm combines the blade of a glaive with a wicked hook. A mounted opponent hit by a glaive-guisarme takes a -2 penalty on his Ride check to stay mounted.",
          12f, 10f, 1, 5, 0, 20, 3, 1, 0, 0, 2, 1, 80, 0
      }, //
      {134, "Lucerne hammer",
          "This polearm has both a pronged hammer head for crushing blows and a spiked head for piercing and peeling armor, most attacks are made with the hammer. The long haft allows the wielder to put amazing force behind the head of this weapon. You gain a +2 bonus to your CMB to sunder medium or heavy armor with a lucerne hammer.",
          15f, 12f, 1, 6, 0, 20, 2, 1, 0, 0, 2, 1, 81, 0
      }, //
      {135, "Arrow, blunt (20)",
          "These arrows have rounded wooden tips. They deal bludgeoning damage rather than piercing damage. An archer can use a blunt arrow to deal nonlethal damage (at the normal -4 attack penalty for using a lethal weapon to deal nonlethal damage).",
          2f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 70, 0
      }, //
      {136, "Arrow, flight (20)",
          "These arrows have light shafts and special fletchings to give them greater range. A flight arrow''s range increment is 20 feet greater with longbows, 10 feet greater with shortbows. They deal damage as if one size category smaller.",
          2f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 70, 0
      }, //
      {137, "Arrow, smoke",
          "This arrow is actually a specially-shaped smokestick that can be fired from a bow. It trails smoke as it flies, and creates a 5-foot cube of smoke where it strikes. It otherwise functions like a normal arrow in terms of damage, range, and so on.",
          10f, 0f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 70, 0
      }, //
      {138, "Chakram",
          "The chakram is a simple, elegant, and highly portable thrown weapon. It is a flat, open-centered metal discus with a sharpened edge. You can wield the chakram as a melee weapon, but it is not designed for such use, you take a -1 penalty on your attack roll with the weapon and must make a DC 15 Reflex save or cut yourself on the blade (half damage, no Strength modifier). You do not need to make this save if wearing heavy armor.",
          1f, 1f, 1, 4, 0, 20, 2, 1, 0, 1, 0, 0, 82, 30
      }, //
      {139, "Pilum",
          "The tip of this heavy javelin is designed to break off and embed itself into a shield once it hits. Like ammunition, a thrown pilum that hits its target is destroyed. If you hit a shield-using opponent with a pilum, he loses the AC bonuses from that shield until he takes a standard action to pry the remnants of the pilum from his shield.",
          5f, 4f, 1, 4, 0, 20, 2, 1, 0, 1, 0, 0, 16, 20
      }, //
      {140, "Swordbreaker dagger",
          "You can use this dagger to disarm or sunder enemy blades by catching them in the grooves on the back of the blade and using your weapon as a lever. If you are proficient with this weapon, add +4 on your disarm or sunder attempts against bladed weapons.",
          10f, 3f, 1, 2, 0, 20, 2, 2, 0, 0, 0, 0, 2, 0
      }, //
      {141, "Falcata",
          "This heavy blade has a single sharp, concave edge and a hook-shaped hilt. Its shape distributes the weight to give it the momentum of an axe with the cutting edge of a sword.",
          18f, 4f, 1, 4, 0, 19, 3, 2, 0, 0, 1, 0, 83, 0
      }, //
      {142, "Khopesh", "This heavy blade has a convex curve near the end, making its overall shape similar to a battleaxe.", 20f,
          8f, 1, 4, 0, 19, 2, 2, 0, 0, 1, 0, 84, 0
      }, //
      {143, "Temple sword",
          "Heavy blades typically used by guardians of religious sites, temple swords have distinctive crescent-shaped blades, appearing as an amalgam of a sickle and sword. Many have holes drilled into the blade or places on the pommel where charms, bells, or other holy trinkets might be attached. Monks are proficient with the temple sword.",
          30f, 3f, 1, 4, 0, 19, 2, 2, 0, 0, 1, 0, 85, 0
      }, //
      {144, "Chain spear",
          "This vicious weapon often finds its way into gladiatorial events due to its versatility. The body of the weapon is a standard short spear, primarily used for thrusting. The butt of the spear is fitted with a length of chain, often spiked, with a hook at the end. The hook and chain may be used to make trip attacks. If your trip attack fails by 10 or more, you may drop the chain spear to avoid being knocked prone.",
          15f, 13f, 1, 3, 0, 20, 2, 2, 0, 0, 2, 0, 11, 0
      }, //
      {145, "Mancatcher",
          "This polearm consists of two curved metal bands that close around a target when you attack, allowing you to bind an opponent. A mancatcher is built to capture a creature of a particular size category (such as Small or Medium) and doesn''t work on creatures of the wrong size. Make a touch attack to hit an opponent and a combat maneuver check to grapple him (without the -4 penalty for not having two hands free), success means you and the target are grappled. Once the target is grappled, you can perform a move or damage grapple action against him. The mancatcher has hardness 10 and 5 hit points, it requires a DC 26 Strength check to break it. If you drop the mancatcher, the target can free himself as a standard action.",
          15f, 10f, 1, 0, 0, 0, 0, 2, 0, 0, 2, 1, 86, 0
      }, //
      {146, "Boomerang",
          "The boomerang is primarily a hunting tool, but it is not uncommon for these versatile thrown weapons to be carried into battle. A boomerang is made of wood and is flat, with a long haft, a pronounced forward curve, and a sharp backward bend at the head. A thrown boomerang does not fly in a returning path, returning boomerangs are solely recreational.",
          3f, 3f, 1, 3, 0, 20, 2, 2, 0, 1, 0, 0, 87, 30
      }, //
      {147, "Double crossbow",
          "This heavy weapon fires a pair of iron-tipped bolts with a single squeeze of the trigger. Due to its size and weight, you take a -4 penalty on your attack roll if you''re proficient with it, or -8 if you''re not. If the attack hits, the target takes damage from both bolts. Critical hits, sneak attack damage, and other precision-based damage only apply to the first bolt. Reloading one bolt is a standard action, the Rapid Reload feat reduces this to a move action. Crossbow Mastery allows you to reload both bolts as a move action",
          300f, 18f, 1, 4, 0, 19, 2, 2, 0, 1, 0, 0, 88, 80
      }, //
      {148, "Lasso",
          "This thrown weapon is a length of rope with a simple open knot on one end that allows you entangle a foe like you would using a net. The DC to cast a spell while entangled with a lasso is 10 + the spell level being cast. An entangled creature can slip free with a DC 15 Escape Artist check as a full-round action. The lasso has 2 hit points and AC 10. It requires a DC 23 Strength check to break it. On a successful hit, the lasso tightens, to use it again you must spend a standard action sliding the knot to enlarge the loop.",
          0.1f, 5f, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 89, 0
      }, //
      {149, "Dustburst bullet ",
          "This gritty and irregular +1 sling bullet explodes into a cloud of choking dust when it successfully strikes its target. This fills a 5-foot cube and follows the target for 1d6 rounds before dispersing. Any creature ending its turn in the cloud must make a DC 13 Fortitude save or be sickened and blinded for 1 round.",
          196f, 0.5f, 0, 0, 1, 0, 0, 0, 2, 1, 1, 4, 17, 50
      }, //
      {150, "Tangle bolt ",
          "Often etched with images of spider webs or swampy vines, this sickly green +1 seeking bolt transforms into sticky goo when it hits, entangling its target and becoming tough and resilient upon exposure to air. In addition to the bolt damage, the target is entangled as if it had been hit by a tanglefoot bag.",
          226f, 0f, 0, 0, 1, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {151, "Searing arrow ",
          "This +1 flaming arrow continues to burn its target each round, dealing 1d6 fire damage on the attacker''s turn for the next 3 rounds. Removing the arrow requires a DC 10 Heal check and prevents any further damage from the arrow (the DC increases to 15 if the target tries to remove the arrow from himself). Removing the arrow destroys it, and it burns up once the 3 rounds pass.",
          1516f, 0f, 0, 0, 1, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {152, "Sizzling arrow ",
          "This +1 corrosive arrow continues to leak acid onto its target each round, dealing 1d6 acid damage on the attacker''s turn for the next 3 rounds. Removing the arrow is a DC 10 Heal check and prevents any further damage from the arrow (the DC increases to 15 if the target tries to remove the arrow from himself). Removing the arrow destroys it, and it dissolves up once the 3 rounds pass.",
          1516f, 0f, 0, 0, 1, 0, 0, 3, 2, 1, 0, 5, 70, 0
      }, //
      {153, "Lance of jousting ",
          "This ornately designed +1 lance streams with ribbons and small favors, allowing a wielder to more effectively knock an opponent from his mount. A successful hit with a lance of jousting on a mounted opponent forces the target to make a Ride check (DC 10 + damage dealt) to avoid being knocked from the saddle. Although used in combat to remove a mounted foe''s advantage, use of a lance of jousting in a tournament or similar contest is generally considered a dishonorable form of cheating.",
          4310f, 10f, 1, 4, 1, 20, 3, 1, 2, 0, 2, 1, 42, 0
      }, //
      {154, "Boulderhead mace ",
          "The head of this +1 heavy mace is made from a single piece of roughly spherical granite. Once per day the wielder can command the mace to release this head, which grows to the size of a Large boulder and rolls quickly in a direction the wielder specifies. The boulder rolls in a straight line up to 60 feet, trampling everything in its path for 3d8+5 damage (Reflex half DC 19). The boulder collapses into rubble and dust at the end of its path or if it encounters an obstacle it cannot break through or roll over, creating a 10-foot-square area of difficult terrain. A new stone mace-head grows on the weapon''s haft over the next 24 hours, and it is unusable as a weapon until the head regrows.",
          6812f, 8f, 1, 4, 1, 20, 2, 0, 2, 0, 1, 0, 6, 0
      }, //
      {155, "Beaststrike club ",
          "This +1 club is often decorated with large teeth and carved with stylized images of different animals. As a standard action, the wielder may transform the club into the head or limb of an animal, the weapon''s damage does not change but the type of damage changes to suit the shape of the club: bite (piercing), claw (slashing), gore (piercing), slam (bludgeoning), sting (piercing), or talon (slashing). When transformed, the club counts as a natural weapon and a manufactured weapon for the purpose of spells and effects that enhance or improve either manufactured or natural weapons. The club also counts as the natural weapon of its current shape for the purpose of feats and spells that rely on specific natural weapons, such as Weapon Focus (bite) or the bloody claws spell. If the wielder has the wild shape ability, she can expend one use of wild shape to increase the weapon''s damage by one step for the duration of that wild shape as long as the druid remains in contact with the weapon, if the wielder can wild shape at will, the club''s damage is always increased in this fashion. If unattended, the club reverts to its normal shape.",
          7300f, 3f, 1, 3, 1, 20, 2, 0, 2, 0, 1, 0, 5, 10
      }, //
      {156, "Trident of stability ",
          "The base of this sturdy but tarnished +1 trident has a wide metal bar at the bottom, perfectly situated to serve as a solid footrest or other sort of handle. The bar acts as an immovable rod, except instead of an activation button, the immobility power triggers whenever the wielder places one or both feet on the bar, and ends whenever the wielder is no longer touching the bar with at least one foot. If the wielder remains in place and steps on the bar, he gains a +10 bonus to his CMD when trying to resist efforts to move him. The wielder is always considered braced against oncoming charge attacks. If the wielder is falling, he may step on the bar as an immediate action to halt his fall, though the sudden jolt means he takes falling damage for the current distance fallen.",
          9815f, 4f, 1, 4, 1, 20, 2, 1, 2, 0, 1, 0, 32, 10
      }, //
      {157, "Blade of binding ",
          "This +1 greatsword is decorated with a chain motif. On a successful hit with the sword against a creature of the wielder''s size or smaller creature, the wielder can attempt to start a grapple as a free action that doesn''t provoke an attack of opportunity. If the wielder succeeds at the grapple, the sword blade transforms into a metal chain and wraps around the target, giving the wielder a +5 bonus on further grapple checks against the target. If the target escapes the grapple or the wielder decides to release the target from the grapple, the chain reverts to sword form (with the wielder holding the handle).<br>The wielder can also let go of the chain''s handle while grappling or pinning the target, if so, the chain remains in place and the target gains the entangled condition (Escape Artist DC 20 to slip free, break DC 28, hardness 10, 10 hit points, concentration DC 17 to cast spells while entangled). Another creature can grab the chain''s handle as a standard action and will it to revert to sword form as a swift action, which releases the bound creature. If the chain is destroyed, it reverts to sword form and the weapon gains the broken condition.",
          12350f, 8f, 2, 3, 1, 19, 2, 1, 2, 0, 2, 0, 39, 0
      }, //
      {158, "Shieldsplitter lance ",
          "This +1 keen lance has the ability to penetrate and destroy shields. Whenever its wielder uses it to successfully strike an opponent who carries a shield, the opponent''s shield takes the same damage as the opponent. If the wielder uses the lance to make a sunder attack against a shield, it bypasses the shield''s hardness.",
          18310f, 10f, 1, 4, 1, 20, 3, 1, 2, 0, 2, 1, 42, 0
      }, //
      {159, "Ricochet hammer ",
          "This +1 returning light hammer can strike multiple foes with a single throw. If the wielder has multiple attacks from a high base attack bonus, he may throw the hammer so it rebounds off the first target to strike at a second target, and so on for each of the wielder''s additional attacks. The distance to each target adds to the total range of the weapon, and range penalties apply. For example, a 6th-level dwarf fighter can throw the hammer using his +6 BAB at a target 20 feet away (within one range increment, no range penalty), if it hits, he ricochets it to a attack using his +1 BAB at a second target 40 feet away from the first target (within three range increments for a -4 range penalty). The hammer can only ricochet if it successfully hits a target, if it misses, it stops ricocheting and has no further attacks that round, and returns as normal for a weapon with the returning property. Because ricocheting attacks are treated as separate attacks, modifiers that only apply to one attack roll (such as true strike) only apply to the first attack and not the others. The ricochet attacks count as the wielder''s additional attacks for that round.",
          20301f, 2f, 1, 2, 1, 20, 2, 1, 2, 0, 0, 0, 19, 20
      }, //
      {160, "Sparkwake starknife ",
          "A faint trail of sparks marks the passage of this +1 shock starknife whenever it is thrown. Once per day its wielder may throw it so it transforms into an 8d6 lightning bolt (Reflex DC 14 half), returning to its physical form at the end of the bolt''s path.",
          21324f, 3f, 1, 2, 1, 20, 3, 1, 2, 0, 0, 0, 24, 20
      }, //
      {161, "Undercutting axe ",
          "This +1 giant-bane battleaxe feels unusually heavy, as if it were made from something far heavier than mere wood and steel. Once per day its wearer can, as a swift action after a successful attack roll, invoke a maximized ray of enfeeblement on the creature struck (11 point Strength penalty, 7 rounds, Fortitude DC 16 for half).",
          23310f, 6f, 1, 4, 1, 20, 3, 1, 2, 0, 1, 0, 26, 0
      }, //
      {162, "Spirit blade ",
          "This almost transparently thin weapon is often decorated with strange faces and swirling mist. In addition to being a +3 ghost touch dagger, it can cast dispel magic once per day.",
          48502f, 1f, 1, 2, 3, 19, 2, 0, 2, 0, 0, 0, 2, 10
      }, //
      {163, "Guarding blade ",
          "This +1 dancing short sword automatically rises up to defend a fallen or sleeping wielder. To trigger the sword''s activation, the wielder must fall unconscious or die while wielding the weapon or holding it in hand. Thereafter, should any creature other than an ally of the wielder attempt to touch or strike him with melee attacks, the sword attacks that creature for up to 4 rounds. After 4 rounds, the weapon drops in the wielder''s square. Unless the guarding blade is an intelligent item, it lacks the wits to make decisions about which is the best opponent to attack, and when confronted by multiple opponents attacking the wielder it tends to select a random target each round.",
          65310f, 2f, 1, 3, 1, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
  };

  /**
   * All weapons
   */
  public static final Object[][] WEAPON_FAMILY = { //
      // id, name
      {1, "Unarmed strike"}, //
      {2, "Dagger"}, //
      {3, "Mace, light"}, //
      {4, "Sickle"}, //
      {5, "Club"}, //
      {6, "Mace, heavy"}, //
      {7, "Morningstar"}, //
      {8, "Shortspear"}, //
      {9, "Longspear"}, //
      {10, "Quarterstaff"}, //
      {11, "Spear"}, //
      {12, "Blowgun"}, //
      {13, "Crossbow, heavy"}, //
      {14, "Crossbow, light"}, //
      {15, "Dart"}, //
      {16, "Javelin"}, //
      {17, "Sling"}, //
      {18, "Axe, throwing"}, //
      {19, "Hammer, light"}, //
      {20, "Handaxe"}, //
      {21, "Kukri"}, //
      {22, "Pick, light"}, //
      {23, "Sap"}, //
      {24, "Starknife"}, //
      {25, "Sword, short"}, //
      {26, "Battleaxe"}, //
      {27, "Flail"}, //
      {28, "Longsword"}, //
      {29, "Pick, heavy"}, //
      {30, "Rapier"}, //
      {31, "Scimitar"}, //
      {32, "Trident"}, //
      {33, "Warhammer"}, //
      {34, "Falchion"}, //
      {35, "Glaive"}, //
      {36, "Greataxe"}, //
      {37, "Greatclub"}, //
      {38, "Flail, heavy"}, //
      {39, "Greatsword"}, //
      {40, "Guisarme"}, //
      {41, "Halberd"}, //
      {42, "Lance"}, //
      {43, "Ranseur"}, //
      {44, "Scythe"}, //
      {45, "Longbow"}, //
      {46, "Longbow, composite"}, //
      {47, "Shortbow"}, //
      {48, "Shortbow, composite"}, //
      {49, "Kama"}, //
      {50, "Nunchaku"}, //
      {51, "Sai"}, //
      {52, "Siangham"}, //
      {53, "Sword, bastard"}, //
      {54, "Waraxe, dwarven"}, //
      {55, "Whip"}, //
      {56, "Axe, orc double"}, //
      {57, "Chain, spiked"}, //
      {58, "Curve blade, elven"}, //
      {59, "Flail, dire"}, //
      {60, "Hammer, gnome hooked"}, //
      {61, "Sword, two-bladed"}, //
      {62, "Urgrosh, dwarven"}, //
      {63, "Bolas"}, //
      {64, "Crossbow, hand"}, //
      {65, "Crossbow, repeating heavy"}, //
      {66, "Crossbow, repeating light"}, //
      {67, "Net"}, //
      {68, "Shuriken"}, //
      {69, "Sling staff, halfling"}, //
      {70, "Ammunition"}, //
      {71, "Grapple"}, //
      {72, "Ray"}, //
      {73, "Shield, light"}, //
      {74, "Shield, heavy"}, //
      {75, "Spiked armor"}, //
      {76, "Bayonet"}, //
      {77, "Bardiche"}, //
      {78, "Bec de corbin"}, //
      {79, "Bill"}, //
      {80, "Glaive-guisarme"}, //
      {81, "Lucerne hammer"}, //
      {82, "Chakram"}, //
      {83, "Falcata"}, //
      {84, "Khopesh"}, //
      {85, "Temple sword"}, //
      {86, "Mancatcher"}, //
      {87, "Boomerang"}, //
      {88, "Double crossbow"}, //
      {89, "Lasso"}, //
  };

}
