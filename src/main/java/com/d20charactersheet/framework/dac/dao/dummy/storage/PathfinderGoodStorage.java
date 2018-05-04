package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores raw data of all goods.
 */
public class PathfinderGoodStorage {

  /**
   * All goods
   */
  public static final Object[][] GOOD = {
      // id, name, description, cost, weight, good type, quality type
      {1, "Backpack (empty)", "", 2f, 2f, 0, 0}, //
      {2, "Barrel (empty)", "", 2f, 30f, 0, 0}, //
      {3, "Basket (empty)", "", 0.4f, 1f, 0, 0}, //
      {4, "Bedroll", "", 0.1f, 5f, 0, 0}, //
      {5, "Bell", "", 1f, 0f, 0, 0}, //
      {6, "Blanket, winter", "", 0.5f, 3f, 0, 0}, //
      {7, "Block and tackle", "", 5f, 5f, 0, 0}, //
      {8, "Bottle, glass", "", 2f, 1f, 0, 0}, //
      {9, "Bucket (empty)", "", 0.5f, 2f, 0, 0}, //
      {10, "Caltrops",
          "A caltrop is a four-pronged metal spike crafted so that one prong faces up no matter how the caltrop comes to rest. You scatter caltrops on the ground in the hope that your enemies step on them or are at least forced to slow down to avoid them. One 2-pound bag of caltrops covers an area 5 feet square.\nEach time a creature moves into an area covered by caltrops (or spends a round fighting while standing in such an area), it runs the risk of stepping on one. Make an attack roll for the caltrops (base attack bonus +0) against the creature. For this attack, the creature''s shield, armor, and deflection bonuses do not count. If the creature is wearing shoes or other footwear, it gets a +2 armor bonus to AC. If the attack succeeds, the creature has stepped on a caltrop. The caltrop deals 1 point of damage, and the creature''s speed is reduced by half because its foot is wounded. This movement penalty lasts for 24 hours, until the creature is successfully treated with a DC 15 Heal check, or until it receives at least 1 point of magical healing. A charging or running creature must immediately stop if it steps on a caltrop. Any creature moving at half speed or slower can pick its way through a bed of caltrops with no trouble.\nCaltrops may not work against unusual opponents.",
          1f, 2f, 0, 0
      }, //
      {11, "Candle",
          "A candle dimly illuminates a small area, increasing the light level in a 5-foot radius by one step (darkness becomes dim light and dim light becomes normal light). A candle cannot increase the light level above normal light. A candle burns for 1 hour.",
          0.01f, 0f, 0, 0
      }, //
      {12, "Canvas (sq. yd.)", "", 0.1f, 1f, 0, 0}, //
      {13, "Case, map or scroll", "", 1f, 0.5f, 0, 0}, //
      {14, "Chain (10 ft.)", "Chain has hardness 10 and 5 hit points. It can be burst with a DC 26 Strength check.", 30f, 2f, 0, 0},
      //
      {15, "Chalk, 1 piece", "", 0.01f, 0f, 0, 0}, //
      {16, "Chest (empty)", "", 2f, 25f, 0, 0}, //
      {17, "Crowbar",
          "A crowbar grants a +2 circumstance bonus on Strength checks made to force open a door or chest. If used in combat, treat a crowbar as a one-handed improvised weapon that deals bludgeoning damage equal to that of a club of its size.",
          2f, 5f, 0, 0
      }, //
      {18, "Firewood (per day)", "", 0.01f, 20f, 0, 0}, //
      {19, "Fishhook", "", 0.1f, 0f, 0, 0}, //
      {20, "Fishing net, 25 sq. ft.", "", 4f, 5f, 0, 0}, //
      {21, "Flask (empty)", "", 0.03f, 1f, 0, 0}, //
      {22, "Flint and steel",
          "Lighting a torch with flint and steel is a full-round action, and lighting any other fire with them takes at least that long.",
          1f, 0f, 0, 0
      }, //
      {23, "Grappling hook",
          "Throwing a grappling hook requires a ranged attack roll, treating the hook as a thrown weapon with a range increment of 10 feet. Objects with ample places to catch the hook are AC 5.",
          1f, 4f, 0, 0
      }, //
      {24, "Hammer",
          "If a hammer is used in combat, treat it as a one-handed improvised weapon that deals bludgeoning damage equal to that of a spiked gauntlet of its size.",
          0.5f, 2f, 0, 0
      }, //
      {25, "Hourglass", "", 25f, 1f, 0, 0}, //
      {26, "Ink (1 oz. vial)", "Ink in colors other than black costs twice as much.", 8f, 0f, 0, 0}, //
      {27, "Inkpen", "", 0.1f, 0f, 0, 0}, //
      {28, "Jug, clay", "This basic jug is fitted with a stopper and holds 1 gallon of liquid.", 0.03f, 9f, 0, 0}, //
      {29, "Ladder, 10-foot", "", 0.2f, 20f, 0, 0}, //
      {30, "Lamp, common",
          "A lamp illuminates a small area, providing normal light in a 15-foot radius and increasing the light level by one step for an additional 15 feet beyond that area (darkness becomes dim light and dim light becomes normal light). A lamp does not increase the light level in normal light or bright light. A lamp burns for 6 hours on one pint of oil. You can carry a lamp in one hand.",
          0.1f, 1f, 0, 0
      }, //
      {31, "Lantern, bullseye",
          "A bullseye lantern provides normal light in a 60-foot cone and increases the light level by one step in the area beyond that, out to a 120-foot cone (darkness becomes dim light and dim light becomes normal light). A bullseye lantern does not increase the light level in normal light or bright light. A lantern burns for 6 hours on one pint of oil. You can carry a lantern in one hand.",
          12f, 3f, 0, 0
      }, //
      {32, "Lantern, hooded",
          "A hooded lantern sheds normal light in a 30-foot radius and increases the light level by one step for an additional 30 feet beyond that area (darkness becomes dim light and dim light becomes normal light). A hooded lantern does not increase the light level in normal light or bright light. A lantern burns for 6 hours on one pint of oil. You can carry a lantern in one hand.",
          7f, 2f, 0, 0
      }, //
      {33, "Lock, Simple",
          "The DC to open a lock with the Disable Device skill depends on the lock''s quality: simple (DC 20), average (DC 25), good (DC 30), or superior (DC 40).",
          20f, 1f, 0, 0
      }, //
      {34, "Lock, Average",
          "The DC to open a lock with the Disable Device skill depends on the lock''s quality: simple (DC 20), average (DC 25), good (DC 30), or superior (DC 40).",
          40f, 1f, 0, 0
      }, //
      {35, "Lock, Good",
          "The DC to open a lock with the Disable Device skill depends on the lock''s quality: simple (DC 20), average (DC 25), good (DC 30), or superior (DC 40).",
          80f, 1f, 0, 0
      }, //
      {36, "Superior", "", 150f, 1f, 0, 0}, //
      {37, "Manacles",
          "Manacles can bind a Medium creature. A manacled creature can use the Escape Artist skill to slip free (DC 30, or DC 35 for masterwork manacles). Breaking the manacles requires a Strength check (DC 26, or DC 28 for masterwork manacles). Manacles have hardness 10 and 10 hit points.\nMost manacles have locks, add the cost of the lock you want to the cost of the manacles.\nFor the same cost, you can buy manacles for a Small creature. For a Large creature, manacles cost 10 times the indicated amount, and for a Huge creature, 100 times the indicated amount. Gargantuan, Colossal, Tiny, Diminutive, and Fine creatures can be held only by specially made manacles, which cost at least 100 times the indicated amount.",
          15f, 2f, 0, 0
      }, //
      {38, "Manacles",
          "Manacles can bind a Medium creature. A manacled creature can use the Escape Artist skill to slip free (DC 30, or DC 35 for masterwork manacles). Breaking the manacles requires a Strength check (DC 26, or DC 28 for masterwork manacles). Manacles have hardness 10 and 10 hit points.\nMost manacles have locks, add the cost of the lock you want to the cost of the manacles.\nFor the same cost, you can buy manacles for a Small creature. For a Large creature, manacles cost 10 times the indicated amount, and for a Huge creature, 100 times the indicated amount. Gargantuan, Colossal, Tiny, Diminutive, and Fine creatures can be held only by specially made manacles, which cost at least 100 times the indicated amount.",
          50f, 2f, 0, 1
      }, //
      {39, "Mirror, small steel", "", 10f, 0.5f, 0, 0}, //
      {40, "Mug/Tankard, clay", "", 0.02f, 1f, 0, 0}, //
      {41, "Oil (1-pint flask)",
          "A pint of oil burns for 6 hours in a lantern or lamp. You can also use a flask of oil as a splash weapon. Use the rules for alchemist''s fire (see Special Substances and Items on Table: Goods and Services), except that it takes a full-round action to prepare a flask with a fuse. Once it is thrown, there is a 50% chance of the flask igniting successfully.\nYou can pour a pint of oil on the ground to cover an area 5 feet square, provided that the surface is smooth. If lit, the oil burns for 2 rounds and deals 1d3 points of fire damage to each creature in the area.",
          0.1f, 1f, 0, 0
      }, //
      {42, "Paper (sheet)", "", 0.4f, 0f, 0, 0}, //
      {43, "Parchment (sheet)", "", 0.2f, 0f, 0, 0}, //
      {44, "Pick, miner''s",
          "If a miner''s pick is used in combat, treat it as a two-handed improvised weapon that deals piercing damage equal to that of a heavy pick of its size. ",
          3f, 10f, 0, 0
      }, //
      {45, "Pitcher, clay", "", 0.02f, 5f, 0, 0}, //
      {46, "Piton", "", 0.1f, 0.5f, 0, 0}, //
      {47, "Pole, 10-foot", "", 0.05f, 8f, 0, 0}, //
      {48, "Pot, iron", "", 0.8f, 4f, 0, 0}, //
      {49, "Pouch, belt (empty)", "", 1f, 1f, 0, 0}, //
      {50, "Ram, portable",
          "This iron-shod wooden beam gives you a +2 circumstance bonus on Strength checks made to break open a door and allows a second person to help, automatically increasing your bonus by 2.",
          10f, 20f, 0, 0
      }, //
      {51, "Rations, trail (per day)", "", 0.5f, 1f, 0, 0}, //
      {52, "Rope, hemp (50 ft.)", "This rope has 2 hit points and can be burst with a DC 23 Strength check.", 1f, 10f, 0, 0}, //
      {53, "Rope, silk (50 ft.)", "This rope has 4 hit points and can be burst with a DC 24 Strength check.", 10f, 5f, 0, 0}, //
      {54, "Sack (empty)", "", 0.1f, 1f, 0, 0}, //
      {55, "Sealing wax", "", 1f, 1f, 0, 0}, //
      {56, "Sewing needle", "", 0.5f, 0f, 0, 0}, //
      {57, "Shovel or spade",
          "If a shovel is used in combat, treat it as a one-handed improvised weapon that deals bludgeoning damage equal to that of a club of its size.",
          2f, 8f, 0, 0
      }, //
      {58, "Signal whistle", "", 0.8f, 0f, 0, 0}, //
      {59, "Signet ring", "", 5f, 0f, 0, 0}, //
      {60, "Sledge", "", 1f, 10f, 0, 0}, //
      {61, "Soap (per lb.)", "", 0.5f, 1f, 0, 0}, //
      {62, "Spyglass",
          "Objects viewed through a spyglass are magnified to twice their size. Characters using a spyglass take a -1 penalty on Perception skill checks per 20 feet of distance to the target, if the target is visible.",
          1000f, 1f, 0, 0
      }, //
      {63, "Tent", "", 10f, 20f, 0, 0}, //
      {64, "Torch",
          "A torch burns for 1 hour, shedding normal light in a 20-foot radius and increasing the light level by one step for an additional 20 feet beyond that area (darkness becomes dim light and dim light becomes normal light). A torch does not increase the light level in normal light or bright light. If a torch is used in combat, treat it as a one-handed improvised weapon that deals bludgeoning damage equal to that of a gauntlet of its size, plus 1 point of fire damage.",
          0.01f, 1f, 0, 0
      }, //
      {65, "Vial, ink or potion", "A vial is made out of glass or steel and holds 1 ounce of liquid.", 1f, 0f, 0, 0}, //
      {66, "Water clock",
          "This large, bulky contrivance gives the time accurately to within half an hour per day since it was last set. It requires a source of water, and it must be kept still because it marks time by the regulated flow of droplets of water.",
          1000f, 200f, 0, 0
      }, //
      {67, "Waterskin", "", 1f, 4f, 0, 0}, //
      {68, "Whetstone", "", 0.02f, 1f, 0, 0}, //
      {69, "Acid (flask)",
          "You can throw a flask of acid as a splash weapon. Treat this attack as a ranged touch attack with a range increment of 10 feet. A direct hit deals 1d6 points of acid damage. Every creature within 5 feet of the point where the acid hits takes 1 point of acid damage from the splash.",
          10f, 1f, 1, 0
      }, //
      {70, "Alchemist''s fire (flask)",
          "You can throw a flask of alchemist''s fire as a splash weapon. Treat this attack as a ranged touch attack with a range increment of 10 feet.\nA direct hit deals 1d6 points of fire damage. Every creature within 5 feet of the point where the flask hits takes 1 point of fire damage from the splash. On the round following a direct hit, the target takes an additional 1d6 points of damage. If desired, the target can use a full-round action to attempt to extinguish the flames before taking this additional damage. Extinguishing the flames requires a DC 15 Reflex save. Rolling on the ground provides the target a +2 bonus on the save. Leaping into a lake or magically extinguishing the flames automatically smothers the fire.",
          20f, 1f, 1, 0
      }, //
      {71, "Antitoxin (vial)", "", 50f, 0f, 1, 0}, //
      {72, "Everburning torch",
          "This otherwise normal torch has a <i>continual flame</i> spell cast on it. This causes it to shed light like an ordinary torch, but it does not emit heat or deal fire damage if used as a weapon. ",
          110f, 1f, 2, 0
      }, //
      {73, "Holy water (flask)",
          "Holy water damages undead creatures and evil outsiders almost as if it were acid. A flask of holy water can be thrown as a splash weapon.\nTreat this attack as a ranged touch attack with a range increment of 10 feet. A flask breaks if thrown against the body of a corporeal creature, but to use it against an incorporeal creature, you must open the flask and pour the holy water out onto the target. Thus, you can douse an incorporeal creature with holy water only if you are adjacent to it. Doing so is a ranged touch attack that does not provoke attacks of opportunity.\nA direct hit by a flask of holy water deals 2d4 points of damage to an undead creature or an evil outsider. Each such creature within 5 feet of the point where the flask hits takes 1 point of damage from the splash.\nTemples to good deities sell holy water at cost (making no profit). Holy water is made using the bless water spell.",
          25f, 1f, 1, 0
      }, //
      {74, "Smokestick",
          "This alchemically treated wooden stick instantly creates thick, opaque smoke when burned. The smoke fills a 10-foot cube (treat the effect as a fog cloud spell, except that a moderate or stronger wind dissipates the smoke in 1 round). The stick is consumed after 1 round, and the smoke dissipates naturally after 1 minute.",
          20f, 0.5f, 2, 0
      }, //
      {75, "Sunrod",
          "This 1-foot-long, gold-tipped, iron rod glows brightly when struck as a standard action. It sheds normal light in a 30-foot radius and increases the light level by one step for an additional 30 feet beyond that area (darkness becomes dim light and dim light becomes normal light). A sunrod does not increase the light level in normal light or bright light. It glows for 6 hours, after which the gold tip is burned out and worthless.",
          2f, 1f, 2, 0
      }, //
      {76, "Tanglefoot bag",
          "A tanglefoot bag is a small sack filled with tar, resin, and other sticky substances. When you throw a tanglefoot bag at a creature (as a ranged touch attack with a range increment of 10 feet), the bag comes apart and goo bursts out, entangling the target and then becoming tough and resilient upon exposure to air. An entangled creature takes a -2 penalty on attack rolls and a -4 penalty to Dexterity and must make a DC 15 Reflex save or be glued to the floor, unable to move. Even on a successful save, it can move only at half speed. Huge or larger creatures are unaffected by a tanglefoot bag. A flying creature is not stuck to the floor, but it must make a DC 15 Reflex save or be unable to fly (assuming it uses its wings to fly) and fall to the ground. A tanglefoot bag does not function underwater.\nA creature that is glued to the floor (or unable to fly) can break free by making a DC 17 Strength check or by dealing 15 points of damage to the goo with a slashing weapon. A creature trying to scrape goo off itself, or another creature assisting, does not need to make an attack roll, hitting the goo is automatic, after which the creature that hit makes a damage roll to see how much of the goo was scraped off. Once free, the creature can move (including flying) at half speed. If the entangled creature attempts to cast a spell, it must make concentration check with a DC of 15 + the spell''s level or be unable to cast the spell. The goo becomes brittle and fragile after 2d4 rounds, cracking apart and losing its effectiveness. An application of universal solvent to a stuck creature dissolves the alchemical goo immediately.",
          50f, 4f, 2, 0
      }, //
      {77, "Thunderstone",
          "You can throw this stone as a ranged attack with a range increment of 20 feet. When it strikes a hard surface (or is struck hard), it creates a deafening bang that is treated as a sonic attack. Each creature within a 10-foot-radius spread must make a DC 15 Fortitude save or be deafened for 1 hour. A deafened creature, in addition to the obvious effects, takes a -4 penalty on initiative and has a 20% chance to miscast and lose any spell with a verbal component that it tries to cast.\nSince you don''t need to hit a specific target, you can simply aim at a particular 5-foot square. Treat the target square as AC 5.",
          30f, 1f, 2, 0
      }, //
      {78, "Tindertwig",
          "The alchemical substance on the end of this small, wooden stick ignites when struck against a rough surface. Creating a flame with a tindertwig is much faster than creating a flame with flint and steel (or a magnifying glass) and tinder. Lighting a torch with a tindertwig is a standard action (rather than a full-round action), and lighting any other fire with one is at least a standard action.",
          1f, 0f, 2, 0
      }, //
      {79, "Alchemist''s lab",
          "This lab is used for making alchemical items, and provides a +2 circumstance bonus on Craft (alchemy) checks. It has no bearing on the costs related to the Craft (alchemy) skill. Without this lab, a character with the Craft (alchemy) skill is assumed to have enough tools to use the skill but not enough to get the +2 bonus that the lab provides.",
          200f, 40f, 3, 0
      }, //
      {80, "Artisan''s tools",
          "These special tools include the items needed to pursue any craft. Without them, you have to use improvised tools (-2 penalty on Craft checks), if you can do the job at all.",
          5f, 5f, 3, 0
      }, //
      {81, "Artisan''s tools",
          "These tools serve the same purpose as artisan''s tools, but masterwork artisan''s tools are the perfect tools for the job, so you get a +2 circumstance bonus on Craft checks made with them.",
          55f, 5f, 3, 1
      }, //
      {82, "Climber''s kit", "These crampons, pitons, ropes, and tools give you a +2 circumstance bonus on Climb checks.", 80f, 5f,
          4, 0
      }, //
      {83, "Disguise kit",
          "The kit is the perfect tool for disguise and provides a +2 circumstance bonus on Disguise checks. A disguise kit is exhausted after 10 uses.",
          50f, 8f, 4, 0
      }, //
      {84, "Healer''s kit",
          "This collection of bandages and herbs provides a +2 circumstance bonus on Heal checks. A healer''s kit is exhausted after 10 uses.",
          50f, 1f, 4, 0
      }, //
      {85, "Holly and mistletoe", "Druids commonly use these plants as divine focuses when casting spells.", 0f, 0f, 3, 0}, //
      {86, "Holy symbol, wooden",
          "A holy symbol focuses positive energy and is used by good clerics and paladins (or by neutral clerics who want to cast good spells or channel positive energy). Each religion has its own holy symbol.\n\nUnholy Symbols: An unholy symbol is like a holy symbol except that it focuses negative energy and is used by evil clerics (or by neutral clerics who want to cast evil spells or channel negative energy).",
          1f, 0f, 3, 0
      }, //
      {87, "Holy symbol, silver",
          "A holy symbol focuses positive energy and is used by good clerics and paladins (or by neutral clerics who want to cast good spells or channel positive energy). Each religion has its own holy symbol.\n\nUnholy Symbols: An unholy symbol is like a holy symbol except that it focuses negative energy and is used by evil clerics (or by neutral clerics who want to cast evil spells or channel negative energy).",
          25f, 1f, 3, 0
      }, //
      {88, "Magnifying glass",
          "This simple lens allows a closer look at small objects. It is also useful as a substitute for flint and steel when starting fires. Lighting a fire with a magnifying glass requires bright light, such as sunlight to focus, tinder to ignite, and at least a full-round action. A magnifying glass grants a +2 circumstance bonus on Appraise checks involving any item that is small or highly detailed.",
          100f, 0f, 3, 0
      }, //
      {89, "Musical instrument, common",
          "A masterwork instrument grants a +2 circumstance bonus on Perform checks involving its use.", 5f, 3f, 3, 0
      }, //
      {90, "Musical instrument", "A masterwork instrument grants a +2 circumstance bonus on Perform checks involving its use.",
          100f, 3f, 3, 1
      }, //
      {91, "Scale, merchant''s",
          "A merchant''s scale grants a +2 circumstance bonus on Appraise checks involving items that are valued by weight, including anything made of precious metals.",
          2f, 1f, 3, 0
      }, //
      {92, "Spell component pouch",
          "A spellcaster with a spell component pouch is assumed to have all the material components and focuses needed for spellcasting, except for those components that have a specific cost, divine focuses, and focuses that wouldn''t fit in a pouch.",
          5f, 2f, 3, 0
      }, //
      {93, "Spellbook, wizard''s (blank)",
          "A spellbook has 100 pages of parchment, and each spell takes up one page per spell level (one page each for 0-level spells).",
          15f, 3f, 3, 0
      }, //
      {94, "Thieves'' tools",
          "This kit contains lockpicks and other tools you need to use the Disable Device skill. Without these tools, you must use improvised tools, and you take a -2 circumstance penalty on Disable Device checks.",
          30f, 1f, 3, 0
      }, //
      {95, "Thieves'' tools",
          "This kit contains extra tools and tools of better make, which grant a +2 circumstance bonus on Disable Device checks.",
          100f, 2f, 3, 1
      }, //
      {96, "Tool",
          "This well-made item is the perfect tool for the job. It grants a +2 circumstance bonus on a related skill check (if any). Bonuses provided by multiple masterwork items do not stack.",
          50f, 1f, 3, 1
      }, //
      {97, "Artisan''s outfit",
          "This outfit includes a shirt with buttons, a skirt or pants with a drawstring, shoes, and perhaps a cap or hat. It may also include a belt or a leather or cloth apron for carrying tools.",
          1f, 4f, 5, 0
      }, //
      {98, "Cleric''s vestments",
          "These clothes are for performing priestly functions, not for adventuring. Cleric''s vestments typically include a cassock, stole, and surplice. ",
          5f, 6f, 5, 0
      }, //
      {99, "Cold-weather outfit",
          "This outfit includes a wool coat, linen shirt, wool cap, heavy cloak, thick pants or skirt, and boots. This outfit grants a +5 circumstance bonus on Fortitude saving throws against exposure to cold weather.",
          8f, 7f, 5, 0
      }, //
      {100, "Courtier''s outfit",
          "This outfit includes fancy, tailored clothes in whatever fashion happens to be the current style in the courts of the nobles. Anyone trying to influence nobles or courtiers while wearing street dress will have a hard time of it (-2 penalty on Charisma-based skill checks to influence such individuals). If you wear this outfit without jewelry (costing an additional 50 gp), you look like an out-of-place commoner.",
          30f, 6f, 5, 0
      }, //
      {101, "Entertainer''s outfit",
          "This set of flashy-perhaps even gaudy-clothes is for entertaining. While the outfit looks whimsical, its practical design lets you tumble, dance, walk a tightrope, or just run (if the audience turns ugly).",
          3f, 4f, 5, 0
      }, //
      {102, "Explorer''s outfit",
          "This set of clothes is for someone who never knows what to expect. It includes sturdy boots, leather breeches or a skirt, a belt, a shirt (perhaps with a vest or jacket), gloves, and a cloak. Rather than a leather skirt, a leather overtunic may be worn over a cloth skirt. The clothes have plenty of pockets (especially the cloak). The outfit also includes any extra accessories you might need, such as a scarf or a wide-brimmed hat.",
          10f, 8f, 5, 0
      }, //
      {103, "Monk''s outfit",
          "This simple outfit includes sandals, loose breeches, and a loose shirt, and is bound together with sashes. The outfit is designed to give you maximum mobility, and it''s made of high-quality fabric. You can conceal small weapons in pockets hidden in the folds, and the sashes are strong enough to serve as short ropes.",
          5f, 2f, 5, 0
      }, //
      {104, "Noble''s outfit",
          "These clothes are designed specifically to be expensive and gaudy. Precious metals and gems are worked into the clothing. A would-be noble also needs a signet ring and jewelry (worth at least 100 gp) to accessorize this outfit.",
          75f, 10f, 5, 0
      }, //
      {105, "Peasant''s outfit",
          "This set of clothes consists of a loose shirt and baggy breeches, or a loose shirt and skirt or overdress. Cloth wrappings are used for shoes.",
          0.1f, 2f, 5, 0
      }, //
      {106, "Royal outfit",
          "This is just the clothing, not the royal scepter, crown, ring, and other accoutrements. Royal clothes are ostentatious, with gems, gold, silk, and fur in abundance.",
          200f, 15f, 5, 0
      }, //
      {107, "Scholar''s outfit",
          "Perfect for a scholar, this outfit includes a robe, a belt, a cap, soft shoes, and possibly a cloak.", 5f, 6f, 5, 0
      }, //
      {108, "Traveler''s outfit",
          "This set of clothes consists of boots, a wool skirt or breeches, a sturdy belt, a shirt (perhaps with a vest or jacket), and an ample cloak with a hood.",
          1f, 5f, 5, 0
      }, //
      {109, "Bit and bridle", "", 2f, 1f, 7, 0}, //
      {110, "Dog, guard", "", 25f, 0f, 6, 0}, //
      {111, "Dog, riding",
          "This Medium dog is specially trained to carry a Small humanoid rider. It is brave in combat like a war-trained horse. Due to its smaller stature, you take no damage when you fall from a riding dog.",
          150f, 0f, 6, 0
      }, //
      {112, "Donkey or mule",
          "Donkeys and mules are stolid in the face of danger, hardy, surefooted, and capable of carrying heavy loads over vast distances. Unlike a horse, a donkey or a mule is willing (though not eager) to enter dungeons and other strange or threatening places.",
          8f, 0f, 6, 0
      }, //
      {113, "Feed (per day)",
          "Horses, donkeys, mules, and ponies can graze to sustain themselves, but providing feed for them is better. If you have a riding dog, you have to feed it meat.",
          0.05f, 10f, 7, 0
      }, //
      {114, "Horse, heavy",
          "A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. A pony is smaller than a horse and is a suitable mount for a gnome or halfling.\nA war-trained horse can be ridden into combat without danger. See the Handle Animal skill for a list of tricks known by horses and ponies with combat training.",
          200f, 0f, 6, 0
      }, //
      {115, "Horse, heavy (combat trained)",
          "A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. A pony is smaller than a horse and is a suitable mount for a gnome or halfling.\nA war-trained horse can be ridden into combat without danger. See the Handle Animal skill for a list of tricks known by horses and ponies with combat training.",
          300f, 0f, 6, 0
      }, //
      {116, "Horse, light",
          "A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. A pony is smaller than a horse and is a suitable mount for a gnome or halfling.\nA war-trained horse can be ridden into combat without danger. See the Handle Animal skill for a list of tricks known by horses and ponies with combat training.",
          75f, 0f, 6, 0
      }, //
      {117, "Horse, light (combat trained)",
          "A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. A pony is smaller than a horse and is a suitable mount for a gnome or halfling.\nA war-trained horse can be ridden into combat without danger. See the Handle Animal skill for a list of tricks known by horses and ponies with combat training.",
          110f, 0f, 6, 0
      }, //
      {118, "Pony", "", 30f, 0f, 6, 0}, //
      {119, "Pony (combat trained)", "", 45f, 0f, 6, 0}, //
      {120, "Saddle, Military",
          "This saddle braces the rider, providing a +2 circumstance bonus on Ride checks related to staying in the saddle. If you''re knocked unconscious while in a military saddle, you have a 75% chance to stay in the saddle.",
          20f, 30f, 7, 0
      }, //
      {121, "Saddle, Pack", "A pack saddle holds gear and supplies, but not a rider. It holds as much gear as the mount can carry.",
          5f, 15f, 7, 0
      }, //
      {122, "Saddle, Riding",
          "If you are knocked unconscious while in a riding saddle, you have a 50% chance to stay in the saddle.", 10f, 25f, 7, 0
      }, //
      {123, "Saddle, Exotic, Military",
          "An exotic saddle is designed for an unusual mount. Exotic saddles come in military, pack, and riding styles.", 60f, 40f,
          7, 0
      }, //
      {124, "Saddle, Exotic, Pack",
          "An exotic saddle is designed for an unusual mount. Exotic saddles come in military, pack, and riding styles.", 15f, 20f,
          7, 0
      }, //
      {125, "Saddle, Exotic, Riding",
          "An exotic saddle is designed for an unusual mount. Exotic saddles come in military, pack, and riding styles.", 30f, 30f,
          7, 0
      }, //
      {126, "Saddlebags", "", 4f, 8f, 7, 0}, //
      {127, "Backpack, masterwork",
          "This backpack has numerous pockets for storing various items that might be needed while adventuring. Hooks are included for attaching items such as canteens, pouches, or even a rolled-up blanket. It has padded bands that strap across the chest and the waist to distribute its weight more evenly. Like a common backpack, it can hold about 2 cubic feet of material in its main container. When wearing a masterwork backpack, treat your Strength score as +1 higher than normal when calculating your carrying capacity.",
          50f, 4f, 0, 0
      }, //
      {128, "Barbed vest",
          "Thin leather flaps keep the hundreds of tiny, fishhook-like needles dotting the surface of this black vest from harming you while you wear it. However, any creature that injures you with a natural or unarmed attack must make a DC 15 Reflex save or take 1 point of damage. If a creature swallows you it takes 1 point of damage each round until it either spits you up, you escape, or you die (at which point the vest has sustained enough damage to no longer serve as a threat). The vest can only be worn over light armor or no armor.",
          10f, 4f, 0, 0
      }, //
      {129, "Blanket", "This warm, woven blanket has straps so it can be rolled up and tied.", 0.2f, 1f, 0, 0}, //
      {130, "Buoy, common",
          "A buoy is used to mark a specific spot in lakes, rivers, or similar bodies of water making it possible for you to return to that location a later date. Each includes a float (typically an air-filled bladder or sealed gourd), a 200-foot length of twine, and 15-pound stone used as an anchor. The float is usually painted a vivid color, and may have a small flag to attract attention. Though anchor buoys prove quite resilient to normal weather and tides, they offer little challenge to intelligent creatures determined to sabotage them.",
          0.5f, 16f, 0, 0
      }, //
      {131, "Buoy, superior",
          "This buoy has a spherical or ovoid hollow metal float typically copper, a length of chain rather than twine, and a metal anchor rather than a weight. It is otherwise the same as a common buoy.",
          10f, 30f, 0, 0
      }, //
      {132, "Butterfly net",
          "One end of this 6-foot-long pole supports a wide metal hoop covered by a thin mesh net. You can use this to sift objects out from material capable of passing through the net such as sand or water. You can also use a butterfly net to capture Fine or Diminutive creatures as if it were a net (weapon), though you don''t need to re-fold the butterfly net if you miss, and you use the handle of the butterfly net like you would the rope of a net weapon.",
          5f, 2f, 0, 0
      }, //
      {133, "Chalkboard",
          "A wooden frame approximately the same size as a large book surrounds this thinly sliced piece of polished black stone. Rubbing a simple damp cloth over the slate erases anything scribed with chalk on its surface.",
          1f, 2f, 0, 0
      }, //
      {134, "Chest, small",
          "The common wooden chest comes in several sizes, including small (2 cubic feet, 1 hit point, Break DC 17), medium (4 cubic feet, 15 hp, Break DC 23), large (6 cubic feet, 30 hit points, Break DC 29), and huge (8 cubic feet, 50 hit points, Break DC 35). Most include a simple inset lock.",
          2f, 25f, 0, 0
      }, //
      {135, "Chest, medium",
          "The common wooden chest comes in several sizes, including small (2 cubic feet, 1 hit point, Break DC 17), medium (4 cubic feet, 15 hp, Break DC 23), large (6 cubic feet, 30 hit points, Break DC 29), and huge (8 cubic feet, 50 hit points, Break DC 35). Most include a simple inset lock.",
          5f, 50f, 0, 0
      }, //
      {136, "Chest, large",
          "The common wooden chest comes in several sizes, including small (2 cubic feet, 1 hit point, Break DC 17), medium (4 cubic feet, 15 hp, Break DC 23), large (6 cubic feet, 30 hit points, Break DC 29), and huge (8 cubic feet, 50 hit points, Break DC 35). Most include a simple inset lock.",
          10f, 100f, 0, 0
      }, //
      {137, "Chest, huge",
          "The common wooden chest comes in several sizes, including small (2 cubic feet, 1 hit point, Break DC 17), medium (4 cubic feet, 15 hp, Break DC 23), large (6 cubic feet, 30 hit points, Break DC 29), and huge (8 cubic feet, 50 hit points, Break DC 35). Most include a simple inset lock.",
          25f, 250f, 0, 0
      }, //
      {138, "Earplugs",
          "Made of waxed cotton or cork, earplugs give you a +2 circumstance bonus on saves against effects that require hearing but also cause a -5 penalty on hearing-based Perception checks.",
          0.03f, 0f, 0, 0
      }, //
      {139, "Hourglass (1 hour)",
          "The standard hourglass takes 1 hour to empty the sand from the upper chamber, larger and smaller timers exist which mark off time in increments as short as 6 seconds.",
          25f, 1f, 0, 0
      }, //
      {140, "Hourglass (1 minute)",
          "The standard hourglass takes 1 hour to empty the sand from the upper chamber, larger and smaller timers exist which mark off time in increments as short as 6 seconds.",
          20f, 0.5f, 0, 0
      }, //
      {141, "Hourglass (6 seconds)",
          "The standard hourglass takes 1 hour to empty the sand from the upper chamber, larger and smaller timers exist which mark off time in increments as short as 6 seconds.",
          10f, 0f, 0, 0
      }, //
      {142, "Iron spike",
          "This foot-long iron spike is used to keep doors open or closed and to secure ropes for climbing. Hearing a spike being hammered in requires a DC 5 Perception check.",
          0.05f, 1f, 0, 0
      }, //
      {143, "Magnet",
          "Handheld magnets are relatively weak and are mainly used to detect or pull iron, mithral, or adamantine at a short range. This hand-sized horseshoe magnet can lift up to a 3-pound iron weight.",
          0.5f, 0.5f, 0, 0
      }, //
      {144, "Marbles",
          "Like caltrops, marbles can be used to slow down opponents. One 2-pound bag of marbles covers an area 5 feet square. A creature entering a square with marbles scattered on it must make a DC 10 Reflex save or fall prone (the creature''s stability bonus to trip applies to this save). Any creature moving at half speed or slower can pick its way through a square of marbles with no trouble.",
          0.1f, 2f, 0, 0
      }, //
      {145, "Paper (sheet)",
          "Ordinary paper typically measures 9 inches by 6 inches and is unsuitable for making magical scrolls. It has hardness 0, 1 hit point, and break DC 5.",
          0.4f, 0f, 0, 0
      }, //
      {146, "Periscope",
          "This 2-foot-long metal tube has right angles at each end with mirrors inside, if you look in one end, you can see out the other end, allowing you safely peer over obstacles, around corners, or into small spaces your head wouldn''t fit. When using a periscope, the end of the tube counts as a Diminutive object, making it much less likely an observed creature notices you, if you have total concealment from the creature except for the end of the periscope, use the tube''s Diminutive size modifier for your Stealth instead of your own size modifier. Distortion from the mirrors gives you a -4 penalty on Perception checks while looking through the periscope. Though the tube is fairly sturdy (hardness 5, 2 hit points), the mirrors inside are fragile (hardness 1, 1 hit point), and any damage that gets through the tube''s hardness applies to the tube and the mirrors.",
          20f, 4f, 0, 0
      }, //
      {147, "Poison pill ring",
          "This ring has a tiny compartment under the setting, typically used to hold poison. Opening and closing a ring is a move action, doing so unseen requires a DC 20 Sleight of Hand check.",
          20f, 0f, 0, 0
      }, //
      {148, "Powder",
          "Powdered chalk, flour, and similar materials are popular with adventurers for their utility in pinpointing invisible creatures. Throwing a bag of powder into a square is an attack against AC 5, and momentarily reveals if there is an invisible creature there. A much more effective method is to spread powder on a surface (which takes 1 full round) and look for footprints.",
          0.01f, 0.5f, 0, 0
      }, //
      {149, "Rice paper (sheet)",
          "This variety of paper is made of rice or tree bark. It has hardness 0, 1 hit point, and break DC 2.", 0.05f, 0f, 0, 0
      }, //
      {150, "Rope, spider''s silk (50 ft.)",
          "Rare to virtually nonexistent on the surface world, spider''s silk rope is woven of strands of silk from monstrous spiders by goblin slaves in the employ of the drow. As such it is commonly used by the dark elves, though shorter spider''s silk rope scraps (generally no more than 10 feet long) frequently appear among goblins. Spider''s silk rope has 6 hit points and can be burst with a DC 25 Strength check.",
          100f, 4f, 0, 0
      }, //
      {151, "Scroll case",
          "A leather or wooden scroll case easily holds four scrolls, you can cram more inside but retrieving any of them becomes a full-round action rather than a move action. You must destroy the scroll case to damage its contents (hardness 2 for leather or 5 for wood, 2 hit points, Break DC 15). A scroll case is not water-tight.",
          1f, 0.5f, 0, 0
      }, //
      {152, "Signal horn",
          "Sounding a horn requires a DC 10 Perform (wind instruments) check and can convey concepts such as ''Attack!'', ''Help!'', ''Advance!'', ''Retreat!'', ''Fire!'', and, ''Alarm!'' The report of a signal horn can be clearly heard (Perception DC 0) up to a half-mile distant. For each quarter-mile beyond, Perception checks to hear the horn suffer a -1 penalty.",
          1f, 2f, 0, 0
      }, //
      {153, "Smoked goggles",
          "These spectacles have lenses made of smoked glass that help protect against creatures with gaze attacks. You are always treated as averting your gaze when dealing with gaze attacks, and you gain a +8 circumstance bonus on saving throws against visual-based attacks (any attack that a blind creature would be immune to). You have a -4 penalty on Perception checks while wearing the goggles, and all opponents are treated as having concealment (20% miss chance).",
          10f, 0f, 0, 0
      }, //
      {154, "String or twine (50 ft.)",
          "Sold in balls or spools of 50 feet, string and twine are useful for rigging traps and alarms and are a vital component of grappling bolts and arrows. String or twine has hardness 0, 1 hit point, and Break DC 14.",
          0.01f, 0.5f, 0, 0
      }, //
      {155, "Swarmsuit",
          "These heavy and overlapping layers of clothing, coupled with a wide hat outfitted with a dense, veil-like netting around its brim makes it all but impossible for Diminutive and Fine creatures to make physical contact with your body. Wearing a swarmsuit cuts your speed in half, but gives you DR 10/- against swarms of Fine creatures and DR 5/- against swarms of Diminutive creatures.",
          20f, 10f, 0, 0
      }, //
      {156, "Tattoo",
          "The cost of a tattoo depends on the quality, size, and number of colors used. A coin-sized tattoo in blue ink that will blur over a decade may cost 1 cp, a hand-sized one in black ink that won''t fade costs 1 sp, and a tattoo covering an entire back takes several sessions and costs 10 gp. Each additional color costs as much as a single tattoo of its size.",
          20f, 0f, 0, 0
      }, //
      {157, "Tent, small",
          "Tents come in a variety of sizes and accommodate between one and 10 people. A small tent holds one Medium creature and takes 20 minutes to assemble, a medium tent holds two creatures and takes 30 minutes, a large tent holds four creatures and takes 45 minutes, and a pavilion holds 10 creatures and takes 90 minutes (two Small creatures count as a Medium creature, and one Large creature counts as two Medium creatures). Pavilion tents are large enough to accommodate a small fire in the center. Packing up a tent takes half as long as assembling it.",
          10f, 20f, 0, 0
      }, //
      {158, "Tent, medium",
          "Tents come in a variety of sizes and accommodate between one and 10 people. A small tent holds one Medium creature and takes 20 minutes to assemble, a medium tent holds two creatures and takes 30 minutes, a large tent holds four creatures and takes 45 minutes, and a pavilion holds 10 creatures and takes 90 minutes (two Small creatures count as a Medium creature, and one Large creature counts as two Medium creatures). Pavilion tents are large enough to accommodate a small fire in the center. Packing up a tent takes half as long as assembling it.",
          15f, 30f, 0, 0
      }, //
      {159, "Tent, large",
          "Tents come in a variety of sizes and accommodate between one and 10 people. A small tent holds one Medium creature and takes 20 minutes to assemble, a medium tent holds two creatures and takes 30 minutes, a large tent holds four creatures and takes 45 minutes, and a pavilion holds 10 creatures and takes 90 minutes (two Small creatures count as a Medium creature, and one Large creature counts as two Medium creatures). Pavilion tents are large enough to accommodate a small fire in the center. Packing up a tent takes half as long as assembling it.",
          30f, 40f, 0, 0
      }, //
      {160, "Tent, pavilion",
          "Tents come in a variety of sizes and accommodate between one and 10 people. A small tent holds one Medium creature and takes 20 minutes to assemble, a medium tent holds two creatures and takes 30 minutes, a large tent holds four creatures and takes 45 minutes, and a pavilion holds 10 creatures and takes 90 minutes (two Small creatures count as a Medium creature, and one Large creature counts as two Medium creatures). Pavilion tents are large enough to accommodate a small fire in the center. Packing up a tent takes half as long as assembling it.",
          100f, 50f, 0, 0
      }, //
      {161, "Weapon cord",
          "Weapon cords are 2-foot-long leather straps that attach your weapon to your wrist. If you drop your weapon or are disarmed, you can recover it as a swift action, and it never moves any further away from you than an adjacent square. However, you cannot switch to a different weapon without first untying the cord (a full-round action) or cutting it (a move action or an attack, hardness 0, 0 hp). Unlike a locked gauntlet, you can still use a hand with a weapon cord, though a dangling weapon may interfere with finer actions.",
          0.1f, 0f, 0, 0
      }, //
      {162, "Whistle, signal",
          "With a DC 5 Perform (wind instruments) check you can use a whistle to signal the same sorts of situations as signal horns. A whistle''s piercing report can be clearly heard (Perception DC 0) up to a quarter-mile away. For each quarter-mile beyond, Perception checks to hear a whistle suffer a -2 penalty.",
          0.8f, 0f, 0, 0
      }, //
      {163, "Whistle, silent", "", 0.9f, 0f, 0, 0}, //
      {164, "Alchemical grease",
          "Each pot of this slick black goo has sufficient contents to cover one Medium or two Small creatures. If you coat yourself in alchemical grease, you gain a +5 alchemical bonus on Escape Artist checks, on combat maneuver checks made to escape a grapple, and to your CMD to avoid being grappled, this lasts 4 hours or until you wash it off.",
          5f, 1f, 1, 0
      }, //
      {165, "Alchemical solvent (vial)",
          "This bubbling purple gel eats through adhesives. Each vial can cover a single 5-foot square. It destroys normal adhesives (such as tar, tree sap, or glue) in a single round but takes 1d4+1 rounds to deal with more powerful adhesives (tanglefoot bags, spider webbing, and so on). It has no affect on fully magical adhesives, including sovereign glue.",
          20f, 0.5f, 1, 0
      }, //
      {166, "Alchemist''s kindness",
          "Favored by young rakes and others of means, this is a crystalline powder resembling salt. Mixed with water, it makes a fizzing cocktail that eliminates the effects of a hangover within 10 minutes of drinking it.",
          1f, 0f, 1, 0
      }, //
      {167, "Alkali flask",
          "This flask of caustic liquid reacts with an ooze''s natural acids. You can throw an alkali flask as a splash weapon with a range increment of 10 feet. Against non-ooze creatures, an alkali flask functions as a normal flask of acid. Against oozes and other acid-based creatures, the alkali flask inflicts double damage.",
          15f, 1f, 1, 0
      }, //
      {168, "Antiplague (vial)",
          "If you drink a vial of this foul-tasting, milky tonic, you gain a +5 alchemical bonus on Fortitude saving throws against disease for the next hour. If already infected, you may also make two saving throws (without the +5 bonus) that day and use the better result.",
          50f, 0f, 1, 0
      }, //
      {169, "Bladeguard",
          "This clear resin protects a weapon from harmful attacks from oozes, rust monsters, and similar effects that corrode or melt weapons, rendering the weapon immune for 24 hours. One pot can coat one two-handed weapon, two one-handed or light weapons, or 50 ammunition items. Applying it takes 1 full round. Immersing the weapon in water or similar liquid washes it off.",
          40f, 0f, 1, 0
      }, //
      {170, "Bloodblock",
          "This gooey, pinkish substance helps treat wounds. Using a dose gives you a +5 alchemical bonus on Heal checks for providing first aid, treating wounds made by caltrops or similar objects, or treating deadly wounds. A dose of bloodblock ends a bleed effect as if you had made a DC 15 Heal check. When treating deadly wounds, using a dose of bloodblock counts as one use of a healer''s kit (and grants the +5 bonus stated above).",
          25f, 0f, 1, 0
      }, //
      {171, "Casting plaster",
          "This white, dry powder mixes with water to form a paste, which hardens over the course of an hour to create a solid material. It can be used to make casts of footprints or carvings, fill in gaps or cracks in walls, or (if applied over a cloth wrapping) create a splint for a broken bone. Hardened plaster has hardness 1 and 5 hp per inch of thickness. A 5-pound clay pot of plaster can cover about five square feet of flat space to a depth of one inch, five Medium forearm or lower-leg casts, or two full-arm or full-leg casts.",
          0.5f, 5f, 1, 0
      }, //
      {172, "Flash powder",
          "This coarse gray powder ignites and burns almost instantly if exposed to flame, significant friction, or even a simple force such as throwing it against a floor (a standard action). Creatures within the 10-foot-radius burst are blinded for 1 round (Fortitude DC 13 negates).",
          50f, 0f, 1, 0
      }, //
      {173, "Light detector",
          "This hand-sized metal plate is covered with a thin layer of light-sensitive transparent paste. If exposed to light, the paste darkens and becomes opaque, depending on the amount of light. Bright light causes it to fully darken in 1 round, normal light in 3 rounds, dim light in 10 rounds. It is mainly used by creatures with darkvision to determine if creatures have recently passed through an area carrying light. The plate is sold wrapped in a thick black cloth to prevent accidental light exposure from ruining the plate.",
          1f, 0f, 1, 0
      }, //
      {174, "Liquid ice (flask)",
          "Also known as ''alchemist''s ice,'' this sealed jar of crystalline blue fluid immediately starts to evaporate once opened. During the next 1d6 rounds, you can use it to freeze a liquid or to coat an object in a thin layer of ice. You can also throw liquid ice as a splash weapon. A direct hit deals 1d6 points of cold damage, creatures within 5 feet of where it hits take 1 point of cold damage from the splash.",
          40f, 2f, 1, 0
      }, //
      {175, "Nushadir (vial)",
          "Normally stored in the form of small, salty pellets in a dry container, this reagent can be mixed with a flask of water and stored safely. Nushadir neutralizes acid, a vial of pellets or a flask of nushadir-water is enough to render a cubic foot of acid safe to touch in 1 minute, though this is usually too slow to prevent damage from a thrown vial of acid or the contents of a large monster''s gullet. Nushadir vapors are slightly irritating to the eyes, nose, and mouth, causing nausea for 1d4 rounds after close exposure (Fortitude DC 10 negates).",
          10f, 1f, 1, 0
      }, //
      {176, "Smelling salts",
          "These sharply scented gray crystals cause people inhaling them to regain consciousness. Smelling salts grant you a new saving throw to resist any spell or effect that has already rendered you unconscious or staggered. If exposed to smelling salts while dying, you immediately become conscious and staggered, but must still make stabilization checks each round, if you perform any standard action (or any other strenuous action) you take 1 point of damage after completing the act and fall unconscious again. A container of smelling salts has dozens of uses if stoppered after each use, but depletes in a matter of hours if left opened.",
          25f, 0f, 1, 0
      }, //
      {177, "Smoke pellet",
          "This small clay sphere contains two alchemical substances separated by a thin barrier. When you break the sphere, the substances mingle and fill a 5-foot square with a cloud of foul but harmless yellow smoke. The smoke pellet acts as a smokestick, except the smoke only lasts for 1 round before dispersing. You may throw a smoke pellet as a ranged touch attack with a range increment of 10 feet.",
          25f, 0f, 1, 0
      }, //
      {178, "Sneezing powder (pouch)",
          "This coarse yellowish-red powder is a splash weapon that causes uncontrollable sneezing for 1d4+1 rounds. Anyone standing in the square of impact must succeed on a DC 12 Fortitude save to resist the powder, while those in adjacent squares must make DC 8 Fortitude saves. Creatures affected by sneezing powder must make a DC 10 Fortitude save every round for the duration or be staggered until their next turn.",
          60f, 2f, 1, 0
      }, //
      {179, "Soothe syrup",
          "This sweet and wholesome-tasting blue liquid creates a sense of warmth and comfort. Soothe syrup coats your stomach and makes it much more difficult for you to succumb to queasiness. For 1 hour after drinking soothe syrup you gain a +5 alchemical bonus on saving throws made to resist effects that would make you nauseated or sickened.",
          25f, 0.5f, 1, 0
      }, //
      {180, "Weapon blanch, adamantine",
          "These alchemical powders have a gritty consistency. When poured on a weapon and placed over a hot flame for a full round, they melt and form a temporary coating on the weapon. The blanching gives the weapon the ability to bypass one kind of material-based damage reduction, such as adamantine, cold iron, or silver. The blanching remains effective until the weapon makes a successful attack. Each dose of blanching can coat one weapon or up to 10 pieces of ammunition. Only one kind of weapon blanch can be on a weapon at one time, though a weapon made of one special material (such as adamantine) can have a different material blanch (such as silver), and counts as both materials for the first successful hit.",
          100f, 0.5f, 1, 0
      }, //
      {181, "Weapon blanch, cold iron",
          "These alchemical powders have a gritty consistency. When poured on a weapon and placed over a hot flame for a full round, they melt and form a temporary coating on the weapon. The blanching gives the weapon the ability to bypass one kind of material-based damage reduction, such as adamantine, cold iron, or silver. The blanching remains effective until the weapon makes a successful attack. Each dose of blanching can coat one weapon or up to 10 pieces of ammunition. Only one kind of weapon blanch can be on a weapon at one time, though a weapon made of one special material (such as adamantine) can have a different material blanch (such as silver), and counts as both materials for the first successful hit.",
          20f, 0.5f, 1, 0
      }, //
      {182, "Weapon blanch, silver",
          "These alchemical powders have a gritty consistency. When poured on a weapon and placed over a hot flame for a full round, they melt and form a temporary coating on the weapon. The blanching gives the weapon the ability to bypass one kind of material-based damage reduction, such as adamantine, cold iron, or silver. The blanching remains effective until the weapon makes a successful attack. Each dose of blanching can coat one weapon or up to 10 pieces of ammunition. Only one kind of weapon blanch can be on a weapon at one time, though a weapon made of one special material (such as adamantine) can have a different material blanch (such as silver), and counts as both materials for the first successful hit.",
          5f, 0.5f, 1, 0
      }, //
      {183, "Abacus", "This device helps users perform mathematical calculations.", 2f, 2f, 3, 0}, //
      {184, "Alchemist''s kit",
          "An alchemist with an alchemist''s kit is assumed to have all the material components needed for his extracts, mutagens, and bombs, except for those components that have a specific cost. An alchemist''s kit provides no bonuses on Craft (alchemy) checks.",
          25f, 5f, 4, 0
      }, //
      {185, "Alchemist''s lab, portable",
          "This compact version of a full-sized alchemist''s lab provides a +1 circumstance bonus on Craft (alchemy) checks.", 75f,
          20f, 4, 0
      }, //
      {186, "Anvil",
          "While anvil sizes vary depending on the type of smithing for which they are used, all anvils have the same basic shape and construction. Blacksmith anvils are typically much heavier and larger (100 pounds) than farrier anvils (50 pounds), and they in turn are much bigger than silver- or goldsmith anvils (10 pounds). Many metalworking tasks are impossible without the proper anvil.",
          5f, 100f, 4, 0
      }, //
      {187, "Astrolabe",
          "This device consists of a flat disc upon which two other discs are mounted. The mounted discs can rotate on a central axis, allowing them to spin and move as days pass. The bottom disc represents the latitude of the user, the upper disc represents the sky, and is filled with astronomical features. Anyone can be shown how to use an astrolabe at night to determine the date and time (which takes 1 minute). An astrolabe grants a +2 circumstance on Knowledge (geography) and Survival checks to navigate in the wilderness (and on Profession [sailor] checks to navigate at sea).",
          100f, 6f, 4, 0
      }, //
      {188, "Balancing pole",
          "These flexible poles range from 15-30 feet in length and, when used properly, help you keep your balance when crossing narrow walkways. Using a balancing pole grants you a +1 circumstance bonus on Acrobatics checks made to traverse a narrow surface.",
          0.8f, 12f, 4, 0
      }, //
      {189, "Bear trap",
          "Although intended for trapping large animals, bear traps work as well for trapping humanoids or monsters. The hinged jaws of the trap are attached to a chain, which in turn is secured to a spike driven into the ground to ensure that the victim cannot simply crawl away. Prying open the jaws or pulling the spike from the ground requires a DC 20 Strength check.",
          2f, 10f, 4, 0
      }, //
      {190, "Bellows", "Bellows are useful for starting fires, providing a +1 circumstance bonus on appropriate Survival checks.",
          1f, 3f, 4, 0
      }, //
      {191, "Cauldron",
          "This iron pot may have a hook for hanging over a fire, but versions intended for traveling usually have three or four legs to let it stand over a fire. It holds approximately one gallon, and can be used for cooking, potion-making, and other similar activities.",
          1f, 5f, 4, 0
      }, //
      {192, "Compass",
          "An ordinary compass that points to the magnetic north pole grants its user a +2 circumstance bonus on Survival checks made to avoid becoming lost. It also can be used to grant the same bonus on Knowledge (dungeoneering) checks made to navigate underground.",
          10f, 0.5f, 4, 0
      }, //
      {193, "Drill",
          "A drill can create a 1-inch-diameter hole in stone, wood, or metal as a standard action. Harder materials wear down or break the drill more quickly. Hearing the sound of drilling requires a DC 15 Perception check.",
          0.5f, 1f, 4, 0
      }, //
      {194, "Footprint book",
          "This 50-page tome contains accurate drawings of various common animal, humanoid, and monster tracks, as well as notes on stride length, tread depth, and similarly useful information. The book gives you a +2 circumstance bonus to identify a creature by its tracks, though the use of shoes makes identifying many humanoids difficult or impossible. Though the book can''t help you identify unique individuals, it can help you tell an ogre footprint from a troll footprint, or an elf''s track from an orc''s. Books sold in different areas may have different footprints, depending on what creatures are common to that location.",
          50f, 3f, 3, 0
      }, //
      {195, "Fortune-teller''s deck, common",
          "This deck of illustrated cards is used by those in tune with the spirit world to predict the future-and by charlatans to take money from gullible or desperate people. A common deck only has simple drawings on parchment scraps or simple wooden plaques. A quality fortune-teller''s deck is usually of quality wooden plaques with painted color images, it is suitable as a focus for the augury spell, and provides a +1 circumstance bonus on Profession (fortune-teller), Profession (medium), and similar Profession checks. A masterwork fortune-teller''s deck may be wood, ivory, or even metal, with painted or carved images and often highlighted with gold inlays or tiny gems, it has all the benefits of a quality deck, except it provides a +2 circumstance bonus on the listed skill checks.",
          1f, 0.5f, 4, 0
      }, //
      {196, "Fortune-teller''s deck, quality",
          "This deck of illustrated cards is used by those in tune with the spirit world to predict the future-and by charlatans to take money from gullible or desperate people. A common deck only has simple drawings on parchment scraps or simple wooden plaques. A quality fortune-teller''s deck is usually of quality wooden plaques with painted color images, it is suitable as a focus for the augury spell, and provides a +1 circumstance bonus on Profession (fortune-teller), Profession (medium), and similar Profession checks. A masterwork fortune-teller''s deck may be wood, ivory, or even metal, with painted or carved images and often highlighted with gold inlays or tiny gems, it has all the benefits of a quality deck, except it provides a +2 circumstance bonus on the listed skill checks.",
          25f, 1f, 4, 0
      }, //
      {197, "Fortune-teller''s deck, masterwork",
          "This deck of illustrated cards is used by those in tune with the spirit world to predict the future-and by charlatans to take money from gullible or desperate people. A common deck only has simple drawings on parchment scraps or simple wooden plaques. A quality fortune-teller''s deck is usually of quality wooden plaques with painted color images, it is suitable as a focus for the augury spell, and provides a +1 circumstance bonus on Profession (fortune-teller), Profession (medium), and similar Profession checks. A masterwork fortune-teller''s deck may be wood, ivory, or even metal, with painted or carved images and often highlighted with gold inlays or tiny gems, it has all the benefits of a quality deck, except it provides a +2 circumstance bonus on the listed skill checks.",
          50f, 1f, 4, 0
      }, //
      {198, "Leeching kit",
          "This sturdy ceramic jar has a heavy lid with a few tiny holes to let air in. It is normally half-filled with water and contains four adult leeches, each about 6 inches long. A leeching kit grants a +2 circumstance bonus on Heal checks to treat poison. Used for medicinal bloodletting, a leech can survive for 6 months between feedings.",
          5f, 5f, 4, 0
      }, //
      {199, "Map maker''s kit",
          "This small kit contains a simple slate with a grid carved into its surface and a number of different colored pieces of chalk. Anyone using this kit to draw a map as they travel receives a +2 circumstance bonus on Survival skill checks to avoid becoming lost.",
          10f, 2f, 4, 0
      }, //
      {200, "Portrait book",
          "This 100-page book contains face drawings of male and female dwarves, elves, gnomes, half-elves, half-orcs, halflings, and humans. By selecting an appropriate drawing and adding hair, beard, or other small features such as moles or scars, even a poor artist can quickly create a reasonable likeness of a specific person-for example, an inquisitor making wanted posters of a half-elven witch.",
          10f, 3f, 3, 0
      }, //
      {201, "Pulley",
          "A simple block-and-tackle pulley, when properly secured, adds a +5 circumstance bonus on Strength checks to lift heavy objects. Securing the pulley requires 1 minute.",
          2f, 10f, 3, 0
      }, //
      {202, "Saw",
          "You can insert a saw between a door and its frame to cut through wooden bolts or bars, dealing 5 hit points per round plus your Strength modifier to the sawed object as a full-round action. Hearing the sawing requires a DC 10 Perception check. Saws used to cut ice on rivers have a point on the end to break through the ice before cutting.",
          0.04f, 2f, 4, 0
      }, //
      {203, "Sextant",
          "A sextant is used to determine your latitude. A sextant grants a +4 circumstance bonus on Survival checks made to navigate while above ground.",
          500f, 2f, 4, 0
      }, //
      {204, "Symptom kit",
          "This small wooden box has many tiny compartments filled with items useful if you want to feign a sickness as well as a handy reference book outlining common indicators for some of the more feared virulent diseases. The kit includes such things as false pustules, pills that cause the person chewing them to foam at the mouth, and herbal concoctions designed to induce fevers or vomiting. Using a symptom kit grants you a +5 circumstances bonus on Disguise checks made for the purpose of simulating illness. A symptom kit is exhausted after 10 uses.",
          25f, 5f, 4, 0
      }, //
      {205, "Traveling spellbook (blank)",
          "A traveling spellbook is lighter and less cumbersome than its full-size counterpart. It has 50 pages.", 10f, 1f, 3, 0
      }, //
      {206, "Cleats",
          "Useful on any terrain where traction may be a concern, cleats are shoes with spikes or hooks attached to the soles. Cleats reduce the penalty for walking over slick surfaces by 50%, for example, walking across ice normally costs 2 squares for every square of movement, but with cleats it costs only 1.5 squares for every square. Cleats cause damage to any type of finished flooring.",
          5f, 2f, 5, 0
      }, //
      {207, "Furs",
          "The most basic of cold-weather gear, animal furs serve to keep their wearers warm. Wearing enough fur to cover the body provides a +2 bonus on Fortitude saves to resist cold weather. This does not stack with any bonuses gained from the Survival skill.",
          12f, 5f, 5, 0
      }, //
      {208, "Hot weather outfit",
          "Covering your body from head to foot in light, airy cloth keeps you cooler than baring your skin to the sun. This outfit typically consists of a loose linen robe and either a turban or loose head covering and veil. The outfit provides a +2 bonus on Fortitude saves to resist warm or hot weather. This does not stack with any bonuses gained from the Survival skill.",
          8f, 4f, 5, 0
      }, //
      {209, "Snowshoes",
          "These high-tension nets of rope or sinew in wooden frames which are lashed to the feet spread your weight across the snow, making you much less likely to break through the crust and rendering walking much easier. Snowshoes reduce the penalty for walking through heavy snow by 50%, for example, if moving through snow normally costs you 2 squares of movement per square traveled, snowshoes reduce this cost to 1.5 squares per square traveled.",
          5f, 4f, 5, 0
      }, //
      {210, "Animal harness",
          "This leather or hemp harness allows a holder to restrain and control a domesticated animal. Ready-made harnesses are available in most markets for common domesticated animals such as cats, dogs, horses, and oxen, but harnesses can be made for nearly any creature.",
          2f, 2f, 7, 0
      }, //
      {211, "Cage, Diminutive or Fine",
          "This secure, portable enclosure is used to hold creatures�generally animals, but a large enough cage can hold anything. Cages are made from iron, wood, or bamboo, depending on local customs and available materials.",
          10f, 2f, 7, 0
      }, //
      {212, "Cage, Huge",
          "This secure, portable enclosure is used to hold creatures�generally animals, but a large enough cage can hold anything. Cages are made from iron, wood, or bamboo, depending on local customs and available materials.",
          60f, 960f, 7, 0
      }, //
      {213, "Cage, Large",
          "This secure, portable enclosure is used to hold creatures�generally animals, but a large enough cage can hold anything. Cages are made from iron, wood, or bamboo, depending on local customs and available materials.",
          30f, 240f, 7, 0
      }, //
      {214, "Cage, Small or Medium",
          "This secure, portable enclosure is used to hold creatures�generally animals, but a large enough cage can hold anything. Cages are made from iron, wood, or bamboo, depending on local customs and available materials.",
          15f, 60f, 7, 0
      }, //
      {215, "Cage, Tiny",
          "This secure, portable enclosure is used to hold creatures�generally animals, but a large enough cage can hold anything. Cages are made from iron, wood, or bamboo, depending on local customs and available materials.",
          2f, 5f, 7, 0
      }, //
      {216, "Dog sled",
          "This sled is several feet long and is designed to be pulled over snow and ice by a team of trained riding dogs. Most sleds have runners at the back for a musher to stand on. A dog sled can carry up to the carrying capacity of all the dogs that pull it.",
          20f, 300f, 7, 0
      }, //
      {217, "Loaded dice, average",
          "Most loaded dice are weighted-a heavier substance is included opposite the desired number. You can spot marks from tampering with a die in this fashion with a DC 15 Appraise or Perception check. Higher-quality dice (such as wooden dice carved around a naturally heavy inclusion) have DCs ranging from 20 to 30.",
          10f, 0f, 8, 0
      }, //
      {218, "Loaded dice, superior",
          "Most loaded dice are weighted-a heavier substance is included opposite the desired number. You can spot marks from tampering with a die in this fashion with a DC 15 Appraise or Perception check. Higher-quality dice (such as wooden dice carved around a naturally heavy inclusion) have DCs ranging from 20 to 30.",
          50f, 0f, 8, 0
      }, //
      {219, "Marked cards",
          "Whether bent, colored, or scratched, marked cards allow an informed user to know what''s on the front of the card by viewing the mark on the back. Realizing that the cards are marked requires a DC 25 Perception check.",
          1f, 1f, 8, 0
      }, //
  };

}
