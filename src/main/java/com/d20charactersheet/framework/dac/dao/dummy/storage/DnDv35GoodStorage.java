package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores raw data of all goods.
 */
public class DnDv35GoodStorage {

  /**
   * All goods
   */
  public static final Object[][] GOOD = {
      // id, name, description, cost, weight, good type, quality type
      {0, "Backpack", "A backpack is a leather pack carried on the back, typically with straps to secure it.", 2f, 2f, 0, 0}, //
      {1, "Barrel", "", 2f, 30f, 0, 0}, //
      {2, "Basket", "", 0.4f, 1f, 0, 0}, //
      {3, "Bedroll",
          "You never know where you're going to sleep, and a bedroll helps you get better sleep in a hayloft or on the cold ground. A bedroll consists of bedding and a blanket thin enough to be rolled up and tied. In an emergency, it can double as a stretcher.",
          0.1f, 5f, 0, 0
      }, //
      {4, "Bell", "", 1f, 0f, 0, 0}, //
      {5, "Winter Blanket", "A thick, quilted, wool blanket made to keep you warm in cold weather.", 0.5f, 3f, 0, 0}, //
      {6, "Block and Tackle", "", 5f, 5f, 0, 0}, //
      {7, "Wine Bottle", "", 2f, 0f, 0, 0}, //
      {8, "Bucket", "", 0.5f, 2f, 0, 0}, //
      {9, "Caltrops",
          "A caltrop is a four-pronged iron spike crafted so that one prong faces up no matter how the caltrop comes to rest. You scatter caltrops on the ground in the hope that your enemies step on them or are at least forced to slow down to avoid them. One 2- pound bag of caltrops covers an area 5 feet square.\n\nEach time a creature moves into an area covered by caltrops (or spends a round fighting while standing in such an area), it might step on one. The caltrops make an attack roll (base attack bonus +0) against the creature. For this attack, the creature�s shield, armor, and deflection bonuses do not count. If the creature is wearing shoes or other footwear, it gets a +2 armor bonus to AC. If the caltrops succeed on the attack, the creature has stepped on one. The caltrop deals 1 point of damage, and the creature�s speed is reduced by one-half because its foot is wounded. This movement penalty lasts for 24 hours, or until the creature is successfully treated with a DC 15 Heal check, or until it receives at least 1 point of magical curing. A charging or running creature must immediately stop if it steps on a caltrop. Any creature moving at half speed or slower can pick its way through a bed of caltrops with no trouble.\n\nCaltrops may not be effective against unusual opponents.",
          1f, 2f, 0, 0
      }, //
      {10, "Candle",
          "A candle dimly illuminates a 5-foot radius and burns for 1 hour. See Player's Handbook page 164 for more rules on illumination.",
          0.01f, 0f, 0, 0
      }, //
      {11, "Canvas (1 sq. yd.)", "", 0.1f, 1f, 0, 0}, //
      {12, "Map Case", "This capped leather or tin rube holds rolled pieces of parchment or paper.", 1f, 0.5f, 0, 0}, //
      {13, "Scroll Case", "This capped leather or tin rube holds rolled pieces of parchment or paper.", 1f, 0.5f, 0, 0}, //
      {14, "Chain (10 ft.)", "Chain has hardness 10 and 5 hit points. It can be burst with a DC 26 Strength check.", 30f, 2f, 0, 0},
      //
      {15, "Chalk", "", 0.01f, 0f, 0, 0}, //
      {16, "Chest", "", 2f, 25f, 0, 0}, //
      {17, "Crowbar",
          "This iron bar is made for levering closed items open. A crowbar is the perfect tool for prying open doors or chests, shattering chains, and the like, and it grants a +2 circumstance bonus on Strength checks made for such purposes. If used in combat, treat a crowbar as a one-handed improvised weapon (see page 113) that deals bludgeoning damage equal to that of a club of its size.",
          2f, 5f, 0, 0
      }, //
      {18, "Firewood (per day)", "", 0.01f, 20f, 0, 0}, //
      {19, "Fishhook", "", 0.1f, 0f, 0, 0}, //
      {20, "Fishing Net (25 sq. ft.)", "", 4f, 5f, 0, 0}, //
      {21, "Flask", "This ceramic, glass, or metal container is fitted with a tight stopper and holds 1 pint of liquid.", 0.03f,
          1.5f, 0, 0
      }, //
      {22, "Flint and Steel",
          "Striking steel and flint together creates sparks. By knocking sparks into tinder, you can create a small flame. Lighting a torch with flint and steel is a full-round action, and lighting any other fire with them takes at least that long.",
          1f, 0f, 0, 0
      }, //
      {23, "Grappling Hook",
          "When tied to the end of a rope, a grappling hook can secure the rope to a battlement, window ledge, tree limb, or other protrusion. Throwing a grappling hook successfully requires a Use Rope check (DC 10, +2 per 10 feet of distance thrown).",
          1f, 4f, 0, 0
      }, //
      {24, "Hammer",
          "This one-handed hammer with an iron head is useful for pounding pitons into a wall. If a hammer is used in combat, treat it as a one-handed improvised weapon (see page 113) that deals bludgeoning damage equal to that of a spiked gauntlet of its size.",
          0.5f, 2f, 0, 0
      }, //
      {25, "Vial of Ink", "This is black ink. You can buy ink in other colors, but it costs twice as much.", 8f, 0f, 0, 0}, //
      {26, "Inkpen",
          "An inkpen is a wooden stick with a special tip on the end. The tip draws ink in when dipped in a vial and leaves an ink trail when drawn across a surface.",
          0.1f, 0f, 0, 0
      }, //
      {27, "Clay Jug", "This basic ceramic jug is fitted with a stopper and holds 1 gallon of liquid.", 0.03f, 9f, 0, 0}, //
      {28, "Ladder (10-foot)", "This item is a straight, simple wooden ladder.", 0.05f, 20f, 0, 0}, //
      {29, "Common Lamp",
          "A lamp clearly illuminates a 15-foot radius, provides shadowy illumination out to a 30-foot radius, and burns for 6 hours on a pint of oil. It burns with a more even flame than a torch, but, unlike a lantern, it uses an open flame and it can spill easily, a fact that makes it too dangerous for most adventuring. You can carry a lamp in one hand. See Player's Handbook page 164 for more rules on illumination.",
          0.1f, 1f, 0, 0
      }, //
      {30, "Bullseye Lantern",
          "A bullseye lantern has only a single shutter. Its other sides are highly polished inside to reflect the light in a single direction. A bullseye lantern provides clear illumination in a 60-foot cone and shadowy illumination in a 120-foot cone. It burns for 6 hours on a pint of oil. You can carry a bullseye lantern in one hand. See Player's Handbook page 164 for more rules on illumination.",
          12f, 3f, 0, 0
      }, //
      {31, "Hooded Lantern",
          "A hooded lantern has shuttered or hinged sides. It clearly illuminates a 30-foot radius and provides shadowy illumination in a 60-foot radius. It burns for 6 hours on a pint of oil. You can carry a hooded lantern in one hand. See Player's Handbook page 164 for more rules on illumination.",
          7f, 2f, 0, 0
      }, //
      {32, "Lock, very simple",
          "A lock is warded with a large, bulky key. The DC to open a simple lock with the Open Lock skill is 20.", 20f, 1f, 0, 0
      }, //
      {33, "Lock, average",
          "A lock is warded with a large, bulky key. The DC to open an average lock with the Open Lock skill is 25.", 40f, 1f, 0, 0
      }, //
      {34, "Lock, good", "A lock is warded with a large, bulky key. The DC to open a good lock with the Open Lock skill is 30.",
          80f, 1f, 0, 0
      }, //
      {35, "Lock, amazing",
          "A lock is warded with a large, bulky key. The DC to open an amazing lock with the Open Lock skill is 40.", 150f, 1f, 0, 0
      }, //
      {36, "Manacles",
          "The manacles detailed on Table 7-8: Goods and Services can bind a Medium creature. A manacled creature can use the Escape Artist skill to slip free (DC 30). Breaking the manacles requires a Strength check (DC 26). Manacles have hardness 10 and 10 hit points. Most manacles have locks, add the cost of the lock you want to the cost of the manacles.\n\nFor the same cost, you can buy manacles for a Small creature. For a Large creature, manacles cost ten times the indicated amount, and for a Huge creature, one hundred times this amount. Gargantuan, Colossal, Tiny, Diminutive, and Fine creatures can be held only by specially made manacles.",
          15f, 2f, 0, 0
      }, //
      {37, "Manacles",
          "The manacles detailed on Table 7-8: Goods and Services can bind a Medium creature. A manacled creature can use the Escape Artist skill to slip free (DC 35). Breaking the manacles requires a Strength check (DC 28). Manacles have hardness 10 and 10 hit points. Most manacles have locks, add the cost of the lock you want to the cost of the manacles.\n\nFor the same cost, you can buy manacles for a Small creature. For a Large creature, manacles cost ten times the indicated amount, and for a Huge creature, one hundred times this amount. Gargantuan, Colossal, Tiny, Diminutive, and Fine creatures can be held only by specially made manacles.",
          50f, 2f, 0, 1
      }, //
      {38, "Small Steel Mirror",
          "A polished steel mirror is handy when you want to look around corners, signal friends with reflected sunlight, keep an eye on a medusa, make sure that you look good enough to present yourself to the queen, or examine wounds that you've received on hard-to-see parts of your body.",
          10f, 0.5f, 0, 0
      }, //
      {39, "Clay Mug", "", 0.02f, 1f, 0, 0}, //
      {40, "Clay Tankard", "", 0.02f, 1f, 0, 0}, //
      {41, "Flask of Oil",
          "A pint of oil burns for 6 hours in a lantern. You can use a flask of oil as a splash weapon (see Throw Splash Weapon, Player's Handbook page 158). Use the rules for alchemist's fire, except that it takes a full-round action to prepare a flask with a fuse. Once it is thrown, there is a 50% chance of the flask igniting successfully.\n\nYou can pour a pint of oil on the ground to cover an area 5 feet square, provided that the surface is smooth. If lit, the oil burns for 2 rounds and deals 1d3 points of fire damage to each creature in the area.",
          0.1f, 1f, 0, 0
      }, //
      {42, "Paper (Sheet)", "A sheet of standard paper is made from cloth fibers.", 0.4f, 0f, 0, 0}, //
      {43, "Parchment (Sheet)", "A sheet of parchment is a piece of goat hide or sheepskin that has been prepared for writing on.",
          0.2f, 0f, 0, 0
      }, //
      {44, "Miner Pick", "", 3f, 10f, 0, 0}, //
      {45, "Clay Pitcher", "", 0.02f, 5f, 0, 0}, //
      {46, "Piton",
          "When a wall doesn't offer handholds and footholds, you can make your own. A piton is a steel spike with an eye through which you can loop a rope. (See the Climb skill, Player's Handbook page 69).",
          0.1f, 0.5f, 0, 0
      }, //
      {47, "Pole (10-foot)",
          "When you suspect a trap, you can put the end of your 10-foot pole through that hole in the wall instead of reaching in with your hand.",
          0.2f, 8f, 0, 0
      }, //
      {48, "Iron Pot", "", 0.5f, 10f, 0, 0}, //
      {49, "Belt Pouch", "This leather pouch straps to your belt. It's good for holding small items.", 1f, 0.5f, 0, 0}, //
      {50, "Portable Ram",
          "This iron-shod wooden beam is the perfect tool for battering down a door. Not only does it gives you a +2 circumstance bonus on Strength checks made to break open a door, it also allows a second person to help you without having to roll, increasing your bonus by 2 (see Breaking Items, Player's Handbook page 167).",
          10f, 20f, 0, 0
      }, //
      {51, "Trail Rations (per Day)",
          "Trail rations are compact, dry, high-energy foods suitable for travel, such as jerky, dried fruit, hardtack, and nuts.",
          0.5f, 1f, 0, 0
      }, //
      {52, "Rope, Hempen", "This rope has 2 hit points and can be burst with a DC 23 Strength check.", 1f, 10f, 0, 0}, //
      {53, "Rope, Silk",
          "This rope has 4 hit points and can be burst with a DC 24 Strength check. It is so supple that it provides a +2 circumstance bonus on Use Rope checks.",
          10f, 5f, 0, 0
      }, //
      {54, "Sack", "This item is made of burlap or a similar material and has a drawstring so it can be closed.", 0.1f, 0.5f, 0, 0},
      //
      {55, "Sealing Wax", "", 1f, 1f, 0, 0}, //
      {56, "Needle Sewing", "", 0.5f, 0f, 0, 0}, //
      {57, "Signal Whistle", "", 0.8f, 0f, 0, 0}, //
      {58, "Signet Ring",
          "Each signet ring has a distinctive design carved into it. When you press this ring into warm sealing wax, you leave an identifying mark.",
          5f, 0f, 0, 0
      }, //
      {59, "Sledge", "This two-handed, iron-headed hammer is good for smashing open treasure chests.", 1f, 10f, 0, 0}, //
      {60, "Soap", "", 0.5f, 1f, 0, 0}, //
      {61, "Shovel", "", 2f, 8f, 0, 0}, //
      {62, "Spade", "", 2f, 8f, 0, 0}, //
      {63, "Spyglass", "Objects viewed through a spyglass are magnified to twice their size.", 1000f, 1f, 0, 0}, //
      {64, "Tent", "This simple tent sleeps two.", 10f, 20f, 0, 0}, //
      {65, "Torch",
          "A typical torch is a wooden rod capped with a twisted flax soaked in tallow. A torch burns for 1 hour, clearly illuminating a 20-foot radius and providing shadowy illumination out to a 40-foot radius. See Player's Handbook page 164 for more rules on illumination. If a torch is used in combat, treat it as a one-handed improvised weapon (see Player's Handbook page 113) that deals bludgeoning damage equal to that of a gauntlet of its size, plus 1 point of fire damage.",
          0.01f, 1f, 0, 0
      }, //
      {66, "Vial",
          "This ceramic, glass, or metal vial is fitted with a tight stopper and holds 1 ounce of liquid. The stoppered container usually is no more than 1 inch wide and 3 inches high.",
          1f, 0f, 0, 0
      }, //
      {67, "Potion", "", 1f, 0f, 0, 0}, //
      {68, "Waterskin", "A waterskin is a leather pouch with a narrow neck that is used for holding water.", 1f, 4f, 0, 0}, //
      {69, "Whetstone", "", 0.02f, 1f, 2, 0}, //
      {70, "Acid (flask)",
          "You can throw a flask of acid as a splash weapon (see Throw Splash Weapon, Player's Handbook page 158). Treat this attack as a ranged touch attack with a range increment of 10 feet. A direct hit deals 1d6 points of acid damage. Every creature within 5 feet of the point where the acid hits takes 1 point of acid damage from the splash",
          10f, 1f, 1, 0
      }, //
      {71, "Alchemist Fire (flask)",
          "Alchemist's fire is sticky, adhesive substance that ignites when exposed to air. You can throw a flask of alchemist's fire as a splash weapon (see Throw Splash Weapon, Player's Handbook page 158). Treat this attack as a ranged touch attack with a range increment of 10 feet.\n\nA direct hit deals 1d6 points of fire damage. Every creature within 5 feet of the point where the flask hits takes 1 point of fire damage from the splash. On the round following a direct hit, the target takes an additional 1d6 points of damage. If desired, the target can use a full-round action to attempt to extinguish the flames before taking this additional damage. Extinguishing the flames requires a DC 15 Reflex save. Rolling on the ground provides the target a +2 bonus on the save. Leaping into a lake or magically extinguishing the flames automatically smothers the fire.",
          20f, 1f, 1, 0
      }, //
      {72, "Antitoxin (vial)",
          "If you drink antitoxin, you get a +5 alchemical bonus on Fortitude saving throws against poison for 1 hour.", 50f, 0f, 1,
          0
      }, //
      {73, "Everburning Torch",
          "This otherwise normal torch has a continual flame spell cast upon it. An everburning torch clearly illuminates a 20-foot radius and provides shadowy illumination out to a 40-foot radius. See Player's Handbook page 164 for more rules on illumination.",
          110f, 1f, 2, 0
      }, //
      {74, "Holy Water (flask)",
          "Holy water damages undead creatures and evil outsiders almost as if it were acid. A flask of holy water can be thrown as a splash weapon (see Throw Splash Weapon, Player's Handbook page 158). Treat this attack as a ranged touch attack with a range increment of 10 feet. A flask breaks if thrown against the body of a corporeal creature, but to use it against an incorporeal creature, you must open the flask and pour the holy water out onto the target. Thus, you can douse an incorporeal creature with holy water only if you are adjacent to it. Doing so is a ranged touch attack that does not provoke attacks of opportunity.\n\nA direct hit by a flask of holy water deals 2d4 points of damage to an undead creature or an evil outsider. Each such creature within 5 feet of the point where the flask hits takes 1 point of damage from the splash.\n\nTemples to good deities sell holy water at cost (making no profit) because the clerics are happy to supply people with what they need to battle evil.",
          25f, 1f, 1, 0
      }, //
      {75, "Smokestick",
          "This alchemically treated wooden stick instantly creates thick, opaque smoke when ignited. The smoke fills a 10-foot cube (treat the effect as a fog cloud spell, except that a moderate or stronger wind dissipates the smoke in 1 round). The stick is consumed after 1 round, and the smoke dissipates naturally.",
          20f, 0.5f, 2, 0
      }, //
      {76, "Sunrod",
          "This 1-foot-long, gold-tipped, iron rod glows brightly when struck. It clearly illuminates a 30-foot radius and provides shadowy illumination in a 60-foot radius. It glows for 6 hours, after which the gold tip is burned out and worthless. See Player's Handbook page 164 for more rules on illumination.",
          2f, 1f, 2, 0
      }, //
      {77, "Tanglefoot Bag",
          "This round leather bag is full of alchemical goo. When you throw a tanglefoot bag at a creature (as a ranged touch attack with a range increment of 10 feet), the bag comes apart and the goo bursts out, entangling the target and then becoming tough and resilient upon exposure to air. An entangled creature takes a -2 penalty on attack rolls and a -4 penalty to Dexterity and must make a DC 15 Reflex save or be glued to the floor, unable to move. Even on a successful save, it can move only at half speed. Huge or larger creatures are unaffected by a tanglefoot bag. A flying creature is not stuck to the floor, but it must make a DC 15 Reflex save or be unable to fly (assuming it uses its wings to fly) and fall to the ground. A tanglefoot bag does not function underwater.\n\nA creature that is glued to the floor (or unable to fly) can break free by making a DC 17 Strength check or by dealing 15 points of damage to the goo with a slashing weapon. A creature trying to scrape goo off itself, or another creature assistig, does not need to make an attack roll, hitting the goo is automatic, after which the creature that hit makes a damage roll to see how much of the goo was scraped off. Once free, the creature can move (including flying) at half speed. A character capable of spellcasting who is bound by the goo must make a DC 15 Concentration check to cast a spell. The goo becomes brittle and fragile after 2d4 rounds, cracking apart and losing its effectiveness. An application of universal solvent (see page 268 of the Dungeon Master's Guide) to a stuck creature dissolves the alchemical goo immediately.",
          50f, 4f, 2, 0
      }, //
      {78, "Thunderstone",
          "You can throw this stone as a ranged attack with a range increment of 20 feet. When it strikes a hard surface (or is struck hard), it creates a deafening bang that is treated as a sonic attack. Each creature within a 10-foot-radius spread must make a DC 15 Fortitude save or be deafened for 1 hour. A deafened creature, in addition to the obvious effects, takes a �4 penalty on initiative and has a 20% chance to miscast and lose any spell with a verbal component that it tries to cast.\n\nSince you don�t need to hit a specific target, you can simply aim at a particular 5-foot square. Treat the target square as AC 5, if you miss, see Throw Splash Weapon, Player's Handbook page 158, to determine where the thunderstone lands.",
          30f, 1f, 2, 0
      }, //
      {79, "Tindertwig",
          "The alchemical substance on the end of this small, wooden stick ignites when struck against a rough surface. Creating a flame with a tindertwig is much faster than creating a flame with flint and steel (or a magnifying glass) and tinder. Lighting a torch with a tindertwig is a standard action (rather than a full-round action), and lighting any other fire with one is at least a standard action.",
          1f, 0f, 2, 0
      }, //
      {80, "Alchemist Lab",
          "This set of equipment includes beakers, bottles, mixing and measuring containers, and a miscellany of chemicals and substances. An alchemist's lab always has the perfect tool for making alchemical items, so it provides a +2 circumstance bonus on Craft (alchemy) checks. It has no bearing on the costs related to the Craft (alchemy) skill. Without this lab, a character with the Craft (alchemy) skill is assumed to have enough tools to use the skill but not enough to get the +2 bonus that the lab provides.",
          500f, 40f, 3, 0
      }, //
      {81, "Artisan Tools",
          "These special tools include the items needed to pursue any craft. Without them, you have to use improvised tools (-2 penalty on Craft checks), if you can do the job at all.",
          5f, 5f, 3, 0
      }, //
      {82, "Artisan Tools",
          "These tools serve the same purpose as artisan's tools (above), but masterwork artisan's tools are the perfect tools for the job, so you get a +2 circumstance bonus on Craft checks made with them.",
          55f, 5f, 3, 1
      }, //
      {83, "Climber Kit",
          "A climber's kit includes special pitons, boot tips, gloves, and a harness that aids in all sorts of climbing. This is the perfect tool for climbing and gives you a +2 circumstance bonus on Climb checks.",
          80f, 5f, 4, 0
      }, //
      {84, "Disguise Kit",
          "This bag contains cosmetics, hair dye, and small physical props. The kit is the perfect tool for disguise and provides a +2 circumstance bonus on Disguise checks. A disguise kit is exhausted after ten uses.",
          50f, 8f, 4, 0
      }, //
      {85, "Healer Kit",
          "This kit is full of herbs, salves, bandages and other useful materials. It is the perfect tool for healing and provides a +2 circumstance bonus on Heal checks. A healer's kit is exhausted after ten uses.",
          50f, 1f, 4, 0
      }, //
      {86, "Holly and Mistletoe",
          "Sprigs of holly and mistletoe are used by druids as the default divine focus for druid spells. Druids can easily find these plants in wooded areas and then harvest sprigs from them essentially for free.",
          0f, 0f, 3, 0
      }, //
      {87, "Holy Symbol, wooden",
          "A holy symbol focuses positive energy. A cleric or paladin uses it as the focus for his spells and as a tool for turning undead. Each religion has its own holy symbol, and a sun symbol is the default holy symbol for clerics not associated with any particular religion.\n\n A silver holy symbol works no better than a wooden one, but it serves as a mark of status for the wielder.\n\n Unholy Symbols: An unholy symbol is like a holy symbol except that it focuses negative energy and is used by evil clerics (or by neutral clerics who want to cast evil spells or command undead). A skull is the default unholy symbol for clerics not associated with any particular religion.",
          1f, 0f, 3, 0
      }, //
      {88, "Holy Symbol, silver",
          "A holy symbol focuses positive energy. A cleric or paladin uses it as the focus for his spells and as a tool for turning undead. Each religion has its own holy symbol, and a sun symbol is the default holy symbol for clerics not associated with any particular religion.\n\n A silver holy symbol works no better than a wooden one, but it serves as a mark of status for the wielder.\n\n Unholy Symbols: An unholy symbol is like a holy symbol except that it focuses negative energy and is used by evil clerics (or by neutral clerics who want to cast evil spells or command undead). A skull is the default unholy symbol for clerics not associated with any particular religion.",
          25f, 1f, 3, 0
      }, //
      {89, "Hourglass", "", 25f, 1f, 3, 0}, //
      {90, "Magnifying Glass",
          "This simple lens allows a closer look at small objects. It is also useful as a substitute for flint and steel when starting fires. Lighting a fire with a magnifying glass requires light as bright as sunlight to focus, tinder to ignite, and at least a full-round action. A magnifying glass grants a +2 circumstance bonus on Appraise checks involving any item that is small or highly detailed, such as a gem.",
          100f, 0f, 3, 0
      }, //
      {91, "Musical Instrument, Common", "Popular instruments include the fife, recorder, lute, mandolin, and shawm.", 5f, 3f, 3, 0
      }, //
      {92, "Musical Instrument",
          "Popular instruments include the fife, recorder, lute, mandolin, and shawm. A masterwork instrument grants a +2 circumstance bonus on Perform checks involving its use.",
          100f, 3f, 3, 1
      }, //
      {93, "Scale, Merchant",
          "This scale includes a small balance and pans, plus a suitable assortment of weights. A scale grants a +2 circumstance bonus on Appraise checks involving items that are valued by weight, including anything made of precious metals.",
          2f, 1f, 3, 0
      }, //
      {94, "Spell Component Pouch",
          "This small, watertight leather belt pouch has many compartments. A spellcaster with a spell component pouch is assumed to have all the material components and focuses needed for spellcasting, except for those components that have a specific cost, divine focuses, and focuses that wouldn't fit in a pouch (such as the natural pool that a druid needs to look into to cast scrying).",
          5f, 2f, 3, 0
      }, //
      {95, "Spellbook",
          "This large, leatherbound book serves as a wizard's reference. A spellbook has 100 pages of parchment, and each spell takes up one page per spell level (one page each for 0-level spells). See Space in the Spellbook, Player's Handbook page 179.",
          15f, 3f, 3, 0
      }, //
      {96, "Thieves Tools",
          "This kit contains the tools you need to use the Disable Device and Open Lock skills. The kit includes one or more skeleton keys, long metal picks and pries, a long-nosed clamp, a small hand saw, and a small wedge and hammer. Without these tools, you must improvise tools, and you take a -2 circumstance penalty on Disable Device and Open Locks checks.",
          30f, 1f, 3, 0
      }, //
      {97, "Thieves Tools",
          "This kit contains extra tools and tools of better make, which grant a +2 circumstance bonus on Disable Device and Open Lock checks.",
          100f, 2f, 3, 1
      }, //
      {98, "Tools",
          "This well-made item is the perfect tool for the job. It grants a +2 circumstance bonus on a related skill check (if any). Some examples of this sort of item include masterwork artisan's tools, masterwork thieves' tools, disguise kit, climber's kit, healer's kit, and masterwork musical instrument. This entry covers just about anything else. Bonuses provided by multiple masterwork items used toward the same skill check do not stack, so masterwork pitons and a masterwork climber�s kit do not provide a +4 bonus if used together on a Climb check.",
          50f, 1f, 3, 1
      }, //
      {99, "Water clock",
          "This large, bulky contrivance gives the time accurate to within half an hour per day since it was last set. It requires a source of water, and it must be kept still because it marks time by the regulated flow of droplets of water. It is primarily an amusement for the wealthy and a tool for the student of arcane lore. Most people have no way to tell exact time, and there's little point in knowing that it is 2:30 p.m. if nobody else does.",
          1000f, 200f, 3, 0
      }, //
      {100, "Outfit Artisan",
          "This outfit includes a shirt with buttons, a skirt or pants with a drawstring, shoes, and perhaps a cap or hat. It may also include a belt or a leather or cloth apron for carrying tools.",
          1f, 4f, 5, 0
      }, //
      {101, "Cleric Vestments", "These ecclesiastical clothes are for performing priestly functions, not for adventuring.", 5f, 6f,
          5, 0
      }, //
      {102, "Outfit Cold Weather",
          "A cold weather outfit includes a wool coat, linen shirt, wool cap, heavy cloak, thick pants or skirt, and boots. This outfit grants a +5 circumstance bonus on Fortitude saving throws against exposure to cold weather.",
          8f, 7f, 5, 0
      }, //
      {103, "Outfit Courtier",
          "This outfit includes fancy, tailored clothes in whatever fashion happens to be the current style in the courts of the nobles. Anyone trying to influence nobles or courtiers while wearing street dress will have a hard time of it (�2 penalty on Charisma-based skill checks to influence such individuals). If you wear this outfit without jewelry (costing an additional 50 gp), you look like an out-of-place commoner.",
          30f, 6f, 5, 0
      }, //
      {104, "Outfit Entertainer",
          "This set of flashy, perhaps even gaudy, clothes is for entertaining. While the outfit looks whimsical, its practical design lets you tumble, dance, walk a tightrope, or just run (if the audience turns ugly).",
          3f, 4f, 5, 0
      }, //
      {105, "Outfit Explorer",
          "This is a full set of clothes for someone who never knows what to expect. It includes sturdy boots, leather breeches or a skirt, a belt, a shirt (perhaps with a vest or jacket), gloves, and a cloak. Rather than a leather skirt, a leather overtunic may be worn over a cloth skirt. The clothes have plenty of pockets (especially the cloak). The outfit also includes any extra items you might need, such as a scarf or a wide-brimmed hat.",
          10f, 8f, 5, 0
      }, //
      {106, "Outfit Monk",
          "This simple outfit includes sandals, loose breeches, and a loose shirt, and is all bound together with sashes. The outfit is designed to give you maximum mobility, and it�s made of high-quality fabric. You can hide small weapons in pockets hidden in the folds, and the sashes are strong enough to serve as short ropes.",
          5f, 2f, 5, 0
      }, //
      {107, "Outfit Noble",
          "This set of clothes is designed specifically to be expensive and to show it. Precious metals and gems are worked into the clothing. To fit into the noble crowd, every would-be noble also needs a signet ring and jewelry (worth at least 100 gp).",
          75f, 10f, 5, 0
      }, //
      {108, "Outfit Peasant",
          "This set of clothes consists of a loose shirt and baggy breeches, or a loose shirt and skirt or overdress. Cloth wrappings are used for shoes.",
          0.1f, 2f, 5, 0
      }, //
      {109, "Outfit Royal",
          "This is just the clothing, not the royal scepter, crown, ring, and other accoutrements. Royal clothes are ostentatious, with gems, gold, silk, and fur in abundance.",
          200f, 15f, 5, 0
      }, //
      {110, "Outfit Scholar",
          "Perfect for a scholar, this outfit includes a robe, a belt, a cap, soft shoes, and possibly a cloak.", 5f, 6f, 5, 0
      }, //
      {111, "Outfit Traveler",
          "This set of clothes consists of boots, a wool skirt or breeches, a sturdy belt, a shirt (perhaps with a vest or jacket), and an ample cloak with a hood.",
          1f, 5f, 5, 0
      }, //
      {112, "Bit and bridle", "", 2f, 1f, 7, 0}, //
      {113, "Dog, guard", "", 25f, 0f, 6, 0}, //
      {114, "Dog, riding",
          "This Medium dog is specially trained to carry a Small humanoid rider. It is brave in combat like a warhorse. You take no damage when you fall from a riding dog.",
          150f, 0f, 6, 0
      }, //
      {115, "Donkey",
          "The best kinds of pack animals around, donkeys and mules are stolid in the face of danger, hardy, surefooted, and capable of carrying heavy loads over vast distances. Unlike a horse, a donkey or a mule is willing (though not eager) to enter dungeons and other strange or threatening places.",
          8f, 0f, 6, 0
      }, //
      {116, "Mule",
          "The best kinds of pack animals around, donkeys and mules are stolid in the face of danger, hardy, surefooted, and capable of carrying heavy loads over vast distances. Unlike a horse, a donkey or a mule is willing (though not eager) to enter dungeons and other strange or threatening places.",
          8f, 0f, 6, 0
      }, //
      {117, "Feed (per day)",
          "Horses, donkeys, mules, and ponies can graze to sustain themselves, but providing feed for them (such as oats) is much better because it provides a more concentrated form of energy, especially if the animal is exerting itself. If you have a riding dog, you have to feed it at least some meat, which may cost more or less than the given amount.",
          0.05f, 10f, 7, 0
      }, //
      {118, "Horse, heavy",
          "The horse is the best all-around work animal and mount in common use. A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. Heavy horses are hard to control in combat (see Mounted Combat, Player's Handbook page 157, and the Ride skill, Player's Handbook page 80).",
          200f, 0f, 6, 0
      }, //
      {119, "Horse, light",
          "The horse is the best all-around work animal and mount in common use. A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. Light horses are hard to control in combat (see Mounted Combat, Player's Handbook page 157, and the Ride skill, Player's Handbook page 80).",
          75f, 0f, 6, 0
      }, //
      {120, "Pony",
          "A pony is smaller than a horse and is a suitable mount for a gnome or halfling. Ponies are hard to control in combat (see Mounted Combat, Player's Handbook page 157, and the Ride skill, Player's Handbook page 80).",
          30f, 0f, 6, 0
      }, //
      {121, "Warhorse, heavy",
          "The horse is the best all-around work animal and mount in common use. A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. Warhorses can be ridden easily into combat (see Mounted Combat, Player's Handbook page 157, and the Ride skill, Player's Handbook page 80).",
          400f, 0f, 6, 0
      }, //
      {122, "Warhorse, light",
          "The horse is the best all-around work animal and mount in common use. A horse is suitable as a mount for a human, dwarf, elf, half-elf, or half-orc. Warhorses can be ridden easily into combat (see Mounted Combat, Player's Handbook page 157, and the Ride skill, Player's Handbook page 80).",
          150f, 0f, 6, 0
      }, //
      {123, "Warpony",
          "A pony is a suitable mount for a gnome or halfling. Warponies can be ridden easily into combat (see Mounted Combat, Player's Handbook page 157, and the Ride skill, Player's Handbook page 80).",
          100f, 0f, 6, 0
      }, //
      {124, "Saddle, military",
          "A military saddle braces the rider, providing a +2 circumstance bonus on Ride checks related to staying in the saddle. If you�re knocked unconscious while in a military saddle, you have a 75% chance to stay in the saddle (compared to 50% for a riding saddle).",
          20f, 30f, 7, 0
      }, //
      {125, "Saddle, pack", "A pack saddle holds gear and supplies, but not a rider. It holds as much gear as the mount can carry.",
          5f, 15f, 7, 0
      }, //
      {126, "Saddle, riding", "The standard riding saddle supports a rider.", 10f, 25f, 7, 0}, //
      {127, "Saddle, exotic, Military",
          "An exotic saddle is like a normal saddle of the same sort except that it is designed for an unusual mount, such as a hippogriff. Exotic saddles come in military, pack, and riding styles.",
          60f, 40f, 7, 0
      }, //
      {128, "Saddle, exotic, pack",
          "An exotic saddle is like a normal saddle of the same sort except that it is designed for an unusual mount, such as a hippogriff. Exotic saddles come in military, pack, and riding styles.",
          15f, 20f, 7, 0
      }, //
      {129, "Saddle, exotic, riding",
          "An exotic saddle is like a normal saddle of the same sort except that it is designed for an unusual mount, such as a hippogriff. Exotic saddles come in military, pack, and riding styles.",
          30f, 30f, 7, 0
      }, //
      {130, "Saddlebags", "", 4f, 8f, 7, 0}, //
  };

}
