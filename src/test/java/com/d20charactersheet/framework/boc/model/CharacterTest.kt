package com.d20charactersheet.framework.boc.model

import com.d20charactersheet.framework.DnDv35Universe
import com.d20charactersheet.framework.Universe
import com.d20charactersheet.framework.boc.service.CharacterClassService
import com.d20charactersheet.framework.boc.service.GameSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class CharacterTest {

    private lateinit var character: Character
    private lateinit var gameSystem: GameSystem
    private lateinit var characterClassService: CharacterClassService

    @BeforeEach
    fun setUp() {
        val universe: Universe = DnDv35Universe()
        gameSystem = universe.gameSystem
        characterClassService = gameSystem.characterClassService
        character = Character()
    }

    @Test
    fun testGetCharacterLevel() {
        val classLevels: MutableList<ClassLevel> = LinkedList()
        val wizard = characterClassService.findClassByName("Wizard", gameSystem.allCharacterClasses)
        val bard = characterClassService.findClassByName("Bard", gameSystem.allCharacterClasses)
        classLevels.add(ClassLevel(wizard, 4))
        character.classLevels = classLevels
        Assert.assertEquals(4, character.characterLevel.toLong())
        classLevels.add(ClassLevel(bard, 3))
        Assert.assertEquals(7, character.characterLevel.toLong())
    }

    @Test
    fun testCheckAttributeNegativeValue() {
        try {
            character.strength = -1
            Assert.fail("Missing exception. Expected RuleException")
        } catch (ruleException: RuleException) {
            // expected exception => OK
        } catch (exception: Exception) {
            Assert.fail("Wrong exception. Expected RuleException")
        }
    }

    @Test
    fun testCheckAttributeZeroValue() {
        try {
            character.strength = 0
            Assert.fail("Missing exception. Expected RuleException")
        } catch (ruleException: RuleException) {
            // expected exception => OK
        } catch (exception: Exception) {
            Assert.fail("Wrong exception. Expected RuleException")
        }
    }

    @Test
    fun testCheckAttributeAllowedValue() {
        character.strength = 1
        character.strength = 5
        character.strength = 10
        character.strength = 15
        character.strength = 20
        character.strength = 50
        character.strength = 99
    }

    @Test
    fun testCheckAttributeToHighValue() {
        try {
            character.strength = 100
            Assert.fail("Missing exception. Expected RuleException")
        } catch (ruleException: RuleException) {
            // expected exception => OK
        } catch (exception: Exception) {
            Assert.fail("Wrong exception. Expected RuleException")
        }
    }

    @Test
    fun testSetExperiencePointsNegative() {
        try {
            character.experiencePoints = -1
            Assert.fail("Missing exception. Expected RuleException")
        } catch (ruleException: RuleException) {
            // expected exception => OK
        } catch (exception: Exception) {
            Assert.fail("Wrong exception. Expected RuleException")
        }
    }

    @Test
    fun testSetClassLevels() {
        val barbarian = characterClassService.findClassByName("Barbarian", gameSystem.allCharacterClasses)
        val classLevel = ClassLevel(barbarian)
        classLevel.level = 0
        val classLevels: MutableList<ClassLevel> = LinkedList()
        classLevels.add(classLevel)
        try {
            character.classLevels = classLevels
            Assert.fail("Missing exception. Expected RuleException")
        } catch (ruleException: RuleException) {
            // expected exception => OK
        } catch (exception: Exception) {
            Assert.fail("Wrong exception. Expected RuleException")
        }
    }

    @Test
    fun testGetCharacterClasses() {
        val classLevels: MutableList<ClassLevel> = LinkedList()
        val wizard = characterClassService.findClassByName("Wizard", gameSystem.allCharacterClasses)
        val barbarian = characterClassService.findClassByName("Barbarian", gameSystem.allCharacterClasses)
        classLevels.add(ClassLevel(wizard, 4))
        classLevels.add(ClassLevel(barbarian, 1))
        character.classLevels = classLevels
        val characterClasses = character.characterClasses
        Assert.assertNotNull(characterClasses)
        Assert.assertEquals(2, characterClasses.size.toLong())
    }

    @Test
    fun testGetAllAbilitiesOfBelvador() {
        val belvador = gameSystem.allCharacters[0]
        val numberOfAllAbilities = belvador.allAbilities
            .size
        Assert.assertEquals(21, numberOfAllAbilities.toLong())
    }

    @Test
    fun testGetRaceAbilitiesOfBelvador() {
        val belvador = gameSystem.allCharacters[0]
        val numberOfRaceAbilities = belvador.raceAbilities
            .size
        Assert.assertEquals(5, numberOfRaceAbilities.toLong())
    }

    @Test
    fun testGetClassAbilitiesOfBelvador() {
        val belvador = gameSystem.allCharacters[0]
        val numberOfClassAbilities = belvador.classAbilities
            .size
        Assert.assertEquals(8, numberOfClassAbilities.toLong())
    }

    @Test
    fun testGetSpelllistAbilities() {
        val belvador = gameSystem.getCharacter(0)
        val spelllistAbilities = belvador.spelllistAbilities
        Assert.assertNotNull(spelllistAbilities)
        Assert.assertEquals(2, spelllistAbilities.size.toLong())
    }

    @Test
    fun testGetKnownSpellsOfBelvador() {
        val belvador = gameSystem.getCharacter(0)
        val spelllistAbilities = belvador.spelllistAbilities
        Assert.assertNotNull(spelllistAbilities)
        Assert.assertEquals(2, spelllistAbilities.size.toLong())
        val knownSpells = belvador.getKnownSpells(
            spelllistAbilities[0]
                .spelllist
        )
        Assert.assertNotNull(knownSpells)
        Assert.assertEquals(31, knownSpells.size.toLong())

        // 0 level
        Assert.assertTrue(containsSpell("Arcane Mark", knownSpells))
        Assert.assertTrue(containsSpell("Detect Magic", knownSpells))
        Assert.assertTrue(containsSpell("Read Magic", knownSpells))
        Assert.assertTrue(containsSpell("Prestidigitation", knownSpells))
        Assert.assertTrue(containsSpell("Resistance", knownSpells))
        Assert.assertTrue(containsSpell("Ray of Frost", knownSpells))
        Assert.assertTrue(containsSpell("Detect Poison", knownSpells))
        Assert.assertTrue(containsSpell("Flare", knownSpells))
        Assert.assertTrue(containsSpell("Light", knownSpells))
        Assert.assertTrue(containsSpell("Dancing Lights", knownSpells))
        Assert.assertTrue(containsSpell("Mending", knownSpells))
        Assert.assertTrue(containsSpell("Mage Hand", knownSpells))
        Assert.assertTrue(containsSpell("Open/Close", knownSpells))
        Assert.assertTrue(containsSpell("Daze", knownSpells))

        // 1st level
        Assert.assertTrue(containsSpell("Shield", knownSpells))
        Assert.assertTrue(containsSpell("Protection from Evil", knownSpells))
        Assert.assertTrue(containsSpell("Mage Armor", knownSpells))
        Assert.assertTrue(containsSpell("Summon Monster I", knownSpells))
        Assert.assertTrue(containsSpell("Mount", knownSpells))
        Assert.assertTrue(containsSpell("Unseen Servant", knownSpells))
        Assert.assertTrue(containsSpell("Magic Missile", knownSpells))
        Assert.assertTrue(containsSpell("Charm Person", knownSpells))
        Assert.assertTrue(containsSpell("Sleep", knownSpells))

        // 2nd level
        Assert.assertTrue(containsSpell("Acid Arrow", knownSpells))
        Assert.assertTrue(containsSpell("Summon Monster II", knownSpells))
        Assert.assertTrue(containsSpell("Knock", knownSpells))
        Assert.assertTrue(containsSpell("Spider Climb", knownSpells))
        Assert.assertTrue(containsSpell("Levitate", knownSpells))
        Assert.assertTrue(containsSpell("Flaming Sphere", knownSpells))

        // 3rd level
        Assert.assertTrue(containsSpell("Summon Monster III", knownSpells))
        Assert.assertTrue(containsSpell("Lightning Bolt", knownSpells))
    }

    @Test
    fun testBodyPartsBelvador() {
        // Arrange
        val belvador = gameSystem.getCharacter(0)

        // Act
        val body = belvador.body

        // Assert
        assertThat(body.bodyParts).hasSize(15)
        assertThat(body.getItemOfBodyPart(BodyPart.BOTH_HANDS).name).isEqualTo("Quarterstaff")
    }

    @Test
    fun testBodyPartsNascan() {
        // Arrange
        val nascan = gameSystem.getCharacter(1)
        val studdedLeather = gameSystem.allArmor[2]
        val battleaxe = gameSystem.allWeapons[25]
        val shortSword = gameSystem.allWeapons[24]

        // Act
        val body = nascan.body

        // Assert
        assertThat(body.bodyParts).hasSize(15)
        BodyAssert.assertThat(body).equippedItem(BodyPart.BODY, studdedLeather).equippedItem(BodyPart.OFF_HAND, shortSword)
            .equippedItem(BodyPart.PRIMARY_HAND, battleaxe)
    }

    @Test
    fun testBodyPartsTocDerJuengere() {
        // Arrange
        val tocDerJuengere = gameSystem.getCharacter(13)
        val studdedLeather = gameSystem.allArmor[2]
        val rapier = gameSystem.allWeapons[29]

        // Act
        val body = tocDerJuengere.body

        // Assert
        assertThat(body.bodyParts).hasSize(15)
        BodyAssert.assertThat(body).equippedItem(BodyPart.BODY, studdedLeather).equippedItem(BodyPart.PRIMARY_HAND, rapier)
    }

    @Test
    fun testWholeEquipmentOfBelvador() {
        // Arrange
        val belvador = gameSystem.getCharacter(0)
        val equipment = belvador.equipment
        val bodyParts: MutableMap<BodyPart, MutableList<Item>> =
            EnumMap(com.d20charactersheet.framework.boc.model.BodyPart::class.java)
        for (bodyPart in BodyPart.values()) {
            bodyParts[bodyPart] = LinkedList()
        }
        val bodyService = gameSystem.bodyService
        for (itemGroup in equipment.items) {
            // Act
            val item = itemGroup.item
            val itemBodyParts = bodyService.calculateBodyParts(item)
            for (bodyPart in itemBodyParts) {
                bodyParts[bodyPart]!!.add(item)
            }
        }

        // Assert
        assertThat(bodyParts[BodyPart.HEAD]).hasSize(0)
        assertThat(bodyParts[BodyPart.EYES]).hasSize(0)
        assertThat(bodyParts[BodyPart.NECK]).hasSize(0)
        assertThat(bodyParts[BodyPart.TORSO]).hasSize(0)
        assertThat(bodyParts[BodyPart.BODY]).hasSize(0)
        assertThat(bodyParts[BodyPart.WAIST]).hasSize(0)
        assertThat(bodyParts[BodyPart.SHOULDERS]).hasSize(0)
        assertThat(bodyParts[BodyPart.ARMS]).hasSize(0)
        assertThat(bodyParts[BodyPart.HANDS]).hasSize(0)
        assertThat(bodyParts[BodyPart.FINGERS_LEFT]).hasSize(0)
        assertThat(bodyParts[BodyPart.FINGERS_RIGHT]).hasSize(0)
        assertThat(bodyParts[BodyPart.FEET]).hasSize(0)
        assertThat(bodyParts[BodyPart.OFF_HAND]).extracting("name").containsOnly("Crossbow, light")
        assertThat(bodyParts[BodyPart.PRIMARY_HAND]).extracting("name").containsOnly("Crossbow, light")
        assertThat(bodyParts[BodyPart.HEAD]).hasSize(0)
        assertThat(bodyParts[BodyPart.BOTH_HANDS]).extracting("name").containsOnly("Quarterstaff", "Crossbow, light")
        assertThat(bodyParts[BodyPart.NONE]).hasSize(20)
    }

    @Test
    fun testWholeEquipmentOfNascan() {
        // Arrange
        val nascan = gameSystem.getCharacter(1)
        val equipment = nascan.equipment
        val bodyParts: MutableMap<BodyPart, MutableList<Item>> =
            EnumMap(com.d20charactersheet.framework.boc.model.BodyPart::class.java)
        for (bodyPart in BodyPart.values()) {
            bodyParts[bodyPart] = LinkedList()
        }
        val bodyService = gameSystem.bodyService
        for (itemGroup in equipment.items) {
            // Act
            val item = itemGroup.item
            val itemBodyParts = bodyService.calculateBodyParts(item)
            for (bodyPart in itemBodyParts) {
                bodyParts[bodyPart]!!.add(item)
            }
        }

        // Assert
        assertThat(bodyParts[BodyPart.HEAD]).hasSize(0)
        assertThat(bodyParts[BodyPart.EYES]).hasSize(0)
        assertThat(bodyParts[BodyPart.NECK]).hasSize(0)
        assertThat(bodyParts[BodyPart.TORSO]).hasSize(0)
        assertThat(bodyParts[BodyPart.BODY]).extracting("name").containsOnly("Studded Leather")
        assertThat(bodyParts[BodyPart.WAIST]).hasSize(0)
        assertThat(bodyParts[BodyPart.SHOULDERS]).hasSize(0)
        assertThat(bodyParts[BodyPart.ARMS]).hasSize(0)
        assertThat(bodyParts[BodyPart.HANDS]).hasSize(0)
        assertThat(bodyParts[BodyPart.FINGERS_LEFT]).hasSize(0)
        assertThat(bodyParts[BodyPart.FINGERS_RIGHT]).hasSize(0)
        assertThat(bodyParts[BodyPart.FEET]).hasSize(0)
        assertThat(bodyParts[BodyPart.OFF_HAND]).extracting("name").containsOnly("Sword, short", "Battleaxe")
        assertThat(bodyParts[BodyPart.PRIMARY_HAND]).extracting("name").containsOnly("Sword, short", "Battleaxe")
        assertThat(bodyParts[BodyPart.HEAD]).hasSize(0)
        assertThat(bodyParts[BodyPart.BOTH_HANDS]).extracting("name").containsOnly("Sword, short", "Battleaxe")
        assertThat(bodyParts[BodyPart.NONE]).hasSize(6)
    }

    @Test
    fun testWholeEquipmentOfTocDerJuengere() {
        // Arrange
        val tocDerJuengere = gameSystem.getCharacter(13)
        val equipment = tocDerJuengere.equipment
        val bodyParts: MutableMap<BodyPart, MutableList<Item>> =
            EnumMap(com.d20charactersheet.framework.boc.model.BodyPart::class.java)
        for (bodyPart in BodyPart.values()) {
            bodyParts[bodyPart] = LinkedList()
        }
        val bodyService = gameSystem.bodyService
        for (itemGroup in equipment.items) {
            // Act
            val item = itemGroup.item
            val itemBodyParts = bodyService.calculateBodyParts(item)
            for (bodyPart in itemBodyParts) {
                bodyParts[bodyPart]!!.add(item)
            }
        }

        // Assert
        assertThat(bodyParts[BodyPart.HEAD]).hasSize(0)
        assertThat(bodyParts[BodyPart.EYES]).hasSize(0)
        assertThat(bodyParts[BodyPart.NECK]).hasSize(0)
        assertThat(bodyParts[BodyPart.TORSO]).hasSize(0)
        assertThat(bodyParts[BodyPart.BODY]).extracting("name").containsOnly("Studded Leather")
        assertThat(bodyParts[BodyPart.WAIST]).hasSize(0)
        assertThat(bodyParts[BodyPart.SHOULDERS]).hasSize(0)
        assertThat(bodyParts[BodyPart.ARMS]).hasSize(0)
        assertThat(bodyParts[BodyPart.HANDS]).hasSize(0)
        assertThat(bodyParts[BodyPart.FINGERS_LEFT]).hasSize(0)
        assertThat(bodyParts[BodyPart.FINGERS_RIGHT]).hasSize(0)
        assertThat(bodyParts[BodyPart.FEET]).hasSize(0)
        assertThat(bodyParts[BodyPart.OFF_HAND]).extracting("name").containsOnly("Rapier", "Crossbow, light")
        assertThat(bodyParts[BodyPart.PRIMARY_HAND]).extracting("name").containsOnly("Rapier", "Crossbow, light")
        assertThat(bodyParts[BodyPart.HEAD]).hasSize(0)
        assertThat(bodyParts[BodyPart.BOTH_HANDS]).extracting("name").containsOnly("Rapier", "Crossbow, light")
        assertThat(bodyParts[BodyPart.NONE]).hasSize(14)
    }

    @Test
    fun testEquippedItemsOfBelvador() {
        // Arrange
        val belvador = gameSystem.getCharacter(0)

        // Act
        val equippedItems = belvador.equippedItems

        // Assert
        assertThat(equippedItems).extracting("Name").containsOnly("Quarterstaff")
    }

    @Test
    fun testEquippedItemsOfNascan() {
        // Arrange
        val nascan = gameSystem.getCharacter(1)

        // Act
        val equippedItems = nascan.equippedItems

        // Assert
        assertThat(equippedItems).extracting("Name")
            .containsExactlyInAnyOrder("Studded Leather", "Sword, short", "Battleaxe")
    }

    @Test
    fun testEquippedItemsOfTocDerJuengere() {
        // Arrange
        val tocDerJuengere = gameSystem.getCharacter(13)

        // Act
        val equippedItems = tocDerJuengere.equippedItems

        // Assert
        assertThat(equippedItems).extracting("Name").containsExactlyInAnyOrder("Studded Leather", "Rapier")
    }

    private fun containsSpell(name: String, knownSpells: List<KnownSpell>): Boolean {
        for (knowSpell in knownSpells) {
            if (knowSpell.spell.name == name) {
                return true
            }
        }
        return false
    }
}