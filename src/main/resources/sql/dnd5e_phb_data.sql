INSERT INTO sex VALUES(0,'Male');
INSERT INTO sex VALUES(1,'Female');


INSERT INTO alignment VALUES(0,'Lawful Good');
INSERT INTO alignment VALUES(1,'Neutral Good');
INSERT INTO alignment VALUES(2,'Chaotic Good');
INSERT INTO alignment VALUES(3,'Lawful Neutral');
INSERT INTO alignment VALUES(4,'Neutral');
INSERT INTO alignment VALUES(5,'Chaotic Neutral');
INSERT INTO alignment VALUES(6,'Lawful Evil');
INSERT INTO alignment VALUES(7,'Neutral Evil');
INSERT INTO alignment VALUES(8,'Chaotic Evil');


INSERT INTO attribute VALUES (0,'Strength');
INSERT INTO attribute VALUES (1,'Dexterity');
INSERT INTO attribute VALUES (2,'Constitution');
INSERT INTO attribute VALUES (3,'Intelligence');
INSERT INTO attribute VALUES (4,'Wisdom');
INSERT INTO attribute VALUES (5,'Charisma');

-- INSERT INTO save VALUES (0,'Fortitude');


INSERT INTO size VALUES (0,'Fine');
INSERT INTO size VALUES (1,'Diminutive');
INSERT INTO size VALUES (2,'Tiny');
INSERT INTO size VALUES (3,'Small');
INSERT INTO size VALUES (4,'Medium');
INSERT INTO size VALUES (5,'Large (tall)');
INSERT INTO size VALUES (6,'Large (long)');
INSERT INTO size VALUES (7,'Huge (tall)');
INSERT INTO size VALUES (8,'Huge (long)');
INSERT INTO size VALUES (9,'Gargantuan (tall)');
INSERT INTO size VALUES (10,'Gargantuan (long)');
INSERT INTO size VALUES (11,'Colossal (tall)');
INSERT INTO size VALUES (12,'Colossal (long)');


INSERT INTO xp_table VALUES (1, 'Normal');


INSERT INTO xp_level VALUES (1, 1, 1, 0);
INSERT INTO xp_level VALUES (2, 1, 2, 300);
INSERT INTO xp_level VALUES (3, 1, 3, 900);
INSERT INTO xp_level VALUES (4, 1, 4, 2700);
INSERT INTO xp_level VALUES (5, 1, 5, 6500);
INSERT INTO xp_level VALUES (6, 1, 6, 14000);
INSERT INTO xp_level VALUES (7, 1, 7, 23000);
INSERT INTO xp_level VALUES (8, 1, 8, 34000);
INSERT INTO xp_level VALUES (9, 1, 9, 48000);
INSERT INTO xp_level VALUES (10, 1, 10, 64000);
INSERT INTO xp_level VALUES (11, 1, 11, 85000);
INSERT INTO xp_level VALUES (12, 1, 12, 100000);
INSERT INTO xp_level VALUES (13, 1, 13, 120000);
INSERT INTO xp_level VALUES (14, 1, 14, 140000);
INSERT INTO xp_level VALUES (15, 1, 15, 165000);
INSERT INTO xp_level VALUES (16, 1, 16, 195000);
INSERT INTO xp_level VALUES (17, 1, 17, 225000);
INSERT INTO xp_level VALUES (18, 1, 18, 265000);
INSERT INTO xp_level VALUES (19, 1, 19, 305000);
INSERT INTO xp_level VALUES (20, 1, 20, 355000);


INSERT INTO race VALUES (1, 'Human', 4, 30, -1 );
INSERT INTO race VALUES (2, 'Dragonborn', 4, 30, -1 );
INSERT INTO race VALUES (3, 'Dwarf', 4, 25, -1 );
INSERT INTO race VALUES (4, 'Elf', 4, 30, -1 );
INSERT INTO race VALUES (5, 'Gnome', 3, 25, -1 );
INSERT INTO race VALUES (6, 'Half-Elf', 4, 30, -1 );
INSERT INTO race VALUES (7, 'Half-Orc', 4, 30, -1 );
INSERT INTO race VALUES (8, 'Halfling', 3, 25, -1 );
INSERT INTO race VALUES (9, 'Tiefling', 4, 30, -1 );


INSERT INTO ability_type VALUES (0, 'Natural');
INSERT INTO ability_type VALUES (1, 'Extraordinary');
INSERT INTO ability_type VALUES (2, 'Spell-like');
INSERT INTO ability_type VALUES (3, 'Supernatural');


INSERT INTO ability VALUES ( 1, 'Ability Score Increase (Human)', 'Your ability scores each increase by 1.', 0, 'Ability' );
INSERT INTO ability VALUES ( 2, 'Ability Score Increase (Dragonborn)', 'Your Strength score increases by 2, and your Charisma score increases by 1.', 0, 'Ability' );
INSERT INTO ability VALUES ( 3, 'Draconic Ancestry', 'You have draconic ancestry. Choose one type of dragon from the Draconic Ancestry table. Your breath weapon and damage resistance are determined by the dragon type, as shown in the table.', 0, 'Ability' );
INSERT INTO ability VALUES ( 4, 'Breath Weapon', 'You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation. When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful Not for resale. Permission granted to print or photocopy this document for personal use only. System Reference Document 5.1 6 one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level. After you use your breath weapon, you can’t use it again until you complete a short or long rest.', 0, 'Ability' );
INSERT INTO ability VALUES ( 5, 'Damage Resistance', 'You have resistance to the damage type associated with your draconic ancestry.', 0, 'Ability' );
INSERT INTO ability VALUES ( 6, 'Ability Score Increase (Dwarf)', 'Your Constitution score increases by 2', 0, 'Ability' );
INSERT INTO ability VALUES ( 7, 'Darkvision', 'Accustomed to life underground, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can''t discern color in darkness, only shades of gray.', 0, 'Ability' );
INSERT INTO ability VALUES ( 8, 'Dwarven Resilience', 'You have advantage on saving throws against poison, and you have resistance against poison damage.', 0, 'Ability' );
INSERT INTO ability VALUES ( 9, 'Dwarven Combat Training', 'You have proficiency with the battleaxe, handaxe, light hammer, and warhammer.', 0, 'Ability' );
INSERT INTO ability VALUES ( 10, 'Tool Proficiency', 'You gain proficiency with the artisan''s tools of your choice: smith''s tools, brewer''s supplies, or mason''s tools.', 0, 'Ability' );
INSERT INTO ability VALUES ( 11, 'Stonecunning', 'Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.', 0, 'Ability' );
INSERT INTO ability VALUES ( 12, 'Ability Score Increase (Elf)', 'Your Dexterity score increases by 2.', 0, 'Ability' );
INSERT INTO ability VALUES ( 13, 'Keen Senses', 'You have proficiency in the Perception skill.', 0, 'Ability' );
INSERT INTO ability VALUES ( 14, 'Fey Ancestry', 'You have advantage on saving throws against being charmed, and magic can''t put you to sleep.', 0, 'Ability' );
INSERT INTO ability VALUES ( 15, 'Trance', 'Elves don''t need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for such meditation is "trance.") While meditating, you can dream after a fashion, such dreams are actually mental exercises that have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep.', 0, 'Ability' );
INSERT INTO ability VALUES ( 16, 'Ability Score Increase (Gnome)', 'Your Intelligence score increases by 2', 0, 'Ability' );
INSERT INTO ability VALUES ( 17, 'Gnome Cunning', 'You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.', 0, 'Ability' );
INSERT INTO ability VALUES ( 18, 'Ability Score Increase (Half-Efl)', 'Your Charisma score increases by 2, and two other ability scores of your choice increase by 1', 0, 'Ability' );
INSERT INTO ability VALUES ( 19, 'Skill Versatility', 'You gain proficiency in two skills of your choice.', 0, 'Ability' );
INSERT INTO ability VALUES ( 20, 'Ability Score Increase (Half-Orc)', 'Your Strength score increases by 2, and your Constitution score increases by 1.', 0, 'Ability' );
INSERT INTO ability VALUES ( 21, 'Menacing', 'You gain proficiency in the Intimidation skill.', 0, 'Ability' );
INSERT INTO ability VALUES ( 22, 'Relentless Endurance', 'When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can''t use this feature again until you finish a long rest.', 0, 'Ability' );
INSERT INTO ability VALUES ( 23, 'Savage Attacks', 'When you score a critical hit with a melee weapon attack, you can roll one of the weapon''s damage dice one additional time and add it to the extra damage of the critical hit.', 0, 'Ability' );
INSERT INTO ability VALUES ( 24, 'Ability Score Increase (Halfling)', 'Your Dexterity score increases by 2.', 0, 'Ability' );
INSERT INTO ability VALUES ( 25, 'Lucky', 'When you roll a 1 on the d20 for an attack roll, ability check, or saving throw, you can reroll the die and must use the new roll.', 0, 'Ability' );
INSERT INTO ability VALUES ( 26, 'Brave', 'You have advantage on saving throws against being frightened.', 0, 'Ability' );
INSERT INTO ability VALUES ( 27, 'Halfling Nimbleness', 'You can move through the space of any creature that is of a size larger than yours.', 0, 'Ability' );
INSERT INTO ability VALUES ( 28, 'Ability Score Increase (Tiefling)', 'Your Intelligence score increases by 1, and your Charisma score increases by 2.', 0, 'Ability' );
INSERT INTO ability VALUES ( 29, 'Hellish Resistance', 'You have resistance to fire damage.', 0, 'Ability' );
INSERT INTO ability VALUES ( 30, 'Infernal Legacy', 'You know the thaumaturgy cantrip. When you reach 3rd level, you can cast the hellish rebuke spell as a 2nd-level spell once with this trait and regain the ability to do so when you finish a long rest. When you reach 5th level, you can cast the darkness spell once with this trait and regain the ability to do so when you finish a long rest. Charisma is your spellcasting ability for these spells.', 0, 'Ability' );


--INSERT INTO ability_property VALUES (11, 'spelllist_id', '7' );


INSERT INTO race_ability VALUES (1, 1);
INSERT INTO race_ability VALUES (2, 2);
INSERT INTO race_ability VALUES (2, 3);
INSERT INTO race_ability VALUES (2, 4);
INSERT INTO race_ability VALUES (2, 5);
INSERT INTO race_ability VALUES (3, 6);
INSERT INTO race_ability VALUES (3, 7);
INSERT INTO race_ability VALUES (3, 8);
INSERT INTO race_ability VALUES (3, 9);
INSERT INTO race_ability VALUES (3, 10);
INSERT INTO race_ability VALUES (3, 11);
INSERT INTO race_ability VALUES (4, 7);
INSERT INTO race_ability VALUES (4, 12);
INSERT INTO race_ability VALUES (4, 13);
INSERT INTO race_ability VALUES (4, 14);
INSERT INTO race_ability VALUES (4, 15);
INSERT INTO race_ability VALUES (5, 7);
INSERT INTO race_ability VALUES (5, 16);
INSERT INTO race_ability VALUES (5, 17);
INSERT INTO race_ability VALUES (6, 7);
INSERT INTO race_ability VALUES (6, 14);
INSERT INTO race_ability VALUES (6, 18);
INSERT INTO race_ability VALUES (6, 19);
INSERT INTO race_ability VALUES (7, 7);
INSERT INTO race_ability VALUES (7, 20);
INSERT INTO race_ability VALUES (7, 21);
INSERT INTO race_ability VALUES (7, 22);
INSERT INTO race_ability VALUES (7, 23);
INSERT INTO race_ability VALUES (8, 24);
INSERT INTO race_ability VALUES (8, 25);
INSERT INTO race_ability VALUES (8, 26);
INSERT INTO race_ability VALUES (8, 27);
INSERT INTO race_ability VALUES (9, 7);
INSERT INTO race_ability VALUES (9, 28);
INSERT INTO race_ability VALUES (9, 29);
INSERT INTO race_ability VALUES (9, 30);



--INSERT INTO skill VALUES ( 1, 'Appraise', '<b>Check:</b> You can appraise common or well-known objects with a DC 12 Appraise check. Failure means that you estimate the value at 50% to 150% (2d6+3 times 10%,) of its actual value.<br/>Appraising a rare or exotic item requires a successful check against DC 15, 20, or higher. If the check is successful, you estimate the value correctly, failure means you cannot estimate the item''s value. <br/>A magnifying glass gives you a +2 circumstance bonus on Appraise checks involving any item that is small or highly detailed, such as a gem. A merchant''s scale gives you a +2 circumstance bonus on Appraise checks involving any items that are valued by weight, including anything made of precious metals. <br/>These bonuses stack. <br/><b>Action:</b> Appraising an item takes 1 minute (ten consecutive full-round actions). <br/><b>Try Again:</b> No. You cannot try again on the same object, regardless of success. <br/><b>Special:</b> A dwarf gets a +2 racial bonus on Appraise checks that are related to stone or metal items because dwarves are familiar with valuable items of all kinds (especially those made of stone or metal). <br/>The master of a raven familiar gains a +3 bonus on Appraise checks. <br/>A character with the Diligent feat gets a +2 bonus on Appraise checks. <br/><b>Synergy:</b> If you have 5 ranks in any Craft skill, you gain a +2 bonus on Appraise checks related to items made with that Craft skill. <br/><b>Untrained:</b> For common items, failure on an untrained check means no estimate. For rare items, success means an estimate of 50% to 150% (2d6+3 times 10%).', 3, 1 );


INSERT INTO class VALUES (1, 'Barbarian', -1, -1, 0, -1, 6 );
INSERT INTO class VALUES (2, 'Bard', -1, -1, 0, -1, 4 );
INSERT INTO class VALUES (3, 'Cleric', -1, -1, 0, -1, 4 );
INSERT INTO class VALUES (4, 'Druid', -1, -1, 0, -1, 4 );
INSERT INTO class VALUES (5, 'Fighter', -1, -1, 0, -1, 5 );
INSERT INTO class VALUES (6, 'Monk', -1, -1, 0, -1, 4 );
INSERT INTO class VALUES (7, 'Paladin', -1, -1, 0, -1, 5 );
INSERT INTO class VALUES (8, 'Ranger', -1, -1, 0, -1, 5 );
INSERT INTO class VALUES (9, 'Rogue', -1, -1, 0, -1, 4 );
INSERT INTO class VALUES (10, 'Sorcerer', -1, -1, 0, -1, 3 );
INSERT INTO class VALUES (11, 'Warlock', -1, -1, 0, -1, 4 );
INSERT INTO class VALUES (12, 'Wizard', -1, -1, 0, -1, 3 );


--INSERT INTO class_skill VALUES (0, 4);


--INSERT INTO class_ability VALUES ( 0, 0, 1 );


INSERT INTO feat_type VALUES (0,'General');
INSERT INTO feat_type VALUES (1,'Item Creation');
INSERT INTO feat_type VALUES (2,'Metamagic');


--INSERT INTO feat VALUES ( 1, 'Acrobatic', '', '+2 bonus on Jump and Tumble checks', 0, 0, 0, 0, 0 );


INSERT INTO die VALUES (0, 'D2');
INSERT INTO die VALUES (1, 'D3');
INSERT INTO die VALUES (2, 'D4');
INSERT INTO die VALUES (3, 'D6');
INSERT INTO die VALUES (4, 'D8');
INSERT INTO die VALUES (5, 'D10');
INSERT INTO die VALUES (6, 'D12');
INSERT INTO die VALUES (7, 'D20');
INSERT INTO die VALUES (8, 'D100');


INSERT INTO quality_type VALUES (0, 'Normal');
INSERT INTO quality_type VALUES (1, 'Masterwork');
INSERT INTO quality_type VALUES (2, 'Magic');


INSERT INTO weapon_type VALUES(0,'Simple');
INSERT INTO weapon_type VALUES(1,'Martial');
INSERT INTO weapon_type VALUES(2,'Exotic');
INSERT INTO weapon_type VALUES(3,'Ammo');


INSERT INTO combat_type VALUES (0, 'Melee Weapon');
INSERT INTO combat_type VALUES (1, 'Ranged Weapon');


INSERT INTO weapon_encumbrance VALUES (0, 'Light Melee Weapon');
INSERT INTO weapon_encumbrance VALUES (1, 'One-Handed Melee Weapon');
INSERT INTO weapon_encumbrance VALUES (2, 'Two-Handed Melee Weapon');
INSERT INTO weapon_encumbrance VALUES (3, 'Light Ranged Weapon');
INSERT INTO weapon_encumbrance VALUES (4, 'One-Handed Ranged Weapon');
INSERT INTO weapon_encumbrance VALUES (5, 'Two-Handed Ranged Weapon');


INSERT INTO weapon_category VALUES (0, 'Normal Weapon');
INSERT INTO weapon_category VALUES (1, 'Reach Weapon');
INSERT INTO weapon_category VALUES (2, 'Double Weapon');
INSERT INTO weapon_category VALUES (3, 'Thrown Weapon');
INSERT INTO weapon_category VALUES (4, 'Projectile Weapon');
INSERT INTO weapon_category VALUES (5, 'Ammunition');


--INSERT INTO weapon_family VALUES (1, 'Unarmed strike' );


INSERT INTO attack_wield VALUES (0, 'Normal Weapon' );
INSERT INTO attack_wield VALUES (1, 'Reach  Weapon' );
INSERT INTO attack_wield VALUES (2, 'Double Weapon' );
INSERT INTO attack_wield VALUES (3, 'Thrown Weapon' );
INSERT INTO attack_wield VALUES (4, 'Projectile Weapon' );
INSERT INTO attack_wield VALUES (5, 'Ammunition' );


INSERT INTO armor_type VALUES(0,'Light');
INSERT INTO armor_type VALUES(1,'Medium');
INSERT INTO armor_type VALUES(2,'Heavy');
INSERT INTO armor_type VALUES(3,'Shield');


INSERT INTO good_type VALUES(0,'Adventuring Gear');
INSERT INTO good_type VALUES(1,'Special Substance');
INSERT INTO good_type VALUES(2,'Special Item');
INSERT INTO good_type VALUES(3,'Tool Kit');
INSERT INTO good_type VALUES(4,'Skill Kit');
INSERT INTO good_type VALUES(5,'Clothing');
INSERT INTO good_type VALUES(6,'Mount');
INSERT INTO good_type VALUES(7,'Mount Gear');


--INSERT INTO weapon VALUES ( 0, 'Gauntlet', 'This metal glove lets you deal lethal damage rather than nonlethal damage with unarmed strikes. A strike with a gauntlet is otherwise considered an unarmed attack. The cost and weight given are for a single gauntlet. Medium and heavy armors (except breastplate) come with gauntlets.', 2, 1, 1, 1, 0, 20, 2, 0, 0, 0, 0, 0, 1, 0 );


--INSERT INTO armor VALUES ( 0, 'Padded', '', 5, 10, 1, 0, 0, 0 );


--INSERT INTO good VALUES (0, 'Backpack', 'A backpack is a leather pack carried on the back, typically with straps to secure it.', 2, 2, 0, 0 );
