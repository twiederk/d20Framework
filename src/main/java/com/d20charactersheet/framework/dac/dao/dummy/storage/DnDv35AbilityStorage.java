package com.d20charactersheet.framework.dac.dao.dummy.storage;

/**
 * Stores abilities.
 */
public class DnDv35AbilityStorage {

  /**
   * Abilities data
   */
  public static final Object[][] ABILITY = { //
      // ability_id, ability_type_id, name, classname, description
      {0, "Fast Movement - Barbarian",
          "A barbarian's land speed is faster than the norm for his race by +10 feet. This benefit applies only when he is wearing no armor, light armor, or medium armor and not carrying a heavy load. Apply this bonus before modifying the barbarian's speed because of any load carried or armor worn.",
          1, "Ability"
      }, //
      {1, "Illiteracy",
          "Barbarians are the only characters who do not automatically know how to read and write. A barbarian may spend 2 skill points to gain the ability to read and write all languages he is able to speak.<br/>A barbarian who gains a level in any other class automatically gains literacy. Any other character who gains a barbarian level does not lose the literacy he or she already had.",
          0, "Ability"
      }, //
      {2, "Rage",
          "A barbarian can fly into a rage a certain number of times per day. In a rage, a barbarian temporarily gains a +4 bonus to Strength, a +4 bonus to Constitution, and a +2 morale bonus on Will saves, but he takes a -2 penalty to Armor Class. The increase in Constitution increases the barbarian's hit points by 2 points per level, but these hit points go away at the end of the rage when his Constitution score drops back to normal. (These extra hit points are not lost first the way temporary hit points are.) While raging, a barbarian cannot use any Charisma-, Dexterity-, or Intelligence-based skills (except for Balance, Escape Artist, Intimidate, and Ride), the Concentration skill, or any abilities that require patience or concentration, nor can he cast spells or activate magic items that require a command word, a spell trigger (such as a wand), or spell completion (such as a scroll) to function. He can use any feat he has except Combat Expertise, item creation feats, and metamagic feats. A fit of rage lasts for a number of rounds equal to 3 + the character's (newly improved) Constitution modifier. A barbarian may prematurely end his rage. At the end of the rage, the barbarian loses the rage modifiers and restrictions and becomes fatigued (-2 penalty to Strength, -2 penalty to Dexterity, can't charge or run) for the duration of the current encounter (unless he is a 17th-level barbarian, at which point this limitation no longer applies, see below).\nA barbarian can fly into a rage only once per encounter. At 1st level he can use his rage ability once per day. At 4th level and every four levels thereafter, he can use it one additional time per day (to a maximum of six times per day at 20th level). Entering a rage takes no time itself, but a barbarian can do it only during his action, not in response to someone else's action.",
          1, "Ability"
      }, //
      {3, "Uncanny Dodge",
          "Retains his Dexterity bonus to AC (if any) even if he is caught flat-footed or struck by an invisible attacker. However, he still loses his Dexterity bonus to AC if immobilized. If he already has uncanny dodge from a different class, he automatically gains improved uncanny dodge (see below) instead.",
          1, "Ability"
      }, //
      {4, "Trap Sense",
          "Starting at 3rd level, a character gains a +1 bonus on Reflex saves made to avoid traps and a +1 dodge bonus to AC against attacks made by traps. These bonuses rise by +1 every three levels thereafter (6th, 9th, 12th, 15th, and 18th level). Trap sense bonuses gained from multiple classes stack.",
          1, "Ability"
      }, //
      {5, "Improved Uncanny Dodge",
          "Can no longer be flanked. This defense denies a rogue the ability to sneak attack him by flanking, unless the attacker has at least four more rogue levels than the target has class levels. If a character already has uncanny dodge (see above) from a second class, the character automatically gains improved uncanny dodge instead, and the levels from the classes that grant uncanny dodge stack to determine the minimum level a rogue must be to flank the character.",
          1, "Ability"
      }, //
      {6, "Damage Reduction - Barbarian",
          "At 7th level, a barbarian gains Damage Reduction. Subtract 1 from the damage the barbarian takes each time he is dealt damage from a weapon or a natural attack. At 10th level, and every three barbarian levels thereafter (13th, 16th, and 19th level), this damage reduction rises by 1 point. Damage reduction can reduce damage to 0 but not below 0.",
          1, "Ability"
      }, //
      {7, "Greater Rage",
          "At 11th level, a barbarian's bonuses to Strength and Constitution during his rage each increase to +6, and his morale bonus on Will saves increases to +3. The penalty to AC remains at -2.",
          1, "Ability"
      }, //
      {8, "Indomitable Will",
          "While in a rage, a barbarian of 14th level or higher gains a +4 bonus on Will saves to resist enchantment spells. This bonus stacks with all other modifiers, including the morale bonus on Will saves he also receives during his rage.",
          1, "Ability"
      }, //
      {9, "Tireless Rage", "At 17th level and higher, a barbarian no longer becomes fatigued at the end of his rage.", 1, "Ability"
      }, //
      {10, "Mighty Rage",
          "At 20th level, a barbarian's bonuses to Strength and Constitution during his rage each increase to +8, and his morale bonus on Will saves increases to +4. The penalty to AC remains at -2.",
          1, "Ability"
      }, //
      {11, "Spells - Bard",
          "A bard casts arcane spells, which are drawn from the bard spell list. He can cast any spell he knows without preparing it ahead of time. Every bard spell has a verbal component (singing, reciting, or music). To learn or cast a spell, a bard must have a Charisma score equal to at least 10 + the spell. The Difficulty Class for a saving throw against a bard's spell is 10 + the spell level + the bard's Charisma modifier.<br/>Like other spellcasters, a bard can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: The Bard. In addition, he receives bonus spells per day if he has a high Charisma score. When Table: Bard Spells Known indicates that the bard gets 0 spells per day of a given spell level, he gains only the bonus spells he would be entitled to based on his Charisma score for that spell level.<br/>The bard's selection of spells is extremely limited. A bard begins play knowing four 0-level spells of your choice. At most new bard levels, he gains one or more new spells, as indicated on Table: Bard Spells Known. (Unlike spells per day, the number of spells a bard knows is not affected by his Charisma score. The numbers on Table: Bard Spells Known are fixed.)<br/>Upon reaching 5th level, and at every third bard level after that (8th, 11th, and so on), a bard can choose to learn a new spell in place of one he already knows. In effect, the bard 'loses' the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged, and it must be at least two levels lower than the highest-level bard spell the bard can cast. A bard may swap only a single spell at any given level, and must choose whether or not to swap the spell at the same time that he gains new spells known for the level.\nAs noted above, a bard need not prepare his spells in advance. He can cast any spell he knows at any time, assuming he has not yet used up his allotment of spells per day for the spell's level. ",
          0, "SpelllistAbility"
      }, //
      {12, "Bardic Knowledge",
          "A bard may make a special bardic knowledge check with a bonus equal to his bard level + his Intelligence modifier to see whether he knows some relevant information about local notable people, legendary items, or noteworthy places. (If the bard has 5 or more ranks in Knowledge (history), he gains a +2 bonus on this check.)<br/>A successful bardic knowledge check will not reveal the powers of a magic item but may give a hint as to its general function. A bard may not take 10 or take 20 on this check. This sort of knowledge is essentially random.<br/><table><tbody><tr><th>DC</th><th>Type of Knowledge</th></tr><tr><td>10</td><td>Common, known by at least a substantial minority drinking. Common legends of the local population.</td></tr><tr><td>20</td><td>Uncommon but available, known by only a few people legends.</td></tr><tr><td>25</td><td>Obscure, known by few, hard to come by.</td></tr><tr><td>30</td><td>Extremely obscure, known by very few, possibly forgotten by most who once knew it, possibly known only by those who don't understand the significance of the knowledge.</td></tr></tbody></table>",
          0, "Ability"
      }, //
      {13, "Bardic Music - Countersong",
          "A bard with 3 or more ranks in a Perform skill can use his music or poetics to counter magical effects that depend on sound (but not spells that simply have verbal components). Each round of the countersong, he makes a Perform check. Any creature within 30 feet of the bard (including the bard himself ) that is affected by a sonic or language-dependent magical attack may use the bard's Perform check result in place of its saving throw if, after the saving throw is rolled, the Perform check result proves to be higher. If a creature within range of the countersong is already under the effect of a noninstantaneous sonic or language-dependent magical attack, it gains another saving throw against the effect each round it hears the countersong, but it must use the bard's Perform check result for the save. Countersong has no effect against effects that don't allow saves. The bard may keep up the countersong for 10 rounds.",
          3, "Ability"
      }, //
      {14, "Bardic Music - Fascinate",
          "A bard with 3 or more ranks in a Perform skill can use his music or poetics to cause one or more creatures to become fascinated with him. Each creature to be fascinated must be within 90 feet, able to see and hear the bard, and able to pay attention to him. The bard must also be able to see the creature. The distraction of a nearby combat or other dangers prevents the ability from working. For every three levels a bard attains beyond 1st, he can target one additional creature with a single use of this ability.<br/>To use the ability, a bard makes a Perform check. His check result is the DC for each affected creature's Will save against the effect. If a creature's saving throw succeeds, the bard cannot attempt to fascinate that creature again for 24 hours. If its saving throw fails, the creature sits quietly and listens to the song, taking no other actions, for as long as the bard continues to play and concentrate (up to a maximum of 1 round per bard level). While fascinated, a target takes a -4 penalty on skill checks made as reactions, such as Listen and Spot checks. Any potential threat requires the bard to make another Perform check and allows the creature a new saving throw against a DC equal to the new Perform check result.\nAny obvious threat, such as someone drawing a weapon, casting a spell, or aiming a ranged weapon at the target, automatically breaks the effect. Fascinate is an enchantment (compulsion), mind-affecting ability.",
          2, "Ability"
      }, //
      {15, "Bardic Music - Inspire Courage.",
          "A bard with 3 or more ranks in a Perform skill can use song or poetics to inspire courage in his allies (including himself ), bolstering them against fear and improving their combat abilities. To be affected, an ally must be able to hear the bard sing. The effect lasts for as long as the ally hears the bard sing and for 5 rounds thereafter. An affected ally receives a +1 morale bonus on saving throws against charm and fear effects and a +1 morale bonus on attack and weapon damage rolls. At 8th level, and every six bard levels thereafter, this bonus increases by 1 (+2 at 8th, +3 at 14th, and +4 at 20th). Inspire courage is a mind-affecting ability.",
          3, "Ability"
      }, //
      {16, "Bardic Music - Inspire Competence",
          "A bard of 3rd level or higher with 6 or more ranks in a Perform skill can use his music or poetics to help an ally succeed at a task. The ally must be within 30 feet and able to see and hear the bard. The bard must also be able to see the ally.<br/>The ally gets a +2 competence bonus on skill checks with a particular skill as long as he or she continues to hear the bard's music. Certain uses of this ability are infeasible. The effect lasts as long as the bard concentrates, up to a maximum of 2 minutes. A bard can't inspire competence in himself. Inspire competence is a mind-affecting ability.",
          3, "Ability"
      }, //
      {17, "Bardic Music - Suggestion",
          "A bard of 6th level or higher with 9 or more ranks in a Perform skill can make a suggestion (as the spell) to a creature that he has already fascinated (see above). Using this ability does not break the bard's concentration on the fascinate effect, nor does it allow a second saving throw against the fascinate effect.<br/>Making a suggestion doesn't count against a bard's daily limit on bardic music performances. A Will saving throw (DC 10 + 1/2 bard's level + bard's Cha modifier) negates the effect. This ability affects only a single creature (but see mass suggestion, below). Suggestion is an enchantment (compulsion), mind-affecting, language dependent ability.",
          3, "Ability"
      }, //
      {18, "Bardic Music - Inspire Greatness",
          "A bard of 9th level or higher with 12 or more ranks in a Perform skill can use music or poetics to inspire greatness in himself or a single willing ally within 30 feet, granting him or her extra fighting capability. For every three levels a bard attains beyond 9th, he can target one additional ally with a single use of this ability (two at 12th level, three at 15th, four at 18th). To inspire greatness, a bard must sing and an ally must hear him sing. The effect lasts for as long as the ally hears the bard sing and for 5 rounds thereafter. A creature inspired with greatness gains 2 bonus Hit Dice (d10s), the commensurate number of temporary hit points (apply the target's Constitution modifier, if any, to these bonus Hit Dice), a +2 competence bonus on attack rolls, and a +1 competence bonus on Fortitude saves. The bonus Hit Dice count as regular Hit Dice for determining the effect of spells that are Hit Dice dependant. Inspire greatness is a mind-affecting ability.",
          3, "Ability"
      }, //
      {19, "Bardic Music - Song of Freedom",
          "A bard of 12th level or higher with 15 or more ranks in a Perform skill can use music or poetics to create an effect equivalent to the break enchantment spell (caster level equals the character's bard level). Using this ability requires 1 minute of uninterrupted concentration and music, and it functions on a single target within 30 feet. A bard can't use song of freedom on himself.",
          2, "Ability"
      }, //
      {20, "Bardic Music - Inspire Heroics",
          "A bard of 15th level or higher with 18 or more ranks in a Perform skill can use music or poetics to inspire tremendous heroism in himself or a single willing ally within 30 feet. For every three bard levels the character attains beyond 15th, he can inspire heroics in one additional creature. To inspire heroics, a bard must sing and an ally must hear the bard sing for a full round. A creature so inspired gains a +4 morale bonus on saving throws and a +4 dodge bonus to AC. The effect lasts for as long as the ally hears the bard sing and for up to 5 rounds thereafter. Inspire heroics is a mind-affecting ability.",
          3, "Ability"
      }, //
      {21, "Bardic Music - Mass Suggestion",
          "This ability functions like suggestion, above, except that a bard of 18th level or higher with 21 or more ranks in a Perform skill can make the suggestion simultaneously to any number of creatures that he has already fascinated (see above). Mass suggestion is an enchantment (compulsion), mind-affecting, language-dependent ability.",
          2, "Ability"
      }, //
      {22, "Aura of Alignment",
          "A cleric of a chaotic, evil, good, or lawful deity has a particularly powerful aura corresponding to the deity's alignment (see the detect evil spell for details). Clerics who don't worship a specific deity but choose the Chaotic, Evil, Good, or Lawful domain have a similarly powerful aura of the corresponding alignment.",
          1, "Ability"
      }, //
      {23, "Spells - Cleric",
          "A cleric casts divine spells, which are drawn from the cleric spell list. However, his alignment may restrict him from casting certain spells opposed to his moral or ethical beliefs: see Chaotic, Evil, Good, and Lawful Spells, below. A cleric must choose and prepare his spells in advance (see below).<br/>To prepare or cast a spell, a cleric must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a cleric's spell is 10 + the spell level + the cleric's Wisdom modifier.<br/>Like other spellcasters, a cleric can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: The Cleric. In addition, he receives bonus spells per day if he has a high Wisdom score. A cleric also gets one domain spell of each spell level he can cast, starting at 1st level. When a cleric prepares a spell in a domain spell slot, it must come from one of his two domains (see Deities, Domains, and Domain Spells, below).<br/>Clerics meditate or pray for their spells. Each cleric must choose a time at which he must spend 1 hour each day in quiet contemplation or supplication to regain his daily allotment of spells. Time spent resting has no effect on whether a cleric can prepare spells. A cleric may prepare and cast any spell on the cleric spell list, provided that he can cast spells of that level, but he must choose which spells to prepare during his daily meditation.",
          0, "SpelllistAbility"
      }, //
      {24, "Cleric Domains",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "Ability"
      }, //
      {25, "Spontaneous Casting - Cure",
          "A good cleric (or a neutral cleric of a good deity) can channel stored spell energy into healing spells that the cleric did not prepare ahead of time. The cleric can 'lose' any prepared spell that is not a domain spell in order to cast any cure spell of the same spell level or lower (a cure spell is any spell with 'cure' in its name). <br/>An evil cleric (or a neutral cleric of an evil deity), can't convert prepared spells to cure spells but can convert them to inflict spells (an inflict spell is one with 'inflict' in its name).<br/>A cleric who is neither good nor evil and whose deity is neither good nor evil can convert spells to either cure spells or inflict spells (player's choice). Once the player makes this choice, it cannot be reversed. This choice also determines whether the cleric turns or commands undead (see below).",
          0, "Ability"
      }, //
      {26, "Alignment Spells",
          "Can't cast spells of an alignment opposed to his own or his deity's (if he has one). Spells associated with particular alignments are indicated by the chaos, evil, good, and law descriptors in their spell descriptions.",
          0, "Ability"
      }, //
      {27, "Turn Undead - Cleric",
          "Any cleric, regardless of alignment, has the power to affect undead creatures by channeling the power of his faith through his holy (or unholy) symbol (see Turn or Rebuke Undead).<br/>A good cleric (or a neutral cleric who worships a good deity) can turn or destroy undead creatures. An evil cleric (or a neutral cleric who worships an evil deity) instead rebukes or commands such creatures. A neutral cleric of a neutral deity must choose whether his turning ability functions as that of a good cleric or an evil cleric. Once this choice is made, it cannot be reversed. This decision also determines whether the cleric can cast spontaneous cure or inflict spells (see above).<br/>A cleric may attempt to turn undead a number of times per day equal to 3 + his Charisma modifier. A cleric with 5 or more ranks in Knowledge (religion) gets a +2 bonus on turning checks against undead.",
          3, "Ability"
      }, //
      {28, "Bonus Languages - Cleric",
          "A cleric's bonus language options include Celestial, Abyssal, and Infernal (the languages of good, chaotic evil, and lawful evil outsiders, respectively). These choices are in addition to the bonus languages available to the character because of his race.",
          0, "Ability"
      }, //
      {29, "Spells - Druid",
          "A druid casts divine spells, which are drawn from the druid spell list. Her alignment may restrict her from casting certain spells opposed to her moral or ethical beliefs: see Chaotic, Evil, Good, and Lawful Spells, below. A druid must choose and prepare her spells in advance (see below).<br/>To prepare or cast a spell, the druid must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a druid's spell is 10 + the spell level + the druid's Wisdom modifier.<br/>Like other spellcasters, a druid can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: The Druid. In addition, she receives bonus spells per day if she has a high Wisdom score. She does not have access to any domain spells or granted powers, as a cleric does.<br/>A druid prepares and casts spells the way a cleric does, though she cannot lose a prepared spell to cast a cure spell in its place (but see Spontaneous Casting, below). A druid may prepare and cast any spell on the druid spell list, provided that she can cast spells of that level, but she must choose which spells to prepare during her daily meditation.",
          0, "SpelllistAbility"
      }, //
      {30, "Spontaneous Casting - Summon",
          "A druid can channel stored spell energy into summoning spells that she hasn't prepared ahead of time. She can 'lose' a prepared spell in order to cast any summon nature's ally spell of the same level or lower.",
          0, "Ability"
      }, //
      {31, "Bonus Languages - Druid",
          "A druid's bonus language options include Sylvan, the language of woodland creatures. This choice is in addition to the bonus languages available to the character because of her race.<br/>A druid also knows Druidic, a secret language known only to druids, which she learns upon becoming a 1st-level druid. Druidic is a free language for a druid. That is, she knows it in addition to her regular allotment of languages and it doesn't take up a language slot. Druids are forbidden to teach this language to nondruids.<br/>Druidic has its own alphabet.",
          0, "Ability"
      }, //
      {32, "Animal Companion - Druid",
          "A druid may begin play with an animal companion selected from the following list: badger, camel, dire rat, dog, riding dog, eagle, hawk, horse (light or heavy), owl, pony, snake (Small or Medium viper), or wolf. If the campaign takes place wholly or partly in an aquatic environment, the following creatures are also available: crocodile, porpoise, Medium shark, and squid. This animal is a loyal companion that accompanies the druid on her adventures as appropriate for its kind.<br/>A 1st-level druid's companion is completely typical for its kind except as noted below. As a druid advances in level, the animal's power increases as shown on the table. If a druid releases her companion from service, she may gain a new one by performing a ceremony requiring 24 uninterrupted hours of prayer. This ceremony can also replace an animal companion that has perished.<br/>A druid of 4th level or higher may select from alternative lists of animals (see below). Should she select an animal companion from one of these alternative lists, the creature gains abilities as if the character's druid level were lower than it actually is. Subtract the value indicated in the appropriate list header from the character's druid level and compare the result with the druid level entry on the table to determine the animal companion's powers. (If this adjustment would reduce the druid's effective level to 0 or lower, she can't have that animal as a companion.) ",
          1, "Ability"
      }, //
      {33, "Nature Sense", "A druid gains a +2 bonus on Knowledge (nature) and Survival checks.", 1, "Ability"}, //
      {34, "Wild Empathy",
          "A character can improve the attitude of an animal. This ability functions just like a Diplomacy check made to improve the attitude of a person. The character rolls 1d20 and adds her class level and her Charisma modifier to determine the wild empathy check result.<br/>The typical domestic animal has a starting attitude of indifferent, while wild animals are usually unfriendly.<br/>To use wild empathy, the character and the animal must be able to study each other, which means that they must be within 30 feet of one another under normal conditions. Generally, influencing an animal in this way takes 1 minute but, as with influencing people, it might take more or less time.<br/>A character can also use this ability to influence a magical beast with an Intelligence score of 1 or 2, but she takes a -4 penalty on the check.",
          1, "Ability"
      }, //
      {35, "Woodland Stride",
          "A character may move through any sort of undergrowth (such as natural thorns, briars, overgrown areas, and similar terrain) at his normal speed and without taking damage or suffering any other impairment. However, thorns, briars, and overgrown areas that have been magically manipulated to impede motion still affect him.",
          1, "Ability"
      }, //
      {36, "Trackless Step",
          "Starting at 3rd level, a druid leaves no trail in natural surroundings and cannot be tracked. She may choose to leave a trail if so desired.",
          1, "Ability"
      }, //
      {37, "Resist Nature's Lure",
          "Starting at 4th level, a druid gains a +4 bonus on saving throws against the spell-like abilities of fey.", 1, "Ability"
      }, //
      {38, "Wild Shape",
          "At 5th level, a druid gains the ability to turn herself into any Small or Medium animal and back again once per day. Her options for new forms include all creatures with the animal type. This ability functions like the polymorph spell, except as noted here. The effect lasts for 1 hour per druid level, or until she changes back. Changing form (to animal or back) is a standard action and doesn't provoke an attack of opportunity.<br/>The form chosen must be that of an animal the druid is familiar with. <br/>A druid loses her ability to speak while in animal form because she is limited to the sounds that a normal, untrained animal can make, but she can communicate normally with other animals of the same general grouping as her new form. (The normal sound a wild parrot makes is a squawk, so changing to this form does not permit speech.)<br/>A druid can use this ability more times per day at 6th, 7th, 10th, 14th, and 18th level, as noted on Table: The Druid. In addition, she gains the ability to take the shape of a Large animal at 8th level, a Tiny animal at 11th level, and a Huge animal at 15th level.<br/>The new form's Hit Dice can't exceed the character's druid level.<br/>At 12th level, a druid becomes able to use wild shape to change into a plant creature with the same size restrictions as for animal forms. (A druid can't use this ability to take the form of a plant that isn't a creature.)\nAt 16th level, a druid becomes able to use wild shape to change into a Small, Medium, or Large elemental (air, earth, fire, or water) once per day. These elemental forms are in addition to her normal wild shape usage. In addition to the normal effects of wild shape, the druid gains all the elemental's extraordinary, supernatural, and spell-like abilities. She also gains the elemental's feats for as long as she maintains the wild shape, but she retains her own creature type.<br/>At 18th level, a druid becomes able to assume elemental form twice per day, and at 20th level she can do so three times per day. At 20th level, a druid may use this wild shape ability to change into a Huge elemental.",
          3, "Ability"
      }, //
      {39, "Venom Immunity", "At 9th level, a druid gains immunity to all poisons. ", 1, "Ability"}, //
      {40, "A Thousand Faces",
          "At 13th level, a druid gains the ability to change her appearance at will, as if using the alter self spell, but only while in her normal form.",
          3, "Ability"
      }, //
      {41, "Timeless Body",
          "After attaining 15th level, a druid no longer takes ability score penalties for aging and cannot be magically aged. Any penalties she may have already incurred, however, remain in place.<br/>Bonuses still accrue, and the druid still dies of old age when her time is up.",
          1, "Ability"
      }, //
      {42, "Bonus Feats - Fighter",
          "At 1st level, a fighter gets a bonus combat-oriented feat in addition to the feat that any 1st-level character gets and the bonus feat granted to a human character. The fighter gains an additional bonus feat at 2nd level and every two fighter levels thereafter (4th, 6th, 8th, 10th, 12th, 14th, 16th, 18th, and 20th). These bonus feats must be drawn from the feats noted as fighter bonus feats. A fighter must still meet all prerequisites for a bonus feat, including ability score and base attack bonus minimums.<br/>These bonus feats are in addition to the feat that a character of any class gets from advancing levels. A fighter is not limited to the list of fighter bonus feats when choosing these feats.",
          0, "Ability"
      }, //
      {43, "AC Bonus - Monk",
          "When unarmored and unencumbered, the monk adds her Wisdom bonus (if any) to her AC. In addition, a monk gains a +1 bonus to AC at 5th level. This bonus increases by 1 for every five monk levels thereafter (+2 at 10th, +3 at 15th, and +4 at 20th level).<br/>These bonuses to AC apply even against touch attacks or when the monk is flat-footed. She loses these bonuses when she is immobilized or helpless, when she wears any armor, when she carries a shield, or when she carries a medium or heavy load.",
          1, "Ability"
      }, //
      {44, "Flurry of Blows",
          "When unarmored, a monk may strike with a flurry of blows at the expense of accuracy. When doing so, she may make one extra attack in a round at her highest base attack bonus, but this attack takes a -2 penalty, as does each other attack made that round. The resulting modified base attack bonuses are shown in the Flurry of Blows Attack Bonus column on Table: The Monk. This penalty applies for 1 round, so it also affects attacks of opportunity the monk might make before her next action. When a monk reaches 5th level, the penalty lessens to -1, and at 9th level it disappears. A monk must use a full attack action to strike with a flurry of blows.<br/>When using flurry of blows, a monk may attack only with unarmed strikes or with special monk weapons (kama, nunchaku, quarterstaff, sai, shuriken, and siangham). She may attack with unarmed strikes and special monk weapons interchangeably as desired. When using weapons as part of a flurry of blows, a monk applies her Strength bonus (not Str bonus x ?1-1/2 or x?1/2) to her damage rolls for all successful attacks, whether she wields a weapon in one or both hands. The monk can't use any weapon other than a special monk weapon as part of a flurry of blows.\nIn the case of the quarterstaff, each end counts as a separate weapon for the purpose of using the flurry of blows ability. Even though the quarterstaff requires two hands to use, a monk may still intersperse unarmed strikes with quarterstaff strikes, assuming that she has enough attacks in her flurry of blows routine to do so.\nWhen a monk reaches 11th level, her flurry of blows ability improves. In addition to the standard single extra attack she gets from flurry of blows, she gets a second extra attack at her full base attack bonus.",
          1, "Ability"
      }, //
      {45, "Unarmed Strike",
          "At 1st level, a monk gains Improved Unarmed Strike as a bonus feat. A monk's attacks may be with either fist interchangeably or even from elbows, knees, and feet. This means that a monk may even make unarmed strikes with her hands full. There is no such thing as an off-hand attack for a monk striking unarmed. A monk may thus apply her full Strength bonus on damage rolls for all her unarmed strikes.<br/>Usually a monk's unarmed strikes deal lethal damage, but she can choose to deal nonlethal damage instead with no penalty on her attack roll. She has the same choice to deal lethal or nonlethal damage while grappling.<br/>A monk's unarmed strike is treated both as a manufactured weapon and a natural weapon for the purpose of spells and effects that enhance or improve either manufactured weapons or natural weapons.<br/>A monk also deals more damage with her unarmed strikes than a normal person would, as shown on Table: The Monk. The unarmed damage on Table: The Monk is for Medium monks. A Small monk deals less damage than the amount given there with her unarmed attacks, while a Large monk deals more damage, see Table: Small or Large Monk Unarmed Damage.<br/><table><tbody><tr><th>Level</th><th>Damage (Small Monk)</th><th>Damage (Large Monk)</th></tr><tr><td>1st-3rd</td><td>1d4</td><td>1d8</td></tr><tr><td>4th-7th</td><td>1d6</td><td>2d6</td></tr><tr><td>8th-11th</td><td>1d8</td><td>2d8</td></tr><tr><td>12th-15th</td><td>1d10</td><td>3d6</td></tr><tr><td>16th-19th</td><td>2d6</td><td>3d8</td></tr><tr><td>20th</td><td>2d8</td><td>4d8</td></tr></tbody></table>",
          0, "Ability"
      }, //
      {46, "Bonus Feats - Monk",
          "At 1st level, a monk may select either Improved Grapple or Stunning Fist as a bonus feat. At 2nd level, she may select either Combat Reflexes or Deflect Arrows as a bonus feat. At 6th level, she may select either Improved Disarm or Improved Trip as a bonus feat. A monk need not have any of the prerequisites normally required for these feats to select them.",
          0, "Ability"
      }, //
      {47, "Evasion",
          "Can avoid even magical and unusual attacks with great agility. If she makes a successful Reflex saving throw against an attack that normally deals half damage on a successful save, she instead takes no damage. Evasion can be used only if she is wearing light armor or no armor. A helpless character does not gain the benefit of evasion.",
          1, "Ability"
      }, //
      {48, "Fast Movement - Monk",
          "At 3rd level, a monk gains an enhancement bonus to her speed, as shown on Table: The Monk. A monk in armor or carrying a medium or heavy load loses this extra speed.",
          1, "Ability"
      }, //
      {49, "Still Mind",
          "A monk of 3rd level or higher gains a +2 bonus on saving throws against spells and effects from the school of enchantment.",
          1, "Ability"
      }, //
      {50, "Ki Strike",
          "At 4th level, a monk's unarmed attacks are empowered with ki. Her unarmed attacks are treated as magic weapons for the purpose of dealing damage to creatures with damage reduction. Ki strike improves with the character's monk level. At 10th level, her unarmed attacks are also treated as lawful weapons for the purpose of dealing damage to creatures with damage reduction. At 16th level, her unarmed attacks are treated as adamantine weapons for the purpose of dealing damage to creatures with damage reduction and bypassing hardness.",
          3, "Ability"
      }, //
      {51, "Slow Fall",
          "At 4th level or higher, a monk within arm's reach of a wall can use it to slow her descent. When first using this ability, she takes damage as if the fall were 20 feet shorter than it actually is. The monk's ability to slow her fall (that is, to reduce the effective distance of the fall when next to a wall) improves with her monk level until at 20th level she can use a nearby wall to slow her descent and fall any distance without harm.",
          1, "Ability"
      }, //
      {52, "Purity of Body", "At 5th level, a monk gains immunity to all diseases except for supernatural and magical diseases.", 1,
          "Ability"
      }, //
      {53, "Wholeness of Body",
          "At 7th level or higher, a monk can heal her own wounds. She can heal a number of hit points of damage equal to twice her current monk level each day, and she can spread this healing out among several uses.",
          3, "Ability"
      }, //
      {54, "Improved Evasion",
          "A character's evasion ability improves. She still takes no damage on a successful Reflex saving throw against attacks, but henceforth she takes only half damage on a failed save. A helpless character does not gain the benefit of improved evasion.",
          1, "Ability"
      }, //
      {55, "Diamond Body", "At 11th level, a monk gains immunity to poisons of all kinds.", 3, "Ability"}, //
      {56, "Abundant Step",
          "At 12th level or higher, a monk can slip magically between spaces, as if using the spell dimension door, once per day. Her caster level for this effect is one-half her monk level (rounded down).",
          3, "Ability"
      }, //
      {57, "Diamond Soul",
          "At 13th level, a monk gains spell resistance equal to her current monk level + 10. In order to affect the monk with a spell, a spellcaster must get a result on a caster level check (1d20 + caster level) that equals or exceeds the monk's spell resistance.",
          1, "Ability"
      }, //
      {58, "Quivering Palm",
          "Starting at 15th level, a monk can set up vibrations within the body of another creature that can thereafter be fatal if the monk so desires. She can use this quivering palm attack once a week, and she must announce her intent before making her attack roll. Constructs, oozes, plants, undead, incorporeal creatures, and creatures immune to critical hits cannot be affected. Otherwise, if the monk strikes successfully and the target takes damage from the blow, the quivering palm attack succeeds. Thereafter the monk can try to slay the victim at any later time, as long as the attempt is made within a number of days equal to her monk level. To make such an attempt, the monk merely wills the target to die (a free action), and unless the target makes a Fortitude saving throw (DC 10 + 1/2 the monk's level + the monk's Wis modifier), it dies. If the saving throw is successful, the target is no longer in danger from that particular quivering palm attack, but it may still be affected by another one at a later time.",
          3, "Ability"
      }, //
      {59, "Tongue of the Sun and Moon", "A monk of 17th level or higher can speak with any living creature.", 1, "Ability"}, //
      {60, "Empty Body",
          "At 19th level, a monk gains the ability to assume an ethereal state for 1 round per monk level per day, as though using the spell etherealness. She may go ethereal on a number of different occasions during any single day, as long as the total number of rounds spent in an ethereal state does not exceed her monk level.",
          3, "Ability"
      }, //
      {61, "Perfect Self",
          "At 20th level, a monk becomes a magical creature. She is forevermore treated as an outsider rather than as a humanoid (or whatever the monk's creature type was) for the purpose of spells and magical effects. Additionally, the monk gains damage reduction 10/magic, which allows her to ignore the first 10 points of damage from any attack made by a nonmagical weapon or by any natural attack made by a creature that doesn't have similar damage reduction. Unlike other outsiders, the monk can still be brought back from the dead as if she were a member of her previous creature type.",
          0, "Ability"
      }, //
      {62, "Bardic Music",
          "Once per day per bard level, a bard can use his song or poetics to produce magical effects on those around him (usually including himself, if desired). While these abilities fall under the category of bardic music and the descriptions discuss singing or playing instruments, they can all be activated by reciting poetry, chanting, singing lyrical songs, singing melodies, whistling, playing an instrument, or playing an instrument in combination with some spoken performance. Each ability requires both a minimum bard level and a minimum number of ranks in the Perform skill to qualify. If a bard does not have the required number of ranks in at least one Perform skill, he does not gain the bardic music ability until he acquires the needed ranks.<br/>Starting a bardic music effect is a standard action. Some bardic music abilities require concentration, which means the bard must take a standard action each round to maintain the ability. Even while using bardic music that doesn't require concentration, a bard cannot cast spells, activate magic items by spell completion (such as scrolls), or activate magic items by magic word (such as wands). Just as for casting a spell with a verbal component, a deaf bard has a 20% chance to fail when attempting to use bardic music. If he fails, the attempt still counts against his daily limit.<br/>Countersong (Su): A bard with 3 or more ranks in a Perform skill can use his music or poetics to counter magical effects that depend on sound (but not spells that simply have verbal components). Each round of the countersong, he makes a Perform check. Any creature within 30 feet of the bard (including the bard himself ) that is affected by a sonic or language-dependent magical attack may use the bard's Perform check result in place of its saving throw if, after the saving throw is rolled, the Perform check result proves to be higher. If a creature within range of the countersong is already under the effect of a noninstantaneous sonic or language-dependent magical attack, it gains another saving throw against the effect each round it hears the countersong, but it must use the bard's Perform check result for the save. Countersong has no effect against effects that don't allow saves. The bard may keep up the countersong for 10 rounds.",
          0, "Ability"
      }, //
      {64, "Aura of Good", "The power of a paladin's aura of good (see the detect good spell) is equal to her paladin level.", 1,
          "Ability"
      }, //
      {65, "Detect Evil", "At will, a paladin can use detect evil, as the spell.", 2, "Ability"}, //
      {66, "Smite Evil",
          "Once per day, a paladin may attempt to smite evil with one normal melee attack. She adds her Charisma bonus (if any) to her attack roll and deals 1 extra point of damage per paladin level. If the paladin accidentally smites a creature that is not evil, the smite has no effect, but the ability is still used up for that day.<br/>At 5th level, and at every five levels thereafter, the paladin may smite evil one additional time per day, as indicated on Table: The Paladin, to a maximum of five times per day at 20th level.",
          3, "Ability"
      }, //
      {67, "Divine Grace", "At 2nd level, a paladin gains a bonus equal to her Charisma bonus (if any) on all saving throws.", 3,
          "Ability"
      }, //
      {68, "Lay on Hands",
          "Beginning at 2nd level, a paladin with a Charisma score of 12 or higher can heal wounds (her own or those of others) by touch. Each day she can heal a total number of hit points of damage equal to her paladin level x her Charisma bonus. A paladin may choose to divide her healing among multiple recipients, and she doesn't have to use it all at once. Using lay on hands is a standard action.<br/>Alternatively, a paladin can use any or all of this healing power to deal damage to undead creatures. Using lay on hands in this way requires a successful melee touch attack and doesn't provoke an attack of opportunity. The paladin decides how many of her daily allotment of points to use as damage after successfully touching an undead creature.",
          3, "Ability"
      }, //
      {69, "Aura of Courage",
          "Beginning at 3rd level, a paladin is immune to fear (magical or otherwise). Each ally within 10 feet of her gains a +4 morale bonus on saving throws against fear effects.<br/>This ability functions while the paladin is conscious, but not if she is unconscious or dead.",
          3, "Ability"
      }, //
      {70, "Divine Health", "At 3rd level, a paladin gains immunity to all diseases, including supernatural and magical diseases.",
          1, "Ability"
      }, //
      {71, "Turn Undead - Paladin",
          "When a paladin reaches 4th level, she gains the supernatural ability to turn undead. She may use this ability a number of times per day equal to 3 + her Charisma modifier. She turns undead as a cleric of three levels lower would.",
          3, "Ability"
      }, //
      {72, "Spells - Paladin",
          "Beginning at 4th level, a paladin gains the ability to cast a small number of divine spells, which are drawn from the paladin spell list. A paladin must choose and prepare her spells in advance.<br/>To prepare or cast a spell, a paladin must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a paladin's spell is 10 + the spell level + the paladin's Wisdom modifier.<br/>Like other spellcasters, a paladin can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: The Paladin. In addition, she receives bonus spells per day if she has a high Wisdom score. When Table: The Paladin indicates that the paladin gets 0 spells per day of a given spell level, she gains only the bonus spells she would be entitled to based on her Wisdom score for that spell level The paladin does not have access to any domain spells or granted powers, as a cleric does.<br/>A paladin prepares and casts spells the way a cleric does, though she cannot lose a prepared spell to spontaneously cast a cure spell in its place. A paladin may prepare and cast any spell on the paladin spell list, provided that she can cast spells of that level, but she must choose which spells to prepare during her daily meditation.<br/>Through 3rd level, a paladin has no caster level. At 4th level and higher, her caster level is one-half her paladin level.",
          0, "SpelllistAbility"
      }, //
      {73, "Special Mount",
          "Upon reaching 5th level, a paladin gains the service of an unusually intelligent, strong, and loyal steed to serve her in her crusade against evil (see below). This mount is usually a heavy warhorse (for a Medium paladin) or a warpony (for a Small paladin).<br/>Once per day, as a full-round action, a paladin may magically call her mount from the celestial realms in which it resides. This ability is the equivalent of a spell of a level equal to one-third the paladin's level. The mount immediately appears adjacent to the paladin and remains for 2 hours per paladin level. It may be dismissed at any time as a free action. The mount is the same creature each time it is summoned, though the paladin may release a particular mount from service.<br/>Each time the mount is called, it appears in full health, regardless of any damage it may have taken previously. The mount also appears wearing or carrying any gear it had when it was last dismissed. Calling a mount is a conjuration (calling) effect.<br/>Should the paladin's mount die, it immediately disappears, leaving behind any equipment it was carrying. The paladin may not summon another mount for thirty days or until she gains a paladin level, whichever comes first, even if the mount is somehow returned from the dead. During this thirty-day period, the paladin takes a -1 penalty on attack and weapon damage rolls.",
          2, "Ability"
      }, //
      {74, "Remove Disease",
          "At 6th level, a paladin can produce a remove disease effect, as the spell, once per week. She can use this ability one additional time per week for every three levels after 6th (twice per week at 9th, three times at 12th, and so forth).",
          2, "Ability"
      }, //
      {75, "Code of Conduct",
          "A paladin must be of lawful good alignment and loses all class abilities if she ever willingly commits an evil act.<br/>Additionally, a paladin's code requires that she respect legitimate authority, act with honor (not lying, not cheating, not using poison, and so forth), help those in need (provided they do not use the help for evil or chaotic ends), and punish those who harm or threaten innocents.",
          0, "Ability"
      }, //
      {76, "Associates",
          "While she may adventure with characters of any good or neutral alignment, a paladin will never knowingly associate with evil characters, nor will she continue an association with someone who consistently offends her moral code. A paladin may accept only henchmen, followers, or cohorts who are lawful good.",
          0, "Ability"
      }, //
      {77, "Favored Enemy",
          "At 1st level, a ranger may select a type of creature from among those given on Table: Ranger Favored Enemies. The ranger gains a +2 bonus on Bluff, Listen, Sense Motive, Spot, and Survival checks when using these skills against creatures of this type. Likewise, he gets a +2 bonus on weapon damage rolls against such creatures.<br/>At 5th level and every five levels thereafter (10th, 15th, and 20th level), the ranger may select an additional favored enemy from those given on the table. In addition, at each such interval, the bonus against any one favored enemy (including the one just selected, if so desired) increases by 2.<br/>If the ranger chooses humanoids or outsiders as a favored enemy, he must also choose an associated subtype, as indicated on the table. If a specific creature falls into more than one category of favored enemy, the ranger's bonuses do not stack. He simply uses whichever bonus is higher.<br/><table><tbody><tr><th>Type (Subtype)</th><th>Type (Subtype)</th></tr><tr><td>Aberration</td><td>Humanoid (reptilian)</td></tr><tr><td>Animal</td><td>Magical beast</td></tr><tr><td>Construct</td><td>Monstrous humanoid</td></tr><tr><td>Dragon</td><td>Ooze</td></tr><tr><td>Elemental</td><td>Outsider (air)</td></tr><tr><td>Fey</td><td>Outsider (chaotic)</td></tr><tr><td>Giant</td><td>Outsider (earth)</td></tr><tr><td>Humanoid (aquatic)</td><td>Outsider (evil)</td></tr><tr><td>Humanoid (dwarf)</td><td>Outsider (fire)</td></tr><tr><td>Humanoid (elf)</td><td>Outsider (good)</td></tr><tr><td>Humanoid (goblinoid)</td><td>Outsider (lawful)</td></tr><tr><td>Humanoid (gnoll)</td><td>Outsider (native)</td></tr><tr><td>Humanoid (gnome)</td><td>Outsider (water)</td></tr><tr><td>Humanoid (halfling)</td><td>Plant</td></tr><tr><td>Humanoid (human)</td><td>Undead</td></tr><tr><td>Humanoid (orc)</td><td>Vermin</td></tr></tbody></table>",
          1, "Ability"
      }, //
      {78, "Track", "A ranger gains Track as a bonus feat.", 0, "Ability"}, //
      {80, "Combat Style",
          "At 2nd level, a ranger must select one of two combat styles to pursue: archery or two-weapon combat. This choice affects the character's class features but does not restrict his selection of feats or special abilities in any way.<br/>If the ranger selects archery, he is treated as having the Rapid Shot feat, even if he does not have the normal prerequisites for that feat.<br/>If the ranger selects two-weapon combat, he is treated as having the Two-Weapon Fighting feat, even if he does not have the normal prerequisites for that feat.<br/>The benefits of the ranger's chosen style apply only when he wears light or no armor. He loses all benefits of his combat style when wearing medium or heavy armor.",
          1, "Ability"
      }, //
      {81, "Endurance", "A ranger gains Endurance as a bonus feat at 3rd level.", 0, "Ability"}, //
      {82, "Animal Companion - Ranger",
          "At 4th level, a ranger gains an animal companion selected from the following list: badger, camel, dire rat, dog, riding dog, eagle, hawk, horse (light or heavy), owl, pony, snake (Small or Medium viper), or wolf. If the campaign takes place wholly or partly in an aquatic environment, the following creatures may be added to the ranger's list of options: crocodile, porpoise, Medium shark, and squid. This animal is a loyal companion that accompanies the ranger on his adventures as appropriate for its kind.<br/>This ability functions like the druid ability of the same name, except that the ranger's effective druid level is one-half his ranger level. A ranger may select from the alternative lists of animal companions just as a druid can, though again his effective druid level is half his ranger level. Like a druid, a ranger cannot select an alternative animal if the choice would reduce his effective druid level below 1st.",
          1, "Ability"
      }, //
      {83, "Spells - Ranger",
          "Beginning at 4th level, a ranger gains the ability to cast a small number of divine spells, which are drawn from the ranger spell list. A ranger must choose and prepare his spells in advance (see below).<br/>To prepare or cast a spell, a ranger must have a Wisdom score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a ranger's spell is 10 + the spell level + the ranger's Wisdom modifier.<br/>Like other spellcasters, a ranger can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: The Ranger. In addition, he receives bonus spells per day if he has a high Wisdom score. When Table: The Ranger indicates that the ranger gets 0 spells per day of a given spell level, he gains only the bonus spells he would be entitled to based on his Wisdom score for that spell level. The ranger does not have access to any domain spells or granted powers, as a cleric does.<br/>A ranger prepares and casts spells the way a cleric does, though he cannot lose a prepared spell to cast a cure spell in its place. A ranger may prepare and cast any spell on the ranger spell list, provided that he can cast spells of that level, but he must choose which spells to prepare during his daily meditation.<br/>Through 3rd level, a ranger has no caster level. At 4th level and higher, his caster level is one-half his ranger level.",
          0, "SpelllistAbility"
      }, //
      {84, "Improved Combat Style",
          "At 6th level, a ranger's aptitude in his chosen combat style (archery or two-weapon combat) improves. If he selected archery at 2nd level, he is treated as having the Manyshot feat, even if he does not have the normal prerequisites for that feat.<br/>If the ranger selected two-weapon combat at 2nd level, he is treated as having the Improved Two-Weapon Fighting feat, even if he does not have the normal prerequisites for that feat.<br/>As before, the benefits of the ranger's chosen style apply only when he wears light or no armor. He loses all benefits of his combat style when wearing medium or heavy armor.",
          1, "Ability"
      }, //
      {86, "Swift Tracker",
          "Beginning at 8th level, a ranger can move at his normal speed while following tracks without taking the normal -5 penalty. He takes only a -10 penalty (instead of the normal -20) when moving at up to twice normal speed while tracking.",
          1, "Ability"
      }, //
      {88, "Combat Style Mastery",
          "At 11th level, a ranger's aptitude in his chosen combat style (archery or two-weapon combat) improves again. If he selected archery at 2nd level, he is treated as having the Improved Precise Shot feat, even if he does not have the normal prerequisites for that feat.<br/>If the ranger selected two-weapon combat at 2nd level, he is treated as having the Greater Two-Weapon Fighting feat, even if he does not have the normal prerequisites for that feat.<br/>As before, the benefits of the ranger's chosen style apply only when he wears light or no armor. He loses all benefits of his combat style when wearing medium or heavy armor.",
          1, "Ability"
      }, //
      {89, "Camouflage",
          "A ranger of 13th level or higher can use the Hide skill in any sort of natural terrain, even if the terrain doesn't grant cover or concealment.",
          1, "Ability"
      }, //
      {90, "Hide in Plain Sight",
          "While in any sort of natural terrain, a ranger of 17th level or higher can use the Hide skill even while being observed.",
          1, "Ability"
      }, //
      {91, "Sneak Attack",
          "If a rogue can catch an opponent when he is unable to defend himself effectively from her attack, she can strike a vital spot for extra damage.<br/>The rogue's attack deals extra damage any time her target would be denied a Dexterity bonus to AC (whether the target actually has a Dexterity bonus or not), or when the rogue flanks her target. This extra damage is 1d6 at 1st level, and it increases by 1d6 every two rogue levels thereafter. Should the rogue score a critical hit with a sneak attack, this extra damage is not multiplied.<br/>Ranged attacks can count as sneak attacks only if the target is within 30 feet.<br/>With a sap (blackjack) or an unarmed strike, a rogue can make a sneak attack that deals nonlethal damage instead of lethal damage. She cannot use a weapon that deals lethal damage to deal nonlethal damage in a sneak attack, not even with the usual -4 penalty.<br/>A rogue can sneak attack only living creatures with discernible anatomies-undead, constructs, oozes, plants, and incorporeal creatures lack vital areas to attack. Any creature that is immune to critical hits is not vulnerable to sneak attacks. The rogue must be able to see the target well enough to pick out a vital spot and must be able to reach such a spot. A rogue cannot sneak attack while striking a creature with concealment or striking the limbs of a creature whose vitals are beyond reach.",
          0, "Ability"
      }, //
      {92, "Trapfinding",
          "Rogues (and only rogues) can use the Search skill to locate traps when the task has a Difficulty Class higher than 20.<br/>Finding a nonmagical trap has a DC of at least 20, or higher if it is well hidden. Finding a magic trap has a DC of 25 + the level of the spell used to create it.<br/>Rogues (and only rogues) can use the Disable Device skill to disarm magic traps. A magic trap generally has a DC of 25 + the level of the spell used to create it.<br/>A rogue who beats a trap's DC by 10 or more with a Disable Device check can study a trap, figure out how it works, and bypass it (with her party) without disarming it.",
          0, "Ability"
      }, //
      {95, "Special Abilities Rogue",
          "On attaining 10th level, and at every three levels thereafter (13th, 16th, and 19th), a rogue gains a special ability of her choice from among the following options.",
          0, "Ability"
      }, //
      {96, "Special Ability Rogue - Crippling Strike",
          "A rogue with this ability can sneak attack opponents with such precision that her blows weaken and hamper them. An opponent damaged by one of her sneak attacks also takes 2 points of Strength damage. Ability points lost to damage return on their own at the rate of 1 point per day for each damaged ability.",
          1, "Ability"
      }, //
      {97, "Special Ability Rogue - Defensive Roll",
          "The rogue can roll with a potentially lethal blow to take less damage from it than she otherwise would. Once per day, when she would be reduced to 0 or fewer hit points by damage in combat (from a weapon or other blow, not a spell or special ability), the rogue can attempt to roll with the damage. To use this ability, the rogue must attempt a Reflex saving throw (DC = damage dealt). If the save succeeds, she takes only half damage from the blow. If it fails, she takes full damage. She must be aware of the attack and able to react to it in order to execute her defensive roll-if she is denied her Dexterity bonus to AC, she can't use this ability. Since this effect would not normally allow a character to make a Reflex save for half damage, the rogue's evasion ability does not apply to the defensive roll.",
          1, "Ability"
      }, //
      {98, "Special Ability Rogue - Improved Evasion",
          "This ability works like evasion, except that while the rogue still takes no damage on a successful Reflex saving throw against attacks henceforth she henceforth takes only half damage on a failed save. A helpless rogue does not gain the benefit of improved evasion.",
          1, "Ability"
      }, //
      {99, "Special Ability Rogue - Opportunist",
          "Once per round, the rogue can make an attack of opportunity against an opponent who has just been struck for damage in melee by another character. This attack counts as the rogue's attack of opportunity for that round. Even a rogue with the Combat Reflexes feat can't use the opportunist ability more than once per round.",
          1, "Ability"
      }, //
      {100, "Special Ability Rogue - Skill Mastery",
          "The rogue becomes so certain in the use of certain skills that she can use them reliably even under adverse conditions.<br/>Upon gaining this ability, she selects a number of skills equal to 3 + her Intelligence modifier. When making a skill check with one of these skills, she may take 10 even if stress and distractions would normally prevent her from doing so. A rogue may gain this special ability multiple times, selecting additional skills for it to apply to each time.",
          0, "Ability"
      }, //
      {101, "Special Ability Rogue - Slippery Mind",
          "This ability represents the rogue's ability to wriggle free from magical effects that would otherwise control or compel her. If a rogue with slippery mind is affected by an enchantment spell or effect and fails her saving throw, she can attempt it again 1 round later at the same DC. She gets only this one extra chance to succeed on her saving throw.",
          1, "Ability"
      }, //
      {102, "Special Ability Rogue - Feat", "A rogue may gain a bonus feat in place of a special ability.", 0, "Ability"}, //
      {103, "Spells - Sorcerer",
          "A sorcerer casts arcane spells which are drawn primarily from the sorcerer/wizard spell list. He can cast any spell he knows without preparing it ahead of time, the way a wizard or a cleric must (see below).<br/>To learn or cast a spell, a sorcerer must have a Charisma score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a sorcerer's spell is 10 + the spell level + the sorcerer's Charisma modifier.<br/>Like other spellcasters, a sorcerer can cast only a certain number of spells of each spell level per day. His base daily spell allotment is given on Table: The Sorcerer. In addition, he receives bonus spells per day if he has a high Charisma score.<br/>A sorcerer's selection of spells is extremely limited. A sorcerer begins play knowing four 0-level spells and two 1st-level spells of your choice. At each new sorcerer level, he gains one or more new spells, as indicated on Table: Sorcerer Spells Known. (Unlike spells per day, the number of spells a sorcerer knows is not affected by his Charisma score. The numbers on Table: Sorcerer Spells Known are fixed.) These new spells can be common spells chosen from the sorcerer/wizard spell list, or they can be unusual spells that the sorcerer has gained some understanding of by study. The sorcerer can't use this method of spell acquisition to learn spells at a faster rate, however.<br/>Upon reaching 4th level, and at every even-numbered sorcerer level after that (6th, 8th, and so on), a sorcerer can choose to learn a new spell in place of one he already knows. In effect, the sorcerer 'loses' the old spell in exchange for the new one. The new spell's level must be the same as that of the spell being exchanged, and it must be at least two levels lower than the highest-level sorcerer spell the sorcerer can cast. A sorcerer may swap only a single spell at any given level, and must choose whether or not to swap the spell at the same time that he gains new spells known for the level.<br/>Unlike a wizard or a cleric, a sorcerer need not prepare his spells in advance. He can cast any spell he knows at any time, assuming he has not yet used up his spells per day for that spell level. He does not have to decide ahead of time which spells he'll cast.",
          0, "SpelllistAbility"
      }, //
      {104, "Familiar",
          "A spell caster can obtain a familiar (see below). Doing so takes 24 hours and uses up magical materials that cost 100 gp. A familiar is a magical beast that resembles a small animal and is unusually tough and intelligent. The creature serves as a companion and servant.<br/>The spell caster chooses the kind of familiar he gets. As the spell caster advances in level, his familiar also increases in power.<br/>If the familiar dies or is dismissed by the sorcerer, the spell caster must attempt a DC 15 Fortitude saving throw. Failure means he loses 200 experience points per sorcerer level. Success reduces the loss to one-half that amount. However, a spell caster's experience point total can never go below 0 as the result of a familiar's demise or dismissal. A slain or dismissed familiar cannot be replaced for a year and day. A slain familiar can be raised from the dead just as a character can be, and it does not lose a level or a Constitution point when this happy event occurs.<br/>A character with more than one class that grants a familiar may have only one familiar at a time.",
          0, "Ability"
      }, //
      {105, "Spells - Wizard",
          "A wizard casts arcane spells which are drawn from the sorcerer/ wizard spell list. A wizard must choose and prepare her spells ahead of time (see below).<br/>To learn, prepare, or cast a spell, the wizard must have an Intelligence score equal to at least 10 + the spell level. The Difficulty Class for a saving throw against a wizard's spell is 10 + the spell level + the wizard's Intelligence modifier.<br/>Like other spellcasters, a wizard can cast only a certain number of spells of each spell level per day. Her base daily spell allotment is given on Table: The Wizard. In addition, she receives bonus spells per day if she has a high Intelligence score.<br/>Unlike a bard or sorcerer, a wizard may know any number of spells. She must choose and prepare her spells ahead of time by getting a good night's sleep and spending 1 hour studying her spellbook. While studying, the wizard decides which spells to prepare.",
          0, "SpelllistAbility"
      }, //
      {106, "Bonus Languages - Wizard",
          "A wizard may substitute Draconic for one of the bonus languages available to the character because of her race.", 0,
          "Ability"
      }, //
      {107, "Scribe Scroll", "At 1st level, a wizard gains Scribe Scroll as a bonus feat. ", 0, "Ability"}, //
      {108, "Bonus Feats - Wizard",
          "At 5th, 10th, 15th, and 20th level, a wizard gains a bonus feat. At each such opportunity, she can choose a metamagic feat, an item creation feat, or Spell Mastery. The wizard must still meet all prerequisites for a bonus feat, including caster level minimums.<br/>These bonus feats are in addition to the feat that a character of any class gets from advancing levels. The wizard is not limited to the categories of item creation feats, metamagic feats, or Spell Mastery when choosing these feats.",
          0, "Ability"
      }, //
      {109, "Spellbooks",
          "A wizard must study her spellbook each day to prepare her spells. She cannot prepare any spell not recorded in her spellbook, except for read magic, which all wizards can prepare from memory.<br/>A wizard begins play with a spellbook containing all 0-level wizard spells (except those from her prohibited school or schools, if any, see School Specialization, below) plus three 1st-level spells of your choice. For each point of Intelligence bonus the wizard has, the spellbook holds one additional 1st-level spell of your choice. At each new wizard level, she gains two new spells of any spell level or levels that she can cast (based on her new wizard level) for her spellbook. At any time, a wizard can also add spells found in other wizards' spellbooks to her own.",
          0, "Ability"
      }, //
      {110, "School Specialization",
          "A school is one of eight groupings of spells, each defined by a common theme. If desired, a wizard may specialize in one school of magic (see below). Specialization allows a wizard to cast extra spells from her chosen school, but she then never learns to cast spells from some other schools.<br/>A specialist wizard can prepare one additional spell of her specialty school per spell level each day. She also gains a +2 bonus on Spellcraft checks to learn the spells of her chosen school.<br/>The wizard must choose whether to specialize and, if she does so, choose her specialty at 1st level. At this time, she must also give up two other schools of magic (unless she chooses to specialize in divination, see below), which become her prohibited schools.<br/>A wizard can never give up divination to fulfill this requirement.<br/>Spells of the prohibited school or schools are not available to the wizard, and she can't even cast such spells from scrolls or fire them from wands. She may not change either her specialization or her prohibited schools later.<br/>The eight schools of arcane magic are abjuration, conjuration, divination, enchantment, evocation, illusion, necromancy, and transmutation.<br/>Spells that do not fall into any of these schools are called universal spells.",
          0, "Ability"
      }, //
      {111, "School Specialization - Abjuration",
          "Spells that protect, block, or banish. An abjuration specialist is called an abjurer.", 0, "SpelllistAbility"
      }, //
      {112, "School Specialization - Conjuration",
          "Spells that bring creatures or materials to the caster. A conjuration specialist is called a conjurer.", 0,
          "SpelllistAbility"
      }, //
      {113, "School Specialization - Divination",
          "Spells that reveal information. A divination specialist is called a diviner. Unlike the other specialists, a diviner must give up only one other school.",
          0, "SpelllistAbility"
      }, //
      {114, "School Specialization - Enchantment",
          "Spells that imbue the recipient with some property or grant the caster power over another being. An enchantment specialist is called an enchanter.",
          0, "SpelllistAbility"
      }, //
      {115, "School Specialization - Evocation",
          "Spells that manipulate energy or create something from nothing. An evocation specialist is called an evoker.", 0,
          "SpelllistAbility"
      }, //
      {116, "School Specialization - Illusion",
          "Spells that alter perception or create false images. An illusion specialist is called an illusionist.", 0,
          "SpelllistAbility"
      }, //
      {117, "School Specialization - Necromancy",
          "Spells that manipulate, create, or destroy life or life force. A necromancy specialist is called a necromancer.", 0,
          "SpelllistAbility"
      }, //
      {118, "School Specialization - Transmutation",
          "Spells that transform the recipient physically or change its properties in a more subtle way. A transmutation specialist is called a transmuter.",
          0, "SpelllistAbility"
      }, //
      {119, "School Specialization - Universal",
          "Not a school, but a category for spells that all wizards can learn. A wizard cannot select universal as a specialty school or as a prohibited school. Only a limited number of spells fall into this category.",
          0, "SpelllistAbility"
      }, //
      {120, "Enhance Arrow",
          "At 1st level, every nonmagical arrow an arcane archer nocks and lets fly becomes magical, gaining a +1 enhancement bonus. Unlike magic weapons created by normal means, the archer need not spend experience points or gold pieces to accomplish this task. However, an archer's magic arrows only function for her. For every two levels the character advances past 1st level in the prestige class, the magic arrows she creates gain +1 greater potency (+1 at 1st level, +2 at 3rd level, +3 at 5th level, +4 at 7th level, and +5 at 9th level).",
          3, "Ability"
      }, //
      {121, "Imbue Arrow",
          "At 2nd level, an arcane archer gains the ability to place an area spell upon an arrow. When the arrow is fired, the spell's area is centered on where the arrow lands, even if the spell could normally be centered only on the caster. This ability allows the archer to use the bow's range rather than the spell's range. It takes a standard action to cast the spell and fire the arrow. The arrow must be fired in the round the spell is cast, or the spell is wasted.",
          2, "Ability"
      }, //
      {122, "Seeker Arrow",
          "At 4th level, an arcane archer can launch an arrow once per day at a target known to her within range, and the arrow travels to the target, even around corners. Only an unavoidable obstacle or the limit of the arrow's range prevents the arrow's flight. This ability negates cover and concealment modifiers, but otherwise the attack is rolled normally. Using this ability is a standard action (and shooting the arrow is part of the action).",
          2, "Ability"
      }, //
      {123, "Phase Arrow",
          "At 6th level, an arcane archer can launch an arrow once per day at a target known to her within range, and the arrow travels to the target in a straight path, passing through any nonmagical barrier or wall in its way. (Any magical barrier stops the arrow.) This ability negates cover, concealment, and even armor modifiers, but otherwise the attack is rolled normally.<br/>Using this ability is a standard action (and shooting the arrow is part of the action).",
          2, "Ability"
      }, //
      {124, "Hail of Arrows",
          "In lieu of her regular attacks, once per day an arcane archer of 8th level or higher can fire an arrow at each and every target within range, to a maximum of one target for every arcane archer level she has earned. Each attack uses the archer's primary attack bonus, and each enemy may only be targeted by a single arrow.",
          2, "Ability"
      }, //
      {125, "Arrow of Death",
          "At 10th level, an arcane archer can create an arrow of death that forces the target, if damaged by the arrow's attack, to make a DC 20 Fortitude save or be slain immediately. It takes one day to make an arrow of death, and the arrow only functions for the arcane archer who created it. The arrow of death lasts no longer than one year, and the archer can only have one such arrow in existence at a time.",
          2, "Ability"
      }, //
      {126, "Spells per Day",
          "When a new prestige class level is gained, the character gains new spells per day as if he had also gained a level in a spellcasting class he belonged to before adding the prestige class. He does not, however, gain any other benefit a character of that class would have gained, except for an increased effective level of spellcasting. If a character had more than one spellcasting class before becoming a prestige character, he must decide to which class he adds the new level for purposes of determining spells per day.",
          0, "Ability"
      }, //
      {127, "Ranged Legerdemain",
          "An arcane trickster can perform one of the following class skills at a range of 30 feet: Disable Device, Open Lock, or Sleight of Hand. Working at a distance increases the normal skill check DC by 5, and an arcane trickster cannot take 10 on this check. Any object to be manipulated must weigh 5 pounds or less.<br/>An arcane trickster can use ranged legerdemain once per day initially, twice per day upon attaining 5th level, and three times per day at 9th level or higher. He can make only one ranged legerdemain skill check each day, and only if he has at least 1 rank in the skill being used.",
          0, "Ability"
      }, //
      {128, "Impromptu Sneak Attack",
          "Beginning at 3rd level, once per day an arcane trickster can declare one melee or ranged attack he makes to be a sneak attack (the target can be no more than 30 feet distant if the impromptu sneak attack is a ranged attack). The target of an impromptu sneak attack loses any Dexterity bonus to AC, but only against that attack. The power can be used against any target, but creatures that are not subject to critical hits take no extra damage (though they still lose any Dexterity bonus to AC against the attack).<br/>At 7th level, an arcane trickster can use this ability twice per day.",
          0, "Ability"
      }, //
      {129, "Spells per Day/Spells Known",
          "When a new prestige class level is gained, the character gains new spells per day (and spells known, if applicable) as if he had also gained a level in whatever arcane spellcasting class in which he could cast 7th-level spells before he added the prestige class level. He does not, however, gain any other benefit a character of that class would have gained. If a character had more than one arcane spellcasting class in which he could cast 7th-level spells before he became a prestige class, he must decide to which class he adds each level of archmage for the purpose of determining spells per day.",
          0, "Ability"
      }, //
      {130, "High Arcana",
          "An archmage gains the opportunity to select a special ability from among those described below by permanently eliminating one existing spell slot (she cannot eliminate a spell slot of higher level than the highest-level spell she can cast). Each special ability has a minimum required spell slot level, as specified in its description.<br/>An archmage may choose to eliminate a spell slot of a higher level than that required to gain a type of high arcana.",
          0, "Ability"
      }, //
      {131, "Arcane Fire",
          "The archmage gains the ability to change arcane spell energy into arcane fire, manifesting it as a bolt of raw magical energy. The bolt is a ranged touch attack with long range (400 feet + 40 feet/level of archmage) that deals 1d6 points of damage per class level of the archmage plus 1d6 points of damage per level of the spell used to create the effect. This ability costs one 9th-level spell slot.",
          3, "Ability"
      }, //
      {132, "Arcane Reach",
          "The archmage can use spells with a range of touch on a target up to 30 feet away. The archmage must make a ranged touch attack. Arcane reach can be selected a second time as a special ability, in which case the range increases to 60 feet. This ability costs one 7th-level spell slot.",
          3, "Ability"
      }, //
      {133, "Mastery of Counterspelling",
          "When the archmage counterspells a spell, it is turned back upon the caster as if it were fully affected by a spell turning spell. If the spell cannot be affected by spell turning, then it is merely counterspelled. This ability costs one 7th-level spell slot.",
          0, "Ability"
      }, //
      {134, "Mastery of Elements",
          "The archmage can alter an arcane spell when cast so that it utilizes a different element from the one it normally uses. This ability can only alter a spell with the acid, cold, fire, electricity, or sonic descriptor. The spell's casting time is unaffected. The caster decides whether to alter the spell's energy type and chooses the new energy type when he begins casting. This ability costs one 8th-level spell slot.",
          0, "Ability"
      }, //
      {135, "Mastery of Shaping",
          "The archmage can alter area and effect spells that use one of the following shapes: burst, cone, cylinder, emanation, or spread. The alteration consists of creating spaces within the spell's area or effect that are not subject to the spell. The minimum dimension for these spaces is a 5-foot cube. Furthermore, any shapeable spells have a minimum dimension of 5 feet instead of 10 feet. This ability costs one 6th-level spell slot.",
          0, "Ability"
      }, //
      {136, "Spell Power",
          "This ability increases the archmage's effective caster level by +1 (for purposes of determining level-dependent spell variables such as damage dice or range, and caster level checks only). This ability costs one 5th-level spell slot.",
          0, "Ability"
      }, //
      {137, "Spell-Like Ability",
          "A character who selects this ability can use one of her spell slots (other than a slot expended to learn this) to permanently prepare one of her spells as a spell-like ability that can be used twice per day. The character does not use any components when casting the spell, although a spell that costs XP to cast still does so and a spell with a costly material component instead costs her 10 times that amount in XP. This ability costs one 5th-level spell slot.<br/>The spell-like ability normally uses a spell slot of the spell's level, although the character can choose to make a spell modified by a metamagic feat into a spell-like ability at the appropriate spell level.<br/>The character may use an available higher-level spell slot in order to use the spell-like ability more often. Using a slot three levels higher than the chosen spell allows her to use the spell-like ability four times per day, and a slot six levels higher lets her use it six times per day.<br/>If spell-like ability is selected more than one time, this ability can apply to the same spell chosen the first time (increasing the number of times per day it can be used) or to a different spell.",
          0, "Ability"
      }, //
      {138, "Death Attack",
          "If an assassin studies his victim for 3 rounds and then makes a sneak attack with a melee weapon that successfully deals damage, the sneak attack has the additional effect of possibly either paralyzing or killing the target (assassin's choice). While studying the victim, the assassin can undertake other actions so long as his attention stays focused on the target and the target does not detect the assassin or recognize the assassin as an enemy. If the victim of such an attack fails a Fortitude save (DC 10 + the assassin's class level + the assassin's Int modifier) against the kill effect, she dies. If the saving throw fails against the paralysis effect, the victim is rendered helpless and unable to act for 1d6 rounds plus 1 round per level of the assassin. If the victim's saving throw succeeds, the attack is just a normal sneak attack. Once the assassin has completed the 3 rounds of study, he must make the death attack within the next 3 rounds.<br/>If a death attack is attempted and fails (the victim makes her save) or if the assassin does not launch the attack within 3 rounds of completing the study, 3 new rounds of study are required before he can attempt another death attack.",
          0, "Ability"
      }, //
      {139, "Poison Use",
          "Trained in the use of poison and never risk accidentally poisoning themselves when applying poison to a blade.", 0,
          "Ability"
      }, //
      {140, "Spells - Assassin",
          "Beginning at 1st level, an assassin gains the ability to cast a number of arcane spells. To cast a spell, an assassin must have an Intelligence score of at least 10 + the spell's level, so an assassin with an Intelligence of 10 or lower cannot cast these spells. Assassin bonus spells are based on Intelligence, and saving throws against these spells have a DC of 10 + spell level + the assassin's Intelligence bonus. When the assassin gets 0 spells per day of a given spell level he gains only the bonus spells he would be entitled to based on his Intelligence score for that spell level.<br/>The assassin's spell list appears below. An assassin casts spells just as a bard does.<br/>Upon reaching 6th level, at every even-numbered level after that (8th and 10th), an assassin can choose to learn a new spell in place of one he already knows. The new spell's level must be the same as that of the spell being exchanged, and it must be at least two levels lower than the highest-level assassin spell the assassin can cast. An assassin may swap only a single spell at any given level, and must choose whether or not to swap the spell at the same time that he gains new spells known for that level.<br/><table><tbody><tr><th>Level</th><th>1st</th><th>2nd</th><th>3rd</th><th>4th</th></tr><tr><th>1st</th><td>2</td><td>-</td><td>-</td><td>-</td></tr><tr><th>2nd</th><td>3</td><td>-</td><td>-</td><td>-</td></tr><tr><th>3rd</th><td>3</td><td>2</td><td>-</td><td>-</td></tr><tr><th>4th</th><td>4</td><td>3</td><td>-</td><td>-</td></tr><tr><th>5th</th><td>4</td><td>3</td><td>2</td><td>-</td></tr><tr><th>6th</th><td>4</td><td>4</td><td>3</td><td>-</td></tr><tr><th>7th</th><td>4</td><td>4</td><td>3</td><td>2</td></tr><tr><th>8th</th><td>4</td><td>4</td><td>4</td><td>3</td></tr><tr><th>9th</th><td>4</td><td>4</td><td>4</td><td>3</td></tr><tr><th>10th</th><td>4</td><td>4</td><td>4</td><td>4</td></tr></tbody></table>",
          0, "SpelllistAbility"
      }, //
      {141, "Save Bonus against Poison",
          "The assassin gains a natural saving throw bonus to all poisons gained at 2nd level that increases by +1 for every two additional levels the assassin gains.",
          0, "Ability"
      }, //
      {142, "Spell List - Assassin",
          "Assassins choose their spells from the following list:<br/>1st Level: disguise self, detect poison, feather fall, ghost sound, jump, obscuring mist, sleep, true strike.<br/>2nd Level: alter self, cat's grace, darkness, fox's cunning, illusory script, invisibility, pass without trace, spider climb, undetectable alignment.<br/>3rd Level: deep slumber, deeper darkness, false life, magic circle against good, misdirection, nondetection.<br/>4th Level: clairaudience/clairvoyance, dimension door, freedom of movement, glibness, greater invisibility, locate creature, modify memory, poison.",
          0, "Ability"
      }, //
      {143, "Aura of Evil",
          "The power of a blackguard's aura of evil (see the detect evil spell) is equal to his class level plus his cleric level, if any.",
          1, "Ability"
      }, //
      {144, "Detect Good",
          "At will, a blackguard can use detect good as a spell-like ability, duplicating the effect of the detect good spell.", 2,
          "Ability"
      }, //
      {145, "Dark Blessing", "A blackguard applies his Charisma modifier (if positive) as a bonus on all saving throws.", 3,
          "Ability"
      }, //
      {146, "Spells - Blackguard",
          "A blackguard has the ability to cast a small number of divine spells. To cast a blackguard spell, a blackguard must have a Wisdom score of at least 10 + the spell's level, so a blackguard with a Wisdom of 10 or lower cannot cast these spells.<br/>Blackguard bonus spells are based on Wisdom, and saving throws against these spells have a DC of 10 + spell level + the blackguard's Wisdom modifier. When the blackguard gets 0 spells per day of a given spell level he gains only the bonus spells he would be entitled to based on his Wisdom score for that spell level. The blackguard's spell list appears below. A blackguard has access to any spell on the list and can freely choose which to prepare, just as a cleric. A blackguard prepares and casts spells just as a cleric does (though a blackguard cannot spontaneously cast cure or inflict spells).",
          0, "SpelllistAbility"
      }, //
      {147, "Smite Good",
          "Once a day, a blackguard of 2nd level or higher may attempt to smite good with one normal melee attack.<br/>He adds his Charisma modifier (if positive) to his attack roll and deals 1 extra point of damage per class level. If a blackguard accidentally smites a creature that is not good, the smite has no effect but it is still used up for that day.<br/>At 5th level, and again at 10th level, a blackguard may smite good one additional time per day.",
          3, "Ability"
      }, //
      {148, "Aura of Despair",
          "Beginning at 3rd level, the blackguard radiates a malign aura that causes enemies within 10 feet of him to take a -2 penalty on all saving throws.",
          3, "Ability"
      }, //
      {149, "Command Undead",
          "When a blackguard reaches 3rd level, he gains the supernatural ability to command and rebuke undead. He commands undead as would a cleric of two levels lower.",
          3, "Ability"
      }, //
      {150, "Spell List - Blackguard",
          "Blackguards choose their spells from the following list:<br/>1st Level: cause fear, corrupt weapon, cure light wounds, doom, inflict light wounds, magic weapon, summon monster I*.<br/>2nd Level: bull's strength, cure moderate wounds, darkness, death knell, eagle's splendor, inflict moderate wounds, shatter, summon monster II*.<br/>3rd Level: contagion, cure serious wounds, deeper darkness, inflict serious wounds, protection from elements, summon monster III*.<br/>4th Level: cure critical wounds, freedom of movement, inflict critical wounds, poison, summon monster IV*.<br/>* Evil creatures only.",
          0, "Ability"
      }, //
      {151, "Corrupt Weapon",
          "Blackguards have access to a special spell, corrupt weapon, which is the opposing counterpart of the paladin spell bless weapon. Instead of improving a weapon's effectiveness against evil foes corrupt weapon makes a weapon more effective against good foes.",
          0, "Ability"
      }, //
      {152, "Bonus Spells",
          "Dragon disciples gain bonus spells as they gain levels in this prestige class, as if from having a high ability score, as given on Table: The Dragon Disciple. A bonus spell can be added to any level of spells the disciple already has the ability to cast.<br/>If a character has more than one spellcasting class, he must decide to which class he adds each bonus spell as it is gained. Once a bonus spell has been applied, it cannot be shifted.",
          0, "Ability"
      }, //
      {153, "Natural Armor Increase",
          "At 1st, 4th, and 7th level, a gains an increase to the character's existing natural armor (if any), as indicated on Table: The Dragon Disciple (the numbers represent the total increase gained to that point). As his skin thickens, a dragon disciple takes on more and more of his progenitor's physical aspect.",
          1, "Ability"
      }, //
      {154, "Claws and Bite",
          "At 2nd level, a dragon disciple gains claw and bite attacks if he does not already have them. Use the values below or the disciple's base claw and bite damage values, whichever are greater.<br/><table><tbody><tr><th>Size</th><th>Bite Damage</th><th>Claw Damage</th></tr><tr><td>Small</td><td>1d4</td><td>1d3</td></tr><tr><td>Medium</td><td>1d6</td><td>1d4</td></tr><tr><td>Large</td><td>1d8</td><td>1d6</td></tr></tbody></table>A dragon disciple is considered proficient with these attacks. When making a full attack, a dragon disciple uses his full base attack bonus with his bite attack but takes a -5 penalty on claw attacks. The Multiattack feat reduces this penalty to only -2.",
          1, "Ability"
      }, //
      {155, "Ability Boost",
          "As a dragon disciple gains levels in this prestige class, his ability scores increase as noted on Table: The Dragon Disciple.<br/>These increases stack and are gained as if through level advancement.",
          1, "Ability"
      }, //
      {156, "Breath Weapon",
          "At 3rd level, a dragon disciple gains a minor breath weapon. The type and shape depend on the dragon variety whose heritage he enjoys (see below). Regardless of the ancestor, the breath weapon deals 2d8 points of damage of the appropriate energy type.<br/>At 7th level, the damage increases to 4d8, and when a disciple attains dragon apotheosis at 10th level it reaches its full power at 6d8. Regardless of its strength, the breath weapon can be used only once per day. Use all the rules for dragon breath weapons except as specified here.<br/>The DC of the breath weapon is 10 + class level + Con modifier.<br/>A line-shaped breath weapon is 5 feet high, 5 feet wide, and 60 feet long. A cone-shaped breath weapon is 30 feet long.<br/><table><tbody><tr><th>Dragon Variety*</th><th>Breath Weapon</th></tr><tr><td>Black</td><td>Line of acid</td></tr><tr><td>Blue</td><td>Line of lightning</td></tr><tr><td>Green</td><td>Cone of corrosive gas (acid)</td></tr><tr><td>Red</td><td>Cone of fire</td></tr><tr><td>White</td><td>Cone of cold</td></tr><tr><td>Brass</td><td>Line of fire</td></tr><tr><td>Bronze</td><td>Line of lightning</td></tr><tr><td>Copper</td><td>Line of acid</td></tr><tr><td>Gold</td><td>Cone of fire</td></tr><tr><td>Silver</td><td>Cone of cold</td></tr></tbody></table><br/>* Other varieties of dragon disciple are possible, using other dragon varieties as ancestors.",
          3, "Ability"
      }, //
      {157, "Blindsense",
          "At 5th level, the dragon disciple gains blindsense with a range of 30 feet. Using nonvisual senses the dragon disciple notices things it cannot see. He usually does not need to make Spot or Listen checks to notice and pinpoint the location of creatures within range of his blindsense ability, provided that he has line of effect to that creature.<br/>Any opponent the dragon disciple cannot see still has total concealment against him, and the dragon disciple still has the normal miss chance when attacking foes that have concealment. Visibility still affects the movement of a creature with blindsense. A creature with blindsense is still denied its Dexterity bonus to Armor Class against attacks from creatures it cannot see. At 10th level, the range of this ability increases to 60 feet.",
          1, "Ability"
      }, //
      {158, "Wings",
          "At 9th level, a dragon disciple grows a set of draconic wings. He may now fly at a speed equal to his normal land speed, with average maneuverability.",
          1, "Ability"
      }, //
      {159, "Dragon Apotheosis",
          "At 10th level, a dragon disciple takes on the half-dragon template. His breath weapon reaches full strength (as noted above), and he gains +4 to Strength and +2 to Charisma. His natural armor bonus increases to +4, and he acquires low-light vision, 60-foot darkvision, immunity to sleep and paralysis effects, and immunity to the energy type used by his breath weapon (see above).",
          0, "Ability"
      }, //
      {160, "Canny Defense",
          "When not wearing armor or using a shield, a duelist adds 1 point of Intelligence bonus (if any) per duelist class level to her Dexterity bonus to modify Armor Class while wielding a melee weapon. If a duelist is caught flat-footed or otherwise denied her Dexterity bonus, she also loses this bonus.",
          1, "Ability"
      }, //
      {161, "Improved Reaction",
          "At 2nd level, a duelist gains a +2 bonus on initiative checks.<br/>At 8th level, the bonus increases to +4. This bonus stacks with the benefit provided by the Improved Initiative feat.",
          1, "Ability"
      }, //
      {162, "Enhanced Mobility",
          "When wearing no armor and not using a shield, a duelist gains an additional +4 bonus to AC against attacks of opportunity caused when she moves out of a threatened square.",
          1, "Ability"
      }, //
      {163, "Grace",
          "At 4th level, a duelist gains an additional +2 competence bonus on all Reflex saving throws. This ability functions for a duelist only when she is wearing no armor and not using a shield.",
          1, "Ability"
      }, //
      {164, "Precise Strike",
          "At 5th level, a duelist gains the ability to strike precisely with a light or one-handed piercing weapon, gaining an extra 1d6 damage added to her normal damage roll.<br/>When making a precise strike, a duelist cannot attack with a weapon in her other hand or use a shield. A duelist's precise strike only works against living creatures with discernible anatomies. Any creature that is immune to critical hits is not vulnerable to a precise strike, and any item or ability that protects a creature from critical hits also protects a creature from a precise strike. At 10th level, the extra damage on a precise strike increases to +2d6.",
          1, "Ability"
      }, //
      {165, "Acrobatic Charge",
          "At 6th level, a duelist gains the ability to charge in situations where others cannot. She may charge over difficult terrain that normally slows movement. Depending on the circumstance, she may still need to make appropriate checks to successfully move over the terrain.",
          1, "Ability"
      }, //
      {166, "Elaborate Parry",
          "At 7th level and higher, if a duelist chooses to fight defensively or use total defense in melee combat, she gains an additional +1 dodge bonus to AC for each level of duelist she has.",
          1, "Ability"
      }, //
      {167, "Deflect Arrows",
          "At 9th level, a duelist gains the benefit of the Deflect Arrows feat when using a light or one-handed piercing weapon.",
          0, "Ability"
      }, //
      {168, "AC Bonus - Dwarven Defender",
          "The dwarven defender receives a dodge bonus to Armor Class that starts at +1 and improves as the defender gains levels, until it reaches +4 at 10th level.",
          1, "Ability"
      }, //
      {169, "Defensive Stance",
          "When he adopts a defensive stance, a defender gains phenomenal strength and durability, but he cannot move from the spot he is defending. He gains +2 to Strength, +4 to Constitution, a +2 resistance bonus on all saves, and a +4 dodge bonus to AC. The increase in Constitution increases the defender's hit points by 2 points per level, but these hit points go away at the end of the defensive stance when the Constitution score drops back 4 points. These extra hit points are not lost first the way temporary hit points are. While in a defensive stance, a defender cannot use skills or abilities that would require him to shift his position. A defensive stance lasts for a number of rounds equal to 3 + the character's (newly improved) Constitution modifier. A defender may end his defensive stance voluntarily prior to this limit. At the end of the defensive stance, the defender is winded and takes a -2 penalty to Strength for the duration of that encounter. A defender can only use his defensive stance a certain number of times per day as determined by his level (see Table: The Dwarven Defender). Using the defensive stance takes no time itself, but a defender can only do so during his action.",
          0, "Ability"
      }, //
      {170, "Trap Sense - Dwarven Defender",
          "At 4th level, a dwarven defender gains a +1 bonus on Reflex saves made to avoid traps and a +1 dodge bonus to AC against attacks by traps. At 8th level, these bonuses rise to +2. These bonuses stack with trap sense bonuses gained from other classes.",
          1, "Ability"
      }, //
      {171, "Damage Reduction - Dwarven Defender",
          "At 6th level, a dwarven defender gains damage reduction. Subtract 3 points from the damage the dwarven defender takes each time he is dealt damage. At 10th level, this damage reduction rises to 6/-. Damage reduction can reduce damage to 0 but not below 0.",
          1, "Ability"
      }, //
      {172, "Mobile Defense",
          "At 8th level, a dwarven defender can adjust his position while maintaining a defensive stance. While in a defensive stance, he can take one 5-foot step each round without losing the benefit of the stance.",
          1, "Ability"
      }, //
      {173, "Bonus Feats - Eldritch Knight",
          "At 1st level, an eldritch knight may choose a bonus feat from the list of feats available to fighters. This is in addition to the feats that a character of any class normally gets from advancing levels. The character must still meet any prerequisites for these bonus feats, including levels of fighter for the Weapon Specialization, Greater Weapon Focus, and Greater Weapon Specialization feats.",
          0, "Ability"
      }, //
      {175, "Spells and Caster Level - Hierophant",
          "Levels in the hierophant prestige class, even though they do not advance spell progression in the character's base class, still stack with the character's base spellcasting levels to determine caster level.",
          0, "Ability"
      }, //
      {176, "Special Abilities Hierophant",
          "Every level, a hierophant gains a special ability of his choice from among the following.", 0, "Ability"
      }, //
      {177, "Special Ability Hierophant - Blast Infidel",
          "A hierophant can use negative energy spells to their maximum effect on creatures with an alignment opposed to the hierophant. (See the table below for a list of which alignments are opposed to each alignment.) Any spell with a description that involves inflicting or channeling negative energy cast on a creature of the opposed alignment works as if under the effect of a Maximize Spell feat (without using a higher-level spell slot). Undead affected by this ability heal the maximized amount of damage.<br/><table><tbody><tr><th>Hierophant Alignment</th><th>Opposed Alignment</th></tr><tr><td>Lawful good</td><td>Chaotic evil</td></tr><tr><td>Neutral good</td><td>Neutral evil</td></tr><tr><td>Chaotic good</td><td>Lawful evil</td></tr><tr><td>Lawful neutral</td><td>Chaotic neutral</td></tr><tr><td>Neutral</td><td>Lawful good, chaotic good, lawful evil, chaotic evil*</td></tr><tr><td>Chaotic neutral</td><td>Lawful neutral</td></tr><tr><td>Lawful evil</td><td>Chaotic good</td></tr><tr><td>Neutral evil</td><td>Neutral good</td></tr><tr><td>Chaotic evil</td><td>Lawful good</td></tr></tbody></table><br/>* A neutral hierophant chooses one of these alignments to be the one that he opposes, for the purposes of this special ability.",
          3, "Ability"
      }, //
      {178, "Special Ability Hierophant - Divine Reach",
          "A hierophant with this ability can use touch spells on targets up to 30 feet away. If the spell requires a melee touch attack, the hierophant must make a ranged touch attack instead. Divine reach can be selected a second time as a special ability, in which case the range increases to 60 feet.",
          3, "Ability"
      }, //
      {179, "Special Ability Hierophant - Faith Healing",
          "A hierophant can use healing spells to their maximum effect on creatures of the same alignment as the hierophant (including the hierophant himself ). Any spell with the healing descriptor cast on such creatures works as if under the effects of a Maximize Spell feat (without using a higher-level spell slot).",
          3, "Ability"
      }, //
      {180, "Special Ability Hierophant - Gift of the Divine",
          "Available only to hierophants with cleric levels, this ability allows a hierophant to transfer one or more uses of his turn undead ability to a willing creature. (Hierophants who rebuke undead transfer uses of rebuke undead instead.) The transfer lasts anywhere from 24 hours to one week (chosen at the time of transfer), and while the transfer is in effect, the number of turning attempts per day allowed to the hierophant is reduced by the number transferred. The recipient turns undead as a cleric of the hierophant's cleric level but uses her own Charisma modifier.",
          3, "Ability"
      }, //
      {181, "Special Ability Hierophant - Mastery of Energy",
          "Available only to hierophants with cleric levels, this ability allows a hierophant to channel positive or negative energy much more effectively, increasing his ability to affect undead. Add a +4 bonus to the hierophant's turning checks and turning damage rolls. This ability only affects undead, even if the hierophant can turn other creatures, such as with a granted power of a domain.",
          3, "Ability"
      }, //
      {182, "Special Ability Hierophant - Metamagic Feat",
          "A hierophant can choose a metamagic feat in place of one of the special abilities described here if desired.", 0,
          "Ability"
      }, //
      {183, "Special Ability Hierophant - Power of Nature",
          "Available only to hierophants with druid levels, this ability allows a hierophant to temporarily transfer one or more of his druid Class Features to a willing creature. The transfer lasts anywhere from 24 hours to one week (chosen at the time of transfer), and while the transfer is in effect, the hierophant cannot use the transferred power. He can transfer any of his druid powers except spellcasting and the ability to have an animal companion.<br/>The druid's wild shape ability can be partially or completely transferred. The heirophant choses how many uses of wild shape per day to give to transfer and retains the rest of the uses for himself. If the hierophant can assume the form of Tiny or Huge animals, the recipient can as well.<br/>As with the imbue with spell ability spell, the hierophant remains responsible to his deity for any use to which the recipient puts the transferred abilities.",
          3, "Ability"
      }, //
      {184, "Special Ability Hierophant - Spell Power",
          "This special ability increases a hierophant's effective caster level by 1 for purposes of determining level-dependent spell variables and for caster level checks. This ability can be selected more than once, and changes to effective caster level are cumulative.",
          0, "Ability"
      }, //
      {186, "Terrain Mastery",
          "At each level, the Horizon Walker adds a new terrain environment to their repertoire from those given below. Terrain mastery gives a horizon walker a bonus on checks involving a skill useful in that terrain, or some other appropriate benefit. A horizon walker also knows how to fight dangerous creatures typically found in that terrain, gaining a +1 insight bonus on attack rolls and damage rolls against creatures with that terrain mentioned in the Environment entry of their descriptions. The horizon walker only gains the bonus if the creature description specifically lists the terrain type.<br/>Horizon walkers take their terrain mastery with them wherever they go. They retain their terrain mastery bonuses on skill checks, attack rolls, and damage rolls whether they're actually in the relevant terrain or not.",
          0, "Ability"
      }, //
      {187, "Planar Terrain Mastery",
          "Planar terrain mastery functions just like terrain mastery, except that the horizon walker can choose one of the planar categories at each level. The horizon walker can take a non-planar terrain type instead, if she wishes.",
          0, "Ability"
      }, //
      {188, "Terrain Mastery - Aquatic",
          "You gain a +4 competence bonus on Swim checks, or a +10-foot bonus to your swim speed if you have one. You gain a +1 insight bonus on attack and damage rolls against aquatic creatures.",
          0, "Ability"
      }, //
      {189, "Terrain Mastery - Desert",
          "You resist effects that tire you. You are immune to fatigue, and anything that would cause you to become exhausted makes you fatigued instead. You gain a +1 insight bonus on attack and damage rolls against desert creatures.",
          0, "Ability"
      }, //
      {190, "Terrain Mastery - Forest",
          "You have a +4 competence bonus on Hide checks. You gain a +1 insight bonus on attack and damage rolls against forest creatures.",
          0, "Ability"
      }, //
      {191, "Terrain Mastery - Hills",
          "You gain a +4 competence bonus on Listen checks. You gain a +1 insight bonus on attack and damage rolls against hills creatures.",
          0, "Ability"
      }, //
      {192, "Terrain Mastery - Marsh",
          "You have a +4 competence bonus on Move Silently checks. You gain a +1 insight bonus on attack and damage rolls against marsh creatures.",
          0, "Ability"
      }, //
      {193, "Terrain Mastery - Mountains",
          "You gain a +4 competence bonus on Climb checks, or a +10- foot bonus to your climb speed if you have one. You gain a +1 insight bonus on attack and damage rolls against mountain creatures.",
          0, "Ability"
      }, //
      {194, "Terrain Mastery - Plains",
          "You have a +4 competence bonus on Spot checks. You gain a +1 insight bonus on attack and damage rolls against plains creatures.",
          0, "Ability"
      }, //
      {195, "Terrain Mastery - Underground",
          "You have 60-foot darkvision, or 120-foot darkvision if you already had darkvision from another source. You gain a +1 insight bonus on attack and damage rolls against underground creatures.",
          0, "Ability"
      }, //
      {196, "Planar Terrain Mastery - Fiery",
          "This kind of planar terrain mastery provides you with resistance to fire 20. You gain a +1 insight bonus on attack and damage rolls against outsiders and elementals with the fire subtype.",
          0, "Ability"
      }, //
      {197, "Planar Terrain Mastery - Weightless",
          "You gain a +30-foot bonus to your fly speed on planes with no gravity or subjective gravity. You gain a +1 insight on attack and damage rolls against creatures native to the Astral Plane, the Elemental Plane of Air, and the Ethereal Plane.",
          0, "Ability"
      }, //
      {198, "Planar Terrain Mastery - Cold",
          "This kind of planar terrain mastery provides you with resistance to cold 20. You gain a +1 insight bonus on attack and damage rolls against outsiders and elementals with the cold subtype.",
          0, "Ability"
      }, //
      {199, "Planar Terrain Mastery - Shifting",
          "You instinctively anticipate shifts in the reality of the plane that bring you closer to your destination, giving you the spell-like ability to use dimension door (as the spell cast at your character level) once every 1d4 rounds. You gain a +1 insight bonus on attack and damage rolls against outsiders and elementals native to a shifting plane.",
          0, "Ability"
      }, //
      {200, "Planar Terrain Mastery - Aligned",
          "You have the instinctive ability to mimic the dominant alignment of the plane. You incur none of the penalties for having an alignment at odds with that of the plane, and spells and abilities that harm those of the opposite alignment don't affect you. You have the dominant alignment of the plane with regard to magic, but your behavior and any alignment-related Class Features you have are unaffected.",
          0, "Ability"
      }, //
      {201, "Planar Terrain Mastery - Cavernous", "You gain tremorsense with a 30-foot range.", 0, "Ability"}, //
      {202, "Planar Terrain Mastery - Other", "If other planes are in use additional Planar Terrains can be created.", 0, "Ability"
      }, //
      {204, "Secret",
          "At 1st level and every two levels higher than 1st (3rd, 5th, 7th, and 9th), the loremaster chooses one secret from the table below. Her level plus Intelligence modifier determines the total number of secrets she can choose. She can't choose the same secret twice.",
          0, "Ability"
      }, //
      {205, "Lore",
          "At 2nd level, a loremaster gains the ability to know legends or information regarding various topics, just as a bard can with bardic knowledge. The loremaster adds her level and her Intelligence modifier to the lore check, which functions otherwise exactly like a bardic knowledge check.",
          0, "Ability"
      }, //
      {206, "Bonus Languages - Loremaster", "A loremaster can choose any new language at 4th and 8th level.", 0, "Ability"}, //
      {207, "Greater Lore", "At 6th level, a loremaster gains the ability to understand magic items, as with the identify spell.",
          1, "Ability"
      }, //
      {208, "True Lore",
          "At 10th level, once per day a loremaster can use her knowledge to gain the effect of a legend lore spell or an analyze dweomer spell.<br/><table><tbody><tr><th>Level +Int Modifier</th><th>Secret</th><th>Effect</th></tr><tr><td>1</td><td>Instant mastery</td><td>4 ranks of a skill in which the character has no ranks</td></tr><tr><td>2</td><td>Secret health</td><td>+3 hit points</td></tr><tr><td>3</td><td>Secrets of inner strength</td><td>+2 bonus on Will saves</td></tr><tr><td>4</td><td>The lore of true stamina</td><td>+2 bonus on Fortitude saves</td></tr><tr><td>5</td><td>Secret knowledge of avoidance</td><td>+2 bonus on Reflex saves</td></tr><tr><td>6</td><td>Weapon trick</td><td>+1 bonus on attack rolls</td></tr><tr><td>7</td><td>Dodge trick</td><td>+1 dodge bonus to AC</td></tr><tr><td>8</td><td>Applicable knowledge</td><td>Any one feat</td></tr><tr><td>9</td><td>Newfound arcana</td><td>1 bonus 1st-level spell*</td></tr><tr><td>10</td><td>More newfound arcana</td><td>1 bonus 2nd-level spell*</td></tr></tbody></table><br/>* As if gained through having a high ability score.",
          1, "Ability"
      }, //
      {211, "Darkvision",
          "At 2nd level, a shadowdancer can see in the dark as though she were permanently under the effect of a darkvision spell.",
          3, "Ability"
      }, //
      {212, "Shadow Illusion",
          "When a shadowdancer reaches 3rd level, she can create visual illusions. This ability's effect is identical to that of the arcane spell silent image and may be employed once per day.",
          2, "Ability"
      }, //
      {213, "Summon Shadow",
          "At 3rd level, a shadowdancer can summon a shadow, an undead shade. Unlike a normal shadow, this shadow's alignment matches that of the shadowdancer, and the creature cannot create spawn. The summoned shadow cannot be turned, rebuked, or commanded by any third party. This shadow serves as a companion to the shadowdancer and can communicate intelligibly with the shadowdancer. Every third level gained by the shadowdancer adds +2 HD (and the requisite base attack and base save bonus increases) to her shadow companion.<br/>If a shadow companion is destroyed, or the shadowdancer chooses to dismiss it, the shadowdancer must attempt a DC 15 Fortitude save. If the saving throw fails, the shadowdancer loses 200 experience points per shadowdancer level. A successful saving throw reduces the loss by half, to 100 XP per prestige class level. The shadowdancer's XP total can never go below 0 as the result of a shadow's dismissal or destruction. A destroyed or dismissed shadow companion cannot be replaced for 30 days.",
          3, "Ability"
      }, //
      {214, "Shadow Jump",
          "At 4th level, a shadowdancer gains the ability to travel between shadows as if by means of a dimension door spell. The limitation is that the magical transport must begin and end in an area with at least some shadow. A shadowdancer can jump up to a total of 20 feet each day in this way. This may be a single jump of 20 feet or two jumps of 10 feet each. Every two levels higher than 4th, the distance a shadowdancer can jump each day doubles (40 feet at 6th, 80 feet at 8th, and 160 feet at 10th). This amount can be split among many jumps, but each one, no matter how small, counts as a 10-foot increment.",
          3, "Ability"
      }, //
      {215, "Defensive Roll",
          "Starting at 5th level, once per day, when a shadowdancer would be reduced to 0 hit points or less by damage in combat (from a weapon or other blow, not a spell or special ability), she can attempt to roll with the damage. She makes a Reflex saving throw (DC = damage dealt) and, if successful, takes only half damage from the blow. She must be aware of the attack and able to react to it in order to execute her defensive roll. If she is in a situation that would deny her any Dexterity bonus to AC, she can't attempt a defensive roll.",
          1, "Ability"
      }, //
      {216, "Slippery Mind",
          "At 7th level, if a shadowdancer is affected by an enchantment and fails her saving throw, 1 round later she can attempt her saving throw again. She only gets this one extra chance to succeed at her saving throw. If it fails as well, the spell's effects occur normally.",
          1, "Ability"
      }, //
      {219, "Improved Ally",
          "When a thaumaturgist casts a planar ally spell (including the lesser and greater versions), he makes a Diplomacy check to convince the creature to aid him for a reduced payment. If the thaumaturgist's Diplomacy check adjusts the creature's attitude to helpful the creature will work for 50% of the standard fee, as long as the task is one that is not against its nature.<br/>The thaumaturgist's improved ally class feature only works when the planar ally shares at least one aspect of alignment with the thaumaturgist.<br/>A thaumaturgist can have only one such ally at a time, but he may bargain for tasks from other planar allies normally.",
          0, "Ability"
      }, //
      {220, "Augment Summoning", "At 2nd level, a thaumaturgist gains the Augment Summoning feat.", 0, "Ability"}, //
      {221, "Extended Summoning",
          "At 3rd level and higher, all spells from the summoning subschool that the thaumaturgist casts have their durations doubled, as if the Extend Spell feat had been applied to them. The levels of the summoning spells don't change, however. This ability stacks with the effect of the Extend Spell feat, which does change the spell's level.",
          0, "Ability"
      }, //
      {222, "Contingent Conjuration",
          "A 4th-level thaumaturgist can prepare a summoning or calling spell ahead of time to be triggered by some other event. This functions as described for the contingency spell, including having the thaumaturgist cast the summoning or calling spell beforehand. The spell is cast instantly when the trigger event occurs. <br/>The conditions needed to bring the spell into effect must be clear, although they can be general. If complicated or convoluted condition as are prescribed, the contingent conjuration may fail when triggered. The conjuration spell occurs based solely on the stated conditions, regardless of whether the thaumaturgist wants it to, although most conjurations can be dismissed normally. A thaumaturgist can have only one contingent conjuration active at a time.",
          0, "Ability"
      }, //
      {223, "Planar Cohort",
          "A 5th-level thaumaturgist can use any of the planar ally spells to call a creature to act as his cohort. The called creature serves loyally and well as long as the thaumaturgist continues to advance a cause important to the creature.<br/>To call a planar cohort, the thaumaturgist must cast the relevant spell, paying the XP costs normally. It takes an offering of 1,000 gp x the HD of the creature to convince it to serve as a planar cohort, and the improved ally class feature can't be used to reduce or eliminate this cost. The planar cohort can't have more Hit Dice than the thaumaturgist has, and must have an ECL no higher than the thaumaturgist's character level -2.<br/>A thaumaturgist can have only one planar cohort at a time, but he can continue to make agreements with other called creatures normally. A planar cohort replaces a thaumaturgist's existing cohort, if he has one by virtue of the Leadership feat.",
          0, "Ability"
      }, //
      {224, "Extra Feat", "1 extra feat at 1st level", 1, "ExtraFeatsAbility"}, //
      {225, "Extra Skill Points", "4 extra skill points at 1st level and 1 extra skill point at each additional level", 1,
          "ExtraSkillPointsAbility"
      }, //
      {226, "Ability Adjustment (+2 Con, -2 Cha)", "+2 Constitution, -2 Charisma", 1, "Ability"}, //
      {227, "Darkvision (60 feet)",
          "See up to 60 feet in the dark. Darkvision is black and white only, but it is otherwise like normal sight, can function just fine with no light at all.",
          1, "Ability"
      }, //
      {228, "Carry Heavy Load",
          "Dwarves can move at normal speed even when wearing medium or heavy armor or when carrying a medium or heavy load (unlike other creatures, whose speed is reduced in such situations)",
          1, "Ability"
      }, //
      {229, "Stonecunning",
          "+2 racial bonus on Search checks to notice unusual stonework. Within 10 feet of unusual stonework make a Search check. Can use the Search skill to find stonework traps. Can also intuit depth, sensing his approx. depth underground.",
          1, "Ability"
      }, //
      {230, "Weapon Familiarity (Dwarf)",
          "Dwarves may treat dwarven waraxes and dwarven urgroshes as martial weapons, rather than exotic weapons.", 1, "Ability"
      }, //
      {231, "Stability",
          "+4 bonus on ability checks made to resist being bull rushed or tripped when standing on the ground (but not when climbing, flying, riding, or otherwise not standing firmly on the ground).",
          1, "Ability"
      }, //
      {232, "Resist Poison", "+2 racial bonus on saving throws against poison.", 1, "Ability"}, //
      {233, "Resist Spells", "+2 racial bonus on saving throws against spells and spell-like effects.", 1, "Ability"}, //
      {234, "Animosity (Orcs and Goblinoids)", "+1 racial bonus on attack rolls against orcs and goblinoids.", 1, "Ability"}, //
      {235, "Armor Bonus (Giants)",
          "+4 dodge bonus to Armor Class against monsters of the giant type. Any time a creature loses its Dexterity bonus (if any) to Armor Class, such as when it is caught flat-footed, it loses its dodge bonus, too. ",
          1, "Ability"
      }, //
      {236, "Skill Bonus (Appraise stone or metal)", "+2 racial bonus on Appraise checks that are related to stone or metal items.",
          1, "Ability"
      }, //
      {237, "Skill Bonus (Craft stone or metal)", "+2 racial bonus on Craft checks that are related to stone or metal.", 1,
          "Ability"
      }, //
      {238, "Ability Adjustment (+2 Dex, -2 Con)", "+2 Dexterity, -2 Constitution.", 1, "Ability"}, //
      {239, "Resist Sleep",
          "Immunity to magic sleep effects, and a +2 racial saving throw bonus against enchantment spells or effects.", 1, "Ability"
      }, //
      {240, "Low-Light Vision",
          "See twice as far as a human in starlight, moonlight, torchlight, and similar conditions of poor illumination. Retains the ability to distinguish color and detail under these conditions.",
          1, "Ability"
      }, //
      {241, "Weapon Proficiency (Sword and Bow)",
          "Receive the Martial Weapon Proficiency feats for the longsword, rapier, longbow (including composite longbow), and shortbow (including composite shortbow) as bonus feats.",
          1, "Ability"
      }, //
      {242, "Skill Bonus (Listen, Search, Spot)",
          "+2 racial bonus on Listen, Search, and Spot checks. An elf who merely passes within 5 feet of a secret or concealed door is entitled to a Search check to notice it as if she were actively looking for it.",
          1, "Ability"
      }, //
      {243, "Ability Adjustment (+2 Con, -2 Str)", "+2 Constitution, -2 Strength", 1, "Ability"}, //
      {244, "Weapon Familiarity (Gnome)", "Gnomes may treat gnome hooked hammers as martial weapons rather than exotic weapons.", 1,
          "Ability"
      }, //
      {245, "Resist Illusion", "+2 racial bonus on saving throws against illusions.", 1, "Ability"}, //
      {246, "Improved Illusion",
          "+1 to the Difficulty Class for all saving throws against illusion spells cast by gnomes. This adjustment stacks with those from similar effects.",
          1, "Ability"
      }, //
      {247, "Animosity (Kobolds and Goblinoids)", "+1 racial bonus on attack rolls against kobolds and goblinoids.", 1, "Ability"},
      //
      {248, "Skill Bonus (Listen)", "+2 racial bonus on Listen checks.", 1, "Ability"}, //
      {249, "Skill Bonus (Alchemy)", "+2 racial bonus on Craft (alchemy) checks.", 1, "Ability"}, //
      {250, "Spell Bonus (Speak with Animal)", "1/day - speak with animals (burrowing mammal only, duration 1 minute)", 2,
          "Ability"
      }, //
      {251, "Spell Bonus (Illusion)",
          "1/day - dancing lights, ghost sound, prestidigitation. Caster level 1st save DC 10 + gnome Cha modifier + spell level.",
          2, "Ability"
      }, //
      {252, "Skill Bonus, lesser (Listen, Search, Spot)", "+1 racial bonus on Listen, Search, and Spot checks.", 1, "Ability"}, //
      {253, "Skill Bonus (Diplomacy, Gather Information)", "+2 racial bonus on Diplomacy and Gather Information checks.", 1,
          "Ability"
      }, //
      {254, "Elven Blood", "For all effects related to race, a half-elf is considered an elf.", 1, "Ability"}, //
      {255, "Ability Adjustment (+2 Str, -2 Int, -2 Cha)", "+2 Strength, -2 Intelligence, -2 Charisma", 1, "Ability"}, //
      {256, "Orc Blood", "For all effects related to race, a half-orc is considered an orc.", 1, "Ability"}, //
      {257, "Ability Adjustment (+2 Dex, -2 Str)", "+2 Dexterity, -2 Strength", 1, "Ability"}, //
      {258, "Skill Bonus (Climb, Jump, Move Silently)", "+2 racial bonus on Climb, Jump, and Move Silently checks.", 1, "Ability"},
      //
      {259, "Resist Misfortune, lesser", "+1 racial bonus on all saving throws.", 1, "Ability"}, //
      {260, "Resist Fear",
          "+2 morale bonus on saving throws against fear: This bonus stacks with the halfling +1 bonus on saving throws in general.",
          1, "Ability"
      }, //
      {261, "Weapon Proficiency (Thrown Weapons and Slings)", "+1 racial bonus on attack rolls with thrown weapons and slings.", 1,
          "Ability"
      }, //
      {263, "Resist Spells, greater", "+3 racial bonus on saving throws against spells and spell-like effects.", 1, "Ability"}, //
      {264, "Resist Poison, greater", "+3 racial bonus on saving throws against poison.", 1, "Ability"}, //
      {265, "Darkvision (90 feet)",
          "See up to 90 feet in the dark. Darkvision is black and white only, but it is otherwise like normal sight, can function just fine with no light at all.",
          1, "Ability"
      }, //
      {266, "Light Sensitivity", "Dazzled in bright sunlight or within the radius of a daylight spell.", 1, "Ability"}, //
      {267, "Ability Adjustment (+2 Con, -4 Cha)", "+2 Constitution, -4 Charisma", 1, "Ability"}, //
      {268, "Darkvision (120 feet)",
          "See up to 120 feet in the dark. Darkvision is black and white only, but it is otherwise like normal sight, can function just fine with no light at all.",
          1, "Ability"
      }, //
      {269, "Immunity", "Immunity to paralysis, phantasms, and poison", 1, "Ability"}, //
      {270, "Spell Bonus (Duergar)",
          "1/day - enlarge person and invisibility as a wizard of twice the duergar class level (minimum caster level 3rd) these abilities affect only the duergar and whatever it carries.",
          2, "Ability"
      }, //
      {271, "Skill Bonus (Move Silently)", "+4 racial bonus on Move Silently checks", 1, "Ability"}, //
      {272, "Skill Bonus (Listen and Spot)", "+1 racial bonus on Listen and Spot checks", 1, "Ability"}, //
      {273, "Ability Adjustment (+2 Dex, -2 Int)", "+2 Dexterity, -2 Intelligence", 1, "Ability"}, //
      {274, "Gills",
          "Aquatic elves can survive out of the water for 1 hour per point of Constitution (after that, refer to the suffocation rules)",
          1, "Ability"
      }, //
      {275, "Superior Low-Light Vision",
          "See four times as far as a human in starlight, moonlight, torchlight, and similar conditions of low illumination", 1,
          "Ability"
      }, //
      {276, "Poison",
          "An opponent hit by a poisoned weapon must succeed on a DC 13 Fortitude save or fall unconscious. After 1 minute, the subject must succeed on another DC 13 Fortitude save or remain unconscious for 2d4 hours.",
          1, "Ability"
      }, //
      {277, "Ability Adjustment (+2 Int, +2 Cha)", "+2 Intelligence, +2 Charisma", 1, "Ability"}, //
      {278, "Spell Resistance", "Spell resistance equal to 11 + class levels.", 1, "Ability"}, //
      {279, "Spell Bonus (Drow)", "1/day - dancing lights, darkness, faerie fire. Caster level equals class levels.", 2, "Ability"},
      //
      {280, "Weapon Proficiency (Sword and Crossbow)",
          "A drow is automatically proficient with the hand crossbow, the rapier, and the short sword.", 1, "Ability"
      }, //
      {281, "Light Blindness",
          "Abrupt exposure to bright light (such as sunlight or a daylight spell) blinds drow for 1 round. On subsequent rounds, they are dazzled as long as they remain in the affected area.",
          1, "Ability"
      }, //
      {282, "Ability Adjustment (+2 Int, -2 Str)", "+2 Intelligence, -2 Strength", 1, "Ability"}, //
      {283, "Ability Adjustment (+2 Dex, -2 Int)", "+2 Dexterity, -2 Intelligence", 1, "Ability"}, //
      {284, "Ability Adjustment (+2 Str, -2 Int)", "+2 Strength, -2 Intelligence", 1, "Ability"}, //
      {285, "Ability Adjustment (-2 Str, +2 Dex, +2 Wis, -4 Cha)", "-2 Strength, +2 Dexterity, +2 Wisdom, -4 Charisma", 1,
          "Ability"
      }, //
      {286, "Resist Misfortune", "+2 racial bonus on all saving throws", 1, "Ability"}, //
      {287, "Spell Bonus (Svirfneblin)",
          "1/day - blindness/deafness, blur, disguise self. Caster level equals the svirfneblin class levels. The save DC is Charisma-based and include a +4 racial modifier.",
          2, "Ability"
      }, //
      {288, "Spell Bonus (Nondetection)",
          "A svirfneblin has a continuous nondetection ability as the spell (caster level equal to class levels).", 3, "Ability"
      }, //
      {289, "Skill Bonus (Hide)", "+2 racial bonus on Hide checks, which improves to +4 underground.", 1, "Ability"}, //
      {290, "Spell Bonus (Forest Gnome)",
          "A forest gnome has the innate ability to use pass without trace (self only, as a free action) as the spell cast by a druid of the forest gnome class levels.",
          3, "Ability"
      }, //
      {291, "Animosity (Kobolds, Goblinoids, Orcs and Reptilian)",
          "+1 racial bonus on attack rolls against kobolds, goblinoids, orcs, and reptilian humanoids.", 1, "Ability"
      }, //
      {292, "Skill Bonus, greater (Hide)", "+4 racial bonus on Hide checks, which improves to +8 in a wooded area.", 1, "Ability"},
      //
      {293, "Skill Bonus (Search, Spot, Listen)",
          "+2 racial bonus on Search, Spot, and Listen checks. Like an elf, a tallfellow who merely passes within 5 feet of a secret or concealed door is entitled to a Search check as though actively looking for it.",
          1, "Ability"
      }, //
      {294, "Spells - Fire Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {295, "Spells - Air Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {296, "Spells - Good Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {297, "Spells - Healing Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {298, "Spells - Knowledge Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {299, "Spells - Law Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {300, "Spells - Luck Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {301, "Spells - Magic Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {302, "Spells - Plant Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {303, "Spells - Protection Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {304, "Spells - Strength Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {305, "Spells - Sun Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {306, "Spells - Travel Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {307, "Spells - Trickery Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {308, "Spells - War Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {309, "Spells - Water Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {310, "Spells - Evil Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {311, "Spells - Earth Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {312, "Spells - Destruction Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {313, "Spells - Death Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {314, "Spells - Chaos Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
      {315, "Spells - Animal Domain",
          "A cleric's deity influences his alignment, what magic he can perform, his values, and how others see him. A cleric chooses two domains from among those belonging to his deity. A cleric can select an alignment domain (Chaos, Evil, Good, or Law) only if his alignment matches that domain.<br/>If a cleric is not devoted to a particular deity, he still selects two domains to represent his spiritual inclinations and abilities. The restriction on alignment domains still applies.<br/>Each domain gives the cleric access to a domain spell at each spell level he can cast, from 1st on up, as well as a granted power. The cleric gets the granted powers of both the domains selected.<br/>With access to two domain spells at a given spell level, a cleric prepares one or the other each day in his domain spell slot. If a domain spell is not on the cleric spell list, a cleric can prepare it only in his domain spell slot.",
          0, "SpelllistAbility"
      }, //
  };

  /**
   * Ability Properties
   */
  public static final Object[][] ABILITY_PROPERTY = { //
      // ability_id, key, value
      {11, "spelllist_id", "7"}, //
      {11, "spell_attribute_id", "5"}, //
      {11, "casting_type_id", "0"}, //
      {11, "spell_source_id", "1"}, //
      {11, "spells_known_table_id", "1"}, //
      {11, "spells_per_day_table_id", "1"}, //
      {11, "attribute_bonus_spell_slots", "true"}, //
      {11, "school_id", "-1"}, //
      {23, "spelllist_id", "1"}, //
      {23, "spell_attribute_id", "4"}, //
      {23, "casting_type_id", "1"}, //
      {23, "spell_source_id", "0"}, //
      {23, "spells_known_table_id", "3"}, //
      {23, "spells_per_day_table_id", "4"}, //
      {23, "attribute_bonus_spell_slots", "true"}, //
      {23, "school_id", "-1"}, //
      {29, "spelllist_id", "2"}, //
      {29, "spell_attribute_id", "4"}, //
      {29, "casting_type_id", "1"}, //
      {29, "spell_source_id", "0"}, //
      {29, "spells_known_table_id", "3"}, //
      {29, "spells_per_day_table_id", "4"}, //
      {29, "attribute_bonus_spell_slots", "true"}, //
      {29, "school_id", "-1"}, //
      {72, "spelllist_id", "3"}, //
      {72, "spell_attribute_id", "4"}, //
      {72, "casting_type_id", "1"}, //
      {72, "spell_source_id", "0"}, //
      {72, "spells_known_table_id", "3"}, //
      {72, "spells_per_day_table_id", "2"}, //
      {72, "attribute_bonus_spell_slots", "true"}, //
      {72, "school_id", "-1"}, //
      {83, "spelllist_id", "4"}, //
      {83, "spell_attribute_id", "4"}, //
      {83, "casting_type_id", "1"}, //
      {83, "spell_source_id", "0"}, //
      {83, "spells_known_table_id", "3"}, //
      {83, "spells_per_day_table_id", "2"}, //
      {83, "attribute_bonus_spell_slots", "true"}, //
      {83, "school_id", "-1"}, //
      {103, "spelllist_id", "6"}, //
      {103, "spell_attribute_id", "5"}, //
      {103, "casting_type_id", "0"}, //
      {103, "spell_source_id", "1"}, //
      {103, "spells_known_table_id", "2"}, //
      {103, "spells_per_day_table_id", "3"}, //
      {103, "attribute_bonus_spell_slots", "true"}, //
      {103, "school_id", "-1"}, //
      {105, "spelllist_id", "5"}, //
      {105, "spell_attribute_id", "3"}, //
      {105, "casting_type_id", "1"}, //
      {105, "spell_source_id", "1"}, //
      {105, "spells_known_table_id", "3"}, //
      {105, "spells_per_day_table_id", "4"}, //
      {105, "attribute_bonus_spell_slots", "true"}, //
      {105, "school_id", "-1"}, //
      {111, "spelllist_id", "5"}, //
      {111, "spell_attribute_id", "3"}, //
      {111, "casting_type_id", "1"}, //
      {111, "spell_source_id", "1"}, //
      {111, "spells_known_table_id", "3"}, //
      {111, "spells_per_day_table_id", "8"}, //
      {111, "attribute_bonus_spell_slots", "false"}, //
      {111, "school_id", "0"}, //
      {112, "spelllist_id", "5"}, //
      {112, "spell_attribute_id", "3"}, //
      {112, "casting_type_id", "1"}, //
      {112, "spell_source_id", "1"}, //
      {112, "spells_known_table_id", "3"}, //
      {112, "spells_per_day_table_id", "8"}, //
      {112, "attribute_bonus_spell_slots", "false"}, //
      {112, "school_id", "1"}, //
      {113, "spelllist_id", "5"}, //
      {113, "spell_attribute_id", "3"}, //
      {113, "casting_type_id", "1"}, //
      {113, "spell_source_id", "1"}, //
      {113, "spells_known_table_id", "3"}, //
      {113, "spells_per_day_table_id", "8"}, //
      {113, "attribute_bonus_spell_slots", "false"}, //
      {113, "school_id", "2"}, //
      {114, "spelllist_id", "5"}, //
      {114, "spell_attribute_id", "3"}, //
      {114, "casting_type_id", "1"}, //
      {114, "spell_source_id", "1"}, //
      {114, "spells_known_table_id", "3"}, //
      {114, "spells_per_day_table_id", "8"}, //
      {114, "attribute_bonus_spell_slots", "false"}, //
      {114, "school_id", "3"}, //
      {115, "spelllist_id", "5"}, //
      {115, "spell_attribute_id", "3"}, //
      {115, "casting_type_id", "1"}, //
      {115, "spell_source_id", "1"}, //
      {115, "spells_known_table_id", "3"}, //
      {115, "spells_per_day_table_id", "8"}, //
      {115, "attribute_bonus_spell_slots", "false"}, //
      {115, "school_id", "4"}, //
      {116, "spelllist_id", "5"}, //
      {116, "spell_attribute_id", "3"}, //
      {116, "casting_type_id", "1"}, //
      {116, "spell_source_id", "1"}, //
      {116, "spells_known_table_id", "3"}, //
      {116, "spells_per_day_table_id", "8"}, //
      {116, "attribute_bonus_spell_slots", "false"}, //
      {116, "school_id", "5"}, //
      {117, "spelllist_id", "5"}, //
      {117, "spell_attribute_id", "3"}, //
      {117, "casting_type_id", "1"}, //
      {117, "spell_source_id", "1"}, //
      {117, "spells_known_table_id", "3"}, //
      {117, "spells_per_day_table_id", "8"}, //
      {117, "attribute_bonus_spell_slots", "false"}, //
      {117, "school_id", "6"}, //
      {118, "spelllist_id", "5"}, //
      {118, "spell_attribute_id", "3"}, //
      {118, "casting_type_id", "1"}, //
      {118, "spell_source_id", "1"}, //
      {118, "spells_known_table_id", "3"}, //
      {118, "spells_per_day_table_id", "8"}, //
      {118, "attribute_bonus_spell_slots", "false"}, //
      {118, "school_id", "7"}, //
      {119, "spelllist_id", "5"}, //
      {119, "spell_attribute_id", "3"}, //
      {119, "casting_type_id", "1"}, //
      {119, "spell_source_id", "1"}, //
      {119, "spells_known_table_id", "3"}, //
      {119, "spells_per_day_table_id", "8"}, //
      {119, "attribute_bonus_spell_slots", "false"}, //
      {119, "school_id", "8"}, //
      {140, "spelllist_id", "30"}, //
      {140, "spell_attribute_id", "3"}, //
      {140, "casting_type_id", "0"}, //
      {140, "spell_source_id", "1"}, //
      {140, "spells_known_table_id", "4"}, //
      {140, "spells_per_day_table_id", "5"}, //
      {140, "attribute_bonus_spell_slots", "true"}, //
      {140, "school_id", "-1"}, //
      {146, "spelllist_id", "31"}, //
      {146, "spell_attribute_id", "4"}, //
      {146, "casting_type_id", "1"}, //
      {146, "spell_source_id", "0"}, //
      {146, "spells_known_table_id", "3"}, //
      {146, "spells_per_day_table_id", "6"}, //
      {146, "attribute_bonus_spell_slots", "true"}, //
      {146, "school_id", "-1"}, //
      {224, "number_of_extra_feats", "1"}, //
      {225, "number_of_skill_points", "1"}, //
      {294, "spelllist_id", "8"}, //
      {294, "spell_attribute_id", "4"}, //
      {294, "casting_type_id", "1"}, //
      {294, "spell_source_id", "0"}, //
      {294, "spells_known_table_id", "3"}, //
      {294, "spells_per_day_table_id", "7"}, //
      {294, "attribute_bonus_spell_slots", "false"}, //
      {294, "school_id", "-1"}, //
      {295, "spelllist_id", "9"}, //
      {295, "spell_attribute_id", "4"}, //
      {295, "casting_type_id", "1"}, //
      {295, "spell_source_id", "0"}, //
      {295, "spells_known_table_id", "3"}, //
      {295, "spells_per_day_table_id", "7"}, //
      {295, "attribute_bonus_spell_slots", "false"}, //
      {295, "school_id", "-1"}, //
      {296, "spelllist_id", "10"}, //
      {296, "spell_attribute_id", "4"}, //
      {296, "casting_type_id", "1"}, //
      {296, "spell_source_id", "0"}, //
      {296, "spells_known_table_id", "3"}, //
      {296, "spells_per_day_table_id", "7"}, //
      {296, "attribute_bonus_spell_slots", "false"}, //
      {296, "school_id", "-1"}, //
      {297, "spelllist_id", "11"}, //
      {297, "spell_attribute_id", "4"}, //
      {297, "casting_type_id", "1"}, //
      {297, "spell_source_id", "0"}, //
      {297, "spells_known_table_id", "3"}, //
      {297, "spells_per_day_table_id", "7"}, //
      {297, "attribute_bonus_spell_slots", "false"}, //
      {297, "school_id", "-1"}, //
      {298, "spelllist_id", "12"}, //
      {298, "spell_attribute_id", "4"}, //
      {298, "casting_type_id", "1"}, //
      {298, "spell_source_id", "0"}, //
      {298, "spells_known_table_id", "3"}, //
      {298, "spells_per_day_table_id", "7"}, //
      {298, "attribute_bonus_spell_slots", "false"}, //
      {298, "school_id", "-1"}, //
      {299, "spelllist_id", "13"}, //
      {299, "spell_attribute_id", "4"}, //
      {299, "casting_type_id", "1"}, //
      {299, "spell_source_id", "0"}, //
      {299, "spells_known_table_id", "3"}, //
      {299, "spells_per_day_table_id", "7"}, //
      {299, "attribute_bonus_spell_slots", "false"}, //
      {299, "school_id", "-1"}, //
      {300, "spelllist_id", "14"}, //
      {300, "spell_attribute_id", "4"}, //
      {300, "casting_type_id", "1"}, //
      {300, "spell_source_id", "0"}, //
      {300, "spells_known_table_id", "3"}, //
      {300, "spells_per_day_table_id", "7"}, //
      {300, "attribute_bonus_spell_slots", "false"}, //
      {300, "school_id", "-1"}, //
      {301, "spelllist_id", "15"}, //
      {301, "spell_attribute_id", "4"}, //
      {301, "casting_type_id", "1"}, //
      {301, "spell_source_id", "0"}, //
      {301, "spells_known_table_id", "3"}, //
      {301, "spells_per_day_table_id", "7"}, //
      {301, "attribute_bonus_spell_slots", "false"}, //
      {301, "school_id", "-1"}, //
      {302, "spelllist_id", "16"}, //
      {302, "spell_attribute_id", "4"}, //
      {302, "casting_type_id", "1"}, //
      {302, "spell_source_id", "0"}, //
      {302, "spells_known_table_id", "3"}, //
      {302, "spells_per_day_table_id", "7"}, //
      {302, "attribute_bonus_spell_slots", "false"}, //
      {302, "school_id", "-1"}, //
      {303, "spelllist_id", "17"}, //
      {303, "spell_attribute_id", "4"}, //
      {303, "casting_type_id", "1"}, //
      {303, "spell_source_id", "0"}, //
      {303, "spells_known_table_id", "3"}, //
      {303, "spells_per_day_table_id", "7"}, //
      {303, "attribute_bonus_spell_slots", "false"}, //
      {303, "school_id", "-1"}, //
      {304, "spelllist_id", "18"}, //
      {304, "spell_attribute_id", "4"}, //
      {304, "casting_type_id", "1"}, //
      {304, "spell_source_id", "0"}, //
      {304, "spells_known_table_id", "3"}, //
      {304, "spells_per_day_table_id", "7"}, //
      {304, "attribute_bonus_spell_slots", "false"}, //
      {304, "school_id", "-1"}, //
      {305, "spelllist_id", "19"}, //
      {305, "spell_attribute_id", "4"}, //
      {305, "casting_type_id", "1"}, //
      {305, "spell_source_id", "0"}, //
      {305, "spells_known_table_id", "3"}, //
      {305, "spells_per_day_table_id", "7"}, //
      {305, "attribute_bonus_spell_slots", "false"}, //
      {305, "school_id", "-1"}, //
      {306, "spelllist_id", "20"}, //
      {306, "spell_attribute_id", "4"}, //
      {306, "casting_type_id", "1"}, //
      {306, "spell_source_id", "0"}, //
      {306, "spells_known_table_id", "3"}, //
      {306, "spells_per_day_table_id", "7"}, //
      {306, "attribute_bonus_spell_slots", "false"}, //
      {306, "school_id", "-1"}, //
      {307, "spelllist_id", "21"}, //
      {307, "spell_attribute_id", "4"}, //
      {307, "casting_type_id", "1"}, //
      {307, "spell_source_id", "0"}, //
      {307, "spells_known_table_id", "3"}, //
      {307, "spells_per_day_table_id", "7"}, //
      {307, "attribute_bonus_spell_slots", "false"}, //
      {307, "school_id", "-1"}, //
      {308, "spelllist_id", "22"}, //
      {308, "spell_attribute_id", "4"}, //
      {308, "casting_type_id", "1"}, //
      {308, "spell_source_id", "0"}, //
      {308, "spells_known_table_id", "3"}, //
      {308, "spells_per_day_table_id", "7"}, //
      {308, "attribute_bonus_spell_slots", "false"}, //
      {308, "school_id", "-1"}, //
      {309, "spelllist_id", "23"}, //
      {309, "spell_attribute_id", "4"}, //
      {309, "casting_type_id", "1"}, //
      {309, "spell_source_id", "0"}, //
      {309, "spells_known_table_id", "3"}, //
      {309, "spells_per_day_table_id", "7"}, //
      {309, "attribute_bonus_spell_slots", "false"}, //
      {309, "school_id", "-1"}, //
      {310, "spelllist_id", "24"}, //
      {310, "spell_attribute_id", "4"}, //
      {310, "casting_type_id", "1"}, //
      {310, "spell_source_id", "0"}, //
      {310, "spells_known_table_id", "3"}, //
      {310, "spells_per_day_table_id", "7"}, //
      {310, "attribute_bonus_spell_slots", "false"}, //
      {310, "school_id", "-1"}, //
      {311, "spelllist_id", "25"}, //
      {311, "spell_attribute_id", "4"}, //
      {311, "casting_type_id", "1"}, //
      {311, "spell_source_id", "0"}, //
      {311, "spells_known_table_id", "3"}, //
      {311, "spells_per_day_table_id", "7"}, //
      {311, "attribute_bonus_spell_slots", "false"}, //
      {311, "school_id", "-1"}, //
      {312, "spelllist_id", "26"}, //
      {312, "spell_attribute_id", "4"}, //
      {312, "casting_type_id", "1"}, //
      {312, "spell_source_id", "0"}, //
      {312, "spells_known_table_id", "3"}, //
      {312, "spells_per_day_table_id", "7"}, //
      {312, "attribute_bonus_spell_slots", "false"}, //
      {312, "school_id", "-1"}, //
      {313, "spelllist_id", "27"}, //
      {313, "spell_attribute_id", "4"}, //
      {313, "casting_type_id", "1"}, //
      {313, "spell_source_id", "0"}, //
      {313, "spells_known_table_id", "3"}, //
      {313, "spells_per_day_table_id", "7"}, //
      {313, "attribute_bonus_spell_slots", "false"}, //
      {313, "school_id", "-1"}, //
      {314, "spelllist_id", "28"}, //
      {314, "spell_attribute_id", "4"}, //
      {314, "casting_type_id", "1"}, //
      {314, "spell_source_id", "0"}, //
      {314, "spells_known_table_id", "3"}, //
      {314, "spells_per_day_table_id", "7"}, //
      {314, "attribute_bonus_spell_slots", "false"}, //
      {314, "school_id", "-1"}, //
      {315, "spelllist_id", "29"}, //
      {315, "spell_attribute_id", "4"}, //
      {315, "casting_type_id", "1"}, //
      {315, "spell_source_id", "0"}, //
      {315, "spells_known_table_id", "3"}, //
      {315, "spells_per_day_table_id", "7"}, //
      {315, "attribute_bonus_spell_slots", "false"}, //
      {315, "school_id", "-1"}, //
  };

}
