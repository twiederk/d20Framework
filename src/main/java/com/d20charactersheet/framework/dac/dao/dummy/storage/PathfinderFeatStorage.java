package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores all information about feats.
 */
public class PathfinderFeatStorage {

  /**
   * All feats of DnDv35
   */
  public static final Object[][] FEAT = { //
      // id, name, prerequisit, benefit, feat_type, fighter, multiple, stack
      {1, "Acrobatic", "", "+2 bonus on Acrobatics and Fly checks", 0, 0, 0, 0, 0}, //
      {2, "Agile Maneuvers", "", "Use your Dex bonus when calculating your CMB", 0, 1, 0, 0, 0}, //
      {3, "Alertness", "", "+2 bonus on Perception and Sense Motive checks", 0, 0, 0, 0, 0}, //
      {4, "Alignment Channel", "Channel energy class feature", "Channel energy can heal or harm outsiders", 0, 0, 1, 0, 0}, //
      {5, "Animal Affinity", "", "+2 bonus on Handle Animal and Ride checks", 0, 0, 0, 0, 0}, //
      {6, "Arcane Armor Training", "Armor Proficiency, Light, caster level 3rd", "Reduce your arcane spell failure chance by 10%",
          0, 1, 0, 0, 0
      }, //
      {7, "Arcane Armor Mastery", "Arcane Armor Training, Armor Proficiency, Medium, caster level 7th",
          "Reduce your arcane spell failure chance by 20%", 0, 1, 0, 0, 0
      }, //
      {8, "Arcane Strike", "Ability to cast arcane spells", "+1 damage and weapons are considered magic", 0, 1, 0, 0, 0}, //
      {9, "Armor Proficiency, Light", "", "No penalties on attack rolls while wearing light armor", 0, 0, 0, 0, 0}, //
      {10, "Armor Proficiency, Medium", "Armor Proficiency, Light", "No penalties on attack rolls while wearing medium armor", 0, 0,
          0, 0, 0
      }, //
      {11, "Armor Proficiency, Heavy", "Armor Proficiency, Medium", "No penalties on attack rolls while wearing heavy armor", 0, 0,
          0, 0, 0
      }, //
      {12, "Athletic", "", "+2 bonus on Climb and Swim checks", 0, 0, 0, 0, 0}, //
      {13, "Augment Summoning", "Spell Focus (conjuration)", "Summoned creatures gain +4 Str and Con", 0, 0, 0, 0, 0}, //
      {14, "Blind-Fight", "", "Reroll miss chances for concealment", 0, 1, 0, 0, 0}, //
      {15, "Catch Off-Guard", "", "No penalties for improvised melee weapons", 0, 1, 0, 0, 0}, //
      {16, "Channel Smite", "Channel energy class feature", "Channel energy through your attack", 0, 1, 0, 0, 0}, //
      {17, "Combat Casting", "", "+4 bonus on concentration checks for defensive casting", 0, 0, 0, 0, 0}, //
      {18, "Combat Expertise", "Int 13", "Trade attack bonus for AC bonus", 0, 1, 0, 0, 0}, //
      {19, "Improved Disarm", "Combat Expertise", "+2 bonus on disarm attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {20, "Greater Disarm", "Improved Disarm, base attack bonus +6", "Disarmed weapons are knocked away from your enemy", 0, 1, 0,
          0, 0
      }, //
      {21, "Improved Feint", "Combat Expertise", "Feint as a move action", 0, 1, 0, 0, 0}, //
      {22, "Greater Feint", "Improved Feint, base attack bonus +6", "Enemies you feint lose their Dex bonus for 1 round", 0, 1, 0,
          0, 0
      }, //
      {23, "Improved Trip", "Combat Expertise", "+2 bonus on trip attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {24, "Greater Trip", "Improved Trip, base attack bonus +6", "Enemies you trip provoke attacks of opportunity", 0, 1, 0, 0, 0},
      //
      {25, "Whirlwind Attack", "Dex 13, Combat Expertise, Spring Attack, base attack bonus +4",
          "Make one melee attack against all foes within reach", 0, 1, 0, 0, 0
      }, //
      {26, "Combat Reflexes", "", "Make additional attacks of opportunity", 0, 1, 0, 0, 0}, //
      {27, "Stand Still", "Combat Reflexes", "Stop enemies from moving past you", 0, 1, 0, 0, 0}, //
      {28, "Command Undead", "Channel negative energy class feature", "Channel energy can be used to control undead", 0, 0, 0, 0, 0
      }, //
      {29, "Critical Focus", "Base attack bonus +9", "+4 bonus on attack rolls made to confirm critical hits", 0, 1, 0, 0, 0}, //
      {30, "Bleeding Critical", "Critical Focus, base attack bonus +11",
          "Whenever you score a critical hit, the target takes 2d6 bleed", 0, 1, 1, 1, 0
      }, //
      {31, "Blinding Critical", "Critical Focus, base attack bonus +15", "Whenever you score a critical hit, the target is blinded",
          0, 1, 0, 0, 0
      }, //
      {32, "Critical Mastery", "Any two critical feats, 14th-level fighter", "Apply two effects to your critical hits", 0, 1, 0, 0,
          0
      }, //
      {33, "Deafening Critical", "Critical Focus, base attack bonus +13",
          "Whenever you score a critical hit, the target is deafened", 0, 1, 0, 0, 0
      }, //
      {34, "Sickening Critical", "Critical Focus, base attack bonus +11",
          "Whenever you score a critical hit, the target is sickened", 0, 1, 0, 0, 0
      }, //
      {35, "Staggering Critical", "Critical Focus, base attack bonus +13",
          "Whenever you score a critical hit, the target is staggered", 0, 1, 0, 0, 0
      }, //
      {36, "Stunning Critical", "Staggering Critical, base attack bonus +17",
          "Whenever you score a critical hit, the target is stunned", 0, 1, 0, 0, 0
      }, //
      {37, "Tiring Critical", "Critical Focus, base attack bonus +13", "Whenever you score a critical hit, the target is fatigued",
          0, 1, 0, 0, 0
      }, //
      {38, "Exhausting Critical", "Tiring Critical, base attack bonus +15",
          "Whenever you score a critical hit, the target is exhausted", 0, 1, 0, 0, 0
      }, //
      {39, "Deadly Aim", "Dex 13, base attack bonus +1", "Trade ranged attack bonus for damage", 0, 1, 0, 0, 0}, //
      {40, "Deceitful", "", "+2 bonus on Bluff and Disguise checks", 0, 0, 0, 0, 0}, //
      {41, "Defensive Combat Training", "", "Use your total Hit Dice as your base attack bonus for CMD", 0, 1, 0, 0, 0}, //
      {42, "Deft Hands", "", "+2 bonus on Disable Device and Sleight of Hand checks", 0, 0, 0, 0, 0}, //
      {43, "Disruptive", "6th-level fighter", "Increases the DC to cast spells adjacent to you", 0, 1, 0, 0, 0}, //
      {44, "Spellbreaker", "Disruptive, 10th-level fighter", "Enemies provoke attacks if their spells fail", 0, 1, 0, 0, 0}, //
      {45, "Dodge", "Dex 13", "+1 dodge bonus to AC", 0, 1, 0, 0, 0}, //
      {46, "Mobility", "Dodge", "+4 AC against attacks of opportunity from movement", 0, 1, 0, 0, 0}, //
      {47, "Spring Attack", "Mobility, base attack bonus +4", "Move before and after melee attack", 0, 1, 0, 0, 0}, //
      {48, "Wind Stance", "Dex 15, Dodge, base attack bonus +6", "Gain 20% concealment if you move", 0, 1, 0, 0, 0}, //
      {49, "Lightning Stance", "Dex 17, Wind Stance, base attack bonus +11", "Gain 50% concealment if you move", 0, 1, 0, 0, 0}, //
      {50, "Elemental Channel", "Channel energy class feature", "Channel energy can harm or heal elementals", 0, 0, 1, 0, 0}, //
      {51, "Endurance", "", "+4 bonus on checks to avoid nonlethal damage", 0, 0, 0, 0, 0}, //
      {52, "Diehard", "Endurance", "Automatically stabilize and remain conscious below 0 hp", 0, 0, 0, 0, 0}, //
      {53, "Eschew Materials", "", "Cast spells without material components", 0, 0, 0, 0, 0}, //
      {54, "Exotic Weapon Proficiency", "Base attack bonus +1", "No penalty on attacks made with one exotic weapon", 0, 1, 1, 0, 0},
      //
      {55, "Extra Channel", "Channel energy class feature", "Channel energy two additional times per day", 0, 0, 0, 0, 0}, //
      {56, "Extra Ki", "Ki pool class feature", "Increase your ki pool by 2 points", 0, 0, 1, 1, 0}, //
      {57, "Extra Lay On Hands", "Lay on hands class feature", "Use lay on hands two additional times per day", 0, 0, 1, 1, 0}, //
      {58, "Extra Mercy", "Mercy class feature", "Your lay on hands benefits from one additional mercy", 0, 0, 1, 0, 0}, //
      {59, "Extra Performance", "Bardic performance class feature", "Use bardic performance for 6 additional rounds per day", 0, 0,
          1, 1, 0
      }, //
      {60, "Extra Rage", "Rage class feature", "Use rage for 6 additional rounds per day", 0, 0, 1, 1, 0}, //
      {61, "Fleet", "", "Your base speed increases by 5 feet", 0, 0, 1, 1, 0}, //
      {62, "Great Fortitude", "", "+2 on Fortitude saves", 0, 0, 0, 0, 0}, //
      {63, "Improved Great Fortitude", "Great Fortitude", "Once per day, you may reroll a Fortitude save", 0, 0, 0, 0, 0}, //
      {64, "Improved Channel", "Channel energy class feature", "+2 bonus on channel energy DC", 0, 0, 0, 0, 0}, //
      {65, "Improved Counterspell", "", "Counterspell with spell of the same school", 0, 0, 0, 0, 0}, //
      {66, "Improved Critical", "Proficiency with weapon, base attack bonus +8", "Double the threat range of one weapon", 0, 1, 1,
          0, 0
      }, //
      {67, "Improved Familiar", "Ability to acquire a familiar, see feat", "Gain a more powerful familiar", 0, 0, 0, 0, 0}, //
      {68, "Improved Initiative", "", "+4 bonus on initiative checks", 0, 1, 0, 0, 0}, //
      {69, "Improved Unarmed Strike", "", "Always considered armed", 0, 1, 0, 0, 0}, //
      {70, "Deflect Arrows", "Dex 13, Improved Unarmed Strike", "Avoid one ranged attack per round", 0, 1, 0, 0, 0}, //
      {71, "Snatch Arrows", "Dex 15, Deflect Arrows", "Catch one ranged attack per round", 0, 1, 0, 0, 0}, //
      {72, "Improved Grapple", "Dex 13, Improved Unarmed Strike", "+2 bonus on grapple attempts, no attack of opportunity", 0, 1, 0,
          0, 0
      }, //
      {73, "Greater Grapple", "Improved Grapple, base attack bonus +6", "Maintain your grapple as a move action", 0, 1, 0, 0, 0}, //
      {74, "Scorpion Style", "Improved Unarmed Strike", "Reduce target''s speed to 5 ft.", 0, 1, 0, 0, 0}, //
      {75, "Gorgon''s Fist", "Scorpion Style, base attack bonus +6", "Stagger a foe whose speed is reduced", 0, 1, 0, 0, 0}, //
      {76, "Medusa''s Wrath", "Gorgon''s Fist, base attack bonus +11", "Make 2 extra attacks against a hindered foe", 0, 1, 0, 0, 0
      }, //
      {77, "Stunning Fist", "Dex 13, Wis 13, Improved Unarmed Strike, base attack bonus +8", "Stun opponent with an unarmed strike",
          0, 1, 0, 0, 0
      }, //
      {78, "Improvised Weapon Mastery", "Catch Off-Guard or Throw Anything, base attack bonus +8",
          "Make an improvised weapon deadly", 0, 1, 0, 0, 0
      }, //
      {79, "Intimidating Prowess", "", "Add Str to Intimidate in addition to Cha", 0, 1, 0, 0, 0}, //
      {80, "Iron Will", "", "+2 bonus on Will saves", 0, 0, 0, 0, 0}, //
      {81, "Improved Iron Will", "Iron Will", "Once per day, you may reroll a Will save", 0, 0, 0, 0, 0}, //
      {82, "Leadership", "Character level 7th", "Gain a cohort and followers", 0, 0, 0, 0, 0}, //
      {83, "Lightning Reflexes", "", "+2 bonus on Reflex saves", 0, 0, 0, 0, 0}, //
      {84, "Improved Lightning Reflexes", "Lightning Reflexes", "Once per day, you may reroll a Reflex save", 0, 0, 0, 0, 0}, //
      {85, "Lunge", "Base attack bonus +6", "Take a -2 penalty to your AC to attack with reach", 0, 1, 0, 0, 0}, //
      {86, "Magical Aptitude", "", "+2 bonus on Spellcraft and Use Magic Device checks", 0, 0, 0, 0, 0}, //
      {87, "Martial Weapon Proficiency", "", "No penalty on attacks made with one martial weapon", 0, 0, 1, 0, 0}, //
      {88, "Master Craftsman", "5 ranks in any Craft or Profession skill", "You can craft magic items without being a spellcaster",
          0, 0, 0, 0, 0
      }, //
      {89, "Mounted Combat", "Ride 1 rank", "Avoid attacks on mount with Ride check", 0, 1, 0, 0, 0}, //
      {90, "Mounted Archery", "Mounted Combat", "Halve the penalty for ranged attacks while mounted", 0, 1, 0, 0, 0}, //
      {91, "Ride-By Attack", "Mounted Combat", "Move before and after a charge attack while mounted", 0, 1, 0, 0, 0}, //
      {92, "Spirited Charge", "Ride-By Attack", "Double damage on a mounted charge", 0, 1, 0, 0, 0}, //
      {93, "Trample", "Mounted Combat", "Overrun targets while mounted", 0, 1, 0, 0, 0}, //
      {94, "Unseat", "Improved Bull Rush, Mounted Combat", "Knock opponents from their mounts", 0, 1, 0, 0, 0}, //
      {95, "Natural Spell", "Wis 13, wild shape class feature", "Cast spells while using wild shape", 0, 0, 0, 0, 0}, //
      {96, "Nimble Moves", "Dex 13", "Ignore 5 feet of difficult terrain when you move", 0, 0, 0, 0, 0}, //
      {97, "Acrobatic Steps", "Dex 15, Nimble Moves", "Ignore 20 feet of difficult terrain when you move", 0, 0, 0, 0, 0}, //
      {98, "Persuasive", "", "+2 bonus on Diplomacy and Intimidate checks", 0, 0, 0, 0, 0}, //
      {99, "Point-Blank Shot", "", "+1 attack and damage on targets within 30 feet", 0, 1, 0, 0, 0}, //
      {100, "Far Shot", "Point-Blank Shot", "Decrease ranged penalties by half", 0, 1, 0, 0, 0}, //
      {101, "Precise Shot", "Point-Blank Shot", "No penalty for shooting into melee", 0, 1, 0, 0, 0}, //
      {102, "Improved PreciseShot", "Dex 19, Precise Shot, base attack bonus +11",
          "No cover or concealment chance on ranged attacks", 0, 1, 0, 0, 0
      }, //
      {103, "Pinpoint Targeting", "Improved Precise Shot, base attack bonus +16", "No armor or shield bonus on one ranged attack",
          0, 1, 0, 0, 0
      }, //
      {104, "Shot on the Run", "Dex 13, Mobility, Point-Blank Shot, base attack bonus +4",
          "Make ranged attack at any point during movement", 0, 1, 0, 0, 0
      }, //
      {105, "Rapid Shot", "Dex 13, Point-Blank Shot", "Make one extra ranged attack", 0, 1, 0, 0, 0}, //
      {106, "Manyshot", "Dex 17, Rapid Shot, base attack bonus +6", "Shoot two arrows simultaneously", 0, 1, 0, 0, 0}, //
      {107, "Power Attack", "Str 13, base attack bonus +1", "Trade melee attack bonus for damage", 0, 1, 0, 0, 0}, //
      {108, "Cleave", "Power Attack", "Make an additional attack if the first one hits", 0, 1, 0, 0, 0}, //
      {109, "Great Cleave", "Cleave, base attack bonus +4", "Make an additional attack after each attack hits", 0, 1, 0, 0, 0}, //
      {110, "Improved Bull Rush", "Power Attack", "+2 bonus on bull rush attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {111, "Greater Bull Rush", "Improved Bull Rush, base attack bonus +6", "Enemies you bull rush provoke attacks of opportunity",
          0, 1, 0, 0, 0
      }, //
      {112, "Improved Overrun", "Power Attack", "+2 bonus on overrun attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {113, "Greater Overrun", "Improved Overrun, base attack bonus +6", "Enemies you overrun provoke attacks of opportunity", 0, 1,
          0, 0, 0
      }, //
      {114, "Improved Sunder", "Power Attack", "+2 bonus on sunder attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {115, "Greater Sunder", "Improved Sunder, base attack bonus +6", "Damage from sunder attempts transfers to your enemy", 0, 1,
          0, 0, 0
      }, //
      {116, "Quick Draw", "Base attack bonus +1", "Draw weapon as a free action", 0, 1, 0, 0, 0}, //
      {117, "Rapid Reload", "Weapon proficiency (crossbow)", "Reload crossbow quickly", 0, 1, 1, 0, 0}, //
      {118, "Run", "", "Run at 5 times your normal speed", 0, 0, 0, 0, 0}, //
      {119, "Selective Channeling", "Cha 13, channel energy class feature", "Choose whom to affect with channel energy", 0, 0, 0, 0,
          0
      }, //
      {120, "Self-Sufficient", "", "+2 bonus on Heal and Survival checks", 0, 0, 0, 0, 0}, //
      {121, "Shield Proficiency", "", "No penalties on attack rolls when using a shield", 0, 0, 0, 0, 0}, //
      {122, "Improved Shield Bash", "Shield Proficiency", "Keep your shield bonus when shield bashing", 0, 1, 0, 0, 0}, //
      {123, "Shield Slam", "Improved Shield Bash, Two-Weapon Fighting, base attack bonus +6", "Free bull rush with a bash attack",
          0, 1, 0, 0, 0
      }, //
      {124, "Shield Master", "Shield Slam, base attack bonus +11", "No two-weapon penalties when attacking with a shield", 0, 1, 0,
          0, 0
      }, //
      {125, "Shield Focus", "Shield Proficiency, base attack bonus +1", "Gain a +1 bonus to your AC when using a shield", 0, 1, 0,
          0, 0
      }, //
      {126, "Greater Shield Focus", "Shield Focus, 8th-level fighter", "Gain a +1 bonus to your AC when using a shield", 0, 1, 0, 0,
          0
      }, //
      {127, "Tower Shield Proficiency", "Shield Proficiency", "No penalties on attack rolls when using a tower shield", 0, 1, 0, 0,
          0
      }, //
      {128, "Simple Weapon Proficiency", "", "No penalty on attacks made with simple weapons", 0, 0, 0, 0, 0}, //
      {129, "Skill Focus", "", "+3 bonus on one skill (+6 at 10 ranks)", 0, 0, 1, 0, 0}, //
      {130, "Spell Focus", "", "+1 bonus on save DCs for one school", 0, 0, 1, 0, 0}, //
      {131, "Greater Spell Focus", "Spell Focus", "+1 bonus on save DCs for one school", 0, 0, 1, 0, 0}, //
      {132, "Spell Mastery", "1st-level Wizard", "Prepare some spells without a spellbook", 0, 0, 0, 0, 0}, //
      {133, "Spell Penetration", "", "+2 bonus on level checks to beat spell resistance", 0, 0, 0, 0, 0}, //
      {134, "Greater Spell Penetration", "Spell Penetration", "+2 bonus on level checks to beat spell resistance", 0, 0, 0, 0, 0},//
      {135, "Stealthy", "", "+2 bonus on Escape Artist and Stealth checks", 0, 0, 0, 0, 0}, //
      {136, "Step Up", "Base attack bonus +1", "Take a 5-foot step as an immediate action", 0, 1, 0, 0, 0}, //
      {137, "Strike Back", "Base attack bonus +11", "Attack foes that strike you while using reach", 0, 1, 0, 0, 0}, //
      {138, "Throw Anything", "", "No penalties for improvised ranged weapons", 0, 1, 0, 0, 0}, //
      {139, "Toughness", "", "+3 hit points, +1 per Hit Die beyond 3", 0, 0, 0, 0, 0}, //
      {140, "Turn Undead", "Channel positive energy classfeature", "Channel energy can be used to make undead flee", 0, 0, 0, 0, 0},
      //
      {141, "Two-Weapon Fighting", "Dex 15", "Reduce two-weapon fighting penalties", 0, 1, 0, 0, 0}, //
      {142, "Double Slice", "Two-Weapon Fighting", "Add your Str bonus to off-hand damage rolls", 0, 1, 0, 0, 0}, //
      {143, "Two-Weapon Rend", "Double Slice, Improved Two-Weapon Fighting, base attack bonus +11",
          "Rend a foe hit by both your weapons", 0, 1, 0, 0, 0
      }, //
      {144, "Improved Two-Weapon Fighting", "Dex 17, Two-Weapon Fighting, base attack bonus +6", "Gain additional off-hand attack",
          0, 1, 0, 0, 0
      }, //
      {145, "Greater Two-Weapon Fighting", "Dex 19, Improved Two-Weapon Fighting, base attack bonus +11",
          "Gain a third off-hand attack", 0, 1, 0, 0, 0
      }, //
      {146, "Two-Weapon Defense", "Two-Weapon Fighting", "Gain +1 shield bonus when fighting with two weapons", 0, 1, 0, 0, 0}, //
      {147, "Vital Strike", "Base attack bonus +6", "Deal twice the normal damage on a single attack", 0, 1, 0, 0, 0}, //
      {148, "Improved Vital Strike", "Vital Strike, base attack bonus +11", "Deal three times the normal damage on a single attack",
          0, 1, 0, 0, 0
      }, //
      {149, "Greater Vital Strike", "Improved Vital Strike, base attack bonus +16",
          "Deal four times the normal damage on a single attack", 0, 1, 0, 0, 0
      }, //
      {150, "Weapon Finesse", "", "Use Dex instead of Str on attack rolls with light weapons", 0, 1, 0, 0, 0}, //
      {151, "Weapon Focus", "Proficiency with weapon, base attack bonus +1", "+1 bonus on attack rolls with one weapon", 0, 1, 1, 0,
          0
      }, //
      {152, "Dazzling Display", "Weapon Focus", "Intimidate all foes within 30 feet", 0, 1, 0, 0, 0}, //
      {153, "Shatter Defenses", "Dazzling Display, base attack bonus +6", "Hindered foes are flat-footed", 0, 1, 0, 0, 0}, //
      {154, "Deadly Stroke", "Greater Weapon Focus, Shatter Defenses, base attack bonus +11", "Deal double damage plus 1 Con bleed",
          0, 1, 0, 0, 0
      }, //
      {155, "Greater Weapon Focus", "Weapon Focus, 8th-level fighter", "+1 bonus on attack rolls with one weapon", 0, 1, 1, 0, 0},//
      {156, "Penetrating Strike", "Weapon Focus, 12th-level fighter", "Your attacks ignore 5 points of damage reduction", 0, 1, 0,
          0, 0
      }, //
      {157, "Greater Penetrating Strike", "Penetrating Strike, 16th-level fighter",
          "Your attacks ignore 10 points of damage reduction", 0, 1, 0, 0, 0
      }, //
      {158, "Weapon Specialization", "Weapon Focus, 4th-level fighter", "+2 bonus on damage rolls with one weapon", 0, 1, 1, 0, 0},
      //
      {159, "Greater Weapon Specialization", "Weapon Specialization, 12th-level fighter",
          "+2 bonus on damage rolls with one weapon", 0, 1, 1, 0, 0
      }, //
      {160, "Brew Potion", "Caster level 3rd", "Create magic potions", 1, 0, 0, 0, 0}, //
      {161, "Craft Magic Arms and Armor", "Caster level 5th", "Create magic armors, shields, and weapons", 1, 0, 0, 0, 0}, //
      {162, "Craft Rod", "Caster level 9th", "Create magic rods", 1, 0, 0, 0, 0}, //
      {163, "Craft Staff", "Caster level 11th", "Create magic staves", 1, 0, 0, 0, 0}, //
      {164, "Craft Wand", "Caster level 5th", "Create magic wands", 1, 0, 0, 0, 0}, //
      {165, "Craft Wondrous Item", "Caster level 3rd", "Create magic wondrous items", 1, 0, 0, 0, 0}, //
      {166, "Forge Ring", "Caster level 7th", "Create magic rings", 1, 0, 0, 0, 0}, //
      {167, "Scribe Scroll", "Caster level 1st", "Create magic scrolls", 1, 0, 0, 0, 0}, //
      {168, "Empower Spell", "", "Increase spell variables by 50%", 2, 0, 0, 0, 2}, //
      {169, "Enlarge Spell", "", "Double spell range", 2, 0, 0, 0, 1}, //
      {170, "Extend Spell", "", "Double spell duration", 2, 0, 0, 0, 1}, //
      {171, "Heighten Spell", "", "Treat spell as a higher level", 2, 0, 0, 0, 0}, //
      {172, "Maximize Spell", "", "Maximize spell variables", 2, 0, 0, 0, 3}, //
      {173, "Quicken Spell", "", "Cast spell as a swift action", 2, 0, 0, 0, 4}, //
      {174, "Silent Spell", "", "Cast spell without verbal components", 2, 0, 0, 0, 1}, //
      {175, "Still Spell", "", "Cast spell without somatic components", 2, 0, 0, 0, 1}, //
      {176, "Widen Spell", "", "Double spell area", 2, 0, 0, 0, 3}, //
      {177, "Additional Traits", "", "Gain two additional character traits", 0, 0, 0, 0, 0}, //
      {178, "Arcane Blast", "Arcane spellcaster, caster level 10th", "Sacrifice a spell to make a ray attack", 0, 0, 0, 0, 0}, //
      {179, "Arcane Shield", "Arcane spellcaster, caster level 10th", "Sacrifice a spell to gain deflection bonus to AC", 0, 0, 0,
          0, 0
      }, //
      {180, "Arcane Talent", "Cha 10, elf, half-elf, or gnome", "Cast a 0-level spell 3 times per day as a spell-like ability", 0,
          0, 0, 0, 0
      }, //
      {181, "Aspect of the Beast", "Wild shape class feature", "Gain one of four bestial advantages", 0, 0, 0, 0, 0}, //
      {182, "Bashing Finish", "Shield Master, Two-Weapon Fighting, base attack bonus +11",
          "Make a free shield bash after a critical hit", 0, 1, 0, 0, 0
      }, //
      {183, "Bloody Assault", "Power Attack, base attack bonus +6", "Trade melee attack bonus for bleed damage", 0, 1, 0, 0, 0}, //
      {184, "Bodyguard", "Combat Reflexes", "Use attack of opportunity to add a bonus to adjacent ally''s AC", 0, 1, 0, 0, 0}, //
      {185, "In Harm''s Way", "Bodyguard", "Take the damage of a successful attack upon an adjacent ally", 0, 1, 0, 0, 0}, //
      {186, "Breadth of Experience", "Dwarf, elf, or gnome, 100+ years old", "+2 bonus on all Knowledge and Profession checks", 0,
          0, 0, 0, 0
      }, //
      {187, "Bull Rush Strike", "Improved Bull Rush, base attack bonus +9", "Attempt a bull rush on a successful critical hit", 0,
          1, 0, 0, 0
      }, //
      {188, "Charge Through", "Improved Overrun, base attack bonus +1", "Make overrun as free action while charging", 0, 1, 0, 0, 0
      }, //
      {189, "Childlike", "Cha 13, halfling", "+2 on Disguise checks to look like human child, take 10 on Bluff checks", 0, 0, 0, 0,
          0
      }, //
      {190, "Cockatrice Strike", "Medusa''s Wrath, base attack bonus +16", "Turn a target to stone with a critical hit", 0, 1, 0, 0,
          0
      }, //
      {191, "Combat Patrol", "Combat Reflexes, Mobility, base attack bonus +5",
          "Increase threatened area for attack of opportunity", 0, 1, 0, 0, 0
      }, //
      {192, "Cooperative Crafting", "1 rank in any Craft skill, any item creation feat ",
          "+2 bonus on Craft or Spellcraft checks while workingtogether", 0, 0, 0, 0, 0
      }, //
      {193, "Cosmopolitan", "", "Read and speak two additional languages", 0, 0, 0, 0, 0}, //
      {194, "Covering Defense", "Shield Focus, base attack bonus +6", "Provide cover to an ally with total defense", 0, 1, 0, 0, 0},
      //
      {195, "Crippling Critical", "Critical Focus, base attack bonus +13",
          "Whenever you score a critical hit, the target''s speed is halved", 0, 1, 0, 0, 0
      }, //
      {196, "Crossbow Mastery", "Dex 15, Rapid Reload, Rapid Shot", "Reload crossbow as free action and make full attacks", 0, 1, 0,
          0, 0
      }, //
      {197, "Dastardly Finish", "Sneak attack +5d6", "Deliver coup de grace to cowering or stunned target", 0, 1, 0, 0, 0}, //
      {198, "Dazing Assault", "Power Attack, base attack bonus +11", "Trade melee attack bonus to daze opponents", 0, 1, 0, 0, 0},//
      {199, "Deep Drinker", "Con 13, monk level 11, drunken ki class feature", "Gain 2 temporary ki from drunken ki", 0, 0, 0, 0, 0
      }, //
      {200, "Deepsight", "Darkvision 60 feet", "Your darkvision has a range of 120 feet", 0, 0, 0, 0, 0}, //
      {201, "Disarming Strike", "Improved Disarm, base attack bonus +9", "Attempt a disarm on a successful critical hit", 0, 1, 0,
          0, 0
      }, //
      {202, "Disrupting Shot", "Dex 13, Point-Blank Shot, 6th-level fighter", "Ranged attacks increase enemy''s DC to cast spells",
          0, 1, 0, 0, 0
      }, //
      {203, "Diviner''s Delving", "Spell Focus (divination)", "+2 bonus on caster level checks with divinations", 0, 0, 0, 0, 0}, //
      {204, "Eagle Eyes", "Wis 13, keen senses racial trait", "Ignore up to -5 due to distance on visual Perception checks", 0, 0,
          0, 0, 0
      }, //
      {205, "Eclectic", "Human", "Gain an additional favored class", 0, 0, 0, 0, 0}, //
      {206, "Eldritch Claws", "Str 15, natural weapons, base attack bonus +6", "Natural weapons treated as magic and silver", 0, 0,
          0, 0, 0
      }, //
      {207, "Elemental Fist", "Con 13, Wis 13, Improved Unarmed Strike, base attack bonus +8",
          "Deal 1d6 energy damage with an unarmed strike", 0, 1, 0, 0, 0
      }, //
      {208, "Elemental Focus", "", "+1 bonus on save DCs for one energy type", 0, 0, 1, 0, 0}, //
      {209, "Greater Elemental Focus", "Elemental Focus", "+1 bonus on save DCs for one energy type", 0, 0, 1, 0, 0}, //
      {210, "Elven Accuracy", "Elf", "Reroll miss chance due to concealment when using a bow", 0, 1, 0, 0, 0}, //
      {211, "Enforcer", "Intimidate 1 rank", "Demoralize opponent as free action when you inflict nonlethal damage", 0, 1, 0, 0, 0},
      //
      {212, "Expanded Arcana", "Caster level 1st, see feat", "Add one or two spells to list of spells known", 0, 0, 1, 0, 0}, //
      {213, "Extra Bombs", "Bomb class feature", "Throw two additional bombs per day", 0, 0, 1, 1, 0}, //
      {214, "Extra Discovery", "Discovery class feature", "Gain one additional discovery", 0, 0, 1, 0, 0}, //
      {215, "Extra Hex", "Hex class feature", "Gain one additional hex", 0, 0, 1, 0, 0}, //
      {216, "Extra Rage Power", "Rage power class feature", "Gain one additional rage power", 0, 0, 1, 0, 0}, //
      {217, "Extra Revelation", "Revelation class feature", "Gain one additional revelation", 0, 0, 1, 0, 0}, //
      {218, "Extra Rogue Talent", "Rogue talent class feature", "Gain one additional rogue talent", 0, 0, 1, 0, 0}, //
      {219, "Fast Drinker", "Con 18, drunken ki class feature", "Drink as a swift action", 0, 0, 0, 0, 0}, //
      {220, "Fast Healer", "Con 13, Diehard, Endurance", "Regain additional hit points when healing", 0, 0, 0, 0, 0}, //
      {221, "Favored Defense", "Favored enemy class feature", "Bonus to CMD and AC when attacked by favored enemy", 0, 0, 1, 0, 0},
      //
      {222, "Fight On", "Con 13, dwarf, half-orc, or orc", "Gain temporary hit points when reduced to 0", 0, 0, 0, 0, 0}, //
      {223, "Focused Shot", "Int 13, Precise Shot", "Add Int modifier on damage rolls with bows or crossbows", 0, 1, 0, 0, 0}, //
      {224, "Following Step", "Dex 13, Step Up", "Move up to 10 feet as an immediate action", 0, 1, 0, 0, 0}, //
      {225, "Step Up and Strike", "Following Step, base attack bonus +6",
          "Follow adjacent creature and attack as an immediate action", 0, 1, 0, 0, 0
      }, //
      {226, "Furious Focus", "Str 13, Power Attack, base attack bonus +1",
          "Do not take the Power Attack penalty on the first attack each round", 0, 1, 0, 0, 0
      }, //
      {227, "Dreadful Carnage", "Str 15, Furious Focus, base attack bonus +11",
          "Make a free Intimidate check when you knock down a foe", 0, 1, 0, 0, 0
      }, //
      {228, "Gang Up", "Combat Expertise", "Flank an opponent if at least two allies are adjacent to it", 0, 1, 0, 0, 0}, //
      {229, "Team Up", "Gang-Up, base attack bonus +6", "Aid another as a move action with two adjacent allies", 0, 1, 0, 0, 0}, //
      {230, "Gnome Trickster", "Cha 13, gnome, gnome magic racial trait", "Use mage hand and prestidigitation once per day", 0, 0,
          0, 0, 0
      }, //
      {231, "Go Unnoticed", "Dex 13, Small size or smaller",
          "Make Stealth check against flat-footed opponents during first round of combat", 0, 0, 0, 0, 0
      }, //
      {232, "Groundling", "Cha 13, gnome, gnome magic racial trait", "Speak with burrowing animals as spell-like ability", 0, 0, 0,
          0, 0
      }, //
      {233, "Heroic Defiance", "Diehard, base Fortitude save +8", "Once per day, delay onset of harmful condition for 1 round", 0,
          0, 0, 0, 0
      }, //
      {234, "Heroic Recovery", "Diehard, base Fortitude save +4",
          "Once per day, gain new saving throw against harmful condition requiring Fort save", 0, 0, 0, 0, 0
      }, //
      {235, "Improved Blind-Fight", "Perception 10 ranks, Blind-Fight", "Ignore miss chance for less than total concealment", 0, 1,
          0, 0, 0
      }, //
      {236, "Greater Blind-Fight", "Perception 15 ranks, Improved Blind-Fight",
          "Total concealment is considered normal concealment", 0, 1, 0, 0, 0
      }, //
      {237, "Improved Dirty Trick", "Combat Expertise", "+2 bonus on dirty trick attempts, no attack of opportunity", 0, 1, 0, 0, 0
      }, //
      {238, "Greater Dirty Trick", "Improved Dirty Trick, base attack bonus +6", "Dirty trick penalty lasts 1d4 rounds", 0, 1, 0, 0,
          0
      }, //
      {239, "Improved Drag", "Power Attack", "+2 bonus on drag attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {240, "Greater Drag", "Improved Drag, base attack bonus +6", "Enemies you drag provoke attacks of opportunity", 0, 1, 0, 0, 0
      }, //
      {241, "Improved Reposition", "Combat Expertise", "+2 bonus on reposition attempts, no attack of opportunity", 0, 1, 0, 0, 0},
      //
      {242, "Greater Reposition", "Improved Reposition, base attack bonus +6",
          "Enemies you reposition provoke attacks of opportunity", 0, 1, 0, 0, 0
      }, //
      {243, "Improved Share Spells", "Spellcraft 10 ranks, see feat", "Spells affect both you and your bonded creature", 0, 0, 0, 0,
          0
      }, //
      {244, "Improved Steal", "Combat Expertise", "+2 bonus on steal attempts, no attack of opportunity", 0, 1, 0, 0, 0}, //
      {245, "Greater Steal", "Improved Steal, base attack bonus +6", "Enemies don''t notice theft until after combat", 0, 1, 0, 0,
          0
      }, //
      {246, "Improved Stonecunning", "Wis 13, dwarf, stonecunning racial trait",
          "+4 bonus on Perception checks to notice unusual stonework", 0, 0, 0, 0, 0
      }, //
      {247, "Stone Sense", "Perception 10 ranks, Improved Stonecunning", "Gain tremorsense 10 ft.", 0, 0, 0, 0, 0}, //
      {248, "Ironguts", "Con 13, dwarf, half-orc, or orc", "+2 on saves against nausea, sickening, and ingested poisons", 0, 0, 0,
          0, 0
      }, //
      {249, "Ironhide", "Con 13, dwarf, half-orc, or orc", "+1 natural armor bonus to AC", 0, 0, 0, 0, 0}, //
      {250, "Keen Scent", "Wis 13, half-orc or orc", "Gain the scent special ability", 0, 0, 0, 0, 0}, //
      {251, "Smell Fear", "Keen Scent, half-orc or orc", "+4 on Perception checks to detect frightened creatures", 0, 0, 0, 0, 0},//
      {252, "Ki Throw", "Improved Trip, Improved Unarmed Strike", "Throw opponent into adjacent square with a trip attack", 0, 1, 0,
          0, 0
      }, //
      {253, "Improved Ki Throw", "Improved Bull Rush, Ki Throw", "Throw opponent into occupied square as a bull rush", 0, 1, 0, 0,
          0
      }, //
      {254, "Leaf Singer", "Cha 13, bardic performance, elf or half-elf",
          "Gain benefits to bardic performance in forests and against fey", 0, 0, 0, 0, 0
      }, //
      {255, "Light Step", "Acrobatic Steps, Nimble Moves, elf", "Move normal speed in difficult terrain", 0, 0, 0, 0, 0}, //
      {256, "Lingering Performance", "Bardic performance class ability",
          "Bardic performance continues for 2 rounds after you stop performing", 0, 0, 0, 0, 0
      }, //
      {257, "Low Profile", "Dex 13, Small size or smaller", "+1 dodge bonus to AC against ranged attacks", 0, 1, 0, 0, 0}, //
      {258, "Lucky Halfling", "Halfling", "You may roll saving throw for an ally once per day", 0, 0, 0, 0, 0}, //
      {259, "Master Alchemist", "Craft (alchemy) 5 ranks",
          "+2 on Craft (alchemy) checks, and you can create alchemical items and poisons faster", 0, 0, 0, 0, 0
      }, //
      {260, "Minor Spell Expertise", "Cast 4th-level spells", "Cast 1st-level spell as spell-like ability 2/day", 0, 0, 1, 0, 0}, //
      {261, "Major Spell Expertise", "Minor Spell Expertise, cast 9th-level spells",
          "Cast 5th-level or lower spell as spell-like ability 2/day", 0, 0, 1, 0, 0
      }, //
      {262, "Missile Shield", "Dex 13, Shield Focus", "Deflect one ranged attack per round with shield", 0, 1, 0, 0, 0}, //
      {263, "Ray Shield", "Dex 15, Missile Shield, Spellbreaker", "Deflect one ranged touch attack per round with shield", 0, 1, 0,
          0, 0
      }, //
      {264, "Mounted Shield", "Mounted Combat, Shield Focus", "Apply shield bonus to mount''s AC", 0, 1, 0, 0, 0}, //
      {265, "Parry Spell", "Spellcraft 15 ranks, Improved Counterspell", "Reflect a counterspelled spell back on its caster", 0, 0,
          0, 0, 0
      }, //
      {266, "Parting Shot", "Shot on the Run, base attack bonus +6", "Make a ranged attack when withdrawing", 0, 1, 0, 0, 0}, //
      {267, "Pass for Human", "Half-elf, half-orc, or halfling", "+10 on Disguise checks to look like a human", 0, 0, 0, 0, 0}, //
      {268, "Perfect Strike", "Dex 13, Wis 13, Improved Unarmed Strike, base attack bonus +8",
          "Roll twice for attacks with monk weapons and take the better roll", 0, 1, 0, 0, 0
      }, //
      {269, "Point-Blank Master", "Weapon Specialization with a ranged weapon",
          "Do not provoke attacks of opportunity while firing one ranged weapon", 0, 1, 0, 0, 0
      }, //
      {270, "Practiced Tactician", "Tactician class feature", "Use tactician ability one additional time per day", 0, 0, 1, 1, 0},//
      {271, "Preferred Spell", "Spellcraft 5 ranks, Heighten Spell", "Spontaneously cast a specific spell", 0, 0, 1, 0, 0}, //
      {272, "Punishing Kick", "Con 13, Wis 13, Improved Unarmed Strike, base attack bonus +8",
          "Knock down or push back foes with unarmed strikes", 0, 1, 0, 0, 0
      }, //
      {273, "Pushing Assault", "Str 15, Power Attack, base attack bonus +1", "Push a foe back with a two-handed weapon", 0, 1, 0, 0,
          0
      }, //
      {274, "Racial Heritage", "Human", "Affected as though both human and another race", 0, 0, 0, 0, 0}, //
      {275, "Raging Vitality", "Con 15, rage class feature", "+2 bonus to Con when raging, and continue raging if unconscious", 0,
          0, 0, 0, 0
      }, //
      {276, "Razortusk", "Half-orc", "Gain bite attack", 0, 0, 0, 0, 0}, //
      {277, "Rending Claws", "Str 13, two claw attacks, base attack bonus +6", "Deal 1d6 extra damage if both claws hit", 0, 1, 0,
          0, 0
      }, //
      {278, "Repositioning Strike", "Improved Repostion, base attack bonus +9",
          "Attempt a reposition attack on a successful critical hit", 0, 1, 0, 0, 0
      }, //
      {279, "Saving Shield", "Shield Proficiency", "Grant shield bonus to an adjacent ally", 0, 1, 0, 0, 0}, //
      {280, "Second Chance", "Combat Expertise, base attack bonus +6", "Exchange later attacks to reroll missed first attack", 0, 1,
          0, 0, 0
      }, //
      {281, "Improved Second Chance", "Second Chance, base attack bonus +11",
          "Take a -5 penalty on later attacks to reroll missed attack", 0, 1, 0, 0, 0
      }, //
      {282, "Shadow Strike", "Base attack bonus +1", "Deal precision damage against targets with concealment", 0, 1, 0, 0, 0}, //
      {283, "Shared Insight", "Wis 13, half-elf", "Grant friendly creatures a +2 bonus on Perception checks", 0, 0, 0, 0, 0}, //
      {284, "Sharp Senses", "Keen senses racial trait", "+4 racial bonus on Perception checks", 0, 0, 0, 0, 0}, //
      {285, "Shield of Swings", "Str 13, Power Attack, base attack bonus +1",
          "Reduce damage with a two handed weapon to gain a +4 shield bonus", 0, 1, 0, 0, 0
      }, //
      {286, "Shield Specialization", "Shield Focus, 4th-level fighter", "+2 bonus to AC against criticals with one type of shield",
          0, 1, 1, 0, 0
      }, //
      {287, "Greater Shield Specialization", "Greater Shield Focus, Shield Specialization, 12th-level fighter",
          "+2 bonus to AC against criticals, and negate critical hit once per day", 0, 1, 1, 0, 0
      }, //
      {288, "Sidestep", "Dex 13, Dodge, Mobility", "Make 5-foot step immediately after an opponent misses", 0, 1, 0, 0, 0}, //
      {289, "Improved Sidestep", "Dex 15, Sidestep", "Sidestep without using your 5-foot step on your next turn", 0, 1, 0, 0, 0}, //
      {290, "Smash", "Power Attack, half-orc", "Ignore 5 points of hardness when breaking an object", 0, 1, 0, 0, 0}, //
      {291, "Sociable", "Cha 13, half-elf", "Grant friendly creatures a +2 bonus on Diplomacy checks", 0, 0, 0, 0, 0}, //
      {292, "Spell Perfection", "Spellcraft 15 ranks, 3 metamagic feats",
          "Apply any metamagic feat to one spell without penalty, up to 9th level", 0, 0, 0, 0, 0
      }, //
      {293, "Spider Step", "Acrobatics 6 ranks, Climb 6 ranks, 6th-level monk",
          "Walk on walls or ceilings for half your slow fall distance", 0, 0, 0, 0, 0
      }, //
      {294, "Cloud Step", "Spider Step, 12th-level monk", "Air walk for half your slow fall distance", 0, 0, 0, 0, 0}, //
      {295, "Stabbing Shot", "Rapid Shot, elf", "Use arrow as a melee attack to push enemies back", 0, 1, 0, 0, 0}, //
      {296, "Steel Soul", "Dwarf, hardy racial trait", "+4 racial bonus on saves against spells and spell-like abilities", 0, 0, 0,
          0, 0
      }, //
      {297, "Stone-Faced", "Dwarf", "+4 bonus on Bluff checks to lie or conceal motives", 0, 0, 0, 0, 0}, //
      {298, "Stone Singer", "Cha 13, bardic performance, dwarf",
          "Gain benefits to bardic performance underground and against earth creatures", 0, 0, 0, 0, 0
      }, //
      {299, "Stunning Assault", "Power Attack, base attack bonus +16", "Trade melee attack bonus to stun opponents", 0, 1, 0, 0, 0},
      //
      {300, "Summoner''s Call", "Eidolon class feature", "Your eidolon gets a bonus when summoned", 0, 0, 0, 0, 0}, //
      {301, "Sundering Strike", "Improved Sunder, base attack bonus", "+9 Attempt a sunder attack on a successful critical hit", 0,
          1, 0, 0, 0
      }, //
      {302, "Swift Aid", "Combat Expertise, base attack bonus", "+6 Attempt to aid another as a swift action", 0, 1, 0, 0, 0}, //
      {303, "Taunt", "Cha 13, Small size or smaller", "Demoralize opponents with Bluff instead of Intimidate", 0, 0, 0, 0, 0}, //
      {304, "Teleport Tactician", "Combat Reflexes, Disruptive, Spellbreaker",
          "Teleporting creatures provoke attacks of opportunity", 0, 1, 0, 0, 0
      }, //
      {305, "Tenacious Transmutation", "Spell Focus (transmutation)", "+2 to DC to dispel your transmutations", 0, 0, 0, 0, 0}, //
      {306, "Touch of Serenity", "Wis 18, Improved Unarmed Strike, base attack bonus +8",
          "Foes hit by unarmed strikes cannot attack or cast spells", 0, 1, 0, 0, 0
      }, //
      {307, "Trick Riding", "Ride rank 9, Mounted Combat", "Automatically pass simple Ride skill checks", 0, 1, 0, 0, 0}, //
      {308, "Mounted Skirmisher", "Ride rank 14, Trick Riding", "Make a full attack if mount moves its speed or less", 0, 1, 0, 0,
          0
      }, //
      {309, "Tripping Strike", "Improved Trip, base attack bonus +9", "Attempt a trip attack on a successful critical hit", 0, 1, 0,
          0, 0
      }, //
      {310, "Under and Over", "Agile Maneuvers, Small size or smaller", "Failed grapples against you cause attacker to fall prone",
          0, 1, 0, 0, 0
      }, //
      {311, "Underfoot", "Dodge, Mobility, Small size or smaller", "+4 on Acrobatics checks to move past larger opponents", 0, 1, 0,
          0, 0
      }, //
      {312, "Vermin Heart", "Wild empathy class feature", "Target vermin with spells as if they were animals", 0, 0, 0, 0, 0}, //
      {313, "War Singer", "Cha 13, bardic performance, half-orc or orc",
          "Gain benefits to bardic performance on battlefields and against orcs", 0, 0, 0, 0, 0
      }, //
      {314, "Well-Prepared", "Halfling", "Retrieve a specific mundane item from your person", 0, 0, 0, 0, 0}, //
      {315, "Bouncing Spell", "", "Redirect a spell that had no effect on initial target", 2, 0, 0, 0, 1}, //
      {316, "Dazing Spell", "", "Daze creature with spell damage", 2, 0, 0, 0, 3}, //
      {317, "Disruptive Spell", "", "Target of spell must make concentration check to cast a spell in the next round", 2, 0, 0, 0,
          1
      }, //
      {318, "Ectoplasmic Spell", "", "Spell fully affects incorporeal and ethereal creatures", 2, 0, 0, 0, 1}, //
      {319, "Elemental Spell", "", "Inflict energy damage instead of regular spell damage", 2, 0, 1, 0, 1}, //
      {320, "Focused Spell", "", "Increase save DC of spell for one target in a group", 2, 0, 0, 0, 1}, //
      {321, "Intensified Spell", "", "Increase maximum damage dice by 5 levels", 2, 0, 0, 0, 1}, //
      {322, "Lingering Spell", "", "Instantaneous area effect spell lasts for 1 round", 2, 0, 0, 0, 1}, //
      {323, "Merciful Spell", "", "Spell inflicts nonlethal damage instead of lethal", 2, 0, 0, 0, 0}, //
      {324, "Persistent Spell", "", "Creatures who saved against a spell must save again", 2, 0, 0, 0, 2}, //
      {325, "Reach Spell", "", "Increase spell range to higher range category", 2, 0, 0, 0, 1}, //
      {326, "Selective Spell", "Spellcraft 10 ranks", "Exclude targets from an area effect spell", 2, 0, 0, 0, 1}, //
      {327, "Sickening Spell", "", "Sicken creature with spell damage", 2, 0, 0, 0, 2}, //
      {328, "Thundering Spell", "", "Deafen creature with spell damage", 2, 0, 0, 0, 2}, //
      {329, "Allied Spellcaster", "Caster level 1st", "+2 bonus on level checks to overcome spell resistance", 3, 0, 0, 0, 0}, //
      {330, "Coordinated Defense", "", "+2 bonus to CMD", 3, 1, 0, 0, 0}, //
      {331, "Coordinated Maneuvers", "", "+2 bonus on combat maneuver checks", 3, 1, 0, 0, 0}, //
      {332, "Duck and Cover", "", "Take ally''s result on Reflex saving throw", 3, 0, 0, 0, 0}, //
      {333, "Lookout", "", "Act in surprise round if ally can act", 3, 1, 0, 0, 0}, //
      {334, "Outflank", "Base attack bonus +4", "Gain +4 bonus on attack rolls when flanking", 3, 1, 0, 0, 0}, //
      {335, "Paired Opportunists", "", "+4 bonus on attacks of opportunity", 3, 1, 0, 0, 0}, //
      {336, "Precise Strike", "Dex 13, base attack bonus +1", "Deal +1d6 points of precision damage with melee attacks", 3, 1, 0, 0,
          0
      }, //
      {337, "Shield Wall", "Shield Proficiency", "Increase your shield bonus to AC", 3, 1, 0, 0, 0}, //
      {338, "Shielded Caster", "", "+4 bonus on concentration checks", 3, 0, 0, 0, 0}, //
      {339, "Swap Places", "", "Switch places with an adjacent ally", 3, 1, 0, 0, 0}, //

  };

}
