UPDATE ability SET name = 'Ability Score Increase (Cha +2. Two other ability scores of your choice increase by 1)' WHERE id = 18;
UPDATE ability SET name = 'Ability Score Increase (Con +2)' WHERE id = 6;
UPDATE ability SET name = 'Ability Score Increase (Dex +2)' WHERE id = 12;
UPDATE ability SET name = 'Ability Score Increase (Dex +2)' WHERE id = 24;
UPDATE ability SET name = 'Ability Score Increase (Int +1, Cha +2)' WHERE id = 28;
UPDATE ability SET name = 'Ability Score Increase (Int +2)' WHERE id = 16;
UPDATE ability SET name = 'Ability Score Increase (Str +1, Dex +1, Con +1, Int +1, Wis +1, Cha +1)' WHERE id = 1;
UPDATE ability SET name = 'Ability Score Increase (Str +2, Cha +1)' WHERE id = 2;
UPDATE ability SET name = 'Ability Score Increase (Str +2, Con +1)' WHERE id = 20;


UPDATE ability SET description = 'Charisma +2. Two other ability scores of your choice increase by 1.' WHERE id = 18;
UPDATE ability SET description = 'Constitution +2.' WHERE id = 6;
UPDATE ability SET description = 'Dexterity +2.' WHERE id = 12;
UPDATE ability SET description = 'Dexterity +2.' WHERE id = 24;
UPDATE ability SET description = 'Intelligence +1, Charisma +2.' WHERE id = 28;
UPDATE ability SET description = 'Intelligence +2.' WHERE id = 16;
UPDATE ability SET description = 'Strength +1, Dexterity +1, Constitution +1, Intelligence +1, Wisdom +1, Charisma +1.' WHERE id = 1;
UPDATE ability SET description = 'Strength +2, Charisma +1.' WHERE id = 2;
UPDATE ability SET description = 'Strength +2, Constitution +1.' WHERE id = 20;


UPDATE image SET id = id + 36 WHERE id > 3;
UPDATE charakter SET image_id = image_id + 36 WHERE image_id > 3;
UPDATE charakter SET thumb_image_id = thumb_image_id + 36 WHERE thumb_image_id > 3;
ALTER TABLE race ADD COLUMN image_id INTEGER NOT NULL DEFAULT 0;


UPDATE race SET image_id = 22 WHERE id = 1;
UPDATE race SET image_id = 25 WHERE id = 2;
UPDATE race SET image_id = 6 WHERE id = 3;
UPDATE race SET image_id = 10 WHERE id = 4;
UPDATE race SET image_id = 12 WHERE id = 5;
UPDATE race SET image_id = 16 WHERE id = 6;
UPDATE race SET image_id = 32 WHERE id = 7;
UPDATE race SET image_id = 14 WHERE id = 8;
UPDATE race SET image_id = 39 WHERE id = 9;

INSERT INTO image VALUES (4, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (5, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (6, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (7, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (8, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (9, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (10, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (11, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (12, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (13, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (14, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (15, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (16, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (17, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (18, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (19, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (20, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (21, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (22, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (23, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (24, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (25, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (26, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (27, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (28, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (29, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (30, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (31, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (32, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (33, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (34, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (35, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (36, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (37, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (38, X'0102030405060708090a0b0c0d0e0f');
INSERT INTO image VALUES (39, X'0102030405060708090a0b0c0d0e0f');

