package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores all weapons of DnDv35.
 */
public class DnDv35WeaponStorage {

  /**
   * All weapons
   */
  public static final Object[][] WEAPON = { //
      // id, name, description, cost, weight, number of dice, die, bonus, critical hit, critical modifier, weapon
      // type, quality type, weapon combat, weapon encumbrance, weapon category, weapon type
      {0, "Gauntlet",
          "This metal glove lets you deal lethal damage rather than nonlethal damage with unarmed strikes. A strike with a gauntlet is otherwise considered an unarmed attack. The cost and weight given are for a single gauntlet. Medium and heavy armors (except breastplate) come with gauntlets.",
          2f, 1f, 1, 1, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {1, "Dagger",
          "You get a +2 bonus on Sleight of Hand checks made to conceal a dagger on your body (see the Sleight of Hand skill)", 2f,
          1f, 1, 2, 0, 19, 2, 0, 0, 0, 0, 0, 2, 10
      }, //
      {2, "Dagger, punching", "", 2f, 1f, 1, 2, 0, 20, 3, 0, 0, 0, 0, 0, 2, 0}, //
      {3, "Gauntlet, spiked",
          "Your opponent cannot use a disarm action to disarm you of spiked gauntlets. The cost and weight given are for a single gauntlet. An attack with a spiked gauntlet is considered an armed attack.",
          5f, 1f, 1, 2, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {4, "Mace, light", "", 5f, 4f, 1, 3, 0, 20, 2, 0, 0, 0, 0, 0, 3, 0}, //
      {5, "Sickle",
          "A sickle can be used to make trip attacks. If you are tripped during your own trip attempt, you can drop the sickle to avoid being tripped.",
          6f, 2f, 1, 3, 0, 20, 2, 0, 0, 0, 0, 0, 4, 0
      }, //
      {6, "Club", "", 0f, 3f, 1, 3, 0, 20, 2, 0, 0, 0, 1, 0, 5, 10}, //
      {7, "Mace, heavy", "", 12f, 8f, 1, 4, 0, 20, 2, 0, 0, 0, 1, 0, 6, 0}, //
      {8, "Morningstar", "", 8f, 6f, 1, 4, 0, 20, 2, 0, 0, 0, 1, 0, 7, 0}, //
      {9, "Shortspear", "A shortspear is small enough to wield one-handed. It may also be thrown.", 1f, 3f, 1, 3, 0, 20, 2, 0, 0, 0,
          1, 0, 8, 20
      }, //
      {10, "Longspear",
          "A longspear has reach. You can strike opponents 10 feet away with it, but you can''t use it against an adjacent foe. If you use a ready action to set a longspear against a charge, you deal double damage on a successful hit against a charging character.",
          5f, 9f, 1, 4, 0, 20, 3, 0, 0, 0, 2, 1, 9, 0
      }, //
      {11, "Quarterstaff",
          "A quarterstaff is a double weapon. You can fight with it as if fighting with two weapons, but if you do, you incur all the normal attack penalties associated with fighting with two weapons, just as if you were using a one-handed weapon and a light weapon. A creature wielding a quarterstaff in one hand can''t use it as a double weapon - only one end of the weapon can be used in any given round.\nThe quarterstaff is a special monk weapon. This designation gives a monk wielding a quarterstaff special options.\n",
          0f, 4f, 1, 3, 0, 20, 2, 0, 0, 0, 2, 2, 10, 0
      }, //
      {12, "Spear",
          "A spear can be thrown. If you use a ready action to set a spear against a charge, you deal double damage on a successful hit against a charging character.",
          2f, 6f, 1, 4, 0, 20, 3, 0, 0, 0, 2, 0, 11, 20
      }, //
      {13, "Crossbow, heavy",
          "You draw a heavy crossbow back by turning a small winch. Loading a heavy crossbow is a full-round action that provokes attacks of opportunity.\nNormally, operating a heavy crossbow requires two hands. However, you can shoot, but not load, a heavy crossbow with one hand at a -4 penalty on attack rolls. You can shoot a heavy crossbow with each hand, but you take a penalty on attack rolls as if attacking with two one-handed weapons. This penalty is cumulative with the penalty for one-handed firing.",
          50f, 8f, 1, 5, 0, 19, 2, 0, 0, 1, 1, 4, 12, 120
      }, //
      {14, "Crossbow, light",
          "You draw a light crossbow back by pulling a lever. Loading a light crossbow is a move action that provokes attacks of opportunity.\nNormally, operating a light crossbow requires two hands. However, you can shoot, but not load, a light crossbow with one hand at a -2 penalty on attack rolls. You can shoot a light crossbow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons. This penalty is cumulative with the penalty for one-handed firing.",
          35f, 4f, 1, 4, 0, 19, 2, 0, 0, 1, 1, 4, 13, 80
      }, //
      {15, "Dart", "", 5f, 0.5f, 1, 2, 0, 20, 2, 0, 0, 1, 0, 3, 14, 20}, //
      {16, "Javelin",
          "Since it is not designed for melee, you are treated as nonproficient with it and take a -4 penalty on attack rolls if you use a javelin as a melee weapon.",
          1f, 2f, 1, 3, 0, 20, 2, 0, 0, 1, 1, 3, 15, 30
      }, //
      {17, "Sling",
          "Your Strength modifier applies to damage rolls when you use a sling, just as it does for thrown weapons. You can fire, but not load, a sling with one hand. Loading a sling is a move action that requires two hands and provokes attacks of opportunity.\nYou can hurl ordinary stones with a sling, but stones are not as dense or as round as bullets. Thus, such an attack deals damage as if the weapon were designed for a creature one size category smaller than you and you take a -1 penalty on attack rolls.\n",
          0f, 0.1f, 1, 2, 0, 20, 2, 0, 0, 1, 1, 4, 16, 50
      }, //
      {18, "Axe, throwing", "", 8f, 2f, 1, 3, 0, 20, 2, 1, 0, 0, 0, 3, 17, 10}, //
      {19, "Hammer, light", "", 1f, 2f, 1, 2, 0, 20, 2, 1, 0, 0, 0, 3, 18, 20}, //
      {20, "Handaxe", "", 6f, 3f, 1, 3, 0, 20, 3, 1, 0, 0, 0, 0, 19, 0}, //
      {21, "Kukri", "", 8f, 2f, 1, 2, 0, 18, 2, 1, 0, 0, 0, 0, 20, 0}, //
      {22, "Pick, light", "", 4f, 3f, 1, 2, 0, 20, 4, 1, 0, 0, 0, 0, 21, 0}, //
      {23, "Sap", "", 1f, 2f, 1, 3, 0, 20, 2, 1, 0, 0, 0, 0, 22, 0}, //
      {24, "Sword, short", "", 10f, 2f, 1, 3, 0, 19, 2, 1, 0, 0, 0, 0, 25, 0}, //
      {25, "Battleaxe", "", 10f, 6f, 1, 4, 0, 20, 3, 1, 0, 0, 1, 0, 26, 0}, //
      {26, "Flail",
          "With a flail, you get a +2 bonus on opposed attack rolls made to disarm an enemy (including the roll to avoid being disarmed if such an attempt fails).\nYou can also use this weapon to make trip attacks. If you are tripped during your own trip attempt, you can drop the flail to avoid being tripped.\n",
          8f, 5f, 1, 4, 0, 20, 2, 1, 0, 0, 1, 0, 27, 0
      }, //
      {27, "Longsword", "", 15f, 4f, 1, 4, 0, 19, 2, 1, 0, 0, 1, 0, 28, 0}, //
      {28, "Pick, heavy", "", 8f, 6f, 1, 3, 0, 20, 4, 1, 0, 0, 1, 0, 29, 0}, //
      {29, "Rapier",
          "You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a rapier sized for you, even though it isn''t a light weapon for you. You can''t wield a rapier in two hands in order to apply 1-1/2 times your Strength bonus to damage.",
          20f, 2f, 1, 3, 0, 18, 2, 1, 0, 0, 1, 0, 30, 0
      }, //
      {30, "Scimitar", "", 15f, 4f, 1, 3, 0, 18, 2, 1, 0, 0, 1, 0, 31, 0}, //
      {31, "Trident",
          "This weapon can be thrown. If you use a ready action to set a trident against a charge, you deal double damage on a successful hit against a charging character.",
          15f, 4f, 1, 4, 0, 20, 2, 1, 0, 0, 1, 0, 33, 10
      }, //
      {32, "Warhammer", "", 12f, 5f, 1, 4, 0, 20, 3, 1, 0, 0, 1, 0, 34, 0}, //
      {33, "Falchion", "", 75f, 8f, 2, 2, 0, 18, 2, 1, 0, 0, 2, 0, 35, 0}, //
      {34, "Glaive",
          "A glaive has reach. You can strike opponents 10 feet away with it, but you can''t use it against an adjacent foe.", 8f,
          10f, 1, 5, 0, 20, 3, 1, 0, 0, 2, 1, 36, 0
      }, //
      {35, "Greataxe", "", 20f, 12f, 1, 6, 0, 20, 3, 1, 0, 0, 2, 0, 37, 0}, //
      {36, "Greatclub", "", 5f, 8f, 1, 5, 0, 20, 2, 1, 0, 0, 2, 0, 38, 0}, //
      {37, "Flail, heavy",
          "With a flail, you get a +2 bonus on opposed attack rolls made to disarm an enemy (including the roll to avoid being disarmed if such an attempt fails).\nYou can also use this weapon to make trip attacks. If you are tripped during your own trip attempt, you can drop the flail to avoid being tripped.\n",
          15f, 10f, 1, 5, 0, 19, 2, 1, 0, 0, 2, 0, 39, 0
      }, //
      {38, "Greatsword", "", 50f, 8f, 2, 3, 0, 19, 2, 1, 0, 0, 2, 0, 40, 0}, //
      {39, "Guisarme",
          "A guisarme has reach. You can strike opponents 10 feet away with it, but you can''t use it against an adjacent foe.\nYou can also use it to make trip attacks. If you are tripped during your own trip attempt, you can drop the guisarme to avoid being tripped.\n",
          9f, 12f, 2, 2, 0, 20, 3, 1, 0, 0, 2, 1, 41, 0
      }, //
      {40, "Halberd",
          "If you use a ready action to set a halberd against a charge, you deal double damage on a successful hit against a charging character.\nYou can use a halberd to make trip attacks. If you are tripped during your own trip attempt, you can drop the halberd to avoid being tripped.\n",
          10f, 12f, 1, 5, 0, 20, 3, 1, 0, 0, 2, 0, 42, 0
      }, //
      {41, "Lance",
          "A lance deals double damage when used from the back of a charging mount. It has reach, so you can strike opponents 10 feet away with it, but you can''t use it against an adjacent foe.\nWhile mounted, you can wield a lance with one hand.\n",
          10f, 10f, 1, 4, 0, 20, 3, 1, 0, 0, 2, 1, 43, 0
      }, //
      {42, "Ranseur",
          "A ranseur has reach. You can strike opponents 10 feet away with it, but you can''t use it against an adjacent foe.\nWith a ranseur, you get a +2 bonus on opposed attack rolls made to disarm an opponent (including the roll to avoid being disarmed if such an attempt fails).\n",
          10f, 12f, 2, 2, 0, 20, 3, 1, 0, 0, 2, 1, 44, 0
      }, //
      {43, "Scythe",
          "A scythe can be used to make trip attacks. If you are tripped during your own trip attempt, you can drop the scythe to avoid being tripped.",
          18f, 10f, 2, 2, 0, 20, 4, 1, 0, 0, 2, 0, 45, 0
      }, //
      {44, "Longbow",
          "You need at least two hands to use a bow, regardless of its size. A longbow is too unwieldy to use while you are mounted. If you have a penalty for low Strength, apply it to damage rolls when you use a longbow. If you have a bonus for high Strength, you can apply it to damage rolls when you use a composite longbow (see below) but not a regular longbow.",
          75f, 3f, 1, 4, 0, 20, 3, 1, 0, 1, 2, 4, 46, 100
      }, //
      {45, "Longbow, composite",
          "You need at least two hands to use a bow, regardless of its size. You can use a composite longbow while mounted. All composite bows are made with a particular strength rating (that is, each requires a minimum Strength modifier to use with proficiency). If your Strength bonus is less than the strength rating of the composite bow, you can''t effectively use it, so you take a -2 penalty on attacks with it. The default composite longbow requires a Strength modifier of +0 or higher to use with proficiency. A composite longbow can be made with a high strength rating to take advantage of an above-average Strength score, this feature allows you to add your Strength bonus to damage, up to the maximum bonus indicated for the bow. Each point of Strength bonus granted by the bow adds 100 gp to its cost.\nFor purposes of weapon proficiency and similar feats, a composite longbow is treated as if it were a longbow.\n",
          100f, 3f, 1, 4, 0, 20, 3, 1, 0, 1, 2, 4, 47, 110
      }, //
      {46, "Shortbow",
          "You need at least two hands to use a bow, regardless of its size. You can use a shortbow while mounted. If you have a penalty for low Strength, apply it to damage rolls when you use a shortbow. If you have a bonus for high Strength, you can apply it to damage rolls when you use a composite shortbow (see below) but not a regular shortbow.",
          30f, 2f, 1, 3, 0, 20, 3, 1, 0, 1, 2, 4, 48, 60
      }, //
      {47, "Shortbow, composite",
          "You need at least two hands to use a bow, regardless of its size. You can use a composite shortbow while mounted. All composite bows are made with a particular strength rating (that is, each requires a minimum Strength modifier to use with proficiency). If your Strength bonus is lower than the strength rating of the composite bow, you can''t effectively use it, so you take a -2 penalty on attacks with it. The default composite shortbow requires a Strength modifier of +0 or higher to use with proficiency. A composite shortbow can be made with a high strength rating to take advantage of an above-average Strength score, this feature allows you to add your Strength bonus to damage, up to the maximum bonus indicated for the bow. Each point of Strength bonus granted by the bow adds 75 gp to its cost. \nFor purposes of weapon proficiency and similar feats, a composite shortbow is treated as if it were a shortbow.\n",
          75f, 2f, 1, 3, 0, 20, 3, 1, 0, 1, 2, 4, 49, 70
      }, //
      {48, "Kama",
          "The kama is a special monk weapon. This designation gives a monk wielding a kama special options.\nYou can use a kama to make trip attacks. If you are tripped during your own trip attempt, you can drop the kama to avoid being tripped.\n",
          2f, 2f, 1, 3, 0, 20, 2, 2, 0, 0, 0, 0, 50, 0
      }, //
      {49, "Nunchaku",
          "The nunchaku is a special monk weapon. This designation gives a monk wielding a nunchaku special options. With a nunchaku, you get a +2 bonus on opposed attack rolls made to disarm an enemy (including the roll to avoid being disarmed if such an attempt fails).",
          2f, 2f, 1, 3, 0, 20, 2, 2, 0, 0, 0, 0, 51, 0
      }, //
      {50, "Sai",
          "You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a rapier sized for you, even though it isn''t a light weapon for you. You can''t wield a rapier in two hands in order to apply 1-1/2 times your Strength bonus to damage.With a sai, you get a +4 bonus on opposed attack rolls made to disarm an enemy (including the roll to avoid being disarmed if such an attempt fails).\nThe sai is a special monk weapon. This designation gives a monk wielding a sai special options.\n",
          1f, 1f, 1, 2, 0, 20, 2, 2, 0, 0, 0, 0, 52, 10
      }, //
      {51, "Siangham", "The siangham is a special monk weapon. This designation gives a monk wielding a siangham special options.",
          3f, 1f, 1, 3, 0, 20, 2, 2, 0, 0, 0, 0, 53, 0
      }, //
      {52, "Sword, bastard",
          "A bastard sword is too large to use in one hand without special training, thus, it is an exotic weapon. A character can use a bastard sword two-handed as a martial weapon.",
          35f, 6f, 1, 5, 0, 19, 2, 2, 0, 0, 1, 0, 54, 0
      }, //
      {53, "Waraxe, dwarven",
          "A dwarven waraxe is too large to use in one hand without special training, thus, it is an exotic weapon. A Medium character can use a dwarven waraxe two-handed as a martial weapon, or a Large creature can use it one-handed in the same way. A dwarf treats a dwarven waraxe as a martial weapon even when using it in one hand.",
          30f, 8f, 1, 5, 0, 20, 3, 2, 0, 0, 1, 0, 55, 0
      }, //
      {54, "Whip",
          "A whip deals nonlethal damage. It deals no damage to any creature with an armor bonus of +1 or higher or a natural armor bonus of +3 or higher. The whip is treated as a melee weapon with 15-foot reach, though you don''t threaten the area into which you can make an attack. In addition, unlike most other weapons with reach, you can use it against foes anywhere within your reach (including adjacent foes).\nUsing a whip provokes an attack of opportunity, just as if you had used a ranged weapon.\nYou can make trip attacks with a whip. If you are tripped during your own trip attempt, you can drop the whip to avoid being tripped.\nWhen using a whip, you get a +2 bonus on opposed attack rolls made to disarm an opponent (including the roll to keep from being disarmed if the attack fails).\nYou can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a whip sized for you, even though it isn''t a light weapon for you.\n",
          1f, 2f, 1, 1, 0, 20, 2, 2, 0, 0, 1, 1, 56, 0
      }, //
      {55, "Axe, orc double",
          "An orc double axe is a double weapon. You can fight with it as if fighting with two weapons, but if you do, you incur all the normal attack penalties associated with fighting with two weapons, just as if you were using a one-handed weapon and a light weapon.\nA creature wielding an orc double axe in one hand can''t use it as a double weapon - only one end of the weapon can be used in any given round.",
          60f, 15f, 1, 4, 0, 20, 3, 2, 0, 0, 2, 2, 57, 0
      }, //
      {56, "Chain, piked",
          "A spiked chain has reach, so you can strike opponents 10 feet away with it. In addition, unlike most other weapons with reach, it can be used against an adjacent foe.\nYou can make trip attacks with the chain. If you are tripped during your own trip attempt, you can drop the chain to avoid being tripped.\nWhen using a spiked chain, you get a +2 bonus on opposed attack rolls made to disarm an opponent (including the roll to avoid being disarmed if such an attempt fails).\nYou can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a spiked chain sized for you, even though it isn''t a light weapon for you.",
          25f, 10f, 2, 2, 0, 20, 2, 2, 0, 0, 2, 1, 58, 0
      }, //
      {57, "Flail, dire",
          "A dire flail is a double weapon. You can fight with it as if fighting with two weapons, but if you do, you incur all the normal attack penalties associated with fighting with two weapons, just as if you were using a one-handed weapon and a light weapon. A creature wielding a dire flail in one hand can''t use it as a double weapon -  only one end of the weapon can be used in any given round.\nWhen using a dire flail, you get a +2 bonus on opposed attack rolls made to disarm an enemy (including the opposed attack roll to avoid being disarmed if such an attempt fails).\nYou can also use this weapon to make trip attacks. If you are tripped during your own trip attempt, you can drop the dire flail to avoid being tripped.\n",
          90f, 10f, 1, 4, 0, 20, 2, 2, 0, 0, 2, 2, 59, 0
      }, //
      {58, "Hammer, gnome hooked",
          "A gnome hooked hammer is a double weapon. You can fight with it as if fighting with two weapons, but if you do, you incur all the normal attack penalties associated with fighting with two weapons, just as if you were using a one-handed weapon and a light weapon. The hammer''s blunt head is a bludgeoning weapon that deals 1d6 points of damage (crit x3). Its hook is a piercing weapon that deals 1d4 points of damage (crit x4). You can use either head as the primary weapon. The other head is the offhand weapon. A creature wielding a gnome hooked hammer in one hand can''t use it as a double weapon - only one end of the weapon can be used in any given round.\nYou can use a gnome hooked hammer to make trip attacks. If you are tripped during your own trip attempt, you can drop the gnome hooked hammer to avoid being tripped.\nGnomes treat gnome hooked hammers as martial weapons.\n",
          20f, 6f, 1, 4, 0, 20, 3, 2, 0, 0, 2, 2, 60, 0
      }, //
      {59, "Sword, two-bladed",
          "A two-bladed sword is a double weapon. You can fight with it as if fighting with two weapons, but if you do, you incur all the normal attack penalties associated with fighting with two weapons, just as if you were using a one-handed weapon and a light weapon. A creature wielding a two-bladed sword in one hand can''t use it as a double weapon - only one end of the weapon can be used in any given round.",
          100f, 10f, 1, 4, 0, 19, 2, 2, 0, 0, 2, 2, 61, 0
      }, //
      {60, "Urgrosh, dwarven",
          "A dwarven urgrosh is a double weapon. You can fight with it as if fighting with two weapons, but if you do, you incur all the normal attack penalties associated with fighting with two weapons, just as if you were using a one-handed weapon and a light weapon. The urgrosh''s axe head is a slashing weapon that deals 1d8 points of damage. Its spear head is a piercing weapon that deals 1d6 points of damage. You can use either head as the primary weapon. The other is the off-hand weapon. A creature wielding a dwarven urgrosh in one hand can''t use it as a double weapon - only one end of the weapon can be used in any given round.\nIf you use a ready action to set an urgrosh against a charge, you deal double damage if you score a hit against a charging character. If you use an urgrosh against a charging character, the spear head is the part of the weapon that deals damage.\nDwarves treat dwarven urgroshes as martial weapons.\n",
          50f, 12f, 1, 4, 0, 20, 3, 2, 0, 0, 2, 2, 62, 0
      }, //
      {61, "Bolas",
          "You can use this weapon to make a ranged trip attack against an opponent. You can''t be tripped during your own trip attempt when using a set of bolas.",
          5f, 2f, 1, 2, 0, 20, 2, 2, 0, 0, 1, 3, 63, 10
      }, //
      {62, "Crossbow, hand",
          "You can draw a hand crossbow back by hand. Loading a hand crossbow is a move action that provokes attacks of opportunity.\nYou can shoot, but not load, a hand crossbow with one hand at no penalty. You can shoot a hand crossbow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons.",
          100f, 2f, 1, 2, 0, 19, 2, 2, 0, 1, 1, 4, 64, 30
      }, //
      {63, "Crossbow, repeating heavy",
          "The repeating crossbow (whether heavy or light) holds 5 crossbow bolts. As long as it holds bolts, you can reload it by pulling the reloading lever (a free action). Loading a new case of 5 bolts is a full-round action that provokes attacks of opportunity.\nYou can fire a repeating crossbow with one hand or fire a repeating crossbow in each hand in the same manner as you would a normal crossbow of the same size. However, you must fire the weapon with two hands in order to use the reloading lever, and you must use two hands to load a new case of bolts.",
          400f, 12f, 1, 5, 0, 19, 2, 2, 0, 1, 1, 4, 65, 120
      }, //
      {64, "Crossbow, repeating light",
          "The repeating crossbow (whether heavy or light) holds 5 crossbow bolts. As long as it holds bolts, you can reload it by pulling the reloading lever (a free action). Loading a new case of 5 bolts is a full-round action that provokes attacks of opportunity.\nYou can fire a repeating crossbow with one hand or fire a repeating crossbow in each hand in the same manner as you would a normal crossbow of the same size. However, you must fire the weapon with two hands in order to use the reloading lever, and you must use two hands to load a new case of bolts.",
          250f, 6f, 1, 4, 0, 19, 2, 2, 0, 1, 1, 4, 66, 80
      }, //
      {65, "Shuriken",
          "A shuriken is a special monk weapon. This designation gives a monk wielding shuriken special options. A shuriken can''t be used as a melee weapon.\nAlthough they are thrown weapons, shuriken are treated as ammunition for the purposes of drawing them, crafting masterwork or otherwise special versions of them and what happens to them after they are thrown.\n",
          0.2f, 0.1f, 1, 0, 0, 20, 2, 2, 0, 1, 0, 3, 68, 10
      }, //
      {66, "Bolts, crossbow (10)",
          "A crossbow bolt used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (crit x2). Bolts come in a wooden case that holds 10 bolts (or 5, for a repeating crossbow). A bolt that hits its target is destroyed, one that misses has a 50% chance of being destroyed or lost.",
          1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 69, 0
      }, //
      {67, "Bullets, sling (10)",
          "Bullets come in a leather pouch that holds 10 bullets. A bullet that hits its target is destroyed, one that misses has a 50% chance of being destroyed or lost.",
          0.1f, 1f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 69, 0
      }, //
      {68, "Arrows (20)",
          "An arrow used as a melee weapon is treated as a light improvised weapon (-4 penalty on attack rolls) and deals damage as a dagger of its size (critical multiplier x2). Arrows come in a leather quiver that holds 20 arrows. An arrow that hits its target is destroyed, one that misses has a 50% chance of being destroyed or lost.",
          1f, 3f, 0, 0, 0, 0, 0, 3, 0, 1, 0, 5, 69, 0
      }, //
      {69, "Adamantine Battleaxe",
          "This nonmagical axe is made out of adamantine. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          3010f, 6f, 1, 4, 0, 20, 3, 1, 0, 0, 1, 0, 26, 0
      }, //
      {70, "Adamantine Dagger",
          "This nonmagical dagger is made out of adamantine. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          3002f, 1f, 1, 2, 0, 19, 2, 0, 0, 0, 1, 0, 2, 10
      }, //
      {71, "Assassin Dagger",
          "This wicked-looking, curved +2 dagger provides a +1 bonus to the DC of a Fortitude save forced by the death attack of an assassin.",
          18302f, 1f, 1, 2, 2, 19, 2, 0, 2, 0, 1, 0, 2, 10
      }, //
      {72, "Dagger of Venom",
          "This black +1 dagger has a serrated edge. It allows the wielder to use a poison effect (as the spell, save DC 14) upon a creature struck by the blade once per day. The wielder can decide to use the power after he has struck. Doing so is a free action, but the poison effect must be invoked in the same round that the dagger strikes.",
          8302f, 1f, 1, 2, 1, 19, 2, 0, 2, 0, 1, 0, 2, 10
      }, //
      {73, "Dwarven Thrower",
          "This weapon commonly functions as a +2 warhammer. In the hands of a dwarf, the warhammer gains an additional +1 enhancement bonus (for a total enhancement bonus of +3) and gains the returning special ability. It can be hurled with a 30-foot range increment. When hurled, it deals an extra 2d8 points of damage against giants or an extra 1d8 points of damage against any other target.",
          60312f, 5f, 1, 4, 2, 20, 3, 1, 2, 0, 1, 3, 34, 30
      }, //
      {74, "Flame Tongue",
          "This is a +1 flaming burst longsword. Once per day, the sword can blast forth a fiery ray at any target within 30 feet as a ranged touch attack. The ray deals 4d6 points of fire damage on a successful hit.",
          10515f, 4f, 1, 4, 1, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {75, "Frost Brand",
          "This +3 frost greatsword sheds light as a torch when the temperature drops below 0�F. At such times it cannot be concealed when drawn, nor can its light be shut off. Its wielder is protected from fire, the sword absorbs the first 10 points of fire damage each round that the wielder would otherwise take.\nA frost brand extinguishes all nonmagical fires in its area. As a standard action, it can also dispel lasting fire spells, but not instantaneous effects, though you must succeed on a dispel check (1d20 +14) against each spell to dispel it. The DC to dispel such spells is 11 + the caster level of the fire spell.\n",
          27375f, 8f, 2, 3, 3, 19, 2, 1, 2, 0, 2, 0, 40, 0
      }, //
      {76, "Holy Avenger",
          "This +2 cold iron longsword becomes a +5 holy cold iron longsword in the hands of a paladin.\nIt provides spell resistance of 5 + the paladin''s level to the wielder and anyone adjacent to her. It also enables the wielder to use greater dispel magic (once per round as a standard action) at the class level of the paladin. (Only the area dispel is possible, not the targeted dispel or counterspell versions of greater dispel magic.)\n",
          12063f, 4f, 1, 4, 2, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {77, "Javelin of Lightning",
          "This javelin becomes a 5d6 lightning bolt when thrown (Reflex DC 14 half ). It is consumed in the attack.", 1500f, 2f, 5,
          3, 0, 20, 2, 0, 2, 1, 1, 3, 15, 0
      }, //
      {78, "Life-Drinker",
          "This +1 greataxe is favored by undead and constructs, who do not suffer its drawback. A life-drinker bestows two negative levels on its target whenever it deals damage, just as if its target had been struck by an undead creature. One day after being struck, subjects must make a DC 16 Fortitude save for each negative level or lose a character level.\nEach time a life-drinker deals damage to a foe, it also bestows one negative level on the wielder. Any negative level gained by the wielder in this fashion lasts for 1 hour.\n",
          40320f, 12f, 1, 6, 1, 20, 3, 1, 0, 0, 2, 0, 37, 0
      }, //
      {79, "Luck Blade (0 wishes)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power.",
          22060f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {80, "Luck Blade (1 wish)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power.",
          62360f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {81, "Luck Blade (2 wishes)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power.",
          102660f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {82, "Luck Blade (3 wishes)",
          "This +2 short sword gives its possessor a +1 luck bonus on all saving throws. Its possessor also gains the power of good fortune, usable once per day. This extraordinary ability allows its possessor to reroll one roll that she just made. She must take the result of the reroll, even if it''s worse than the original roll. In addition, a luck blade may contain up to three wishes (when randomly rolled, a luck blade holds 1d4-1 wishes, minimum 0). When the last wish is used, the sword remains a +2 short sword, still grants the +1 luck bonus, and still grants its reroll power.",
          142960f, 2f, 1, 3, 2, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {83, "Mace of Smiting",
          "This +3 adamantine heavy mace has a +5 enhancement bonus against constructs, and any critical hit dealt to a construct completely destroys it (no saving throw). A critical hit dealt to an outsider deals x4 damage rather than x2.",
          75312f, 8f, 1, 4, 3, 20, 2, 0, 2, 0, 1, 0, 6, 0
      }, //
      {84, "Mace of Terror",
          "On command, this +2 heavy mace causes the wielder''s clothes and appearance to transform into an illusion of darkest horror such that living creatures in a 30-foot cone become panicked as if by a fear spell (Will DC 16 partial). They take a -2 morale penalty on saving throws, and they flee from the wielder. The wielder may use this ability up to three times per day. ",
          38552f, 8f, 1, 4, 2, 20, 2, 0, 2, 0, 1, 0, 6, 0
      }, //
      {85, "Cold Iron Longsword",
          "This nonmagical longsword is crafted out of cold iron. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          330f, 4f, 1, 4, 0, 19, 2, 1, 1, 0, 1, 0, 28, 0
      }, //
      {86, "Nine Lives Stealer",
          "This longsword always performs as a +2 longsword, but it also has the power to draw the life force from an opponent. It can do this nine times before the ability is lost. At that point, the sword becomes a simple +2 longsword (with a hint of evil about it). A critical hit must be dealt for the sword''s death-dealing ability to function, and this weapon has no effect on creatures not subject to critical hits. The victim is entitled to a DC 20 Fortitude save to avoid death. If the save is successful, the sword''s death-dealing ability does not function, no use of the ability is expended, and normal critical damage is determined. This sword is evil, and any good character attempting to wield it gains two negative levels. These negative levels remain as long as the sword is in hand and disappear when the sword is no longer wielded. These negative levels never result in actual level loss, but they cannot be overcome in any way (including restoration spells) while the sword is wielded.",
          23057f, 4f, 1, 4, 2, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {87, "Oathbow",
          "Of elven make, this white +2 composite longbow (+2 Str bonus) whispers ''Swift defeat to my enemies'' in Elven when nocked and pulled. Once per day, if the firer swears aloud to slay her target (a free action), the bow''s whisper becomes the low shout ''Swift death to those who have wronged me.'' Against such a sworn enemy, the bow has a +5 enhancement bonus, and arrows launched from it deal an additional 2d6 points of damage (and x4 on a critical hit instead of the normal x3). However, the bow is treated as only a masterwork weapon against all foes other than the sworn enemy, and the wielder takes a -1 penalty on attack rolls with any weapon other than the oathbow. These bonuses and penalties last for seven days or until the sworn enemy is slain or destroyed by the wielder of the oathbow, whichever comes first.\nThe oathbow may only have one sworn enemy at a time. Once the wielder swears to slay a target, he cannot make a new oath until he has slain that target or seven days have passed. Even if the wielder slays the sworn enemy on the same day that he makes the oath, he cannot activate the oathbow''s special power again until 24 hours have passed from the time he made the oath.\n",
          25600f, 3f, 1, 4, 2, 20, 3, 1, 2, 1, 2, 4, 47, 110
      }, //
      {88, "Rapier of Puncturing",
          "Three times per day, this +2 wounding rapier allows the wielder to make a touch attack with the weapon that deals 1d6 points of Constitution damage by draining blood. Creatures immune to critical hits are immune to the Constitution damage dealt by this weapon.",
          50320f, 2f, 1, 3, 2, 18, 2, 1, 2, 0, 1, 0, 30, 0
      }, //
      {89, "Screaming Bolt",
          "One of these +2 bolts screams when fired, forcing all enemies of the wielder within 20 feet of the path of the bolt to succeed on a DC 14 Will save or become shaken. This is a mind-affecting fear effect.",
          267f, 0.1f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 69, 0
      }, //
      {90, "Shatterspike",
          "Wielders without the Improved Sunder feat use Shatterspike as a +1 longsword only, wielders with the Improved Sunder feat add a +4 bonus (including the sword''s +1 enhancement bonus) to the opposed roll when attempting to strike a foe''s weapon. If successful, Shatterspike deals 1d8+4 points of damage plus the wielder''s Strength modifier to the target weapon (the target weapon''s hardness must still be overcome with each hit). Shatterspike can damage weapons with an enhancement bonus of +4 or lower.",
          4315f, 4f, 1, 4, 1, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {91, "Shifter Sorrow",
          "This +1/+1 two-bladed sword has blades of alchemical silver. The weapon deals an extra 2d6 points of damage against any creature with the shapechanger subtype. When a shapechanger or a creature in an alternate form (such as a druid using wild shape) is struck by the weapon, it must make a DC 15 Will save or return to its natural form.",
          12780f, 10f, 1, 4, 1, 19, 2, 3, 2, 0, 2, 2, 61, 0
      }, //
      {92, "Silver Dagger",
          "This masterwork alchemical silver dagger is nonmagical. As a masterwork weapon, it has a +1 enhancement bonus on attack rolls.",
          322f, 1f, 1, 2, 0, 19, 2, 0, 1, 0, 0, 0, 2, 10
      }, //
      {93, "Slaying Arrow",
          "This +1 arrow is keyed to a particular type or subtype of creature. If it strikes such a creature, the target must make a DC 20 Fortitude save or die (or, in the case of unliving targets, be destroyed) instantly. Note that even creatures normally exempt from Fortitude saves (undead and constructs) are subject to this attack. When keyed to a living creature, this is a death effect (and thus death ward protects a target). To determine the type or subtype of creature the arrow is keyed to, roll on the table below.\nA greater slaying arrow functions just like a normal slaying arrow, but the DC to avoid the death effect is 23.\n",
          2282f, 0.15f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 69, 0
      }, //
      {94, "Slaying Arrow, greater",
          "This +1 arrow is keyed to a particular type or subtype of creature. If it strikes such a creature, the target must make a DC 20 Fortitude save or die (or, in the case of unliving targets, be destroyed) instantly. Note that even creatures normally exempt from Fortitude saves (undead and constructs) are subject to this attack. When keyed to a living creature, this is a death effect (and thus death ward protects a target). To determine the type or subtype of creature the arrow is keyed to, roll on the table below.\nA greater slaying arrow functions just like a normal slaying arrow, but the DC to avoid the death effect is 23.\n",
          4057f, 0.15f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 69, 0
      }, //
      {95, "Sleep Arrow",
          "This +1 arrow is painted white and has white fletching. If it strikes a foe so that it would normally deal damage, it instead bursts into magical energy that deals nonlethal damage (in the same amount as would be lethal damage) and forces the target to make a DC 11 Will save or fall asleep.",
          132f, 0.15f, 0, 0, 0, 0, 0, 3, 2, 1, 0, 5, 69, 0
      }, //
      {96, "Sun Blade",
          "This sword is the size of a bastard sword. However, a sun blade is wielded as if it were a short sword with respect to weight and ease of use. (In other words, the weapon appears to all viewers to be a bastard sword, and deals bastard sword damage, but the wielder feels and reacts as if the weapon were a short sword.) Any individual able to use either a bastard sword or a short sword with proficiency is proficient in the use of a sun blade. Likewise, Weapon Focus and Weapon Specialization in short sword and bastard sword apply equally, but the benefits of those feats do not stack.\nIn normal combat, the glowing golden blade of the weapon is equal to a +2 bastard sword. Against evil creatures, its enhancement bonus is +4. Against Negative Energy Plane creatures or undead creatures, the sword deals double damage (and x3 on a critical hit instead of the usual x2).\nThe blade also has a special sunlight power. Once per day, the wielder can swing the blade vigorously above her head while speaking a command word. The sunblade then sheds a bright yellow radiance that is like full daylight. The radiance begins shining in a 10-foot radius around the sword wielder and extends outward at 5 feet per round for 10 rounds thereafter, to create a globe of light with a 60-foot radius. When the wielder stops swinging, the radiance fades to a dim glow that persists for another minute before disappearing entirely. All sun blades are of good alignment, and any evil creature attempting to wield one gains one negative level. The negative level remains as long as the sword is in hand and disappears when the sword is no longer wielded. This negative level never results in actual level loss, but it cannot be overcome in any way (including restoration spells) while the sword is wielded.\n",
          50335f, 2f, 1, 5, 2, 19, 2, 2, 2, 0, 1, 0, 54, 0
      }, //
      {97, "Sword of Life Stealing",
          "This black iron +2 longsword bestows a negative level when it deals a critical hit. The sword wielder gains 1d6 temporary hit points each time a negative level is bestowed on another. These temporary hit points last for 24 hours. One day after being struck, subjects must make a DC 16 Fortitude save for each negative level or lose a character level.",
          25715f, 4f, 1, 4, 2, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {98, "Sword of the Planes",
          "This longsword has an enhancement bonus of +1 on the Material Plane, but on any Elemental Plane its enhancement bonus increases to +2. (The +2 enhancement bonus also applies on the Material Plane when the weapon is used against elementals.) It operates as a +3 longsword on the Astral Plane or the Ethereal Plane or when used against opponents native to either of those planes. On any other plane, or against any outsider, it functions as a +4 longsword.",
          22315f, 4f, 1, 4, 1, 19, 2, 1, 2, 0, 1, 0, 28, 0
      }, //
      {99, "Sword of Subtlety",
          "A +1 short sword with a thin, dull gray blade, this weapon provides a +4 bonus on its wielder''s attack and damage rolls when he is making a sneak attack with it.",
          22310f, 2f, 1, 3, 1, 19, 2, 1, 2, 0, 0, 0, 25, 0
      }, //
      {100, "Sylvan Scimitar",
          "This +3 scimitar, when used outdoors in a temperate climate, grants its wielder the use of the Cleave feat and deals an extra 1d6 points of damage.",
          47315f, 4f, 1, 3, 3, 18, 2, 2, 2, 0, 1, 0, 31, 0
      }, //
      {101, "Trident of Fish Command",
          "The magical properties of this +1 trident with a 6-foot-long haft enable its wielder to charm up to 14 HD of aquatic animals (Will DC 16 negates, animals get a +5 bonus if currently under attack by the wielder or his allies), no two of which can be more than 30 feet apart. The wielder can use this effect up to three times per day. The wielder can communicate with the animals as if using a speak with animals spell. Animals making their saving throw are free of control, but they will not approach within 10 feet of the trident. The trident can be used up to three times per day.",
          18650f, 4f, 1, 4, 1, 20, 2, 1, 2, 0, 1, 0, 33, 10
      }, //
      {102, "Trident of Warning",
          "A weapon of this type enables its wielder to determine the location, depth, kind, and number of aquatic predators within 680 feet. A trident of warning must be grasped and pointed in order for the character using it to gain such information, and it requires 1 round to scan a hemisphere with a radius of 680 feet. The weapon is otherwise a +2 trident.",
          10115f, 4f, 1, 4, 2, 20, 2, 1, 2, 0, 1, 0, 33, 10
      }, //
      {103, "Unarmed strike",
          "A Medium character deals 1d3 points of nonlethal damage with an unarmed strike. A Small character deals 1d2 points of nonlethal damage. A monk or any character with the Improved Unarmed Strike feat can deal lethal or nonlethal damage with unarmed strikes, at her option. The damage from an unarmed strike is considered weapon damage for the purposes of effects that give you a bonus on weapon damage rolls.\nAn unarmed strike is always considered a light weapon. Therefore, you can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with an unarmed strike.\n",
          0f, 0f, 1, 1, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0
      }, //
      {104, "Shield, light", "You can bash with a shield instead of using it for defense. See Armor for details.", 0f, 0f, 1, 1, 0,
          20, 2, 1, 0, 0, 0, 0, 23, 0
      }, //
      {105, "Spiked armor",
          "You can outfit your armor with spikes, which can deal damage in a grapple or as a separate attack. See Armor for details.",
          0f, 0f, 1, 3, 0, 20, 2, 1, 0, 0, 0, 0, 24, 0
      }, //
      {106, "Spiked shield, light", "You can bash with a spiked shield instead of using it for defense. See Armor for details.", 0f,
          0f, 1, 2, 0, 20, 2, 1, 0, 0, 0, 0, 23, 0
      }, //
      {107, "Shield, heavy", "You can bash with a shield instead of using it for defense. See Armor for details.", 0f, 0f, 1, 2, 0,
          20, 2, 1, 0, 0, 1, 0, 32, 0
      }, //
      {108, "Spiked shield, heavy", "You can bash with a spiked shield instead of using it for defense. See Armor for details.", 0f,
          0f, 1, 3, 0, 20, 2, 1, 0, 0, 1, 0, 32, 0
      }, //
      {109, "Net",
          "A net is used to entangle enemies. When you throw a net, you make a ranged touch attack against your target. A net''s maximum range is 10 feet. If you hit, the target is entangled. An entangled creature takes a -2 penalty on attack rolls and a -4 penalty on Dexterity, can move at only half speed, and cannot charge or run. If you control the trailing rope by succeeding on an opposed Strength check while holding it, the entangled creature can move only within the limits that the rope allows. If the entangled creature attempts to cast a spell, it must make a DC 15 Concentration check or be unable to cast the spell.\nAn entangled creature can escape with a DC 20 Escape Artist check (a full-round action). The net has 5 hit points and can be burst with a DC 25 Strength check (also a full-round action).\nA net is useful only against creatures within one size category of you.\nA net must be folded to be thrown effectively. The first time you throw your net in a fight, you make a normal ranged touch attack roll. After the net is unfolded, you take a -4 penalty on attack rolls with it. It takes 2 rounds for a proficient user to fold a net and twice that long for a nonproficient one to do so.\n",
          20f, 6f, 0, 0, 0, 0, 0, 2, 0, 1, 1, 3, 67, 0
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
      {12, "Crossbow, heavy"}, //
      {13, "Crossbow, light"}, //
      {14, "Dart"}, //
      {15, "Javelin"}, //
      {16, "Sling"}, //
      {17, "Axe, throwing"}, //
      {18, "Hammer, light"}, //
      {19, "Handaxe"}, //
      {20, "Kukri"}, //
      {21, "Pick, light"}, //
      {22, "Sap"}, //
      {23, "Shield, light"}, //
      {24, "Spiked armor"}, //
      {25, "Sword, short"}, //
      {26, "Battleaxe"}, //
      {27, "Flail"}, //
      {28, "Longsword"}, //
      {29, "Pick, heavy"}, //
      {30, "Rapier"}, //
      {31, "Scimitar"}, //
      {32, "Shield, heavy"}, //
      {33, "Trident"}, //
      {34, "Warhammer"}, //
      {35, "Falchion"}, //
      {36, "Glaive"}, //
      {37, "Greataxe"}, //
      {38, "Greatclub"}, //
      {39, "Flail, heavy"}, //
      {40, "Greatsword"}, //
      {41, "Guisarme"}, //
      {42, "Halberd"}, //
      {43, "Lance"}, //
      {44, "Ranseur"}, //
      {45, "Scythe"}, //
      {46, "Longbow"}, //
      {47, "Longbow, composite"}, //
      {48, "Shortbow"}, //
      {49, "Shortbow, composite"}, //
      {50, "Kama"}, //
      {51, "Nunchaku"}, //
      {52, "Sai"}, //
      {53, "Siangham"}, //
      {54, "Sword, bastard"}, //
      {55, "Waraxe, dwarven"}, //
      {56, "Whip"}, //
      {57, "Axe, orc double"}, //
      {58, "Chain, spiked"}, //
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
      {69, "Ammunition"}, //
      {70, "Grapple"}, //
      {71, "Ray"}, //
  };

}
