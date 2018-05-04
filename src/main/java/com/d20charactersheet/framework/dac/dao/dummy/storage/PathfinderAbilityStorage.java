package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores abilities.
 */
public class PathfinderAbilityStorage {

  /**
   * Abilities data
   */
  public static final Object[][] ABILITY = { //
      // ability_id, ability_type_id, name, classname, description
      {1, "+2 Constitution, +2 Wisdom, -2 Charisma", "Dwarves are both tough and wise, but also a bit gruff.", 0, "Ability"}, //
      {2, "Darkvision",
          "Character can see in the dark up to 60 feet. If she already has darkvision, the range increases by 30 feet.", 1,
          "Ability"
      }, //
      {3, "Defensive Training Dwarves", "Dwarves get a +4 dodge bonus to AC against monsters of the giant subtype.", 0, "Ability"},
      //
      {4, "Greed",
          "Dwarves receive a +2 racial bonus on Appraise skill checks made to determine the price of nonmagical goods that contain precious metals or gemstones.",
          0, "Ability"
      }, //
      {5, "Hatred Dwarves",
          "Dwarves receive a +1 bonus on attack rolls against humanoid creatures of the orc and goblinoid subtypes due to special training against these hated foes.",
          0, "Ability"
      }, //
      {6, "Hardy", "Dwarves receive a +2 racial bonus on saving throws against poison, spells, and spell-like abilities.", 0,
          "Ability"
      }, //
      {7, "Stability",
          "Dwarves receive a +4 racial bonus to their Combat Maneuver Defense when resisting a bull rush or trip attempt while standing on the ground.",
          0, "Ability"
      }, //
      {8, "+2 Dexterity, +2 Intelligence, -2 Constitution", "Elves are nimble, both in body and mind, but their form is frail.", 0,
          "Ability"
      }, //
      {9, "Low-Light Vision", "Characters can see twice as far as humans in conditions of dim light. See Additional Rules.", 0,
          "Ability"
      }, //
      {10, "Elven Immunities",
          "Characters are immune to magic sleep effects and get a +2 racial saving throw bonus against enchantment spells and effects.",
          0, "Ability"
      }, //
      {11, "Elven Magic",
          "Elves receive a +2 racial bonus on caster level checks made to overcome spell resistance. In addition, elves receive a +2 racial bonus on Spellcraft skill checks made to identify the properties of magic items.",
          0, "Ability"
      }, //
      {12, "Keen Senses", "Characters receive a +2 racial bonus on Perception skill checks.", 0, "Ability"}, //
      {13, "+2 Constitution, +2 Charisma, -2 Strength",
          "Gnomes are physically weak but surprisingly hardy, and their attitude makes them naturally agreeable.", 0, "Ability"
      }, //
      {15, "Defensive Training Gnomes", "Gnomes get a +4 dodge bonus to AC against monsters of the giant type.", 0, "Ability"}, //
      {16, "Gnome Magic",
          "Gnomes add +1 to the DC of any saving throws against illusion spells that they cast. Gnomes with a Charisma of 11 or higher also gain the following spell-like abilities: 1/day-dancing lights, ghost sound, prestidigitation, and speak with animals. The caster level for these effects is equal to the gnome''s level. The DC for these spells is equal to 10 + the spell''s level + the gnome''s Charisma modifier.",
          0, "Ability"
      }, //
      {17, "Hatred Gnomes",
          "Gnomes receive a +1 bonus on attack rolls against humanoid creatures of the reptilian and goblinoid subtypes due to special training against these hated foes.",
          0, "Ability"
      }, //
      {18, "Illusion Resistance", "Gnomes get a +2 racial saving throw bonus against illusion spells or effects.", 0, "Ability"}, //
      {20, "Obsessive", "Gnomes receive a +2 racial bonus on a Craft or Profession skill of their choice.", 0, "Ability"}, //
      {21, "+2 to One Ability Score",
          "Characters get a +2 bonus to one ability score of their choice at creation to represent their varied nature.", 0,
          "Ability"
      }, //
      {23, "Adaptability", "Half-elves receive Skill Focus as a bonus feat at 1st level.", 0, "Ability"}, //
      {24, "Elf Blood", "Half-elves count as both elves and humans for any effect related to race.", 0, "Ability"}, //
      {27, "Multitalented",
          "Half-elves choose two favored classes at first level and gain +1 hit point or +1 skill point whenever they take a level in either one of those classes. See Classes for more information about favored classes.",
          0, "Ability"
      }, //
      {30, "Intimidating", "Half-orcs receive a +2 racial bonus on Intimidate skill checks due to their fearsome nature.", 0,
          "Ability"
      }, //
      {31, "Orc Blood", "Half-orcs count as both humans and orcs for any effect related to race.", 0, "Ability"}, //
      {32, "Orc Ferocity",
          "Once per day, when a half-orc is brought below 0 hit points but not killed, he can fight on for one more round as if disabled. At the end of his next turn, unless brought to above 0 hit points, he immediately falls unconscious and begins dying.",
          0, "Ability"
      }, //
      {33, "+2 Dexterity, +2 Charisma, -2 Strength",
          "Halflings are nimble and strong-willed, but their small stature makes them weaker than other races.", 0, "Ability"
      }, //
      {34, "Fearless",
          "Halflings receive a +2 racial bonus on all saving throws against fear. This bonus stacks with the bonus granted by halfling luck.",
          0, "Ability"
      }, //
      {35, "Halfling Luck", "Halflings receive a +1 racial bonus on all saving throws.", 0, "Ability"}, //
      {37, "Sure-Footed", "Halflings receive a +2 racial bonus on Acrobatics and Climb skill checks.", 0, "Ability"}, //
      {39, "Bonus Feat - Human", "Humans select one extra feat at 1st level.", 0, "ExtraFeatsAbility"}, //
      {40, "Skilled", "Humans gain an additional skill rank at first level and one additional rank whenever they gain a level.", 0,
          "ExtraSkillPointsAbility"
      }, //
      {41, "Stonecunning",
          "Dwarves receive a +2 bonus on Perception checks to potentially notice unusual stonework, such as traps and hidden doors located in stone walls or floors. They receive a check to notice such features whenever they pass within 10 feet of them, whether or not they are actively looking.",
          0, "Ability"
      }, //
      {42, "Fast Movement - Barbarian",
          "A barbarian's land speed is faster than the norm for her race by +10 feet. This benefit applies only when she is wearing no armor, light armor, or medium armor, and not carrying a heavy load. Apply this bonus before modifying the barbarian's speed because of any load carried or armor worn. This bonus stacks with any other bonuses to the barbarian's land speed.",
          1, "Ability"
      }, //
      {43, "Rage",
          "A barbarian can call upon inner reserves of strength and ferocity, granting her additional combat prowess. Starting at 1st level, a barbarian can rage for a number of rounds per day equal to 4 + her Constitution modifier. At each level after 1st, she can rage for 2 additional rounds. Temporary increases to Constitution, such as those gained from rage and spells like bear's endurance, do not increase the total number of rounds that a barbarian can rage per day. A barbarian can enter rage as a free action. The total number of rounds of rage per day is renewed after resting for 8 hours, although these hours do not need to be consecutive.<br/>While in rage, a barbarian gains a +4 morale bonus to her Strength and Constitution, as well as a +2 morale bonus on Will saves. In addition, she takes a -2 penalty to Armor Class. The increase to Constitution grants the barbarian 2 hit points per Hit Dice, but these disappear when the rage ends and are not lost first like temporary hit points. While in rage, a barbarian cannot use any Charisma-, Dexterity-, or Intelligence-based skills (except Acrobatics, Fly, Intimidate, and Ride) or any ability that requires patience or concentration.<br/>A barbarian can end her rage as a free action and is fatigued after rage for a number of rounds equal to 2 times the number of rounds spent in the rage. A barbarian cannot enter a new rage while fatigued or exhausted but can otherwise enter rage multiple times during a single encounter or combat. If a barbarian falls unconscious, her rage immediately ends, placing her in peril of death.",
          1, "Ability"
      }, //
      {44, "Rage Powers",
          "As a barbarian gains levels, she learns to use her rage in new ways. Starting at 2nd level, a barbarian gains a rage power. She gains another rage power for every two levels of barbarian attained after 2nd level. A barbarian gains the benefits of rage powers only while raging, and some of these powers require the barbarian to take an action first. Unless otherwise noted, a barbarian cannot select an individual power more than once.",
          1, "Ability"
      }, //
      {45, "Animal Fury",
          "While raging, the barbarian gains a bite attack. If used as part of a full attack action, the bite attack is made at the barbarian's full base attack bonus -5. If the bite hits, it deals 1d4 points of damage (assuming the barbarian is Medium, 1d3 points of damage if Small) plus half the barbarian's Strength modifier. A barbarian can make a bite attack as part of the action to maintain or break free from a grapple. This attack is resolved before the grapple check is made. If the bite attack hits, any grapple checks made by the barbarian against the target this round are at a +2 bonus.",
          1, "Ability"
      }, //
      {46, "Clear Mind",
          "A barbarian may reroll a failed Will save. This power is used as an immediate action after the first save is attempted, but before the results are revealed by the GM. The barbarian must take the second result, even if it is worse. A barbarian must be at least 8th level before selecting this power. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {47, "Fearless Rage",
          "While raging, the barbarian is immune to the shaken and frightened conditions. A barbarian must be at least 12th level before selecting this rage power.",
          1, "Ability"
      }, //
      {48, "Guarded Stance",
          "The barbarian gains a +1 dodge bonus to her Armor Class against melee attacks for a number of rounds equal to the barbarian's current Constitution modifier (minimum 1). This bonus increases by +1 for every 6 levels the barbarian has attained. Activating this ability is a move action that does not provoke an attack of opportunity.",
          1, "Ability"
      }, //
      {49, "Increased Damage Reduction",
          "The barbarian's damage reduction increases by 1/-. This increase is always active while the barbarian is raging. A barbarian can select this rage power up to three times. Its effects stack. A barbarian must be at least 8th level before selecting this rage power.",
          1, "Ability"
      }, //
      {50, "Internal Fortitude",
          "While raging, the barbarian is immune to the sickened and nauseated conditions. A barbarian must be at least 8th level before selecting this rage power.",
          1, "Ability"
      }, //
      {51, "Intimidating Glare",
          "The barbarian can make an Intimidate check against one adjacent foe as a move action. If the barbarian successfully demoralizes her opponent, the foe is shaken for 1d4 rounds + 1 round for every 5 points by which the barbarian's check exceeds the DC.",
          1, "Ability"
      }, //
      {52, "Knockback",
          "Once per round, the barbarian can make a bull rush attempt against one target in place of a melee attack. If successful, the target takes damage equal to the barbarian's Strength modifier and is moved back as normal. The barbarian does not need to move with the target if successful. This does not provoke an attack of opportunity.",
          1, "Ability"
      }, //
      {54, "Mighty Swing",
          "The barbarian automatically confirms a critical hit. This power is used as an immediate action once a critical threat has been determined. A barbarian must be at least 12th level before selecting this power. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {55, "Moment of Clarity",
          "The barbarian does not gain any benefits or take any of the penalties from rage for 1 round. Activating this power is a swift action. This includes the penalty to Armor Class and the restriction on what actions can be performed. This round still counts against her total number of rounds of rage per day. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {56, "Night Vision",
          "The barbarian's senses grow incredibly sharp while raging and she gains darkvision 60 feet. A barbarian must have low-light vision as a rage power or a racial trait to select this rage power.",
          1, "Ability"
      }, //
      {57, "No Escape",
          "The barbarian can move up to double her normal speed as an immediate action but she can only use this ability when an adjacent foe uses a withdraw action to move away from her. She must end her movement adjacent to the enemy that used the withdraw action. The barbarian provokes attacks of opportunity as normal during this movement. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {58, "Powerful Blow",
          "The barbarian gains a +1 bonus on a single damage roll. This bonus increases by +1 for every 4 levels the barbarian has attained. This power is used as a swift action before the roll to hit is made. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {59, "Quick Reflexes", "While raging, the barbarian can make one additional attack of opportunity per round.", 1, "Ability"},
      //
      {60, "Raging Climber", "When raging, the barbarian adds her level as an enhancement bonus on all Climb skill checks.", 1,
          "Ability"
      }, //
      {61, "Raging Leaper",
          "When raging, the barbarian adds her level as an enhancement bonus on all Acrobatics skill checks made to jump. When making a jump in this way, the barbarian is always considered to have a running start.",
          1, "Ability"
      }, //
      {62, "Raging Swimmer", "When raging, the barbarian adds her level as an enhancement bonus on all Swim skill checks.", 1,
          "Ability"
      }, //
      {63, "Renewed Vigor",
          "As a standard action, the barbarian heals 1d8 points of damage + her Constitution modifier. For every four levels the barbarian has attained above 4th, this amount of damage healed increases by 1d8, to a maximum of 5d8 at 20th level. A barbarian must be at least 4th level before selecting this power. This power can be used only once per day and only while raging.",
          1, "Ability"
      }, //
      {64, "Rolling Dodge",
          "The barbarian gains a +1 dodge bonus to her Armor Class against ranged attacks for a number of rounds equal to the barbarian's current Constitution modifier (minimum 1). This bonus increases by +1 for every 6 levels the barbarian has attained. Activating this ability is a move action that does not provoke an attack of opportunity.",
          1, "Ability"
      }, //
      {65, "Roused Anger",
          "The barbarian may enter a rage even if fatigued. While raging after using this ability, the barbarian is immune to the fatigued condition. Once this rage ends, the barbarian is exhausted for 10 minutes per round spent raging.",
          1, "Ability"
      }, //
      {66, "Scent",
          "The barbarian gains the scent ability while raging and can use this ability to locate unseen foes (see scent ability).",
          1, "Ability"
      }, //
      {67, "Strength Surge",
          "The barbarian adds her barbarian level on one Strength check or combat maneuver check, or to her Combat Maneuver Defense when an opponent attempts a maneuver against her. This power is used as an immediate action. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {68, "Superstition",
          "The barbarian gains a +2 morale bonus on saving throws made to resist spells, supernatural abilities, and spell-like abilities. This bonus increases by +1 for every 4 levels the barbarian has attained. While raging, the barbarian cannot be a willing target of any spell and must make saving throws to resist all spells, even those cast by allies.",
          1, "Ability"
      }, //
      {69, "Surprise Accuracy",
          "The barbarian gains a +1 morale bonus on one attack roll. This bonus increases by +1 for every 4 levels the barbarian has attained. This power is used as a swift action before the roll to hit is made. This power can only be used once per rage.",
          1, "Ability"
      }, //
      {70, "Swift Foot",
          "The barbarian gains a 5-foot enhancement bonus to her speed. This increase is always active while the barbarian is raging. A barbarian can select this rage power up to three times. Its effects stack. ",
          1, "Ability"
      }, //
      {71, "Terrifying Howl",
          "The barbarian unleashes a terrifying howl as a standard action. All shaken enemies within 30 feet must make a Will save (DC equal to 10 + 1/2 the barbarian's level + the barbarian's Strength modifier) or be panicked for 1d4+1 rounds. Once an enemy has made a save versus terrifying howl (successful or not), it is immune to this power for 24 hours. A barbarian must have the intimidating glare rage power to select this rage power. A barbarian must be at least 8th level before selecting this power.",
          1, "Ability"
      }, //
      {72, "Unexpected Strike",
          "The barbarian can make an attack of opportunity against a foe that moves into any square threatened by the barbarian, regardless of whether or not that movement would normally provoke an attack of opportunity. This power can only be used once per rage. A barbarian must be at least 8th level before selecting this power.",
          1, "Ability"
      }, //
      {73, "Uncanny Dodge",
          "A character gains the ability to react to danger before her senses would normally allow her to do so. She cannot be caught flat-footed, even if the attacker is invisible. She still loses her Dexterity bonus to AC if immobilized. A characer with this ability can still lose her Dexterity bonus to AC if an opponent successfully uses the feint action against her.<br/>If a character already has uncanny dodge from a different class, she automatically gains improved uncanny dodge instead.",
          1, "Ability"
      }, //
      {74, "Trap Sense",
          "A character gains a +1 bonus on Reflex saves made to avoid traps and a +1 dodge bonus to AC against attacks made by traps. These bonuses increase by +1 every three class levels thereafter (6th, 9th, 12th, 15th, and 18th level). Trap sense bonuses gained from multiple classes stack.",
          1, "Ability"
      }, //
      {75, "Improved Uncanny Dodge",
          "The character can no longer be flanked. This defense denies a rogue the ability to sneak attack the character by flanking her, unless the attacker has at least four more rogue levels than the target has class levels.<br/>If a character already has uncanny dodge from another class, the levels from the classes that grant uncanny dodge stack to determine the minimum rogue level required to flank the character.",
          1, "Ability"
      }, //
      {76, "Damage Reduction",
          "At 7th level, a barbarian gains damage reduction. Subtract 1 from the damage the barbarian takes each time she is dealt damage from a weapon or a natural attack. At 10th level, and every three barbarian levels thereafter (13th, 16th, and 19th level), this damage reduction rises by 1 point. Damage reduction can reduce damage to 0 but not below 0.",
          1, "Ability"
      }, //
      {77, "Greater Rage",
          "At 11th level, when a barbarian enters rage, the morale bonus to her Strength and Constitution increases to +6 and the morale bonus on her Will saves increases to +3.",
          1, "Ability"
      }, //
      {78, "Indomitable Will",
          "While in rage, a barbarian of 14th level or higher gains a +4 bonus on Will saves to resist enchantment spells. This bonus stacks with all other modifiers, including the morale bonus on Will saves she also receives during her rage.",
          1, "Ability"
      }, //
      {79, "Tireless Rage", "Starting at 17th level, a barbarian no longer becomes fatigued at the end of her rage.", 1, "Ability"},
      //
      {80, "Mighty Rage",
          "At 20th level, when a barbarian enters rage, the morale bonus to her Strength and Constitution increases to +8 and the morale bonus on her Will saves increases to +4.",
          1, "Ability"
      }, //
      {81, "Spells - Bard",
          "A bard casts arcane spells drawn from the bard spell list presented in verbal component (song, recitation, or music). To learn or cast a spell, a bard must have a Charisma score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a bard's spell is 10 + the spell level + the bard's Charisma modifier.<br/>Like other spellcasters, a bard can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: Bard. In addition, he receives bonus spells per day if he has a high Charisma score (see Table: Ability Modifiers and Bonus Spells).<br/>The bard's selection of spells is extremely limited. A bard begins play knowing four 0-level spells and two 1st-level spells of the bard's choice. At each new bard level, he gains one or more new spells, as indicated on Table: Bard Spells Known. (Unlike spells per day, the number of spells a bard knows is not affected by his Charisma score. The numbers on Table: Bard Spells Known are fixed.)<br/>Upon reaching 5th level, and at every third bard level after that (8th, 11th, and so on), a bard can choose to learn a new spell in place of one he already knows. In effect, the bard 'loses' the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged, and it must be at least one level lower than the highest-level bard spell the bard can cast. A bard may swap only a single spell at any given level and must choose whether or not to swap the spell at the same time that he gains new spells known for the level.<br/>A bard need not prepare his spells in advance. He can cast any spell he knows at any time, assuming he has not yet used up his allotment of spells per day for the spell's level. ",
          0, "SpelllistAbility"
      }, //
      {82, "Bardic Knowledge",
          "A character adds half his class level (minimum 1) to all Knowledge skill checks and may make all Knowledge skill checks untrained. Levels in this class stack with levels in any other class that grants a similar ability.",
          1, "Ability"
      }, //
      {83, "Bardic Performance - Bard",
          "A bard is trained to use the Perform skill to create magical effects on those around him, including himself if desired. He can use this ability for a number of rounds per day equal to 4 + his Charisma modifier. At each level after 1st a bard can use bardic performance for 2 additional rounds per day. Each round, the bard can produce any one of the types of bardic performance that he has mastered, as indicated by his level. <br/>Starting a bardic performance is a standard action, but it can be maintained each round as a free action. Changing a bardic performance from one effect to another requires the bard to stop the previous performance and start a new one as a standard action. A bardic performance cannot be disrupted, but it ends immediately if the bard is killed, paralyzed, stunned, knocked unconscious, or otherwise prevented from taking a free action to maintain it each round. A bard cannot have more than one bardic performance in effect at one time.<br/>At 7th level, a bard can start a bardic performance as a move action instead of a standard action. At 13th level, a bard can start a bardic performance as a swift action. <br/>Each bardic performance has audible components, visual components, or both.<br/>If a bardic performance has audible components, the targets must be able to hear the bard for the performance to have any effect, and such performances are language dependent. A deaf bard has a 20% chance to fail when attempting to use a bardic performance with an audible component. If he fails this check, the attempt still counts against his daily limit. Deaf creatures are immune to bardic performances with audible components.<br/>If a bardic performance has a visual component, the targets must have line of sight to the bard for the performance to have any effect. A blind bard has a 50% chance to fail when attempting to use a bardic performance with a visual component. If he fails this check, the attempt still counts against his daily limit. Blind creatures are immune to bardic performances with visual components.",
          0, "Ability"
      }, //
      {84, "Countersong",
          "At 1st level, a bard learns to counter magic effects that depend on sound (but not spells that have verbal components). Each round of the countersong he makes a Perform (keyboard, percussion, wind, string, or sing) skill check. Any creature within 30 feet of the bard (including the bard himself) that is affected by a sonic or language-dependent magical attack may use the bard's Perform check result in place of its saving throw if, after the saving throw is rolled, the Perform check result proves to be higher. If a creature within range of the countersong is already under the effect of a noninstantaneous sonic or language-dependent magical attack, it gains another saving throw against the effect each round it hears the countersong, but it must use the bard's Perform skill check result for the save. Countersong does not work on effects that don't allow saves. Countersong relies on audible components.",
          3, "Ability"
      }, //
      {85, "Distraction",
          "At 1st level, a bard can use his performance to counter magic effects that depend on sight. Each round of the distraction, he makes a Perform (act, comedy, dance, or oratory) skill check. Any creature within 30 feet of the bard (including the bard himself) that is affected by an illusion (pattern) or illusion (figment) magical attack may use the bard's Perform check result in place of its saving throw if, after the saving throw is rolled, the Perform skill check proves to be higher. If a creature within range of the distraction is already under the effect of a noninstantaneous illusion (pattern) or illusion (figment) magical attack, it gains another saving throw against the effect each round it sees the distraction, but it must use the bard's Perform skill check result for the save. Distraction does not work on effects that don't allow saves. Distraction relies on visual components.",
          3, "Ability"
      }, //
      {86, "Fascinate",
          "At 1st level, a bard can use his performance to cause one or more creatures to become fascinated with him. Each creature to be fascinated must be within 90 feet, able to see and hear the bard, and capable of paying attention to him. The bard must also be able to see the creatures affected. The distraction of a nearby combat or other dangers prevents this ability from working. For every three levels the bard has attained beyond 1st, he can target one additional creature with this ability.<br/>Each creature within range receives a Will save (DC 10 + 1/2 the bard's level + the bard's Cha modifier) to negate the effect. If a creature's saving throw succeeds, the bard cannot attempt to fascinate that creature again for 24 hours. If its saving throw fails, the creature sits quietly and observes the performance for as long as the bard continues to maintain it. While fascinated, a target takes a -4 penalty on all skill checks made as reactions, such as Perception checks. Any potential threat to the target allows the target to make a new saving throw against the effect. Any obvious threat, such as someone drawing a weapon, casting a spell, or aiming a weapon at the target, automatically breaks the effect.<br/>Fascinate is an enchantment (compulsion), mind-affecting ability. Fascinate relies on audible and visual components in order to function. ",
          3, "Ability"
      }, //
      {87, "Inspire Courage",
          "A 1st-level bard can use his performance to inspire courage in his allies (including himself), bolstering them against fear and improving their combat abilities. To be affected, an ally must be able to perceive the bard's performance. An affected ally receives a +1 morale bonus on saving throws against charm and fear effects and a +1 competence bonus on attack and weapon damage rolls. At 5th level, and every six bard levels thereafter, this bonus increases by +1, to a maximum of +4 at 17th level. Inspire courage is a mind-affecting ability. Inspire courage can use audible or visual components. The bard must choose which component to use when starting his performance.",
          3, "Ability"
      }, //
      {88, "Inspire Competence",
          "A bard of 3rd level or higher can use his performance to help an ally succeed at a task. That ally must be within 30 feet and be able to hear the bard. The ally gets a +2 competence bonus on skill checks with a particular skill as long as she continues to hear the bard's performance. This bonus increases by +1 for every four levels the bard has attained beyond 3rd (+3 at 7th, +4 at 11th, +5 at 15th, and +6 at 19th). Certain uses of this ability are infeasible, such as Stealth, and may be disallowed at the GM's discretion. A bard can't inspire competence in himself. Inspire competence relies on audible components.",
          3, "Ability"
      }, //
      {89, "Suggestion",
          "A bard of 6th level or higher can use his performance to make a suggestion (as per the spell) to a creature he has already fascinated (see above). Using this ability does not disrupt the fascinate effect, but it does require a standard action to activate (in addition to the free action to continue the fascinate effect). A bard can use this ability more than once against an individual creature during an individual performance.<br/>Making a suggestion does not count against a bard's daily use of bardic performance. A Will saving throw (DC 10 + 1/2 the bard's level + the bard's Cha modifier) negates the effect. This ability affects only a single creature. Suggestion is an enchantment (compulsion), mind affecting, language-dependent ability and relies on audible components.",
          2, "Ability"
      }, //
      {90, "Dirge of Doom",
          "A bard of 8th level or higher can use his performance to foster a sense of growing dread in his enemies, causing them to become shaken. To be affected, an enemy must be within 30 feet and able to see and hear the bard's performance. The effect persists for as long as the enemy is within 30 feet and the bard continues his performance. This performance cannot cause a creature to become frightened or panicked, even if the targets are already shaken from another effect. Dirge of doom is a mind-affecting fear effect, and it relies on audible and visual components.",
          3, "Ability"
      }, //
      {91, "Inspire Greatness",
          "A bard of 9th level or higher can use his performance to inspire greatness in himself or a single willing ally within 30 feet, granting extra fighting capability. For every three levels the bard attains beyond 9th, he can target an additional ally while using this performance (up to a maximum of four targets at 18th level). To inspire greatness, all of the targets must be able to see and hear the bard. A creature inspired with greatness gains 2 bonus Hit Dice (d10s), the commensurate number of temporary hit points (apply the target's Constitution modifier, if any, to these bonus Hit Dice), a +2 competence bonus on attack rolls, and a +1 competence bonus on Fortitude saves. The bonus Hit Dice count as regular Hit Dice for determining the effect of spells that are Hit Dice dependent. Inspire greatness is a mind-affecting ability and it relies on audible and visual components.",
          3, "Ability"
      }, //
      {92, "Soothing Performance",
          "A bard of 12th level or higher can use his performance to create an effect equivalent to a mass cure serious wounds, using the bard's level as the caster level. In addition, this performance removes the fatigued, sickened, and shaken conditions from all those affected. Using this ability requires 4 rounds of continuous performance, and the targets must be able to see and hear the bard throughout the performance. Soothing performance affects all targets that remain within 30 feet throughout the performance. Soothing performance relies on audible and visual components.",
          3, "Ability"
      }, //
      {93, "Frightening Tune",
          "A bard of 14th level or higher can use his performance to cause fear in his enemies. To be affected, an enemy must be able to hear the bard perform and be within 30 feet. Each enemy within range receives a Will save (DC 10 + 1/2 the bard's level + the bard's Cha modifier) to negate the effect. If the save succeeds, the creature is immune to this ability for 24 hours. If the save fails, the target becomes frightened and flees for as long as the target can hear the bard's performance. Frightening tune relies on audible components.",
          2, "Ability"
      }, //
      {94, "Inspire Heroics",
          "A bard of 15th level or higher can inspire tremendous heroism in himself or a single ally within 30 feet. For every three bard levels the character attains beyond 15th, he can inspire heroics in an additional creature. To inspire heroics, all of the targets must be able to see and hear the bard. Inspired creatures gain a +4 morale bonus on saving throws and a +4 dodge bonus to AC. This effect lasts for as long as the targets are able to witness the performance. Inspire heroics is a mind-affecting ability that relies on audible and visual components.",
          3, "Ability"
      }, //
      {95, "Mass Suggestion",
          "This ability functions just like suggestion, but allows a bard of 18th level or higher to make a suggestion simultaneously to any number of creatures that he has already fascinated. Mass suggestion is an  enchantment (compulsion), mind-affecting, language-dependent ability that relies on audible components.",
          3, "Ability"
      }, //
      {96, "Deadly Performance",
          "A bard of 20th level or higher can use his performance to cause one enemy to die from joy or sorrow. To be affected, the target must be able to see and hear the bard perform for 1 full round and be within 30 feet. The target receives a Will save (DC 10 + 1/2 the bard's level + the bard's Cha modifier) to negate the effect. If a creature's saving throw succeeds, the target is staggered for 1d4 rounds, and the bard cannot use deadly performance on that creature again for 24 hours. If a creature's saving throw fails, it dies. Deadly performance is a mind-affecting death effect that relies on audible and visual components.",
          3, "Ability"
      }, //
      {97, "Cantrips - Bard",
          "Bards learn a number of cantrips, or 0-level spells, as noted on Table: Bard Spells Known under 'Spells Known.' These spells are cast like any other spell, but they do not consume any slots and may be used again.",
          0, "Ability"
      }, //
      {98, "Versatile Performance",
          "At 2nd level, a bard can choose one type of Perform skill. He can use his bonus in that skill in place of his bonus in associated skills. When substituting in this way, the bard uses his total Perform skill bonus, including class skill bonus, in place of its associated skill's bonus, whether or not he has ranks in that skill or if it is a class skill. At 6th level, and every 4 levels thereafter, the bard can select an additional type of Perform to substitute.<br/>The types of Perform and their associated skills are: Act (Bluff, Disguise), Comedy (Bluff, Intimidate), Dance (Acrobatics, Fly), Keyboard Instruments (Diplomacy, Intimidate), Oratory (Diplomacy, Sense Motive), Percussion (Handle Animal, Intimidate), Sing (Bluff, Sense Motive), String (Bluff, Diplomacy), and Wind (Diplomacy, Handle Animal).",
          1, "Ability"
      }, //
      {99, "Well-Versed",
          "At 2nd level, the bard becomes resistant to the bardic performance of others, and to sonic effects in general. The bard gains a +4 bonus on saving throws made against bardic performance, sonic, and language-dependent effects. ",
          1, "Ability"
      }, //
      {100, "Lore Master",
          "At 5th level, the bard becomes a master of lore and can take 10 on any Knowledge skill check that he has ranks in. A bard can choose not to take 10 and can instead roll normally. In addition, once per day, the bard can take 20 on any Knowledge skill check as a standard action. He can use this ability one additional time per day for every six levels he possesses beyond 5th, to a maximum of three times per day at 17th level.",
          1, "Ability"
      }, //
      {101, "Jack-of-All-Trades",
          "At 10th level, the bard can use any skill, even if the skill normally requires him to be trained. At 16th level, the bard considers all skills to be class skills. At 19th level, the bard can take 10 on any skill check, even if it is not normally allowed.",
          1, "Ability"
      }, //
      {102, "Aura",
          "A cleric of a chaotic, evil, good, or lawful deity has a particularly powerful aura corresponding to the deity's alignment (see the detect evil spell for details).",
          1, "Ability"
      }, //
      {103, "Spells - Cleric",
          "A cleric casts divine spells which are drawn from the cleric spell list presented in alignment, however, may restrict her from casting certain spells opposed to her moral or ethical beliefs, see chaotic, evil, good, and lawful spells. A cleric must choose and prepare her spells in advance.<br/>To prepare or cast a spell, a cleric must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a cleric's spell is 10 + the spell level + the cleric's Wisdom modifier.<br/>Like other spellcasters, a cleric can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: Cleric. In addition, she receives bonus spells per day if she has a high Wisdom score (see Table: Ability Modifiers and Bonus Spells). <br/>Clerics meditate or pray for their spells. Each cleric must choose a time when she must spend 1 hour each day in quiet contemplation or supplication to regain her daily allotment of spells. A cleric may prepare and cast any spell on the cleric spell list, provided that she can cast spells of that level, but she must choose which spells to prepare during her daily meditation.",
          0, "SpelllistAbility"
      }, //
      {104, "Channel Energy",
          "Regardless of alignment, any cleric can release a wave of energy by channeling the power of her faith through her holy (or unholy) symbol. This energy can be used to cause or heal damage, depending on the type of energy channeled and the creatures targeted. <br/>A good cleric (or one who worships a good deity) channels positive energy and can choose to deal damage to undead creatures or to heal living creatures. An evil cleric (or one who worships an evil deity) channels negative energy and can choose to deal damage to living creatures or to heal undead creatures. A neutral cleric who worships a neutral deity (or one who is not devoted to a particular deity) must choose whether she channels positive or negative energy. Once this choice is made, it cannot be reversed. This decision also determines whether the cleric casts spontaneous cure or inflict spells (see spontaneous casting). <br/>Channeling energy causes a burst that affects all creatures of one type (either undead or living) in a 30-foot radius centered on the cleric. The amount of damage dealt or healed is equal to 1d6 points of damage plus 1d6 points of damage for every two cleric levels beyond 1st (2d6 at 3rd, 3d6 at 5th, and so on). Creatures that take damage from channeled energy receive a Will save to halve the damage. The DC of this save is equal to 10 + 1/2 the cleric's level + the cleric's Charisma modifier. Creatures healed by channeled energy cannot exceed their maximum hit point total-all excess healing is lost. A cleric may channel energy a number of times per day equal to 3 + her Charisma modifier. This is a standard action that does not provoke an attack of opportunity. A cleric can choose whether or not to include herself in this effect. A cleric must be able to present her holy symbol to use this ability. ",
          3, "Ability"
      }, //
      {105, "Domains",
          "A cleric's deity influences her alignment, what magic she can perform, her values, and how others see her. A cleric chooses two domains from among those belonging to her deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if her alignment matches that domain. If a cleric is not devoted to a particular deity, she still selects two domains to represent her spiritual inclinations and abilities (subject to GM approval). The restriction on alignment domains still applies.<br/>Each domain grants a number of domain powers, dependent upon the level of the cleric, as well as a number of bonus spells. A cleric gains one domain spell slot for each level of cleric spell she can cast, from 1st on up. Each day, a cleric can prepare one of the spells from her two domains in that slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in her domain spell slot. Domain spells cannot be used to cast spells spontaneously. <br/>In addition, a cleric gains the listed powers from both of her domains, if she is of a high enough level. Unless otherwise noted, using a domain power is a standard action. Cleric domains are listed at the end of this class entry.",
          0, "Ability"
      }, //
      {106, "Orisons - Cleric",
          "Clerics can prepare a number of orisons, or 0-level spells, each day, as noted on Table: Cleric under 'Spells per Day.' These spells are cast like any other spell, but they are not expended when cast and may be used again.",
          0, "Ability"
      }, //
      {107, "Spontaneous Casting - Cleric",
          "A good cleric (or a neutral cleric of a good deity) can channel stored spell energy into healing spells that she did not prepare ahead of time. The cleric can 'lose' any prepared spell that is not an orison or domain spell in order to cast any cure spell of the same spell level or lower (a cure spell is any spell with 'cure' in its name). <br/>An evil cleric (or a neutral cleric who worships an evil deity) can't convert prepared spells to cure spells but can convert them to inflict spells (an inflict spell is one with 'inflict' in its name).<br/>A cleric who is neither good nor evil and whose deity is neither good nor evil can convert spells to either cure spells or inflict spells (player's choice). Once the player makes this choice, it cannot be reversed. This choice also determines whether the cleric channels positive or negative energy (see Channel Energy).",
          0, "Ability"
      }, //
      {108, "Chaotic, Evil, Good, and Lawful Spells",
          "A character can't cast spells of an alignment opposed to her own or her deity's (if she has one). Spells associated with particular alignments are indicated by the chaotic, evil, good, and lawful descriptors in their spell descriptions.",
          0, "Ability"
      }, //
      {109, "Bonus Languages - Cleric",
          "A cleric's bonus language options include Celestial, Abyssal, and Infernal (the languages of good, chaotic evil, and lawful evil outsiders, respectively). These choices are in addition to the bonus languages available to the character because of her race.",
          0, "Ability"
      }, //
      {110, "Spells - Druid",
          "A druid casts divine spells which are drawn from the druid spell list presented in alignment may restrict her from casting certain spells opposed to her moral or ethical beliefs, see Chaotic, Evil, Good, and Lawful Spells. A druid must choose and prepare her spells in advance.<br/>To prepare or cast a spell, the druid must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a druid's spell is 10 + the spell level + the druid's Wisdom modifier.<br/>Like other spellcasters, a druid can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: Druid. In addition, she receives bonus spells per day if she has a high Wisdom score (see Table: Ability Modifiers and Bonus Spells).<br/>A druid must spend 1 hour each day in a trance-like meditation on the mysteries of nature to regain her daily allotment of spells. A druid may prepare and cast any spell on the druid spell list, provided that she can cast spells of that level, but she must choose which spells to prepare during her daily meditation.",
          0, "SpelllistAbility"
      }, //
      {111, "Spontaneous Casting - Druid",
          "A druid can channel stored spell energy into summoning spells that she hasn't prepared ahead of time. She can 'lose' a prepared spell in order to cast any summon nature's ally spell of the same level or lower. ",
          0, "Ability"
      }, //
      {113, "Orisons - Druid",
          "Druids can prepare a number of orisons, or 0-level spells, each day, as noted on Table: Druid under 'Spells per Day.' These spells are cast like any other spell, but they are not expended when cast and may be used again.",
          0, "Ability"
      }, //
      {114, "Bonus Languages - Druid",
          "A druid's bonus language options include Sylvan, the language of woodland creatures. This choice is in addition to the bonus languages available to the character because of her race.<br/>A druid also knows Druidic, a secret language known only to druids, which she learns upon becoming a 1st-level druid. Druidic is a free language for a druid, that is, she knows it in addition to her regular allotment of languages and it doesn't take up a language slot. Druids are forbidden to teach this language to nondruids.<br/>Druidic has its own alphabet.",
          0, "Ability"
      }, //
      {115, "Nature Bond",
          "At 1st level, a druid forms a bond with nature. This bond can take one of two forms. The first is a close tie to the natural world, granting the druid one of the following cleric domains: Air, Animal, Earth, Fire, Plant, Water, or Weather. When determining the powers and bonus spells granted by this domain, the druid's effective cleric level is equal to her druid level. A druid that selects this option also receives additional domain spell slots, just like a cleric. She must prepare the spell from her domain in this slot and this spell cannot be used to cast a spell spontaneously.<br/>The second option is to form a close bond with an animal companion. A druid may begin play with any of the animals listed in Animal Choices. This animal is a loyal companion that accompanies the druid on her adventures.<br/>Unlike normal animals of its kind, an animal companion's Hit Dice, abilities, skills, and feats advance as the druid advances in level. If a character receives an animal companion from more than one source, her effective druid levels stack for the purposes of determining the statistics and abilities of the companion. Most animal companions increase in size when their druid reaches 4th or 7th level, depending on the companion. If a druid releases her companion from service, she may gain a new one by performing a ceremony requiring 24 uninterrupted hours of prayer in the environment where the new companion typically lives. This ceremony can also replace an animal companion that has perished.",
          1, "Ability"
      }, //
      {116, "Nature Sense", "A druid gains a +2 bonus on Knowledge (nature) and Survival checks.", 1, "Ability"}, //
      {117, "Wild Empathy",
          "A character can improve the attitude of an animal. This ability functions just like a Diplomacy check made to improve the attitude of a person (see Charisma modifier to determine the wild empathy check result. The typical domestic animal has a starting attitude of indifferent, while wild animals are usually unfriendly.<br/>To use wild empathy, the character and the animal must be within 30 feet of one another under normal conditions. Generally, influencing an animal in this way takes 1 minute but, as with influencing people, it might take more or less time.<br/>A character can also use this ability to influence a magical beast with an Intelligence score of 1 or 2, but she takes a -4 penalty on the check.",
          1, "Ability"
      }, //
      {118, "Woodland Stride",
          "A character may move through any sort of undergrowth (such as natural thorns, briars, overgrown areas, and similar terrain) at her normal speed and without taking damage or suffering any other impairment. Thorns, briars, and overgrown areas that have been magically manipulated to impede motion, however, still affect her.",
          1, "Ability"
      }, //
      {119, "Trackless Step",
          "Starting at 3rd level, a druid leaves no trail in natural surroundings and cannot be tracked. She may choose to leave a trail if so desired.",
          1, "Ability"
      }, //
      {120, "Resist Nature's Lure",
          "Starting at 4th level, a druid gains a +4 bonus on saving throws against the spell-like and supernatural abilities of fey. This bonus also applies to spells and effects that utilize or target plants, such as blight, entangle, spike growth, and warp wood.",
          1, "Ability"
      }, //
      {121, "Wild Shape",
          "At 4th level, a druid gains the ability to turn herself into any Small or Medium animal and back again once per day. Her options for new forms include all creatures with the animal type. This ability functions like the beast shape I spell, except as noted here. The effect lasts for 1 hour per druid level, or until she changes back. Changing form (to animal or back) is a standard action and doesn't provoke an attack of opportunity. The form chosen must be that of an animal with which the druid is familiar. <br/>A druid loses her ability to speak while in animal form because she is limited to the sounds that a normal, untrained animal can make, but she can communicate normally with other animals of the same general grouping as her new form. (The normal sound a wild parrot makes is a squawk, so changing to this form does not permit speech.)<br/>A druid can use this ability an additional time per day at 6th level and every two levels thereafter, for a total of eight times at 18th level. At 20th level, a druid can use wild shape at will. As a druid gains levels, this ability allows the druid to take on the form of larger and smaller animals, elementals, and plants. Each form expends one daily use of this ability, regardless of the form taken. <br/>At 6th level, a druid can also use wild shape to change into a Large or Tiny animal or a Small elemental. When taking the form of an animal, a druid's wild shape now functions as beast shape II. When taking the form of an elemental, the druid's wild shape functions as elemental body I.<br/>At 8th level, a druid can also use wild shape to change into a Huge or Diminutive animal, a Medium elemental, or a Small or Medium plant creature. When taking the form of animals, a druid's wild shape now functions as beast shape III. When taking the form of an elemental, the druid's wild shape now functions as elemental body II. When taking the form of a plant creature, the druid's wild shape functions as plant shape I.<br/>At 10th level, a druid can also use wild shape to change into a Large elemental or a Large plant creature. When taking the form of an elemental, the druid's wild shape now functions as elemental body III. When taking the form of a plant, the druid's wild shape now functions as plant shape II.<br/>At 12th level, a druid can also use wild shape to change into a Huge elemental or a Huge plant creature. When taking the form of an elemental, the druid's wild shape now functions as elemental body IV. When taking the form of a plant, the druid's wild shape now functions as plant shape III.",
          3, "Ability"
      }, //
      {122, "Venom Immunity", "At 9th level, a druid gains immunity to all poisons. ", 1, "Ability"}, //
      {123, "A Thousand Faces",
          "At 13th level, a druid gains the ability to change her appearance at will, as if using the alter self spell, but only while in her normal form.",
          3, "Ability"
      }, //
      {124, "Timeless Body",
          "A character no longer takes penalties to his ability scores for aging and cannot be magically aged. Any such penalties that he has already taken, however, remain in place. Age bonuses still accrue, and the character still dies of old age when his time is up.",
          1, "Ability"
      }, //
      {125, "Bonus Feats - Fighter",
          "At 1st level, and at every even level thereafter, a fighter gains a bonus feat in addition to those gained from normal advancement (meaning that the fighter gains a feat at every level). These bonus feats must be selected from those listed as combat feats, sometimes also called 'fighter bonus feats.'<br/>Upon reaching 4th level, and every four levels thereafter (8th, 12th, and so on), a fighter can choose to learn a new bonus feat in place of a bonus feat he has already learned. In effect, the fighter loses the bonus feat in exchange for the new one. The old feat cannot be one that was used as a prerequisite for another feat, prestige class, or other ability. A fighter can only change one feat at any given level and must choose whether or not to swap the feat at the time he gains a new bonus feat for the level.",
          0, "Ability"
      }, //
      {126, "Bravery",
          "Starting at 2nd level, a fighter gains a +1 bonus on Will saves against fear. This bonus increases by +1 for every four levels beyond 2nd.",
          1, "Ability"
      }, //
      {127, "Armor Training",
          "Starting at 3rd level, a fighter learns to be more maneuverable while wearing armor. Whenever he is wearing armor, he reduces the armor check penalty by 1 (to a minimum of 0) and increases the maximum Dexterity bonus allowed by his armor by 1. Every four levels thereafter (7th, 11th, and 15th), these bonuses increase by +1 each time, to a maximum -4 reduction of the armor check penalty and a +4 increase of the maximum Dexterity bonus allowed.<br/>In addition, a fighter can also move at his normal speed while wearing medium armor. At 7th level, a fighter can move at his normal speed while wearing heavy armor.",
          1, "Ability"
      }, //
      {128, "Weapon Training - Fighter",
          "Starting at 5th level, a fighter can select one group of weapons, as noted below. Whenever he attacks with a weapon from this group, he gains a +1 bonus on attack and damage rolls.<br/>Every four levels thereafter (9th, 13th, and 17th), a fighter becomes further trained in another group of weapons. He gains a +1 bonus on attack and damage rolls when using a weapon from this group. In addition, the bonuses granted by previous weapon groups increase by +1 each. For example, when a fighter reaches 9th level, he receives a +1 bonus on attack and damage rolls with one weapon group and a +2 bonus on attack and damage rolls with the weapon group selected at 5th level. Bonuses granted from overlapping groups do not stack. Take the highest bonus granted for a weapon if it resides in two or more groups.<br/>A fighter also adds this bonus to any combat maneuver checks made with weapons from this group. This bonus also applies to the fighter's Combat Maneuver Defense when defending against disarm and sunder attempts made against weapons from this group.<br/>Weapon groups are defined as follows (GMs may add other weapons to these groups, or add entirely new groups):<br/>Axes: battleaxe, dwarven waraxe, greataxe, handaxe, heavy pick, light pick, orc double axe, and throwing axe. <br/>Blades, Heavy: bastard sword, elven curve blade, falchion, greatsword, longsword, scimitar, scythe, and two-bladed sword.<br/>Blades, Light: dagger, kama, kukri, rapier, sickle, starknife, and short sword.<br/>Bows: composite longbow, composite shortbow, longbow, and shortbow.<br/>Close: gauntlet, heavy shield, light shield, punching dagger, sap, spiked armor, spiked gauntlet, spiked shield, and unarmed strike.<br/>Crossbows: hand crossbow, heavy crossbow, light crossbow, heavy repeating crossbow, and light repeating crossbow.<br/>Double: dire flail, dwarven urgrosh, gnome hooked hammer, orc double axe, quarterstaff, and two-bladed sword.<br/>Flails: dire flail, flail, heavy flail, morningstar, nunchaku, spiked chain, and whip.<br/>Hammers: club, greatclub, heavy mace, light hammer, light mace, and warhammer.<br/>Monk: kama, nunchaku, quarterstaff, sai, shuriken, siangham, and unarmed strike.<br/>Natural: unarmed strike and all natural weapons, such as bite, claw, gore, tail, and wing.<br/>Pole Arms: glaive, guisarme, halberd, and ranseur.<br/>Spears: javelin, lance, longspear, shortspear, spear, and trident.<br/>Thrown: blowgun, bolas, club, dagger, dart, halfling sling staff, javelin, light hammer, net, shortspear, shuriken, sling, spear, starknife, throwing axe, and trident.",
          1, "Ability"
      }, //
      {129, "Armor Mastery", "At 19th level, a fighter gains DR 5/- whenever he is wearing armor or using a shield.", 1, "Ability"},
      //
      {130, "Weapon Mastery",
          "At 20th level, a fighter chooses one weapon, such as the longsword, greataxe, or longbow. Any attacks made with that weapon automatically confirm all critical threats and have their damage multiplier increased by 1 (&times,2 becomes &times,3, for example). In addition, he cannot be disarmed while wielding a weapon of this type.",
          1, "Ability"
      }, //
      {131, "AC Bonus",
          "When unarmored and unencumbered, the monk adds his Wisdom bonus (if any) to his AC and his CMD. In addition, a monk gains a +1 bonus to AC and CMD at 4th level. This bonus increases by 1 for every four monk levels thereafter, up to a maximum of +5 at 20th level.<br/>These bonuses to AC apply even against touch attacks or when the monk is flat-footed. He loses these bonuses when he is immobilized or helpless, when he wears any armor, when he carries a shield, or when he carries a medium or heavy load.",
          1, "Ability"
      }, //
      {132, "Flurry of Blows",
          "Starting at 1st level, a monk can make a flurry of blows as a full-attack action. When doing so he may make one additional attack using any combination of unarmed strikes or attacks with a special monk weapon (kama, nunchaku, quarterstaff, sai, shuriken, and siangham) as if using the Two-Weapon Fighting feat (even if the monk does not meet the prerequisites for the feat). For the purpose of these attacks, the monk's base attack bonus from his monk class levels. For all other purposes, such as qualifying for a feat or a prestige class, the monk uses his normal base attack bonus. <br/>At 8th level, the monk can make two additional attacks when he uses flurry of blows, as if using Improved Two-Weapon Fighting (even if the monk does not meet the prerequisites for the feat).<br/>At 15th level, the monk can make three additional attacks using flurry of blows, as if using Greater Two-Weapon Fighting (even if the monk does not meet the prerequisites for the feat). <br/>A monk applies his full Strength bonus to his damage rolls for all successful attacks made with flurry of blows, whether the attacks are made with an off-hand or with a weapon wielded in both hands. A monk may substitute disarm, sunder, and trip combat maneuvers for unarmed attacks as part of a flurry of blows. A monk cannot use any weapon other than an unarmed strike or a special monk weapon as part of a flurry of blows. A monk with natural weapons cannot use such weapons as part of a flurry of blows, nor can he make natural attacks in addition to his flurry of blows attacks.",
          1, "Ability"
      }, //
      {133, "Unarmed Strike",
          "At 1st level, a monk gains Improved Unarmed Strike as a bonus feat. A monk's attacks may be with fist, elbows, knees, and feet. This means that a monk may make unarmed strikes with his hands full. There is no such thing as an off-hand attack for a monk striking unarmed. A monk may thus apply his full Strength bonus on damage rolls for all his unarmed strikes.<br/>Usually a monk's unarmed strikes deal lethal damage, but he can choose to deal nonlethal damage instead with no penalty on his attack roll. He has the same choice to deal lethal or nonlethal damage while grappling.<br/>A monk's unarmed strike is treated as both a manufactured weapon and a natural weapon for the purpose of spells and effects that enhance or improve either manufactured weapons or natural weapons.<br/>A monk also deals more damage with his unarmed strikes than a normal person would.",
          0, "Ability"
      }, //
      {134, "Bonus Feat - Monk",
          "At 1st level, 2nd level, and every 4 levels thereafter, a monk may select a bonus feat. These feats must be taken from the following list: Catch Off-Guard, Combat Reflexes, Deflect Arrows, Dodge, Improved Grapple, Scorpion Style, and Throw Anything. At 6th level, the following feats are added to the list: Gorgon's Fist, Improved Bull Rush, Improved Disarm, Improved Feint, Improved Trip, and Mobility. At 10th level, the following feats are added to the list: Improved Critical, Medusa's Wrath, Snatch Arrows, and Spring Attack. A monk need not have any of the prerequisites normally required for these feats to select them.",
          0, "Ability"
      }, //
      {135, "Stunning Fist",
          "At 1st level, the monk gains Stunning Fist as a bonus feat, even if he does not meet the prerequisites. At 4th level, and every 4 levels thereafter, the monk gains the ability to apply a new condition to the target of his Stunning Fist. This condition replaces stunning the target for 1 round, and a successful saving throw still negates the effect. At 4th level, he can choose to make the target fatigued. At 8th level, he can make the target sickened for 1 minute. At 12th level, he can make the target staggered for 1d6+1 rounds. At 16th level, he can permanently blind or deafen the target. At 20th level, he can paralyze the target for 1d6+1 rounds. The monk must choose which condition will apply before the attack roll is made. These effects do not stack with themselves (a creature sickened by Stunning Fist cannot become nauseated if hit by Stunning Fist again), but additional hits do increase the duration.",
          1, "Ability"
      }, //
      {136, "Evasion",
          "If exposed to any effect that normally allows her to attempt a Reflex saving throw for half damage, she takes no damage with a successful saving throw. The evasion ability can only be used if the character is wearing light armor or no armor.",
          1, "Ability"
      }, //
      {137, "Fast Movement - Monk",
          "At 3rd level, a monk gains an enhancement bonus to his land speed, as shown on Table: Monk. A monk in armor or carrying a medium or heavy load loses this extra speed.",
          1, "Ability"
      }, //
      {138, "Maneuver Training",
          "At 3rd level, a monk uses his monk level in place of his base attack bonus when calculating his Combat Maneuver Bonus. Base attack bonuses granted from other classes are unaffected and are added normally.",
          1, "Ability"
      }, //
      {139, "Still Mind", "A monk of 3rd level or higher gains a +2 bonus on saving throws against enchantment spells and effects.",
          1, "Ability"
      }, //
      {140, "Ki Pool",
          "At 4th level, a monk gains a pool of ki points, supernatural energy he can use to accomplish amazing feats. The number of points in a monk's ki pool is equal to 1/2 his monk level + his Wisdom modifier. As long as he has at least 1 point in his ki pool, he can make a ki strike. At 4th level, ki strike allows his unarmed attacks to be treated as magic weapons for the purpose of overcoming damage reduction. Ki strike improves with the character's monk level. At 10th level, his unarmed attacks are also treated as lawful weapons for the purpose of overcoming damage reduction. At 16th level, his unarmed attacks are treated as adamantine weapons for the purpose of overcoming damage reduction and bypassing hardness.<br/>By spending 1 point from his ki pool, a monk can make one additional attack at his highest attack bonus when making a flurry of blows attack. In addition, he can spend 1 point to increase his speed by 20 feet for 1 round. Finally, a monk can spend 1 point from his ki pool to give himself a +4 dodge bonus to AC for 1 round. Each of these powers is activated as a swift action. A monk gains additional powers that consume points from his ki pool as he gains levels.<br/>The ki pool is replenished each morning after 8 hours of rest or meditation, these hours do not need to be consecutive.",
          3, "Ability"
      }, //
      {141, "Slow Fall",
          "At 4th level or higher, a monk within arm's reach of a wall can use it to slow his descent. When first gaining this ability, he takes damage as if the fall were 20 feet shorter than it actually is. The monk's ability to slow his fall (that is, to reduce the effective distance of the fall when next to a wall) improves with his monk level until at 20th level he can use a nearby wall to slow his descent and fall any distance without harm.",
          1, "Ability"
      }, //
      {142, "High Jump",
          "At 5th level, a monk adds his level to all Acrobatics checks made to jump, both for vertical jumps and horizontal jumps. In addition, he always counts as having a running start when making jump checks using Acrobatics. By spending 1 point from his ki pool as a swift action, a monk gains a +20 bonus on Acrobatics checks made to jump for 1 round.",
          1, "Ability"
      }, //
      {143, "Purity of Body", "At 5th level, a monk gains immunity to all diseases, including supernatural and magical diseases.",
          1, "Ability"
      }, //
      {144, "Wholeness of Body",
          "At 7th level or higher, a monk can heal his own wounds as a standard action. He can heal a number of hit points of damage equal to his monk level by using 2 points from his ki pool.",
          3, "Ability"
      }, //
      {145, "Improved Evasion",
          "This works like evasion, except that while the character still takes no damage on a successful Reflex saving throw against attacks, she henceforth takes only half damage on a failed save. A helpless character does not gain the benefit of improved evasion.",
          1, "Ability"
      }, //
      {146, "Diamond Body", "At 11th level, a monk gains immunity to poisons of all kinds.", 3, "Ability"}, //
      {147, "Abundant Step",
          "At 12th level or higher, a monk can slip magically between spaces, as if using the spell dimension door. Using this ability is a move action that consumes 2 points from his ki pool. His caster level for this effect is equal to his monk level. He cannot take other creatures with him when he uses this ability.",
          3, "Ability"
      }, //
      {148, "Diamond Soul",
          "At 13th level, a monk gains spell resistance equal to his current monk level + 10. In order to affect the monk with a spell, a spellcaster must get a result on a caster level check (1d20 + caster level) that equals or exceeds the monk's spell resistance.",
          1, "Ability"
      }, //
      {149, "Quivering Palm",
          "Starting at 15th level, a monk can set up vibrations within the body of another creature that can thereafter be fatal if the monk so desires. He can use this quivering palm attack once per day, and he must announce his intent before making his attack roll. Creatures immune to critical hits cannot be affected. Otherwise, if the monk strikes successfully and the target takes damage from the blow, the quivering palm attack succeeds. Thereafter, the monk can try to slay the victim at any later time, as long as the attempt is made within a number of days equal to his monk level. To make such an attempt, the monk merely wills the target to die (a free action), and unless the target makes a Fortitude saving throw (DC 10 + 1/2 the monk's level + the monk's Wis modifier), it dies. If the saving throw is successful, the target is no longer in danger from that particular quivering palm attack, but it may still be affected by another one at a later time. A monk can have no more than 1 quivering palm in effect at one time. If a monk uses quivering palm while another is still in effect, the previous effect is negated.",
          3, "Ability"
      }, //
      {151, "Tongue of the Sun and Moon", "A monk of 17th level or higher can speak with any living creature.", 1, "Ability"}, //
      {152, "Empty Body",
          "At 19th level, a monk gains the ability to assume an ethereal state for 1 minute as though using the spell etherealness. Using this ability is a move action that consumes 3 points from his ki pool. This ability only affects the monk and cannot be used to make other creatures ethereal.",
          3, "Ability"
      }, //
      {153, "Perfect Self",
          "At 20th level, a monk becomes a magical creature. He is forevermore treated as an outsider rather than as a humanoid (or whatever the monk's creature type was) for the purpose of spells and magical effects. Additionally, the monk gains damage reduction 10/chaotic, which allows him to ignore the first 10 points of damage from any attack made by a nonchaotic weapon or by any natural attack made by a creature that doesn't have similar damage reduction. Unlike other outsiders, the monk can still be brought back from the dead as if he were a member of his previous creature type.",
          0, "Ability"
      }, //
      {154, "Aura of Good", "The power of a paladin's aura of good (see the detect good spell) is equal to her paladin level.", 1,
          "Ability"
      }, //
      {155, "Detect Evil",
          "At will, a paladin can use detect evil, as the spell. A paladin can, as a move action, concentrate on a single item or individual within 60 feet and determine if it is evil, learning the strength of its aura as if having studied it for 3 rounds. While focusing on one individual or object, the paladin does not detect evil in any other object or individual within range.",
          2, "Ability"
      }, //
      {156, "Smite Evil",
          "Once per day, a paladin can call out to the powers of good to aid her in her struggle against evil. As a swift action, the paladin chooses one target within sight to smite. If this target is evil, the paladin adds her Charisma bonus (if any) to her attack rolls and adds her paladin level to all damage rolls made against the target of her smite. If the target of smite evil is an outsider with the evil subtype, an evil-aligned dragon, or an undead creature, the bonus to damage on the first successful attack increases to 2 points of damage per level the paladin possesses. Regardless of the target, smite evil attacks automatically bypass any DR the creature might possess.<br/>In addition, while smite evil is in effect, the paladin gains a deflection bonus equal to her Charisma modifier (if any) to her AC against attacks made by the target of the smite. If the paladin targets a creature that is not evil, the smite is wasted with no effect.<br/>The smite evil effect remains until the target of the smite is dead or the next time the paladin rests and regains her uses of this ability. At 4th level, and at every three levels thereafter, the paladin may smite evil one additional time per day, as indicated on Table: Paladin, to a maximum of seven times per day at 19th level.",
          3, "Ability"
      }, //
      {157, "Divine Grace", "At 2nd level, a paladin gains a bonus equal to her Charisma bonus (if any) on all saving throws.", 3,
          "Ability"
      }, //
      {158, "Lay On Hands",
          "Beginning at 2nd level, a paladin can heal wounds (her own or those of others) by touch. Each day she can use this ability a number of times equal to 1/2 her paladin level plus her Charisma modifier. With one use of this ability, a paladin can heal 1d6 hit points of damage for every two paladin levels she possesses. Using this ability is a standard action, unless the paladin targets herself, in which case it is a swift action. Despite the name of this ability, a paladin only needs one free hand to use this ability.<br/>Alternatively, a paladin can use this healing power to deal damage to undead creatures, dealing 1d6 points of damage for every two levels the paladin possesses. Using lay on hands in this way requires a successful melee touch attack and doesn't provoke an attack of opportunity. Undead do not receive a saving throw against this damage.",
          3, "Ability"
      }, //
      {159, "Aura of Courage",
          "At 3rd level, a paladin is immune to fear (magical or otherwise). Each ally within 10 feet of her gains a +4 morale bonus on saving throws against fear effects. This ability functions only while the paladin is conscious, not if she is unconscious or dead.",
          3, "Ability"
      }, //
      {160, "Divine Health",
          "At 3rd level, a paladin is immune to all diseases, including supernatural and magical diseases, including mummy rot.", 1,
          "Ability"
      }, //
      {161, "Mercy",
          "At 3rd level, and every three levels thereafter, a paladin can select one mercy. Each mercy adds an effect to the paladin's lay on hands ability. Whenever the paladin uses lay on hands to heal damage to one target, the target also receives the additional effects from all of the mercies possessed by the paladin. A mercy can remove a condition caused by a curse, disease, or poison without curing the affliction. Such conditions return after 1 hour unless the mercy actually removes the affliction that causes the condition.<br/>At 3rd level, the paladin can select from the following initial mercies. <br/>- Fatigued: The target is no longer fatigued.<br/>- Shaken: The target is no longer shaken.<br/>- Sickened: The target is no longer sickened. <br/>At 6th level, a paladin adds the following mercies to the list of those that can be selected. <br/>- Dazed: The target is no longer dazed.<br/>- Diseased: The paladin's lay on hands ability also acts as remove disease, using the paladin's level as the caster level.<br/>- Staggered: The target is no longer staggered, unless the target is at exactly 0 hit points.<br/>At 9th level, a paladin adds the following mercies to the list of those that can be selected.<br/>- Cursed: The paladin's lay on hands ability also acts as remove curse, using the paladin's level as the caster level.<br/>- Exhausted: The target is no longer exhausted. The paladin must have the fatigue mercy before selecting this mercy.<br/>- Frightened: The target is no longer frightened. The paladin must have the shaken mercy before selecting this mercy.<br/>- Nauseated: The target is no longer nauseated. The paladin must have the sickened mercy before selecting this mercy.<br/>- Poisoned: The paladin's lay on hands ability also acts as neutralize poison, using the paladin's level as the caster level.<br/>At 12th level, a paladin adds the following mercies to the list of those that can be selected.<br/>- Blinded: The target is no longer blinded.<br/>- Deafened: The target is no longer deafened.<br/>- Paralyzed: The target is no longer paralyzed.<br/>- Stunned: The target is no longer stunned. <br/>These abilities are cumulative. For example, a 12th-level paladin's lay on hands ability heals 6d6 points of damage and might also cure fatigued and exhausted conditions as well as removing diseases and neutralizing poisons. Once a condition or spell effect is chosen, it can't be changed.",
          3, "Ability"
      }, //
      {162, "Channel Positive Energy",
          "When a paladin reaches 4th level, she gains the supernatural ability to channel positive energy like a cleric. Using this ability consumes two uses of her lay on hands ability. A paladin uses her level as her effective cleric level when channeling positive energy. This is a Charisma-based ability.",
          3, "Ability"
      }, //
      {163, "Spells - Paladin",
          "Beginning at 4th level, a paladin gains the ability to cast a small number of divine spells which are drawn from the paladin spell list presented in Spell Lists. A paladin must choose and prepare her spells in advance.<br/>To prepare or cast a spell, a paladin must have a Charisma score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a paladin's spell is 10 + the spell level + the paladin's Charisma modifier.<br/>Like other spellcasters, a paladin can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: Paladin. In addition, she receives bonus spells per day if she has a high Charisma score (see Table: Ability Modifiers and Bonus Spells). When Table: Paladin indicates that the paladin gets 0 spells per day of a given spell level, she gains only the bonus spells she would be entitled to based on her Charisma score for that spell level.<br/>A paladin must spend 1 hour each day in quiet prayer and meditation to regain her daily allotment of spells. A paladin may prepare and cast any spell on the paladin spell list, provided that she can cast spells of that level, but she must choose which spells to prepare during her daily meditation.<br/>Through 3rd level, a paladin has no caster level. At 4th level and higher, her caster level is equal to her paladin level - 3.",
          0, "SpelllistAbility"
      }, //
      {164, "Divine Bond",
          "Upon reaching 5th level, a paladin forms a divine bond with her god. This bond can take one of two forms. Once the form is chosen, it cannot be changed.<br/>The first type of bond allows the paladin to enhance her weapon as a standard action by calling upon the aid of a celestial spirit for 1 minute per paladin level. When called, the spirit causes the weapon to shed light as a torch. At 5th level, this spirit grants the weapon a +1 enhancement bonus. For every three levels beyond 5th, the weapon gains another +1 enhancement bonus, to a maximum of +6 at 20th level. These bonuses can be added to the weapon, stacking with existing weapon bonuses to a maximum of +5, or they can be used to add any of the following weapon properties: axiomatic, brilliant energy, defending, disruption, flaming, flaming burst, holy, keen, merciful, and speed. Adding these properties consumes an amount of bonus equal to the property's cost (see Table: Melee Weapon Special Abilities). These bonuses are added to any properties the weapon already has, but duplicate abilities do not stack. If the weapon is not magical, at least a +1 enhancement bonus must be added before any other properties can be added. The bonus and properties granted by the spirit are determined when the spirit is called and cannot be changed until the spirit is called again. The celestial spirit imparts no bonuses if the weapon is held by anyone other than the paladin but resumes giving bonuses if returned to the paladin. These bonuses apply to only one end of a double weapon. A paladin can use this ability once per day at 5th level, and one additional time per day for every four levels beyond 5th, to a total of four times per day at 17th level.<br/>If a weapon bonded with a celestial spirit is destroyed, the paladin loses the use of this ability for 30 days, or until she gains a level, whichever comes first. During this 30-day period, the paladin takes a -1 penalty on attack and weapon damage rolls.<br/>The second type of bond allows a paladin to gain the service of an unusually intelligent, strong, and loyal steed to serve her in her crusade against evil. This mount is usually a heavy horse (for a Medium paladin) or a pony (for a Small paladin), although more exotic mounts, such as a boar, camel, or dog are also suitable. This mount functions as a druid's animal companion, using the paladin's level as her effective druid level. Bonded mounts have an Intelligence of at least 6. <br/>Once per day, as a full-round action, a paladin may magically call her mount to her side. This ability is the equivalent of a spell of a level equal to one-third the paladin's level. The mount immediately appears adjacent to the paladin. A paladin can use this ability once per day at 5th level, and one additional time per day for every 4 levels thereafter, for a total of four times per day at 17th level.<br/>At 11th level, the mount gains the celestial template and becomes a magical beast for the purposes of determining which spells affect it. At 15th level, a paladin's mount gains spell resistance equal to the paladin's level + 11.<br/>Should the paladin's mount die, the paladin may not summon another mount for 30 days or until she gains a paladin level, whichever comes first. During this 30-day period, the paladin takes a -1 penalty on attack and weapon damage rolls. ",
          2, "Ability"
      }, //
      {165, "Aura of Resolve",
          "At 8th level, a paladin is immune to charm spells and spell-like abilities. Each ally within 10 feet of her gains a +4 morale bonus on saving throws against charm effects.<br/>This ability functions only while the paladin is conscious, not if she is unconscious or dead.",
          3, "Ability"
      }, //
      {166, "Aura of Justice",
          "At 11th level, a paladin can expend two uses of her smite evil ability to grant the ability to smite evil to all allies within 10 feet, using her bonuses. Allies must use this smite evil ability by the start of the paladin's next turn and the bonuses last for 1 minute. Using this ability is a free action. Evil creatures gain no benefit from this ability. ",
          3, "Ability"
      }, //
      {167, "Aura of Faith",
          "At 14th level, a paladin's weapons are treated as good-aligned for the purposes of overcoming damage reduction. Any attack made against an enemy within 10 feet of her is treated as good-aligned for the purposes of overcoming damage reduction.<br/>This ability functions only while the paladin is conscious, not if she is unconscious or dead.",
          3, "Ability"
      }, //
      {168, "Aura of Righteousness",
          "At 17th level, a paladin gains DR 5/evil and immunity to compulsion spells and spell-like abilities. Each ally within 10 feet of her gains a +4 morale bonus on saving throws against compulsion effects. <br/>This ability functions only while the paladin is conscious, not if she is unconscious or dead.",
          3, "Ability"
      }, //
      {169, "Holy Champion",
          "At 20th level, a paladin becomes a conduit for the power of her god. Her DR increases to 10/evil. Whenever she uses smite evil and successfully strikes an evil outsider, the outsider is also subject to a banishment, using her paladin level as the caster level (her weapon and holy symbol automatically count as objects that the subject hates). After the banishment effect and the damage from the attack is resolved, the smite immediately ends. In addition, whenever she channels positive energy or uses lay on hands to heal a creature, she heals the maximum possible amount.",
          3, "Ability"
      }, //
      {170, "Code of Conduct",
          "A paladin must be of lawful good alignment and loses all class features except proficiencies if she ever willingly commits an evil act.<br/>Additionally, a paladin's code requires that she respect legitimate authority, act with honor (not lying, not cheating, not using poison, and so forth), help those in need (provided they do not use the help for evil or chaotic ends), and punish those who harm or threaten innocents.",
          0, "Ability"
      }, //
      {171, "Associates",
          "While she may adventure with good or neutral allies, a paladin avoids working with evil characters or with anyone who consistently offends her moral code. Under exceptional circumstances, a paladin can ally with evil associates, but only to defeat what she believes to be a greater evil. A paladin should seek an atonement spell periodically during such an unusual alliance, and should end the alliance immediately should she feel it is doing more harm than good. A paladin may accept only henchmen, followers, or cohorts who are lawful good.",
          0, "Ability"
      }, //
      {172, "Favored Enemy",
          "At 1st level, a ranger selects a creature type from the ranger favored enemies table. He gains a +2 bonus on Bluff, Knowledge, Perception, Sense Motive, and Survival checks against creatures of his selected type. Likewise, he gets a +2 bonus on weapon attack and damage rolls against them. A ranger may make Knowledge skill checks untrained when attempting to identify these creatures.<br/>At 5th level and every five levels thereafter (10th, 15th, and 20th level), the ranger may select an additional favored enemy. In addition, at each such interval, the bonus against any one favored enemy (including the one just selected, if so desired) increases by +2. <br/>If the ranger chooses humanoids or outsiders as a favored enemy, he must also choose an associated subtype, as indicated on the table below. (Note that there are other types of humanoid to choose from-those called out specifically on the table below are merely the most common.) If a specific creature falls into more than one category of favored enemy, the ranger's bonuses do not stack, he simply uses whichever bonus is higher.",
          1, "Ability"
      }, //
      {173, "Track", "A ranger adds half his level (minimum 1) to Survival skill checks made to follow or identify tracks.", 1,
          "Ability"
      }, //
      {175, "Combat Style Feat",
          "At 2nd level, a ranger must select one of two combat styles to pursue: archery or two-weapon combat. The ranger's expertise manifests in the form of bonus feats at 2nd, 6th, 10th, 14th, and 18th level. He can choose feats from his selected combat style, even if he does not have the normal prerequisites.<br/>If the ranger selects archery, he can choose from the following list whenever he gains a combat style feat: Far Shot, Point Blank Shot, Precise Shot, and Rapid Shot. At 6th level, he adds Improved Precise Shot and Manyshot to the list. At 10th level, he adds Pinpoint Targeting and Shot on the Run to the list.<br/>If the ranger selects two-weapon combat, he can choose from the following list whenever he gains a combat style feat: Double Slice, Improved Shield Bash, Quick Draw, and Two-Weapon Fighting. At 6th level, he adds Improved Two-Weapon Fighting and Two-Weapon Defense to the list. At 10th level, he adds Greater Two-Weapon Fighting and Two-Weapon Rend to the list.<br/>The benefits of the ranger's chosen style feats apply only when he wears light, medium, or no armor. He loses all benefits of his combat style feats when wearing heavy armor. Once a ranger selects a combat style, it cannot be changed.",
          1, "Ability"
      }, //
      {176, "Endurance", "A ranger gains Endurance as a bonus feat at 3rd level.", 1, "Ability"}, //
      {177, "Favored Terrain",
          "At 3rd level, a ranger may select a type of terrain from the Favored Terrains table. The ranger gains a +2 bonus on initiative checks and Knowledge (geography), Perception, Stealth, and Survival skill checks when he is in this terrain. A ranger traveling through his favored terrain normally leaves no trail and cannot be tracked (though he may leave a trail if he so chooses). At 8th level and every five levels thereafter, the ranger may select an additional favored terrain. In addition, at each such interval, the skill bonus and initiative bonus in any one favored terrain (including the one just selected, if so desired), increases by +2. <br/>If a specific terrain falls into more than one category of favored terrain, the ranger's bonuses do not stack, he simply uses whichever bonus is higher.",
          1, "Ability"
      }, //
      {178, "Hunter's Bond",
          "At 4th level, a ranger forms a bond with his hunting companions. This bond can take one of two forms. Once the form is chosen, it cannot be changed. The first is a bond to his companions. This bond allows him to spend a move action to grant half his favored enemy bonus against a single target of the appropriate type to all allies within 30 feet who can see or hear him. This bonus lasts for a number of rounds equal to the ranger's Wisdom modifier (minimum 1). This bonus does not stack with any favored enemy bonuses possessed by his allies, they use whichever bonus is higher.<br/>The second option is to form a close bond with an animal companion. A ranger who selects an animal companion can choose from the following list: badger, bird, camel, cat (small), dire rat, dog, horse, pony, snake (viper or constrictor), or wolf. If the campaign takes place wholly or partly in an aquatic environment, the ranger may choose a shark instead. This animal is a loyal companion that accompanies the ranger on his adventures as appropriate for its kind. A ranger's animal companion shares his favored enemy and favored terrain bonuses.<br/>This ability functions like the druid animal companion ability (which is part of the Nature Bond class feature), except that the ranger's effective druid level is equal to his ranger level - 3.",
          1, "Ability"
      }, //
      {179, "Spells - Ranger",
          "Beginning at 4th level, a ranger gains the ability to cast a small number of divine spells, which are drawn from the ranger spell list presented in Spell Lists. A ranger must choose and prepare his spells in advance.<br/>To prepare or cast a spell, a ranger must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a ranger's spell is 10 + the spell level + the ranger's Wisdom modifier.<br/>Like other spellcasters, a ranger can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: Ranger. In addition, he receives bonus spells per day if he has a high Wisdom score (see Table: Ability Modifiers and Bonus Spells). When Table: Ranger indicates that the ranger gets 0 spells per day of a given spell level, he gains only the bonus spells he would be entitled to based on his Wisdom score for that spell level.<br/>A ranger must spend 1 hour per day in quiet meditation to regain his daily allotment of spells. A ranger may prepare and cast any spell on the ranger spell list, provided that he can cast spells of that level, but he must choose which spells to prepare during his daily meditation.<br/>Through 3rd level, a ranger has no caster level. At 4th level and higher, his caster level is equal to his ranger level - 3.",
          0, "SpelllistAbility"
      }, //
      {180, "Swift Tracker",
          "Beginning at 8th level, a ranger can move at his normal speed while using Survival to follow tracks without taking the normal -5 penalty. He takes only a -10 penalty (instead of the normal -20) when moving at up to twice normal speed while tracking.",
          1, "Ability"
      }, //
      {182, "Quarry",
          "At 11th level, a ranger can, as a standard action, denote one target within his line of sight as his quarry. Whenever he is following the tracks of his quarry, a ranger can take 10 on his Survival skill checks while moving at normal speed, without penalty. In addition, he receives a +2 insight bonus on attack rolls made against his quarry, and all critical threats are automatically confirmed. A ranger can have no more than one quarry at a time and the creature's type must correspond to one of his favored enemy types. He can dismiss this effect at any time as a free action, but he cannot select a new quarry for 24 hours. If the ranger sees proof that his quarry is dead, he can select a new quarry after waiting 1 hour.",
          1, "Ability"
      }, //
      {183, "Camouflage",
          "A ranger of 12th level or higher can use the Stealth skill to hide in any of his favored terrains, even if the terrain doesn't grant cover or concealment.",
          1, "Ability"
      }, //
      {185, "Hide in Plain Sight - Terrain",
          "While in any of his favored terrains, a ranger of 17th level or higher can use the Stealth skill even while being observed.",
          1, "Ability"
      }, //
      {186, "Improved Quarry",
          "At 19th level, the ranger's ability to hunt his quarry improves. He can now select a quarry as a free action, and can now take 20 while using Survival to track his quarry, while moving at normal speed without penalty. His insight bonus to attack his quarry increases to +4. If his quarry is killed or dismissed, he can select a new one after 10 minutes have passed.",
          1, "Ability"
      }, //
      {187, "Master Hunter",
          "A ranger of 20th level becomes a master hunter. He can always move at full speed while using Survival to follow tracks without penalty. He can, as a standard action, make a single attack against a favored enemy at his full attack bonus. If the attack hits, the target takes damage normally and must make a Fortitude save or die. The DC of this save is equal to 10 + 1/2 the ranger's level + the ranger's Wisdom modifier. A ranger can choose instead to deal an amount of nonlethal damage equal to the creature's current hit points. A successful save negates this damage. A ranger can use this ability once per day against each favored enemy type he possesses, but not against the same creature more than once in a 24-hour period.",
          1, "Ability"
      }, //
      {188, "Sneak Attack - Rogue",
          "If a rogue can catch an opponent when he is unable to defend himself effectively from her attack, she can strike a vital spot for extra damage.<br/>The rogue's attack deals extra damage anytime her target would be denied a Dexterity bonus to AC (whether the target actually has a Dexterity bonus or not), or when the rogue flanks her target. This extra damage is 1d6 at 1st level, and increases by 1d6 every two rogue levels thereafter. Should the rogue score a critical hit with a sneak attack, this extra damage is not multiplied. Ranged attacks can count as sneak attacks only if the target is within 30 feet.<br/>With a weapon that deals nonlethal damage (like a sap, whip, or an unarmed strike), a rogue can make a sneak attack that deals nonlethal damage instead of lethal damage. She cannot use a weapon that deals lethal damage to deal nonlethal damage in a sneak attack, not even with the usual -4 penalty.<br/>The rogue must be able to see the target well enough to pick out a vital spot and must be able to reach such a spot. A rogue cannot sneak attack while striking a creature with concealment.",
          0, "Ability"
      }, //
      {189, "Trapfinding",
          "A rogue adds 1/2 her level to Perception skill checks made to locate traps and to Disable Device skill checks (minimum +1). A rogue can use Disable Device to disarm magic traps.",
          0, "Ability"
      }, //
      {191, "Rogue Talents",
          "As a rogue gains experience, she learns a number of talents that aid her and confound her foes. Starting at 2nd level, a rogue gains one rogue talent. She gains an additional rogue talent for every 2 levels of rogue attained after 2nd level. A rogue cannot select an individual talent more than once.",
          0, "Ability"
      }, //
      {192, "Bleeding Attack",
          "A rogue with this ability can cause living opponents to bleed by hitting them with a sneak attack. This attack causes the target to take 1 additional point of damage each round for each die of the rogue's sneak attack (e.g., 4d6 equals 4 points of bleed). Bleeding creatures take that amount of damage every round at the start of each of their turns. The bleeding can be stopped by a DC 15 Heal check or the application of any effect that heals hit point damage. Bleeding damage from this ability does not stack with itself. Bleeding damage bypasses any damage reduction the creature might possess.",
          1, "Ability"
      }, //
      {193, "Combat Trick", "A rogue that selects this talent gains a bonus combat feat (see Feats).", 0, "Ability"}, //
      {194, "Fast Stealth", "This ability allows a rogue to move at full speed using the Stealth skill without penalty.", 1,
          "Ability"
      }, //
      {195, "Finesse Rogue", "A rogue that selects this talent gains Weapon Finesse as a bonus feat.", 0, "Ability"}, //
      {196, "Ledge Walker",
          "This ability allows a rogue to move along narrow surfaces at full speed using the Acrobatics skill without penalty. In addition, a rogue with this talent is not flat-footed when using Acrobatics to move along narrow surfaces.",
          1, "Ability"
      }, //
      {197, "Major Magic",
          "A rogue with this talent gains the ability to cast a 1st-level spell from the sorcerer/wizard spell list two times a day as a spell-like ability. The caster level for this ability is equal to the rogue's level. The save DC for this spell is 11 + the rogue's Intelligence modifier. The rogue must have an Intelligence of at least 11 to select this talent. A rogue must have the minor magic rogue talent before choosing this talent.",
          2, "Ability"
      }, //
      {198, "Minor Magic",
          "A rogue with this talent gains the ability to cast a 0-level spell from the sorcerer/wizard spell list. This spell can be cast three times a day as a spell-like ability. The caster level for this ability is equal to the rogue's level. The save DC for this spell is 10 + the rogue's Intelligence modifier. The rogue must have an Intelligence of at least 10 to select this talent.",
          1, "Ability"
      }, //
      {199, "Quick Disable",
          "It takes a rogue with this ability half the normal amount of time to disable a trap using the Disable Device skill (minimum 1 round).",
          1, "Ability"
      }, //
      {200, "Resiliency",
          "Once per day, a rogue with this ability can gain a number of temporary hit points equal to the rogue's level. Activating this ability is an immediate action that can only be performed when she is brought to below 0 hit points. This ability can be used to prevent her from dying. These temporary hit points last for 1 minute. If the rogue's hit points drop below 0 due to the loss of these temporary hit points, she falls unconscious and is dying as normal.",
          1, "Ability"
      }, //
      {201, "Rogue Crawl",
          "While prone, a rogue with this ability can move at half speed. This movement provokes attacks of opportunity as normal. A rogue with this talent can take a 5-foot step while crawling.",
          1, "Ability"
      }, //
      {202, "Slow Reactions", "Opponents damaged by the rogue's sneak attack can't make attacks of opportunity for 1 round.", 1,
          "Ability"
      }, //
      {203, "Stand Up",
          "A rogue with this ability can stand up from a prone position as a free action. This still provokes attacks of opportunity for standing up while threatened by a foe.",
          1, "Ability"
      }, //
      {204, "Surprise Attack",
          "During the surprise round, opponents are always considered flat-footed to a rogue with this ability, even if they have already acted. ",
          1, "Ability"
      }, //
      {205, "Trap Spotter",
          "Whenever a rogue with this talent comes within 10 feet of a trap, she receives an immediate Perception skill check to notice the trap. This check should be made in secret by the GM.",
          1, "Ability"
      }, //
      {206, "Weapon Training - Rogue", "A rogue that selects this talent gains Weapon Focus as a bonus feat.", 1, "Ability"}, //
      {210, "Advanced Talents",
          "At 10th level, and every two levels thereafter, a rogue can choose one of the following advanced talents in place of a rogue talent.",
          0, "Ability"
      }, //
      {211, "Crippling Strike",
          "A rogue with this ability can sneak attack opponents with such precision that her blows weaken and hamper them. An opponent damaged by one of her sneak attacks also takes 2 points of Strength damage.",
          1, "Ability"
      }, //
      {212, "Defensive Roll",
          "With this advanced talent, the character can roll with a potentially lethal blow to take less damage from it than she otherwise would. Once per day, when she would be reduced to 0 or fewer hit points by damage in combat (from a weapon or other blow, not a spell or special ability), the character can attempt to roll with the damage. To use this ability, the character must attempt a Reflex saving throw (DC = damage dealt). If the save succeeds, she takes only half damage from the blow, if it fails, she takes full damage. She must be aware of the attack and able to react to it in order to execute her defensive roll-if she is denied her Dexterity bonus to AC, she can't use this ability. Since this effect would not normally allow a character to make a Reflex save for half damage, the character's evasion ability does not apply to the defensive roll.",
          1, "Ability"
      }, //
      {213, "Dispelling Attack",
          "Opponents that are dealt sneak attack damage by a rogue with this ability are affected by a targeted dispel magic, targeting the lowest-level spell effect active on the target. The caster level for this ability is equal to the rogue's level. A rogue must have the major magic rogue talent before choosing dispelling attack.",
          3, "Ability"
      }, //
      {215, "Opportunist",
          "Once per round, the rogue can make an attack of opportunity against an opponent who has just been struck for damage in melee by another character. This attack counts as an attack of opportunity for that round. Even a rogue with the Combat Reflexes feat can't use the opportunist ability more than once per round.",
          1, "Ability"
      }, //
      {216, "Skill Mastery",
          "The rogue becomes so confident in the use of certain skills that she can use them reliably even under adverse conditions.<br/>Upon gaining this ability, she selects a number of skills equal to 3 + her Intelligence modifier. When making a skill check with one of these skills, she may take 10 even if stress and distractions would normally prevent her from doing so. A rogue may gain this special ability multiple times, selecting additional skills for skill mastery to apply to each time.",
          1, "Ability"
      }, //
      {217, "Slippery Mind",
          "This ability represents the character's ability to wriggle free from magical effects that would otherwise control or compel her. If a character with slippery mind is affected by an enchantment spell or effect and fails her saving throw, she can attempt it again 1 round later at the same DC. She gets only this one extra chance to succeed on her saving throw.",
          1, "Ability"
      }, //
      {218, "Feat", "A rogue may gain any feat that she qualifies for in place of a rogue talent.", 0, "Ability"}, //
      {219, "Master Strike",
          "Upon reaching 20th level, a rogue becomes incredibly deadly when dealing sneak attack damage. Each time the rogue deals sneak attack damage, she can choose one of the following three effects: the target can be put to sleep for 1d4 hours, paralyzed for 2d6 rounds, or slain. Regardless of the effect chosen, the target receives a Fortitude save to negate the additional effect. The DC of this save is equal to 10 + 1/2 the rogue's level + the rogue's Intelligence modifier. Once a creature has been the target of a master strike, regardless of whether or not the save is made, that creature is immune to that rogue's master strike for 24 hours. Creatures that are immune to sneak attack damage are also immune to this ability.",
          1, "Ability"
      }, //
      {220, "Spells - Sorcerer",
          "A sorcerer casts arcane spells drawn primarily from the sorcerer/wizard spell list presented in Charisma score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a sorcerer's spell is 10 + the spell level + the sorcerer's Charisma modifier.<br/>Like other spellcasters, a sorcerer can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: Sorcerer. In addition, she receives bonus spells per day if she has a high Charisma score (see Table: Ability Modifiers and Bonus Spells).<br/>A sorcerer's selection of spells is extremely limited. A sorcerer begins play knowing four 0-level spells and two 1st-level spells of her choice. At each new sorcerer level, she gains one or more new spells, as indicated on Table: Sorcerer Spells Known. (Unlike spells per day, the number of spells a sorcerer knows is not affected by her Charisma score, the numbers on Table: Sorcerer Spells Known are fixed.) These new spells can be common spells chosen from the sorcerer/wizard spell list, or they can be unusual spells that the sorcerer has gained some understanding of through study. <br/>Upon reaching 4th level, and at every even-numbered sorcerer level after that (6th, 8th, and so on), a sorcerer can choose to learn a new spell in place of one she already knows. In effect, the sorcerer loses the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged. A sorcerer may swap only a single spell at any given level, and must choose whether or not to swap the spell at the same time that she gains new spells known for the level.<br/>Unlike a wizard or a cleric, a sorcerer need not prepare her spells in advance. She can cast any spell she knows at any time, assuming she has not yet used up her spells per day for that spell level.",
          0, "SpelllistAbility"
      }, //
      {221, "Bloodline",
          "Each sorcerer has a source of magic somewhere in her heritage that grants her spells, bonus feats, an additional class skill, and other special abilities. This source can represent a blood relation or an extreme event involving a creature somewhere in the family's past. For example, a sorcerer might have a dragon as a distant relative or her grandfather might have signed a terrible contract with a devil. Regardless of the source, this influence manifests in a number of ways as the sorcerer gains levels. A sorcerer must pick one bloodline upon taking her first level of sorcerer. Once made, this choice cannot be changed.<br/>At 3rd level, and every two levels thereafter, a sorcerer learns an additional spell, derived from her bloodline. These spells are in addition to the number of spells given on Table: Sorcerer Spells Known. These spells cannot be exchanged for different spells at higher levels.<br/>At 7th level, and every six levels thereafter, a sorcerer receives one bonus feat, chosen from a list specific to each bloodline. The sorcerer must meet the prerequisites for these bonus feats. ",
          0, "Ability"
      }, //
      {222, "Cantrips - Sorcerer",
          "Sorcerers learn a number of cantrips, or 0-level spells, as noted on Table: Sorcerer Spells Known under 'Spells Known.' These spells are cast like any other spell, but they do not consume any slots and may be used again.",
          0, "Ability"
      }, //
      {223, "Eschew Materials", "A sorcerer gains Eschew Materials as a bonus feat at 1st level.", 0, "Ability"}, //
      {224, "Aberrant Bloodline",
          "There is a taint in your blood, one that is alien and bizarre. You tend to think in odd ways, approaching problems from an angle that most would not expect. Over time, this taint manifests itself in your physical form.",
          0, "Ability"
      }, //
      {225, "Aberrant - Class Skill", "Knowledge (dungeoneering).", 0, "Ability"}, //
      {226, "Aberrant - Bonus Spells",
          "enlarge person (3rd), see invisibility (5th), tongues (7th), black tentacles (9th), feeblemind (11th), veil (13th), plane shift (15th), mind blank (17th), shapechange (19th).",
          0, "Ability"
      }, //
      {227, "Aberrant - Bonus Feats",
          "Combat Casting, Improved Disarm, Improved Grapple, Improved Initiative, Improved Unarmed Strike, Iron Will, Silent Spell, Skill Focus (Knowledge [dungeoneering]).",
          0, "Ability"
      }, //
      {228, "Aberrant - Bloodline Arcana",
          "Whenever you cast a spell of the polymorph subschool, increase the duration of the spell by 50% (minimum 1 round). This bonus does not stack with the increase granted by the Extend Spell feat.",
          0, "Ability"
      }, //
      {229, "Aberrant - Bloodline Powers",
          "Aberrant sorcerers show increasing signs of their tainted heritage as they increase in level, although they are only visible when used.",
          0, "Ability"
      }, //
      {230, "Aberrant - Acidic Ray",
          "Starting at 1st level, you can fire an acidic ray as a standard action, targeting any foe within 30 feet as a ranged touch attack. The acidic ray deals 1d6 points of acid damage + 1 for every two sorcerer levels you possess. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          2, "Ability"
      }, //
      {231, "Aberrant - Long Limbs",
          "At 3rd level, your reach increases by 5 feet whenever you are making a melee touch attack. This ability does not otherwise increase your threatened area. At 11th level, this bonus to your reach increases to 10 feet. At 17th level, this bonus to your reach increases to 15 feet.",
          1, "Ability"
      }, //
      {232, "Aberrant - Unusual Anatomy",
          "At 9th level, your anatomy changes, giving you a 25% chance to ignore any critical hit or sneak attack scored against you. This chance increases to 50% at 13th level.",
          1, "Ability"
      }, //
      {233, "Aberrant - Alien Resistance", "At 15th level, you gain spell resistance equal to your sorcerer level + 10.", 3,
          "Ability"
      }, //
      {234, "Aberrant - Form",
          "At 20th level, your body becomes truly unnatural. You are immune to critical hits and sneak attacks. In addition, you gain blindsight with a range of 60 feet and damage reduction 5/-.",
          1, "Ability"
      }, //
      {235, "Abyssal Bloodline",
          "Generations ago, a demon spread its filth into your heritage. While it does not manifest in all of your kin, for you it is particularly strong. You might sometimes have urges to chaos or evil, but your destiny (and alignment) is up to you.",
          0, "Ability"
      }, //
      {236, "Abyssal - Class Skill", "Knowledge (planes).", 0, "Ability"}, //
      {237, "Abyssal - Bonus Spells",
          "cause fear (3rd), bull's strength (5th), rage (7th), stoneskin (9th), dismissal (11th), transformation (13th), greater teleport (15th), unholy aura (17th), summon monster IX (19th).",
          0, "Ability"
      }, //
      {238, "Abyssal - Bonus Feats",
          "Augment Summoning, Cleave, Empower Spell, Great Fortitude, Improved Bull Rush, Improved Sunder, Power Attack, Skill Focus (Knowledge [planes]).",
          0, "Ability"
      }, //
      {239, "Abyssal - Bloodline Arcana",
          "Whenever you cast a spell of the summoning subschool, the creatures summoned gain DR/good equal to 1/2 your sorcerer level (minimum 1). This does not stack with any DR the creature might have.",
          0, "Ability"
      }, //
      {240, "Abyssal - Bloodline Powers",
          "While some would say that you are possessed, you know better. The demonic influence in your blood grows as you gain power.",
          0, "Ability"
      }, //
      {241, "Abyssal - Claws",
          "At 1st level, you can grow claws as a free action. These claws are treated as natural weapons, allowing you to make two claw attacks as a full attack action using your full base attack bonus. These attacks deal 1d4 points of damage each (1d3 if you are Small) plus your Strength modifier. At 5th level, these claws are considered magic weapons for the purpose of overcoming DR. At 7th level, the damage increases by one step to 1d6 points of damage (1d4 if you are Small). At 11th level, these claws become flaming weapons, each dealing an additional 1d6 points of fire damage on a successful hit. You can use your claws for a number of rounds per day equal to 3 + your Charisma modifier. These rounds do not need to be consecutive.",
          3, "Ability"
      }, //
      {242, "Abyssal - Demon Resistances",
          "At 3rd level, you gain resist electricity 5 and a +2 bonus on saving throws made against poison. At 9th level, your resistance to electricity increases to 10 and your bonus on poison saving throws increases to +4.",
          1, "Ability"
      }, //
      {243, "Abyssal - Strength of the Abyss",
          "At 9th level, you gain a +2 inherent bonus to your Strength. This bonus increases to +4 at 13th level, and to +6 at 17th level.",
          1, "Ability"
      }, //
      {244, "Abyssal - Added Summonings",
          "At 15th level, whenever you summon a creature with the demon subtype or the fiendish template using a summon monster spell, you summon one additional creature of the same kind.",
          3, "Ability"
      }, //
      {245, "Abyssal - Demonic Might",
          "At 20th level, the power of the Abyss flows through you. You gain immunity to electricity and poison. You also gain resistance to acid 10, cold 10, and fire 10, and gain telepathy with a range of 60 feet (allowing you to communicate with any creature that can speak a language).",
          3, "Ability"
      }, //
      {246, "Arcane Bloodline",
          "Your family has always been skilled in the eldritch art of magic. While many of your relatives were accomplished wizards, your powers developed without the need for study and practice.",
          0, "Ability"
      }, //
      {247, "Arcane - Class Skill", "Knowledge (any one).", 0, "Ability"}, //
      {248, "Arcane - Bonus Spells",
          "identify (3rd), invisibility (5th), dispel magic (7th), dimension door (9th), overland flight (11th), true seeing (13th), greater teleport (15th), power word stun (17th), wish (19th).",
          0, "Ability"
      }, //
      {249, "Arcane - Bonus Feats",
          "Combat Casting, Improved Counterspell, Improved Initiative, Iron Will, Scribe Scroll, Skill Focus (Knowledge [arcana]), Spell Focus, Still Spell.",
          0, "Ability"
      }, //
      {250, "Arcane - Bloodline Arcana",
          "Whenever you apply a metamagic feat to a spell that increases the slot used by at least one level, increase the spell's DC by +1. This bonus does not stack with itself and does not apply to spells modified by the Heighten Spell feat.",
          0, "Ability"
      }, //
      {251, "Arcane - Bloodline Powers",
          "Magic comes naturally to you, but as you gain levels you must take care to prevent the power from overwhelming you. ", 0,
          "Ability"
      }, //
      {252, "Arcane - Arcane Bond",
          "At 1st level, you gain an arcane bond, as a wizard equal to your sorcerer level. Your sorcerer levels stack with any wizard levels you possess when determining the powers of your familiar or bonded object. This ability does not allow you to have both a familiar and a bonded item. Once per day, your bond item allows you to cast any one of our spells known (unlike a wizard's bonded item, which allows him to cast any one spell in his spellbook).",
          3, "Ability"
      }, //
      {253, "Arcane - Metamagic Adept",
          "At 3rd level, you can apply any one metamagic feat you know to a spell you are about to cast without increasing the casting time. You must still expend a higher-level spell slot to cast this spell. You can use this ability once per day at 3rd level and one additional time per day for every four sorcerer levels you possess beyond 3rd, up to five times per day at 19th level. At 20th level, this ability is replaced by arcane apotheosis.",
          1, "Ability"
      }, //
      {254, "Arcane - New Arcana",
          "At 9th level, you can add any one spell from the sorcerer/wizard spell list to your list of spells known. This spell must be of a level that you are capable of casting. You can also add one additional spell at 13th level and 17th level.",
          1, "Ability"
      }, //
      {255, "Arcane - School Power",
          "At 15th level, pick one school of magic. The DC for any spells you cast from that school increases by +2. This bonus stacks with the bonus granted by Spell Focus.",
          1, "Ability"
      }, //
      {256, "Arcane - Arcane Apotheosis",
          "At 20th level, your body surges with arcane power. You can add any metamagic feats that you know to your spells without increasing their casting time, although you must still expend higher-level spell slots. Whenever you use magic items that require charges, you can instead expend spell slots to power the item. For every three levels of spell slots that you expend, you consume one less charge when using a magic item that expends charges.",
          1, "Ability"
      }, //
      {257, "Celestial Bloodline",
          "Your bloodline is blessed by a celestial power, either from a celestial ancestor or through divine intervention. Although this power drives you along the path of good, your fate (and alignment) is your own to determine.",
          0, "Ability"
      }, //
      {258, "Celestial - Class Skill", "Heal.", 0, "Ability"}, //
      {259, "Celestial - Bonus Spells",
          "bless (3rd), resist energy (5th), magic circle against evil (7th), remove curse (9th), flame strike (11th), greater dispel magic (13th), banishment (15th), sunburst (17th), gate (19th).",
          0, "Ability"
      }, //
      {260, "Celestial - Bonus Feats",
          "Dodge, Extend Spell, Iron Will, Mobility, Mounted Combat, Ride-By Attack, Skill Focus (Knowledge [religion]), Weapon Finesse.",
          0, "Ability"
      }, //
      {261, "Celestial - Bloodline Arcana",
          "Whenever you cast a spell of the summoning subschool, the creatures summoned gain DR/evil equal to 1/2 your sorcerer level (minimum 1). This does not stack with any DR the creature might have.",
          0, "Ability"
      }, //
      {262, "Celestial - Bloodline Powers",
          "Your celestial heritage grants you a great many powers, but they come at a price. The lords of the higher planes are watching you and your actions closely.",
          0, "Ability"
      }, //
      {263, "Celestial - Heavenly Fire",
          "Starting at 1st level, you can unleash a ray of heavenly fire as a standard action, targeting any foe within 30 feet as a ranged touch attack. Against evil creatures, this ray deals 1d4 points of damage + 1 for every two sorcerer levels you possess. This damage is divine and not subject to energy resistance or immunity. This ray heals good creatures of 1d4 points of damage + 1 for every two sorcerer levels you possess. A good creature cannot benefit from your heavenly fire more than once per day. Neutral creatures are neither harmed nor healed by this effect. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          2, "Ability"
      }, //
      {264, "Celestial - Celestial Resistances",
          "At 3rd level, you gain resist acid 5 and resist cold 5. At 9th level, your resistances increase to 10.", 1, "Ability"
      }, //
      {265, "Celestial - Wings of Heaven",
          "At 9th level, you can sprout feathery wings and fly for a number of minutes per day equal to your sorcerer level, with a speed of 60 feet and good maneuverability. This duration does not need to be consecutive, but it must be used in 1 minute increments. ",
          3, "Ability"
      }, //
      {266, "Celestial - Conviction",
          "At 15th level, you can reroll any one ability check, attack roll, skill check, or saving throw you just made. You must decide to use this ability after the die is rolled, but before the results are revealed by the GM. You must take the second result, even if it is worse. You can use this ability once per day.",
          3, "Ability"
      }, //
      {267, "Celestial - Ascension",
          "At 20th level, you become infused with the power of the heavens. You gain immunity to acid, cold, and petrification. You also gain resist electricity 10, resist fire 10, and a +4 racial bonus on saves against poison. Finally, you gain unlimited use of the wings of heaven ability. Finally, you gain the ability to speak with any creature that has a language (as per the tongues spell).",
          3, "Ability"
      }, //
      {268, "Destined Bloodline",
          "Your family is destined for greatness in some way. Your birth could have been foretold in prophecy, or perhaps it occurred during an especially auspicious event, such as a solar eclipse. Regardless of your bloodline's origin, you have a great future ahead.",
          0, "Ability"
      }, //
      {269, "Destined - Class Skill", "Knowledge (history).", 0, "Ability"}, //
      {270, "Destined - Bonus Spells",
          " alarm (3rd), blur (5th), protection from energy (7th), freedom of movement (9th), break enchantment (11th), mislead (13th), spell turning (15th), moment of prescience (17th), foresight (19th).",
          0, "Ability"
      }, //
      {271, "Destined - Bonus Feats",
          "Arcane Strike, Diehard, Endurance, Leadership, Lightning Reflexes, Maximize Spell, Skill Focus (Knowledge [history]), Weapon Focus.",
          0, "Ability"
      }, //
      {272, "Destined - Bloodline Arcana",
          "Whenever you cast a spell with a range of 'personal,' you gain a luck bonus equal to the spell's level on all your saving throws for 1 round.",
          0, "Ability"
      }, //
      {273, "Destined - Bloodline Powers", "You are destined for great things, and the powers that you gain serve to protect you.",
          0, "Ability"
      }, //
      {274, "Destined - Touch of Destiny",
          "At 1st level, you can touch a creature as a standard action, giving it an insight bonus on attack rolls, skill checks, ability checks, and saving throws equal to 1/2 your sorcerer level (minimum 1) for 1 round. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          2, "Ability"
      }, //
      {275, "Destined - Fated",
          "Starting at 3rd level, you gain a +1 luck bonus on all of your saving throws and to your AC during surprise rounds (see Combat) and when you are otherwise unaware of an attack. At 7th level and every four levels thereafter, this bonus increases by +1, to a maximum of +5 at 19th level.",
          3, "Ability"
      }, //
      {276, "Destined - It Was Meant To Be",
          "At 9th level, you may reroll any one attack roll, critical hit confirmation roll, or level check made to overcome spell resistance. You must decide to use this ability after the first roll is made but before the results are revealed by the GM. You must take the second result, even if it is worse. At 9th level, you can use this ability once per day. At 17th level, you can use this ability twice per day.",
          3, "Ability"
      }, //
      {277, "Destined - Within Reach",
          "At 15th level, your ultimate destiny is drawing near. Once per day, when an attack or spell that causes damage would result in your death, you may attempt a DC 20 Will save. If successful, you are instead reduced to -1 hit points and are automatically stabilized. The bonus from your fated ability applies to this save.",
          3, "Ability"
      }, //
      {278, "Destined - Destiny Realized",
          "At 20th level, your moment of destiny is at hand. Any critical threats made against you only confirm if the second roll results in a natural 20 on the die. Any critical threats you score with a spell are automatically confirmed. Once per day, you can automatically succeed at one caster level check made to overcome spell resistance. You must use this ability before making the roll.",
          3, "Ability"
      }, //
      {279, "Draconic Bloodline",
          "At some point in your family's history, a dragon interbred with your bloodline, and now its ancient power flows through your veins. ",
          0, "Ability"
      }, //
      {280, "Draconic - Class Skill", "Perception.", 0, "Ability"}, //
      {281, "Draconic - Bonus Spells",
          "mage armor (3rd), resist energy (5th), spell resistance (11th), form of the dragon I (13th), form of the dragon II (15th), form of the dragon III (17th), wish (19th).",
          0, "Ability"
      }, //
      {282, "Draconic - Bonus Feats",
          "Blind-Fight, Great Fortitude, Improved Initiative, Power Attack, Quicken Spell, Skill Focus (Fly), Skill Focus (Knowledge [arcana]), Toughness.",
          0, "Ability"
      }, //
      {283, "Draconic - Bloodline Arcana",
          "Whenever you cast a spell with an energy descriptor that matches your draconic bloodline's energy type, that spell deals +1 point of damage per die rolled.",
          0, "Ability"
      }, //
      {284, "Draconic - Bloodline Powers",
          "The power of dragons flows through you and manifests in a number of ways. At 1st level, you must select one of the chromatic or metallic dragon types. This choice cannot be changed. A number of your abilities grant resistances and deal damage based on your dragon type.",
          0, "Ability"
      }, //
      {285, "Draconic - Claws",
          "Starting at 1st level, you can grow claws as a free action. These claws are treated as natural weapons, allowing you to make two claw attacks as a full attack action using your full base attack bonus. Each of these attacks deals 1d4 points of damage plus your Strength modifier (1d3 if you are Small). At 5th level, these claws are considered magic weapons for the purpose of overcoming DR. At 7th level, the damage increases by one step to 1d6 points of damage (1d4 if you are Small). At 11th level, these claws deal an additional 1d6 points of damage of your energy type on a successful hit. You can use your claws for a number of rounds per day equal to 3 + your Charisma modifier. These rounds do not need to be consecutive.",
          3, "Ability"
      }, //
      {286, "Draconic - Dragon Resistances",
          "At 3rd level, you gain resist 5 against your energy type and a +1 natural armor bonus. At 9th level, your energy resistance increases to 10 and natural armor bonus increases to +2. At 15th level, your natural armor bonus increases to +4.",
          1, "Ability"
      }, //
      {287, "Draconic - Breath Weapon",
          "At 9th level, you gain a breath weapon. This breath weapon deals 1d6 points of damage of your energy type per sorcerer level. Those caught in the area of the breath receive a Reflex save for half damage. The DC of this save is equal to 10 + 1/2 your sorcerer level + your Charisma modifier. The shape of the breath weapon depends on your dragon type (as indicated on the above chart). At 9th level, you can use this ability once per day. At 17th level, you can use this ability twice per day. At 20th level, you can use this ability three times per day.",
          3, "Ability"
      }, //
      {288, "Draconic - Wings",
          "At 15th level, leathery dragon wings grow from your back as a standard action, giving you a fly speed of 60 feet with average maneuverability. You can dismiss the wings as a free action.",
          3, "Ability"
      }, //
      {289, "Draconic - Power of Wyrms",
          "At 20th level, your draconic heritage becomes manifest. You gain immunity to paralysis, sleep, and damage of your energy type. You also gain blindsense 60 feet.",
          3, "Ability"
      }, //
      {290, "Elemental Bloodline",
          "The power of the elements resides in you, and at times you can hardly control its fury. This influence comes from an elemental outsider in your family history or a time when you or your relatives were exposed to a powerful elemental force.",
          0, "Ability"
      }, //
      {291, "Elemental - Class Skill", "Knowledge (planes).", 0, "Ability"}, //
      {292, "Elemental - Bonus Spells",
          "burning hands* (3rd), scorching ray* (5th), protection from energy (7th), elemental body I (9th), elemental body II (11th), elemental body III (13th), elemental body IV (15th), summon monster VIII (elementals only) (17th), elemental swarm (19th).<br/>*These spells always deal a type of damage determined by your element. In addition, the subtype of these spells changes to match the energy type of your element.",
          0, "Ability"
      }, //
      {293, "Elemental - Bonus Feats",
          "Dodge, Empower Spell, Great Fortitude, Improved Initiative, Lightning Reflexes, Power Attack, Skill Focus (Knowledge [planes]), Weapon Finesse.",
          0, "Ability"
      }, //
      {294, "Elemental - Bloodline Arcana",
          "Whenever you cast a spell that deals energy damage, you can change the type of damage to match the type of your bloodline. This also changes the spell's type to match the type of your bloodline.",
          0, "Ability"
      }, //
      {295, "Elemental - Bloodline Powers",
          "One of the four elements infuses your being, and you can draw upon its power in times of need. At first level, you must select one of the four elements: air, earth, fire, or water. This choice cannot be changed. A number of your abilities grant resistances and deal damage based on your element.",
          0, "Ability"
      }, //
      {296, "Elemental - Elemental Ray",
          "Starting at 1st level, you can unleash an elemental ray as a standard action, targeting any foe within 30 feet as a ranged touch attack. This ray deals 1d6 points of damage of your energy type + 1 for every two sorcerer levels you possess. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          2, "Ability"
      }, //
      {297, "Elemental - Elemental Resistance",
          "At 3rd level, you gain energy resistance 10 against your energy type. At 9th level, your energy resistance increases to 20.",
          1, "Ability"
      }, //
      {298, "Elemental - Elemental Blast",
          "At 9th level, you can unleash a blast of elemental power once per day. This 20-foot-radius burst does 1d6 points of damage of your energy type per sorcerer level. Those caught in the area of your blast receive a Reflex save for half damage. Creatures that fail their saves gain vulnerability to your energy type until the end of your next turn. The DC of this save is equal to 10 + 1/2 your sorcerer level + your Charisma modifier. At 9th level, you can use this ability once per day. At 17th level, you can use this ability twice per day. At 20th level, you can use this ability three times per day. This power has a range of 60 feet.",
          2, "Ability"
      }, //
      {299, "Elemental - Elemental Movement",
          "At 15th level, you gain a special movement type or bonus. This ability is based on your chosen element, as indicated on the above chart.",
          3, "Ability"
      }, //
      {300, "Elemental - Elemental Body",
          "At 20th level, elemental power surges through your body. You gain immunity to sneak attacks, critical hits, and damage from your energy type.",
          3, "Ability"
      }, //
      {301, "Fey Bloodline",
          "The capricious nature of the fey runs in your family due to some intermingling of fey blood or magic. You are more emotional than most, prone to bouts of joy and rage.",
          0, "Ability"
      }, //
      {302, "Fey - Class Skill", "Knowledge (nature).", 0, "Ability"}, //
      {303, "Fey - Bonus Spells",
          "entangle (3rd), hideous laughter (5th), deep slumber (7th), poison (9th), tree stride (11th), mislead (13th), phase door (15th), irresistible dance (17th), shapechange (19th).",
          0, "Ability"
      }, //
      {304, "Fey - Bonus Feats",
          "Dodge, Improved Initiative, Lightning Reflexes, Mobility, Point Blank Shot, Precise Shot, Quicken Spell, Skill Focus (Knowledge [nature]).",
          0, "Ability"
      }, //
      {305, "Fey - Bloodline Arcana", "Whenever you cast a spell of the compulsion subschool, increase the spell's DC by +2.", 0,
          "Ability"
      }, //
      {306, "Fey - Bloodline Powers",
          "You have always had a tie to the natural world, and as your power increases, so does the influence of the fey over your magic.",
          0, "Ability"
      }, //
      {307, "Fey - Laughing Touch",
          "At 1st level, you can cause a creature to burst out laughing for 1 round as a melee touch attack. A laughing creature can only take a move action but can defend itself normally. Once a creature has been affected by laughing touch, it is immune to its effects for 24 hours. You can use this ability a number of times per day equal to 3 + your Charisma modifier. This is a mind-affecting effect.",
          2, "Ability"
      }, //
      {308, "Fey - Woodland Stride",
          "At 3rd level, you can move through any sort of undergrowth (such as natural thorns, briars, overgrown areas, and similar terrain) at your normal speed and without taking damage or suffering any other impairment. Thorns, briars, and overgrown areas that have been magically manipulated to impede motion, however, still affect you.",
          1, "Ability"
      }, //
      {309, "Fey - Fleeting Glance",
          "At 9th level, you can turn invisible for a number of rounds per day equal to your sorcerer level. This ability functions as greater invisibility. These rounds need not be consecutive.",
          2, "Ability"
      }, //
      {310, "Fey - Fey Magic",
          "At 15th level, you may reroll any caster level check made to overcome spell resistance. You must decide to use this ability before the results are revealed by the GM. You must take the second result, even if it is worse. You can use this ability at will.",
          3, "Ability"
      }, //
      {311, "Fey - Soul of the Fey",
          "At 20th level, your soul becomes one with the world of the fey. You gain immunity to poison and DR 10/cold iron. Creatures of the animal type do not attack you unless compelled to do so through magic. Once per day, you can cast shadow walk as a spell-like ability using your sorcerer level as your caster level.",
          3, "Ability"
      }, //
      {312, "Infernal Bloodline",
          "Somewhere in your family's history, a relative made a deal with a devil, and that pact has influenced your family line ever since. In you, it manifests in direct and obvious ways, granting you powers and abilities. While your fate is still your own, you can't help but wonder if your ultimate reward is bound to the Pit.",
          0, "Ability"
      }, //
      {313, "Infernal - Class Skill", "Diplomacy.", 0, "Ability"}, //
      {314, "Infernal - Bonus Spells",
          "protection from good (3rd), scorching ray (5th), suggestion (7th), charm monster (9th), dominate person (11th), planar binding (devils and creatures with the fiendish template only) (13th), greater teleport (15th), power word stun (17th), meteor swarm (19th).",
          0, "Ability"
      }, //
      {315, "Infernal - Bonus Feats",
          "Blind-Fight, Combat Expertise, Deceitful, Extend Spell, Improved Disarm, Iron Will, Skill Focus (Knowledge [planes]), Spell Penetration.",
          0, "Ability"
      }, //
      {316, "Infernal - Bloodline Arcana", "Whenever you cast a spell of the charm subschool, increase the spell's DC by +2.", 0,
          "Ability"
      }, //
      {317, "Infernal - Bloodline Powers",
          "You can draw upon the power of Hell, although you must be wary of its corrupting influence. Such power does not come without a price.",
          0, "Ability"
      }, //
      {318, "Infernal - Corrupting Touch",
          "At 1st level, you can cause a creature to become shaken as a melee touch attack. This effect persists for a number of rounds equal to 1/2 your sorcerer level (minimum 1). Creatures shaken by this ability radiate an aura of evil, as if they were an evil outsider (see detect evil). Multiple touches do not stack, but they do add to the duration. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          2, "Ability"
      }, //
      {319, "Infernal - Infernal Resistances",
          "At 3rd level, you gain resist fire 5 and a +2 bonus on saving throws made against poison. At 9th level, your resistance to fire increases to 10 and your bonus on poison saving throws increases to +4.",
          1, "Ability"
      }, //
      {320, "Infernal - Hellfire",
          "At 9th level, you can call down a column of hellfire. This 10-foot-radius burst does 1d6 points of fire damage per sorcerer level. Those caught in the area of your blast receive a Reflex save for half damage. Good creatures that fail their saves are shaken for a number of rounds equal to your sorcerer level. The DC of this save is equal to 10 + 1/2 your sorcerer level + your Charisma modifier. At 9th level, you can use this ability once per day. At 17th level, you can use this ability twice per day. At 20th level, you can use this ability three times per day. This power has a range of 60 feet.",
          2, "Ability"
      }, //
      {321, "Infernal - On Dark Wings",
          "At 15th level, you can grow fearsome bat wings as a standard action, giving you a fly speed of 60 feet with average maneuverability. The wings can be dismissed as a free action.",
          3, "Ability"
      }, //
      {322, "Infernal - Power of the Pit",
          "At 20th level, your form becomes infused with vile power. You gain immunity to fire and poison. You also gain resistance to acid 10 and cold 10, and the ability to see perfectly in darkness of any kind to a range of 60 feet.",
          3, "Ability"
      }, //
      {323, "Undead Bloodline",
          "The taint of the grave runs through your family. Perhaps one of your ancestors became a powerful lich or vampire, or maybe you were born dead before suddenly returning to life. Either way, the forces of death move through you and touch your every action.",
          0, "Ability"
      }, //
      {324, "Undead - Class Skill", "Knowledge (religion).", 0, "Ability"}, //
      {325, "Undead - Bonus Spells",
          "chill touch (3rd), false life (5th), vampiric touch (7th), animate dead (9th), waves of fatigue (11th), undeath to death (13th), finger of death (15th), horrid wilting (17th), energy drain (19th).",
          0, "Ability"
      }, //
      {326, "Undead - Bonus Feats",
          "Combat Casting, Diehard, Endurance, Iron Will, Skill Focus (Knowledge [religion]), Spell Focus, Still Spell, Toughness.",
          0, "Ability"
      }, //
      {327, "Undead - Bloodline Arcana",
          "Some undead are susceptible to your mind-affecting spells. Corporeal undead that were once humanoids are treated as humanoids for the purposes of determining which spells affect them.",
          0, "Ability"
      }, //
      {328, "Undead - Bloodline Powers",
          "You can call upon the foul powers of the afterlife. Unfortunately, the more you draw upon them, the closer you come to joining them.",
          0, "Ability"
      }, //
      {329, "Undead - Grave Touch",
          "Starting at 1st level, you can make a melee touch attack as a standard action that causes a living creature to become shaken for a number of rounds equal to 1/2 your sorcerer level (minimum 1). If you touch a shaken creature with this ability, it becomes frightened for 1 round if it has fewer Hit Dice than your sorcerer level. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          2, "Ability"
      }, //
      {330, "Undead - Death's Gift",
          "At 3rd level, you gain resist cold 5 and DR 5/- against nonlethal damage. At 9th level, your resistance to cold increases to 10 and your DR increases to 10/- against nonlethal damage.",
          3, "Ability"
      }, //
      {331, "Undead - Grasp of the Dead",
          "At 9th level, you can cause a swarm of skeletal arms to burst from the ground to rip and tear at your foes. The skeletal arms erupt from the ground in a 20-foot-radius burst. Anyone in this area takes 1d6 points of slashing damage per sorcerer level. Those caught in the area receive a Reflex save for half damage. Those who fail the save are unable to move for 1 round. The DC of this save is equal to 10 + 1/2 your sorcerer level + your Charisma modifier. The skeletal arms disappear after 1 round. The arms must burst up from a solid surface. At 9th level, you can use this ability once per day. At 17th level, you can use this ability twice per day. At 20th level, you can use this ability three times per day. This power has a range of 60 feet.",
          2, "Ability"
      }, //
      {332, "Undead - Incorporeal Form",
          "At 15th level, you can become incorporeal for 1 round per sorcerer level. While in this form, you gain the incorporeal subtype. You only take half damage from corporeal sources as long as they are magic (you take no damage from non-magic weapons and objects). Likewise, your spells deal only half damage to corporeal creatures. Spells and other effects that do not deal damage function normally. You can use this ability once per day.",
          2, "Ability"
      }, //
      {333, "Undead - One of Us",
          "At 20th level, your form begins to rot (the appearance of this decay is up to you) and undead see you as one of them. You gain immunity to cold, nonlethal damage, paralysis, and sleep. You also gain DR 5/-. Unintelligent undead do not notice you unless you attack them. You receive a +4 morale bonus on saving throws made against spells and spell-like abilities cast by undead.",
          1, "Ability"
      }, //
      {334, "Spells - Wizard",
          "A wizard casts arcane spells drawn from the sorcerer/wizard spell list presented in Spell Lists. A wizard must choose and prepare his spells ahead of time.<br/>To learn, prepare, or cast a spell, the wizard must have an Intelligence score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a wizard's spell is 10 + the spell level + the wizard's Intelligence modifier.<br/>A wizard can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: Wizard. In addition, he receives bonus spells per day if he has a high Intelligence score (see Table: Ability Modifiers and Bonus Spells).<br/>A wizard may know any number of spells. He must choose and prepare his spells ahead of time by getting 8 hours of sleep and spending 1 hour studying his spellbook. While studying, the wizard decides which spells to prepare.",
          0, "SpelllistAbility"
      }, //
      {335, "Bonus Languages - Wizard",
          "A wizard may substitute Draconic for one of the bonus languages available to the character because of his race.", 0,
          "Ability"
      }, //
      {336, "Arcane Bond",
          "At 1st level, wizards form a powerful bond with an object or a creature. This bond can take one of two forms: a familiar or a bonded object. A familiar is a magical pet that enhances the wizard's skills and senses and can aid him in magic, while a bonded object is an item a wizard can use to cast additional spells or to serve as a magical item. Once a wizard makes this choice, it is permanent and cannot be changed. Rules for bonded items are given below, while rules for familiars are at the end of this section.<br/>Wizards who select a bonded object begin play with one at no cost. Objects that are the subject of an arcane bond must fall into one of the following categories: amulet, ring, staff, wand, or weapon. These objects are always masterwork quality. Weapons acquired at 1st level are not made of any special material. If the object is an amulet or ring, it must be worn to have effect, while staves, wands, and weapons must be wielded. If a wizard attempts to cast a spell without his bonded object worn or in hand, he must make a concentration check or lose the spell. The DC for this check is equal to 20 + the spell's level. If the object is a ring or amulet, it occupies the ring or neck slot accordingly.<br/>A bonded object can be used once per day to cast any one spell that the wizard has in his spellbook and is capable of casting, even if the spell is not prepared. This spell is treated like any other spell cast by the wizard, including casting time, duration, and other effects dependent on the wizard's level. This spell cannot be modified by metamagic feats or other abilities. The bonded object cannot be used to cast spells from the wizard's opposition schools (see arcane school).<br/>A wizard can add additional magic abilities to his bonded object as if he has the required item creation feats and if he meets the level prerequisites of the feat. For example, a wizard with a bonded dagger must be at least 5th level to add magic abilities to the dagger (see the Craft Magic Arms and Armor feat in Feats). If the bonded object is a wand, it loses its wand abilities when its last charge is consumed, but it is not destroyed and it retains all of its bonded object properties and can be used to craft a new wand. The magic properties of a bonded object, including any magic abilities added to the object, only function for the wizard who owns it. If a bonded object's owner dies, or the item is replaced, the object reverts to being an ordinary masterwork item of the appropriate type.<br/>If a bonded object is damaged, it is restored to full hit points the next time the wizard prepares his spells. If the object of an arcane bond is lost or destroyed, it can be replaced after 1 week in a special ritual that costs 200 gp per wizard level plus the cost of the masterwork item. This ritual takes 8 hours to complete. Items replaced in this way do not possess any of the additional enchantments of the previous bonded item. A wizard can designate an existing magic item as his bonded item. This functions in the same way as replacing a lost or destroyed item except that the new magic item retains its abilities while gaining the benefits and drawbacks of becoming a bonded item.",
          1, "Ability"
      }, //
      {337, "Arcane School",
          "A wizard can choose to specialize in one school of magic, gaining additional spells and powers based on that school. This choice must be made at 1st level, and once made, it cannot be changed. A wizard that does not select a school receives the universalist school instead.<br/>A wizard that chooses to specialize in one school of magic must select two other schools as his opposition schools, representing knowledge sacrificed in one area of arcane lore to gain mastery in another. A wizard who prepares spells from his opposition schools must use two spell slots of that level to prepare the spell. For example, a wizard with evocation as an opposition school must expend two of his available 3rd-level spell slots to prepare a fireball. In addition, a specialist takes a -4 penalty on any skill checks made when crafting a magic item that has a spell from one of his opposition schools as a prerequisite. A universalist wizard can prepare spells from any school without restriction.<br/>Each arcane school gives the wizard a number of school powers. In addition, specialist wizards receive an additional spell slot of each spell level he can cast, from 1st on up. Each day, a wizard can prepare a spell from his specialty school in that slot. This spell must be in the wizard's spellbook. A wizard can select a spell modified by a metamagic feat to prepare in his school slot, but it uses up a higher-level spell slot. Wizards with the universalist school do not receive a school slot.",
          0, "Ability"
      }, //
      {338, "Cantrips - Wizard",
          "Wizards can prepare a number of cantrips, or 0-level spells, each day, as noted on Table: Wizard under 'Spells per Day.' These spells are cast like any other spell, but they are not expended when cast and may be used again. A wizard can prepare a cantrip from a prohibited school, but it uses up two of his available slots (see below).",
          0, "Ability"
      }, //
      {339, "Scribe Scroll", "At 1st level, a wizard gains Scribe Scroll as a bonus feat. ", 0, "Ability"}, //
      {340, "Bonus Feats - Wizard",
          "At 5th, 10th, 15th, and 20th level, a wizard gains a bonus feat. At each such opportunity, he can choose a metamagic feat, an item creation feat, or Spell Mastery. The wizard must still meet all prerequisites for a bonus feat, including caster level minimums. These bonus feats are in addition to the feats that a character of any class gets from advancing levels. The wizard is not limited to the categories of item creation feats, metamagic feats, or Spell Mastery when choosing those feats.",
          0, "Ability"
      }, //
      {341, "Spellbooks",
          "A wizard must study his spellbook each day to prepare his spells. He cannot prepare any spell not recorded in his spellbook, except for read magic, which all wizards can prepare from memory.<br/>A wizard begins play with a spellbook containing all 0-level wizard spells (except those from his prohibited schools, if any, see Arcane Schools) plus three 1st-level spells of his choice. The wizard also selects a number of additional 1st-level spells equal to his Intelligence modifier to add to the spellbook. At each new wizard level, he gains two new spells of any spell level or levels that he can cast (based on his new wizard level) for his spellbook. At any time, a wizard can also add spells found in other wizards' spellbooks to his own (see Magic).",
          0, "Ability"
      }, //
      {342, "Abjuration School", "The abjurer uses magic against itself, and masters the art of defensive and warding magics.", 0,
          "SpelllistAbility"
      }, //
      {343, "Abjuration - Resistance",
          "You gain resistance 5 to an energy type of your choice, chosen when you prepare spells. This resistance can be changed each day. At 11th level, this resistance increases to 10. At 20th level, this resistance changes to immunity to the chosen energy type.",
          1, "Ability"
      }, //
      {344, "Abjuration - Protective Ward",
          "As a standard action, you can create a 10-foot-radius field of protective magic centered on you that lasts for a number of rounds equal to your Intelligence modifier. All allies in this area (including you) receive a +1 deflection bonus to their AC. This bonus increases by +1 for every five wizard levels you possess. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          3, "Ability"
      }, //
      {345, "Abjuration - Energy Absorption",
          "At 6th level, you gain an amount of energy absorption equal to 3 times your wizard level per day. Whenever you take energy damage, apply immunity, vulnerability (if any), and resistance first and apply the rest to this absorption, reducing your daily total by that amount. Any damage in excess of your absorption is applied to you normally.",
          3, "Ability"
      }, //
      {346, "Conjuration School", "The conjurer focuses on the study of summoning monsters and magic alike to bend to his will.", 0,
          "SpelllistAbility"
      }, //
      {347, "Conjuration - Summoner's Charm",
          "Whenever you cast a conjuration (summoning) spell, increase the duration by a number of rounds equal to 1/2 your wizard level (minimum 1). At 20th level, you can change the duration of all summon monster spells to permanent. You can have no more than one summon monster spell made permanent in this way at one time. If you designate another summon monster spell as permanent, the previous spell immediately ends.",
          3, "Ability"
      }, //
      {348, "Conjuration - Acid Dart",
          "As a standard action you can unleash an acid dart targeting any foe within 30 feet as a ranged touch attack. The acid dart deals 1d6 points of acid damage + 1 for every two wizard levels you possess. You can use this ability a number of times per day equal to 3 + your Intelligence modifier. This attack ignores spell resistance.",
          2, "Ability"
      }, //
      {349, "Conjuration - Dimensional Steps",
          "At 8th level, you can use this ability to teleport up to 30 feet per wizard level per day as a standard action. This teleportation must be used in 5-foot increments and such movement does not provoke an attack of opportunity. You can bring other willing creatures with you, but you must expend an equal amount of distance for each additional creature brought with you.",
          2, "Ability"
      }, //
      {350, "Divination School", "Diviners are masters of remote viewing, prophecies, and using magic to explore the world.", 0,
          "SpelllistAbility"
      }, //
      {351, "Divination - Forewarned",
          "You can always act in the surprise round even if you fail to make a Perception roll to notice a foe, but you are still considered flat-footed until you take an action. In addition, you receive a bonus on initiative checks equal to 1/2 your wizard level (minimum +1). At 20th level, anytime you roll initiative, assume the roll resulted in a natural 20.",
          3, "Ability"
      }, //
      {352, "Divination - Diviner's Fortune",
          "When you activate this school power, you can touch any creature as a standard action to give it an insight bonus on all of its attack rolls, skill checks, ability checks, and saving throws equal to 1/2 your wizard level (minimum +1) for 1 round. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          2, "Ability"
      }, //
      {353, "Divination - Scrying Adept",
          "At 8th level, you are always aware when you are being observed via magic, as if you had a permanent detect scrying. In addition, whenever you scry on a subject, treat the subject as one step more familiar to you. Very familiar subjects get a -10 penalty on their save to avoid your scrying attempts.",
          3, "Ability"
      }, //
      {354, "Enchantment School", "The enchanter uses magic to control and manipulate the minds of his victims.", 0,
          "SpelllistAbility"
      }, //
      {355, "Enchantment - Enchanting Smile",
          "You gain a +2 enhancement bonus on Bluff, Diplomacy, and Intimidate skill checks. This bonus increases by +1 for every five wizard levels you possess, up to a maximum of +6 at 20th level. At 20th level, whenever you succeed at a saving throw against a spell of the enchantment school, that spell is reflected back at its caster, as per spell turning.",
          3, "Ability"
      }, //
      {356, "Enchantment - Dazing Touch",
          "You can cause a living creature to become dazed for 1 round as a melee touch attack. Creatures with more Hit Dice than your wizard level are unaffected. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          2, "Ability"
      }, //
      {357, "Enchantment - Aura of Despair",
          "At 8th level, you can emit a 30-foot aura of despair for a number of rounds per day equal to your wizard level. Enemies within this aura take a -2 penalty on ability checks, attack rolls, damage rolls, saving throws, and skill checks. These rounds do not need to be consecutive. This is a mind-affecting effect.",
          3, "Ability"
      }, //
      {358, "Evocation School", "Evokers revel in the raw power of magic, and can use it to create and destroy with shocking ease.",
          0, "SpelllistAbility"
      }, //
      {359, "Evocation - Intense Spells",
          "Whenever you cast an evocation spell that deals hit point damage, add 1/2 your wizard level to the damage (minimum +1). This bonus only applies once to a spell, not once per missile or ray, and cannot be split between multiple missiles or rays. This bonus damage is not increased by Empower Spell or similar effects. This damage is of the same type as the spell. At 20th level, whenever you cast an evocation spell you can roll twice to penetrate a creature's spell resistance and take the better result.",
          3, "Ability"
      }, //
      {360, "Evocation - Force Missile",
          "As a standard action you can unleash a force missile that automatically strikes a foe, as magic missile. The force missile deals 1d4 points of damage plus the damage from your intense spells evocation power. This is a force effect. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          2, "Ability"
      }, //
      {361, "Evocation - Elemental Wall",
          "At 8th level, you can create a wall of energy that lasts for a number of rounds per day equal to your wizard level. These rounds do not need to be consecutive. This wall deals acid, cold, electricity, or fire damage, determined when you create it. The elemental wall otherwise functions like wall of fire.",
          2, "Ability"
      }, //
      {362, "Illusion School",
          "Illusionists use magic to weave confounding images, figments, and phantoms to baffle and vex their foes.", 0,
          "SpelllistAbility"
      }, //
      {363, "Illusion - Extended Illusions",
          "Any illusion spell you cast with a duration of 'concentration' lasts a number of additional rounds equal to 1/2 your wizard level after you stop maintaining concentration (minimum +1 round). At 20th level, you can make one illusion spell with a duration of 'concentration' become permanent. You can have no more than one illusion made permanent in this way at one time. If you designate another illusion as permanent, the previous permanent illusion ends. ",
          3, "Ability"
      }, //
      {364, "Illusion - Blinding Ray",
          "As a standard action you can fire a shimmering ray at any foe within 30 feet as a ranged touch attack. The ray causes creatures to be blinded for 1 round. Creatures with more Hit Dice than your wizard level are dazzled for 1 round instead. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          2, "Ability"
      }, //
      {365, "Illusion - Invisibility Field",
          "At 8th level, you can make yourself invisible as a swift action for a number of rounds per day equal to your wizard level. These rounds do not need to be consecutive. This otherwise functions as greater invisibility.",
          2, "Ability"
      }, //
      {366, "Necromancy School",
          "The dread and feared necromancer commands undead and uses the foul power of unlife against his enemies.", 0,
          "SpelllistAbility"
      }, //
      {367, "Necromancy - Power over Undead",
          "You receive Command Undead or Turn Undead as a bonus feat. You can channel energy a number of times per day equal to 3 + your Intelligence modifier, but only to use the selected feat. You can take other feats to add to this ability, such as Extra Channel and Improved Channel, but not feats that alter this ability, such as Elemental Channel and Alignment Channel. The DC to save against these feats is equal to 10 + 1/2 your wizard level + your Charisma modifier. At 20th level, undead cannot add their channel resistance to the save against this ability.",
          3, "Ability"
      }, //
      {368, "Necromancy - Grave Touch",
          "As a standard action, you can make a melee touch attack that causes a living creature to become shaken for a number of rounds equal to 1/2 your wizard level (minimum 1). If you touch a shaken creature with this ability, it becomes frightened for 1 round if it has fewer Hit Dice than your wizard level. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          2, "Ability"
      }, //
      {369, "Necromancy - Life Sight",
          "At 8th level, you gain blindsight to a range of 10 feet for a number of rounds per day equal to your wizard level. This ability only allows you to detect living creatures and undead creatures. This sight also tells you whether a creature is living or undead. Constructs and other creatures that are neither living nor undead cannot be seen with this ability. The range of this ability increases by 10 feet at 12th level, and by an additional 10 feet for every four levels beyond 12th. These rounds do not need to be consecutive.",
          3, "Ability"
      }, //
      {370, "Transmutation School", "Transmuters use magic to change the world around them.", 0, "SpelllistAbility"}, //
      {371, "Transmutation - Physical Enhancement",
          "You gain a +1 enhancement bonus to one physical ability score (Strength, Dexterity, or Constitution). This bonus increases by +1 for every five wizard levels you possess to a maximum of +5 at 20th level. You can change this bonus to a new ability score when you prepare spells. At 20th level, this bonus applies to two physical ability scores of your choice.",
          3, "Ability"
      }, //
      {372, "Transmutation - Telekinetic Fist",
          "As a standard action you can strike with a telekinetic fist, targeting any foe within 30 feet as a ranged touch attack. The telekinetic fist deals 1d4 points of bludgeoning damage + 1 for every two wizard levels you possess. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          2, "Ability"
      }, //
      {373, "Transmutation - Change Shape",
          "At 8th level, you can change your shape for a number of rounds per day equal to your wizard level. These rounds do not need to be consecutive. This ability otherwise functions like beast shape II or elemental body I. At 12th level, this ability functions like beast shape III or elemental body II.",
          2, "Ability"
      }, //
      {374, "Universalist School",
          "Wizards who do not specialize (known as as universalists) have the most diversity of all arcane spellcasters.", 0,
          "SpelllistAbility"
      }, //
      {375, "Universalist - Hand of the Apprentice",
          "You cause your melee weapon to fly from your grasp and strike a foe before instantly returning to you. As a standard action, you can make a single attack using a melee weapon at a range of 30 feet. This attack is treated as a ranged attack with a thrown weapon, except that you add your Intelligence modifier on the attack roll instead of your Dexterity modifier (damage still relies on Strength). This ability cannot be used to perform a combat maneuver. You can use this ability a number of times per day equal to 3 + your Intelligence modifier.",
          3, "Ability"
      }, //
      {376, "Universalist - Metamagic Mastery",
          "At 8th level, you can apply any one metamagic feat that you know to a spell you are about to cast. This does not alter the level of the spell or the casting time. You can use this ability once per day at 8th level and one additional time per day for every two wizard levels you possess beyond 8th. Any time you use this ability to apply a metamagic feat that increases the spell level by more than 1, you must use an additional daily usage for each level above 1 that the feat adds to the spell. Even though this ability does not modify the spell's actual level, you cannot use this ability to cast a spell whose modified spell level would be above the level of the highest-level spell that you are capable of casting.",
          3, "Ability"
      }, //
      {377, "Arcane Spells and Armor",
          "Armor restricts the complicated gestures required while casting any spell that has a somatic component. The armor and shield descriptions list the arcane spell failure chance for different armors and shields.<br/>If a spell doesn't have a somatic component, an arcane spellcaster can cast it with no arcane spell failure chance while wearing armor. Such spells can also be cast even if the caster's hands are bound or he is grappling (although concentration checks still apply normally). The metamagic feat Still Spell allows a spellcaster to prepare or cast a spell without the somatic component at one spell level higher than normal. This also provides a way to cast a spell while wearing armor without risking arcane spell failure.",
          0, "Ability"
      }, //
      {378, "Spells per Day - Arcane Archer",
          "At the indicated levels, an arcane archer gains new spells per day as if he had also gained a level in an arcane spellcasting class he belonged to before adding the prestige class. He does not, however, gain other benefits a character of that class would have gained, except for additional spells per day, spells known (if he is a spontaneous spellcaster), and an increased effective level of spellcasting. If a character had more than one arcane spellcasting class before becoming an arcane archer, he must decide to which class he adds the new level for purposes of determining spells per day.",
          0, "Ability"
      }, //
      {379, "Enhance Arrows",
          "At 1st level, every nonmagical arrow an arcane archer nocks and lets fly becomes magical, gaining a +1 enhancement bonus. Unlike magic weapons created by normal means, the archer need not spend gold pieces to accomplish this task. However, an archer's magic arrows only function for him. <br/>In addition, the arcane archer's arrows gain a number of additional qualities as he gains additional levels. The elemental, elemental burst, and aligned qualities can be changed once per day, when the arcane archer prepares spells or, in the case of spontaneous spellcasters, after 8 hours of rest. <br/>At 3rd level, every nonmagical arrow fired by an arcane archer gains one of the following elemental themed weapon qualities: flaming, frost, or shock. <br/>At 5th level, every nonmagical arrow fired by an arcane archer gains the distance weapon quality.<br/>At 7th level, every nonmagical arrow fired by an arcane archer gains one of the following elemental burst weapon qualities: flaming burst, icy burst, or shocking burst. This ability replaces the ability gained at 3rd level.<br/>At 9th level, every nonmagical arrow fired by an arcane archer gains one of the following aligned weapon qualities: anarchic, axiomatic, holy, or unholy. The arcane archer cannot choose an ability that is the opposite of his alignment (for example, a lawful good arcane archer could not choose anarchic or unholy as his weapon quality).<br/>The bonuses granted by a magic bow apply as normal to arrows that have been enhanced with this ability. Only the larger enhancement bonus applies. Duplicate abilities do not stack.",
          3, "Ability"
      }, //
      {380, "Imbue Arrow",
          "At 2nd level, an arcane archer gains the ability to place an area spell upon an arrow. When the arrow is fired, the spell's area is centered where the arrow lands, even if the spell could normally be centered only on the caster. This ability allows the archer to use the bow's range rather than the spell's range. A spell cast in this way uses its standard casting time and the arcane archer can fire the arrow as part of the casting. The arrow must be fired during the round that the casting is completed or the spell is wasted. If the arrow misses, the spell is wasted.",
          2, "Ability"
      }, //
      {381, "Seeker Arrow",
          "At 4th level, an arcane archer can launch an arrow at a target known to him within range, and the arrow travels to the target, even around corners. Only an unavoidable obstacle or the limit of the arrow's range prevents the arrow's flight. This ability negates cover and concealment modifiers, but otherwise the attack is rolled normally. Using this ability is a standard action (and shooting the arrow is part of the action). An arcane archer can use this ability once per day at 4th level, and one additional time per day for every two levels beyond 4th, to a maximum of four times per day at 10th level.",
          2, "Ability"
      }, //
      {382, "Phase Arrow",
          "At 6th level, an arcane archer can launch an arrow once per day at a target known to him within range, and the arrow travels to the target in a straight path, passing through any nonmagical barrier or wall in its way. (Any magical barrier stops the arrow.) This ability negates cover, concealment, armor, and shield modifiers, but otherwise the attack is rolled normally. Using this ability is a standard action (and shooting the arrow is part of the action). An arcane archer can use this ability once per day at 6th level, and one additional time per day for every two levels beyond 6th, to a maximum of three times per day at 10th level.",
          2, "Ability"
      }, //
      {383, "Hail of Arrows",
          "In lieu of his regular attacks, once per day an arcane archer of 8th level or higher can fire an arrow at each and every target within range, to a maximum of one target for every arcane archer level she has earned. Each attack uses the archer's primary attack bonus, and each enemy may only be targeted by a single arrow.",
          2, "Ability"
      }, //
      {384, "Arrow of Death",
          "At 10th level, an arcane archer can create a special type of slaying arrow that forces the target, if damaged by the arrow's attack, to make a Fortitude save or be slain immediately. The DC of this save is equal to 20 + the arcane archer's Charisma modifier. It takes 1 day to make a slaying arrow, and the arrow only functions for the arcane archer who created it. The slaying arrow lasts no longer than 1 year, and the archer can only have one such arrow in existence at a time.",
          2, "Ability"
      }, //
      {385, "Spells per Day - Arcane Trickster",
          "When a new arcane trickster level is gained, the character gains new spells per day as if she had also gained a level in a spellcasting class she belonged to before adding the prestige class. She does not, however, gain other benefits a character of that class would have gained, except for additional spells per day, spells known (if she is a spontaneous spellcaster), and an increased effective level of spellcasting. If a character had more than one spellcasting class before becoming an arcane trickster, she must decide to which class she adds the new level for purposes of determining spells per day.",
          0, "Ability"
      }, //
      {386, "Ranged Legerdemain",
          "An arcane trickster can use Disable Device and Sleight of Hand at a range of 30 feet. Working at a distance increases the normal skill check DC by 5, and an arcane trickster cannot take 10 on this check. Any object to be manipulated must weigh 5 pounds or less. She can only use this ability if she has at least 1 rank in the skill being used.",
          3, "Ability"
      }, //
      {387, "Sneak Attack - Arcane Trickster",
          "This is exactly like the rogue ability of the same name. The extra damage dealt increases by +1d6 every other level (2nd, 4th, 6th, 8th, and 10th). If an arcane trickster gets a sneak attack bonus from another source, the bonuses on damage stack.",
          0, "Ability"
      }, //
      {388, "Impromptu Sneak Attack",
          "Beginning at 3rd level, once per day an arcane trickster can declare one melee or ranged attack she makes to be a sneak attack (the target can be no more than 30 feet distant if the impromptu sneak attack is a ranged attack). The target of an impromptu sneak attack loses any Dexterity bonus to AC, but only against that attack. The power can be used against any target, but creatures that are not subject to critical hits take no extra damage (though they still lose any Dexterity bonus to AC against the attack).<br/>At 7th level, an arcane trickster can use this ability twice per day.",
          1, "Ability"
      }, //
      {389, "Tricky Spells",
          "Starting at 5th level, an arcane trickster can cast her spells without their somatic or verbal components, as if using the Still Spell and Silent Spell feats. Spells cast using this ability do not increase in spell level or casting time. She can use this ability 3 times per day at 5th level and one additional time per every two levels thereafter, to a maximum of 5 times per day at 9th level. The arcane trickster decides to use this ability at the time of casting.",
          3, "Ability"
      }, //
      {390, "Invisible Thief",
          "At 9th level, an arcane trickster can become invisible, as if under the effects of greater invisibility, as a free action. She can remain invisible for a number of rounds per day equal to her arcane trickster level. Her caster level for this effect is equal to her caster level. These rounds need not be consecutive.",
          3, "Ability"
      }, //
      {391, "Surprise Spells",
          "At 10th level, an arcane trickster can add her sneak attack damage to any spell that deals damage, if the targets are flat-footed. This additional damage only applies to spells that deal hit point damage, and the additional damage is of the same type as the spell. If the spell allows a saving throw to negate or halve the damage, it also negates or halves the sneak attack damage.",
          0, "Ability"
      }, //
      {392, "Sneak Attack - Assassin",
          "This is exactly like the rogue ability of the same name. The extra damage dealt increases by +1d6 every other level (1st, 3rd, 5th, 7th, and 9th). If an assassin gets a sneak attack bonus from another source, the bonuses on damage stack.",
          0, "Ability"
      }, //
      {393, "Death Attack",
          "If an assassin studies his victim for 3 rounds and then makes a sneak attack with a melee weapon that successfully deals damage, the sneak attack has the additional effect of possibly either paralyzing or killing the target (assassin's choice). Studying the victim is a standard action. The death attack fails if the target detects the assassin or recognizes the assassin as an enemy (although the attack might still be a sneak attack if the target is denied his Dexterity bonus to his Armor Class or is flanked). If the victim of such a death attack fails a Fortitude save (DC 10 + the assassin's class level + the assassin's Int modifier) against the kill effect, she dies. If the saving throw fails against the paralysis effect, the victim is rendered helpless and unable to act for 1d6 rounds plus 1 round per level of the assassin. If the victim's saving throw succeeds, the attack is just a normal sneak attack. Once the assassin has completed the 3 rounds of study, he must make the death attack within the next 3 rounds.<br/>If a death attack is attempted and fails (the victim makes her save) or if the assassin does not launch the attack within 3 rounds of completing the study, 3 new rounds of study are required before he can attempt another death attack.",
          1, "Ability"
      }, //
      {394, "Poison Use",
          "Assassins are trained in the use of poison and cannot accidentally poison themselves when applying poison to a blade (see Poison).",
          0, "Ability"
      }, //
      {395, "Save Bonus against Poison",
          "At 2nd level, the assassin gains a +1 saving throw bonus against poisons. This bonus increase by +1 every two levels.",
          0, "Ability"
      }, //
      {397, "Hidden Weapons",
          "At 4th level, an assassin becomes a master at hiding weapons on his body. He adds his assassin level to all Sleight of Hand skill checks made to prevent others from noticing them.",
          1, "Ability"
      }, //
      {398, "True Death",
          "Starting at 4th level, anyone slain by an assassin's death attack becomes more difficult to bring back from the dead. Spellcasters attempting to bring a creature back from the dead using raise dead or similar magic must make a caster level check with a DC equal to 15 + the assassin's level or the spell fails and the material component is wasted. Casting remove curse the round before attempting to bring the creature back from the dead negates this chance. The DC of the remove curse is 10 + the assassin's level.",
          3, "Ability"
      }, //
      {400, "Quiet Death",
          "At 6th level, whenever an assassin kills a creature using his death attack during a surprise round, he can also make a Stealth check, opposed by Perception checks of those in the vicinity to prevent them from identifying him as the assailant. If successful, those nearby might not even notice that the target is dead for a few moments, allowing the assassin to avoid detection. ",
          1, "Ability"
      }, //
      {401, "Hide in Plain Sight - Shadow",
          "A character can use the Stealth skill even while being observed. As long as she is within 10 feet of an area of dim light, a character can hide herself from view in the open without anything to actually hide behind. She cannot, however, hide in her own shadow.",
          3, "Ability"
      }, //
      {402, "Swift Death",
          "At 9th level, once per day, an assassin can make a death attack against a foe without studying the foe beforehand. He must still sneak attack his foe using a melee weapon that deals damage.",
          1, "Ability"
      }, //
      {403, "Angel of Death",
          "At 10th level, the assassin becomes a master of death. Once per day, when the assassin makes a successful death attack, he can cause the target's body to crumble to dust. This prevents raise dead and resurrection (although true resurrection works as normal). The assassin must declare the use of this ability before the attack is made. If the attack misses or the target successfully saves against the death attack, this ability is wasted with no effect.",
          3, "Ability"
      }, //
      {404, "Spells per Day - Dragon Disciple",
          "At the indicated levels, a dragon disciple gains new spells per day as if he had also gained a level in an arcane spellcasting class he belonged to before adding the prestige class. He does not, however, gain other benefits a character of that class would have gained, except for additional spells per day, spells known (if he is a spontaneous spellcaster), and an increased effective level of spellcasting. If a character had more than one arcane spellcasting class before becoming a dragon disciple, he must decide to which class he adds the new level for purposes of determining spells per day.",
          0, "Ability"
      }, //
      {405, "Blood of Dragons",
          "A dragon disciple adds his level to his sorcerer levels when determining the powers gained from his bloodline. If the dragon disciple does not have levels of sorcerer, he instead gains bloodline powers of the draconic bloodline, using his dragon disciple level as his sorcerer level to determine the bonuses gained. He must choose a dragon type upon gaining his first level in this class and that type must be the same as his sorcerer type. This ability does not grant bonus spells to a sorcerer unless he possesses spell slots of an appropriate level. Such bonus spells are automatically granted if the sorcerer gains spell slots of the spell's level.",
          0, "Ability"
      }, //
      {406, "Natural Armor Increase",
          "As his skin thickens, a dragon disciple takes on more and more of his progenitor's physical aspect. At 1st, 4th, and 7th level, a dragon disciple gains an increase to the character's existing natural armor (if any), as indicated on Table: Dragon Disciple. These armor bonuses stack. ",
          1, "Ability"
      }, //
      {407, "Ability Boost",
          "As a dragon disciple gains levels in this prestige class, his ability scores increase as noted on Table: Dragon Disciple. These increases stack and are gained as if through level advancement.",
          1, "Ability"
      }, //
      {408, "Bloodline Feat",
          "Upon reaching 2nd level, and every three levels thereafter, a dragon disciple receives one bonus feat, chosen from the draconic bloodline's bonus feat list.",
          1, "Ability"
      }, //
      {409, "Dragon Bite",
          "At 2nd level, whenever the dragon disciple uses his bloodline to grow claws, he also gains a bite attack. This is a primary natural attack that deals 1d6 points of damage (1d4 if the dragon disciple is Small), plus 1-1/2 times the dragon disciple's Strength modifier. Upon reaching 6th level, this bite also deals 1d6 points of energy damage. The type of damage dealt is determined by the dragon disciple's bloodline.",
          1, "Ability"
      }, //
      {410, "Breath Weapon",
          "At 3rd level, a dragon disciple gains the breath weapon bloodline power, even if his level does not yet grant that power. Once his level is high enough to grant this ability through the bloodline, the dragon disciple gains an additional use of his breath weapon each day. The type and shape of the breath weapon depends on the type of dragon selected by the dragon disciple, as detailed under the Draconic sorcerer bloodline description. ",
          3, "Ability"
      }, //
      {411, "Blindsense",
          "At 5th level, the dragon disciple gains line of effect to that creature.<br/>Any opponent the dragon disciple cannot see still has total concealment against him, and the dragon disciple still has the normal miss chance when attacking foes that have concealment. Visibility still affects the movement of a creature with blindsense. A creature with blindsense is still denied its Dexterity bonus to Armor Class against attacks from creatures it cannot see. At 10th level, the range of this ability increases to 60 feet.",
          1, "Ability"
      }, //
      {412, "Dragon Form",
          "At 7th level, a dragon disciple can assume the form of a dragon. This ability works like form of the dragon II and the dragon disciple can use this ability twice per day. His caster level for this effect is equal to his effective sorcerer levels for his draconic bloodline. Whenever he casts form of the dragon, he must assume the form of a dragon of the same type as his bloodline.",
          3, "Ability"
      }, //
      {413, "Wings",
          "At 9th level, a dragon disciple gains the wings bloodline power, even if his level does not yet grant that power. Once his level is high enough to grant this ability through the bloodline, the dragon disciple's speed increases to 90 feet.",
          3, "Ability"
      }, //
      {414, "Canny Defense",
          "When wearing light or no armor and not using a shield, a duelist adds 1 point of Intelligence bonus (if any) per duelist class level to her Dexterity bonus to modify Armor Class while wielding a melee weapon. If a duelist is caught flat-footed or otherwise denied her Dexterity bonus, she also loses this bonus.",
          1, "Ability"
      }, //
      {415, "Precise Strike",
          "A duelist gains the ability to strike precisely with a light or one-handed piercing weapon, adding her duelist level to her damage roll.<br/>When making a precise strike, a duelist cannot attack with a weapon in her other hand or use a shield. A duelist's precise strike only works against living creatures with discernible anatomies. Any creature that is immune to critical hits is also immune to a precise strike, and any item or ability that protects a creature from critical hits also protects a creature from a precise strike.",
          1, "Ability"
      }, //
      {416, "Improved Reaction",
          "At 2nd level, a duelist gains a +2 bonus on initiative checks. At 8th level, the bonus increases to +4. This bonus stacks with the benefit provided by the Improved Initiative feat.",
          1, "Ability"
      }, //
      {417, "Parry",
          "At 2nd level, a duelist learns to parry the attacks of other creatures, causing them to miss. Whenever the duelist takes a full attack action with a light or one-handed piercing weapon, she can elect not to take one of her attacks. At any time before her next turn, she can attempt to parry an attack against her or an adjacent ally as an immediate action. To parry the attack, the duelist makes an attack roll, using the same bonuses as the attack she chose to forego during her previous action. If her attack roll is greater than the roll of the attacking creature, the attack automatically misses. For each size category that the attacking creature is larger than the duelist, the duelist takes a -4 penalty on her attack roll. The duelist also takes a -4 penalty when attempting to parry an attack made against an adjacent ally. The duelist must declare the use of this ability after the attack is announced, but before the roll is made.",
          1, "Ability"
      }, //
      {418, "Enhanced Mobility",
          "Starting at 3rd level, when wearing light or no armor and not using a shield, a duelist gains an additional +4 bonus to AC against attacks of opportunity caused when she moves out of a threatened square.",
          1, "Ability"
      }, //
      {419, "Combat Reflexes",
          "At 4th level, a duelist gains the benefit of the Combat Reflexes feat when using a light or one-handed piercing weapon.",
          1, "Ability"
      }, //
      {420, "Grace",
          "At 4th level, a duelist gains an additional +2 competence bonus on all Reflex saving throws. This ability functions for a duelist only when she is wearing light or no armor and not using a shield.",
          1, "Ability"
      }, //
      {421, "Riposte",
          "Starting at 5th level, a duelist can make an attack of opportunity against any creature whose attack she successfully parries, so long as the creature she is attacking is within reach.",
          1, "Ability"
      }, //
      {422, "Acrobatic Charge",
          "At 6th level, a duelist gains the ability to charge in situations where others cannot. She may charge over difficult terrain that normally slows movement. Depending on the circumstance, she may still need to make appropriate checks to successfully move over the terrain.",
          1, "Ability"
      }, //
      {423, "Elaborate Defense",
          "At 7th level and higher, if a duelist chooses to fight defensively or use total defense in melee combat, she gains an additional +1 dodge bonus to AC for every 3 levels of duelist she has attained.",
          1, "Ability"
      }, //
      {424, "Deflect Arrows",
          "At 9th level, a duelist gains the benefit of the Deflect Arrows feat when using a light or one-handed piercing weapon. The duelist does not need a free hand to use this feat.",
          1, "Ability"
      }, //
      {425, "No Retreat",
          "At 9th level, enemies adjacent to the duelist that take a withdraw action provoke an attack of opportunity from the duelist.",
          1, "Ability"
      }, //
      {426, "Crippling Critical",
          "When you confirm a critical hit using a light or one-handed piercing weapon, you can apply one of the following penalties in addition to the damage dealt: reduce all of the target's speeds by 10 feet (minimum 5 feet), 1d4 points of Strength or Dexterity damage, -4 penalty on all saving throws, -4 penalty to Armor Class, or 2d6 points of bleed damage. These penalties last for 1 minute, except for ability damage, which must be healed normally, and bleed damage, which continues until the target receives magic healing or a DC 15 Heal skill check.",
          1, "Ability"
      }, //
      {427, "Bonus Feat - Eldritch Knight",
          "At 1st level, an eldritch knight may choose a bonus combat feat. This is in addition to the feats that a character of any class normally gets from advancing levels. The character must still meet any prerequisites for these bonus feats. An eldritch knight gains an additional combat feat at 5th and 9th level.",
          0, "Ability"
      }, //
      {428, "Diverse Training",
          "An eldritch knight adds his level to any levels of fighter he might have for the purpose of meeting the prerequisites for feats (if he has no fighter levels, treat his eldritch knight levels as levels of fighter). He also adds his level to any levels in an arcane spellcasting class for the purpose of meeting the prerequisites for feats.",
          0, "Ability"
      }, //
      {429, "Spells per Day - Eldritch Knight",
          "At the indicated levels, an eldritch knight gains new spells per day as if he had also gained a level in an arcane spellcasting class he belonged to before adding the prestige class. He does not, however, gain any other benefit a character of that class would have gained, except for additional spells per day, spells known (if he is a spontaneous spellcaster), and an increased effective level of spellcasting. If a character had more than one arcane spellcasting class before becoming an eldritch knight, he must decide to which class he adds the new level for purposes of determining spells per day.",
          0, "Ability"
      }, //
      {430, "Spell Critical",
          "At 10th level, whenever an eldritch knight successfully confirms a critical hit, he can cast a spell as a swift action. The spell must include the target of the attack as one of its targets or in its area of effect. Casting this spell does not provoke an attack of opportunity. The caster must still meet all of the spell's components and must roll for arcane spell failure if necessary.",
          1, "Ability"
      }, //
      {431, "Spells per Day/Spells Known",
          "When a new loremaster level is gained, the character gains new spells per day as if he had also gained a level in a spellcasting class he belonged to before adding the prestige class. He does not, however, gain other benefits a character of that class would have gained, except for additional spells per day, spells known (if he is a spontaneous spellcaster), and an increased effective level of spellcasting. If a character had more than one spellcasting class before becoming a loremaster, he must decide to which class he adds the new level for purposes of determining spells per day.",
          0, "Ability"
      }, //
      {432, "Secret",
          "At 1st level and every two levels higher than 1st (3rd, 5th, 7th, and 9th), the loremaster chooses one secret from the Loremaster Secrets table. His level plus Intelligence modifier determines which secrets he can choose. He can't choose the same secret twice.",
          0, "Ability"
      }, //
      {433, "Lore",
          "At 2nd level, a loremaster adds half his level to all Knowledge skill checks and may make such checks untrained. The bonuses gained from this ability stack with those gained from Bardic Knowledge.",
          0, "Ability"
      }, //
      {434, "Bonus Languages - Loremaster", "A loremaster can learn any new language at 4th and 8th level.", 0, "Ability"}, //
      {435, "Greater Lore",
          "At 6th level, a loremaster gains the ability to understand magic items. Whenever a loremaster examines a magic item to determine its properties, he gains a +10 circumstance bonus on his Spellcraft skill check.",
          1, "Ability"
      }, //
      {436, "True Lore",
          "At 10th level, a loremaster's knowledge becomes vast indeed. Once per day a loremaster can use his knowledge to gain the effect of a legend lore spell or an analyze dweomer spell. If used to create a legend lore effect, this ability has a casting time of 1 minute, regardless of how much information is already known about the subject in question.",
          1, "Ability"
      }, //
      {437, "Spells per Day - Mystic Theurge",
          "When a new mystic theurge level is gained, the character gains new spells per day as if he had also gained a level in any one arcane spellcasting class he belonged to before he added the prestige class and any one divine spellcasting class he belonged to previously. He does not, however, gain other benefits a character of that class would have gained. This essentially means that he adds the level of mystic theurge to the level of whatever other arcane spellcasting class and divine spellcasting class the character has, then determines spells per day, spells known, and caster level accordingly. If a character had more than one arcane spellcasting class or more than one divine spellcasting class before he became a mystic theurge, he must decide to which class he adds each level of mystic theurge for the purpose of determining spells per day.",
          0, "Ability"
      }, //
      {438, "Combined Spells",
          "A mystic theurge can prepare and cast spells from one of his spellcasting classes using the available slots from any of his other spellcasting classes. Spells prepared or cast in this way take up a slot one level higher than they originally occupied. This ability cannot be used to cast a spell at a lower level if that spell exists on both spell lists. At 1st level, a mystic theurge can prepare 1st-level spells from one of his spellcasting classes using the 2nd-level slots of the other spellcasting class. Every two levels thereafter, the level of spells that can be cast in this way increases by one, to a maximum of 5th-level spells at 9th level (these spells would take up 6th-level spell slots). The components of these spells do not change, but they otherwise follow the rules for the spellcasting class used to cast the spell. <br/>Spontaneous spellcasters can only select spells that they have prepared that day using non-spontaneous classes for this ability, even if the spells have already been cast. For example, a cleric/sorcerer/mystic theurge can use this ability to spontaneously cast a bless spell using a 2nd-level sorcerer spell slot, if the character had a prepared bless spell using a 1st-level cleric spell slot, even if that spell had already been cast that day.",
          3, "Ability"
      }, //
      {439, "Spell Synthesis",
          "At 10th level, a mystic theurge can cast two spells, one from each of his spellcasting classes, using one action. Both of the spells must have the same casting time. The mystic theurge can make any decisions concerning the spells independently. Any target affected by both of the spells takes a -2 penalty on saves made against each spell. The mystic theurge receives a +2 bonus on caster level checks made to overcome spell resistance with these two spells. A mystic theurge may use this ability once per day.",
          3, "Ability"
      }, //
      {441, "Deep Pockets",
          "A Pathfinder chronicler collects items as well as lore, picking up small amounts of this or that throughout her travels. As a result, she may carry unspecified equipment worth up to 100 gp per class level. This can be any kind of gear that can reasonably fit into a backpack, including potions and scrolls (but not any other sort of magic item). As a full-round action, the chronicler may dig through her pockets to retrieve an item she specifies at that time, deducting its value from the allocated amount of cost. This item cannot weigh more than 10 pounds. When the total remaining cost reaches 0, the chronicler can retrieve no more items until she refills her deep pockets by spending a few hours and an amount of gold to bring her total up to 100 gp per class level.<br/>In addition, if she takes 1 hour to pack her gear each day, she gains a +4 bonus to Strength to determine her light encumbrance. This does not affect her maximum carrying capacity. The efficient distribution of weight simply encumbers her less than the same amount of weight normally should. Finally, the Pathfinder chronicler gains a +4 bonus on Sleight of Hand checks made to conceal small objects on her person.",
          1, "Ability"
      }, //
      {442, "Master Scribe",
          "A Pathfinder chronicler adds her class level as a bonus on all Linguistics and Profession (scribe) checks, as well as Use Magic Device checks involving scrolls or other written magical items. A Pathfinder chronicler can make Linguistics checks to decipher text as a full-round action and can always take 10 on Linguistics and Profession (scribe) checks, even if distracted or endangered. ",
          1, "Ability"
      }, //
      {443, "Live to Tell the Tale",
          "At 2nd level, once per day per two class levels, a Pathfinder chronicler can attempt a new saving throw against any ongoing condition against which she failed a saving throw in a previous round, even if the effect is normally permanent. This ability has no effect on conditions that do not allow saving throws or against instantaneous effects. ",
          1, "Ability"
      }, //
      {444, "Pathfinding",
          "Beginning at 2nd level, a Pathfinder chronicler develops an excellent sense of direction and skill at leading others through difficult terrain or by following ancient maps. A Pathfinder chronicler gains a +5 bonus on Survival checks made to avoid becoming lost and to Intelligence checks to escape a maze spell. In addition, she always uses the 'road or trail' overland movement modifier even when in trackless terrain, whether on foot or mounted. With a DC 15 Survival check, the Pathfinder chronicler can extend this benefit to one companion per class level. ",
          1, "Ability"
      }, //
      {445, "Bardic Performance - Pathfinder Chronicler",
          "At 3rd level, a Pathfinder chronicler gains this ability, which functions like the bard class feature of the same name, except that the chronicler's effective bard level is 2 lower than her class level. Levels in this class stack with levels in any other class that grants a similar ability to determine her effective bard level.",
          3, "Ability"
      }, //
      {446, "Improved Aid",
          "Pathfinder chroniclers frequently serve as the companions of great heroes, standing by their sides and recording their deeds, but often lending a crucial helping hand. Starting at 3rd level, a Pathfinder chronicler using the aid another action grants a +4 bonus, rather than the normal +2. ",
          1, "Ability"
      }, //
      {447, "Epic Tales",
          "A 4th-level Pathfinder chronicler can inscribe a tale so evocative and so moving that it conveys the effects of bardic music through the written word. To create an epic tale requires the pathfinder chronicler to expend a number of rounds of her bardic performance ability equal to twice the duration of the epic tale (maximum duration of 10 rounds), and any relevant Performance skill check is made with Profession (scribe) instead. An epic tale affects only the reader, but it grants all the benefits that would normally apply for hearing a performance. A Pathfinder chronicler may apply the effects of any feats that affect bardic music to her epic tales. An epic tale retains its supernatural potency for 1 day per class level. It requires 1 hour to inscribe, a full-round action to activate, and has a duration equal to 1/2 the number of bardic performance rounds expended during its creation. Once activated, an epic tale's magic is consumed.",
          3, "Ability"
      }, //
      {448, "Whispering Campaign",
          "Pathfinder chroniclers influence the world through their control of information and ability to shape public perception. At 5th level, as a special use of bardic music, the Pathfinder chronicler can create the effect of a doom spell as cast by a sorcerer of her class level by denouncing a creature in person. This is a language-dependent effect.<br/>Alternatively, the chronicler can denounce a particular target (an individual or a definable group of creatures) to others. This form of bardic music creates the effect of the enthrall spell, but at the end of the performance all creatures who failed to save shift their attitude toward the target of the oration by one step (in the direction of the Pathfinder chronicler's choice) for 1 day per class level.",
          1, "Ability"
      }, //
      {449, "Inspire Action",
          "As a special use of bardic music, a 6th-level Pathfinder chronicler can exhort any one ally within hearing to a sudden surge of action, allowing her ally to immediately take an extra move action. This does not count against the ally's number of actions on his own turn.<br/>At 9th level, she can enable an ally to immediately take a standard action instead. ",
          3, "Ability"
      }, //
      {450, "Call Down the Legends",
          "At 7th level, once per week as a full-round action, a Pathfinder chronicler can summon 2d4 4th-level human barbarians, as if she used a bronze horn of Valhalla, these summoned barbarians serve her with complete loyalty. The barbarians are constructs, not actual people (although they seem to be). They arrive with the normal starting equipment for barbarians and attack anyone the chronicler designates.",
          3, "Ability"
      }, //
      {451, "Greater Epic Tales",
          "At 8th level, the Pathfinder chronicler's written word gains power. This ability functions like the chronicler's epic tales ability, except that if read aloud, the bardic music takes effect as if the author had used the ability, but the effects are targeted by the reader and use the reader's Charisma score where applicable. ",
          3, "Ability"
      }, //
      {452, "Lay of the Exalted Dead",
          "Once per week as a full-round action, a 10th-level Pathfinder chronicler can summon 1d4+1 5th-level human barbarians, as if she used an iron horn of Valhalla. The summoned barbarians serve her with complete and unquestioning loyalty. They are constructs, with the incorporeal subtype (they take 50% of the damage from corporeal sources, and no damage from nonmagical sources). They arrive wearing +2 studded leather and wielding +1 ghost touch greataxes (allowing them to deal full damage to corporeal creatures) and attack anyone the chronicler designates. To the chronicler and their allies, these exalted dead appear like a noble troop of spectral warriors. Her enemies, however, behold the terrible wrath of the ancient heroes and must succeed at Will saves or become shaken for 1 round per summoned barbarian (DC 15 + the Pathfinder chronicler's Charisma modifier).",
          3, "Ability"
      }, //
      {457, "Rogue Talent",
          "At 3rd level, and every three levels thereafter, a shadowdancer gains a special ability that allows her to confound her foes. This functions as the rogue talent class feature. A shadowdancer cannot select an individual talent more than once. If a shadowdancer has the advanced talents rogue class feature, she can chose from the advanced talents list instead.",
          0, "Ability"
      }, //
      {458, "Shadow Illusion",
          "When a shadowdancer reaches 3rd level, she can create visual illusions. This ability functions as silent image, using the shadowdancer's level as the caster level. A shadowdancer can use this ability once per day for every two shadowdancer levels she has attained. The DC for this ability is Charisma-based.",
          2, "Ability"
      }, //
      {459, "Summon Shadow",
          "At 3rd level, a shadowdancer can summon a shadow, an undead shade. Unlike a normal shadow, this shadow's alignment matches that of the shadowdancer, and the creature cannot create spawn. The summoned shadow receives a +4 bonus on Will saves made to halve the damage from positive channeled energy and the shadow cannot be turned or commanded. This shadow serves as a companion to the shadowdancer and can communicate intelligibly with the shadowdancer. This shadow has a number of hit points equal to half the shadowdancer's total. The shadow uses the shadowdancer's base attack bonus and base save bonuses.<br/>If a shadow companion is destroyed, or the shadowdancer chooses to dismiss it, the shadowdancer must attempt a DC 15 Fortitude save. If the saving throw fails, the shadowdancer gains one permanent negative level. A successful saving throw avoids this negative level. A destroyed or dismissed shadow companion cannot be replaced for 30 days.",
          3, "Ability"
      }, //
      {460, "Shadow Call",
          "At 4th level, a shadowdancer can create creatures and effects out of raw shadow. This ability functions as shadow conjuration, using the shadowdancer's level as the caster level. A shadowdancer can use this ability once per day at 4th level, plus one additional time per day for every two levels attained beyond 4th (2/day at 6th level, 3/day at 8th level, and 4/day at 10th level). Upon reaching 10th level, this ability functions as greater shadow conjuration. The DC for this ability is Charisma-based.",
          2, "Ability"
      }, //
      {461, "Shadow Jump",
          "At 4th level, a shadowdancer gains the ability to travel between shadows as if by means of a dimension door spell. The limitation is that the magical transport must begin and end in an area with at least some dim light. A shadowdancer can jump up to a total of 40 feet each day in this way, this may be a single jump of 40 feet or four jumps of 10 feet each. Every two levels higher than 4th, the distance a shadowdancer can jump each day doubles (80 feet at 6th, 160 feet at 8th, and 320 feet at 10th). This amount can be split among many jumps, but each one, no matter how small, counts as a 10-foot increment.",
          3, "Ability"
      }, //
      {465, "Shadow Power",
          "At 8th level, a shadowdancer can use raw shadow to damage her foes. This ability functions as shadow evocation, using the shadowdancer's level as the caster level. A shadowdancer can use this ability once per day at 8th level, and one additional time per day upon reaching 10th level. The DC for this ability is Charisma-based. ",
          2, "Ability"
      }, //
      {467, "Shadow Master",
          "At 10th level, whenever a shadowdancer is in an area of dim light, she gains DR 10/- and a +2 luck bonus on all saving throws. In addition, whenever she successfully scores a critical hit against a foe who is in an area of dim light, that foe is blinded for 1d6 rounds.",
          3, "Ability"
      }, //
      {469, "Spells - Air Domain",
          "You can manipulate lightning, mist, and wind, traffic with air creatures, and are resistant to electricity damage.", 0,
          "SpelllistAbility"
      }, //
      {471, "Spells - Animal Domain",
          "You can speak with and befriend animals with ease. In addition, you treat Knowledge (nature) as a class skill.", 0,
          "SpelllistAbility"
      }, //
      {473, "Spells - Artifice Domain",
          "You can repair damage to objects, animate objects with life, and create objects from nothing.", 0, "SpelllistAbility"
      }, //
      {475, "Spells - Chaos Domain", "Your touch infuses life and weapons with chaos, and you revel in all things anarchic.", 0,
          "SpelllistAbility"
      }, //
      {477, "Spells - Charm Domain",
          "You can baffle and befuddle foes with a touch or a smile, and your beauty and grace are divine.", 0, "SpelllistAbility"
      }, //
      {479, "Spells - Community Domain",
          "Your touch can heal wounds, and your presence instills unity and strengthens emotional bonds.", 0, "SpelllistAbility"
      }, //
      {481, "Spells - Darkness Domain",
          "You manipulate shadows and darkness. In addition, you receive Blind-Fight as a bonus feat.", 0, "SpelllistAbility"
      }, //
      {483, "Spells - Death Domain", "You can cause the living to bleed at a touch, and find comfort in the presence of the dead.",
          0, "SpelllistAbility"
      }, //
      {485, "Spells - Destruction Domain", "You revel in ruin and devastation, and can deliver particularly destructive attacks.",
          0, "SpelllistAbility"
      }, //
      {487, "Spells - Earth Domain",
          "You have mastery over earth, metal, and stone, can fire darts of acid, and command earth creatures.", 0,
          "SpelllistAbility"
      }, //
      {489, "Spells - Evil Domain", "You are sinister and cruel, and have wholly pledged your soul to the cause of evil.", 0,
          "SpelllistAbility"
      }, //
      {491, "Spells - Fire Domain", "You can call forth fire, command creatures of the inferno, and your flesh does not burn.", 0,
          "SpelllistAbility"
      }, //
      {493, "Spells - Glory Domain",
          "You are infused with the glory of the divine, and are a true foe of the undead. In addition, when you channel positive energy to harm undead creatures, the save DC to halve the damage is increased by 2.",
          0, "SpelllistAbility"
      }, //
      {495, "Spells - Good Domain", "You have pledged your life and soul to goodness and purity.", 0, "SpelllistAbility"}, //
      {497, "Spells - Healing Domain",
          "Your touch staves off pain and death, and your healing magic is particularly vital and potent.", 0, "SpelllistAbility"
      }, //
      {499, "Spells - Knowledge Domain",
          "You are a scholar and a sage of legends. In addition, you treat all Knowledge skills as class skills.", 0,
          "SpelllistAbility"
      }, //
      {501, "Spells - Law Domain", "You follow a strict and ordered code of laws, and in so doing, achieve enlightenment.", 0,
          "SpelllistAbility"
      }, //
      {503, "Spells - Liberation Domain",
          "You are a spirit of freedom and a staunch foe against all who would enslave and oppress.", 0, "SpelllistAbility"
      }, //
      {505, "Spells - Luck Domain", "You are infused with luck, and your mere presence can spread good fortune.", 0,
          "SpelllistAbility"
      }, //
      {507, "Spells - Madness Domain",
          "You embrace the madness that lurks deep in your heart, and can unleash it to drive your foes insane or to sacrifice certain abilities to hone others.",
          0, "SpelllistAbility"
      }, //
      {509, "Spells - Magic Domain", "You are a true student of all things mystical, and see divinity in the purity of magic.", 0,
          "SpelllistAbility"
      }, //
      {511, "Spells - Nobility Domain", "You are a great leader, an inspiration to all who follow the teachings of your faith.", 0,
          "SpelllistAbility"
      }, //
      {513, "Spells - Plant Domain", "You find solace in the green, can grow defensive thorns, and can communicate with plants.", 0,
          "SpelllistAbility"
      }, //
      {515, "Spells - Protection Domain",
          "Your faith is your greatest source of protection, and you can use that faith to defend others. In addition, you receive a +1 resistance bonus on saving throws. This bonus increases by 1 for every 5 levels you possess. ",
          0, "SpelllistAbility"
      }, //
      {517, "Spells - Repose Domain",
          "You see death not as something to be feared, but as a final rest and reward for a life well spent. The taint of undeath is a mockery of what you hold dear.",
          0, "SpelllistAbility"
      }, //
      {519, "Spells - Rune Domain", "In strange and eldritch runes you find potent magic. You gain Scribe Scroll as a bonus feat.",
          0, "SpelllistAbility"
      }, //
      {521, "Spells - Strength Domain", "In strength and brawn there is truth�your faith gives you incredible might and power. ", 0,
          "SpelllistAbility"
      }, //
      {523, "Spells - Sun Domain",
          "You see truth in the pure and burning light of the sun, and can call upon its blessing or wrath to work great deeds.", 0,
          "SpelllistAbility"
      }, //
      {525, "Spells - Travel Domain",
          "You are an explorer and find enlightenment in the simple joy of travel, be it by foot or conveyance or magic. Increase your base speed by 10 feet.",
          0, "SpelllistAbility"
      }, //
      {527, "Spells - Trickery Domain",
          "You are a master of illusions and deceptions. Bluff, Disguise, and Stealth are class skills.", 0, "SpelllistAbility"
      }, //
      {529, "Spells - War Domain", "You are a crusader for your god, always ready and willing to fight to defend your faith.", 0,
          "SpelllistAbility"
      }, //
      {531, "Spells - Water Domain", "You can manipulate water and mist and ice, conjure creatures of water, and resist cold.", 0,
          "SpelllistAbility"
      }, //
      {533, "Spells - Weather Domain",
          "With power over storm and sky, you can call down the wrath of the gods upon the world below.", 0, "SpelllistAbility"
      }, //
      {534, "Alchemy",
          "Alchemists are not only masters of creating mundane alchemical substances such as alchemist's fire and smokesticks, but also of fashioning magical potion-like extracts in which they can store spell effects. In effect, an alchemist prepares his spells by mixing ingredients into a number of extracts, and then \"casts\" his spells by drinking the extract. When an alchemist creates an extract or bomb, he infuses the concoction with a tiny fraction of his own magical power-this enables the creation of powerful effects, but also binds the effects to the creator.<br>When using Craft (alchemy) to create an alchemical item, an alchemist gains a competence bonus equal to his class level on the Craft (alchemy) check. In addition, an alchemist can use Craft (alchemy) to identify potions as if using <i>detect magic</i>. He must hold the potion for 1 round to make such a check.<br>An alchemist can create three special types of magical items-extracts, bombs, and mutagens. Bombs are explosive splash weapons, and mutagens are transformative elixirs that the alchemist drinks to enhance his physical abilities-both of these are detailed in their own sections below.<br>Extracts are the most varied of the three. In many ways, they behave like spells in potion form, and as such their effects can be dispelled by effects like <i>dispel magic </i>using the alchemist's level as the caster level. Unlike potions, though, extracts can have powerful effects and duplicate spells that a potion normally could not.<br> An alchemist can create only a certain number of extracts of each level per day. His base daily allotment of extracts is given on Table 2-1. In addition, he receives bonus extracts per day if he has a high Intelligence score, in the same way a wizard receives bonus spells per day.<br>When an alchemist mixes an extract, he infuses the chemicals and reagents in the extract with magic siphoned from his own magical aura. An extract immediately becomes inert if it leaves the alchemist's possession, reactivating as soon as it returns to his keeping-an alchemist cannot normally pass out his extracts for allies to use (but see the \"infusion\" discovery below). An extract, once created, remains potent for 1 day before losing its magic, so an alchemist must re-prepare his extracts every day. Mixing an extract takes 1 minute of work-most alchemists prepare many extracts at the start of the day or just before going on an adventure, but it's not uncommon for an alchemist to keep some (or even all) of his daily extract slots open so that he can prepare extracts in the field as needed.<br>Although the alchemist doesn't actually cast spells, he does have a formulae list that determines what extracts he can create. An alchemist can utilize spell-trigger items if the spell appears on his formuale list, but not spell-completion items (unless he uses Use Magic Device to do so). An extract is \"cast\" by drinking it, as if imbibing a potion-the effects of an extract exactly duplicate the spell upon which its formula is based, save that the spell always affects only the drinking alchemist. An alchemist can draw and drink an extract as a standard action. The alchemist uses his level as the caster level to determine any effect based on caster level.<br>Creating extracts consumes raw materials, but the cost of these materials is insignificant-comparable to the valueless material components of most spells. If a spell normally has a costly material component, that component is expended during the consumption of that particular extract. Extracts cannot be made from spells that have focus requirements (alchemist extracts that duplicate divine spells never have a divine focus requirement).<br>An alchemist can prepare an extract of any formula he knows. To learn or use an extract, an alchemist must have an Intelligence score equal to at least 10 + the extract's level. The Difficulty Class for a saving throw against an alchemist's extract is 10 + the extract level + the alchemist's Intelligence modifier.<br>An alchemist may know any number of formulae. He stores his formulae in a special tome called a formula book. He must refer to this book whenever he prepares an extract but not when he consumes it. An alchemist begins play with two 1st-level formulae of his choice, plus a number of additional forumlae equal to his Intelligence modifier. At each new alchemist level, he gains one new formula of any level that he can create. An alchemist can also add formulae to his book just like a wizard adds spells to his spellbook, using the same costs, pages, and time requirements. An alchemist can study a wizard's spellbook to learn any formula that is equivalent to a spell the spellbook contains. A wizard, however, cannot learn spells from a formula book. An alchemist does not need to decipher arcane writings before copying them.",
          3, "Ability"
      }, //
      {535, "Bomb",
          "In addition to magical extracts, alchemists are adept at swiftly mixing various volatile chemicals and infusing them with their magical reserves to create powerful bombs that they can hurl at their enemies. An alchemist can use a number of bombs each day equal to his class level + his Intelligence modifier. Bombs are unstable, and if not used in the round they are created, they degrade and become inert-their method of creation prevents large volumes of explosive material from being created and stored. In order to create a bomb, the alchemist must use a small vial containing an ounce of liquid catalyst-the alchemist can create this liquid catalyst from small amounts of chemicals from an alchemy lab, and these supplies can be readily refilled in the same manner as a spellcaster's component pouch. Most alchemists create a number of catalyst vials at the start of the day equal to the total number of bombs they can create in that day-once created, a catalyst vial remains usable by the alchemist for years.<br>Drawing the components of, creating, and throwing a bomb requires a standard action that provokes an attack of opportunity. Thrown bombs have a range of 20 feet and use the Throw Splash Weapon special attack. Bombs are considered weapons and can be selected using feats such as Point-Blank Shot and Weapon Focus. On a direct hit, an alchemist's bomb inflicts 1d6 points of fire damage + additional damage equal to the alchemist's Intelligence modifier. The damage of an alchemist's bomb increases by 1d6 points at every odd-numbered alchemist level (this bonus damage is not multiplied on a critical hit or by using feats such as Vital Strike). Splash damage from an alchemist bomb is always equal to the bomb's minimum damage (so if the bomb would deal 2d6+4 points of fire damage on a direct hit, its splash damage would be 6 points of fire damage). Those caught in the splash damage can attempt a Reflex save for half damage. The DC of this save is equal to 10 + 1/2 the alchemist's level + the alchemist's Intelligence modifier.<br>Alchemists can learn new types of bombs as discoveries (see the Discovery ability) as they level up. An alchemist's bomb, like an extract, becomes inert if used or carried by anyone else.",
          3, "Ability"
      }, //
      {536, "Brew Potion",
          "At 1st level, alchemists receive Brew Potion as a bonus feat. An alchemist can brew potions of any formulae he knows (up to 3rd level), using his alchemist level as his caster level. The spell must be one that can be made into a potion. The alchemist does not need to meet the prerequisites for this feat.",
          1, "Ability"
      }, //
      {537, "Mutagen",
          "At 1st level, an alchemist discovers how to create a mutagen that he can imbibe in order to heighten his physical prowess at the cost of his personality. It takes 1 hour to brew a dose of mutagen, and once brewed, it remains potent until used. An alchemist can only maintain one dose of mutagen at a time-if he brews a second dose, any existing mutagen becomes inert. As with an extract or bomb, a mutagen that is not in an alchemist's possession becomes inert until an alchemist picks it up again.<br>When an alchemist brews a mutagen, he selects one physical ability score-either Strength, Dexterity, or Constitution. It's a standard action to drink a mutagen. Upon being imbibed, the mutagen causes the alchemist to grow bulkier and more bestial, granting him a +2 natural armor bonus and a +4 alchemical bonus to the selected ability score for 10 minutes per alchemist level. In addition, while the mutagen is in effect, the alchemist takes a -2 penalty to one of his mental ability scores. If the mutagen enhances his Strength, it applies a penalty to his Intelligence. If it enhances his Dexterity, it applies a penalty to his Wisdom. If it enhances his Constitution, it applies a penalty to his Charisma.<br>A non-alchemist who drinks a mutagen must make a Fortitude save (DC 10 + 1/2 the alchemist's level + the alchemist's Intelligence modifier) or become nauseated for 1 hour-a non-alchemist can never gain the benefit of a mutagen, but an alchemist can gain the effects of another alchemist's mutagen if he drinks it. (Although if the other alchemist creates a different mutagen, the effects of the 'stolen' mutagen immediately cease.) The effects of a mutagen do not stack. Whenever an alchemist drinks a mutagen, the effects of any previous mutagen immediately end.",
          3, "Ability"
      }, //
      {538, "Throw Anything",
          "All alchemists gain the Throw Anything feat as a bonus feat at 1st level. An alchemist adds his Intelligence modifier to damage done with splash weapons, including the splash damage if any. This bonus damage is already included in the bomb class feature.",
          1, "Ability"
      }, //
      {539, "Discovery",
          "At 2nd level, and then again every 2 levels thereafter (up to 18th level), an alchemist makes an incredible alchemical discovery. Unless otherwise noted, an alchemist cannot select an individual discovery more than once. Some discoveries can only be made if the alchemist has met certain prerequisites first, such as uncovering other discoveries. Discoveries that modify bombs that are marked with an asterisk (*) do not stack. Only one such discovery can be applied to an individual bomb. The DC of any saving throw called for by a discovery is equal to 10 + 1/2 the alchemist's level + the alchemist's Intelligence modifier.",
          3, "Ability"
      }, //
      {540, "Discovery - Acid bomb",
          "When the alchemist creates a bomb, he can choose to have it inflict acid damage. Creatures that take a direct hit from an acid bomb take an additional 1d6 points of acid damage 1 round later.",
          3, "Ability"
      }, //
      {541, "Discovery - Combine extracts",
          "When the alchemist creates an extract, he can place two formulae into one extract. When the extract is consumed, both formulae take effect. This extract has a level two levels higher than the highest-level formulae placed in the extract. An alchemist must be at least 8th level before selecting this discovery.",
          3, "Ability"
      }, //
      {542, "Discovery - Concentrate poison",
          "The alchemist can combine two doses of the same poison to increase their effects. This requires two doses of the poison and 1 minute of concentration. When completed, the alchemist has one dose of poison. The poison's frequency is extended by 50% and the save DC increases by +2. This poison must be used within 1 hour of its creation or it is ruined.",
          3, "Ability"
      }, //
      {543, "Discovery - Concussive bomb",
          "When the alchemist creates a bomb, he can choose to have it inflict sonic damage. Concussive bombs deal 1d4 points of sonic damage, plus 1d4 points of sonic damage for every odd-numbered level, instead of 1d6. Creatures that take a direct hit from a concussive bomb are deafened for 1 minute unless they succeed at a Fortitude save. An alchemist must be at least 6th level before selecting this discovery.",
          3, "Ability"
      }, //
      {544, "Discovery - Delayed bomb",
          "The alchemist can place a bomb so that it explodes a number of rounds after the alchemist ceases contact with the bomb. This delay can be any number of rounds as chosen by the alchemist, up to a number of rounds equal to his level. If at any point the alchemist reclaims possession of the delayed bomb, he can end the timer and prevent the bomb's detonation. A delayed bomb detonates immediately if any other creature attempts to touch or move it, or if the bomb's contents are removed from the vial (such as if the vial breaks). The bomb deals damage as if it scored a direct hit to any creature in the square with the bomb when it detonates, and splash damage to all adjacent creatures as normal. An alchemist cannot have more than one delayed bomb at one time. If he creates another delayed bomb, the previous bomb becomes inert. Dispel magic can neutralize a delayed bomb, as can a successful Disable Device check (DC equals 10 + the alchemist's level + the alchemist's Intelligence modifier). An alchemist must be at least 8th level before selecting this discovery.",
          3, "Ability"
      }, //
      {545, "Discovery - Dilution",
          "Once per day, the alchemist can dilute any one potion or elixir, creating two doses of the same potion from one. Diluting a potion costs a number of gp equal to one-quarter of the potion's market value. A potion that has been diluted cannot be diluted again. This discovery cannot be used to dilute extracts or mutagens. An alchemist must be at least 12th level before selecting this discovery.",
          3, "Ability"
      }, //
      {546, "Discovery - Dispelling Bomb",
          "When the alchemist creates a bomb, he can choose to have it dispel magic effects instead of deal damage. Creatures that take a direct hit from a dispelling bomb are subject to a targeted dispel magic spell, using the alchemist's level as the caster level. This cannot be used to target a specific spell effect. The alchemist must be at least 6th level before selecting this discovery.",
          3, "Ability"
      }, //
      {547, "Discovery - Elixir of life",
          "Once per day, the alchemist can brew an elixir of life. This special concoction costs 25,000 gp to create and takes 1 hour of work. An elixir of life, when administered by the alchemist who brewed it, restores life to a dead creature as per the spell true resurrection. Alternatively, the alchemist himself may drink the elixir of life, after which point he is immediately targeted with a resurrection spell the next time he is killed. Used in this manner, the effects of an elixir of life persist only for a number of days equal to the alchemist's Intelligence modifier, if he does not die before that time expires, the effects of the elixir of life end. An alchemist must be at least 16th level before selecting this discovery.",
          3, "Ability"
      }, //
      {548, "Discovery - Enhance potion",
          "A number of times per day equal to his Intelligence modifier, the alchemist can cause any potion he drinks to function at a caster level equal to his class level.",
          3, "Ability"
      }, //
      {549, "Discovery - Eternal potion",
          "If an alchemist drinks a potion that he extends, the effects of that potion become permanent until he chooses to make another potion effect permanent. An alchemist must be at least 16th level and must possess the extend potion discovery before selecting this discovery.",
          3, "Ability"
      }, //
      {550, "Discovery - Explosive bomb",
          "The alchemist's bombs now have a splash radius of 10 feet rather than 5 feet. Creatures that take a direct hit from an explosive bomb catch fire, taking 1d6 points of fire damage each round until the fire is extinguished. Extinguishing the flames is a full-round action that requires a Reflex save. Rolling on the ground provides the target with a +2 to the save. Dousing the target with at least 2 gallons of water automatically extinguishes the flames.",
          3, "Ability"
      }, //
      {551, "Discovery - Extend potion",
          "A number of times per day equal to his Intelligence modifier, the alchemist can cause any potion he drinks that does not have an instantaneous duration to function at twice its normal duration. This does not apply to extracts.",
          3, "Ability"
      }, //
      {552, "Discovery - Fast bombs",
          "An alchemist with this discovery can quickly create enough bombs to throw more than one in a single round. The alchemist can prepare and throw additional bombs as a full-round action if his base attack bonus is high enough to grant him additional attacks. This functions just like a full-attack with a ranged weapon. An alchemist must be at least 8th level before selecting this discovery.",
          3, "Ability"
      }, //
      {553, "Discovery - Feral mutagen",
          "Whenever the alchemist imbibes a mutagen, he gains two claw attacks and a bite attack. These are primary attacks and are made using the alchemist's full base attack bonus. The claw attacks deal 1d6 points of damage (1d4 if the alchemist is Small) and the bite attack deals 1d8 points of damage (1d6 if the alchemist is Small). While the mutagen is in effect, the alchemist gains a +2 competence bonus on Intimidate skill checks.",
          3, "Ability"
      }, //
      {554, "Discovery - Force bomb",
          "When the alchemist creates a bomb, he can choose to have it inflict force damage. Force bombs deal 1d4 points of force damage, plus 1d4 points of force damage for every odd-numbered level, instead of 1d6. Creatures that take a direct hit from a force bomb are knocked prone unless they succeed on a Reflex save. An alchemist must be at least 8th level before selecting this discovery.",
          3, "Ability"
      }, //
      {555, "Discovery - Frost bomb",
          "When the alchemist creates a bomb, he can choose to have it inflict cold damage. Creatures that take a direct hit from a frost bomb are staggered on their next turn unless they succeed on a Fortitude save.",
          3, "Ability"
      }, //
      {556, "Discovery - Grand mutagen",
          "The alchemist's mutagen now grants a +6 natural armor bonus, a +8 alchemical bonus to one ability score (Strength, Dexterity, or Constitution), a +6 alchemical bonus to a second physical ability score, and a +4 alchemical bonus to a third physical ability score. The alchemist takes a -2 penalty to his Intelligence, Wisdom, and Charisma as long as the mutagen persists (see Mutagen). An alchemist must be at least 16th level and must possess the greater mutagen discovery before selecting this discovery.",
          3, "Ability"
      }, //
      {557, "Discovery - Greater mutagen",
          "The alchemist's mutagen now grants a +4 natural armor bonus, a +6 alchemical bonus to one physical ability score (Strength, Dexterity, or Constitution), and a +4 alchemical bonus to a second physical ability score. The alchemist takes a -2 penalty on both associated mental ability scores as long as the mutagen persists. An alchemist must be at least 12th level before selecting this discovery.",
          3, "Ability"
      }, //
      {558, "Discovery - Infuse mutagen",
          "When the alchemist creates a mutagen, he can infuse it with an extra bit of his own magical power. This inflicts 2 points of Intelligence damage to the alchemist and costs 1,000 gp in rare reagents, but the mutagen created persists on its own and is not rendered inert if the alchemist creates another mutagen. This allows an alchemist to create different types of mutagens and keep them handy for emergencies. This does not allow an alchemist to gain the effects of multiple mutagens-only the most recently imbibed mutagen has any effect.",
          3, "Ability"
      }, //
      {559, "Discovery - Inferno bomb",
          "The effects of the smoke created by an alchemist's bomb duplicate the effects of incendiary cloud instead of fog cloud, filling an area equal to twice the bomb's splash radius for 1 round per level. An alchemist must be at least 16th level and must possess the smoke bomb discovery before selecting this discovery.",
          3, "Ability"
      }, //
      {560, "Discovery - Infusion",
          "When the alchemist creates an extract, he can infuse it with an extra bit of his own magical power. The extract created now persists even after the alchemist sets it down. As long as the extract exists, it continues to occupy one of the alchemist's daily extract slots. An infused extract can be imbibed by a non-alchemist to gain its effects.",
          3, "Ability"
      }, //
      {561, "Discovery - Madness bomb",
          "The alchemist's bombs do more than sear flesh-they sear the mind. A creature that takes a direct hit from a madness bomb takes damage from the bomb plus 1d4 points of Wisdom damage. Reduce the amount of normal damage dealt by the bomb by 2d6 (so a bomb that would normally deal 6d6+4 points of damage deals 4d6+4 points of damage instead). The amount of Wisdom damage dealt by a madness bomb is reduced by 1 for each madness bomb that hit the target in the past 24 hours, to a minimum of 1 point of Wisdom damage. An alchemist must be at least 12th level before selecting this discovery.",
          3, "Ability"
      }, //
      {562, "Discovery - Poison bomb",
          "The effects of the smoke created by an alchemist's bomb duplicates the effects of cloudkill instead of fog cloud, filling an area equal to twice the bomb's splash radius for 1 round per level. An alchemist must be at least 12th level and must possess the smoke bomb discovery before selecting this discovery.",
          3, "Ability"
      }, //
      {563, "Discovery - Precise bombs",
          "Whenever the alchemist throws a bomb, he can select a number of squares equal to his Intelligence modifier that are not affected by the splash damage from his bombs. If the bomb misses, this discovery has no effect.",
          3, "Ability"
      }, //
      {564, "Discovery - Shock bomb",
          "When the alchemist creates a bomb, he can choose to have it inflict electricity damage. Creatures that take a direct hit from a shock bomb are dazzled for 1d4 rounds.",
          3, "Ability"
      }, //
      {565, "Discovery - Smoke bomb",
          "When the alchemist creates a bomb, he can choose to have it create a cloud of thick smoke when it detonates. The cloud functions as fog cloud, filling an area equal to twice the bomb's splash radius for 1 round per level.",
          3, "Ability"
      }, //
      {566, "Discovery - Sticky bomb",
          "The effects of the alchemist's bombs are persistent and continue to damage creatures for 1 round after the initial damage. Creatures that take a direct hit from a sticky bomb take the splash damage 1 round later. Bombs that have effects that would normally occur 1 round later instead have those effects occur 2 rounds later. An alchemist must be at least 10th level before selecting this discovery.",
          3, "Ability"
      }, //
      {567, "Discovery - Sticky poison",
          "Any poison the alchemist creates is sticky-when the alchemist applies it to a weapon, the weapon remains poisoned for a number of strikes equal to the alchemist's Intelligence modifier. An alchemist must be at least 6th level before selecting this discovery.",
          3, "Ability"
      }, //
      {568, "Discovery - Stink bomb",
          "The effects of the smoke created by an alchemist's bomb can duplicate the effects of stinking cloud instead of fog cloud, filling an area equal to twice the bomb's splash radius for 1 round. An alchemist must possess the smoke bomb discovery before selecting this discovery.",
          3, "Ability"
      }, //
      {569, "Poison Resistance",
          "At 2nd level, an alchemist gains a +2 bonus on all saving throws against poison. This bonus increases to +4 at 5th level, and then again to +6 at 8th level. At 10th level, an alchemist becomes completely immune to poison.",
          1, "Ability"
      }, //
      {570, "Poison Use",
          "Alchemists are trained in the use of poison and starting at 2nd level, cannot accidentally poison themselves when applying poison to a weapon.",
          1, "Ability"
      }, //
      {571, "Swift Alchemy",
          "At 3rd level, an alchemist can create alchemical items with astounding speed. It takes an alchemist half the normal amount of time to create alchemical items, and he can apply poison to a weapon as a move action.",
          1, "Ability"
      }, //
      {572, "Swift Poisoning", "At 6th level, an alchemist can apply a dose of poison to a weapon as a swift action.", 1, "Ability"
      }, //
      {573, "Persistent Mutagen", "At 14th level, the effects of a mutagen last for 1 hour per level.", 3, "Ability"}, //
      {574, "Instant Alchemy",
          "At 18th level, an alchemist can create alchemical items with almost supernatural speed. He can create any alchemical item as a full-round action if he succeeds at the Craft (alchemy) check and has the appropriate resources at hand to fund the creation. He can apply poison to a weapon as an immediate action.",
          1, "Ability"
      }, //
      {575, "Grand Discovery",
          "At 20th level, the alchemist makes a grand discovery. He immediately learns two normal discoveries, but also learns a third discovery chosen from the list below, representing a truly astounding alchemical breakthrough of significant import. For many alchemists, the promise of one of these grand discoveries is the primary goal of their experiments and hard work.",
          3, "Ability"
      }, //
      {576, "Grand Discovery - Awakened Intellect",
          "The alchemist's constant exposure to strange chemicals has expanded his mind. His Intelligence score permanently increases by 2 points.",
          3, "Ability"
      }, //
      {577, "Grand Discovery - Eternal Youth",
          "The alchemist has discovered a cure for aging, and from this point forward he takes no penalty to his physical ability scores from advanced age. If the alchemist is already taking such penalties, they are removed at this time.",
          3, "Ability"
      }, //
      {578, "Grand Discovery - Fast Healing",
          "The alchemist's flesh responds to damage with shocking speed-he gains fast healing 5.", 3, "Ability"
      }, //
      {579, "Grand Discovery - Philosopher's Stone",
          "The alchemist learns how to create a philosopher's stone, and can do so once per month at no cost. Creating a philosopher's stone takes 1 day of work.",
          3, "Ability"
      }, //
      {580, "Grand Discovery - Poison Touch",
          "The alchemist gains a poisonous touch, as if under the effects of a poison spell. He can suppress or activate this ability as a free action. The physical appearance of how the alchemist generates and delivers his poisonous touch varies from alchemist to alchemist.",
          3, "Ability"
      }, //
      {581, "Grand Discovery - True Mutagen",
          "The alchemist's mutagen now grants a +8 natural armor bonus and a +8 alchemical bonus to Strength, Dexterity, and Constitution. The alchemist takes a -2 penalty to his Intelligence, Wisdom, and Charisma as long as the mutagen persists (see Mutagen). An alchemist must possess the grand mutagen discovery before selecting this discovery.",
          3, "Ability"
      }, //
      {582, "Spells - Alchemist Formulae",
          "Alchemists gain access to a variety of formulae, allowing them to make extracts of the following spells. ", 0,
          "SpelllistAbility"
      }, //
      {583, "Challenge ",
          "Once per day, a cavalier can challenge a foe to combat. As a swift action, the cavalier chooses one target within sight to challenge. The cavalier's melee attacks deal extra damage whenever the attacks are made against the target of his challenge. This extra damage is equal to the cavalier's level. The cavalier can use this ability once per day at 1st level, plus one additional time per day for every three levels beyond 1st, to a maximum of seven times per day at 19th level.<br>Challenging a foe requires much of the cavalier's concentration. The cavalier takes a -2 penalty to his Armor Class, except against attacks made by the target of his challenge.<br>The challenge remains in effect until the target is dead or unconscious or until the combat ends. Each cavalier's challenge also includes another effect which is listed in the section describing the cavalier's order.",
          1, "Ability"
      }, //
      {584, "Mount",
          "A cavalier gains the service of a loyal and trusty steed to carry him into battle. This mount functions as a druid's animal companion, using the cavalier's level as his effective druid level. The creature must be one that he is capable of riding and is suitable as a mount. A Medium cavalier can select a camel or a horse. A Small cavalier can select a pony or wolf, but can also select a boar or a dog if he is at least 4th level. The GM might approve other animals as suitable mounts.<br>A cavalier does not take an armor check penalty on Ride checks while riding his mount. The mount is always considered combat trained and begins play with Light Armor Proficiency as a bonus feat. A cavalier's mount does not gain the share spells special ability.<br>A cavalier's bond with his mount is strong, with the pair learning to anticipate each other's moods and moves. Should a cavalier's mount die, the cavalier may find another mount to serve him after 1 week of mourning. This new mount does not gain the link, evasion, devotion, or improved evasion special abilities until the next time the cavalier gains a level.",
          1, "Ability"
      }, //
      {585, "Order",
          "At 1st level, a cavalier must pledge himself to a specific order. The order grants the cavalier a number of bonuses, class skills, and special abilities. In addition, each order includes a number of edicts that the cavalier must follow. If he violates any of these edicts, he loses the benefits from his order's challenge ability for 24 hours. The violation of an edict is subject to GM interpretation.<br>A cavalier cannot change his order without undertaking a lengthy process to dedicate himself to a new cause. When this choice is made, he immediately loses all of the benefits from his old order. He must then follow the edicts of his new order for one entire level without gaining any benefits from that order. Once accomplished, he gains all of the bonuses from his new order. Note that the names of these orders might vary depending upon the campaign setting or GM's preference.",
          1, "Ability"
      }, //
      {586, "Tactician",
          "At 1st level, a cavalier receives a teamwork feat as a bonus feat. He must meet the prerequisites for this feat. As a standard action, the cavalier can grant this feat to all allies within 30 feet who can see and hear him. Allies retain the use of this bonus feat for 3 rounds plus 1 round for every two levels the cavalier possesses. Allies do not need to meet the prerequisites of these bonus feats. The cavalier can use this ability once per day at 1st level, plus one additional time per day at 5th level and for every 5 levels thereafter.",
          1, "Ability"
      }, //
      {587, "Cavalier's Charge",
          "At 3rd level, a cavalier learns to make more accurate charge attacks while mounted. The cavalier receives a +4 bonus on melee attack rolls on a charge while mounted (instead of the normal +2). In addition, the cavalier does not suffer any penalty to his AC after making a charge attack while mounted.",
          1, "Ability"
      }, //
      {588, "Expert Trainer",
          "At 4th level, a cavalier learns to train mounts with speed and unsurpassed expertise. The cavalier receives a bonus equal to 1/2 his cavalier level whenever he uses Handle Animal on an animal that serves as a mount. In addition, he can reduce the time needed to teach a mount a new trick or train a mount for a general purpose to 1 day per 1 week required by increasing the DC by +5. He can also train more than one mount at once, although each mount after the first adds +2 to the DC.",
          1, "Ability"
      }, //
      {589, "Banner",
          "At 5th level, a cavalier's banner becomes a symbol of inspiration to his allies and companions. As long as the cavalier's banner is clearly visible, all allies within 60 feet receive a +2 morale bonus on saving throws against fear and a +1 morale bonus on attack rolls made as part of a charge. At 10th level, and every five levels thereafter, these bonuses increase by +1. The banner must be at least Small or larger and must be carried or displayed by the cavalier or his mount to function.",
          1, "Ability"
      }, //
      {590, "Bonus Feat",
          "At 6th level, and at every six levels thereafter, a cavalier gains a bonus feat in addition to those gained from normal advancement. These bonus feats must be selected from those listed as combat feats. The cavalier must meet the prerequisites of these bonus feats.",
          1, "Ability"
      }, //
      {591, "Greater Tactician",
          "At 9th level, the cavalier receives an additional teamwork feat as a bonus feat. He must meet the prerequisites for this feat. The cavalier can grant this feat to his allies using the tactician ability. Using the tactician ability is a swift action.",
          1, "Ability"
      }, //
      {592, "Mighty Charge",
          "At 11th level, a cavalier learns to make devastating charge attacks while mounted. Double the threat range of any weapons wielded during a charge while mounted. This increase does not stack with other effects that increase the threat range of the weapon. In addition, the cavalier can make a free bull rush, disarm, sunder, or trip combat maneuver if his charge attack is successful. This free combat maneuver does not provoke an attack of opportunity.",
          1, "Ability"
      }, //
      {593, "Demanding Challenge",
          "At 12th level, whenever a cavalier declares a challenge, his target must pay attention to the threat he poses. As long as the target is within the threatened area of the cavalier, it takes a -2 penalty to its AC from attacks made by anyone other than the cavalier.",
          1, "Ability"
      }, //
      {594, "Master Tactician",
          "At 17th level, the cavalier receives an additional teamwork feat as a bonus feat. He must meet the prerequisites for this feat. The cavalier can grant this feat to his allies using the tactician ability. Whenever the cavalier uses the tactician ability, he grants any two teamwork feats that he knows. He can select from any of his teamwork feats, not just his bonus feats.",
          1, "Ability"
      }, //
      {595, "Supreme Charge",
          "At 20th level, whenever the cavalier makes a charge attack while mounted, he deals double the normal amount of damage (or triple if using a lance). In addition, if the cavalier confirms a critical hit on a charge attack while mounted, the target is stunned for 1d4 rounds. A Will save reduces this to staggered for 1d4 rounds. The DC is equal to 10 + the cavalier's base attack bonus. ",
          1, "Ability"
      }, //
      {596, "Order of the Cockatrice",
          "A cavalier who belongs to this order serves only himself, working to further his own aims and increase his own prestige. Cavaliers of this order tend to be selfish and concerned only with personal goals and objectives.",
          1, "Ability"
      }, //
      {597, "Order of the Cockatrice - Braggart",
          "At 2nd level, the cavalier can spend a standard action to extol his own accomplishments and battle prowess. He receives Dazzling Display as a bonus feat. He does not need a weapon in hand to use this ability. The cavalier receives a +2 morale bonus on melee attack rolls made against demoralized targets.",
          1, "Ability"
      }, //
      {598, "Order of the Cockatrice - Steal Glory",
          "At 8th level, the cavalier can steal the glory from another creature's successful strike. Whenever a creature other than the cavalier scores a critical hit against a target that the cavalier is threatening, he can make an attack of opportunity against the same target.",
          1, "Ability"
      }, //
      {599, "Order of the Cockatrice - Moment of Triumph",
          "At 15th level, the cavalier can, as a free action, declare a moment of triumph. For 1 round, the cavalier receives a competence bonus equal to his Charisma modifier on all ability checks, attack rolls, damage rolls, saving throws, and skill checks. This bonus is also added to his AC. In addition, any critical threats he makes are automatically confirmed. The cavalier can use this ability once per day.",
          1, "Ability"
      }, //
      {600, "Order of the Dragon",
          "Cavaliers belonging to the order of the dragon dedicate themselves to a group of like-minded individuals, be it a mercenary company or a small band of adventurers. These cavaliers believe in loyalty and friendship, and are willing to lay down their lives to protect their allies.",
          1, "Ability"
      }, //
      {601, "Order of the Dragon - Aid Allies",
          "At 2nd level, whenever an order of the dragon cavalier uses the aid another action to assist one of his allies, the ally receives a +3 bonus to his Armor Class, attack roll, saving throw, or skill check. At 8th level, and every six levels thereafter, this bonus increases by an additional +1.",
          1, "Ability"
      }, //
      {602, "Order of the Dragon - Strategy",
          "At 8th level, the cavalier can spend a standard action to grant one of a number of bonuses to all allies within 30 feet (including himself). The allies must be able to see or hear the cavalier to receive this bonus. The cavalier can grant a +2 dodge bonus to AC for 1 round, a +2 morale bonus on all attack rolls for 1 round, or the ability to move up to their speed as an immediate action once. The cavalier can grant a different bonus to each ally within range, but allies can only benefit from this ability once per combat.",
          1, "Ability"
      }, //
      {603, "Order of the Dragon - Act as One",
          "At 15th level, the cavalier can spend a standard action to move up to his speed and make a melee attack. All allies within 30 feet can also move up to their speed and make a melee attack as an immediate action. This movement and attack can be made as a charge if the movement qualifies. All attacks are made at a +2 bonus (this stacks with the bonus from a charge) and all participants receive a +2 dodge bonus to their AC for 1 round. A cavalier can use this ability once per combat.",
          1, "Ability"
      }, //
      {604, "Order of the Lion",
          "A cavalier who belongs to this order has pledged himself to a sovereign, be it a king, queen, or even the local warlord. Cavaliers of this order are stalwart and dedicated to their cause, willing to go any length to ensure the safety of their lord and his domain.",
          1, "Ability"
      }, //
      {605, "Order of the Lion - Lion's Call",
          "At 2nd level, an order of the lion cavalier gains the ability to rally his allies. As a standard action, he can give an encouraging speech which grants all allies within 60 feet a competence bonus on their saving throws against fear equal to his Charisma modifier and a +1 competence bonus on attack rolls for a number of rounds equal to his cavalier level. If an ally within range is under the effect of a spell or ability that causes him to be frightened or panicked, he can immediately make another saving throw to resist the effect (if allowed).",
          1, "Ability"
      }, //
      {606, "Order of the Lion - For the King",
          "At 8th level, an order of the lion cavalier can call out to his allies, inspiring them to greatness. As a swift action, the cavalier can grant a competence bonus equal to his Charisma modifier on all attack and damage rolls to all allies within 30 feet. This bonus lasts for 1 round. This ability can be used once per combat.",
          1, "Ability"
      }, //
      {607, "Order of the Lion - Shield of the Liege",
          "At 15th level, an order of the lion cavalier can protect those around him. Allies that are adjacent to the cavalier receive a +2 shield bonus to their AC. In addition, as an immediate action, the cavalier can redirect an attack made at a creature adjacent to himself, as long as the creature making the attack is within the cavalier's reach. This ability must be declared before the attack roll is made. The attack is made against the cavalier's AC and defenses, even if the creature could not normally reach or attack the cavalier. The cavalier loses any cover or concealment bonuses when subject to the redirected attack.",
          1, "Ability"
      }, //
      {608, "Order of the Shield",
          "Cavaliers who join the order of the shield devote their lives to protecting the common folk, from the simple farmer to the honest craftsman. These cavaliers stand before the tide, protecting the innocent from roving marauders and hungry monsters.",
          1, "Ability"
      }, //
      {609, "Order of the Shield - Resolute",
          "At 2nd level, whenever the cavalier takes damage from a melee or ranged attack while wearing heavy armor, the cavalier can convert 1 point of lethal damage to 1 point of nonlethal damage. He can use this ability once each time he takes damage. This ability cannot be used to convert ability damage, ability drain, or energy damage to nonlethal damage. At 6th level, and every four levels thereafter, the amount of damage the cavalier can convert increases by 1.",
          1, "Ability"
      }, //
      {610, "Order of the Shield - Stem the Tide",
          "At 8th level, the cavalier receives Stand Still as a bonus feat, even if he does not meet the prerequisites. Instead of making a combat maneuver check to stop the creature from moving, a cavalier with this ability can elect to make a normal attack instead. If the attack hits and deals damage, the target must stop moving, just as if the cavalier had made a successful combat maneuver check.",
          1, "Ability"
      }, //
      {611, "Order of the Shield - Protect the Meek",
          "At 15th level, the cavalier can move to intercept foes. As an immediate action, he can move up to his speed (or his mount's speed, if mounted) and make a single melee attack. This movement provokes attacks of opportunity as normal. The cavalier must end his movement adjacent to an enemy. On his next turn, the cavalier is staggered and cannot use this ability again for 1 round.",
          1, "Ability"
      }, //
      {612, "Order of the Star",
          "Cavaliers who join the order of the star dedicate themselves to the protection and service of a faith and its members. Cavaliers belonging to this order tend to follow many of the tenets and guides of the religion that they serve. When a cavalier joins this order, he should select a single religion to serve.",
          1, "Ability"
      }, //
      {613, "Order of the Star - Calling",
          "At 2nd level, the cavalier can make a short prayer as a standard action, filling him with confidence in his abilities. At any point in the next minute, he can receive a competence bonus on an ability check, attack roll, saving throw, or skill check equal to his Charisma modifier. He must declare that he is using this bonus before the roll is made. He can use this ability up to four times per day, once for each type of check or roll. In addition, the cavalier adds 1/2 his cavalier level to any levels of paladin or cleric he might possess for the purposes of determining the effects of channel energy or lay on hands.",
          1, "Ability"
      }, //
      {614, "Order of the Star - For the Faith",
          "At 8th level, the cavalier can call upon his faith to bolster himself in combat. As a free action, the cavalier can call out the name of his deity, granting him a morale bonus on attack rolls equal to his Charisma modifier for 1 round. In addition, any allies within 30 feet that share his faith also receive half this bonus (minimum +1). The cavalier can use this ability once per day, plus one additional time per day at 12th level and every four levels thereafter.",
          1, "Ability"
      }, //
      {615, "Order of the Star - Retribution",
          "At 15th level, the cavalier can take retribution on those who dare to strike an agent of his faith. Whenever an enemy makes a successful melee attack against the cavalier or an adjacent ally devoted to the same faith as the cavalier, the enemy provokes an attack of opportunity from the cavalier. The cavalier receives a +2 morale bonus on the attack of opportunity. If the attack made by the enemy was a critical hit, the cavalier may treat the enemy as the target of his challenge for the attack of opportunity. The cavalier can use this ability once per round.",
          1, "Ability"
      }, //
      {616, "Order of the Sword",
          "Cavaliers who join the order of the sword dedicate their lives to the code of chivalry, living a life of honor, valor, and fairness. Cavaliers of this order tend to swear service to a lord or a lady. Of all the orders, the order of the sword is perhaps the broadest in terms of its focus and ideals.",
          1, "Ability"
      }, //
      {617, "Order of the Sword - By My Honor",
          "At 2nd level, the cavalier must select one alignment. As long as he maintains the selected alignment, he receives a +2 morale bonus to one saving throw of his choice.",
          1, "Ability"
      }, //
      {618, "Order of the Sword - Mounted Mastery",
          "At 8th level, the cavalier ignores the armor check penalty when using the Ride skill, regardless of whether or not the creature he is riding is his mount. Whenever he makes a charge attack while mounted, he receives a +4 dodge bonus to his AC to avoid attacks set against his charge. When making such an attack, he can add his mount's Strength modifier to the damage roll, in addition to his own. He also receives a bonus feat, chosen from the following list: Mounted Combat, Ride-By Attack, Skill Focus (Ride), Spirited Charge, Trample, or Unseat. He must qualify for the feat selected.",
          1, "Ability"
      }, //
      {619, "Order of the Sword - Knight's Challenge",
          "At 15th level, the cavalier can make a knight's challenge once per day. This functions like a normal challenge, but the cavalier adds his Charisma bonus on all attack rolls and damage rolls made against the target of his challenge. In addition, he receives a +4 circumstance bonus on attack rolls made to confirm critical hits against the target of his knight's challenge.",
          1, "Ability"
      }, //
      {620, "Spells - Inquisitor",
          "An inquisitor casts divine spells drawn from the inquisitor spell list. She can cast any spell she knows at any time without preparing it ahead of time, assuming she has not yet used up her allotment of spells per day for the spell's level.<br>To learn or cast a spell, an inquisitor must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against an inquisitor's spell is 10 + the spell level + the inquisitor's Wisdom modifier.<br>An inquisitor can cast only a certain number of spells of each spell level each day. Her base daily spell allotment is given on Table 2-3. In addition, she receives bonus spells per day if she has a high Wisdom score (see Table 1-3 of the Pathfinder RPG Core Rulebook).<br>An inquisitor's selection of spells is extremely limited. An inquisitor begins play knowing four 0-level spells and two 1st-level spells of the inquisitor's choice. At each new inquisitor level, she gains one or more new spells as indicated on Table 2-4. (Unlike spells per day, the number of spells an inquisitor knows is not affected by her Wisdom score. The numbers on Table 2-4 are fixed.)<br>Upon reaching 5th level, and at every third inquisitor level thereafter (8th, 11th, and so on), an inquisitor can choose to learn a new spell in place of one she already knows. In effect, the inquisitor 'loses' the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged, and it must be at least one level lower than the highest-level inquisitor spell she can cast. The inquisitor may swap out only a single spell at any given level and must choose whether or not to swap the spell at the same time that she gains new spells known for the level.",
          0, "SpelllistAbility"
      }, //
      {621, "Domain",
          "Like a cleric's deity, an inquisitor's deity influences her alignment, what magic she can perform, and her values. Although not as tied to the tenets of the deity as a cleric, an inquisitor must still hold such guidelines in high regard, despite that fact she can go against them if it serves the greater good of the faith. An inquisitor can select one domain from among those belonging to her deity. She can select an alignment domain only if her alignment matches that domain. With the GM's approval, an inquisitor can be devoted to an ideal instead of a deity, selecting one domain to represent her personal inclination and abilities. The restriction on alignment domains still applies.<br>Each domain grants a number of domain powers, depending on the level of the inquisitor. An inquisitor does not gain the bonus spells listed for each domain, nor does she gain bonus spell slots. The inquisitor uses her level as her effective cleric level when determining the power and effect of her domain powers. If the inquisitor has cleric levels, one of her two domain selections must be the same domain selected as an inquisitor. Levels of cleric and inquisitor stack for the purpose of determining domain powers and abilities, but not for bonus spells.",
          0, "Ability"
      }, //
      {622, "Judgment",
          "Starting at 1st level, an inquisitor can pronounce judgment upon her foes as a swift action. Starting when the judgment is made, the inquisitor receives a bonus or special ability based on the type of judgment made.<br>At 1st level, an inquisitor can use this ability once per day. At 4th level and every three levels thereafter, the inquisitor can use this ability one additional time per day. Once activated, this ability lasts until the combat ends, at which point all of the bonuses immediately end. The inquisitor must participate in the combat to gain these bonuses. If she is frightened, panicked, paralyzed, stunned, unconscious, or otherwise prevented from participating in the combat, the ability does not end, but the bonuses do not resume until she can participate in the combat again.<br>When the inquisitor uses this ability, she must select one type of judgment to make. As a swift action, she can change this judgment to another type. If the inquisitor is evil, she receives profane bonuses instead of sacred, as appropriate. Neutral inquisitors must select profane or sacred bonuses. Once made, this choice cannot be changed.",
          3, "Ability"
      }, //
      {623, "Judgment - Destruction",
          "The inquisitor is filled with divine wrath, gaining a +1 sacred bonus on all weapon damage rolls. This bonus increases by +1 for every three inquisitor levels she possesses.",
          3, "Ability"
      }, //
      {624, "Judgment - Healing",
          "The inquisitor is surrounded by a healing light, gaining fast healing 1. This causes the inquisitor to heal 1 point of damage each round as long as the inquisitor is alive and the judgment lasts. The amount of healing increases by 1 point for every three inquisitor levels she possesses.",
          3, "Ability"
      }, //
      {625, "Judgment - Justice",
          "This judgment spurs the inquisitor to seek justice, granting a +1 sacred bonus on all attack rolls. This bonus increases by +1 for every five inquisitor levels she possesses. At 10th level, this bonus is doubled on all attack rolls made to confirm critical hits.",
          3, "Ability"
      }, //
      {626, "Judgment - Piercing",
          "This judgment gives the inquisitor great focus and makes her spells more potent. This benefit grants a +1 sacred bonus on concentration checks and caster level checks made to overcome a target's spell resistance. This bonus increases by +1 for every three inquisitor levels she possesses.",
          3, "Ability"
      }, //
      {627, "Judgment - Protection",
          "The inquisitor is surrounded by a protective aura, granting a +1 sacred bonus to Armor Class. This bonus increases by +1 for every five inquisitor levels she possesses. At 10th level, this bonus is doubled against attack rolls made to confirm critical hits against the inquisitor.",
          3, "Ability"
      }, //
      {628, "Judgment - Purity",
          "The inquisitor is protected from the vile taint of her foes, gaining a +1 sacred bonus on all saving throws. This bonus increases by +1 for every five inquisitor levels she possesses. At 10th level, the bonus is doubled against curses, diseases, and poisons.",
          3, "Ability"
      }, //
      {629, "Judgment - Resiliency",
          "This judgment makes the inquisitor resistant to harm, granting DR 1/magic. This DR increases by 1 for every five levels she possesses. At 10th level, this DR changes from magic to an alignment (chaotic, evil, good, or lawful) that is opposite the inquisitor's. If she is neutral, the inquisitor does not receive this increase.",
          3, "Ability"
      }, //
      {630, "Judgment - Resistance",
          "The inquisitor is shielded by a flickering aura, gaining 2 points of energy resistance against one energy type (acid, cold, electricity, fire, or sonic) chosen when the judgment is declared. The protection increases by 2 for every three inquisitor levels she possesses.",
          3, "Ability"
      }, //
      {631, "Judgment - Smiting",
          "This judgment bathes the inquisitor's weapons in a divine light. The inquisitor's weapons count as magic for the purposes of bypassing damage reduction. At 6th level, the inquisitor's weapons also count as one alignment type (chaotic, evil, good, or lawful) for the purpose of bypassing damage reduction. The type selected must match one of the inquisitor's alignments. If the inquisitor is neutral, she does not receive this bonus. At 10th level, the inquisitor's weapons also count as adamantine for the purpose of overcoming damage reduction (but not for reducing hardness).",
          3, "Ability"
      }, //
      {632, "Monster Lore",
          "The inquisitor adds her Wisdom modifier on Knowledge skill checks in addition to her Intelligence modifier, when making skill checks to identify the abilities and weaknesses of creatures.",
          1, "Ability"
      }, //
      {633, "Orisons",
          "Inquisitors learn a number of orisons, or 0-level spells, as noted on Table 2-4 under 'Spells Known.' These spells are cast like any other spell, but they are not expended when cast and may be used again. Orisons prepared using other spell slots, such as those due to metamagic feats, are expended normally.",
          0, "Ability"
      }, //
      {634, "Stern Gaze",
          "Inquisitors are skilled at sensing deception and intimidating their foes. An inquisitor receives a morale bonus on all Intimidate and Sense Motive checks equal to 1/2 her inquisitor level (minimum +1).",
          1, "Ability"
      }, //
      {635, "Cunning Initiative",
          "At 2nd level, an inquisitor adds her Wisdom modifier on initiative checks, in addition to her Dexterity modifier.", 1,
          "Ability"
      }, //
      {636, "Detect Alignment",
          "At will, an inquisitor can use detect chaos, detect evil, detect good, or detect law. She can only use one of these at any given time.",
          2, "Ability"
      }, //
      {637, "Track", "At 2nd level, an inquisitor adds half her level on Survival skill checks made to follow or identify tracks.",
          1, "Ability"
      }, //
      {638, "Solo Tactics",
          "At 3rd level, all of the inquisitor's allies are treated as if they possessed the same teamwork feats as the inquisitor for the purpose of determining whether the inquisitor receives a bonus from her teamwork feats. Her allies do not receive any bonuses from these feats unless they actually possess the feats themselves. The allies' positioning and actions must still meet the prerequisites listed in the teamwork feat for the inquisitor to receive the listed bonus.",
          1, "Ability"
      }, //
      {639, "Teamwork Feat",
          "At 3rd level, and every three levels thereafter, the inquisitor gains a bonus feat in addition to those gained from normal advancement. These bonus feats must be selected from those listed as teamwork feats. The inquisitor must meet the prerequisites of the selected bonus feat.<br>As a standard action, the inquisitor can choose to learn a new bonus teamwork feat in place of the most recent bonus teamwork feat she has already learned. In effect, the inquisitor loses the bonus feat in exchange for the new one. She can only change the most recent teamwork feat gained. Whenever she gains a new teamwork feat, the previous teamwork feat becomes set and cannot be changed again. An inquisitor can change her most recent teamwork feat a number of times per day equal to her Wisdom modifier.",
          0, "Ability"
      }, //
      {640, "Bane",
          "At 5th level, an inquisitor can imbue one of her weapons with the bane weapon special ability as a swift action. She must select one creature type when she uses this ability (and a subtype if the creature type selected is humanoid or outsider). Once selected, the type can be changed as a swift action. This ability only functions while the inquisitor wields the weapon. If dropped or taken, the weapon resumes granting this ability if it is returned to the inquisitor before the duration expires. This ability lasts for a number of rounds per day equal to the inquisitor's level. These rounds do not need to be consecutive.",
          3, "Ability"
      }, //
      {641, "Discern Lies",
          "At 5th level, an inquisitor can discern lies, as per the spell, for a number of rounds per day equal to her inquisitor level. These rounds do not need to be consecutive. Activating this ability is an immediate action.",
          2, "Ability"
      }, //
      {642, "Second Judgment",
          "At 8th level, whenever an inquisitor uses her judgment ability, she selects two different judgments, instead of one. This only consumes one use of her judgment ability. As a swift action, she can change one of these judgments to another type.",
          1, "Ability"
      }, //
      {643, "Stalwart",
          "At 11th level, an inquisitor can use mental and physical resiliency to avoid certain attacks. If she makes a Fortitude or Will saving throw against an attack that has a reduced effect on a successful save, she instead avoids the effect entirely. This ability can only be used if the inquisitor is wearing light armor, medium armor, or no armor. A helpless inquisitor does not gain the benefit of the stalwart ability.",
          1, "Ability"
      }, //
      {644, "Greater Bane",
          "At 12th level, whenever an inquisitor uses her bane ability, the amount of bonus damage dealt by the weapon against creatures of the selected type increases to 4d6.",
          3, "Ability"
      }, //
      {645, "Exploit Weakness",
          "At 14th level, the inquisitor learns to take advantage of any opportunity that presents itself. Whenever the inquisitor scores a critical hit, she ignores any damage reduction the target might have. In addition, if the target has regeneration, the creature loses regeneration on the round following the critical hit and can die normally during that round. Creatures whose regeneration always functions are immune to this ability. Finally, if the inquisitor deals energy damage to a creature with vulnerability to that energy type, she deals +1 point of damage per die rolled.",
          1, "Ability"
      }, //
      {646, "Third Judgment",
          "At 16th level, whenever an inquisitor uses her judgment ability, she selects three different judgments, instead of just two. This only consumes one use of her judgment ability. As a swift action, the inquisitor can change one of these judgments to another type.",
          1, "Ability"
      }, //
      {647, "Slayer",
          "At 17th level, an inquisitor learns to focus her judgment. Whenever an inquisitor uses her judgment ability, she must select one type of judgment. She is treated as if she were 5 levels higher for the purposes of determining the bonus granted by the judgment. Unlike other types of judgment, the one enhanced by this ability cannot be changed for the remainder of the judgment",
          1, "Ability"
      }, //
      {648, "True Judgment",
          "At 20th level, an inquisitor can call true judgment down upon a foe during combat. Whenever an inquisitor uses her judgment ability, the inquisitor can invoke true judgment on a foe as a swift action. Once declared, the inquisitor can make a single melee (or ranged attack, if the foe is within 30 feet) against the target. If the attack hits, it deals damage normally and the target must make a Fortitude save or die. The DC of this save is equal to 10 + 1/2 the inquisitor's level + the inquisitor's Wisdom modifier. Regardless of whether or not the save is made, the target creature is immune to the inquisitor's true judgment ability for 24 hours. Once this ability has been used, it cannot be used again for 1d4 rounds.",
          3, "Ability"
      }, //
      {649, "Chaotic, Evil, Good, and Lawful Spells",
          "An inquisitor can't cast spells of an alignment opposed to her own or her deity's (if she has one). Spells associated with particular alignments are indicated by the chaotic, evil, good and lawful descriptors in their spell descriptions. ",
          0, "Ability"
      }, //
      {650, "Spells - Oracle",
          "An oracle casts divine spells drawn from the cleric spell lists. She can cast any spell she knows without preparing it ahead of time. To learn or cast a spell, an oracle must have a Charisma score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against an oracle's spell is 10 + the spell's level + the oracle's Charisma modifier.<br>Like other spellcasters, an oracle can cast only a certain number of spells per day of each spell level. Her base daily spell allotment is given on Table 2-5. In addition, she receives bonus spells per day if she has a high Charisma score (see Table 1-3 of the Pathfinder RPG Core Rulebook).<br>Unlike other divine spellcasters, an oracle's selection of spells is extremely limited. An oracle begins play knowing four 0-level spells and two 1st-level spells of her choice. At each new oracle level, she gains one or more new spells, as indicated on Table 2-6. Unlike spells per day, the number of spells an oracle knows is not affected by her Charisma score, the numbers on Table 2-6 are fixed.<br>In addition to the spells gained by oracles as they gain levels, each oracle also adds all of either the cure spells or the inflict spells to her list of spells known (cure spells include all spells with 'cure' in the name, inflict spells include all spells with 'inflict' in the name). These spells are added as soon as the oracle is capable of casting them. This choice is made when the oracle gains her first level and cannot be changed.<br>Upon reaching 4th level, and at every even-numbered oracle level after that (6th, 8th, and so on), an oracle can choose to learn a new spell in place of one she already knows. In effect, the oracle loses the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged. An oracle may swap only a single spell at any given level, and must choose whether or not to swap the spell at the same time that she gains new spells known for the level. She cannot swap any cure or inflict spells, nor can she swap any spells gained from her mystery.<br>Unlike a cleric, an oracle need not prepare her spells in advance. She can cast any spell she knows at any time, assuming she has not yet used up her spells per day for that spell level. Oracles do not need to provide a divine focus to cast spells that list divine focus (DF) as part of the components.",
          0, "SpelllistAbility"
      }, //
      {651, "Oracle's Curse",
          "Each oracle is cursed, but this curse comes with a benefit as well as a hindrance. This choice is made at 1st level, and once made, it cannot be changed. The oracle's curse cannot be removed or dispelled without the aid of a deity. An oracle's curse is based on her oracle level plus one for every two levels or Hit Dice other than oracle. Each oracle must choose one of the following curses.",
          1, "Ability"
      }, //
      {652, "Oracle's Curse - Clouded Vision",
          "Your eyes are obscured, making it difficult for you to see. You cannot see anything beyond 30 feet, but you can see as if you had darkvision. At 5th level, this distance increases to 60 feet. At 10th level, you gain blindsense out to a range of 30 feet. At 15th level, you gain blindsight out to a range of 15 feet.",
          1, "Ability"
      }, //
      {653, "Oracle's Curse - Deaf",
          "You cannot hear and suffer all of the usual penalties for being deafened. You cast all of your spells as if they were modified by the Silent Spell feat. This does not increase their level or casting time. At 5th level, you receive a +3 competence bonus on Perception checks that do not rely upon hearing, and the initiative penalty for being deaf is reduced to -2. At 10th level, you gain scent and you do not suffer any penalty on initiative checks due to being deaf. At 15th level, you gain tremorsense out to a range of 30 feet.",
          1, "Ability"
      }, //
      {654, "Oracle's Curse - Haunted",
          "Malevolent spirits follow you wherever you go, causing minor mishaps and strange occurrences (such as unexpected breezes, small objects moving on their own, and faint noises). Retrieving any stored item from your gear requires a standard action, unless it would normally take longer. Any item you drop lands 10 feet away from you in a random direction. Add mage hand and ghost sound to your list of spells known. At 5th level, add levitate and minor image to your list of spells known. At 10th level, add telekinesis to your list of spells known. At 15th level, add reverse gravity to your list of spells known.",
          1, "Ability"
      }, //
      {655, "Oracle's Curse - Lame",
          "One of your legs is permanently wounded, reducing your base land speed by 10 feet if your base speed is 30 feet or more. If your base speed is less than 30 feet, your speed is reduced by 5 feet. Your speed is never reduced due to encumbrance. At 5th level, you are immune to the fatigued condition (but not exhaustion). At 10th level, your speed is never reduced by armor. At 15th level, you are immune to the exhausted condition.",
          1, "Ability"
      }, //
      {656, "Oracle's Curse - Tongues",
          "In times of stress or unease, you speak in tongues. Pick one of the following languages: Abyssal, Aklo, Aquan, Auran, Celestial, Ignan, Infernal, or Terran. Whenever you are in combat, you can only speak and understand the selected language. This does not interfere with spellcasting, but it does apply to spells that are language dependent. You gain the selected language as a bonus language. At 5th level, pick an additional language to speak in combat and add it to your list of known languages. At 10th level, you can understand any spoken language, as if under the effects of tongues, even during combat. At 15th level, you can speak and understand any language, but your speech is still restricted during combat.",
          1, "Ability"
      }, //
      {657, "Oracle's Curse - Wasting",
          "Your body is slowly rotting away. You take a -4 penalty on Charisma-based skill checks, except for Intimidate. You gain a +4 competence bonus on saves made against disease. At 5th level, you are immune to the sickened condition (but not nauseated). At 10th level, you gain immunity to disease. At 15th level, you are immune to the nauseated condition.",
          1, "Ability"
      }, //
      {658, "Orisons",
          "Oracles learn a number of orisons, or 0-level spells, as noted on Table 2-6 under 'Spells Known.' These spells are cast like any other spell, but they do not consume any slots and may be used again.",
          0, "Ability"
      }, //
      {659, "Mystery Battle - Class Skills",
          "An oracle with the battle mystery adds Intimidate, Knowledge (engineering), Perception, and Ride to her list of class skills.",
          0, "Ability"
      }, //
      {660, "Spells - Mystery Battle",
          "enlarge person (2nd), fog cloud (4th), magic vestment (6th), wall of fire (8th), righteous might (10th), mass bull's strength (12th), control weather (14th), earthquake (16th), storm of vengeance (18th).",
          0, "SpelllistAbility"
      }, //
      {661, "Mystery Battle - Battlecry",
          "As a standard action, you can unleash an inspiring battlecry. All allies within 100 feet who hear your cry gain a +1 morale bonus on attack rolls, skill checks, and saving throws for a number of rounds equal to your Charisma modifier. At 10th level, this bonus increases to +2. You can use this ability once per day, plus one additional time per day at 5th level and for every five levels thereafter.",
          1, "Ability"
      }, //
      {662, "Mystery Battle - Battlefield Clarity",
          "Once per day, as an immediate action, whenever you fail a saving throw that causes you to become blind, deaf, frightened, panicked, paralyzed, shaken, or stunned, you may attempt that saving throw again, with a +4 insight bonus on the roll. You must take the second result, even if it is worse. At 7th and 15th level, you can use this ability one additional time per day.",
          1, "Ability"
      }, //
      {663, "Mystery Battle - Combat Healer",
          "Whenever you cast a cure spell (a spell with 'cure' in its name), you can cast it as a swift action, as if using the Quicken Spell feat, by expending two spell slots. This does not increase the level of the spell. You can use this ability once per day at 7th level and one additional time per day for every four levels beyond 7th. You must be at least 7th level to select this revelation.",
          3, "Ability"
      }, //
      {664, "Mystery Battle - Iron Skin",
          "Once per day, your skin hardens and takes on the appearance of iron, granting you DR 10/adamantine. This functions as stoneskin, using your oracle level as the caster level. At 15th level, you can use this ability twice per day. You must be at least 11th level to select this revelation.",
          1, "Ability"
      }, //
      {665, "Mystery Battle - Maneuver Mastery",
          "Select one type of combat maneuver. When performing the selected maneuver, you treat your oracle level as your base attack bonus (plus the BAB from other classes) when determining your CMB. At 7th level, you gain the Improved feat (such as Improved Trip) that grants you a bonus when performing that maneuver. At 11th level, you gain the Greater feat (such as Greater Trip) that grants you a bonus when performing that maneuver. You do not need to meet the prerequisites to receive these feats.",
          1, "Ability"
      }, //
      {666, "Mystery Battle - Resiliency",
          "You are not disabled and you do not gain the staggered condition if you are reduced to exactly 0 hit points. At 7th level, you gain Diehard as a bonus feat. At 11th level, you do not lose a hit point when you take a standard action while disabled. You do not need to meet the prerequisite to receive the Diehard feat.",
          1, "Ability"
      }, //
      {667, "Mystery Battle - Skill at Arms", "You gain proficiency in all martial weapons and heavy armor.", 1, "Ability"}, //
      {668, "Mystery Battle - Surprising Charge",
          "Once per day, you can move up to your speed as an immediate action. You can use this ability one additional time per day at 7th level and 15th level.",
          1, "Ability"
      }, //
      {669, "Mystery Battle - War Sight",
          "Whenever you roll for initiative, you can roll twice and take either result. At 7th level, you can always act in the surprise round, but if you fail to notice the ambush, you act last, regardless of your initiative result (you act in the normal order in following rounds). At 11th level, you can roll for initiative three times and take any one of the results.",
          3, "Ability"
      }, //
      {670, "Mystery Battle - Weapon Mastery",
          "Select one weapon with which you are proficient. You gain Weapon Focus with that weapon. At 8th level, you gain Improved Critical with that weapon. At 12th level, you gain Greater Weapon Focus with that weapon. You do not need to meet the prerequisites to receive these feats.",
          1, "Ability"
      }, //
      {671, "Mystery Battle - Final Revelation",
          "Upon reaching 20th level, you become an avatar of battle. You can take a full-attack action and move up to your speed as a full-round action (you can move before or after the attacks). Whenever you score a critical hit, you can ignore any DR the target might possess. You gain a +4 insight bonus to your AC for the purpose of confirming critical hits against you. When you are below 0 hit points, you do not die until your negative total is in excess of twice your Constitution score.",
          0, "Ability"
      }, //
      {672, "Mystery Bones - Class Skills",
          "An oracle with a bones mystery adds Bluff, Disguise, Intimidate, and Stealth to her list of class skills.", 0, "Ability"
      }, //
      {673, "Spells - Mystery Bones",
          "cause fear (2nd), false life (4th), animate dead (6th), fear (8th), slay living (10th), circle of death (12th), control undead (14th), horrid wilting (16th), wail of the banshee (18th).",
          0, "SpelllistAbility"
      }, //
      {674, "Mystery Bones - Armor of Bones",
          "You can conjure armor made of bones that grants you a +4 armor bonus. At 7th level, and every four levels thereafter, this bonus increases by +2. At 13th level, this armor grants you DR 5/bludgeoning. You can use this armor for 1 hour per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-hour increments.",
          3, "Ability"
      }, //
      {675, "Mystery Bones - Bleeding Wounds",
          "Whenever a creature takes damage from one of your spells or effects that causes negative energy damage (such as inflict light wounds or the death's touch revelation), it begins to bleed, taking 1 point of damage each round. At 5th level, and every five levels thereafter, this damage increases by 1. The bleeding can be stopped by a DC 15 Heal check or any effect that heals damage.",
          3, "Ability"
      }, //
      {676, "Mystery Bones - Death's Touch",
          "You can cause terrible wounds to appear on a creature with a melee touch attack. This attack deals 1d6 points of negative energy damage +1 point for every two oracle levels you possess. If used against an undead creature, it heals damage and grants a +2 channel resistance for 1 minute. You can use this ability a number of times per day equal to 3 + your Charisma modifier.",
          3, "Ability"
      }, //
      {677, "Mystery Bones - Near Death",
          "You gain a +2 insight bonus on saves against diseases, mind-affecting effects, and poisons. At 7th level, this bonus also applies on saves against death effects, sleep effects, and stunning. At 11th level, the bonus increases to +4.",
          3, "Ability"
      }, //
      {678, "Mystery Bones - Raise the Dead",
          "As a standard action, you can summon a single skeleton or zombie to serve you. The undead creature has a number of Hit Dice equal to your oracle level. It remains for a number of rounds equal to your Charisma modifier. At 7th level, you can summon a bloody skeleton or fast zombie. At 15th level, you can summon an advanced skeleton or zombie. You can use this ability once per day plus one additional time per day at 10th level.",
          3, "Ability"
      }, //
      {679, "Mystery Bones - Resist Life",
          "You are treated as an undead creature when you are targeted by positive or negative energy. You are not subject to Turn Undead or Command Undead (or any other effect that specifically targets undead), unless you are actually an undead creature. At 7th level, you receive channel resistance +2. This bonus increases by +2 at 11th and 15th level.",
          3, "Ability"
      }, //
      {680, "Mystery Bones - Soul Siphon",
          "As a ranged touch attack, you can unleash a ray that causes a target to gain one negative level. The ray has a range of 30 feet. This negative level lasts for a number of minutes equal to your Charisma modifier. Whenever this ability gives a target a negative level, you heal a number of hit points equal to your oracle level. You can use this ability once per day, plus one additional time at 11th level and every four levels thereafter. You must be at least 7th level to select this revelation.",
          3, "Ability"
      }, //
      {681, "Mystery Bones - Spirit Walk",
          "As a standard action, you can become incorporeal and invisible. While in this form, you can move in any direction and through any object (except for those made of force). You can take no action other than to move while in this form. You remain in this form for a number of rounds equal to your oracle level, but you can end this effect prematurely with a standard action. You can use this ability once per day at 11th level, and twice per day at 15th level. You must be at least 11th level to select this revelation.",
          3, "Ability"
      }, //
      {682, "Mystery Bones - Undead Servitude",
          "You gain Command Undead as a bonus feat. You can channel negative energy a number of times per day equal to 3 + your Charisma modifier, but only to use Command Undead. You can take other feats to add to this ability, such as Improved Channeling, but not feats that alter this ability, such as Alignment Channel.",
          3, "Ability"
      }, //
      {683, "Mystery Bones - Voice of the Grave",
          "You can speak with dead, as per the spell, for a number of rounds per day equal to your oracle level. These rounds do not need to be consecutive. At 5th level, and every five levels thereafter, the dead creature takes a cumulative -2 penalty on its Will save to resist this effect.",
          3, "Ability"
      }, //
      {684, "Mystery Bones - Final Revelation",
          "Upon reaching 20th level, you become a master of death. Once per round, you can cast bleed or stabilize as a free action. If you are brought to below 0 hit points, you automatically stabilize. You can cast animate dead at will without paying a material component cost (although you are still subject to the usual Hit Die control limit). Once per day, you can cast power word kill, but the spell can target a creature with 150 hit points or less.",
          0, "Ability"
      }, //
      {685, "Mystery Heavens - Class Skills",
          "An oracle with the heavens mystery adds Fly, Knowledge (arcana), Perception, and Survival to her list of class skills.",
          0, "Ability"
      }, //
      {686, "Spells - Mystery Heavens",
          "color spray (2nd), hypnotic pattern (4th), daylight (6th), rainbow pattern (8th), overland flight (10th), chain lightning (12th), prismatic spray (14th), sunburst (16th), meteor swarm (18th).",
          0, "SpelllistAbility"
      }, //
      {687, "Mystery Heavens - Awesome Display",
          "Your phantasmagoric displays accurately model the mysteries of the night sky, dumbfounding all who behold them. Each creature affected by your illusion (pattern) spells is treated as if its total number of Hit Dice were equal to its number of Hit Dice minus your Charisma modifier (if positive).",
          3, "Ability"
      }, //
      {688, "Mystery Heavens - Coat of Many Stars",
          "You conjure a coat of starry radiance that grants you a +4 armor bonus. At 7th level, and every four levels thereafter, this bonus increases by +2. At 13th level, this armor grants you DR 5/slashing. You can use this coat for 1 hour per day per oracle level. The duration does not need to be consecutive, it can instead be spent in 1-hour increments.",
          2, "Ability"
      }, //
      {689, "Mystery Heavens - Dweller in Darkness",
          "Once per day, you cast your psyche into the void of space to attract the attention of a terrible otherworldly being. The dweller in darkness behaves in all ways as if you had cast phantasmal killer. At 17th level, the dweller in darkness can be perceived by more than one creature, as if you had cast weird. You must be at least 11th level to choose this revelation.",
          3, "Ability"
      }, //
      {690, "Mystery Heavens - Guiding Star",
          "Whenever you can see the open sky at night, you can determine your precise location. When the night sky is visible to you, you may also add your Charisma modifier to your Wisdom modifier on all Wisdom-based checks. In addition, once per night while outdoors, you can cast one spell as if it were modified by the Empower Spell, Extend Spell, Silent Spell, or Still spell feat without increasing the spell's casting time or level.",
          3, "Ability"
      }, //
      {691, "Mystery Heavens - Interstellar Void",
          "You call upon the frigid depths of outer space to bring a terrible chill to your enemies. As a standard action, one target within 30 feet is cloaked in the void and takes 1d6 points of cold damage per level. A successful Fortitude save halves this damage. At 10th level, the interstellar void is so extreme that enemies who fail their saving throw are fatigued. At 15th level, creatures who fail their save are exhausted and stunned for 1 round. You can use this ability once per day plus one additional time per day at 10th level.",
          3, "Ability"
      }, //
      {692, "Mystery Heavens - Lure of the Heavens",
          "Your connection to the skies above is so strong that your feet barely touch the ground. At 1st level, you no longer leave tracks. At 5th level, you can hover up to 6 inches above the ground or even above liquid surfaces, as if levitating. At 10th level, you gain the ability to fly, as per the spell, for a number of minutes per day equal to your oracle level. This duration does not need to be consecutive, but it must be spent in 1-minute increments.",
          3, "Ability"
      }, //
      {693, "Mystery Heavens - Mantle of Moonlight",
          "Your innate understanding of the moon renders you immune to lycanthropy. Additionally, you may disrupt a lycanthrope's connection to the moon with a successful touch attack. This action automatically forces the lycanthrope into its humanoid form, which it must remain in for a number of rounds equal to your oracle level. Upon reaching 5th level, you can use this ability to force others into a rage, as per the spell. Using this ability is a melee touch attack. You can use this ability once per day at 5th level plus one additional time per day for every 5 levels above 5th.",
          3, "Ability"
      }, //
      {694, "Mystery Heavens - Moonlight Bridge",
          "You summon a bridge of shimmering moonlight. The 10-foot-wide span touches the ground at a point adjacent to your position. From this point it can extend in any direction for 10 feet per oracle level. The path persists until you have crossed over the bridge or for 24 hours, whichever is shorter. You may summon a moonlight bridge a number of times per day equal to your Charisma bonus. Should the bridge be attacked, treat it as a wall of force.",
          3, "Ability"
      }, //
      {695, "Mystery Heavens - Spray of Shooting Stars",
          "As a standard action, you can unleash a ball of energy that explodes in a 5-foot-radius burst dealing 1d4 points of fire damage per level. A successful Reflex save halves this damage. This attack has a range of 60 feet. You can fire one explosive ball per day, plus one additional ball per day at 5th level and for every 5 levels thereafter. You can fire more than one ball at a time, but creatures caught inside more than one simultaneous explosions only take damage once.",
          3, "Ability"
      }, //
      {696, "Mystery Heavens - Star Chart",
          "Your copious notes contain a working model of the night sky expressed in artistic scribbles and arcane mathematical formulae. Once per day, you may spend 10 minutes contemplating your star chart to gain the benefit of the spell commune. You must be at least 7th level to select this revelation.",
          1, "Ability"
      }, //
      {697, "Mystery Heavens - Final Revelation",
          "Upon achieving 20th level, your rapport with the heavens grants you perfect harmony with the universe. You receive a bonus on all saving throws equal to your Charisma modifier. You automatically stabilize if you are below 0 hit points, are immune to fear effects, and automatically confirm all critical hits. Should you die, you are reborn 3 days later in the form of a star child, who matures over the course of 7 days (treat as the reincarnate spell).",
          0, "Ability"
      }, //
      {698, "Mystery Life - Class Skills",
          "An oracle with the life mystery adds Handle Animal, Knowledge (nature), and Survival to her list of class skills.", 0,
          "Ability"
      }, //
      {699, "Spells - Mystery Life",
          "detect undead (2nd), lesser restoration (4th), neutralize poison (6th), restoration (8th), breath of life (10th), heal (12th), greater restoration (14th), mass heal (16th), true resurrection (18th).",
          0, "SpelllistAbility"
      }, //
      {700, "Mystery Life - Channel",
          "You can channel positive energy like a cleric, using your oracle level as your effective cleric level when determining the amount of damage healed (or caused to undead) and the DC. You can use this ability a number of times per day equal to 1 + your Charisma modifier.",
          3, "Ability"
      }, //
      {701, "Mystery Life - Combat Healer", "As the battle mystery revelation.", 3, "Ability"}, //
      {702, "Mystery Life - Delay Affliction",
          "Once per day as an immediate action, whenever you fail a saving throw against a disease or poison, you may ignore its effects for 1 hour per level. At 7th and 15th level, you can use this ability one additional time per day.",
          3, "Ability"
      }, //
      {703, "Mystery Life - Energy Body",
          "As a standard action, you can transform your body into pure life energy, resembling a golden-white fire elemental. In this form, you gain the elemental subtype and give off a warm, welcoming light that increases the light level within 10 feet by one step, up to normal light. Any undead creature striking you with its body or a handheld weapon deals normal damage, but at the same time the attacker takes 1d6 points of positive energy damage + 1 point per oracle level. Creatures wielding melee weapons with reach are not subject to this damage if they attack you. If you grapple or attack an undead creature using unarmed strikes or natural weapons, you may deal this damage in place of the normal damage for the attack. Once per round, if you pass through a living allied creature's square or the ally passes through your square, it heals 1d6 hit points + 1 per oracle level. You may use this ability to heal yourself as a move action. You choose whether or not to heal a creature when it passes through your space. You may return to your normal form as a free action. You may remain in energy body form for a number of rounds per day equal to your oracle level.",
          3, "Ability"
      }, //
      {704, "Mystery Life - Enhanced Cures",
          "Whenever you cast a cure spell, the maximum number of hit points healed is based on your oracle level, not the limit based on the spell. For example, an 11th-level oracle of life with this revelation may cast cure light wounds to heal 1d8+11 hit points instead of the normal 1d8+5 maximum.",
          3, "Ability"
      }, //
      {705, "Mystery Life - Healing Hands",
          "You gain a +4 bonus on Heal checks. You may provide first aid to two people or treat two people for poison as a standard action (make a separate Heal check for each creature). When using the Heal skill to treat wounds from caltrops (and so on), treat deadly wounds, treat poison, treat disease, or treat long-term care, you may treat double the normal number of people you may treat at the same time. You may provide long-term care for yourself.",
          1, "Ability"
      }, //
      {706, "Mystery Life - Life Link",
          "As a standard action, you may create a bond between yourself and another creature. Each round at the start of your turn, if the bonded creature is wounded for 5 or more hit points below its maximum hit points, it heals 5 hit points and you take 5 hit points of damage. You may have one bond active per oracle level. This bond continues until the bonded creature dies, you die, the distance between you and the other creature exceeds medium range, or you end it as an immediate action (if you have multiple bonds active, you may end as many as you want as part of the same immediate action).",
          3, "Ability"
      }, //
      {707, "Mystery Life - Lifesense",
          "You notice and locate living creatures within 30 feet, just as if you possessed the blindsight ability. You must be at least 11th level to select this revelation.",
          3, "Ability"
      }, //
      {708, "Mystery Life - Safe Curing",
          "Whenever you cast a spell that cures the target of hit point damage, you do not provoke attacks of opportunity for spellcasting.",
          3, "Ability"
      }, //
      {709, "Mystery Life - Spirit Boost",
          "Whenever your healing spells heal a target up to its maximum hit points, any excess points persist for 1 round per level as temporary hit points (up to a maximum number of temporary hit points equal to your oracle level).",
          3, "Ability"
      }, //
      {710, "Mystery Life - Final Revelation",
          "Upon reaching 20th level, you become a perfect channel for life energy. You become immune to bleed, death attacks, exhaustion, fatigue, nausea effects, negative levels, and sickened effects. Ability damage and drain cannot reduce you below 1 in any ability score. You automatically make saving throws against massive damage. When you are below 0 hit points, you do not die until your negative total is in excess of twice your Constitution score.",
          0, "Ability"
      }, //
      {711, "Mystery Lore - Class Skills",
          "An oracle with the lore mystery adds Appraise and all Knowledge skills to her list of class skills.", 0, "Ability"
      }, //
      {712, "Spells - Mystery Lore",
          "identify (2nd), tongues (4th), locate object (6th), legend lore (8th), contact other plane (10th), mass owl's wisdom (12th), vision (14th), moment of prescience (16th), time stop (18th).",
          0, "SpelllistAbility"
      }, //
      {713, "Mystery Lore - Arcane Archivist",
          "Your experience with lore-filled tomes has granted you the ability to cast arcane spells as if they were on your spell list. Once per day, you can cast a spell from the sorcerer/wizard spell list as if it were on your list of spells known. The spell consumes a spell slot one level higher than the level of the spell. You must have a spellbook containing the spell to cast it in this way, and the spell is erased when you complete the casting. You must be at least 11th level to select this revelation.",
          3, "Ability"
      }, //
      {714, "Mystery Lore - Automatic Writing",
          "Once per day, you can spend a full hour in uninterrupted meditation. During this period, your hands produce mysterious writing that pertains to the future. At 1st level, the prophetic writing manifests as an augury spell with 90% effectiveness. At 5th level, the writing takes the form of a divination with 90% effectiveness. At 8th level, the writing manifests as a casting of commune with no material component required.",
          3, "Ability"
      }, //
      {715, "Mystery Lore - Brain Drain",
          "You can take a standard action to violently probe the mind of a single intelligent enemy within 100 feet. The target receives a Will save to negate the effect and immediately knows the source of this harmful mental prying. Those who fail this save are wracked with pain, taking 1d4 points of damage per oracle level. After successfully attacking with this ability, you may use a full-round action to sort through the jumble of stolen thoughts and memories to make a single Knowledge check using the victim's skill bonus. The randomly stolen thoughts remain in your mind for a number of rounds equal to your Charisma modifier. Treat the knowledge gained as if you used detect thoughts. This is a mind-affecting effect. You can use this ability once per day at 1st level, plus one additional time per day at 5th level and for every 5 levels beyond 5th.",
          3, "Ability"
      }, //
      {716, "Mystery Lore - Focused Trance",
          "You can enter a deep meditation, blocking out visual and auditory stimuli and allowing you to concentrate on a single problem, philosophical issue, or memory. This trance lasts 1d6 rounds, during which time you can only take move actions. During this period, you gain a bonus equal to your level on all saves against sonic effects and gaze attacks. When you come out of your trance, you may make a single Intelligence-based skill check with a +20 circumstance bonus. You may enter your focused trance a number of times per day equal to your Charisma modifier.",
          1, "Ability"
      }, //
      {717, "Mystery Lore - Lore Keeper",
          "Instead of encyclopedic knowledge, you learn most of your information through tales, songs, and poems. You may use your Charisma modifier instead of your Intelligence modifier on all Knowledge checks.",
          1, "Ability"
      }, //
      {718, "Mystery Lore - Mental Acuity",
          "Your explorations into the secret mysteries of the world have granted you a preternatural understanding of all things-and you just keep getting smarter. You gain a +1 inherent bonus to Intelligence upon taking this revelation and another at every third oracle level gained thereafter. You must be at least 7th level to select this revelation.",
          3, "Ability"
      }, //
      {719, "Mystery Lore - Sidestep Secret",
          "Your innate understanding of the universe has granted you preternatural reflexes and the uncanny ability to step out of danger at the very last second. Add your Charisma modifier (instead of your Dexterity modifier) to your Armor Class and all Reflex saving throws. Your armor's maximum Dexterity bonus applies to your Charisma instead of your Dexterity.",
          3, "Ability"
      }, //
      {720, "Mystery Lore - Spontaneous Symbology",
          "Your knowledge of the secret history of the world has unveiled the mysterious symbols that govern reality. You can cast any 'symbol' spell using a spell slot of the appropriate level, even if the spell is not on your list of spells known. A symbol spell is any spell with the word 'symbol' in its name. You must be at least 11th level to select this revelation.",
          3, "Ability"
      }, //
      {721, "Mystery Lore - Think On It",
          "Once per day, the oracle of lore can re-attempt any previously failed Knowledge check. On this attempt, add a +10 competence bonus on the check.",
          1, "Ability"
      }, //
      {722, "Mystery Lore - Whirlwind Lesson",
          "You can quickly browse through a magical tome or manual, gaining its benefits with only a single 8-hour study session (rather than the usual 48 hours over a period of 6 days). At 7th level, you may allow another character to join in your study, both of you gain the full benefit of having read the book. At 15th level, you may share your whirlwind lesson with a number of characters equal to your oracle level. The benefits to you are permanent, whereas your students gain the tome or manual's benefits for a number of days equal to your Charisma modifier but then forget what they have learned.",
          1, "Ability"
      }, //
      {723, "Mystery Lore - Final Revelation",
          "You gain the ability to take 20 on all Knowledge skill checks. Your understanding of the fundamental underpinnings of reality has also become so advanced that once per day, you can cast wish. This ability does not require a material component, but the wish cannot be used to grant ability score bonuses, nor can it be used to replicate spells with expensive material components.",
          0, "Ability"
      }, //
      {724, "Mystery Nature - Class Skills",
          "An oracle with the nature mystery adds Climb, Fly, Knowledge (nature), Ride, Survival, and Swim to her list of class skills.",
          0, "Ability"
      }, //
      {725, "Spells - Mystery Nature",
          "charm animal (2nd), barkskin (4th), speak with plants (6th), grove of respite* (8th), awaken (10th), stone tell (12th), creeping doom (14th), animal shapes (16th), world wave* (18th).",
          0, "SpelllistAbility"
      }, //
      {726, "Mystery Nature - Bonded Mount",
          "You gain the service of an unusually intelligent, strong, and loyal mount. The creature must be one that you are capable of riding and is suitable as a mount. A Medium oracle can select a camel or a horse. A Small oracle can select a pony or wolf, but can also select a boar or a dog if she is at least 4th level. This mount functions as a druid's animal companion, using your oracle level as your effective druid level. Bonded mounts have an Intelligence score of at least 6.",
          3, "Ability"
      }, //
      {727, "Mystery Nature - Erosion Touch",
          "As a melee touch attack, you can deal 1d6 points of damage per level to objects or constructs. If used against an object in another creature's possession, treat this attack as a sunder combat maneuver. You can use this ability once per day, plus one time per day for every three levels you possess.",
          3, "Ability"
      }, //
      {728, "Mystery Nature - Friend to the Animals",
          "Add all summon nature's ally spells to your spell list. You must still select these spells using your allotment of spells known. Animals within 30 feet of you receive a bonus on all saving throws equal to your Charisma modifier.",
          1, "Ability"
      }, //
      {729, "Mystery Nature - Life Leach",
          "You can draw life force from the bodies of enemies and channel it into yourself. As a standard action, you can drain the life essence from one living target within 30 feet. The target takes 1d6 points of damage per two levels you possess (maximum 10d6). You gain temporary hit points equal to the damage you deal. You can't gain more than the target's current hit points + the target's Constitution score (which is enough to kill the subject). The temporary hit points last a number of hours equal to your Charisma modifier. The target receives a Fortitude save to halve the damage (and the temporary hit points you gain). You may use this ability once per day at 7th level, plus one additional time per day for every 4 levels you possess beyond 7th. You must be at least 7th level before selecting this revelation.",
          3, "Ability"
      }, //
      {730, "Mystery Nature - Natural Divination",
          "You can read the entrails of a freshly killed animal or humanoid to gain an insight bonus equal to your Charisma modifier on one saving throw. Alternatively, by observing and interpreting the flights of birds, you may apply a +10 competence bonus on any one skill check. Finally, by charting marks in dirt or stone, or observing the behavior of sand when thrown into the wind, you gain a +4 insight bonus on one initiative check. These bonuses must be used during the next 24 hours and you must declare you are using the bonus before the check or save is made. Making a natural divination takes 10 minutes. You may use natural divination (in any combination) once per day plus one additional time per day for every four oracle levels you have attained.",
          1, "Ability"
      }, //
      {731, "Mystery Nature - Nature's Whispers",
          "You have become so attuned to the whispers of the natural world, from the croaking of frogs to the groaning of great boulders, that your surroundings constantly keep you preternaturally aware of danger. You may add your Charisma modifier, instead of your Dexterity modifier, to your Armor Class and CMD. Any condition that would cause you to lose your Dexterity modifier to your Armor Class instead causes you to lose your Charisma modifier to your Armor Class.",
          1, "Ability"
      }, //
      {732, "Mystery Nature - Speak with Animals",
          "Choose a specific kind of animal (eagle, fox, dog, and so on). You gain the ability to converse with that type of animal as if you were under the effects of speak with animal. You gain the ability to communicate with an additional kind of animal for every 3 oracle levels you have attained.",
          1, "Ability"
      }, //
      {733, "Mystery Nature - Spirit of Nature",
          "When in a natural setting, whenever you are reduced to negative hit points, you automatically stabilize. At 5th level, you gain fast healing 1 for 1d4 rounds whenever you are reduced to negative hit points. At 10th level, the ability works everywhere, even in civilized or wholly artificial realms. At 15th level, you gain fast healing 3 for 1d4 rounds when reduced to negative hit points.",
          3, "Ability"
      }, //
      {734, "Mystery Nature - Transcendental Bond",
          "You become so attuned to the common spirit shared by all living things that you can use it to communicate with allies. You may communicate with your allies for a number of rounds per day equal to your oracle level as if using telepathic bond. You may designate a number of creatures as your ally equal to your Charisma modifier. Designating a creature is a standard action that requires a touch. At 10th level, you may use this bond to cast a touch spell on a designated ally once per day.",
          3, "Ability"
      }, //
      {735, "Mystery Nature - Undo Artifice",
          "At 11th-level, you gain the ability to reduce a nonliving item to its component parts, essentially erasing the hand of artifice and rendering the item into a pile of raw natural materials. This effect acts as the spell polymorph any object, working on both magical and nonmagical nonliving objects. The duration is always permanent. Unlike polymorph any object, it cannot be used to mimic the effects of other spells. Items subject to this effect receive a Fortitude saving throw to negate the effect. Magic items receive a circumstance bonus on this save equal to +1 for every 5,000 gp in the item's value. You may use undo artifice a number of times per day equal to your Charisma modifier.",
          2, "Ability"
      }, //
      {736, "Mystery Nature - Final Revelation",
          "At 20th level, you have discovered the intrinsic secrets of life itself, granting you incredible control over your own body. Once per day, you can surround yourself with an organic cocoon as a full-round action. While enclosed in the cocoon, you are considered helpless. Eight hours later, you emerge having changed your type to plant, animal, or humanoid, gaining superficial physical characteristics as appropriate (see the Pathfinder RPG Bestiary). This change does not alter your Hit Dice, hit points, saving throws, skill points, class skills, or proficiencies. Each time the transformation is made, you are cleansed of all poisons or diseases, are restored to full hit points, and heal all ability damage. You must select a new type every time the transformation is made.",
          3, "Ability"
      }, //
      {737, "Mystery Stone - Class Skills",
          "An oracle with the stone mystery adds Appraise, Climb, Intimidate, and Survival to her list of class skills.", 0,
          "Ability"
      }, //
      {738, "Spells - Mystery Stone",
          "magic stone (2nd), stone call* (4th), meld into stone (6th), wall of stone (8th), stoneskin (10th), stone tell (12th), statue (14th), repel metal or stone (16th), clashing rocks* (18th).",
          0, "SpelllistAbility"
      }, //
      {739, "Mystery Stone - Acid Skin",
          "You gain resist acid 5. This resistance increases to 10 at 5th level and 20 at 11th level. At 17th level, you gain immunity to acid.",
          1, "Ability"
      }, //
      {740, "Mystery Stone - Clobbering Strike",
          "Whenever you score a critical hit against an opponent with a spell that requires an attack roll, you may immediately attempt to trip your opponent as a swift action. You do not provoke an attack of opportunity as normal for this trip attempt. You cannot be tripped in return when using this ability.",
          1, "Ability"
      }, //
      {741, "Mystery Stone - Crystal Sight",
          "You can see through stone, earth, or sand as easily as if it were transparent crystal. Your gaze can penetrate a number of feet equal to your oracle level, or 1/12th this thickness of metal. You can use this ability a number of rounds per day equal to your oracle level, but these rounds do not need to be consecutive.",
          1, "Ability"
      }, //
      {742, "Mystery Stone - Earth Glide",
          "You can pass through stone, dirt, or almost any other sort of earth except worked stone and metal as easily as a fish swims through water. If protected against fire damage, you can even glide through lava. You glide at your base land speed. While gliding, you breathe stone as if it were air (you do not need to hold your breath). Your burrowing leaves behind no tunnel or hole, nor does it create any ripple or sign of your presence. A move earth spell cast on an area where you are flings you back 30 feet, stunning you for 1 round unless you succeed on a DC 15 Fortitude save. Activating this ability is a free action. You can glide for 1 minute per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-minute increments. You must be at least 7th level to select this revelation. You can bring other creatures with you when you glide, but each passenger costs an additional minute per minute of travel.",
          3, "Ability"
      }, //
      {743, "Mystery Stone - Mighty Pebble",
          "As a standard action, you can charge and throw a pebble (or other stone of similar size) that detonates when it strikes a target as a ranged attack. The pebble has a range increment of 20 feet and has a +1 enhancement bonus to attack and damage for every four oracle levels you possess. Any creature struck by the pebble takes 1d6 points of bludgeoning damage per two oracle levels you possess (minimum 1d6). Creatures in squares adjacent to the target take half damage, or no damage if they make a Reflex saving throw. If the attack roll misses, treat the pebble as a thrown splash weapon to determine where it lands. You can use this ability once per day, plus one additional time per day at 5th level and every five levels thereafter.",
          3, "Ability"
      }, //
      {744, "Mystery Stone - Rock Throwing",
          "You are an accomplished rock thrower and have a +1 racial bonus on attack rolls with thrown rocks. You can hurl rocks up to two categories smaller than your own size. The range increment for a rock is 20 feet, and you can hurl it up to 5 range increments. Damage for a hurled rock is 2d4 for a Medium creature or 2d3 for a Small creature, plus 1-1/2 your Strength bonus.",
          1, "Ability"
      }, //
      {745, "Mystery Stone - Shard Explosion",
          "As a swift action, you can cause jagged pieces of stone to explode outward from your body. These shards deal 1d6 points of piercing damage per two oracle levels (minimum 1d6) to all creatures within a 10-foot burst. A Reflex save halves this damage. In addition, the broken shards make the area difficult terrain until your next turn. You can use this ability once per day, plus one additional time per day at 5th level and every five levels thereafter.",
          3, "Ability"
      }, //
      {746, "Mystery Stone - Steelbreaker Skin",
          "As a standard action, you can harden your flesh so that weapons that strike you are damaged or destroyed. Anytime a melee or ranged weapon strikes you, the weapon takes an amount of damage equal to your oracle level. This ability does not prevent the weapon from harming you unless the damage destroys the weapon attacking you. You can use this ability once per day, but the duration is 1 minute/level. You must be at least 7th level to select this revelation. At 15th level, the damage from this ability ignores up to 10 points of hardness.",
          3, "Ability"
      }, //
      {747, "Mystery Stone - Stone Stability",
          "You receive a +4 bonus to your Combat Maneuver Defense when resisting a bull rush or trip attempt while standing on the ground. At 5th level, you gain Improved Trip as a bonus feat. At 10th level, you gain Greater Trip as a bonus feat. You do not need to meet the prerequisites to gain these feats.",
          1, "Ability"
      }, //
      {748, "Mystery Stone - Touch of Acid",
          "As a standard action, you can perform a melee touch attack that deals 1d6 points of acid damage +1 point for every two oracle levels you possess. You can use this ability a number of times per day equal to 3 + your Charisma modifier. At 11th level, any weapon that you wield deals +1d6 points of acid damage, similar to how a flaming weapon operates.",
          3, "Ability"
      }, //
      {749, "Mystery Stone - Final Revelation",
          "Upon reaching 20th level, you become a master of acid and earth. You can apply any one of the following feats to any acid or earth spell without increasing the level or casting time: Enlarge Spell, Extend Spell, Silent Spell, or Still Spell.",
          0, "Ability"
      }, //
      {750, "Mystery Waves - Class Skills",
          "An oracle with the waves mystery adds Acrobatics, Escape Artist, Knowledge (nature), and Swim to her list of class skills.",
          0, "Ability"
      }, //
      {751, "Spells - Mystery Waves",
          "touch of the sea* (2nd), slipstream* (4th), water breathing (6th), wall of ice (8th), geyser* (10th), fluid form* (12th), vortex* (14th), seamantle* (16th), tsunami* (18th).",
          0, "SpelllistAbility"
      }, //
      {752, "Mystery Waves - Blizzard",
          "As a standard action, you can create a blizzard of snow and ice. You can create one 10-foot-cube of storm per oracle level. These cubes can be arranged in any pattern you desire, but each cube must be adjacent to another and one must be adjacent to you. Any creature caught in the blizzard takes 1d4 points of cold damage per oracle level, with a Reflex save resulting in half damage. The storm lasts for a number of rounds equal to your Charisma modifier, the ground remains icy (+5 to Acrobatics DCs) as long as local conditions permit. The blizzard obscures sight beyond 5 feet, providing total concealment. A creature within 5 feet has concealment. You can use this ability once per day. You must be 11th level to select this revelation.",
          3, "Ability"
      }, //
      {753, "Mystery Waves - Fluid Nature",
          "You receive a +4 bonus to your Combat Maneuver Defense against bull rush, drag, grapple, reposition, and trip attempts. A creature trying to confirm a critical hit against you has a -4 penalty on its confirmation roll. At 5th level, you gain Dodge as a bonus feat. You do not need to meet the prerequisite to gain this feat.",
          1, "Ability"
      }, //
      {754, "Mystery Waves - Fluid Travel",
          "You can walk on liquid as if it were a solid surface. Walking on the liquid does not harm you, you can walk on acid or even lava (as if walking on a solid temporary crust), though you would still take fire damage from being near the lava. You can move across this surface at your normal land speed. At 7th level, while this ability is in effect, you can instead go underwater, gaining a swim speed of 60 feet and the ability to breathe water. You can use this ability for 1 hour per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-hour increments.",
          3, "Ability"
      }, //
      {755, "Mystery Waves - Freezing Spells",
          "Whenever a creature fails a saving throw and takes cold damage from one of your spells, it is slowed (as the slow spell) for 1 round. Spells that do not allow a save do not slow creatures. At 11th level, the duration increases to 1d4 rounds.",
          3, "Ability"
      }, //
      {756, "Mystery Waves - Ice Armor",
          "You can conjure armor of ice that grants you a +4 armor bonus. At 7th level, and every four levels thereafter, this bonus increases by +2. At 13th level, this armor grants you DR 5/piercing. In cold conditions, the armor bonus (and DR bonus) increases by 2, in very hot conditions it decreases by 2. You can use this armor for 1 hour per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-hour increments.",
          3, "Ability"
      }, //
      {757, "Mystery Waves - Icy Skin",
          "You gain resist cold 5. This resistance increases to 10 at 5th level and 20 at 11th level. At 17th level, you gain immunity to cold.",
          1, "Ability"
      }, //
      {758, "Mystery Waves - Punitive Transformation",
          "You can transform an opponent into a harmless animal as if using baleful polymorph. This transformation lasts 1 round per oracle level. Transforming another creature causes the first to immediately revert to normal. You may use this ability a number of times per day equal to your Charisma modifier. You must be at least 7th level before selecting this revelation.",
          3, "Ability"
      }, //
      {759, "Mystery Waves - Water Form",
          "As a standard action, you can assume the form of a Small water elemental, as elemental body I. At 9th level, you can assume the form of a Medium water elemental, as elemental body II. At 11th level, you can assume the form of a Large water elemental, as elemental body III. At 13th level, you can assume the form of a Huge water elemental, as elemental body IV. You can use this ability once per day, but the duration is 1 hour/level. You must be at least 7th level to select this revelation.",
          3, "Ability"
      }, //
      {760, "Mystery Waves - Water Sight",
          "You can see through fog and mist without penalty as long as there is enough light to allow you to see normal. At 7th level, you can use any calm pool of water at least 1 foot in diameter as a scrying device, as if using the scry spell. At 15th level, this functions like greater scrying.You can use the scrying abilities for a number of rounds per day equal to your oracle level, but these rounds do not need to be consecutive.",
          3, "Ability"
      }, //
      {761, "Mystery Waves - Wintry Touch",
          "As a standard action, you can perform a melee touch attack that deals 1d6 points of cold damage + 1 point for every two oracle levels you possess. You can use the wintry touch ability a number of times per day equal to 3 + your Charisma modifier. At 11th level, any weapon that you wield is treated as a frost weapon.",
          3, "Ability"
      }, //
      {762, "Mystery Waves - Final Revelation",
          "Upon reaching 20th level, you become a master of cold and water. You can apply any one of the following feats to any cold or water spell without increasing the level or casting time: Enlarge Spell, Extend Spell, Silent Spell, or Still Spell.",
          0, "Ability"
      }, //
      {763, "Mystery Wind - Class Skills",
          "An oracle with the wind mystery adds Acrobatics, Escape Artist, Fly, and Stealth to her list of class skills.", 0,
          "Ability"
      }, //
      {764, "Spells - Mystery Wind",
          "alter winds* (2nd), gust of wind (4th), cloak of winds* (6th), river of wind* (8th), control winds (10th), sirocco* (12th), control weather (14th), whirlwind (16th), winds of vengeance* (18th).",
          0, "SpelllistAbility"
      }, //
      {765, "Mystery Wind - Air Barrier",
          "You can create an invisible shell of air that grants you a +4 armor bonus. At 7th level, and every four levels thereafter, this bonus increases by +2. At 13th level, this barrier causes incoming arrows, rays, and other ranged attacks requiring an attack roll against you to have a 50% miss chance. You can use this barrier for 1 hour per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-hour increments.",
          1, "Ability"
      }, //
      {766, "Mystery Wind - Gaseous Form",
          "As a standard action, you can assume gaseous form (as the spell). You can remain gaseous for 1 minute per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-minute increments. You must be at least 7th level to select this revelation. You can bring other creatures with you in gaseous form, but each passenger costs an additional minute per minute of travel.",
          3, "Ability"
      }, //
      {767, "Mystery Wind - Invisibility",
          "As a standard action, you can become invisible (as per the invisibility spell). You can remain invisible for 1 minute per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-minute increments. Starting at 9th level, each time you activate this ability you can treat it as greater invisibility, though each round spent this way counts as 1 minute of your normal invisibility duration. You must be at least 3rd level to select this revelation.",
          3, "Ability"
      }, //
      {768, "Mystery Wind - Lightning Breath",
          "As a standard action, you can breathe a 30-foot line of electricity. This line deals 1d4 points of electricity damage per oracle level. A Reflex save halves this damage. You can use this ability once per day, plus one additional time per day at 5th level and every five levels thereafter.",
          3, "Ability"
      }, //
      {769, "Mystery Wind - Spark Skin",
          "You gain resist electricity 5. This resistance increases to 10 at 5th level and 20 at 11th level. At 17th level, you gain immunity to electricity.",
          1, "Ability"
      }, //
      {770, "Mystery Wind - Thunderburst",
          "As a standard action, you can create a blast of air accompanied by a loud peal of thunder. The blast has a range of 100 feet and has a 20-foot radius, increasing by 5 feet for every 4 oracle levels after 7th. Creatures in the area take 1d6 points of bludgeoning damage per oracle level and are deafened for 1 hour, with a Fortitude save resulting in half damage and no deafness. You must be at least 7th level to select this revelation. You can use this ability once per day, plus one additional time per day at 11th level and every four levels thereafter.",
          1, "Ability"
      }, //
      {771, "Mystery Wind - Touch of Electricity",
          "As a standard action, you can perform a melee touch attack that deals 1d6 points of electricity damage +1 point for every two oracle levels you possess. You can use this ability a number of times per day equal to 3 + your Charisma modifier. At 11th level, any weapon that you wield is treated as a shock weapon.",
          3, "Ability"
      }, //
      {772, "Mystery Wind - Vortex Spells",
          "Whenever you score a critical hit against an opponent with an attack spell, the target is staggered for 1 round. At 11th level, the duration increases to 1d4 rounds.",
          1, "Ability"
      }, //
      {773, "Mystery Wind - Wind Sight",
          "You ignore penalties on Perception checks based on wind and the first 100 feet of distance. At 7th level, as a standard action, you can see and hear into any area (as if using clairaudience and clairvoyance) within range as long as there is an unobstructed path for air to travel between you and the target area (this does not require line of effect, meaning the path can turn corners and go through spaces no smaller than 1 inch in diameter). You can use this ability a number of rounds per day equal to your oracle level, but these rounds do not need to be consecutive.",
          1, "Ability"
      }, //
      {774, "Mystery Wind - Wings of Air",
          "As a swift action, you can manifest a pair of translucent, cloud-like wings that grant you a fly speed of 60 feet with good maneuverability. At 10th level, your speed increases to 90 feet and your maneuverability increases to perfect. You can use these wings for 1 minute per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1-minute increments. You must be at least 7th level to select this revelation.",
          3, "Ability"
      }, //
      {775, "Mystery Wind - Final Revelation",
          "Upon reaching 20th level, you become a master of air and electricity. You can apply any one of the following feats to any air or electricity spell without increasing the level or casting time: Enlarge Spell, Extend Spell, Silent Spell, or Still Spell.",
          0, "Ability"
      }, //
      {776, "Spells - Summoner",
          "A summoner casts arcane spells drawn from the summoner spell list. He can cast any spell he knows without preparing it ahead of time, assuming he has not yet used up his allotment of spells per day for the spell's level.<br>To learn or cast a spell, a summoner must have a Charisma score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a summoner's spell is 10 + the spell level + the summoner's Charisma modifier.<br>A summoner can cast only a certain number of spells of each spell level each day. His base daily spell allotment is given on Table 2-7. In addition, he receives bonus spells per day if he has a high Charisma score (see Table 1-3 of the Pathfinder RPG Core Rulebook).<br>A summoner's selection of spells is extremely limited. A summoner begins play knowing four 0-level spells and two 1st-level spells of the summoner's choice. At each new summoner level, he gains one or more new spells as indicated on Table 2-8. (Unlike spells per day, the number of spells a summoner knows is not affected by his Charisma score. The numbers on Table 2-8 are fixed.)<br>Upon reaching 5th level, and at every third summoner level thereafter (8th, 11th, and so on), a summoner can choose to learn a new spell in place of one he already knows. In effect, the summoner 'loses' the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged, and it must be at least one level lower than the highest-level summoner spell he can cast. A summoner may swap out only a single spell at any given level and must choose whether or not to swap the spell at the same time that he gains new spells known for the level.",
          0, "SpelllistAbility"
      }, //
      {777, "Cantrips - Summoner",
          "A summoner learns a number of cantrips, or 0-level spells, as noted on Table 2-8 under 'Spells Known.' These spells are cast like any other spell, but they may be cast any number of times per day. Cantrips prepared using other spell slots, due to metamagic feats, for example, consume spell slots as normally.",
          0, "Ability"
      }, //
      {778, "Eidolon",
          "A summoner begins play with the ability to summon to his side a powerful outsider called an eidolon. The eidolon forms a link with the summoner, who, forever after, summons an aspect of the same creature. An eidolon has the same alignment as the summoner that calls it and can speak all of his languages. Eidolons are treated as summoned creatures, except that they are not sent back to their home plane until reduced to a number of negative hit points equal to or greater than their Constitution score. In addition, due to its tie to its summoner, an eidolon can touch and attack creatures warded by protection from evil and similar effects that prevent contact with summoned creatures.<br>A summoner can summon his eidolon in a ritual that takes 1 minute to perform. When summoned in this way, the eidolon hit points are unchanged from the last time it was summoned. The only exception to this is if the eidolon was slain, in which case it returns with half its normal hit points. The eidolon does not heal naturally. The eidolon remains until dismissed by the summoner (a standard action). If the eidolon is sent back to its home plane due to death, it cannot be summoned again until the following day. The eidolon cannot be sent back to its home plane by means of dispel magic, but spells such as dismissal and banishment work normally. If the summoner is unconscious, asleep, or killed, his eidolon is immediately banished.<br>The eidolon takes a form shaped by the summoner's desires. The eidolon's Hit Dice, saving throws, skills, feats, and abilities are tied to the summoner's class level and increase as the summoner gains levels. In addition, each eidolon receives a pool of evolution points, based on the summoner's class level, that can be used to give the eidolon different abilities and powers. Whenever the summoner gains a level, he must decide how these points are spent, and they are set until he gains another level of summoner.<br>The eidolon's physical appearance is up to the summoner, but it always appears as some sort of fantastical creature. This control is not fine enough to make the eidolon appear like a specific creature. The eidolon also bears a glowing rune that is identical to a rune that appears on the summoner's forehead as long as the eidolon is summoned. While this rune can be hidden through mundane means, it cannot be concealed through magic that changes appearance, such as alter self or polymorph (although invisibility does conceal it as long as the spell lasts).",
          0, "Ability"
      }, //
      {779, "Life Link",
          "Starting at 1st level, a summoner forms a close bond with his eidolon. Whenever the eidolon takes enough damage to send it back to its home plane, the summoner can, as a free action, sacrifice any number of hit points. Each hit point sacrificed in this way prevents 1 point of damage done to the eidolon. This can prevent the eidolon from being sent back to its home plane.<br>In addition, the eidolon and the summoner must remain within 100 feet of one another for the eidolon to remain at full strength. If the eidolon is beyond 100 feet but closer than 1,000 feet, its current and maximum hit point totals are reduced by 50%. If the eidolon is more than 1,000 feet away but closer than 10,000 feet, its current and maximum hit point totals are reduced by 75%. If the eidolon is more than 10,000 feet away, it is immediately returned to its home plane. Current hit points lost in this way are not restored when the eidolon gets closer to its summoner, but its maximum hit point total does return to normal.",
          3, "Ability"
      }, //
      {780, "Summon Monster I",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {781, "Summon Monster II",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {782, "Summon Monster III",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {783, "Summon Monster IV",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {784, "Summon Monster V",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {785, "Summon Monster VI",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {786, "Summon Monster VIII",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {787, "Summon Monster VIII",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {788, "Summon Monster IX",
          "Starting at 1st level, a summoner can cast summon monster I as a spell-like ability a number of times per day equal to 3 + his Charisma modifier. Drawing upon this ability uses up the same power as the summoner uses to call his eidolon. As a result, he can only use this ability when his eidolon is not summoned. He can cast this spell as a standard action and the creatures remain for 1 minute per level (instead of 1 round per level). At 3rd level, and every 2 levels thereafter, the power of this ability increases by one spell level, allowing him to summon more powerful creatures (to a maximum of summon monster IX at 17th level). At 19th level, this ability can be used as gate or summon monster IX. If used as gate, the summoner must pay any required material components. A summoner cannot have more than one summon monster or gate spell active in this way at one time. If this ability is used again, any existing summon monster or gate immediately ends. These summon spells are considered to be part of his spell list for the purposes of spell trigger and spell completion items. In addition, he can expend uses of this ability to fufill the construction requirements of any magic item he creates, so long as he can use this ability to cast the required spell.",
          2, "Ability"
      }, //
      {789, "Bond Senses",
          "Starting at 2nd level, a summoner can, as a standard action, share the senses of his eidolon, hearing, seeing, smelling, tasting, and touching everything the eidolon does. He can use this ability a number of rounds per day equal to his summoner level. There is no range to this effect, but the eidolon and the summoner must be on the same plane. The summoner can end this effect as a free action.",
          3, "Ability"
      }, //
      {790, "Shield Ally",
          "At 4th level, whenever a summoner is within his eidolon's reach, the summoner receives a +2 shield bonus to his Armor Class and a +2 circumstance bonus on his saving throws. This bonus does not apply if the eidolon is grappled, helpless, paralyzed, stunned, or unconscious.",
          1, "Ability"
      }, //
      {791, "Maker's Call",
          "At 6th level, as a standard action, a summoner can call his eidolon to his side. This functions as dimension door, using the summoner's caster level. When used, the eidolon appears adjacent to the summoner (or as close as possible if all adjacent spaces are occupied). If the eidolon is out of range, the ability is wasted. The summoner can use this ability once per day at 6th level, plus one additional time per day for every four levels beyond 6th.",
          3, "Ability"
      }, //
      {792, "Transposition",
          "At 8th level, a summoner can use his maker's call ability to swap locations with his eidolon. If it is larger than him, he can appear in any square occupied by the eidolon. The eidolon must occupy the square that was occupied by the summoner if able, or as close as possible if it is not able.",
          3, "Ability"
      }, //
      {793, "Aspect",
          "At 10th level, a summoner can divert up to 2 points from his eidolon's evolution pool to add evolutions to himself. He cannot select any evolution that the eidolon could not possess, and he must be able to meet the requirements as well. He cannot select the ability increase evolution through this ability. Any points spent in this way are taken from the eidolon's evolution pool (reducing the total number available to the eidolon). The summoner can change the evolutions he receives from these points any time he can change the eidolon's evolutions.",
          3, "Ability"
      }, //
      {794, "Greater Shield Ally",
          "At 12th level, whenever an ally is within an eidolon's reach, the ally receives a +2 shield bonus to its Armor Class and a +2 circumstance bonus on its saving throws. If this ally is the summoner, these bonuses increase to +4. This bonus does not apply if the eidolon is grappled, helpless, paralyzed, stunned, or unconscious.",
          3, "Ability"
      }, //
      {795, "Life Bond",
          "At 14th level, a summoner's life becomes linked to his eidolon's. As long as the eidolon has 1 or more hit points, the summoner is protected from harm. Damage in excess of that which would reduce the summoner to fewer than 0 hit points is instead transferred to the eidolon. This damage is transferred 1 point at a time, meaning that as soon as the eidolon is reduced to a number of negative his points equal to its Constitution score, all excess damage remains with the summoner. Effects that cause death but not damage are unaffected by this ability. This ability does not affect spells like baleful polymorph, flesh to stone, or imprisonment, or other spells that do not cause actual damage.",
          3, "Ability"
      }, //
      {796, "Merge Forms",
          "At 16th level, as a full-round action, a summoner can touch his eidolon and the two can merge forms. This transformation includes all of the summoner's gear. While merged in this way, the summoner is protected from harm and cannot be the target of spells or effects. All effects and spells currently targeting the summoner are suspended until the summoner emerges from the eidolon (although durations continue to expire).<br>The summoner can cast spells while inside the eidolon by taking control of the eidolon for the duration of the casting. Any material components used for these spells are taken from the summoner's gear, even though they are otherwise inaccessible. The summoner can direct all of the eidolon's actions while merged, can perceive through its senses, and can speak through its voice.<br>The summoner can use this ability for a number of rounds per day equal to his summoner level. He can end this effect at any time as a swift action. The summoner emerges in a square adjacent to the eidolon if able. If the eidolon is returned to its home plane while the summoner is merged with it, the summoner is immediately ejected, taking 4d6 points of damage, and is stunned for 1 round.",
          3, "Ability"
      }, //
      {797, "Greater Aspect",
          "At 18th level, a summoner can divert more of his eidolon's evolutions to himself. This ability functions as the aspect ability, but up to 6 evolution points can be taken. Unlike the aspect ability, the eidolon loses 1 point from its evolution pool for every 2 points (or fraction thereof) diverted to the summoner.",
          3, "Ability"
      }, //
      {798, "Twin Eidolon",
          "At 20th level, a summoner and his eidolon share a true connection. As a standard action, the summoner can assume the shape of his eidolon, copying all of its evolutions, form, and abilities. His Strength, Dexterity, and Constitution scores change to match the base scores of his eidolon. He can choose to have any gear that he carries become absorbed by his new form, as with spells from the polymorph subschool. Items with continuous effects continue to function while absorbed in this way. The summoner loses his natural attacks and all racial traits (except bonus feats, skills, and languages) in favor of the abilities granted by his eidolon's evolutions. The summoner retains all of his class features. The summoner can keep this form for a number of minutes per day equal to his summoner level. This duration does not need to be consecutive, but it must be spent in 1-minute increments. The summoner can end this effect as a free action.",
          3, "Ability"
      }, //
      {799, "Spells - Witch",
          "A witch casts arcane spells drawn from the witch spell list. A witch must choose and prepare her spells ahead of time.<br>To learn or cast a spell, a witch must have an Intelligence score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a witch's spell is 10 + the spell level + the witch's Intelligence modifier.<br>A witch can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table 2-10. In addition, she receives bonus spells per day if she has a high Intelligence score (see Table 1-3 of the Pathfinder RPG Core Rulebook).<br>A witch may know any number of spells. She must choose and prepare her spells ahead of time by getting 8 hours of sleep and spending 1 hour communing with her familiar. While communing, the witch decides which spells to prepare.",
          0, "SpelllistAbility"
      }, //
      {800, "Spells - Patron Agility",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {801, "Cantrips - Witch",
          "Witches can prepare a number of cantrips, or 0-level spells, each day, as noted on Table 2-10 under 'Spells per Day.' These spells are cast like any other spell, but they are not expended when cast and may be used again. Cantrips prepared using other spell slots, due to metamagic feats for example, are expended normally.",
          0, "Ability"
      }, //
      {802, "Hex - Blight",
          "The witch can curse an animal, plant creature, or plot of land, causing it to wither and die. Blighting an area takes 1 round, during which time the witch and her familiar must be in contact with the target. If it's used on a plot of land, the land begins to wither the following day, and over the next week all plants in the area die. Nothing will grow in that area so long as the curse persists. A witch can affect an area with a radius equal to her class level x 10 feet. Blighting a creature is a standard action that requires a melee touch attack. If used on a creature of the animal or plant type, the creature gains the following curse: Blight Hex-type curse, save Will negates, frequency 1/day, effect 1 Con damage. Both types of curse can be removed with a remove curse or similar magic, using the save DC as the DC to remove the curse. A witch can only have one blight in effect at a time. If another blight hex is made, the first immediately ends.",
          3, "Ability"
      }, //
      {803, "Hex - Cackle",
          "A witch can cackle madly as a move action. Any creature that is within 30 feet that is under the effects of an agony hex, charm hex, evil eye hex, fortune hex, or misfortune hex caused by the witch has the duration of that hex extended by 1 round.",
          3, "Ability"
      }, //
      {804, "Hex - Cauldron",
          "The witch receives Brew Potion as a bonus feat and a +4 insight bonus on Craft (alchemy) skill checks.", 1, "Ability"
      }, //
      {805, "Hex - Charm",
          "A witch can charm an animal or humanoid creature within 30 feet by beckoning and speaking soothing words. This improves the attitude of an animal or humanoid creature by 1 step, as if the witch had successfully used the Diplomacy skill. The effect lasts for a number of rounds equal to the Witch's Intelligence modifier. A Will save negates this effect. Whether or not the save is successful, a creature cannot be the target of this hex again for 1 day. At 8th level, this effect improves the attitude of the target creature by 2 steps. This is a mind-affecting charm effect.",
          3, "Ability"
      }, //
      {806, "Hex - Coven",
          "The witch counts as a hag for the purpose of joining a hag's coven. The coven must contain at least one hag. In addition, whenever the witch with this hex is within 30 feet of another witch with this hex, she can use the aid another action to grant a +1 bonus to the other witch's caster level for 1 round. This bonus applies to the witch's spells and all of her hexes.",
          1, "Ability"
      }, //
      {807, "Hex - Disguise",
          "A witch can change her appearance for a number of hours equal to her class level, as if using disguise self. These hours do not need to be consecutive, but they must be spent in 1-hour increments.",
          3, "Ability"
      }, //
      {808, "Hex - Evil Eye",
          "The witch can cause doubt to creep into the mind of a foe within 30 feet that she can see. The target takes a -2 penalty on one of the following (witch's choice): AC, ability checks, attack rolls, saving throws, or skill checks. This hex lasts for a number of rounds equal to 3 + the witch's Intelligence modifier. A Will save reduces this to just 1 round. This is a mind-affecting effect. At 8th level the penalty increases to -4.",
          3, "Ability"
      }, //
      {809, "Hex - Flight",
          "The witch grows lighter as she gains power, eventually gaining the ability to fly. At 1st level, the witch can use feather fall at will and gains a +4 racial bonus on Swim checks. At 3rd level, she can cast levitate once per day. At 5th level, she can fly, as per the spell, for a number of minutes per day equal to her level. These minutes do not need to be consecutive, but they must be spent in 1-minute increments. This hex only affects the witch.",
          3, "Ability"
      }, //
      {810, "Hex - Fortune",
          "The witch can grant a creature within 30 feet a bit of good luck for 1 round. The target can call upon this good luck once per round, allowing him to reroll any ability check, attack roll, saving throw, or skill check, taking the better result. He must decide to use this ability before the first roll is made. At 8th level and 16th level, the duration of this hex is extended by 1 round. Once a creature has benefited from the fortune hex, it cannot benefit from it again for 24 hours.",
          3, "Ability"
      }, //
      {811, "Hex - Healing",
          "A witch can soothe the wounds of those she touches. This acts as a cure light wounds spell, using the witch's caster level. Once a creature has benefited from the healing hex, it cannot benefit from it again for 24 hours. At 5th level, this hex acts like cure moderate wounds.",
          3, "Ability"
      }, //
      {812, "Hex - Misfortune",
          "The witch can cause a creature within 30 feet to suffer grave misfortune for 1 round. Anytime the creature makes an ability check, attack roll, saving throw, or skill check, it must roll twice and take the worse result. A Will save negates this hex. At 8th level and 16th level, the duration of this hex is extended by 1 round. This hex affects all rolls the target must make while it lasts. Whether or not the save is successful, a creature cannot be the target of this hex again for 1 day.",
          3, "Ability"
      }, //
      {813, "Hex - Slumber",
          "A witch can cause a creature within 30 feet to fall into a deep, magical sleep, as per the spell sleep. The creature receives a Will save to negate the effect. If the save fails, the creature falls asleep for a number of rounds equal to the witch's level. This hex can affect a creature of any HD. The creature will not wake due to noise or light, but others can rouse it with a standard action. This hex ends immediately if the creature takes damage. Whether or not the save is successful, a creature cannot be the target of this hex again for 1 day.",
          3, "Ability"
      }, //
      {814, "Hex - Tongues",
          "A witch with this hex can understand any spoken language for a number of minutes per day equal to her level, as comprehend languages. This duration does not need to be consecutive, but it must be spent in 1-minute increments. At 5th level, a witch can use this ability to speak any language, as per tongues.",
          3, "Ability"
      }, //
      {815, "Hex - Ward",
          "A witch can use this hex to place a protective ward over one creature. The warded creature receives a +2 deflection bonus to AC and a +2 resistance bonus on saving throws. This ward lasts until the warded creature is hit or fails a saving throw. A witch knows when a warded creature is no longer protected. A witch can have only one ward active at a time. If the witch uses this ability again, the previous ward immediately ends. A witch cannot use this ability on herself. At 8th level and 16th level, the bonuses provided by this ward increase by +1.",
          3, "Ability"
      }, //
      {816, "Hex - Witch's Familiar",
          "At 1st level, a witch forms a close bond with a familiar, a creature that teaches her magic and helps to guide her along her path. Familiars also aid a witch by granting her skill bonuses, additional spells, and help with some types of magic. This functions like the wizard's arcane bond class feature, except as noted in the Witch's Familiar section.<br>A witch must commune with her familiar each day to prepare her spells. Familiars store all of the spells that a witch knows, and a witch cannot prepare a spell that is not stored by her familiar. A witch's familiar begins play storing all of the 0-level witch spells plus three 1st-level spells of the witch's choice. The witch also selects a number of additional 1st-level spells equal to her Intelligence modifier to store in her familiar. At each new witch level, she adds two new spells of any spell level or levels that she can cast (based on her new witch level) to her familiar. A witch can also add additional spells to her familiar through a special ritual (see sidebar).",
          1, "Ability"
      }, //
      {817, "Major Hex - Agony",
          "With a quick incantation, a witch can place this hex on one creature within 60 feet, causing them to suffer intense pain. The target is nauseated for a number of rounds equal to the witch's level. A Fortitude save negates this effect. If the saving throw is failed, the target can attempt a new save each round to end the effect. Whether or not the save is successful, a creature cannot be the target of this hex again for 1 day.",
          3, "Ability"
      }, //
      {818, "Major Hex - Hag's Eye",
          "A witch with this hex can create a magic sensor that she can see through. This functions as per the spell arcane eye. If the witch has the coven hex, all other witches within 10 feet who also have the coven hex can see through this sensor as well, although the witch that created it still controls it. The witch can use this eye for a number of minutes per day equal to her level. These minutes do not need to be consecutive, but they must be spent in 1-minute increments.",
          3, "Ability"
      }, //
      {819, "Major Hex - Major Healing",
          "By calling upon eerie powers, the witch's touch can mend even the most terrible wounds of those she touches. This acts as cure serious wounds, using the witch's caster level. Once a creature has benefited from the major healing hex, it cannot benefit from it again for 24 hours. At 15th level, this hex acts like cure critical wounds.",
          3, "Ability"
      }, //
      {820, "Major Hex - Nightmares",
          "Calling upon fell powers, a witch can place a hex on a creature within 60 feet that causes its sleep to be tormented by terrible nightmares. This functions as the spell nightmare each time the affected creature attempts to rest. A Will save negates this effect. If the save is failed, the target must make a new save each night or be unable to rest.",
          3, "Ability"
      }, //
      {821, "Major Hex - Retribution",
          "A witch can place a retribution hex on a creature within 60 feet, causing terrible wounds to open across the target's flesh whenever it deals damage to another creature in melee. Immediately after the hexed creature deals damage in melee, it takes half that damage (round down). This damage bypasses any resistances, immunities, or damage reduction the creature possesses. This effect lasts for a number of rounds equal to the witch's Intelligence modifier. A Will save negates this effect.",
          3, "Ability"
      }, //
      {822, "Major Hex - Vision",
          "A witch with the vision hex can grant a glimpse of the future to a creature touched. Granting a vision takes 1 minute, during which time the witch and the target must remain in contact with one another. At the end of this time, the subject receives a brief image of the future, usually no more than 1 year from the time of the vision, subject to GM discretion. This is only one possible version of the future, making such visions unreliable at best. Most visions are slanted toward the alignment of the witch that granted them. For example, the visions granted by a chaotic evil witch often show scenes of death and destruction, while those of a neutral good witch tend to be of joyous events or occasions. A creature cannot be subject to another vision until the current vision has either come to pass or been prevented. A witch cannot use this ability on herself. Unwilling creatures receive a Will save to negate the vision.",
          3, "Ability"
      }, //
      {823, "Major Hex - Waxen Image",
          "The witch can spend a full-round action to create a crude and unnerving wax duplicate of a creature she can see within 30 feet. Once the image is complete, the subject must make a Will save. If the subject fails, the witch gains a small measure of control over the creature. Whenever she exercises this control, the creature receives a new Will save to end the effect. This effect occurs on the witch's turn and does not impede the creature's actions on its turn. The witch can use the waxen image a number of times equal to her Intelligence modifier before it melts. As a standard action, the witch can cause the subject to do any one of the following things: move up to the creature's speed in any direction, attack itself once with any weapon in hand (this attack automatically hits), lay down on the ground, or drop anything held. Alternatively, she can spend one of her uses to simply torture the image, causing the creature to be both sickened and staggered on its turn. As soon as the creature has succeeded on a saving throw against this effect, it is immune to it for 24 hours. The is an enchantment (compulsion) effect.",
          3, "Ability"
      }, //
      {824, "Major Hex - Weather Control",
          "A witch with this hex can use control weather once per day, but creating the weather takes 1 full hour of chanting, dancing, and communing with her familiar.",
          3, "Ability"
      }, //
      {825, "Grand Hex - Death Curse",
          "This powerful hex seizes a creature's heart, causing death within just a few moments. This hex has a range of 30 feet. The hexed creature receives a Will save to negate the effect. If this save is failed, the creature becomes fatigued the first round of the hex. On the second round of the hex, the creature becomes exhausted. On the third round, the creature dies unless it succeeds at a Fort save. Creatures that fail the first save but succeed at the second remain exhausted and take 4d6 points of damage + 1 point of damage per level of the witch. Slaying the witch that hexed the creature ends the effect, but any fatigue or exhaustion remains. Whether or not the saves are successful, a creature cannot be the target of this hex again for 1 day.",
          3, "Ability"
      }, //
      {826, "Grand Hex - Eternal Slumber",
          "The witch can touch a creature, causing it to drift off into a permanent slumber. The creature receives a Will save to negate this effect. If the save fails, the creature falls asleep and cannot be woken. The effect can only be removed with a wish or similar magic, although slaying the witch ends the effect. The witch can use this ability to poison food or drink, causing those who ingest it to make a save or fall into an eternal slumber. She can only have one such dose of poison at any one time, and it loses its potency after 1 minute if not consumed. Whether or not the save is successful, a creature cannot be the target of this hex again for 1 day.",
          3, "Ability"
      }, //
      {827, "Grand Hex - Forced Reincarnation",
          "The witch causes a creature within 30 feet to die and be immediately reincarnated into a new body. A Will save negates this effect. Those that fail are slain and immediately brought back to life with the spell reincarnate. Whether or not the save is successful, a creature cannot be the target of this hex again for 1 day.",
          3, "Ability"
      }, //
      {828, "Grand Hex - Life Giver",
          "Once per day the witch can, as a full round action, touch a dead creature and bring it back to life. This functions as resurrection, but it does not require a material component.",
          3, "Ability"
      }, //
      {829, "Grand Hex - Natural Disaster",
          "A witch using this hex calls down the forces of nature to wreak havoc on an area. This functions as a storm of vengeance combined with an earthquake that occurs on the second round of the effect (while acid is raining from the sky). A witch must concentrate for the duration of this effect. If disrupted, the effect immediately ends. A witch can only use this ability once per day.",
          3, "Ability"
      }, //
      {830, "Inspiring Command - Battle Magic",
          "One ally gains a bonus on caster level checks and concentration checks equal to the battle herald's command bonus.", 1,
          "Ability"
      }, //
      {831, "Inspiring Command - Inspire Hardiness", "Allies gain DR/- equal to the battle herald's inspiring command bonus.", 1,
          "Ability"
      }, //
      {832, "Inspiring Command - Inspired Tactics",
          "Allies apply the battle herald's inspiring command bonus on critical hit confirmation rolls, on combat maneuver checks, and as a dodge bonus to AC against any attacks of opportunity provoked by combat maneuvers.",
          1, "Ability"
      }, //
      {833, "Inspiring Command - Keep Your Heads",
          "Allies apply the battle herald's inspiring command bonus on Will saves and concentration checks.", 1, "Ability"
      }, //
      {834, "Inspiring Command - None Shall Fall",
          "A number of allies equal to the battle herald's inspiring command bonus heal 1d6 points of damage. Targeted allies who are poisoned may attempt a new poison saving throw with a bonus equal to the battle herald's inspiring command bonus, a failed save has no additional effect, but a successful save counts toward curing the poison. This healing is not positive energy and can heal undead creatures.",
          1, "Ability"
      }, //
      {835, "Inspiring Command - Pincer Maneuver",
          "Allies apply the battle herald's inspiring command bonus to attack and damage rolls when flanking and as a dodge bonus to AC against attacks of opportunity provoked by movement (including standing from prone).",
          1, "Ability"
      }, //
      {836, "Inspiring Command - Rally",
          "Allies affected by a fear effect may attempt a new saving throw against each fear effect on them, this new save has a bonus equal to the battle herald's inspiring command bonus.",
          1, "Ability"
      }, //
      {837, "Inspiring Command - Reveille",
          "Allies affected by exhaustion, fatigue, or sleep effects may attempt a new saving throw against each such effect, this new save has a bonus equal to the battle herald's inspiring command bonus. Allies who are sleeping normally automatically awaken when this ability is used.",
          1, "Ability"
      }, //
      {838, "Inspiring Command - Scatter",
          "A number of allies equal to the battle herald's inspiring command bonus gain the benefits of the Wind Stance feat.", 1,
          "Ability"
      }, //
      {839, "Inspiring Command - Shake It Off",
          "One ally subject to an ongoing condition may attempt a new saving throw to negate the effects with a bonus equal to the battle herald's inspiring command bonus. This ability does not help against instantaneous effects, effects that require recurring saving throws to avoid additional penalties (such as diseases and poisons), or effects that do not allow a saving throw.",
          1, "Ability"
      }, //
      {840, "Inspiring Command - Sound the Charge",
          "Allies apply the battle herald's inspiring command bonus to attack and damage rolls. Charging allies increase their speed by 5 feet times the battle herald's inspiring command bonus.",
          1, "Ability"
      }, //
      {841, "Inspiring Command - Sound the Retreat",
          "Allies gain the benefit of the Lightning Stance feat. The battle herald must have the scatter ability to select this ability.",
          1, "Ability"
      }, //
      {842, "Inspiring Command - Stand Firm",
          "Allies apply the battle herald's inspiring command bonus to CMD and on Fortitude saves.", 1, "Ability"
      }, //
      {843, "Inspiring Command - Teamwork",
          "Allies add the battle herald's inspiring command bonus on skill checks or attack rolls made when using the aid another action, and if successful, the assisted ally increases the aid another bonus by an amount equal to the battle herald's inspiring command bonus.",
          1, "Ability"
      }, //
      {844, "Inspiring Command - Tuck and Roll",
          "Allies apply the battle herald's inspiring command bonus on Reflex saves and Acrobatics checks.", 1, "Ability"
      }, //
      {845, "Improved Leadership",
          "A battle herald with the Leadership feat adds her inspiring command bonus to her leadership score.", 1, "Ability"
      }, //
      {846, "Voice of Authority",
          "A battle herald is skilled at shouting commands over the din of the battlefield and signaling allies when speech is impossible. She gains a +2 bonus on Diplomacy and Intimidate checks with creatures with which she shares a language. In addition, her allies gain a bonus equal to the battle herald's class level on Perception or Sense Motive checks to hear her commands or interpret her secret messages conveyed with Bluff. The battle herald's levels stack with cavalier levels for the purpose of the cavalier's tactician ability.",
          1, "Ability"
      }, //
      {847, "Easy March",
          "At 2nd level, allies within 60 feet of the battle herald can hustle or force march during overland travel without ill effects for a number of hours per day equal to 1 hour times her inspiring command bonus.",
          1, "Ability"
      }, //
      {848, "Inspire Greatness",
          "At 4th level, a battle herald may use her inspiring command ability to inspire greatness (as the 9th-level bardic performance ability). This ability affects one creature at 4th level, two at 7th, and three at 10th.",
          1, "Ability"
      }, //
      {849, "Banner",
          "At 5th level, a battle herald may fly a battle standard that inspires her allies. This ability is identical to the cavalier's banner ability, and cavalier levels stack with battle herald levels to determine the bonuses provided by the banner.",
          1, "Ability"
      }, //
      {850, "Teamwork Feat",
          "At 6th level, a battle herald receives a teamwork feat as a bonus feat. She must meet the prerequisites for this feat. She can use her cavalier tactician ability as a move action to grant this feat to allies (if she has the cavalier greater tactician ability, this is a swift action).",
          1, "Ability"
      }, //
      {851, "Demanding Challenge", "This ability is identical to the 12th-level cavalier demanding challenge ability.", 1,
          "Ability"
      }, //
      {852, "Persistent Commands",
          "At 8th level, a battle herald may allow her inspiring commands to persist even if she is incapacitated and unable to maintain them. If the player chooses, the effects of the battle herald's inspiring commands persist for a number of rounds equal to her Charisma bonus (these count toward her number of rounds per day limit). This ability does not apply if the battle herald intentionally stops maintaining an inspiring command-only if she is dazed, held, stunned, killed, and so on, and is unable to maintain them. If the battle herald recovers from incapacity while an inspiring command is ongoing, she may resume maintaining it as a free action.",
          1, "Ability"
      }, //
      {853, "Inspire Last Stand",
          "At 9th level, a battle herald may use inspiring command to grant herself and all allies within 30 feet the benefits of the Diehard feat. Conscious affected creatures also gain the benefits of inspire courage while at negative hit points.",
          1, "Ability"
      }, //
      {854, "Complex Commands",
          "At 10th level, a battle herald can have more than one command ability in effect at one time. Each must be begun separately and requires a separate maintenance cost. This allows the battle herald to have more than one single-target command (such as battle magic) in effect at the same time. The effects of multiple instances of the same command ability do not stack, even if the bonuses provided by that ability would normally stack (for example, if the battle herald maintains two pincer maneuver commands, her allies do not get double the bonus, even though dodge bonuses normally stack).<br>The battle herald can also maintain one bardic performance in addition to her inspiring commands, though each must be begun separately and each requires its own maintenance cost.",
          1, "Ability"
      }, //
      {855, "Spells per Day",
          "At the indicated levels, a vindicator gains new spells per day as if he had also gained a level in a divine spellcasting class he belonged to before adding the prestige class. He does not, however, gain other benefits of that class other than spells per day, spells known, and an increased effective level of spellcasting. If he had more than one divine spellcasting class before becoming a vindicator, he must decide to which class he adds the new level for the purpose of determining spells per day.",
          0, "Ability"
      }, //
      {856, "Channel Energy",
          "The vindicator's class level stacks with levels in any other class that grants the channel energy ability.", 3, "Ability"
      }, //
      {857, "Vindicator's Shield",
          "A vindicator can channel energy into his shield as a standard action, when worn, the shield gives the vindicator a sacred bonus (if positive energy) or profane bonus (if negative energy) to his Armor Class equal to the number of dice of the vindicator's channel energy. This bonus lasts for 24 hours or until the vindicator is struck in combat, whichever comes first. The shield does not provide this bonus to any other wielder, but the vindicator does not need to be holding the shield for it to retain this power.",
          3, "Ability"
      }, //
      {858, "Stigmata",
          "A vindicator willingly gives his blood in service to his faith, and is marked by scarified wounds appropriate to his deity. He may stop or start the flow of blood by force of will as a standard action, at 6th level it becomes a move action, and at 10th level it becomes a swift action. Activating stigmata causes bleed damage equal to half the vindicator's class level, and this bleed damage is not halted by curative magic. While the stigmata are bleeding, the vindicator gains a sacred bonus (if he channels positive energy) or profane bonus (if he channels negative energy) equal to half his class level. Each time he activates his stigmata, the vindicator decides if the bonus applies to attack rolls, weapon damage rolls, Armor Class, caster level checks, or saving throws, to change what the bonus applies to, the vindicator must deactivate and reactivate his stigmata.<br>While his stigmata are bleeding, the vindicator ignores blood drain and bleed damage from any other source and can use bleed or stabilize at will as a standard action.",
          3, "Ability"
      }, //
      {859, "Faith Healing",
          "At 3rd level, any cure wounds spells a vindicator casts on himself are automatically empowered as if by the Empower Spell feat, except they do not use higher spell level slots or an increased casting time. If the vindicator targets himself with a cure spell that affects multiple creatures, this ability only applies to himself. At 8th level, these healing spells are maximized rather than empowered.",
          3, "Ability"
      }, //
      {860, "Divine Wrath",
          "At 4th level, when a vindicator confirms a critical hit, he may sacrifice a prepared 1st-level spell or available 1st-level spell slot to invoke doom upon the target as an immediate action (using the vindicator's caster level). The save DC is increased by +2 if his weapon has a x3 damage multiplier, or by +4 if it is x4. The vindicator can also use this ability in response to being critically hit, even if the attack incapacitates or kills the vindicator.",
          2, "Ability"
      }, //
      {861, "Channel Smite",
          "At 5th level, while a vindicator's stigmata are bleeding, his blood runs down his weapons like sacred or profane liquid energy, when he uses Channel Smite, the damage increases by 1d6, and if the target fails its save, it is sickened and takes 1d6 points of bleed damage each round on its turn. The target can attempt a new save every round to end the sickened and bleed effects.",
          0, "Ability"
      }, //
      {862, "Bloodfire", "At 5th level, a vindicator gains Channel Smite as a bonus feat.", 3, "Ability"}, //
      {863, "Versatile Channel",
          "At 6th level, a vindicator's channel energy can instead affect a 30-foot cone or a 120-foot line.", 3, "Ability"
      }, //
      {864, "Divine Judgment",
          "At 7th level, when a vindicator's melee attack reduces a creature to -1 or fewer hit points, he may sacrifice a prepared 2nd-level spell or available 2nd-level spell slot to invoke death knell upon the target as an immediate action (using the vindicator's caster level). As vindicators mete out divine judgment, this is not an evil act. The save DC increases by +2 if his weapon has a x3 critical multiplier, or by +4 if it is x4.",
          2, "Ability"
      }, //
      {865, "Bloodrain",
          "At 9th level, while his stigmata are bleeding, the vindicator's harmful channeled energy is accompanied by a burst of sacred or profane liquid energy, increasing the damage by 1d6. Creatures failing their saves against the channeled energy become sickened and take 1d6 points of bleed damage each round. Affected creatures can attempt a new save every round to end the sickened and bleed effects.",
          3, "Ability"
      }, //
      {866, "Divine Retribution",
          "At 10th level, when a vindicator confirms a critical hit, he may sacrifice a prepared 3rd-level spell or available 3rd-level spell slot to invoke bestow curse upon the target as an immediate action (using the vindicator's caster level). The save DC increases by +2 if his weapon has a x3 critical multiplier, or by +4 if it is x4. The vindicator can also use this ability in response to being critically hit, even if the attack incapacitates or kills the vindicator.",
          2, "Ability"
      }, //
      {867, "Favored Terrain",
          "At 1st level, a horizon walker may select a favored terrain from the ranger Favored Terrains table (Pathfinder RPG Core Rulebook 65). This works exactly like the ranger favored terrain ability. The horizon walker gains an additional favored terrain at 2nd, 4th, 5th, 7th, 8th and 10th level, and he can increase the bonus from an existing favored terrain as described in the ranger ability. If the horizon walker has abilities from other classes that only work in a favored terrain (such as a ranger's camouflage and hide in plain sight abilities), those abilities work in favored terrains selected as a horizon walker.",
          0, "Ability"
      }, //
      {868, "Terrain Mastery - Astral Plane",
          "The horizon walker's fly speed increases by +30 feet on planes with no gravity or subjective gravity.", 0, "Ability"
      }, //
      {869, "Terrain Mastery - Cold", "The horizon walker gains cold resistance 10.", 0, "Ability"}, //
      {870, "Terrain Mastery - Desert",
          "The horizon walker gains immunity to exhaustion, anything that would cause him to become exhausted makes him fatigued instead.",
          0, "Ability"
      }, //
      {871, "Terrain Mastery - Ethereal Plane",
          "The horizon walker ignores the 20% concealment miss chance from fog and mist, and treats total concealment from these sources as concealment.",
          0, "Ability"
      }, //
      {872, "Terrain Mastery - Forest", "The horizon walker gains a +4 competence bonus on Stealth checks.", 0, "Ability"}, //
      {873, "Terrain Mastery - Jungle",
          "The horizon walker gains a +4 competence bonus on Escape Artist checks and increases his CMD against grapple maneuvers by +4.",
          0, "Ability"
      }, //
      {874, "Terrain Mastery - Mountain",
          "The horizon walker gains a +4 competence bonus on Climb checks and does not lose his Dexterity modifier to AC while climbing.",
          0, "Ability"
      }, //
      {875, "Terrain Mastery - Plains",
          "The horizon walker's movement is not reduced by wearing medium armor or carrying a medium load.", 0, "Ability"
      }, //
      {876, "Terrain Mastery - Plane of Air",
          "The horizon walker gains a +4 competence bonus on Fly checks and +1 competence bonus on all attack and damage rolls against flying creatures. He gains the ability to breathe air if he cannot already do so.",
          0, "Ability"
      }, //
      {877, "Terrain Mastery - Plane of Earth", "The horizon walker gains DR 1/adamantine.", 0, "Ability"}, //
      {878, "Terrain Mastery - Plane of Fire", "The horizon walker gains fire resistance 10.", 0, "Ability"}, //
      {879, "Terrain Mastery - Plane of Water",
          "The horizon walker gains a +4 competence bonus on Swim checks and a +1 competence bonus on all attack and damage rolls against swimming creatures. He gains the ability to breathe water if he cannot already do so.",
          0, "Ability"
      }, //
      {880, "Terrain Mastery - Plane, aligned",
          "If the horizon walker selects a plane with an alignment trait, he can choose to detect as that alignment (fooling all forms of magic divination) as an immediate action, this benefit lasts until he dismisses it (a free action).",
          0, "Ability"
      }, //
      {881, "Terrain Mastery - Swamp", "The horizon walker gains a +4 competence bonus on Perception checks.", 0, "Ability"}, //
      {882, "Terrain Mastery - Underground", "The horizon walker gains Blind-Fight as a bonus feat.", 0, "Ability"}, //
      {883, "Terrain Mastery - Urban", "The horizon walker gains a +4 competence bonus on Diplomacy checks.", 0, "Ability"}, //
      {884, "Terrain Mastery - Water",
          "The horizon walker gains a +4 competence bonus on Swim checks and +1 competence bonus on all attack and damage rolls against swimming creatures.",
          0, "Ability"
      }, //
      {885, "Terrain Dominance - Astral Plane",
          "The horizon walker gains a +1 competence bonus on attack and damage rolls against outsiders. He gains dimension door as a spell-like ability a number of times per day equal to 3 + the character's Wisdom modifier (caster level equal to the character's level).",
          0, "Ability"
      }, //
      {886, "Terrain Dominance - Cold",
          "The horizon walker gains cold resistance 20 (this replaces the character's cold resistance from mastery of the cold terrain) and a +1 competence bonus on all attack and damage rolls against creatures of the cold subtype.",
          0, "Ability"
      }, //
      {887, "Terrain Dominance - Desert", "The horizon walker gains fire resistance 10 and immunity to fatigue.", 0, "Ability"}, //
      {888, "Terrain Dominance - Ethereal Plane",
          "The walker gains ethereal jaunt as a spell-like ability once per day (caster level equal to the character's level). He must be at least 7th level before selecting this power.",
          0, "Ability"
      }, //
      {889, "Terrain Dominance - Forest",
          "The horizon walker gains hallucinatory terrain as a spell-like ability a number of times per day equal to 3 + the character's Wisdom modifier (caster level equal to the character's level). The horizon walker can only use this ability to create illusory forests.",
          0, "Ability"
      }, //
      {890, "Terrain Dominance - Jungle",
          "The horizon walker gains charm monster as a spell-like ability a number of times per day equal to 3 + the character's Wisdom modifier (caster level equal to the character's level). This charm only affects animals, magical beasts, and creatures primarily found in the jungle.",
          0, "Ability"
      }, //
      {891, "Terrain Dominance - Mountain", "The horizon walker gains DR 2/adamantine.", 0, "Ability"}, //
      {892, "Terrain Dominance - Plains", "The walker's base speed increases by +10 feet.", 0, "Ability"}, //
      {893, "Terrain Dominance - Plane of Air",
          "The horizon walker gains fly as a spell-like ability a number of times per day equal to 3 + the character's Wisdom modifier (caster level equal to the character's level).",
          0, "Ability"
      }, //
      {894, "Terrain Dominance - Plane of Earth",
          "The horizon walker gains tremorsense with a range of 30 feet. He must be at least 5th level before selecting this plane for this ability.",
          0, "Ability"
      }, //
      {895, "Terrain Dominance - Plane of Fire",
          "The horizon walker gains fire resistance 20 (this replaces the character's file resistance from mastery of the Plane of Fire terrain) and a +1 competence bonus on all attack and damage rolls again creatures of the fire subtype.",
          0, "Ability"
      }, //
      {896, "Terrain Dominance - Plane of Water",
          "The horizon walker's movements and actions are not hampered when underwater. This allows him to speak, make attacks, and cast spells normally underwater (as if using freedom of movement).",
          0, "Ability"
      }, //
      {897, "Terrain Dominance - Plane, aligned",
          "For the purpose of bypassing damage reduction, the horizon walker's manufactured and natural weapons count as the opposite alignment of his chosen plane of dominance. If his chosen plane has more than one alignment type, he must choose one of those types for this ability. For example, if he selects 'Hell' (an evil, lawful plane) for his terrain dominance ability, he may choose 'evil' or 'lawful,' which means his attacks bypass good or chaotic damage reduction, respectively. Alternatively, if native creatures of his chosen plane are vulnerable to a particular special material (such as cold iron or silver), he may choose to have his weapons bypass damage reduction as if they were that special material. If he selects this plane more than once for his terrain dominance ability, his attacks count as an additional alignment or special material (such as 'good and silver' or 'chaotic and good').",
          0, "Ability"
      }, //
      {898, "Terrain Dominance - Swamp",
          "The horizon walker gains tremorsense with a 30-foot range. He must be 5th level before selecting this power.", 0,
          "Ability"
      }, //
      {899, "Terrain Dominance - Underground",
          "The horizon walker gains darkvision with a range of 60 feet. If he already has darkvision 60 feet, its range extends by 60 feet.",
          0, "Ability"
      }, //
      {900, "Terrain Dominance - Urban",
          "The horizon walker gains charm person as a spell-like ability a number of times per day equal to 3 + the character's Wisdom modifier (caster level equal to the character's level).",
          0, "Ability"
      }, //
      {901, "Terrain Dominance - Water",
          "The horizon walker gains a swim speed of 20 feet. If he already has a natural swim speed, his swim speed increases by +20 feet.",
          0, "Ability"
      }, //
      {902, "Master of All Lands",
          "At 10th level, the horizon walker becomes familiar with and comfortable in all possible terrains. His terrain bonus in all favored terrains increases by +2, and he treats all other terrains as if they were favored terrains (+2 bonus). If a naturally occurring condition of temperature or weather requires a check or saving throw, he automatically succeeds. All allies within 60 feet of him gain a +2 bonus on these checks and saves, if the horizon walker is in a mastered terrain, this bonus increases to +4.",
          3, "Ability"
      }, //
      {903, "Extracts per Day",
          "At the indicated levels, a master chymist gains new extracts per day as if she had also gained a level in alchemist. She does not, however, gain other benefits a character of that class would have gained, except for extracts per day and an increased effective caster level for extracts.",
          0, "Ability"
      }, //
      {904, "Bomb-Thrower",
          "The destructive power of bombs appeals to the violent urges of a master chymist. Add the character's alchemist and master chymist levels together to determine the damage done by her bombs.",
          1, "Ability"
      }, //
      {905, "Mutagenic Form",
          "A master chymist's mutagenic form is an alter ego that has a different personality than her normal form, an outgrowth of the mental changes caused by the mutagenic potions she has consumed over the course of her career. The mutagenic form shares memories and basic goals with the chymist's normal personality but goes about meeting those goals in a different manner. The mutagenic form is often ugly and monstrous and may even appear to be a different race or gender than her normal form, they may look as different as two unrelated people. Indeed, the mutagenic form often has his or her own name, and may attempt to maintain independent relationships and strongholds (though the alter ego's limited time in existence often makes this difficult). The mutagenic form even has his or her own alignment (which is selected by the player, but must be different from the master chymist's normal alignment). The change in alignment only affects the master chymist while in her mutagenic form.<br>Example: Darabont is a neutral good gnome alchemist 7/master chymist 4. Her mutagenic form is a deformed, twisted creature called Butcher. Butcher is neutral, and more interested in seeing the world kept in balance than promoting the greatest good. Butcher is aware she exists only when called on by Darabont, but seeks to build her own circle of like-minded friends during the hours she exists. Butcher does not dislike Darabont, but feels her gnome form is too soft and innocent to survive in the harsh world the chymist lives in. As Darabont, the character detects as good and is affected as a good character by spells with effects that vary by alignment, as Butcher, the same character is neutral, is not revealed by a detect good spell, and is treated as neutral for all spells and effects.",
          1, "Ability"
      }, //
      {906, "Mutate",
          "At 1st level, as a result of repeated exposure to her mutagens, the master chymist can now assume a mutagenic form twice per day without imbibing her mutagen. In this form, she gains all the bonuses and penalties of her mutagen and adds together her alchemist and master chymist levels together to determine her effective alchemist level for the duration of this form. Using a mutagen also forces the chymist into this form. Taking a mutagen or using the mutate ability again while in her mutagenic form works normally (with the new mutagen's modifiers replacing the current modifiers, and the longer duration taking precedent). The chymist remains in her mutagenic form until its duration expires, her magic is interrupted (as with an antimagic field), or she expends another use of her mutate ability.<br>A chymist may be forced to take her mutagenic form against her will by stress or damage. Anytime the character is in her normal form and has daily uses of the mutate ability available, she may be forced to switch after suffering a critical hit or failing a Fortitude save. In these situations the chymist must make a DC 25 Will save, if she fails, on her next turn she uses a standard action to change to her mutagenic form (which counts as a use of the mutate ability).<br>At 5th level, the master chymist can assume her mutagenic form three times per day, this increases to four times per day at 8th level and five times per day at 10th level.",
          3, "Ability"
      }, //
      {907, "Advanced Mutagen - Burly",
          "In her mutagenic form, the master chymist's heavy physical frame gives her an alchemical bonus on Strength checks, Constitution checks, and Strength-based skill checks as well as a bonus to CMB and CMD. The bonus is equal to half the master chymist's class level.",
          1, "Ability"
      }, //
      {908, "Advanced Mutagen - Disguise",
          "When in her mutagenic form, the chymist can temporarily change her appearance to her normal form and still retain most of the abilities of her mutagenic form. As a standard action, she may make a Will saving throw (DC 20) to assume the appearance of her normal form for one minute. Each additional minute beyond the first requires a new saving throw with a +1 increase to the DC. Failure means the chymist assumes her normal form (as if ending the use of mutagenic form) or reverts fully to her mutagenic form. At any time while using this ability, the chymist can resume her normal form as a standard action or relax her will and revert to her mutagenic form as a free action. Once this ability ends, the chymist cannot use it again until 10 minutes have passed. Obvious physical changes in mutagenic form such as draconic mutagen, feral mutagen, and growth mutagen do not work while the chymist is disguised in her normal form. Time spent disguised counts toward the chymist's time in her mutagenic form.",
          1, "Ability"
      }, //
      {909, "Advanced Mutagen - Draconic Mutagen",
          "When the chymist assumes her mutagenic form, she gains dragon-like features-scaly skin, reptilian eyes, and so on, resembling a half-dragon. The chymist chooses one dragon type (see the draconic bloodline) when selecting this advanced mutagen, once selected, this choice cannot be changed and determines her draconic resistances and breath weapon type. The chymist gains resistance 20 to the dragon's energy type. The chymist's breath weapon deals 8d8 points of energy damage (Reflex half, DC 10 + the chymist's class level + the chymist's Intelligence modifier), she may use her breath weapon once per transformation into her mutagenic form. The character must have an effective alchemist level (alchemist level plus master chymist levels) of at least 16, must know the form of the dragon I extract, and must have the feral mutagen discovery or advanced mutagen to select this ability.",
          1, "Ability"
      }, //
      {910, "Advanced Mutagen - Dual Mind",
          "The chymist's alter ego gives her a +2 bonus on Will saving throws in her normal and mutagenic forms. If she is affected by an enchantment spell or effect and fails her saving throw, she can attempt it again 1 round later at the same DC, if she succeeds, she is free of the effect (as if she had made her original save) and immediately changes to her mutagenic form or back to her normal form. If she has no more uses of the mutate ability remaining for the day, she cannot use dual mind. The character must have an effective alchemist level (alchemist level plus master chymist levels) of at least 10 to select this ability.",
          1, "Ability"
      }, //
      {911, "Advanced Mutagen - Evasion",
          "This mutagen functions as the rogue ability of the same name, except that it only applies in the chymist's mutagenic form.",
          1, "Ability"
      }, //
      {912, "Advanced Mutagen - Extended Mutagen", "The duration of the master chymist's mutation is doubled.", 1, "Ability"}, //
      {913, "Advanced Mutagen - Feral Mutagen",
          "This mutagen is identical to the alchemist discovery of the same name and counts as that discovery for the purpose of qualifying for other discoveries or advanced mutagens.",
          1, "Ability"
      }, //
      {914, "Advanced Mutagen - Furious Mutagen",
          "The damage dice for the feral mutagen's bite and claw attacks increase by one die step. The character must have an effective alchemist level (alchemist level plus chymist level) of at least 11 and must have the feral mutagen discovery or advanced mutagen to select this ability.",
          1, "Ability"
      }, //
      {915, "Advanced Mutagen - Grand Mutagen",
          "This mutagen is identical to the alchemist discovery of the same name and counts as that discovery for the purpose of qualifying for other discoveries or advanced mutagens. The character must have an effective alchemist level (alchemist level plus master chymist levels) of at least 16 and must have the feral mutagen discovery or advanced mutagen to select this ability.",
          1, "Ability"
      }, //
      {916, "Advanced Mutagen - Greater Mutagen",
          "This mutagen is identical to the alchemist discovery of the same name and counts as that discovery for the purpose of qualifying for other discoveries or advanced mutagens. The character must have an effective alchemist level (alchemist level plus chymist level) of at least 12 and must have the feral mutagen discovery or advanced mutagen to select this ability.",
          1, "Ability"
      }, //
      {917, "Advanced Mutagen - Growth Mutagen",
          "When the chymist assumes her mutagenic form, she increases one size category, as if under the effects of an enlarge person spell. The character must have an effective alchemist level (alchemist level plus chymist level) of at least 16 and must know the enlarge person, giant form I, or polymorph extract to select this ability.",
          3, "Ability"
      }, //
      {918, "Advanced Mutagen - Night Vision", "The chymist gains darkvision 60 feet and low-light vision in her mutagenic form.",
          1, "Ability"
      }, //
      {919, "Advanced Mutagen - Nimble",
          "The master chymist's lithe physical frame gives her an alchemical bonus on all Dexterity checks, Dexterity skill checks, and CMD, and a natural armor bonus to her Armor Class. The bonus is equal to half the master chymist's class level.",
          1, "Ability"
      }, //
      {920, "Advanced Mutagen - Restoring Change",
          "When the chymist assumes her mutagenic form or returns to her normal form from her mutagenic form, she heals a number of hit points equal to 1d8 + her character level.",
          3, "Ability"
      }, //
      {921, "Advanced Mutagen - Scent", "The master chymist gains the scent ability in her mutagenic form.", 1, "Ability"}, //
      {922, "Brutality",
          "At 3rd level, a master chymist's taste for violence leads her to strike more powerful blows with weapons easily mastered by her bestial mind. At 3rd level, a chymist in her mutagenic form deals +2 damage when attacking with simple weapons and natural attacks. This bonus increases to +4 at 7th level and to +6 at 9th level.",
          1, "Ability"
      }, //
      {923, "Art of Deception", "A master spy adds her class level to all Bluff, Disguise, and Sense Motive checks.", 1, "Ability"},
      //
      {924, "Master of Disguise",
          "A master spy can create a disguise in half the time normally required. In addition, any penalties from assuming a disguise of a different gender, race, age, or size are reduced by 1.",
          1, "Ability"
      }, //
      {925, "Sneak Attack",
          "This ability is exactly like the rogue ability of the same name. The extra damage dealt increases by +1d6 at every third level (1st, 4th, 7th, and 10th). If a master spy gets a sneak attack bonus from another source, the bonuses on damage stack.",
          1, "Ability"
      }, //
      {926, "Glib Lie",
          "A master spy of 2nd level or higher can deceive truth-detecting magic. A creature using this sort of magic against the spy must succeed on a caster level check against a DC of 15 + the master spy's class level to succeed (as if she were under the effect of a glibness spell), failure means the magic doesn't detect the spy's lies or force her to speak only the truth. This ability does not give the master spy the glibness spell's bonus on Bluff checks.",
          3, "Ability"
      }, //
      {927, "Mask Alignment",
          "A master spy of 2nd level or higher can alter her alignment aura to deceive spells that discern alignment (such as detect evil). She may choose to detect as any specific alignment, or to detect as no alignment at all. This ability does not protect against spells or effects that cause harm based on alignment. Masking her alignment aura is a standard action, and lasts until she changes it again or ends the effect.",
          3, "Ability"
      }, //
      {928, "Nonmagical Aura",
          "At 3rd level, a master spy can use magic aura twice per day, but only for the purpose of making an object appear nonmagical.",
          2, "Ability"
      }, //
      {929, "Superficial Knowledge",
          "A master spy gives the appearance of knowing more than she actually does. Starting at 3rd level, she can make untrained Knowledge and Profession checks pertaining to her cover or assumed identity as if she were trained and gains a bonus equal to half her level on these checks. For example, a master spy masquerading as a noblewoman can make untrained Knowledge (history) checks about the kingdom and Knowledge (nobility) checks about its noble and royal families as if she were trained, but she cannot make untrained Knowledge (nature) skill checks to identify herbs.",
          1, "Ability"
      }, //
      {930, "Concealed Thoughts",
          "A 4th-level master spy can conceal her schemes from mind-reading magic. When a creature is using detect thoughts or similar magic to read her mind, she decides what surface thoughts her opponent detects, and her true surface thoughts remain private. This ability does not protect against mental attacks or mind-reading that delves deeper than surface thoughts.",
          3, "Ability"
      }, //
      {931, "Quick Change",
          "Starting at 4th level, a master spy can assume a disguise in only 2d4 rounds by taking a -10 penalty on her Disguise check. This penalty drops to -5 at 8th level.",
          1, "Ability"
      }, //
      {932, "Elude Detection",
          "At 5th level, a master spy can befuddle divinations used against her as if she were under the effect of a nondetection spell with a caster level equal to her character level. She can suppress or resume this protection as a standard action. If dispelled, the spy cannot resume the nondetection for 1d4 rounds.",
          2, "Ability"
      }, //
      {933, "Slippery Mind",
          "At 5th level, a master spy can slip away from mental control. This functions as the rogue advanced talent of the same name. If the spy has the slippery mind ability from another class, these abilities stack, but she can still only use slippery mind once per round.",
          3, "Ability"
      }, //
      {934, "Shift Alignment",
          "Starting at 6th level, a master spy's control over her aura improves. When she assumes a false alignment, she can choose to have all spells and magic items affect her as though she were that alignment, this includes helpful and harmful effects. For example, a neutral good master spy can shift her aura to lawful evil so she can pass through a doorway that shocks creatures that aren't lawful evil, if hit by holy smite with this shifted aura, she takes damage as if she were evil. A master spy can change her alignment aura from a masked alignment (as per her 2nd-level class feature, where effects still function based on her actual alignment) to a shifted alignment (as per this ability, where effects function based on her assumed alignment) as a standard action. Shifting her alignment aura is a standard action, and lasts until she changes it again or ends the effect.",
          3, "Ability"
      }, //
      {935, "Death Attack",
          "At 8th level, a master spy learns the art of killing or paralyzing a foe with a careful strike. This ability functions as the assassin's death attack ability. If the master spy has levels in another class that grants the death attack ability, these levels stack with her master spy level to determine the DC of her death attack, even if she has not yet reached 8th level as a master spy.",
          1, "Ability"
      }, //
      {936, "Fool Casting",
          "A master spy of 8th level or higher can trick an opponent into believing that she has been charmed or dominated. When the master spy succeeds at a saving throw against a magical effect that provides ongoing control (such as charm person, dominate person, or a vampire's dominate ability), she can allow the spell to take partial effect. To the caster, it appears that the spy failed her saving throw, but the spy is not under the caster's control. If the spell provides a telepathic link, it functions normally, but the spy is under no obligation to follow the caster's commands. The master spy can dismiss a fooled spell as a standard action. Fooled casting can be used when the spy succeeds at a subsequent saving throw against an ongoing effect, such as that granted by slippery mind.",
          3, "Ability"
      }, //
      {937, "Hidden Mind",
          "At 9th level, a master spy gains the benefit of a constant mind blank spell at a caster level equal to her character level. The spy can suppress or resume this protection as a standard action. If dispelled, the spy cannot resume the mind blank for 1d4 rounds.",
          2, "Ability"
      }, //
      {938, "Assumption",
          "The ultimate ability of the master spy is to take over another persona entirely, making it her own. As a full-round action, the spy can touch a helpless creature and shift her aura to that of her target. This confuses divination effects and spells, even ones as powerful as discern location, such that they register the spy as being the creature she has touched. This ability is not proof against the actions of deities or similarly powerful beings. The assumption of an identity lasts until the master spy ends it (a standard action) or she uses the ability on another creature.",
          3, "Ability"
      }, //
      {939, "Spells per Day - Nature Warden",
          "At the indicated levels, a nature warden gains new spells per day as if she had also gained a level in a divine spellcasting class she belonged to before adding the prestige class. She does not, however, gain other benefits a character of that class would have gained, except for additional spells per day, spells known (if she is a spontaneous caster), and an increased effective level of spellcasting. If she had more than one divine spellcasting class before becoming a nature warden, she must decide to which class she adds the new level for the purpose of determining spells per day.",
          0, "Ability"
      }, //
      {940, "Companion Bond",
          "At 1st level, a nature warden's class levels stack with levels in all classes that grant an animal companion for the purpose of determining her animal companion's abilities. The nature warden and her animal companion have an empathic link like that between a wizard and his familiar. At 5th level, the nature warden's animal companion gains the same benefits the warden does when in the warden's favored terrain.",
          1, "Ability"
      }, //
      {941, "Natural Empathy",
          "For the purpose of the wild empathy ability, a nature warden's class level stacks with levels in all classes with the wild empathy ability. When in her favored terrain, a nature warden adds her favored terrain bonus to wild empathy checks. She may also choose to use wild empathy to demoralize an animal or magical beast rather than improving its attitude, as if using Intimidate rather than Diplomacy.<br>At 4th level, a nature warden no longer suffers a penalty when using wild empathy to influence or demoralize magical beasts. At 7th level, she may use wild empathy to affect vermin (whether mindless or with Intelligence 1 or 2). At 10th level, she may use it to affect plant creatures (whether mindless or with Intelligence 1 or 2).",
          1, "Ability"
      }, //
      {942, "Mystic Harmony",
          "At 2nd level, a nature warden in her favored terrain gains an insight bonus to AC equal to half her favored terrain bonus. She loses this bonus when she is immobilized or helpless.",
          3, "Ability"
      }, //
      {943, "Wild Stride",
          "At 2nd level, a nature warden and her animal companion gain the ability to move through natural hazards of her favored terrain (such as bogs, loose sand, snow, ice, rockslides, and so on) at her normal speed without taking damage or suffering any other impairment (in effect, this is the woodland stride ability applied to non-plant environmental hazards). Terrain hazards that have been magically manipulated to impede motion still affect her.",
          1, "Ability"
      }, //
      {944, "Animal Speech",
          "At 3rd level, a nature warden can speak with animals at will when in her favored terrain. Outside her favored terrain, she can use speak with animals once per day. Her caster level is equal to her class level.",
          2, "Ability"
      }, //
      {945, "Silverclaw",
          "At 4th level, a nature warden's animal companion and any creature she summons with summon nature's ally gain DR/silver equal to the warden's class level. In addition, their natural weapons are considered silver for the purpose of overcoming damage reduction.",
          3, "Ability"
      }, //
      {946, "Favored Terrain",
          "At 5th level and again at 10th level, a nature warden may choose a favored terrain. This ability is identical to and stacks with the ranger class ability.",
          1, "Ability"
      }, //
      {947, "Survivalist",
          "At 5th level, a nature warden suffers no penalty for using an improvised weapon or improvised tool. At 10th level, a warden can spend 1 minute examining and adjusting an improvised weapon or tool, thereafter she treats it as a masterwork weapon or tool.",
          1, "Ability"
      }, //
      {948, "Woodforging",
          "At 6th level, a nature warden can manufacture wooden items which she may use with surpassing skill. Once per day, she may use wood shape as a spell-like ability with a caster level equal to her nature warden level. In her hands, items created with this ability are treated as masterwork items under the effect of an ironwood spell, in the hands of others, they are merely ordinary wooden items of the appropriate type. If the warden uses this ability to create armor or weapons, she may craft them into magic items as if she had the Craft Magic Arms and Armor feat (though they are merely magical wood in the hands of others, and only ironwood when she uses them).",
          2, "Ability"
      }, //
      {949, "Companion Walk",
          "At 7th level, the nature warden's companion shares the benefits of travel spells (such as tree stride and transport via plants) and polymorph and similar spells (including tree shape) cast by the warden from the druid or ranger spell list. The companion counts either as part of the warden or as an object with no weight, whichever is more favorable for the warden.",
          3, "Ability"
      }, //
      {950, "Plant Speech",
          "At 7th level, a nature warden can cast speak with plants at will when in her favored terrain. Outside her favored terrain, she can use speak with plants once per day as a spell-like ability. Her caster level is equal to her class level.",
          2, "Ability"
      }, //
      {951, "Ironpaw",
          "At 8th level, a nature warden may grant her animal companion and any creature she summons with summon nature's ally DR/cold iron equal to her class level. In addition, their natural weapons are considered cold iron for the purpose of overcoming damage reduction. This ability does not stack with the silverclaw ability. The warden must decide at the time of summoning whether a summoned creature gains the benefits of silverclaw or ironpaw. She may change which ability applies to her animal companion by spending 1 hour in prayer and meditation with the companion within 100 feet.",
          3, "Ability"
      }, //
      {952, "Guarded Lands ",
          "At 9th level, a nature warden may designate an area as her guarded lands, allowing her to treat it as her favored terrain or to enhance her bonuses if it is already in her favored terrain. The area must be no larger than 1 square mile, and the warden must spend 24 hours carefully studying the entire area. This period of study gives her a +2 favored terrain bonus in that area, which stacks with any favored terrain bonus for that area (for example, she also gets her forest favored terrain bonus if her guarded lands are part of a forest). She may also designate one creature type as her favored enemy within those guarded lands, gaining a +2 favored enemy bonus against the creature type that stacks with any favored enemy bonus she has against that type of creature. Allies who can see and hear the warden gain an initiative bonus equal to half the warden's favored terrain bonus for that terrain.<br>A nature warden may have a number of guarded lands equal to her Wisdom bonus (minimum 1). When she reaches her maximum number of guarded lands, she can select a new guarded land by abandoning an existing one and performing the ritual for a new area.",
          1, "Ability"
      }, //
      {953, "Companion Soul",
          "At 10th level, a nature warden's bond with her animal companion is so strong that it transcends distance and even death. The companion's devotion ability increases to a +8 morale bonus on Will saves against enchantment spells and effects. The warden may scry on her animal companion once per day as if using the scrying spell, except she needs no focus or divine focus. She may view the area around her companion or see through its eyes. If her companion dies, she can revive it with an 8-hour ritual, this has the same effect as raise dead, except it doesn't require a material component and the companion does not gain any negative levels from the ordeal.",
          3, "Ability"
      }, //
      {954, "Spells per Day - Rage Prophet",
          "At the indicated levels, a rage prophet gains new spells per day as if he had also gained a level in a divine spellcasting class he belonged to before adding the prestige class. He does not, however, gain other benefits a character of that class would have gained, except for additional spells per day, spells known (if he is a spontaneous caster), and an increased effective level of spellcasting. If he had more than one divine spellcasting class before becoming a rage prophet, he must decide to which class he adds the new level for the purpose of determining spells per day.",
          0, "Ability"
      }, //
      {955, "Savage Seer",
          "A rage prophet's class level stacks with barbarian levels for determining the effect of rage powers, and with oracle levels for determining the effect of oracle revelations and his oracle's curse. This does not grant additional abilities.",
          0, "Ability"
      }, //
      {956, "Spirit Guide",
          "Every rage prophet possesses a spirit guide, an insubstantial phantom that speaks to his mind, watches over him, and lends him its strength and wisdom. Whenever the rage prophet rages, he gains the benefit of a single guidance spell from his spirit guide, this bonus can be used at any time during his rage. The spirit guide also allows the rage prophet to use dancing lights, ghost sound, and mage hand as spell-like abilities once per day each (caster level equal to the rage prophet's class level). The DCs are Charisma-based.",
          2, "Ability"
      }, //
      {957, "Spells - Rage Prophet Mystery",
          "At 2nd level and every even level thereafter, a rage prophet learns an additional spell from his spirit guide. These spells are in addition to those listed in Table 2-6: Oracle Spells Known. Like spells from an oracle's mystery, the rage prophet cannot exchange these spells for different spells at higher levels. The rage prophet must be able to cast oracle spells of the listed level to learn one of these spells from his spirit guide. The rage prophet treats the spell as an oracle spell of the listed level. The possible spells are arcane eye (4th), augury (2nd), divination (4th), dream (5th), find the path (6th), helping hand (3rd), see invisibility (2nd), shadow walk (6th), speak with dead (3rd), spectral hand (2nd), spiritual weapon (2nd), unseen servant (1st), vision (7th), and whispering wind (2nd).",
          0, "SpelllistAbility"
      }, //
      {958, "Raging Healer",
          "At 2nd level, a rage prophet is able to cast cure spells on himself while raging, without having to use clarity of mind.",
          3, "Ability"
      }, //
      {959, "Indomitable Caster", "At 3rd level, a rage prophet adds his Constitution bonus (if any) on concentration checks.", 1,
          "Ability"
      }, //
      {960, "Ragecaster",
          "Starting at 4th level, a rage prophet's spells grow more potent when he rages. When using moment of clarity, he adds his barbarian level to his caster level. At 7th level, he adds his Constitution bonus to the save DC of any spells cast while raging.",
          3, "Ability"
      }, //
      {961, "Spirit Guardian",
          "At 5th level, the competence bonus provided by the spirit guide's guidance spell increases to half the rage prophet's class level when used while battling a fey, outsider, undead, or incorporeal creature. As a swift action, the rage prophet can spend 1 round of rage (whether he is raging or not) to give his armor and weapons the ghost touch property for 1 round, this effect ends if the item is no longer in his possession.",
          2, "Ability"
      }, //
      {962, "Enduring Rage",
          "At 6th level, as a free action, a rage prophet can extend the duration of his rage by sacrificing a spell slot, this prolongs the duration of his rage for a number of rounds equal to the level of the spell slot used.",
          3, "Ability"
      }, //
      {963, "Raging Spellstrength",
          "At 8th level, a rage prophet is able to cast spells with a range of 'personal' on himself while raging, without having to use clarity of mind.",
          3, "Ability"
      }, //
      {964, "Spirit Warrior",
          "At 9th level, the competence bonus provided by the rage prophet's guidance increases to his rage prophet level when used while battling a fey, outsider, undead, or incorporeal creature. His ability to give his armor and weapons the ghost touch property becomes an immediate action instead of a swift action.",
          3, "Ability"
      }, //
      {965, "Greater Rage",
          "At 10th level, when a rage prophet enters a rage, his morale bonus to Strength and Constitution increases to +6 and his morale bonus on Will saves increases to +3.",
          1, "Ability"
      }, //
      {966, "AC Bonus - Stalwart Defender",
          "A stalwart defender receives a dodge bonus to AC that starts at +1 and improves as the defender gains levels, until it reaches +4 at 10th level.",
          1, "Ability"
      }, //
      {967, "Defensive Stance",
          "At 1st level, a stalwart defender can enter a defensive stance, a position of readiness and trancelike determination. A stalwart defender can maintain this stance for a number of rounds per day equal to 4 + his Constitution modifier. At each level after 1st, he can maintain the stance for 2 additional rounds per day. Temporary increases to Constitution, such as those gained from the defensive stance and spells like bear's endurance, do not increase the total number of rounds that the stalwart defender can maintain a defensive stance per day. The stalwart defender can enter a defensive stance as a free action. The total number of rounds of defensive stance per day is renewed after resting for 8 hours, although these hours do not need to be consecutive.<br>While in a defensive stance, the stalwart defender gains a +2 dodge bonus to AC, a +4 morale bonus to his Strength and Constitution, as well as a +2 morale bonus on Will saves. The increase to Constitution grants the stalwart defender 2 hit points per Hit Die, but these hit points disappear when the defensive stance ends and are not lost first like temporary hit points. While in a defensive stance, a stalwart defender cannot willingly move from his current position through any means (including normal movement, riding a mount, teleportation, or willingly allowing allies to carry him). If he enters a defensive stance while on a moving vehicle he does not control (such as a wagon or ship), he can maintain the stance even if the vehicle moves. If the stalwart defender moves under his own power as a result of an enemy's successful use of the Bluff skill or an enchantment spell, his stance ends.<br>The stalwart defender can end his defensive stance as a free action, after ending the stance, he is fatigued for a number of rounds equal to 2 times the number of rounds spent in the stance. A stalwart defender cannot enter a new defensive stance while fatigued or exhausted but can otherwise enter a stance multiple times during a single encounter or combat. If a stalwart defender falls unconscious, his defensive stance immediately ends, placing him in peril of death.<br>A defensive stance requires a level of emotional calm, and it may not be maintained by a character in a rage (such as from the rage class feature or the rage spell).",
          1, "Ability"
      }, //
      {968, "Defensive Powers - Bulwark",
          "The defender adds his armor check penalty as a bonus to the DC of opponents attempting to Bluff him and Acrobatics checks to pass by him without provoking an attack of opportunity for moving through spaces he threatens.",
          1, "Ability"
      }, //
      {969, "Defensive Powers - Clear Mind",
          "The stalwart defender may reroll a failed Will save. This power is used as an immediate action after the first save is attempted, but before the results are revealed by the GM. The stalwart defender must take the second result, even if it is worse. This power can only be used once per defensive stance.",
          1, "Ability"
      }, //
      {970, "Defensive Powers - Fearless Defense",
          "While in a defensive stance, the stalwart defender is immune to the shaken and frightened conditions. He must be at least 4th level before selecting this power.",
          1, "Ability"
      }, //
      {971, "Defensive Powers - Halting Blow",
          "If a foe's movement in the defender's threatened area provokes an attack of opportunity and the stalwart defender successfully hits the foe with the attack, the foe's movement ends immediately. The foe cannot move again until its next turn but can still take the rest of its action. A stalwart defender must have selected the bulwark power prior to selecting halting blow.",
          1, "Ability"
      }, //
      {972, "Defensive Powers - Immobile",
          "While in a defensive stance, the stalwart defender adds his class level to his CMD against any bull rush, overrun, pull, and push combat maneuvers, as well as grapple attempts to move him. The stalwart defender must be at least 4th level to select this power.",
          1, "Ability"
      }, //
      {973, "Defensive Powers - Increased Damage Reduction",
          "The stalwart defender's damage reduction from this class increases by 1/-. This increase is always active while the stalwart defender is in a defensive stance. He can select this power up to two times. Its effects stack. The stalwart defender must be at least 6th level before selecting this defensive power.",
          1, "Ability"
      }, //
      {974, "Defensive Powers - Intercept",
          "Once a round as an immediate action, when a melee or ranged weapon would successfully strike an adjacent ally, the stalwart defender can choose to have the weapon strike him instead of the intended target. The attack automatically hits the stalwart defender, regardless his AC or any miss chance in effect, and he suffers the normal consequences of the attack.",
          1, "Ability"
      }, //
      {975, "Defensive Powers - Internal Fortitude",
          "While in a defensive stance, the stalwart defender is immune to the sickened and nauseated conditions.", 1, "Ability"
      }, //
      {976, "Defensive Powers - Mighty Resilience",
          "The stalwart defender automatically negates the additional damage of one successful critical hit or sneak attack, as well as other abilities or effects that rely on a successful critical hit or sneak attack (such as blinding from Blinding Critical or bleed from sneak attack). The stalwart defender takes only normal damage from the attack. This power may only be used once per defensive stance. The stalwart defender must be at least 6th level to select this power.",
          1, "Ability"
      }, //
      {977, "Defensive Powers - Renewed Defense",
          "As a standard action, the stalwart defender heals 1d8 points of damage + his Constitution modifier. For every two levels the stalwart defender has attained above 2nd, this healing increases by 1d8, to a maximum of 5d8 at 10th level. This power can be used only once per day and only while in a defensive stance.",
          1, "Ability"
      }, //
      {978, "Defensive Powers - Roused Defense",
          "The stalwart defender may enter a defensive stance even if fatigued. While maintaining a defensive stance after using this ability, he is immune to the fatigued condition. Once this stance ends, he is exhausted for 10 minutes per round spent in a defensive stance.",
          1, "Ability"
      }, //
      {979, "Defensive Powers - Smash",
          "While in a defensive stance, the stalwart defender may make an extra attack per round that is either a shield bash or a slam (even if he doesn't normally have a slam attack). If used as part of a full attack action, the extra attack is made at the stalwart defender's full base attack bonus -5. The smash deals 1d4 points of damage (if the stalwart defender is Medium, or 1d3 if he is Small) plus half the character's Strength modifier. The character can make this attack as part of the action to maintain or break free from a grapple, this attack is resolved before the grapple check is made. If the attack hits, any grapple checks made by the stalwart defender against the target this round are at a +2 bonus.",
          1, "Ability"
      }, //
      {980, "Defensive Powers - Unexpected Strike",
          "The stalwart defender can make an attack of opportunity against a foe that moves into any square threatened by the stalwart defender, regardless of whether or not that movement would normally provoke an attack of opportunity. This power can only be used once per stance. A stalwart defender must be at least 4th level before selecting this power.",
          1, "Ability"
      }, //
      {981, "Mobile Defense",
          "At 9th level, a stalwart defender can adjust his position while maintaining a defensive stance. While in a defensive stance, he can take one 5-foot step each round without losing the benefit of the stance.",
          1, "Ability"
      }, //
      {982, "Last Word",
          "Once per day, while in a defensive stance, a stalwart defender can make one melee attack against an opponent within reach in response to an attack that would reduce him to negative hit points, knock him unconscious, or kill him. For example, a stalwart defender has 1 hit point left when a red dragon bites him, the defender may use this ability even if the dragon's bite would otherwise kill him instantly. If the attack hits, roll the damage dice for the attack twice and add the results together, but do not multiply damage bonuses from Strength, weapon abilities (such as flaming), or precision-based damage (such as sneak attack). This bonus damage is not multiplied on a critical hit (although other damage bonuses are multiplied normally). Once the defender's attack is resolved, he suffers the normal effect of the attack that provoked this ability.",
          1, "Ability"
      }, //
      {983, "Mystery Flame - Class Skills",
          "An oracle with the flame mystery adds Acrobatics, Climb, Intimidate, and Perform to her list of class skills.", 0,
          "Ability"
      }, //
      {984, "Spells - Mystery Flame",
          "burning hands (2nd), resist energy (4th), fireball (6th), wall of fire (8th), summon monster V (fire elementals only, 10th), fire seeds (12th), fire storm (14th), incendiary cloud (16th), fiery body* (18th).",
          0, "SpelllistAbility"
      }, //
      {985, "Mystery Flame - Burning Magic",
          "Whenever a creature fails a saving throw and takes fire damage from one of your spells, it catches on fire. This fire deals 1 point of fire damage per spell level at the beginning of the burning creature's turn. The fire lasts for 1d4 rounds, but it can be extinguished as a move action if the creature succeeds at a Reflex save (using the spell's DC). Dousing the creature with water as a standard action grants a +2 bonus on this save, while immersing the creature in water automatically extinguishes the fire. Spells that do not grant a save do not cause a creature to catch on fire.",
          3, "Ability"
      }, //
      {986, "Mystery Flame - Cinder Dance",
          "Your base speed increases by 10 feet. At 5th level, you receive Nimble Moves as a bonus feat. At 10th level, you receive Acrobatic Steps as a bonus feat. You do not need to meet the prerequisites to receive these feats. Oracles with the lame oracle curse cannot select this evelation.",
          1, "Ability"
      }, //
      {987, "Mystery Flame - Fire Breath",
          "As a standard action, you can unleash a 15-foot cone of flame from your mouth. This flame deals 1d4 points of fire damage per level. A Reflex save halves this damage. You can use this ability once per day, plus one additional time per day at 5th level and every five levels thereafter. The save DC is Charisma-based.",
          3, "Ability"
      }, //
      {988, "Mystery Flame - Firestorm",
          "As a standard action, you can cause fire to erupt around you. You can create one 10-foot cube of fire per oracle level. These cubes can be arranged in any pattern you desire, but each cube must be adjacent to another and one must be adjacent to you. Any creature caught in these flames takes 1d6 points of fire damage per oracle level, with a Reflex save resulting in half damage. This fire lasts for a number of rounds equal to your Charisma modifier. You can use this ability once per day. You must be at least 11th level to select this revelation.",
          3, "Ability"
      }, //
      {989, "Mystery Flame - Form of Flame",
          "As a standard action, you can assume the form of a Small fire elemental, as elemental body I. At 9th level, you can assume the form of a Medium fire elemental, as elemental body II. At 11th level, you can assume the form of a Large fire elemental, as elemental body III. At 13th level, you can assume the form of a Huge fire elemental, as elemental body IV. You can use this ability once per day, but the duration is 1 hour/level. You must be at least 7th level to select this revelation.",
          3, "Ability"
      }, //
      {990, "Mystery Flame - Gaze of Flames",
          "You can see through fire, fog, and smoke without penalty as long as the light is sufficient to allow you to see normally. At 7th level, you can gaze through any source of flame within 10 feet per oracle level, as if using clairvoyance. You can use this ability for a number of rounds per day equal to your oracle level, but these rounds do not need to be consecutive.",
          3, "Ability"
      }, //
      {991, "Mystery Flame - Heat Aura",
          "As a swift action, you can cause waves of heat to radiate from your body. This heat deals 1d4 points of fire damage per two oracle levels (minimum 1d4) to all creatures within 10 feet. A Reflex save halves the damage. In addition, your form wavers and blurs, granting you 20% concealment until your next turn. You can use this ability once per day, plus one additional time per day at 5th level and every five levels thereafter.",
          3, "Ability"
      }, //
      {992, "Mystery Flame - Molten Skin",
          "You gain resist fire 5. This resistance increases to 10 at 5th level and 20 at 11th level. At 17th level, you gain immunity to fire.",
          1, "Ability"
      }, //
      {993, "Mystery Flame - Touch of Flame",
          "As a standard action, you can perform a melee touch attack that deals 1d6 points of fire damage +1 point for every two oracle levels you possess. You can use this ability a number of times per day equal to 3 + your Charisma modifier. At 11th level, any weapon that you wield is treated as a flaming weapon.",
          3, "Ability"
      }, //
      {994, "Mystery Flame - Wings of Fire",
          "As a swift action, you can manifest a pair of fiery wings that grant you a fly speed of 60 feet with average maneuverability. You can use these wings for 1 minute per day per oracle level. This duration does not need to be consecutive, but it must be spent in 1 minute increments. You must be at least 7th level before selecting this revelation.",
          3, "Ability"
      }, //
      {995, "Mystery Flame - Final Revelation",
          "Upon reaching 20th level, you become a master of fire. You can apply any one of the following feats to any fire spell you cast without increasing the level or casting time: Enlarge Spell, Extend Spell, Silent Spell, or Still Spell. You do not need to possess these feats to use this ability.",
          0, "Ability"
      }, //
      {996, "Spells - Patron Animals",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {997, "Spells - Patron Deception",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {998, "Spells - Patron Elements",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {999, "Spells - Patron Endurance",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1000, "Spells - Patron Plague",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1001, "Spells - Patron Shadow",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1002, "Spells - Patron Strength",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1003, "Spells - Patron Transformation",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1004, "Spells - Patron Trickery",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1005, "Spells - Patron Water",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1006, "Spells - Patron Wisdom",
          "At 1st level, when a witch gains her familiar, she must also select a patron. This patron is a vague and mysterious force, granting the witch power for reasons that she might not entirely understand. While these forces need not be named, they typically hold influence over one of the following forces. At 2nd level, and every two levels thereafter, a witch's patron adds new spells to a witch's list of spells known. These spells are also automatically added to the list of spells stored by the familiar.",
          0, "SpelllistAbility"
      }, //
      {1007, "Greater Banner",
          "At 14th level, the cavalier's banner becomes a rallying call to his allies. All allies within 60 feet receive a +2 morale bonus on saving throws against charm and compulsion spells and effects. In addition, while his banner is displayed, the cavalier can spend a standard action to wave the banner through the air, granting all allies within 60 feet an additional saving throw against any one spell or effect that is targeting them. This save is made at the original DC. Spells and effects that do not allow saving throws are unaffected by this ability. An ally cannot benefit from this ability more than once per day.",
          1, "Ability"
      }, //
      {1008, "Order of the Cockatrice - Edicts",
          "The cavalier must keep his own interests and aims above those of all others. He must always accept payment when it is due, rewards when earned, and an even (or greater) share of loot. The cavalier must take every opportunity to increase his own stature, prestige, and power.",
          0, "Ability"
      }, //
      {1009, "Order of the Cockatrice - Challenge",
          "Whenever an order of the cockatrice cavalier issues a challenge, he receives a +1 morale bonus on all melee damage rolls made against the target of his challenge as long as he is the only creature threatening the target (not counting his mount). This bonus increases by +1 for every four levels the cavalier possesses.",
          0, "Ability"
      }, //
      {1010, "Order of the Cockatrice - Skills",
          "An order of the cockatrice cavalier adds Appraise (Int) and Perform (Cha) to his list of class skills. In addition, an order of the cockatrice cavalier adds his Charisma modifier to the DC on another creature's attempt to demoralize him through Intimidate (in addition to his Wisdom modifier, as normal).",
          0, "Ability"
      }, //
      {1011, "Order of the Dragon - Edicts",
          "The cavalier must remain loyal to his allies and must always work to further the aims of the group. He must protect his allies from harm and defend their honor when called into doubt.",
          0, "Ability"
      }, //
      {1012, "Order of the Dragon - Challenge",
          "Whenever an order of the dragon cavalier issues a challenge, his allies receive a +1 circumstance bonus on melee attack rolls against the target of his challenge whenever he is threatening the target. This bonus increases by +1 for every four levels the cavalier possesses.",
          0, "Ability"
      }, //
      {1013, "Order of the Dragon - Skills",
          "An order of the dragon cavalier adds Perception (Wis) and Survival (Wis) to his list of class skills. In addition, whenever an order of the dragon cavalier uses Survival to provide food and water for his allies or to protect his allies from harsh weather, he receives a bonus on the check equal to 1/2 his cavalier level (minimum +1).",
          0, "Ability"
      }, //
      {1014, "Order of the Lion - Edicts",
          "The cavalier must protect the life and lands of his sovereign at all costs. He must obey the commands of his sovereign without question. He must strive to expand the power and prestige of his realm.",
          0, "Ability"
      }, //
      {1015, "Order of the Lion - Challenge",
          "Whenever an order of the lion cavalier issues a challenge, he receives a +1 dodge bonus to his AC against attacks made by the target of his challenge. This bonus increases by +1 for every four levels the cavalier possesses.",
          0, "Ability"
      }, //
      {1016, "Order of the Lion - Skills",
          "An order of the lion cavalier adds Knowledge (local) (Int) and Knowledge (nobility) (Int) to his list of class skills. An order of the lion cavalier can make Knowledge (nobility) skill checks untrained. If he has ranks in the skill, he receives a bonus on the check equal to 1/2 his cavalier level (minimum +1) as long as the check involves his sovereign.",
          0, "Ability"
      }, //
      {1017, "Order of the Shield - Edicts",
          "The cavalier must protect the lives and prosperity of the common folk, shielding them from the deprivations of those who would seek to cause them harm or exploit them. He must give charity when it is warranted and aid when needed. He must take no action that would cause harm or hardship to those who cannot defend themselves.",
          0, "Ability"
      }, //
      {1018, "Order of the Shield - Challenge",
          "Whenever an order of the shield cavalier issues a challenge, he receives a +1 morale bonus on attack rolls made against the target of his challenge if the target makes an attack against a target other than the cavalier. This bonus lasts for 1 minute. The bonus increases by +1 for every four levels the cavalier possesses.",
          0, "Ability"
      }, //
      {1019, "Order of the Shield - Skills",
          "An order of the shield cavalier adds Heal (Wis) and Knowledge (local) (Int) to his list of class skills. Whenever an order of the shield cavalier uses the Heal skill on a creature other than himself, he receives a bonus on the check equal to 1/2 his cavalier level (minimum +1).",
          0, "Ability"
      }, //
      {1020, "Order of the Star - Edicts",
          "The cavalier must strive to protect the faith and all those who follow its teachings, from priest to common man. He must adhere to the strictures of the faith, promote its cause whenever possible, and serve the agents of the divine.",
          0, "Ability"
      }, //
      {1021, "Order of the Star - Challenge",
          "Whenever an order of the star cavalier issues a challenge, he receives a +1 morale bonus on all his saving throws as long as he is threatening the target of his challenge. This bonus increases by +1 for every four levels the cavalier possesses.",
          0, "Ability"
      }, //
      {1022, "Order of the Star - Skills",
          "An order of the star cavalier adds Heal (Wis) and Knowledge (religion) (Int) to his list of class skills. An order of the star cavalier can make Knowledge (religion) skill checks untrained. If he has ranks in the skill, he receives a bonus on the check equal to 1/2 his cavalier level (minimum +1) as long as the check involves his chosen faith.",
          0, "Ability"
      }, //
      {1023, "Order of the Sword - Edicts",
          "The cavalier must show courage in the face of danger, mercy to those who have wronged him, and charity to the poor and the meek. He must be just and honorable at all times and in all things. He must defend his honor and, above all else, the honor of those he serves.",
          0, "Ability"
      }, //
      {1024, "Order of the Sword - Challenge",
          "Whenever an order of the sword cavalier issues a challenge, he receives a +1 morale bonus on attack rolls against the target of his challenge so long as he is astride his mount. The bonus increases by +1 for every four levels the cavalier possesses.",
          0, "Ability"
      }, //
      {1025, "Order of the Sword - Skills",
          "An order of the sword cavalier adds Knowledge (nobility) (Int) and Knowledge (religion) (Int) to his list of class skills. Whenever the cavalier uses Sense Motive to oppose a Bluff check, he receives a competence bonus on the check equal to 1/2 his cavalier level (minimum +1).",
          0, "Ability"
      }, //
      {1026, "Terrain Mastery",
          "At 2nd level, a horizon walker selects a favored terrain to master. When within this terrain the horizon walker may, as a move action, grant a +2 bonus on Climb, Stealth, Perception and Survival checks made by all allies within 30 feet who can see and hear him. The character masters one additional terrain at 4th, 6th, and 8th levels.",
          0, "Ability"
      }, //
      {1027, "Terrain Dominance",
          "At 3rd level, a horizon walker learns total dominance over one terrain he has already selected for terrain mastery. When dealing with creatures native to that terrain, the horizon walker treats his favored terrain bonus for that terrain as a favored enemy bonus (as the ranger class feature) against those creatures.This bonus overlaps (does not stack with) bonuses gained when fighting a favored enemy.",
          0, "Ability"
      }, //
      {1028, "Advanced Mutagen",
          "At 2nd level, the mutagenic form of the master chymist continues to evolve and develop as she grows in power. The master chymist selects an advanced mutagen, a power that changes how her mutagen form works or can only be accessed in her mutagenic form. She gains additional advanced mutagens at 4th, 6th, 8th, and 10th level. The chymist cannot select the same advanced mutagen more than once.",
          3, "Ability"
      }, //
      {1029, "Link",
          "A summoner and his eidolon share a mental link allows for communication across any distance (as long as they are on the same plane). This communication is a free action, allowing the summoner to give orders to his eidolon at any time. In addition, magic items interfere with the summoner's connection to his eidolon. As a result, the summoner and his eidolon share magic item slots. For example, if the summoner is wearing a ring, his eidolon can wear no more than one ring. In case of a conflict, the items worn by the summoner remain active, and those used by the eidolon become dormant. The eidolon must possess the appropriate appendages to utilize a magic item.",
          1, "Ability"
      }, //
      {1030, "Share Spells",
          "The summoner may cast a spell with a target of 'you' on his eidolon (as a spell with a range of touch) instead of on himself. A summoner may cast spells on his eidolon even if the spells normally do not affect creatures of the eidolon's type (outsider). Spells cast in this way must come from the summoner spell list. This ability does not allow the eidolon to share abilities that are not spells, even if they function like spells.",
          1, "Ability"
      }, //
      {1031, "Ability Score Increase", "The eidolon adds +1 to one of its ability scores.", 1, "Ability"}, //
      {1032, "Devotion", "An eidolon gains a +4 morale bonus on Will saves against enchantment spells and effects.", 1, "Ability"},
      //
      {1033, "Multiattack",
          "An eidolon gains Multiattack as a bonus feat if it has 3 or more natural attacks and does not already have that feat. If it does not have the requisite 3 or more natural attacks (or it is reduced to less than 3 attacks), the eidolon instead gains a second attack with one of its natural weapons, albeit at a -5 penalty. If the eidolon later gains 3 or more natural attacks, it loses this additional attack and instead gains Multiattack.",
          0, "Ability"
      }, //
      {1034, "Evolution - Bite",
          "An eidolon's maw is full of razor-sharp teeth, giving it a bite attack. This attack is a primary attack. The bite deals 1d6 points of damage (1d8 if Large, 2d6 if Huge). If the eidolon already has a bite attack, this evolution allows it to deal 1-1/2 times its Strength modifier on damage rolls made with its bite.",
          1, "Ability"
      }, //
      {1035, "Evolution - Claws",
          "An eidolon has a pair of vicious claws at the end of its limbs, giving it two claw attacks. These attacks are primary attacks. The claws deal 1d4 points of damage (1d6 if Large, 1d8 if Huge). The eidolon must have the limbs evolution to take this evolution. This evolution can only be applied to the limbs (legs) evolution once This evolution can be selected more than once, but the eidolon must possess an equal number of the limbs evolution.",
          1, "Ability"
      }, //
      {1036, "Evolution - Climb",
          "An eidolon becomes a skilled climber, gaining a climb speed equal to its base speed. This evolution can be selected more than once. Each additional time it is selected, increase the eidolon's climb speed by 20 feet.",
          1, "Ability"
      }, //
      {1037, "Evolution - Gills", "An eidolon has gills and can breathe underwater indefinitely.", 1, "Ability"}, //
      {1038, "Evolution - Improved Damage",
          "One of the eidolon's natural attacks is particularly deadly. Select one natural attack form and increase the damage die type by one step. This evolution can be selected more than once. Its effects do not stack. Each time an eidolon selects this evolution, it applies to a different natural attack.",
          1, "Ability"
      }, //
      {1039, "Evolution - Improved Natural Armor",
          "An eidolon's hide grows thick fur, rigid scales, or bony plates, giving it a +2 bonus to its natural armor. This evolution can be taken once for every five levels the summoner possesses.",
          1, "Ability"
      }, //
      {1040, "Evolution - Magic Attacks",
          "An eidolon is infused with magic, allowing it to treat all of its natural attacks as if they were magic for the purpose of overcoming damage reduction. If the summoner is 10th level or higher, all of the eidolon's weapons are treated as the alignment of the eidolon for the purpose of overcoming damage reduction.",
          3, "Ability"
      }, //
      {1041, "Evolution - Mount",
          "An eidolon is properly skilled and formed to serve as a combat-trained mount. The eidolon must be at least one size category larger than its rider. This evolution is only available to eidolons of the quadruped and serpentine base forms.",
          1, "Ability"
      }, //
      {1042, "Evolution - Pincers",
          "An eidolon grows a large pincers at the end of one pair of its limbs, giving it two pincer attacks. These attacks are secondary attacks. The pincers deal 1d6 points of damage (1d8 if Large, 2d6 if Huge). Eidolons with the grab evolution linked to pincers gain a +2 bonus on CMB checks made to grapple. The eidolon must have the limbs (arms) evolution to take this evolution. Alternatively, the eidolon can replace the claws from its base form with pincers (this still costs 1 evolution point). This evolution can be selected more than once, but the eidolon must possess an equal number of the limbs evolution.",
          1, "Ability"
      }, //
      {1043, "Evolution - Pounce",
          "An eidolon gains quick reflexes, allowing it to make a full attack after a charge. This evolution is only available to eidolons of the quadruped base form.",
          1, "Ability"
      }, //
      {1044, "Evolution - Pull",
          "An eidolon gains the ability to pull creatures closer with a successful attack. Select one type of natural attack. Whenever the eidolon makes a successful attack of the selected type, it can attempt a free combat maneuver check. If successful, the target of the attack is pulled 5 feet closer to the eidolon. This ability only works on creatures of a size equal to or smaller than the eidolon. Creatures pulled in this way do not provoke attacks of opportunity. The eidolon must have a reach of 10 feet or more to select this evolution. This evolution can be selected more than once. Its effects do not stack. Each time an eidolon selects this evolution, it applies to a different natural attack.",
          1, "Ability"
      }, //
      {1045, "Evolution - Push",
          "An eidolon gains the ability to push creatures away with a successful attack. Select one type of natural attack. Whenever the eidolon makes a successful attack of the selected type, it can attempt a free combat maneuver check. If successful, the target of the attack is pushed 5 feet directly away from the eidolon. This ability only works on creatures of a size equal to or smaller than the eidolon. Creatures pushed in this way do not provoke attacks of opportunity. This evolution can be selected more than once. Its effects do not stack. Each time an eidolon selects this evolution, it applies to a different natural attack.",
          1, "Ability"
      }, //
      {1046, "Evolution - Reach",
          "One of an eidolon's attacks is capable of striking at foes at a distance. Pick one attack. The eidolon's reach with that attack increases by 5 feet.",
          1, "Ability"
      }, //
      {1047, "Evolution - Resistance",
          "An eidolon's form takes on a resiliency to one particular energy type, which is usually reflected in its physical body (ashen hide for fire, icy breath for cold, and so on). Pick one energy type (acid, cold, electricity, fire, or sonic). The eidolon gains resist 5 against that energy type. This resistance increases by 5 for every 5 levels the summoner possesses, to a maximum of 15 at 10th level. This evolution can be selected more than once. Its effects do not stack. Each time an eidolon selects this evolution, it applies to a different energy type.",
          1, "Ability"
      }, //
      {1048, "Evolution - Scent",
          "An eidolon's sense of smell becomes quite acute. The eidolon gains the scent special quality, allowing it to detect opponents within 30 feet by sense of smell. If the opponent is upwind, the range increases to 60 feet, if downwind, it drops to 15 feet. Strong scents can be detected at twice the normal range. Scent does not allow the eidolon to precisely locate the creature, only to detect its presence. It can detect the direction with a move action. The eidolon can pinpoint the creature's location if it is within 5 feet. The eidolon can use scent to track creatures.",
          1, "Ability"
      }, //
      {1049, "Evolution - Skilled",
          "An eidolon becomes especially adept at a specific skill, gaining a +8 racial bonus on that skill. This evolution can be selected more than once. Its effects do not stack. Each time an eidolon selects this evolution, it applies to a different skill.",
          1, "Ability"
      }, //
      {1050, "Evolution - Slam",
          "An eidolon can deliver a devastating slam attack. This attack is a primary attack. The slam deals 1d8 points of damage (2d6 if Large, 2d8 if Huge). The eidolon must have the limbs (arms) evolution to take this evolution. Alternatively, the eidolon can replace the claws from its base form with this slam attack (this still costs 1 evolution point). This evolution can be selected more than once, but the eidolon must possess an equal number of the limbs evolution.",
          1, "Ability"
      }, //
      {1051, "Evolution - Sting",
          "An eidolon possesses a long, barbed stinger at the end of its tail, granting it a sting attack. This attack is a primary attack. The sting deals 1d4 points of damage (1d6 if Large, 1d8 if Huge). The eidolon must possess the tail evolution to take this evolution. This evolution can be selected more than once, but the eidolon must possess an equal number of the tail evolution.",
          1, "Ability"
      }, //
      {1052, "Evolution - Swim",
          "An eidolon gains webbed hands, feet, or powerful flippers, giving it a swim speed equal to its base speed. This evolution does not give the eidolon the ability to breathe underwater. This evolution can be selected more than once. Each additional time it is selected, increase the eidolon's swim speed by 20 feet.",
          1, "Ability"
      }, //
      {1053, "Evolution - Tail",
          "An eidolon grows a long, powerful tail. This grants it a +2 racial bonus on Acrobatics checks made to balance on a surface. This evolution can be selected more than once.",
          1, "Ability"
      }, //
      {1054, "Evolution - Tail Slap",
          "An eidolon can use its tail to bash nearby foes, granting it a tail slap attack. This attack is a secondary attack. The tail slap deals 1d6 points of damage (1d8 if Large, 2d6 if Huge). The eidolon must possess the tail evolution to take this evolution. This evolution can be selected more than once, but the eidolon must possess an equal number of the tail evolution.",
          1, "Ability"
      }, //
      {1055, "Evolution - Tentacle",
          "An eidolon possesses a long, sinuous tentacle, granting it a tentacle attack. This attack is a secondary attack. The tentacle attack deals 1d4 points of damage (1d6 if Large, 1d8 if Huge). This evolution can be selected more than once.",
          1, "Ability"
      }, //
      {1056, "Evolution - Wing Buffet",
          "An eidolon learns to use its wings to batter foes, granting it two wing buffet attacks. These attacks are secondary attacks. The wing buffets deal 1d4 points of damage (1d6 if Large, 1d8 if Huge). The eidolon must possess the flight evolution, with wings, to select this evolution.",
          1, "Ability"
      }, //
      {1057, "Evolution - Ability Increase",
          "An eidolon grows larger muscles, gains faster reflexes, achieves greater intelligence, or acquires another increase to one of its abilities. Increase one of the eidolon's ability scores by +2. This evolution can be selected more than once. It can only be applied once to an individual ability score, plus 1 additional time for every 6 levels the summoner possesses.",
          1, "Ability"
      }, //
      {1058, "Evolution - Constrict",
          "An eidolon gains powerful muscles that allow it to crush those it grapples. Whenever the eidolon successfully grapples a foe using the grab evolution, it deals additional damage equal to the amount of damage dealt by the attack used by the grab evolution. This evolution is only available to eidolons of the serpentine base form.",
          1, "Ability"
      }, //
      {1059, "Evolution - Energy Attacks",
          "An eidolon's attacks become charged with energy. Pick one energy type: acid, cold, electricity, or fire. All of the eidolon's natural attacks deal 1d6 points of energy damage of the chosen type on a successful hit. The summoner must be at least 5th level before selecting this evolution.",
          3, "Ability"
      }, //
      {1060, "Evolution - Flight",
          "An eidolon grows large wings, like those of a bat, bird, insect, or dragon, gaining the ability to fly. The eidolon gains a fly speed equal to its base speed. The eidolon's maneuverability depends on it size. Medium or smaller eidolons have good maneuverability. Large eidolons have average maneuverability, while Huge eidolons have poor maneuverability. For 2 additional evolution points, the eidolon flies by means of magic. It loses its wings, but its maneuverability increases to perfect. Flying via magic means makes this a supernatural ability. The eidolon's fly speed can be increased by spending additional evolution points, gaining a 20-foot increase to fly speed for each additional point spent. The summoner must be at least 5th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1061, "Evolution - Gore",
          "An eidolon grows a number of horns on its head, giving it a gore attack. This attack is a primary attack. The gore deals 1d6 points of damage (1d8 if Large, 2d6 if Huge).",
          1, "Ability"
      }, //
      {1062, "Evolution - Grab",
          "An eidolon becomes adept at grappling foes, gaining the grab ability. Pick bite, claw, pincers, slam, tail slap, or tentacle attacks. Whenever the eidolon makes a successful attack of the selected type, it can attempt a free combat maneuver check. If successful, the eidolon grapples the target. This ability only works on creatures of a size one category smaller than the eidolon or smaller. Eidolons with this evolution receive a +4 bonus on CMB checks made to grapple.",
          1, "Ability"
      }, //
      {1063, "Evolution - Immunity",
          "An eidolon's body becomes extremely resilient to one energy type, gaining immunity to that type. Pick one energy type: acid, cold, electricity, fire, or sonic. The eidolon gains immunity to that energy type. This evolution can be selected more than once. Its effects do not stack. Each time it applies to a different energy type. The summoner must be at least 7th level before selecting this evolution.",
          3, "Ability"
      }, //
      {1064, "Evolution - Limbs (arms)",
          "An eidolon grows an additional pair of limbs. These limbs can take one of two forms. They can be made into legs, complete with feet. Each pair of legs increases the eidolon's base speed by 10 feet. Alternatively, they can be made into arms, complete with hands. The eidolon does not gain any additional natural attacks for an additional pair of arms, but it can take other evolutions that add additional attacks (such as claws or a slam). Arms that have hands can be used to wield weapons, if the eidolon is proficient. This evolution can be selected more than once.",
          1, "Ability"
      }, //
      {1065, "Evolution - Poison",
          "An eidolon secretes toxic venom, gaining a poison attack. Pick one bite or sting attack. Whenever the selected attack hits, the target is poisoned. Eidolon poison-type poison (injury), save Fort negates, frequency 1/round for 4 rounds, effect 1d4 Str damage, cure 1 save. The save DC is equal to 10 + 1/2 the eidolon's HD + the eidolon's Constitution modifier. For 2 additional evolution points, this poison deals Constitution damage instead. This poison can be used no more than once per round. The summoner must be at least 7th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1066, "Evolution - Rake",
          "An eidolon grows dangerous claws on its feet, allowing it to make 2 rake attacks on foes it is grappling. These attacks are primary attacks. The eidolon receives these additional attacks each time it succeeds on a grapple check against the target. These rake attacks deal 1d4 points of damage (1d6 if Large, 1d8 if Huge). This evolution is only available to eidolons of the quadruped base form. This evolution counts as one natural attack toward te eidolon's maximum. The summoner must be at least 4th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1067, "Evolution - Rend",
          "An eidolon learns to rip and tear the flesh of those it attacks with its claws, gaining the rend ability. Whenever the eidolon makes two successful claw attacks against the same target in 1 round, its claws latch onto the flesh and deal extra damage. This damage is equal to the damage dealt by one claw attack plus 1-1/2 times the eidolon's Strength modifier. The eidolon must possess the claws evolution to select this evolution. The summoner must be at least 6th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1068, "Evolution - Trample",
          "An eidolon gains the ability to crush its foes underfoot, gaining the trample ability. As a full-round action, the eidolon can overrun any creature that is at least one size smaller than itself. This works like the overrun combat maneuver, but the eidolon does not need to make a check, it merely has to move over opponents in its path. The creatures take 1d6 points of damage (1d8 if Large, 2d6 if Huge), plus 1-1/2 times the eidolon's Strength modifier. Targets of the trample can make attacks of opportunity at a -4 penalty. If a target forgoes the attack of opportunity, it can make a Reflex save for half damage. The DC of this save is 10 + 1/2 the eidolon's HD + the eidolon's Strength modifier. A trampling eidolon can only deal trampling damage to a creature once per round. This evolution is only available to eidolons of the biped or quadruped base forms.",
          1, "Ability"
      }, //
      {1069, "Evolution - Tremorsense",
          "An eidolon becomes attuned to vibrations in the ground, gaining tremorsense out to a range of 30 feet. This works like the blindsense evolution, but only if both the eidolon and the creature to be pinpointed are in contact with the ground. The summoner must be at least 7th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1070, "Evolution - Trip",
          "An eidolon becomes adept at knocking foes to the ground with its bite, granting it a trip attack. Whenever the eidolon makes a successful bite attack of the selected type, it can attempt a free combat maneuver check. If successful, the target is knocked prone. If the check fails, the eidolon is not tripped in return. This ability only works on creatures of a size equal to or smaller than the eidolon. The eidolon must possess the bite evolution to select this evolution.",
          1, "Ability"
      }, //
      {1071, "Evolution - Weapon Training",
          "An eidolon learns to use a weapon, gaining Simple Weapon Proficiency as a bonus feat. If 2 additional evolution points are spent, it gains proficiency with all martial weapons as well.",
          1, "Ability"
      }, //
      {1072, "Evolution - Blindsense",
          "An eidolon's senses become incredibly acute, giving it blindsense out to a range of 30 feet. This ability allows the eidolon to pinpoint the location of creatures that it cannot see without having to make a Perception check, but such creatures still have total concealment from the eidolon. Visibility still affects the eidolon's movement and it is still denied its Dexterity bonus to Armor Class against attacks from creatures it cannot see. The summoner must be at least 9th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1073, "Evolution - Burrow",
          "An eidolon grows thick and gnarled claws, allowing it to move through the earth. The eidolon gains a burrow speed equal to 1/2 its base speed. It can use this speed to move through dirt, clay, sand, and earth. It does not leave a hole behind, nor is its passage marked on the surface. The summoner must be at least 9th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1074, "Evolution - Damage Reduction",
          "An eidolon's body becomes resistant to harm, granting it damage reduction. Choose one alignment: chaotic, evil, good, or lawful. The eidolon gains DR 5 that can be bypassed by weapons that possess the chosen alignment. The alignment must be opposite to one of the alignments possessed by the eidolon. At 12th level, this protection can be increased to DR 10 by spending 2 additional evolution points. The summoner must be at least 9th level before selecting this evolution.",
          3, "Ability"
      }, //
      {1075, "Evolution - Frightful Presence",
          "An eidolon becomes unsettling to its foes, gaining the frightful presence ability. The eidolon can activate this ability as part of an offensive action, such as a charge or attack. Opponents within 30 feet of the eidolon must make a Will save or become shaken for 3d6 rounds. The DC of this save is equal to 10 + 1/2 the eidolon's HD + the eidolon's Charisma modifier. If the eidolon has at least 4 more Hit Dice than an opponent, that opponent becomes frightened instead. Foes with more HD than the eidolon are immune to this effect. The summoner must be at least 11th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1076, "Evolution - Swallow Whole",
          "An eidolon gains the swallow whole ability, giving it the ability to consume its foes. If the eidolon begins its turn with a creature grappled using its bite attack (see the grab evolution), it can attempt a combat maneuver check to swallow the creature. The creature can be up to one size category smaller than the eidolon. Swallowed creatures take damage equal to the eidolon's bite damage each round plus 1d6 points of bludgeoning damage. A swallowed creature keeps the grappled condition, but can attempt to cut its way free with a light slashing or piercing weapon. The amount of damage needed to cut free is equal to 1/10 the eidolon's total hit points. The eidolon's AC against these attacks is equal to 10 + 1/2 its natural armor bonus. If a swallowed creature cuts its way out, the eidolon loses this ability until it heals this damage. Alternatively, the swallowed creature can attempt to escape the grapple as normal. Success indicates that it has returned to the eidolon's mouth, where it can attempt to escape or be swallowed again. The eidolon must possess the grab evolution, tied to a bite attack, to take this evolution. The summoner must be at least 9th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1077, "Evolution - Web",
          "An eidolon gains a pair of spinnerets, giving it the ability to spin webs. The eidolon can use these webs to support itself plus up to one creature of the same size. It can throw webbing as a ranged touch attack up to 8 times per day, entangling a creature up to one size larger than the eidolon. The webbing has a range of 50 feet and a 10-foot range increment. Creatures entangled by the web can escape with an Escape Artist check or a Strength check (at a -4 penalty). The DC of these checks is equal to 10 + 1/2 the eidolon's HD + the eidolon's Con modifier. The webs have a Hardness of 0 and a number of hits points equal to the eidolon's total Hit Dice. The eidolon can climb its own webs at its climb speed and can pinpoint any creature touching its webs. The eidolon must possess the climb evolution to take this evolution. The summoner must be at least 7th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1078, "Evolution - Blindsight",
          "An eidolon's senses sharpen even further, granting it blindsight out to a range of 30 feet. The eidolon can maneuver and attack as normal, ignoring darkness, invisibility, and most forms of concealment as long as it has line of effect to the target. The eidolon must possess the blindsense evolution to take this evolution. The summoner must be at least 11th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1079, "Evolution - Breath Weapon",
          "An eidolon learns to exhale a cone or line of magical energy, gaining a breath weapon. Select either acid, cold, electricity, or fire. The eidolon can breathe a 30-foot cone (or 60-foot line) that deals 1d6 points of damage of the selected type per HD it possesses. Those caught in the breath weapon can attempt a Reflex save for half damage. The DC is equal to 10 + 1/2 the eidolon's HD + the eidolon's Constitution modifier. The eidolon can use this ability once per day. The eidolon can use this ability 1 additional time per day by spending an additional 1 evolution point (maximum 3/day). The summoner must be at least 9th level before selecting this evolution.",
          3, "Ability"
      }, //
      {1080, "Evolution - Fast Healing",
          "An eidolon's body gains the ability to heal wounds very quickly, giving it fast healing 1. The eidolon heals 1 point of damage each round, just like natural healing. Fast healing does not restore hit points lost due to starvation, thirst, or suffocation, nor does it allow the eidolon to regrow lost body parts (or to reattach severed parts). Fast healing functions as long as the eidolon is alive. This fast healing does not function when the eidolon is not on the same plane as its summoner. This healing can be increased by 1 per round for every 2 additional evolution points spent (maximum 5). The summoner must be at least 11th level before selecting this evolution.",
          3, "Ability"
      }, //
      {1081, "Evolution - Large",
          "An eidolon grows in size, becoming Large. The eidolon gains a +8 bonus to Strength, a +4 bonus to Constitution, and a +2 bonus to its natural armor. It takes a -2 penalty to its Dexterity. This size change also gives the creature a -1 size penalty to its AC and on attack rolls, a +1 bonus to its CMB and CMD, a -2 penalty on Fly skill checks, and a -4 penalty on Stealth skill checks. If the eidolon has the biped base form, it also gains 10-foot reach. Any reach evolutions the eidolon possesses are added to this total. The eidolon must be Medium to take this evolution. The summoner must be at least 8th level before selecting this evolution.<br>If 6 additional evolution points are spent, the eidolon instead becomes Huge. The eidolon gains a +16 bonus to Strength, a +8 bonus to Constitution, and a +5 bonus to its natural armor. It takes a -4 penalty to its Dexterity. This size change also give the creature a -2 size penalty to its AC and attack rolls, a +2 bonus to its CMB and CMD, 10-foot reach, a -4 penalty on Fly skill checks, and a -8 penalty on Stealth skill checks. If the eidolon has the biped base form, its reach increases to 15 feet (10 feet for all other base forms). Any reach evolutions the eidolon possesses are added to this total. These bonuses and penalties replace, and do not stack with, those gained from becoming Large. The summoner must be at least 13th level before selecting this option.<br>The ability increase evolution costs twice as much (4 evolution points) when adding to the Strength or Constitution scores of a Large or Huge eidolon.",
          1, "Ability"
      }, //
      {1082, "Evolution - Spell Resistance",
          "An eidolon is protected against magic, gaining spell resistance. The eidolon's spell resistance is equal to 11 + the summoner's level. This spell resistance does not apply to spells cast by the summoner. The summoner must be at least 9th level before selecting this evolution.",
          1, "Ability"
      }, //
      {1083, "Evolution - Limbs (legs)",
          "An eidolon grows an additional pair of limbs. These limbs can take one of two forms. They can be made into legs, complete with feet. Each pair of legs increases the eidolon's base speed by 10 feet. Alternatively, they can be made into arms, complete with hands. The eidolon does not gain any additional natural attacks for an additional pair of arms, but it can take other evolutions that add additional attacks (such as claws or a slam). Arms that have hands can be used to wield weapons, if the eidolon is proficient. This evolution can be selected more than once.",
          1, "Ability"
      }, //
  };

  /**
   * Ability Properties
   */
  public static final Object[][] ABILITY_PROPERTY = { //
      // ability_id, key, value
      {39, "number_of_extra_feats", "1"}, //
      {40, "number_of_skill_points", "1"}, //
      {81, "spelllist_id", "6"}, //
      {81, "spell_attribute_id", "5"}, //
      {81, "casting_type_id", "0"}, //
      {81, "spell_source_id", "1"}, //
      {81, "spells_known_table_id", "1"}, //
      {81, "spells_per_day_table_id", "1"}, //
      {81, "attribute_bonus_spell_slots", "true"}, //
      {81, "school_id", "-1"}, //
      {103, "spelllist_id", "3"}, //
      {103, "spell_attribute_id", "4"}, //
      {103, "casting_type_id", "1"}, //
      {103, "spell_source_id", "0"}, //
      {103, "spells_known_table_id", "3"}, //
      {103, "spells_per_day_table_id", "4"}, //
      {103, "attribute_bonus_spell_slots", "true"}, //
      {103, "school_id", "-1"}, //
      {110, "spelllist_id", "4"}, //
      {110, "spell_attribute_id", "4"}, //
      {110, "casting_type_id", "1"}, //
      {110, "spell_source_id", "0"}, //
      {110, "spells_known_table_id", "3"}, //
      {110, "spells_per_day_table_id", "4"}, //
      {110, "attribute_bonus_spell_slots", "true"}, //
      {110, "school_id", "-1"}, //
      {163, "spelllist_id", "7"}, //
      {163, "spell_attribute_id", "5"}, //
      {163, "casting_type_id", "1"}, //
      {163, "spell_source_id", "0"}, //
      {163, "spells_known_table_id", "3"}, //
      {163, "spells_per_day_table_id", "2"}, //
      {163, "attribute_bonus_spell_slots", "true"}, //
      {163, "school_id", "-1"}, //
      {179, "spelllist_id", "5"}, //
      {179, "spell_attribute_id", "4"}, //
      {179, "casting_type_id", "1"}, //
      {179, "spell_source_id", "0"}, //
      {179, "spells_known_table_id", "3"}, //
      {179, "spells_per_day_table_id", "2"}, //
      {179, "attribute_bonus_spell_slots", "true"}, //
      {179, "school_id", "-1"}, //
      {220, "spelllist_id", "1"}, //
      {220, "spell_attribute_id", "5"}, //
      {220, "casting_type_id", "0"}, //
      {220, "spell_source_id", "1"}, //
      {220, "spells_known_table_id", "2"}, //
      {220, "spells_per_day_table_id", "3"}, //
      {220, "attribute_bonus_spell_slots", "true"}, //
      {220, "school_id", "-1"}, //
      {334, "spelllist_id", "2"}, //
      {334, "spell_attribute_id", "3"}, //
      {334, "casting_type_id", "1"}, //
      {334, "spell_source_id", "1"}, //
      {334, "spells_known_table_id", "3"}, //
      {334, "spells_per_day_table_id", "4"}, //
      {334, "attribute_bonus_spell_slots", "true"}, //
      {334, "school_id", "-1"}, //
      {342, "spelllist_id", "2"}, //
      {342, "spell_attribute_id", "3"}, //
      {342, "casting_type_id", "1"}, //
      {342, "spell_source_id", "1"}, //
      {342, "spells_known_table_id", "3"}, //
      {342, "spells_per_day_table_id", "6"}, //
      {342, "attribute_bonus_spell_slots", "false"}, //
      {342, "school_id", "0"}, //
      {346, "spelllist_id", "2"}, //
      {346, "spell_attribute_id", "3"}, //
      {346, "casting_type_id", "1"}, //
      {346, "spell_source_id", "1"}, //
      {346, "spells_known_table_id", "3"}, //
      {346, "spells_per_day_table_id", "6"}, //
      {346, "attribute_bonus_spell_slots", "false"}, //
      {346, "school_id", "1"}, //
      {350, "spelllist_id", "2"}, //
      {350, "spell_attribute_id", "3"}, //
      {350, "casting_type_id", "1"}, //
      {350, "spell_source_id", "1"}, //
      {350, "spells_known_table_id", "3"}, //
      {350, "spells_per_day_table_id", "6"}, //
      {350, "attribute_bonus_spell_slots", "false"}, //
      {350, "school_id", "2"}, //
      {354, "spelllist_id", "2"}, //
      {354, "spell_attribute_id", "3"}, //
      {354, "casting_type_id", "1"}, //
      {354, "spell_source_id", "1"}, //
      {354, "spells_known_table_id", "3"}, //
      {354, "spells_per_day_table_id", "6"}, //
      {354, "attribute_bonus_spell_slots", "false"}, //
      {354, "school_id", "3"}, //
      {358, "spelllist_id", "2"}, //
      {358, "spell_attribute_id", "3"}, //
      {358, "casting_type_id", "1"}, //
      {358, "spell_source_id", "1"}, //
      {358, "spells_known_table_id", "3"}, //
      {358, "spells_per_day_table_id", "6"}, //
      {358, "attribute_bonus_spell_slots", "false"}, //
      {358, "school_id", "4"}, //
      {362, "spelllist_id", "2"}, //
      {362, "spell_attribute_id", "3"}, //
      {362, "casting_type_id", "1"}, //
      {362, "spell_source_id", "1"}, //
      {362, "spells_known_table_id", "3"}, //
      {362, "spells_per_day_table_id", "6"}, //
      {362, "attribute_bonus_spell_slots", "false"}, //
      {362, "school_id", "5"}, //
      {366, "spelllist_id", "2"}, //
      {366, "spell_attribute_id", "3"}, //
      {366, "casting_type_id", "1"}, //
      {366, "spell_source_id", "1"}, //
      {366, "spells_known_table_id", "3"}, //
      {366, "spells_per_day_table_id", "6"}, //
      {366, "attribute_bonus_spell_slots", "false"}, //
      {366, "school_id", "6"}, //
      {370, "spelllist_id", "2"}, //
      {370, "spell_attribute_id", "3"}, //
      {370, "casting_type_id", "1"}, //
      {370, "spell_source_id", "1"}, //
      {370, "spells_known_table_id", "3"}, //
      {370, "spells_per_day_table_id", "6"}, //
      {370, "attribute_bonus_spell_slots", "false"}, //
      {370, "school_id", "7"}, //
      {374, "spelllist_id", "2"}, //
      {374, "spell_attribute_id", "3"}, //
      {374, "casting_type_id", "1"}, //
      {374, "spell_source_id", "1"}, //
      {374, "spells_known_table_id", "3"}, //
      {374, "spells_per_day_table_id", "6"}, //
      {374, "attribute_bonus_spell_slots", "false"}, //
      {374, "school_id", "8"}, //
      {469, "spelllist_id", "8"}, //
      {469, "spell_attribute_id", "4"}, //
      {469, "casting_type_id", "1"}, //
      {469, "spell_source_id", "0"}, //
      {469, "spells_known_table_id", "3"}, //
      {469, "spells_per_day_table_id", "5"}, //
      {469, "attribute_bonus_spell_slots", "false"}, //
      {469, "school_id", "-1"}, //
      {471, "spelllist_id", "9"}, //
      {471, "spell_attribute_id", "4"}, //
      {471, "casting_type_id", "1"}, //
      {471, "spell_source_id", "0"}, //
      {471, "spells_known_table_id", "3"}, //
      {471, "spells_per_day_table_id", "5"}, //
      {471, "attribute_bonus_spell_slots", "false"}, //
      {471, "school_id", "-1"}, //
      {473, "spelllist_id", "10"}, //
      {473, "spell_attribute_id", "4"}, //
      {473, "casting_type_id", "1"}, //
      {473, "spell_source_id", "0"}, //
      {473, "spells_known_table_id", "3"}, //
      {473, "spells_per_day_table_id", "5"}, //
      {473, "attribute_bonus_spell_slots", "false"}, //
      {473, "school_id", "-1"}, //
      {475, "spelllist_id", "11"}, //
      {475, "spell_attribute_id", "4"}, //
      {475, "casting_type_id", "1"}, //
      {475, "spell_source_id", "0"}, //
      {475, "spells_known_table_id", "3"}, //
      {475, "spells_per_day_table_id", "5"}, //
      {475, "attribute_bonus_spell_slots", "false"}, //
      {475, "school_id", "-1"}, //
      {477, "spelllist_id", "12"}, //
      {477, "spell_attribute_id", "4"}, //
      {477, "casting_type_id", "1"}, //
      {477, "spell_source_id", "0"}, //
      {477, "spells_known_table_id", "3"}, //
      {477, "spells_per_day_table_id", "5"}, //
      {477, "attribute_bonus_spell_slots", "false"}, //
      {477, "school_id", "-1"}, //
      {479, "spelllist_id", "13"}, //
      {479, "spell_attribute_id", "4"}, //
      {479, "casting_type_id", "1"}, //
      {479, "spell_source_id", "0"}, //
      {479, "spells_known_table_id", "3"}, //
      {479, "spells_per_day_table_id", "5"}, //
      {479, "attribute_bonus_spell_slots", "false"}, //
      {479, "school_id", "-1"}, //
      {481, "spelllist_id", "14"}, //
      {481, "spell_attribute_id", "4"}, //
      {481, "casting_type_id", "1"}, //
      {481, "spell_source_id", "0"}, //
      {481, "spells_known_table_id", "3"}, //
      {481, "spells_per_day_table_id", "5"}, //
      {481, "attribute_bonus_spell_slots", "false"}, //
      {481, "school_id", "-1"}, //
      {483, "spelllist_id", "15"}, //
      {483, "spell_attribute_id", "4"}, //
      {483, "casting_type_id", "1"}, //
      {483, "spell_source_id", "0"}, //
      {483, "spells_known_table_id", "3"}, //
      {483, "spells_per_day_table_id", "5"}, //
      {483, "attribute_bonus_spell_slots", "false"}, //
      {483, "school_id", "-1"}, //
      {485, "spelllist_id", "16"}, //
      {485, "spell_attribute_id", "4"}, //
      {485, "casting_type_id", "1"}, //
      {485, "spell_source_id", "0"}, //
      {485, "spells_known_table_id", "3"}, //
      {485, "spells_per_day_table_id", "5"}, //
      {485, "attribute_bonus_spell_slots", "false"}, //
      {485, "school_id", "-1"}, //
      {487, "spelllist_id", "17"}, //
      {487, "spell_attribute_id", "4"}, //
      {487, "casting_type_id", "1"}, //
      {487, "spell_source_id", "0"}, //
      {487, "spells_known_table_id", "3"}, //
      {487, "spells_per_day_table_id", "5"}, //
      {487, "attribute_bonus_spell_slots", "false"}, //
      {487, "school_id", "-1"}, //
      {489, "spelllist_id", "18"}, //
      {489, "spell_attribute_id", "4"}, //
      {489, "casting_type_id", "1"}, //
      {489, "spell_source_id", "0"}, //
      {489, "spells_known_table_id", "3"}, //
      {489, "spells_per_day_table_id", "5"}, //
      {489, "attribute_bonus_spell_slots", "false"}, //
      {489, "school_id", "-1"}, //
      {491, "spelllist_id", "19"}, //
      {491, "spell_attribute_id", "4"}, //
      {491, "casting_type_id", "1"}, //
      {491, "spell_source_id", "0"}, //
      {491, "spells_known_table_id", "3"}, //
      {491, "spells_per_day_table_id", "5"}, //
      {491, "attribute_bonus_spell_slots", "false"}, //
      {491, "school_id", "-1"}, //
      {493, "spelllist_id", "20"}, //
      {493, "spell_attribute_id", "4"}, //
      {493, "casting_type_id", "1"}, //
      {493, "spell_source_id", "0"}, //
      {493, "spells_known_table_id", "3"}, //
      {493, "spells_per_day_table_id", "5"}, //
      {493, "attribute_bonus_spell_slots", "false"}, //
      {493, "school_id", "-1"}, //
      {495, "spelllist_id", "21"}, //
      {495, "spell_attribute_id", "4"}, //
      {495, "casting_type_id", "1"}, //
      {495, "spell_source_id", "0"}, //
      {495, "spells_known_table_id", "3"}, //
      {495, "spells_per_day_table_id", "5"}, //
      {495, "attribute_bonus_spell_slots", "false"}, //
      {495, "school_id", "-1"}, //
      {497, "spelllist_id", "22"}, //
      {497, "spell_attribute_id", "4"}, //
      {497, "casting_type_id", "1"}, //
      {497, "spell_source_id", "0"}, //
      {497, "spells_known_table_id", "3"}, //
      {497, "spells_per_day_table_id", "5"}, //
      {497, "attribute_bonus_spell_slots", "false"}, //
      {497, "school_id", "-1"}, //
      {499, "spelllist_id", "23"}, //
      {499, "spell_attribute_id", "4"}, //
      {499, "casting_type_id", "1"}, //
      {499, "spell_source_id", "0"}, //
      {499, "spells_known_table_id", "3"}, //
      {499, "spells_per_day_table_id", "5"}, //
      {499, "attribute_bonus_spell_slots", "false"}, //
      {499, "school_id", "-1"}, //
      {501, "spelllist_id", "24"}, //
      {501, "spell_attribute_id", "4"}, //
      {501, "casting_type_id", "1"}, //
      {501, "spell_source_id", "0"}, //
      {501, "spells_known_table_id", "3"}, //
      {501, "spells_per_day_table_id", "5"}, //
      {501, "attribute_bonus_spell_slots", "false"}, //
      {501, "school_id", "-1"}, //
      {503, "spelllist_id", "25"}, //
      {503, "spell_attribute_id", "4"}, //
      {503, "casting_type_id", "1"}, //
      {503, "spell_source_id", "0"}, //
      {503, "spells_known_table_id", "3"}, //
      {503, "spells_per_day_table_id", "5"}, //
      {503, "attribute_bonus_spell_slots", "false"}, //
      {503, "school_id", "-1"}, //
      {505, "spelllist_id", "26"}, //
      {505, "spell_attribute_id", "4"}, //
      {505, "casting_type_id", "1"}, //
      {505, "spell_source_id", "0"}, //
      {505, "spells_known_table_id", "3"}, //
      {505, "spells_per_day_table_id", "5"}, //
      {505, "attribute_bonus_spell_slots", "false"}, //
      {505, "school_id", "-1"}, //
      {507, "spelllist_id", "27"}, //
      {507, "spell_attribute_id", "4"}, //
      {507, "casting_type_id", "1"}, //
      {507, "spell_source_id", "0"}, //
      {507, "spells_known_table_id", "3"}, //
      {507, "spells_per_day_table_id", "5"}, //
      {507, "attribute_bonus_spell_slots", "false"}, //
      {507, "school_id", "-1"}, //
      {509, "spelllist_id", "28"}, //
      {509, "spell_attribute_id", "4"}, //
      {509, "casting_type_id", "1"}, //
      {509, "spell_source_id", "0"}, //
      {509, "spells_known_table_id", "3"}, //
      {509, "spells_per_day_table_id", "5"}, //
      {509, "attribute_bonus_spell_slots", "false"}, //
      {509, "school_id", "-1"}, //
      {511, "spelllist_id", "29"}, //
      {511, "spell_attribute_id", "4"}, //
      {511, "casting_type_id", "1"}, //
      {511, "spell_source_id", "0"}, //
      {511, "spells_known_table_id", "3"}, //
      {511, "spells_per_day_table_id", "5"}, //
      {511, "attribute_bonus_spell_slots", "false"}, //
      {511, "school_id", "-1"}, //
      {513, "spelllist_id", "30"}, //
      {513, "spell_attribute_id", "4"}, //
      {513, "casting_type_id", "1"}, //
      {513, "spell_source_id", "0"}, //
      {513, "spells_known_table_id", "3"}, //
      {513, "spells_per_day_table_id", "5"}, //
      {513, "attribute_bonus_spell_slots", "false"}, //
      {513, "school_id", "-1"}, //
      {515, "spelllist_id", "31"}, //
      {515, "spell_attribute_id", "4"}, //
      {515, "casting_type_id", "1"}, //
      {515, "spell_source_id", "0"}, //
      {515, "spells_known_table_id", "3"}, //
      {515, "spells_per_day_table_id", "5"}, //
      {515, "attribute_bonus_spell_slots", "false"}, //
      {515, "school_id", "-1"}, //
      {517, "spelllist_id", "32"}, //
      {517, "spell_attribute_id", "4"}, //
      {517, "casting_type_id", "1"}, //
      {517, "spell_source_id", "0"}, //
      {517, "spells_known_table_id", "3"}, //
      {517, "spells_per_day_table_id", "5"}, //
      {517, "attribute_bonus_spell_slots", "false"}, //
      {517, "school_id", "-1"}, //
      {519, "spelllist_id", "33"}, //
      {519, "spell_attribute_id", "4"}, //
      {519, "casting_type_id", "1"}, //
      {519, "spell_source_id", "0"}, //
      {519, "spells_known_table_id", "3"}, //
      {519, "spells_per_day_table_id", "5"}, //
      {519, "attribute_bonus_spell_slots", "false"}, //
      {519, "school_id", "-1"}, //
      {521, "spelllist_id", "34"}, //
      {521, "spell_attribute_id", "4"}, //
      {521, "casting_type_id", "1"}, //
      {521, "spell_source_id", "0"}, //
      {521, "spells_known_table_id", "3"}, //
      {521, "spells_per_day_table_id", "5"}, //
      {521, "attribute_bonus_spell_slots", "false"}, //
      {521, "school_id", "-1"}, //
      {523, "spelllist_id", "35"}, //
      {523, "spell_attribute_id", "4"}, //
      {523, "casting_type_id", "1"}, //
      {523, "spell_source_id", "0"}, //
      {523, "spells_known_table_id", "3"}, //
      {523, "spells_per_day_table_id", "5"}, //
      {523, "attribute_bonus_spell_slots", "false"}, //
      {523, "school_id", "-1"}, //
      {525, "spelllist_id", "36"}, //
      {525, "spell_attribute_id", "4"}, //
      {525, "casting_type_id", "1"}, //
      {525, "spell_source_id", "0"}, //
      {525, "spells_known_table_id", "3"}, //
      {525, "spells_per_day_table_id", "5"}, //
      {525, "attribute_bonus_spell_slots", "false"}, //
      {525, "school_id", "-1"}, //
      {527, "spelllist_id", "37"}, //
      {527, "spell_attribute_id", "4"}, //
      {527, "casting_type_id", "1"}, //
      {527, "spell_source_id", "0"}, //
      {527, "spells_known_table_id", "3"}, //
      {527, "spells_per_day_table_id", "5"}, //
      {527, "attribute_bonus_spell_slots", "false"}, //
      {527, "school_id", "-1"}, //
      {529, "spelllist_id", "38"}, //
      {529, "spell_attribute_id", "4"}, //
      {529, "casting_type_id", "1"}, //
      {529, "spell_source_id", "0"}, //
      {529, "spells_known_table_id", "3"}, //
      {529, "spells_per_day_table_id", "5"}, //
      {529, "attribute_bonus_spell_slots", "false"}, //
      {529, "school_id", "-1"}, //
      {531, "spelllist_id", "39"}, //
      {531, "spell_attribute_id", "4"}, //
      {531, "casting_type_id", "1"}, //
      {531, "spell_source_id", "0"}, //
      {531, "spells_known_table_id", "3"}, //
      {531, "spells_per_day_table_id", "5"}, //
      {531, "attribute_bonus_spell_slots", "false"}, //
      {531, "school_id", "-1"}, //
      {533, "spelllist_id", "40"}, //
      {533, "spell_attribute_id", "4"}, //
      {533, "casting_type_id", "1"}, //
      {533, "spell_source_id", "0"}, //
      {533, "spells_known_table_id", "3"}, //
      {533, "spells_per_day_table_id", "5"}, //
      {533, "attribute_bonus_spell_slots", "false"}, //
      {533, "school_id", "-1"}, //
      {582, "spelllist_id", "41"}, //
      {620, "spelllist_id", "42"}, //
      {650, "spelllist_id", "43"}, //
      {660, "spelllist_id", "44"}, //
      {673, "spelllist_id", "45"}, //
      {686, "spelllist_id", "46"}, //
      {699, "spelllist_id", "47"}, //
      {712, "spelllist_id", "48"}, //
      {725, "spelllist_id", "49"}, //
      {738, "spelllist_id", "50"}, //
      {751, "spelllist_id", "51"}, //
      {764, "spelllist_id", "52"}, //
      {776, "spelllist_id", "53"}, //
      {799, "spelllist_id", "54"}, //
      {800, "spelllist_id", "55"}, //
      {957, "spelllist_id", "56"}, //
      {984, "spelllist_id", "57"}, //
      {996, "spelllist_id", "58"}, //
      {997, "spelllist_id", "59"}, //
      {998, "spelllist_id", "60"}, //
      {999, "spelllist_id", "61"}, //
      {1000, "spelllist_id", "62"}, //
      {1001, "spelllist_id", "63"}, //
      {1002, "spelllist_id", "64"}, //
      {1003, "spelllist_id", "65"}, //
      {1004, "spelllist_id", "66"}, //
      {1005, "spelllist_id", "67"}, //
      {1006, "spelllist_id", "68"}, //
  };

}
