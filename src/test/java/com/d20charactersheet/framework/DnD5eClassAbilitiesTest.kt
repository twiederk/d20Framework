package com.d20charactersheet.framework

import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DnD5eClassAbilitiesTest {

    private val gameSystem: GameSystem = DnD5eUniverse().gameSystem

    @Test
    fun getAllClasses_barbarian_classAbilities() {

        // Act
        val barbarian = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[0]

        // Assert
        assertThat(barbarian.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Rage",
            "Unarmored Defense",
            "Reckless Attack",
            "Danger Sense",
            "Ability Score Improvement",
            "Extra Attack",
            "Fast Movement",
            "Feral Instinct",
            "Brutal Critical",
            "Relentless Rage",
            "Persistent Rage",
            "Indomitable Might",
            "Primal Champion",
            "Frenzy",
            "Mindless Rage",
            "Intimidating Presence",
            "Retaliation"
        )
    }

    @Test
    fun getAllClasses_bard_classAbilities() {

        // Act
        val bard = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[1]

        // Assert
        assertThat(bard.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Spellcasting - Bard",
            "Bardic Inspiration",
            "Jack of All Trades",
            "Song of Rest",
            "Bard College",
            "Expertise",
            "Ability Score Improvement",
            "Font of Inspiration",
            "Countercharm",
            "Magical Secrets",
            "Superior Inspiration",
            "College of Lore",
            "College of Lore - Bonus Proficiencies",
            "College of Lore - Cutting Words",
            "College of Lore - Additional Magical Secrets",
            "College of Lore - Peerless Skill"
        )
    }

    @Test
    fun getAllClasses_cleric_classAbilities() {

        // Act
        val cleric = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[2]

        // Assert
        assertThat(cleric.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Spellcasting - Cleric",
            "Divine Domain",
            "Channel Divinity",
            "Turn Undead",
            "Destroy Undead",
            "Divine Intervention",
            "Life Domain",
            "Life Domain - Bonus Proficiency",
            "Life Domain - Disciple of Life",
            "Life Domain - Preserve Life",
            "Life Domain - Blessed Healer",
            "Life Domain - Divine Strike",
            "Life Domain - Supreme Healing"
        )
    }

    @Test
    fun getAllClasses_druid_classAbilities() {

        // Act
        val druid = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[3]

        // Assert
        assertThat(druid.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Druidic",
            "Spellcasting - Druid",
            "Wild Shape",
            "Druid Circle",
            "Timeless Body",
            "Beast Spells",
            "Archdruid",
            "Circle of Land",
            "Circle of Land - Bonus Cantrip",
            "Circle of Land - Natural Recovery",
            "Circle of Land - Land's Stride",
            "Circle of Land - Nature's Ward",
            "Circle of Land - Nature's Sanctuary",
            "Circle of Land - Spells Arctic",
            "Circle of Land - Spells Coast",
            "Circle of Land - Spells Desert",
            "Circle of Land - Spells Forest",
            "Circle of Land - Spells Grassland",
            "Circle of Land - Spells Mountain",
            "Circle of Land - Spells Swamp"
        )
    }

    @Test
    fun getAllClasses_fighter_classAbilities() {

        // Act
        val fighter = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[4]

        // Assert
        assertThat(fighter.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Fighting Style - Archery",
            "Fighting Style - Defense",
            "Fighting Style - Dueling",
            "Fighting Style - Great Weapon Fighting",
            "Fighting Style - Protection",
            "Fighting Style - Two-Weapon Fighting",
            "Second Wind",
            "Action Surge",
            "Martial Archetype",
            "Extra Attack",
            "Indomitable",
            "Champion",
            "Champion - Improved Critical",
            "Champion - Remarkable Athlete",
            "Champion - Additional Fighting Style",
            "Champion - Superior Critical",
            "Champion - Survivor"
        )
    }

    @Test
    fun getAllClasses_monk_classAbilities() {

        // Act
        val monk = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[5]

        // Assert
        assertThat(monk.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Unarmored Defense",
            "Martial Arts",
            "Ki",
            "Unarmored Movement",
            "Monastic Tradition",
            "Ki - Flurry of Blows",
            "Ki - Patient Defense",
            "Ki - Step of the Wind",
            "Ki - Deflect Missiles",
            "Slow Fall",
            "Extra Attack",
            "Stunning Strike",
            "Ki-Empowered Strikes",
            "Evasion",
            "Stillness of Mind",
            "Purity of Body",
            "Tongue of the Sun and Moon",
            "Diamond Soul",
            "Timeless Body",
            "Empty Body",
            "Perfect Self",
            "Way of the Open Hand",
            "Way of the Open Hand - Open Hand Technique",
            "Way of the Open Hand - Wholeness of Body",
            "Way of the Open Hand - Tranquility",
            "Way of the Open Hand - Quivering Palm"
        )
    }

    @Test
    fun getAllClasses_paladin_classAbilities() {

        // Act
        val paladin = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[6]

        // Assert
        assertThat(paladin.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Fighting Style - Defense",
            "Fighting Style - Dueling",
            "Fighting Style - Great Weapon Fighting",
            "Fighting Style - Protection",
            "Extra Attack",
            "Divine Sense",
            "Lay on Hands",
            "Spellcasting - Paladin",
            "Divine Smite",
            "Divine Health",
            "Sacred Oath",
            "Aura of Protection",
            "Aura of Courage",
            "Improved Divine Smite",
            "Cleansing Touch",
            "Oath of Devotion",
            "Oath of Devotion - Sacred Weapon",
            "Oath of Devotion - Turn the Unholy",
            "Oath of Devotion - Aura of Devotion",
            "Oath of Devotion - Purity of Spirit",
            "Oath of Devotion - Holy Nimbus"
        )
    }

    @Test
    fun getAllClasses_ranger_classAbilities() {

        // Act
        val ranger = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[7]

        // Assert
        assertThat(ranger.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Fighting Style - Archery",
            "Fighting Style - Defense",
            "Fighting Style - Dueling",
            "Fighting Style - Two-Weapon Fighting",
            "Extra Attack",
            "Favored Enemy",
            "Natural Explorer",
            "Spellcasting - Ranger",
            "Ranger Archetype",
            "Primeval Awareness",
            "Land's Stride",
            "Hide in Plain Sight",
            "Vanish",
            "Feral Senses",
            "Foe Slayer",
            "Hunter",
            "Hunter - Colossus Slayer",
            "Hunter - Giant Killer",
            "Hunter - Horde Breaker",
            "Hunter - Escape the Horde",
            "Hunter - Multiattack Defense",
            "Hunter - Steel Will",
            "Hunter - Volley",
            "Hunter - Whirlwind Attack",
            "Hunter - Evasion",
            "Hunter - Stand Against the Tide",
            "Hunter - Uncanny Dodge"
        )
    }

    @Test
    fun getAllClasses_rogue_classAbilities() {

        // Act
        val rogue = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[8]

        // Assert
        assertThat(rogue.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Expertise",
            "Sneak Attack",
            "Thieves' Cant",
            "Cunning Action",
            "Roguish Archetype",
            "Uncanny Dodge",
            "Evasion",
            "Reliable Talent",
            "Blindsense",
            "Slippery Mind",
            "Elusive",
            "Stroke of Luck",
            "Thief",
            "Thief - Fast Hands",
            "Thief - Second-Story Work",
            "Thief - Supreme Sneak",
            "Thief - Use Magic Device",
            "Thief - Thief's Reflexes"
        )
    }

    @Test
    fun getAllClasses_sorcerer_classAbilities() {

        // Act
        val sorcerer = gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[9]

        // Assert
        assertThat(sorcerer.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Spellcasting - Sorcerer",
            "Sorcerous Origin",
            "Font of Magic",
            "Metamagic",
            "Metamagic - Careful Spell",
            "Metamagic - Distant Spell",
            "Metamagic - Empowered Spell",
            "Metamagic - Extended Spell",
            "Metamagic - Heightened Spell",
            "Metamagic - Quickened Spell",
            "Metamagic - Subtle Spell",
            "Metamagic - Twinned Spell",
            "Sorcerous Restoration",
            "Draconic Bloodline",
            "Draconic - Dragon Ancestor",
            "Draconic - Draconic Resilience",
            "Draconic - Elemental Affinity",
            "Draconic - Dragon Wings",
            "Draconic - Draconic Presence"
        )
    }

    @Test
    fun getAllClasses_warlock_classAbilities() {

        // Act
        val warlock =
            gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[10]

        // Assert
        assertThat(warlock.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Otherworldly Patron",
            "Pact Magic",
            "Eldritch Invocations",
            "Pact of the Chain",
            "Pact of the Blade",
            "Pact of the Tome",
            "Mystic Arcanum",
            "Eldritch Master",
            "Eldritch Invocation - Agonizing Blast",
            "Eldritch Invocation - Armor of Shadows",
            "Eldritch Invocation - Ascendant Step",
            "Eldritch Invocation - Beast Speech",
            "Eldritch Invocation - Beguiling Influence",
            "Eldritch Invocation - Bewitching Whispers",
            "Eldritch Invocation - Book of Ancient Secrets",
            "Eldritch Invocation - Chains of Carceri",
            "Eldritch Invocation - Devil's Sight",
            "Eldritch Invocation - Dreadful Word",
            "Eldritch Invocation - Eldritch Sight",
            "Eldritch Invocation - Eldritch Spear",
            "Eldritch Invocation - Eyes of the Rune Keeper",
            "Eldritch Invocation - Fiendish Vigor",
            "Eldritch Invocation - Gaze of Two Minds",
            "Eldritch Invocation - Lifedrinker",
            "Eldritch Invocation - Mask of Many Faces",
            "Eldritch Invocation - Master of Myriad Forms",
            "Eldritch Invocation - Minions of Chaos",
            "Eldritch Invocation - Mire the Mind",
            "Eldritch Invocation - Misty Visions",
            "Eldritch Invocation - One with Shadows",
            "Eldritch Invocation - Otherworldly Leap",
            "Eldritch Invocation - Repelling Blast",
            "Eldritch Invocation - Sculptor of Flesh",
            "Eldritch Invocation - Sign of Ill Omen",
            "Eldritch Invocation - Thief of Five Fates",
            "Eldritch Invocation - Thirsting Blade",
            "Eldritch Invocation - Visions of Distant Realms",
            "Eldritch Invocation - Voice of the Chain Master",
            "Eldritch Invocation - Whispers of the Grave",
            "Eldritch Invocation - Witch Sight",
            "The Fiend",
            "The Fiend - Expanded Spell List",
            "The Fiend - Dark One's Blessing",
            "The Fiend - Dark One's Own Luck",
            "The Fiend - Fiendish Resilience",
            "The Fiend - Hurl Through Hell"
        )
    }


    @Test
    fun getAllClasses_wizard_classAbilities() {

        // Act
        val wizard =
            gameSystem.characterClassService.getAllCharacterClasses(gameSystem.allSkills, gameSystem.allAbilities)[11]

        // Assert
        assertThat(wizard.classAbilities).extracting("ability.name").containsExactlyInAnyOrder(
            "Ability Score Improvement",
            "Spellcasting - Wizard",
            "Arcane Recovery",
            "Arcane Tradition",
            "Spell Mastery",
            "Signature Spells",
            "School of Evocation",
            "Evocation - Evocation Savant",
            "Evocation - Sculpt Spells",
            "Evocation - Potent Cantrip",
            "Evocation - Empowered Evocation",
            "Evocation - Overchannel"
        )
    }

}