package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores all information about feats.
 */
public class DnDv35FeatStorage {

  /**
   * All feats of DnDv35
   */
  public static final Object[][] FEAT = { //
      // id, name, prerequisit, benefit, feat_type, fighter, multiple, stack, spell_slot
      {1, "Acrobatic", "", "+2 bonus on Jump and Tumble checks", 0, 0, 0, 0, 0}, //
      {2, "Agile", "", "+2 bonus on Balance and Escape Artist checks", 0, 0, 0, 0, 0}, //
      {3, "Alertness", "", "+2 bonus on Listen and Spot checks", 0, 0, 0, 0, 0}, //
      {4, "Animal Affinity", "", "+2 bonus on Handle Animal and Ride checks", 0, 0, 0, 0, 0}, //
      {5, "Armor Proficiency (Heavy)", "Armor Proficiency (medium)", "No armor check penalty on attack rolls", 0, 0, 0, 0, 0}, //
      {6, "Armor Proficiency (Light)", "", "No armor check penalty on attack rolls", 0, 0, 0, 0, 0}, //
      {7, "Armor Proficiency (Medium)", "Armor Proficiency (light)", "No armor check penalty on attack rolls", 0, 0, 0, 0, 0}, //
      {8, "Athletic", "", "+2 bonus on Climb and Swim checks", 0, 0, 0, 0, 0}, //
      {9, "Augment Summoning", "Spell Focus (conjuration)", "Summoned creatures gain +4 Str, +4 Con", 0, 0, 0, 0, 0}, //
      {10, "Blind-Fight", "", "Reroll miss change for concealment", 0, 1, 0, 0, 0}, //
      {11, "Brew Potion", "Caster level 3rd", "Create magic potions", 1, 0, 0, 0, 0}, //
      {12, "Cleave", "Power Attack", "Extra melee attack after dropping target", 0, 1, 0, 0, 0}, //
      {13, "Combat Casting", "", "+4 bonus on Concentration checks for defensive casting", 0, 0, 0, 0, 0}, //
      {14, "Combat Expertise", "Int 13", "Trade attack bonus for AC (max 5 points)", 0, 1, 0, 0, 0}, //
      {15, "Combat Reflexes", "", "Additional attack of oppertunity", 0, 1, 0, 0, 0}, //
      {16, "Craft Magic Arms And Armor", "Caster level 5th", "Create magic weapons, armor and shields", 1, 0, 0, 0, 0}, //
      {17, "Craft Rod", "Caster level 9th", "Create magic rods", 1, 0, 0, 0, 0}, //
      {18, "Craft Staff", "Caster level 12th", "Create magic staffs", 1, 0, 0, 0, 0}, //
      {19, "Craft Wand", "Caster level 5th", "Create magic wands", 1, 0, 0, 0, 0}, //
      {20, "Craft Wondrous Item", "Caster level 3rd", "Create magic wondrous items", 1, 0, 0, 0, 0}, //
      {21, "Deceitful", "", "+2 bonus on Disguise and Forgery checks", 0, 0, 0, 0, 0}, //
      {22, "Deflect Arrows", "Dex 13, Improved Unarmed Strike", "Deflect one ranged attack per round", 0, 1, 0, 0, 0}, //
      {23, "Deft Hands", "", "+2 bonus on Sleight of Hand and Use Rope checks", 0, 0, 0, 0, 0}, //
      {24, "Diehard", "Endurance", "Remain conscious at -1 to -9 hp", 0, 0, 0, 0, 0}, //
      {25, "Diligent", "", "+2 bonus on Appraise and Decipher Script checks", 0, 0, 0, 0, 0}, //
      {26, "Dodge", "Dex 13", "+1 dodge bonus to AC against selected target", 0, 1, 0, 0, 0}, //
      {27, "Empower Spell", "", "Increase spell''s variable, numeric effects by 50%", 2, 0, 0, 0, 2}, //
      {28, "Endurance", "", "+4 bonus on checks or saves to resist nonlethal damage", 0, 0, 0, 0, 0}, //
      {29, "Enlarge Spell", "", "Double spell''s range", 2, 0, 0, 0, 1}, //
      {30, "Eschew Materials", "", "Cast spells without material components", 0, 0, 0, 0, 0}, //
      {31, "Exotic Weapon Proficiency", "Base attack bonus +1", "No penalty on attack with specific exotic weapon", 0, 1, 1, 0, 0},
      //
      {32, "Extend Spell", "", "Double spell''s duration", 2, 0, 0, 0, 1}, //
      {33, "Extra Turning", "Ability to turn or rebuke creatures", "Can turn or rebuke 4 more times per day", 0, 0, 0, 1, 0}, //
      {34, "Far Shot", "Point Blank Shot", "Increase range increment by 50% or 100%", 0, 1, 0, 0, 0}, //
      {35, "Forge Ring", "Caster level 12th", "Create magic rings", 1, 0, 0, 0, 0}, //
      {36, "Great Cleave", "Cleave, Power Attack, base attack bonus +4", "No limit to cleave attacks each round", 0, 1, 0, 0, 0}, //
      {37, "Great Fortitude", "", "+2 bonus on Fortitude saves", 0, 0, 0, 0, 0}, //
      {38, "Greater Spell Focus", "", "+1 bonus on save DCs against specific school of magic", 0, 0, 1, 0, 0}, //
      {39, "Greater Spell Penetration", "Spell Penetration", "+4 to caster level checks to defeat spell resistance", 0, 0, 0, 0, 0},
      //
      {40, "Greater Two-Weapon Fighting", "Dex 19, Improved Two-Weapon Fighting, Two-Weapon Fighting, base attack bonus +11",
          "Gain third off-hand attack", 0, 1, 0, 0, 0
      }, //
      {41, "Greater Weapon Focus", "Proficiency with weapon, Weapon Focus with weapon, fighter level 8th",
          "+2 bonus on attack rolls with selected weapon", 0, 1, 1, 0, 0
      }, //
      {42, "Greater Weapon Specialization",
          "Proficiency with weapon, Greater Weapon Focus with weapon, Weapon Focus with weapon, Weapon Specialization with weapon, fighter level 12th",
          "+4 bonus on damage rolls with selected weapon", 0, 1, 1, 0, 0
      }, //
      {43, "Heighten Spell", "", "Cast spells as higher level", 2, 0, 0, 0, 0}, //
      {44, "Improved Bull Rush", "Power Attack", "+4 bonus on bull rush attempts, no attack of oppertunity", 0, 1, 0, 0, 0}, //
      {45, "Improved Counterspell", "", "Counterspell with spell of same school", 0, 0, 0, 0, 0}, //
      {46, "Improved Critical", "Proficient with weapon, base attack bonus +8", "Double threat range of weapon", 0, 1, 1, 0, 0}, //
      {47, "Improved Disarm", "Combat Expertise", "+4 bonus on disarm attemps, no attack of oppertunity", 0, 1, 0, 0, 0}, //
      {48, "Improved Feint", "Combat Expertise", "Feint in combat as move action", 0, 1, 0, 0, 0}, //
      {49, "Improved Grapple", "Dex 13, Improved Unarmed Strike", "+4 bonus on grapple checks, no attack of oppertunity", 0, 1, 0,
          0, 0
      }, //
      {50, "Improved Initiative", "", "+4 bonus on initative checks", 0, 1, 0, 0, 0}, //
      {51, "Improved Overrun", "Power Attack", "+4 bonus on overrun attempts, no attack of opperunity", 0, 1, 0, 0, 0}, //
      {52, "Improved Precise Shot", "Dex 19, Point Blank Shot, Precise Shot, base attack bonus +11",
          "Ignore less than total cover/concealment on ranged attacks", 0, 1, 0, 0, 0
      }, //
      {53, "Improved Shield Bash", "Shield Proficiency", "Retain shild bonus to AC when shield bashing", 0, 1, 0, 0, 0}, //
      {54, "Improved Sunder", "Power Attack", "+4 bonus on sunder attempts, no attack of oppertunity", 0, 1, 0, 0, 0}, //
      {55, "Improved Trip", "Combat Expertise", "+4 bonus on trip attempts, no attack of oppertunity", 0, 1, 0, 0, 0}, //
      {56, "Improved Turning", "Ability to turn or rebuke creatures", "+1 level for turning checks", 0, 0, 0, 0, 0}, //
      {57, "Improved Two-Weapon Fighting", "Dex 17, Two-Weapon Fighting, base attack bonus +6", "Gain second off-hand attack", 0, 1,
          0, 0, 0
      }, //
      {58, "Improved Unarmed Strike", "", "Considered armed even when unarmed", 0, 1, 0, 0, 0}, //
      {59, "Investigator", "", "+2 bonus on Gather Information and Search checks", 0, 0, 0, 0, 0}, //
      {60, "Iron Will", "", "+2 bonus on Will saves", 0, 0, 0, 0, 0}, //
      {61, "Leadership", "Character level 6th", "Attract cohort and followers", 0, 0, 0, 0, 0}, //
      {62, "Lightning Reflexes", "", "+2 on Reflex saves", 0, 0, 0, 0, 0}, //
      {63, "Magical Aptitude", "", "+2 bonus on Spellcraft and Use Magic Device checks", 0, 0, 0, 0, 0}, //
      {64, "Manyshot", "Dex 17, Point Blank Shot, Rapid Shot, base attack bonus +6", "Shoot two or more arrows simultaneously", 0,
          1, 0, 0, 0
      }, //
      {65, "Martial Weapon Proficiency", "", "No penalty on attacks with specific martial weapons", 0, 0, 1, 0, 0}, //
      {66, "Maximize Spell", "", "Maximize spell''s variable, nummeric effects", 2, 0, 0, 0, 3}, //
      {67, "Mobility", "Dodge", "+4 dodge bonus to AC against some attacks of opportunity", 0, 1, 0, 0, 0}, //
      {68, "Mounted Archery", "Mounted Combat", "Half penalty for ranged attacks while mounted", 0, 1, 0, 0, 0}, //
      {69, "Mounted Combat", "Ride 1 rank", "Negate hits on mount with Ride check", 0, 1, 0, 0, 0}, //
      {70, "Natural Spell", "Wis 13, Ability to use wild shape", "Cast spells while in wild shape", 0, 0, 0, 0, 0}, //
      {71, "Negotiator", "", "+2 bonus on Diplomacy and Sense Motive checks", 0, 0, 0, 0, 0}, //
      {72, "Nimble Fingers", "", "+2 bonus on Disable Device and Open Lock checks", 0, 0, 0, 0, 0}, //
      {73, "Persuasive", "", "+2 bonus on Bluff checks and Intimidate checks", 0, 0, 0, 0, 0}, //
      {74, "Point Blank Shot", "", "+1 bonus on ranged attack and damage within 30 ft.", 0, 1, 0, 0, 0}, //
      {75, "Power Attack", "Str 13", "Trade attack bonus for damage (up to base attack bonus)", 0, 1, 0, 0, 0}, //
      {76, "Precise Shot", "Point Blank Shot", "No -4 penalty for shooting into melee", 0, 1, 0, 0, 0}, //
      {77, "Quick Draw", "Base attack bonus +1", "Draw weapon as free action", 0, 1, 0, 0, 0}, //
      {78, "Quicken Spell", "", "Cast spells as free action", 2, 0, 0, 0, 4}, //
      {79, "Rapid Reload", "Weapon Proficiency with crossbow", "Reload crossbow more quickly", 0, 1, 0, 0, 0}, //
      {80, "Rapid Shot", "Dex 13, Point Blank Shot", "One extra ranged attack each round", 0, 1, 0, 0, 0}, //
      {81, "Ride-By Attack", "Mounted Combat", "Move before and after mounted charge", 0, 1, 0, 0, 0}, //
      {82, "Run", "", "Run at 4 times normal speed, +4 bonus on Jump checks made after running start", 0, 0, 0, 0, 0}, //
      {83, "Scribe Scroll", "Caster level 1st", "Create magic scrolls", 1, 0, 0, 0, 0}, //
      {84, "Self-Sufficient", "", "+2 bonus on Heal and Survival checks", 0, 0, 0, 0, 0}, //
      {85, "Shield Proficiency", "", "No armor check penalty on attack rolls", 0, 0, 0, 0, 0}, //
      {86, "Shot On The Run", "Dex 13, Dodge, Mobility, Point Blank Shot, base attack bonus +4",
          "Move before and after ranged attack", 0, 1, 0, 0, 0
      }, //
      {87, "Silent Spell", "", "Cast spells without verbal components", 2, 0, 0, 0, 1}, //
      {88, "Simple Weapon Proficiency", "", "No -4 penalty on attack rolls with simple weapons", 0, 0, 0, 0, 0}, //
      {89, "Skill Focus", "", "+3 bonus on checks with selected skill", 0, 0, 1, 0, 0}, //
      {90, "Snatch Arrows", "Dex 15, Deflect Arrows, Improved Unarmed Strike", "Catch a deflected ranged attack", 0, 1, 0, 0, 0}, //
      {91, "Spell Focus", "", "+1 bonus on save DCs against specific school of magic", 0, 0, 1, 0, 0}, //
      {92, "Spell Mastery", "Wizard level 1st", "Can prepare some spells without spellbook", 0, 0, 1, 0, 0}, //
      {93, "Spell Penetration", "", "+2 bonus on caster level ckecks to defeat spell resistance", 0, 0, 0, 0, 0}, //
      {94, "Spirited Charge", "Mounted Combat, Ride-By Attack.", "Double damage with mounted charge", 0, 1, 0, 0, 0}, //
      {95, "Spring Attack", "Mobility, base attack bonus +4", "Move before and after melee attack", 0, 1, 0, 0, 0}, //
      {96, "Stealthy", "", "+2 bonus on Hide and Move Silently checks", 0, 0, 0, 0, 0}, //
      {97, "Still Spell", "", "Cast spells without somatic components", 2, 0, 0, 0, 1}, //
      {98, "Stunning Fist", "Dex 13, Wis 13, Improved Unarmed Strike, base attack bonus +8", "Stun opponent with unarmed strike", 0,
          1, 0, 0, 0
      }, //
      {99, "Toughness", "", "+3 hit points", 0, 0, 0, 1, 0}, //
      {100, "Tower Shield Proficiency", "Shield Proficiency", "No armor check penalty on attack rolls", 0, 0, 0, 0, 0}, //
      {101, "Track", "", "", 0, 0, 0, 0, 0}, //
      {102, "Trample", "Mounted Combat", "Targets cannot avoid mounted overrun", 0, 1, 0, 0, 0}, //
      {103, "Two-Weapon Defense", "Two-Weapon Fighting", "Off-hand weapon grants +1 shield bonus to AC", 0, 1, 0, 0, 0}, //
      {104, "Two-Weapon Fighting", "Dex 15", "Reduce two-weapon fighting penealties by 2", 0, 1, 0, 0, 0}, //
      {105, "Weapon Finesse", "base attack bonus +1",
          "Use Dex modifier insteat of Str modifier on attack rolls with light melee weapons", 0, 1, 0, 0, 0
      }, //
      {106, "Weapon Focus", "Proficiency with weapon, base attack bonus +1", "+1 bonus on attack rolls with selected weapon", 0, 1,
          1, 0, 0
      }, //
      {107, "Weapon Specialization", "Proficiency with weapon, Weapon Focus with weapon, fighter level 4th",
          "+2 bonus on damage rolls with selected weapon", 0, 1, 1, 0, 0
      }, //
      {108, "Whirlwind Attack", "Dex 13, Int 13, Combat Expertise, Dodge, Mobility, Spring Attack, base attack bonus +4",
          "One melee attack against each opponent within reach", 0, 1, 0, 0, 0
      }, //
      {109, "Widen Spell", "", "Double spell''s area", 2, 0, 0, 0, 3}, //
  };

}
